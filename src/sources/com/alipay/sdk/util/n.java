package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.data.a;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.openalliance.ad.constant.u;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4750a = "com.alipay.android.app";

    /* renamed from: b, reason: collision with root package name */
    public static final String f4751b = "com.eg.android.AlipayGphone";

    /* renamed from: c, reason: collision with root package name */
    public static final int f4752c = 99;

    /* renamed from: d, reason: collision with root package name */
    public static final int f4753d = 73;

    /* renamed from: f, reason: collision with root package name */
    public static final int f4755f = 125;

    /* renamed from: g, reason: collision with root package name */
    private static final String f4756g = "com.eg.android.AlipayGphoneRC";

    /* renamed from: h, reason: collision with root package name */
    private static final String f4757h = ".alipay.wallet";

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f4754e = {"10.1.5.1013151", "10.1.5.1013148"};

    /* renamed from: i, reason: collision with root package name */
    private static final char[] f4758i = "0123456789ABCDEF".toCharArray();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final PackageInfo f4759a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4760b;

        /* renamed from: c, reason: collision with root package name */
        public final String f4761c;

        public a(PackageInfo packageInfo, int i10, String str) {
            this.f4759a = packageInfo;
            this.f4760b = i10;
            this.f4761c = str;
        }

        public boolean a() {
            Signature[] signatureArr = this.f4759a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                String a10 = n.a(signature.toByteArray());
                if (a10 != null && !TextUtils.equals(a10, this.f4761c)) {
                    com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.f4451u, String.format("Got %s, expected %s", a10, this.f4761c));
                    return true;
                }
            }
            return false;
        }

        public boolean b() {
            return this.f4759a.versionCode < this.f4760b;
        }
    }

    public static String a() {
        if (EnvUtils.isSandBox()) {
            return f4756g;
        }
        try {
            return com.alipay.sdk.app.i.f4411a.get(0).f4587a;
        } catch (Throwable unused) {
            return f4751b;
        }
    }

    public static Map<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf("=", 1);
            if (-1 != indexOf) {
                hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
            }
        }
        return hashMap;
    }

    public static Map<String, String> c(String str) {
        HashMap hashMap = new HashMap(4);
        int indexOf = str.indexOf(63);
        if (indexOf != -1 && indexOf < str.length() - 1) {
            for (String str2 : str.substring(indexOf + 1).split("&")) {
                int indexOf2 = str2.indexOf(61, 1);
                if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                    hashMap.put(str2.substring(0, indexOf2), e(str2.substring(indexOf2 + 1)));
                }
            }
        }
        return hashMap;
    }

    public static JSONObject d(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static String e(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.f4449s, e2);
            return "";
        }
    }

    public static DisplayMetrics f(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String g(Context context) {
        String a10 = m.a(context);
        return a10.substring(0, a10.indexOf("://"));
    }

    public static String h(Context context) {
        return "-1;-1";
    }

    public static String i(Context context) {
        return b(context, context.getPackageName());
    }

    public static int j(Context context) {
        return c(context, context.getPackageName());
    }

    public static String a(String str) {
        return (EnvUtils.isSandBox() && TextUtils.equals(str, f4756g)) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
    }

    private static PackageInfo d(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    public static String e(Context context) {
        DisplayMetrics f10 = f(context);
        return f10.widthPixels + StringUtils.NO_PRINT_CODE + f10.heightPixels;
    }

    public static String a(String str, String str2, String str3) {
        try {
            int indexOf = str3.indexOf(str) + str.length();
            if (indexOf <= str.length()) {
                return "";
            }
            int indexOf2 = TextUtils.isEmpty(str2) ? 0 : str3.indexOf(str2, indexOf);
            if (indexOf2 < 1) {
                return str3.substring(indexOf);
            }
            return str3.substring(indexOf, indexOf2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
                if (!matcher.matches() || matcher.groupCount() < 4) {
                    return "Unavailable";
                }
                return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static boolean f(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    private static boolean b(PackageInfo packageInfo) {
        String str = "";
        boolean z10 = false;
        if (packageInfo == null) {
            str = "info == null";
        } else {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = "info.signatures.length <= 0";
            } else {
                z10 = true;
            }
        }
        if (!z10) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4434d, com.alipay.sdk.app.statistic.c.f4443m, str);
        }
        return z10;
    }

    public static String a(byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f29912b).generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e2) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4434d, com.alipay.sdk.app.statistic.c.f4445o, e2);
            return null;
        }
    }

    public static String c(Context context) {
        return " (" + b() + ";" + c() + ";" + d(context) + ";;" + e(context) + ")(sdk android)";
    }

    public static boolean b(Context context, List<a.C0096a> list) {
        try {
            for (a.C0096a c0096a : list) {
                if (c0096a != null) {
                    String str = c0096a.f4587a;
                    if (EnvUtils.isSandBox() && f4751b.equals(str)) {
                        str = f4756g;
                    }
                    try {
                        if (context.getPackageManager().getPackageInfo(str, 128) != null) {
                            return true;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.I, th);
            return false;
        }
    }

    public static String d(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static a a(Context context, List<a.C0096a> list) {
        a a10;
        if (list == null) {
            return null;
        }
        for (a.C0096a c0096a : list) {
            if (c0096a != null && (a10 = a(context, c0096a.f4587a, c0096a.f4588b, c0096a.f4589c)) != null && !a10.a() && !a10.b()) {
                return a10;
            }
        }
        return null;
    }

    public static boolean b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a(), 128);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode < 99;
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static String c() {
        String d10 = d();
        int indexOf = d10.indexOf("-");
        if (indexOf != -1) {
            d10 = d10.substring(0, indexOf);
        }
        int indexOf2 = d10.indexOf("\n");
        if (indexOf2 != -1) {
            d10 = d10.substring(0, indexOf2);
        }
        return "Linux " + d10;
    }

    private static a a(Context context, String str, int i10, String str2) {
        PackageInfo packageInfo;
        if (EnvUtils.isSandBox() && f4751b.equals(str)) {
            str = f4756g;
        }
        try {
            packageInfo = d(context, str);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4434d, com.alipay.sdk.app.statistic.c.f4442l, th);
            packageInfo = null;
        }
        if (b(packageInfo)) {
            return a(packageInfo, i10, str2);
        }
        return null;
    }

    public static String b() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.f4442l, th);
            return "";
        }
    }

    private static a a(PackageInfo packageInfo, int i10, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new a(packageInfo, i10, str);
    }

    private static boolean c(PackageInfo packageInfo) {
        int i10 = packageInfo.applicationInfo.flags;
        return (i10 & 1) == 0 && (i10 & 128) == 0;
    }

    public static boolean a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f4750a, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static int c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionCode;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.f4442l, th);
            return -1;
        }
    }

    private static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) - 1);
        int length = bArr.length - 1;
        for (int i10 = 0; i10 <= length; i10++) {
            byte b4 = bArr[i10];
            char[] cArr = f4758i;
            stringBuffer.append(cArr[(b4 & 240) >> 4]);
            stringBuffer.append(cArr[b4 & 15]);
            if (i10 < length) {
                stringBuffer.append(ShortcutConstants.SERVICES_SEPARATOR);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            String[] strArr = f4754e;
            if (!TextUtils.equals(str, strArr[0])) {
                if (!TextUtils.equals(str, strArr[1])) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static WebView a(Activity activity, String str, String str2) {
        Context applicationContext = activity.getApplicationContext();
        if (!TextUtils.isEmpty(str2)) {
            CookieSyncManager.createInstance(applicationContext).sync();
            CookieManager.getInstance().setCookie(str, str2);
            CookieSyncManager.getInstance().sync();
        }
        LinearLayout linearLayout = new LinearLayout(applicationContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        activity.setContentView(linearLayout, layoutParams);
        WebView webView = new WebView(applicationContext);
        layoutParams.weight = 1.0f;
        webView.setVisibility(0);
        linearLayout.addView(webView, layoutParams);
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + c(applicationContext));
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowContentAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        webView.setVerticalScrollbarOverlay(true);
        webView.setDownloadListener(new o(applicationContext));
        try {
            Method method = webView.getSettings().getClass().getMethod("setDomStorageEnabled", Boolean.TYPE);
            if (method != null) {
                method.invoke(webView.getSettings(), Boolean.TRUE);
            }
        } catch (Exception unused) {
        }
        try {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused2) {
                webView.getSettings().setCacheMode(2);
                webView.loadUrl(str);
                return webView;
            }
        } catch (Throwable unused3) {
            Method method2 = webView.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (method2 != null) {
                method2.invoke(webView, "searchBoxJavaBridge_");
                method2.invoke(webView, "accessibility");
                method2.invoke(webView, "accessibilityTraversal");
            }
            webView.getSettings().setCacheMode(2);
            webView.loadUrl(str);
            return webView;
        }
    }

    public static String a(int i10) {
        Random random = new Random();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                sb2.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
            } else if (nextInt == 1) {
                sb2.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
            } else if (nextInt == 2) {
                sb2.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb2.toString();
    }

    public static String a(Context context, String str) {
        String str2 = "";
        try {
            String str3 = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    str3 = str3 + "#M";
                } else {
                    if (runningAppProcessInfo.processName.startsWith(str + u.bD)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str3);
                        sb2.append("#");
                        sb2.append(runningAppProcessInfo.processName.replace(str + u.bD, ""));
                        str3 = sb2.toString();
                    }
                }
            }
            str2 = str3;
        } catch (Throwable unused) {
        }
        if (str2.length() > 0) {
            str2 = str2.substring(1);
        }
        return str2.length() == 0 ? "N" : str2;
    }

    public static boolean a(WebView webView, String str, @Nullable Activity activity) {
        int parseInt;
        String substring;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (!str.toLowerCase().startsWith(com.alipay.sdk.cons.a.f4527j.toLowerCase()) && !str.toLowerCase().startsWith(com.alipay.sdk.cons.a.f4528k.toLowerCase())) {
            if (!TextUtils.equals(str, com.alipay.sdk.cons.a.f4530m) && !TextUtils.equals(str, com.alipay.sdk.cons.a.f4531n)) {
                if (!str.startsWith(com.alipay.sdk.cons.a.f4529l)) {
                    return false;
                }
                try {
                    String substring2 = str.substring(str.indexOf(com.alipay.sdk.cons.a.f4529l) + 24);
                    parseInt = Integer.parseInt(substring2.substring(substring2.lastIndexOf(com.alipay.sdk.cons.a.f4532o) + 10));
                } catch (Exception unused) {
                    com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.e());
                }
                if (parseInt != com.alipay.sdk.app.k.SUCCEEDED.a() && parseInt != com.alipay.sdk.app.k.PAY_WAITTING.a()) {
                    com.alipay.sdk.app.k b4 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.FAILED.a());
                    com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b4.a(), b4.b(), ""));
                    activity.runOnUiThread(new p(activity));
                    return true;
                }
                if (com.alipay.sdk.cons.a.f4536s) {
                    StringBuilder sb2 = new StringBuilder();
                    String decode = URLDecoder.decode(str);
                    String decode2 = URLDecoder.decode(decode);
                    String str2 = decode2.substring(decode2.indexOf(com.alipay.sdk.cons.a.f4529l) + 24, decode2.lastIndexOf(com.alipay.sdk.cons.a.f4532o)).split(com.alipay.sdk.cons.a.f4534q)[0];
                    int indexOf = decode.indexOf(com.alipay.sdk.cons.a.f4534q) + 12;
                    sb2.append(str2);
                    sb2.append(com.alipay.sdk.cons.a.f4534q);
                    sb2.append(decode.substring(indexOf, decode.indexOf("&", indexOf)));
                    sb2.append(decode.substring(decode.indexOf("&", indexOf)));
                    substring = sb2.toString();
                } else {
                    String decode3 = URLDecoder.decode(str);
                    substring = decode3.substring(decode3.indexOf(com.alipay.sdk.cons.a.f4529l) + 24, decode3.lastIndexOf(com.alipay.sdk.cons.a.f4532o));
                }
                com.alipay.sdk.app.k b10 = com.alipay.sdk.app.k.b(parseInt);
                com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b10.a(), b10.b(), substring));
                activity.runOnUiThread(new p(activity));
                return true;
            }
            com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
            activity.finish();
            return true;
        }
        try {
            a a10 = a(activity, com.alipay.sdk.app.i.f4411a);
            if (a10 != null && !a10.b() && !a10.a()) {
                if (str.startsWith("intent://platformapi/startapp")) {
                    str = str.replaceFirst("intent://platformapi/startapp\\?", com.alipay.sdk.cons.a.f4527j);
                }
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        } catch (Throwable unused2) {
        }
        return true;
    }

    public static String a(Signature signature) {
        try {
            return b(MessageDigest.getInstance("SHA-256").digest(signature.toByteArray()));
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.D, th);
            return "";
        }
    }
}
