package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: FlacStreamMetadata.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f20059a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20060b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20061c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20062d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20063e;

    /* renamed from: f, reason: collision with root package name */
    public final int f20064f;

    /* renamed from: g, reason: collision with root package name */
    public final int f20065g;

    /* renamed from: h, reason: collision with root package name */
    public final int f20066h;

    /* renamed from: i, reason: collision with root package name */
    public final int f20067i;

    /* renamed from: j, reason: collision with root package name */
    public final long f20068j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final a f20069k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public final Metadata f20070l;

    /* compiled from: FlacStreamMetadata.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f20071a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f20072b;

        public a(long[] jArr, long[] jArr2) {
            this.f20071a = jArr;
            this.f20072b = jArr2;
        }
    }

    public g(byte[] bArr, int i10) {
        u uVar = new u(bArr);
        uVar.p(i10 * 8);
        this.f20059a = uVar.h(16);
        this.f20060b = uVar.h(16);
        this.f20061c = uVar.h(24);
        this.f20062d = uVar.h(24);
        int h10 = uVar.h(20);
        this.f20063e = h10;
        this.f20064f = k(h10);
        this.f20065g = uVar.h(3) + 1;
        int h11 = uVar.h(5) + 1;
        this.f20066h = h11;
        this.f20067i = f(h11);
        this.f20068j = uVar.j(36);
        this.f20069k = null;
        this.f20070l = null;
    }

    @Nullable
    public static Metadata a(List<String> list, List<PictureFrame> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = list.get(i10);
            String[] N0 = j0.N0(str, "=");
            if (N0.length != 2) {
                String valueOf = String.valueOf(str);
                m.h("FlacStreamMetadata", valueOf.length() != 0 ? "Failed to parse Vorbis comment: ".concat(valueOf) : new String("Failed to parse Vorbis comment: "));
            } else {
                arrayList.add(new VorbisComment(N0[0], N0[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static int f(int i10) {
        if (i10 == 8) {
            return 1;
        }
        if (i10 == 12) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 != 20) {
            return i10 != 24 ? -1 : 6;
        }
        return 5;
    }

    public static int k(int i10) {
        switch (i10) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public g b(List<PictureFrame> list) {
        return new g(this.f20059a, this.f20060b, this.f20061c, this.f20062d, this.f20063e, this.f20065g, this.f20066h, this.f20068j, this.f20069k, i(a(Collections.emptyList(), list)));
    }

    public g c(@Nullable a aVar) {
        return new g(this.f20059a, this.f20060b, this.f20061c, this.f20062d, this.f20063e, this.f20065g, this.f20066h, this.f20068j, aVar, this.f20070l);
    }

    public g d(List<String> list) {
        return new g(this.f20059a, this.f20060b, this.f20061c, this.f20062d, this.f20063e, this.f20065g, this.f20066h, this.f20068j, this.f20069k, i(a(list, Collections.emptyList())));
    }

    public long e() {
        long j10;
        long j11;
        int i10 = this.f20062d;
        if (i10 > 0) {
            j10 = (i10 + this.f20061c) / 2;
            j11 = 1;
        } else {
            int i11 = this.f20059a;
            j10 = ((((i11 != this.f20060b || i11 <= 0) ? 4096L : i11) * this.f20065g) * this.f20066h) / 8;
            j11 = 64;
        }
        return j10 + j11;
    }

    public long g() {
        long j10 = this.f20068j;
        if (j10 == 0) {
            return -9223372036854775807L;
        }
        return (j10 * 1000000) / this.f20063e;
    }

    public Format h(byte[] bArr, @Nullable Metadata metadata) {
        bArr[4] = Byte.MIN_VALUE;
        int i10 = this.f20062d;
        if (i10 <= 0) {
            i10 = -1;
        }
        return new Format.b().e0("audio/flac").W(i10).H(this.f20065g).f0(this.f20063e).T(Collections.singletonList(bArr)).X(i(metadata)).E();
    }

    @Nullable
    public Metadata i(@Nullable Metadata metadata) {
        Metadata metadata2 = this.f20070l;
        return metadata2 == null ? metadata : metadata2.b(metadata);
    }

    public long j(long j10) {
        return j0.s((j10 * this.f20063e) / 1000000, 0L, this.f20068j - 1);
    }

    public g(int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, @Nullable a aVar, @Nullable Metadata metadata) {
        this.f20059a = i10;
        this.f20060b = i11;
        this.f20061c = i12;
        this.f20062d = i13;
        this.f20063e = i14;
        this.f20064f = k(i14);
        this.f20065g = i15;
        this.f20066h = i16;
        this.f20067i = f(i16);
        this.f20068j = j10;
        this.f20069k = aVar;
        this.f20070l = metadata;
    }
}
