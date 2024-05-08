package d5;

import com.google.android.exoplayer2.util.j0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* compiled from: DefaultExtractorInput.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements d {

    /* renamed from: b, reason: collision with root package name */
    public final o6.g f48614b;

    /* renamed from: c, reason: collision with root package name */
    public final long f48615c;

    /* renamed from: d, reason: collision with root package name */
    public long f48616d;

    /* renamed from: f, reason: collision with root package name */
    public int f48618f;

    /* renamed from: g, reason: collision with root package name */
    public int f48619g;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f48617e = new byte[65536];

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f48613a = new byte[4096];

    public b(o6.g gVar, long j10, long j11) {
        this.f48614b = gVar;
        this.f48616d = j10;
        this.f48615c = j11;
    }

    @Override // d5.d
    public long b() {
        return this.f48615c;
    }

    @Override // d5.d
    public boolean f(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        int u10 = u(bArr, i10, i11);
        while (u10 < i11 && u10 != -1) {
            u10 = v(bArr, i10, i11, u10, z10);
        }
        n(u10);
        return u10 != -1;
    }

    @Override // d5.d
    public int g(int i10) throws IOException {
        int w3 = w(i10);
        if (w3 == 0) {
            byte[] bArr = this.f48613a;
            w3 = v(bArr, 0, Math.min(i10, bArr.length), 0, true);
        }
        n(w3);
        return w3;
    }

    @Override // d5.d
    public long getPosition() {
        return this.f48616d;
    }

    @Override // d5.d
    public int h(byte[] bArr, int i10, int i11) throws IOException {
        int min;
        t(i11);
        int i12 = this.f48619g;
        int i13 = this.f48618f;
        int i14 = i12 - i13;
        if (i14 == 0) {
            min = v(this.f48617e, i13, i11, 0, true);
            if (min == -1) {
                return -1;
            }
            this.f48619g += min;
        } else {
            min = Math.min(i11, i14);
        }
        System.arraycopy((Object) this.f48617e, this.f48618f, (Object) bArr, i10, min);
        this.f48618f += min;
        return min;
    }

    @Override // d5.d
    public void j(byte[] bArr, int i10, int i11) throws IOException {
        l(bArr, i10, i11, false);
    }

    @Override // d5.d
    public boolean l(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        if (!s(i11, z10)) {
            return false;
        }
        System.arraycopy((Object) this.f48617e, this.f48618f - i11, (Object) bArr, i10, i11);
        return true;
    }

    @Override // d5.d
    public void m() {
        this.f48618f = 0;
    }

    public final void n(int i10) {
        if (i10 != -1) {
            this.f48616d += i10;
        }
    }

    @Override // d5.d
    public long o() {
        return this.f48616d + this.f48618f;
    }

    @Override // d5.d
    public void q(int i10) throws IOException {
        s(i10, false);
    }

    @Override // d5.d
    public void r(int i10) throws IOException {
        x(i10, false);
    }

    @Override // d5.d, o6.g
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int u10 = u(bArr, i10, i11);
        if (u10 == 0) {
            u10 = v(bArr, i10, i11, 0, true);
        }
        n(u10);
        return u10;
    }

    @Override // d5.d
    public void readFully(byte[] bArr, int i10, int i11) throws IOException {
        f(bArr, i10, i11, false);
    }

    @Override // d5.d
    public boolean s(int i10, boolean z10) throws IOException {
        t(i10);
        int i11 = this.f48619g - this.f48618f;
        while (i11 < i10) {
            i11 = v(this.f48617e, this.f48618f, i10, i11, z10);
            if (i11 == -1) {
                return false;
            }
            this.f48619g = this.f48618f + i11;
        }
        this.f48618f += i10;
        return true;
    }

    public final void t(int i10) {
        int i11 = this.f48618f + i10;
        byte[] bArr = this.f48617e;
        if (i11 > bArr.length) {
            this.f48617e = Arrays.copyOf(this.f48617e, j0.r(bArr.length * 2, 65536 + i11, i11 + 524288));
        }
    }

    public final int u(byte[] bArr, int i10, int i11) {
        int i12 = this.f48619g;
        if (i12 == 0) {
            return 0;
        }
        int min = Math.min(i12, i11);
        System.arraycopy((Object) this.f48617e, 0, (Object) bArr, i10, min);
        y(min);
        return min;
    }

    public final int v(byte[] bArr, int i10, int i11, int i12, boolean z10) throws IOException {
        if (!Thread.interrupted()) {
            int read = this.f48614b.read(bArr, i10 + i12, i11 - i12);
            if (read != -1) {
                return i12 + read;
            }
            if (i12 == 0 && z10) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    public final int w(int i10) {
        int min = Math.min(this.f48619g, i10);
        y(min);
        return min;
    }

    public boolean x(int i10, boolean z10) throws IOException {
        int w3 = w(i10);
        while (w3 < i10 && w3 != -1) {
            w3 = v(this.f48613a, -w3, Math.min(i10, this.f48613a.length + w3), w3, z10);
        }
        n(w3);
        return w3 != -1;
    }

    public final void y(int i10) {
        int i11 = this.f48619g - i10;
        this.f48619g = i11;
        this.f48618f = 0;
        byte[] bArr = this.f48617e;
        byte[] bArr2 = i11 < bArr.length - 524288 ? new byte[65536 + i11] : bArr;
        System.arraycopy((Object) bArr, i10, (Object) bArr2, 0, i11);
        this.f48617e = bArr2;
    }
}
