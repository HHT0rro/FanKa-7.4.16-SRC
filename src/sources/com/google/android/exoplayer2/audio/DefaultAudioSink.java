package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.window.TaskConstants;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.q;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Executor;
import x4.s;
import x4.u;
import x4.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DefaultAudioSink implements AudioSink {

    /* renamed from: a0, reason: collision with root package name */
    public static boolean f19707a0;
    public long A;
    public long B;
    public long C;
    public int D;
    public boolean E;
    public boolean F;
    public long G;
    public float H;
    public AudioProcessor[] I;
    public ByteBuffer[] J;

    @Nullable
    public ByteBuffer K;
    public int L;

    @Nullable
    public ByteBuffer M;
    public byte[] N;
    public int O;
    public int P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public int U;
    public s V;
    public boolean W;
    public long X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final x4.e f19708a;

    /* renamed from: b, reason: collision with root package name */
    public final b f19709b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19710c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.audio.d f19711d;

    /* renamed from: e, reason: collision with root package name */
    public final j f19712e;

    /* renamed from: f, reason: collision with root package name */
    public final AudioProcessor[] f19713f;

    /* renamed from: g, reason: collision with root package name */
    public final AudioProcessor[] f19714g;

    /* renamed from: h, reason: collision with root package name */
    public final ConditionVariable f19715h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.audio.b f19716i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayDeque<e> f19717j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f19718k;

    /* renamed from: l, reason: collision with root package name */
    public final int f19719l;

    /* renamed from: m, reason: collision with root package name */
    public h f19720m;

    /* renamed from: n, reason: collision with root package name */
    public final f<AudioSink.InitializationException> f19721n;

    /* renamed from: o, reason: collision with root package name */
    public final f<AudioSink.WriteException> f19722o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public AudioSink.a f19723p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public c f19724q;

    /* renamed from: r, reason: collision with root package name */
    public c f19725r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public AudioTrack f19726s;

    /* renamed from: t, reason: collision with root package name */
    public x4.d f19727t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public e f19728u;

    /* renamed from: v, reason: collision with root package name */
    public e f19729v;

    /* renamed from: w, reason: collision with root package name */
    public f1 f19730w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public ByteBuffer f19731x;

    /* renamed from: y, reason: collision with root package name */
    public int f19732y;

    /* renamed from: z, reason: collision with root package name */
    public long f19733z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public /* synthetic */ InvalidAudioTrackTimestampException(String str, a aVar) {
            this(str);
        }

        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a extends Thread {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AudioTrack f19734b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, AudioTrack audioTrack) {
            super(str);
            this.f19734b = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f19734b.flush();
                this.f19734b.release();
            } finally {
                DefaultAudioSink.this.f19715h.open();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        AudioProcessor[] a();

        f1 b(f1 f1Var);

        long c();

        long d(long j10);

        boolean e(boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Format f19736a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19737b;

        /* renamed from: c, reason: collision with root package name */
        public final int f19738c;

        /* renamed from: d, reason: collision with root package name */
        public final int f19739d;

        /* renamed from: e, reason: collision with root package name */
        public final int f19740e;

        /* renamed from: f, reason: collision with root package name */
        public final int f19741f;

        /* renamed from: g, reason: collision with root package name */
        public final int f19742g;

        /* renamed from: h, reason: collision with root package name */
        public final int f19743h;

        /* renamed from: i, reason: collision with root package name */
        public final AudioProcessor[] f19744i;

        public c(Format format, int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z10, AudioProcessor[] audioProcessorArr) {
            this.f19736a = format;
            this.f19737b = i10;
            this.f19738c = i11;
            this.f19739d = i12;
            this.f19740e = i13;
            this.f19741f = i14;
            this.f19742g = i15;
            this.f19744i = audioProcessorArr;
            this.f19743h = c(i16, z10);
        }

        @RequiresApi(21)
        public static AudioAttributes j(x4.d dVar, boolean z10) {
            if (z10) {
                return k();
            }
            return dVar.a();
        }

        @RequiresApi(21)
        public static AudioAttributes k() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(boolean z10, x4.d dVar, int i10) throws AudioSink.InitializationException {
            try {
                AudioTrack d10 = d(z10, dVar, i10);
                int state = d10.getState();
                if (state == 1) {
                    return d10;
                }
                try {
                    d10.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.f19740e, this.f19741f, this.f19743h, this.f19736a, o(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e2) {
                throw new AudioSink.InitializationException(0, this.f19740e, this.f19741f, this.f19743h, this.f19736a, o(), e2);
            }
        }

        public boolean b(c cVar) {
            return cVar.f19738c == this.f19738c && cVar.f19742g == this.f19742g && cVar.f19740e == this.f19740e && cVar.f19741f == this.f19741f && cVar.f19739d == this.f19739d;
        }

        public final int c(int i10, boolean z10) {
            if (i10 != 0) {
                return i10;
            }
            int i11 = this.f19738c;
            if (i11 == 0) {
                return m(z10 ? 8.0f : 1.0f);
            }
            if (i11 == 1) {
                return l(50000000L);
            }
            if (i11 == 2) {
                return l(250000L);
            }
            throw new IllegalStateException();
        }

        public final AudioTrack d(boolean z10, x4.d dVar, int i10) {
            int i11 = j0.f22990a;
            if (i11 >= 29) {
                return f(z10, dVar, i10);
            }
            if (i11 >= 21) {
                return e(z10, dVar, i10);
            }
            return g(dVar, i10);
        }

        @RequiresApi(21)
        public final AudioTrack e(boolean z10, x4.d dVar, int i10) {
            return new AudioTrack(j(dVar, z10), DefaultAudioSink.I(this.f19740e, this.f19741f, this.f19742g), this.f19743h, 1, i10);
        }

        @RequiresApi(29)
        public final AudioTrack f(boolean z10, x4.d dVar, int i10) {
            return new AudioTrack.Builder().setAudioAttributes(j(dVar, z10)).setAudioFormat(DefaultAudioSink.I(this.f19740e, this.f19741f, this.f19742g)).setTransferMode(1).setBufferSizeInBytes(this.f19743h).setSessionId(i10).setOffloadedPlayback(this.f19738c == 1).build();
        }

        public final AudioTrack g(x4.d dVar, int i10) {
            int c02 = j0.c0(dVar.f54388c);
            if (i10 == 0) {
                return new AudioTrack(c02, this.f19740e, this.f19741f, this.f19742g, this.f19743h, 1);
            }
            return new AudioTrack(c02, this.f19740e, this.f19741f, this.f19742g, this.f19743h, 1, i10);
        }

        public long h(long j10) {
            return (j10 * this.f19740e) / 1000000;
        }

        public long i(long j10) {
            return (j10 * 1000000) / this.f19740e;
        }

        public final int l(long j10) {
            int O = DefaultAudioSink.O(this.f19742g);
            if (this.f19742g == 5) {
                O *= 2;
            }
            return (int) ((j10 * O) / 1000000);
        }

        public final int m(float f10) {
            int minBufferSize = AudioTrack.getMinBufferSize(this.f19740e, this.f19741f, this.f19742g);
            com.google.android.exoplayer2.util.a.g(minBufferSize != -2);
            int r10 = j0.r(minBufferSize * 4, ((int) h(250000L)) * this.f19739d, Math.max(minBufferSize, ((int) h(750000L)) * this.f19739d));
            return f10 != 1.0f ? Math.round(r10 * f10) : r10;
        }

        public long n(long j10) {
            return (j10 * 1000000) / this.f19736a.A;
        }

        public boolean o() {
            return this.f19738c == 1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class d implements b {

        /* renamed from: a, reason: collision with root package name */
        public final AudioProcessor[] f19745a;

        /* renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.audio.h f19746b;

        /* renamed from: c, reason: collision with root package name */
        public final i f19747c;

        public d(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new com.google.android.exoplayer2.audio.h(), new i());
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public AudioProcessor[] a() {
            return this.f19745a;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public f1 b(f1 f1Var) {
            this.f19747c.h(f1Var.f20698a);
            this.f19747c.g(f1Var.f20699b);
            return f1Var;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long c() {
            return this.f19746b.o();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long d(long j10) {
            return this.f19747c.f(j10);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public boolean e(boolean z10) {
            this.f19746b.u(z10);
            return z10;
        }

        public d(AudioProcessor[] audioProcessorArr, com.google.android.exoplayer2.audio.h hVar, i iVar) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f19745a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f19746b = hVar;
            this.f19747c = iVar;
            audioProcessorArr2[audioProcessorArr.length] = hVar;
            audioProcessorArr2[audioProcessorArr.length + 1] = iVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final f1 f19748a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f19749b;

        /* renamed from: c, reason: collision with root package name */
        public final long f19750c;

        /* renamed from: d, reason: collision with root package name */
        public final long f19751d;

        public /* synthetic */ e(f1 f1Var, boolean z10, long j10, long j11, a aVar) {
            this(f1Var, z10, j10, j11);
        }

        public e(f1 f1Var, boolean z10, long j10, long j11) {
            this.f19748a = f1Var;
            this.f19749b = z10;
            this.f19750c = j10;
            this.f19751d = j11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f<T extends Exception> {

        /* renamed from: a, reason: collision with root package name */
        public final long f19752a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public T f19753b;

        /* renamed from: c, reason: collision with root package name */
        public long f19754c;

        public f(long j10) {
            this.f19752a = j10;
        }

        public void a() {
            this.f19753b = null;
        }

        public void b(T t2) throws Exception {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f19753b == null) {
                this.f19753b = t2;
                this.f19754c = this.f19752a + elapsedRealtime;
            }
            if (elapsedRealtime >= this.f19754c) {
                T t10 = this.f19753b;
                if (t10 != t2) {
                    t10.addSuppressed(t2);
                }
                T t11 = this.f19753b;
                a();
                throw t11;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class g implements b.a {
        public g() {
        }

        @Override // com.google.android.exoplayer2.audio.b.a
        public void a(long j10) {
            if (DefaultAudioSink.this.f19723p != null) {
                DefaultAudioSink.this.f19723p.a(j10);
            }
        }

        @Override // com.google.android.exoplayer2.audio.b.a
        public void b(long j10, long j11, long j12, long j13) {
            long R = DefaultAudioSink.this.R();
            long S = DefaultAudioSink.this.S();
            StringBuilder sb2 = new StringBuilder(182);
            sb2.append("Spurious audio timestamp (frame position mismatch): ");
            sb2.append(j10);
            sb2.append(", ");
            sb2.append(j11);
            sb2.append(", ");
            sb2.append(j12);
            sb2.append(", ");
            sb2.append(j13);
            sb2.append(", ");
            sb2.append(R);
            sb2.append(", ");
            sb2.append(S);
            String sb3 = sb2.toString();
            if (!DefaultAudioSink.f19707a0) {
                m.h("DefaultAudioSink", sb3);
                return;
            }
            throw new InvalidAudioTrackTimestampException(sb3, null);
        }

        @Override // com.google.android.exoplayer2.audio.b.a
        public void c(long j10, long j11, long j12, long j13) {
            long R = DefaultAudioSink.this.R();
            long S = DefaultAudioSink.this.S();
            StringBuilder sb2 = new StringBuilder(180);
            sb2.append("Spurious audio timestamp (system clock mismatch): ");
            sb2.append(j10);
            sb2.append(", ");
            sb2.append(j11);
            sb2.append(", ");
            sb2.append(j12);
            sb2.append(", ");
            sb2.append(j13);
            sb2.append(", ");
            sb2.append(R);
            sb2.append(", ");
            sb2.append(S);
            String sb3 = sb2.toString();
            if (!DefaultAudioSink.f19707a0) {
                m.h("DefaultAudioSink", sb3);
                return;
            }
            throw new InvalidAudioTrackTimestampException(sb3, null);
        }

        @Override // com.google.android.exoplayer2.audio.b.a
        public void d(int i10, long j10) {
            if (DefaultAudioSink.this.f19723p != null) {
                DefaultAudioSink.this.f19723p.c(i10, j10, SystemClock.elapsedRealtime() - DefaultAudioSink.this.X);
            }
        }

        @Override // com.google.android.exoplayer2.audio.b.a
        public void e(long j10) {
            StringBuilder sb2 = new StringBuilder(61);
            sb2.append("Ignoring impossibly large audio latency: ");
            sb2.append(j10);
            m.h("DefaultAudioSink", sb2.toString());
        }

        public /* synthetic */ g(DefaultAudioSink defaultAudioSink, a aVar) {
            this();
        }
    }

    @RequiresApi(29)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class h {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f19756a = new Handler();

        /* renamed from: b, reason: collision with root package name */
        public final AudioTrack.StreamEventCallback f19757b;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public class a extends AudioTrack.StreamEventCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DefaultAudioSink f19759a;

            public a(DefaultAudioSink defaultAudioSink) {
                this.f19759a = defaultAudioSink;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i10) {
                com.google.android.exoplayer2.util.a.g(audioTrack == DefaultAudioSink.this.f19726s);
                if (DefaultAudioSink.this.f19723p == null || !DefaultAudioSink.this.S) {
                    return;
                }
                DefaultAudioSink.this.f19723p.f();
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(@NonNull AudioTrack audioTrack) {
                com.google.android.exoplayer2.util.a.g(audioTrack == DefaultAudioSink.this.f19726s);
                if (DefaultAudioSink.this.f19723p == null || !DefaultAudioSink.this.S) {
                    return;
                }
                DefaultAudioSink.this.f19723p.f();
            }
        }

        public h() {
            this.f19757b = new a(DefaultAudioSink.this);
        }

        public void a(AudioTrack audioTrack) {
            final Handler handler = this.f19756a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new Executor() { // from class: x4.t
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handler.post(runnable);
                }
            }, this.f19757b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f19757b);
            this.f19756a.removeCallbacksAndMessages(null);
        }
    }

    public DefaultAudioSink(@Nullable x4.e eVar, b bVar, boolean z10, boolean z11, int i10) {
        this.f19708a = eVar;
        this.f19709b = (b) com.google.android.exoplayer2.util.a.e(bVar);
        int i11 = j0.f22990a;
        this.f19710c = i11 >= 21 && z10;
        this.f19718k = i11 >= 23 && z11;
        this.f19719l = i11 < 29 ? 0 : i10;
        this.f19715h = new ConditionVariable(true);
        this.f19716i = new com.google.android.exoplayer2.audio.b(new g(this, null));
        com.google.android.exoplayer2.audio.d dVar = new com.google.android.exoplayer2.audio.d();
        this.f19711d = dVar;
        j jVar = new j();
        this.f19712e = jVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new com.google.android.exoplayer2.audio.g(), dVar, jVar);
        Collections.addAll(arrayList, bVar.a());
        this.f19713f = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.f19714g = new AudioProcessor[]{new com.google.android.exoplayer2.audio.e()};
        this.H = 1.0f;
        this.f19727t = x4.d.f54384f;
        this.U = 0;
        this.V = new s(0, 0.0f);
        f1 f1Var = f1.f20696d;
        this.f19729v = new e(f1Var, false, 0L, 0L, null);
        this.f19730w = f1Var;
        this.P = -1;
        this.I = new AudioProcessor[0];
        this.J = new ByteBuffer[0];
        this.f19717j = new ArrayDeque<>();
        this.f19721n = new f<>(100L);
        this.f19722o = new f<>(100L);
    }

    @RequiresApi(21)
    public static AudioFormat I(int i10, int i11, int i12) {
        return new AudioFormat.Builder().setSampleRate(i10).setChannelMask(i11).setEncoding(i12).build();
    }

    public static int K(int i10) {
        int i11 = j0.f22990a;
        if (i11 <= 28) {
            if (i10 == 7) {
                i10 = 8;
            } else if (i10 == 3 || i10 == 4 || i10 == 5) {
                i10 = 6;
            }
        }
        if (i11 <= 26 && "fugu".equals(j0.f22991b) && i10 == 1) {
            i10 = 2;
        }
        return j0.G(i10);
    }

    @Nullable
    public static Pair<Integer, Integer> L(Format format, @Nullable x4.e eVar) {
        if (eVar == null) {
            return null;
        }
        int f10 = q.f((String) com.google.android.exoplayer2.util.a.e(format.f19544m), format.f19541j);
        int i10 = 6;
        if (!(f10 == 5 || f10 == 6 || f10 == 18 || f10 == 17 || f10 == 7 || f10 == 8 || f10 == 14)) {
            return null;
        }
        if (f10 == 18 && !eVar.f(18)) {
            f10 = 6;
        } else if (f10 == 8 && !eVar.f(8)) {
            f10 = 7;
        }
        if (!eVar.f(f10)) {
            return null;
        }
        if (f10 == 18) {
            if (j0.f22990a >= 29 && (i10 = N(18, format.A)) == 0) {
                m.h("DefaultAudioSink", "E-AC3 JOC encoding supported but no channel count supported");
                return null;
            }
        } else {
            i10 = format.f19557z;
            if (i10 > eVar.e()) {
                return null;
            }
        }
        int K = K(i10);
        if (K == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(f10), Integer.valueOf(K));
    }

    public static int M(int i10, ByteBuffer byteBuffer) {
        switch (i10) {
            case 5:
            case 6:
            case 18:
                return x4.b.d(byteBuffer);
            case 7:
            case 8:
                return u.e(byteBuffer);
            case 9:
                int m10 = v.m(j0.H(byteBuffer, byteBuffer.position()));
                if (m10 != -1) {
                    return m10;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            default:
                StringBuilder sb2 = new StringBuilder(38);
                sb2.append("Unexpected audio encoding: ");
                sb2.append(i10);
                throw new IllegalStateException(sb2.toString());
            case 14:
                int a10 = x4.b.a(byteBuffer);
                if (a10 == -1) {
                    return 0;
                }
                return x4.b.h(byteBuffer, a10) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return x4.c.c(byteBuffer);
        }
    }

    @RequiresApi(29)
    public static int N(int i10, int i11) {
        AudioAttributes build = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
        for (int i12 = 8; i12 > 0; i12--) {
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i10).setSampleRate(i11).setChannelMask(j0.G(i12)).build(), build)) {
                return i12;
            }
        }
        return 0;
    }

    public static int O(int i10) {
        switch (i10) {
            case 5:
                return MediationConstant.ErrorCode.ADN_INIT_FAIL;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return TaskConstants.TASK_CHILD_LAYER_TASK_OVERLAY;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
        }
    }

    public static boolean U(int i10) {
        return (j0.f22990a >= 24 && i10 == -6) || i10 == -32;
    }

    public static boolean W() {
        return j0.f22990a >= 30 && j0.f22993d.startsWith("Pixel");
    }

    public static boolean X(AudioTrack audioTrack) {
        return j0.f22990a >= 29 && audioTrack.isOffloadedPlayback();
    }

    public static boolean Y(Format format, @Nullable x4.e eVar) {
        return L(format, eVar) != null;
    }

    @RequiresApi(21)
    public static void h0(AudioTrack audioTrack, float f10) {
        audioTrack.setVolume(f10);
    }

    public static void i0(AudioTrack audioTrack, float f10) {
        audioTrack.setStereoVolume(f10, f10);
    }

    @RequiresApi(21)
    public static int o0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i10) {
        return audioTrack.write(byteBuffer, i10, 1);
    }

    public final void C(long j10) {
        f1 f1Var;
        if (k0()) {
            f1Var = this.f19709b.b(J());
        } else {
            f1Var = f1.f20696d;
        }
        f1 f1Var2 = f1Var;
        boolean e2 = k0() ? this.f19709b.e(Q()) : false;
        this.f19717j.add(new e(f1Var2, e2, Math.max(0L, j10), this.f19725r.i(S()), null));
        j0();
        AudioSink.a aVar = this.f19723p;
        if (aVar != null) {
            aVar.onSkipSilenceEnabledChanged(e2);
        }
    }

    public final long D(long j10) {
        while (!this.f19717j.isEmpty() && j10 >= this.f19717j.getFirst().f19751d) {
            this.f19729v = this.f19717j.remove();
        }
        e eVar = this.f19729v;
        long j11 = j10 - eVar.f19751d;
        if (eVar.f19748a.equals(f1.f20696d)) {
            return this.f19729v.f19750c + j11;
        }
        if (this.f19717j.isEmpty()) {
            return this.f19729v.f19750c + this.f19709b.d(j11);
        }
        e first = this.f19717j.getFirst();
        return first.f19750c - j0.W(first.f19751d - j10, this.f19729v.f19748a.f20698a);
    }

    public final long E(long j10) {
        return j10 + this.f19725r.i(this.f19709b.c());
    }

    public final AudioTrack F() throws AudioSink.InitializationException {
        try {
            return ((c) com.google.android.exoplayer2.util.a.e(this.f19725r)).a(this.W, this.f19727t, this.U);
        } catch (AudioSink.InitializationException e2) {
            Z();
            AudioSink.a aVar = this.f19723p;
            if (aVar != null) {
                aVar.b(e2);
            }
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0029 -> B:4:0x0009). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean G() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.P
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto Lb
            r9.P = r3
        L9:
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            int r4 = r9.P
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.I
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.c()
        L1f:
            r9.b0(r7)
            boolean r0 = r4.b()
            if (r0 != 0) goto L29
            return r3
        L29:
            int r0 = r9.P
            int r0 = r0 + r2
            r9.P = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.M
            if (r0 == 0) goto L3b
            r9.n0(r0, r7)
            java.nio.ByteBuffer r0 = r9.M
            if (r0 == 0) goto L3b
            return r3
        L3b:
            r9.P = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.G():boolean");
    }

    public final void H() {
        int i10 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.I;
            if (i10 >= audioProcessorArr.length) {
                return;
            }
            AudioProcessor audioProcessor = audioProcessorArr[i10];
            audioProcessor.flush();
            this.J[i10] = audioProcessor.d();
            i10++;
        }
    }

    public final f1 J() {
        return P().f19748a;
    }

    public final e P() {
        e eVar = this.f19728u;
        if (eVar != null) {
            return eVar;
        }
        if (!this.f19717j.isEmpty()) {
            return this.f19717j.getLast();
        }
        return this.f19729v;
    }

    public boolean Q() {
        return P().f19749b;
    }

    public final long R() {
        if (this.f19725r.f19738c == 0) {
            return this.f19733z / r0.f19737b;
        }
        return this.A;
    }

    public final long S() {
        if (this.f19725r.f19738c == 0) {
            return this.B / r0.f19739d;
        }
        return this.C;
    }

    public final void T() throws AudioSink.InitializationException {
        this.f19715h.block();
        AudioTrack F = F();
        this.f19726s = F;
        if (X(F)) {
            c0(this.f19726s);
            if (this.f19719l != 3) {
                AudioTrack audioTrack = this.f19726s;
                Format format = this.f19725r.f19736a;
                audioTrack.setOffloadDelayPadding(format.C, format.D);
            }
        }
        this.U = this.f19726s.getAudioSessionId();
        com.google.android.exoplayer2.audio.b bVar = this.f19716i;
        AudioTrack audioTrack2 = this.f19726s;
        c cVar = this.f19725r;
        bVar.t(audioTrack2, cVar.f19738c == 2, cVar.f19742g, cVar.f19739d, cVar.f19743h);
        g0();
        int i10 = this.V.f54436a;
        if (i10 != 0) {
            this.f19726s.attachAuxEffect(i10);
            this.f19726s.setAuxEffectSendLevel(this.V.f54437b);
        }
        this.F = true;
    }

    public final boolean V() {
        return this.f19726s != null;
    }

    public final void Z() {
        if (this.f19725r.o()) {
            this.Y = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(Format format) {
        return m(format) != 0;
    }

    public final void a0() {
        if (this.R) {
            return;
        }
        this.R = true;
        this.f19716i.h(S());
        this.f19726s.stop();
        this.f19732y = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean b() {
        return !V() || (this.Q && !h());
    }

    public final void b0(long j10) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.I.length;
        int i10 = length;
        while (i10 >= 0) {
            if (i10 > 0) {
                byteBuffer = this.J[i10 - 1];
            } else {
                byteBuffer = this.K;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.f19701a;
                }
            }
            if (i10 == length) {
                n0(byteBuffer, j10);
            } else {
                AudioProcessor audioProcessor = this.I[i10];
                if (i10 > this.P) {
                    audioProcessor.a(byteBuffer);
                }
                ByteBuffer d10 = audioProcessor.d();
                this.J[i10] = d10;
                if (d10.hasRemaining()) {
                    i10++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i10--;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void c(f1 f1Var) {
        f1 f1Var2 = new f1(j0.q(f1Var.f20698a, 0.1f, 8.0f), j0.q(f1Var.f20699b, 0.1f, 8.0f));
        if (this.f19718k && j0.f22990a >= 23) {
            f0(f1Var2);
        } else {
            e0(f1Var2, Q());
        }
    }

    @RequiresApi(29)
    public final void c0(AudioTrack audioTrack) {
        if (this.f19720m == null) {
            this.f19720m = new h();
        }
        this.f19720m.a(audioTrack);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public f1 d() {
        if (this.f19718k) {
            return this.f19730w;
        }
        return J();
    }

    public final void d0() {
        this.f19733z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.Z = false;
        this.D = 0;
        this.f19729v = new e(J(), Q(), 0L, 0L, null);
        this.G = 0L;
        this.f19728u = null;
        this.f19717j.clear();
        this.K = null;
        this.L = 0;
        this.M = null;
        this.R = false;
        this.Q = false;
        this.P = -1;
        this.f19731x = null;
        this.f19732y = 0;
        this.f19712e.m();
        H();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void e() {
        if (this.W) {
            this.W = false;
            flush();
        }
    }

    public final void e0(f1 f1Var, boolean z10) {
        e P = P();
        if (f1Var.equals(P.f19748a) && z10 == P.f19749b) {
            return;
        }
        e eVar = new e(f1Var, z10, -9223372036854775807L, -9223372036854775807L, null);
        if (V()) {
            this.f19728u = eVar;
        } else {
            this.f19729v = eVar;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void f() {
        if (j0.f22990a < 25) {
            flush();
            return;
        }
        this.f19722o.a();
        this.f19721n.a();
        if (V()) {
            d0();
            if (this.f19716i.j()) {
                this.f19726s.pause();
            }
            this.f19726s.flush();
            this.f19716i.r();
            com.google.android.exoplayer2.audio.b bVar = this.f19716i;
            AudioTrack audioTrack = this.f19726s;
            c cVar = this.f19725r;
            bVar.t(audioTrack, cVar.f19738c == 2, cVar.f19742g, cVar.f19739d, cVar.f19743h);
            this.F = true;
        }
    }

    @RequiresApi(23)
    public final void f0(f1 f1Var) {
        if (V()) {
            try {
                this.f19726s.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(f1Var.f20698a).setPitch(f1Var.f20699b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                m.i("DefaultAudioSink", "Failed to set playback params", e2);
            }
            f1Var = new f1(this.f19726s.getPlaybackParams().getSpeed(), this.f19726s.getPlaybackParams().getPitch());
            this.f19716i.u(f1Var.f20698a);
        }
        this.f19730w = f1Var;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (V()) {
            d0();
            if (this.f19716i.j()) {
                this.f19726s.pause();
            }
            if (X(this.f19726s)) {
                ((h) com.google.android.exoplayer2.util.a.e(this.f19720m)).b(this.f19726s);
            }
            AudioTrack audioTrack = this.f19726s;
            this.f19726s = null;
            if (j0.f22990a < 21 && !this.T) {
                this.U = 0;
            }
            c cVar = this.f19724q;
            if (cVar != null) {
                this.f19725r = cVar;
                this.f19724q = null;
            }
            this.f19716i.r();
            this.f19715h.close();
            new a("ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
        this.f19722o.a();
        this.f19721n.a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void g() {
        com.google.android.exoplayer2.util.a.g(j0.f22990a >= 21);
        com.google.android.exoplayer2.util.a.g(this.T);
        if (this.W) {
            return;
        }
        this.W = true;
        flush();
    }

    public final void g0() {
        if (V()) {
            if (j0.f22990a >= 21) {
                h0(this.f19726s, this.H);
            } else {
                i0(this.f19726s, this.H);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean h() {
        return V() && this.f19716i.i(S());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void i(int i10) {
        if (this.U != i10) {
            this.U = i10;
            this.T = i10 != 0;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean j(ByteBuffer byteBuffer, long j10, int i10) throws AudioSink.InitializationException, AudioSink.WriteException {
        ByteBuffer byteBuffer2 = this.K;
        com.google.android.exoplayer2.util.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f19724q != null) {
            if (!G()) {
                return false;
            }
            if (!this.f19724q.b(this.f19725r)) {
                a0();
                if (h()) {
                    return false;
                }
                flush();
            } else {
                this.f19725r = this.f19724q;
                this.f19724q = null;
                if (X(this.f19726s) && this.f19719l != 3) {
                    this.f19726s.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.f19726s;
                    Format format = this.f19725r.f19736a;
                    audioTrack.setOffloadDelayPadding(format.C, format.D);
                    this.Z = true;
                }
            }
            C(j10);
        }
        if (!V()) {
            try {
                T();
            } catch (AudioSink.InitializationException e2) {
                if (!e2.isRecoverable) {
                    this.f19721n.b(e2);
                    return false;
                }
                throw e2;
            }
        }
        this.f19721n.a();
        if (this.F) {
            this.G = Math.max(0L, j10);
            this.E = false;
            this.F = false;
            if (this.f19718k && j0.f22990a >= 23) {
                f0(this.f19730w);
            }
            C(j10);
            if (this.S) {
                play();
            }
        }
        if (!this.f19716i.l(S())) {
            return false;
        }
        if (this.K == null) {
            com.google.android.exoplayer2.util.a.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            c cVar = this.f19725r;
            if (cVar.f19738c != 0 && this.D == 0) {
                int M = M(cVar.f19742g, byteBuffer);
                this.D = M;
                if (M == 0) {
                    return true;
                }
            }
            if (this.f19728u != null) {
                if (!G()) {
                    return false;
                }
                C(j10);
                this.f19728u = null;
            }
            long n10 = this.G + this.f19725r.n(R() - this.f19712e.l());
            if (!this.E && Math.abs(n10 - j10) > 200000) {
                this.f19723p.b(new AudioSink.UnexpectedDiscontinuityException(j10, n10));
                this.E = true;
            }
            if (this.E) {
                if (!G()) {
                    return false;
                }
                long j11 = j10 - n10;
                this.G += j11;
                this.E = false;
                C(j10);
                AudioSink.a aVar = this.f19723p;
                if (aVar != null && j11 != 0) {
                    aVar.e();
                }
            }
            if (this.f19725r.f19738c == 0) {
                this.f19733z += byteBuffer.remaining();
            } else {
                this.A += this.D * i10;
            }
            this.K = byteBuffer;
            this.L = i10;
        }
        b0(j10);
        if (!this.K.hasRemaining()) {
            this.K = null;
            this.L = 0;
            return true;
        }
        if (!this.f19716i.k(S())) {
            return false;
        }
        m.h("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    public final void j0() {
        AudioProcessor[] audioProcessorArr = this.f19725r.f19744i;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.I = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.J = new ByteBuffer[size];
        H();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void k(s sVar) {
        if (this.V.equals(sVar)) {
            return;
        }
        int i10 = sVar.f54436a;
        float f10 = sVar.f54437b;
        AudioTrack audioTrack = this.f19726s;
        if (audioTrack != null) {
            if (this.V.f54436a != i10) {
                audioTrack.attachAuxEffect(i10);
            }
            if (i10 != 0) {
                this.f19726s.setAuxEffectSendLevel(f10);
            }
        }
        this.V = sVar;
    }

    public final boolean k0() {
        return (this.W || !"audio/raw".equals(this.f19725r.f19736a.f19544m) || l0(this.f19725r.f19736a.B)) ? false : true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void l(AudioSink.a aVar) {
        this.f19723p = aVar;
    }

    public final boolean l0(int i10) {
        return this.f19710c && j0.n0(i10);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int m(Format format) {
        if (!"audio/raw".equals(format.f19544m)) {
            return ((this.Y || !m0(format, this.f19727t)) && !Y(format, this.f19708a)) ? 0 : 2;
        }
        if (!j0.o0(format.B)) {
            int i10 = format.B;
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("Invalid PCM encoding: ");
            sb2.append(i10);
            m.h("DefaultAudioSink", sb2.toString());
            return 0;
        }
        int i11 = format.B;
        return (i11 == 2 || (this.f19710c && i11 == 4)) ? 2 : 1;
    }

    public final boolean m0(Format format, x4.d dVar) {
        int f10;
        int G;
        if (j0.f22990a < 29 || this.f19719l == 0 || (f10 = q.f((String) com.google.android.exoplayer2.util.a.e(format.f19544m), format.f19541j)) == 0 || (G = j0.G(format.f19557z)) == 0 || !AudioManager.isOffloadedPlaybackSupported(I(format.A, G, f10), dVar.a())) {
            return false;
        }
        return ((format.C != 0 || format.D != 0) && (this.f19719l == 1) && !W()) ? false : true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void n() throws AudioSink.WriteException {
        if (!this.Q && V() && G()) {
            a0();
            this.Q = true;
        }
    }

    public final void n0(ByteBuffer byteBuffer, long j10) throws AudioSink.WriteException {
        int o02;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.M;
            if (byteBuffer2 != null) {
                com.google.android.exoplayer2.util.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.M = byteBuffer;
                if (j0.f22990a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.N;
                    if (bArr == null || bArr.length < remaining) {
                        this.N = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.N, 0, remaining);
                    byteBuffer.position(position);
                    this.O = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (j0.f22990a < 21) {
                int c4 = this.f19716i.c(this.B);
                if (c4 > 0) {
                    o02 = this.f19726s.write(this.N, this.O, Math.min(remaining2, c4));
                    if (o02 > 0) {
                        this.O += o02;
                        byteBuffer.position(byteBuffer.position() + o02);
                    }
                } else {
                    o02 = 0;
                }
            } else if (this.W) {
                com.google.android.exoplayer2.util.a.g(j10 != -9223372036854775807L);
                o02 = p0(this.f19726s, byteBuffer, remaining2, j10);
            } else {
                o02 = o0(this.f19726s, byteBuffer, remaining2);
            }
            this.X = SystemClock.elapsedRealtime();
            if (o02 < 0) {
                boolean U = U(o02);
                if (U) {
                    Z();
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(o02, this.f19725r.f19736a, U);
                AudioSink.a aVar = this.f19723p;
                if (aVar != null) {
                    aVar.b(writeException);
                }
                if (!writeException.isRecoverable) {
                    this.f19722o.b(writeException);
                    return;
                }
                throw writeException;
            }
            this.f19722o.a();
            if (X(this.f19726s)) {
                long j11 = this.C;
                if (j11 > 0) {
                    this.Z = false;
                }
                if (this.S && this.f19723p != null && o02 < remaining2 && !this.Z) {
                    this.f19723p.d(this.f19716i.e(j11));
                }
            }
            int i10 = this.f19725r.f19738c;
            if (i10 == 0) {
                this.B += o02;
            }
            if (o02 == remaining2) {
                if (i10 != 0) {
                    com.google.android.exoplayer2.util.a.g(byteBuffer == this.K);
                    this.C += this.D * this.L;
                }
                this.M = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void o(x4.d dVar) {
        if (this.f19727t.equals(dVar)) {
            return;
        }
        this.f19727t = dVar;
        if (this.W) {
            return;
        }
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long p(boolean z10) {
        if (!V() || this.F) {
            return Long.MIN_VALUE;
        }
        return E(D(Math.min(this.f19716i.d(z10), this.f19725r.i(S()))));
    }

    @RequiresApi(21)
    public final int p0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i10, long j10) {
        if (j0.f22990a >= 26) {
            return audioTrack.write(byteBuffer, i10, 1, j10 * 1000);
        }
        if (this.f19731x == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.f19731x = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.f19731x.putInt(1431633921);
        }
        if (this.f19732y == 0) {
            this.f19731x.putInt(4, i10);
            this.f19731x.putLong(8, j10 * 1000);
            this.f19731x.position(0);
            this.f19732y = i10;
        }
        int remaining = this.f19731x.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.f19731x, remaining, 1);
            if (write < 0) {
                this.f19732y = 0;
                return write;
            }
            if (write < remaining) {
                return 0;
            }
        }
        int o02 = o0(audioTrack, byteBuffer, i10);
        if (o02 < 0) {
            this.f19732y = 0;
            return o02;
        }
        this.f19732y -= o02;
        return o02;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.S = false;
        if (V() && this.f19716i.q()) {
            this.f19726s.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.S = true;
        if (V()) {
            this.f19716i.v();
            this.f19726s.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void q() {
        this.E = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void r(Format format, int i10, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessor[] audioProcessorArr;
        int intValue;
        int i11;
        int i12;
        int intValue2;
        int i13;
        int i14;
        AudioProcessor[] audioProcessorArr2;
        int[] iArr2;
        if ("audio/raw".equals(format.f19544m)) {
            com.google.android.exoplayer2.util.a.a(j0.o0(format.B));
            i11 = j0.a0(format.B, format.f19557z);
            if (l0(format.B)) {
                audioProcessorArr2 = this.f19714g;
            } else {
                audioProcessorArr2 = this.f19713f;
            }
            this.f19712e.n(format.C, format.D);
            if (j0.f22990a < 21 && format.f19557z == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i15 = 0; i15 < 6; i15++) {
                    iArr2[i15] = i15;
                }
            } else {
                iArr2 = iArr;
            }
            this.f19711d.l(iArr2);
            AudioProcessor.a aVar = new AudioProcessor.a(format.A, format.f19557z, format.B);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.a e2 = audioProcessor.e(aVar);
                    if (audioProcessor.isActive()) {
                        aVar = e2;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e10) {
                    throw new AudioSink.ConfigurationException(e10, format);
                }
            }
            int i16 = aVar.f19705c;
            i13 = aVar.f19703a;
            intValue2 = j0.G(aVar.f19704b);
            audioProcessorArr = audioProcessorArr2;
            intValue = i16;
            i12 = j0.a0(i16, aVar.f19704b);
            i14 = 0;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i17 = format.A;
            if (m0(format, this.f19727t)) {
                audioProcessorArr = audioProcessorArr3;
                intValue = q.f((String) com.google.android.exoplayer2.util.a.e(format.f19544m), format.f19541j);
                intValue2 = j0.G(format.f19557z);
                i11 = -1;
                i12 = -1;
                i13 = i17;
                i14 = 1;
            } else {
                Pair<Integer, Integer> L = L(format, this.f19708a);
                if (L != null) {
                    audioProcessorArr = audioProcessorArr3;
                    intValue = ((Integer) L.first).intValue();
                    i11 = -1;
                    i12 = -1;
                    intValue2 = ((Integer) L.second).intValue();
                    i13 = i17;
                    i14 = 2;
                } else {
                    String valueOf = String.valueOf(format);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 37);
                    sb2.append("Unable to configure passthrough for: ");
                    sb2.append(valueOf);
                    throw new AudioSink.ConfigurationException(sb2.toString(), format);
                }
            }
        }
        if (intValue == 0) {
            String valueOf2 = String.valueOf(format);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 48);
            sb3.append("Invalid output encoding (mode=");
            sb3.append(i14);
            sb3.append(") for: ");
            sb3.append(valueOf2);
            throw new AudioSink.ConfigurationException(sb3.toString(), format);
        }
        if (intValue2 != 0) {
            this.Y = false;
            c cVar = new c(format, i11, i14, i12, i13, intValue2, intValue, i10, this.f19718k, audioProcessorArr);
            if (V()) {
                this.f19724q = cVar;
                return;
            } else {
                this.f19725r = cVar;
                return;
            }
        }
        String valueOf3 = String.valueOf(format);
        StringBuilder sb4 = new StringBuilder(valueOf3.length() + 54);
        sb4.append("Invalid output channel config (mode=");
        sb4.append(i14);
        sb4.append(") for: ");
        sb4.append(valueOf3);
        throw new AudioSink.ConfigurationException(sb4.toString(), format);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        for (AudioProcessor audioProcessor : this.f19713f) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.f19714g) {
            audioProcessor2.reset();
        }
        this.S = false;
        this.Y = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void s(boolean z10) {
        e0(J(), z10);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f10) {
        if (this.H != f10) {
            this.H = f10;
            g0();
        }
    }
}
