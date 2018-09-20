https://www.javaworld.com/article/2073918/core-java/i-want-my-aop---part-1.html
https://doanduyhai.wordpress.com/2011/12/05/advanced-aspectj-part-i-instanciation-model/
https://github.com/Barlog-M/aspectj-maven-example/blob/compile-time-weaving/pom.xml
https://stackoverflow.com/questions/30413186/nosuchmethoderror-with-aspectj


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
   or
   ajc package/*.java
   or 
   ajc -argfile name.lst
   or 
   ajc -argfile package/name.list

   Note, compiling example in "compiletime-crosscutting" directory will
   result in compile time errors. This is correct behavior illustrating
   how aspectj can be used for compile-time crosscutting behavior modification.
   See the article for more details.

   For exanmple in "softening" directory, perform additional step of
   generating RMI stub classes by invoking following command:

   rmic DateFetcherImpl

   Note, compiling example in "access-control" directory will
   result in an compile time error. This is the correct behavior illustrating
   how aspectj can be used for compile-time crosscutting behavior modification.
   See the article for more details.

2. Run examples by invoking the main class in each directory. Note, not
   all examples have a main class. You can run test by invoking:

   java Test

   Note, HelloWorld.java, MannersAspect.java, and Test.java in helloworld1
   and helloworld2 directory are identical. JapaneseMannersAspect.java is
   the only additional file in helloworld2 directory.
   
3. For "thread-pooling" example, start two or more command shell. In one
   command shell, start the server by issuing:

   java UppercaseServer <port-number>

   For example,
   java UppercaseServer	10000

   In other command shells, start clients by issuing

   java UppercaseClient <servername> <port-number>

   For example,
   java UppercaseClient localhost 10000

   To test pooling aspect, kill a client (by typing ^C), start a new 
   one, and observe messages printed in command shell running the server.
   
4 MVN + Eclipse example

  Run
  mvn compile exec:java
  
  Create executable jar with dependencies
  mvn package assembly:single
  
  ***Branches
	master - non AspectJ example
	compile_time_weaving - weaving during compile time example
	load_time_weaving -waving during load time example
  


