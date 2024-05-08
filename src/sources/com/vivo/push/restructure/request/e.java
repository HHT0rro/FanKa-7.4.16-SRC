package com.vivo.push.restructure.request;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.g;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f46357a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper) {
        super(looper);
        this.f46357a = dVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Map map;
        Map map2;
        int i10 = message.what;
        map = this.f46357a.f46352a;
        if (map.containsKey(Integer.valueOf(i10))) {
            map2 = this.f46357a.f46352a;
            g.a().execute(new f(this, (b) map2.remove(Integer.valueOf(i10))));
        }
    }
}
