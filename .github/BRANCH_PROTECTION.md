# Branch Protection Rules Configuration
# 
# These rules should be applied in GitHub Repository Settings > Branches
# This file serves as documentation for the required protection rules

## Main Branch Protection Rules
- **Branch name pattern**: `main`
- **Restrict pushes that create files**: ✅ Enabled
- **Require pull request reviews before merging**: ✅ Enabled
  - Required approving reviews: 1
  - Dismiss stale reviews: ✅ Enabled
  - Require review from code owners: ✅ Enabled
  - Restrict reviews to users with write access: ✅ Enabled
- **Require status checks to pass**: ✅ Enabled
  - Require branches to be up to date: ✅ Enabled
  - Status checks: `build`, `validate-main-pr`
- **Require conversation resolution**: ✅ Enabled
- **Require signed commits**: ❌ Optional
- **Require linear history**: ✅ Enabled
- **Require deployments to succeed**: ❌ Disabled
- **Lock branch**: ❌ Disabled
- **Do not allow bypassing**: ✅ Enabled (Repository owners only)

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

## Feature/Hotfix Branch Rules
- **Branch name pattern**: `feature/**`
- **Branch name pattern**: `hotfix/**`
- **Require status checks to pass**: ✅ Enabled
  - Status checks: `build`
- **Delete head branches**: ✅ Enabled (after merge)

## Repository Settings
- **Default branch**: `develop`
- **Merge button**: Allow merge commits ✅
- **Squash merging**: Allow squash merging ✅
- **Rebase merging**: Allow rebase merging ❌ (for cleaner history)
- **Auto-delete head branches**: ✅ Enabled
- **Automatically delete head branches**: ✅ Enabled

## CODEOWNERS Configuration
Create `.github/CODEOWNERS` file with repository owner as global code owner.
