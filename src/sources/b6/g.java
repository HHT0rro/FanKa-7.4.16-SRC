package b6;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import b6.g;
import java.util.Comparator;
import java.util.TreeSet;

/* compiled from: RtpPacketReorderingQueue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public final TreeSet<a> f1334a = new TreeSet<>(new Comparator() { // from class: b6.f
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int d10;
            d10 = g.d((g.a) obj, (g.a) obj2);
            return d10;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    public int f1335b;

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    public int f1336c;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    public boolean f1337d;

    /* compiled from: RtpPacketReorderingQueue.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final e f1338a;

        /* renamed from: b, reason: collision with root package name */
        public final long f1339b;

        public a(e eVar, long j10) {
            this.f1338a = eVar;
            this.f1339b = j10;
        }
    }

    public g() {
        i();
    }

    public static int c(int i10, int i11) {
        int min;
        int i12 = i10 - i11;
        return (Math.abs(i12) <= 1000 || (min = (Math.min(i10, i11) - Math.max(i10, i11)) + 65535) >= 1000) ? i12 : i10 < i11 ? min : -min;
    }

    public static /* synthetic */ int d(a aVar, a aVar2) {
        return c(aVar.f1338a.f1320g, aVar2.f1338a.f1320g);
    }

    public static int e(int i10) {
        return (i10 + 1) % 65535;
    }

    public static int h(int i10) {
        if (i10 == 0) {
            return 65534;
        }
        return (i10 - 1) % 65535;
    }

    public final synchronized void b(a aVar) {
        this.f1335b = aVar.f1338a.f1320g;
        this.f1334a.add(aVar);
    }

    public synchronized boolean f(e eVar, long j10) {
        if (this.f1334a.size() < 5000) {
            int i10 = eVar.f1320g;
            if (!this.f1337d) {
                i();
                this.f1336c = h(i10);
                this.f1337d = true;
                b(new a(eVar, j10));
                return true;
            }
            if (Math.abs(c(i10, e(this.f1335b))) < 1000) {
                if (c(i10, this.f1336c) <= 0) {
                    return false;
                }
                b(new a(eVar, j10));
                return true;
            }
            this.f1336c = h(i10);
            this.f1334a.clear();
            b(new a(eVar, j10));
            return true;
        }
        throw new IllegalStateException("Queue size limit of 5000 reached.");
    }

    @Nullable
    public synchronized e g(long j10) {
        if (this.f1334a.isEmpty()) {
            return null;
        }
        a first = this.f1334a.first();
        int i10 = first.f1338a.f1320g;
        if (i10 != e(this.f1336c) && j10 < first.f1339b) {
            return null;
        }
        this.f1334a.pollFirst();
        this.f1336c = i10;
        return first.f1338a;
    }

    public synchronized void i() {
        this.f1334a.clear();
        this.f1337d = false;
        this.f1336c = -1;
        this.f1335b = -1;
    }
}
