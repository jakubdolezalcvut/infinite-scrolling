buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.3.2")
        classpath(embeddedKotlin("gradle-plugin"))
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}