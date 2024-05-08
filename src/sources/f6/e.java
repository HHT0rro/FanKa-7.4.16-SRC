package f6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.j0;
import e6.h;
import e6.i;
import f6.e;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import z4.e;

/* compiled from: CeaDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class e implements e6.f {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque<b> f49210a = new ArrayDeque<>();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque<i> f49211b;

    /* renamed from: c, reason: collision with root package name */
    public final PriorityQueue<b> f49212c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public b f49213d;

    /* renamed from: e, reason: collision with root package name */
    public long f49214e;

    /* renamed from: f, reason: collision with root package name */
    public long f49215f;

    /* compiled from: CeaDecoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends h implements Comparable<b> {

        /* renamed from: k, reason: collision with root package name */
        public long f49216k;

        public b() {
        }

        @Override // java.lang.Comparable
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (m() != bVar.m()) {
                return m() ? 1 : -1;
            }
            long j10 = this.f19884f - bVar.f19884f;
            if (j10 == 0) {
                j10 = this.f49216k - bVar.f49216k;
                if (j10 == 0) {
                    return 0;
                }
            }
            return j10 > 0 ? 1 : -1;
        }
    }

    /* compiled from: CeaDecoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends i {

        /* renamed from: g, reason: collision with root package name */
        public e.a<c> f49217g;

        public c(e.a<c> aVar) {
            this.f49217g = aVar;
        }

        @Override // z4.e
        public final void p() {
            this.f49217g.a(this);
        }
    }

    public e() {
        for (int i10 = 0; i10 < 10; i10++) {
            this.f49210a.add(new b());
        }
        this.f49211b = new ArrayDeque<>();
        for (int i11 = 0; i11 < 2; i11++) {
            this.f49211b.add(new c(new e.a() { // from class: f6.d
                @Override // z4.e.a
                public final void a(z4.e eVar) {
                    e.this.n((e.c) eVar);
                }
            }));
        }
        this.f49212c = new PriorityQueue<>();
    }

    @Override // e6.f
    public void b(long j10) {
        this.f49214e = j10;
    }

    public abstract e6.e e();

    public abstract void f(h hVar);

    @Override // z4.c
    public void flush() {
        this.f49215f = 0L;
        this.f49214e = 0L;
        while (!this.f49212c.isEmpty()) {
            m((b) j0.j(this.f49212c.poll()));
        }
        b bVar = this.f49213d;
        if (bVar != null) {
            m(bVar);
            this.f49213d = null;
        }
    }

    @Override // z4.c
    @Nullable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public h a() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.g(this.f49213d == null);
        if (this.f49210a.isEmpty()) {
            return null;
        }
        b pollFirst = this.f49210a.pollFirst();
        this.f49213d = pollFirst;
        return pollFirst;
    }

    @Override // z4.c
    @Nullable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public i c() throws SubtitleDecoderException {
        if (this.f49211b.isEmpty()) {
            return null;
        }
        while (!this.f49212c.isEmpty() && ((b) j0.j(this.f49212c.peek())).f19884f <= this.f49214e) {
            b bVar = (b) j0.j(this.f49212c.poll());
            if (bVar.m()) {
                i iVar = (i) j0.j(this.f49211b.pollFirst());
                iVar.g(4);
                m(bVar);
                return iVar;
            }
            f(bVar);
            if (k()) {
                e6.e e2 = e();
                i iVar2 = (i) j0.j(this.f49211b.pollFirst());
                iVar2.q(bVar.f19884f, e2, Long.MAX_VALUE);
                m(bVar);
                return iVar2;
            }
            m(bVar);
        }
        return null;
    }

    @Nullable
    public final i i() {
        return this.f49211b.pollFirst();
    }

    public final long j() {
        return this.f49214e;
    }

    public abstract boolean k();

    @Override // z4.c
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void d(h hVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.a(hVar == this.f49213d);
        b bVar = (b) hVar;
        if (bVar.l()) {
            m(bVar);
        } else {
            long j10 = this.f49215f;
            this.f49215f = 1 + j10;
            bVar.f49216k = j10;
            this.f49212c.add(bVar);
        }
        this.f49213d = null;
    }

    public final void m(b bVar) {
        bVar.h();
        this.f49210a.add(bVar);
    }

    public void n(i iVar) {
        iVar.h();
        this.f49211b.add(iVar);
    }

    @Override // z4.c
    public void release() {
    }
}
