package com.kuaishou.weapon.p0;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Camera;
import android.location.Location;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class an {

    /* renamed from: a, reason: collision with root package name */
    public static final String f35797a = "de.robv.android.xposed.XposedHelpers";

    /* renamed from: b, reason: collision with root package name */
    public static final String f35798b = "de.robv.android.xposed.XposedBridge";

    /* renamed from: c, reason: collision with root package name */
    public static final String f35799c = "com.elderdrivers.riru.edxp.config.EdXpConfigGlobal";

    /* JADX WARN: Code restructure failed: missing block: B:45:0x008e, code lost:
    
        if (r4 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Set<java.lang.String> a() {
        /*
            r6 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r1 = 0
            java.util.HashSet r2 = new java.util.HashSet     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            r2.<init>()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            java.lang.String r4 = "/proc/"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            r3.append(r4)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            java.lang.String r4 = "/maps"
            r3.append(r4)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            java.io.FileReader r5 = new java.io.FileReader     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L8d
        L2c:
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            if (r3 == 0) goto L52
            java.lang.String r5 = ".so"
            boolean r5 = r3.endsWith(r5)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            if (r5 != 0) goto L42
            java.lang.String r5 = ".jar"
            boolean r5 = r3.endsWith(r5)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            if (r5 == 0) goto L2c
        L42:
            java.lang.String r5 = " "
            int r5 = r3.lastIndexOf(r5)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            int r5 = r5 + 1
            java.lang.String r3 = r3.substring(r5)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            r2.add(r3)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            goto L2c
        L52:
            r4.close()     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            java.util.Iterator r2 = r2.iterator2()     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
        L59:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            if (r3 == 0) goto L7d
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            java.lang.String r5 = "com.saurik.substrate"
            boolean r5 = r3.contains(r5)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            if (r5 == 0) goto L71
            r0.add(r3)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            goto L59
        L71:
            java.lang.String r5 = "XposedBridge.jar"
            boolean r5 = r3.contains(r5)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            if (r5 == 0) goto L59
            r0.add(r3)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L8e
            goto L59
        L7d:
            r4.close()     // Catch: java.lang.Exception -> L81
            goto L91
        L81:
            goto L91
        L83:
            r0 = move-exception
            r1 = r4
            goto L87
        L86:
            r0 = move-exception
        L87:
            if (r1 == 0) goto L8c
            r1.close()     // Catch: java.lang.Exception -> L8c
        L8c:
            throw r0
        L8d:
            r4 = r1
        L8e:
            if (r4 == 0) goto L91
            goto L7d
        L91:
            int r2 = r0.size()
            if (r2 <= 0) goto L98
            return r0
        L98:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.an.a():java.util.Set");
    }

    public Set<String> b() {
        Set h10;
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(f35798b);
            if (loadClass == null) {
                return null;
            }
            Field declaredField = loadClass.getDeclaredField("sHookedMethodCallbacks");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(loadClass);
            if (map == null || (h10 = map.h()) == null || h10.size() <= 0) {
                return null;
            }
            return a(h10);
        } catch (Exception unused) {
            return null;
        }
    }

    public Set<String> c() {
        Set h10;
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(f35797a);
            if (loadClass == null) {
                return null;
            }
            Field declaredField = loadClass.getDeclaredField("methodCache");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(loadClass);
            if (map == null || (h10 = map.h()) == null || h10.size() <= 0) {
                return null;
            }
            return a(h10);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a(TelephonyManager.class, "getDeviceId", new Class[0]) ? 1 : 0);
            jSONObject.put("1", a(TelephonyManager.class, "getSubscriberId", new Class[0]) ? 1 : 0);
            jSONObject.put("2", a(TelephonyManager.class, "getSimSerialNumber", new Class[0]) ? 1 : 0);
            jSONObject.put("3", a(Location.class, "getLatitude", new Class[0]) ? 1 : 0);
            jSONObject.put("4", a(Location.class, "getLongitude", new Class[0]) ? 1 : 0);
            if (Build.VERSION.SDK_INT >= 26) {
                jSONObject.put("5", a(Build.class, "getSerial", new Class[0]) ? 1 : 0);
            } else {
                jSONObject.put("5", 0);
            }
            jSONObject.put("6", a(WifiInfo.class, "getMacAddress", new Class[0]) ? 1 : 0);
            jSONObject.put("7", a(WifiInfo.class, "getBSSID", new Class[0]) ? 1 : 0);
            jSONObject.put("8", a(WifiInfo.class, "getRssi", new Class[0]) ? 1 : 0);
            jSONObject.put("9", a(Class.class, "forName", String.class) ? 1 : 0);
            jSONObject.put("10", a(ActivityManager.class, "getRunningServices", Integer.TYPE) ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i10 = 1;
            boolean a10 = a(MediaRecorder.class, "setOutputFile", String.class);
            if (a10) {
                jSONObject.put("0", a10 ? 1 : 0);
            }
            boolean a11 = a(Camera.class, "takePicture", Camera.ShutterCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class);
            if (a11) {
                jSONObject.put("1", a11 ? 1 : 0);
            }
            boolean a12 = a(MediaPlayer.class, "setDataSource", Context.class, Uri.class);
            if (a12) {
                if (!a12) {
                    i10 = 0;
                }
                jSONObject.put("2", i10);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject f() {
        JSONObject jSONObject;
        boolean a10;
        boolean a11;
        try {
            jSONObject = new JSONObject();
            a10 = a(Cipher.class, "doFinal", byte[].class);
            jSONObject.put("0", a10 ? 1 : 0);
            boolean a12 = a(SecureRandom.class, "setSeed", byte[].class);
            jSONObject.put("1", a12 ? 1 : 0);
            if (a12) {
                a10 = true;
            }
            boolean a13 = a(MessageDigest.class, "update", byte[].class);
            jSONObject.put("2", a13 ? 1 : 0);
            if (a13) {
                a10 = true;
            }
            boolean a14 = a(MessageDigest.class, "getInstance", String.class);
            jSONObject.put("3", a14 ? 1 : 0);
            if (a14) {
                a10 = true;
            }
            boolean a15 = a(Uri.class, "parse", String.class);
            jSONObject.put("4", a15 ? 1 : 0);
            if (a15) {
                a10 = true;
            }
            boolean a16 = a(SQLiteDatabase.class, "execSQL", String.class);
            jSONObject.put("5", a16 ? 1 : 0);
            if (a16) {
                a10 = true;
            }
            a11 = a(Activity.class, "finish", new Class[0]);
            jSONObject.put("6", a11 ? 1 : 0);
        } catch (Exception unused) {
        }
        if (a11 ? true : a10) {
            return jSONObject;
        }
        return null;
    }

    public JSONObject g() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            boolean a10 = a(JSONObject.class, "toString", new Class[0]);
            if (a10) {
                jSONObject.put("0", a10 ? 1 : 0);
            }
            boolean a11 = a(TextUtils.class, "isEmpty", CharSequence.class);
            if (a11) {
                jSONObject.put("1", a11 ? 1 : 0);
            }
            boolean a12 = a(JSONArray.class, "toString", new Class[0]);
            if (a12) {
                jSONObject.put("2", a12 ? 1 : 0);
            }
            boolean a13 = a(Cipher.class, "doFinal", byte[].class);
            if (a13) {
                jSONObject.put("3", a13 ? 1 : 0);
            }
            boolean a14 = a(ByteArrayOutputStream.class, "toByteArray", new Class[0]);
            if (a14) {
                jSONObject.put("4", a14 ? 1 : 0);
            }
            boolean a15 = a(FileOutputStream.class, "write", byte[].class);
            if (a15) {
                jSONObject.put("5", a15 ? 1 : 0);
            }
            boolean a16 = a(HttpURLConnection.class, "setRequestProperty", String.class, String.class);
            if (a16) {
                jSONObject.put("6", a16 ? 1 : 0);
            }
        } catch (Exception unused) {
        }
        if (jSONObject.length() > 0) {
            return jSONObject;
        }
        return null;
    }

    public JSONObject b(Set set) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (ClassLoader.getSystemClassLoader() != null && set.size() > 0) {
                int i10 = 1;
                jSONObject.put("0", a(Class.class, "forName", set) ? 1 : 0);
                jSONObject.put("1", a(ClassLoader.class, "loadClass", set) ? 1 : 0);
                jSONObject.put("2", a(Throwable.class, "getStackTrace", set) ? 1 : 0);
                jSONObject.put("3", a(PackageManager.class, c.b("Z2V0SW5zdGFsbGVkUGFja2FnZXM=", 2), set) ? 1 : 0);
                jSONObject.put("4", a(PackageManager.class, c.b("Z2V0SW5zdGFsbGVkQXBwbGljYXRpb25z", 2), set) ? 1 : 0);
                jSONObject.put("5", a(ActivityManager.class, "getRunningServices", set) ? 1 : 0);
                if (!a(JSONObject.class, "toString", set)) {
                    i10 = 0;
                }
                jSONObject.put("6", i10);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            if (obj instanceof String) {
                if (obj != null) {
                    String str = (String) obj;
                    if (!str.startsWith("android.app.ResourcesManager#") && !str.startsWith("android.view.LayoutInflater#")) {
                    }
                }
                hashSet.add(obj);
            } else if (obj instanceof Method) {
                hashSet.add(((Method) obj).getName());
            }
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0059 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(android.content.Context r3, int r4, java.util.Set r5) {
        /*
            r2 = this;
            r0 = 0
            java.lang.ClassLoader r1 = java.lang.ClassLoader.getSystemClassLoader()     // Catch: java.lang.Exception -> L5b
            if (r1 == 0) goto L56
            switch(r4) {
                case 13: goto L4f;
                case 14: goto L48;
                case 15: goto L41;
                case 16: goto L38;
                case 17: goto L2f;
                case 18: goto L26;
                case 19: goto L1d;
                case 20: goto L14;
                case 21: goto Lb;
                default: goto La;
            }     // Catch: java.lang.Exception -> L5b
        La:
            goto L56
        Lb:
            java.lang.Class<android.net.wifi.WifiInfo> r3 = android.net.wifi.WifiInfo.class
            java.lang.String r4 = "getBSSID"
            boolean r3 = r2.a(r3, r4, r5)     // Catch: java.lang.Exception -> L5b
            goto L57
        L14:
            java.lang.Class<android.net.wifi.WifiInfo> r3 = android.net.wifi.WifiInfo.class
            java.lang.String r4 = "getSSID"
            boolean r3 = r2.a(r3, r4, r5)     // Catch: java.lang.Exception -> L5b
            goto L57
        L1d:
            java.lang.Class<android.net.wifi.WifiInfo> r3 = android.net.wifi.WifiInfo.class
            java.lang.String r4 = "getMacAddress"
            boolean r3 = r2.a(r3, r4, r5)     // Catch: java.lang.Exception -> L5b
            goto L57
        L26:
            java.lang.Class<java.lang.reflect.Method> r3 = java.lang.reflect.Method.class
            java.lang.String r4 = "invoke"
            boolean r3 = r2.a(r3, r4, r5)     // Catch: java.lang.Exception -> L5b
            goto L57
        L2f:
            java.lang.Class<java.lang.StringBuilder> r3 = java.lang.StringBuilder.class
            java.lang.String r4 = "toString"
            boolean r3 = r2.a(r3, r4, r5)     // Catch: java.lang.Exception -> L5b
            goto L57
        L38:
            java.lang.Class<android.provider.Settings$Secure> r3 = android.provider.Settings.Secure.class
            java.lang.String r4 = "getString"
            boolean r3 = r2.a(r3, r4, r5)     // Catch: java.lang.Exception -> L5b
            goto L57
        L41:
            java.lang.String r4 = "getSimSerialNumber"
            boolean r3 = r2.a(r3, r4, r5)     // Catch: java.lang.Exception -> L5b
            goto L57
        L48:
            java.lang.String r4 = "getSubscriberId"
            boolean r3 = r2.a(r3, r4, r5)     // Catch: java.lang.Exception -> L5b
            goto L57
        L4f:
            java.lang.String r4 = "getDeviceId"
            boolean r3 = r2.a(r3, r4, r5)     // Catch: java.lang.Exception -> L5b
            goto L57
        L56:
            r3 = 0
        L57:
            if (r3 == 0) goto L5b
            r3 = 1
            return r3
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.an.a(android.content.Context, int, java.util.Set):int");
    }

    private boolean a(Class cls, String str, Set set) {
        if (str != null) {
            try {
                if (set.size() > 0 && set.toString().contains(str)) {
                    if (set.toString().contains(cls.getName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean a(Context context, String str, Set set) {
        TelephonyManager telephonyManager;
        try {
            if (set.size() > 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                return a(telephonyManager.getClass(), str, set);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(Class cls, String str, Class<?>... clsArr) {
        try {
            return a(bh.a((Class<?>) cls, str, clsArr));
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean a(Method method) {
        return method != null && Modifier.isNative(method.getModifiers());
    }
}
