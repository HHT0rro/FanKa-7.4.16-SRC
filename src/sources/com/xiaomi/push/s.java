package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.r;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class s extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f48145a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, Looper looper) {
        super(looper);
        this.f48145a = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        r.b bVar = (r.b) message.obj;
        int i10 = message.what;
        if (i10 == 0) {
            bVar.a();
        } else if (i10 == 1) {
            bVar.c();
        }
        super.handleMessage(message);
    }
}
