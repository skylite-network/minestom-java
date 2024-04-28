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

    // Find some more Minestom libraries here:
    // https://minestom.net/libraries
}