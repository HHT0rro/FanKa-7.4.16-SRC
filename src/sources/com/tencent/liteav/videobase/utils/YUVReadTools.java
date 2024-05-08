package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class YUVReadTools {
    public static native void nativeReadYUVPlanesForByteArray(int i10, int i11, byte[] bArr);

    public static native void nativeReadYUVPlanesForByteBuffer(int i10, int i11, ByteBuffer byteBuffer);
}
