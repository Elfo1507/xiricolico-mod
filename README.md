# Xiricolico Mod

[![Build Status](https://github.com/yourusername/xiricolico-mod/workflows/Build%20and%20Test/badge.svg)](https://github.com/yourusername/xiricolico-mod/actions)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.21-green.svg)](https://www.minecraft.net/)
[![Forge](https://img.shields.io/badge/Forge-51.0.33-orange.svg)](https://files.minecraftforge.net/)

A comprehensive Minecraft Forge mod featuring diverse technomage content including custom mobs, automated machines, magical foods, status effects, and more.

## 🎮 Features

### 🔧 Configuration
The mod includes comprehensive configuration options:
- Toggle features on/off (mobs, machines, foods, effects)
- Adjust balance settings (spawn rates, speeds, durations)
- Debug options for development

## 📋 Requirements

- **Minecraft**: 1.20.1+ (or your target version)
- **Minecraft Forge**: Latest recommended version
- **Java**: 17+

## 🛠️ Installation

### From Releases (Recommended)
1. Download the latest release from the [Releases page](https://github.com/yourusername/xiricolico-mod/releases)
2. Place the `.jar` file in your `mods` folder
3. Launch Minecraft with Forge installed

### From Source
1. Clone this repository
2. Run `./gradlew build`
3. Find the built jar in `build/libs/`

## 🔨 Development

### Building from Source
```bash
git clone https://github.com/yourusername/xiricolico-mod.git
cd xiricolico-mod
./gradlew build
```

### Development Environment
```bash
./gradlew runClient    # Run client in development
./gradlew runServer    # Run server in development
```

## 📝 Project Structure

```
src/main/java/com/xiricolico/mod/
├── XiricolicoMod.java          # Main mod class
├── config/                     # Configuration system
├── core/                       # Core systems & registries
├── items/                      # Items and foods
├── blocks/                     # Blocks and machines
├── entities/                   # Custom mobs (planned)
├── effects/                    # Status effects (planned)
└── client/                     # Client-side code
```

## 🎯 Roadmap

### Current Status
- ✅ Project structure and configuration

### Planned Features


## 🤝 Contributing

We welcome contributions! We use a **simplified GitFlow workflow** to maintain code quality and organized development.

### 🌳 Quick GitFlow Guide

```bash
# 🆕 Start a new feature
git checkout develop
git checkout -b feature/your-amazing-feature

# 🚨 Create a hotfix
git checkout main  
git checkout -b hotfix/critical-bug-fix

# 🚀 Use our helper script
./scripts/gitflow.sh feature my-new-feature
./scripts/gitflow.sh status
```

### 📋 Branch Rules
- **`main`**: Production releases only (owner approval required)
- **`develop`**: Integration branch (default for PRs)
- **`feature/*`**: New features (merge to develop)
- **`hotfix/*`**: Critical fixes (merge to main)

For detailed guidelines, see our [Contributing Guide](CONTRIBUTING.md).

### 🔧 Quick Start for Contributors
1. Fork the repository
2. Create feature branch: `feature/amazing-feature`
3. Make your changes and test them
4. Push and create PR to `develop`
5. Wait for review and approval

## 🔒 Repository Protection

- ✅ **Branch Protection**: Main and develop branches are protected
- ✅ **Required Reviews**: All PRs require approval
- ✅ **CI/CD Checks**: Automated testing and validation
- ✅ **Code Owners**: Core files require owner review
- ✅ **GitFlow Validation**: Branch naming conventions enforced

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Acknowledgments

- Built with Minecraft Forge
- Inspired by ppopopo

---

**Note**: This mod is in active development. Features marked as "planned" are not yet implemented but are on the roadmap.
