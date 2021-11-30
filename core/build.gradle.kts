import org.rs.cardears.ConfigData
import org.rs.cardears.Deps

plugins {
    id("com.android.library")
    id( "kotlin-android")
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
    implementation(Deps.Ktx.navigationFragment)
    implementation(Deps.Ktx.navigationUi)

    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.junitUi)
    androidTestImplementation(Deps.Test.espresso)

}
