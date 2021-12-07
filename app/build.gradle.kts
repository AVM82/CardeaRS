import org.rs.cardears.ConfigData
import org.rs.cardears.Deps

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
    id("androidx.navigation.safeargs.kotlin")
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

    implementation(project(":app:features:providers"))
    implementation(project(":app:features:schedule"))
    implementation(project(":localStorage"))
    implementation(project(":remoteStorage"))
    implementation(project(":core"))

    implementation(Deps.Ktx.core)
    implementation(Deps.Ktx.liveData)
    implementation(Deps.Ktx.viewModel)
    implementation(Deps.Ktx.fragment)

    implementation(Deps.AndroidX.appcompat)
    implementation(Deps.Google.material)
    implementation(Deps.AndroidX.constraint)

    implementation(Deps.Google.hilt)
    implementation(Deps.AndroidX.hilt)
    kapt(Deps.Kapt.dagger)
    kapt(Deps.Kapt.hilt)

    implementation(Deps.Ktx.navigationFragment)
    implementation(Deps.Ktx.navigationUi)

    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.junitUi)
    androidTestImplementation(Deps.Test.espresso)
}
