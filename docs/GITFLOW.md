# 🌳 GitFlow Workflow Guide
**Xiricolico Mod - Development Workflow**

## 📊 Branch Structure

Our project uses an extended GitFlow model with story-driven development:

```
main (releases) ← release-x.x.x/ ← feature/* ← story/*
                                  ↑
                      develop (testing) ←┘
```

## 🎯 Branch Types

### 📝 **Story Branches** (`story/*`)
Small, focused tasks that implement specific parts of a feature.

**Examples:**
- `story/essence-extractor-gui`
- `story/copper-beetle-ai` 
- `story/magic-berry-recipe`

**Rules:**
- ✅ Direct commits allowed
- ✅ Can merge to `develop` or `feature/*`
- 🎯 1-3 days of work maximum

### 🏗️ **Feature Branches** (`feature/*`)
Complete features composed of multiple stories.

**Examples:**
- `feature/essence-system`
- `feature/technomage-mobs`
- `feature/automation-machines`

**Rules:**
- ❌ No direct commits (use stories)
- ✅ Can merge to `develop` or `release-x.x.x/`
- 🎯 1-2 weeks of work

### 🚀 **Release Branches** (`release-x.x.x/`)
Version preparation and final testing.

**Examples:**
- `release-1.2.0/`
- `release-2.0.0/`

**Rules:**
- ❌ No direct commits
- ✅ Only merges to `main`
- 🎯 Semantic versioning required

### 🔧 **Develop Branch**
Integration testing environment.

**Rules:**
- ❌ No direct commits
- ✅ Accepts merges from any branch type
- 🎯 Testing only - never merges out

### 🚨 **Hotfix Branches** (`hotfix/*`)
Critical production fixes.

**Examples:**
- `hotfix/crash-on-startup`
- `hotfix/dupe-exploit-fix`

**Rules:**
- ✅ Direct commits allowed
- ✅ Can merge to `develop`, `release-x.x.x/`, or `main`
- 🎯 Emergency priority

## 🔄 Development Process

### 1. Start a Story
```bash
# Create story branch from develop
git checkout develop
git pull origin develop
git checkout -b story/your-story-name

# Work and commit
git add .
git commit -m "feat: implement story component"
git push origin story/your-story-name
```

### 2. Integrate Story
Choose your integration path:

**Option A: Test in develop**
```bash
# Create PR: story/your-story → develop
# For testing and validation
```

**Option B: Add to feature**
```bash
# Create PR: story/your-story → feature/parent-feature
# For feature integration
```

### 3. Complete Feature
```bash
# Test feature in develop first
# Create PR: feature/your-feature → develop

# When ready for release
# Create PR: feature/your-feature → release-x.x.x/
```

### 4. Release to Production
```bash
# Final testing in release branch
# Create PR: release-x.x.x/ → main
# Owner approval required
```

## 🛡️ Protection Rules

### **Merge Restrictions**
- **To `main`**: Only from `release-x.x.x/` branches
- **To `release-x.x.x/`**: From `feature/*` or `hotfix/*` only
- **To `feature/*`**: From `story/*` branches only
- **To `develop`**: From any branch (testing)

### **Required Approvals**
- **Main**: Repository owner approval required
- **Release**: 1 approval required + all CI checks
- **Feature**: CI checks must pass
- **Develop**: CI checks must pass

## 🎯 Branch Naming Conventions

### Story Branches
```
story/component-description
story/gui-essence-extractor
story/ai-copper-beetle
story/recipe-magic-berry
```

### Feature Branches
```
feature/system-name
feature/essence-system
feature/automation-machines
feature/technomage-mobs
```

### Release Branches
```
release-x.x.x/
release-1.2.0/
release-2.0.0/
```

### Hotfix Branches
```
hotfix/issue-description
hotfix/crash-on-startup
hotfix/memory-leak-fix
```

## 🚀 Quick Commands

### Using Git Directly
```bash
# Start story
git checkout develop && git checkout -b story/my-component

# Start feature  
git checkout develop && git checkout -b feature/my-system

# Start release
git checkout develop && git checkout -b release-1.2.0/

# Start hotfix
git checkout main && git checkout -b hotfix/critical-fix
```

### Using Helper Script
```bash
# Story workflow
./scripts/gitflow.sh story my-component
./scripts/gitflow.sh finish-story

# Feature workflow  
./scripts/gitflow.sh feature my-system
./scripts/gitflow.sh finish-feature

# Release workflow
./scripts/gitflow.sh release 1.2.0
./scripts/gitflow.sh deploy-release
```

## 📋 Pull Request Guidelines

### PR Titles
- **Story**: `feat(story): implement component X`
- **Feature**: `feat: add system Y` 
- **Release**: `release: version x.x.x`
- **Hotfix**: `fix: resolve critical issue Z`

### PR Requirements
- ✅ Clear description of changes
- ✅ Testing instructions provided
- ✅ All CI checks passing
- ✅ Appropriate target branch selected
- ✅ Related issues linked

## 🎯 Best Practices

### Story Development
- Keep stories small and focused
- Write clear commit messages
- Test locally before pushing
- Document any breaking changes

### Feature Integration
- Ensure all stories are complete
- Test feature as a whole in develop
- Update documentation if needed
- Verify configuration changes

### Release Preparation
- Update version numbers
- Test thoroughly in release branch
- Prepare changelog
- Verify all features work together

## 🔍 Troubleshooting

### Common Issues
- **Wrong target branch**: Check branch naming and target
- **CI failures**: Review build logs and fix issues
- **Merge conflicts**: Rebase your branch and resolve conflicts
- **Permission denied**: Ensure you have the right permissions

### Getting Help
- Check this documentation first
- Review existing PRs for examples
- Ask in project discussions
- Contact repository maintainers

---
**Remember**: This workflow ensures code quality, organized development, and smooth releases. When in doubt, start with a story branch and work your way up! 🚀
