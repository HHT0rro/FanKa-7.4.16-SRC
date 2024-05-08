package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.j0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface AudioProcessor {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f19701a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class UnhandledAudioFormatException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public UnhandledAudioFormatException(com.google.android.exoplayer2.audio.AudioProcessor.a r3) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                int r0 = r0 + 18
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                java.lang.String r0 = "Unhandled format: "
                r1.append(r0)
                r1.append(r3)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException.<init>(com.google.android.exoplayer2.audio.AudioProcessor$a):void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static final a f19702e = new a(-1, -1, -1);

        /* renamed from: a, reason: collision with root package name */
        public final int f19703a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19704b;

        /* renamed from: c, reason: collision with root package name */
        public final int f19705c;

        /* renamed from: d, reason: collision with root package name */
        public final int f19706d;

        public a(int i10, int i11, int i12) {
            this.f19703a = i10;
            this.f19704b = i11;
            this.f19705c = i12;
            this.f19706d = j0.o0(i12) ? j0.a0(i12, i11) : -1;
        }

        public String toString() {
            int i10 = this.f19703a;
            int i11 = this.f19704b;
            int i12 = this.f19705c;
            StringBuilder sb2 = new StringBuilder(83);
            sb2.append("AudioFormat[sampleRate=");
            sb2.append(i10);
            sb2.append(", channelCount=");
            sb2.append(i11);
            sb2.append(", encoding=");
            sb2.append(i12);
            sb2.append(']');
            return sb2.toString();
        }
    }

    void a(ByteBuffer byteBuffer);

    boolean b();

    void c();

    ByteBuffer d();

    a e(a aVar) throws UnhandledAudioFormatException;

    void flush();

    boolean isActive();

    void reset();
}
