import org.rs.cardears.ConfigData
import org.rs.cardears.Deps

plugins {
    id("com.android.library")
    id( "kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

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
    implementation(project(":core"))

    implementation(Deps.Ktx.core)
    implementation(Deps.coroutines)

    implementation(Deps.Google.hilt)
    implementation(Deps.AndroidX.hilt)
    implementation("com.google.firebase:firebase-firestore-ktx:24.0.0")
    implementation("com.google.firebase:firebase-database-ktx:20.0.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.1.1")
    kapt(Deps.Kapt.dagger)
    kapt(Deps.Kapt.hilt)

    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.junitUi)
    androidTestImplementation(Deps.Test.espresso)

}
