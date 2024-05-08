package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.f.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.List;

/* compiled from: ImageDownTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f46449a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f46450b;

    public q(p pVar, List list) {
        this.f46450b = pVar;
        this.f46449a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j10;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j11;
        int i10;
        NotifyArriveCallbackByUser notifyArriveCallbackByUser;
        u.a aVar;
        insideNotificationItem = this.f46450b.f46443b;
        if (insideNotificationItem != null) {
            ad b4 = ad.b();
            j10 = this.f46450b.f46444c;
            b4.a("com.vivo.push.notify_key", j10);
            context = this.f46450b.f46442a;
            List list = this.f46449a;
            insideNotificationItem2 = this.f46450b.f46443b;
            j11 = this.f46450b.f46444c;
            i10 = this.f46450b.f46446e;
            notifyArriveCallbackByUser = this.f46450b.f46447f;
            aVar = this.f46450b.f46448g;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j11, i10, notifyArriveCallbackByUser, aVar);
        }
    }
}
