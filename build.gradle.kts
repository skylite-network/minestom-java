plugins {
    java
    application
    id("io.github.goooler.shadow") version "8.1.7"
}

group = "org.example"
version = "0.1.0"

application.mainClass = "org.example.server.Server"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.minestom:minestom-snapshots:1f34e60ea6")

    // Enable logging in Minestom
    implementation("ch.qos.logback:logback-classic:1.5.6")

    // Find some more Minestom libraries here:
    // https://minestom.net/libraries
}

tasks.shadowJar {
    archiveClassifier = ""
}

tasks.build {
    dependsOn(tasks.shadowJar)
}
