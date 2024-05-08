package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class x {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f47090a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f47091b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f47092c;

        /* renamed from: d, reason: collision with root package name */
        public String f47093d;

        public b(String str, boolean z10, boolean z11, String str2) {
            this.f47090a = str;
            this.f47091b = z10;
            this.f47092c = z11;
            this.f47093d = str2;
        }
    }

    public static ActivityInfo a(PackageManager packageManager, Intent intent, Class<?> cls) {
        Iterator<ResolveInfo> iterator2 = packageManager.queryBroadcastReceivers(intent, 16384).iterator2();
        while (iterator2.hasNext()) {
            ActivityInfo activityInfo = iterator2.next().activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    public static void b(Context context) {
        new Thread(new i1(context)).start();
    }

    public static void d(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        Iterator<ResolveInfo> iterator2 = packageManager.queryBroadcastReceivers(intent, 16384).iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            ActivityInfo activityInfo = iterator2.next().activityInfo;
            z10 = (activityInfo == null || TextUtils.isEmpty(activityInfo.name) || !activityInfo.name.equals(str2)) ? false : true;
            if (z10) {
                break;
            }
        }
        if (!z10) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", str2));
        }
    }

    public static void e(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() != activityInfo.enabled) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", activityInfo.name, boolArr[0]));
        }
        if (boolArr[1].booleanValue() != activityInfo.exported) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", activityInfo.name, boolArr[1]));
        }
    }

    public static boolean f(PackageInfo packageInfo, String[] strArr) {
        for (ServiceInfo serviceInfo : packageInfo.services) {
            if (g(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(String[] strArr, String str) {
        if (strArr != null && str != null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2 A[EDGE_INSN: B:23:0x00a2->B:24:0x00a2 BREAK  A[LOOP:0: B:8:0x006e->B:37:0x006e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void j(android.content.Context r8) {
        /*
            java.lang.String r0 = "com.xiaomi.push.service.receivers.PingReceiver"
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            java.lang.String r2 = r8.getPackageName()
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = kc.n.f50831m
            r3.<init>(r4)
            r3.setPackage(r2)
            r4 = 1
            r5 = 0
            java.lang.Class r6 = com.xiaomi.push.n7.c(r8, r0)     // Catch: java.lang.ClassNotFoundException -> L55
            android.content.pm.ActivityInfo r3 = a(r1, r3, r6)     // Catch: java.lang.ClassNotFoundException -> L55
            boolean r6 = com.xiaomi.mipush.sdk.MiPushClient.d0(r8)     // Catch: java.lang.ClassNotFoundException -> L55
            r7 = 2
            if (r6 != 0) goto L45
            if (r3 == 0) goto L35
            java.lang.Boolean[] r0 = new java.lang.Boolean[r7]     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch: java.lang.ClassNotFoundException -> L55
            r0[r5] = r6     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch: java.lang.ClassNotFoundException -> L55
            r0[r4] = r6     // Catch: java.lang.ClassNotFoundException -> L55
            e(r3, r0)     // Catch: java.lang.ClassNotFoundException -> L55
            goto L59
        L35:
            com.xiaomi.mipush.sdk.x$a r3 = new com.xiaomi.mipush.sdk.x$a     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.String r6 = "<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest."
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch: java.lang.ClassNotFoundException -> L55
            r7[r5] = r0     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.String r0 = java.lang.String.format(r6, r7)     // Catch: java.lang.ClassNotFoundException -> L55
            r3.<init>(r0)     // Catch: java.lang.ClassNotFoundException -> L55
            throw r3     // Catch: java.lang.ClassNotFoundException -> L55
        L45:
            if (r3 == 0) goto L59
            java.lang.Boolean[] r0 = new java.lang.Boolean[r7]     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch: java.lang.ClassNotFoundException -> L55
            r0[r5] = r6     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch: java.lang.ClassNotFoundException -> L55
            r0[r4] = r6     // Catch: java.lang.ClassNotFoundException -> L55
            e(r3, r0)     // Catch: java.lang.ClassNotFoundException -> L55
            goto L59
        L55:
            r0 = move-exception
            fc.c.k(r0)
        L59:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r3 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r0.<init>(r3)
            r0.setPackage(r2)
            r2 = 16384(0x4000, float:2.2959E-41)
            java.util.List r0 = r1.queryBroadcastReceivers(r0, r2)
            java.util.Iterator r0 = r0.iterator2()
            r1 = 0
        L6e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto La2
            java.lang.Object r2 = r0.next()
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2
            android.content.pm.ActivityInfo r2 = r2.activityInfo
            if (r2 == 0) goto L9f
            java.lang.String r3 = r2.name     // Catch: java.lang.ClassNotFoundException -> L9a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.ClassNotFoundException -> L9a
            if (r3 != 0) goto L9f
            java.lang.Class<com.xiaomi.mipush.sdk.PushMessageReceiver> r3 = com.xiaomi.mipush.sdk.PushMessageReceiver.class
            java.lang.String r6 = r2.name     // Catch: java.lang.ClassNotFoundException -> L9a
            java.lang.Class r6 = com.xiaomi.push.n7.c(r8, r6)     // Catch: java.lang.ClassNotFoundException -> L9a
            boolean r3 = r3.isAssignableFrom(r6)     // Catch: java.lang.ClassNotFoundException -> L9a
            if (r3 == 0) goto L9f
            boolean r1 = r2.enabled     // Catch: java.lang.ClassNotFoundException -> L9a
            if (r1 == 0) goto L9f
            r1 = 1
            goto La0
        L9a:
            r2 = move-exception
            fc.c.k(r2)
            goto L6e
        L9f:
            r1 = 0
        La0:
            if (r1 == 0) goto L6e
        La2:
            if (r1 == 0) goto Lc6
            boolean r0 = com.xiaomi.mipush.sdk.MiPushClient.A(r8)
            if (r0 == 0) goto Lb8
            java.lang.String r0 = "com.huawei.android.push.intent.RECEIVE"
            java.lang.String r1 = "com.xiaomi.assemble.control.HmsPushReceiver"
            d(r8, r0, r1)
            java.lang.String r0 = "com.huawei.intent.action.PUSH"
            java.lang.String r1 = "com.huawei.hms.support.api.push.PushEventReceiver"
            d(r8, r0, r1)
        Lb8:
            boolean r0 = com.xiaomi.mipush.sdk.MiPushClient.C(r8)
            if (r0 == 0) goto Lc5
            java.lang.String r0 = "com.vivo.pushclient.action.RECEIVE"
            java.lang.String r1 = "com.xiaomi.assemble.control.FTOSPushMessageReceiver"
            d(r8, r0, r1)
        Lc5:
            return
        Lc6:
            com.xiaomi.mipush.sdk.x$a r8 = new com.xiaomi.mipush.sdk.x$a
            java.lang.String r0 = "Receiver: none of the subclasses of PushMessageReceiver is enabled or defined."
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.x.j(android.content.Context):void");
    }

    public static void k(Context context, PackageInfo packageInfo) {
        boolean z10;
        HashSet hashSet = new HashSet();
        String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
        hashSet.addAll(Arrays.asList(com.kuaishou.weapon.p0.g.f36115a, com.kuaishou.weapon.p0.g.f36116b, str, com.kuaishou.weapon.p0.g.f36118d, com.kuaishou.weapon.p0.g.f36117c, com.kuaishou.weapon.p0.g.f36119e, "android.permission.VIBRATE"));
        PermissionInfo[] permissionInfoArr = packageInfo.permissions;
        if (permissionInfoArr != null) {
            for (PermissionInfo permissionInfo : permissionInfoArr) {
                if (str.equals(permissionInfo.name)) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        if (!z10) {
            throw new a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", str));
        }
        String[] strArr = packageInfo.requestedPermissions;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && hashSet.contains(str2)) {
                    hashSet.remove(str2);
                    if (hashSet.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            throw new a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", hashSet.iterator2().next()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void l(Context context, PackageInfo packageInfo) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(PushMessageHandler.class.getCanonicalName(), new b(PushMessageHandler.class.getCanonicalName(), true, true, ""));
        hashMap2.put(MessageHandleService.class.getCanonicalName(), new b(MessageHandleService.class.getCanonicalName(), true, false, ""));
        if (!MiPushClient.d0(context) || f(packageInfo, new String[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"})) {
            hashMap2.put("com.xiaomi.push.service.XMJobService", new b("com.xiaomi.push.service.XMJobService", true, false, "android.permission.BIND_JOB_SERVICE"));
            hashMap2.put("com.xiaomi.push.service.XMPushService", new b("com.xiaomi.push.service.XMPushService", true, false, ""));
        }
        if (MiPushClient.z(context)) {
            hashMap2.put("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", new b("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", true, false, ""));
            hashMap2.put("com.xiaomi.assemble.control.MiFirebaseMessagingService", new b("com.xiaomi.assemble.control.MiFirebaseMessagingService", true, false, ""));
        }
        if (MiPushClient.B(context)) {
            hashMap2.put("com.xiaomi.assemble.control.COSPushMessageService", new b("com.xiaomi.assemble.control.COSPushMessageService", true, true, "com.coloros.mcs.permission.SEND_MCS_MESSAGE"));
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.name) && hashMap2.containsKey(serviceInfo.name)) {
                    b bVar = (b) hashMap2.remove(serviceInfo.name);
                    boolean z10 = bVar.f47091b;
                    boolean z11 = bVar.f47092c;
                    String str = bVar.f47093d;
                    if (z10 != serviceInfo.enabled) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", serviceInfo.name, Boolean.valueOf(z10)));
                    }
                    if (z11 != serviceInfo.exported) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", serviceInfo.name, Boolean.valueOf(z11)));
                    }
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, serviceInfo.permission)) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", serviceInfo.name, str));
                    }
                    hashMap.put(serviceInfo.name, serviceInfo.processName);
                    if (hashMap2.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashMap2.isEmpty()) {
            throw new a(String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", hashMap2.h().iterator2().next()));
        }
        if (!TextUtils.equals((CharSequence) hashMap.get(PushMessageHandler.class.getCanonicalName()), (CharSequence) hashMap.get(MessageHandleService.class.getCanonicalName()))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", PushMessageHandler.class.getCanonicalName(), MessageHandleService.class.getCanonicalName()));
        }
        if (hashMap.containsKey("com.xiaomi.push.service.XMJobService") && hashMap.containsKey("com.xiaomi.push.service.XMPushService") && !TextUtils.equals((CharSequence) hashMap.get("com.xiaomi.push.service.XMJobService"), (CharSequence) hashMap.get("com.xiaomi.push.service.XMPushService"))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"));
        }
    }
}
