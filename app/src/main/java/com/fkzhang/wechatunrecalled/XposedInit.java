package com.fkzhang.wechatunrecalled;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;

/**
 * Created by fkzhang on 1/16/2016.
 */
public class XposedInit implements IXposedHookLoadPackage {
    private SparseArray<WechatUnrecalledHook> mWechatHooks;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {

//        XposedBridge.log(loadPackageParam.packageName);

        String packageName = loadPackageParam.packageName;
        if (!(packageName.contains("com.tencen") && packageName.contains("mm")))
            return;


        try {
            Object activityThread = callStaticMethod(findClass("android.app.ActivityThread", null), "currentActivityThread");
            Context mContext = (Context) callMethod(activityThread, "getSystemContext");

            try {
                String versionName = mContext.getPackageManager().getPackageInfo(packageName,
                        0).versionName;

                XposedBridge.log("Loaded app: " + loadPackageParam.packageName + " " + versionName);

                WechatUnrecalledHook hooks = getHooks(packageName, versionName,
                        loadPackageParam.appInfo.uid);
                if (hooks != null)
                    hooks.hook(loadPackageParam.classLoader);
            } catch (Exception e) {
                XposedBridge.log(e);
            }
        } catch (Exception e) {
            XposedBridge.log(e);
        }


    }

    private WechatUnrecalledHook getHooks(String packageName, String versionName, int uid) {
        if (mWechatHooks == null) {
            mWechatHooks = new SparseArray<>();
        }
        if (mWechatHooks.indexOfKey(uid) != -1) {
            return mWechatHooks.get(uid);
        }

        if (TextUtils.isEmpty(versionName)) {
            if (packageName.equals("com.tencent.mm4")) { // support modified 6.3.5 version
                mWechatHooks.put(uid, new WechatUnrecalledHook(new WechatPackageNames("com.tencent.mm",
                        "6.3.5")));
            }
        } else if (versionName.contains("6.3.13") || versionName.contains("6.3.11") ||
                versionName.contains("6.3.9") || versionName.contains("6.3.8") ||
                versionName.contains("6.3.5") || versionName.contains("6.3.0") ||
                versionName.contains("6.2.5")) {
            mWechatHooks.put(uid, new WechatUnrecalledHook(new WechatPackageNames(packageName, versionName)));
        } else if (versionName.contains("6.0.0")) { // 6.0 golden modified version
            mWechatHooks.put(uid, new WechatUnrecalledHook600(new WechatPackageNames(packageName, versionName)));
        } else {
            XposedBridge.log("wechat version " + versionName + " not supported, please upgrade");
            return null;
        }

        return mWechatHooks.get(uid);
    }

}
