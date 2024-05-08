package com.tencent.liteav.videoconsumer.decoder;

import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SpsInfo {
    public int width = 0;
    public int height = 0;
    public Integer videoFormat = null;
    public Integer videoFullRangeFlag = null;
    public Integer colourPrimaries = null;
    public Integer transferCharacteristics = null;
    public Integer matrixCoefficients = null;
    public Integer maxNumRefFrames = null;

    @CalledByNative
    public SpsInfo() {
    }

    public static native SpsInfo nativeDecodeSps(boolean z10, ByteBuffer byteBuffer);

    public static native byte[] nativeGetSpsPps(byte[] bArr, boolean z10, boolean z11);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpsInfo)) {
            return false;
        }
        SpsInfo spsInfo = (SpsInfo) obj;
        return spsInfo.width == this.width && spsInfo.height == this.height && com.tencent.liteav.base.util.i.a(this.videoFormat, spsInfo.videoFormat) && com.tencent.liteav.base.util.i.a(this.videoFullRangeFlag, spsInfo.videoFullRangeFlag) && com.tencent.liteav.base.util.i.a(this.colourPrimaries, spsInfo.colourPrimaries) && com.tencent.liteav.base.util.i.a(this.transferCharacteristics, spsInfo.transferCharacteristics) && com.tencent.liteav.base.util.i.a(this.matrixCoefficients, spsInfo.matrixCoefficients) && com.tencent.liteav.base.util.i.a(this.maxNumRefFrames, spsInfo.maxNumRefFrames);
    }

    public void set(SpsInfo spsInfo) {
        if (spsInfo == null) {
            spsInfo = new SpsInfo();
        }
        this.width = spsInfo.width;
        this.height = spsInfo.height;
        this.videoFormat = spsInfo.videoFormat;
        this.videoFullRangeFlag = spsInfo.videoFullRangeFlag;
        this.colourPrimaries = spsInfo.colourPrimaries;
        this.transferCharacteristics = spsInfo.transferCharacteristics;
        this.matrixCoefficients = spsInfo.matrixCoefficients;
        this.maxNumRefFrames = spsInfo.maxNumRefFrames;
    }

    @CalledByNative
    public void setColourPrimaries(int i10) {
        this.colourPrimaries = Integer.valueOf(i10);
    }

    @CalledByNative
    public void setHeight(int i10) {
        this.height = i10;
    }

    @CalledByNative
    public void setMatrixCoefficients(int i10) {
        this.matrixCoefficients = Integer.valueOf(i10);
    }

    @CalledByNative
    public void setMaxNumRefFrames(int i10) {
        this.maxNumRefFrames = Integer.valueOf(i10);
    }

    @CalledByNative
    public void setTransferCharacteristics(int i10) {
        this.transferCharacteristics = Integer.valueOf(i10);
    }

    @CalledByNative
    public void setVideoFormat(int i10) {
        this.videoFormat = Integer.valueOf(i10);
    }

    @CalledByNative
    public void setVideoFullRangeFlag(int i10) {
        this.videoFullRangeFlag = Integer.valueOf(i10);
    }

    @CalledByNative
    public void setWidth(int i10) {
        this.width = i10;
    }

    @NonNull
    public String toString() {
        return "SpsInfo(" + ("width=" + this.width + ",height=" + this.height + ",videoFormat=" + ((Object) this.videoFormat) + ",videoFullRangeFlag=" + ((Object) this.videoFullRangeFlag) + ",colourPrimaries=" + ((Object) this.colourPrimaries) + ",transferCharacteristics=" + ((Object) this.transferCharacteristics) + ",matrixCoefficients=" + ((Object) this.matrixCoefficients) + ",maxNumRefFrames=" + ((Object) this.maxNumRefFrames)) + ")";
    }
}
