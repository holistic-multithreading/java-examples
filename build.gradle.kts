plugins {
    `java-library`
    id("me.champeau.jmh") version "0.7.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.test {
    useJUnitPlatform()
}

jmh {
    warmupIterations.set(2)
    iterations.set(2)
    fork.set(2)
    benchmarkMode.set(listOf("all"))
}
