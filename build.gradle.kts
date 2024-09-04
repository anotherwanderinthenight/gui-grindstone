plugins {
    id("java-library")
    id("maven-publish")
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://hub.spigotmc.org/nexus/content/groups/public/")
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        maven("https://oss.sonatype.org/content/groups/public/")
        maven("https://jitpack.io")
    }
}

subprojects {

    apply {
        plugin("java-library")
        plugin("maven-publish")
    }

    group = "dev.triumphteam"
    version = "3.1.11"

    dependencies {
        compileOnly("org.jetbrains:annotations:21.0.1")
        compileOnly("org.spigotmc:spigot-api:1.20.2-R0.1-SNAPSHOT")

        val adventureVersion = "4.17.0"
        api("net.kyori:adventure-api:$adventureVersion")
        api("net.kyori:adventure-text-serializer-legacy:$adventureVersion")
        api("net.kyori:adventure-text-serializer-gson:$adventureVersion")
        api("net.kyori:adventure-platform-bukkit:4.3.3")
    }

    tasks {
        withType<JavaCompile> {
            sourceCompatibility = JavaVersion.VERSION_1_8.toString()
            targetCompatibility = JavaVersion.VERSION_1_8.toString()
            options.encoding = "UTF-8"
        }
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                groupId = "dev.wander"
                artifactId = "Gui"
                version = "1.0"
                from(components["java"])
            }
        }
    }
}
