package qc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Program32Header.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j extends e {
    public j(i iVar, d dVar, long j10) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(dVar.f53196a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = dVar.f53198c + (j10 * dVar.f53200e);
        this.f53205a = iVar.k(allocate, j11);
        this.f53206b = iVar.k(allocate, 4 + j11);
        this.f53207c = iVar.k(allocate, 8 + j11);
        this.f53208d = iVar.k(allocate, j11 + 20);
    }
}
