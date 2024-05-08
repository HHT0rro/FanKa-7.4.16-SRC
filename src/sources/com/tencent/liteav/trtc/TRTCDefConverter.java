package com.tencent.liteav.trtc;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.util.concurrent.TimeUnit;

@JNINamespace("liteav::trtc")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TRTCDefConverter {
    private static final String TAG = "TRTCDefConverter";
    private static final com.tencent.liteav.base.b.a sThrottler = new com.tencent.liteav.base.b.a(TimeUnit.SECONDS.toMillis(1));

    @CalledByNative
    public static long getGLContextNativeHandle(Object obj) {
        return OpenGlUtils.getGLContextNativeHandle(obj);
    }
}
