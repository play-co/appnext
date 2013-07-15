# Game Closure DevKit Plugin: Appnext

This plugin adds analytics support from the [Appnext service](http://appnext.com) for Android and iOS platforms.

## Usage

Install the addon with `basil install appnext`.

Include it in the `manifest.json` file under the "addons" section for your game:

~~~
"addons": [
	"appnext"
],
~~~

Under the Android/iOS sections, you can configure the Appnext plugin:

~~~
	"android": {
		"versionCode": 1,
		"icons": {
			"36": "resources/icons/android36.png",
			"48": "resources/icons/android48.png",
			"72": "resources/icons/android72.png",
			"96": "resources/icons/android96.png"
		},
		"appnextPlacementID": "4a472b97-401c-40ff-9589-b6f115261814"
	}
~~~

~~~
	"ios": {
		"bundleID": "mmp",
		"appleID": "568975017",
		"version": "1.0.3",
		"icons": {
			"57": "resources/images/promo/icon57.png",
			"72": "resources/images/promo/icon72.png",
			"114": "resources/images/promo/icon114.png",
			"144": "resources/images/promo/icon144.png"
		},
		"appnextPlacementID": "4a472b97-401c-40ff-9589-b6f115261814"
	},
~~~

To use Appnext to display an ad in your game, first use the [Appnext website](http://appnext.com) to create a new placement ID.  Then you can edit your game JavaScript code to import the Appnext object:

~~~
import plugins.appnext.appnext as appnext;
~~~

And use the `showInterstitial` method to show an ad:

~~~
appnext.showInterstitial();
~~~
