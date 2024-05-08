package com.zego.zegoavkit2.mediarecorder;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.zego.zegoavkit2.entities.ZegoPublishStreamQuality;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoMediaRecorder implements IZegoMediaRecordCallback2 {
    private volatile IZegoMediaRecordCallbackBase mZegoMediaRecordCallback = null;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private void setZegoMediaRecordCallbackBase(IZegoMediaRecordCallbackBase iZegoMediaRecordCallbackBase) {
        this.mZegoMediaRecordCallback = iZegoMediaRecordCallbackBase;
        if (iZegoMediaRecordCallbackBase != null) {
            ZegoMediaRecordJNI.setCallback(this);
            ZegoMediaRecordJNI.setMediaRecordCallback(true);
        } else {
            ZegoMediaRecordJNI.setCallback(null);
            ZegoMediaRecordJNI.setMediaRecordCallback(false);
        }
    }

    @Override // com.zego.zegoavkit2.mediarecorder.IZegoMediaRecordCallbackBase
    public void onMediaRecord(final int i10, final ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, final String str) {
        final IZegoMediaRecordCallbackBase iZegoMediaRecordCallbackBase = this.mZegoMediaRecordCallback;
        if (iZegoMediaRecordCallbackBase != null) {
            this.mHandler.post(new Runnable() { // from class: com.zego.zegoavkit2.mediarecorder.ZegoMediaRecorder.1
                @Override // java.lang.Runnable
                public void run() {
                    iZegoMediaRecordCallbackBase.onMediaRecord(i10, zegoMediaRecordChannelIndex, str);
                }
            });
        }
    }

    @Override // com.zego.zegoavkit2.mediarecorder.IZegoMediaRecordCallback2
    public void onRecordStatusUpdate(final ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, final String str, final long j10, final long j11, final ZegoPublishStreamQuality zegoPublishStreamQuality) {
        final IZegoMediaRecordCallbackBase iZegoMediaRecordCallbackBase = this.mZegoMediaRecordCallback;
        if (iZegoMediaRecordCallbackBase != null) {
            this.mHandler.post(new Runnable() { // from class: com.zego.zegoavkit2.mediarecorder.ZegoMediaRecorder.2
                @Override // java.lang.Runnable
                public void run() {
                    IZegoMediaRecordCallbackBase iZegoMediaRecordCallbackBase2 = iZegoMediaRecordCallbackBase;
                    if (iZegoMediaRecordCallbackBase2 instanceof IZegoMediaRecordCallback) {
                        ((IZegoMediaRecordCallback) iZegoMediaRecordCallbackBase2).onRecordStatusUpdate(zegoMediaRecordChannelIndex, str, j10, j11);
                    } else if (iZegoMediaRecordCallbackBase2 instanceof IZegoMediaRecordCallback2) {
                        ((IZegoMediaRecordCallback2) iZegoMediaRecordCallbackBase2).onRecordStatusUpdate(zegoMediaRecordChannelIndex, str, j10, j11, zegoPublishStreamQuality);
                    }
                }
            });
        }
    }

    public void setZegoMediaRecordCallback(IZegoMediaRecordCallback iZegoMediaRecordCallback) {
        setZegoMediaRecordCallbackBase(iZegoMediaRecordCallback);
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, String str) {
        if (zegoMediaRecordChannelIndex == null || str == null) {
            return false;
        }
        return ZegoMediaRecordJNI.startRecord(zegoMediaRecordChannelIndex.value(), zegoMediaRecordType.value(), str);
    }

    public boolean stopRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex) {
        if (zegoMediaRecordChannelIndex == null) {
            return false;
        }
        ZegoMediaRecordJNI.stopRecord(zegoMediaRecordChannelIndex.value());
        return true;
    }

    public void setZegoMediaRecordCallback(IZegoMediaRecordCallback2 iZegoMediaRecordCallback2) {
        setZegoMediaRecordCallbackBase(iZegoMediaRecordCallback2);
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, String str, boolean z10, int i10) {
        if (zegoMediaRecordChannelIndex == null || str == null) {
            return false;
        }
        return ZegoMediaRecordJNI.startRecordEx(zegoMediaRecordChannelIndex.value(), zegoMediaRecordType.value(), str, z10, i10, ZegoMediaRecordFormat.FLV.value(), false, "");
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, Uri uri, boolean z10, int i10) {
        if (uri == null) {
            return false;
        }
        return startRecord(zegoMediaRecordChannelIndex, zegoMediaRecordType, uri.toString(), z10, i10);
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, String str, boolean z10, int i10, ZegoMediaRecordFormat zegoMediaRecordFormat) {
        if (zegoMediaRecordChannelIndex == null || str == null) {
            return false;
        }
        return ZegoMediaRecordJNI.startRecordEx(zegoMediaRecordChannelIndex.value(), zegoMediaRecordType.value(), str, z10, i10, zegoMediaRecordFormat.value(), false, "");
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, Uri uri, boolean z10, int i10, ZegoMediaRecordFormat zegoMediaRecordFormat) {
        if (uri == null) {
            return false;
        }
        return startRecord(zegoMediaRecordChannelIndex, zegoMediaRecordType, uri.toString(), z10, i10, zegoMediaRecordFormat);
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, String str, boolean z10, int i10, ZegoMediaRecordFormat zegoMediaRecordFormat, boolean z11) {
        if (zegoMediaRecordChannelIndex == null || str == null) {
            return false;
        }
        return ZegoMediaRecordJNI.startRecordEx(zegoMediaRecordChannelIndex.value(), zegoMediaRecordType.value(), str, z10, i10, zegoMediaRecordFormat.value(), z11, "");
    }

    public boolean startRecord(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, ZegoMediaRecordType zegoMediaRecordType, Uri uri, boolean z10, int i10, ZegoMediaRecordFormat zegoMediaRecordFormat, boolean z11) {
        if (uri == null) {
            return false;
        }
        return startRecord(zegoMediaRecordChannelIndex, zegoMediaRecordType, uri.toString(), z10, i10, zegoMediaRecordFormat, z11);
    }

    public boolean startRecord(ZegoMediaRecordConfig zegoMediaRecordConfig) {
        if (zegoMediaRecordConfig.storageUri == null) {
            return false;
        }
        return ZegoMediaRecordJNI.startRecordEx(zegoMediaRecordConfig.channelIndex.value(), zegoMediaRecordConfig.recordType.value(), zegoMediaRecordConfig.storageUri.toString(), zegoMediaRecordConfig.enableStatusCallback, zegoMediaRecordConfig.interval, zegoMediaRecordConfig.recordFormat.value(), zegoMediaRecordConfig.isFragment, zegoMediaRecordConfig.config);
    }
}
