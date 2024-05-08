package com.tencent.liteav.videobase.common;

import android.media.MediaCodec;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class EncodedVideoFrame {
    private static final String TAG = "EncodedVideoFrame";
    public ByteBuffer data;
    public long dts;
    public int height;
    public long pts;
    public int rotation;
    public MediaFormat videoFormat;
    public int width;
    public final ProducerChainTimestamp producerChainTimestamp = new ProducerChainTimestamp();
    public final ConsumerChainTimestamp consumerChainTimestamp = new ConsumerChainTimestamp();
    public long nativePtr = 0;
    public c nalType = c.UNKNOWN;
    public d profileType = d.UNKNOWN;
    public CodecType codecType = CodecType.H264;
    public long gopIndex = 0;
    public long gopFrameIndex = 0;
    public long frameIndex = 0;
    public long refFrameIndex = 0;
    public Integer svcInfo = null;
    public boolean isEosFrame = false;
    public b hdrType = b.UNKNOWN;
    public MediaCodec.BufferInfo info = null;

    @CalledByNative
    public static EncodedVideoFrame createEncodedVideoFrame(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10, long j11, long j12, long j13, long j14, long j15, int i13, long j16, int i14, int i15, boolean z10, int i16, int i17) {
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        encodedVideoFrame.data = byteBuffer;
        encodedVideoFrame.nativePtr = j16;
        encodedVideoFrame.nalType = c.a(i10);
        encodedVideoFrame.profileType = d.a(i11);
        encodedVideoFrame.codecType = CodecType.a(i13);
        encodedVideoFrame.rotation = i12;
        encodedVideoFrame.dts = j10;
        encodedVideoFrame.pts = j11;
        encodedVideoFrame.gopIndex = j12;
        encodedVideoFrame.gopFrameIndex = j13;
        encodedVideoFrame.frameIndex = j14;
        encodedVideoFrame.refFrameIndex = j15;
        encodedVideoFrame.info = null;
        encodedVideoFrame.width = i14;
        encodedVideoFrame.height = i15;
        if (z10) {
            encodedVideoFrame.svcInfo = Integer.valueOf(i16);
        } else {
            encodedVideoFrame.svcInfo = null;
        }
        encodedVideoFrame.hdrType = b.a(i17);
        return encodedVideoFrame;
    }

    private c getNalTypeFromH264NALHeader(ByteBuffer byteBuffer, int i10) {
        int i11 = byteBuffer.get(i10) & 31;
        if (i11 == 5) {
            return c.IDR;
        }
        if (i11 == 6) {
            return c.SEI;
        }
        if (i11 == 7) {
            return c.SPS;
        }
        if (i11 != 8) {
            return c.UNKNOWN;
        }
        return c.PPS;
    }

    private c getNalTypeFromH265NALHeader(ByteBuffer byteBuffer, int i10) {
        int i11 = (byteBuffer.get(i10) & 126) >> 1;
        if (i11 != 39) {
            switch (i11) {
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    return c.IDR;
                default:
                    switch (i11) {
                        case 32:
                            return c.VPS;
                        case 33:
                            return c.SPS;
                        case 34:
                            return c.PPS;
                        default:
                            return c.UNKNOWN;
                    }
            }
        }
        return c.SEI;
    }

    public static int getNextNALHeaderPos(int i10, ByteBuffer byteBuffer) {
        while (true) {
            int i11 = i10 + 3;
            if (i11 >= byteBuffer.remaining()) {
                return -1;
            }
            if (byteBuffer.get(i10) == 0 && byteBuffer.get(i10 + 1) == 0 && byteBuffer.get(i10 + 2) == 0 && byteBuffer.get(i11) == 1) {
                return i10 + 4;
            }
            if (byteBuffer.get(i10) == 0 && byteBuffer.get(i10 + 1) == 0 && byteBuffer.get(i10 + 2) == 1) {
                return i11;
            }
            i10++;
        }
    }

    private native void nativeRelease(long j10);

    @CalledByNative
    public static long resetEncodedVideoFrame(EncodedVideoFrame encodedVideoFrame) {
        long j10 = encodedVideoFrame.nativePtr;
        if (j10 == 0 || encodedVideoFrame.data == null) {
            return 0L;
        }
        encodedVideoFrame.data = null;
        encodedVideoFrame.nativePtr = 0L;
        return j10;
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativePtr != 0) {
            LiteavLog.w(TAG, "nativePtr != 0, must call release before finalize ");
            release();
        }
    }

    public boolean isH265() {
        return this.codecType == CodecType.H265;
    }

    public boolean isHDRFrame() {
        b bVar = this.hdrType;
        return (bVar == null || bVar == b.UNKNOWN) ? false : true;
    }

    public boolean isIDRFrame() {
        c cVar = this.nalType;
        if (cVar != null) {
            if (cVar == c.IDR) {
                return true;
            }
        }
        return false;
    }

    public boolean isRPSEnable() {
        d dVar = this.profileType;
        return dVar == d.BASELINE_RPS || dVar == d.MAIN_RPS || dVar == d.HIGH_RPS;
    }

    public boolean isSVCEnable() {
        return this.svcInfo != null;
    }

    public boolean isValidFrame() {
        ByteBuffer byteBuffer = this.data;
        return byteBuffer != null && byteBuffer.remaining() > 0 && this.nalType != null && this.codecType != null && this.width > 0 && this.height > 0;
    }

    public void release() {
        long j10 = this.nativePtr;
        if (j10 != 0) {
            nativeRelease(j10);
            this.nativePtr = 0L;
        }
    }

    @NonNull
    public String toString() {
        return "nalType = " + ((Object) this.nalType) + ", profiletype=" + ((Object) this.profileType) + ", rotation=" + this.rotation + ", codecType=" + ((Object) this.codecType) + ", dts=" + this.dts + ", pts=" + this.pts + ", gopIndex=" + this.gopIndex + ", gopFrameIndex=" + this.gopFrameIndex + ", frameIndex=" + this.frameIndex;
    }

    public void updateNALTypeAccordingNALHeader() {
        c nalTypeFromH264NALHeader;
        if (this.data == null) {
            return;
        }
        c cVar = this.nalType;
        if (cVar != null && cVar != c.UNKNOWN) {
            return;
        }
        int i10 = 0;
        while (true) {
            i10 = getNextNALHeaderPos(i10, this.data);
            if (i10 == -1 || i10 >= this.data.remaining()) {
                return;
            }
            c cVar2 = c.UNKNOWN;
            if (isH265()) {
                nalTypeFromH264NALHeader = getNalTypeFromH265NALHeader(this.data, i10);
            } else {
                nalTypeFromH264NALHeader = getNalTypeFromH264NALHeader(this.data, i10);
            }
            c cVar3 = this.nalType;
            if (cVar3 == null || cVar3 == cVar2 || nalTypeFromH264NALHeader == c.IDR) {
                this.nalType = nalTypeFromH264NALHeader;
            }
            c cVar4 = this.nalType;
            if (cVar4 != c.SPS && cVar4 != c.PPS && cVar4 != c.VPS && cVar4 != c.SEI) {
                return;
            }
        }
    }
}
