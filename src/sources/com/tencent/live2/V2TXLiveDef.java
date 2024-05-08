package com.tencent.live2;

import com.tencent.live2.impl.V2TXLiveUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLContext;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class V2TXLiveDef {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLiveAudioFrameObserverFormat {
        public int sampleRate = 0;
        public int channel = 0;
        public int samplesPerCall = 0;
        public V2TXLiveAudioFrameOperationMode mode = V2TXLiveAudioFrameOperationMode.V2TXLiveAudioFrameOperationModeReadOnly;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLiveAudioFrameOperationMode {
        V2TXLiveAudioFrameOperationModeReadWrite,
        V2TXLiveAudioFrameOperationModeReadOnly
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLiveAudioQuality {
        V2TXLiveAudioQualitySpeech,
        V2TXLiveAudioQualityDefault,
        V2TXLiveAudioQualityMusic
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLiveBufferType {
        V2TXLiveBufferTypeUnknown,
        V2TXLiveBufferTypeByteBuffer,
        V2TXLiveBufferTypeByteArray,
        V2TXLiveBufferTypeTexture
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLiveFillMode {
        V2TXLiveFillModeFill,
        V2TXLiveFillModeFit,
        V2TXLiveFillModeScaleFill
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLiveLocalRecordingParams {
        public String filePath;
        public V2TXLiveRecordMode recordMode = V2TXLiveRecordMode.V2TXLiveRecordModeBoth;
        public int interval = -1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLiveLogConfig {
        public String logPath;
        public int logLevel = 0;
        public boolean enableObserver = false;
        public boolean enableConsole = false;
        public boolean enableLogFile = true;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLiveLogLevel {
        public static final int V2TXLiveLogLevelAll = 0;
        public static final int V2TXLiveLogLevelDebug = 1;
        public static final int V2TXLiveLogLevelError = 4;
        public static final int V2TXLiveLogLevelFatal = 5;
        public static final int V2TXLiveLogLevelInfo = 2;
        public static final int V2TXLiveLogLevelNULL = 6;
        public static final int V2TXLiveLogLevelWarning = 3;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLiveMirrorType {
        V2TXLiveMirrorTypeAuto,
        V2TXLiveMirrorTypeEnable,
        V2TXLiveMirrorTypeDisable
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLiveMixInputType {
        V2TXLiveMixInputTypeAudioVideo,
        V2TXLiveMixInputTypePureVideo,
        V2TXLiveMixInputTypePureAudio
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLiveMode {
        TXLiveMode_RTMP,
        TXLiveMode_RTC
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLivePixelFormat {
        V2TXLivePixelFormatUnknown,
        V2TXLivePixelFormatI420,
        V2TXLivePixelFormatTexture2D
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLivePlayerStatistics {
        public int appCpu;
        public int audioBitrate;
        public int audioBlockRate;
        public int audioPacketLoss;
        public int audioTotalBlockTime;
        public int fps;
        public int height;
        public int jitterBufferDelay;
        public int rtt;
        public int systemCpu;
        public int videoBitrate;
        public int videoBlockRate;
        public int videoPacketLoss;
        public int videoTotalBlockTime;
        public int width;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLivePushStatus {
        V2TXLivePushStatusDisconnected,
        V2TXLivePushStatusConnecting,
        V2TXLivePushStatusConnectSuccess,
        V2TXLivePushStatusReconnecting
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLivePusherStatistics {
        public int appCpu;
        public int audioBitrate;
        public int fps;
        public int height;
        public int rtt;
        public int systemCpu;
        public int videoBitrate;
        public int width;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLiveRecordMode {
        V2TXLiveRecordModeBoth
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLiveRotation {
        V2TXLiveRotation0,
        V2TXLiveRotation90,
        V2TXLiveRotation180,
        V2TXLiveRotation270
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLiveSocks5ProxyConfig {
        public boolean supportHttps = true;
        public boolean supportTcp = true;
        public boolean supportUdp = true;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLiveStreamInfo {
        public int height;
        public String url;
        public int width;

        public V2TXLiveStreamInfo(int i10, int i11, String str) {
            this.width = i10;
            this.height = i11;
            this.url = str;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLiveTexture {
        public EGLContext eglContext10;
        public android.opengl.EGLContext eglContext14;
        public int textureId;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLiveVideoEncoderParam {
        public int minVideoBitrate;
        public int videoBitrate;
        public V2TXLiveVideoResolution videoResolution;
        public V2TXLiveVideoResolutionMode videoResolutionMode = V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait;
        public int videoFps = 15;

        public V2TXLiveVideoEncoderParam(V2TXLiveVideoResolution v2TXLiveVideoResolution) {
            this.videoResolution = v2TXLiveVideoResolution;
            V2TXLiveUtils.a bitrateByResolution = V2TXLiveUtils.getBitrateByResolution(v2TXLiveVideoResolution);
            this.videoBitrate = bitrateByResolution.f45082b;
            this.minVideoBitrate = bitrateByResolution.f45081a;
        }

        public final String toString() {
            return "V2TXLiveVideoEncoderParam{videoResolution=" + ((Object) this.videoResolution) + ", videoResolutionMode=" + ((Object) this.videoResolutionMode) + ", videoFps=" + this.videoFps + ", videoBitrate=" + this.videoBitrate + ", minVideoBitrate=" + this.minVideoBitrate + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLiveVideoFrame {
        public ByteBuffer buffer;
        public byte[] data;
        public int height;
        public int rotation;
        public V2TXLiveTexture texture;
        public int width;
        public V2TXLivePixelFormat pixelFormat = V2TXLivePixelFormat.V2TXLivePixelFormatUnknown;
        public V2TXLiveBufferType bufferType = V2TXLiveBufferType.V2TXLiveBufferTypeUnknown;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLiveVideoResolution {
        V2TXLiveVideoResolution160x160,
        V2TXLiveVideoResolution270x270,
        V2TXLiveVideoResolution480x480,
        V2TXLiveVideoResolution320x240,
        V2TXLiveVideoResolution480x360,
        V2TXLiveVideoResolution640x480,
        V2TXLiveVideoResolution320x180,
        V2TXLiveVideoResolution480x270,
        V2TXLiveVideoResolution640x360,
        V2TXLiveVideoResolution960x540,
        V2TXLiveVideoResolution1280x720,
        V2TXLiveVideoResolution1920x1080
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum V2TXLiveVideoResolutionMode {
        V2TXLiveVideoResolutionModeLandscape,
        V2TXLiveVideoResolutionModePortrait
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLiveAudioFrame {
        public int channel;
        public byte[] data;
        public int sampleRate;
        public long timestamp;

        public V2TXLiveAudioFrame() {
            this.data = null;
            this.sampleRate = 48000;
            this.channel = 1;
            this.timestamp = 0L;
        }

        public final String toString() {
            return "[data='" + ((Object) this.data) + "'][sampleRate='" + this.sampleRate + "'][channel=" + this.channel + "][timestamp=" + this.timestamp + "]";
        }

        public V2TXLiveAudioFrame(V2TXLiveAudioFrame v2TXLiveAudioFrame) {
            this.data = v2TXLiveAudioFrame.data;
            this.sampleRate = v2TXLiveAudioFrame.sampleRate;
            this.channel = v2TXLiveAudioFrame.channel;
            this.timestamp = v2TXLiveAudioFrame.timestamp;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class V2TXLiveMixStream {
        public int height;
        public V2TXLiveMixInputType inputType;
        public String streamId;
        public String userId;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f45078x;

        /* renamed from: y, reason: collision with root package name */
        public int f45079y;
        public int zOrder;

        public V2TXLiveMixStream() {
            this.userId = "";
            this.f45078x = 0;
            this.f45079y = 0;
            this.width = 0;
            this.height = 0;
            this.zOrder = 0;
            this.inputType = V2TXLiveMixInputType.V2TXLiveMixInputTypeAudioVideo;
        }

        public String toString() {
            return "[userId='" + this.userId + "'][streamId='" + this.streamId + "'][x=" + this.f45078x + "][y=" + this.f45079y + "][width=" + this.width + "][height=" + this.height + "][zOrder=" + this.zOrder + "][inputType=" + ((Object) this.inputType) + ']';
        }

        public V2TXLiveMixStream(String str, int i10, int i11, int i12, int i13, int i14) {
            this.userId = str;
            this.f45078x = i10;
            this.f45079y = i11;
            this.width = i12;
            this.height = i13;
            this.zOrder = i14;
            this.inputType = V2TXLiveMixInputType.V2TXLiveMixInputTypeAudioVideo;
        }

        public V2TXLiveMixStream(V2TXLiveMixStream v2TXLiveMixStream) {
            this.userId = v2TXLiveMixStream.userId;
            this.streamId = v2TXLiveMixStream.streamId;
            this.f45078x = v2TXLiveMixStream.f45078x;
            this.f45079y = v2TXLiveMixStream.f45079y;
            this.width = v2TXLiveMixStream.width;
            this.height = v2TXLiveMixStream.height;
            this.zOrder = v2TXLiveMixStream.zOrder;
            this.inputType = v2TXLiveMixStream.inputType;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class V2TXLiveTranscodingConfig {
        public int audioBitrate;
        public int audioChannels;
        public int audioSampleRate;
        public int backgroundColor;
        public String backgroundImage;
        public ArrayList<V2TXLiveMixStream> mixStreams;
        public String outputStreamId;
        public int videoBitrate;
        public int videoFramerate;
        public int videoGOP;
        public int videoHeight;
        public int videoWidth;

        public V2TXLiveTranscodingConfig() {
            this.videoWidth = 0;
            this.videoHeight = 0;
            this.videoBitrate = 0;
            this.videoFramerate = 15;
            this.videoGOP = 2;
            this.backgroundColor = 0;
            this.audioSampleRate = 48000;
            this.audioChannels = 1;
            this.outputStreamId = null;
        }

        public final String toString() {
            return "[videoWidth=" + this.videoWidth + "][videoHeight=" + this.videoHeight + "][videoBitrate=" + this.videoBitrate + "][videoFramerate=" + this.videoFramerate + "][videoGOP=" + this.videoGOP + "][backgroundColor=" + this.backgroundColor + "][backgroundImage='" + this.backgroundImage + "'][audioSampleRate=" + this.audioSampleRate + "][audioBitrate=" + this.audioBitrate + "][audioChannels=" + this.audioChannels + "][mixStreams=" + ((Object) this.mixStreams) + "][outputStreamId='" + this.outputStreamId + "']";
        }

        public V2TXLiveTranscodingConfig(V2TXLiveTranscodingConfig v2TXLiveTranscodingConfig) {
            this.videoWidth = v2TXLiveTranscodingConfig.videoWidth;
            this.videoHeight = v2TXLiveTranscodingConfig.videoHeight;
            this.videoBitrate = v2TXLiveTranscodingConfig.videoBitrate;
            this.videoFramerate = v2TXLiveTranscodingConfig.videoFramerate;
            this.videoGOP = v2TXLiveTranscodingConfig.videoGOP;
            this.backgroundColor = v2TXLiveTranscodingConfig.backgroundColor;
            this.backgroundImage = v2TXLiveTranscodingConfig.backgroundImage;
            this.audioSampleRate = v2TXLiveTranscodingConfig.audioSampleRate;
            this.audioBitrate = v2TXLiveTranscodingConfig.audioBitrate;
            this.audioChannels = v2TXLiveTranscodingConfig.audioChannels;
            this.outputStreamId = v2TXLiveTranscodingConfig.outputStreamId;
            this.mixStreams = new ArrayList<>(v2TXLiveTranscodingConfig.mixStreams);
        }
    }
}
