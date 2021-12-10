import org.rs.cardears.Deps

plugins {
    id("java-library")
    id("kotlin")
}

dependencies {

    implementation(Deps.coroutines)

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
