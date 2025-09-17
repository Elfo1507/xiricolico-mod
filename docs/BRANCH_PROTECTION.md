# Branch Protection Rules Configuration - Extended GitFlow
# 
# These rules should be applied in GitHub Repository Settings > Branches
# This file serves as documentation for the required protection rules

## Main Branch Protection Rules
- **Branch name pattern**: `main`
- **Restrict pushes that create files**: ✅ Enabled
- **Require pull request reviews before merging**: ✅ Enabled
  - Required approving reviews: 1 (Repository owner only)
  - Dismiss stale reviews: ✅ Enabled
  - Require review from code owners: ✅ Enabled
  - Restrict reviews to users with write access: ✅ Enabled
- **Require status checks to pass**: ✅ Enabled
  - Require branches to be up to date: ✅ Enabled
  - Status checks: `build`, `validate-gitflow-pr`, `validate-main-pr`
- **Require conversation resolution**: ✅ Enabled
- **Require signed commits**: ❌ Optional
- **Require linear history**: ✅ Enabled
- **Require deployments to succeed**: ❌ Disabled
- **Lock branch**: ❌ Disabled
- **Do not allow bypassing**: ✅ Enabled (Repository owners only)

## Release Branch Protection Rules
- **Branch name pattern**: `release-*`
- **Require pull request reviews before merging**: ✅ Enabled
  - Required approving reviews: 1
  - Dismiss stale reviews: ✅ Enabled
  - Require review from code owners: ✅ Enabled
- **Require status checks to pass**: ✅ Enabled
  - Require branches to be up to date: ✅ Enabled
  - Status checks: `build`, `validate-gitflow-pr`
- **Require conversation resolution**: ✅ Enabled
- **Allow force pushes**: ❌ Disabled
- **Allow deletions**: ❌ Disabled

## Feature Branch Protection Rules
- **Branch name pattern**: `feature/**`
- **Require pull request reviews before merging**: ✅ Enabled
  - Required approving reviews: 1
  - Dismiss stale reviews: ❌ Disabled
- **Require status checks to pass**: ✅ Enabled
  - Require branches to be up to date: ✅ Enabled
  - Status checks: `build`, `validate-gitflow-pr`
- **Require conversation resolution**: ✅ Enabled
- **Allow force pushes**: ❌ Disabled
- **Allow deletions**: ❌ Disabled

## Develop Branch Protection Rules
- **Branch name pattern**: `develop`
- **Require pull request reviews before merging**: ✅ Enabled
  - Required approving reviews: 1
  - Dismiss stale reviews: ❌ Disabled
  - Require review from code owners: ❌ Disabled
- **Require status checks to pass**: ✅ Enabled
  - Require branches to be up to date: ✅ Enabled
  - Status checks: `build`
- **Require conversation resolution**: ✅ Enabled
- **Allow force pushes**: ❌ Disabled
- **Allow deletions**: ❌ Disabled

## Story/Hotfix Branch Rules
- **Branch name pattern**: `story/**`
- **Branch name pattern**: `hotfix/**`
- **Require status checks to pass**: ✅ Enabled
  - Status checks: `build`
- **Delete head branches**: ✅ Enabled (after merge)

## Extended GitFlow Merge Rules

### Allowed Merge Paths
```
story/* → develop (testing)
story/* → feature/* (integration)
feature/* → develop (testing)
feature/* → release-x.x.x/ (deployment)
hotfix/* → develop (testing)
hotfix/* → release-x.x.x/ (deployment)
hotfix/* → main (emergency only)
release-x.x.x/ → main (production)
```

### Forbidden Merge Paths
```
❌ story/* → main
❌ story/* → release-x.x.x/
❌ feature/* → main
❌ develop → any branch (testing only)
❌ Any direct commits to main/release/feature branches
```

## Repository Settings
- **Default branch**: `develop`
- **Merge button**: Allow merge commits ✅
- **Squash merging**: Allow squash merging ✅
- **Rebase merging**: Allow rebase merging ❌ (for cleaner history)
- **Auto-delete head branches**: ✅ Enabled
- **Automatically delete head branches**: ✅ Enabled

## CODEOWNERS Configuration
Create `.github/CODEOWNERS` file with repository owner as global code owner.
