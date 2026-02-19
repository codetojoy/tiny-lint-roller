// Pure Java project — disable Scala cross-building
crossPaths       := false
autoScalaLibrary := false

organization := "app"
name         := "tiny-lint-roller"
version      := "0.1.0-SNAPSHOT"

javacOptions ++= Seq("-source", "21", "-target", "21")

val ebeanVersion        = "15.1.0"
val pgVersion           = "42.7.1"
val hikariVersion       = "5.1.0"
val logbackVersion      = "1.5.3"
val slf4jVersion        = "2.0.12"
val avajeLogbackVersion = "1.1"

libraryDependencies ++= Seq(
  // Annotation processor — auto-discovered by javac via META-INF/services
  "io.ebean"            % "querybean-generator" % ebeanVersion,
  // Ebean core
  "io.ebean"            % "ebean"               % ebeanVersion,
  "io.ebean"            % "ebean-querybean"     % ebeanVersion,
  // Runtime Java agent for bytecode enhancement
  "io.ebean"            % "ebean-agent"         % ebeanVersion,
  // Database
  "org.postgresql"      % "postgresql"          % pgVersion,
  "com.zaxxer"          % "HikariCP"            % hikariVersion,
  // Logging
  "org.avaje.composite" % "logback"             % avajeLogbackVersion,
  "ch.qos.logback"      % "logback-classic"     % logbackVersion,
  "ch.qos.logback"      % "logback-core"        % logbackVersion,
  "org.slf4j"           % "slf4j-api"           % slf4jVersion,
  "org.slf4j"           % "jcl-over-slf4j"      % slf4jVersion
)

// Fork JVM — required for -javaagent
run / fork := true

// Locate ebean-agent jar dynamically from resolved classpath
run / javaOptions := {
  val cp       = (Runtime / fullClasspath).value
  val agentJar = cp
    .map(_.data)
    .find(_.getName.startsWith("ebean-agent"))
    .getOrElse(sys.error("ebean-agent jar not found on Runtime classpath"))
  Seq(s"-javaagent:${agentJar.getAbsolutePath}")
}

// Forward DB env vars into forked JVM (App.java uses System.getenv())
run / envVars := {
  val keys = Seq("DB_URL", "DB_USERNAME", "DB_PASSWORD")
  keys.map(k => k -> sys.env.getOrElse(k, sys.error(s"Required env var $k is not set"))).toMap
}
