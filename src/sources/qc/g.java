package qc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Elf32Header.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class g extends d {

    /* renamed from: j, reason: collision with root package name */
    public final i f53210j;

    public g(boolean z10, i iVar) {
        this.f53196a = z10;
        this.f53210j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z10 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f53197b = iVar.f(allocate, 16L);
        this.f53198c = iVar.k(allocate, 28L);
        this.f53199d = iVar.k(allocate, 32L);
        this.f53200e = iVar.f(allocate, 42L);
        this.f53201f = iVar.f(allocate, 44L);
        this.f53202g = iVar.f(allocate, 46L);
        this.f53203h = iVar.f(allocate, 48L);
        this.f53204i = iVar.f(allocate, 50L);
    }

    @Override // qc.d
    public c a(long j10, int i10) {
        return new a(this.f53210j, this, j10, i10);
    }

    @Override // qc.d
    public e b(long j10) {
        return new j(this.f53210j, this, j10);
    }

    @Override // qc.d
    public f c(int i10) {
        return new l(this.f53210j, this, i10);
    }
}
