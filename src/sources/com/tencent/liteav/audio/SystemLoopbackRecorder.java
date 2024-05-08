package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.os.Process;
import com.android.internal.os.PowerProfile;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SystemLoopbackRecorder {
    private static final String TAG = "SystemLoopbackRecorder";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f42602a = 0;
    private static final Object mLock = new Object();
    private static final List<SystemLoopbackRecorder> sListeners = new LinkedList();
    private volatile long mNativeSystemLoopbackRecorder;

    @CalledByNative
    public SystemLoopbackRecorder(long j10) {
        this.mNativeSystemLoopbackRecorder = j10;
    }

    private static native void nativeSetMediaProjectionSession(long j10, MediaProjection mediaProjection);

    public static void notifyMediaProjectionState(MediaProjection mediaProjection) {
        StringBuilder sb2 = new StringBuilder("Received MediaProjection state ");
        sb2.append(mediaProjection != null);
        Log.i(TAG, sb2.toString(), new Object[0]);
        synchronized (mLock) {
            Iterator<SystemLoopbackRecorder> iterator2 = sListeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().setMediaProjectionSession(mediaProjection);
            }
        }
    }

    @CalledByNative
    public void registerMediaProjectionListener() {
        synchronized (mLock) {
            sListeners.add(this);
        }
    }

    public void setMediaProjectionSession(MediaProjection mediaProjection) {
        if (this.mNativeSystemLoopbackRecorder != 0) {
            nativeSetMediaProjectionSession(this.mNativeSystemLoopbackRecorder, mediaProjection);
        }
    }

    @CalledByNative
    public void unregisterMediaProjectionListener() {
        synchronized (mLock) {
            sListeners.remove(this);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Recorder {

        /* renamed from: a, reason: collision with root package name */
        private AudioRecord f42603a;

        /* renamed from: b, reason: collision with root package name */
        private AudioManager f42604b;

        @CalledByNative("Recorder")
        public Recorder() {
            Context applicationContext = ContextUtils.getApplicationContext();
            ContextUtils.getApplicationContext();
            this.f42604b = (AudioManager) applicationContext.getSystemService(PowerProfile.POWER_AUDIO);
        }

        private static AudioRecord a(MediaProjection mediaProjection, int i10, int i11, int i12) {
            AudioPlaybackCaptureConfiguration.Builder builder = new AudioPlaybackCaptureConfiguration.Builder(mediaProjection);
            builder.addMatchingUsage(1);
            builder.addMatchingUsage(14);
            AudioPlaybackCaptureConfiguration build = builder.build();
            if (build == null) {
                return null;
            }
            int i13 = i11 == 1 ? 16 : 12;
            AudioFormat build2 = new AudioFormat.Builder().setEncoding(2).setSampleRate(i10).setChannelMask(i13).build();
            int minBufferSize = AudioRecord.getMinBufferSize(i10, i13, 2);
            AudioRecord audioRecord = null;
            for (int i14 = 1; i14 <= 2 && audioRecord == null; i14++) {
                int i15 = minBufferSize * i14;
                if (i15 >= i12 * 4 || i14 >= 2) {
                    try {
                        audioRecord = new AudioRecord.Builder().setAudioFormat(build2).setBufferSizeInBytes(i15).setAudioPlaybackCaptureConfig(build).build();
                    } catch (Throwable th) {
                        Log.w(SystemLoopbackRecorder.TAG, "Create record error " + th.getMessage(), new Object[0]);
                        a(audioRecord);
                    }
                    if (audioRecord.getState() != 1) {
                        Log.e(SystemLoopbackRecorder.TAG, "Audio record state error", new Object[0]);
                        a(audioRecord);
                        audioRecord = null;
                    } else {
                        audioRecord.startRecording();
                        Log.i(SystemLoopbackRecorder.TAG, "Create audio record success", new Object[0]);
                    }
                }
            }
            return audioRecord;
        }

        @CalledByNative("Recorder")
        public int read(ByteBuffer byteBuffer, int i10) {
            if (this.f42603a == null) {
                return -1;
            }
            byteBuffer.position(0);
            int read = this.f42603a.read(byteBuffer, i10);
            if (read > 0) {
                return read;
            }
            Log.e(SystemLoopbackRecorder.TAG, "Read failed ".concat(String.valueOf(read)), new Object[0]);
            return -1;
        }

        @CalledByNative("Recorder")
        public int startRecording(MediaProjection mediaProjection, int i10, int i11, int i12) {
            try {
                AudioManager audioManager = this.f42604b;
                if (audioManager != null) {
                    audioManager.setAllowedCapturePolicy(3);
                }
            } catch (Throwable th) {
                Log.e(SystemLoopbackRecorder.TAG, "ForbidCaptureAudioFromCurrentApp error " + th.getMessage(), new Object[0]);
            }
            AudioManager audioManager2 = this.f42604b;
            int mode = audioManager2 != null ? audioManager2.getMode() : 0;
            a(0);
            this.f42603a = a(mediaProjection, i10, i11, i12);
            a(mode);
            if (this.f42603a == null) {
                return -1;
            }
            Process.setThreadPriority(-19);
            return 0;
        }

        @CalledByNative("Recorder")
        public void stopRecording() {
            a(this.f42603a);
            this.f42603a = null;
        }

        private static void a(AudioRecord audioRecord) {
            if (audioRecord == null) {
                return;
            }
            try {
                if (audioRecord.getRecordingState() == 3) {
                    audioRecord.stop();
                }
                audioRecord.release();
            } catch (Throwable th) {
                Log.e(SystemLoopbackRecorder.TAG, "Destroy AudioRecord failed." + th.getMessage(), new Object[0]);
            }
        }

        private void a(int i10) {
            try {
                AudioManager audioManager = this.f42604b;
                if (audioManager != null) {
                    audioManager.setMode(i10);
                }
            } catch (Throwable th) {
                Log.e(SystemLoopbackRecorder.TAG, "Set audio mode exception " + th.getMessage(), new Object[0]);
            }
        }
    }
}
