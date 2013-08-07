package com.tealeaf.plugin.plugins;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tealeaf.EventQueue;
import com.tealeaf.TeaLeaf;
import com.tealeaf.logger;
import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import java.util.HashMap;

import com.tealeaf.plugin.IPlugin;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.tealeaf.EventQueue;
import com.tealeaf.event.*;

import com.appnext.appnextsdk.Appnext;

public class AppnextPlugin implements IPlugin {
	Context _ctx;
	Appnext _appnext;

	public AppnextPlugin() {
	}

	public void onCreateApplication(Context applicationContext) {
		_ctx = applicationContext;
	}

	public void onCreate(Activity activity, Bundle savedInstanceState) {
        PackageManager manager = activity.getPackageManager();
        String appnextPlacementID = "";
        try {
            Bundle meta = manager.getApplicationInfo(activity.getPackageName(), PackageManager.GET_META_DATA).metaData;
            if (meta != null) {
                appnextPlacementID = meta.get("appnextPlacementID").toString();
            }
        } catch (Exception e) {
            android.util.Log.d("EXCEPTION", "" + e.getMessage());
        }

		logger.log("{appnext} Installing for placementID:", appnextPlacementID);

		_appnext = new Appnext(activity);
		_appnext.setAppID(appnextPlacementID);
	}

    public void showInterstitial(String json) {
        try {
            logger.log("{appnext} Showing interstitial");
			_appnext.showBubble();
        } catch (Exception e) {
            logger.log("{appnext} Failure while showing interstitial:", e.getMessage());
        }
    }

	public void onResume() {
	}

	public void onStart() {
	}

	public void onPause() {
	}

	public void onStop() {
	}

	public void onDestroy() {
	}

	public void onNewIntent(Intent intent) {
	}

	public void setInstallReferrer(String referrer) {
	}

	public void onActivityResult(Integer request, Integer result, Intent data) {
	}

	public void logError(String error) {
	}

	public boolean consumeOnBackPressed() {
		_appnext.hideBubble();
		return true;
	}

	public void onBackPressed() {
	}
}

