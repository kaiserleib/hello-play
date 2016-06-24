name := "hello"

version := "current"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  javaJpa,
  javaWs,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "org.hibernate" % "hibernate-core"          % "5.1.0.Final",
  "org.hibernate" % "hibernate-java8"         % "5.1.0.Final",
  "mysql" % "mysql-connector-java" % "5.1.36",
  "com.newrelic.agent.java" % "newrelic-api" % "3.24.1",
  "ch.qos.logback.contrib" % "logback-json-core"    % "0.1.2" % "runtime",
  "ch.qos.logback.contrib" % "logback-json-classic" % "0.1.2" % "runtime",
  "ch.qos.logback.contrib" % "logback-jackson"      % "0.1.2" % "runtime",
  "org.codehaus.janino" % "janino" % "2.6.1" % "runtime",
  "org.mockito" % "mockito-all" % "1.9.5" % "test"
)

routesGenerator := InjectedRoutesGenerator

// Needed for proper JUnit test output
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v", "-q")

// Java project.
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java
// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)
// Use .class files instead of generated .scala files for views and routes
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)


