package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a1 extends x0 {

    /* renamed from: a, reason: collision with root package name */
    public final z0 f24743a = new z0();

    @Override // com.google.android.gms.internal.mlkit_vision_face.x0
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            this.f24743a.a(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
