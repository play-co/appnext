var Appnext = Class(function () {
	this.showInterstitial = function (placementID) {
		logger.log("{appnext} Showing interstitial:", placementID);

		if (NATIVE && NATIVE.plugins && NATIVE.plugins.sendEvent) {
			NATIVE.plugins.sendEvent("AppnextPlugin", "showInterstitial",
				JSON.stringify({ placementID: placementID }));
		}
	};
});

exports = new Appnext();
