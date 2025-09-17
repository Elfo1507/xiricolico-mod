#!/bin/bash
# GitFlow Helper Script for Xiricolico Mod
# Usage: ./scripts/gitflow.sh [command] [name]

set -e

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Helper functions
print_usage() {
    echo "🌳 Xiricolico Mod GitFlow Helper"
    echo ""
    echo "Usage: $0 [command] [name]"
    echo ""
    echo "Commands:"
    echo "  feature <name>    - Create and switch to new feature branch"
    echo "  hotfix <name>     - Create and switch to new hotfix branch"
    echo "  finish-feature    - Merge current feature to develop"
    echo "  finish-hotfix     - Merge current hotfix to main and develop"
    echo "  sync              - Sync develop with upstream"
    echo "  release <version> - Create release tag and push to main"
    echo "  status            - Show current branch and status"
    echo ""
}

print_info() {
    echo -e "${BLUE}ℹ️  $1${NC}"
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

# Check if we're in a git repository
check_git_repo() {
    if ! git rev-parse --git-dir > /dev/null 2>&1; then
        print_error "Not in a git repository!"
        exit 1
    fi
}

# Get current branch
get_current_branch() {
    git branch --show-current
}

# Create feature branch
create_feature() {
    local feature_name="$1"
    if [[ -z "$feature_name" ]]; then
        print_error "Feature name is required!"
        print_usage
        exit 1
    fi
    
    local branch_name="feature/$feature_name"
    
    print_info "Creating feature branch: $branch_name"
    
    # Switch to develop and pull latest
    git checkout develop
    git pull upstream develop 2>/dev/null || git pull origin develop
    
    # Create and switch to feature branch
    git checkout -b "$branch_name"
    
    print_success "Feature branch '$branch_name' created and checked out"
    print_info "You can now start working on your feature!"
}

# Create hotfix branch
create_hotfix() {
    local hotfix_name="$1"
    if [[ -z "$hotfix_name" ]]; then
        print_error "Hotfix name is required!"
        print_usage
        exit 1
    fi
    
    local branch_name="hotfix/$hotfix_name"
    
    print_info "Creating hotfix branch: $branch_name"
    
    # Switch to main and pull latest
    git checkout main
    git pull upstream main 2>/dev/null || git pull origin main
    
    # Create and switch to hotfix branch
    git checkout -b "$branch_name"
    
    print_success "Hotfix branch '$branch_name' created and checked out"
    print_warning "Remember: hotfixes should only contain critical bug fixes!"
}

# Finish feature (merge to develop)
finish_feature() {
    local current_branch=$(get_current_branch)
    
    if [[ ! "$current_branch" =~ ^feature/.+ ]]; then
        print_error "You must be on a feature branch to finish it!"
        exit 1
    fi
    
    print_info "Finishing feature: $current_branch"
    
    # Push current branch
    git push origin "$current_branch"
    
    print_success "Feature branch pushed to origin"
    print_info "Please create a Pull Request to develop branch on GitHub"
    print_info "URL: https://github.com/Elfo1507/xiricolico-mod/compare/develop...$current_branch"
}

# Sync with upstream
sync_develop() {
    print_info "Syncing develop branch with upstream"
    
    git checkout develop
    git pull upstream develop 2>/dev/null || git pull origin develop
    git push origin develop
    
    print_success "Develop branch synced"
}

# Show status
show_status() {
    local current_branch=$(get_current_branch)
    local repo_status=$(git status --porcelain)
    
    echo "🌳 Xiricolico Mod - Git Status"
    echo ""
    echo "Current branch: $current_branch"
    
    if [[ -n "$repo_status" ]]; then
        echo "Working directory: Changes detected"
        git status --short
    else
        echo "Working directory: Clean"
    fi
    
    echo ""
    echo "Recent commits:"
    git log --oneline -5
}

# Main script logic
case "$1" in
    "feature")
        check_git_repo
        create_feature "$2"
        ;;
    "hotfix")
        check_git_repo
        create_hotfix "$2"
        ;;
    "finish-feature")
        check_git_repo
        finish_feature
        ;;
    "sync")
        check_git_repo
        sync_develop
        ;;
    "status")
        check_git_repo
        show_status
        ;;
    *)
        print_usage
        exit 1
        ;;
esac
