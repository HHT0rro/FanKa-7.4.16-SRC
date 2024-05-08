package com.tencent.connect.auth;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: g, reason: collision with root package name */
    private static SharedPreferences f42442g;

    /* renamed from: a, reason: collision with root package name */
    private String f42443a;

    /* renamed from: b, reason: collision with root package name */
    private String f42444b;

    /* renamed from: c, reason: collision with root package name */
    private String f42445c;

    /* renamed from: d, reason: collision with root package name */
    private int f42446d = 1;

    /* renamed from: e, reason: collision with root package name */
    private long f42447e = -1;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.open.utils.a f42448f;

    public QQToken(String str) {
        this.f42443a = str;
    }

    private static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (f42442g == null) {
                f42442g = f.a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = f42442g;
        }
        return sharedPreferences;
    }

    @Deprecated
    private static String b(String str) {
        return Base64.encodeToString(l.i(str), 2);
    }

    @Deprecated
    private static String c(String str) {
        return Base64.encodeToString(l.i(str), 2) + "_spkey";
    }

    public String getAccessToken() {
        return this.f42444b;
    }

    public String getAppId() {
        return this.f42443a;
    }

    public int getAuthSource() {
        return this.f42446d;
    }

    public long getExpireTimeInSecond() {
        return this.f42447e;
    }

    public String getOpenId() {
        return this.f42445c;
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (TextUtils.isEmpty(openId)) {
                JSONObject loadSession = loadSession(this.f42443a);
                if (loadSession != null) {
                    openId = loadSession.getString("openid");
                    if (!TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.f42443a);
            } else {
                SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.f42443a);
            }
        } catch (Exception e2) {
            SLog.i("QQToken", "getLocalOpenIdByAppId " + e2.toString());
        }
        return openId;
    }

    public boolean isSessionValid() {
        return this.f42444b != null && System.currentTimeMillis() < this.f42447e;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f42448f == null) {
                this.f42448f = new com.tencent.open.utils.a(f.a());
            }
            return a(str, this.f42448f);
        } catch (Exception e2) {
            SLog.i("QQToken", "login loadSession" + e2.toString());
            return null;
        }
    }

    public void removeSession(String str) {
        SharedPreferences.Editor edit = a().edit();
        edit.remove(c(str));
        edit.remove(c(str));
        edit.remove(a(str));
        edit.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f42448f == null) {
                this.f42448f = new com.tencent.open.utils.a(f.a());
            }
            return a(this.f42443a, jSONObject, this.f42448f);
        } catch (Exception e2) {
            SLog.i("QQToken", "login saveSession" + e2.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.f42444b = str;
        this.f42447e = 0L;
        if (str2 != null) {
            this.f42447e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.f42443a = str;
    }

    public void setAuthSource(int i10) {
        this.f42446d = i10;
    }

    public void setOpenId(String str) {
        this.f42445c = str;
    }

    private static synchronized JSONObject a(String str, com.tencent.open.utils.a aVar) {
        String b4;
        synchronized (QQToken.class) {
            if (f.a() == null) {
                SLog.i("QQToken", "loadJsonPreference context null");
                return null;
            }
            if (str == null) {
                SLog.i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            }
            String string = a().getString(a(str), "");
            if (TextUtils.isEmpty(string)) {
                if (!JniInterface.isJniOk) {
                    i.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                    JniInterface.loadSo();
                }
                if (!JniInterface.isJniOk) {
                    SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                    return null;
                }
                String c4 = c(str);
                String string2 = a().getString(c4, "");
                try {
                    if (TextUtils.isEmpty(string2)) {
                        String b10 = b(str);
                        String string3 = a().getString(b10, "");
                        try {
                            if (TextUtils.isEmpty(string3)) {
                                SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                                return null;
                            }
                            b4 = JniInterface.d1(string3);
                            if (TextUtils.isEmpty(b4)) {
                                SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                return null;
                            }
                            a(str, new JSONObject(b4), aVar);
                        } catch (Exception e2) {
                            SLog.e("QQToken", "Catch Exception", e2);
                            return null;
                        } finally {
                            a().edit().remove(b10).apply();
                        }
                    } else {
                        b4 = JniInterface.d2(string2);
                        a(str, new JSONObject(b4), aVar);
                    }
                } catch (Exception e10) {
                    SLog.e("QQToken", "Catch Exception", e10);
                    return null;
                } finally {
                    a().edit().remove(c4).apply();
                }
            } else {
                b4 = aVar.b(string);
            }
            try {
                JSONObject jSONObject = new JSONObject(b4);
                SLog.i("QQToken", "loadJsonPreference sucess");
                return jSONObject;
            } catch (Exception e11) {
                SLog.i("QQToken", "loadJsonPreference decode " + e11.toString());
                return null;
            }
        }
    }

    private static synchronized boolean a(String str, JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        synchronized (QQToken.class) {
            if (f.a() == null) {
                SLog.i("QQToken", "saveJsonPreference context null");
                return false;
            }
            if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(Constants.PARAM_EXPIRES_TIME, System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String a10 = a(str);
                        String a11 = aVar.a(jSONObject.toString());
                        if (a10.length() > 6 && a11 != null) {
                            a().edit().putString(a10, a11).commit();
                            SLog.i("QQToken", "saveJsonPreference sucess");
                            return true;
                        }
                        SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return false;
                    }
                    SLog.i("QQToken", "expires is null");
                    return false;
                } catch (Exception e2) {
                    SLog.e("QQToken", "saveJsonPreference exception:" + e2.toString());
                    return false;
                }
            }
            SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
            return false;
        }
    }

    private static String a(String str) {
        return Base64.encodeToString(l.i(str), 2) + "_aes_google";
    }
}
