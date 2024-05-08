package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.mobile.auth.gatewayauth.Constant;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.emotion.QQEmotion;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.im.IM;
import com.tencent.open.log.SLog;
import com.tencent.open.log.Tracer;
import com.tencent.open.miniapp.MiniApp;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;

    /* renamed from: c, reason: collision with root package name */
    private static Tencent f45366c;

    /* renamed from: a, reason: collision with root package name */
    private final c f45367a;

    /* renamed from: b, reason: collision with root package name */
    private String f45368b;

    private Tencent(String str, Context context) {
        this.f45367a = c.a(str, context);
    }

    private static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        }
    }

    public static synchronized Tencent createInstance(String str, Context context, String str2) {
        Tencent createInstance;
        synchronized (Tencent.class) {
            createInstance = createInstance(str, context);
            SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str + ", authorities=" + str2);
            if (createInstance != null) {
                createInstance.f45368b = str2;
            } else {
                SLog.i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");
            }
        }
        return createInstance;
    }

    public static synchronized String getAuthorities(String str) {
        synchronized (Tencent.class) {
            if (TextUtils.isEmpty(str)) {
                SLog.i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");
                return null;
            }
            Tencent tencent = f45366c;
            if (tencent == null) {
                SLog.i("openSDK_LOG.Tencent", "sInstance == null");
                return null;
            }
            return str.equals(tencent.getAppId()) ? f45366c.f45368b : "";
        }
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleResultData() data = null ? ");
        sb2.append(intent == null);
        sb2.append(", listener = null ? ");
        sb2.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb2.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean isSupportPushToQZone(Context context) {
        boolean z10 = i.c(context, "5.9.5") >= 0 || i.a(context, Constants.PACKAGE_QQ_SPEED) != null;
        SLog.i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + z10);
        return z10;
    }

    public static boolean isSupportShareToQQ(Context context) {
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean z10 = true;
        if (l.c(context) && i.a(context, Constants.PACKAGE_QQ_PAD) != null) {
            return true;
        }
        if (i.c(context, "4.1") < 0 && i.a(context, Constants.PACKAGE_TIM) == null && i.a(context, Constants.PACKAGE_QQ_SPEED) == null) {
            z10 = false;
        }
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + z10);
        return z10;
    }

    public static boolean onActivityResultData(int i10, int i11, Intent intent, IUiListener iUiListener) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onActivityResultData() reqcode = ");
        sb2.append(i10);
        sb2.append(", resultcode = ");
        sb2.append(i11);
        sb2.append(", data = null ? ");
        sb2.append(intent == null);
        sb2.append(", listener = null ? ");
        sb2.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb2.toString());
        return UIListenerManager.getInstance().onActivityResult(i10, i11, intent, iUiListener);
    }

    public static Map<String, String> parseMiniParameters(Intent intent) {
        String stringExtra;
        HashMap hashMap = new HashMap();
        if (intent == null) {
            SLog.e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
            return hashMap;
        }
        try {
            stringExtra = intent.getStringExtra("appParameter");
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e2);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + stringExtra);
            JSONObject jSONObject = new JSONObject(stringExtra);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        }
        Uri data = intent.getData();
        if (data == null) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");
            return hashMap;
        }
        String uri = data.toString();
        if (TextUtils.isEmpty(uri)) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");
            return hashMap;
        }
        String substring = uri.substring(uri.lastIndexOf(63) + 1);
        if (TextUtils.isEmpty(substring)) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");
            return hashMap;
        }
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + substring);
        for (String str : substring.split("&")) {
            String[] split = str.split("=");
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    public static void setCustomLogger(Tracer tracer) {
        SLog.i("openSDK_LOG.Tencent", "setCustomLogger");
        SLog.getInstance().setCustomLogger(tracer);
    }

    public void checkLogin(IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "checkLogin()");
        this.f45367a.a(iUiListener);
    }

    public String getAccessToken() {
        String accessToken = this.f45367a.b().getAccessToken();
        SLog.i("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + accessToken);
        return accessToken;
    }

    public String getAppId() {
        String appId = this.f45367a.b().getAppId();
        SLog.i("openSDK_LOG.Tencent", "getAppId() appid =" + appId);
        return appId;
    }

    public long getExpiresIn() {
        long expireTimeInSecond = this.f45367a.b().getExpireTimeInSecond();
        SLog.i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + expireTimeInSecond);
        return expireTimeInSecond;
    }

    public String getOpenId() {
        String openId = this.f45367a.b().getOpenId();
        SLog.i("openSDK_LOG.Tencent", "getOpenId() openid= " + openId);
        return openId;
    }

    public QQToken getQQToken() {
        SLog.i("openSDK_LOG.Tencent", "getQQToken()");
        return this.f45367a.b();
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleLoginData() data = null ? ");
        sb2.append(intent == null);
        sb2.append(", listener = null ? ");
        sb2.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb2.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void initSessionCache(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString("openid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
            SLog.i("openSDK_LOG.Tencent", "initSessionCache()");
        } catch (Exception e2) {
            SLog.i("QQToken", "initSessionCache " + e2.toString());
        }
    }

    public boolean isQQInstalled(Context context) {
        boolean b4 = i.b(context);
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + b4);
        return b4;
    }

    public boolean isReady() {
        boolean z10 = isSessionValid() && getOpenId() != null;
        SLog.i("openSDK_LOG.Tencent", "isReady() --ready=" + z10);
        return z10;
    }

    public boolean isSessionValid() {
        boolean c4 = this.f45367a.c();
        SLog.i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + c4);
        return c4;
    }

    public boolean isSupportSSOLogin(Activity activity) {
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean z10 = true;
        if (l.c(activity) && i.a((Context) activity, Constants.PACKAGE_QQ_PAD) != null) {
            return true;
        }
        if (i.c(activity, "4.1") < 0 && i.d(activity, "1.1") < 0 && i.e(activity, "4.0.0") < 0) {
            z10 = false;
        }
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + z10);
        return z10;
    }

    public JSONObject loadSession(String str) {
        JSONObject loadSession = this.f45367a.b().loadSession(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadSession() appid ");
        sb2.append(str);
        sb2.append(", length=");
        sb2.append(loadSession != null ? loadSession.length() : 0);
        SLog.i("openSDK_LOG.Tencent", sb2.toString());
        return loadSession;
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        return this.f45367a.a(activity, str, iUiListener);
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        return this.f45367a.a(activity, str + ",server_side", iUiListener);
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, boolean z10, String str2, String str3, String str4) {
        SLog.i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        return this.f45367a.a(activity, str, iUiListener, z10, str2, str3, str4);
    }

    public void logout(Context context) {
        SLog.i("openSDK_LOG.Tencent", "logout()");
        this.f45367a.b().setAccessToken(null, "0");
        this.f45367a.b().setOpenId(null);
        this.f45367a.b().removeSession(this.f45367a.b().getAppId());
    }

    public boolean onActivityResult(int i10, int i11, Intent intent) {
        SLog.i("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
        return false;
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "publishToQzone()");
        new QzonePublish(activity, this.f45367a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        return this.f45367a.b(activity, str, iUiListener);
    }

    public void releaseResource() {
    }

    public void reportDAU() {
        SLog.i("openSDK_LOG.Tencent", "reportDAU() ");
        this.f45367a.a();
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        SLog.i("openSDK_LOG.Tencent", "request()");
        return HttpUtils.request(this.f45367a.b(), f.a(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        SLog.i("openSDK_LOG.Tencent", "requestAsync()");
        HttpUtils.requestAsync(this.f45367a.b(), f.a(), str, bundle, str2, iRequestListener);
    }

    public void saveSession(JSONObject jSONObject) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("saveSession() length=");
        sb2.append(jSONObject != null ? jSONObject.length() : 0);
        SLog.i("openSDK_LOG.Tencent", sb2.toString());
        this.f45367a.b().saveSession(jSONObject);
    }

    public void setAccessToken(String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        this.f45367a.a(str, str2);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        String string = bundle.getString("picture");
        new QQAvatar(this.f45367a.b()).setAvatar(activity, Uri.parse(string), iUiListener, bundle.getInt(Constant.LOGIN_ACTIVITY_EXIT_ANIM));
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setAvatarByQQ()");
        new QQAvatar(this.f45367a.b()).setAvatarByQQ(activity, uri, iUiListener);
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setDynamicAvatar()");
        new QQAvatar(this.f45367a.b()).setDynamicAvatar(activity, uri, iUiListener);
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "saveQQEmotions()");
        new QQEmotion(this.f45367a.b()).setEmotions(activity, arrayList, iUiListener);
    }

    public void setOpenId(String str) {
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --start");
        this.f45367a.b(f.a(), str);
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "shareToQQ()");
        if (TextUtils.isEmpty(this.f45368b)) {
            iUiListener.onWarning(-19);
        }
        new QQShare(activity, this.f45367a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "shareToQzone()");
        new QzoneShare(activity, this.f45367a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public int startIMAio(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMAio()");
        return startIMConversation(activity, IM.CHAT_TYPE_AIO, str, str2);
    }

    public int startIMAudio(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMAudio()");
        return startIMConversation(activity, IM.CHAT_TYPE_AUDIO_CHAT, str, str2);
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        return new IM(getQQToken()).startIMConversation(activity, str, str2, str3);
    }

    public int startIMVideo(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMVideo()");
        return startIMConversation(activity, IM.CHAT_TYPE_VIDEO_CHAT, str, str2);
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3) {
        SLog.i("openSDK_LOG.Tencent", "startMiniApp()");
        return new MiniApp(getQQToken()).startMiniApp(activity, MiniApp.MINIAPP_TYPE_NORMAL, str, "21", str2, str3);
    }

    public int login(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.i("openSDK_LOG.Tencent", "login activity with params");
        return this.f45367a.a(activity, iUiListener, map);
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        return this.f45367a.a(fragment, str + ",server_side", iUiListener, "");
    }

    public int login(Activity activity, String str, IUiListener iUiListener, boolean z10) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        return this.f45367a.a(activity, str, iUiListener, z10);
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            f.a(context.getApplicationContext());
            SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
            if (TextUtils.isEmpty(str)) {
                SLog.e("openSDK_LOG.Tencent", "appId should not be empty!");
                return null;
            }
            Tencent tencent = f45366c;
            if (tencent == null) {
                f45366c = new Tencent(str, context);
            } else if (!str.equals(tencent.getAppId())) {
                f45366c.logout(context);
                f45366c = new Tencent(str, context);
            }
            if (!a(context, str)) {
                return null;
            }
            g.a(context, str);
            SLog.i("openSDK_LOG.Tencent", "createInstance()  -- end");
            return f45366c;
        }
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener, int i10, int i11) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        bundle.putInt(Constant.LOGIN_ACTIVITY_EXIT_ANIM, i11);
        activity.overridePendingTransition(i10, 0);
        setAvatar(activity, bundle, iUiListener);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        return this.f45367a.a(fragment, str, iUiListener, "");
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener, boolean z10) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        return this.f45367a.a(fragment, str, iUiListener, "", z10);
    }
}
