ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val dependencies = Seq(
  "io.circe" %% "circe-core" % "0.12.3",
  "io.circe" %% "circe-parser" % "0.12.3",
  "io.circe" %% "circe-generic" % "0.12.3",
  "org.sangria-graphql" %% "sangria" % "2.0.0-M3",
  "org.sangria-graphql" %% "sangria-circe" % "1.3.0"
)

lazy val working = (project in file("samples/working"))
  .settings(
    name := "working",
    libraryDependencies ++= dependencies
  )

lazy val notWorking = (project in file("samples/not_working"))
  .settings(
    name := "not_working",
    libraryDependencies ++= dependencies
  )

lazy val workaround = (project in file("samples/workaround"))
  .settings(
    name := "workaround",
    libraryDependencies ++= dependencies
  )

lazy val root = (project in file("."))
  .settings(
    name := "sangria-ambiguous-reference"
  )
  .dependsOn(working, notWorking, workaround)
