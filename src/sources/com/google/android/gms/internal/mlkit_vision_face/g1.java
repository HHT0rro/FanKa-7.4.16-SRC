package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g1 extends OutputStream {

    /* renamed from: b, reason: collision with root package name */
    public long f24879b = 0;

    public final long a() {
        return this.f24879b;
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        this.f24879b++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f24879b += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr, int i10, int i11) {
        int length;
        int i12;
        if (i10 >= 0 && i10 <= (length = bArr.length) && i11 >= 0 && (i12 = i10 + i11) <= length && i12 >= 0) {
            this.f24879b += i11;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
