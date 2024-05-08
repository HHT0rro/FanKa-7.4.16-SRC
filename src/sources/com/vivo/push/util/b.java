package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.security.PublicKey;
import java.util.HashMap;

/* compiled from: BaseConvertMsgToIntent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public String f46409a;

    /* renamed from: b, reason: collision with root package name */
    public long f46410b;

    /* renamed from: c, reason: collision with root package name */
    public Context f46411c;

    /* renamed from: d, reason: collision with root package name */
    public NotifyArriveCallbackByUser f46412d;

    public static void a(Intent intent, Context context) {
        try {
            intent.putExtra("security_avoid_pull", a.a(context).a("com.vivo.pushservice"));
            String a10 = com.vivo.push.e.b.a().a(context).a("com.vivo.pushservice");
            PublicKey a11 = com.vivo.push.e.b.a().a(context).a();
            if (TextUtils.isEmpty(a10)) {
                a10 = "com.vivo.pushservice";
            }
            intent.putExtra("security_avoid_pull_rsa", a10);
            intent.putExtra("security_avoid_rsa_public_key", a11 == null ? "com.vivo.pushservice" : ab.a(a11));
        } catch (Exception e2) {
            u.a("BaseNotifyClickIntentParam", "pushNotificationBySystem encrypt ：" + e2.getMessage());
            intent.putExtra("security_avoid_pull_rsa", "com.vivo.pushservice");
            intent.putExtra("security_avoid_rsa_public_key", "com.vivo.pushservice");
        }
    }

    public abstract int a();

    public abstract PendingIntent a(Context context, Intent intent);

    public abstract Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser);

    public final long b() {
        return this.f46410b;
    }

    public final Intent a(Context context, String str, long j10, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.f46410b = j10;
        this.f46409a = str;
        this.f46411c = context;
        this.f46412d = notifyArriveCallbackByUser;
        Intent a10 = a(context, insideNotificationItem, notifyArriveCallbackByUser);
        int a11 = a();
        if (a11 <= 0) {
            return a10;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("messageID", String.valueOf(this.f46410b));
        String a12 = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a12)) {
            hashMap.put("remoteAppId", a12);
        }
        hashMap.put(IAdInterListener.AdReqParam.AP, this.f46409a);
        hashMap.put("clientsdkver", String.valueOf(ag.c(this.f46411c, this.f46409a)));
        f.a(a11, (HashMap<String, String>) hashMap);
        return null;
    }

    public static Intent a(Context context, String str, long j10, Intent intent, InsideNotificationItem insideNotificationItem) {
        Intent intent2 = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        intent2.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent2.putExtra("command_type", "reflect_receiver");
        intent2.putExtras(intent.getExtras());
        a(intent2, context);
        com.vivo.push.b.p pVar = new com.vivo.push.b.p(str, j10, insideNotificationItem);
        pVar.b(intent.getAction());
        if (intent.getComponent() != null) {
            pVar.c(intent.getComponent().getPackageName());
            pVar.d(intent.getComponent().getClassName());
        }
        if (intent.getData() != null) {
            pVar.a(intent.getData());
        }
        pVar.b(intent2);
        return intent2;
    }
}
