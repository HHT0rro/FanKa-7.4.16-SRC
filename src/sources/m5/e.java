package m5;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.j0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
@RequiresApi(23)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class e {

    /* renamed from: h, reason: collision with root package name */
    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    public static final ArrayDeque<b> f51833h = new ArrayDeque<>();

    /* renamed from: i, reason: collision with root package name */
    public static final Object f51834i = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f51835a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f51836b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f51837c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference<RuntimeException> f51838d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.e f51839e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f51840f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f51841g;

    /* compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e.this.f(message);
        }
    }

    /* compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f51843a;

        /* renamed from: b, reason: collision with root package name */
        public int f51844b;

        /* renamed from: c, reason: collision with root package name */
        public int f51845c;

        /* renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f51846d = new MediaCodec.CryptoInfo();

        /* renamed from: e, reason: collision with root package name */
        public long f51847e;

        /* renamed from: f, reason: collision with root package name */
        public int f51848f;

        public void a(int i10, int i11, int i12, long j10, int i13) {
            this.f51843a = i10;
            this.f51844b = i11;
            this.f51845c = i12;
            this.f51847e = j10;
            this.f51848f = i13;
        }
    }

    public e(MediaCodec mediaCodec, HandlerThread handlerThread, boolean z10) {
        this(mediaCodec, handlerThread, z10, new com.google.android.exoplayer2.util.e());
    }

    public static void c(z4.b bVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = bVar.f54845f;
        cryptoInfo.numBytesOfClearData = e(bVar.f54843d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = e(bVar.f54844e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) com.google.android.exoplayer2.util.a.e(d(bVar.f54841b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) com.google.android.exoplayer2.util.a.e(d(bVar.f54840a, cryptoInfo.iv));
        cryptoInfo.mode = bVar.f54842c;
        if (j0.f22990a >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(bVar.f54846g, bVar.f54847h));
        }
    }

    @Nullable
    public static byte[] d(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 != null && bArr2.length >= bArr.length) {
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, bArr.length);
            return bArr2;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    @Nullable
    public static int[] e(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 != null && iArr2.length >= iArr.length) {
            System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, iArr.length);
            return iArr2;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public static b k() {
        ArrayDeque<b> arrayDeque = f51833h;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new b();
            }
            return arrayDeque.removeFirst();
        }
    }

    public static boolean m() {
        String e2 = com.google.common.base.a.e(j0.f22992c);
        return e2.contains("samsung") || e2.contains("motorola");
    }

    public static void p(b bVar) {
        ArrayDeque<b> arrayDeque = f51833h;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    public final void b() throws InterruptedException {
        this.f51839e.c();
        ((Handler) j0.j(this.f51837c)).obtainMessage(2).sendToTarget();
        this.f51839e.a();
    }

    public final void f(Message message) {
        b bVar;
        int i10 = message.what;
        if (i10 == 0) {
            bVar = (b) message.obj;
            g(bVar.f51843a, bVar.f51844b, bVar.f51845c, bVar.f51847e, bVar.f51848f);
        } else if (i10 != 1) {
            if (i10 != 2) {
                q(new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.f51839e.e();
            }
            bVar = null;
        } else {
            bVar = (b) message.obj;
            h(bVar.f51843a, bVar.f51844b, bVar.f51846d, bVar.f51847e, bVar.f51848f);
        }
        if (bVar != null) {
            p(bVar);
        }
    }

    public final void g(int i10, int i11, int i12, long j10, int i13) {
        try {
            this.f51835a.queueInputBuffer(i10, i11, i12, j10, i13);
        } catch (RuntimeException e2) {
            q(e2);
        }
    }

    public final void h(int i10, int i11, MediaCodec.CryptoInfo cryptoInfo, long j10, int i12) {
        try {
            if (this.f51840f) {
                synchronized (f51834i) {
                    this.f51835a.queueSecureInputBuffer(i10, i11, cryptoInfo, j10, i12);
                }
                return;
            }
            this.f51835a.queueSecureInputBuffer(i10, i11, cryptoInfo, j10, i12);
        } catch (RuntimeException e2) {
            q(e2);
        }
    }

    public void i() {
        if (this.f51841g) {
            try {
                j();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    public final void j() throws InterruptedException {
        ((Handler) j0.j(this.f51837c)).removeCallbacksAndMessages(null);
        b();
        l();
    }

    public final void l() {
        RuntimeException andSet = this.f51838d.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    public void n(int i10, int i11, int i12, long j10, int i13) {
        l();
        b k10 = k();
        k10.a(i10, i11, i12, j10, i13);
        ((Handler) j0.j(this.f51837c)).obtainMessage(0, k10).sendToTarget();
    }

    public void o(int i10, int i11, z4.b bVar, long j10, int i12) {
        l();
        b k10 = k();
        k10.a(i10, i11, 0, j10, i12);
        c(bVar, k10.f51846d);
        ((Handler) j0.j(this.f51837c)).obtainMessage(1, k10).sendToTarget();
    }

    @VisibleForTesting
    public void q(RuntimeException runtimeException) {
        this.f51838d.set(runtimeException);
    }

    public void r() {
        if (this.f51841g) {
            i();
            this.f51836b.quit();
        }
        this.f51841g = false;
    }

    public void s() {
        if (this.f51841g) {
            return;
        }
        this.f51836b.start();
        this.f51837c = new a(this.f51836b.getLooper());
        this.f51841g = true;
    }

    public void t() throws InterruptedException {
        b();
    }

    @VisibleForTesting
    public e(MediaCodec mediaCodec, HandlerThread handlerThread, boolean z10, com.google.android.exoplayer2.util.e eVar) {
        this.f51835a = mediaCodec;
        this.f51836b = handlerThread;
        this.f51839e = eVar;
        this.f51838d = new AtomicReference<>();
        this.f51840f = z10 || m();
    }
}
