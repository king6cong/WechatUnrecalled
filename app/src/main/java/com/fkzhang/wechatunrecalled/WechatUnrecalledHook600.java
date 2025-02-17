package com.fkzhang.wechatunrecalled;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

import java.util.Random;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;

import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;
import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;

/**
 * Created by fkzhang on 1/16/2016.
 */
public class WechatUnrecalledHook600 extends WechatUnrecalledHook {

    private Object mStorageObject;

    public WechatUnrecalledHook600(WechatPackageNames packageNames) {
        super(packageNames);
    }

    public void hook(ClassLoader loader) {
        try {
            hookRecall(loader);
        } catch (Exception e) {
            XposedBridge.log(e);
        }
        try {
            hookDatabase(loader);
        } catch (Exception e) {
            XposedBridge.log(e);
        }
        try {
            hookStorageObject(loader);
        } catch (Exception e) {
            XposedBridge.log(e);
        }
        try {
            findAndHookConstructor("dalvik.system.DexClassLoader", loader, String.class, String.class,
                    String.class, ClassLoader.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            String dexPath = (String) param.args[0];
                            ClassLoader classLoader = (ClassLoader) param.thisObject;
                            if (dexPath.contains(mP.packageName + ".plugin.mutidex")) {
                                try {
                                    hookSns(classLoader);
                                } catch (Exception e) {
                                    XposedBridge.log(e);
                                }
                            }
                        }
                    });
        } catch (Exception e) {
            XposedBridge.log(e);
        }
        try {
            hookApplicationPackageManager(loader);
        } catch (Throwable t) {
            XposedBridge.log(t);
        }
    }

    protected void hookStorageObject(final ClassLoader loader) {
        findAndHookConstructor(mP.packageName + ".storage.ay", loader,
                mP.packageName + ".at.h", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        mStorageObject = param.thisObject;
                    }
                });
    }

    protected void insertMessage(String talker, int talkerId, String msg, long createTime) {
        int type = 10000;
        int status = 3;
        long msgSvrId = createTime + (new Random().nextInt());
        long msgId = getNextMsgId();
        ContentValues v = new ContentValues();
        v.put("msgid", msgId);
        v.put("msgSvrid", msgSvrId);
        v.put("type", type);
        v.put("status", status);
        v.put("createTime", createTime);
        v.put("talker", talker);
        v.put("content", msg);
        insertSQL("message", "", v);
        updateMessageCount();
    }

    protected void updateMessageCount() {
        callMethod(callMethod(mStorageObject, "Cv", "message"), "aSC");
    }

    protected Bitmap getImage(String path) {
        String str = null;
        try {
            str = (String) callMethod(callStaticMethod(mImgClss, mP.imageMethod1),
                    mP.imageMethod2, path, "", "");
        } catch (Exception e) {
        }

        if (TextUtils.isEmpty(str))
            return null;

        return BitmapFactory.decodeFile(str);
    }

}
