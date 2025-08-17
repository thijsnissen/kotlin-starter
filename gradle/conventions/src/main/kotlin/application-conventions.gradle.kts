import utils.DockerImageTag

group = ""
version = "0.1.0-SNAPSHOT"

description = "Directory structure and settings for starting a new Kotlin project"

plugins {
    application
    id("com.google.cloud.tools.jib")
}

val dockerImageTagProvider = providers.of(DockerImageTag::class) { parameters.semver.set(version.toString()) }

jib {
    container {
        creationTime = "USE_CURRENT_TIMESTAMP"
        ports = listOf("8080")
    }

    from {
        platforms {
            platform {
                os = "linux"
                architecture = "amd64"
            }
            platform {
                os = "linux"
                architecture = "arm64"
            }
        }
        image = "gcr.io/distroless/java21:nonroot"
    }
    to {
        image = rootProject.name
        tags = setOf(
            dockerImageTagProvider.get(),
            "latest"
        )
    }
}
