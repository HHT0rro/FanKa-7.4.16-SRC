package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: SampleDataQueue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final o6.b f21753a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21754b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f21755c;

    /* renamed from: d, reason: collision with root package name */
    public a f21756d;

    /* renamed from: e, reason: collision with root package name */
    public a f21757e;

    /* renamed from: f, reason: collision with root package name */
    public a f21758f;

    /* renamed from: g, reason: collision with root package name */
    public long f21759g;

    /* compiled from: SampleDataQueue.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f21760a;

        /* renamed from: b, reason: collision with root package name */
        public final long f21761b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f21762c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public o6.a f21763d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public a f21764e;

        public a(long j10, int i10) {
            this.f21760a = j10;
            this.f21761b = j10 + i10;
        }

        public a a() {
            this.f21763d = null;
            a aVar = this.f21764e;
            this.f21764e = null;
            return aVar;
        }

        public void b(o6.a aVar, a aVar2) {
            this.f21763d = aVar;
            this.f21764e = aVar2;
            this.f21762c = true;
        }

        public int c(long j10) {
            return ((int) (j10 - this.f21760a)) + this.f21763d.f52288b;
        }
    }

    public j0(o6.b bVar) {
        this.f21753a = bVar;
        int e2 = bVar.e();
        this.f21754b = e2;
        this.f21755c = new ParsableByteArray(32);
        a aVar = new a(0L, e2);
        this.f21756d = aVar;
        this.f21757e = aVar;
        this.f21758f = aVar;
    }

    public static a d(a aVar, long j10) {
        while (j10 >= aVar.f21761b) {
            aVar = aVar.f21764e;
        }
        return aVar;
    }

    public static a i(a aVar, long j10, ByteBuffer byteBuffer, int i10) {
        a d10 = d(aVar, j10);
        while (i10 > 0) {
            int min = Math.min(i10, (int) (d10.f21761b - j10));
            byteBuffer.put(d10.f21763d.f52287a, d10.c(j10), min);
            i10 -= min;
            j10 += min;
            if (j10 == d10.f21761b) {
                d10 = d10.f21764e;
            }
        }
        return d10;
    }

    public static a j(a aVar, long j10, byte[] bArr, int i10) {
        a d10 = d(aVar, j10);
        int i11 = i10;
        while (i11 > 0) {
            int min = Math.min(i11, (int) (d10.f21761b - j10));
            System.arraycopy((Object) d10.f21763d.f52287a, d10.c(j10), (Object) bArr, i10 - i11, min);
            i11 -= min;
            j10 += min;
            if (j10 == d10.f21761b) {
                d10 = d10.f21764e;
            }
        }
        return d10;
    }

    public static a k(a aVar, DecoderInputBuffer decoderInputBuffer, l0.b bVar, ParsableByteArray parsableByteArray) {
        int i10;
        long j10 = bVar.f21799b;
        parsableByteArray.L(1);
        a j11 = j(aVar, j10, parsableByteArray.d(), 1);
        long j12 = j10 + 1;
        byte b4 = parsableByteArray.d()[0];
        boolean z10 = (b4 & 128) != 0;
        int i11 = b4 & Byte.MAX_VALUE;
        z4.b bVar2 = decoderInputBuffer.f19881c;
        byte[] bArr = bVar2.f54840a;
        if (bArr == null) {
            bVar2.f54840a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a j13 = j(j11, j12, bVar2.f54840a, i11);
        long j14 = j12 + i11;
        if (z10) {
            parsableByteArray.L(2);
            j13 = j(j13, j14, parsableByteArray.d(), 2);
            j14 += 2;
            i10 = parsableByteArray.J();
        } else {
            i10 = 1;
        }
        int[] iArr = bVar2.f54843d;
        if (iArr == null || iArr.length < i10) {
            iArr = new int[i10];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = bVar2.f54844e;
        if (iArr3 == null || iArr3.length < i10) {
            iArr3 = new int[i10];
        }
        int[] iArr4 = iArr3;
        if (z10) {
            int i12 = i10 * 6;
            parsableByteArray.L(i12);
            j13 = j(j13, j14, parsableByteArray.d(), i12);
            j14 += i12;
            parsableByteArray.P(0);
            for (int i13 = 0; i13 < i10; i13++) {
                iArr2[i13] = parsableByteArray.J();
                iArr4[i13] = parsableByteArray.H();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.f21798a - ((int) (j14 - bVar.f21799b));
        }
        TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) com.google.android.exoplayer2.util.j0.j(bVar.f21800c);
        bVar2.c(i10, iArr2, iArr4, cryptoData.encryptionKey, bVar2.f54840a, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        long j15 = bVar.f21799b;
        int i14 = (int) (j14 - j15);
        bVar.f21799b = j15 + i14;
        bVar.f21798a -= i14;
        return j13;
    }

    public static a l(a aVar, DecoderInputBuffer decoderInputBuffer, l0.b bVar, ParsableByteArray parsableByteArray) {
        if (decoderInputBuffer.s()) {
            aVar = k(aVar, decoderInputBuffer, bVar, parsableByteArray);
        }
        if (decoderInputBuffer.k()) {
            parsableByteArray.L(4);
            a j10 = j(aVar, bVar.f21799b, parsableByteArray.d(), 4);
            int H = parsableByteArray.H();
            bVar.f21799b += 4;
            bVar.f21798a -= 4;
            decoderInputBuffer.q(H);
            a i10 = i(j10, bVar.f21799b, decoderInputBuffer.f19882d, H);
            bVar.f21799b += H;
            int i11 = bVar.f21798a - H;
            bVar.f21798a = i11;
            decoderInputBuffer.u(i11);
            return i(i10, bVar.f21799b, decoderInputBuffer.f19885g, bVar.f21798a);
        }
        decoderInputBuffer.q(bVar.f21798a);
        return i(aVar, bVar.f21799b, decoderInputBuffer.f19882d, bVar.f21798a);
    }

    public final void a(a aVar) {
        if (aVar.f21762c) {
            a aVar2 = this.f21758f;
            boolean z10 = aVar2.f21762c;
            int i10 = (z10 ? 1 : 0) + (((int) (aVar2.f21760a - aVar.f21760a)) / this.f21754b);
            o6.a[] aVarArr = new o6.a[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                aVarArr[i11] = aVar.f21763d;
                aVar = aVar.a();
            }
            this.f21753a.b(aVarArr);
        }
    }

    public void b(long j10) {
        a aVar;
        if (j10 == -1) {
            return;
        }
        while (true) {
            aVar = this.f21756d;
            if (j10 < aVar.f21761b) {
                break;
            }
            this.f21753a.d(aVar.f21763d);
            this.f21756d = this.f21756d.a();
        }
        if (this.f21757e.f21760a < aVar.f21760a) {
            this.f21757e = aVar;
        }
    }

    public void c(long j10) {
        this.f21759g = j10;
        if (j10 != 0) {
            a aVar = this.f21756d;
            if (j10 != aVar.f21760a) {
                while (this.f21759g > aVar.f21761b) {
                    aVar = aVar.f21764e;
                }
                a aVar2 = aVar.f21764e;
                a(aVar2);
                a aVar3 = new a(aVar.f21761b, this.f21754b);
                aVar.f21764e = aVar3;
                if (this.f21759g == aVar.f21761b) {
                    aVar = aVar3;
                }
                this.f21758f = aVar;
                if (this.f21757e == aVar2) {
                    this.f21757e = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.f21756d);
        a aVar4 = new a(this.f21759g, this.f21754b);
        this.f21756d = aVar4;
        this.f21757e = aVar4;
        this.f21758f = aVar4;
    }

    public long e() {
        return this.f21759g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, l0.b bVar) {
        l(this.f21757e, decoderInputBuffer, bVar, this.f21755c);
    }

    public final void g(int i10) {
        long j10 = this.f21759g + i10;
        this.f21759g = j10;
        a aVar = this.f21758f;
        if (j10 == aVar.f21761b) {
            this.f21758f = aVar.f21764e;
        }
    }

    public final int h(int i10) {
        a aVar = this.f21758f;
        if (!aVar.f21762c) {
            aVar.b(this.f21753a.c(), new a(this.f21758f.f21761b, this.f21754b));
        }
        return Math.min(i10, (int) (this.f21758f.f21761b - this.f21759g));
    }

    public void m(DecoderInputBuffer decoderInputBuffer, l0.b bVar) {
        this.f21757e = l(this.f21757e, decoderInputBuffer, bVar, this.f21755c);
    }

    public void n() {
        a(this.f21756d);
        a aVar = new a(0L, this.f21754b);
        this.f21756d = aVar;
        this.f21757e = aVar;
        this.f21758f = aVar;
        this.f21759g = 0L;
        this.f21753a.a();
    }

    public void o() {
        this.f21757e = this.f21756d;
    }

    public int p(o6.g gVar, int i10, boolean z10) throws IOException {
        int h10 = h(i10);
        a aVar = this.f21758f;
        int read = gVar.read(aVar.f21763d.f52287a, aVar.c(this.f21759g), h10);
        if (read != -1) {
            g(read);
            return read;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    public void q(ParsableByteArray parsableByteArray, int i10) {
        while (i10 > 0) {
            int h10 = h(i10);
            a aVar = this.f21758f;
            parsableByteArray.j(aVar.f21763d.f52287a, aVar.c(this.f21759g), h10);
            i10 -= h10;
            g(h10);
        }
    }
}
