#!/bin/bash
# Extended GitFlow Helper Script for Xiricolico Mod
# Usage: ./scripts/gitflow.sh [command] [name]

set -e

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
PURPLE='\033[0;35m'
NC='\033[0m' # No Color

# Helper functions
print_usage() {
    echo -e "${BLUE}🌳 Xiricolico Mod Extended GitFlow Helper${NC}"
    echo ""
    echo "Usage: $0 [command] [name]"
    echo ""
    echo -e "${GREEN}Story Workflow:${NC}"
    echo "  story <name>          - Create new story branch"
    echo "  finish-story          - Push story and show merge options"
    echo ""
    echo -e "${GREEN}Feature Workflow:${NC}"
    echo "  feature <name>        - Create new feature branch"
    echo "  integrate-story       - Merge story into current feature"
    echo "  finish-feature        - Show feature completion options"
    echo ""
    echo -e "${GREEN}Release Workflow:${NC}"
    echo "  release <version>     - Create release branch (x.x.x format)"
    echo "  finish-release        - Merge release to main and tag"
    echo ""
    echo -e "${GREEN}Hotfix Workflow:${NC}"
    echo "  hotfix <name>         - Create hotfix branch from main"
    echo "  finish-hotfix         - Show hotfix deployment options"
    echo ""
    echo -e "${GREEN}General Commands:${NC}"
    echo "  sync                  - Sync develop with upstream"
    echo "  status                - Show current branch and GitFlow status"
    echo "  validate              - Validate current branch follows GitFlow"
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

print_step() {
    echo -e "${PURPLE}🎯 $1${NC}"
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

# Validate version format
validate_version() {
    local version="$1"
    if [[ ! "$version" =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]]; then
        print_error "Version must follow semantic versioning (x.x.x)"
        print_info "Example: 1.2.0"
        exit 1
    fi
}

# Create story branch
create_story() {
    local story_name="$1"
    if [[ -z "$story_name" ]]; then
        print_error "Story name is required!"
        print_usage
        exit 1
    fi
    
    local branch_name="story/$story_name"
    
    print_step "Creating story branch: $branch_name"
    
    # Switch to develop and pull latest
    git checkout develop
    git pull upstream develop 2>/dev/null || git pull origin develop
    
    # Create and switch to story branch
    git checkout -b "$branch_name"
    
    print_success "Story branch '$branch_name' created and checked out"
    print_info "You can now start working on your story!"
    print_warning "Remember: Stories should be small, focused tasks (1-3 days max)"
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
    
    print_step "Creating feature branch: $branch_name"
    
    # Switch to develop and pull latest
    git checkout develop
    git pull upstream develop 2>/dev/null || git pull origin develop
    
    # Create and switch to feature branch
    git checkout -b "$branch_name"
    
    print_success "Feature branch '$branch_name' created and checked out"
    print_info "You can now integrate stories into this feature!"
    print_warning "Remember: No direct commits to features - use story branches"
}

# Create release branch
create_release() {
    local version="$1"
    if [[ -z "$version" ]]; then
        print_error "Version is required!"
        print_usage
        exit 1
    fi
    
    validate_version "$version"
    
    local branch_name="release-$version/"
    
    print_step "Creating release branch: $branch_name"
    
    # Switch to develop and pull latest
    git checkout develop
    git pull upstream develop 2>/dev/null || git pull origin develop
    
    # Create and switch to release branch
    git checkout -b "$branch_name"
    
    print_success "Release branch '$branch_name' created and checked out"
    print_info "You can now merge features into this release"
    print_warning "Remember: Update version numbers in gradle.properties and mods.toml"
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
    
    print_step "Creating hotfix branch: $branch_name"
    
    # Switch to main and pull latest
    git checkout main
    git pull upstream main 2>/dev/null || git pull origin main
    
    # Create and switch to hotfix branch
    git checkout -b "$branch_name"
    
    print_success "Hotfix branch '$branch_name' created and checked out"
    print_warning "Remember: Hotfixes should only contain critical bug fixes!"
}

# Finish story
finish_story() {
    local current_branch=$(get_current_branch)
    
    if [[ ! "$current_branch" =~ ^story/.+ ]]; then
        print_error "You must be on a story branch to finish it!"
        exit 1
    fi
    
    print_step "Finishing story: $current_branch"
    
    # Push current branch
    git push origin "$current_branch"
    
    print_success "Story branch pushed to origin"
    print_info "Choose your integration path:"
    echo ""
    echo "🧪 Test in develop:"
    echo "   Create PR: $current_branch → develop"
    echo "   URL: https://github.com/Elfo1507/xiricolico-mod/compare/develop...$current_branch"
    echo ""
    echo "🏗️ Integrate into feature:"
    echo "   Create PR: $current_branch → feature/your-feature"
    echo "   (Replace 'your-feature' with actual feature name)"
}

# Integrate story into current feature
integrate_story() {
    local current_branch=$(get_current_branch)
    
    if [[ ! "$current_branch" =~ ^feature/.+ ]]; then
        print_error "You must be on a feature branch to integrate stories!"
        exit 1
    fi
    
    print_step "Available stories to integrate into $current_branch:"
    
    # List story branches
    git branch -r | grep "origin/story/" | sed 's/origin\///' | sed 's/^[ ]*//'
    
    echo ""
    print_info "To integrate a story, create a PR: story/name → $current_branch"
}

# Finish feature
finish_feature() {
    local current_branch=$(get_current_branch)
    
    if [[ ! "$current_branch" =~ ^feature/.+ ]]; then
        print_error "You must be on a feature branch to finish it!"
        exit 1
    fi
    
    print_step "Finishing feature: $current_branch"
    
    print_info "Choose your completion path:"
    echo ""
    echo "🧪 Test in develop first (recommended):"
    echo "   Create PR: $current_branch → develop"
    echo "   URL: https://github.com/Elfo1507/xiricolico-mod/compare/develop...$current_branch"
    echo ""
    echo "🚀 Add to release:"
    echo "   Create PR: $current_branch → release-x.x.x/"
    echo "   (Replace x.x.x with target version)"
}

# Finish release
finish_release() {
    local current_branch=$(get_current_branch)
    
    if [[ ! "$current_branch" =~ ^release-.+ ]]; then
        print_error "You must be on a release branch to finish it!"
        exit 1
    fi
    
    local version=${current_branch#release-}
    version=${version%/}
    
    print_step "Finishing release: $current_branch (version $version)"
    
    print_info "Create PR to deploy release:"
    echo "   Create PR: $current_branch → main"
    echo "   URL: https://github.com/Elfo1507/xiricolico-mod/compare/main...$current_branch"
    echo ""
    print_warning "After merge, version $version will be automatically tagged and released"
}

# Show GitFlow status
show_status() {
    local current_branch=$(get_current_branch)
    local repo_status=$(git status --porcelain)
    
    echo -e "${BLUE}🌳 Xiricolico Mod - GitFlow Status${NC}"
    echo ""
    
    # Branch info
    echo "📍 Current branch: $current_branch"
    
    # Branch type detection
    if [[ "$current_branch" =~ ^story/.+ ]]; then
        echo "🎯 Branch type: Story (component development)"
    elif [[ "$current_branch" =~ ^feature/.+ ]]; then
        echo "🎯 Branch type: Feature (system development)"
    elif [[ "$current_branch" =~ ^release-.+ ]]; then
        echo "🎯 Branch type: Release (version preparation)"
    elif [[ "$current_branch" =~ ^hotfix/.+ ]]; then
        echo "🎯 Branch type: Hotfix (critical fix)"
    elif [[ "$current_branch" == "develop" ]]; then
        echo "🎯 Branch type: Develop (integration testing)"
    elif [[ "$current_branch" == "main" ]]; then
        echo "🎯 Branch type: Main (production releases)"
    else
        echo "🎯 Branch type: Unknown (not following GitFlow)"
    fi
    
    # Working directory status
    if [[ -n "$repo_status" ]]; then
        echo "📂 Working directory: Changes detected"
        git status --short
    else
        echo "📂 Working directory: Clean"
    fi
    
    echo ""
    echo "📜 Recent commits:"
    git log --oneline -5
    
    echo ""
    echo "🌿 Available branches:"
    git branch -a | head -10
}

# Validate current branch
validate_branch() {
    local current_branch=$(get_current_branch)
    
    print_step "Validating branch: $current_branch"
    
    if [[ "$current_branch" =~ ^story/.+ ]]; then
        print_success "Valid story branch"
    elif [[ "$current_branch" =~ ^feature/.+ ]]; then
        print_success "Valid feature branch"
    elif [[ "$current_branch" =~ ^release-[0-9]+\.[0-9]+\.[0-9]+.* ]]; then
        print_success "Valid release branch"
    elif [[ "$current_branch" =~ ^hotfix/.+ ]]; then
        print_success "Valid hotfix branch"
    elif [[ "$current_branch" == "develop" || "$current_branch" == "main" ]]; then
        print_success "Valid core branch"
    else
        print_error "Branch does not follow GitFlow conventions"
        print_info "Valid patterns:"
        print_info "  - story/your-story-name"
        print_info "  - feature/your-feature-name"
        print_info "  - hotfix/your-fix-name"
        print_info "  - release-x.x.x/"
        exit 1
    fi
}

# Sync develop
sync_develop() {
    print_step "Syncing develop branch with upstream"
    
    git checkout develop
    git pull upstream develop 2>/dev/null || git pull origin develop
    git push origin develop
    
    print_success "Develop branch synced"
}

# Main script logic
case "$1" in
    "story")
        check_git_repo
        create_story "$2"
        ;;
    "feature")
        check_git_repo
        create_feature "$2"
        ;;
    "release")
        check_git_repo
        create_release "$2"
        ;;
    "hotfix")
        check_git_repo
        create_hotfix "$2"
        ;;
    "finish-story")
        check_git_repo
        finish_story
        ;;
    "finish-feature")
        check_git_repo
        finish_feature
        ;;
    "finish-release")
        check_git_repo
        finish_release
        ;;
    "integrate-story")
        check_git_repo
        integrate_story
        ;;
    "sync")
        check_git_repo
        sync_develop
        ;;
    "status")
        check_git_repo
        show_status
        ;;
    "validate")
        check_git_repo
        validate_branch
        ;;
    *)
        print_usage
        exit 1
        ;;
esac
