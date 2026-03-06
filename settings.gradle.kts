pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "jpFigma"

include(":base")//sdk (Base) 0

include(":modules:ui") //UI agent (Figma → Compose) 1
include(":modules:state") //State agent (UiState / Events) 2
include(":modules:data") //Data agent (API / Repository) 3
include(":app")//Integration agent (ViewModel) 4
