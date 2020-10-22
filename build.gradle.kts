import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.jvm.tasks.Jar

plugins {
    kotlin("jvm") version "1.4.10"
}

group = "dev.orf1"
version = "1.0.0"

repositories {
    mavenCentral()
    maven ("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
    maven ("https://repo.aikar.co/content/groups/aikar/")
}

dependencies {
    testImplementation(kotlin("test-junit"))
    compileOnly("org.spigotmc:spigot-api:1.16.3-R0.1-SNAPSHOT")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib", version = "1.4.10")
    implementation("co.aikar:acf-paper:0.5.0-SNAPSHOT")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

task ("installPlugin") {
    project.delete(files("server/plugins"))
    doLast {
        copy {
            from ("build/libs/foundation-${project.version}.jar")
            into ("server/plugins")
        }
    }
}

val fatJar = task("fatJar", type = Jar::class) {
    archiveBaseName.set(project.name)
    manifest {
        attributes["Implementation-Title"] = "Foundation"
        attributes["Implementation-Version"] = archiveVersion
        attributes["Main-Class"] = "dev.orf1.foundation.Foundation"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}

tasks {
    "build" {
        dependsOn(fatJar)
    }
}