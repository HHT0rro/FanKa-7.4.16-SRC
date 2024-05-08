package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;

/* compiled from: AdPlaybackState.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f21205g = new a(null, new C0193a[0], 0, -9223372036854775807L, 0);

    /* renamed from: h, reason: collision with root package name */
    public static final C0193a f21206h = new C0193a(0).g(0);

    /* renamed from: i, reason: collision with root package name */
    public static final g<a> f21207i = a5.a.f700a;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final Object f21208a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21209b;

    /* renamed from: c, reason: collision with root package name */
    public final long f21210c;

    /* renamed from: d, reason: collision with root package name */
    public final long f21211d;

    /* renamed from: e, reason: collision with root package name */
    public final int f21212e;

    /* renamed from: f, reason: collision with root package name */
    public final C0193a[] f21213f;

    /* compiled from: AdPlaybackState.java */
    /* renamed from: com.google.android.exoplayer2.source.ads.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0193a {

        /* renamed from: h, reason: collision with root package name */
        public static final g<C0193a> f21214h = a5.a.f700a;

        /* renamed from: a, reason: collision with root package name */
        public final long f21215a;

        /* renamed from: b, reason: collision with root package name */
        public final int f21216b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri[] f21217c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f21218d;

        /* renamed from: e, reason: collision with root package name */
        public final long[] f21219e;

        /* renamed from: f, reason: collision with root package name */
        public final long f21220f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f21221g;

        public C0193a(long j10) {
            this(j10, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        @CheckResult
        public static long[] a(long[] jArr, int i10) {
            int length = jArr.length;
            int max = Math.max(i10, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, -9223372036854775807L);
            return copyOf;
        }

        @CheckResult
        public static int[] b(int[] iArr, int i10) {
            int length = iArr.length;
            int max = Math.max(i10, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        public int c() {
            return d(-1);
        }

        public int d(int i10) {
            int i11 = i10 + 1;
            while (true) {
                int[] iArr = this.f21218d;
                if (i11 >= iArr.length || this.f21221g || iArr[i11] == 0 || iArr[i11] == 1) {
                    break;
                }
                i11++;
            }
            return i11;
        }

        public boolean e() {
            if (this.f21216b == -1) {
                return true;
            }
            for (int i10 = 0; i10 < this.f21216b; i10++) {
                int[] iArr = this.f21218d;
                if (iArr[i10] == 0 || iArr[i10] == 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0193a.class != obj.getClass()) {
                return false;
            }
            C0193a c0193a = (C0193a) obj;
            return this.f21215a == c0193a.f21215a && this.f21216b == c0193a.f21216b && Arrays.equals(this.f21217c, c0193a.f21217c) && Arrays.equals(this.f21218d, c0193a.f21218d) && Arrays.equals(this.f21219e, c0193a.f21219e) && this.f21220f == c0193a.f21220f && this.f21221g == c0193a.f21221g;
        }

        public boolean f() {
            return this.f21216b == -1 || c() < this.f21216b;
        }

        @CheckResult
        public C0193a g(int i10) {
            int[] b4 = b(this.f21218d, i10);
            long[] a10 = a(this.f21219e, i10);
            return new C0193a(this.f21215a, i10, b4, (Uri[]) Arrays.copyOf(this.f21217c, i10), a10, this.f21220f, this.f21221g);
        }

        @CheckResult
        public C0193a h(long[] jArr) {
            int length = jArr.length;
            Uri[] uriArr = this.f21217c;
            if (length < uriArr.length) {
                jArr = a(jArr, uriArr.length);
            } else if (this.f21216b != -1 && jArr.length > uriArr.length) {
                jArr = Arrays.copyOf(jArr, uriArr.length);
            }
            return new C0193a(this.f21215a, this.f21216b, this.f21218d, this.f21217c, jArr, this.f21220f, this.f21221g);
        }

        public int hashCode() {
            int i10 = this.f21216b * 31;
            long j10 = this.f21215a;
            int hashCode = (((((((i10 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + Arrays.hashCode(this.f21217c)) * 31) + Arrays.hashCode(this.f21218d)) * 31) + Arrays.hashCode(this.f21219e)) * 31;
            long j11 = this.f21220f;
            return ((hashCode + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f21221g ? 1 : 0);
        }

        public C0193a(long j10, int i10, int[] iArr, Uri[] uriArr, long[] jArr, long j11, boolean z10) {
            com.google.android.exoplayer2.util.a.a(iArr.length == uriArr.length);
            this.f21215a = j10;
            this.f21216b = i10;
            this.f21218d = iArr;
            this.f21217c = uriArr;
            this.f21219e = jArr;
            this.f21220f = j11;
            this.f21221g = z10;
        }
    }

    public a(@Nullable Object obj, C0193a[] c0193aArr, long j10, long j11, int i10) {
        this.f21208a = obj;
        this.f21210c = j10;
        this.f21211d = j11;
        this.f21209b = c0193aArr.length + i10;
        this.f21213f = c0193aArr;
        this.f21212e = i10;
    }

    public C0193a a(int i10) {
        int i11 = this.f21212e;
        if (i10 < i11) {
            return f21206h;
        }
        return this.f21213f[i10 - i11];
    }

    public int b(long j10, long j11) {
        if (j10 == Long.MIN_VALUE) {
            return -1;
        }
        if (j11 != -9223372036854775807L && j10 >= j11) {
            return -1;
        }
        int i10 = this.f21212e;
        while (i10 < this.f21209b && ((a(i10).f21215a != Long.MIN_VALUE && a(i10).f21215a <= j10) || !a(i10).f())) {
            i10++;
        }
        if (i10 < this.f21209b) {
            return i10;
        }
        return -1;
    }

    public int c(long j10, long j11) {
        int i10 = this.f21209b - 1;
        while (i10 >= 0 && d(j10, j11, i10)) {
            i10--;
        }
        if (i10 < 0 || !a(i10).e()) {
            return -1;
        }
        return i10;
    }

    public final boolean d(long j10, long j11, int i10) {
        if (j10 == Long.MIN_VALUE) {
            return false;
        }
        long j12 = a(i10).f21215a;
        return j12 == Long.MIN_VALUE ? j11 == -9223372036854775807L || j10 < j11 : j10 < j12;
    }

    @CheckResult
    public a e(long[][] jArr) {
        com.google.android.exoplayer2.util.a.g(this.f21212e == 0);
        C0193a[] c0193aArr = this.f21213f;
        C0193a[] c0193aArr2 = (C0193a[]) j0.A0(c0193aArr, c0193aArr.length);
        for (int i10 = 0; i10 < this.f21209b; i10++) {
            c0193aArr2[i10] = c0193aArr2[i10].h(jArr[i10]);
        }
        return new a(this.f21208a, c0193aArr2, this.f21210c, this.f21211d, this.f21212e);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return j0.c(this.f21208a, aVar.f21208a) && this.f21209b == aVar.f21209b && this.f21210c == aVar.f21210c && this.f21211d == aVar.f21211d && this.f21212e == aVar.f21212e && Arrays.equals(this.f21213f, aVar.f21213f);
    }

    public int hashCode() {
        int i10 = this.f21209b * 31;
        Object obj = this.f21208a;
        return ((((((((i10 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f21210c)) * 31) + ((int) this.f21211d)) * 31) + this.f21212e) * 31) + Arrays.hashCode(this.f21213f);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdPlaybackState(adsId=");
        sb2.append(this.f21208a);
        sb2.append(", adResumePositionUs=");
        sb2.append(this.f21210c);
        sb2.append(", adGroups=[");
        for (int i10 = 0; i10 < this.f21213f.length; i10++) {
            sb2.append("adGroup(timeUs=");
            sb2.append(this.f21213f[i10].f21215a);
            sb2.append(", ads=[");
            for (int i11 = 0; i11 < this.f21213f[i10].f21218d.length; i11++) {
                sb2.append("ad(state=");
                int i12 = this.f21213f[i10].f21218d[i11];
                if (i12 == 0) {
                    sb2.append('_');
                } else if (i12 == 1) {
                    sb2.append('R');
                } else if (i12 == 2) {
                    sb2.append('S');
                } else if (i12 == 3) {
                    sb2.append('P');
                } else if (i12 != 4) {
                    sb2.append('?');
                } else {
                    sb2.append('!');
                }
                sb2.append(", durationUs=");
                sb2.append(this.f21213f[i10].f21219e[i11]);
                sb2.append(')');
                if (i11 < this.f21213f[i10].f21218d.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("])");
            if (i10 < this.f21213f.length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("])");
        return sb2.toString();
    }
}
