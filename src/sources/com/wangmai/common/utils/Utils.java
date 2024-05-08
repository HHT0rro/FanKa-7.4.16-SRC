package com.wangmai.common.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.openalliance.ad.constant.u;
import com.kuaishou.weapon.p0.g;
import com.wangmai.aliagainstcheatingId.AliAgainstId;
import com.wangmai.common.utils.HandlerUtil;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.StringCallback;
import com.wangmai.okhttp.model.Response;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Utils {
    public static final String EMPTY_STRING = "";
    public static final String TAG = "WM_Utils";
    public static final String TRACK_EVENT_TYPE_APP_STATE = "SDK_DP_APP_STATE";
    public static final String TRACK_EVENT_TYPE_DP_CALLBACK = "SDK_DP_CALLBACK";
    public static final String TRACK_EVENT_TYPE_DP_RETRY_FAILED = "SDK_DP_RETRY_FAILED";
    public static final String TRACK_EVENT_TYPE_DP_RETRY_SUCCESS = "SDK_DP_RETRY_SUCCESS";
    public static String UA = "";
    public static int intervalTime = 0;
    public static boolean isReportInFront = false;
    public static boolean isSwitchBackground = false;
    public static String operatorValue = "";
    public static final String replaceConfig = "(?i)__CONFIG__";
    public static final String replaceEventType = "(?i)__EVENTTYPE__";
    public static final String replaceSubType = "(?i)__SUBTYPE__";
    public static final long trackMinDuration = 1000;

    public static String GetApkInfoPackageName(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            return packageArchiveInfo != null ? packageArchiveInfo.applicationInfo.packageName : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean checkAppInstalled(Context context, String str) {
        PackageInfo packageInfo;
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static String concatString(Object... objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : objArr) {
            stringBuffer.append(obj);
        }
        return stringBuffer.toString();
    }

    public static int dip2px(Context context, float f10) {
        if (getDensity(context) <= 0.0f) {
            DebugLog.release_e(TAG, "dip2px scale <= 0");
        } else {
            f10 = (f10 * getDensity(context)) + 0.5f;
        }
        return (int) f10;
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof NinePatchDrawable)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static void executeRetryOpenByDeepLink(Context context, String str, String str2, List<String> list) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(32768);
            if (str.startsWith("tbopen://")) {
                intent.addFlags(536870912);
            }
            intent.addFlags(268435456);
            PendingIntent.getActivity(context, 0, intent, 0).send();
            reportRetryOpenByDeeplinkResult(true, str2, list);
        } catch (Throwable th) {
            DebugLog.W(TAG, "pendingIntent send error:" + th.toString());
            reportRetryOpenByDeeplinkResult(false, str2, list);
        }
    }

    public static void executeTrackReport(String str) {
        OkHttp.get(str).execute(new StringCallback() { // from class: com.wangmai.common.utils.Utils.4
            @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
            public void onError(Response<String> response) {
                super.onError(response);
                DebugLog.W(Utils.TAG, "track report error :" + response.getException().toString());
            }

            @Override // com.wangmai.okhttp.callback.Callback
            public void onSuccess(Response<String> response) {
            }
        });
    }

    public static String getAndroidId(Context context) {
        String str = "";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string != null) {
                str = string;
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, "fillAndroidId error:" + th.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            DebugLog.W(TAG, "获取设备AndroidId耗时：" + currentTimeMillis2 + " ms");
        }
        return str;
    }

    public static Drawable getApkInfoIcon(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (OutOfMemoryError unused) {
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getAppName(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1);
        if (packageArchiveInfo == null) {
            return "";
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(packageManager).toString();
        } catch (OutOfMemoryError unused) {
            return "";
        }
    }

    public static String getBootMark() {
        try {
            return AliAgainstId.getBoot();
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "get bootId error:" + th.toString());
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0076, code lost:
    
        if (r9 == 1) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
    
        if (r9 == 2) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007a, code lost:
    
        if (r9 == 3) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
    
        if (r9 == 4) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
    
        if (com.wangmai.common.utils.ConstantInfo.isCanUsePhoneState() == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008b, code lost:
    
        if (com.wangmai.common.utils.PermissionUtils.checkPermission(r13, com.kuaishou.weapon.p0.g.f36117c) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008d, code lost:
    
        r13 = ((android.telephony.TelephonyManager) r13.getSystemService("phone")).getNetworkType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009b, code lost:
    
        if (r13 == 20) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009d, code lost:
    
        switch(r13) {
            case 1: goto L50;
            case 2: goto L50;
            case 3: goto L49;
            case 4: goto L50;
            case 5: goto L49;
            case 6: goto L49;
            case 7: goto L50;
            case 8: goto L49;
            case 9: goto L49;
            case 10: goto L49;
            case 11: goto L50;
            case 12: goto L49;
            case 13: goto L57;
            case 14: goto L49;
            case 15: goto L49;
            case 16: goto L50;
            default: goto L48;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
    
        r3 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a5, code lost:
    
        com.wangmai.common.utils.DebugLog.W(com.wangmai.common.utils.Utils.TAG, "fillNetworkInfo error: canUsePhoneState is false");
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getConnectType(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.common.utils.Utils.getConnectType(android.content.Context):int");
    }

    public static float getDensity(Context context) {
        try {
            return context.getResources().getDisplayMetrics().density;
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "getDensity error:" + th.toString());
            return 0.0f;
        }
    }

    public static int getDeviceType(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? 2 : 1;
        } catch (Throwable th) {
            DebugLog.W(TAG, "getDeviceType error:" + th.toString());
            return 0;
        }
    }

    public static List<String> getFilesAllName(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }

    public static String getFingerprint() {
        return Build.FINGERPRINT;
    }

    public static String getIMSI(Context context) {
        String str = "";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            if (subscriberId != null) {
                str = subscriberId;
            }
        } catch (Throwable unused) {
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            DebugLog.W(TAG, "获取IMSI耗时：" + currentTimeMillis2 + " ms");
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getMEID(android.content.Context r6) {
        /*
            java.lang.String r0 = "WM_Utils"
            java.lang.String r1 = ""
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = "phone"
            java.lang.Object r4 = r6.getSystemService(r4)     // Catch: java.lang.Throwable -> L30
            android.telephony.TelephonyManager r4 = (android.telephony.TelephonyManager) r4     // Catch: java.lang.Throwable -> L30
            java.lang.String r4 = r4.getDeviceId()     // Catch: java.lang.Throwable -> L30
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L2d
            if (r5 == 0) goto L28
            android.content.Context r6 = r6.getApplicationContext()     // Catch: java.lang.Throwable -> L2d
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Throwable -> L2d
            java.lang.String r5 = "android_id"
            java.lang.String r4 = android.provider.Settings.Secure.getString(r6, r5)     // Catch: java.lang.Throwable -> L2d
        L28:
            if (r4 != 0) goto L2b
            goto L49
        L2b:
            r1 = r4
            goto L49
        L2d:
            r6 = move-exception
            r1 = r4
            goto L31
        L30:
            r6 = move-exception
        L31:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getMEID error:"
            r4.append(r5)
            java.lang.String r6 = r6.toString()
            r4.append(r6)
            java.lang.String r6 = r4.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r6)
        L49:
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            r2 = 10
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L6d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "获取MEID耗时："
            r6.append(r2)
            r6.append(r4)
            java.lang.String r2 = " ms"
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r6)
        L6d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.common.utils.Utils.getMEID(android.content.Context):java.lang.String");
    }

    public static String getMacAddress(Context context) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (Build.VERSION.SDK_INT < 23) {
                str = getMacAddressByDefault(context);
            } else {
                str = getMacAddressByInterface();
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, "fillMacAddress error:" + th.toString());
            str = "";
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            DebugLog.W(TAG, "获取设备Mac地址耗时：" + currentTimeMillis2 + " ms");
        }
        return TextUtils.isEmpty(str) ? "020000000000" : str;
    }

    public static String getMacAddressByDefault(Context context) {
        WifiManager wifiManager;
        try {
            if (PermissionUtils.checkPermission(context, g.f36118d) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null && wifiManager.getConnectionInfo() != null && wifiManager.getConnectionInfo().getMacAddress() != null) {
                return wifiManager.getConnectionInfo().getMacAddress().replace(u.bD, "").toUpperCase();
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, "getMacAddressByDefault error:" + th.toString());
        }
        return "";
    }

    public static String getMacAddressByInterface() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b4 : hardwareAddress) {
                        sb2.append(String.format("%02X:", Byte.valueOf(b4)));
                    }
                    if (sb2.length() > 0) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    return sb2.toString();
                }
            }
        } catch (Throwable th) {
            DebugLog.W("RequestJson", "getAdressMacByInterface:" + th.toString());
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getMcc(android.content.Context r6) {
        /*
            java.lang.String r0 = "WM_Utils"
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r3 = com.wangmai.common.utils.PermissionUtils.checkPermission(r6, r3)     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L47
            java.lang.String r3 = "phone"
            java.lang.Object r6 = r6.getSystemService(r3)     // Catch: java.lang.Throwable -> L2e
            android.telephony.TelephonyManager r6 = (android.telephony.TelephonyManager) r6     // Catch: java.lang.Throwable -> L2e
            java.lang.String r6 = r6.getSimOperator()     // Catch: java.lang.Throwable -> L2e
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L2e
            if (r3 != 0) goto L47
            int r3 = r6.length()     // Catch: java.lang.Throwable -> L2e
            r4 = 5
            if (r3 < r4) goto L47
            r3 = 0
            r4 = 3
            java.lang.String r6 = r6.substring(r3, r4)     // Catch: java.lang.Throwable -> L2e
            goto L49
        L2e:
            r6 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "fillMcc error:"
            r3.append(r4)
            java.lang.String r6 = r6.toString()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r6)
        L47:
            java.lang.String r6 = ""
        L49:
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            r1 = 10
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto L6d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "获取Mcc耗时："
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r1)
        L6d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.common.utils.Utils.getMcc(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getMnc(android.content.Context r6) {
        /*
            java.lang.String r0 = "WM_Utils"
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r3 = com.wangmai.common.utils.PermissionUtils.checkPermission(r6, r3)     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L46
            java.lang.String r3 = "phone"
            java.lang.Object r6 = r6.getSystemService(r3)     // Catch: java.lang.Throwable -> L2d
            android.telephony.TelephonyManager r6 = (android.telephony.TelephonyManager) r6     // Catch: java.lang.Throwable -> L2d
            java.lang.String r6 = r6.getSimOperator()     // Catch: java.lang.Throwable -> L2d
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L2d
            if (r3 != 0) goto L46
            int r3 = r6.length()     // Catch: java.lang.Throwable -> L2d
            r4 = 5
            if (r3 < r4) goto L46
            r3 = 3
            java.lang.String r6 = r6.substring(r3, r4)     // Catch: java.lang.Throwable -> L2d
            goto L48
        L2d:
            r6 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "fillMnc error:"
            r3.append(r4)
            java.lang.String r6 = r6.toString()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r6)
        L46:
            java.lang.String r6 = ""
        L48:
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            r1 = 10
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto L6c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "获取Mnc耗时："
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r1)
        L6c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.common.utils.Utils.getMnc(android.content.Context):java.lang.String");
    }

    public static String getOperator(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            if (!TextUtils.isEmpty(simOperator) && simOperator.length() > 5) {
                operatorValue = simOperator.substring(0, 5);
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, "getOperator error:" + th.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            DebugLog.W(TAG, "获取移动网络运营商编码耗时：" + currentTimeMillis2 + " ms");
        }
        return operatorValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        if (r6.startsWith("46011") != false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getOperatorType(android.content.Context r6) {
        /*
            java.lang.String r0 = "WM_Utils"
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = com.wangmai.common.utils.Utils.operatorValue     // Catch: java.lang.Throwable -> L7b
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L11
            java.lang.String r6 = com.wangmai.common.utils.Utils.operatorValue     // Catch: java.lang.Throwable -> L7b
            goto L1d
        L11:
            java.lang.String r3 = "phone"
            java.lang.Object r6 = r6.getSystemService(r3)     // Catch: java.lang.Throwable -> L7b
            android.telephony.TelephonyManager r6 = (android.telephony.TelephonyManager) r6     // Catch: java.lang.Throwable -> L7b
            java.lang.String r6 = r6.getSimOperator()     // Catch: java.lang.Throwable -> L7b
        L1d:
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L94
            java.lang.String r3 = "46000"
            boolean r3 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L79
            java.lang.String r3 = "46002"
            boolean r3 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L79
            java.lang.String r3 = "46007"
            boolean r3 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L79
            java.lang.String r3 = "46004"
            boolean r3 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L7b
            if (r3 == 0) goto L44
            goto L79
        L44:
            java.lang.String r3 = "46001"
            boolean r3 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L77
            java.lang.String r3 = "46006"
            boolean r3 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L77
            java.lang.String r3 = "46009"
            boolean r3 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L7b
            if (r3 == 0) goto L5d
            goto L77
        L5d:
            java.lang.String r3 = "46003"
            boolean r3 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L75
            java.lang.String r3 = "46005"
            boolean r3 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L75
            java.lang.String r3 = "46011"
            boolean r6 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L7b
            if (r6 == 0) goto L94
        L75:
            r6 = 2
            goto L96
        L77:
            r6 = 3
            goto L96
        L79:
            r6 = 1
            goto L96
        L7b:
            r6 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getOperatorType error:"
            r3.append(r4)
            java.lang.String r6 = r6.toString()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r6)
        L94:
            r6 = 99
        L96:
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            r1 = 10
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto Lba
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "获取运营商类型耗时："
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r1)
        Lba:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.common.utils.Utils.getOperatorType(android.content.Context):int");
    }

    public static int getOrientation(Context context) {
        try {
        } catch (Throwable th) {
            DebugLog.W(TAG, "getOrientation error:" + th.toString());
        }
        if (context.getResources().getConfiguration().orientation == 2) {
            return 2;
        }
        return context.getResources().getConfiguration().orientation == 1 ? 1 : 0;
    }

    public static String getResolution(Context context, boolean z10) {
        String concatString;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (z10) {
                concatString = concatString(Integer.valueOf(displayMetrics.widthPixels), LanguageTag.PRIVATEUSE, Integer.valueOf(displayMetrics.heightPixels));
            } else {
                int i10 = displayMetrics.widthPixels;
                int i11 = displayMetrics.heightPixels;
                concatString = i10 >= i11 ? concatString(Integer.valueOf(i11), LanguageTag.PRIVATEUSE, Integer.valueOf(displayMetrics.widthPixels)) : concatString(Integer.valueOf(i10), LanguageTag.PRIVATEUSE, Integer.valueOf(displayMetrics.heightPixels));
            }
            return concatString;
        } catch (Throwable th) {
            DebugLog.W(TAG, "getResolution error:" + th.toString());
            return "";
        }
    }

    public static int getScreenBrightness(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String getTimeZone() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable th) {
            DebugLog.W(TAG, "getTimeZone error:" + th.toString());
            return "";
        }
    }

    public static String getUpdateMark() {
        try {
            return AliAgainstId.getUpdate();
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "get updateId error:" + th.toString());
            return "";
        }
    }

    public static String getUserAgent(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        try {
            if (TextUtils.isEmpty(UA)) {
                try {
                    str = WebSettings.getDefaultUserAgent(context);
                } catch (Throwable unused) {
                }
                UA = str;
            } else {
                str = UA;
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "getUserAgent error:" + th.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            DebugLog.D(TAG, "fetch ua cost：" + currentTimeMillis2 + " ms");
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getVersionName(android.content.Context r6) {
        /*
            java.lang.String r0 = "WM_Utils"
            long r1 = java.lang.System.currentTimeMillis()
            android.content.pm.PackageManager r3 = r6.getPackageManager()     // Catch: java.lang.Throwable -> L18
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Throwable -> L18
            r4 = 0
            android.content.pm.PackageInfo r6 = r3.getPackageInfo(r6, r4)     // Catch: java.lang.Throwable -> L18
            if (r6 == 0) goto L31
            java.lang.String r6 = r6.versionName     // Catch: java.lang.Throwable -> L18
            goto L33
        L18:
            r6 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getVersionName error:"
            r3.append(r4)
            java.lang.String r6 = r6.toString()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r6)
        L31:
            java.lang.String r6 = ""
        L33:
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            r1 = 10
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto L57
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "获取应用版本名耗时："
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r1)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.common.utils.Utils.getVersionName(android.content.Context):java.lang.String");
    }

    public static int getWindowHeight(Context context) {
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int getWindowWidth(Context context) {
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable th) {
            DebugLog.release_e("getWindowWidth", th.toString());
            return 0;
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isForeground1(Context context) {
        boolean z10 = false;
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(context.getApplicationInfo().processName)) {
                    z10 = true;
                }
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "isForeground(runningProcess) error:" + th.toString());
        }
        return z10;
    }

    public static boolean isForeground2(Context context) {
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (!runningTasks.isEmpty()) {
                if (runningTasks.get(0).topActivity.getPackageName().equals(context.getPackageName())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, "isForeground(runningTasks) error:" + th.toString());
        }
        return false;
    }

    public static boolean isRunningForeground(Context context) {
        return isForeground1(context);
    }

    public static String md5Decode(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder(digest.length * 2);
            for (byte b4 : digest) {
                int i10 = b4 & 255;
                if (i10 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UnsupportedEncodingException", e2);
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("NoSuchAlgorithmException", e10);
        }
    }

    public static boolean openByDeeplink(Activity activity, String str, int i10, String str2, List<String> list, long j10) {
        return openByDeeplink(activity, str, i10, str2, list, j10);
    }

    public static double parseDouble(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Double.parseDouble(str);
            }
        } catch (Throwable unused) {
        }
        return ShadowDrawableWrapper.COS_45;
    }

    public static int parseInt(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static int px2dip(Context context, float f10) {
        float density = getDensity(context);
        if (density <= 0.0f) {
            DebugLog.release_e(TAG, "px2dip scale <= 0");
        } else {
            f10 = (f10 / density) + 0.5f;
        }
        return (int) f10;
    }

    public static void reportRetryOpenByDeeplinkResult(boolean z10, String str, List<String> list) {
        String replaceAll;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        if (z10 && list.contains(TRACK_EVENT_TYPE_DP_RETRY_SUCCESS)) {
            replaceAll = str.replaceAll(replaceEventType, TRACK_EVENT_TYPE_DP_RETRY_SUCCESS);
        } else if (!list.contains(TRACK_EVENT_TYPE_DP_RETRY_FAILED)) {
            return;
        } else {
            replaceAll = str.replaceAll(replaceEventType, TRACK_EVENT_TYPE_DP_RETRY_FAILED);
        }
        OkHttp.get(replaceAll).execute(new StringCallback() { // from class: com.wangmai.common.utils.Utils.2
            @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
            public void onError(Response<String> response) {
                super.onError(response);
                DebugLog.W(Utils.TAG, "report retry open deepLink error:" + response.getException().toString());
            }

            @Override // com.wangmai.okhttp.callback.Callback
            public void onSuccess(Response<String> response) {
            }
        });
    }

    public static void resetTrackVariable() {
        isSwitchBackground = false;
        isReportInFront = false;
        intervalTime = 0;
    }

    public static void retryOpenByDeepLink(final Context context, final String str, final int i10, final String str2, final List<String> list) {
        if (i10 > 0) {
            ThreadUtils.mMainHandler.postDelayed(new Runnable() { // from class: com.wangmai.common.utils.Utils.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Utils.isRunningForeground(context)) {
                        DebugLog.D(Utils.TAG, "foreground " + i10);
                        Utils.executeRetryOpenByDeepLink(context, str, str2, list);
                    }
                }
            }, i10);
        }
    }

    public static void startAppTrackMonitoring(final Context context, final String str, List<String> list, final long j10) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty() || j10 < 1000) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        HandlerUtil.getInstance().removeMessage();
        resetTrackVariable();
        HandlerUtil.getInstance().sendMessage(1000L, new HandlerUtil.ITick() { // from class: com.wangmai.common.utils.Utils.3
            @Override // com.wangmai.common.utils.HandlerUtil.ITick
            public void onTick() {
                if (System.currentTimeMillis() > currentTimeMillis + j10) {
                    HandlerUtil.getInstance().removeMessage();
                    DebugLog.W(Utils.TAG, "cancel monitoring");
                    return;
                }
                boolean isRunningForeground = Utils.isRunningForeground(context);
                Utils.executeTrackReport(str.replaceAll(Utils.replaceEventType, Utils.TRACK_EVENT_TYPE_APP_STATE).replaceAll(Utils.replaceSubType, String.valueOf(Utils.intervalTime * 1000)).replaceAll(Utils.replaceConfig, isRunningForeground ? "1" : "2"));
                if (isRunningForeground) {
                    if (Utils.isSwitchBackground && !Utils.isReportInFront) {
                        Utils.isReportInFront = true;
                        Utils.executeTrackReport(str.replaceAll(Utils.replaceEventType, Utils.TRACK_EVENT_TYPE_DP_CALLBACK).replaceAll(Utils.replaceConfig, String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                    }
                } else {
                    Utils.isSwitchBackground = true;
                }
                Utils.intervalTime++;
            }
        });
    }

    public static boolean openByDeeplink(Context context, String str, int i10, String str2, List<String> list, long j10) {
        try {
            DebugLog.W(TAG, "openByDeeplink threadName = " + Thread.currentThread().getName());
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(32768);
            if (str.startsWith("tbopen://")) {
                intent.addFlags(536870912);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            retryOpenByDeepLink(context, str, i10, str2, list);
            startAppTrackMonitoring(context, str2, list, j10);
            return true;
        } catch (Throwable th) {
            DebugLog.W(TAG, "open dp error:" + th.toString());
            retryOpenByDeepLink(context, str, i10, str2, list);
            startAppTrackMonitoring(context, str2, list, j10);
            return false;
        }
    }

    public static int dip2px(int i10) {
        return (int) ((i10 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static String getAppName(Context context) {
        System.currentTimeMillis();
        try {
            int i10 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes;
            if (i10 == 0) {
                return "";
            }
            return context.getResources().getString(i10) + "";
        } catch (Throwable th) {
            DebugLog.W(TAG, "getAppName error:" + th.toString());
            return "";
        }
    }
}
