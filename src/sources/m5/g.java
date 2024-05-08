package m5;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.j0;
import java.util.ArrayDeque;

/* compiled from: AsynchronousMediaCodecCallback.java */
@RequiresApi(23)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g extends MediaCodec.Callback {

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f51852b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f51853c;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    @GuardedBy("lock")
    public MediaFormat f51858h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    @GuardedBy("lock")
    public MediaFormat f51859i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy("lock")
    public MediaCodec.CodecException f51860j;

    /* renamed from: k, reason: collision with root package name */
    @GuardedBy("lock")
    public long f51861k;

    /* renamed from: l, reason: collision with root package name */
    @GuardedBy("lock")
    public boolean f51862l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    @GuardedBy("lock")
    public IllegalStateException f51863m;

    /* renamed from: a, reason: collision with root package name */
    public final Object f51851a = new Object();

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("lock")
    public final com.google.android.exoplayer2.util.j f51854d = new com.google.android.exoplayer2.util.j();

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("lock")
    public final com.google.android.exoplayer2.util.j f51855e = new com.google.android.exoplayer2.util.j();

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("lock")
    public final ArrayDeque<MediaCodec.BufferInfo> f51856f = new ArrayDeque<>();

    /* renamed from: g, reason: collision with root package name */
    @GuardedBy("lock")
    public final ArrayDeque<MediaFormat> f51857g = new ArrayDeque<>();

    public g(HandlerThread handlerThread) {
        this.f51852b = handlerThread;
    }

    @GuardedBy("lock")
    public final void b(MediaFormat mediaFormat) {
        this.f51855e.a(-2);
        this.f51857g.add(mediaFormat);
    }

    public int c() {
        synchronized (this.f51851a) {
            int i10 = -1;
            if (i()) {
                return -1;
            }
            k();
            if (!this.f51854d.d()) {
                i10 = this.f51854d.e();
            }
            return i10;
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f51851a) {
            if (i()) {
                return -1;
            }
            k();
            if (this.f51855e.d()) {
                return -1;
            }
            int e2 = this.f51855e.e();
            if (e2 >= 0) {
                com.google.android.exoplayer2.util.a.i(this.f51858h);
                MediaCodec.BufferInfo remove = this.f51856f.remove();
                bufferInfo.set(remove.offset, remove.size, remove.presentationTimeUs, remove.flags);
            } else if (e2 == -2) {
                this.f51858h = this.f51857g.remove();
            }
            return e2;
        }
    }

    public void e(final Runnable runnable) {
        synchronized (this.f51851a) {
            this.f51861k++;
            ((Handler) j0.j(this.f51853c)).post(new Runnable() { // from class: m5.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.j(runnable);
                }
            });
        }
    }

    @GuardedBy("lock")
    public final void f() {
        if (!this.f51857g.isEmpty()) {
            this.f51859i = this.f51857g.getLast();
        }
        this.f51854d.b();
        this.f51855e.b();
        this.f51856f.clear();
        this.f51857g.clear();
        this.f51860j = null;
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f51851a) {
            mediaFormat = this.f51858h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        com.google.android.exoplayer2.util.a.g(this.f51853c == null);
        this.f51852b.start();
        Handler handler = new Handler(this.f51852b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f51853c = handler;
    }

    @GuardedBy("lock")
    public final boolean i() {
        return this.f51861k > 0 || this.f51862l;
    }

    @GuardedBy("lock")
    public final void k() {
        l();
        m();
    }

    @GuardedBy("lock")
    public final void l() {
        IllegalStateException illegalStateException = this.f51863m;
        if (illegalStateException == null) {
            return;
        }
        this.f51863m = null;
        throw illegalStateException;
    }

    @GuardedBy("lock")
    public final void m() {
        MediaCodec.CodecException codecException = this.f51860j;
        if (codecException == null) {
            return;
        }
        this.f51860j = null;
        throw codecException;
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final void j(Runnable runnable) {
        synchronized (this.f51851a) {
            o(runnable);
        }
    }

    @GuardedBy("lock")
    public final void o(Runnable runnable) {
        if (this.f51862l) {
            return;
        }
        long j10 = this.f51861k - 1;
        this.f51861k = j10;
        if (j10 > 0) {
            return;
        }
        if (j10 < 0) {
            p(new IllegalStateException());
            return;
        }
        f();
        try {
            runnable.run();
        } catch (IllegalStateException e2) {
            p(e2);
        } catch (Exception e10) {
            p(new IllegalStateException(e10));
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
        synchronized (this.f51851a) {
            this.f51860j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i10) {
        synchronized (this.f51851a) {
            this.f51854d.a(i10);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i10, @NonNull MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f51851a) {
            MediaFormat mediaFormat = this.f51859i;
            if (mediaFormat != null) {
                b(mediaFormat);
                this.f51859i = null;
            }
            this.f51855e.a(i10);
            this.f51856f.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
        synchronized (this.f51851a) {
            b(mediaFormat);
            this.f51859i = null;
        }
    }

    public final void p(IllegalStateException illegalStateException) {
        synchronized (this.f51851a) {
            this.f51863m = illegalStateException;
        }
    }

    public void q() {
        synchronized (this.f51851a) {
            this.f51862l = true;
            this.f51852b.quit();
            f();
        }
    }
}
