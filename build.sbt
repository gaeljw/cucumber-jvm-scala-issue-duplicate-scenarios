name := "test"

version := "0.0.1-BUG"

lazy val jdkVersion = "1.8"
scalaVersion := "2.12.11"

lazy val root = (project in file("."))

// specify the source and target jdk for Java compiler
javacOptions ++= Seq("-source", jdkVersion, "-target", jdkVersion)

//Removing the top level directory
//topLevelDirectory := None

libraryDependencies ++= Seq(

  "junit" % "junit" % "4.12" % Test,
  "io.cucumber" % "cucumber-junit" % "4.7.1" % Test,
  //"io.cucumber" % "cucumber-picocontainer" % "2.4.0" % Test,
  "io.cucumber" %% "cucumber-scala" % "4.7.1" % Test,

  "com.novocode" % "junit-interface" % "0.11" % Test

)
