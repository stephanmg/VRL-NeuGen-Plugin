# VRL-NeuGen-Plugin

Plugin using NeuGen's pseudo-backend (cf. https://github.com/NeuroBox3D/NeuGen/tree/devel) to allow usage of NeuGen functionality
within a VRL-Studio Project.

Travis: 
* [![Build Status](https://travis-ci.org/stephanmg/VRL-NeuGen-Plugin.svg?branch=master)](https://travis-ci.org/stephanmg/VRL-NeuGen-Plugin)

Coveralls:
* [![Coverage Status](https://coveralls.io/repos/github/stephanmg/VRL-NeuGen-Plugin/badge.svg)](https://coveralls.io/github/stephanmg/VRL-NeuGen-Plugin)

Issues:
* [![Stories in Backlog](https://badge.waffle.io/stephanmg/vrl-neugen-plugin.png?label=backlog&title=Backlog)](http://waffle.io/stephanmg/vrl-neugen-plugin)
[![Stories in Ready](https://badge.waffle.io/stephanmg/vrl-neugen-plugin.png?label=ready&title=Ready)](http://waffle.io/stephanmg/vrl-neugen-plugin)
[![Stories in In Progress](https://badge.waffle.io/stephanmg/vrl-neugen-plugin.png?label=in progress&title=In Progress)](http://waffle.io/stephanmg/vrl-neugen-plugin)
[![Stories in Done](https://badge.waffle.io/stephanmg/vrl-neugen-plugin.png?label=done&title=Done)](http://waffle.io/stephanmg/vrl-neugen-plugin)

Codacy:
* [![Codacy Badge](https://api.codacy.com/project/badge/Grade/70786ea69d38466b85726e964497f901)](https://www.codacy.com/app/stephan_5/VRL-NeuGen-Plugin?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=stephanmg/VRL-NeuGen-Plugin&amp;utm_campaign=Badge_Grade)

VersionEye:
* [![Dependency Status](https://www.versioneye.com/user/projects/57a0d6473d8eb6004f9bce99/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/57a0d6473d8eb6004f9bce99)

License:
* [![LGPLv3](https://img.shields.io/badge/license-LGPLv3-blue.svg)](./README.md)

Join the [Developer Group](https://groups.google.com/forum/#!forum/vrl-developers) if you'd like to contribute.

## How To Build The Project

### 1. Dependencies

- JDK 1.7
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


### 4. Usage
Open the provided template project "NeuGen - Template #1" to get started.

