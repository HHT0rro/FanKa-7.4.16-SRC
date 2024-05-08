package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k2 extends u1 {
    @Override // com.google.android.gms.internal.vision.u1
    public final void a(Throwable th) {
        th.printStackTrace();
    }

    @Override // com.google.android.gms.internal.vision.u1
    public final void b(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }
}
