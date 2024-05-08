package com.zego.zegoliveroom;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import com.zego.zegoavkit2.ZegoStreamExtraPlayInfo;
import com.zego.zegoavkit2.audioprocessing.ZegoAudioProcessing;
import com.zego.zegoavkit2.entities.ZegoCDNPublishTarget;
import com.zego.zegoavkit2.entities.ZegoColorEnhancementParams;
import com.zego.zegoavkit2.entities.ZegoDumpDataConfig;
import com.zego.zegoavkit2.entities.ZegoObjectSegmentationConfig;
import com.zego.zegoavkit2.entities.ZegoStreamRelayCDNInfo;
import com.zego.zegoavkit2.utils.ZegoLogUtil;
import com.zego.zegoliveroom.ZegoLiveRoomJNI;
import com.zego.zegoliveroom.callback.IZegoAVEngineCallback;
import com.zego.zegoliveroom.callback.IZegoAudioAuxDataCallback;
import com.zego.zegoliveroom.callback.IZegoAudioPostpCallback;
import com.zego.zegoliveroom.callback.IZegoAudioPrepCallback2;
import com.zego.zegoliveroom.callback.IZegoAudioProcCallback;
import com.zego.zegoliveroom.callback.IZegoAudioRecordCallback;
import com.zego.zegoliveroom.callback.IZegoAudioRecordCallback2;
import com.zego.zegoliveroom.callback.IZegoAudioRouteCallback;
import com.zego.zegoliveroom.callback.IZegoCheckAudioVADCallback;
import com.zego.zegoliveroom.callback.IZegoCustomCommandCallback;
import com.zego.zegoliveroom.callback.IZegoDeviceEventCallback;
import com.zego.zegoliveroom.callback.IZegoDumpDataCallback;
import com.zego.zegoliveroom.callback.IZegoEndJoinLiveCallback;
import com.zego.zegoliveroom.callback.IZegoExperimentalAPICallback;
import com.zego.zegoliveroom.callback.IZegoInitSDKCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoLiveEventCallback;
import com.zego.zegoliveroom.callback.IZegoLivePlayerCallback;
import com.zego.zegoliveroom.callback.IZegoLivePlayerCallback2;
import com.zego.zegoliveroom.callback.IZegoLivePublisherCallback;
import com.zego.zegoliveroom.callback.IZegoLivePublisherCallback2;
import com.zego.zegoliveroom.callback.IZegoLivePublisherExCallback;
import com.zego.zegoliveroom.callback.IZegoLogHookCallback;
import com.zego.zegoliveroom.callback.IZegoLogInfoCallback;
import com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoNetTypeCallback;
import com.zego.zegoliveroom.callback.IZegoRealtimeSequentialDataCallback;
import com.zego.zegoliveroom.callback.IZegoResponseCallback;
import com.zego.zegoliveroom.callback.IZegoRoomCallback;
import com.zego.zegoliveroom.callback.IZegoRunLoopObserveCallback;
import com.zego.zegoliveroom.callback.IZegoSnapshotCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoSnapshotCompletionCallback2;
import com.zego.zegoliveroom.callback.IZegoUpdatePublishTargetCallback;
import com.zego.zegoliveroom.callback.im.IZegoBigRoomMessageCallback;
import com.zego.zegoliveroom.callback.im.IZegoIMCallback;
import com.zego.zegoliveroom.callback.im.IZegoRoomMessageCallback;
import com.zego.zegoliveroom.constants.ZegoAvConfig;
import com.zego.zegoliveroom.constants.ZegoConstants;
import com.zego.zegoliveroom.entity.ZegoAudioAuxDataConfig;
import com.zego.zegoliveroom.entity.ZegoAudioFrame;
import com.zego.zegoliveroom.entity.ZegoAudioRecordConfig;
import com.zego.zegoliveroom.entity.ZegoBigRoomMessage;
import com.zego.zegoliveroom.entity.ZegoCodecCapabilityInfo;
import com.zego.zegoliveroom.entity.ZegoExtPrepSet;
import com.zego.zegoliveroom.entity.ZegoPlayStats;
import com.zego.zegoliveroom.entity.ZegoPlayStreamParams;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import com.zego.zegoliveroom.entity.ZegoProxyInfo;
import com.zego.zegoliveroom.entity.ZegoPublishDualStreamConfig;
import com.zego.zegoliveroom.entity.ZegoPublishStreamParams;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoRoomMessage;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import com.zego.zegoliveroom.entity.ZegoUser;
import com.zego.zegoliveroom.entity.ZegoUserState;
import com.zego.zegoliveroom.utils.ZegoCommonUtils;
import com.zego.zegoliveroom.utils.zegoevent.ZegoEventManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoLiveRoom implements ZegoLiveRoomJNI.IJniZegoLiveRoomCallback, ZegoLiveRoomJNI.IJniZegoIMCallback {
    private static final int DEFAULT_LOG_FILE_COUNT = 3;
    private static final int DEFAULT_LOG_SIZE = 5242880;
    public static SDKContext mContext;
    private static IZegoLogHookCallback mZegoLogHookCallback;
    private static String sLogPath;
    private Map<Integer, IZegoCustomCommandCallback> mMapCustomCommandCallback;
    private Map<Integer, IZegoEndJoinLiveCallback> mMapEndJoinLiveResponseCallback;
    private Map<Object, Object> mMapIMCallback;
    private Map<Integer, IZegoResponseCallback> mMapInviteJoinLiveResponseCallback;
    private Map<Integer, IZegoResponseCallback> mMapJoinLiveResponseCallback;
    private Map<String, IZegoSnapshotCompletionCallback> mMapStreamSnapshotCompletionCallback;
    private Map<Integer, IZegoUpdatePublishTargetCallback> mMapUpdatePublishTargetCallback;
    private Map<String, IZegoLoginCompletionCallback> mMapZegoLoginCompletionCallback;
    private volatile IZegoRoomCallback mZegoRoomCallback = null;
    private volatile IZegoRunLoopObserveCallback mZegoRunLoopObserveCallback = null;
    private volatile IZegoLivePlayerCallback mZegoLivePlayerCallback = null;
    private volatile IZegoInitSDKCompletionCallback mZegoInitSDKCallback = null;
    private volatile IZegoLivePublisherCallback mZegoLivePublisherCallback = null;
    private volatile IZegoLivePublisherCallback2 mZegoLivePublisherCallback2 = null;
    private volatile IZegoLivePublisherExCallback mZegoLivePublisherExCallback = null;
    private volatile IZegoAudioRecordCallback mZegoAudioRecordCallback = null;
    private volatile IZegoAudioRecordCallback2 mZegoAudioRecordCallback2 = null;
    private volatile IZegoAudioPrepCallback2 mZegoAudioPrepCB = null;
    private volatile IZegoAudioProcCallback mZegoAudioProcCB = null;
    private volatile IZegoAudioPostpCallback mZegoAudioPostpCB = null;
    private volatile IZegoAudioAuxDataCallback mZegoAlignedAudioAuxDataCB = null;
    private volatile IZegoExperimentalAPICallback mZegoExperimentalAPICB = null;
    private volatile IZegoDeviceEventCallback mZegoDeviceEventCallback = null;
    private volatile IZegoLiveEventCallback mZegoLiveEventCallback = null;
    private volatile IZegoIMCallback mZegoIMCallback = null;
    private volatile IZegoAVEngineCallback mZegoAVEngineCallback = null;
    private volatile IZegoLogInfoCallback mZegoLogInfoCallback = null;
    private volatile IZegoAudioRouteCallback mZegoAudioRouteCallback = null;
    private volatile IZegoNetTypeCallback mZegoNetTypeCallback = null;
    private volatile IZegoRealtimeSequentialDataCallback mZegoRealtimeSequentialDataCallback = null;
    private volatile IZegoCheckAudioVADCallback mZegoCheckAudioVADCallback = null;
    private volatile IZegoSnapshotCompletionCallback mPreviewSnapshotCompletionCallback = null;
    private volatile IZegoSnapshotCompletionCallback2 mPreviewSnapshotCompletionCallback2 = null;
    private volatile IZegoDumpDataCallback mZegoDumpDataCallback = null;
    private Handler mUIHandler = new Handler(Looper.getMainLooper());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface SDKContext {
        Application getAppContext();

        String getLogPath();

        String getSoFullPath();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface SDKContextEx extends SDKContext {
        long getLogFileSize();

        IZegoLogHookCallback getLogHookCallback();

        String getSubLogFolder();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface SDKContextEx2 extends SDKContextEx {
        Uri getLogPathUri();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface SDKContextEx3 extends SDKContextEx {
        int getLogFileCount();
    }

    public ZegoLiveRoom() {
        this.mMapJoinLiveResponseCallback = null;
        this.mMapEndJoinLiveResponseCallback = null;
        this.mMapInviteJoinLiveResponseCallback = null;
        this.mMapZegoLoginCompletionCallback = null;
        this.mMapStreamSnapshotCompletionCallback = null;
        this.mMapIMCallback = null;
        this.mMapCustomCommandCallback = null;
        this.mMapUpdatePublishTargetCallback = null;
        this.mMapEndJoinLiveResponseCallback = new HashMap();
        this.mMapJoinLiveResponseCallback = new HashMap();
        this.mMapInviteJoinLiveResponseCallback = new HashMap();
        this.mMapZegoLoginCompletionCallback = new HashMap();
        this.mMapStreamSnapshotCompletionCallback = new HashMap();
        this.mMapIMCallback = new HashMap();
        this.mMapCustomCommandCallback = new HashMap();
        this.mMapUpdatePublishTargetCallback = new HashMap();
    }

    private static Uri _createFolder(Context context, Uri uri, String str) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, "vnd.android.document/directory", str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Uri _createSubFolder(Context context, Uri uri, String str) {
        if (str != null && !str.isEmpty()) {
            for (String str2 : str.split("/")) {
                if (uri == null) {
                    break;
                }
                if (!str2.isEmpty()) {
                    Uri _findFolder = _findFolder(context, uri, str2);
                    uri = _findFolder != null ? _findFolder : _createFolder(context, uri, str2);
                }
            }
        }
        return uri;
    }

    private static Uri _findFolder(Context context, Uri uri, String str) {
        Cursor query = context.getContentResolver().query(DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri)), new String[]{"document_id", "_display_name"}, null, null, null);
        Uri uri2 = null;
        if (query == null) {
            return null;
        }
        while (true) {
            if (!query.moveToNext()) {
                break;
            }
            if (query.getString(query.getColumnIndex("_display_name")).equalsIgnoreCase(str)) {
                uri2 = DocumentsContract.buildDocumentUriUsingTree(uri, query.getString(query.getColumnIndex("document_id")));
                break;
            }
        }
        query.close();
        return uri2;
    }

    private boolean _initSDKInner(long j10, byte[] bArr, Context context) {
        if (!ZegoSdkInfo.VERSION.equals(version())) {
            throw new RuntimeException("[ZEGO] The version of SDK jar and native shared library (.so) does not match!");
        }
        if (j10 == 0) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_initSDK] failed，appid is 0");
            return false;
        }
        if (bArr == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_initSDK] will use token");
        }
        if (ZegoCommonUtils.isDeviceInBlackList()) {
            ZegoLiveRoomJNI.setAudioDeviceMode(2);
            ZegoLiveRoomJNI.enableAEC(true);
            ZegoLiveRoomJNI.enableNoiseSuppress(true);
        }
        if (!ZegoLiveRoomJNI.initSDK((int) j10, bArr, context, ZegoLiveRoom.class.getClassLoader())) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_initSDK], init failed");
            return false;
        }
        ZegoLiveRoomJNI.setZegoLiveRoomCallback(this);
        ZegoLiveRoomJNI.setZegoIMCallback(this);
        ZegoEventManager.getInstance().onActiveEvent(ZegoEventManager.ZEGO_EVENT_ID_INITSDK);
        return true;
    }

    @Deprecated
    public static void _logPrint(int i10, String str, Object... objArr) {
        String format = String.format(str, objArr);
        if (i10 == 0) {
            ZegoLiveRoomJNI.logPrint(format);
            return;
        }
        if (1 == i10) {
            ZegoLiveRoomJNI.logPrintVerbose(format);
        } else if (2 == i10) {
            ZegoLiveRoomJNI.logPrint(format);
            ZegoLiveRoomJNI.logPrintVerbose(format);
        }
    }

    public static void enableCheckPoc(boolean z10) {
        ZegoLiveRoomJNI.enableCheckPoc(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ZegoUser[] getListOfLegalUser(ZegoUser[] zegoUserArr) {
        ZegoUser[] zegoUserArr2 = null;
        if (zegoUserArr != null && zegoUserArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (ZegoUser zegoUser : zegoUserArr) {
                if (zegoUser != null && !TextUtils.isEmpty(zegoUser.userID) && !TextUtils.isEmpty(zegoUser.userName)) {
                    arrayList.add(zegoUser);
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            zegoUserArr2 = new ZegoUser[size];
            for (int i10 = 0; i10 < size; i10++) {
                zegoUserArr2[i10] = (ZegoUser) arrayList.get(i10);
            }
        }
        return zegoUserArr2;
    }

    public static int getMaxPlayChannelCount() {
        return ZegoLiveRoomJNI.getMaxPlayChannelCount();
    }

    public static int getMaxPublishChannelCount() {
        return ZegoLiveRoomJNI.getMaxPublishChannelCount();
    }

    private void removeAllRoomCallback() {
        this.mMapEndJoinLiveResponseCallback.clear();
        this.mMapJoinLiveResponseCallback.clear();
        this.mMapInviteJoinLiveResponseCallback.clear();
        synchronized (this.mMapZegoLoginCompletionCallback) {
            this.mMapZegoLoginCompletionCallback.clear();
        }
        this.mMapStreamSnapshotCompletionCallback.clear();
        this.mPreviewSnapshotCompletionCallback = null;
        this.mPreviewSnapshotCompletionCallback2 = null;
        this.mMapIMCallback.clear();
        this.mMapCustomCommandCallback.clear();
        this.mMapUpdatePublishTargetCallback.clear();
    }

    private void removeRoomCallback(String str) {
        this.mMapZegoLoginCompletionCallback.remove(str);
    }

    public static boolean requireHardwareDecoder(boolean z10) {
        return ZegoLiveRoomJNI.requireHardwareDecoder(z10, null);
    }

    public static boolean requireHardwareEncoder(boolean z10) {
        return ZegoLiveRoomJNI.requireHardwareEncoder(z10);
    }

    private boolean setAppOrientationInner(int i10, int i11) {
        if (i10 >= 0 && i10 <= 3) {
            return ZegoLiveRoomJNI.setAppOrientation(i10, i11);
        }
        ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setAppOrientationInner] failed, orientation is illegal");
        return false;
    }

    public static boolean setAudioDevice(int i10, String str) {
        if (i10 == 0 || i10 == 1) {
            return ZegoLiveRoomJNI.setAudioDevice(i10, str);
        }
        String.format("deviceType: %d invalid when setAudioDevice", Integer.valueOf(i10));
        return false;
    }

    public static void setAudioDeviceMode(int i10) {
        if (ZegoCommonUtils.isDeviceInBlackList() && (1 == i10 || 4 == i10 || 5 == i10 || 8 == i10)) {
            ZegoLiveRoomJNI.setAudioDeviceMode(2);
        } else {
            ZegoLiveRoomJNI.setAudioDeviceMode(i10);
        }
    }

    public static void setBusinessType(int i10) {
        ZegoLiveRoomJNI.setBusinessType(i10);
    }

    public static void setConfig(String str) {
        ZegoLiveRoomJNI.setConfig(str);
    }

    public static boolean setDummyCaptureImagePath(String str, int i10) {
        ZegoLiveRoomJNI.setDummyCaptureImagePath(str, i10);
        return true;
    }

    public static boolean setGeoFence(int i10, List<Integer> list) {
        int[] iArr;
        if (list != null) {
            iArr = new int[list.size()];
            for (int i11 = 0; i11 < list.size(); i11++) {
                iArr[i11] = list.get(i11).intValue();
            }
        } else {
            iArr = null;
        }
        return ZegoLiveRoomJNI.setGeoFence(i10, iArr);
    }

    @Deprecated
    public static void setLogPath(String str) {
        sLogPath = str;
    }

    public static boolean setPlayQualityMonitorCycle(long j10) {
        return ZegoLiveRoomJNI.setPlayQualityMonitorCycle(j10);
    }

    public static boolean setPreviewWaterMarkRect(Rect rect) {
        return setPreviewWaterMarkRectInner(rect, 0);
    }

    private static boolean setPreviewWaterMarkRectInner(Rect rect, int i10) {
        if (rect == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setPreviewWaterMarkRectInner] failed, rect is null");
            return false;
        }
        ZegoLiveRoomJNI.setPreviewWaterMarkRect(rect.left, rect.top, rect.right, rect.bottom, i10);
        return true;
    }

    private void setPublishConfigInner(Map<String, Object> map, int i10) {
        if (map == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setPublishConfigInner] invalid params, config is null");
            return;
        }
        String str = (String) map.get("publish_custom_target");
        if (!TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.setPublishConfig(str, i10);
        } else {
            String str2 = (String) map.get(ZegoConstants.PublishConfig.PUBLISH_CUSTOM_TARGET);
            if (!TextUtils.isEmpty(str2)) {
                ZegoLiveRoomJNI.setPublishConfig(str2, i10);
            }
        }
        String str3 = (String) map.get("publish_cdn_target");
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        ZegoLiveRoomJNI.setCDNPublishTarget(str3, i10);
    }

    public static boolean setPublishQualityMonitorCycle(long j10) {
        return ZegoLiveRoomJNI.setPublishQualityMonitorCycle(j10);
    }

    public static boolean setPublishWaterMarkRect(Rect rect) {
        return setPublishWaterMarkRectInner(rect, 0);
    }

    private static boolean setPublishWaterMarkRectInner(Rect rect, int i10) {
        if (rect == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setPublishWaterMarkRectInner] failed, rect is null");
            return false;
        }
        ZegoLiveRoomJNI.setPublishWaterMarkRect(rect.left, rect.top, rect.right, rect.bottom, i10);
        return true;
    }

    public static boolean setRoomMode(int i10) {
        return ZegoLiveRoomJNI.setRoomMode(i10);
    }

    public static int setSDKContext(SDKContext sDKContext) {
        long j10;
        IZegoLogHookCallback iZegoLogHookCallback;
        String str;
        String str2;
        Uri logPathUri;
        mContext = sDKContext;
        Application appContext = sDKContext.getAppContext();
        if (appContext != null) {
            int ensureSoLoaded = ZegoLiveRoomJNI.ensureSoLoaded(appContext, sDKContext.getSoFullPath());
            if (ensureSoLoaded < 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("load zegoliveroom native library failed, errorCode: ");
                sb2.append(ensureSoLoaded);
            } else {
                String str3 = null;
                if (sDKContext instanceof SDKContextEx) {
                    SDKContextEx sDKContextEx = (SDKContextEx) sDKContext;
                    j10 = sDKContextEx.getLogFileSize();
                    str = sDKContextEx.getSubLogFolder();
                    iZegoLogHookCallback = sDKContextEx.getLogHookCallback();
                } else {
                    j10 = 5242880;
                    iZegoLogHookCallback = null;
                    str = null;
                }
                if (!(sDKContext instanceof SDKContextEx2) || (logPathUri = ((SDKContextEx2) sDKContext).getLogPathUri()) == null) {
                    str2 = str;
                } else {
                    Uri buildDocumentUriUsingTree = DocumentsContract.buildDocumentUriUsingTree(logPathUri, DocumentsContract.getTreeDocumentId(logPathUri));
                    if (str != null) {
                        buildDocumentUriUsingTree = _createSubFolder(appContext, buildDocumentUriUsingTree, str);
                    } else {
                        str3 = str;
                    }
                    String uri = buildDocumentUriUsingTree.toString();
                    str2 = str3;
                    str3 = uri;
                }
                int logFileCount = sDKContext instanceof SDKContextEx3 ? ((SDKContextEx3) sDKContext).getLogFileCount() : 3;
                if (str3 == null || str3.length() == 0) {
                    str3 = sDKContext.getLogPath();
                }
                String logPath = (str3 == null || str3.length() == 0) ? ZegoLogUtil.getLogPath(appContext) : str3;
                if (iZegoLogHookCallback != null) {
                    mZegoLogHookCallback = iZegoLogHookCallback;
                    ZegoLiveRoomJNI.setLogHook();
                }
                ZegoLiveRoomJNI.setLogPathAndSize(logPath, j10, str2, appContext, logFileCount);
            }
            if (ensureSoLoaded > 0) {
                ZegoLiveRoomJNI.logPrint("Java_ZegoLiveRoom_setSDKContext，reload zegoliveroom native library success with code: " + ensureSoLoaded);
            }
            return ensureSoLoaded;
        }
        throw new RuntimeException("[ZEGO] The app context should not be null!");
    }

    public static void setTestEnv(boolean z10) {
        ZegoLiveRoomJNI.setTestEnv(z10);
    }

    public static boolean setUser(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setUser] failed, userID is empty");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setUser] failed, userName is empty");
            return false;
        }
        return ZegoLiveRoomJNI.setUser(str, str2);
    }

    public static void setVerbose(boolean z10) {
        ZegoLiveRoomJNI.setVerbose(z10);
    }

    public static boolean setWaterMarkImagePath(String str) {
        return setWaterMarkImagePathInner(str, 0);
    }

    private static boolean setWaterMarkImagePathInner(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setWaterMarkImagePathInner] failed, imagePath is empty");
            return false;
        }
        ZegoLiveRoomJNI.setWaterMarkImagePath(str, i10);
        return true;
    }

    private boolean startPlayingStreamInner(String str, Object obj, ZegoStreamExtraPlayInfo zegoStreamExtraPlayInfo) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_startPlayingStreamInner] failed, streamID is empty");
            return false;
        }
        if (zegoStreamExtraPlayInfo != null && TextUtils.isEmpty(zegoStreamExtraPlayInfo.params)) {
            zegoStreamExtraPlayInfo.params = "";
        }
        return ZegoLiveRoomJNI.startPlayingStream(str, obj, zegoStreamExtraPlayInfo);
    }

    private boolean startPublishInner(String str, String str2, int i10) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        return ZegoLiveRoomJNI.startPublishing(str, str2, i10);
    }

    private boolean startPublishInner2(String str, String str2, int i10, int i11, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        if (TextUtils.isEmpty(str3) || ZegoLiveRoomJNI.updateStreamExtraInfo(str3, i11)) {
            return ZegoLiveRoomJNI.startPublishing2(str, str2, i10, i11, str4);
        }
        return false;
    }

    private boolean startPublishInner3(String str, String str2, int i10, int i11, int i12, int i13, String str3, String str4, String str5) {
        String str6 = TextUtils.isEmpty(str) ? "" : str;
        String str7 = TextUtils.isEmpty(str2) ? "" : str2;
        String str8 = TextUtils.isEmpty(str4) ? "" : str4;
        String str9 = TextUtils.isEmpty(str5) ? "" : str5;
        if (!TextUtils.isEmpty(str3) && !ZegoLiveRoomJNI.updateStreamExtraInfo(str3, i13)) {
            return false;
        }
        return ZegoLiveRoomJNI.startPublishing3(str6, str7, i10, i11, i12, i13, str8, str9);
    }

    private boolean updateStreamExtraInfoInner(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return ZegoLiveRoomJNI.updateStreamExtraInfo(str, i10);
    }

    public static void uploadLog() {
        ZegoLiveRoomJNI.uploadLog();
    }

    public static String version() {
        return ZegoLiveRoomJNI.version();
    }

    public static String version2() {
        return ZegoLiveRoomJNI.version2();
    }

    public int activateAllAudioPlayStream(boolean z10) {
        return ZegoLiveRoomJNI.activateAllAudioPlayStream(z10);
    }

    public int activateAllVideoPlayStream(boolean z10) {
        return ZegoLiveRoomJNI.activateAllVideoPlayStream(z10);
    }

    public int activateAudioPlayStream(String str, boolean z10) {
        return ZegoLiveRoomJNI.activateAudioPlayStream(str, z10);
    }

    public int activateVideoPlayStream(String str, boolean z10) {
        return ZegoLiveRoomJNI.activateVideoPlayStream(str, z10, -1);
    }

    public boolean addPublishTarget(String str, String str2, IZegoUpdatePublishTargetCallback iZegoUpdatePublishTargetCallback) {
        if (iZegoUpdatePublishTargetCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_addPublishTarget] failed, callback is null");
            return false;
        }
        int addPublishTarget = ZegoLiveRoomJNI.addPublishTarget(str, str2);
        if (addPublishTarget != -1) {
            if (this.mMapUpdatePublishTargetCallback.get(Integer.valueOf(addPublishTarget)) != null) {
                ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_addPublishTarget], unfinished add publish target, seq:" + addPublishTarget);
            }
            this.mMapUpdatePublishTargetCallback.put(Integer.valueOf(addPublishTarget), iZegoUpdatePublishTargetCallback);
            return true;
        }
        ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_addPublishTarget] failed, seq:" + addPublishTarget);
        return false;
    }

    public int callExperimentalAPI(String str) {
        return ZegoLiveRoomJNI.callExperimentalAPI(str);
    }

    public boolean deletePublishTarget(String str, String str2, IZegoUpdatePublishTargetCallback iZegoUpdatePublishTargetCallback) {
        if (iZegoUpdatePublishTargetCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_deletePublishTarget] failed, callback is null");
            return false;
        }
        int deletePublishTarget = ZegoLiveRoomJNI.deletePublishTarget(str, str2);
        if (deletePublishTarget != -1) {
            if (this.mMapUpdatePublishTargetCallback.get(Integer.valueOf(deletePublishTarget)) != null) {
                ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_deletePublishTarget], unfinished delete publish target, seq:" + deletePublishTarget);
            }
            this.mMapUpdatePublishTargetCallback.put(Integer.valueOf(deletePublishTarget), iZegoUpdatePublishTargetCallback);
            return true;
        }
        ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_deletePublishTarget] failed, seq:" + deletePublishTarget);
        return false;
    }

    public void enableAEC(boolean z10) {
        ZegoLiveRoomJNI.enableAEC(z10);
    }

    public void enableAECWhenHeadsetDetected(boolean z10) {
        ZegoLiveRoomJNI.enableAECWhenHeadsetDetected(z10);
    }

    public void enableAGC(boolean z10) {
        ZegoLiveRoomJNI.enableAGC(z10);
    }

    public void enableAlignedAudioAuxData(boolean z10, ZegoAudioAuxDataConfig zegoAudioAuxDataConfig) {
        ZegoLiveRoomJNI.enableAlignedAudioAuxData(z10, zegoAudioAuxDataConfig);
    }

    public void enableAlphaChannelVideoEncoder(boolean z10, int i10, int i11) {
        ZegoLiveRoomJNI.enableAlphaChannelVideoEncoder(z10, i10, i11);
    }

    public void enableAudioPostp(boolean z10, String str) {
        ZegoLiveRoomJNI.enableAudioPostp(z10, str);
    }

    public void enableAudioPrepVADStableStateMonitor(boolean z10) {
        ZegoLiveRoomJNI.enableAudioPrepVADStableStateMonitor(z10, 3000);
    }

    public boolean enableBeautifying(int i10) {
        return ZegoLiveRoomJNI.enableBeautifying(i10, 0);
    }

    public boolean enableCamera(boolean z10) {
        return ZegoLiveRoomJNI.enableCamera(z10, 0);
    }

    public boolean enableCaptureMirror(boolean z10) {
        return ZegoLiveRoomJNI.enableCaptureMirror(z10, 0);
    }

    public void enableCapturedAudioVADStableStateMonitor(boolean z10) {
        ZegoLiveRoomJNI.enableCapturedAudioVADStableStateMonitor(z10, 3000);
    }

    public void enableColorEnhancement(boolean z10, ZegoColorEnhancementParams zegoColorEnhancementParams, int i10) {
        ZegoLiveRoomJNI.enableColorEnhancement(z10, zegoColorEnhancementParams, i10);
    }

    public void enableDTX(boolean z10) {
        ZegoLiveRoomJNI.enableDTX(z10);
    }

    public boolean enableH265EncodeFallback(boolean z10) {
        return ZegoLiveRoomJNI.enableH265EncodeFallback(z10);
    }

    public boolean enableLoopback(boolean z10) {
        return ZegoLiveRoomJNI.enableLoopback(z10);
    }

    public boolean enableMic(boolean z10) {
        return ZegoLiveRoomJNI.enableMic(z10);
    }

    public boolean enableMicDevice(boolean z10) {
        return ZegoLiveRoomJNI.enableMicDevice(z10);
    }

    public boolean enableNoiseSuppress(boolean z10) {
        return ZegoLiveRoomJNI.enableNoiseSuppress(z10);
    }

    public boolean enablePlayVirtualStereo(boolean z10, int i10, String str) {
        return ZegoLiveRoomJNI.enablePlayVirtualStereo(z10, i10, str);
    }

    public boolean enablePreviewMirror(boolean z10) {
        return ZegoLiveRoomJNI.enablePreviewMirror(z10, 0);
    }

    @Deprecated
    public int enablePublishStreamAlignment(boolean z10) {
        return ZegoLiveRoomJNI.setStreamAlignmentProperty(z10 ? 1 : 0, -1);
    }

    public boolean enableRateControl(boolean z10) {
        return ZegoLiveRoomJNI.enableRateControl(z10, 0);
    }

    public void enableScreenCaptureEncodeOptimization(boolean z10, int i10) {
        ZegoLiveRoomJNI.enableScreenCaptureEncodeOptimization(z10, i10);
    }

    @Deprecated
    public boolean enableSelectedAudioRecord(int i10, int i11) {
        return ZegoLiveRoomJNI.enableSelectedAudioRecord(i10, i11, 1);
    }

    public boolean enableSpeaker(boolean z10) {
        return ZegoLiveRoomJNI.enableSpeaker(z10);
    }

    public boolean enableTorch(boolean z10) {
        return ZegoLiveRoomJNI.enableTorch(z10, 0);
    }

    public void enableTrafficControl(int i10, boolean z10) {
        ZegoLiveRoomJNI.enableTrafficControl(i10, z10, 0);
    }

    public boolean enableTransientNoiseSuppress(boolean z10) {
        return ZegoLiveRoomJNI.enableTransientNoiseSuppress(z10);
    }

    public void enableVAD(boolean z10) {
        ZegoLiveRoomJNI.enableVAD(z10);
    }

    public void enableVideoObjectSegmentation(boolean z10, int i10, int i11) {
        ZegoLiveRoomJNI.enableVideoObjectSegmentation(z10, i10, i11);
    }

    public void enableVideoSuperResolution(String str, boolean z10) {
        ZegoLiveRoomJNI.enableVideoSuperResolution(str, z10);
    }

    public boolean enableViewMirror(boolean z10, String str) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_enableViewMirror] failed, streamID is empty");
            return false;
        }
        return ZegoLiveRoomJNI.enableViewMirror(z10, str);
    }

    public boolean endJoinLive(String str, IZegoEndJoinLiveCallback iZegoEndJoinLiveCallback) {
        return endJoinLive(str, null, iZegoEndJoinLiveCallback);
    }

    public int getAudioRouteType() {
        return ZegoLiveRoomJNI.getAudioRouteType();
    }

    public float getCaptureSoundLevel() {
        return ZegoLiveRoomJNI.getCaptureSoundLevel();
    }

    public float getSoundLevelOfStream(String str) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_getSoundLevelOfStream] failed, streamID is empty");
            return 0.0f;
        }
        return ZegoLiveRoomJNI.getSoundLevelOfStream(str);
    }

    public ZegoUser getUserByStreamID(String str) {
        return ZegoLiveRoomJNI.getUserByStreamID(str);
    }

    public ZegoCodecCapabilityInfo[] getVideoCodecCapabilityList() {
        String videoCodecCapabilityList = ZegoLiveRoomJNI.getVideoCodecCapabilityList();
        if (videoCodecCapabilityList == null || videoCodecCapabilityList.length() == 0) {
            return new ZegoCodecCapabilityInfo[0];
        }
        String[] split = videoCodecCapabilityList.split(";");
        ZegoCodecCapabilityInfo[] zegoCodecCapabilityInfoArr = new ZegoCodecCapabilityInfo[split.length];
        for (int i10 = 0; i10 < split.length; i10++) {
            String[] split2 = split[i10].split(",");
            zegoCodecCapabilityInfoArr[i10] = new ZegoCodecCapabilityInfo();
            zegoCodecCapabilityInfoArr[i10].codecId = Integer.parseInt(split2[0]);
            zegoCodecCapabilityInfoArr[i10].isHardware = Integer.parseInt(split2[1]);
        }
        return zegoCodecCapabilityInfoArr;
    }

    @Deprecated
    public boolean initSDK(long j10, byte[] bArr, Context context) {
        SDKContext sDKContext;
        if (context == null && ((sDKContext = mContext) == null || sDKContext.getAppContext() == null)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_initSDK] failed, context is null");
            return false;
        }
        if (mContext == null) {
            String str = sLogPath;
            if (str == null || str.length() == 0) {
                str = ZegoLogUtil.getLogPath(context);
            }
            ZegoLiveRoomJNI.setLogPathAndSize(str, 5242880L, null, context, 3);
        }
        if (context == null) {
            context = mContext.getAppContext();
        }
        return _initSDKInner(j10, bArr, context);
    }

    public void initVideoSuperResolution() {
        ZegoLiveRoomJNI.initVideoSuperResolution();
    }

    public boolean inviteJoinLive(String str, IZegoResponseCallback iZegoResponseCallback) {
        return inviteJoinLive(str, null, iZegoResponseCallback);
    }

    public boolean isVideoDecoderSupported(int i10) {
        return ZegoLiveRoomJNI.isVideoDecoderSupported(i10, 0) != 0;
    }

    public boolean isVideoEncoderSupported(int i10) {
        return ZegoLiveRoomJNI.isVideoEncoderSupported(i10, 0) != 0;
    }

    public boolean loginRoom(String str, int i10, IZegoLoginCompletionCallback iZegoLoginCompletionCallback) {
        return loginRoom(str, "", i10, iZegoLoginCompletionCallback);
    }

    public boolean logoutRoom() {
        boolean logoutRoom = logoutRoom(null);
        if (logoutRoom) {
            removeAllRoomCallback();
        }
        return logoutRoom;
    }

    public int muteAudioPublish(boolean z10) {
        return muteAudioPublish(z10, 0);
    }

    public int muteVideoPublish(boolean z10) {
        return muteVideoPublish(z10, 0);
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onAVEngineStart() {
        final IZegoAVEngineCallback iZegoAVEngineCallback = this.mZegoAVEngineCallback;
        if (iZegoAVEngineCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.56
                @Override // java.lang.Runnable
                public void run() {
                    iZegoAVEngineCallback.onAVEngineStart();
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onAVEngineStop() {
        final IZegoAVEngineCallback iZegoAVEngineCallback = this.mZegoAVEngineCallback;
        if (iZegoAVEngineCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.57
                @Override // java.lang.Runnable
                public void run() {
                    iZegoAVEngineCallback.onAVEngineStop();
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onAlignedAudioAuxDataCallback(ZegoAudioFrame zegoAudioFrame, int i10) {
        IZegoAudioAuxDataCallback iZegoAudioAuxDataCallback = this.mZegoAlignedAudioAuxDataCB;
        if (iZegoAudioAuxDataCallback != null) {
            iZegoAudioAuxDataCallback.onAlignedAudioAuxDataCallback(zegoAudioFrame, i10);
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public ZegoAudioFrame onAudioPostp(ZegoAudioFrame zegoAudioFrame, String str) {
        IZegoAudioPostpCallback iZegoAudioPostpCallback = this.mZegoAudioPostpCB;
        return iZegoAudioPostpCallback != null ? iZegoAudioPostpCallback.onAudioPostp(zegoAudioFrame, str) : zegoAudioFrame;
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public ZegoAudioFrame onAudioPrep(ZegoAudioFrame zegoAudioFrame) {
        IZegoAudioPrepCallback2 iZegoAudioPrepCallback2 = this.mZegoAudioPrepCB;
        return iZegoAudioPrepCallback2 != null ? iZegoAudioPrepCallback2.onAudioPrep(zegoAudioFrame) : zegoAudioFrame;
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onAudioPrepVADStateUpdate(final int i10) {
        final IZegoCheckAudioVADCallback iZegoCheckAudioVADCallback = this.mZegoCheckAudioVADCallback;
        if (iZegoCheckAudioVADCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.76
                @Override // java.lang.Runnable
                public void run() {
                    iZegoCheckAudioVADCallback.onAudioPrepVADStateUpdate(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public ZegoAudioFrame onAudioProc(ZegoAudioFrame zegoAudioFrame) {
        IZegoAudioProcCallback iZegoAudioProcCallback = this.mZegoAudioProcCB;
        return iZegoAudioProcCallback != null ? iZegoAudioProcCallback.onAudioProc(zegoAudioFrame) : zegoAudioFrame;
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onAudioRecordCallback(final byte[] bArr, final int i10, final int i11, final int i12, final int i13) {
        final IZegoAudioRecordCallback2 iZegoAudioRecordCallback2 = this.mZegoAudioRecordCallback2;
        if (iZegoAudioRecordCallback2 != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.49
                @Override // java.lang.Runnable
                public void run() {
                    iZegoAudioRecordCallback2.onAudioRecordCallback(bArr, i10, i11, i12, i13);
                }
            });
            return;
        }
        final IZegoAudioRecordCallback iZegoAudioRecordCallback = this.mZegoAudioRecordCallback;
        if (iZegoAudioRecordCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.50
                @Override // java.lang.Runnable
                public void run() {
                    iZegoAudioRecordCallback.onAudioRecordCallback(bArr, i10, i11, i12);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onAudioRouteChange(final int i10) {
        final IZegoAudioRouteCallback iZegoAudioRouteCallback = this.mZegoAudioRouteCallback;
        if (iZegoAudioRouteCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.64
                @Override // java.lang.Runnable
                public void run() {
                    iZegoAudioRouteCallback.onAudioRouteChange(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onCaptureAudioFirstFrame() {
        final IZegoLivePublisherCallback iZegoLivePublisherCallback = this.mZegoLivePublisherCallback;
        if (iZegoLivePublisherCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.43
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback.onCaptureAudioFirstFrame();
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onCaptureVideoFirstFrame() {
        final IZegoLivePublisherCallback iZegoLivePublisherCallback = this.mZegoLivePublisherCallback;
        if (iZegoLivePublisherCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.38
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback.onCaptureVideoFirstFrame();
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onCaptureVideoSizeChanged(final int i10, final int i11) {
        final IZegoLivePublisherCallback iZegoLivePublisherCallback = this.mZegoLivePublisherCallback;
        if (iZegoLivePublisherCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.36
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback.onCaptureVideoSizeChangedTo(i10, i11);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onCapturedAudioVADStateUpdate(final int i10) {
        final IZegoCheckAudioVADCallback iZegoCheckAudioVADCallback = this.mZegoCheckAudioVADCallback;
        if (iZegoCheckAudioVADCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.75
                @Override // java.lang.Runnable
                public void run() {
                    iZegoCheckAudioVADCallback.onCapturedAudioVADStateUpdate(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onCustomCommand(final int i10, int i11, final String str) {
        final IZegoCustomCommandCallback iZegoCustomCommandCallback = this.mMapCustomCommandCallback.get(Integer.valueOf(i11));
        if (iZegoCustomCommandCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.52
                @Override // java.lang.Runnable
                public void run() {
                    iZegoCustomCommandCallback.onSendCustomCommand(i10, str);
                }
            });
            this.mMapCustomCommandCallback.remove(Integer.valueOf(i11));
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onDeviceError(final String str, final int i10) {
        final IZegoDeviceEventCallback iZegoDeviceEventCallback = this.mZegoDeviceEventCallback;
        if (iZegoDeviceEventCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.48
                @Override // java.lang.Runnable
                public void run() {
                    iZegoDeviceEventCallback.onDeviceError(str, i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onDisconnect(final int i10, final String str) {
        final IZegoRoomCallback iZegoRoomCallback = this.mZegoRoomCallback;
        if (iZegoRoomCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.7
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomCallback.onDisconnect(i10, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onEndJoinLive(final int i10, int i11, final String str) {
        final IZegoEndJoinLiveCallback remove = this.mMapEndJoinLiveResponseCallback.remove(Integer.valueOf(i11));
        if (remove != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.34
                @Override // java.lang.Runnable
                public void run() {
                    remove.onEndJoinLive(i10, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onExperimentalAPICallback(final String str) {
        final IZegoExperimentalAPICallback iZegoExperimentalAPICallback = this.mZegoExperimentalAPICB;
        if (iZegoExperimentalAPICallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.51
                @Override // java.lang.Runnable
                public void run() {
                    iZegoExperimentalAPICallback.onExperimentalAPICallback(str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onFatalError(final int i10) {
        final IZegoRoomCallback iZegoRoomCallback = this.mZegoRoomCallback;
        if (iZegoRoomCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.10
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomCallback.onFatalError(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onInitSDK(final int i10) {
        final IZegoInitSDKCompletionCallback iZegoInitSDKCompletionCallback = this.mZegoInitSDKCallback;
        if (iZegoInitSDKCompletionCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.1
                @Override // java.lang.Runnable
                public void run() {
                    iZegoInitSDKCompletionCallback.onInitSDK(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onInviteJoinLiveRequest(final int i10, final String str, final String str2, final String str3) {
        final IZegoLivePlayerCallback iZegoLivePlayerCallback = this.mZegoLivePlayerCallback;
        if (iZegoLivePlayerCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.19
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePlayerCallback.onInviteJoinLiveRequest(i10, str, str2, str3);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onInviteJoinLiveResponse(final int i10, final String str, final String str2, int i11) {
        final IZegoResponseCallback remove = this.mMapInviteJoinLiveResponseCallback.remove(Integer.valueOf(i11));
        if (remove != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.33
                @Override // java.lang.Runnable
                public void run() {
                    remove.onResponse(i10, str, str2);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onJoinLiveRequest(final int i10, final String str, final String str2, final String str3) {
        final IZegoLivePublisherCallback iZegoLivePublisherCallback = this.mZegoLivePublisherCallback;
        if (iZegoLivePublisherCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.32
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback.onJoinLiveRequest(i10, str, str2, str3);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onJoinLiveResponse(final int i10, final String str, final String str2, int i11) {
        final IZegoResponseCallback remove = this.mMapJoinLiveResponseCallback.remove(Integer.valueOf(i11));
        if (remove != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.18
                @Override // java.lang.Runnable
                public void run() {
                    remove.onResponse(i10, str, str2);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onKickOut(final int i10, final String str, final String str2) {
        final IZegoRoomCallback iZegoRoomCallback = this.mZegoRoomCallback;
        if (iZegoRoomCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.6
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomCallback.onKickOut(i10, str, str2);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onLiveEvent(final int i10, final HashMap<String, String> hashMap) {
        final IZegoLiveEventCallback iZegoLiveEventCallback = this.mZegoLiveEventCallback;
        if (iZegoLiveEventCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.46
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLiveEventCallback.onLiveEvent(i10, hashMap);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onLogHook(String str) {
        IZegoLogHookCallback iZegoLogHookCallback = mZegoLogHookCallback;
        if (iZegoLogHookCallback != null) {
            iZegoLogHookCallback.onLogHook(str);
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onLogUploadResult(final int i10) {
        final IZegoLogInfoCallback iZegoLogInfoCallback = this.mZegoLogInfoCallback;
        if (iZegoLogInfoCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.3
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLogInfoCallback.onLogUploadResult(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onLogWillOverwrite() {
        final IZegoLogInfoCallback iZegoLogInfoCallback = this.mZegoLogInfoCallback;
        if (iZegoLogInfoCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.2
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLogInfoCallback.onLogWillOverwrite();
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onLoginRoom(final int i10, String str, final ZegoStreamInfo[] zegoStreamInfoArr) {
        synchronized (this.mMapZegoLoginCompletionCallback) {
            final IZegoLoginCompletionCallback iZegoLoginCompletionCallback = this.mMapZegoLoginCompletionCallback.get(str);
            this.mMapZegoLoginCompletionCallback.remove(str);
            if (iZegoLoginCompletionCallback != null) {
                this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.5
                    @Override // java.lang.Runnable
                    public void run() {
                        iZegoLoginCompletionCallback.onLoginCompletion(i10, zegoStreamInfoArr);
                    }
                });
            }
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onNetTypeChange(final int i10) {
        final IZegoNetTypeCallback iZegoNetTypeCallback = this.mZegoNetTypeCallback;
        if (iZegoNetTypeCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.65
                @Override // java.lang.Runnable
                public void run() {
                    iZegoNetTypeCallback.onNetTypeChange(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onNetworkQuality(final String str, final int i10, final int i11) {
        final IZegoRoomCallback iZegoRoomCallback = this.mZegoRoomCallback;
        if (iZegoRoomCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.54
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomCallback.onNetworkQuality(str, i10, i11);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onPlayQualityUpdate(final String str, final ZegoPlayStreamQuality zegoPlayStreamQuality) {
        final IZegoLivePlayerCallback iZegoLivePlayerCallback = this.mZegoLivePlayerCallback;
        if (iZegoLivePlayerCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.15
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePlayerCallback.onPlayQualityUpdate(str, zegoPlayStreamQuality);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onPlayStateUpdate(final int i10, final String str) {
        final IZegoLivePlayerCallback iZegoLivePlayerCallback = this.mZegoLivePlayerCallback;
        if (iZegoLivePlayerCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.14
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePlayerCallback.onPlayStateUpdate(i10, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onPlayStatsUpdate(final ZegoPlayStats zegoPlayStats) {
        final IZegoLivePlayerCallback2 iZegoLivePlayerCallback2;
        if (!(this.mZegoLivePlayerCallback instanceof IZegoLivePlayerCallback2) || (iZegoLivePlayerCallback2 = (IZegoLivePlayerCallback2) this.mZegoLivePlayerCallback) == null) {
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.16
            @Override // java.lang.Runnable
            public void run() {
                iZegoLivePlayerCallback2.onPlayStatsUpdate(zegoPlayStats);
            }
        });
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onPlayVideoSuperResolutionUpdate(final String str, final int i10, final int i11) {
        final IZegoLivePlayerCallback2 iZegoLivePlayerCallback2;
        if (!(this.mZegoLivePlayerCallback instanceof IZegoLivePlayerCallback2) || (iZegoLivePlayerCallback2 = (IZegoLivePlayerCallback2) this.mZegoLivePlayerCallback) == null) {
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.17
            @Override // java.lang.Runnable
            public void run() {
                iZegoLivePlayerCallback2.onPlayVideoSuperResolutionUpdate(str, i10, i11);
            }
        });
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onPreviewSnapshot(final Bitmap bitmap) {
        final IZegoSnapshotCompletionCallback iZegoSnapshotCompletionCallback = this.mPreviewSnapshotCompletionCallback;
        if (iZegoSnapshotCompletionCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.44
                @Override // java.lang.Runnable
                public void run() {
                    iZegoSnapshotCompletionCallback.onZegoSnapshotCompletion(bitmap);
                }
            });
            this.mPreviewSnapshotCompletionCallback = null;
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onPreviewVideoFirstFrame(final int i10) {
        final IZegoLivePublisherCallback2 iZegoLivePublisherCallback2 = this.mZegoLivePublisherCallback2;
        if (iZegoLivePublisherCallback2 != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.40
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback2.onPreviewVideoFirstFrame(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onPublishQulityUpdate(final String str, final ZegoPublishStreamQuality zegoPublishStreamQuality) {
        final IZegoLivePublisherCallback iZegoLivePublisherCallback = this.mZegoLivePublisherCallback;
        if (iZegoLivePublisherCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.35
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback.onPublishQualityUpdate(str, zegoPublishStreamQuality);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onPublishStateUpdate(final int i10, final String str, final HashMap<String, Object> hashMap) {
        final IZegoLivePublisherCallback iZegoLivePublisherCallback = this.mZegoLivePublisherCallback;
        if (iZegoLivePublisherCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.29
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback.onPublishStateUpdate(i10, str, hashMap);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onReconnect(final int i10, final String str) {
        final IZegoRoomCallback iZegoRoomCallback = this.mZegoRoomCallback;
        if (iZegoRoomCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.8
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomCallback.onReconnect(i10, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoIMCallback
    public void onRecvBigRoomMessage(final String str, final ZegoBigRoomMessage[] zegoBigRoomMessageArr) {
        final IZegoIMCallback iZegoIMCallback = this.mZegoIMCallback;
        if (iZegoIMCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.63
                @Override // java.lang.Runnable
                public void run() {
                    iZegoIMCallback.onRecvBigRoomMessage(str, zegoBigRoomMessageArr);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRecvCustomCommand(final String str, final String str2, final String str3, final String str4) {
        final IZegoRoomCallback iZegoRoomCallback = this.mZegoRoomCallback;
        if (iZegoRoomCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.53
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomCallback.onRecvCustomCommand(str, str2, str3, str4);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRecvEndJoinLiveCommand(final String str, final String str2, final String str3) {
        final IZegoLivePlayerCallback iZegoLivePlayerCallback = this.mZegoLivePlayerCallback;
        if (iZegoLivePlayerCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.20
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePlayerCallback.onRecvEndJoinLiveCommand(str, str2, str3);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRecvRealtimeSequentialData(ByteBuffer byteBuffer, String str) {
        IZegoRealtimeSequentialDataCallback iZegoRealtimeSequentialDataCallback = this.mZegoRealtimeSequentialDataCallback;
        if (iZegoRealtimeSequentialDataCallback != null) {
            iZegoRealtimeSequentialDataCallback.onRecvRealtimeSequentialData(byteBuffer, str);
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRecvRemoteAudioFirstFrame(final String str) {
        final IZegoLivePlayerCallback2 iZegoLivePlayerCallback2;
        if (!(this.mZegoLivePlayerCallback instanceof IZegoLivePlayerCallback2) || (iZegoLivePlayerCallback2 = (IZegoLivePlayerCallback2) this.mZegoLivePlayerCallback) == null) {
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.25
            @Override // java.lang.Runnable
            public void run() {
                iZegoLivePlayerCallback2.onRecvRemoteAudioFirstFrame(str);
            }
        });
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRecvRemoteVideoFirstFrame(final String str) {
        final IZegoLivePlayerCallback2 iZegoLivePlayerCallback2;
        if (!(this.mZegoLivePlayerCallback instanceof IZegoLivePlayerCallback2) || (iZegoLivePlayerCallback2 = (IZegoLivePlayerCallback2) this.mZegoLivePlayerCallback) == null) {
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.26
            @Override // java.lang.Runnable
            public void run() {
                iZegoLivePlayerCallback2.onRecvRemoteVideoFirstFrame(str);
            }
        });
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoIMCallback
    public void onRecvRoomMessage(final String str, final ZegoRoomMessage[] zegoRoomMessageArr) {
        final IZegoIMCallback iZegoIMCallback = this.mZegoIMCallback;
        if (iZegoIMCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.62
                @Override // java.lang.Runnable
                public void run() {
                    iZegoIMCallback.onRecvRoomMessage(str, zegoRoomMessageArr);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRelayCDNStateUpdate(final ZegoStreamRelayCDNInfo[] zegoStreamRelayCDNInfoArr, final String str) {
        final IZegoLivePublisherExCallback iZegoLivePublisherExCallback = this.mZegoLivePublisherExCallback;
        if (iZegoLivePublisherExCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.30
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherExCallback.onRelayCDNStateUpdate(zegoStreamRelayCDNInfoArr, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRemoteCameraStatusUpdate(final String str, final int i10, final int i11) {
        final IZegoLivePlayerCallback2 iZegoLivePlayerCallback2;
        if (!(this.mZegoLivePlayerCallback instanceof IZegoLivePlayerCallback2) || (iZegoLivePlayerCallback2 = (IZegoLivePlayerCallback2) this.mZegoLivePlayerCallback) == null) {
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.22
            @Override // java.lang.Runnable
            public void run() {
                iZegoLivePlayerCallback2.onRemoteCameraStatusUpdate(str, i10, i11);
            }
        });
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRemoteMicStatusUpdate(final String str, final int i10, final int i11) {
        final IZegoLivePlayerCallback2 iZegoLivePlayerCallback2;
        if (!(this.mZegoLivePlayerCallback instanceof IZegoLivePlayerCallback2) || (iZegoLivePlayerCallback2 = (IZegoLivePlayerCallback2) this.mZegoLivePlayerCallback) == null) {
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.23
            @Override // java.lang.Runnable
            public void run() {
                iZegoLivePlayerCallback2.onRemoteMicStatusUpdate(str, i10, i11);
            }
        });
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRemoteSpeakerStatusUpdate(final String str, final int i10, final int i11) {
        final IZegoLivePlayerCallback2 iZegoLivePlayerCallback2;
        if (!(this.mZegoLivePlayerCallback instanceof IZegoLivePlayerCallback2) || (iZegoLivePlayerCallback2 = (IZegoLivePlayerCallback2) this.mZegoLivePlayerCallback) == null) {
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.24
            @Override // java.lang.Runnable
            public void run() {
                iZegoLivePlayerCallback2.onRemoteSpeakerStatusUpdate(str, i10, i11);
            }
        });
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRenderRemoteVideoFirstFrame(final String str) {
        final IZegoLivePlayerCallback2 iZegoLivePlayerCallback2;
        if (!(this.mZegoLivePlayerCallback instanceof IZegoLivePlayerCallback2) || (iZegoLivePlayerCallback2 = (IZegoLivePlayerCallback2) this.mZegoLivePlayerCallback) == null) {
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.27
            @Override // java.lang.Runnable
            public void run() {
                iZegoLivePlayerCallback2.onRenderRemoteVideoFirstFrame(str);
            }
        });
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRequestDumpData() {
        final IZegoDumpDataCallback iZegoDumpDataCallback = this.mZegoDumpDataCallback;
        if (iZegoDumpDataCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.66
                @Override // java.lang.Runnable
                public void run() {
                    iZegoDumpDataCallback.onRequestDumpData();
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRequestUploadDumpData(final String str, final boolean z10) {
        final IZegoDumpDataCallback iZegoDumpDataCallback = this.mZegoDumpDataCallback;
        if (iZegoDumpDataCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.67
                @Override // java.lang.Runnable
                public void run() {
                    iZegoDumpDataCallback.onRequestUploadDumpData(str, z10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRoomInfoUpdated(final ZegoRoomInfo zegoRoomInfo, final String str) {
        final IZegoRoomCallback iZegoRoomCallback = this.mZegoRoomCallback;
        if (iZegoRoomCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.11
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomCallback.onRoomInfoUpdated(zegoRoomInfo, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onRunLoopObserveCallback(final long j10, final int i10, final int i11, final int i12, final int i13) {
        final IZegoRunLoopObserveCallback iZegoRunLoopObserveCallback = this.mZegoRunLoopObserveCallback;
        if (iZegoRunLoopObserveCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.4
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRunLoopObserveCallback.onRunLoopObserveCallback(j10, i10, i11, i12, i13);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoIMCallback
    public void onSendBigRoomMessage(final int i10, final String str, int i11, final String str2) {
        final IZegoBigRoomMessageCallback iZegoBigRoomMessageCallback = (IZegoBigRoomMessageCallback) this.mMapIMCallback.get(Integer.valueOf(i11));
        if (iZegoBigRoomMessageCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.61
                @Override // java.lang.Runnable
                public void run() {
                    iZegoBigRoomMessageCallback.onSendBigRoomMessage(i10, str, str2);
                }
            });
            this.mMapIMCallback.remove(Integer.valueOf(i11));
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onSendLocalAudioFirstFrame(final int i10) {
        final IZegoLivePublisherCallback2 iZegoLivePublisherCallback2 = this.mZegoLivePublisherCallback2;
        if (iZegoLivePublisherCallback2 != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.41
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback2.onSendLocalAudioFirstFrame(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onSendLocalVideoFirstFrame(final int i10) {
        final IZegoLivePublisherCallback2 iZegoLivePublisherCallback2 = this.mZegoLivePublisherCallback2;
        if (iZegoLivePublisherCallback2 != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.42
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback2.onSendLocalVideoFirstFrame(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onSendRealtimeSequentialData(final int i10, final int i11) {
        final IZegoRealtimeSequentialDataCallback iZegoRealtimeSequentialDataCallback = this.mZegoRealtimeSequentialDataCallback;
        if (iZegoRealtimeSequentialDataCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.71
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRealtimeSequentialDataCallback.onSendRealtimeSequentialData(i10, i11);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoIMCallback
    public void onSendRoomMessage(final int i10, final String str, int i11, final long j10) {
        final IZegoRoomMessageCallback iZegoRoomMessageCallback = (IZegoRoomMessageCallback) this.mMapIMCallback.get(Integer.valueOf(i11));
        if (iZegoRoomMessageCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.60
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomMessageCallback.onSendRoomMessage(i10, str, j10);
                }
            });
            this.mMapIMCallback.remove(Integer.valueOf(i11));
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onSnapshot(final Bitmap bitmap, String str) {
        final IZegoSnapshotCompletionCallback iZegoSnapshotCompletionCallback = this.mMapStreamSnapshotCompletionCallback.get(str);
        if (iZegoSnapshotCompletionCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.28
                @Override // java.lang.Runnable
                public void run() {
                    iZegoSnapshotCompletionCallback.onZegoSnapshotCompletion(bitmap);
                }
            });
            this.mMapStreamSnapshotCompletionCallback.remove(str);
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onStartDumpData(final int i10) {
        final IZegoDumpDataCallback iZegoDumpDataCallback = this.mZegoDumpDataCallback;
        if (iZegoDumpDataCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.68
                @Override // java.lang.Runnable
                public void run() {
                    iZegoDumpDataCallback.onStartDumpData(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onStopDumpData(final int i10, final String str) {
        final IZegoDumpDataCallback iZegoDumpDataCallback = this.mZegoDumpDataCallback;
        if (iZegoDumpDataCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.69
                @Override // java.lang.Runnable
                public void run() {
                    iZegoDumpDataCallback.onStopDumpData(i10, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onStreamEvent(final int i10, final String str, final HashMap<String, String> hashMap) {
        final IZegoLiveEventCallback iZegoLiveEventCallback = this.mZegoLiveEventCallback;
        if (iZegoLiveEventCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.47
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLiveEventCallback.onStreamEvent(i10, str, hashMap);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onStreamExtraInfoUpdated(final ZegoStreamInfo[] zegoStreamInfoArr, final String str) {
        final IZegoRoomCallback iZegoRoomCallback = this.mZegoRoomCallback;
        if (iZegoRoomCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.13
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomCallback.onStreamExtraInfoUpdated(zegoStreamInfoArr, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onStreamUpdated(final int i10, final ZegoStreamInfo[] zegoStreamInfoArr, final String str) {
        final IZegoRoomCallback iZegoRoomCallback = this.mZegoRoomCallback;
        if (iZegoRoomCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.12
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomCallback.onStreamUpdated(i10, zegoStreamInfoArr, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onTempBroken(final int i10, final String str) {
        final IZegoRoomCallback iZegoRoomCallback = this.mZegoRoomCallback;
        if (iZegoRoomCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.9
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomCallback.onTempBroken(i10, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onTokenWillExpired(final String str, final int i10) {
        final IZegoRoomCallback iZegoRoomCallback = this.mZegoRoomCallback;
        if (iZegoRoomCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.55
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomCallback.onTokenWillExpired(str, i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoIMCallback
    public void onUpdateOnlineCount(final String str, final int i10) {
        final IZegoIMCallback iZegoIMCallback = this.mZegoIMCallback;
        if (iZegoIMCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.59
                @Override // java.lang.Runnable
                public void run() {
                    iZegoIMCallback.onUpdateOnlineCount(str, i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onUpdatePublishTargetState(final int i10, final String str, int i11) {
        final IZegoUpdatePublishTargetCallback remove = this.mMapUpdatePublishTargetCallback.remove(Integer.valueOf(i11));
        if (remove != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.31
                @Override // java.lang.Runnable
                public void run() {
                    remove.onUpdatePublishTargetState(i10, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onUploadDumpData(final int i10) {
        final IZegoDumpDataCallback iZegoDumpDataCallback = this.mZegoDumpDataCallback;
        if (iZegoDumpDataCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.70
                @Override // java.lang.Runnable
                public void run() {
                    iZegoDumpDataCallback.onUploadDumpData(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoIMCallback
    public void onUserUpdate(final ZegoUserState[] zegoUserStateArr, final int i10, final String str) {
        final IZegoIMCallback iZegoIMCallback = this.mZegoIMCallback;
        if (iZegoIMCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.58
                @Override // java.lang.Runnable
                public void run() {
                    iZegoIMCallback.onUserUpdate(zegoUserStateArr, i10, str);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onVideoDecoderError(final int i10, final int i11, final String str) {
        final IZegoLivePlayerCallback2 iZegoLivePlayerCallback2;
        if (!(this.mZegoLivePlayerCallback instanceof IZegoLivePlayerCallback2) || (iZegoLivePlayerCallback2 = (IZegoLivePlayerCallback2) this.mZegoLivePlayerCallback) == null) {
            return;
        }
        this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.73
            @Override // java.lang.Runnable
            public void run() {
                iZegoLivePlayerCallback2.onVideoDecoderError(i10, i11, str);
            }
        });
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onVideoEncoderChanged(final int i10, final int i11, final int i12) {
        final IZegoLivePublisherCallback2 iZegoLivePublisherCallback2 = this.mZegoLivePublisherCallback2;
        if (iZegoLivePublisherCallback2 != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.74
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback2.onVideoEncoderChanged(i10, i11, i12);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onVideoEncoderError(final int i10, final int i11, final int i12) {
        final IZegoLivePublisherCallback2 iZegoLivePublisherCallback2 = this.mZegoLivePublisherCallback2;
        if (iZegoLivePublisherCallback2 != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.72
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback2.onVideoEncoderError(i10, i11, i12);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onVideoObjectSegmentationStateChanged(final int i10, final int i11, final int i12) {
        final IZegoLivePublisherCallback2 iZegoLivePublisherCallback2 = this.mZegoLivePublisherCallback2;
        if (iZegoLivePublisherCallback2 != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.77
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback2.onVideoObjectSegmentationStateChanged(i10, i11, i12);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onVideoSizeChanged(final String str, final int i10, final int i11) {
        final IZegoLivePlayerCallback iZegoLivePlayerCallback = this.mZegoLivePlayerCallback;
        if (iZegoLivePlayerCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.21
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePlayerCallback.onVideoSizeChangedTo(str, i10, i11);
                }
            });
        }
    }

    public void pauseModule(int i10) {
        ZegoLiveRoomJNI.pauseModule(i10);
    }

    public void removeDumpData() {
        ZegoLiveRoomJNI.removeDumpData();
    }

    public boolean requestJoinLive(IZegoResponseCallback iZegoResponseCallback) {
        return requestJoinLive(null, iZegoResponseCallback);
    }

    public boolean requireHardwareDecoderByStream(boolean z10, String str) {
        return ZegoLiveRoomJNI.requireHardwareDecoder(z10, str);
    }

    public boolean requireHardwareEncoderByChannel(boolean z10, int i10) {
        return ZegoLiveRoomJNI.requireHardwareEncoderByChannel(z10, i10);
    }

    public boolean respondInviteJoinLiveReq(int i10, int i11) {
        return respondInviteJoinLiveReq(i10, i11, null);
    }

    public boolean respondJoinLiveReq(int i10, int i11) {
        return respondJoinLiveReq(i10, i11, null);
    }

    public void resumeModule(int i10) {
        ZegoLiveRoomJNI.resumeModule(i10);
    }

    public boolean sendBigRoomMessage(int i10, int i11, String str, IZegoBigRoomMessageCallback iZegoBigRoomMessageCallback) {
        return sendBigRoomMessage(i10, i11, str, null, iZegoBigRoomMessageCallback);
    }

    public boolean sendCustomCommand(ZegoUser[] zegoUserArr, String str, IZegoCustomCommandCallback iZegoCustomCommandCallback) {
        return sendCustomCommand(zegoUserArr, str, null, iZegoCustomCommandCallback);
    }

    public int sendRealtimeSequentialData(ByteBuffer byteBuffer, int i10) {
        return ZegoLiveRoomJNI.sendRealtimeSequentialData(byteBuffer, byteBuffer.limit(), i10);
    }

    public boolean sendRoomMessage(int i10, int i11, String str, IZegoRoomMessageCallback iZegoRoomMessageCallback) {
        return sendRoomMessage(i10, i11, str, null, iZegoRoomMessageCallback);
    }

    public void setAECMode(int i10) {
        ZegoLiveRoomJNI.setAECMode(i10);
    }

    public boolean setAVConfig(ZegoAvConfig zegoAvConfig) {
        return setAVConfigInner(zegoAvConfig, 0);
    }

    public boolean setAVConfigInner(ZegoAvConfig zegoAvConfig, int i10) {
        if (zegoAvConfig == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setAVConfigInner] failed, config is null");
            return false;
        }
        return ZegoLiveRoomJNI.setVideoCaptureResolution(zegoAvConfig.getVideoCaptureResolutionWidth(), zegoAvConfig.getVideoCaptureResolutionHeight(), i10) & ZegoLiveRoomJNI.setVideoFPS(zegoAvConfig.getVideoFPS(), i10) & true & ZegoLiveRoomJNI.setVideoBitrate(zegoAvConfig.getVideoBitrate(), i10) & ZegoLiveRoomJNI.setVideoEncodeResolution(zegoAvConfig.getVideoEncodeResolutionWidth(), zegoAvConfig.getVideoEncodeResolutionHeight(), i10);
    }

    public void setAlignedAudioAuxDataCallback(IZegoAudioAuxDataCallback iZegoAudioAuxDataCallback) {
        this.mZegoAlignedAudioAuxDataCB = iZegoAudioAuxDataCallback;
        ZegoLiveRoomJNI.setAlignedAudioAuxDataCallback(iZegoAudioAuxDataCallback != null);
    }

    public boolean setAppOrientation(int i10) {
        return setAppOrientationInner(i10, 0);
    }

    public boolean setAppOrientationMode(int i10) {
        return ZegoLiveRoomJNI.setAppOrientationMode(i10);
    }

    public boolean setAudioBitrate(int i10) {
        return ZegoLiveRoomJNI.setAudioBitrate(i10, 0);
    }

    public void setAudioCaptureShiftOnMix(int i10) {
        ZegoLiveRoomJNI.setAudioCaptureShiftOnMix(i10);
    }

    public void setAudioChannelCount(int i10) {
        ZegoLiveRoomJNI.setAudioChannelCount(i10);
    }

    public void setAudioChannelCountByChannel(int i10, int i11) {
        ZegoLiveRoomJNI.setAudioChannelCountByChannel(i10, i11);
    }

    @Deprecated
    public boolean setAudioEqualizerGain(int i10, float f10) {
        try {
            return ((Boolean) ZegoAudioProcessing.class.getMethod("setAudioEqualizerGain", Integer.TYPE, Float.TYPE).invoke(null, Integer.valueOf(i10), Float.valueOf(f10))).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean setAudioMixMode(int i10, List<String> list) {
        return ZegoLiveRoomJNI.setAudioMixMode(i10, list);
    }

    public void setAudioPostpCallback(IZegoAudioPostpCallback iZegoAudioPostpCallback, ZegoExtPrepSet zegoExtPrepSet) {
        this.mZegoAudioPostpCB = iZegoAudioPostpCallback;
        ZegoLiveRoomJNI.setAudioPostpCallback(iZegoAudioPostpCallback != null, zegoExtPrepSet);
    }

    public void setAudioPrepAfterLoopbackCallback(IZegoAudioProcCallback iZegoAudioProcCallback, ZegoExtPrepSet zegoExtPrepSet) {
        this.mZegoAudioProcCB = iZegoAudioProcCallback;
        ZegoLiveRoomJNI.setAudioPrepAfterLoopbackCallback(iZegoAudioProcCallback != null, zegoExtPrepSet);
    }

    public void setAudioPrepCallback(IZegoAudioPrepCallback2 iZegoAudioPrepCallback2, ZegoExtPrepSet zegoExtPrepSet) {
        this.mZegoAudioPrepCB = iZegoAudioPrepCallback2;
        ZegoLiveRoomJNI.setAudioPrepCallback(iZegoAudioPrepCallback2 != null, zegoExtPrepSet);
    }

    public boolean setAudioSource(int i10, int i11) {
        return ZegoLiveRoomJNI.setAudioSource(i10, i11);
    }

    public void setAudioVADStableStateCallback(IZegoCheckAudioVADCallback iZegoCheckAudioVADCallback) {
        this.mZegoCheckAudioVADCallback = iZegoCheckAudioVADCallback;
        ZegoLiveRoomJNI.enableAudioVADStableStateCallback(iZegoCheckAudioVADCallback != null);
    }

    public boolean setBuiltInSpeakerOn(boolean z10) {
        return ZegoLiveRoomJNI.setBuiltInSpeakerOn(z10);
    }

    public boolean setCaptureFrameRotation(int i10, int i11) {
        return ZegoLiveRoomJNI.setCaptureFrameRotation(i10, i11);
    }

    public void setCapturePipelineScaleMode(int i10) {
        ZegoLiveRoomJNI.setCapturePipelineScaleMode(i10);
    }

    public void setCaptureVolume(int i10) {
        ZegoLiveRoomJNI.setCaptureVolume(i10);
    }

    public void setChannelExtraParam(String str, int i10) {
        ZegoLiveRoomJNI.setChannelExtraParam(str, i10);
    }

    public void setCloudProxyConfig(ArrayList<ZegoProxyInfo> arrayList, String str, boolean z10) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        ZegoLiveRoomJNI.setCloudProxyConfig((ZegoProxyInfo[]) arrayList.toArray(new ZegoProxyInfo[arrayList.size()]), str, z10);
    }

    public boolean setCustomCDNPublishTarget(ZegoCDNPublishTarget zegoCDNPublishTarget, int i10) {
        if (zegoCDNPublishTarget == null) {
            return ZegoLiveRoomJNI.setCustomCDNPublishTarget(null, null, null, i10);
        }
        return ZegoLiveRoomJNI.setCustomCDNPublishTarget(zegoCDNPublishTarget.url, zegoCDNPublishTarget.protocols, zegoCDNPublishTarget.quicVersions, i10);
    }

    @Deprecated
    public boolean setCustomToken(String str) {
        return ZegoLiveRoomJNI.setCustomToken(str);
    }

    public void setDumpDataCallback(IZegoDumpDataCallback iZegoDumpDataCallback) {
        this.mZegoDumpDataCallback = iZegoDumpDataCallback;
        ZegoLiveRoomJNI.enableDumpDataCallback(iZegoDumpDataCallback != null);
    }

    public void setExperimentalAPICallback(IZegoExperimentalAPICallback iZegoExperimentalAPICallback) {
        this.mZegoExperimentalAPICB = iZegoExperimentalAPICallback;
        ZegoLiveRoomJNI.setExperimentalAPICallback(iZegoExperimentalAPICallback != null);
    }

    public boolean setFilter(int i10) {
        return ZegoLiveRoomJNI.setFilter(i10, 0);
    }

    public boolean setFrontCam(boolean z10) {
        return ZegoLiveRoomJNI.setFrontCam(z10, 0);
    }

    public void setLatencyMode(int i10) {
        ZegoLiveRoomJNI.setLatencyMode(i10);
    }

    public void setLatencyModeByChannel(int i10, int i11) {
        ZegoLiveRoomJNI.setLatencyModeByChannel(i10, i11);
    }

    public void setLocalProxyConfig(ArrayList<ZegoProxyInfo> arrayList, boolean z10) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        ZegoLiveRoomJNI.setLocalProxyConfig((ZegoProxyInfo[]) arrayList.toArray(new ZegoProxyInfo[arrayList.size()]), z10);
    }

    public void setLoopbackVolume(int i10) {
        ZegoLiveRoomJNI.setLoopbackVolume(i10);
    }

    public boolean setLowlightEnhancement(int i10, int i11) {
        return ZegoLiveRoomJNI.setLowlightEnhancement(i10, i11);
    }

    public void setMinVideoBitrateForTrafficControl(int i10, int i11) {
        ZegoLiveRoomJNI.setMinVideoBitrateForTrafficControl(i10, i11, 0);
    }

    public void setMinVideoFpsForTrafficControl(int i10, int i11) {
        ZegoLiveRoomJNI.setMinVideoFpsForTrafficControl(i10, i11);
    }

    public void setMinVideoResolutionForTrafficControl(int i10, int i11, int i12) {
        ZegoLiveRoomJNI.setMinVideoResolutionForTrafficControl(i10, i11, i12);
    }

    public boolean setNoiseSuppressMode(int i10) {
        return ZegoLiveRoomJNI.setNoiseSuppressMode(i10);
    }

    public boolean setPlayStreamFocus(String str) {
        return ZegoLiveRoomJNI.setPlayStreamFocus(str);
    }

    public int setPlayStreamsAlignmentProperty(int i10) {
        return ZegoLiveRoomJNI.setPlayStreamsAlignmentProperty(i10);
    }

    public boolean setPlayVolume(int i10) {
        return ZegoLiveRoomJNI.setPlayVolume(i10);
    }

    public boolean setPolishFactor(float f10) {
        return ZegoLiveRoomJNI.setPolishFactor(f10, 0);
    }

    public boolean setPolishStep(float f10) {
        return ZegoLiveRoomJNI.setPolishStep(f10, 0);
    }

    public boolean setPreviewRotation(int i10) {
        return ZegoLiveRoomJNI.setPreviewRotation(i10, 0);
    }

    public boolean setPreviewView(Object obj) {
        return ZegoLiveRoomJNI.setPreviewView(obj, 0);
    }

    public boolean setPreviewViewBackgroundColor(int i10) {
        return ZegoLiveRoomJNI.setPreviewViewBackgroundColor(i10, 0);
    }

    public boolean setPreviewViewMode(int i10) {
        return ZegoLiveRoomJNI.setPreviewViewMode(i10, 0);
    }

    public void setPublishConfig(Map<String, Object> map) {
        setPublishConfigInner(map, 0);
    }

    public boolean setPublishDualStreamConfig(ZegoPublishDualStreamConfig[] zegoPublishDualStreamConfigArr, int i10) {
        if (zegoPublishDualStreamConfigArr == null || i10 < 0) {
            return false;
        }
        return ZegoLiveRoomJNI.setPublishDualStreamConfig(zegoPublishDualStreamConfigArr, zegoPublishDualStreamConfigArr.length, i10);
    }

    public void setPublishEncryptKey(byte[] bArr, int i10) {
        ZegoLiveRoomJNI.setPublishEncryptKey(bArr, i10);
    }

    public boolean setRecvBufferLevelLimit(int i10, int i11, String str) {
        return ZegoLiveRoomJNI.setRecvBufferLevelLimit(i10, i11, str);
    }

    public boolean setRoomConfig(boolean z10, boolean z11) {
        return setRoomConfig(z10, z11, null);
    }

    public boolean setRoomMaxUserCount(int i10) {
        return setRoomMaxUserCount(i10, null);
    }

    public void setRunLoopObserveCallback(IZegoRunLoopObserveCallback iZegoRunLoopObserveCallback) {
        this.mZegoRunLoopObserveCallback = iZegoRunLoopObserveCallback;
        if (iZegoRunLoopObserveCallback != null) {
            ZegoLiveRoomJNI.enableRunLoopObserveCallback(true);
        } else {
            ZegoLiveRoomJNI.enableRunLoopObserveCallback(false);
        }
    }

    public boolean setSharpenFactor(float f10) {
        return ZegoLiveRoomJNI.setSharpenFactor(f10, 0);
    }

    public int setStreamAlignmentProperty(int i10, int i11) {
        return ZegoLiveRoomJNI.setStreamAlignmentProperty(i10, i11);
    }

    public boolean setToken(String str, String str2) {
        return ZegoLiveRoomJNI.setToken(str, str2);
    }

    public void setTrafficControlFocusOn(int i10) {
        ZegoLiveRoomJNI.setTrafficControlFocusOn(i10, 0);
    }

    public boolean setVideoCaptureDeviceId(String str, int i10) {
        return ZegoLiveRoomJNI.setVideoCaptureDeviceId(str, i10);
    }

    public boolean setVideoCodecId(int i10, int i11) {
        return ZegoLiveRoomJNI.setVideoCodecId(i10, i11);
    }

    public void setVideoEncoderRateControlConfig(int i10, int i11) {
        ZegoLiveRoomJNI.setVideoEncoderRateControlConfig(i10, i11, 0);
    }

    public boolean setVideoKeyFrameInterval(int i10) {
        return setVideoKeyFrameInterval(i10, 0);
    }

    public boolean setVideoMirrorMode(int i10, int i11) {
        return ZegoLiveRoomJNI.setVideoMirrorMode(i10, i11);
    }

    public boolean setVideoSource(int i10, int i11) {
        return setVideoSource(i10, 0, i11);
    }

    public boolean setViewBackgroundColor(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setViewBackgroundColor] failed, streamID is empty");
            return false;
        }
        return ZegoLiveRoomJNI.setViewBackgroundColor(i10, str);
    }

    public boolean setViewMode(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setViewMode] failed, streamID is empty");
            return false;
        }
        return ZegoLiveRoomJNI.setViewMode(i10, str);
    }

    public boolean setViewRotation(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setViewRotation] failed, streamID is empty");
            return false;
        }
        return ZegoLiveRoomJNI.setViewRotation(i10, str);
    }

    public boolean setWhitenFactor(float f10) {
        return ZegoLiveRoomJNI.setWhitenFactor(f10, 0);
    }

    public void setZegoAVEngineCallback(IZegoAVEngineCallback iZegoAVEngineCallback) {
        this.mZegoAVEngineCallback = iZegoAVEngineCallback;
    }

    public void setZegoAudioRecordCallback(IZegoAudioRecordCallback iZegoAudioRecordCallback) {
        this.mZegoAudioRecordCallback = iZegoAudioRecordCallback;
    }

    public void setZegoAudioRouteCallback(IZegoAudioRouteCallback iZegoAudioRouteCallback) {
        this.mZegoAudioRouteCallback = iZegoAudioRouteCallback;
        if (iZegoAudioRouteCallback != null) {
            ZegoLiveRoomJNI.enableAudioRouteCallback(true);
        } else {
            ZegoLiveRoomJNI.enableAudioRouteCallback(false);
        }
    }

    public void setZegoDeviceEventCallback(IZegoDeviceEventCallback iZegoDeviceEventCallback) {
        this.mZegoDeviceEventCallback = iZegoDeviceEventCallback;
    }

    public void setZegoIMCallback(IZegoIMCallback iZegoIMCallback) {
        this.mZegoIMCallback = iZegoIMCallback;
    }

    public void setZegoLiveEventCallback(IZegoLiveEventCallback iZegoLiveEventCallback) {
        this.mZegoLiveEventCallback = iZegoLiveEventCallback;
    }

    public void setZegoLivePlayerCallback(IZegoLivePlayerCallback iZegoLivePlayerCallback) {
        this.mZegoLivePlayerCallback = iZegoLivePlayerCallback;
    }

    public void setZegoLivePublisherCallback(IZegoLivePublisherCallback iZegoLivePublisherCallback) {
        this.mZegoLivePublisherCallback = iZegoLivePublisherCallback;
    }

    public void setZegoLivePublisherCallback2(IZegoLivePublisherCallback2 iZegoLivePublisherCallback2) {
        this.mZegoLivePublisherCallback2 = iZegoLivePublisherCallback2;
    }

    public void setZegoLivePublisherExCallback(IZegoLivePublisherExCallback iZegoLivePublisherExCallback) {
        this.mZegoLivePublisherExCallback = iZegoLivePublisherExCallback;
    }

    public void setZegoLogInfoCallback(IZegoLogInfoCallback iZegoLogInfoCallback) {
        this.mZegoLogInfoCallback = iZegoLogInfoCallback;
    }

    public void setZegoNetTypeCallback(IZegoNetTypeCallback iZegoNetTypeCallback) {
        this.mZegoNetTypeCallback = iZegoNetTypeCallback;
        if (iZegoNetTypeCallback != null) {
            ZegoLiveRoomJNI.enableNetTypeCallback(true);
        } else {
            ZegoLiveRoomJNI.enableNetTypeCallback(false);
        }
    }

    public void setZegoRealtimeSequentialDataCallback(IZegoRealtimeSequentialDataCallback iZegoRealtimeSequentialDataCallback) {
        this.mZegoRealtimeSequentialDataCallback = iZegoRealtimeSequentialDataCallback;
        ZegoLiveRoomJNI.enableRealtimeSequentialDataCallback(iZegoRealtimeSequentialDataCallback != null);
    }

    public void setZegoRoomCallback(IZegoRoomCallback iZegoRoomCallback) {
        this.mZegoRoomCallback = iZegoRoomCallback;
    }

    public void startDumpData(ZegoDumpDataConfig zegoDumpDataConfig) {
        ZegoLiveRoomJNI.startDumpData(zegoDumpDataConfig.dataType);
    }

    public boolean startPlayingStream(String str, Object obj) {
        return startPlayingStreamInner(str, obj, null);
    }

    public boolean startPlayingStreamWithParams(ZegoPlayStreamParams zegoPlayStreamParams) {
        if (zegoPlayStreamParams == null) {
            return false;
        }
        if (TextUtils.isEmpty(zegoPlayStreamParams.streamID)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_startPlayingStreamInner] failed, streamID is empty");
            return false;
        }
        ZegoStreamExtraPlayInfo zegoStreamExtraPlayInfo = zegoPlayStreamParams.extraInfo;
        if (zegoStreamExtraPlayInfo != null && TextUtils.isEmpty(zegoStreamExtraPlayInfo.params)) {
            zegoPlayStreamParams.extraInfo.params = "";
        }
        if (TextUtils.isEmpty(zegoPlayStreamParams.roomID)) {
            zegoPlayStreamParams.roomID = "";
        }
        return ZegoLiveRoomJNI.startPlayingStreamWithParams(zegoPlayStreamParams.streamID, zegoPlayStreamParams.displayView, zegoPlayStreamParams.viewAlphaBlend, zegoPlayStreamParams.extraInfo, zegoPlayStreamParams.roomID);
    }

    public boolean startPreview() {
        return ZegoLiveRoomJNI.startPreview(0);
    }

    public boolean startPublishing(String str, String str2, int i10) {
        return startPublishInner(str, str2, i10);
    }

    public boolean startPublishing2(String str, String str2, int i10, int i11) {
        return startPublishInner2(str, str2, i10, i11, null, null);
    }

    public boolean startPublishingWithParams(ZegoPublishStreamParams zegoPublishStreamParams) {
        if (zegoPublishStreamParams == null) {
            return false;
        }
        return startPublishInner3(zegoPublishStreamParams.streamID, zegoPublishStreamParams.streamTitle, zegoPublishStreamParams.publishFlag, zegoPublishStreamParams.forceSynchronousNetworkTime, zegoPublishStreamParams.censorshipMode, zegoPublishStreamParams.channelIndex, zegoPublishStreamParams.extraInfo, zegoPublishStreamParams.publishParams, zegoPublishStreamParams.roomID);
    }

    public void stopDumpData() {
        ZegoLiveRoomJNI.stopDumpData();
    }

    public boolean stopPlayingStream(String str) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_stopPlayingStream] failed, streamID is empty");
            return false;
        }
        return ZegoLiveRoomJNI.stopPlayingStream(str);
    }

    public boolean stopPreview() {
        return ZegoLiveRoomJNI.stopPreview(0);
    }

    public boolean stopPublishing() {
        return ZegoLiveRoomJNI.stopPublishing(0);
    }

    public boolean switchRoom(String str, String str2, int i10, IZegoLoginCompletionCallback iZegoLoginCompletionCallback) {
        boolean switchRoom;
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_switchRoom] failed, roomID is empty");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (iZegoLoginCompletionCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_switchRoom] failed, callback is null");
            return false;
        }
        synchronized (this.mMapZegoLoginCompletionCallback) {
            switchRoom = ZegoLiveRoomJNI.switchRoom(str, str2, i10);
            if (switchRoom) {
                removeAllRoomCallback();
                ZegoEventManager.getInstance().onActiveEvent(ZegoEventManager.ZEGO_EVENT_ID_LOGOUT_ROOM);
                if (this.mMapZegoLoginCompletionCallback.get(str) != null) {
                    ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_switchRoom] find unfinished roomid: " + str);
                }
                this.mMapZegoLoginCompletionCallback.put(str, iZegoLoginCompletionCallback);
            }
        }
        return switchRoom;
    }

    public boolean takePreviewSnapshot(IZegoSnapshotCompletionCallback iZegoSnapshotCompletionCallback) {
        if (iZegoSnapshotCompletionCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_takePreviewSnapshot] failed, callback is null");
            return false;
        }
        this.mPreviewSnapshotCompletionCallback = iZegoSnapshotCompletionCallback;
        return ZegoLiveRoomJNI.takePreviewSnapshot(0);
    }

    public boolean takeSnapshotOfStream(String str, IZegoSnapshotCompletionCallback iZegoSnapshotCompletionCallback) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_takeSnapshotOfStream] failed, streamID is empty");
            return false;
        }
        if (iZegoSnapshotCompletionCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_takeSnapshotOfStream] failed, callback is null");
            return false;
        }
        boolean takeSnapshot = ZegoLiveRoomJNI.takeSnapshot(str);
        if (takeSnapshot) {
            if (this.mMapStreamSnapshotCompletionCallback.get(str) != null) {
                ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_takeSnapshotOfStream] unfinished snapshot, streamID:" + str);
            }
            this.mMapStreamSnapshotCompletionCallback.put(str, iZegoSnapshotCompletionCallback);
        }
        return takeSnapshot;
    }

    public boolean unInitSDK() {
        try {
            sLogPath = null;
            this.mZegoRoomCallback = null;
            this.mZegoLivePlayerCallback = null;
            this.mZegoLivePublisherCallback = null;
            this.mZegoLivePublisherExCallback = null;
            this.mZegoLivePublisherCallback2 = null;
            this.mZegoDeviceEventCallback = null;
            this.mZegoLiveEventCallback = null;
            this.mZegoAudioRecordCallback = null;
            this.mZegoIMCallback = null;
            this.mZegoAVEngineCallback = null;
            this.mZegoInitSDKCallback = null;
            this.mZegoLogInfoCallback = null;
            this.mZegoAudioRouteCallback = null;
            this.mZegoNetTypeCallback = null;
            this.mZegoRealtimeSequentialDataCallback = null;
            this.mZegoRunLoopObserveCallback = null;
            this.mZegoDumpDataCallback = null;
            removeAllRoomCallback();
            ZegoLiveRoomJNI.setZegoLiveRoomCallback(null);
            ZegoLiveRoomJNI.setZegoIMCallback(null);
            ZegoEventManager.getInstance().onActiveEvent(ZegoEventManager.ZEGO_EVENT_ID_UNINITSDK);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return ZegoLiveRoomJNI.unInitSDK();
    }

    public void uninitVideoSuperResolution() {
        ZegoLiveRoomJNI.uninitVideoSuperResolution();
    }

    public void updatePlayDecryptKey(String str, byte[] bArr) {
        ZegoLiveRoomJNI.updatePlayDecryptKey(str, bArr);
    }

    public boolean updatePlayToken(String str, byte[] bArr) {
        return ZegoLiveRoomJNI.updatePlayToken(str, bArr);
    }

    public boolean updatePlayView(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_updatePlayView] failed, streamID is empty");
            return false;
        }
        return ZegoLiveRoomJNI.updatePlayView(str, obj);
    }

    public boolean updateStreamExtraInfo(String str) {
        return updateStreamExtraInfoInner(str, 0);
    }

    public void uploadDumpData() {
        ZegoLiveRoomJNI.uploadDumpData();
    }

    public static boolean setDummyCaptureImagePath(Uri uri, int i10) {
        if (uri == null) {
            return setDummyCaptureImagePath("", i10);
        }
        return setDummyCaptureImagePath(uri.toString(), i10);
    }

    public static boolean setPreviewWaterMarkRect(Rect rect, int i10) {
        return setPreviewWaterMarkRectInner(rect, i10);
    }

    public static boolean setPublishWaterMarkRect(Rect rect, int i10) {
        return setPublishWaterMarkRectInner(rect, i10);
    }

    public static boolean setWaterMarkImagePath(Uri uri) {
        if (uri == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setWaterMarkImagePath] failed, imageUri is null");
            return false;
        }
        return setWaterMarkImagePathInner(uri.toString(), 0);
    }

    public int activateVideoPlayStream(String str, boolean z10, int i10) {
        return ZegoLiveRoomJNI.activateVideoPlayStream(str, z10, i10);
    }

    public void enableAudioPrepVADStableStateMonitor(boolean z10, int i10) {
        ZegoLiveRoomJNI.enableAudioPrepVADStableStateMonitor(z10, i10);
    }

    public boolean enableBeautifying(int i10, int i11) {
        return ZegoLiveRoomJNI.enableBeautifying(i10, i11);
    }

    public boolean enableCamera(boolean z10, int i10) {
        return ZegoLiveRoomJNI.enableCamera(z10, i10);
    }

    public boolean enableCaptureMirror(boolean z10, int i10) {
        return ZegoLiveRoomJNI.enableCaptureMirror(z10, i10);
    }

    public void enableCapturedAudioVADStableStateMonitor(boolean z10, int i10) {
        ZegoLiveRoomJNI.enableCapturedAudioVADStableStateMonitor(z10, i10);
    }

    public boolean enablePreviewMirror(boolean z10, int i10) {
        return ZegoLiveRoomJNI.enablePreviewMirror(z10, i10);
    }

    public boolean enableRateControl(boolean z10, int i10) {
        return ZegoLiveRoomJNI.enableRateControl(z10, i10);
    }

    public boolean enableSelectedAudioRecord(ZegoAudioRecordConfig zegoAudioRecordConfig) {
        if (zegoAudioRecordConfig == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_enableSelectedAudioRecord] failed, config is NULL");
            return false;
        }
        return ZegoLiveRoomJNI.enableSelectedAudioRecord(zegoAudioRecordConfig.mask, zegoAudioRecordConfig.sampleRate, zegoAudioRecordConfig.channels);
    }

    public boolean enableTorch(boolean z10, int i10) {
        return ZegoLiveRoomJNI.enableTorch(z10, i10);
    }

    public void enableTrafficControl(int i10, boolean z10, int i11) {
        ZegoLiveRoomJNI.enableTrafficControl(i10, z10, i11);
    }

    public void enableVideoObjectSegmentation(boolean z10, ZegoObjectSegmentationConfig zegoObjectSegmentationConfig, int i10) {
        ZegoLiveRoomJNI.enableVideoObjectSegmentationWithConfig(z10, zegoObjectSegmentationConfig, i10);
    }

    public boolean endJoinLive(String str, String str2, IZegoEndJoinLiveCallback iZegoEndJoinLiveCallback) {
        if (iZegoEndJoinLiveCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_endJoinLive] failed, callback is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_endJoinLive] failed, userId is empty");
            return false;
        }
        int endJoinLive = ZegoLiveRoomJNI.endJoinLive(str, str2);
        if (endJoinLive > 0) {
            if (this.mMapEndJoinLiveResponseCallback.get(Integer.valueOf(endJoinLive)) != null) {
                ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_endJoinLive], unfinished send end join live, seq:" + endJoinLive);
            }
            this.mMapEndJoinLiveResponseCallback.put(Integer.valueOf(endJoinLive), iZegoEndJoinLiveCallback);
            return true;
        }
        ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_endJoinLive] failed, seq:" + endJoinLive);
        return false;
    }

    public boolean inviteJoinLive(String str, String str2, IZegoResponseCallback iZegoResponseCallback) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_inviteJoinLive] failed, userID is empty");
            return false;
        }
        if (iZegoResponseCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_inviteJoinLive] failed, callback is null");
            return false;
        }
        int inviteJoinLive = ZegoLiveRoomJNI.inviteJoinLive(str, str2);
        if (inviteJoinLive > 0) {
            if (this.mMapInviteJoinLiveResponseCallback.get(Integer.valueOf(inviteJoinLive)) != null) {
                ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_inviteJoinLive] unfinished invite JoinLive, seq:" + inviteJoinLive);
            }
            this.mMapInviteJoinLiveResponseCallback.put(Integer.valueOf(inviteJoinLive), iZegoResponseCallback);
            return true;
        }
        ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_inviteJoinLive] failed, seq:" + inviteJoinLive);
        return false;
    }

    public int isVideoDecoderSupported(int i10, int i11) {
        return ZegoLiveRoomJNI.isVideoDecoderSupported(i10, i11);
    }

    public int isVideoEncoderSupported(int i10, int i11) {
        return ZegoLiveRoomJNI.isVideoEncoderSupported(i10, i11);
    }

    public boolean loginRoom(String str, String str2, int i10, IZegoLoginCompletionCallback iZegoLoginCompletionCallback) {
        boolean loginRoom;
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_loginRoom] failed, roomID is empty");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (iZegoLoginCompletionCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_loginRoom] failed, callback is null");
            return false;
        }
        synchronized (this.mMapZegoLoginCompletionCallback) {
            loginRoom = ZegoLiveRoomJNI.loginRoom(str, str2, i10);
            if (loginRoom) {
                if (this.mMapZegoLoginCompletionCallback.get(str) != null) {
                    ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_loginRoom], unfinished room login: " + str);
                }
                this.mMapZegoLoginCompletionCallback.put(str, iZegoLoginCompletionCallback);
            }
        }
        return loginRoom;
    }

    public int muteAudioPublish(boolean z10, int i10) {
        return ZegoLiveRoomJNI.muteAudioPublish(z10, i10);
    }

    public int muteVideoPublish(boolean z10, int i10) {
        return ZegoLiveRoomJNI.muteVideoPublish(z10, i10);
    }

    public boolean requestJoinLive(String str, IZegoResponseCallback iZegoResponseCallback) {
        if (iZegoResponseCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_requestJoinLive] failed, callback is null");
            return false;
        }
        int requestJoinLive = ZegoLiveRoomJNI.requestJoinLive(str);
        if (requestJoinLive > 0) {
            if (this.mMapJoinLiveResponseCallback.get(Integer.valueOf(requestJoinLive)) != null) {
                ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_requestJoinLive] unfinished send end join live, seq:" + requestJoinLive);
            }
            this.mMapJoinLiveResponseCallback.put(Integer.valueOf(requestJoinLive), iZegoResponseCallback);
            return true;
        }
        ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_requestJoinLive] failed, seq:" + requestJoinLive);
        return false;
    }

    public boolean respondInviteJoinLiveReq(int i10, int i11, String str) {
        return ZegoLiveRoomJNI.respondInviteJoinLiveReq(i10, i11, str);
    }

    public boolean respondJoinLiveReq(int i10, int i11, String str) {
        return ZegoLiveRoomJNI.respondJoinLiveReq(i10, i11, str);
    }

    public boolean sendBigRoomMessage(int i10, int i11, String str, String str2, IZegoBigRoomMessageCallback iZegoBigRoomMessageCallback) {
        if (iZegoBigRoomMessageCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendBigRoomMessage] callback is null");
        }
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendBigRoomMessage] failed, content is empty");
            return false;
        }
        int sendBigRoomMessage = ZegoLiveRoomJNI.sendBigRoomMessage(i10, i11, str, str2);
        if (sendBigRoomMessage != -1) {
            if (this.mMapIMCallback.get(Integer.valueOf(sendBigRoomMessage)) != null) {
                ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendBigRoomMessage], unfinished send room message, seq:" + sendBigRoomMessage);
            }
            if (iZegoBigRoomMessageCallback == null) {
                return true;
            }
            this.mMapIMCallback.put(Integer.valueOf(sendBigRoomMessage), iZegoBigRoomMessageCallback);
            return true;
        }
        ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendBigRoomMessage] failed, seq:" + sendBigRoomMessage);
        return false;
    }

    public boolean sendCustomCommand(ZegoUser[] zegoUserArr, String str, String str2, IZegoCustomCommandCallback iZegoCustomCommandCallback) {
        if (iZegoCustomCommandCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendCustomCommand] failed, callback is null");
            return false;
        }
        ZegoUser[] listOfLegalUser = getListOfLegalUser(zegoUserArr);
        if (listOfLegalUser == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendCustomCommand] failed, listMember is empty");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendCustomCommand] failed, content is empty");
            return false;
        }
        int sendCustomCommand = ZegoLiveRoomJNI.sendCustomCommand(listOfLegalUser, listOfLegalUser.length, str, str2);
        if (sendCustomCommand == -1) {
            return false;
        }
        if (this.mMapCustomCommandCallback.get(Integer.valueOf(sendCustomCommand)) != null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendCustomCommand], unfinished custom command, seq:" + sendCustomCommand);
        }
        this.mMapCustomCommandCallback.put(Integer.valueOf(sendCustomCommand), iZegoCustomCommandCallback);
        return true;
    }

    public boolean sendRoomMessage(int i10, int i11, String str, String str2, IZegoRoomMessageCallback iZegoRoomMessageCallback) {
        if (iZegoRoomMessageCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendRoomMessage] failed, callback is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendRoomMessage] failed, content is empty");
            return false;
        }
        int sendRoomMessageEx = ZegoLiveRoomJNI.sendRoomMessageEx(i10, i11, str, str2);
        if (sendRoomMessageEx != -1) {
            if (this.mMapIMCallback.get(Integer.valueOf(sendRoomMessageEx)) != null) {
                ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendRoomMessage], unfinished send room message, seq:" + sendRoomMessageEx);
            }
            this.mMapIMCallback.put(Integer.valueOf(sendRoomMessageEx), iZegoRoomMessageCallback);
            return true;
        }
        ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_sendRoomMessage] failed, seq:" + sendRoomMessageEx);
        return false;
    }

    public boolean setAVConfig(ZegoAvConfig zegoAvConfig, int i10) {
        return setAVConfigInner(zegoAvConfig, i10);
    }

    public boolean setAppOrientation(int i10, int i11) {
        return setAppOrientationInner(i10, i11);
    }

    public boolean setAudioBitrate(int i10, int i11) {
        return ZegoLiveRoomJNI.setAudioBitrate(i10, i11);
    }

    public boolean setFilter(int i10, int i11) {
        return ZegoLiveRoomJNI.setFilter(i10, i11);
    }

    public boolean setFrontCam(boolean z10, int i10) {
        return ZegoLiveRoomJNI.setFrontCam(z10, i10);
    }

    public void setMinVideoBitrateForTrafficControl(int i10, int i11, int i12) {
        ZegoLiveRoomJNI.setMinVideoBitrateForTrafficControl(i10, i11, i12);
    }

    public boolean setPlayVolume(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return ZegoLiveRoomJNI.setPlayVolume2(i10, str);
    }

    public boolean setPolishFactor(float f10, int i10) {
        return ZegoLiveRoomJNI.setPolishFactor(f10, i10);
    }

    public boolean setPolishStep(float f10, int i10) {
        return ZegoLiveRoomJNI.setPolishStep(f10, i10);
    }

    public boolean setPreviewRotation(int i10, int i11) {
        return ZegoLiveRoomJNI.setPreviewRotation(i10, i11);
    }

    public boolean setPreviewView(Object obj, int i10) {
        return ZegoLiveRoomJNI.setPreviewView(obj, i10);
    }

    public boolean setPreviewViewBackgroundColor(int i10, int i11) {
        return ZegoLiveRoomJNI.setPreviewViewBackgroundColor(i10, i11);
    }

    public boolean setPreviewViewMode(int i10, int i11) {
        return ZegoLiveRoomJNI.setPreviewViewMode(i10, i11);
    }

    public void setPublishConfig(Map<String, Object> map, int i10) {
        setPublishConfigInner(map, i10);
    }

    public boolean setRoomConfig(boolean z10, boolean z11, String str) {
        return ZegoLiveRoomJNI.setRoomConfig(z10, z11, str);
    }

    public boolean setRoomMaxUserCount(int i10, String str) {
        return ZegoLiveRoomJNI.setRoomMaxUserCount(i10, str);
    }

    public boolean setSharpenFactor(float f10, int i10) {
        return ZegoLiveRoomJNI.setSharpenFactor(f10, i10);
    }

    public void setTrafficControlFocusOn(int i10, int i11) {
        ZegoLiveRoomJNI.setTrafficControlFocusOn(i10, i11);
    }

    public void setVideoEncoderRateControlConfig(int i10, int i11, int i12) {
        ZegoLiveRoomJNI.setVideoEncoderRateControlConfig(i10, i11, i12);
    }

    public boolean setVideoKeyFrameInterval(int i10, int i11) {
        return ZegoLiveRoomJNI.setVideoKeyFrameInterval(i10, i11);
    }

    public boolean setVideoSource(int i10, int i11, int i12) {
        return ZegoLiveRoomJNI.setVideoSource(i10, i11, i12);
    }

    public boolean setWhitenFactor(float f10, int i10) {
        return ZegoLiveRoomJNI.setWhitenFactor(f10, i10);
    }

    public void setZegoAudioRecordCallback(IZegoAudioRecordCallback2 iZegoAudioRecordCallback2) {
        this.mZegoAudioRecordCallback2 = iZegoAudioRecordCallback2;
    }

    public boolean startPlayingStream(String str, Object obj, String str2) {
        ZegoStreamExtraPlayInfo zegoStreamExtraPlayInfo = new ZegoStreamExtraPlayInfo();
        zegoStreamExtraPlayInfo.params = str2;
        return startPlayingStreamInner(str, obj, zegoStreamExtraPlayInfo);
    }

    public boolean startPreview(int i10) {
        return ZegoLiveRoomJNI.startPreview(i10);
    }

    public boolean startPublishing(String str, String str2, int i10, String str3) {
        if (TextUtils.isEmpty(str3) || ZegoLiveRoomJNI.updateStreamExtraInfo(str3, 0)) {
            return startPublishInner(str, str2, i10);
        }
        return false;
    }

    public boolean startPublishing2(String str, String str2, int i10, String str3, int i11) {
        return startPublishInner2(str, str2, i10, i11, str3, null);
    }

    public boolean stopPreview(int i10) {
        return ZegoLiveRoomJNI.stopPreview(i10);
    }

    public boolean stopPublishing(int i10) {
        return ZegoLiveRoomJNI.stopPublishing(i10);
    }

    public boolean updateStreamExtraInfo(String str, int i10) {
        return updateStreamExtraInfoInner(str, i10);
    }

    public boolean logoutRoom(String str) {
        ZegoEventManager.getInstance().onActiveEvent(ZegoEventManager.ZEGO_EVENT_ID_LOGOUT_ROOM);
        boolean logoutRoom = ZegoLiveRoomJNI.logoutRoom(str);
        if (logoutRoom) {
            removeRoomCallback(str);
        }
        return logoutRoom;
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onCaptureVideoFirstFrame(final int i10) {
        final IZegoLivePublisherCallback2 iZegoLivePublisherCallback2 = this.mZegoLivePublisherCallback2;
        if (iZegoLivePublisherCallback2 != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.39
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback2.onCaptureVideoFirstFrame(i10);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onCaptureVideoSizeChanged(final int i10, final int i11, final int i12) {
        final IZegoLivePublisherCallback2 iZegoLivePublisherCallback2 = this.mZegoLivePublisherCallback2;
        if (iZegoLivePublisherCallback2 != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.37
                @Override // java.lang.Runnable
                public void run() {
                    iZegoLivePublisherCallback2.onCaptureVideoSizeChangedTo(i10, i11, i12);
                }
            });
        }
    }

    public boolean setPreviewView(Object obj, boolean z10, int i10) {
        return ZegoLiveRoomJNI.setPreviewView2(obj, z10, i10);
    }

    public boolean startPublishing2(String str, String str2, int i10, String str3, String str4, int i11) {
        return startPublishInner2(str, str2, i10, i11, str3, str4);
    }

    public static boolean setWaterMarkImagePath(String str, int i10) {
        return setWaterMarkImagePathInner(str, i10);
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomJNI.IJniZegoLiveRoomCallback
    public void onPreviewSnapshot(final int i10, final Bitmap bitmap) {
        final IZegoSnapshotCompletionCallback2 iZegoSnapshotCompletionCallback2 = this.mPreviewSnapshotCompletionCallback2;
        if (iZegoSnapshotCompletionCallback2 != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoom.45
                @Override // java.lang.Runnable
                public void run() {
                    iZegoSnapshotCompletionCallback2.onZegoSnapshotCompletion(i10, bitmap);
                }
            });
            this.mPreviewSnapshotCompletionCallback2 = null;
        }
    }

    public boolean takePreviewSnapshot(IZegoSnapshotCompletionCallback2 iZegoSnapshotCompletionCallback2, int i10) {
        if (iZegoSnapshotCompletionCallback2 == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_takePreviewSnapshot_channel] failed, callback is null");
            return false;
        }
        this.mPreviewSnapshotCompletionCallback2 = iZegoSnapshotCompletionCallback2;
        return ZegoLiveRoomJNI.takePreviewSnapshot(i10);
    }

    public boolean updatePlayView(String str, Object obj, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_updatePlayView] failed, streamID is empty");
            return false;
        }
        return ZegoLiveRoomJNI.updatePlayView2(str, obj, z10);
    }

    public static boolean setWaterMarkImagePath(Uri uri, int i10) {
        if (uri == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_setWaterMarkImagePath] failed, imageUri is null");
            return false;
        }
        return setWaterMarkImagePathInner(uri.toString(), i10);
    }

    public boolean startPlayingStream(String str, Object obj, ZegoStreamExtraPlayInfo zegoStreamExtraPlayInfo) {
        return startPlayingStreamInner(str, obj, zegoStreamExtraPlayInfo);
    }

    public boolean initSDK(long j10, byte[] bArr) {
        return initSDK(j10, bArr, (IZegoInitSDKCompletionCallback) null);
    }

    public boolean initSDK(long j10, byte[] bArr, IZegoInitSDKCompletionCallback iZegoInitSDKCompletionCallback) {
        this.mZegoInitSDKCallback = iZegoInitSDKCompletionCallback;
        SDKContext sDKContext = mContext;
        if (sDKContext != null && sDKContext.getAppContext() != null) {
            return _initSDKInner(j10, bArr, mContext.getAppContext().getApplicationContext());
        }
        throw new RuntimeException("[ZEGO] Android application context not set!");
    }

    public boolean switchRoom(String str, String str2, String str3, int i10, IZegoLoginCompletionCallback iZegoLoginCompletionCallback) {
        if (TextUtils.isEmpty(str)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_switchRoom] failed, fromRoomID is empty");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_switchRoom] failed, toRoomID is empty");
            return false;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        if (iZegoLoginCompletionCallback == null) {
            ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_switchRoom] failed, callback is null");
            return false;
        }
        boolean switchRoom2 = ZegoLiveRoomJNI.switchRoom2(str, str2, str3, i10);
        if (switchRoom2) {
            removeRoomCallback(str);
            ZegoEventManager.getInstance().onActiveEvent(ZegoEventManager.ZEGO_EVENT_ID_LOGOUT_ROOM);
            if (this.mMapZegoLoginCompletionCallback.get(str2) != null) {
                ZegoLiveRoomJNI.logPrint("[Java_ZegoLiveRoom_switchRoom] find unfinished roomid: " + str2);
            }
            this.mMapZegoLoginCompletionCallback.put(str2, iZegoLoginCompletionCallback);
        }
        return switchRoom2;
    }
}
