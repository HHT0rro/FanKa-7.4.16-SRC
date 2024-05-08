package com.tencent.liteav.audio.musicdecoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MediaCodecBridge {
    private static final String TAG = "MediaCodecBridge";
    private static final long TIMEOUT_MS = 2000;
    private boolean mDecodeEOS;
    private MediaFormat mFormat;
    private long mLongestDurationUs;
    private MediaCodec mMediaCodec;
    private MediaExtractor mMediaExtractor;
    private String mMime;
    private int mRawDataSize;
    private int mTrackCount;
    private int mTrackIndex;

    private ByteBuffer dequeueOutputBuffer() {
        ByteBuffer byteBuffer;
        if (this.mDecodeEOS) {
            return null;
        }
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(TIMEOUT_MS));
            if (dequeueOutputBuffer == -1) {
                return null;
            }
            if (dequeueOutputBuffer == -3) {
                Log.i(TAG, "codec output buffers changed.", new Object[0]);
                return null;
            }
            if (dequeueOutputBuffer == -2) {
                this.mFormat = this.mMediaCodec.getOutputFormat();
                Log.i(TAG, "codec output format changed: " + ((Object) this.mFormat), new Object[0]);
                return null;
            }
            if (dequeueOutputBuffer < 0) {
                Log.e(TAG, "unexpected result from dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)), new Object[0]);
                return null;
            }
            if ((bufferInfo.flags & 4) != 0) {
                Log.i(TAG, "Decode to EOS", new Object[0]);
                this.mDecodeEOS = true;
                return null;
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                byteBuffer = this.mMediaCodec.getOutputBuffer(dequeueOutputBuffer);
            } else {
                byteBuffer = this.mMediaCodec.getOutputBuffers()[dequeueOutputBuffer];
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bufferInfo.size);
            allocateDirect.put(byteBuffer);
            this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
            return allocateDirect;
        } catch (IllegalStateException e2) {
            Log.e(TAG, "Failed to dequeue output buffer", e2);
            return null;
        }
    }

    private ByteBuffer drainData() {
        for (int i10 = 0; i10 < 3; i10++) {
            ByteBuffer dequeueOutputBuffer = dequeueOutputBuffer();
            if (dequeueOutputBuffer != null) {
                return dequeueOutputBuffer;
            }
        }
        return null;
    }

    private long getDuration(MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return -1L;
        }
        try {
            return mediaFormat.getLong("durationUs");
        } catch (Exception e2) {
            Log.e(TAG, "getDuration failed. ".concat(String.valueOf(e2)), new Object[0]);
            return -1L;
        }
    }

    private boolean initMediaCodec() {
        if (!TextUtils.isEmpty(this.mMime) && this.mFormat != null) {
            try {
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.mMime);
                this.mMediaCodec = createDecoderByType;
                createDecoderByType.configure(this.mFormat, (Surface) null, (MediaCrypto) null, 0);
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                this.mMediaCodec = null;
            }
        }
        return false;
    }

    private boolean initMediaExtractor(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mDecodeEOS = false;
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mMediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(str);
            this.mTrackCount = this.mMediaExtractor.getTrackCount();
            for (int i10 = 0; i10 < this.mTrackCount; i10++) {
                MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(i10);
                String string = trackFormat.getString(DatabaseSourceInfoStorage.COLUMN_MIME);
                if (!TextUtils.isEmpty(string) && string.startsWith("audio/")) {
                    long duration = getDuration(trackFormat);
                    if (this.mLongestDurationUs < duration) {
                        this.mLongestDurationUs = duration;
                    }
                }
            }
            int i11 = this.mTrackIndex;
            if (i11 != 0) {
                return selectTrack(i11);
            }
            for (int i12 = 0; i12 < this.mTrackCount; i12++) {
                if (selectTrack(i12)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e2) {
            Log.e(TAG, "initMediaExtractor: ", e2);
            this.mMediaExtractor = null;
            this.mFormat = null;
            this.mMime = null;
            return false;
        }
    }

    private boolean selectTrack(int i10) {
        MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(i10);
        String string = trackFormat.getString(DatabaseSourceInfoStorage.COLUMN_MIME);
        if (TextUtils.isEmpty(string) || !string.startsWith("audio/")) {
            return false;
        }
        this.mMediaExtractor.selectTrack(i10);
        this.mTrackIndex = i10;
        this.mFormat = trackFormat;
        this.mMime = string;
        return true;
    }

    public long getLongestDuration() {
        return this.mLongestDurationUs;
    }

    public MediaFormat getOutputFormat() {
        return this.mFormat;
    }

    public int getTotalRawDataSize() {
        return this.mRawDataSize;
    }

    public int getTrackCount() {
        return this.mTrackCount;
    }

    public boolean initAndStart(String str) {
        if (this.mMediaCodec != null || !initMediaExtractor(str) || !initMediaCodec()) {
            return false;
        }
        try {
            this.mMediaCodec.start();
            return true;
        } catch (IllegalStateException e2) {
            Log.e(TAG, "Cannot start the audio codec", e2);
            return false;
        }
    }

    public boolean isDecodeEnd() {
        return this.mDecodeEOS;
    }

    public ByteBuffer processFrame() {
        int dequeueInputBuffer;
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(TIMEOUT_MS)) < 0) {
            return null;
        }
        ByteBuffer byteBuffer = this.mMediaCodec.getInputBuffers()[dequeueInputBuffer];
        int readSampleData = byteBuffer != null ? this.mMediaExtractor.readSampleData(byteBuffer, 0) : -1;
        if (readSampleData <= 0) {
            this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        } else {
            this.mRawDataSize += readSampleData;
            this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.mMediaExtractor.getSampleTime(), 0);
            this.mMediaExtractor.advance();
        }
        return drainData();
    }

    public boolean seekTo(long j10) {
        MediaExtractor mediaExtractor;
        if (this.mMediaCodec == null || (mediaExtractor = this.mMediaExtractor) == null || j10 > this.mLongestDurationUs) {
            return false;
        }
        mediaExtractor.seekTo(j10, 2);
        return true;
    }

    public void setMusicTrack(int i10) {
        int i11 = this.mTrackIndex;
        if (i11 == i10) {
            return;
        }
        this.mMediaExtractor.unselectTrack(i11);
        if (selectTrack(i10)) {
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            }
            if (initMediaCodec()) {
                try {
                    this.mMediaCodec.start();
                } catch (IllegalStateException e2) {
                    Log.e(TAG, "Cannot start the audio codec", e2);
                }
            }
        }
    }

    public void stop() {
        MediaExtractor mediaExtractor = this.mMediaExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.mMediaExtractor = null;
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mMediaCodec.release();
            this.mMediaCodec = null;
        }
        this.mDecodeEOS = false;
    }
}
