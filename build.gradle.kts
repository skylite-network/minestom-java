plugins {
    java
}

group = "org.example"
version = "0.1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Minestom:Minestom:-SNAPSHOT")

    // This is used to enable logging in Minestom
    implementation("org.slf4j:slf4j-simple:2.0.13")

    // Find some more Minestom libraries here:
    // https://minestom.net/libraries
}