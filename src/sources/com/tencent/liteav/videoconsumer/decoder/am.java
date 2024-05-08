package com.tencent.liteav.videoconsumer.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class am {
    public static void a(MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat, @Nullable Surface surface) {
        mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
    }

    public static void a(MediaCodec mediaCodec, int i10, int i11, long j10, int i12) {
        mediaCodec.queueInputBuffer(i10, 0, i11, j10, i12);
    }
}
