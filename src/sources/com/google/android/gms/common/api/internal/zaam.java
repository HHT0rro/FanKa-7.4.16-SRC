package com.google.android.gms.common.api.internal;

import androidx.annotation.BinderThread;
import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zam;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zaam extends zad {
    private final WeakReference<o> zaa;

    public zaam(o oVar) {
        this.zaa = new WeakReference<>(oVar);
    }

    @Override // com.google.android.gms.signin.internal.zad, com.google.android.gms.signin.internal.zac
    @BinderThread
    public final void zaa(zam zamVar) {
        o oVar = this.zaa.get();
        if (oVar == null) {
            return;
        }
        o.a(oVar);
        new p(this, oVar, oVar, zamVar);
        throw null;
    }
}
