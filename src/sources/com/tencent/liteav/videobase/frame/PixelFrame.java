package com.tencent.liteav.videobase.frame;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import java.nio.ByteBuffer;
import java.util.Collection;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PixelFrame extends k {
    public ByteBuffer mBuffer;
    private GLConstants.ColorRange mColorRange;
    private GLConstants.ColorSpace mColorSpace;
    public ConsumerChainTimestamp mConsumerChainTimestamp;
    public byte[] mData;
    public Object mGLContext;
    public int mHeight;
    private boolean mIsMirrorHorizontal;
    private boolean mIsMirrorVertical;
    private float[] mMatrix;
    public FrameMetaData mMetaData;
    public GLConstants.PixelBufferType mPixelBufferType;
    public GLConstants.PixelFormatType mPixelFormatType;
    public ProducerChainTimestamp mProducerChainTimestamp;
    private Rotation mRotation;
    public int mTextureId;
    private long mTimestamp;
    public int mWidth;

    public PixelFrame() {
        super(null);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = Rotation.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
    }

    public static PixelFrame createFromBitmap(@NonNull Bitmap bitmap) {
        int width = (bitmap.getWidth() / 2) * 2;
        int height = (bitmap.getHeight() / 2) * 2;
        if (width != 0 && height != 0 && (bitmap.getWidth() % 2 != 0 || bitmap.getHeight() % 2 != 0)) {
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
        }
        ByteBuffer b4 = com.tencent.liteav.videobase.utils.j.b(bitmap.getWidth() * 4 * bitmap.getHeight());
        if (b4 == null) {
            return null;
        }
        bitmap.copyPixelsToBuffer(b4);
        b4.position(0);
        PixelFrame pixelFrame = new PixelFrame();
        pixelFrame.setBuffer(b4);
        pixelFrame.setWidth(bitmap.getWidth());
        pixelFrame.setHeight(bitmap.getHeight());
        pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.BYTE_BUFFER);
        pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
        return pixelFrame;
    }

    @CalledByNative
    private int getColorRangeValue() {
        return this.mColorRange.getValue();
    }

    @CalledByNative
    private int getColorSpaceValue() {
        return this.mColorSpace.getValue();
    }

    @CalledByNative
    private int getPixelBufferTypeValue() {
        return this.mPixelBufferType.mValue;
    }

    @CalledByNative
    private int getPixelFormatTypeValue() {
        return this.mPixelFormatType.getValue();
    }

    @CalledByNative
    private int getRotationValue() {
        return this.mRotation.mValue;
    }

    public static void releasePixelFrames(Collection<PixelFrame> collection) {
        if (collection == null) {
            return;
        }
        for (PixelFrame pixelFrame : collection) {
            if (pixelFrame != null) {
                pixelFrame.release();
            }
        }
        collection.clear();
    }

    @CalledByNative
    public void copy(PixelFrame pixelFrame) {
        this.mTimestamp = pixelFrame.mTimestamp;
        this.mWidth = pixelFrame.mWidth;
        this.mHeight = pixelFrame.mHeight;
        this.mPixelBufferType = pixelFrame.mPixelBufferType;
        this.mPixelFormatType = pixelFrame.mPixelFormatType;
        this.mRotation = pixelFrame.mRotation;
        this.mIsMirrorHorizontal = pixelFrame.mIsMirrorHorizontal;
        this.mIsMirrorVertical = pixelFrame.mIsMirrorVertical;
        if (pixelFrame.mMatrix != null) {
            this.mMatrix = new float[16];
            float[] matrix = pixelFrame.getMatrix();
            float[] fArr = this.mMatrix;
            System.arraycopy((Object) matrix, 0, (Object) fArr, 0, fArr.length);
        }
        this.mMatrix = pixelFrame.mMatrix;
        this.mData = pixelFrame.mData;
        this.mBuffer = pixelFrame.mBuffer;
        this.mTextureId = pixelFrame.mTextureId;
        this.mGLContext = pixelFrame.mGLContext;
        this.mMetaData = pixelFrame.mMetaData;
        this.mConsumerChainTimestamp = pixelFrame.mConsumerChainTimestamp;
        this.mProducerChainTimestamp = pixelFrame.mProducerChainTimestamp;
        this.mColorSpace = pixelFrame.mColorSpace;
        this.mColorRange = pixelFrame.mColorRange;
    }

    @CalledByNative
    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public GLConstants.ColorRange getColorRange() {
        return this.mColorRange;
    }

    public GLConstants.ColorSpace getColorSpace() {
        return this.mColorSpace;
    }

    public ConsumerChainTimestamp getConsumerChainTimestamp() {
        if (this.mConsumerChainTimestamp == null) {
            this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
        }
        return this.mConsumerChainTimestamp;
    }

    @CalledByNative
    public byte[] getData() {
        return this.mData;
    }

    @CalledByNative
    public Object getGLContext() {
        return this.mGLContext;
    }

    @CalledByNative
    public long getGLContextNativeHandle() {
        return OpenGlUtils.getGLContextNativeHandle(this.mGLContext);
    }

    @CalledByNative
    public int getHeight() {
        return this.mHeight;
    }

    public float[] getMatrix() {
        return this.mMatrix;
    }

    @CalledByNative
    public FrameMetaData getMetaData() {
        return this.mMetaData;
    }

    public GLConstants.PixelBufferType getPixelBufferType() {
        return this.mPixelBufferType;
    }

    public GLConstants.PixelFormatType getPixelFormatType() {
        return this.mPixelFormatType;
    }

    public ProducerChainTimestamp getProducerChainTimestamp() {
        if (this.mProducerChainTimestamp == null) {
            this.mProducerChainTimestamp = new ProducerChainTimestamp();
        }
        return this.mProducerChainTimestamp;
    }

    public Rotation getRotation() {
        return this.mRotation;
    }

    @CalledByNative
    public int getTextureId() {
        return this.mTextureId;
    }

    @CalledByNative
    public long getTimestamp() {
        return this.mTimestamp;
    }

    @CalledByNative
    public int getWidth() {
        return this.mWidth;
    }

    public boolean hasTransformParams() {
        return this.mRotation != Rotation.NORMAL || this.mIsMirrorHorizontal || this.mIsMirrorVertical || this.mMatrix != null;
    }

    public boolean isFrameDataValid() {
        GLConstants.PixelBufferType pixelBufferType = this.mPixelBufferType;
        if (pixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D && this.mTextureId == -1) {
            return false;
        }
        if (pixelBufferType == GLConstants.PixelBufferType.BYTE_BUFFER && this.mBuffer == null) {
            return false;
        }
        return (pixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY && this.mData == null) ? false : true;
    }

    public boolean isMirrorHorizontal() {
        return this.mIsMirrorHorizontal;
    }

    public boolean isMirrorVertical() {
        return this.mIsMirrorVertical;
    }

    public void postRotate(Rotation rotation) {
        if (rotation == Rotation.ROTATION_90 || rotation == Rotation.ROTATION_270) {
            swapWidthHeight();
        }
        setRotation(Rotation.a((this.mRotation.mValue + rotation.mValue) % 360));
    }

    @Override // com.tencent.liteav.videobase.frame.k
    @CalledByNative
    public void release() {
        super.release();
    }

    public void reset() {
        this.mTimestamp = 0L;
        this.mRotation = Rotation.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mMetaData = null;
        this.mProducerChainTimestamp = null;
        this.mConsumerChainTimestamp = null;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
    }

    @Override // com.tencent.liteav.videobase.frame.k
    @CalledByNative
    public int retain() {
        return super.retain();
    }

    public void setBuffer(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }

    public void setColorRange(GLConstants.ColorRange colorRange) {
        this.mColorRange = colorRange;
    }

    public void setColorSpace(GLConstants.ColorSpace colorSpace) {
        this.mColorSpace = colorSpace;
    }

    public void setConsumerChainTimestamp(ConsumerChainTimestamp consumerChainTimestamp) {
        this.mConsumerChainTimestamp = consumerChainTimestamp;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    @CalledByNative
    public void setGLContext(Object obj) {
        this.mGLContext = obj;
    }

    public void setHeight(int i10) {
        this.mHeight = i10;
    }

    public void setMatrix(float[] fArr) {
        this.mMatrix = fArr;
    }

    @CalledByNative
    public void setMetaData(FrameMetaData frameMetaData) {
        this.mMetaData = frameMetaData;
    }

    public void setMirrorHorizontal(boolean z10) {
        this.mIsMirrorHorizontal = z10;
    }

    public void setMirrorVertical(boolean z10) {
        this.mIsMirrorVertical = z10;
    }

    public void setPixelBufferType(GLConstants.PixelBufferType pixelBufferType) {
        this.mPixelBufferType = pixelBufferType;
    }

    public void setPixelFormatType(GLConstants.PixelFormatType pixelFormatType) {
        this.mPixelFormatType = pixelFormatType;
    }

    public void setProducerChainTimestamp(ProducerChainTimestamp producerChainTimestamp) {
        this.mProducerChainTimestamp = producerChainTimestamp;
    }

    public void setRotation(Rotation rotation) {
        this.mRotation = rotation;
    }

    @CalledByNative
    public void setTextureId(int i10) {
        this.mTextureId = i10;
    }

    @CalledByNative
    public void setTimestamp(long j10) {
        this.mTimestamp = j10;
    }

    public void setWidth(int i10) {
        this.mWidth = i10;
    }

    public void swapWidthHeight() {
        int i10 = this.mWidth;
        this.mWidth = this.mHeight;
        this.mHeight = i10;
    }

    public PixelFrame(PixelFrame pixelFrame) {
        super(null);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = Rotation.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
        copy(pixelFrame);
    }

    public PixelFrame(int i10, int i11, int i12, int i13, int i14) {
        this(null, i10, i11, i12, GLConstants.PixelBufferType.a(i13), GLConstants.PixelFormatType.a(i14));
    }

    public PixelFrame(g<PixelFrame> gVar, int i10, int i11, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
        this(gVar, i10, i11, pixelFormatType == GLConstants.PixelFormatType.RGBA ? i10 * i11 * 4 : ((i10 * i11) * 3) / 2, pixelBufferType, pixelFormatType);
    }

    public PixelFrame(g<PixelFrame> gVar, int i10, int i11, int i12, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
        super(gVar);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = Rotation.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
        this.mWidth = i10;
        this.mHeight = i11;
        this.mPixelFormatType = pixelFormatType;
        this.mPixelBufferType = pixelBufferType;
        if (pixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY) {
            this.mData = com.tencent.liteav.videobase.utils.j.a(i12);
        } else {
            this.mBuffer = com.tencent.liteav.videobase.utils.j.b(i12);
        }
    }

    public PixelFrame(g<? extends PixelFrame> gVar) {
        super(gVar);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = Rotation.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
    }
}
