package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* compiled from: ChannelMappingAudioProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d extends c {

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public int[] f19796i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public int[] f19797j;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) com.google.android.exoplayer2.util.a.e(this.f19797j);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer k10 = k(((limit - position) / this.f19789b.f19706d) * this.f19790c.f19706d);
        while (position < limit) {
            for (int i10 : iArr) {
                k10.putShort(byteBuffer.getShort((i10 * 2) + position));
            }
            position += this.f19789b.f19706d;
        }
        byteBuffer.position(limit);
        k10.flip();
    }

    @Override // com.google.android.exoplayer2.audio.c
    public AudioProcessor.a g(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.f19796i;
        if (iArr == null) {
            return AudioProcessor.a.f19702e;
        }
        if (aVar.f19705c == 2) {
            boolean z10 = aVar.f19704b != iArr.length;
            int i10 = 0;
            while (i10 < iArr.length) {
                int i11 = iArr[i10];
                if (i11 >= aVar.f19704b) {
                    throw new AudioProcessor.UnhandledAudioFormatException(aVar);
                }
                z10 |= i11 != i10;
                i10++;
            }
            if (z10) {
                return new AudioProcessor.a(aVar.f19703a, iArr.length, 2);
            }
            return AudioProcessor.a.f19702e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void h() {
        this.f19797j = this.f19796i;
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void j() {
        this.f19797j = null;
        this.f19796i = null;
    }

    public void l(@Nullable int[] iArr) {
        this.f19796i = iArr;
    }
}
