package p6;

import com.google.android.exoplayer2.upstream.cache.Cache;
import java.util.Comparator;
import java.util.TreeSet;

/* compiled from: LeastRecentlyUsedCacheEvictor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n implements com.google.android.exoplayer2.upstream.cache.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f52904a;

    /* renamed from: b, reason: collision with root package name */
    public final TreeSet<f> f52905b = new TreeSet<>(new Comparator() { // from class: p6.m
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int h10;
            h10 = n.h((f) obj, (f) obj2);
            return h10;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public long f52906c;

    public n(long j10) {
        this.f52904a = j10;
    }

    public static int h(f fVar, f fVar2) {
        long j10 = fVar.f52872g;
        long j11 = fVar2.f52872g;
        if (j10 - j11 == 0) {
            return fVar.compareTo(fVar2);
        }
        return j10 < j11 ? -1 : 1;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public boolean a() {
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void b(Cache cache, f fVar) {
        this.f52905b.add(fVar);
        this.f52906c += fVar.f52869d;
        i(cache, 0L);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public void c(Cache cache, String str, long j10, long j11) {
        if (j11 != -1) {
            i(cache, j11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void d(Cache cache, f fVar) {
        this.f52905b.remove(fVar);
        this.f52906c -= fVar.f52869d;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void e(Cache cache, f fVar, f fVar2) {
        d(cache, fVar);
        b(cache, fVar2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public void f() {
    }

    public final void i(Cache cache, long j10) {
        while (this.f52906c + j10 > this.f52904a && !this.f52905b.isEmpty()) {
            cache.f(this.f52905b.first());
        }
    }
}
