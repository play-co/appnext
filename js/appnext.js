var Appnext = Class(function () {
	this.showInterstitial = function () {
		logger.log("{appnext} Showing interstitial");

		if (NATIVE && NATIVE.plugins && NATIVE.plugins.sendEvent) {
			NATIVE.plugins.sendEvent("AppnextPlugin", "showInterstitial",
				JSON.stringify({}));
		}
	};
});

exports = new Appnext();
