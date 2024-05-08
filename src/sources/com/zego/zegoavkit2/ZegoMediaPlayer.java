package com.zego.zegoavkit2;

import android.net.Uri;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoMediaPlayer {
    public static final int PlayerTypeAux = 1;
    public static final int PlayerTypePlayer = 0;
    private int mPlayerIndex;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AudioChannel {
        public static final int All = 3;
        public static final int Left = 1;
        public static final int Right = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AudioTrackMode {
        public static final int Multiple = 1;
        public static final int Normal = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class CacheStat {
        public int time = 0;
        public int size = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ErrorCode {
        public static final int ErrorCodec = -3;
        public static final int ErrorDemux = -5;
        public static final int ErrorFile = -1;
        public static final int ErrorPath = -2;
        public static final int Expired = -8;
        public static final int FrameDrop = -6;
        public static final int LoadTimeout = -7;
        public static final int NoSupportStream = -4;
        public static final int OK = 0;
        public static final int ResourceIDExpired = -9;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class PlayerIndex {
        public static final int First = 0;
        public static final int Fourth = 3;
        public static final int Second = 1;
        public static final int Third = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class PlayerViewMode {
        public static final int ScaleAspectFill = 1;
        public static final int ScaleAspectFit = 0;
        public static final int ScaleToFill = 2;
    }

    private native void clearViewNative(int i10);

    private native void enableAccurateSeekNative(boolean z10, int i10);

    private native void enableAudioPlayCallbackNative(boolean z10, int i10);

    private native void enableBlockDataCallbackNative(boolean z10, int i10, int i11);

    private native void enableEventCallbackNative(boolean z10, int i10);

    private native void enableMediaSideInfoCallbackNative(boolean z10, int i10);

    private native void enableRepeatModeNative(boolean z10, int i10);

    private native void enableVideoPlayCallbackNative(boolean z10, int i10, int i11);

    private native void enableZegoMediaPlayerFileReaderNative(boolean z10, int i10);

    private native long getAudioStreamCountNative(int i10);

    private native long getCurrentDurationNative(int i10);

    private native long getCurrentRenderingDurationNative(int i10);

    private native long getDurationNative(int i10);

    private native String getMetaDataValueNative(String str, int i10);

    private native boolean getOnlineResourceCacheStatNative(CacheStat cacheStat, int i10);

    private native int getPlayVolumeNative(int i10);

    private native int getPublishVolumeNative(int i10);

    private native void initNative(int i10, int i11);

    private native void loadCopyrightedMusicNative(String str, long j10, int i10);

    private native void loadNative(String str, long j10, int i10);

    private native void loadNative2(ByteBuffer byteBuffer, int i10, long j10, int i11);

    private native void muteLocalNative(boolean z10, int i10);

    private native void pauseNative(int i10);

    private native boolean requireHWDecoderNative(int i10);

    private native void resumeNative(int i10);

    private native void seekToNative(long j10, int i10);

    private native void setAccurateSeekTimeoutNative(long j10, int i10);

    private native void setActiveAudioChannelNative(int i10, int i11);

    private native void setAudioChannelKeyShiftNative(int i10, float f10, int i11);

    private native void setAudioPublishStreamNative(long j10, int i10);

    private native long setAudioStreamNative(long j10, int i10);

    private native void setAudioTrackModeNative(int i10, int i11);

    private native void setBackgroundColorNative(int i10, int i11);

    private native void setBufferThresholdNative(int i10, int i11);

    private native void setHttpHeadersNative(Map<String, String> map, int i10);

    private native void setLoadResourceTimeoutNative(int i10, int i11);

    private native void setLoopCountNative(int i10, int i11);

    private native void setOnlineResourceCacheNative(int i10, int i11, int i12);

    private native void setPlayMediaStreamTypeNative(int i10, int i11);

    private native void setPlaySpeedNative(float f10, int i10);

    private native void setPlayVolumeNative(int i10, int i11);

    private native void setPlayerTypeNative(int i10, int i11);

    private native boolean setProcessIntervalNative(long j10, int i10);

    private native void setPublishVolumeNative(int i10, int i11);

    private native void setViewModeNative(int i10, int i11);

    private native void setViewNative(Object obj, int i10);

    private native void setVolumeNative(int i10, int i11);

    private native void startCopyrightedMusicNative(String str, long j10, int i10);

    private native void startNative(String str, boolean z10, long j10, int i10);

    private native void startNative2(String str, long j10, int i10);

    private native void startNative3(ByteBuffer byteBuffer, int i10, long j10, int i11);

    private native void stopNative(int i10);

    private native void takeSnapshotNative(int i10);

    private native void uninitNative(int i10);

    private native void updatePositionNative(float[] fArr, int i10);

    public void clearView() {
        clearViewNative(this.mPlayerIndex);
    }

    public void enableAccurateSeek(boolean z10) {
        enableAccurateSeekNative(z10, this.mPlayerIndex);
    }

    @Deprecated
    public void enableRepeatMode(boolean z10) {
        enableRepeatModeNative(z10, this.mPlayerIndex);
    }

    public long getAudioStreamCount() {
        return getAudioStreamCountNative(this.mPlayerIndex);
    }

    public long getCurrentDuration() {
        return getCurrentDurationNative(this.mPlayerIndex);
    }

    public long getCurrentRenderingDuration() {
        return getCurrentRenderingDurationNative(this.mPlayerIndex);
    }

    public long getDuration() {
        return getDurationNative(this.mPlayerIndex);
    }

    public String getMetaDataValue(String str) {
        return getMetaDataValueNative(str, this.mPlayerIndex);
    }

    public boolean getOnlineResourceCacheStat(CacheStat cacheStat) {
        return getOnlineResourceCacheStatNative(cacheStat, this.mPlayerIndex);
    }

    public int getPlayVolume() {
        return getPlayVolumeNative(this.mPlayerIndex);
    }

    public int getPublishVolume() {
        return getPublishVolumeNative(this.mPlayerIndex);
    }

    @Deprecated
    public void init(int i10) {
        this.mPlayerIndex = 0;
        init(i10, 0);
    }

    public void load(String str) {
        load(str, 0L);
    }

    public void loadCopyrightedMusic(String str, long j10) {
        loadCopyrightedMusicNative(str, j10, this.mPlayerIndex);
    }

    public void muteLocal(boolean z10) {
        muteLocalNative(z10, this.mPlayerIndex);
    }

    public void pause() {
        pauseNative(this.mPlayerIndex);
    }

    public boolean requireHWDecoder() {
        return requireHWDecoderNative(this.mPlayerIndex);
    }

    public void resume() {
        resumeNative(this.mPlayerIndex);
    }

    public void seekTo(long j10) {
        seekToNative(j10, this.mPlayerIndex);
    }

    public void setAccurateSeekTimeout(long j10) {
        setAccurateSeekTimeoutNative(j10, this.mPlayerIndex);
    }

    public void setActiveAudioChannel(int i10) {
        setActiveAudioChannelNative(i10, this.mPlayerIndex);
    }

    public void setAudioChannelKeyShift(int i10, float f10) {
        setAudioChannelKeyShiftNative(i10, f10, this.mPlayerIndex);
    }

    public void setAudioPlayCallback(IZegoMediaPlayerAudioPlayCallback iZegoMediaPlayerAudioPlayCallback) {
        ZegoMediaPlayerCallbackBridge.setAudioDataCallback(iZegoMediaPlayerAudioPlayCallback, this.mPlayerIndex);
        enableAudioPlayCallbackNative(iZegoMediaPlayerAudioPlayCallback != null, this.mPlayerIndex);
    }

    public void setAudioPublishStream(long j10) {
        setAudioPublishStreamNative(j10, this.mPlayerIndex);
    }

    public long setAudioStream(long j10) {
        return setAudioStreamNative(j10, this.mPlayerIndex);
    }

    public void setAudioTrackMode(int i10) {
        setAudioTrackModeNative(i10, this.mPlayerIndex);
    }

    public void setBackgroundColor(int i10) {
        setBackgroundColorNative(i10, this.mPlayerIndex);
    }

    public void setBlockDataCallback(IZegoMediaPlayerBlockDataCallback iZegoMediaPlayerBlockDataCallback, int i10) {
        ZegoMediaPlayerCallbackBridge.setBlockDataCallback(iZegoMediaPlayerBlockDataCallback, this.mPlayerIndex);
        enableBlockDataCallbackNative(iZegoMediaPlayerBlockDataCallback != null, i10, this.mPlayerIndex);
    }

    public void setBufferThreshold(int i10) {
        setBufferThresholdNative(i10, this.mPlayerIndex);
    }

    public void setEventWithIndexCallback(IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback) {
        ZegoMediaPlayerCallbackBridge.setEventWithIndexCallback(iZegoMediaPlayerWithIndexCallback, this.mPlayerIndex);
        enableEventCallbackNative(iZegoMediaPlayerWithIndexCallback != null, this.mPlayerIndex);
    }

    public void setHttpHeaders(Map<String, String> map) {
        setHttpHeadersNative(map, this.mPlayerIndex);
    }

    public void setLoadResourceTimeout(int i10) {
        setLoadResourceTimeoutNative(i10, this.mPlayerIndex);
    }

    public void setLoopCount(int i10) {
        setLoopCountNative(i10, this.mPlayerIndex);
    }

    public void setMediaPlayerFileReader(ZegoMediaPlayerFileReader zegoMediaPlayerFileReader) {
        ZegoMediaPlayerCallbackBridge.setMediaPlayerFileReader(zegoMediaPlayerFileReader, this.mPlayerIndex);
        enableZegoMediaPlayerFileReaderNative(zegoMediaPlayerFileReader != null, this.mPlayerIndex);
    }

    public void setMediaSideInfoCallback(IZegoMediaPlayerMediaSideInfoCallback iZegoMediaPlayerMediaSideInfoCallback) {
        ZegoMediaPlayerCallbackBridge.setMediaSideInfoCallback(iZegoMediaPlayerMediaSideInfoCallback, this.mPlayerIndex);
        enableMediaSideInfoCallbackNative(iZegoMediaPlayerMediaSideInfoCallback != null, this.mPlayerIndex);
    }

    public void setOnlineResourceCache(int i10, int i11) {
        setOnlineResourceCacheNative(i10, i11, this.mPlayerIndex);
    }

    public void setPlayMediaStreamType(int i10) {
        setPlayMediaStreamTypeNative(i10, this.mPlayerIndex);
    }

    public void setPlaySpeed(float f10) {
        setPlaySpeedNative(f10, this.mPlayerIndex);
    }

    public void setPlayVolume(int i10) {
        setPlayVolumeNative(i10, this.mPlayerIndex);
    }

    public void setPlayerType(int i10) {
        setPlayerTypeNative(i10, this.mPlayerIndex);
    }

    public boolean setProcessInterval(long j10) {
        return setProcessIntervalNative(j10, this.mPlayerIndex);
    }

    public void setPublishVolume(int i10) {
        setPublishVolumeNative(i10, this.mPlayerIndex);
    }

    public void setVideoPlayWithIndexCallback(IZegoMediaPlayerVideoPlayWithIndexCallback iZegoMediaPlayerVideoPlayWithIndexCallback, int i10) {
        ZegoMediaPlayerCallbackBridge.setVideoDataWithIndexCallback(iZegoMediaPlayerVideoPlayWithIndexCallback, this.mPlayerIndex);
        enableVideoPlayCallbackNative(iZegoMediaPlayerVideoPlayWithIndexCallback != null, i10, this.mPlayerIndex);
    }

    public void setVideoPlayWithIndexCallback2(IZegoMediaPlayerVideoPlayWithIndexCallback2 iZegoMediaPlayerVideoPlayWithIndexCallback2, int i10) {
        ZegoMediaPlayerCallbackBridge.setVideoDataWithIndexCallback2(iZegoMediaPlayerVideoPlayWithIndexCallback2, this.mPlayerIndex);
        enableVideoPlayCallbackNative(iZegoMediaPlayerVideoPlayWithIndexCallback2 != null, i10, this.mPlayerIndex);
    }

    public void setView(Object obj) {
        setViewNative(obj, this.mPlayerIndex);
    }

    public void setViewMode(int i10) {
        setViewModeNative(i10, this.mPlayerIndex);
    }

    public void setVolume(int i10) {
        setVolumeNative(i10, this.mPlayerIndex);
    }

    @Deprecated
    public void start(String str, boolean z10) {
        start(str, z10, 0L);
    }

    public void startCopyrightedMusic(String str, long j10) {
        startCopyrightedMusicNative(str, j10, this.mPlayerIndex);
    }

    public void stop() {
        stopNative(this.mPlayerIndex);
    }

    public void takeSnapshot() {
        takeSnapshotNative(this.mPlayerIndex);
    }

    public void uninit() {
        setEventWithIndexCallback(null);
        setMediaPlayerFileReader(null);
        setVideoPlayWithIndexCallback(null, 0);
        setVideoPlayWithIndexCallback2(null, 0);
        setAudioPlayCallback(null);
        ZegoMediaPlayerCallbackBridge.removeVideoDataBuffer(this.mPlayerIndex);
        uninitNative(this.mPlayerIndex);
    }

    public void updatePosition(float[] fArr) {
        updatePositionNative(fArr, this.mPlayerIndex);
    }

    public void load(Uri uri) {
        load(uri, 0L);
    }

    @Deprecated
    public void start(String str, boolean z10, long j10) {
        startNative(str, z10, j10, this.mPlayerIndex);
    }

    public void init(int i10, int i11) {
        this.mPlayerIndex = i11;
        initNative(i10, i11);
    }

    public void load(String str, long j10) {
        loadNative(str, j10, this.mPlayerIndex);
    }

    public void start(String str, long j10) {
        startNative2(str, j10, this.mPlayerIndex);
    }

    public void load(Uri uri, long j10) {
        loadNative(uri != null ? uri.toString() : "", j10, this.mPlayerIndex);
    }

    public void start(Uri uri, long j10) {
        startNative2(uri != null ? uri.toString() : "", j10, this.mPlayerIndex);
    }

    public void load(ByteBuffer byteBuffer, long j10) {
        if (byteBuffer == null) {
            return;
        }
        loadNative2(byteBuffer, byteBuffer.limit(), j10, this.mPlayerIndex);
    }

    public void start(ByteBuffer byteBuffer, long j10) {
        if (byteBuffer == null) {
            return;
        }
        startNative3(byteBuffer, byteBuffer.limit(), j10, this.mPlayerIndex);
    }
}
