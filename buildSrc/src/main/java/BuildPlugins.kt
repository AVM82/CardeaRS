package org.rs.cardears

object BuildPlugins {
    val gradle by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val hilt by lazy {"com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"}
    val googleServices by lazy {"com.google.gms:google-services:${Versions.googleServices}"}
    val navigationSafeArgs by lazy {"androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationSafeArgs}"}
}
