package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.push.n6;
import com.xiaomi.push.v4;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static z f48217a;

    /* renamed from: b, reason: collision with root package name */
    public static a f48218b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a {
        void a();
    }

    public static synchronized z a(Context context) {
        synchronized (a0.class) {
            z zVar = f48217a;
            if (zVar != null) {
                return zVar;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString(Constant.MAP_KEY_UUID, null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString(MonitorConstants.EXTRA_DEVICE_ID, null);
            int i10 = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && n6.m(string7)) {
                string7 = n6.I(context);
                sharedPreferences.edit().putString(MonitorConstants.EXTRA_DEVICE_ID, string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String I = n6.I(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(I) && !TextUtils.isEmpty(string7) && !string7.equals(I)) {
                fc.c.i("read_phone_state permission changes.");
            }
            z zVar2 = new z(string, string2, string3, string4, string5, string6, i10);
            f48217a = zVar2;
            return zVar2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:3|4|(2:8|(28:10|11|(1:13)|14|(1:16)|17|(1:19)|20|(1:22)|23|(1:25)|26|27|28|29|(1:31)(1:68)|32|(6:34|(1:36)|37|(1:41)|42|(1:44))|45|(1:47)|48|(1:50)|51|(1:53)|54|(2:56|(5:58|(1:60)|61|62|63)(1:65))|66|67))|72|11|(0)|14|(0)|17|(0)|20|(0)|23|(0)|26|27|28|29|(0)(0)|32|(0)|45|(0)|48|(0)|51|(0)|54|(0)|66|67) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bf, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c0, code lost:
    
        fc.c.k(r10);
        r10 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007b A[Catch: all -> 0x0251, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004c, B:10:0x0062, B:11:0x006e, B:13:0x007b, B:14:0x0080, B:16:0x008a, B:17:0x008f, B:20:0x0097, B:23:0x00a0, B:26:0x00a9, B:28:0x00b4, B:31:0x00c8, B:32:0x00d1, B:34:0x00f8, B:36:0x0104, B:37:0x0117, B:39:0x0121, B:41:0x0127, B:42:0x013b, B:44:0x0141, B:45:0x0146, B:47:0x0169, B:48:0x0172, B:50:0x017c, B:51:0x0185, B:53:0x01c4, B:54:0x01c8, B:56:0x01ce, B:58:0x01db, B:60:0x01f9, B:61:0x020f, B:65:0x023d, B:71:0x00c0), top: B:3:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008a A[Catch: all -> 0x0251, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004c, B:10:0x0062, B:11:0x006e, B:13:0x007b, B:14:0x0080, B:16:0x008a, B:17:0x008f, B:20:0x0097, B:23:0x00a0, B:26:0x00a9, B:28:0x00b4, B:31:0x00c8, B:32:0x00d1, B:34:0x00f8, B:36:0x0104, B:37:0x0117, B:39:0x0121, B:41:0x0127, B:42:0x013b, B:44:0x0141, B:45:0x0146, B:47:0x0169, B:48:0x0172, B:50:0x017c, B:51:0x0185, B:53:0x01c4, B:54:0x01c8, B:56:0x01ce, B:58:0x01db, B:60:0x01f9, B:61:0x020f, B:65:0x023d, B:71:0x00c0), top: B:3:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c8 A[Catch: all -> 0x0251, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004c, B:10:0x0062, B:11:0x006e, B:13:0x007b, B:14:0x0080, B:16:0x008a, B:17:0x008f, B:20:0x0097, B:23:0x00a0, B:26:0x00a9, B:28:0x00b4, B:31:0x00c8, B:32:0x00d1, B:34:0x00f8, B:36:0x0104, B:37:0x0117, B:39:0x0121, B:41:0x0127, B:42:0x013b, B:44:0x0141, B:45:0x0146, B:47:0x0169, B:48:0x0172, B:50:0x017c, B:51:0x0185, B:53:0x01c4, B:54:0x01c8, B:56:0x01ce, B:58:0x01db, B:60:0x01f9, B:61:0x020f, B:65:0x023d, B:71:0x00c0), top: B:3:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f8 A[Catch: all -> 0x0251, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004c, B:10:0x0062, B:11:0x006e, B:13:0x007b, B:14:0x0080, B:16:0x008a, B:17:0x008f, B:20:0x0097, B:23:0x00a0, B:26:0x00a9, B:28:0x00b4, B:31:0x00c8, B:32:0x00d1, B:34:0x00f8, B:36:0x0104, B:37:0x0117, B:39:0x0121, B:41:0x0127, B:42:0x013b, B:44:0x0141, B:45:0x0146, B:47:0x0169, B:48:0x0172, B:50:0x017c, B:51:0x0185, B:53:0x01c4, B:54:0x01c8, B:56:0x01ce, B:58:0x01db, B:60:0x01f9, B:61:0x020f, B:65:0x023d, B:71:0x00c0), top: B:3:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0169 A[Catch: all -> 0x0251, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004c, B:10:0x0062, B:11:0x006e, B:13:0x007b, B:14:0x0080, B:16:0x008a, B:17:0x008f, B:20:0x0097, B:23:0x00a0, B:26:0x00a9, B:28:0x00b4, B:31:0x00c8, B:32:0x00d1, B:34:0x00f8, B:36:0x0104, B:37:0x0117, B:39:0x0121, B:41:0x0127, B:42:0x013b, B:44:0x0141, B:45:0x0146, B:47:0x0169, B:48:0x0172, B:50:0x017c, B:51:0x0185, B:53:0x01c4, B:54:0x01c8, B:56:0x01ce, B:58:0x01db, B:60:0x01f9, B:61:0x020f, B:65:0x023d, B:71:0x00c0), top: B:3:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017c A[Catch: all -> 0x0251, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004c, B:10:0x0062, B:11:0x006e, B:13:0x007b, B:14:0x0080, B:16:0x008a, B:17:0x008f, B:20:0x0097, B:23:0x00a0, B:26:0x00a9, B:28:0x00b4, B:31:0x00c8, B:32:0x00d1, B:34:0x00f8, B:36:0x0104, B:37:0x0117, B:39:0x0121, B:41:0x0127, B:42:0x013b, B:44:0x0141, B:45:0x0146, B:47:0x0169, B:48:0x0172, B:50:0x017c, B:51:0x0185, B:53:0x01c4, B:54:0x01c8, B:56:0x01ce, B:58:0x01db, B:60:0x01f9, B:61:0x020f, B:65:0x023d, B:71:0x00c0), top: B:3:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c4 A[Catch: all -> 0x0251, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004c, B:10:0x0062, B:11:0x006e, B:13:0x007b, B:14:0x0080, B:16:0x008a, B:17:0x008f, B:20:0x0097, B:23:0x00a0, B:26:0x00a9, B:28:0x00b4, B:31:0x00c8, B:32:0x00d1, B:34:0x00f8, B:36:0x0104, B:37:0x0117, B:39:0x0121, B:41:0x0127, B:42:0x013b, B:44:0x0141, B:45:0x0146, B:47:0x0169, B:48:0x0172, B:50:0x017c, B:51:0x0185, B:53:0x01c4, B:54:0x01c8, B:56:0x01ce, B:58:0x01db, B:60:0x01f9, B:61:0x020f, B:65:0x023d, B:71:0x00c0), top: B:3:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ce A[Catch: all -> 0x0251, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004c, B:10:0x0062, B:11:0x006e, B:13:0x007b, B:14:0x0080, B:16:0x008a, B:17:0x008f, B:20:0x0097, B:23:0x00a0, B:26:0x00a9, B:28:0x00b4, B:31:0x00c8, B:32:0x00d1, B:34:0x00f8, B:36:0x0104, B:37:0x0117, B:39:0x0121, B:41:0x0127, B:42:0x013b, B:44:0x0141, B:45:0x0146, B:47:0x0169, B:48:0x0172, B:50:0x017c, B:51:0x0185, B:53:0x01c4, B:54:0x01c8, B:56:0x01ce, B:58:0x01db, B:60:0x01f9, B:61:0x020f, B:65:0x023d, B:71:0x00c0), top: B:3:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.xiaomi.push.service.z b(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.a0.b(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.z");
    }

    public static String c(Context context) {
        StringBuilder sb2;
        String str;
        String a10 = kc.a.c(context).a();
        if (com.xiaomi.push.e.d()) {
            sb2 = new StringBuilder();
            sb2.append("http://");
            sb2.append(v4.f48437i);
            str = ":9085";
        } else if (com.xiaomi.push.o.China.name().equals(a10)) {
            sb2 = new StringBuilder();
            str = "https://cn.register.xmpush.xiaomi.com";
        } else if (com.xiaomi.push.o.Global.name().equals(a10)) {
            sb2 = new StringBuilder();
            str = "https://register.xmpush.global.xiaomi.com";
        } else if (com.xiaomi.push.o.Europe.name().equals(a10)) {
            sb2 = new StringBuilder();
            str = "https://fr.register.xmpush.global.xiaomi.com";
        } else if (com.xiaomi.push.o.Russia.name().equals(a10)) {
            sb2 = new StringBuilder();
            str = "https://ru.register.xmpush.global.xiaomi.com";
        } else if (com.xiaomi.push.o.India.name().equals(a10)) {
            sb2 = new StringBuilder();
            str = "https://idmb.register.xmpush.global.xiaomi.com";
        } else {
            sb2 = new StringBuilder();
            sb2.append("https://");
            str = com.xiaomi.push.e.c() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
        }
        sb2.append(str);
        sb2.append("/pass/v2/register");
        return sb2.toString();
    }

    public static void d() {
        a aVar = f48218b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static void e(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f48217a = null;
        d();
    }

    public static void f(Context context, z zVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString(Constant.MAP_KEY_UUID, zVar.f48360a);
        edit.putString("security", zVar.f48362c);
        edit.putString("token", zVar.f48361b);
        edit.putString("app_id", zVar.f48363d);
        edit.putString("package_name", zVar.f48365f);
        edit.putString("app_token", zVar.f48364e);
        edit.putString(MonitorConstants.EXTRA_DEVICE_ID, n6.I(context));
        edit.putInt("env_type", zVar.f48366g);
        edit.commit();
        d();
    }

    public static void g(a aVar) {
        f48218b = aVar;
    }

    public static boolean h(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
