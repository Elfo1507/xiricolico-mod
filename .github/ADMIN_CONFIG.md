# 🔧 Admin Configuration Guide - Xiricolico Mod

## 🚀 Initial Setup Phase

This document provides instructions for bypassing GitFlow rules during the initial project setup phase.

## 📋 Setup Phase Rules

During the **SETUP PHASE**, direct commits to `main` are allowed for:

- ✅ Initial project configuration
- ✅ Documentation setup
- ✅ CI/CD configuration
- ✅ Branch protection setup
- ✅ Repository structure creation
- ✅ Framework configuration files

## 🛠️ Bypass Methods

### Method 1: Direct Commit to Main (Recommended for Setup)

```bash
# 1. Ensure you're on main branch
git checkout main

# 2. Stage your changes
git add .

# 3. Commit with setup marker
git commit -m "🔧 Setup: [Description]

[SETUP-PHASE] Direct commit to main for initial configuration"

# 4. Push to origin
git push origin main
```

### Method 2: Force Merge from Develop

```bash
# 1. Commit changes to develop
git checkout develop
git add .
git commit -m "🔧 Setup: [Description]"
git push origin develop

# 2. Force merge to main
git checkout main
git merge develop --no-ff -m "🔧 Setup: Merge configuration changes

[SETUP-PHASE] Force merge for initial project setup"
git push origin main
```

### Method 3: Using Admin Override Script

```bash
# Use the admin configuration script
./scripts/admin-config.sh commit "Description of changes"
```

## 🔒 After Setup Phase

Once the initial setup is complete:

1. **Enable branch protection** on GitHub:
   - Go to Settings → Branches
   - Add protection rule for `main`
   - Require pull request reviews
   - Require status checks to pass

2. **Mark setup completion**:

   ```bash
   git tag v0.1.0-setup
   git push origin v0.1.0-setup
   ```

3. **Switch to GitFlow workflow**:
   - All future changes must go through proper branches
   - Use `feature/*`, `hotfix/*`, `release-*` branches
   - Follow the documented GitFlow process

## ⚠️ Important Notes

- **SETUP-PHASE** commits should only be used during initial configuration
- After setup completion, all commits must follow GitFlow rules
- Document all bypass reasons in commit messages
- This file should be removed/archived after setup completion

## 🎯 Setup Completion Checklist

- [ ] All configuration files created
- [ ] Documentation structure established
- [ ] CI/CD workflows configured
- [ ] Branch protection rules documented
- [ ] GitFlow scripts created
- [ ] Initial release tag created (`v0.1.0-setup`)
- [ ] Branch protection enabled on GitHub
- [ ] Remove/archive this admin config file

---

**⚠️ This configuration should only be used during initial project setup!**
