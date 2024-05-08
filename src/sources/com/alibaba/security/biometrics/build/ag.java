package com.alibaba.security.biometrics.build;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.alibaba.security.common.utils.SystemUtils;

/* compiled from: SettingUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ag {
    public static void a(Context context) {
        if (SystemUtils.isHuawei()) {
            f(context);
            return;
        }
        if (SystemUtils.isMeizu()) {
            e(context);
            return;
        }
        if (SystemUtils.isXiaomi()) {
            g(context);
            return;
        }
        if (SystemUtils.isOppo()) {
            c(context);
        } else if (SystemUtils.isVivo()) {
            b(context);
        } else {
            d(context);
        }
    }

    private static void b(Context context) {
        try {
            String str = Build.MODEL;
            if ((str.contains("Y85") && !str.contains("Y85A")) || str.contains("vivo Y53L")) {
                Intent intent = new Intent();
                intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.PurviewTabActivity");
                intent.putExtra("packagename", context.getPackageName());
                intent.putExtra("tabId", "1");
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent();
            intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent2.setAction("secure.intent.action.softPermissionDetail");
            intent2.putExtra("packagename", context.getPackageName());
            context.startActivity(intent2);
        } catch (Exception unused) {
            d(context);
        }
    }

    private static void c(Context context) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
            context.startActivity(intent);
        } catch (Exception unused) {
            d(context);
        }
    }

    private static void d(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void e(Context context) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", context.getPackageName());
            context.startActivity(intent);
        } catch (Exception unused) {
            d(context);
        }
    }

    private static void f(Context context) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            context.startActivity(intent);
        } catch (Exception unused) {
            d(context);
        }
    }

    private static void g(Context context) {
        try {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity"));
            intent.putExtra("extra_pkgname", context.getPackageName());
            context.startActivity(intent);
        } catch (Exception unused) {
            d(context);
        }
    }
}
