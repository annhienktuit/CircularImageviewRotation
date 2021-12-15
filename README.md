
# Circular Imageview with Rotate Animation
[![](https://jitpack.io/v/annhienktuit/CircularImageviewRotation.svg)](https://jitpack.io/#annhienktuit/CircularImageviewRotation)

This is a fast and efficient open source custom imageview for Android that allow to easy implement disc animation that usually appear in Music Players.

It uses custom View and support animation

- Start Animation
- Cancel Animation
- Pause Animation
- Set Duration






**Sample**


![](![](https://i.imgur.com/kAS4GOv.gif))


## Installation
**Gradle**

Add it in your root build.gradle at the end of repositories:


```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency

```
dependencies {
	    implementation 'com.github.annhienktuit:CircularImageviewRotation:1.0.8'
	}
```

Note: If this error appear: "Build was configured to prefer settings repositories over project repositories" you can workaround with this:

Replace the line:
```
repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
```
with
```
repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
```
## Usage/Examples

```kotlin
var imageview: CircularImageView
var animation: RotateAnimation

animation = RotateAnimation(this, imageview)

animation.startAnimation() //start

animation.setDuration(20000) //set duration

animation.pause() //pause

animation.resume() //resume

animation.cancel() //cancel
```

