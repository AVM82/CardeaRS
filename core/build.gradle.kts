import org.rs.cardears.Deps

plugins {
    id("java-library")
    id("kotlin")
}

dependencies {

    implementation(Deps.coroutines)

    testImplementation(Deps.Test.junit)

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}