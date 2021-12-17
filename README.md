
# Circular Imageview with Rotate Animation
[![](https://jitpack.io/v/annhienktuit/CircularImageviewRotation.svg)](https://jitpack.io/#annhienktuit/CircularImageviewRotation)

This is a fast and efficient open source custom imageview for Android that allow to easy implement disc animation that usually appear in Music Players.

It uses custom View and support animation

- Start Animation
- Cancel Animation
- Pause Animation
- Set Duration





**Sample**

<p align="center">
  <img src="https://i.imgur.com/I61nYTp.gif" width="300" height="530" />
</p>



## Installation
**Gradle**

Add it in your root **build.gradle** at the end of repositories:


```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency

```gradle
dependencies {
	implementation 'com.github.annhienktuit:CircularImageviewRotation:1.0.8'
}
```

Note: If this error appear: "Build was configured to prefer settings repositories over project repositories" you can workaround like this:

Replace the line:
```gradle
repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
```
with
```gradle
repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
```
## Usage/Examples

```kotlin
var imageview: CircularImageView
var animation: RotateAnimation = RotateAnimation(this, imageview)

animation.setDuration(20000) //set duration

animation.startAnimation() //start

animation.pause() //pause

animation.resume() //resume

animation.cancel() //cancel
```

