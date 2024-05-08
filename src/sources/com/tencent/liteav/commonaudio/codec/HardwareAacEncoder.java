package com.tencent.liteav.commonaudio.codec;

import android.media.MediaFormat;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.commonaudio.codec.AacMediaCodecWrapper;
import java.nio.ByteBuffer;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HardwareAacEncoder {

    /* renamed from: a, reason: collision with root package name */
    private final AacMediaCodecWrapper f43115a = new AacMediaCodecWrapper(AacMediaCodecWrapper.a.f43111a);

    @CalledByNative
    public HardwareAacEncoder() {
    }

    @CalledByNative
    public ByteBuffer encode(ByteBuffer byteBuffer) {
        return this.f43115a.processFrame(byteBuffer);
    }

    @CalledByNative
    public boolean init(int i10, int i11, int i12) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i10, i11);
        createAudioFormat.setInteger(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i12);
        createAudioFormat.setInteger("aac-profile", 2);
        return this.f43115a.a(createAudioFormat);
    }

    @CalledByNative
    public void unInit() {
        this.f43115a.a();
    }
}
