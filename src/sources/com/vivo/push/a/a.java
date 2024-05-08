package com.vivo.push.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.internal.logging.nano.MetricsProto;
import com.vivo.push.d;
import com.vivo.push.e.b;
import com.vivo.push.i;
import com.vivo.push.util.aa;
import com.vivo.push.util.ab;
import com.vivo.push.util.u;
import com.vivo.push.v;
import java.util.List;

/* compiled from: CommandBridge.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    public static void a(Context context, String str, v vVar) {
        boolean c4 = vVar.c();
        i a10 = i.a(context, c4 ? "com.vivo.vms.upstageservice" : "com.vivo.vms.aidlservice");
        boolean a11 = a10.a();
        if (TextUtils.isEmpty(vVar.a())) {
            vVar.a(context.getPackageName());
        }
        if (a11 && !"com.vivo.pushservice".equals(context.getPackageName())) {
            d dVar = new d(vVar.a(), str, new Bundle());
            vVar.a(dVar);
            if (a10.a(dVar.b())) {
                return;
            }
            u.b("CommandBridge", "send command error by aidl");
            u.c(context, "send command error by aidl");
        }
        Intent intent = new Intent("com.vivo.pushservice.action.METHOD");
        intent.setPackage(str);
        intent.setClassName(str, c4 ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService");
        vVar.a(intent);
        try {
            a(context, intent);
        } catch (Exception e2) {
            u.a("CommandBridge", "CommandBridge startService exception: ", e2);
        }
    }

    public static void a(Context context, Intent intent) throws Exception {
        if (context != null) {
            try {
                context.startService(intent);
                return;
            } catch (Exception e2) {
                u.a("CommandBridge", "start service error", e2);
                intent.setComponent(null);
                context.sendBroadcast(intent);
                return;
            }
        }
        u.d("CommandBridge", "enter startService context is null");
        throw new Exception("context is null");
    }

    public static void a(Context context, v vVar, String str) {
        try {
            boolean d10 = aa.d(context, str);
            String str2 = d10 ? "com.vivo.pushservice.action.RECEIVE" : "com.vivo.pushclient.action.RECEIVE";
            if (!TextUtils.isEmpty(str)) {
                if (d10 || a(context, str2, str)) {
                    if (TextUtils.isEmpty(vVar.a())) {
                        vVar.a(context.getPackageName());
                    }
                    Intent intent = new Intent();
                    intent.setFlags(1048576);
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setAction(str2);
                    }
                    intent.setPackage(str);
                    intent.setClassName(str, d10 ? "com.vivo.push.sdk.service.CommandService" : "com.vivo.push.sdk.service.CommandClientService");
                    intent.putExtra("security_avoid_pull", com.vivo.push.util.a.a(context).a("com.vivo.pushservice"));
                    vVar.b(intent);
                    intent.putExtra("command_type", "reflect_receiver");
                    intent.putExtra("security_avoid_pull_rsa", b.a().a(context).a("com.vivo.pushservice"));
                    intent.putExtra("security_avoid_rsa_public_key", ab.a(b.a().a(context).a()));
                    a(context, intent);
                    return;
                }
                return;
            }
            u.c(context, "消息接受者包名为空！");
            throw new Exception("消息接受者包名为空！");
        } catch (Exception e2) {
            u.a("CommandBridge", "CommandBridge sendCommandToClient exception", e2);
        }
    }

    private static boolean a(Context context, String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return true;
            }
            u.b("CommandBridge", "action check error：action>>" + str + ";pkgname>>" + str2);
            return false;
        } catch (Exception unused) {
            u.b("CommandBridge", "queryBroadcastReceivers error");
            return false;
        }
    }
}
