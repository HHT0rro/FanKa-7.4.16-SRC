package com.amap.api.col.p0003l;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: ByteJoinDataStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class io extends iu {

    /* renamed from: a, reason: collision with root package name */
    public ByteArrayOutputStream f6491a;

    public io() {
        this.f6491a = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.p0003l.iu
    public final byte[] a(byte[] bArr) {
        byte[] byteArray = this.f6491a.toByteArray();
        try {
            this.f6491a.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f6491a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.p0003l.iu
    public final void b(byte[] bArr) {
        try {
            this.f6491a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public io(iu iuVar) {
        super(iuVar);
        this.f6491a = new ByteArrayOutputStream();
    }
}
