plugins {
    `java-gradle-plugin`
    `maven-publish`
}

group = "com.jinte"
version = "1.0.0"

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("jintePlugin") {
            id = "com.vvsk.jinte"
            implementationClass = "com.vvsk.jinte.JintePlugin"
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("pluginMaven") {
            
        }
 
    }
}

tasks.build {
    doLast {
        val jarFile = layout.buildDirectory.file("libs/jinte-${version}.jar").get().asFile
        val targetDir = File(rootProject.projectDir, "artifacts") // Change if needed

        targetDir.mkdirs() // Ensure the directory exists
        jarFile.copyTo(File(targetDir, jarFile.name), overwrite = true)

        println("✅ JAR copied to ${targetDir.absolutePath}")
    }
}
