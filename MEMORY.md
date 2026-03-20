# Figma to Compose - Conversion 1

## Source
- JSON: `616-12935.json`
- Assets parsed: Facebook, Telegram, VK, Phone.

## Output Structure
- `projects/jpFigma/modules/ui/src/main/java/com/example/ui/screens/SupportScreen.kt` - Main screen component (`SupportScreen` container and `SupportScreenBody`).
- `projects/jpFigma/modules/ui/src/main/java/com/example/ui/components/SupportComponents.kt` - Reusable UI components for the screen (`SocialIconButton`, `SupportHeader`).
- `projects/jpFigma/app/src/main/java/com/example/app/mockScreens/SupportMockData.kt` - Mock data state.
- `projects/jpFigma/modules/ui/src/main/java/com/example/ui/theme/` - Theme configurations (`Color.kt`, `Theme.kt`).

## Notes
- The JSON source was primarily a list of asset URLs rather than a full layout tree. Thus, inferred a "Support/Social Contacts" screen structure from the provided icons.
- Adhered strictly to the provided rules: no ViewModel/Repository, dp instead of px, no magic numbers, components split correctly into `components` package, Mock data created in `:app` module.
- `SupportScreen` has no parameters and calls `SupportScreenBody`.
- Used standard modifiers and strict UI decomposition.
