# Contributing to Xiricolico Mod

Thank you for your interest in contributing to Xiricolico Mod! This document provides guidelines for contributing to the project using our simplified GitFlow workflow.

## 🌳 GitFlow Workflow (Extended)

We use an advanced GitFlow model with story-driven development for maximum organization and quality:

### 🔄 Branch Hierarchy

```
main (production releases) ← release-x.x.x/ ← feature/* ← story/*
                                             ↑
                             develop (testing) ←┘
                                   ↑
                             hotfix/* (critical fixes)
```

### 📋 Detailed Branch Rules

#### **Story Branches** (`story/*`)
- 🎯 **Purpose**: Small, focused development tasks (1-3 days max)
- 📝 **Naming**: `story/component-description`
- ✅ **Direct commits**: Allowed
- 🔗 **Can merge to**: `develop` (testing), `feature/*` (integration)
- 🚫 **Cannot merge to**: `main`, `release-x.x.x/`

#### **Feature Branches** (`feature/*`)
- 🎯 **Purpose**: Complete features composed of multiple stories
- 📝 **Naming**: `feature/system-name`  
- ❌ **Direct commits**: Not allowed (use stories)
- � **Can merge to**: `develop` (testing), `release-x.x.x/` (deployment)
- 🚫 **Cannot merge to**: `main`

#### **Release Branches** (`release-x.x.x/`)
- � **Purpose**: Version preparation and final testing
- 📝 **Naming**: `release-1.2.0/` (semantic versioning)
- ❌ **Direct commits**: Not allowed
- 🔗 **Can merge to**: `main` (production) ONLY
- ✅ **Sources**: `feature/*`, `hotfix/*`

#### **Develop Branch** (`develop`)
- 🎯 **Purpose**: Integration testing environment
- ❌ **Direct commits**: Not allowed
- ✅ **Sources**: Any branch type for testing
- 🚫 **Never merges to**: Any other branch (testing only)

#### **Hotfix Branches** (`hotfix/*`)
- 🎯 **Purpose**: Critical production fixes
- 📝 **Naming**: `hotfix/critical-issue`
- ✅ **Direct commits**: Allowed
- 🔗 **Can merge to**: `develop`, `release-x.x.x/`, `main` (emergency)

#### **Main Branch** (`main`)
- 🎯 **Purpose**: Production releases only
- ❌ **Direct commits**: Never allowed
- ✅ **Sources**: `release-x.x.x/` branches ONLY
- 🔒 **Protection**: Owner approval required

## 🚀 Contributing Workflow

### 1. Fork and Clone
```bash
# Fork on GitHub, then clone your fork
git clone https://github.com/yourusername/xiricolico-mod.git
cd xiricolico-mod

# Add upstream remote
git remote add upstream https://github.com/Elfo1507/xiricolico-mod.git
```

### 2. Create Feature Branch
```bash
# Always start from develop
git checkout develop
git pull upstream develop

# Create your feature branch
git checkout -b feature/amazing-new-feature
```

### 3. Development Setup
## 🚀 Extended Development Workflow

### 1. Start a Story (Small Task)
```bash
# Create story branch from develop
git checkout develop
git pull origin develop
git checkout -b story/essence-extractor-gui

# OR use helper script
./scripts/gitflow-extended.sh story essence-extractor-gui
```

### 2. Work on Story
```bash
# Work and commit normally
git add .
git commit -m "feat(story): implement essence extractor GUI layout"
git push origin story/essence-extractor-gui
```

### 3. Complete Story
```bash
# Use helper to see options
./scripts/gitflow-extended.sh finish-story

# Choose integration path:
# Option A: Test in develop (PR: story → develop)
# Option B: Integrate into feature (PR: story → feature/essence-system)
```

### 4. Feature Development
```bash
# Create feature branch
./scripts/gitflow-extended.sh feature essence-system

# Integrate completed stories via PRs
# Multiple stories can be merged into one feature
```

### 5. Release Preparation
```bash
# Create release branch
./scripts/gitflow-extended.sh release 1.2.0

# Merge features via PRs: feature/essence-system → release-1.2.0/
# Update version numbers in gradle.properties and mods.toml
```

### 6. Production Deploy
```bash
# Create PR: release-1.2.0/ → main
# Owner approval required
# Automatic tagging and release after merge
```

### 7. Helper Script Commands
```bash
# Status and validation
./scripts/gitflow-extended.sh status
./scripts/gitflow-extended.sh validate

# Story workflow
./scripts/gitflow-extended.sh story my-component
./scripts/gitflow-extended.sh finish-story

# Feature workflow
./scripts/gitflow-extended.sh feature my-system
./scripts/gitflow-extended.sh finish-feature

# Release workflow
./scripts/gitflow-extended.sh release 1.2.0
./scripts/gitflow-extended.sh finish-release

# Hotfix workflow
./scripts/gitflow-extended.sh hotfix critical-bug
```

## 🔍 Pull Request Review Process

### For `develop` branch:
1. ✅ Automated CI checks must pass
2. ✅ Code review by maintainer
3. ✅ Manual testing if needed
4. ✅ 1 approval required
5. 🎉 Merge to `develop`

### For `main` branch (hotfixes only):
1. ✅ All automated checks must pass
2. ✅ Owner review and approval required
3. ✅ Emergency deployment if critical
4. 🚨 Immediate merge if approved

## 🚫 Branch Protection Rules

### What's Blocked:
- ❌ Direct pushes to `main` or `develop`
- ❌ Force pushes to protected branches
- ❌ Merging without PR approval
- ❌ PRs from invalid branch names
- ❌ Failing CI checks

### What's Required:
- ✅ All CI checks must pass
- ✅ Branch must be up to date
- ✅ Code owner approval for main
- ✅ Conversation resolution
- ✅ Valid branch naming convention

## 📋 Types of Contributions

### 🐛 Bug Reports
- Use the issue template
- Provide reproduction steps
- Include relevant logs and environment details

### ✨ Feature Requests
- Describe the feature and its benefits
- Consider how it fits with the mod's theme
- Provide implementation suggestions if possible

### 🔧 Code Contributions
- Bug fixes
- New items, blocks, or entities
- Performance improvements
- Documentation improvements

### 🎨 Assets
- Textures for items, blocks, and entities
- Sounds and music
- Translations

## 🎯 Development Priorities

### Current Focus
- Implementing custom mob entities
- Adding machine functionality and GUIs
- Creating custom status effects
- Improving configuration system

### Future Goals
- World generation features
- Advanced automation systems
- Integration with popular mods
- Performance optimizations

## 📖 Resources

- [Minecraft Forge Documentation](https://docs.minecraftforge.net/)
- [Forge Community Wiki](https://forge.gemwire.uk/)
- [Modding Tutorials](https://docs.minecraftforge.net/en/latest/gettingstarted/)

## 📞 Getting Help

- Open an issue for questions about the codebase
- Join discussions in existing issues and pull requests
- Check the documentation first

## 🔍 Code Review Process

All contributions go through code review:
1. Automated checks run on your PR
2. Manual review by maintainers
3. Feedback and requested changes
4. Approval and merge

Thank you for contributing to Xiricolico Mod! 🎉
