name := """slickness"""

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq("com.typesafe.slick" %% "slick"       % "2.1.0",
                            "org.xerial"          % "sqlite-jdbc" % "3.7.2")
