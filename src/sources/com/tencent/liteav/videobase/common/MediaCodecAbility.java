package com.tencent.liteav.videobase.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import androidx.annotation.RequiresApi;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MediaCodecAbility {
    private static final String TAG = "MediaCodecAbility";

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        com.tencent.liteav.base.util.LiteavLog.i(com.tencent.liteav.videobase.common.MediaCodecAbility.TAG, "got hevc decoder:%s", r7.getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
    
        continue;
     */
    @com.tencent.liteav.base.annotations.CalledByNative
    @androidx.annotation.RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isDecoderSupportHevc() {
        /*
            java.lang.String r0 = "MediaCodecAbility"
            int r1 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            r2 = 0
            r3 = 21
            if (r1 >= r3) goto Lc
            return r2
        Lc:
            r1 = 1
            android.media.MediaCodecList r3 = new android.media.MediaCodecList     // Catch: java.lang.Throwable -> L4f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4f
            android.media.MediaCodecInfo[] r3 = r3.getCodecInfos()     // Catch: java.lang.Throwable -> L4f
            int r4 = r3.length     // Catch: java.lang.Throwable -> L4f
            r5 = 0
            r6 = 0
        L19:
            if (r5 >= r4) goto L57
            r7 = r3[r5]     // Catch: java.lang.Throwable -> L4d
            java.lang.String[] r8 = r7.getSupportedTypes()     // Catch: java.lang.Throwable -> L4d
            boolean r9 = r7.isEncoder()     // Catch: java.lang.Throwable -> L4d
            if (r9 != 0) goto L4a
            int r9 = r8.length     // Catch: java.lang.Throwable -> L4d
            r10 = 0
        L29:
            if (r10 >= r9) goto L4a
            r11 = r8[r10]     // Catch: java.lang.Throwable -> L4d
            java.lang.String r12 = "video/hevc"
            boolean r11 = r11.contains(r12)     // Catch: java.lang.Throwable -> L4d
            if (r11 == 0) goto L47
            java.lang.String r6 = "got hevc decoder:%s"
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L44
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> L44
            r8[r2] = r7     // Catch: java.lang.Throwable -> L44
            com.tencent.liteav.base.util.LiteavLog.i(r0, r6, r8)     // Catch: java.lang.Throwable -> L44
            r6 = 1
            goto L4a
        L44:
            r2 = move-exception
            r6 = 1
            goto L52
        L47:
            int r10 = r10 + 1
            goto L29
        L4a:
            int r5 = r5 + 1
            goto L19
        L4d:
            r2 = move-exception
            goto L52
        L4f:
            r1 = move-exception
            r2 = r1
            r6 = 0
        L52:
            java.lang.String r1 = "get hevc decode error "
            com.tencent.liteav.base.util.LiteavLog.e(r0, r1, r2)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.common.MediaCodecAbility.isDecoderSupportHevc():boolean");
    }

    @CalledByNative
    @RequiresApi(api = 21)
    public static boolean isEncoderSupportHevc() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return false;
        }
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                for (String str : mediaCodecInfo.getSupportedTypes()) {
                    if (str.contains("video/hevc")) {
                        LiteavLog.i(TAG, "Got hevc encoder");
                        return true;
                    }
                }
            }
        }
        LiteavLog.w(TAG, "not got hevc encoder");
        return false;
    }

    @CalledByNative
    public static boolean isMediaCodecSWHevcDecodeSupport() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return false;
        }
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                if (!mediaCodecInfo.isEncoder()) {
                    for (String str : supportedTypes) {
                        if (str.contains("video/hevc") && isSoftOnlyDecoder(mediaCodecInfo)) {
                            LiteavLog.i(TAG, "got soft only hevc decoder:%s", mediaCodecInfo.getName());
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            LiteavLog.e(TAG, "get hevc decode error ", th);
        }
        return false;
    }

    public static boolean isSoftOnlyDecoder(MediaCodecInfo mediaCodecInfo) {
        if (LiteavSystemInfo.getSystemOSVersionInt() > 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        return mediaCodecInfo.getName().contains("android") || mediaCodecInfo.getName().contains("google");
    }
}
