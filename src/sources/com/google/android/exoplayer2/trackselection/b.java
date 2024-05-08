package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.q;
import java.util.Arrays;
import n6.i;

/* compiled from: MappingTrackSelector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class b extends i {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public a f22339c;

    /* compiled from: MappingTrackSelector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f22340a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f22341b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f22342c;

        /* renamed from: d, reason: collision with root package name */
        public final TrackGroupArray[] f22343d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f22344e;

        /* renamed from: f, reason: collision with root package name */
        public final int[][][] f22345f;

        /* renamed from: g, reason: collision with root package name */
        public final TrackGroupArray f22346g;

        public a(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f22341b = strArr;
            this.f22342c = iArr;
            this.f22343d = trackGroupArrayArr;
            this.f22345f = iArr3;
            this.f22344e = iArr2;
            this.f22346g = trackGroupArray;
            this.f22340a = iArr.length;
        }

        public int a(int i10, int i11, boolean z10) {
            int i12 = this.f22343d[i10].a(i11).f21168b;
            int[] iArr = new int[i12];
            int i13 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                int f10 = f(i10, i11, i14);
                if (f10 == 4 || (z10 && f10 == 3)) {
                    iArr[i13] = i14;
                    i13++;
                }
            }
            return b(i10, i11, Arrays.copyOf(iArr, i13));
        }

        public int b(int i10, int i11, int[] iArr) {
            int i12 = 0;
            String str = null;
            boolean z10 = false;
            int i13 = 0;
            int i14 = 16;
            while (i12 < iArr.length) {
                String str2 = this.f22343d[i10].a(i11).a(iArr[i12]).f19544m;
                int i15 = i13 + 1;
                if (i13 == 0) {
                    str = str2;
                } else {
                    z10 |= !j0.c(str, str2);
                }
                i14 = Math.min(i14, m1.c(this.f22345f[i10][i11][i12]));
                i12++;
                i13 = i15;
            }
            return z10 ? Math.min(i14, this.f22344e[i10]) : i14;
        }

        public int c() {
            return this.f22340a;
        }

        public int d(int i10) {
            return this.f22342c[i10];
        }

        public TrackGroupArray e(int i10) {
            return this.f22343d[i10];
        }

        public int f(int i10, int i11, int i12) {
            return m1.d(this.f22345f[i10][i11][i12]);
        }
    }

    public static int f(n1[] n1VarArr, TrackGroup trackGroup, int[] iArr, boolean z10) throws ExoPlaybackException {
        int length = n1VarArr.length;
        int i10 = 0;
        boolean z11 = true;
        for (int i11 = 0; i11 < n1VarArr.length; i11++) {
            n1 n1Var = n1VarArr[i11];
            int i12 = 0;
            for (int i13 = 0; i13 < trackGroup.f21168b; i13++) {
                i12 = Math.max(i12, m1.d(n1Var.a(trackGroup.a(i13))));
            }
            boolean z12 = iArr[i11] == 0;
            if (i12 > i10 || (i12 == i10 && z10 && !z11 && z12)) {
                length = i11;
                z11 = z12;
                i10 = i12;
            }
        }
        return length;
    }

    public static int[] h(n1 n1Var, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.f21168b];
        for (int i10 = 0; i10 < trackGroup.f21168b; i10++) {
            iArr[i10] = n1Var.a(trackGroup.a(i10));
        }
        return iArr;
    }

    public static int[] i(n1[] n1VarArr) throws ExoPlaybackException {
        int length = n1VarArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = n1VarArr[i10].w();
        }
        return iArr;
    }

    @Override // n6.i
    public final void d(@Nullable Object obj) {
        this.f22339c = (a) obj;
    }

    @Override // n6.i
    public final TrackSelectorResult e(n1[] n1VarArr, TrackGroupArray trackGroupArray, s.a aVar, Timeline timeline) throws ExoPlaybackException {
        int[] h10;
        int[] iArr = new int[n1VarArr.length + 1];
        int length = n1VarArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length];
        int[][][] iArr2 = new int[n1VarArr.length + 1][];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = trackGroupArray.f21172b;
            trackGroupArr[i10] = new TrackGroup[i11];
            iArr2[i10] = new int[i11];
        }
        int[] i12 = i(n1VarArr);
        for (int i13 = 0; i13 < trackGroupArray.f21172b; i13++) {
            TrackGroup a10 = trackGroupArray.a(i13);
            int f10 = f(n1VarArr, a10, iArr, q.l(a10.a(0).f19544m) == 5);
            if (f10 == n1VarArr.length) {
                h10 = new int[a10.f21168b];
            } else {
                h10 = h(n1VarArr[f10], a10);
            }
            int i14 = iArr[f10];
            trackGroupArr[f10][i14] = a10;
            iArr2[f10][i14] = h10;
            iArr[f10] = iArr[f10] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[n1VarArr.length];
        String[] strArr = new String[n1VarArr.length];
        int[] iArr3 = new int[n1VarArr.length];
        for (int i15 = 0; i15 < n1VarArr.length; i15++) {
            int i16 = iArr[i15];
            trackGroupArrayArr[i15] = new TrackGroupArray((TrackGroup[]) j0.A0(trackGroupArr[i15], i16));
            iArr2[i15] = (int[][]) j0.A0(iArr2[i15], i16);
            strArr[i15] = n1VarArr[i15].getName();
            iArr3[i15] = n1VarArr[i15].g();
        }
        a aVar2 = new a(strArr, iArr3, trackGroupArrayArr, i12, iArr2, new TrackGroupArray((TrackGroup[]) j0.A0(trackGroupArr[n1VarArr.length], iArr[n1VarArr.length])));
        Pair<RendererConfiguration[], ExoTrackSelection[]> j10 = j(aVar2, iArr2, i12, aVar, timeline);
        return new TrackSelectorResult((RendererConfiguration[]) j10.first, (ExoTrackSelection[]) j10.second, aVar2);
    }

    @Nullable
    public final a g() {
        return this.f22339c;
    }

    public abstract Pair<RendererConfiguration[], ExoTrackSelection[]> j(a aVar, int[][][] iArr, int[] iArr2, s.a aVar2, Timeline timeline) throws ExoPlaybackException;
}
