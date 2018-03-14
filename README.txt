Installing AspectJ
==================
1. Download AspectJ compiler and tool from:
   http://aspectj.org/servlets/AJSite?channel=download&subChannel=compilerAndTools

   Download jar file corresponding to "Compiler and Core Tools".
   
2. Install AspectJ by invoking (the exact command will vary depending upon
   the version of aspectj downloaded):

   java -jar aspectj-tools-1.0.3.jar

   Setup classpath as specified in the installer.

Compiling and running examples
==============================
1. For compiling and running examples, change current directory to example
   of your interest and issue following command:

   ajc *.java

   Note, compiling example in "compiletime-crosscutting" directory will
   result in compile time errors. This is correct behavior illustrating
   how aspectj can be used for compile-time crosscutting behavior modification.
   See the article for more details.

   For exanmple in "softening" directory, perform additional step of
   generating RMI stub classes by invoking following command:

   rmic DateFetcherImpl

2. Run examples by invoking the main class in each directory. Note, not
   all examples have a main class. You can run test by invoking:

   java Test

   Note, HelloWorld.java, MannersAspect.java, and Test.java in helloworld1
   and helloworld2 directory are identical. JapaneseMannersAspect.java is
   the only additional file in helloworld2 directory.
   
   
