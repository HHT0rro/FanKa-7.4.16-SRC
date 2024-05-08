package com.github.penfeizhou.animation.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import h4.d;
import h4.f;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class FrameSeqDecoder<R extends h4.d, W extends h4.f> {

    /* renamed from: u, reason: collision with root package name */
    public static final Rect f19218u = new Rect();

    /* renamed from: a, reason: collision with root package name */
    public final int f19219a;

    /* renamed from: b, reason: collision with root package name */
    public final i4.c f19220b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f19221c;

    /* renamed from: f, reason: collision with root package name */
    public int f19224f;

    /* renamed from: h, reason: collision with root package name */
    public final Set<j> f19226h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f19227i;

    /* renamed from: j, reason: collision with root package name */
    public final Runnable f19228j;

    /* renamed from: k, reason: collision with root package name */
    public int f19229k;

    /* renamed from: l, reason: collision with root package name */
    public final Set<Bitmap> f19230l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f19231m;

    /* renamed from: n, reason: collision with root package name */
    public Map<Bitmap, Canvas> f19232n;

    /* renamed from: o, reason: collision with root package name */
    public ByteBuffer f19233o;

    /* renamed from: p, reason: collision with root package name */
    public volatile Rect f19234p;

    /* renamed from: q, reason: collision with root package name */
    public W f19235q;

    /* renamed from: r, reason: collision with root package name */
    public R f19236r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f19237s;

    /* renamed from: t, reason: collision with root package name */
    public volatile State f19238t;

    /* renamed from: d, reason: collision with root package name */
    public List<com.github.penfeizhou.animation.decode.a<R, W>> f19222d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public int f19223e = -1;

    /* renamed from: g, reason: collision with root package name */
    public Integer f19225g = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum State {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FrameSeqDecoder.this.f19227i.get()) {
                return;
            }
            if (FrameSeqDecoder.this.p()) {
                long currentTimeMillis = System.currentTimeMillis();
                FrameSeqDecoder.this.f19221c.postDelayed(this, Math.max(0L, FrameSeqDecoder.this.Q() - (System.currentTimeMillis() - currentTimeMillis)));
                Iterator iterator2 = FrameSeqDecoder.this.f19226h.iterator2();
                while (iterator2.hasNext()) {
                    ((j) iterator2.next()).a(FrameSeqDecoder.this.f19233o);
                }
                return;
            }
            FrameSeqDecoder.this.R();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f19240b;

        public b(j jVar) {
            this.f19240b = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameSeqDecoder.this.f19226h.add(this.f19240b);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f19242b;

        public c(j jVar) {
            this.f19242b = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameSeqDecoder.this.f19226h.remove(this.f19242b);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FrameSeqDecoder.this.f19226h.size() == 0) {
                FrameSeqDecoder.this.R();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Thread f19245b;

        public e(Thread thread) {
            this.f19245b = thread;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    if (FrameSeqDecoder.this.f19234p == null) {
                        if (FrameSeqDecoder.this.f19236r == null) {
                            FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                            frameSeqDecoder.f19236r = frameSeqDecoder.x(frameSeqDecoder.f19220b.obtain());
                        } else {
                            FrameSeqDecoder.this.f19236r.reset();
                        }
                        FrameSeqDecoder frameSeqDecoder2 = FrameSeqDecoder.this;
                        frameSeqDecoder2.A(frameSeqDecoder2.G(frameSeqDecoder2.f19236r));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    FrameSeqDecoder.this.f19234p = FrameSeqDecoder.f19218u;
                }
            } finally {
                LockSupport.unpark(this.f19245b);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameSeqDecoder.this.B();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameSeqDecoder.this.C();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameSeqDecoder.this.f19224f = 0;
            FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
            frameSeqDecoder.f19223e = -1;
            frameSeqDecoder.f19237s = false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class i implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f19250b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f19251c;

        public i(int i10, boolean z10) {
            this.f19250b = i10;
            this.f19251c = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            FrameSeqDecoder.this.C();
            try {
                FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                frameSeqDecoder.f19229k = this.f19250b;
                frameSeqDecoder.A(frameSeqDecoder.G(frameSeqDecoder.x(frameSeqDecoder.f19220b.obtain())));
                if (this.f19251c) {
                    FrameSeqDecoder.this.B();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface j {
        void a(ByteBuffer byteBuffer);

        void onEnd();

        void onStart();
    }

    public FrameSeqDecoder(i4.c cVar, @Nullable j jVar) {
        HashSet hashSet = new HashSet();
        this.f19226h = hashSet;
        this.f19227i = new AtomicBoolean(true);
        this.f19228j = new a();
        this.f19229k = 1;
        this.f19230l = new HashSet();
        this.f19231m = new Object();
        this.f19232n = new WeakHashMap();
        this.f19235q = z();
        this.f19236r = null;
        this.f19237s = false;
        this.f19238t = State.IDLE;
        this.f19220b = cVar;
        if (jVar != null) {
            hashSet.add(jVar);
        }
        int a10 = g4.a.b().a();
        this.f19219a = a10;
        this.f19221c = new Handler(g4.a.b().c(a10));
    }

    public final void A(Rect rect) {
        this.f19234p = rect;
        int width = rect.width() * rect.height();
        int i10 = this.f19229k;
        this.f19233o = ByteBuffer.allocate(((width / (i10 * i10)) + 1) * 4);
        if (this.f19235q == null) {
            this.f19235q = z();
        }
    }

    @WorkerThread
    public final void B() {
        this.f19227i.compareAndSet(true, false);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.f19222d.size() == 0) {
                try {
                    R r10 = this.f19236r;
                    if (r10 == null) {
                        this.f19236r = x(this.f19220b.obtain());
                    } else {
                        r10.reset();
                    }
                    A(G(this.f19236r));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(q());
            sb2.append(" Set state to RUNNING,cost ");
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            this.f19238t = State.RUNNING;
            if (w() != 0 && this.f19237s) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(q());
                sb3.append(" No need to started");
            } else {
                this.f19223e = -1;
                this.f19228j.run();
                Iterator<j> iterator2 = this.f19226h.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onStart();
                }
            }
        } catch (Throwable th2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(q());
            sb4.append(" Set state to RUNNING,cost ");
            sb4.append(System.currentTimeMillis() - currentTimeMillis);
            this.f19238t = State.RUNNING;
            throw th2;
        }
    }

    @WorkerThread
    public final void C() {
        this.f19221c.removeCallbacks(this.f19228j);
        this.f19222d.clear();
        synchronized (this.f19231m) {
            for (Bitmap bitmap : this.f19230l) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.f19230l.clear();
        }
        if (this.f19233o != null) {
            this.f19233o = null;
        }
        this.f19232n.clear();
        try {
            R r10 = this.f19236r;
            if (r10 != null) {
                r10.close();
                this.f19236r = null;
            }
            W w3 = this.f19235q;
            if (w3 != null) {
                w3.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        I();
        this.f19238t = State.IDLE;
        Iterator<j> iterator2 = this.f19226h.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onEnd();
        }
    }

    public boolean D() {
        return this.f19238t == State.RUNNING || this.f19238t == State.INITIALIZING;
    }

    public Bitmap E(int i10, int i11) {
        synchronized (this.f19231m) {
            Iterator<Bitmap> iterator2 = this.f19230l.iterator2();
            Bitmap bitmap = null;
            while (iterator2.hasNext()) {
                int i12 = i10 * i11 * 4;
                Bitmap next = iterator2.next();
                if (next != null && next.getAllocationByteCount() >= i12) {
                    iterator2.remove();
                    if ((next.getWidth() != i10 || next.getHeight() != i11) && i10 > 0 && i11 > 0) {
                        next.reconfigure(i10, i11, Bitmap.Config.ARGB_8888);
                    }
                    next.eraseColor(0);
                    return next;
                }
                bitmap = next;
            }
            if (i10 <= 0 || i11 <= 0) {
                return null;
            }
            try {
                bitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (OutOfMemoryError e10) {
                e10.printStackTrace();
            }
            return bitmap;
        }
    }

    public void F() {
        this.f19221c.removeCallbacks(this.f19228j);
        this.f19227i.compareAndSet(false, true);
    }

    public abstract Rect G(R r10) throws IOException;

    public void H(Bitmap bitmap) {
        synchronized (this.f19231m) {
            if (bitmap != null) {
                this.f19230l.add(bitmap);
            }
        }
    }

    public abstract void I();

    public void J(j jVar) {
        this.f19221c.post(new c(jVar));
    }

    public abstract void K(com.github.penfeizhou.animation.decode.a<R, W> aVar);

    public void L() {
        this.f19221c.post(new h());
    }

    public void M() {
        this.f19227i.compareAndSet(true, false);
        this.f19221c.removeCallbacks(this.f19228j);
        this.f19221c.post(this.f19228j);
    }

    public boolean N(int i10, int i11) {
        int s2 = s(i10, i11);
        if (s2 == this.f19229k) {
            return false;
        }
        boolean D = D();
        this.f19221c.removeCallbacks(this.f19228j);
        this.f19221c.post(new i(s2, D));
        return true;
    }

    public void O(int i10) {
        this.f19225g = Integer.valueOf(i10);
    }

    public void P() {
        if (this.f19234p == f19218u) {
            return;
        }
        if (this.f19238t != State.RUNNING) {
            State state = this.f19238t;
            State state2 = State.INITIALIZING;
            if (state != state2) {
                if (this.f19238t == State.FINISHING) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(q());
                    sb2.append(" Processing,wait for finish at ");
                    sb2.append((Object) this.f19238t);
                }
                this.f19238t = state2;
                if (Looper.myLooper() == this.f19221c.getLooper()) {
                    B();
                    return;
                } else {
                    this.f19221c.post(new f());
                    return;
                }
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(q());
        sb3.append(" Already started");
    }

    @WorkerThread
    public final long Q() {
        int i10 = this.f19223e + 1;
        this.f19223e = i10;
        if (i10 >= u()) {
            this.f19223e = 0;
            this.f19224f++;
        }
        com.github.penfeizhou.animation.decode.a<R, W> t2 = t(this.f19223e);
        if (t2 == null) {
            return 0L;
        }
        K(t2);
        return t2.f19258f;
    }

    public void R() {
        if (this.f19234p == f19218u) {
            return;
        }
        State state = this.f19238t;
        State state2 = State.FINISHING;
        if (state != state2 && this.f19238t != State.IDLE) {
            if (this.f19238t == State.INITIALIZING) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(q());
                sb2.append("Processing,wait for finish at ");
                sb2.append((Object) this.f19238t);
            }
            this.f19238t = state2;
            if (Looper.myLooper() == this.f19221c.getLooper()) {
                C();
                return;
            } else {
                this.f19221c.post(new g());
                return;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(q());
        sb3.append("No need to stop");
    }

    public void S() {
        this.f19221c.post(new d());
    }

    public void o(j jVar) {
        this.f19221c.post(new b(jVar));
    }

    public final boolean p() {
        if (!D() || this.f19222d.size() == 0) {
            return false;
        }
        if (w() <= 0 || this.f19224f < w() - 1) {
            return true;
        }
        if (this.f19224f == w() - 1 && this.f19223e < u() - 1) {
            return true;
        }
        this.f19237s = true;
        return false;
    }

    public final String q() {
        return "";
    }

    public Rect r() {
        if (this.f19234p == null) {
            State state = State.FINISHING;
            Thread currentThread = Thread.currentThread();
            this.f19221c.post(new e(currentThread));
            LockSupport.park(currentThread);
        }
        return this.f19234p == null ? f19218u : this.f19234p;
    }

    public int s(int i10, int i11) {
        int i12 = 1;
        if (i10 != 0 && i11 != 0) {
            int min = Math.min(r().width() / i10, r().height() / i11);
            while (true) {
                int i13 = i12 * 2;
                if (i13 > min) {
                    break;
                }
                i12 = i13;
            }
        }
        return i12;
    }

    public com.github.penfeizhou.animation.decode.a<R, W> t(int i10) {
        if (i10 < 0 || i10 >= this.f19222d.size()) {
            return null;
        }
        return this.f19222d.get(i10);
    }

    public int u() {
        return this.f19222d.size();
    }

    public abstract int v();

    public final int w() {
        Integer num = this.f19225g;
        return num != null ? num.intValue() : v();
    }

    public abstract R x(h4.d dVar);

    public int y() {
        return this.f19229k;
    }

    public abstract W z();
}
