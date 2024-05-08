package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public static m0 f24187a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzal<String> f24188b = zzal.zzf("common", "vision-common", "play-services-mlkit-barcode-scanning", "barcode-scanning", "play-services-mlkit-face-detection", "face-detection", "play-services-mlkit-image-labeling", "play-services-mlkit-text-recognition");

    public static synchronized e0 a(String str) {
        e0 b4;
        synchronized (n0.class) {
            y f10 = z.f("common");
            f10.a(f24188b.contains("common"));
            b4 = b(f10.e());
        }
        return b4;
    }

    public static synchronized e0 b(z zVar) {
        e0 b4;
        synchronized (n0.class) {
            if (f24187a == null) {
                f24187a = new m0(null);
            }
            b4 = f24187a.b(zVar);
        }
        return b4;
    }
}
