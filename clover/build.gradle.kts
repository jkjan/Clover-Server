import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.2.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	war
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
	kotlin("plugin.jpa") version "1.3.61"
}

group = "com.jun"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly by configurations.creating
configurations {
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation ("com.google.firebase:firebase-admin:6.8.1")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("mysql:mysql-connector-java")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	//providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		exclude(module = "junit")
	}
	testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.3.50")
	testImplementation("org.assertj:assertj-core:3.13.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
