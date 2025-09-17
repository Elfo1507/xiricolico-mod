# 📊 Semantic Versioning Guide - Xiricolico Mod
**Version Format: MAJOR.MINOR.PATCH**

## 🎯 Version Number Format

Our project follows [Semantic Versioning](https://semver.org/) with the format **MAJOR.MINOR.PATCH**:

```
12.8.23
││ │ │
││ │ └── PATCH: Bug fixes, hotfixes, small improvements
││ └──── MINOR: New features, backwards compatible changes  
│└────── MAJOR: Breaking changes, incompatible API changes
```

## 📋 When to Increment Each Number

### 🔧 **PATCH Version** (Third Number)
**Increment when making backwards-compatible bug fixes**

**Examples:**
- `1.2.3 → 1.2.4` - Fixed crash when opening GUI
- `2.8.15 → 2.8.16` - Fixed recipe not working properly
- `12.4.7 → 12.4.8` - Performance optimization for mob AI

**What qualifies as PATCH:**
- ✅ Bug fixes that don't change functionality
- ✅ Hotfixes for critical issues
- ✅ Performance improvements
- ✅ Documentation updates
- ✅ Code cleanup without behavior changes
- ✅ Translation updates

### 🆕 **MINOR Version** (Second Number)
**Increment when adding functionality in a backwards-compatible manner**

**Examples:**
- `1.2.8 → 1.3.0` - Added new essence extractor machine
- `2.5.12 → 2.6.0` - Added three new mobs to the game
- `12.8.23 → 12.9.0` - Added configuration options for mob spawning

**What qualifies as MINOR:**
- ✅ New items, blocks, or entities
- ✅ New features that don't break existing saves
- ✅ New configuration options
- ✅ New recipes or crafting methods
- ✅ Enhanced existing features (keeping compatibility)
- ✅ New API methods (backwards compatible)

**PATCH resets to 0** when MINOR is incremented.

### 📊 **MAJOR Version** (First Number)
**Increment when making incompatible API changes or breaking changes**

**Examples:**
- `1.15.7 → 2.0.0` - Complete rewrite of essence system
- `2.8.4 → 3.0.0` - Removed deprecated items, changed save format
- `12.9.3 → 13.0.0` - Major overhaul that breaks existing worlds

**What qualifies as MAJOR:**
- ❌ Breaking changes that affect existing saves
- ❌ Removal of items, blocks, or entities
- ❌ Complete system overhauls
- ❌ Changed mod ID or structure
- ❌ Incompatible API changes
- ❌ Changes requiring world regeneration

**MINOR and PATCH reset to 0** when MAJOR is incremented.

## 🚀 Practical Examples

### Bug Fix Release
```
Current: 2.5.8
Change: Fixed essence extractor crash
New: 2.5.9
```

### Feature Release
```
Current: 2.5.9
Change: Added copper beetle mob + magic berry food
New: 2.6.0
```

### Breaking Change Release
```
Current: 2.6.4
Change: Complete rewrite of machine system (breaks saves)
New: 3.0.0
```

## 🔄 Release Planning

### Current Project Roadmap
- **v1.0.x**: Core functionality, basic systems
- **v1.1.x**: Enhanced mob system, automation features
- **v1.2.x**: Advanced machines, world generation
- **v2.0.x**: Major system overhauls, mod compatibility
- **v3.0.x**: Complete content expansion, API changes

### Version Lifecycle
```
Development → Testing → Release
    ↓           ↓         ↓
 feature/*  → develop → release-x.y.z/ → main → tag vx.y.z
```

## 🎯 Branch Naming Examples

### Valid Release Branches
```
release-1.0.0/     ✅ Initial release
release-1.2.15/    ✅ Minor update with many patches
release-12.8.23/   ✅ High version numbers supported
release-2.15.7/    ✅ Major 2, many minor features
release-100.0.0/   ✅ Century milestone (hypothetical)
```

### Invalid Release Branches
```
release-1.0/       ❌ Missing patch number
release-v1.2.3/    ❌ Extra 'v' prefix
release-1.2.3.4/   ❌ Too many numbers
release-1.2.beta/  ❌ Non-numeric patch
```

## 🛠️ Implementation in Code

### Gradle Properties
```properties
# gradle.properties
mod_version=12.8.23
```

### Mods.toml
```toml
# META-INF/mods.toml
version="${mod_version}"
```

### Git Tags
```bash
# Automatic tagging after release merge
git tag v12.8.23
git push origin v12.8.23
```

## ⚠️ Important Notes

### Pre-1.0.0 Versions
- **0.x.y** versions are considered unstable
- Major changes can happen at any time
- Not recommended for production use

### Version Comparison
```
1.2.3 < 1.2.4    ✅ Patch increment
1.2.9 < 1.3.0    ✅ Minor increment (patch resets)
1.9.5 < 2.0.0    ✅ Major increment (minor/patch reset)
```

### Emergency Hotfixes
For critical production issues:
```
Current release: 2.5.0
Critical bug found: Crash on startup
Hotfix release: 2.5.1 (immediate patch)
```

## 📋 Decision Matrix

| Change Type | Example | Version Change |
|-------------|---------|----------------|
| 🔧 Bug fix | Fixed recipe crash | `2.5.8 → 2.5.9` |
| 🔧 Hotfix | Fixed dupe exploit | `2.5.9 → 2.5.10` |
| 🆕 New item | Added magic sword | `2.5.10 → 2.6.0` |
| 🆕 New feature | Added automation | `2.6.0 → 2.7.0` |
| 📊 Breaking change | Removed old items | `2.7.5 → 3.0.0` |
| 📊 System rewrite | New save format | `3.2.1 → 4.0.0` |

## 🎯 Best Practices

1. **Plan major versions carefully** - Breaking changes affect users
2. **Use patch versions liberally** - Fix bugs quickly
3. **Batch minor features** - Don't increment for every small addition
4. **Communicate breaking changes** - Always document in changelogs
5. **Test thoroughly** - Especially before major version increments

---
*Follow this guide to maintain clear, predictable versioning for Xiricolico Mod development!* 🚀
