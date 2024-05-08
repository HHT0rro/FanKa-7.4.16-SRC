package com.tencent.liteav.audio.musicdecoder;

import android.media.MediaFormat;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;
import wseemann.media.FFmpegMediaMetadataRetriever;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MusicResourceDecoderAndroid {
    private static final String TAG = "MusicResourceDecoderAndroid";
    private final MediaCodecBridge mDecoder = new MediaCodecBridge();

    @CalledByNative
    public MusicResourceDecoderAndroid() {
    }

    @CalledByNative
    public ByteBuffer decode() {
        return this.mDecoder.processFrame();
    }

    @CalledByNative
    public int getBitrate() {
        MediaFormat outputFormat = this.mDecoder.getOutputFormat();
        if (outputFormat == null) {
            return -1;
        }
        try {
            return outputFormat.getInteger(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
        } catch (Exception e2) {
            Log.e(TAG, "getDuration failed. ".concat(String.valueOf(e2)), new Object[0]);
            return -1;
        }
    }

    @CalledByNative
    public int getChannelCount() {
        MediaFormat outputFormat = this.mDecoder.getOutputFormat();
        if (outputFormat == null) {
            return -1;
        }
        try {
            return outputFormat.getInteger("channel-count");
        } catch (Exception e2) {
            Log.e(TAG, "getChannelCount failed. ".concat(String.valueOf(e2)), new Object[0]);
            return -1;
        }
    }

    @CalledByNative
    public long getDuration() {
        return (this.mDecoder.getLongestDuration() + 500) / 1000;
    }

    @CalledByNative
    public int getSampleRate() {
        MediaFormat outputFormat = this.mDecoder.getOutputFormat();
        if (outputFormat == null) {
            return -1;
        }
        try {
            return outputFormat.getInteger("sample-rate");
        } catch (Exception e2) {
            Log.e(TAG, "getSampleRate failed. ".concat(String.valueOf(e2)), new Object[0]);
            return -1;
        }
    }

    @CalledByNative
    public int getTotalRawDataSize() {
        return this.mDecoder.getTotalRawDataSize();
    }

    @CalledByNative
    public int getTrackCount() {
        return this.mDecoder.getTrackCount();
    }

    @CalledByNative
    public boolean isDecodeEnd() {
        return this.mDecoder.isDecodeEnd();
    }

    @CalledByNative
    public boolean seekTo(long j10) {
        return this.mDecoder.seekTo(j10 * 1000);
    }

    @CalledByNative
    public void setMusicTrack(int i10) {
        this.mDecoder.setMusicTrack(i10);
    }

    @CalledByNative
    public boolean start(String str) {
        return this.mDecoder.initAndStart(str);
    }

    @CalledByNative
    public void stop() {
        this.mDecoder.stop();
    }
}
