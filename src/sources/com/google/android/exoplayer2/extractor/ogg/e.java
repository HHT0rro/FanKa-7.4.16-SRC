package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: OggPacket.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final f f20303a = new f();

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f20304b = new ParsableByteArray(new byte[65025], 0);

    /* renamed from: c, reason: collision with root package name */
    public int f20305c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f20306d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20307e;

    public final int a(int i10) {
        int i11;
        int i12 = 0;
        this.f20306d = 0;
        do {
            int i13 = this.f20306d;
            int i14 = i10 + i13;
            f fVar = this.f20303a;
            if (i14 >= fVar.f20314g) {
                break;
            }
            int[] iArr = fVar.f20317j;
            this.f20306d = i13 + 1;
            i11 = iArr[i13 + i10];
            i12 += i11;
        } while (i11 == 255);
        return i12;
    }

    public f b() {
        return this.f20303a;
    }

    public ParsableByteArray c() {
        return this.f20304b;
    }

    public boolean d(d5.d dVar) throws IOException {
        int i10;
        com.google.android.exoplayer2.util.a.g(dVar != null);
        if (this.f20307e) {
            this.f20307e = false;
            this.f20304b.L(0);
        }
        while (!this.f20307e) {
            if (this.f20305c < 0) {
                if (!this.f20303a.c(dVar) || !this.f20303a.a(dVar, true)) {
                    return false;
                }
                f fVar = this.f20303a;
                int i11 = fVar.f20315h;
                if ((fVar.f20309b & 1) == 1 && this.f20304b.f() == 0) {
                    i11 += a(0);
                    i10 = this.f20306d + 0;
                } else {
                    i10 = 0;
                }
                if (!d5.f.e(dVar, i11)) {
                    return false;
                }
                this.f20305c = i10;
            }
            int a10 = a(this.f20305c);
            int i12 = this.f20305c + this.f20306d;
            if (a10 > 0) {
                ParsableByteArray parsableByteArray = this.f20304b;
                parsableByteArray.c(parsableByteArray.f() + a10);
                if (!d5.f.d(dVar, this.f20304b.d(), this.f20304b.f(), a10)) {
                    return false;
                }
                ParsableByteArray parsableByteArray2 = this.f20304b;
                parsableByteArray2.O(parsableByteArray2.f() + a10);
                this.f20307e = this.f20303a.f20317j[i12 + (-1)] != 255;
            }
            if (i12 == this.f20303a.f20314g) {
                i12 = -1;
            }
            this.f20305c = i12;
        }
        return true;
    }

    public void e() {
        this.f20303a.b();
        this.f20304b.L(0);
        this.f20305c = -1;
        this.f20307e = false;
    }

    public void f() {
        if (this.f20304b.d().length == 65025) {
            return;
        }
        ParsableByteArray parsableByteArray = this.f20304b;
        parsableByteArray.N(Arrays.copyOf(parsableByteArray.d(), Math.max(65025, this.f20304b.f())), this.f20304b.f());
    }
}
