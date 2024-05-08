package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q implements a8.g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f24563a = false;

    /* renamed from: b, reason: collision with root package name */
    public final a8.c f24564b;

    /* renamed from: c, reason: collision with root package name */
    public final a8.e f24565c;

    public q(a8.c cVar, a8.e eVar) {
        this.f24564b = cVar;
        this.f24565c = eVar;
    }

    @Override // a8.g
    @NonNull
    public final a8.g a(@Nullable String str) throws IOException {
        c();
        this.f24565c.e(this.f24564b, str);
        return this;
    }

    @Override // a8.g
    @NonNull
    public final a8.g b(boolean z10) throws IOException {
        c();
        ((m) this.f24565c).h(this.f24564b, z10);
        return this;
    }

    public final void c() {
        if (this.f24563a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f24563a = true;
    }
}
