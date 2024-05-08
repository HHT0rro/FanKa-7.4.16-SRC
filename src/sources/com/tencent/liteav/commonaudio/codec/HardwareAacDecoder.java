package com.tencent.liteav.commonaudio.codec;

import android.media.MediaFormat;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.commonaudio.codec.AacMediaCodecWrapper;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HardwareAacDecoder {

    /* renamed from: a, reason: collision with root package name */
    private final AacMediaCodecWrapper f43114a = new AacMediaCodecWrapper(AacMediaCodecWrapper.a.f43112b);

    @CalledByNative
    public HardwareAacDecoder() {
    }

    @CalledByNative
    public ByteBuffer decode(ByteBuffer byteBuffer) {
        return this.f43114a.processFrame(byteBuffer);
    }

    @CalledByNative
    public int getCacheSize() {
        return this.f43114a.f43106b;
    }

    @CalledByNative
    public int getOutputChannelCount() {
        MediaFormat mediaFormat = this.f43114a.f43105a;
        if (mediaFormat == null) {
            return -1;
        }
        try {
            return mediaFormat.getInteger("channel-count");
        } catch (Exception e2) {
            Log.e("HardwareAacDecoder", "getOutputChannelCount failed. ".concat(String.valueOf(e2)), new Object[0]);
            return -1;
        }
    }

    @CalledByNative
    public int getOutputSampleRate() {
        MediaFormat mediaFormat = this.f43114a.f43105a;
        if (mediaFormat == null) {
            return -1;
        }
        try {
            return mediaFormat.getInteger("sample-rate");
        } catch (Exception e2) {
            Log.e("HardwareAacDecoder", "getOutputSampleRate failed. ".concat(String.valueOf(e2)), new Object[0]);
            return -1;
        }
    }

    @CalledByNative
    public boolean init(int i10, int i11, ByteBuffer byteBuffer) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i10, i11);
        createAudioFormat.setString(DatabaseSourceInfoStorage.COLUMN_MIME, "audio/mp4a-latm");
        createAudioFormat.setByteBuffer("csd-0", byteBuffer);
        return this.f43114a.a(createAudioFormat);
    }

    @CalledByNative
    public void unInit() {
        this.f43114a.a();
    }
}
