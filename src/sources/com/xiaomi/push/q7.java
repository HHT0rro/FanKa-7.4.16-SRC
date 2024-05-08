package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class q7 extends p7 {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Runnable f48103e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q7(Context context, File file, Runnable runnable) {
        super(context, file, null);
        this.f48103e = runnable;
    }

    @Override // com.xiaomi.push.p7
    public void a(Context context) {
        Runnable runnable = this.f48103e;
        if (runnable != null) {
            runnable.run();
        }
    }
}
