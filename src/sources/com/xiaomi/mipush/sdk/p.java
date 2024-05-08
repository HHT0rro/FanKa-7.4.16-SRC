package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.id;
import com.xiaomi.push.it;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static int f47067a;

    public static MiPushCommandMessage a(String str, List<String> list, long j10, String str2, String str3) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j10);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        return miPushCommandMessage;
    }

    public static MiPushMessage b(it itVar, id idVar, boolean z10) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(itVar.m3037a());
        if (!TextUtils.isEmpty(itVar.d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(itVar.d());
        } else if (!TextUtils.isEmpty(itVar.c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(itVar.c());
        } else if (TextUtils.isEmpty(itVar.f())) {
            miPushMessage.setMessageType(0);
        } else {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(itVar.f());
        }
        miPushMessage.setCategory(itVar.e());
        if (itVar.a() != null) {
            miPushMessage.setContent(itVar.a().c());
        }
        if (idVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(idVar.m2970a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(idVar.m2975b());
            }
            miPushMessage.setDescription(idVar.d());
            miPushMessage.setTitle(idVar.m2978c());
            miPushMessage.setNotifyType(idVar.a());
            miPushMessage.setNotifyId(idVar.c());
            miPushMessage.setPassThrough(idVar.b());
            miPushMessage.setExtra(idVar.m2971a());
        }
        miPushMessage.setNotified(z10);
        return miPushMessage;
    }

    public static int c(Context context) {
        if (f47067a == 0) {
            g(e(context) ? 1 : 2);
        }
        return f47067a;
    }

    public static boolean d(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean e(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return d(context, intent);
    }

    public static void f(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(RemoteMessageConst.MSGTYPE, 3);
        intent.putExtra("key_command", miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void g(int i10) {
        f47067a = i10;
    }
}
