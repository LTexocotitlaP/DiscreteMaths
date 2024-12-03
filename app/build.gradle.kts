plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    mavenCentral()
}

dependencies {

}

application {
    mainClass = "org.example.App"
}

javafx {
    version = "23.0.1"
    modules("javafx.controls")
}
