package p6;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* compiled from: CachedContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f52873a;

    /* renamed from: b, reason: collision with root package name */
    public final String f52874b;

    /* renamed from: c, reason: collision with root package name */
    public final TreeSet<o> f52875c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<a> f52876d;

    /* renamed from: e, reason: collision with root package name */
    public l f52877e;

    /* compiled from: CachedContent.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f52878a;

        /* renamed from: b, reason: collision with root package name */
        public final long f52879b;

        public a(long j10, long j11) {
            this.f52878a = j10;
            this.f52879b = j11;
        }

        public boolean a(long j10, long j11) {
            long j12 = this.f52879b;
            if (j12 == -1) {
                return j10 >= this.f52878a;
            }
            if (j11 == -1) {
                return false;
            }
            long j13 = this.f52878a;
            return j13 <= j10 && j10 + j11 <= j13 + j12;
        }

        public boolean b(long j10, long j11) {
            long j12 = this.f52878a;
            if (j12 > j10) {
                return j11 == -1 || j10 + j11 > j12;
            }
            long j13 = this.f52879b;
            return j13 == -1 || j12 + j13 > j10;
        }
    }

    public g(int i10, String str) {
        this(i10, str, l.f52900c);
    }

    public void a(o oVar) {
        this.f52875c.add(oVar);
    }

    public boolean b(k kVar) {
        this.f52877e = this.f52877e.d(kVar);
        return !r2.equals(r0);
    }

    public l c() {
        return this.f52877e;
    }

    public o d(long j10, long j11) {
        o j12 = o.j(this.f52874b, j10);
        o floor = this.f52875c.floor(j12);
        if (floor != null && floor.f52868c + floor.f52869d > j10) {
            return floor;
        }
        o ceiling = this.f52875c.ceiling(j12);
        if (ceiling != null) {
            long j13 = ceiling.f52868c - j10;
            j11 = j11 == -1 ? j13 : Math.min(j13, j11);
        }
        return o.i(this.f52874b, j10, j11);
    }

    public TreeSet<o> e() {
        return this.f52875c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f52873a == gVar.f52873a && this.f52874b.equals(gVar.f52874b) && this.f52875c.equals(gVar.f52875c) && this.f52877e.equals(gVar.f52877e);
    }

    public boolean f() {
        return this.f52875c.isEmpty();
    }

    public boolean g(long j10, long j11) {
        for (int i10 = 0; i10 < this.f52876d.size(); i10++) {
            if (this.f52876d.get(i10).a(j10, j11)) {
                return true;
            }
        }
        return false;
    }

    public boolean h() {
        return this.f52876d.isEmpty();
    }

    public int hashCode() {
        return (((this.f52873a * 31) + this.f52874b.hashCode()) * 31) + this.f52877e.hashCode();
    }

    public boolean i(long j10, long j11) {
        for (int i10 = 0; i10 < this.f52876d.size(); i10++) {
            if (this.f52876d.get(i10).b(j10, j11)) {
                return false;
            }
        }
        this.f52876d.add(new a(j10, j11));
        return true;
    }

    public boolean j(f fVar) {
        if (!this.f52875c.remove(fVar)) {
            return false;
        }
        File file = fVar.f52871f;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public o k(o oVar, long j10, boolean z10) {
        com.google.android.exoplayer2.util.a.g(this.f52875c.remove(oVar));
        File file = (File) com.google.android.exoplayer2.util.a.e(oVar.f52871f);
        if (z10) {
            File k10 = o.k((File) com.google.android.exoplayer2.util.a.e(file.getParentFile()), this.f52873a, oVar.f52868c, j10);
            if (file.renameTo(k10)) {
                file = k10;
            } else {
                String valueOf = String.valueOf(file);
                String valueOf2 = String.valueOf(k10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 21 + valueOf2.length());
                sb2.append("Failed to rename ");
                sb2.append(valueOf);
                sb2.append(" to ");
                sb2.append(valueOf2);
                com.google.android.exoplayer2.util.m.h("CachedContent", sb2.toString());
            }
        }
        o f10 = oVar.f(file, j10);
        this.f52875c.add(f10);
        return f10;
    }

    public void l(long j10) {
        for (int i10 = 0; i10 < this.f52876d.size(); i10++) {
            if (this.f52876d.get(i10).f52878a == j10) {
                this.f52876d.remove(i10);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public g(int i10, String str, l lVar) {
        this.f52873a = i10;
        this.f52874b = str;
        this.f52877e = lVar;
        this.f52875c = new TreeSet<>();
        this.f52876d = new ArrayList<>();
    }
}
