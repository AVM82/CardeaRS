import org.rs.cardears.ConfigData
import org.rs.cardears.Deps

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":ResourceModule"))

    val lifecycleVersion = "2.4.0-alpha01"
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

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
    implementation("androidx.navigation:navigation-runtime-ktx:2.3.5")

    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.junitUi)
    androidTestImplementation(Deps.Test.espresso)
}
