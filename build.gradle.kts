plugins {
    signing
    `maven-publish`
    `kotlin-dsl`
    kotlin("jvm") version "2.0.0"
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "1.2.0"
    id("io.github.sgpublic.java-publish") version "1.0.0-alpha01"
}

group = "io.github.sgpublic"
version = "1.0.0-alpha02"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

gradlePlugin {
    website.set("https://github.com/sgpublic/gradle-buildsrc-utils")
    vcsUrl.set("https://github.com/sgpublic/gradle-buildsrc-utils.git")

    plugins {
        create("gradlePublishing") {
            this.id = "${group}.buildsrc-utils"
            implementationClass = "io.github.sgpublic.gradle.BuildSrcUtils"
            displayName = "Gradle buildSrc Utils"
            description = "A collection of gradle buildSrc utils."
            tags = listOf("buildsrc")
        }
    }
}
