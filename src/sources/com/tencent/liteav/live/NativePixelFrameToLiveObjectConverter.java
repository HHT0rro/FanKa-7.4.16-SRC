package com.tencent.liteav.live;

import android.os.Looper;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.ByteBuffer;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativePixelFrameToLiveObjectConverter {
    @CalledByNative
    public static ByteBuffer createByteBuffer(int i10) {
        return ByteBuffer.allocateDirect(i10);
    }

    @CalledByNative
    public static long getGLContextNativeHandle(Object obj) {
        return OpenGlUtils.getGLContextNativeHandle(obj);
    }

    @CalledByNative
    public static boolean isInUIThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
