package com.zego.zegoavkit2;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.zego.zegoavkit2.entities.VideoFrame;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoMediaPlayerCallbackBridge {
    private static volatile HashMap<Integer, IZegoMediaPlayerWithIndexCallback> mEventWithIndexCallbackMap = new HashMap<>();
    private static volatile HashMap<Integer, IZegoMediaPlayerVideoPlayWithIndexCallback> mVideoDataWithIndexCallbackMap = new HashMap<>();
    private static volatile HashMap<Integer, IZegoMediaPlayerVideoPlayWithIndexCallback2> mVideoDataWithIndexCallback2Map = new HashMap<>();
    private static volatile HashMap<Integer, IZegoMediaPlayerAudioPlayCallback> mAudioDataCallbackMap = new HashMap<>();
    private static volatile HashMap<Integer, IZegoMediaPlayerMediaSideInfoCallback> mMediaSideInfoCallbackMap = new HashMap<>();
    private static volatile HashMap<Integer, ZegoMediaPlayerFileReader> mVideoMediaPlayerFileReaderMap = new HashMap<>();
    private static volatile HashMap<Integer, IZegoMediaPlayerBlockDataCallback> mBlockDataCallbackMap = new HashMap<>();
    private static volatile HashMap<Integer, ByteBuffer> mVideoBuffers = new HashMap<>();

    public static void close(int i10) {
        ZegoMediaPlayerFileReader zegoMediaPlayerFileReader = mVideoMediaPlayerFileReaderMap.get(Integer.valueOf(i10));
        if (zegoMediaPlayerFileReader != null) {
            zegoMediaPlayerFileReader.close(i10);
        }
    }

    public static int dequeueInputBuffer(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        IZegoMediaPlayerVideoPlayWithIndexCallback2 iZegoMediaPlayerVideoPlayWithIndexCallback2 = mVideoDataWithIndexCallback2Map.get(Integer.valueOf(i12));
        if (iZegoMediaPlayerVideoPlayWithIndexCallback2 != null) {
            return iZegoMediaPlayerVideoPlayWithIndexCallback2.dequeueInputBuffer(i10, i11, iArr, iArr2, i12);
        }
        return -1;
    }

    public static VideoFrame getInputBuffer(int i10, int i11) {
        IZegoMediaPlayerVideoPlayWithIndexCallback2 iZegoMediaPlayerVideoPlayWithIndexCallback2 = mVideoDataWithIndexCallback2Map.get(Integer.valueOf(i11));
        if (iZegoMediaPlayerVideoPlayWithIndexCallback2 != null) {
            return iZegoMediaPlayerVideoPlayWithIndexCallback2.getInputBuffer(i10, i11);
        }
        return null;
    }

    public static long getSize(int i10) {
        ZegoMediaPlayerFileReader zegoMediaPlayerFileReader = mVideoMediaPlayerFileReaderMap.get(Integer.valueOf(i10));
        if (zegoMediaPlayerFileReader != null) {
            return zegoMediaPlayerFileReader.getSize(i10);
        }
        return 0L;
    }

    public static void onAudioBegin(final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.7
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onAudioBegin(i10);
                }
            }
        });
    }

    public static void onAudioDataCallback(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13) {
        IZegoMediaPlayerAudioPlayCallback iZegoMediaPlayerAudioPlayCallback = mAudioDataCallbackMap.get(Integer.valueOf(i13));
        if (iZegoMediaPlayerAudioPlayCallback != null) {
            iZegoMediaPlayerAudioPlayCallback.onPlayAudioData(byteBuffer, i10, i11, i12, i13);
        }
    }

    public static void onBlockBegin(String str, int i10) {
        IZegoMediaPlayerBlockDataCallback iZegoMediaPlayerBlockDataCallback = mBlockDataCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerBlockDataCallback != null) {
            iZegoMediaPlayerBlockDataCallback.OnBlockBegin(str, i10);
        }
    }

    public static int onBlockData(ByteBuffer byteBuffer, int i10) {
        IZegoMediaPlayerBlockDataCallback iZegoMediaPlayerBlockDataCallback = mBlockDataCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerBlockDataCallback != null) {
            return iZegoMediaPlayerBlockDataCallback.OnBlockData(byteBuffer, i10);
        }
        return -1;
    }

    public static void onBufferBegin(final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.9
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onBufferBegin(i10);
                }
            }
        });
    }

    public static void onBufferEnd(final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.10
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onBufferEnd(i10);
                }
            }
        });
    }

    public static void onLoadComplete(final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.11
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onLoadComplete(i10);
                }
            }
        });
    }

    public static void onMediaPlayerVideoSizeChanged(final int i10, final int i11, final int i12) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i12));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.15
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onMediaPlayerVideoSizeChanged(i10, i11, i12);
                }
            }
        });
    }

    public static void onMediaSideInfoCallback(ByteBuffer byteBuffer, int i10) {
        IZegoMediaPlayerMediaSideInfoCallback iZegoMediaPlayerMediaSideInfoCallback = mMediaSideInfoCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerMediaSideInfoCallback != null) {
            iZegoMediaPlayerMediaSideInfoCallback.onMediaSideInfo(byteBuffer, i10);
        }
    }

    public static void onPlayEnd(final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.8
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayEnd(i10);
                }
            }
        });
    }

    public static void onPlayError(final int i10, final int i11) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i11));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.5
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayError(i10, i11);
                }
            }
        });
    }

    public static void onPlayPause(final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.2
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayPause(i10);
                }
            }
        });
    }

    public static void onPlayResume(final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.4
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayResume(i10);
                }
            }
        });
    }

    public static void onPlayStart(final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.1
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayStart(i10);
                }
            }
        });
    }

    public static void onPlayStop(final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.3
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onPlayStop(i10);
                }
            }
        });
    }

    public static void onPlayVideoData(ByteBuffer byteBuffer, int i10, ZegoVideoDataFormat zegoVideoDataFormat, int i11) {
        IZegoMediaPlayerVideoPlayWithIndexCallback iZegoMediaPlayerVideoPlayWithIndexCallback = mVideoDataWithIndexCallbackMap.get(Integer.valueOf(i11));
        if (iZegoMediaPlayerVideoPlayWithIndexCallback != null) {
            ByteBuffer byteBuffer2 = mVideoBuffers.containsKey(Integer.valueOf(i11)) ? mVideoBuffers.get(Integer.valueOf(i11)) : null;
            if (byteBuffer2 == null || byteBuffer2.capacity() < i10) {
                byteBuffer2 = ByteBuffer.allocateDirect(i10);
                mVideoBuffers.put(Integer.valueOf(i11), byteBuffer2);
            }
            byteBuffer2.clear();
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            iZegoMediaPlayerVideoPlayWithIndexCallback.onPlayVideoData(byteBuffer2.array(), i10, zegoVideoDataFormat, i11);
        }
    }

    public static void onProcessInterval(long j10, int i10) {
        IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        iZegoMediaPlayerWithIndexCallback.onProcessInterval(j10, i10);
    }

    public static void onReadEOF(final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.14
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onReadEOF(i10);
                }
            }
        });
    }

    public static void onRenderingProcessInterval(long j10, int i10) {
        IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        iZegoMediaPlayerWithIndexCallback.onRenderingProcessInterval(j10, i10);
    }

    public static void onSeekComplete(final int i10, final long j10, final int i11) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i11));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.12
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onSeekComplete(i10, j10, i11);
                }
            }
        });
    }

    public static void onSnapshot(Bitmap bitmap, final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        final Bitmap copy = bitmap != null ? bitmap.copy(bitmap.getConfig(), true) : null;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.13
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onSnapshot(copy, i10);
                }
            }
        });
    }

    public static void onVideoBegin(final int i10) {
        final IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback = mEventWithIndexCallbackMap.get(Integer.valueOf(i10));
        if (iZegoMediaPlayerWithIndexCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.ZegoMediaPlayerCallbackBridge.6
            @Override // java.lang.Runnable
            public void run() {
                IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback2 = IZegoMediaPlayerWithIndexCallback.this;
                if (iZegoMediaPlayerWithIndexCallback2 != null) {
                    iZegoMediaPlayerWithIndexCallback2.onVideoBegin(i10);
                }
            }
        });
    }

    public static int open(String str, int i10) {
        ZegoMediaPlayerFileReader zegoMediaPlayerFileReader = mVideoMediaPlayerFileReaderMap.get(Integer.valueOf(i10));
        if (zegoMediaPlayerFileReader != null) {
            return zegoMediaPlayerFileReader.open(str, i10);
        }
        return -1;
    }

    public static void queueInputBuffer(int i10, ZegoVideoDataFormat zegoVideoDataFormat, int i11) {
        IZegoMediaPlayerVideoPlayWithIndexCallback2 iZegoMediaPlayerVideoPlayWithIndexCallback2 = mVideoDataWithIndexCallback2Map.get(Integer.valueOf(i11));
        if (iZegoMediaPlayerVideoPlayWithIndexCallback2 != null) {
            iZegoMediaPlayerVideoPlayWithIndexCallback2.queueInputBuffer(i10, zegoVideoDataFormat, i11);
        }
    }

    public static ByteBuffer read(int i10, int i11) {
        ZegoMediaPlayerFileReader zegoMediaPlayerFileReader = mVideoMediaPlayerFileReaderMap.get(Integer.valueOf(i11));
        if (zegoMediaPlayerFileReader != null) {
            return zegoMediaPlayerFileReader.read(i10, i11);
        }
        return null;
    }

    public static void removeVideoDataBuffer(int i10) {
        if (mVideoBuffers.containsKey(Integer.valueOf(i10))) {
            mVideoBuffers.remove(Integer.valueOf(i10));
        }
    }

    public static long seek(long j10, int i10, int i11) {
        ZegoMediaPlayerFileReader zegoMediaPlayerFileReader = mVideoMediaPlayerFileReaderMap.get(Integer.valueOf(i11));
        if (zegoMediaPlayerFileReader != null) {
            return zegoMediaPlayerFileReader.seek(j10, i10, i11);
        }
        return -1L;
    }

    public static void setAudioDataCallback(IZegoMediaPlayerAudioPlayCallback iZegoMediaPlayerAudioPlayCallback, int i10) {
        mAudioDataCallbackMap.put(Integer.valueOf(i10), iZegoMediaPlayerAudioPlayCallback);
    }

    public static void setBlockDataCallback(IZegoMediaPlayerBlockDataCallback iZegoMediaPlayerBlockDataCallback, int i10) {
        mBlockDataCallbackMap.put(Integer.valueOf(i10), iZegoMediaPlayerBlockDataCallback);
    }

    public static void setEventWithIndexCallback(IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback, int i10) {
        mEventWithIndexCallbackMap.put(Integer.valueOf(i10), iZegoMediaPlayerWithIndexCallback);
    }

    public static void setMediaPlayerFileReader(ZegoMediaPlayerFileReader zegoMediaPlayerFileReader, int i10) {
        mVideoMediaPlayerFileReaderMap.put(Integer.valueOf(i10), zegoMediaPlayerFileReader);
    }

    public static void setMediaSideInfoCallback(IZegoMediaPlayerMediaSideInfoCallback iZegoMediaPlayerMediaSideInfoCallback, int i10) {
        mMediaSideInfoCallbackMap.put(Integer.valueOf(i10), iZegoMediaPlayerMediaSideInfoCallback);
    }

    public static void setVideoDataWithIndexCallback(IZegoMediaPlayerVideoPlayWithIndexCallback iZegoMediaPlayerVideoPlayWithIndexCallback, int i10) {
        mVideoDataWithIndexCallbackMap.put(Integer.valueOf(i10), iZegoMediaPlayerVideoPlayWithIndexCallback);
    }

    public static void setVideoDataWithIndexCallback2(IZegoMediaPlayerVideoPlayWithIndexCallback2 iZegoMediaPlayerVideoPlayWithIndexCallback2, int i10) {
        mVideoDataWithIndexCallback2Map.put(Integer.valueOf(i10), iZegoMediaPlayerVideoPlayWithIndexCallback2);
    }
}
