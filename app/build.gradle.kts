plugins {
    id("java")
    id("application")
    id("org.sonarqube") version "6.2.0.5505"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
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
