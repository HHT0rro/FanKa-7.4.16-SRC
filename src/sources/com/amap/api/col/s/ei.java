package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: ByteJoinDataStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ei extends eo {

    /* renamed from: a, reason: collision with root package name */
    public ByteArrayOutputStream f7910a;

    public ei() {
        this.f7910a = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.s.eo
    public final byte[] a(byte[] bArr) {
        byte[] byteArray = this.f7910a.toByteArray();
        try {
            this.f7910a.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f7910a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.s.eo
    public final void b(byte[] bArr) {
        try {
            this.f7910a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ei(eo eoVar) {
        super(eoVar);
        this.f7910a = new ByteArrayOutputStream();
    }
}
