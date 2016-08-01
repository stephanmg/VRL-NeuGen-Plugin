# VRL-NeuGen-Plugin

[![Build Status](https://travis-ci.org/stephanmg/VRL-NeuGen-Plugin.png)](https://travis-ci.org/stephanmg/VRL-NeuGen-Plugin)

Join the [Developer Group](https://groups.google.com/forum/#!forum/vrl-developers) if you'd like to contribute.

## How To Build The Project

### 1. Dependencies

- JDK 1.6
- Internet Connection (other dependencies will be downloaded automatically)
- Optional: IDE with [Gradle](http://www.gradle.org/) support


### 2. Configuration (Optional)

If the plugin shall be installed to a custom destination, specify the path in `build.properties`, e.g.,
    
    # vrl property folder location (plugin destination)
    vrldir=/path/to/.vrl/0.4.3/myvrl
    
Otherwise, the plugin will be installed to the default location (depends on VRL version that is specified in the gradle dependencies).

### 3. Build & Install

#### IDE

To build the project from an IDE do the following:

- open the  [Gradle](http://www.gradle.org/) project
- call the `installVRLPlugin` Gradle task to build and install the plugin
- restart VRL-Studio

#### Command Line

Building the project from the command line is also possible.

Navigate to the project folder and call the `installVRLPlugin` [Gradle](http://www.gradle.org/)
task to build and install the plugin.

##### Bash (Linux/OS X/Cygwin/other Unix-like OS)

    cd Path/To/VRL-NeuGen-Plugin/VRL-NeuGen-Plugin
    ./gradlew installVRLPlugin
    
##### Windows (CMD)

    cd Path\To\VRL-NeuGen-Plugin\VRL-NeuGen-Plugin
    gradlew installVRLPlugin

Finally, restart VRL-Studio

