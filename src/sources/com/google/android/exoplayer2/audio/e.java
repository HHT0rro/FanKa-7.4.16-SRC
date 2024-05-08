package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.j0;
import java.nio.ByteBuffer;

/* compiled from: FloatResamplingAudioProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e extends c {

    /* renamed from: i, reason: collision with root package name */
    public static final int f19798i = Float.floatToIntBits(Float.NaN);

    public static void l(int i10, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i10 * 4.656612875245797E-10d));
        if (floatToIntBits == f19798i) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        ByteBuffer k10;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i10 = limit - position;
        int i11 = this.f19789b.f19705c;
        if (i11 == 536870912) {
            k10 = k((i10 / 3) * 4);
            while (position < limit) {
                l(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), k10);
                position += 3;
            }
        } else if (i11 == 805306368) {
            k10 = k(i10);
            while (position < limit) {
                l((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), k10);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        k10.flip();
    }

    @Override // com.google.android.exoplayer2.audio.c
    public AudioProcessor.a g(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        int i10 = aVar.f19705c;
        if (!j0.n0(i10)) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        if (i10 != 4) {
            return new AudioProcessor.a(aVar.f19703a, aVar.f19704b, 4);
        }
        return AudioProcessor.a.f19702e;
    }
}
