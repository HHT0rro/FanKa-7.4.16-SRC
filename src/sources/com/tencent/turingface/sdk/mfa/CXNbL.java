package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class CXNbL extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f45538a;

    public CXNbL(Context context) {
        this.f45538a = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        long j10;
        Context context = this.f45538a;
        String str = fenkF.f45789a;
        try {
            j10 = Long.valueOf(fenkF.b(context, "801")).longValue();
        } catch (Throwable unused) {
            j10 = 0;
        }
        if (j10 == 0) {
            Context context2 = this.f45538a;
            HashMap hashMap = new HashMap();
            StringBuilder b4 = com.tencent.turingcam.oqKCa.b("");
            b4.append(System.currentTimeMillis());
            hashMap.put("801", b4.toString());
            fenkF.a(context2, hashMap);
        }
    }
}
