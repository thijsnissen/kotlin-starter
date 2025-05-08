plugins {
    application
    id("com.google.cloud.tools.jib")
}

jib {
    to {
        image = "kotlin-starter"
    }
    from {
        image = "eclipse-temurin:21-jre"
    }
}
