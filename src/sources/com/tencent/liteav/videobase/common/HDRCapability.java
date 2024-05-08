package com.tencent.liteav.videobase.common;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.l;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HDRCapability {
    private static final String TAG = "HDRCapability";
    private static Boolean sIsHDR10Supported;
    private static final l sSequenceTaskRunner = new l();

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 24)
    public static void checkIsHDR10Supported() {
        synchronized (HDRCapability.class) {
            if (sIsHDR10Supported != null) {
                return;
            }
            try {
                boolean isDisplaySupportHDR10 = isDisplaySupportHDR10();
                boolean isDecoderSupportHDR10 = isDecoderSupportHDR10();
                synchronized (HDRCapability.class) {
                    Boolean valueOf = Boolean.valueOf(isDisplaySupportHDR10 && isDecoderSupportHDR10);
                    sIsHDR10Supported = valueOf;
                    LiteavLog.i(TAG, "the device supports hdr10 %b", valueOf);
                }
            } catch (Throwable th) {
                LiteavLog.e(TAG, "check hdr capability error ", th);
            }
        }
    }

    private static boolean hasHDR10ProfileLevel(MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr) {
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == 4096) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(api = 21)
    private static boolean isDecoderSupportHDR10() {
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            for (String str : mediaCodecInfo.getSupportedTypes()) {
                if (str.contains("video/hevc") && hasHDR10ProfileLevel(mediaCodecInfo.getCapabilitiesForType("video/hevc").profileLevels)) {
                    return true;
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 24)
    private static boolean isDisplaySupportHDR10() {
        WindowManager windowManager;
        Display.HdrCapabilities hdrCapabilities;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || (windowManager = (WindowManager) applicationContext.getSystemService("window")) == null || (hdrCapabilities = windowManager.getDefaultDisplay().getHdrCapabilities()) == null) {
            return false;
        }
        for (int i10 : hdrCapabilities.getSupportedHdrTypes()) {
            if (i10 == 2) {
                return true;
            }
        }
        return false;
    }

    @CalledByNative
    @RequiresApi(api = 24)
    public static synchronized boolean isHDRSupported(int i10) {
        synchronized (HDRCapability.class) {
            if (LiteavSystemInfo.getSystemOSVersionInt() < 24) {
                return false;
            }
            if (i10 != b.HDR10.mValue) {
                return false;
            }
            Boolean bool = sIsHDR10Supported;
            if (bool != null) {
                return bool.booleanValue();
            }
            sSequenceTaskRunner.a(a.a());
            return false;
        }
    }
}
