package p6;

import androidx.annotation.Nullable;
import java.io.File;

/* compiled from: CacheSpan.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class f implements Comparable<f> {

    /* renamed from: b, reason: collision with root package name */
    public final String f52867b;

    /* renamed from: c, reason: collision with root package name */
    public final long f52868c;

    /* renamed from: d, reason: collision with root package name */
    public final long f52869d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f52870e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final File f52871f;

    /* renamed from: g, reason: collision with root package name */
    public final long f52872g;

    public f(String str, long j10, long j11, long j12, @Nullable File file) {
        this.f52867b = str;
        this.f52868c = j10;
        this.f52869d = j11;
        this.f52870e = file != null;
        this.f52871f = file;
        this.f52872g = j12;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        if (!this.f52867b.equals(fVar.f52867b)) {
            return this.f52867b.compareTo(fVar.f52867b);
        }
        long j10 = this.f52868c - fVar.f52868c;
        if (j10 == 0) {
            return 0;
        }
        return j10 < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.f52870e;
    }

    public boolean c() {
        return this.f52869d == -1;
    }

    public String toString() {
        long j10 = this.f52868c;
        long j11 = this.f52869d;
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("[");
        sb2.append(j10);
        sb2.append(", ");
        sb2.append(j11);
        sb2.append("]");
        return sb2.toString();
    }
}
