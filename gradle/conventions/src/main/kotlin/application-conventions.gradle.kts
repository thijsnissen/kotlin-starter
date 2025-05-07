plugins {
    id("com.google.cloud.tools.jib")
    application
}

jib {
    to {
        image = "kotlin-starter"
    }
    from {
        image = "eclipse-temurin:21-jre"
    }
}
