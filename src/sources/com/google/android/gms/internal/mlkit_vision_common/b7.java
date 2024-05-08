package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b7 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public static a7 f24252a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzq<String> f24253b = zzq.zzf("common", "vision-common", "play-services-mlkit-barcode-scanning", "barcode-scanning", "play-services-mlkit-face-detection", "face-detection", "play-services-mlkit-image-labeling", "play-services-mlkit-text-recognition");

    public static synchronized q6 a(String str) {
        q6 b4;
        synchronized (b7.class) {
            i6 f10 = j6.f("vision-common");
            f10.a(f24253b.contains("vision-common"));
            b4 = b(f10.e());
        }
        return b4;
    }

    public static synchronized q6 b(j6 j6Var) {
        q6 b4;
        synchronized (b7.class) {
            if (f24252a == null) {
                f24252a = new a7(null);
            }
            b4 = f24252a.b(j6Var);
        }
        return b4;
    }
}
