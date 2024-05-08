package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o1 implements a8.g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f25105a = false;

    /* renamed from: b, reason: collision with root package name */
    public final a8.c f25106b;

    /* renamed from: c, reason: collision with root package name */
    public final a8.e f25107c;

    public o1(a8.c cVar, a8.e eVar) {
        this.f25106b = cVar;
        this.f25107c = eVar;
    }

    @Override // a8.g
    @NonNull
    public final a8.g a(@Nullable String str) throws IOException {
        c();
        this.f25107c.e(this.f25106b, str);
        return this;
    }

    @Override // a8.g
    @NonNull
    public final a8.g b(boolean z10) throws IOException {
        c();
        ((k1) this.f25107c).h(this.f25106b, z10);
        return this;
    }

    public final void c() {
        if (this.f25105a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f25105a = true;
    }
}
