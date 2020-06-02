name := "flink-mf-common"
organization := "hu.sztaki.ilab"

version := "0.1"

scalaVersion := "2.11.7"

lazy val flinkVersion = "1.9.0"



lazy val commonDependencies = Seq(
  "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "com.typesafe" % "config" % "1.3.3",
  "org.slf4j" % "slf4j-api" % "1.7.29",
  "org.slf4j" % "slf4j-simple" % "1.7.29",
)

lazy val flinkDependencies = Seq(
  "org.apache.flink" %% "flink-scala" % flinkVersion,
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion,
  "org.apache.flink" %% "flink-streaming-java" % flinkVersion
)

lazy val flinkKafkaDependencies = Seq(
  "org.apache.flink" % "flink-connector-kafka-0.11_2.11" % flinkVersion
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= commonDependencies,
    libraryDependencies ++= flinkDependencies.map(_ % "provided"),
    libraryDependencies ++= flinkKafkaDependencies,
    //    libraryDependencies += "hu.sztaki.ilab" % "matrix-factorization" % "0.1" from "http://info.ilab.sztaki.hu/~bdaniel/matrix-factorization_2.11-0.1.jar",
    libraryDependencies += "hu.sztaki.ilab" % "matrix-factorization" % "0.13" from "http://info.ilab.sztaki.hu/~lukacsg/matrix-factorization-assembly-0.13.jar",
    libraryDependencies += "hu.sztaki.ilab" % "data-stream-logger" % "0.1" from "http://info.ilab.sztaki.hu/~bdaniel/data-stream-logger_2.11-0.1.jar"
  )

lazy val commonSettings = Seq(
  organization := "hu.sztaki.ilab",
  version := "0.2",
  scalaVersion := "2.11.7"
)
