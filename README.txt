======================
Coverage tool for Java
======================

Usage:
$ cd Tutorial3
$ mvn clean
$ mvn install

This creates code-coverage-1.0-SNAPSHOT.jar.

To use the coverage tool, put the included pom.xml file in the directoy containing your maven-structured src directory. Then, from the directory containing pom.xml,
$ mvn clean
$ mvn test

Well, this should work. I think. I include the example.


Edits:

7/3/2018 (Amanda Pierce)
TODO: please add description of classes
- Created project
	Java classes (building and running on her computer)
	- Agent
	- ClassTransformer
	- ClassVisitorModifier
	- CodeCoverageData
	- CodeCoverageInformationContainer
	- MethodVisitorModifier
	- TestListener
	Maven configuration files (working on her computer)
	- pom.xml for building the coverage tool
	- pom.xml for building the test suite to be checked for coverage
	 

8/3/2018 (Ineke van der Berg)
- Rewrote pom.xml files (now building and running in honours lab and on my computer with Maven 3)
- Added README with usage instructions and edit history
- Fixed some issues in source code
- Tried to add some comments


TODO:
- Amanda, will you please put in a few comments for debug purposes?
- Coverage output??
