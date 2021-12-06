@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "CardeaRS"
include(
    "app",
    "core",
    "app:features:providers",
    "app:features:schedule",
    "localStorage"
)
include(":remoteStorage")
