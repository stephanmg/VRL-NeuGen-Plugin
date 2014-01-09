# VRL-Tutorial-Plugin-01

Tutorial Plugin Project

# Dependencies

- JDK >= 1.6
- IDE with [Gradle](http://www.gradle.org/) support (optional)
- Internet Connection (other dependencies will be downloaded automatically)

# How To Configure

Specify correct path in `build.properties`, e.g.,
    
    # vrl property folder location (plugin destination)
    vrldir=/Users/myusername/.vrl/0.4.2/default

# How To Build

## IDE

- open the  [Gradle](http://www.gradle.org/) project
- call the `installVRLPlugin` Gradle task to build and install the plugin
- restart VRL-Studio

## Command Line

Go to the project folder: 

    cd VRL-Tutorial-Plugin-01/VRL-Tutorial-Plugin-01

and call the `installVRLPlugin`  [Gradle](http://www.gradle.org/) task to build and install the plugin

    ./gradlew installVRLPlugin

Finally, restart VRL-Studio

