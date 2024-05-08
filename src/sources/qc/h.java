package qc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Elf64Header.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h extends d {

    /* renamed from: j, reason: collision with root package name */
    public final i f53211j;

    public h(boolean z10, i iVar) {
        this.f53196a = z10;
        this.f53211j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z10 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f53197b = iVar.f(allocate, 16L);
        this.f53198c = iVar.i(allocate, 32L);
        this.f53199d = iVar.i(allocate, 40L);
        this.f53200e = iVar.f(allocate, 54L);
        this.f53201f = iVar.f(allocate, 56L);
        this.f53202g = iVar.f(allocate, 58L);
        this.f53203h = iVar.f(allocate, 60L);
        this.f53204i = iVar.f(allocate, 62L);
    }

    @Override // qc.d
    public c a(long j10, int i10) {
        return new b(this.f53211j, this, j10, i10);
    }

    @Override // qc.d
    public e b(long j10) {
        return new k(this.f53211j, this, j10);
    }

    @Override // qc.d
    public f c(int i10) {
        return new m(this.f53211j, this, i10);
    }
}
