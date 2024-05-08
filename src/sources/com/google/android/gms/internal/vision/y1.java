package com.google.android.gms.internal.vision;

import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y1 extends u1 {

    /* renamed from: b, reason: collision with root package name */
    public final x1 f25704b = new x1();

    @Override // com.google.android.gms.internal.vision.u1
    public final void a(Throwable th) {
        th.printStackTrace();
        List<Throwable> a10 = this.f25704b.a(th, false);
        if (a10 == null) {
            return;
        }
        synchronized (a10) {
            for (Throwable th2 : a10) {
                System.err.print("Suppressed: ");
                th2.printStackTrace();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.u1
    public final void b(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.f25704b.a(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
