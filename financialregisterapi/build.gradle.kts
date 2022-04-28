import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		mavenCentral()
	}

	dependencies {
		classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
	}
}

plugins {
	id("org.springframework.boot") version "2.6.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.jetbrains.kotlin.plugin.allopen") version "1.4.32"
	id("org.jetbrains.kotlin.jvm") version "1.6.21"
//	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "rcmto"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {

}

dependencies {
//	KOTLIN
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//	SPRING
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation ("org.springframework.boot:spring-boot-starter-security")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
//	AWS
	implementation ("com.amazonaws:aws-java-sdk-dynamodb:1.12.173")
	platform("com.amazonaws:aws-java-sdk-bom:1.11.1000")
	implementation ("io.github.boostchicken:spring-data-dynamodb:5.2.5")
//	LOMBOK
	compileOnly ("org.projectlombok:lombok:1.18.22")
	annotationProcessor ("org.projectlombok:lombok:1.18.22")
	testCompileOnly ("org.projectlombok:lombok:1.18.22")
	testAnnotationProcessor ("org.projectlombok:lombok:1.18.22")
//	MODELMAPPER
	implementation ("org.modelmapper:modelmapper:3.0.0")
//JWT
	implementation ("io.jsonwebtoken:jjwt:0.9.1")
	implementation ("jakarta.xml.bind:jakarta.xml.bind-api:2.3.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
//		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
