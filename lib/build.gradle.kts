plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.mixinpowered.net.lib"
version = "0.0.0"

repositories {
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly("io.papermc.paper:paper-api:1.21.3-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    enabled = false
}

kotlin {
    jvmToolchain(21)
}