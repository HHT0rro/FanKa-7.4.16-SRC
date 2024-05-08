package com.vivo.push.f;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnNotificationArrivedReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InsideNotificationItem f46219a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.q f46220b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f46221c;

    public v(u uVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar) {
        this.f46221c = uVar;
        this.f46219a = insideNotificationItem;
        this.f46220b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        char c4;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        u uVar = this.f46221c;
        PushMessageCallback pushMessageCallback = ((aa) uVar).f46183b;
        context = uVar.f46360a;
        NotifyArriveCallbackByUser onNotificationMessageArrived = pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.v.a(this.f46219a));
        int a10 = this.f46221c.a(onNotificationMessageArrived);
        if (a10 > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("messageID", String.valueOf(this.f46220b.f()));
            String a11 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a11)) {
                hashMap.put("remoteAppId", a11);
            }
            context9 = this.f46221c.f46360a;
            context10 = this.f46221c.f46360a;
            hashMap.put("clientsdkver", String.valueOf(com.vivo.push.util.ag.c(context9, context10.getPackageName())));
            com.vivo.push.util.f.a(a10, (HashMap<String, String>) hashMap);
            return;
        }
        int b4 = this.f46221c.b();
        if (b4 > 0) {
            StringBuilder sb2 = new StringBuilder("pkg name : ");
            context7 = this.f46221c.f46360a;
            sb2.append(context7.getPackageName());
            sb2.append(" notify channel switch is ");
            sb2.append(b4);
            com.vivo.push.util.u.b("OnNotificationArrivedTask", sb2.toString());
            context8 = this.f46221c.f46360a;
            com.vivo.push.util.u.b(context8, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(b4)));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("messageID", String.valueOf(this.f46220b.f()));
            String a12 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a12)) {
                hashMap2.put("remoteAppId", a12);
            }
            com.vivo.push.util.f.a(b4, (HashMap<String, String>) hashMap2);
            return;
        }
        context2 = this.f46221c.f46360a;
        InsideNotificationItem insideNotificationItem = this.f46219a;
        long f10 = this.f46220b.f();
        u uVar2 = this.f46221c;
        PushMessageCallback pushMessageCallback2 = ((aa) uVar2).f46183b;
        context3 = uVar2.f46360a;
        com.vivo.push.util.p pVar = new com.vivo.push.util.p(context2, insideNotificationItem, f10, pushMessageCallback2.isAllowNet(context3), new w(this), onNotificationMessageArrived);
        boolean isShowBigPicOnMobileNet = this.f46219a.isShowBigPicOnMobileNet();
        String purePicUrl = this.f46219a.getPurePicUrl();
        if (TextUtils.isEmpty(purePicUrl)) {
            purePicUrl = this.f46219a.getCoverUrl();
        }
        if (!TextUtils.isEmpty(purePicUrl)) {
            com.vivo.push.util.u.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
            if (!isShowBigPicOnMobileNet) {
                context5 = this.f46221c.f46360a;
                com.vivo.push.util.u.a(context5, "mobile net unshow");
                context6 = this.f46221c.f46360a;
                NetworkInfo a13 = com.vivo.push.util.x.a(context6);
                if (a13 != null && a13.getState() == NetworkInfo.State.CONNECTED) {
                    int type = a13.getType();
                    c4 = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                } else {
                    c4 = 0;
                }
                if (c4 == 1) {
                    purePicUrl = null;
                    this.f46219a.clearCoverUrl();
                    this.f46219a.clearPurePicUrl();
                }
            } else {
                context4 = this.f46221c.f46360a;
                com.vivo.push.util.u.a(context4, "mobile net show");
            }
        }
        pVar.execute(this.f46219a.getIconUrl(), purePicUrl);
    }
}
