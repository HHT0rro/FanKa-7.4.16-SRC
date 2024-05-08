package qc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Program64Header.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k extends e {
    public k(i iVar, d dVar, long j10) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(dVar.f53196a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = dVar.f53198c + (j10 * dVar.f53200e);
        this.f53205a = iVar.k(allocate, j11);
        this.f53206b = iVar.i(allocate, 8 + j11);
        this.f53207c = iVar.i(allocate, 16 + j11);
        this.f53208d = iVar.i(allocate, j11 + 40);
    }
}
