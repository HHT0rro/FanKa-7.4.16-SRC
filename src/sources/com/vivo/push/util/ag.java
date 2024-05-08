package com.vivo.push.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.internal.logging.nano.MetricsProto;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Utility.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f46403a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: b, reason: collision with root package name */
    private static String[] f46404b = {com.kuaishou.weapon.p0.g.f36115a, com.kuaishou.weapon.p0.g.f36116b, "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", com.kuaishou.weapon.p0.g.f36118d, "android.permission.WAKE_LOCK", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", com.kuaishou.weapon.p0.g.f36119e};

    /* renamed from: c, reason: collision with root package name */
    private static String[] f46405c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: d, reason: collision with root package name */
    private static String[] f46406d = {"com.vivo.push.sdk.RegistrationReceiver"};

    /* renamed from: e, reason: collision with root package name */
    private static String[] f46407e = new String[0];

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, Bundle> f46408f = new ConcurrentHashMap();

    public static long a(Context context) {
        String a10 = aa.a(context);
        if (TextUtils.isEmpty(a10)) {
            u.a("Utility", "systemPushPkgName is null");
            return -1L;
        }
        return a(context, a10);
    }

    public static String b(Context context, String str) {
        Object a10 = a(context, str, "verification_status");
        return a10 != null ? a10.toString() : "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b1, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0099, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L43;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00b6: MOVE (r0 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:76:0x00b6 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa A[Catch: Exception -> 0x00b4, TRY_ENTER, TryCatch #4 {Exception -> 0x00b4, blocks: (B:50:0x0092, B:52:0x0097, B:45:0x009b, B:41:0x00aa, B:43:0x00af), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af A[Catch: Exception -> 0x00b4, TRY_LEAVE, TryCatch #4 {Exception -> 0x00b4, blocks: (B:50:0x0092, B:52:0x0097, B:45:0x009b, B:41:0x00aa, B:43:0x00af), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.PublicKey c(android.content.Context r12) {
        /*
            r0 = 0
            r1 = 24
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            java.lang.String r3 = "Utility"
            if (r2 < r1) goto L2d
            android.content.ContentResolver r4 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            android.net.Uri r6 = com.vivo.push.x.f46459a     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            android.content.ContentProviderClient r4 = r4.acquireUnstableContentProviderClient(r6)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            if (r4 == 0) goto L2b
            java.lang.String r5 = "client is null"
            com.vivo.push.util.u.a(r3, r5)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r5 = r4
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            goto L2f
        L24:
            r12 = move-exception
            goto Lb7
        L27:
            r12 = move-exception
            r5 = r0
            goto La5
        L2b:
            r5 = r0
            goto L2f
        L2d:
            r4 = r0
            r5 = r4
        L2f:
            if (r5 != 0) goto L43
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            android.net.Uri r7 = com.vivo.push.x.f46459a     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r12 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            r5 = r12
            goto L43
        L41:
            r12 = move-exception
            goto La5
        L43:
            if (r5 != 0) goto L52
            if (r5 == 0) goto L4a
            r5.close()     // Catch: java.lang.Exception -> L51
        L4a:
            if (r4 == 0) goto L51
            if (r2 < r1) goto L51
            r4.close()     // Catch: java.lang.Exception -> L51
        L51:
            return r0
        L52:
            boolean r12 = r5.moveToNext()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            if (r12 == 0) goto L92
            java.lang.String r12 = "pushkey"
            java.lang.String r2 = "name"
            int r2 = r5.getColumnIndex(r2)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            java.lang.String r2 = r5.getString(r2)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            boolean r12 = r12.equals(r2)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            if (r12 == 0) goto L52
            java.lang.String r12 = "value"
            int r12 = r5.getColumnIndex(r12)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            java.lang.String r12 = r5.getString(r12)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            java.lang.String r2 = "result key : "
            java.lang.String r6 = java.lang.String.valueOf(r12)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            java.lang.String r2 = r2.concat(r6)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            com.vivo.push.util.u.d(r3, r2)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            java.security.PublicKey r12 = com.vivo.push.util.ab.a(r12)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            r5.close()     // Catch: java.lang.Exception -> L91
            if (r4 == 0) goto L91
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L91
            if (r0 < r1) goto L91
            r4.close()     // Catch: java.lang.Exception -> L91
        L91:
            return r12
        L92:
            r5.close()     // Catch: java.lang.Exception -> Lb4
            if (r4 == 0) goto Lb4
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lb4
            if (r12 < r1) goto Lb4
        L9b:
            r4.close()     // Catch: java.lang.Exception -> Lb4
            goto Lb4
        L9f:
            r12 = move-exception
            r4 = r0
            goto Lb7
        La2:
            r12 = move-exception
            r4 = r0
            r5 = r4
        La5:
            r12.printStackTrace()     // Catch: java.lang.Throwable -> Lb5
            if (r5 == 0) goto Lad
            r5.close()     // Catch: java.lang.Exception -> Lb4
        Lad:
            if (r4 == 0) goto Lb4
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lb4
            if (r12 < r1) goto Lb4
            goto L9b
        Lb4:
            return r0
        Lb5:
            r12 = move-exception
            r0 = r5
        Lb7:
            if (r0 == 0) goto Lbc
            r0.close()     // Catch: java.lang.Exception -> Lc5
        Lbc:
            if (r4 == 0) goto Lc5
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lc5
            if (r0 < r1) goto Lc5
            r4.close()     // Catch: java.lang.Exception -> Lc5
        Lc5:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.c(android.content.Context):java.security.PublicKey");
    }

    private static void d(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() != null) {
                ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
                if (serviceInfoArr != null) {
                    for (String str2 : f46405c) {
                        a(str2, serviceInfoArr, str);
                    }
                    return;
                }
                throw new VivoPushException("serviceInfos is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void e(Context context, String str) throws VivoPushException {
        if (f46407e.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() != null) {
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
                if (activityInfoArr != null) {
                    for (String str2 : f46407e) {
                        a(str2, activityInfoArr, str);
                    }
                    return;
                }
                throw new VivoPushException("activityInfos is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void f(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() != null) {
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
                if (activityInfoArr != null) {
                    for (String str2 : f46406d) {
                        a(str2, activityInfoArr, str);
                    }
                    return;
                }
                throw new VivoPushException("receivers is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int g(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "Utility"
            r1 = 0
            if (r3 == 0) goto L46
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 == 0) goto Lc
            goto L46
        Lc:
            java.lang.String r2 = "sdk_version_vivo"
            java.lang.Object r3 = a(r3, r4, r2)
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L1b
            java.lang.String r3 = (java.lang.String) r3
        L18:
            r4 = r3
            r3 = 0
            goto L2f
        L1b:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L28
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r4 = ""
            goto L2f
        L28:
            if (r3 == 0) goto L45
            java.lang.String r3 = r3.toString()
            goto L18
        L2f:
            if (r3 <= 0) goto L32
            return r3
        L32:
            int r1 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Exception -> L37
            goto L45
        L37:
            r3 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "getClientSdkVersion: "
            java.lang.String r3 = r4.concat(r3)
            com.vivo.push.util.u.a(r0, r3)
        L45:
            return r1
        L46:
            java.lang.String r3 = "getClientSdkVersion() error, context is null or pkgName is empty"
            com.vivo.push.util.u.a(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.g(android.content.Context, java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00fd, code lost:
    
        r12 = r12 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r20) throws com.vivo.push.util.VivoPushException {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.b(android.content.Context):void");
    }

    public static long a(Context context, String str) {
        Object a10 = a(context, str, "com.vivo.push.sdk_version");
        if (a10 == null) {
            a10 = a(context, str, "sdk_version");
        }
        if (a10 != null) {
            try {
                return Long.parseLong(a10.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                u.a("Utility", "getSdkVersionCode error ", e2);
                return -1L;
            }
        }
        u.a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00eb A[Catch: Exception -> 0x00e7, TryCatch #2 {Exception -> 0x00e7, blocks: (B:77:0x00e3, B:65:0x00eb, B:67:0x00ef), top: B:76:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.d(android.content.Context):boolean");
    }

    public static Object a(Context context, String str, String str2) {
        Object obj;
        Bundle bundle;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, Bundle> map = f46408f;
            Object obj2 = (map == null || map.size() <= 0 || (bundle = f46408f.get(str)) == null) ? null : bundle.get(str2);
            if (obj2 != null) {
                return obj2;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                r0 = applicationInfo != null ? applicationInfo.metaData : null;
                obj = r0 != null ? r0.get(str2) : obj2;
            } catch (Exception e2) {
                e = e2;
                r0 = obj2;
            }
            try {
                if (f46408f.size() > 300) {
                    return obj;
                }
                f46408f.put(str, r0);
                return obj;
            } catch (Exception e10) {
                r0 = obj;
                e = e10;
                u.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                return r0;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    public static int c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            int a10 = (int) a(context, str);
            return a10 <= 0 ? g(context, str) : a10;
        }
        u.a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
        return 0;
    }

    private static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : f46403a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    private static void a(Context context, String str, String str2, boolean z10) throws VivoPushException {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            if (z10) {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    Iterator<ResolveInfo> iterator2 = queryBroadcastReceivers.iterator2();
                    while (iterator2.hasNext()) {
                        if (str2.equals(iterator2.next().activityInfo.name)) {
                            return;
                        }
                    }
                    throw new VivoPushException(str2 + " is missing");
                }
                throw new VivoPushException("checkModule " + ((Object) intent) + " has no receivers");
            }
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (str2.equals(resolveInfo.serviceInfo.name)) {
                        if (resolveInfo.serviceInfo.exported) {
                            return;
                        }
                        throw new VivoPushException(resolveInfo.serviceInfo.name + " exported is false");
                    }
                }
                throw new VivoPushException(str2 + " is missing");
            }
            throw new VivoPushException("checkModule " + ((Object) intent) + " has no services");
        } catch (Exception e2) {
            u.a("Utility", "error  " + e2.getMessage());
            throw new VivoPushException("checkModule error" + e2.getMessage());
        }
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    public static void a(Context context, Intent intent) {
        String a10 = aa.a(context);
        String stringExtra = intent.getStringExtra("client_pkgname");
        if (TextUtils.isEmpty(a10)) {
            u.a("Utility", "illegality abe adapter : push pkg is null");
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            u.a("Utility", "illegality abe adapter : src pkg is null");
            return;
        }
        if (a10.equals(context.getPackageName())) {
            u.a("Utility", "illegality abe adapter : abe is not pushservice");
            return;
        }
        if (!a10.equals(stringExtra)) {
            u.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + a10);
            intent.setPackage(a10);
            intent.setClassName(a10, "com.vivo.push.sdk.service.PushService");
            context.startService(intent);
            return;
        }
        u.a("Utility", "illegality abe adapter : pushPkg = " + a10 + " ; srcPkg = " + stringExtra);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d5 A[Catch: Exception -> 0x00d1, TryCatch #7 {Exception -> 0x00d1, blocks: (B:74:0x00cd, B:62:0x00d5, B:64:0x00d9), top: B:73:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r16, java.lang.String r17, java.lang.String r18, long r19) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.a(android.content.Context, java.lang.String, java.lang.String, long):boolean");
    }

    public static boolean a(Context context, String str, boolean z10) {
        Cursor a10;
        Cursor cursor = null;
        try {
        } catch (Exception e2) {
            u.a("Utility", "close", e2);
        }
        try {
            try {
                Uri uri = com.vivo.push.x.f46463e;
                String[] strArr = new String[2];
                strArr[0] = str;
                strArr[1] = z10 ? "1" : "0";
                a10 = a(uri, "appPkgName = ? and agreePrivacyStatement = ? ", strArr, context);
            } catch (Exception e10) {
                u.a("Utility", "syncAgreePrivacyStatement", e10);
                if (0 != 0) {
                    cursor.close();
                }
            }
            if (a10 == null) {
                u.a("Utility", "cursor is null");
                if (a10 != null) {
                    try {
                        a10.close();
                    } catch (Exception e11) {
                        u.a("Utility", "close", e11);
                    }
                }
                return false;
            }
            if (a10.moveToFirst()) {
                boolean parseBoolean = Boolean.parseBoolean(a10.getString(a10.getColumnIndex("agreePrivacyStatement")));
                try {
                    a10.close();
                } catch (Exception e12) {
                    u.a("Utility", "close", e12);
                }
                return parseBoolean;
            }
            a10.close();
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e13) {
                    u.a("Utility", "close", e13);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0082: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:49:0x0082 */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.database.Cursor a(android.net.Uri r13, java.lang.String r14, java.lang.String[] r15, android.content.Context r16) {
        /*
            java.lang.String r1 = "close"
            r2 = 24
            r3 = 0
            java.lang.String r4 = "Utility"
            if (r16 != 0) goto Lf
            java.lang.String r0 = "context is null"
            com.vivo.push.util.u.a(r4, r0)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            return r3
        Lf:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            if (r0 < r2) goto L30
            android.content.ContentResolver r5 = r16.getContentResolver()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            r12 = r13
            android.content.ContentProviderClient r5 = r5.acquireUnstableContentProviderClient(r13)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            if (r5 == 0) goto L2e
            java.lang.String r6 = "client is null"
            com.vivo.push.util.u.a(r4, r6)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L81
            r8 = 0
            r11 = 0
            r6 = r5
            r7 = r13
            r9 = r14
            r10 = r15
            android.database.Cursor r6 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L81
            goto L33
        L2e:
            r6 = r3
            goto L33
        L30:
            r12 = r13
            r5 = r3
            r6 = r5
        L33:
            if (r6 != 0) goto L45
            android.content.ContentResolver r6 = r16.getContentResolver()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L81
            r8 = 0
            r11 = 0
            r7 = r13
            r9 = r14
            r10 = r15
            android.database.Cursor r6 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L81
            goto L45
        L43:
            r0 = move-exception
            goto L6d
        L45:
            if (r6 != 0) goto L5a
            java.lang.String r6 = "cursor is null"
            com.vivo.push.util.u.a(r4, r6)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L81
            if (r5 == 0) goto L59
            if (r0 < r2) goto L59
            r5.close()     // Catch: java.lang.Exception -> L54
            goto L59
        L54:
            r0 = move-exception
            r2 = r0
            com.vivo.push.util.u.a(r4, r1, r2)
        L59:
            return r3
        L5a:
            if (r5 == 0) goto L67
            if (r0 < r2) goto L67
            r5.close()     // Catch: java.lang.Exception -> L62
            goto L67
        L62:
            r0 = move-exception
            r2 = r0
            com.vivo.push.util.u.a(r4, r1, r2)
        L67:
            return r6
        L68:
            r0 = move-exception
        L69:
            r5 = r0
            goto L84
        L6b:
            r0 = move-exception
            r5 = r3
        L6d:
            java.lang.String r6 = "queryContentResolver"
            com.vivo.push.util.u.a(r4, r6, r0)     // Catch: java.lang.Throwable -> L81
            if (r5 == 0) goto L80
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L7c
            if (r0 < r2) goto L80
            r5.close()     // Catch: java.lang.Exception -> L7c
            goto L80
        L7c:
            r0 = move-exception
            com.vivo.push.util.u.a(r4, r1, r0)
        L80:
            return r3
        L81:
            r0 = move-exception
            r3 = r5
            goto L69
        L84:
            if (r3 == 0) goto L92
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L8e
            if (r0 < r2) goto L92
            r3.close()     // Catch: java.lang.Exception -> L8e
            goto L92
        L8e:
            r0 = move-exception
            com.vivo.push.util.u.a(r4, r1, r0)
        L92:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ag.a(android.net.Uri, java.lang.String, java.lang.String[], android.content.Context):android.database.Cursor");
    }
}
