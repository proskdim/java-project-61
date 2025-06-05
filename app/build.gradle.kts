plugins {
    id("application")
    id("org.sonarqube") version "6.2.0.5505"

    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
    properties {
      property("sonar.projectKey", "proskdim_java-project-61")
      property("sonar.organization", "proskdim")
      property("sonar.host.url", "https://sonarcloud.io")
    }
  }

application  {
  mainClass = "hexlet.code.App"
}
