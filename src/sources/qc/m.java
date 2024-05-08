package qc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Section64Header.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m extends f {
    public m(i iVar, d dVar, int i10) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(dVar.f53196a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f53209a = iVar.k(allocate, dVar.f53199d + (i10 * dVar.f53202g) + 44);
    }
}
