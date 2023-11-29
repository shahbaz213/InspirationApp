import org.gradle.kotlin.dsl.`kotlin-dsl`
import org.jetbrains.kotlin.load.kotlin.signatures

plugins {
    id("maven-publish")
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.1.0"
}

extra["PUBLISH_GROUP_ID"] = "io.github.shahbaz213"
extra["PUBLISH_VERSION"] = "1.0"
extra["PUBLISH_ARTIFACT_ID"] = "inspirationlibrary"
extra["PUBLISH_DESCRIPTION"] = "An android gradle plugin for localization"
extra["PUBLISH_URL"] = "https://github.com/shahbaz213/InspirationApp"
extra["PUBLISH_LICENSE_NAME"] = "Apache 2.0 License"
extra["PUBLISH_LICENSE_URL"] = "https://www.apache.org/licenses/LICENSE-2.0"
extra["PUBLISH_DEVELOPER_ID"] = "shahbaz213"
extra["PUBLISH_DEVELOPER_NAME"] = "Malik Shahbaz"
extra["PUBLISH_DEVELOPER_EMAIL"] = "malikshahbaz213@gmail.com"
extra["PUBLISH_SCM_CONNECTION"] = "scm:git:github.com/shahbaz213/InspirationApp.git"
extra["PUBLISH_SCM_DEVELOPER_CONNECTION"] = "scm:git:ssh://github.com/shahbaz213/InspirationApp.git"
extra["PUBLISH_SCM_URL"] = "https://github.com/shahbaz213/InspirationApp/tree/master"


version = extra["PUBLISH_VERSION"] as String
group = extra["PUBLISH_GROUP_ID"] as String
publishing{
    repositories {
        maven {
            url = uri("C:\\repo")
        }
    }
}

gradlePlugin {
    website.set(extra["PUBLISH_URL"] as String)
    vcsUrl.set(extra["PUBLISH_URL"] as String)
    plugins {
        create("InspirationAppPlugin") {
            id = "io.github.shahbaz213.inspirationlibrary"
            implementationClass = "com.app.inspirationlibrary.plugin.inspirationlibrary"
            displayName = "LokaleNow Android Plugin"
            description = "Android gradle plugin for app's localization"
            tags.set(listOf("android", "locale","string"))
        }
    }
}
dependencies {

    implementation("com.android.tools.build:gradle:7.4.0-rc03")
    //implementation("org.javassist:javassist:3.29.2-GA")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation ("com.google.code.gson:gson:2.10.1")
}