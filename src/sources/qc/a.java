package qc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Dynamic32Structure.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a extends c {
    public a(i iVar, d dVar, long j10, int i10) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(dVar.f53196a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = j10 + (i10 * 8);
        this.f53194a = iVar.k(allocate, j11);
        this.f53195b = iVar.k(allocate, j11 + 4);
    }
}
