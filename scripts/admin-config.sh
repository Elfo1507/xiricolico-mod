#!/bin/bash
# Admin Configuration Script for Xiricolico Mod
# For use during SETUP PHASE ONLY

set -e

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Helper functions
print_info() {
    echo -e "${BLUE}🔧 SETUP: $1${NC}"
}

print_success() {
    echo -e "${GREEN}✅ $1${NC}"
}

print_warning() {
    echo -e "${YELLOW}⚠️  $1${NC}"
}

print_error() {
    echo -e "${RED}❌ $1${NC}"
}

print_usage() {
    echo "🔧 Admin Configuration Script"
    echo ""
    echo "Usage: $0 [command] [description]"
    echo ""
    echo "Commands:"
    echo "  commit <description>  - Direct commit to main with setup marker"
    echo "  merge                 - Force merge develop to main"
    echo "  status               - Show current setup status"
    echo "  complete             - Mark setup phase as complete"
    echo ""
    echo "⚠️  This script should only be used during initial project setup!"
}

# Check if we're in a git repository
check_git_repo() {
    if ! git rev-parse --git-dir > /dev/null 2>&1; then
        print_error "Not in a git repository!"
        exit 1
    fi
}

# Direct commit to main with setup marker
setup_commit() {
    local description="$1"
    if [[ -z "$description" ]]; then
        print_error "Commit description is required!"
        print_usage
        exit 1
    fi
    
    print_warning "SETUP PHASE: Making direct commit to main"
    print_info "Description: $description"
    
    # Ensure we're on main
    git checkout main
    
    # Check for changes
    if ! git diff --staged --quiet; then
        print_info "Staged changes detected, committing..."
        
        git commit -m "🔧 Setup: $description

[SETUP-PHASE] Direct commit to main for initial configuration"
        
        print_success "Setup commit created"
        
        # Ask if user wants to push
        read -p "Push to origin? (y/N): " -n 1 -r
        echo
        if [[ $REPLY =~ ^[Yy]$ ]]; then
            git push origin main
            print_success "Changes pushed to origin/main"
        fi
    else
        print_warning "No staged changes to commit"
    fi
}

# Force merge develop to main
setup_merge() {
    print_warning "SETUP PHASE: Force merging develop to main"
    
    # Switch to main and pull latest
    git checkout main
    git pull origin main 2>/dev/null || true
    
    # Pull latest develop
    git pull origin develop 2>/dev/null || true
    
    # Force merge develop
    git merge develop --no-ff -m "🔧 Setup: Merge configuration changes

[SETUP-PHASE] Force merge for initial project setup"
    
    print_success "Develop merged to main"
    
    # Ask if user wants to push
    read -p "Push to origin? (y/N): " -n 1 -r
    echo
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        git push origin main
        print_success "Changes pushed to origin/main"
    fi
}

# Show setup status
setup_status() {
    local current_branch=$(git branch --show-current)
    
    echo "🔧 Xiricolico Mod - Setup Status"
    echo ""
    echo "Current branch: $current_branch"
    echo "Setup phase: ACTIVE"
    echo ""
    
    # Check for staged changes
    if ! git diff --staged --quiet; then
        echo "Staged changes:"
        git diff --staged --name-only
    else
        echo "No staged changes"
    fi
    
    echo ""
    echo "Recent commits:"
    git log --oneline -3
    
    echo ""
    print_info "Use './scripts/admin-config.sh commit \"description\"' to commit setup changes"
}

# Complete setup phase
setup_complete() {
    print_warning "Marking setup phase as complete"
    
    # Create setup completion tag
    local tag_name="v0.1.0-setup"
    
    print_info "Creating setup completion tag: $tag_name"
    git tag -a "$tag_name" -m "🎯 Setup Phase Complete

Initial project configuration and documentation completed.
GitFlow workflow now active for all future development."
    
    print_success "Setup completion tag created"
    
    # Ask if user wants to push tag
    read -p "Push tag to origin? (y/N): " -n 1 -r
    echo
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        git push origin "$tag_name"
        print_success "Setup tag pushed to origin"
    fi
    
    print_info "Setup phase marked as complete!"
    print_warning "All future commits must follow GitFlow workflow"
}

# Main script logic
case "$1" in
    "commit")
        check_git_repo
        setup_commit "$2"
        ;;
    "merge")
        check_git_repo
        setup_merge
        ;;
    "status")
        check_git_repo
        setup_status
        ;;
    "complete")
        check_git_repo
        setup_complete
        ;;
    *)
        print_usage
        exit 1
        ;;
esac
