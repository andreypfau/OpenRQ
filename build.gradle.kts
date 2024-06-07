plugins {
    `java-library`
    `maven-publish`
    id("me.champeau.jmh") version "0.7.2"
}

version = "3.3.2"
group = "net.fec.openrq"

repositories {
    mavenCentral()
}

dependencies {
    jmh("com.beust:jcommander:1.35")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnit("4.13.2")
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(8)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
