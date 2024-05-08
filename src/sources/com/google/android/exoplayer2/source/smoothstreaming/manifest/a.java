package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.h0;
import com.google.android.exoplayer2.util.j0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import u5.d;

/* compiled from: SsManifest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a implements d<a> {

    /* renamed from: a, reason: collision with root package name */
    public final int f22101a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22102b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22103c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22104d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final C0205a f22105e;

    /* renamed from: f, reason: collision with root package name */
    public final b[] f22106f;

    /* renamed from: g, reason: collision with root package name */
    public final long f22107g;

    /* renamed from: h, reason: collision with root package name */
    public final long f22108h;

    /* compiled from: SsManifest.java */
    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class C0205a {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f22109a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f22110b;

        /* renamed from: c, reason: collision with root package name */
        public final TrackEncryptionBox[] f22111c;

        public C0205a(UUID uuid, byte[] bArr, TrackEncryptionBox[] trackEncryptionBoxArr) {
            this.f22109a = uuid;
            this.f22110b = bArr;
            this.f22111c = trackEncryptionBoxArr;
        }
    }

    public a(int i10, int i11, long j10, long j11, long j12, int i12, boolean z10, @Nullable C0205a c0205a, b[] bVarArr) {
        this(i10, i11, j11 == 0 ? -9223372036854775807L : j0.H0(j11, 1000000L, j10), j12 != 0 ? j0.H0(j12, 1000000L, j10) : -9223372036854775807L, i12, z10, c0205a, bVarArr);
    }

    @Override // u5.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final a a(List<StreamKey> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i10 = 0;
        while (i10 < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i10);
            b bVar2 = this.f22106f[streamKey.f21020c];
            if (bVar2 != bVar && bVar != null) {
                arrayList2.add(bVar.b((Format[]) arrayList3.toArray(new Format[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.f22121j[streamKey.f21021d]);
            i10++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.b((Format[]) arrayList3.toArray(new Format[0])));
        }
        return new a(this.f22101a, this.f22102b, this.f22107g, this.f22108h, this.f22103c, this.f22104d, this.f22105e, (b[]) arrayList2.toArray(new b[0]));
    }

    /* compiled from: SsManifest.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f22112a;

        /* renamed from: b, reason: collision with root package name */
        public final String f22113b;

        /* renamed from: c, reason: collision with root package name */
        public final long f22114c;

        /* renamed from: d, reason: collision with root package name */
        public final String f22115d;

        /* renamed from: e, reason: collision with root package name */
        public final int f22116e;

        /* renamed from: f, reason: collision with root package name */
        public final int f22117f;

        /* renamed from: g, reason: collision with root package name */
        public final int f22118g;

        /* renamed from: h, reason: collision with root package name */
        public final int f22119h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public final String f22120i;

        /* renamed from: j, reason: collision with root package name */
        public final Format[] f22121j;

        /* renamed from: k, reason: collision with root package name */
        public final int f22122k;

        /* renamed from: l, reason: collision with root package name */
        public final String f22123l;

        /* renamed from: m, reason: collision with root package name */
        public final String f22124m;

        /* renamed from: n, reason: collision with root package name */
        public final List<Long> f22125n;

        /* renamed from: o, reason: collision with root package name */
        public final long[] f22126o;

        /* renamed from: p, reason: collision with root package name */
        public final long f22127p;

        public b(String str, String str2, int i10, String str3, long j10, String str4, int i11, int i12, int i13, int i14, @Nullable String str5, Format[] formatArr, List<Long> list, long j11) {
            this(str, str2, i10, str3, j10, str4, i11, i12, i13, i14, str5, formatArr, list, j0.I0(list, 1000000L, j10), j0.H0(j11, 1000000L, j10));
        }

        public Uri a(int i10, int i11) {
            com.google.android.exoplayer2.util.a.g(this.f22121j != null);
            com.google.android.exoplayer2.util.a.g(this.f22125n != null);
            com.google.android.exoplayer2.util.a.g(i11 < this.f22125n.size());
            String num = Integer.toString(this.f22121j[i10].f19540i);
            String l10 = this.f22125n.get(i11).toString();
            return h0.e(this.f22123l, this.f22124m.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l10).replace("{start_time}", l10));
        }

        public b b(Format[] formatArr) {
            return new b(this.f22123l, this.f22124m, this.f22112a, this.f22113b, this.f22114c, this.f22115d, this.f22116e, this.f22117f, this.f22118g, this.f22119h, this.f22120i, formatArr, this.f22125n, this.f22126o, this.f22127p);
        }

        public long c(int i10) {
            if (i10 == this.f22122k - 1) {
                return this.f22127p;
            }
            long[] jArr = this.f22126o;
            return jArr[i10 + 1] - jArr[i10];
        }

        public int d(long j10) {
            return j0.i(this.f22126o, j10, true, true);
        }

        public long e(int i10) {
            return this.f22126o[i10];
        }

        public b(String str, String str2, int i10, String str3, long j10, String str4, int i11, int i12, int i13, int i14, @Nullable String str5, Format[] formatArr, List<Long> list, long[] jArr, long j11) {
            this.f22123l = str;
            this.f22124m = str2;
            this.f22112a = i10;
            this.f22113b = str3;
            this.f22114c = j10;
            this.f22115d = str4;
            this.f22116e = i11;
            this.f22117f = i12;
            this.f22118g = i13;
            this.f22119h = i14;
            this.f22120i = str5;
            this.f22121j = formatArr;
            this.f22125n = list;
            this.f22126o = jArr;
            this.f22127p = j11;
            this.f22122k = list.size();
        }
    }

    public a(int i10, int i11, long j10, long j11, int i12, boolean z10, @Nullable C0205a c0205a, b[] bVarArr) {
        this.f22101a = i10;
        this.f22102b = i11;
        this.f22107g = j10;
        this.f22108h = j11;
        this.f22103c = i12;
        this.f22104d = z10;
        this.f22105e = c0205a;
        this.f22106f = bVarArr;
    }
}
