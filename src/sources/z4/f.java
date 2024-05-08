package z4;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.util.ArrayDeque;
import z4.e;

/* compiled from: SimpleDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class f<I extends DecoderInputBuffer, O extends e, E extends DecoderException> implements c<I, O, E> {

    /* renamed from: a, reason: collision with root package name */
    public final Thread f54865a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f54866b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque<I> f54867c = new ArrayDeque<>();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque<O> f54868d = new ArrayDeque<>();

    /* renamed from: e, reason: collision with root package name */
    public final I[] f54869e;

    /* renamed from: f, reason: collision with root package name */
    public final O[] f54870f;

    /* renamed from: g, reason: collision with root package name */
    public int f54871g;

    /* renamed from: h, reason: collision with root package name */
    public int f54872h;

    /* renamed from: i, reason: collision with root package name */
    public I f54873i;

    /* renamed from: j, reason: collision with root package name */
    public E f54874j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f54875k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f54876l;

    /* renamed from: m, reason: collision with root package name */
    public int f54877m;

    /* compiled from: SimpleDecoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            f.this.t();
        }
    }

    public f(I[] iArr, O[] oArr) {
        this.f54869e = iArr;
        this.f54871g = iArr.length;
        for (int i10 = 0; i10 < this.f54871g; i10++) {
            this.f54869e[i10] = g();
        }
        this.f54870f = oArr;
        this.f54872h = oArr.length;
        for (int i11 = 0; i11 < this.f54872h; i11++) {
            this.f54870f[i11] = h();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f54865a = aVar;
        aVar.start();
    }

    public final boolean f() {
        return !this.f54867c.isEmpty() && this.f54872h > 0;
    }

    @Override // z4.c
    public final void flush() {
        synchronized (this.f54866b) {
            this.f54875k = true;
            this.f54877m = 0;
            I i10 = this.f54873i;
            if (i10 != null) {
                q(i10);
                this.f54873i = null;
            }
            while (!this.f54867c.isEmpty()) {
                q(this.f54867c.removeFirst());
            }
            while (!this.f54868d.isEmpty()) {
                this.f54868d.removeFirst().p();
            }
        }
    }

    public abstract I g();

    public abstract O h();

    public abstract E i(Throwable th);

    @Nullable
    public abstract E j(I i10, O o10, boolean z10);

    public final boolean k() throws InterruptedException {
        E i10;
        synchronized (this.f54866b) {
            while (!this.f54876l && !f()) {
                this.f54866b.wait();
            }
            if (this.f54876l) {
                return false;
            }
            I removeFirst = this.f54867c.removeFirst();
            O[] oArr = this.f54870f;
            int i11 = this.f54872h - 1;
            this.f54872h = i11;
            O o10 = oArr[i11];
            boolean z10 = this.f54875k;
            this.f54875k = false;
            if (removeFirst.m()) {
                o10.g(4);
            } else {
                if (removeFirst.l()) {
                    o10.g(Integer.MIN_VALUE);
                }
                try {
                    i10 = j(removeFirst, o10, z10);
                } catch (OutOfMemoryError e2) {
                    i10 = i(e2);
                } catch (RuntimeException e10) {
                    i10 = i(e10);
                }
                if (i10 != null) {
                    synchronized (this.f54866b) {
                        this.f54874j = i10;
                    }
                    return false;
                }
            }
            synchronized (this.f54866b) {
                if (this.f54875k) {
                    o10.p();
                } else if (o10.l()) {
                    this.f54877m++;
                    o10.p();
                } else {
                    o10.f54864d = this.f54877m;
                    this.f54877m = 0;
                    this.f54868d.addLast(o10);
                }
                q(removeFirst);
            }
            return true;
        }
    }

    @Override // z4.c
    @Nullable
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final I a() throws DecoderException {
        I i10;
        synchronized (this.f54866b) {
            o();
            com.google.android.exoplayer2.util.a.g(this.f54873i == null);
            int i11 = this.f54871g;
            if (i11 == 0) {
                i10 = null;
            } else {
                I[] iArr = this.f54869e;
                int i12 = i11 - 1;
                this.f54871g = i12;
                i10 = iArr[i12];
            }
            this.f54873i = i10;
        }
        return i10;
    }

    @Override // z4.c
    @Nullable
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final O c() throws DecoderException {
        synchronized (this.f54866b) {
            o();
            if (this.f54868d.isEmpty()) {
                return null;
            }
            return this.f54868d.removeFirst();
        }
    }

    public final void n() {
        if (f()) {
            this.f54866b.notify();
        }
    }

    public final void o() throws DecoderException {
        E e2 = this.f54874j;
        if (e2 != null) {
            throw e2;
        }
    }

    @Override // z4.c
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void d(I i10) throws DecoderException {
        synchronized (this.f54866b) {
            o();
            com.google.android.exoplayer2.util.a.a(i10 == this.f54873i);
            this.f54867c.addLast(i10);
            n();
            this.f54873i = null;
        }
    }

    public final void q(I i10) {
        i10.h();
        I[] iArr = this.f54869e;
        int i11 = this.f54871g;
        this.f54871g = i11 + 1;
        iArr[i11] = i10;
    }

    @CallSuper
    public void r(O o10) {
        synchronized (this.f54866b) {
            s(o10);
            n();
        }
    }

    @Override // z4.c
    @CallSuper
    public void release() {
        synchronized (this.f54866b) {
            this.f54876l = true;
            this.f54866b.notify();
        }
        try {
            this.f54865a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void s(O o10) {
        o10.h();
        O[] oArr = this.f54870f;
        int i10 = this.f54872h;
        this.f54872h = i10 + 1;
        oArr[i10] = o10;
    }

    public final void t() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (k());
    }

    public final void u(int i10) {
        com.google.android.exoplayer2.util.a.g(this.f54871g == this.f54869e.length);
        for (I i11 : this.f54869e) {
            i11.q(i10);
        }
    }
}
