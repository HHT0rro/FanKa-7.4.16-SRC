package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i extends OutputStream {

    /* renamed from: b, reason: collision with root package name */
    public long f24366b = 0;

    public final long a() {
        return this.f24366b;
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        this.f24366b++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f24366b += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr, int i10, int i11) {
        int length;
        int i12;
        if (i10 >= 0 && i10 <= (length = bArr.length) && i11 >= 0 && (i12 = i10 + i11) <= length && i12 >= 0) {
            this.f24366b += i11;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
