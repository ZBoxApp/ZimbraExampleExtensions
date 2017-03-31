## About
This repo contains examples to help understand how to develop a extension for Zimbra Server.

This examples are based on the following documentations:

* [Zimbra 2010 Blog Post: Extending Zimbra with Server Extensions](https://blog.zimbra.com/2010/04/extending-zimbra-with-server-extensions/)
* [Blog de dieploegers: Creating Zimbra Server Extensions Quickstart](http://dennis.dieploegers.de/creating-zimbra-server-extensions-quickstart/)
* [Zimbra Github repo](https://github.com/zimbra)

## Requirements
The included **Vagrant** is ready start using this examples, but it you want to build a development environment on your own, this environment should comply with:

- Zimbra >= 8.6,
- Development tools installed,
- Java development tools installed,
- `ant` and `maven` tools instaled,

## How to use the examples
All the Docs assume that you are using the Vagrant VM, if you are not using it you have to take into account:

- The Webmail Port: `7080` is how the Vagrant VM is configured,
- `sudo`: the examples use `sudo` a lot, you may just run everything like `root`

1. Clone the repo
2. Startup the Vagrant machine
3. Wait for Vagrant
4. Change to the example and read the readme

**All commands must be run on the Vagrant vm**

```
$ vagrant ssh
```

## Examples Folder Structure

* `build`, folder where the `*.class` bytecode files are stored,
* `conf`, folder of the `Extension` configuration,
* `dist`, folder where the `Extension.jar` file is saved,
* `src`, the source code of the extension,

### Manifest File
On every example there is a `./conf/MANIFEST.MF` file, where the extension name is declared:

```
Zimbra-Extension-Class: com.zboxapp.HttpExtension
```

All the examples on this repo belongs to the `com.zboxapp` [package](https://en.wikipedia.org/wiki/Java_package).

### ANT
Inside every example there is a `build.xml` file, which contains the magic to compile the extension. The basic content of this file is as follows:

```xml
<!-- Name of the Extension -->
<project name="HttpExtension" default="jar">
    <!-- Define a couple of variables (property) -->
	<property name="zimbra.root.dir" location="/opt/zimbra"></property>
	<!-- Libraries need on compile time -->
    <property name="common.jars.dir" location="${zimbra.root.dir}/lib/jars"></property>
    <!-- Set the CLASS PATH: Java libs -->
    <path id="class.path">
        <!-- Add all the jars to the CLASS PATH -->
        <fileset dir="${common.jars.dir}">
            <include name="**/*.jar"></include>
        </fileset>
    </path>
    <!-- Compile Taks -->
    <target name="compile" description="Compiles the source code">
        <path id="all.java.path">
            <pathelement location="src"></pathelement>
        </path>
        <javac includeantruntime="false" destdir="build" debug="true" classpathref="class.path">
            <src refid="all.java.path"></src>
        </javac>
    </target>
    <!-- Create jar file task -->
    <target name="jar" depends="compile" description="Creates the jar file">
        <jar manifest="conf/MANIFEST.MF" destfile="dist/HttpExtension.jar" basedir="build"></jar>
    </target>
</project>
```

## Examples

* [HttpExtension](./HttpExtension), shows how to add a new Endpoint on Zimbra server to process a http request.
