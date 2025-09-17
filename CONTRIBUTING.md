# Contributing to Xiricolico Mod

Thank you for your interest in contributing to Xiricolico Mod! This document provides guidelines for contributing to the project.

## 🤝 How to Contribute

### 1. Fork and Clone
1. Fork the repository on GitHub
2. Clone your fork locally:
   ```bash
   git clone https://github.com/yourusername/xiricolico-mod.git
   cd xiricolico-mod
   ```

### 2. Development Setup
1. Ensure you have Java 17+ installed
2. Import the project into your IDE (IntelliJ IDEA or Eclipse recommended)
3. Run the client for testing:
   ```bash
   ./gradlew runClient
   ```

### 3. Making Changes

#### Code Style
- Follow Java conventions and existing code style
- Use descriptive variable and method names
- Add appropriate comments for complex logic
- Keep methods focused and reasonably sized

#### New Features
- Create new features in appropriate packages
- Follow the existing registry pattern for items, blocks, and entities
- Add configuration options for major features
- Test your changes thoroughly

#### Bug Fixes
- Identify the root cause before fixing
- Add comments explaining the fix if it's not obvious
- Test the fix and ensure it doesn't break other functionality

### 4. Testing Your Changes
- Test in both single-player and multiplayer
- Verify compatibility with other mods when possible
- Check that the mod loads correctly
- Test configuration changes

### 5. Submitting Your Contribution
1. Create a new branch for your feature/fix:
   ```bash
   git checkout -b feature/your-feature-name
   ```
2. Commit your changes with clear, descriptive messages
3. Push to your fork and create a Pull Request
4. Provide a clear description of what your changes do

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
