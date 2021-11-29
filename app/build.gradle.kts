import rs.school.rs.android2021task6.ConfigData
import rs.school.rs.android2021task6.Deps

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "org.rs.cardears"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Deps.Ktx.core)
    implementation(Deps.Ktx.liveData)
    implementation(Deps.Ktx.viewModel)
    implementation(Deps.Ktx.fragment)

    implementation(Deps.AndroidX.appcompat)
    implementation(Deps.Google.material)
    implementation(Deps.AndroidX.constraint)

    implementation(Deps.Ktx.navigationFragment)
    implementation(Deps.Ktx.navigationUi)

    implementation(Deps.Google.hilt)
    implementation(Deps.AndroidX.hilt)
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    kapt(Deps.Kapt.dagger)
    kapt(Deps.Kapt.hilt)

    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.junitUi)
    androidTestImplementation(Deps.Test.espresso)
}