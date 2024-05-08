package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h9 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public static g9 f24927a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzbm<String> f24928b = zzbm.zzf("common", "vision-common", "play-services-mlkit-barcode-scanning", "barcode-scanning", "play-services-mlkit-face-detection", "face-detection", "play-services-mlkit-image-labeling", "play-services-mlkit-text-recognition");

    public static synchronized w8 a(String str) {
        w8 b4;
        synchronized (h9.class) {
            n8 f10 = o8.f(str);
            f10.a(f24928b.contains(str));
            b4 = b(f10.e());
        }
        return b4;
    }

    public static synchronized w8 b(o8 o8Var) {
        w8 b4;
        synchronized (h9.class) {
            if (f24927a == null) {
                f24927a = new g9(null);
            }
            b4 = f24927a.b(o8Var);
        }
        return b4;
    }
}
