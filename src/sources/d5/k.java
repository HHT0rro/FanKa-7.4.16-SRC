package d5;

import java.io.IOException;

/* compiled from: ForwardingExtractorInput.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class k implements d {

    /* renamed from: a, reason: collision with root package name */
    public final d f48637a;

    public k(d dVar) {
        this.f48637a = dVar;
    }

    @Override // d5.d
    public long b() {
        return this.f48637a.b();
    }

    @Override // d5.d
    public boolean f(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        return this.f48637a.f(bArr, i10, i11, z10);
    }

    @Override // d5.d
    public int g(int i10) throws IOException {
        return this.f48637a.g(i10);
    }

    @Override // d5.d
    public long getPosition() {
        return this.f48637a.getPosition();
    }

    @Override // d5.d
    public int h(byte[] bArr, int i10, int i11) throws IOException {
        return this.f48637a.h(bArr, i10, i11);
    }

    @Override // d5.d
    public void j(byte[] bArr, int i10, int i11) throws IOException {
        this.f48637a.j(bArr, i10, i11);
    }

    @Override // d5.d
    public boolean l(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        return this.f48637a.l(bArr, i10, i11, z10);
    }

    @Override // d5.d
    public void m() {
        this.f48637a.m();
    }

    @Override // d5.d
    public long o() {
        return this.f48637a.o();
    }

    @Override // d5.d
    public void q(int i10) throws IOException {
        this.f48637a.q(i10);
    }

    @Override // d5.d
    public void r(int i10) throws IOException {
        this.f48637a.r(i10);
    }

    @Override // d5.d, o6.g
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return this.f48637a.read(bArr, i10, i11);
    }

    @Override // d5.d
    public void readFully(byte[] bArr, int i10, int i11) throws IOException {
        this.f48637a.readFully(bArr, i10, i11);
    }

    @Override // d5.d
    public boolean s(int i10, boolean z10) throws IOException {
        return this.f48637a.s(i10, z10);
    }
}
