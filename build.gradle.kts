plugins {
    `kotlin-dsl`
    kotlin("jvm") version "2.0.0"

    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "1.2.0"
}

group = "io.github.sgpublic"
version = "1.0.0-alpha01"

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

publishing {
    repositories {
        mavenLocal()
    }
}

gradlePlugin {
    website.set("https://github.com/sgpublic/buildsrc-utils")
    vcsUrl.set("https://github.com/sgpublic/buildsrc-utils.git")

    plugins {
        create("gradlePublishing") {
            this.id = "${group}.buildsrc-utils"
            implementationClass = "io.github.sgpublic.gradle.BuildSrcUtils"
            displayName = "Gradle buildSrc Utils"
            description = "A collection of gradle buildSrc utils."
        }
    }
}
