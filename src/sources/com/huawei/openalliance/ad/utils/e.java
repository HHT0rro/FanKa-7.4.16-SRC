package com.huawei.openalliance.ad.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.huawei.hms.ads.gl;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.net.URISyntaxException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e {
    private static final String Code = "ApkUtil";
    private static final Map<String, List<String>> V;

    static {
        HashMap hashMap = new HashMap();
        V = hashMap;
        hashMap.put("com.huawei.hwid", Arrays.asList("b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05"));
        hashMap.put("com.huawei.hms", Arrays.asList("e49d5c2c0e11b3b1b96ca56c6de2a14ec7dab5ccc3b5f300d03e5b4dba44f539"));
        hashMap.put("com.huawei.hwid.tv", Arrays.asList("3517262215d8d3008cbf888750b6418edc4d562ac33ed6874e0d73aba667bc3c"));
    }

    public static String B(Context context, String str) {
        byte[] F = F(context, str);
        if (F == null || F.length == 0) {
            return null;
        }
        return u.Code(aq.Code(F));
    }

    public static boolean C(Context context, String str) {
        return Code(V.get(str), B(context, str));
    }

    public static boolean Code() {
        return Build.VERSION.SDK_INT <= 29 || !V();
    }

    public static boolean Code(Context context) {
        return !TextUtils.isEmpty(V(context));
    }

    public static boolean Code(Context context, String str) {
        return V(context, str) != null;
    }

    public static boolean Code(Context context, String str, String str2) {
        String str3;
        Intent V2;
        gl.V(Code, "openApp intent");
        try {
            if (context.getPackageManager() == null || (V2 = V(context, str2, str)) == null) {
                return false;
            }
            if (!(context instanceof Activity)) {
                V2.addFlags(268435456);
            }
            V2.setClipData(com.huawei.openalliance.ad.constant.u.cG);
            context.startActivity(V2);
            return true;
        } catch (ActivityNotFoundException unused) {
            str3 = "activity not exist";
            gl.I(Code, str3);
            return false;
        } catch (Exception unused2) {
            str3 = "handle intent url fail";
            gl.I(Code, str3);
            return false;
        }
    }

    private static boolean Code(Intent intent, String str) {
        ComponentName component;
        if (intent == null || TextUtils.isEmpty(str) || (component = intent.getComponent()) == null) {
            return true;
        }
        String packageName = component.getPackageName();
        return TextUtils.isEmpty(packageName) || str.equalsIgnoreCase(packageName);
    }

    public static boolean Code(String str) {
        return "com.huawei.hwid".equals(str) || "com.huawei.hms".equals(str) || "com.huawei.hwid.tv".equals(str);
    }

    private static boolean Code(List<ResolveInfo> list) {
        if (aa.Code(list)) {
            return false;
        }
        boolean z10 = true;
        Iterator<ResolveInfo> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (!iterator2.next().activityInfo.exported) {
                z10 = false;
            }
        }
        return z10;
    }

    private static boolean Code(List<String> list, String str) {
        if (list != null && !TextUtils.isEmpty(str)) {
            Iterator<String> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (str.equalsIgnoreCase(iterator2.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static byte[] F(Context context, String str) {
        String str2;
        PackageInfo packageInfo;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr.length > 0) {
                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(signatureArr[0].toByteArray());
                        try {
                            byte[] encoded = CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f29912b).generateCertificate(byteArrayInputStream2).getEncoded();
                            at.Code((Closeable) byteArrayInputStream2);
                            return encoded;
                        } catch (RuntimeException e2) {
                            e = e2;
                            byteArrayInputStream = byteArrayInputStream2;
                            str2 = "getPackageSignatureBytes RuntimeException:" + e.getClass().getSimpleName();
                            gl.Z(Code, str2);
                            at.Code((Closeable) byteArrayInputStream);
                            gl.V(Code, "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        } catch (Exception e10) {
                            e = e10;
                            byteArrayInputStream = byteArrayInputStream2;
                            str2 = "getPackageSignatureBytes Exception:" + e.getClass().getSimpleName();
                            gl.Z(Code, str2);
                            at.Code((Closeable) byteArrayInputStream);
                            gl.V(Code, "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        } catch (Throwable th) {
                            th = th;
                            byteArrayInputStream = byteArrayInputStream2;
                            at.Code((Closeable) byteArrayInputStream);
                            throw th;
                        }
                    }
                }
            } catch (RuntimeException e11) {
                e = e11;
            } catch (Exception e12) {
                e = e12;
            }
            at.Code((Closeable) byteArrayInputStream);
            gl.V(Code, "Failed to get application signature certificate fingerprint.");
            return new byte[0];
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String I(Context context) {
        return Code(context, "com.huawei.hwid") ? "com.huawei.hwid" : Code(context, "com.huawei.hms") ? "com.huawei.hms" : Code(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    public static boolean I(Context context, String str) {
        Intent launchIntentForPackage;
        gl.V(Code, "open app main page");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (launchIntentForPackage = packageManager.getLaunchIntentForPackage(str)) == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            launchIntentForPackage.addFlags(268435456);
        }
        launchIntentForPackage.setPackage(str);
        launchIntentForPackage.setClipData(com.huawei.openalliance.ad.constant.u.cG);
        context.startActivity(launchIntentForPackage);
        return true;
    }

    public static ApplicationInfo S(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getApplicationInfo(str, 128);
            }
            gl.V(Code, "pm is null");
            return null;
        } catch (Throwable th) {
            gl.I(Code, "getApplicationInfo " + th.getClass().getSimpleName());
            return null;
        }
    }

    public static Intent V(Context context, String str, String str2) {
        String str3;
        PackageManager packageManager;
        try {
            if (!TextUtils.isEmpty(str) && (packageManager = context.getPackageManager()) != null) {
                Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
                if (!Code(parseUri, str2)) {
                    return null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    parseUri.setPackage(str2);
                }
                if (parseUri.getData() != null) {
                    parseUri = parseUri.setDataAndTypeAndNormalize(parseUri.getData(), parseUri.getType());
                }
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(parseUri, 0);
                if (!Code(queryIntentActivities)) {
                    gl.I(Code, "parseAndCheckIntent, activity not exists or not exported.");
                    return null;
                }
                if (!queryIntentActivities.isEmpty() || !Code()) {
                    return parseUri;
                }
            }
        } catch (URISyntaxException unused) {
            str3 = "parseAndCheckIntent, parse uri fail";
            gl.I(Code, str3);
            return null;
        } catch (Exception unused2) {
            str3 = "handle intent url fail";
            gl.I(Code, str3);
            return null;
        }
        return null;
    }

    public static PackageInfo V(Context context, String str) {
        String str2;
        if (gl.Code()) {
            gl.Code(Code, "getPackageInfo, packageName:%s", str);
        }
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "getPackageInfo NameNotFoundException";
            gl.I(Code, str2);
            return null;
        } catch (Exception unused2) {
            str2 = "getPackageInfo Exception";
            gl.I(Code, str2);
            return null;
        }
    }

    public static String V(Context context) {
        String I = I(context);
        if (TextUtils.isEmpty(I)) {
            return null;
        }
        if (Code(V.get(I), B(context, I))) {
            return I;
        }
        return null;
    }

    public static boolean V() {
        try {
            return ((Boolean) Class.forName("com.huawei.openalliance.ad.ppskit.utils.AdsCoreScopeUtil").getMethod("isScopePrime", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            gl.V(Code, "AdsCoreScopeUtil wrapper not found");
            gl.Code(Code, "is prime sdk: %s.", Boolean.FALSE);
            return false;
        }
    }

    public static int Z(Context context, String str) {
        try {
            PackageInfo V2 = V(context, str);
            if (V2 == null) {
                return 0;
            }
            return V2.versionCode;
        } catch (AndroidRuntimeException | Exception unused) {
            gl.I(Code, "getAppVersionCode fail");
            return 0;
        }
    }
}
