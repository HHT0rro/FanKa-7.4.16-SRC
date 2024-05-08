package com.tencent.liteav.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.nio.ByteBuffer;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LiteavAudioTrack {
    private static final String TAG = "LiteavAudioTrack";
    private AudioTrack mAudioTrack;
    private byte[] mPlayBuffer;
    private int mBufferSize = 0;
    private int mSystemOSVersion = 0;

    @CalledByNative
    public LiteavAudioTrack() {
    }

    private static AudioTrack createStartedAudioTrack(int i10, int i11, int i12, int i13, boolean z10) {
        AudioTrack audioTrack;
        int i14;
        int i15;
        try {
            if (z10) {
                if (i13 == 3) {
                    i14 = 1;
                    i15 = 2;
                } else {
                    i14 = 2;
                    i15 = 1;
                }
                try {
                    audioTrack = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(i14).setContentType(i15).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(i10).setChannelMask(i11).build()).setTransferMode(1).setBufferSizeInBytes(i12).setPerformanceMode(1).build();
                } catch (Throwable unused) {
                    audioTrack = null;
                    Log.w(TAG, "create AudioTrack failed. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), streamTypeToString(i13));
                    destroyAudioTrack(audioTrack);
                    return null;
                }
                try {
                    audioTrack.setBufferSizeInFrames((((i10 * 10) * (i11 == 12 ? 2 : 1)) * 2) / 1000);
                } catch (Throwable unused2) {
                    Log.w(TAG, "create AudioTrack failed. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), streamTypeToString(i13));
                    destroyAudioTrack(audioTrack);
                    return null;
                }
            } else {
                audioTrack = new AudioTrack(i13, i10, i11, 2, i12, 1);
            }
            if (audioTrack.getState() == 1) {
                audioTrack.play();
                Log.i(TAG, "create AudioTrack success. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s, fastJava: %b", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), streamTypeToString(i13), Boolean.valueOf(z10));
                return audioTrack;
            }
            throw new RuntimeException("AudioTrack is not initialized.");
        } catch (Throwable unused3) {
        }
    }

    private static void destroyAudioTrack(AudioTrack audioTrack) {
        if (audioTrack == null) {
            return;
        }
        try {
            if (audioTrack.getPlayState() == 3) {
                audioTrack.stop();
                audioTrack.flush();
            }
            audioTrack.release();
        } catch (Exception e2) {
            Log.e(TAG, "stop AudioTrack failed.", e2);
        }
    }

    private static String streamTypeToString(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "STREAM_INVALID" : "STREAM_NOTIFICATION" : "STREAM_ALARM" : "STREAM_MUSIC" : "STREAM_RING" : "STREAM_SYSTEM" : "STREAM_VOICE_CALL";
    }

    @CalledByNative
    public int getBufferSize() {
        return this.mBufferSize;
    }

    @CalledByNative
    public int startPlayout(int i10, int i11, int i12, int i13, boolean z10) {
        int[] iArr = {i10, 0, 3, 1};
        int i14 = i12 == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(i11, i14, 2);
        if (minBufferSize <= 0) {
            Log.e(TAG, "AudioTrack.getMinBufferSize return error: ".concat(String.valueOf(minBufferSize)), new Object[0]);
            return -2;
        }
        for (int i15 = 0; i15 < 4 && this.mAudioTrack == null; i15++) {
            int i16 = iArr[i15];
            for (int i17 = 1; i17 <= 2 && this.mAudioTrack == null; i17++) {
                int i18 = minBufferSize * i17;
                this.mBufferSize = i18;
                if (i18 >= i13 * 4 || i17 >= 2) {
                    this.mAudioTrack = createStartedAudioTrack(i11, i14, i18, i16, z10);
                }
            }
        }
        if (this.mAudioTrack == null) {
            return -1;
        }
        this.mSystemOSVersion = LiteavSystemInfo.getSystemOSVersionInt();
        Process.setThreadPriority(-19);
        return 0;
    }

    @CalledByNative
    public void stopPlayout() {
        destroyAudioTrack(this.mAudioTrack);
        this.mAudioTrack = null;
    }

    @CalledByNative
    public int write(ByteBuffer byteBuffer, int i10, int i11, int i12) {
        int write;
        if (this.mAudioTrack == null) {
            return -1;
        }
        byteBuffer.position(i10);
        if (this.mSystemOSVersion >= 21) {
            write = this.mAudioTrack.write(byteBuffer, i11, i12 == 0 ? 1 : 0);
        } else {
            byte[] bArr = this.mPlayBuffer;
            if (bArr == null || bArr.length < i11) {
                this.mPlayBuffer = new byte[i11];
            }
            byteBuffer.get(this.mPlayBuffer, 0, i11);
            write = this.mAudioTrack.write(this.mPlayBuffer, 0, i11);
        }
        if (write >= 0) {
            return write;
        }
        Log.e(TAG, "write audio data to AudioTrack failed. ".concat(String.valueOf(write)), new Object[0]);
        return -1;
    }
}
