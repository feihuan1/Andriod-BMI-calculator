# BMI Calculator (Android)

A simple Android app to calculate Body Mass Index (BMI) based on age, height (feet/inches), and weight (kg). Built with Android SDK 36 and Material components.

## Features
- Gender selection: Male or Female (for UI only; not used in calculation)
- Input fields for age, height (feet + inches), and weight (kg)
- Calculates BMI using metric units
- Displays calculated BMI result

## Screens
- Main screen with:
  - Image banner
  - Gender `RadioGroup`
  - Age `EditText`
  - Height `EditText` for feet and inches
  - Weight `EditText` in kg
  - Calculate `Button`
  - Result `TextView`

## Tech Stack
- Language: Java
- Min SDK: 24
- Target/Compile SDK: 36
- Build system: Gradle (AGP 8.12.2)
- UI: AndroidX AppCompat, Material, ConstraintLayout
- Testing: JUnit 4, AndroidX Test, Espresso

## Project Structure
```
app/
  src/main/
    AndroidManifest.xml
    java/com/example/bmicalculator/MainActivity.java
    res/layout/activity_main.xml
    res/values/{strings.xml, themes.xml, colors.xml}
```

## Setup
1. Clone the repository.
2. Open in Android Studio (Giraffe or newer recommended).
3. Ensure you have SDK 36 installed.
4. Sync Gradle.

## Build & Run
- From Android Studio: Run the `app` configuration on an emulator or device (API 24+).
- CLI:
```bash
./gradlew :app:assembleDebug
./gradlew :app:installDebug
```

## Usage
1. Select gender (optional; not used in BMI formula).
2. Enter age (years).
3. Enter height in feet and inches.
4. Enter weight in kilograms.
5. Tap Calculate to see your BMI.

## BMI Formula
BMI = weight_kg / (height_m^2)
- Feet/inches are converted to meters: total_inches × 0.0254

## Notes & Limitations
- No input validation: non-numeric or empty fields will crash the app. Consider adding checks before parsing.
- Weight is in kg; height must be provided in feet + inches.
- Result currently displays raw BMI number without categorization.

## Dependencies
Managed via `gradle/libs.versions.toml`:
- AndroidX AppCompat `1.7.1`
- Material Components `1.12.0`
- Activity `1.10.1`
- ConstraintLayout `2.2.1`
- JUnit `4.13.2`, AndroidX Test JUnit `1.3.0`, Espresso `3.7.0`

## License
This project is provided as-is for educational purposes.

## Troubleshooting
- Build fails fetching dependencies: Click Sync Gradle, check internet, and ensure AGP `8.12.2` matches your Android Studio.
- SDK not found/Compile SDK 36 missing: Install Android API 36 via SDK Manager and set `compileSdk`/`targetSdk` to 36.
- App crashes on Calculate: One or more inputs may be empty or non-numeric. Enter valid numbers for age, height (feet & inches), and weight (kg).
- Wrong BMI value: Ensure weight is in kilograms and height is correctly split between feet and inches.
