package com.vivo.push.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.android.internal.logging.nano.MetricsProto;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: PushPackageUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f46388a;

    /* renamed from: b, reason: collision with root package name */
    private static String f46389b;

    public static com.vivo.push.model.b a(Context context, o oVar) {
        com.vivo.push.model.b bVar;
        com.vivo.push.model.b f10;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.model.b c4 = c(applicationContext);
        if (c4 != null) {
            u.d("PushPackageUtils", "get system push info :".concat(String.valueOf(c4)));
            return c4;
        }
        List<String> a10 = oVar.a(applicationContext);
        com.vivo.push.model.b f11 = f(applicationContext, applicationContext.getPackageName());
        if (a10 != null && a10.size() > 0) {
            com.vivo.push.model.b bVar2 = null;
            String a11 = af.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(a11) || !a(applicationContext, a11, "com.vivo.pushservice.action.METHOD") || (bVar = f(applicationContext, a11)) == null || !bVar.d()) {
                bVar = null;
            }
            if (f11 == null || !f11.d()) {
                f11 = null;
            }
            if (bVar == null) {
                bVar = null;
            }
            if (f11 == null || (bVar != null && (!f11.c() ? !(bVar.c() || f11.b() > bVar.b()) : !(bVar.c() && f11.b() > bVar.b())))) {
                f11 = bVar;
            }
            HashMap hashMap = new HashMap();
            if (f11 == null) {
                f11 = null;
            } else if (f11.c()) {
                bVar2 = f11;
                f11 = null;
            }
            int size = a10.size();
            for (int i10 = 0; i10 < size; i10++) {
                String str = a10.get(i10);
                if (!TextUtils.isEmpty(str) && (f10 = f(applicationContext, str)) != null) {
                    hashMap.put(str, f10);
                    if (f10.d()) {
                        if (f10.c()) {
                            if (bVar2 == null || f10.b() > bVar2.b()) {
                                bVar2 = f10;
                            }
                        } else if (f11 == null || f10.b() > f11.b()) {
                            f11 = f10;
                        }
                    }
                }
            }
            if (f11 == null) {
                u.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                f11 = bVar2;
            }
        } else {
            if (f11 != null && f11.d()) {
                c4 = f11;
            }
            u.a("PushPackageUtils", "findAllPushPackages error: find no package!");
            f11 = c4;
        }
        if (f11 != null) {
            if (f11.c()) {
                u.a(applicationContext, "查找最优包为:" + f11.a() + "(" + f11.b() + ", Black)");
                u.d("PushPackageUtils", "finSuitablePushPackage" + f11.a() + "(" + f11.b() + ", Black)");
            } else {
                u.a(applicationContext, "查找最优包为:" + f11.a() + "(" + f11.b() + ")");
                u.d("PushPackageUtils", "finSuitablePushPackage" + f11.a() + "(" + f11.b() + ")");
            }
        } else {
            u.b(applicationContext, "查找最优包为空!");
            u.d("PushPackageUtils", "finSuitablePushPackage is null");
        }
        return f11;
    }

    public static boolean b(Context context) {
        ProviderInfo resolveContentProvider;
        Boolean bool = f46388a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str)));
        f46388a = valueOf;
        return valueOf.booleanValue();
    }

    private static com.vivo.push.model.b c(Context context) {
        String a10 = a(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        com.vivo.push.model.b bVar = new com.vivo.push.model.b(a10);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a10, 128);
            if (packageInfo != null) {
                bVar.a(packageInfo.versionCode);
                bVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                bVar.a(ag.a(context, a10));
            }
            bVar.a(a(context, bVar.b()));
            bVar.b(a(context, a10));
            return bVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e2);
            return null;
        }
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    public static boolean e(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    private static com.vivo.push.model.b f(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str)) {
            if (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                com.vivo.push.model.b bVar = new com.vivo.push.model.b(str);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                    if (packageInfo != null) {
                        bVar.a(packageInfo.versionCode);
                        bVar.a(packageInfo.versionName);
                        applicationInfo = packageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        bVar.a(ag.a(context, str));
                    }
                    bVar.b(a(context, str));
                    bVar.a(a(context, bVar.b()));
                    return bVar;
                } catch (Exception e2) {
                    u.a("PushPackageUtils", "getPushPackageInfo exception: ", e2);
                }
            }
        }
        return null;
    }

    private static String g(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b4 : digest) {
                    String upperCase = Integer.toHexString(b4 & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e2) {
                u.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e2)));
            }
        }
        return null;
    }

    public static int b(Context context, String str) {
        int i10 = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i10;
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0100 A[Catch: Exception -> 0x00eb, TRY_ENTER, TryCatch #3 {Exception -> 0x00eb, blocks: (B:75:0x00de, B:77:0x00e3, B:79:0x00e7, B:33:0x0100, B:35:0x0105, B:37:0x0109), top: B:7:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105 A[Catch: Exception -> 0x00eb, TryCatch #3 {Exception -> 0x00eb, blocks: (B:75:0x00de, B:77:0x00e3, B:79:0x00e7, B:33:0x0100, B:35:0x0105, B:37:0x0109), top: B:7:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.aa.a(android.content.Context):java.lang.String");
    }

    public static boolean a(Context context, String str) {
        ServiceInfo serviceInfo;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                int size = queryIntentServices.size();
                boolean z10 = false;
                for (int i10 = 0; i10 < size; i10++) {
                    ResolveInfo resolveInfo = queryIntentServices.get(i10);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        String str2 = serviceInfo.name;
                        boolean z11 = serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z11) {
                            boolean z12 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            z10 = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z12);
                        }
                    }
                }
                return z10;
            }
            u.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    private static boolean a(Context context, long j10) {
        com.vivo.push.cache.d a10 = com.vivo.push.cache.b.a().a(context);
        if (a10 != null) {
            return a10.isInBlackList(j10);
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        List<ResolveInfo> list;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT);
        } catch (Exception unused) {
            list = null;
        }
        return list != null && list.size() > 0;
    }
}
