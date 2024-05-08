package com.tencent.liteav.trtc;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.s;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.e;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONArray;
import org.json.JSONObject;

@JNINamespace("liteav::trtc")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TrtcCloudJni {
    private static final Object INIT_LOCK = new Object();
    private static final String TAG = "TrtcCloudJni";
    private static boolean mHasInited;
    private TRTCCloudListener.TRTCAudioFrameListener mAudioFrameListener;
    private TRTCCloudListener.TRTCVideoFrameListener mCalledGLCreatedFrameListener;
    private final HashSet<View> mFloatingWindowSet;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private TRTCCloudListener mListener;
    private Handler mListenerHandler;
    private List<TRTCCloudListener> mListenerList;
    private String mLocalUserId;
    private final a<TRTCCloudListener.TRTCVideoRenderListener> mLocalVideoRenderListenerWrapper;
    private long mNativeTrtcCloudJni;
    private final ReentrantReadWriteLock mReadWriteLock;
    private final Map<String, a<TRTCCloudListener.TRTCVideoRenderListener>> mRemoteVideoRenderListenerMap;
    private final a<TRTCCloudListener.TRTCVideoFrameListener> mVideoFrameListenerWrapper;

    /* renamed from: com.tencent.liteav.trtc.TrtcCloudJni$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43212a;

        static {
            int[] iArr = new int[Rotation.values().length];
            f43212a = iArr;
            try {
                iArr[Rotation.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43212a[Rotation.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43212a[Rotation.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AudioFrame {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioFrame f43213a;

        public AudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            this.f43213a = tRTCAudioFrame;
        }

        @CalledByNative("AudioFrame")
        public int getChannel() {
            return this.f43213a.channel;
        }

        @CalledByNative("AudioFrame")
        public byte[] getData() {
            return this.f43213a.data;
        }

        @CalledByNative("AudioFrame")
        public int getSampleRate() {
            return this.f43213a.sampleRate;
        }

        @CalledByNative("AudioFrame")
        public long getTimestamp() {
            return this.f43213a.timestamp;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AudioParallelParams {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioParallelParams f43214a;

        public AudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
            this.f43214a = tRTCAudioParallelParams;
        }

        @CalledByNative("AudioParallelParams")
        public String[] getIncludeUsers() {
            ArrayList<String> arrayList = this.f43214a.includeUsers;
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        @CalledByNative("AudioParallelParams")
        public int getMaxCount() {
            return this.f43214a.maxCount;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AudioRecordingParams {

        /* renamed from: a, reason: collision with root package name */
        private final TRTCCloudDef.TRTCAudioRecordingParams f43215a;

        public AudioRecordingParams(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
            this.f43215a = tRTCAudioRecordingParams;
        }

        @CalledByNative("AudioRecordingParams")
        public int getContent() {
            return this.f43215a.recordingContent;
        }

        @CalledByNative("AudioRecordingParams")
        public String getFilePath() {
            return this.f43215a.filePath;
        }

        @CalledByNative("AudioRecordingParams")
        public int getMaxDurationPerFile() {
            return this.f43215a.maxDurationPerFile;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class EnterRoomParams {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCParams f43216a;

        public EnterRoomParams(TRTCCloudDef.TRTCParams tRTCParams) {
            this.f43216a = tRTCParams;
        }

        @CalledByNative("EnterRoomParams")
        public String getBusinessInfo() {
            return this.f43216a.businessInfo;
        }

        @CalledByNative("EnterRoomParams")
        public String getPrivateMapKey() {
            return this.f43216a.privateMapKey;
        }

        @CalledByNative("EnterRoomParams")
        public String getRecordId() {
            return this.f43216a.userDefineRecordId;
        }

        @CalledByNative("EnterRoomParams")
        public int getRole() {
            return this.f43216a.role;
        }

        @CalledByNative("EnterRoomParams")
        public int getRoomId() {
            return this.f43216a.roomId;
        }

        @CalledByNative("EnterRoomParams")
        public int getSdkAppId() {
            return this.f43216a.sdkAppId;
        }

        @CalledByNative("EnterRoomParams")
        public String getStrRoomId() {
            return this.f43216a.strRoomId;
        }

        @CalledByNative("EnterRoomParams")
        public String getStreamId() {
            return this.f43216a.streamId;
        }

        @CalledByNative("EnterRoomParams")
        public String getUserId() {
            return this.f43216a.userId;
        }

        @CalledByNative("EnterRoomParams")
        public String getUserSig() {
            return this.f43216a.userSig;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class LocalRecordingParams {

        /* renamed from: a, reason: collision with root package name */
        private final TRTCCloudDef.TRTCLocalRecordingParams f43217a;

        public LocalRecordingParams(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
            this.f43217a = tRTCLocalRecordingParams;
        }

        @CalledByNative("LocalRecordingParams")
        public String getFilePath() {
            return this.f43217a.filePath;
        }

        @CalledByNative("LocalRecordingParams")
        public int getInterval() {
            return this.f43217a.interval;
        }

        @CalledByNative("LocalRecordingParams")
        public int getMaxDurationPerFile() {
            return this.f43217a.maxDurationPerFile;
        }

        @CalledByNative("LocalRecordingParams")
        public int getRecordType() {
            return this.f43217a.recordType;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class LocalStatistics {

        /* renamed from: a, reason: collision with root package name */
        private TRTCStatistics.TRTCLocalStatistics f43218a = new TRTCStatistics.TRTCLocalStatistics();

        @CalledByNative("LocalStatistics")
        public static void addLocalStatistics(LocalStatistics localStatistics, ArrayList<LocalStatistics> arrayList) {
            arrayList.add(localStatistics);
        }

        @CalledByNative("LocalStatistics")
        public static LocalStatistics createLocalStatistics(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            LocalStatistics localStatistics = new LocalStatistics();
            TRTCStatistics.TRTCLocalStatistics tRTCLocalStatistics = localStatistics.f43218a;
            tRTCLocalStatistics.streamType = i10;
            tRTCLocalStatistics.width = i11;
            tRTCLocalStatistics.height = i12;
            tRTCLocalStatistics.frameRate = i13;
            tRTCLocalStatistics.videoBitrate = i14;
            tRTCLocalStatistics.audioBitrate = i16;
            tRTCLocalStatistics.audioSampleRate = i15;
            tRTCLocalStatistics.audioCaptureState = i17;
            return localStatistics;
        }

        @CalledByNative("LocalStatistics")
        public static ArrayList<LocalStatistics> createLocalStatisticsArray() {
            return new ArrayList<>();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class MixUser {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCMixUser f43219a;

        public /* synthetic */ MixUser(TRTCCloudDef.TRTCMixUser tRTCMixUser, byte b4) {
            this(tRTCMixUser);
        }

        @CalledByNative("MixUser")
        public int getHeight() {
            return this.f43219a.height;
        }

        @CalledByNative("MixUser")
        public String getImage() {
            return TextUtils.isEmpty(this.f43219a.image) ? "" : this.f43219a.image;
        }

        @CalledByNative("MixUser")
        public int getInputType() {
            return this.f43219a.inputType;
        }

        @CalledByNative("MixUser")
        public boolean getPureAudio() {
            return this.f43219a.pureAudio;
        }

        @CalledByNative("MixUser")
        public int getRenderMode() {
            return this.f43219a.renderMode;
        }

        @CalledByNative("MixUser")
        public String getRoomId() {
            return TextUtils.isEmpty(this.f43219a.roomId) ? "" : this.f43219a.roomId;
        }

        @CalledByNative("MixUser")
        public int getSoundLevel() {
            return this.f43219a.soundLevel;
        }

        @CalledByNative("MixUser")
        public int getStreamType() {
            return this.f43219a.streamType;
        }

        @CalledByNative("MixUser")
        public String getUserId() {
            return TextUtils.isEmpty(this.f43219a.userId) ? "" : this.f43219a.userId;
        }

        @CalledByNative("MixUser")
        public int getWidth() {
            return this.f43219a.width;
        }

        @CalledByNative("MixUser")
        public int getX() {
            return this.f43219a.f45376x;
        }

        @CalledByNative("MixUser")
        public int getY() {
            return this.f43219a.f45377y;
        }

        @CalledByNative("MixUser")
        public int getZOrder() {
            return this.f43219a.zOrder;
        }

        private MixUser(TRTCCloudDef.TRTCMixUser tRTCMixUser) {
            this.f43219a = tRTCMixUser;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class PayloadPrivateEncryptionConfig {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig f43220a;

        public PayloadPrivateEncryptionConfig(TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig) {
            this.f43220a = tRTCPayloadPrivateEncryptionConfig;
        }

        @CalledByNative("PayloadPrivateEncryptionConfig")
        public int getEncryptionAlgorithm() {
            return this.f43220a.encryptionAlgorithm;
        }

        @CalledByNative("PayloadPrivateEncryptionConfig")
        public String getEncryptionKey() {
            String str = this.f43220a.encryptionKey;
            return str != null ? str : "";
        }

        @CalledByNative("PayloadPrivateEncryptionConfig")
        public byte[] getEncryptionSalt() {
            return this.f43220a.encryptionSalt;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class PublishCDNParams {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishCDNParam f43221a;

        public PublishCDNParams(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
            this.f43221a = tRTCPublishCDNParam;
        }

        @CalledByNative("PublishCDNParams")
        public int getAppId() {
            return this.f43221a.appId;
        }

        @CalledByNative("PublishCDNParams")
        public int getBizId() {
            return this.f43221a.bizId;
        }

        @CalledByNative("PublishCDNParams")
        public String getStreamId() {
            return TextUtils.isEmpty(this.f43221a.streamId) ? "" : this.f43221a.streamId;
        }

        @CalledByNative("PublishCDNParams")
        public String getUrl() {
            return TextUtils.isEmpty(this.f43221a.url) ? "" : this.f43221a.url;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class PublishCdnUrl {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishCdnUrl f43222a;

        public PublishCdnUrl(TRTCCloudDef.TRTCPublishCdnUrl tRTCPublishCdnUrl) {
            this.f43222a = tRTCPublishCdnUrl;
        }

        @CalledByNative("PublishCdnUrl")
        public boolean getIsInternalLine() {
            return this.f43222a.isInternalLine;
        }

        @CalledByNative("PublishCdnUrl")
        public String getRtmpUrl() {
            String str = this.f43222a.rtmpUrl;
            return str != null ? str : "";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class PublishTarget {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishTarget f43223a;

        public PublishTarget(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget) {
            this.f43223a = tRTCPublishTarget;
        }

        @CalledByNative("PublishTarget")
        public int getMode() {
            return this.f43223a.mode;
        }

        @CalledByNative("PublishTarget")
        public PublishCdnUrl[] getPublishCdnUrls() {
            ArrayList<TRTCCloudDef.TRTCPublishCdnUrl> arrayList = this.f43223a.cdnUrlList;
            if (arrayList == null) {
                return null;
            }
            PublishCdnUrl[] publishCdnUrlArr = new PublishCdnUrl[arrayList.size()];
            for (int i10 = 0; i10 < this.f43223a.cdnUrlList.size(); i10++) {
                publishCdnUrlArr[i10] = new PublishCdnUrl(this.f43223a.cdnUrlList.get(i10));
            }
            return publishCdnUrlArr;
        }

        @CalledByNative("PublishTarget")
        public TRTCUser getTRTCUser() {
            return new TRTCUser(this.f43223a.mixStreamIdentity);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class RemoteStatistics {

        /* renamed from: a, reason: collision with root package name */
        public TRTCStatistics.TRTCRemoteStatistics f43224a = new TRTCStatistics.TRTCRemoteStatistics();

        @CalledByNative("RemoteStatistics")
        public static void addRemoteStatistics(RemoteStatistics remoteStatistics, ArrayList<RemoteStatistics> arrayList) {
            arrayList.add(remoteStatistics);
        }

        @CalledByNative("RemoteStatistics")
        public static RemoteStatistics createRemoteStatistics(String str, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27) {
            RemoteStatistics remoteStatistics = new RemoteStatistics();
            TRTCStatistics.TRTCRemoteStatistics tRTCRemoteStatistics = remoteStatistics.f43224a;
            tRTCRemoteStatistics.userId = str;
            tRTCRemoteStatistics.streamType = i10;
            tRTCRemoteStatistics.width = i11;
            tRTCRemoteStatistics.height = i12;
            tRTCRemoteStatistics.frameRate = i13;
            tRTCRemoteStatistics.audioPacketLoss = i20;
            tRTCRemoteStatistics.videoPacketLoss = i14;
            tRTCRemoteStatistics.videoBlockRate = i17;
            tRTCRemoteStatistics.videoTotalBlockTime = i16;
            tRTCRemoteStatistics.videoBitrate = i15;
            tRTCRemoteStatistics.audioBitrate = i19;
            tRTCRemoteStatistics.audioSampleRate = i18;
            tRTCRemoteStatistics.audioTotalBlockTime = i21;
            tRTCRemoteStatistics.audioBlockRate = i22;
            tRTCRemoteStatistics.jitterBufferDelay = i23;
            tRTCRemoteStatistics.point2PointDelay = i24;
            tRTCRemoteStatistics.finalLoss = i25;
            tRTCRemoteStatistics.remoteNetworkUplinkLoss = i26;
            tRTCRemoteStatistics.remoteNetworkRTT = i27;
            return remoteStatistics;
        }

        @CalledByNative("RemoteStatistics")
        public static ArrayList<RemoteStatistics> createRemoteStatisticsArray() {
            return new ArrayList<>();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ScreenShareParams {

        /* renamed from: a, reason: collision with root package name */
        private final TRTCCloudDef.TRTCScreenShareParams f43225a;

        public ScreenShareParams(TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
            this.f43225a = tRTCScreenShareParams;
        }

        @CalledByNative("ScreenShareParams")
        public Object getMediaProjection() {
            return this.f43225a.mediaProjection;
        }

        @CalledByNative("ScreenShareParams")
        public boolean isForegroundServiceEnabled() {
            return this.f43225a.enableForegroundService;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class SpeedTestResult {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCSpeedTestResult f43228a = new TRTCCloudDef.TRTCSpeedTestResult();

        @CalledByNative("SpeedTestResult")
        public static SpeedTestResult createSpeedTestResult(boolean z10, String str, String str2, int i10, float f10, float f11, int i11, int i12, int i13, int i14, int i15) {
            SpeedTestResult speedTestResult = new SpeedTestResult();
            TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult = speedTestResult.f43228a;
            tRTCSpeedTestResult.success = z10;
            tRTCSpeedTestResult.errMsg = str;
            tRTCSpeedTestResult.ip = str2;
            tRTCSpeedTestResult.quality = i10;
            tRTCSpeedTestResult.upLostRate = f10;
            tRTCSpeedTestResult.downLostRate = f11;
            tRTCSpeedTestResult.rtt = i11;
            tRTCSpeedTestResult.availableUpBandwidth = i12;
            tRTCSpeedTestResult.availableDownBandwidth = i13;
            tRTCSpeedTestResult.upJitter = i14;
            tRTCSpeedTestResult.downJitter = i15;
            return speedTestResult;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Statistics {

        /* renamed from: a, reason: collision with root package name */
        private TRTCStatistics f43229a = new TRTCStatistics();

        @CalledByNative("Statistics")
        public static Statistics createStatistics(int i10, int i11, int i12, int i13, int i14, int i15, long j10, long j11, ArrayList<LocalStatistics> arrayList, ArrayList<RemoteStatistics> arrayList2) {
            Statistics statistics = new Statistics();
            TRTCStatistics tRTCStatistics = statistics.f43229a;
            tRTCStatistics.appCpu = i10;
            tRTCStatistics.systemCpu = i11;
            tRTCStatistics.upLoss = i12;
            tRTCStatistics.downLoss = i13;
            tRTCStatistics.rtt = i14;
            tRTCStatistics.gatewayRtt = i15;
            tRTCStatistics.sendBytes = j10;
            tRTCStatistics.receiveBytes = j11;
            tRTCStatistics.localArray = new ArrayList<>();
            statistics.f43229a.remoteArray = new ArrayList<>();
            if (arrayList != null) {
                Iterator<LocalStatistics> iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    statistics.f43229a.localArray.add(iterator2.next().f43218a);
                }
            }
            if (arrayList2 != null) {
                Iterator<RemoteStatistics> iterator22 = arrayList2.iterator2();
                while (iterator22.hasNext()) {
                    statistics.f43229a.remoteArray.add(iterator22.next().f43224a);
                }
            }
            return statistics;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class StreamEncoderParam {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCStreamEncoderParam f43230a;

        public StreamEncoderParam(TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam) {
            this.f43230a = tRTCStreamEncoderParam;
        }

        @CalledByNative("StreamEncoderParam")
        public int getAudioEncodedChannelNum() {
            return this.f43230a.audioEncodedChannelNum;
        }

        @CalledByNative("StreamEncoderParam")
        public int getAudioEncodedCodecType() {
            return this.f43230a.audioEncodedCodecType;
        }

        @CalledByNative("StreamEncoderParam")
        public int getAudioEncodedKbps() {
            return this.f43230a.audioEncodedKbps;
        }

        @CalledByNative("StreamEncoderParam")
        public int getAudioEncodedSampleRate() {
            return this.f43230a.audioEncodedSampleRate;
        }

        @CalledByNative("StreamEncoderParam")
        public int getVideoEncodedFPS() {
            return this.f43230a.videoEncodedFPS;
        }

        @CalledByNative("StreamEncoderParam")
        public int getVideoEncodedGOP() {
            return this.f43230a.videoEncodedGOP;
        }

        @CalledByNative("StreamEncoderParam")
        public int getVideoEncodedHeight() {
            return this.f43230a.videoEncodedHeight;
        }

        @CalledByNative("StreamEncoderParam")
        public int getVideoEncodedKbps() {
            return this.f43230a.videoEncodedKbps;
        }

        @CalledByNative("StreamEncoderParam")
        public int getVideoEncodedWidth() {
            return this.f43230a.videoEncodedWidth;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class StreamMixingConfig {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCStreamMixingConfig f43231a;

        public StreamMixingConfig(TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
            this.f43231a = tRTCStreamMixingConfig;
        }

        @CalledByNative("StreamMixingConfig")
        public TRTCUser[] getAudioMixUserList() {
            ArrayList<TRTCCloudDef.TRTCUser> arrayList = this.f43231a.audioMixUserList;
            if (arrayList == null) {
                return null;
            }
            TRTCUser[] tRTCUserArr = new TRTCUser[arrayList.size()];
            for (int i10 = 0; i10 < this.f43231a.audioMixUserList.size(); i10++) {
                tRTCUserArr[i10] = new TRTCUser(this.f43231a.audioMixUserList.get(i10));
            }
            return tRTCUserArr;
        }

        @CalledByNative("StreamMixingConfig")
        public int getBackgroundColor() {
            return this.f43231a.backgroundColor;
        }

        @CalledByNative("StreamMixingConfig")
        public String getBackgroundImage() {
            String str = this.f43231a.backgroundImage;
            return str != null ? str : "";
        }

        @CalledByNative("StreamMixingConfig")
        public VideoLayout[] getVideoLayoutList() {
            ArrayList<TRTCCloudDef.TRTCVideoLayout> arrayList = this.f43231a.videoLayoutList;
            if (arrayList == null) {
                return null;
            }
            VideoLayout[] videoLayoutArr = new VideoLayout[arrayList.size()];
            for (int i10 = 0; i10 < this.f43231a.videoLayoutList.size(); i10++) {
                videoLayoutArr[i10] = new VideoLayout(this.f43231a.videoLayoutList.get(i10));
            }
            return videoLayoutArr;
        }

        @CalledByNative("StreamMixingConfig")
        public Watermark[] getWatermarkList() {
            ArrayList<TRTCCloudDef.TRTCWatermark> arrayList = this.f43231a.watermarkList;
            if (arrayList == null) {
                return null;
            }
            Watermark[] watermarkArr = new Watermark[arrayList.size()];
            for (int i10 = 0; i10 < this.f43231a.watermarkList.size(); i10++) {
                watermarkArr[i10] = new Watermark(this.f43231a.watermarkList.get(i10));
            }
            return watermarkArr;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class SwitchRoomConfig {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCSwitchRoomConfig f43232a;

        public SwitchRoomConfig(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
            this.f43232a = tRTCSwitchRoomConfig;
        }

        @CalledByNative("SwitchRoomConfig")
        public String getPrivateMapKey() {
            String str = this.f43232a.privateMapKey;
            return str != null ? str : "";
        }

        @CalledByNative("SwitchRoomConfig")
        public int getRoomId() {
            return this.f43232a.roomId;
        }

        @CalledByNative("SwitchRoomConfig")
        public String getStringRoomId() {
            String str = this.f43232a.strRoomId;
            return str != null ? str : "";
        }

        @CalledByNative("SwitchRoomConfig")
        public String getUserSig() {
            String str = this.f43232a.userSig;
            return str != null ? str : "";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCUser {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCUser f43233a;

        public TRTCUser(TRTCCloudDef.TRTCUser tRTCUser) {
            this.f43233a = tRTCUser;
        }

        @CalledByNative("TRTCUser")
        public int getIntRoomId() {
            return this.f43233a.intRoomId;
        }

        @CalledByNative("TRTCUser")
        public String getStrRoomId() {
            String str = this.f43233a.strRoomId;
            return str != null ? str : "";
        }

        @CalledByNative("TRTCUser")
        public String getUserId() {
            String str = this.f43233a.userId;
            return str != null ? str : "";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TranscodingConfig {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCTranscodingConfig f43234a;

        public TranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
            this.f43234a = tRTCTranscodingConfig;
        }

        @CalledByNative("TranscodingConfig")
        public int getAppId() {
            return this.f43234a.appId;
        }

        @CalledByNative("TranscodingConfig")
        public int getAudioBitrate() {
            return this.f43234a.audioBitrate;
        }

        @CalledByNative("TranscodingConfig")
        public int getAudioChannels() {
            return this.f43234a.audioChannels;
        }

        @CalledByNative("TranscodingConfig")
        public int getAudioSampleRate() {
            return this.f43234a.audioSampleRate;
        }

        @CalledByNative("TranscodingConfig")
        public int getBackgroundColor() {
            return this.f43234a.backgroundColor;
        }

        @CalledByNative("TranscodingConfig")
        public String getBackgroundImage() {
            return TextUtils.isEmpty(this.f43234a.backgroundImage) ? "" : this.f43234a.backgroundImage;
        }

        @CalledByNative("TranscodingConfig")
        public int getBizId() {
            return this.f43234a.bizId;
        }

        @CalledByNative("TranscodingConfig")
        public MixUser[] getMixUsers() {
            ArrayList<TRTCCloudDef.TRTCMixUser> arrayList = this.f43234a.mixUsers;
            if (arrayList == null) {
                return null;
            }
            MixUser[] mixUserArr = new MixUser[arrayList.size()];
            byte b4 = 0;
            for (int i10 = 0; i10 < this.f43234a.mixUsers.size(); i10++) {
                mixUserArr[i10] = new MixUser(this.f43234a.mixUsers.get(i10), b4);
            }
            return mixUserArr;
        }

        @CalledByNative("TranscodingConfig")
        public int getMode() {
            return this.f43234a.mode;
        }

        @CalledByNative("TranscodingConfig")
        public String getStreamId() {
            return TextUtils.isEmpty(this.f43234a.streamId) ? "" : this.f43234a.streamId;
        }

        @CalledByNative("TranscodingConfig")
        public int getVideoBitrate() {
            return this.f43234a.videoBitrate;
        }

        @CalledByNative("TranscodingConfig")
        public int getVideoFramerate() {
            return this.f43234a.videoFramerate;
        }

        @CalledByNative("TranscodingConfig")
        public int getVideoGOP() {
            return this.f43234a.videoGOP;
        }

        @CalledByNative("TranscodingConfig")
        public int getVideoHeight() {
            return this.f43234a.videoHeight;
        }

        @CalledByNative("TranscodingConfig")
        public String getVideoSeiParams() {
            return TextUtils.isEmpty(this.f43234a.videoSeiParams) ? "" : this.f43234a.videoSeiParams;
        }

        @CalledByNative("TranscodingConfig")
        public int getVideoWidth() {
            return this.f43234a.videoWidth;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class VideoEncParams {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCVideoEncParam f43235a;

        public VideoEncParams(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
            this.f43235a = tRTCVideoEncParam;
        }

        @CalledByNative("VideoEncParams")
        public int getMinVideoBitrate() {
            return this.f43235a.minVideoBitrate;
        }

        @CalledByNative("VideoEncParams")
        public int getVideoBitrate() {
            return this.f43235a.videoBitrate;
        }

        @CalledByNative("VideoEncParams")
        public int getVideoFps() {
            return this.f43235a.videoFps;
        }

        @CalledByNative("VideoEncParams")
        public int getVideoResolution() {
            return this.f43235a.videoResolution;
        }

        @CalledByNative("VideoEncParams")
        public int getVideoResolutionMode() {
            return this.f43235a.videoResolutionMode;
        }

        @CalledByNative("VideoEncParams")
        public boolean isEnableAdjustRes() {
            return this.f43235a.enableAdjustRes;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class VideoLayout {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCVideoLayout f43236a;

        public VideoLayout(TRTCCloudDef.TRTCVideoLayout tRTCVideoLayout) {
            this.f43236a = tRTCVideoLayout;
        }

        @CalledByNative("VideoLayout")
        public int getBackgroundColor() {
            return this.f43236a.backgroundColor;
        }

        @CalledByNative("VideoLayout")
        public int getFillMode() {
            return this.f43236a.fillMode;
        }

        @CalledByNative("VideoLayout")
        public int getHeight() {
            return this.f43236a.height;
        }

        @CalledByNative("VideoLayout")
        public String getPlaceHolderImage() {
            String str = this.f43236a.placeHolderImage;
            return str != null ? str : "";
        }

        @CalledByNative("VideoLayout")
        public TRTCUser getTRTCUser() {
            return new TRTCUser(this.f43236a.fixedVideoUser);
        }

        @CalledByNative("VideoLayout")
        public int getVideoStreamType() {
            return this.f43236a.fixedVideoStreamType;
        }

        @CalledByNative("VideoLayout")
        public int getWidth() {
            return this.f43236a.width;
        }

        @CalledByNative("VideoLayout")
        public int getX() {
            return this.f43236a.f45378x;
        }

        @CalledByNative("VideoLayout")
        public int getY() {
            return this.f43236a.f45379y;
        }

        @CalledByNative("VideoLayout")
        public int getZOrder() {
            return this.f43236a.zOrder;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Watermark {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCWatermark f43237a;

        public Watermark(TRTCCloudDef.TRTCWatermark tRTCWatermark) {
            this.f43237a = tRTCWatermark;
        }

        @CalledByNative("Watermark")
        public int getHeight() {
            return this.f43237a.height;
        }

        @CalledByNative("Watermark")
        public String getWatermarkUrl() {
            String str = this.f43237a.watermarkUrl;
            return str != null ? str : "";
        }

        @CalledByNative("Watermark")
        public int getWidth() {
            return this.f43237a.width;
        }

        @CalledByNative("Watermark")
        public int getX() {
            return this.f43237a.f45380x;
        }

        @CalledByNative("Watermark")
        public int getY() {
            return this.f43237a.f45381y;
        }

        @CalledByNative("Watermark")
        public int getZOrder() {
            return this.f43237a.zOrder;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public int f43238a;

        /* renamed from: b, reason: collision with root package name */
        public GLConstants.PixelFormatType f43239b;

        /* renamed from: c, reason: collision with root package name */
        public GLConstants.PixelBufferType f43240c;

        /* renamed from: d, reason: collision with root package name */
        public T f43241d;

        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }
    }

    static {
        s.a();
    }

    public TrtcCloudJni(boolean z10) {
        this(0L, z10);
    }

    private List<TRTCCloudListener> CopyOnReadListeners() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.mListenerList);
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null && !copyOnWriteArrayList.contains(tRTCCloudListener)) {
            copyOnWriteArrayList.add(this.mListener);
        }
        return copyOnWriteArrayList;
    }

    private static int convertPixelBufferTypeToTRTCBufferType(GLConstants.PixelBufferType pixelBufferType) {
        if (pixelBufferType == GLConstants.PixelBufferType.BYTE_BUFFER) {
            return 1;
        }
        if (pixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY) {
            return 2;
        }
        return pixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D ? 3 : 0;
    }

    private static int convertPixelFormatTypeToTRTCFormatType(GLConstants.PixelFormatType pixelFormatType) {
        if (pixelFormatType == GLConstants.PixelFormatType.I420) {
            return 1;
        }
        if (pixelFormatType == GLConstants.PixelFormatType.NV21) {
            return 4;
        }
        return pixelFormatType == GLConstants.PixelFormatType.RGBA ? 5 : 0;
    }

    private static int convertPixelFrameRotationToTRTCVideoRotation(Rotation rotation) {
        int i10 = AnonymousClass3.f43212a[rotation.ordinal()];
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2) {
                i11 = 3;
                if (i10 != 3) {
                    return 0;
                }
            }
        }
        return i11;
    }

    private static GLConstants.PixelBufferType convertTRTCBufferTypeToPixelBufferType(int i10) {
        if (i10 == 1) {
            return GLConstants.PixelBufferType.BYTE_BUFFER;
        }
        if (i10 != 2) {
            return GLConstants.PixelBufferType.TEXTURE_2D;
        }
        return GLConstants.PixelBufferType.BYTE_ARRAY;
    }

    private static GLConstants.PixelFormatType convertTRTCFormatTypeToPixelFormatType(int i10) {
        if (i10 != 2) {
            if (i10 == 4) {
                return GLConstants.PixelFormatType.NV21;
            }
            if (i10 != 5) {
                return GLConstants.PixelFormatType.I420;
            }
        }
        return GLConstants.PixelFormatType.RGBA;
    }

    private static Rotation covertTRTCVideoRotationToPixelFrameRotation(int i10) {
        if (i10 == 1) {
            return Rotation.ROTATION_90;
        }
        if (i10 == 2) {
            return Rotation.ROTATION_180;
        }
        if (i10 != 3) {
            return Rotation.NORMAL;
        }
        return Rotation.ROTATION_270;
    }

    @CalledByNative
    public static Bundle createExtraInfoBundle(String str, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i10);
        return bundle;
    }

    private Bundle extraToBundle(String str) {
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    String[] strArr = new String[jSONArray.length()];
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        strArr[i10] = jSONArray.getString(i10);
                    }
                    bundle.putStringArray(next, strArr);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bundle;
    }

    @CalledByNative
    public static long getGLContextNativeHandle(Object obj) {
        return OpenGlUtils.getGLContextNativeHandle(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingWindow() {
        WindowManager windowManager;
        if (this.mFloatingWindowSet.isEmpty()) {
            return;
        }
        Iterator<View> iterator2 = this.mFloatingWindowSet.iterator2();
        while (iterator2.hasNext()) {
            View next = iterator2.next();
            if (next != null && (windowManager = (WindowManager) next.getContext().getSystemService("window")) != null) {
                windowManager.removeViewImmediate(next);
            }
        }
        this.mFloatingWindowSet.clear();
    }

    public static void init(int i10) {
        synchronized (INIT_LOCK) {
            if (!mHasInited) {
                mHasInited = true;
                nativeGlobalInit(i10);
            }
        }
    }

    private static boolean isCustomPreprocessSupportedBufferType(GLConstants.PixelBufferType pixelBufferType) {
        return pixelBufferType == GLConstants.PixelBufferType.BYTE_BUFFER || pixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY || pixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D;
    }

    private static boolean isCustomPreprocessSupportedFormatType(GLConstants.PixelFormatType pixelFormatType) {
        return pixelFormatType == GLConstants.PixelFormatType.I420 || pixelFormatType == GLConstants.PixelFormatType.NV21 || pixelFormatType == GLConstants.PixelFormatType.RGBA;
    }

    private static boolean isCustomRenderSupportedBufferType(GLConstants.PixelBufferType pixelBufferType) {
        return pixelBufferType == GLConstants.PixelBufferType.BYTE_BUFFER || pixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY || pixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D;
    }

    private static boolean isCustomRenderSupportedFormatType(GLConstants.PixelFormatType pixelFormatType) {
        return pixelFormatType == GLConstants.PixelFormatType.I420 || pixelFormatType == GLConstants.PixelFormatType.NV21 || pixelFormatType == GLConstants.PixelFormatType.RGBA;
    }

    @CalledByNative
    public static boolean isInUIThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static /* synthetic */ void lambda$enterRoom$0(TrtcCloudJni trtcCloudJni) {
        trtcCloudJni.onEnterRoom(-3316);
        trtcCloudJni.onError(-3316, "enter room param null");
    }

    public static /* synthetic */ void lambda$onSnapshotComplete$1(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        if (tRTCSnapshotListener != null) {
            tRTCSnapshotListener.onSnapshotComplete(bitmap);
        }
    }

    private static native String nativeCallExperimentalAPI(long j10, String str);

    private static native void nativeConnectOtherRoom(long j10, String str);

    private static native long nativeCreateAudioEffectManager(long j10);

    private static native long nativeCreateBeautyManager(long j10);

    private static native long nativeCreateDeviceManager(long j10);

    private static native long nativeCreatePipeline(TrtcCloudJni trtcCloudJni, boolean z10);

    private static native long nativeCreateSubCloud(TrtcCloudJni trtcCloudJni, long j10);

    private static native void nativeDestroyPipeline(long j10);

    private static native void nativeDisconnectOtherRoom(long j10);

    private static native void nativeEnable3DSpatialAudioEffect(long j10, boolean z10);

    private static native void nativeEnableAudioFrameNotification(long j10, boolean z10);

    private static native void nativeEnableAudioVolumeEvaluation(long j10, boolean z10, int i10, boolean z11, boolean z12);

    private static native void nativeEnableCustomAudioCapture(long j10, boolean z10);

    private static native void nativeEnableCustomAudioRendering(long j10, boolean z10);

    private static native void nativeEnableCustomVideoCapture(long j10, int i10, boolean z10);

    private static native void nativeEnableEncSmallVideoStream(long j10, boolean z10, VideoEncParams videoEncParams);

    private static native void nativeEnableMixExternalAudioFrame(long j10, boolean z10, boolean z11);

    private static native int nativeEnablePayloadPrivateEncryption(long j10, boolean z10, PayloadPrivateEncryptionConfig payloadPrivateEncryptionConfig);

    private static native void nativeEnableVideoCustomPreprocess(long j10, boolean z10, int i10, int i11, int i12);

    private static native void nativeEnableVideoCustomRender(long j10, boolean z10, String str, int i10, int i11, int i12);

    private static native void nativeEnterRoom(long j10, EnterRoomParams enterRoomParams, int i10);

    private static native void nativeExitRoom(long j10);

    private static native int nativeGetAudioCaptureVolume(long j10);

    private static native int nativeGetAudioPlayoutVolume(long j10);

    private static native void nativeGetCustomAudioRenderingFrame(long j10, byte[] bArr, int i10, int i11);

    private static native void nativeGlobalInit(int i10);

    private static native void nativeGlobalUninit();

    private static native int nativeMixExternalAudioFrame(long j10, AudioFrame audioFrame);

    private static native void nativeMuteAllRemoteAudio(long j10, boolean z10);

    private static native void nativeMuteAllRemoteVideoStreams(long j10, boolean z10);

    private static native void nativeMuteLocalAudio(long j10, boolean z10);

    private static native void nativeMuteLocalVideo(long j10, int i10, boolean z10);

    private static native void nativeMuteRemoteAudio(long j10, String str, boolean z10);

    private static native void nativeMuteRemoteVideoStream(long j10, String str, int i10, boolean z10);

    private static native void nativePauseScreenCapture(long j10, int i10);

    private static native void nativeResumeScreenCapture(long j10, int i10);

    private static native void nativeSendCustomAudioData(long j10, AudioFrame audioFrame);

    private static native boolean nativeSendCustomCmdMsg(long j10, int i10, byte[] bArr, boolean z10, boolean z11);

    private static native void nativeSendCustomVideoData(long j10, int i10, int i11, int i12, Object obj, int i13, int i14, int i15, int i16, long j11, byte[] bArr, ByteBuffer byteBuffer);

    private static native boolean nativeSendSEIMsg(long j10, byte[] bArr, int i10);

    private static native void nativeSet3DSpatialReceivingRange(long j10, String str, int i10);

    private static native void nativeSetAudioCaptureVolume(long j10, int i10);

    private static native void nativeSetAudioPlayoutVolume(long j10, int i10);

    private static native void nativeSetAudioQuality(long j10, int i10);

    private static native int nativeSetCapturedAudioFrameCallbackFormat(long j10, int i10, int i11, int i12, int i13);

    private static native void nativeSetConsoleEnabled(boolean z10);

    private static native void nativeSetDefaultStreamRecvMode(long j10, boolean z10, boolean z11);

    private static native void nativeSetGSensorMode(long j10, int i10, int i11);

    private static native void nativeSetListenerHandler(long j10, Handler handler);

    private static native int nativeSetLocalProcessedAudioFrameCallbackFormat(long j10, int i10, int i11, int i12, int i13);

    private static native void nativeSetLocalViewFillMode(long j10, int i10);

    private static native void nativeSetLocalViewMirror(long j10, int i10);

    private static native void nativeSetLocalViewRotation(long j10, int i10);

    private static native void nativeSetLogCompressEnabled(boolean z10);

    private static native void nativeSetLogLevel(int i10);

    private static native void nativeSetLogPath(String str);

    private static native void nativeSetMixExternalAudioVolume(long j10, int i10, int i11);

    private static native void nativeSetMixTranscodingConfig(long j10, TranscodingConfig transcodingConfig);

    private static native int nativeSetMixedPlayAudioFrameCallbackFormat(long j10, int i10, int i11, int i12, int i13);

    private static native void nativeSetNetworkQosParam(long j10, int i10, int i11);

    private static native void nativeSetPerspectiveCorrectionPoints(long j10, String str, float[] fArr, float[] fArr2);

    private static native void nativeSetPriorRemoteVideoStreamType(long j10, int i10);

    private static native void nativeSetRemoteAudioParallelParams(long j10, AudioParallelParams audioParallelParams);

    private static native void nativeSetRemoteAudioVolume(long j10, String str, int i10);

    private static native void nativeSetRemoteVideoStreamType(long j10, String str, int i10);

    private static native void nativeSetRemoteViewFillMode(long j10, String str, int i10, int i11);

    private static native void nativeSetRemoteViewMirror(long j10, String str, int i10, int i11);

    private static native void nativeSetRemoteViewRotation(long j10, String str, int i10, int i11);

    private static native void nativeSetVideoEncoderMirror(long j10, boolean z10);

    private static native void nativeSetVideoEncoderParams(long j10, int i10, VideoEncParams videoEncParams);

    private static native void nativeSetVideoEncoderRotation(long j10, int i10);

    private static native void nativeSetVideoMuteImage(long j10, Bitmap bitmap, int i10);

    private static native void nativeSetWatermark(long j10, Bitmap bitmap, int i10, float f10, float f11, float f12);

    private static native void nativeShowDashboardManager(long j10, int i10);

    private static native void nativeSnapshotVideo(long j10, String str, int i10, int i11, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener);

    private static native int nativeStartAudioRecording(long j10, AudioRecordingParams audioRecordingParams);

    private static native void nativeStartLocalAudio(long j10);

    private static native void nativeStartLocalAudioWithQuality(long j10, int i10);

    private static native void nativeStartLocalPreview(long j10, boolean z10, DisplayTarget displayTarget);

    private static native void nativeStartLocalRecording(long j10, LocalRecordingParams localRecordingParams);

    private static native void nativeStartPublishCDNStream(long j10, PublishCDNParams publishCDNParams);

    private static native void nativeStartPublishMediaStream(long j10, PublishTarget publishTarget, StreamEncoderParam streamEncoderParam, StreamMixingConfig streamMixingConfig);

    private static native void nativeStartPublishing(long j10, String str, int i10);

    private static native void nativeStartRemoteView(long j10, String str, int i10, DisplayTarget displayTarget);

    private static native void nativeStartRemoteViewWithoutStreamType(long j10, String str, DisplayTarget displayTarget);

    private static native void nativeStartScreenCapture(long j10, int i10, VideoEncParams videoEncParams, ScreenShareParams screenShareParams);

    private static native void nativeStartSpeedTest(long j10, SpeedTestParams speedTestParams);

    private static native void nativeStartSystemAudioLoopback(long j10);

    private static native void nativeStopAllRemoteView(long j10);

    private static native void nativeStopAudioRecording(long j10);

    private static native void nativeStopLocalAudio(long j10);

    private static native void nativeStopLocalPreview(long j10);

    private static native void nativeStopLocalRecording(long j10);

    private static native void nativeStopPublishCDNStream(long j10);

    private static native void nativeStopPublishMediaStream(long j10, String str);

    private static native void nativeStopPublishing(long j10);

    private static native void nativeStopRemoteView(long j10, String str, int i10);

    private static native void nativeStopRemoteViewWithoutStreamType(long j10, String str);

    private static native void nativeStopScreenCapture(long j10, int i10);

    private static native void nativeStopSpeedTest(long j10);

    private static native void nativeStopSystemAudioLoopback(long j10);

    private static native void nativeSwitchRole(long j10, int i10);

    private static native void nativeSwitchRoleWithPrivateMapKey(long j10, int i10, String str);

    private static native void nativeSwitchRoom(long j10, SwitchRoomConfig switchRoomConfig);

    private static native void nativeUpdateLocalView(long j10, DisplayTarget displayTarget);

    private static native void nativeUpdateOtherRoomForwardMode(long j10, String str);

    private static native void nativeUpdatePublishMediaStream(long j10, String str, PublishTarget publishTarget, StreamEncoderParam streamEncoderParam, StreamMixingConfig streamMixingConfig);

    private static native void nativeUpdateRemote3DSpatialPosition(long j10, String str, int[] iArr);

    private static native void nativeUpdateRemoteView(long j10, String str, int i10, DisplayTarget displayTarget);

    private static native void nativeUpdateSelf3DSpatialPosition(long j10, int[] iArr, float[] fArr, float[] fArr2, float[] fArr3);

    private void runOnListenerThread(Runnable runnable) {
        Handler handler = this.mListenerHandler;
        if (Looper.myLooper() != handler.getLooper()) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void setConsoleEnabled(boolean z10) {
        nativeSetConsoleEnabled(z10);
    }

    public static void setLogCompressEnabled(boolean z10) {
        nativeSetLogCompressEnabled(z10);
    }

    public static void setLogDirPath(String str) {
        nativeSetLogPath(str);
    }

    public static void setLogLevel(int i10) {
        nativeSetLogLevel(i10);
    }

    private static void shadowCopy(@NonNull PixelFrame pixelFrame, @NonNull TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        tRTCVideoFrame.pixelFormat = convertPixelFormatTypeToTRTCFormatType(pixelFrame.getPixelFormatType());
        tRTCVideoFrame.bufferType = convertPixelBufferTypeToTRTCBufferType(pixelFrame.getPixelBufferType());
        TRTCCloudDef.TRTCTexture tRTCTexture = new TRTCCloudDef.TRTCTexture();
        tRTCVideoFrame.texture = tRTCTexture;
        tRTCTexture.textureId = pixelFrame.getTextureId();
        if (pixelFrame.getGLContext() instanceof EGLContext) {
            tRTCVideoFrame.texture.eglContext10 = (EGLContext) pixelFrame.getGLContext();
        } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 17 && (pixelFrame.getGLContext() instanceof android.opengl.EGLContext)) {
            tRTCVideoFrame.texture.eglContext14 = (android.opengl.EGLContext) pixelFrame.getGLContext();
        }
        tRTCVideoFrame.data = pixelFrame.getData();
        tRTCVideoFrame.buffer = pixelFrame.getBuffer();
        tRTCVideoFrame.width = pixelFrame.getWidth();
        tRTCVideoFrame.height = pixelFrame.getHeight();
        tRTCVideoFrame.timestamp = pixelFrame.getTimestamp();
        tRTCVideoFrame.rotation = convertPixelFrameRotationToTRTCVideoRotation(pixelFrame.getRotation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFloatingWindow(View view) {
        if (view == null) {
            return;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 23 && !Settings.canDrawOverlays(view.getContext())) {
            LiteavLog.e(TAG, "can't show floating window for no drawing overlay permission");
            return;
        }
        if (this.mFloatingWindowSet.contains(view)) {
            LiteavLog.i(TAG, "the window has been added");
            return;
        }
        WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
        if (windowManager == null) {
            LiteavLog.e(TAG, "get windowManager error");
            return;
        }
        this.mFloatingWindowSet.add(view);
        int i10 = 2005;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 26) {
            i10 = 2038;
        } else if (LiteavSystemInfo.getSystemOSVersionInt() > 24) {
            i10 = 2002;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i10);
        layoutParams.flags = 8 | 262144;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        windowManager.addView(view, layoutParams);
    }

    public static void uninit() {
        synchronized (INIT_LOCK) {
            if (mHasInited) {
                mHasInited = false;
                nativeGlobalUninit();
            }
        }
    }

    public void addListener(TRTCCloudListener tRTCCloudListener) {
        if (tRTCCloudListener == null || this.mListenerList.contains(tRTCCloudListener)) {
            return;
        }
        this.mListenerList.add(tRTCCloudListener);
    }

    public String callExperimentalAPI(String str) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                return nativeCallExperimentalAPI(j10, str);
            }
            this.mJniReadLock.unlock();
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void connectOtherRoom(String str) {
        long j10 = this.mNativeTrtcCloudJni;
        if (j10 != 0) {
            nativeConnectOtherRoom(j10, str);
        }
    }

    public long createAudioEffectManager() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            return j10 != 0 ? nativeCreateAudioEffectManager(j10) : 0L;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public long createBeautyManager() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            return j10 != 0 ? nativeCreateBeautyManager(j10) : 0L;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @CalledByNative
    public ByteBuffer createByteBuffer(int i10) {
        return ByteBuffer.allocateDirect(i10);
    }

    public long createDeviceManager() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            return j10 != 0 ? nativeCreateDeviceManager(j10) : 0L;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @CalledByNative
    public TRTCCloudDef.TRTCVideoFrame createTRTCVideoFrame(int i10, int i11, Object obj, int i12, int i13, int i14, int i15, long j10, byte[] bArr, ByteBuffer byteBuffer) {
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
        GLConstants.PixelBufferType a10 = GLConstants.PixelBufferType.a(i11);
        tRTCVideoFrame.pixelFormat = convertPixelFormatTypeToTRTCFormatType(GLConstants.PixelFormatType.a(i10));
        tRTCVideoFrame.bufferType = convertPixelBufferTypeToTRTCBufferType(a10);
        TRTCCloudDef.TRTCTexture tRTCTexture = new TRTCCloudDef.TRTCTexture();
        tRTCVideoFrame.texture = tRTCTexture;
        tRTCTexture.textureId = i12;
        if (obj instanceof EGLContext) {
            tRTCTexture.eglContext10 = (EGLContext) obj;
        } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 17 && (obj instanceof android.opengl.EGLContext)) {
            tRTCVideoFrame.texture.eglContext14 = (android.opengl.EGLContext) obj;
        }
        tRTCVideoFrame.data = bArr;
        tRTCVideoFrame.buffer = byteBuffer;
        tRTCVideoFrame.width = i13;
        tRTCVideoFrame.height = i14;
        tRTCVideoFrame.timestamp = j10;
        tRTCVideoFrame.rotation = convertPixelFrameRotationToTRTCVideoRotation(Rotation.a(i15));
        return tRTCVideoFrame;
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeDestroyPipeline(j10);
                this.mNativeTrtcCloudJni = 0L;
            }
            this.mListenerList.clear();
        } finally {
            this.mJniWriteLock.unlock();
        }
    }

    public void disconnectOtherRoom() {
        long j10 = this.mNativeTrtcCloudJni;
        if (j10 != 0) {
            nativeDisconnectOtherRoom(j10);
        }
    }

    public void enable3DSpatialAudioEffect(boolean z10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeEnable3DSpatialAudioEffect(j10, z10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableAudioVolumeEvaluation(boolean z10, TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeEnableAudioVolumeEvaluation(j10, z10, tRTCAudioVolumeEvaluateParams.interval, tRTCAudioVolumeEvaluateParams.enableVadDetection, tRTCAudioVolumeEvaluateParams.enableSpectrumCalculation);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomAudioCapture(boolean z10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeEnableCustomAudioCapture(j10, z10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomAudioRendering(boolean z10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeEnableCustomAudioRendering(j10, z10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomVideoCapture(int i10, boolean z10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeEnableCustomVideoCapture(j10, i10, z10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int enableEncSmallVideoStream(boolean z10, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeEnableEncSmallVideoStream(j10, z10, new VideoEncParams(tRTCVideoEncParam));
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void enableMixExternalAudioFrame(boolean z10, boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeEnableMixExternalAudioFrame(j10, z10, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int enablePayloadPrivateEncryption(boolean z10, TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig) {
        int i10;
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                i10 = nativeEnablePayloadPrivateEncryption(j10, z10, tRTCPayloadPrivateEncryptionConfig == null ? null : new PayloadPrivateEncryptionConfig(tRTCPayloadPrivateEncryptionConfig));
            } else {
                i10 = -1;
            }
            return i10;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i10) {
        if (tRTCParams == null) {
            LiteavLog.e(TAG, "enterRoom param is null");
            runOnListenerThread(com.tencent.liteav.trtc.a.a(this));
            return;
        }
        this.mJniReadLock.lock();
        try {
            this.mLocalUserId = tRTCParams.userId;
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeEnterRoom(j10, new EnterRoomParams(tRTCParams), i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void exitRoom() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeExitRoom(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getAudioCaptureVolume() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            return j10 != 0 ? nativeGetAudioCaptureVolume(j10) : 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getAudioPlayoutVolume() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            return j10 != 0 ? nativeGetAudioPlayoutVolume(j10) : 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeGetCustomAudioRenderingFrame(j10, tRTCAudioFrame.data, tRTCAudioFrame.sampleRate, tRTCAudioFrame.channel);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @CalledByNative
    public int getFrameBufferType(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return convertTRTCBufferTypeToPixelBufferType(tRTCVideoFrame.bufferType).mValue;
    }

    @CalledByNative
    public byte[] getFrameByteArray(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.data;
    }

    @CalledByNative
    public ByteBuffer getFrameByteBuffer(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.buffer;
    }

    @CalledByNative
    public Object getFrameEglContext(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
            return tRTCVideoFrame.texture.eglContext14;
        }
        return tRTCVideoFrame.texture.eglContext10;
    }

    @CalledByNative
    public int getFrameHeight(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.height;
    }

    @CalledByNative
    public int getFramePixelFormat(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return convertTRTCFormatTypeToPixelFormatType(tRTCVideoFrame.pixelFormat).getValue();
    }

    @CalledByNative
    public long getFramePts(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.timestamp;
    }

    @CalledByNative
    public int getFrameRotation(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return covertTRTCVideoRotationToPixelFrameRotation(tRTCVideoFrame.rotation).mValue;
    }

    @CalledByNative
    public int getFrameTextureId(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.texture.textureId;
    }

    @CalledByNative
    public int getFrameWidth(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.width;
    }

    public long getTrtcCloudJni() {
        this.mJniReadLock.lock();
        try {
            return this.mNativeTrtcCloudJni;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                return nativeMixExternalAudioFrame(j10, new AudioFrame(tRTCAudioFrame));
            }
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteAllRemoteAudio(boolean z10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeMuteAllRemoteAudio(j10, z10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteAllRemoteVideoStreams(boolean z10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeMuteAllRemoteVideoStreams(j10, z10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteLocalAudio(boolean z10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeMuteLocalAudio(j10, z10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteLocalVideo(int i10, boolean z10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeMuteLocalVideo(j10, i10, z10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteRemoteAudio(String str, boolean z10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeMuteRemoteAudio(j10, str, z10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteRemoteVideoStream(String str, int i10, boolean z10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeMuteRemoteVideoStream(j10, str, i10, z10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @CalledByNative
    public void onAudioCaptureProcessedData(byte[] bArr, long j10, int i10, int i11) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j10;
        tRTCAudioFrame.sampleRate = i10;
        tRTCAudioFrame.channel = i11;
        tRTCAudioFrameListener.onCapturedAudioFrame(tRTCAudioFrame);
    }

    @CalledByNative
    public void onAudioMixedAllData(byte[] bArr, int i10, int i11) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = 0L;
        tRTCAudioFrame.sampleRate = i10;
        tRTCAudioFrame.channel = i11;
        tRTCAudioFrameListener.onMixedAllAudioFrame(tRTCAudioFrame);
    }

    @CalledByNative
    public void onAudioPlayoutData(byte[] bArr, long j10, int i10, int i11) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j10;
        tRTCAudioFrame.sampleRate = i10;
        tRTCAudioFrame.channel = i11;
        tRTCAudioFrameListener.onMixedPlayAudioFrame(tRTCAudioFrame);
    }

    @CalledByNative
    public void onAudioRemoteStreamData(String str, byte[] bArr, long j10, int i10, int i11, byte[] bArr2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j10;
        tRTCAudioFrame.sampleRate = i10;
        tRTCAudioFrame.channel = i11;
        tRTCAudioFrame.extraData = bArr2;
        tRTCAudioFrameListener.onRemoteUserAudioFrame(tRTCAudioFrame, str);
    }

    @CalledByNative
    public void onAudioRouteChanged(int i10, int i11) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onAudioRouteChanged(i10, i11);
        }
    }

    @CalledByNative
    public void onCameraDidReady() {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onCameraDidReady();
        }
    }

    @CalledByNative
    public void onCdnStreamStateChanged(String str, int i10, int i11, String str2, String str3) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onCdnStreamStateChanged(str, i10, i11, str2, null);
        }
    }

    @CalledByNative
    public void onConnectOtherRoom(String str, int i10, String str2) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onConnectOtherRoom(str, i10, str2);
        }
    }

    @CalledByNative
    public void onConnectionLost() {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onConnectionLost();
        }
    }

    @CalledByNative
    public void onConnectionRecovery() {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onConnectionRecovery();
        }
    }

    @CalledByNative
    public void onDisConnectOtherRoom(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onDisConnectOtherRoom(i10, str);
        }
    }

    @CalledByNative
    public void onEarMonitoringData(byte[] bArr, int i10, int i11) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = 0L;
        tRTCAudioFrame.sampleRate = i10;
        tRTCAudioFrame.channel = i11;
        tRTCAudioFrameListener.onVoiceEarMonitorAudioFrame(tRTCAudioFrame);
    }

    @CalledByNative
    public void onEnterRoom(int i10) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onEnterRoom(i10);
        }
    }

    @CalledByNative
    public void onError(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onError(i10, str, null);
        }
    }

    @CalledByNative
    public void onExitRoom(int i10) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onExitRoom(i10);
        }
        synchronized (this.mLocalVideoRenderListenerWrapper) {
            this.mLocalVideoRenderListenerWrapper.f43241d = null;
        }
        synchronized (this.mRemoteVideoRenderListenerMap) {
            this.mRemoteVideoRenderListenerMap.clear();
        }
    }

    @CalledByNative
    public void onFirstAudioFrame(String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onFirstAudioFrame(str);
        }
    }

    @CalledByNative
    public void onFirstVideoFrame(String str, int i10, int i11, int i12) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onFirstVideoFrame(str, i10, i11, i12);
        }
    }

    @CalledByNative
    public void onGLContextCreated() {
        synchronized (this.mVideoFrameListenerWrapper) {
            this.mCalledGLCreatedFrameListener = this.mVideoFrameListenerWrapper.f43241d;
        }
        LiteavLog.i(TAG, "onGLContextCreated " + ((Object) this.mCalledGLCreatedFrameListener));
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onGLContextCreated();
        }
    }

    @CalledByNative
    public void onGLContextDestroy() {
        LiteavLog.i(TAG, "onGLContextDestroy " + ((Object) this.mCalledGLCreatedFrameListener));
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onGLContextDestory();
            this.mCalledGLCreatedFrameListener = null;
        }
    }

    @CalledByNative
    public byte[] onLocalAudioStreamData(byte[] bArr, long j10, int i10, int i11) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return null;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j10;
        tRTCAudioFrame.sampleRate = i10;
        tRTCAudioFrame.channel = i11;
        tRTCAudioFrameListener.onLocalProcessedAudioFrame(tRTCAudioFrame);
        byte[] bArr2 = tRTCAudioFrame.extraData;
        if (bArr2 == null) {
            return null;
        }
        if (bArr2.length <= 100) {
            return bArr2;
        }
        LiteavLog.w(TAG, "Audioframe.extraData length need to be under 100!");
        return null;
    }

    @CalledByNative
    public void onLocalRecordBegin(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onLocalRecordBegin(i10, str);
        }
    }

    @CalledByNative
    public void onLocalRecordComplete(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onLocalRecordComplete(i10, str);
        }
    }

    @CalledByNative
    public void onLocalRecordFragment(String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onLocalRecordFragment(str);
        }
    }

    @CalledByNative
    public void onLocalRecording(long j10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onLocalRecording(j10, str);
        }
    }

    @CalledByNative
    public void onMicDidReady() {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onMicDidReady();
        }
    }

    @CalledByNative
    public void onMissCustomCmdMsg(String str, int i10, int i11, int i12) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onMissCustomCmdMsg(str, i10, i11, i12);
        }
    }

    @CalledByNative
    public void onNetworkQuality(int i10, String[] strArr, int[] iArr) {
        if (CopyOnReadListeners().size() == 0) {
            return;
        }
        TRTCCloudDef.TRTCQuality tRTCQuality = new TRTCCloudDef.TRTCQuality();
        tRTCQuality.userId = "";
        tRTCQuality.quality = i10;
        ArrayList<TRTCCloudDef.TRTCQuality> arrayList = new ArrayList<>();
        if (strArr != null && strArr.length != 0 && iArr != null && iArr.length != 0 && iArr.length == strArr.length) {
            for (int i11 = 0; i11 < strArr.length; i11++) {
                TRTCCloudDef.TRTCQuality tRTCQuality2 = new TRTCCloudDef.TRTCQuality();
                tRTCQuality2.userId = strArr[i11];
                tRTCQuality2.quality = iArr[i11];
                arrayList.add(tRTCQuality2);
            }
        }
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onNetworkQuality(tRTCQuality, arrayList);
        }
    }

    @CalledByNative
    public void onPreprocessVideoFrame(int i10, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame2) {
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener == null || tRTCVideoFrameListener == null) {
            return;
        }
        tRTCVideoFrameListener.onProcessVideoFrame(tRTCVideoFrame, tRTCVideoFrame2);
    }

    @CalledByNative
    public void onRecvCustomCmdMsg(String str, int i10, int i11, byte[] bArr) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onRecvCustomCmdMsg(str, i10, i11, bArr);
        }
    }

    @CalledByNative
    public void onRemoteAudioStatusUpdated(String str, int i10, int i11) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onRemoteAudioStatusUpdated(str, i10, i11, null);
        }
    }

    @CalledByNative
    public void onRemoteVideoStatusUpdated(String str, int i10, int i11, int i12) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onRemoteVideoStatusUpdated(str, i10, i11, i12, null);
        }
    }

    @CalledByNative
    public void onRenderVideoFrame(String str, int i10, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener;
        if (TextUtils.isEmpty(str)) {
            str = this.mLocalUserId;
            tRTCVideoRenderListener = this.mLocalVideoRenderListenerWrapper.f43241d;
        } else {
            a<TRTCCloudListener.TRTCVideoRenderListener> aVar = this.mRemoteVideoRenderListenerMap.get(str);
            tRTCVideoRenderListener = aVar == null ? null : aVar.f43241d;
        }
        if (tRTCVideoRenderListener != null) {
            tRTCVideoRenderListener.onRenderVideoFrame(str, i10, tRTCVideoFrame);
        }
    }

    @CalledByNative
    public void onSEIMessageReceived(byte[] bArr, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onRecvSEIMsg(str, bArr);
        }
    }

    @CalledByNative
    public void onScreenCapturePaused() {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onScreenCapturePaused();
        }
    }

    @CalledByNative
    public void onScreenCaptureResumed() {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onScreenCaptureResumed();
        }
    }

    @CalledByNative
    public void onScreenCaptureStarted() {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onScreenCaptureStarted();
        }
    }

    @CalledByNative
    public void onScreenCaptureStopped(int i10) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onScreenCaptureStopped(i10);
        }
    }

    @CalledByNative
    public void onSendFirstLocalAudioFrame() {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onSendFirstLocalAudioFrame();
        }
    }

    @CalledByNative
    public void onSendFirstLocalVideoFrame(int i10) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onSendFirstLocalVideoFrame(i10);
        }
    }

    @CalledByNative
    public void onSetMixTranscodingConfig(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onSetMixTranscodingConfig(i10, str);
        }
    }

    @CalledByNative
    public void onSnapshotComplete(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        runOnListenerThread(b.a(tRTCSnapshotListener, bitmap));
    }

    @CalledByNative
    public void onSpeedTest(SpeedTestResult speedTestResult, int i10, int i11) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onSpeedTest(speedTestResult.f43228a, i10, i11);
        }
    }

    @CalledByNative
    public void onSpeedTestResult(SpeedTestResult speedTestResult) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onSpeedTestResult(speedTestResult.f43228a);
        }
    }

    @CalledByNative
    public void onStartPublishCDNStream(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onStartPublishCDNStream(i10, str);
        }
    }

    @CalledByNative
    public void onStartPublishMediaStream(String str, int i10, String str2, String str3) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onStartPublishMediaStream(str, i10, str2, extraToBundle(str3));
        }
    }

    @CalledByNative
    public void onStartPublishing(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onStartPublishing(i10, str);
        }
    }

    @CalledByNative
    public void onStatistics(Statistics statistics) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onStatistics(statistics.f43229a);
        }
    }

    @CalledByNative
    public void onStopPublishCDNStream(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onStopPublishCDNStream(i10, str);
        }
    }

    @CalledByNative
    public void onStopPublishMediaStream(String str, int i10, String str2, String str3) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onStopPublishMediaStream(str, i10, str2, extraToBundle(str3));
        }
    }

    @CalledByNative
    public void onStopPublishing(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onStopPublishing(i10, str);
        }
    }

    @CalledByNative
    public void onSwitchRole(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onSwitchRole(i10, str);
        }
    }

    @CalledByNative
    public void onSwitchRoom(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onSwitchRoom(i10, str);
        }
    }

    @CalledByNative
    public void onTryToReconnect() {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onTryToReconnect();
        }
    }

    @CalledByNative
    public void onUpdateOtherRoomForwardMode(int i10, String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onUpdateOtherRoomForwardMode(i10, str);
        }
    }

    @CalledByNative
    public void onUpdatePublishMediaStream(String str, int i10, String str2, String str3) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onUpdatePublishMediaStream(str, i10, str2, extraToBundle(str3));
        }
    }

    @CalledByNative
    public void onUserAudioAvailable(String str, boolean z10) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onUserAudioAvailable(str, z10);
        }
    }

    @CalledByNative
    public void onUserEnter(String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onUserEnter(str);
        }
    }

    @CalledByNative
    public void onUserExit(String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onUserExit(str, 0);
        }
    }

    @CalledByNative
    public void onUserOffline(String str, int i10) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onRemoteUserLeaveRoom(str, i10);
        }
    }

    @CalledByNative
    public void onUserOnline(String str) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onRemoteUserEnterRoom(str);
        }
    }

    @CalledByNative
    public void onUserSubStreamAvailable(String str, boolean z10) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onUserSubStreamAvailable(str, z10);
        }
    }

    @CalledByNative
    public void onUserVideoAvailable(String str, boolean z10) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onUserVideoAvailable(str, z10);
        }
    }

    @CalledByNative
    public void onUserVideoSizeChanged(String str, int i10, int i11, int i12) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onUserVideoSizeChanged(str, i10, i11, i12);
        }
    }

    @CalledByNative
    public void onUserVoiceVolume(String[] strArr, int[] iArr, int[] iArr2, float[][] fArr, int i10) {
        String str;
        if (strArr == null || iArr == null) {
            return;
        }
        if (strArr.length == iArr.length) {
            ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList = new ArrayList<>();
            for (int i11 = 0; i11 < strArr.length; i11++) {
                TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
                if (strArr[i11].isEmpty() && (str = this.mLocalUserId) != null && !str.isEmpty()) {
                    tRTCVolumeInfo.userId = this.mLocalUserId;
                } else {
                    tRTCVolumeInfo.userId = strArr[i11];
                }
                tRTCVolumeInfo.volume = iArr[i11];
                tRTCVolumeInfo.vad = iArr2[i11];
                tRTCVolumeInfo.spectrumData = fArr[i11];
                arrayList.add(tRTCVolumeInfo);
            }
            Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onUserVoiceVolume(arrayList, i10);
            }
            return;
        }
        throw new IllegalArgumentException("Invalid parameter, userIds and volumes do not match.");
    }

    @CalledByNative
    public void onWarning(int i10, String str, Bundle bundle) {
        Iterator<TRTCCloudListener> iterator2 = CopyOnReadListeners().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onWarning(i10, str, bundle);
        }
    }

    public void pauseScreenCapture(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativePauseScreenCapture(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void removeListener(TRTCCloudListener tRTCCloudListener) {
        if (tRTCCloudListener == null || !this.mListenerList.contains(tRTCCloudListener)) {
            return;
        }
        this.mListenerList.remove(tRTCCloudListener);
    }

    public void resumeScreenCapture(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeResumeScreenCapture(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSendCustomAudioData(j10, new AudioFrame(tRTCAudioFrame));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public boolean sendCustomCmdMsg(int i10, byte[] bArr, boolean z10, boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                return nativeSendCustomCmdMsg(j10, i10, bArr, z10, z11);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void sendCustomVideoData(int i10, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        Object obj;
        int i11;
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                TRTCCloudDef.TRTCTexture tRTCTexture = tRTCVideoFrame.texture;
                if (tRTCTexture != null) {
                    int i12 = tRTCTexture.textureId;
                    Object obj2 = tRTCTexture.eglContext10;
                    if (obj2 == null) {
                        obj2 = tRTCTexture.eglContext14;
                    }
                    i11 = i12;
                    obj = obj2;
                } else {
                    obj = null;
                    i11 = -1;
                }
                nativeSendCustomVideoData(j10, i10, convertTRTCFormatTypeToPixelFormatType(tRTCVideoFrame.pixelFormat).getValue(), convertTRTCBufferTypeToPixelBufferType(tRTCVideoFrame.bufferType).mValue, obj, i11, tRTCVideoFrame.width, tRTCVideoFrame.height, covertTRTCVideoRotationToPixelFrameRotation(tRTCVideoFrame.rotation).mValue, tRTCVideoFrame.timestamp, tRTCVideoFrame.data, tRTCVideoFrame.buffer);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public boolean sendSEIMsg(byte[] bArr, int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                return nativeSendSEIMsg(j10, bArr, i10);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void set3DSpatialReceivingRange(String str, int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSet3DSpatialReceivingRange(j10, str, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioCaptureVolume(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetAudioCaptureVolume(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                this.mAudioFrameListener = tRTCAudioFrameListener;
                nativeEnableAudioFrameNotification(j10, tRTCAudioFrameListener != null);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioPlayoutVolume(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetAudioPlayoutVolume(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioQuality(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetAudioQuality(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setCapturedAudioFrameCallbackFormat(int i10, int i11, int i12, int i13) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            return j10 != 0 ? nativeSetCapturedAudioFrameCallbackFormat(j10, i10, i11, i12, i13) : 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setDefaultStreamRecvMode(boolean z10, boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetDefaultStreamRecvMode(j10, z10, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setGSensorMode(int i10, int i11) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetGSensorMode(j10, i10, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setListener(TRTCCloudListener tRTCCloudListener) {
        this.mListener = tRTCCloudListener;
    }

    public void setListenerHandler(Handler handler) {
        this.mJniReadLock.lock();
        if (handler == null) {
            this.mListenerHandler = new Handler(Looper.getMainLooper());
        } else {
            this.mListenerHandler = handler;
        }
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetListenerHandler(j10, handler);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setLocalProcessedAudioFrameCallbackFormat(int i10, int i11, int i12, int i13) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            return j10 != 0 ? nativeSetLocalProcessedAudioFrameCallbackFormat(j10, i10, i11, i12, i13) : 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setLocalVideoProcessListener(int i10, int i11, int i12, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                GLConstants.PixelFormatType convertTRTCFormatTypeToPixelFormatType = convertTRTCFormatTypeToPixelFormatType(i11);
                GLConstants.PixelBufferType convertTRTCBufferTypeToPixelBufferType = convertTRTCBufferTypeToPixelBufferType(i12);
                if (!isCustomPreprocessSupportedFormatType(convertTRTCFormatTypeToPixelFormatType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
                }
                if (!isCustomPreprocessSupportedBufferType(convertTRTCBufferTypeToPixelBufferType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
                }
                synchronized (this.mVideoFrameListenerWrapper) {
                    a<TRTCCloudListener.TRTCVideoFrameListener> aVar = this.mVideoFrameListenerWrapper;
                    if (aVar.f43241d != null) {
                        nativeEnableVideoCustomPreprocess(this.mNativeTrtcCloudJni, false, aVar.f43238a, aVar.f43239b.getValue(), this.mVideoFrameListenerWrapper.f43240c.mValue);
                    }
                    a<TRTCCloudListener.TRTCVideoFrameListener> aVar2 = this.mVideoFrameListenerWrapper;
                    aVar2.f43241d = tRTCVideoFrameListener;
                    aVar2.f43238a = i10;
                    aVar2.f43239b = convertTRTCFormatTypeToPixelFormatType;
                    aVar2.f43240c = convertTRTCBufferTypeToPixelBufferType;
                    if (tRTCVideoFrameListener != 0) {
                        nativeEnableVideoCustomPreprocess(this.mNativeTrtcCloudJni, true, i10, convertTRTCFormatTypeToPixelFormatType.getValue(), this.mVideoFrameListenerWrapper.f43240c.mValue);
                    }
                }
            }
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setLocalVideoRenderListener(int i10, int i11, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        boolean z10;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                GLConstants.PixelFormatType convertTRTCFormatTypeToPixelFormatType = convertTRTCFormatTypeToPixelFormatType(i10);
                GLConstants.PixelBufferType convertTRTCBufferTypeToPixelBufferType = convertTRTCBufferTypeToPixelBufferType(i11);
                if (!isCustomRenderSupportedFormatType(convertTRTCFormatTypeToPixelFormatType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
                }
                if (!isCustomRenderSupportedBufferType(convertTRTCBufferTypeToPixelBufferType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
                }
                synchronized (this.mLocalVideoRenderListenerWrapper) {
                    a<TRTCCloudListener.TRTCVideoRenderListener> aVar = this.mLocalVideoRenderListenerWrapper;
                    if (aVar.f43241d != null) {
                        GLConstants.PixelFormatType pixelFormatType = aVar.f43239b;
                        if (pixelFormatType == convertTRTCFormatTypeToPixelFormatType && aVar.f43240c == convertTRTCBufferTypeToPixelBufferType) {
                            z10 = false;
                            if (!z10 && tRTCVideoRenderListener != 0) {
                                aVar.f43241d = tRTCVideoRenderListener;
                            }
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 0, pixelFormatType.getValue(), this.mLocalVideoRenderListenerWrapper.f43240c.mValue);
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 2, this.mLocalVideoRenderListenerWrapper.f43239b.getValue(), this.mLocalVideoRenderListenerWrapper.f43240c.mValue);
                        }
                        z10 = true;
                        if (!z10) {
                            aVar.f43241d = tRTCVideoRenderListener;
                        }
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 0, pixelFormatType.getValue(), this.mLocalVideoRenderListenerWrapper.f43240c.mValue);
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 2, this.mLocalVideoRenderListenerWrapper.f43239b.getValue(), this.mLocalVideoRenderListenerWrapper.f43240c.mValue);
                    }
                    a<TRTCCloudListener.TRTCVideoRenderListener> aVar2 = this.mLocalVideoRenderListenerWrapper;
                    aVar2.f43241d = tRTCVideoRenderListener;
                    aVar2.f43239b = convertTRTCFormatTypeToPixelFormatType;
                    aVar2.f43240c = convertTRTCBufferTypeToPixelBufferType;
                    if (tRTCVideoRenderListener != 0) {
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, "", 0, convertTRTCFormatTypeToPixelFormatType.getValue(), this.mLocalVideoRenderListenerWrapper.f43240c.mValue);
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, "", 2, this.mLocalVideoRenderListenerWrapper.f43239b.getValue(), this.mLocalVideoRenderListenerWrapper.f43240c.mValue);
                    }
                }
            }
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewFillMode(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetLocalViewFillMode(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewMirror(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetLocalViewMirror(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewRotation(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetLocalViewRotation(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setMixExternalAudioVolume(int i10, int i11) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetMixExternalAudioVolume(j10, i10, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetMixTranscodingConfig(j10, tRTCTranscodingConfig == null ? null : new TranscodingConfig(tRTCTranscodingConfig));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setMixedPlayAudioFrameCallbackFormat(int i10, int i11, int i12, int i13) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            return j10 != 0 ? nativeSetMixedPlayAudioFrameCallbackFormat(j10, i10, i11, i12, i13) : 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetNetworkQosParam(j10, tRTCNetworkQosParam.preference, tRTCNetworkQosParam.controlMode);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setPerspectiveCorrectionPoints(String str, PointF[] pointFArr, PointF[] pointFArr2) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                List list = null;
                float[] a10 = e.a((List<PointF>) (pointFArr == null ? null : Arrays.asList(pointFArr)));
                if (pointFArr2 != null) {
                    list = Arrays.asList(pointFArr2);
                }
                nativeSetPerspectiveCorrectionPoints(j10, str, a10, e.a((List<PointF>) list));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setPriorRemoteVideoStreamType(int i10) {
        long j10 = this.mNativeTrtcCloudJni;
        if (j10 == 0) {
            return 0;
        }
        nativeSetPriorRemoteVideoStreamType(j10, i10);
        return 0;
    }

    public void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetRemoteAudioParallelParams(j10, new AudioParallelParams(tRTCAudioParallelParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteAudioVolume(String str, int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetRemoteAudioVolume(j10, str, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setRemoteVideoRenderListener(String str, int i10, int i11, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        boolean z10;
        this.mJniReadLock.lock();
        try {
            byte b4 = 0;
            if (this.mNativeTrtcCloudJni != 0) {
                if (TextUtils.isEmpty(str)) {
                    this.mJniReadLock.unlock();
                    return -3319;
                }
                GLConstants.PixelFormatType convertTRTCFormatTypeToPixelFormatType = convertTRTCFormatTypeToPixelFormatType(i10);
                GLConstants.PixelBufferType convertTRTCBufferTypeToPixelBufferType = convertTRTCBufferTypeToPixelBufferType(i11);
                if (!isCustomRenderSupportedFormatType(convertTRTCFormatTypeToPixelFormatType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
                }
                if (!isCustomRenderSupportedBufferType(convertTRTCBufferTypeToPixelBufferType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
                }
                synchronized (this.mRemoteVideoRenderListenerMap) {
                    a<TRTCCloudListener.TRTCVideoRenderListener> aVar = this.mRemoteVideoRenderListenerMap.get(str);
                    if (aVar != null) {
                        GLConstants.PixelFormatType pixelFormatType = aVar.f43239b;
                        if (pixelFormatType == convertTRTCFormatTypeToPixelFormatType && aVar.f43240c == convertTRTCBufferTypeToPixelBufferType) {
                            z10 = false;
                            if (!z10 && tRTCVideoRenderListener != 0) {
                                aVar.f43241d = tRTCVideoRenderListener;
                                this.mRemoteVideoRenderListenerMap.put(str, aVar);
                            }
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, str, 0, pixelFormatType.getValue(), aVar.f43240c.mValue);
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, str, 2, aVar.f43239b.getValue(), aVar.f43240c.mValue);
                        }
                        z10 = true;
                        if (!z10) {
                            aVar.f43241d = tRTCVideoRenderListener;
                            this.mRemoteVideoRenderListenerMap.put(str, aVar);
                        }
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, str, 0, pixelFormatType.getValue(), aVar.f43240c.mValue);
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, str, 2, aVar.f43239b.getValue(), aVar.f43240c.mValue);
                    }
                    if (tRTCVideoRenderListener != 0) {
                        a<TRTCCloudListener.TRTCVideoRenderListener> aVar2 = new a<>(b4);
                        aVar2.f43241d = tRTCVideoRenderListener;
                        aVar2.f43239b = convertTRTCFormatTypeToPixelFormatType;
                        aVar2.f43240c = convertTRTCBufferTypeToPixelBufferType;
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, str, 0, convertTRTCFormatTypeToPixelFormatType.getValue(), aVar2.f43240c.mValue);
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, str, 2, aVar2.f43239b.getValue(), aVar2.f43240c.mValue);
                        this.mRemoteVideoRenderListenerMap.put(str, aVar2);
                    } else {
                        this.mRemoteVideoRenderListenerMap.remove(str);
                    }
                }
            }
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setRemoteVideoStreamType(String str, int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetRemoteVideoStreamType(j10, str, i10);
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void setRemoteViewFillMode(String str, int i10, int i11) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetRemoteViewFillMode(j10, str, i10, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteViewMirror(String str, int i10, int i11) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetRemoteViewMirror(j10, str, i10, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteViewRotation(String str, int i10, int i11) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                if (i11 == 1) {
                    i11 = 3;
                } else if (i11 == 3) {
                    i11 = 1;
                }
                nativeSetRemoteViewRotation(j10, str, i10, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderMirror(boolean z10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetVideoEncoderMirror(j10, z10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderParams(int i10, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetVideoEncoderParams(j10, i10, new VideoEncParams(tRTCVideoEncParam));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderRotation(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetVideoEncoderRotation(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoMuteImage(Bitmap bitmap, int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetVideoMuteImage(j10, bitmap, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setWatermark(Bitmap bitmap, int i10, float f10, float f11, float f12) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSetWatermark(j10, bitmap, i10, f10, f11, f12);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void showDashboardManager(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeShowDashboardManager(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void snapshotVideo(String str, int i10, int i11, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSnapshotVideo(j10, str, i10, i11, tRTCSnapshotListener);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 == 0) {
                this.mJniReadLock.unlock();
                return 0;
            }
            return nativeStartAudioRecording(j10, new AudioRecordingParams(tRTCAudioRecordingParams));
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalAudio(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStartLocalAudioWithQuality(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalPreview(boolean z10, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStartLocalPreview(j10, z10, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStartLocalRecording(j10, new LocalRecordingParams(tRTCLocalRecordingParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStartPublishCDNStream(j10, new PublishCDNParams(tRTCPublishCDNParam));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                StreamMixingConfig streamMixingConfig = null;
                PublishTarget publishTarget = tRTCPublishTarget == null ? null : new PublishTarget(tRTCPublishTarget);
                StreamEncoderParam streamEncoderParam = tRTCStreamEncoderParam == null ? null : new StreamEncoderParam(tRTCStreamEncoderParam);
                if (tRTCStreamMixingConfig != null) {
                    streamMixingConfig = new StreamMixingConfig(tRTCStreamMixingConfig);
                }
                nativeStartPublishMediaStream(j10, publishTarget, streamEncoderParam, streamMixingConfig);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishing(String str, int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStartPublishing(j10, str, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startRemoteView(String str, int i10, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStartRemoteView(j10, str, i10, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startScreenCapture(int i10, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, final TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                ScreenShareParams screenShareParams = tRTCScreenShareParams != null ? new ScreenShareParams(tRTCScreenShareParams) : null;
                if (tRTCVideoEncParam == null) {
                    nativeStartScreenCapture(this.mNativeTrtcCloudJni, i10, null, screenShareParams);
                    LiteavLog.w(TAG, "startScreenCapture encParams is null");
                } else {
                    nativeStartScreenCapture(this.mNativeTrtcCloudJni, i10, new VideoEncParams(tRTCVideoEncParam), screenShareParams);
                }
            }
            if (tRTCScreenShareParams != null) {
                ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.liteav.trtc.TrtcCloudJni.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TrtcCloudJni.this.showFloatingWindow(tRTCScreenShareParams.floatingView);
                    }
                });
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSpeedTest(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStartSpeedTest(j10, new SpeedTestParams(tRTCSpeedTestParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSystemAudioLoopback() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStartSystemAudioLoopback(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopAllRemoteView() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopAllRemoteView(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopAudioRecording() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopAudioRecording(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalAudio() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopLocalAudio(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalPreview() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopLocalPreview(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalRecording() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopLocalRecording(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishCDNStream() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopPublishCDNStream(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishMediaStream(String str) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopPublishMediaStream(j10, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishing() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopPublishing(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopRemoteView(String str, int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopRemoteView(j10, str, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopScreenCapture(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopScreenCapture(j10, i10);
            }
            this.mJniReadLock.unlock();
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.liteav.trtc.TrtcCloudJni.2
                @Override // java.lang.Runnable
                public final void run() {
                    TrtcCloudJni.this.hideFloatingWindow();
                }
            });
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void stopSpeedTest() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopSpeedTest(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopSystemAudioLoopback() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopSystemAudioLoopback(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRole(int i10) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSwitchRole(j10, i10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSwitchRoom(j10, new SwitchRoomConfig(tRTCSwitchRoomConfig));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateLocalView(TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeUpdateLocalView(j10, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateOtherRoomForwardMode(String str) {
        long j10 = this.mNativeTrtcCloudJni;
        if (j10 != 0) {
            nativeUpdateOtherRoomForwardMode(j10, str);
        }
    }

    public void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeUpdatePublishMediaStream(j10, str, tRTCPublishTarget == null ? null : new PublishTarget(tRTCPublishTarget), tRTCStreamEncoderParam == null ? null : new StreamEncoderParam(tRTCStreamEncoderParam), tRTCStreamMixingConfig == null ? null : new StreamMixingConfig(tRTCStreamMixingConfig));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateRemote3DSpatialPosition(String str, int[] iArr) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeUpdateRemote3DSpatialPosition(j10, str, iArr);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateRemoteView(String str, int i10, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeUpdateRemoteView(j10, str, i10, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeUpdateSelf3DSpatialPosition(j10, iArr, fArr, fArr2, fArr3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public TrtcCloudJni(long j10, boolean z10) {
        this.mNativeTrtcCloudJni = 0L;
        this.mLocalUserId = "";
        this.mListenerList = new CopyOnWriteArrayList();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mFloatingWindowSet = new HashSet<>();
        if (j10 == 0) {
            this.mNativeTrtcCloudJni = nativeCreatePipeline(this, z10);
        } else {
            this.mNativeTrtcCloudJni = nativeCreateSubCloud(this, j10);
        }
        byte b4 = 0;
        this.mVideoFrameListenerWrapper = new a<>(b4);
        this.mLocalVideoRenderListenerWrapper = new a<>(b4);
        this.mRemoteVideoRenderListenerMap = new HashMap();
        this.mListenerHandler = new Handler(Looper.getMainLooper());
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class SpeedTestParams {

        /* renamed from: a, reason: collision with root package name */
        private final TRTCCloudDef.TRTCSpeedTestParams f43226a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f43227b;

        public SpeedTestParams(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
            this.f43226a = tRTCSpeedTestParams;
            this.f43227b = false;
        }

        @CalledByNative("SpeedTestParams")
        public int getExpectedDownBandwidth() {
            return this.f43226a.expectedDownBandwidth;
        }

        @CalledByNative("SpeedTestParams")
        public int getExpectedUpBandwidth() {
            return this.f43226a.expectedUpBandwidth;
        }

        @CalledByNative("SpeedTestParams")
        public boolean getIsCalledFromDeprecatedApi() {
            return this.f43227b;
        }

        @CalledByNative("SpeedTestParams")
        public int getSDKAppId() {
            return this.f43226a.sdkAppId;
        }

        @CalledByNative("SpeedTestParams")
        public int getScene() {
            return this.f43226a.scene;
        }

        @CalledByNative("SpeedTestParams")
        public String getUserId() {
            return this.f43226a.userId;
        }

        @CalledByNative("SpeedTestParams")
        public String getUserSig() {
            return this.f43226a.userSig;
        }

        public SpeedTestParams(int i10, String str, String str2) {
            TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams = new TRTCCloudDef.TRTCSpeedTestParams();
            this.f43226a = tRTCSpeedTestParams;
            tRTCSpeedTestParams.sdkAppId = i10;
            tRTCSpeedTestParams.userId = str;
            tRTCSpeedTestParams.userSig = str2;
            tRTCSpeedTestParams.scene = 1;
            this.f43227b = true;
        }
    }

    public void startLocalAudio() {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStartLocalAudio(j10);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startRemoteView(String str, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStartRemoteViewWithoutStreamType(j10, str, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSpeedTest(int i10, String str, String str2) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStartSpeedTest(j10, new SpeedTestParams(i10, str, str2));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopRemoteView(String str) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeStopRemoteViewWithoutStreamType(j10, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRole(int i10, String str) {
        this.mJniReadLock.lock();
        try {
            long j10 = this.mNativeTrtcCloudJni;
            if (j10 != 0) {
                nativeSwitchRoleWithPrivateMapKey(j10, i10, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    private static void shadowCopy(@NonNull TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame, @NonNull PixelFrame pixelFrame) {
        int i10;
        Object obj;
        TRTCCloudDef.TRTCTexture tRTCTexture = tRTCVideoFrame.texture;
        pixelFrame.setPixelFormatType(convertTRTCFormatTypeToPixelFormatType(tRTCVideoFrame.pixelFormat));
        pixelFrame.setPixelBufferType(convertTRTCBufferTypeToPixelBufferType(tRTCVideoFrame.bufferType));
        if (tRTCTexture != null) {
            i10 = tRTCTexture.textureId;
            obj = tRTCTexture.eglContext10;
            if (obj == null) {
                obj = tRTCTexture.eglContext14;
            }
        } else {
            i10 = -1;
            obj = null;
        }
        pixelFrame.setTextureId(i10);
        pixelFrame.setGLContext(obj);
        pixelFrame.setData(tRTCVideoFrame.data);
        pixelFrame.setBuffer(tRTCVideoFrame.buffer);
        pixelFrame.setWidth(tRTCVideoFrame.width);
        pixelFrame.setHeight(tRTCVideoFrame.height);
        pixelFrame.setTimestamp(tRTCVideoFrame.timestamp);
        pixelFrame.setRotation(covertTRTCVideoRotationToPixelFrameRotation(tRTCVideoFrame.rotation));
    }
}
