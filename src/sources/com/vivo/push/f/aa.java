package com.vivo.push.f;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.rtmp.TXLiveConstants;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.NotifyAdapterUtil;
import java.security.PublicKey;

/* compiled from: OnReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class aa extends com.vivo.push.s {

    /* renamed from: b, reason: collision with root package name */
    public PushMessageCallback f46183b;

    /* renamed from: c, reason: collision with root package name */
    private int f46184c;

    public aa(com.vivo.push.v vVar) {
        super(vVar);
        this.f46184c = 0;
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        this.f46183b = pushMessageCallback;
    }

    public final int b() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24) {
            return 0;
        }
        NotificationManager notificationManager = (NotificationManager) this.f46360a.getSystemService("notification");
        if (notificationManager != null && !notificationManager.areNotificationsEnabled()) {
            return TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG;
        }
        if (i10 < 26 || notificationManager == null) {
            return 0;
        }
        try {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(NotifyAdapterUtil.PRIMARY_CHANNEL);
            if (notificationChannel != null) {
                return notificationChannel.getImportance() == 0 ? 2121 : 0;
            }
            return 0;
        } catch (Exception unused) {
            com.vivo.push.util.u.b("OnVerifyCallBackCommand", "判断通知通道出现系统错误");
            return 0;
        }
    }

    public final int c() {
        return this.f46184c;
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        if (!com.vivo.push.m.a().d()) {
            com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        }
        if (publicKey == null) {
            com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify key is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            com.vivo.push.util.u.d("OnVerifyCallBackCommand", "contentTag is null");
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                com.vivo.push.util.u.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
                if (com.vivo.push.util.ab.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                    com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify id is success");
                    return true;
                }
                com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(str));
                com.vivo.push.util.u.c(this.f46360a, "vertify fail srcDigest is ".concat(str));
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify exception");
                return false;
            }
        }
        com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify id is null");
        return false;
    }

    public final int a(NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        if (notifyArriveCallbackByUser == null) {
            com.vivo.push.util.u.b("OnVerifyCallBackCommand", "pkg name : " + this.f46360a.getPackageName() + " 应用到达回调返回值为空，不做处理");
            com.vivo.push.util.u.b(this.f46360a, "应用到达回调返回值异常，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回正确的对象");
            return 2163;
        }
        if (!notifyArriveCallbackByUser.isIntercept()) {
            return 0;
        }
        com.vivo.push.util.u.b("OnVerifyCallBackCommand", "pkg name : " + this.f46360a.getPackageName() + " 应用主动拦截通知");
        com.vivo.push.util.u.b(this.f46360a, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
        return 2120;
    }

    public final void a(int i10) {
        this.f46184c = i10;
    }
}
