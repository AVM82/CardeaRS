plugins {
    id("org.jlleitschuh.gradle.ktlint").version("10.2.0")
    id("io.gitlab.arturbosch.detekt").version("1.18.1")
}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(rs.school.rs.android2021task6.BuildPlugins.gradle)
        classpath(rs.school.rs.android2021task6.BuildPlugins.kotlin)
        classpath(rs.school.rs.android2021task6.BuildPlugins.hilt)
    }
}

detekt {
    toolVersion = "1.18.1"
    config = files("config/detekt/detekt.yml")
    buildUponDefaultConfig = true
    source = files("src/main/java", "src/main/kotlin")
    reports {
        html {
            enabled = true
            destination = file("build/detekt/detekt.html")
        }
    }
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    this.jvmTarget = "1.8"
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint") // Version should be inherited from parent
    apply(plugin = "io.gitlab.arturbosch.detekt") // Version should be inherited from parent

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

