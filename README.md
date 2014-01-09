# VRL-Tutorial-Plugin-01

Tutorial Plugin Project

# Dependencies

- JDK >= 1.6
- IDE with [Gradle](http://www.gradle.org/) support (optional)
- Internet Connetion (other dependencies will be automatically downloaded)

# How To Configure

specify correct path in `build.properties`, e.g.,
    
    # vrl property folder location (plugin destination)
    vrldir=/Users/miho/.vrl/0.4.2/default

# How To Build

## IDE

- open the Gradle project
- call the `installVRLPlugin` Gradle task to build and install the plugin

## Command Line

go to the project folder: 

    cd VRL-Tutorial-Plugin-01/VRL-Tutorial-Plugin-01

call the `installVRLPlugin` Gradle task to build and install the plugin

    ./gradlew installVRLPlugin



