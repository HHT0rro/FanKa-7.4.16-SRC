package com.autonavi.aps.amapapi.utils;

import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.fm;
import com.amap.api.col.p0003l.fn;
import com.amap.api.col.p0003l.fv;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.hailiang.advlib.core.ADEvent;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Utils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static WifiManager f9674a;

    /* renamed from: b, reason: collision with root package name */
    private static int f9675b;

    /* renamed from: c, reason: collision with root package name */
    private static String[] f9676c;

    /* renamed from: d, reason: collision with root package name */
    private static String f9677d;

    public static float a(float f10) {
        return (float) (((long) (f10 * 100.0d)) / 100.0d);
    }

    public static String a(int i10) {
        if (i10 == 33) {
            return "补偿定位失败，未命中缓存";
        }
        switch (i10) {
            case 0:
                return "success";
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case 8:
                return "其他错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case 12:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
            default:
                switch (i10) {
                    case 18:
                        return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
                    case 19:
                        return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
                    case 20:
                        return "模糊定位失败，具体可查看错误信息/详细信息描述";
                    default:
                        return "其他错误";
                }
        }
    }

    public static boolean a(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar == null || "8".equals(aVar.d()) || "5".equals(aVar.d()) || "6".equals(aVar.d())) {
            return false;
        }
        return b(aVar);
    }

    public static double b(double d10) {
        return ((long) (d10 * 1000000.0d)) / 1000000.0d;
    }

    public static boolean b(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == ShadowDrawableWrapper.COS_45 && latitude == ShadowDrawableWrapper.COS_45) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    public static double c(double d10) {
        return ((long) (d10 * 100.0d)) / 100.0d;
    }

    public static int c() {
        int i10 = f9675b;
        if (i10 > 0) {
            return i10;
        }
        try {
            try {
                return f.b("android.os.Build$VERSION", "SDK_INT");
            } catch (Throwable unused) {
                return Integer.parseInt(f.a("android.os.Build$VERSION", "SDK").toString());
            }
        } catch (Throwable unused2) {
            return 0;
        }
    }

    private static boolean d(Context context, String str) throws Throwable {
        return ((Integer) f.a(str, "getInt", new Object[]{context.getContentResolver(), ((String) f.a(str, "AIRPLANE_MODE_ON")).toString()}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static String e() {
        try {
            return fn.b("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean f(Context context) {
        int i10;
        if (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
            return true;
        }
        try {
            i10 = f.b(((Application) context).getBaseContext(), "checkSelfPermission", com.autonavi.aps.amapapi.b.E);
        } catch (Throwable unused) {
            i10 = 0;
        }
        return i10 == 0;
    }

    public static boolean g(Context context) {
        boolean z10;
        if (context == null) {
            return true;
        }
        if (f9674a == null) {
            f9674a = (WifiManager) a(context, "wifi");
        }
        try {
            if (c(context, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                z10 = f9674a.isWifiEnabled();
            } else {
                b.a(new Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");
                z10 = false;
            }
            try {
                d.b();
            } catch (Throwable unused) {
                d.c();
                return z10 ? z10 : z10;
            }
        } catch (Throwable unused2) {
            z10 = false;
        }
        if (z10 && c() > 17) {
            try {
                return "true".equals(String.valueOf(f.a(f9674a, "isScanAlwaysAvailable", new Object[0])));
            } catch (Throwable unused3) {
                return z10;
            }
        }
    }

    public static String h(Context context) {
        NetworkInfo c4 = c(context);
        if (c4 == null || !c4.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = c4.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type != 0) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        String subtypeName = c4.getSubtypeName();
        switch (c4.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
                return "4G";
            default:
                if (!"GSM".equalsIgnoreCase(subtypeName)) {
                    return ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) ? "3G" : subtypeName;
                }
                break;
        }
        return "2G";
    }

    public static String i(Context context) {
        String h10 = fm.h();
        if (TextUtils.isEmpty(h10) || h10.equals("00:00:00:00:00:00")) {
            h10 = i.a(context);
        }
        return TextUtils.isEmpty(h10) ? "00:00:00:00:00:00" : h10;
    }

    public static boolean j(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static boolean k(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }

    public static String l(Context context) {
        if (f9677d == null) {
            f9677d = com.autonavi.aps.amapapi.security.a.a("MD5", fj.c(context));
        }
        return f9677d;
    }

    public static boolean m(Context context) {
        try {
            if (!p(context) && !o(context)) {
                if (!n(context)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    private static boolean n(Context context) {
        return h("huawei") && q(context) && s(context);
    }

    private static boolean o(Context context) {
        return h(ADEvent.VIVO) && q(context) && r(context);
    }

    private static boolean p(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 31 || context == null || context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36121g) == 0) {
                return false;
            }
            return context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36122h) == 0;
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    private static boolean q(Context context) {
        try {
            int i10 = Build.VERSION.SDK_INT;
            int i11 = context.getApplicationInfo().targetSdkVersion;
            return ((i10 == 30) && (i11 >= 23)) || ((i10 == 31) && (i11 <= 30 && i11 >= 23));
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    private static boolean r(Context context) {
        Cursor cursor;
        boolean z10 = false;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, "package_name=?", new String[]{context.getPackageName()}, null);
            boolean z11 = false;
            while (cursor != null) {
                try {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    if (cursor.getString(0) != null && cursor.getInt(1) == 1) {
                        z11 = true;
                    }
                } catch (Throwable unused) {
                    z10 = z11;
                    try {
                        d.b();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return z10;
                    } catch (Throwable unused2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return z10;
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return z11;
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    private static boolean s(Context context) {
        try {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (context == null || context.checkSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") != 0) {
                        return false;
                    }
                } else if (context == null || context.checkCallingOrSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") != 0) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                d.b();
                return false;
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(b.f9641j)) {
            return b.f9641j;
        }
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(fj.c(context), 64);
        } catch (Throwable th) {
            b.a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(b.f9642k)) {
                b.f9642k = null;
            }
        } catch (Throwable th2) {
            b.a(th2, "Utils", "getAppName");
        }
        StringBuilder sb2 = new StringBuilder();
        if (packageInfo != null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            CharSequence loadLabel = applicationInfo != null ? applicationInfo.loadLabel(context.getPackageManager()) : null;
            if (loadLabel != null) {
                sb2.append(loadLabel.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb2.append(packageInfo.versionName);
            }
        }
        String c4 = fj.c(context);
        if (!TextUtils.isEmpty(c4)) {
            sb2.append(",");
            sb2.append(c4);
        }
        if (!TextUtils.isEmpty(b.f9642k)) {
            sb2.append(",");
            sb2.append(b.f9642k);
        }
        String sb3 = sb2.toString();
        b.f9641j = sb3;
        return sb3;
    }

    public static boolean e(Context context) {
        int i10;
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            Application application = (Application) context;
            for (String str : com.autonavi.aps.amapapi.b.D) {
                try {
                    i10 = f.b(application.getBaseContext(), "checkSelfPermission", str);
                } catch (Throwable unused) {
                    i10 = 0;
                }
                if (i10 == 0) {
                }
            }
            return true;
        }
        for (String str2 : com.autonavi.aps.amapapi.b.D) {
            if (context.checkCallingOrSelfPermission(str2) == 0) {
            }
        }
        return true;
        return false;
    }

    public static boolean a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return b(aMapLocation);
        }
        return false;
    }

    public static NetworkInfo c(Context context) {
        try {
            return fm.k(context);
        } catch (Throwable th) {
            b.a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    public static int f(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    public static String[] a(TelephonyManager telephonyManager) {
        int i10;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i11 = 0;
            while (i11 < charArray.length && Character.isDigit(charArray[i11])) {
                i11++;
            }
            strArr2[1] = networkOperator.substring(3, i11 + 3);
        }
        try {
            i10 = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            b.a(th, "Utils", "getMccMnc");
            i10 = 0;
        }
        if (i10 == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return ("0".equals(strArr2[0]) && "0".equals(strArr2[1]) && (strArr = f9676c) != null) ? strArr : strArr2;
        }
        f9676c = strArr2;
        return strArr2;
    }

    public static double c(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    private static FileOutputStream c(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.canWrite()) {
                    throw new IOException("File '" + ((Object) file) + "' cannot be written to");
                }
            } else {
                throw new IOException("File '" + ((Object) file) + "' exists but is a directory");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IOException("Directory '" + ((Object) parentFile) + "' could not be created");
                }
                file.createNewFile();
            }
        }
        return new FileOutputStream(file, false);
    }

    public static int d() {
        return new Random().nextInt(65536) - 32768;
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo c4 = c(context);
            if (c4 != null) {
                if (c4.isConnectedOrConnecting()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean h(String str) {
        try {
            String str2 = Build.MANUFACTURER;
            String str3 = Build.BRAND;
            if (!str2.equalsIgnoreCase(str)) {
                if (!str3.toLowerCase().contains(str)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    public static float d(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static byte g(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    public static int e(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static boolean c(Context context, String str) {
        boolean z10 = false;
        try {
            if (Build.VERSION.SDK_INT < 23 ? !(context == null || context.checkCallingOrSelfPermission(fv.c(str)) != 0) : !(context == null || context.checkSelfPermission(fv.c(str)) != 0)) {
                z10 = true;
            }
        } catch (Throwable unused) {
            d.b();
        }
        return z10;
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (c() < 17) {
                return d(context, "android.provider.Settings$System");
            }
            return d(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte[] b(int i10, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr[i11] = (byte) ((i10 >> (i11 * 8)) & 255);
        }
        return bArr;
    }

    public static float a(double[] dArr) {
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static int b(byte[] bArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 2; i11++) {
            i10 |= (bArr[i11] & 255) << ((1 - i11) * 8);
        }
        return i10;
    }

    public static float a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static ArrayList<String> b(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("#");
            for (int i10 = 0; i10 < split.length; i10++) {
                if (split[i10].contains(",nb") || split[i10].contains(",access")) {
                    arrayList.add(split[i10]);
                }
            }
        }
        return arrayList;
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        return a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private static FileInputStream b(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return new FileInputStream(file);
                }
                throw new IOException("File '" + ((Object) file) + "' cannot be read");
            }
            throw new IOException("File '" + ((Object) file) + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + ((Object) file) + "' does not exist");
    }

    public static Object a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            b.a(th, "Utils", "getServ");
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        return fv.b(bArr);
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return fv.a(jSONObject, str);
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || "00:00:00:00:00:00".equals(str) || "02:00:00:00:00:00".equals(str) || str.contains(" :")) ? false : true;
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static String a(ConnectivityManager connectivityManager) {
        int i10 = 0;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    i10 = activeNetworkInfo.getSubtype();
                }
            } catch (Throwable unused) {
            }
        }
        switch (i10) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    public static byte[] a(long j10) {
        byte[] bArr = new byte[8];
        for (int i10 = 0; i10 < 8; i10++) {
            bArr[i10] = (byte) ((j10 >> (i10 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] a(int i10, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i10 & 255);
        bArr[1] = (byte) ((i10 & 65280) >> 8);
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(long r4, java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L8
            java.lang.String r6 = "yyyy-MM-dd HH:mm:ss"
        L8:
            r0 = 0
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> L17
            java.util.Locale r2 = java.util.Locale.CHINA     // Catch: java.lang.Throwable -> L17
            r1.<init>(r6, r2)     // Catch: java.lang.Throwable -> L17
            r1.applyPattern(r6)     // Catch: java.lang.Throwable -> L14
            goto L20
        L14:
            r6 = move-exception
            r0 = r1
            goto L18
        L17:
            r6 = move-exception
        L18:
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "formatUTC"
            com.autonavi.aps.amapapi.utils.b.a(r6, r1, r2)
            r1 = r0
        L20:
            r2 = 0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 > 0) goto L2a
            long r4 = a()
        L2a:
            if (r1 != 0) goto L2f
            java.lang.String r4 = "NULL"
            return r4
        L2f:
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = r1.format(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.j.a(long, java.lang.String):java.lang.String");
    }

    public static double a(double d10) {
        return b(d10);
    }

    public static boolean a(Location location, int i10) {
        boolean z10;
        Bundle extras;
        try {
            z10 = location.isFromMockProvider();
        } catch (Throwable unused) {
            z10 = false;
        }
        if (z10) {
            return true;
        }
        try {
            extras = location.getExtras();
        } catch (Throwable unused2) {
        }
        if ((extras != null ? extras.getInt("satellites") : 0) <= 0) {
            return true;
        }
        if (i10 == 0 && location.getAltitude() == ShadowDrawableWrapper.COS_45 && location.getBearing() == 0.0f) {
            if (location.getSpeed() == 0.0f) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = "2.0.201501131131".replace(".", "");
        Cursor cursor = null;
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    cursor = sQLiteDatabase.query("sqlite_master", new String[]{"count(*) as c"}, "type = 'table' AND name = '" + str.trim() + replace + "'", null, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        if (cursor.getInt(0) > 0) {
                            z10 = true;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return z10;
                }
            } catch (Throwable unused) {
                if (cursor == null) {
                    return true;
                }
                cursor.close();
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList<String> b4 = b(str);
            String[] split = str2.toString().split("#");
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < split.length; i12++) {
                if (split[i12].contains(",nb") || split[i12].contains(",access")) {
                    i10++;
                    if (b4.contains(split[i12])) {
                        i11++;
                    }
                }
            }
            if (i11 * 2 >= (b4.size() + i10) * 0.618d) {
                return true;
            }
        }
        return false;
    }

    public static List<String> a(File file) {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = b(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, Charset.defaultCharset());
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                arrayList.add(readLine);
                            } catch (Throwable unused) {
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return arrayList;
                            }
                        }
                        bufferedReader2.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    inputStreamReader = null;
                }
            } catch (Throwable unused4) {
                fileInputStream = null;
                inputStreamReader = null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public static void a(File file, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = c(file);
                if (str != null) {
                    fileOutputStream.write(str.getBytes());
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
        }
    }
}
