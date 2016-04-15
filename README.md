# Preferences Manager

The android library that is used to manage the preferences.

[![Platform](http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat)](http://developer.android.com/index.html) [![Language](http://img.shields.io/badge/language-java-orange.svg?style=flat)](http://www.oracle.com/technetwork/java/javase/downloads/index.html) [![License](http://img.shields.io/badge/license-apache2.0-lightgrey.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

## Usage

Initialize the preferences manager

```java
new PreferencesManager(this)
    .setName("prefs")
    .init();
```

Example 1:

```java
// put int to preferences
PreferencesManager.putInt(key, value);

// get int from preferences
PreferencesManager.getInt(key)
```

Example 2:

```java
// your object
class Person {
    
    public String name;
    
    public Person(String name) {
        this.name = name;
    }

}

// put object to preferences
PreferencesManager.putObject(key, new Person(name));

// get object from preferences
PreferencesManager.getObject(key, Person.class);
```

## Gradle

Add the dependency in your `build.gradle`

```groovy
buildscript {
    repositories {
        jcenter()
    }
}

dependencies {
    compile 'com.shawnlin:PreferencesManager:1.0.1'
}
```

## License

```
Copyright (C) 2016 ShawnLin013(Shawn Lin)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```