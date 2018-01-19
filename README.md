Android ViewPager Library with custom tab titles and icons.

## Screenshots

![1](/screenshots/1.png?raw=true)

## Importing into your project

**Gradle**

Add the following to your parent project Gradle file

```
allprojects {
        repositories {
           maven { url "https://dl.bintray.com/mikefot/maven/" }
        }
    }
```

And the following to your module Gradle file:

`compile 'com.michaelfotiadis:android-smart-fragment-pager-adapter:1.0.1'`

**Maven**

```
<dependency>
  <groupId>com.michaelfotiadis</groupId>
  <artifactId>android-smart-fragment-pager-adapter</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```

You will also need to include the AppCompat and Design libraries in your project.

**Bintray Project**
https://bintray.com/mikefot/maven/android-smart-fragment-pager-adapter
