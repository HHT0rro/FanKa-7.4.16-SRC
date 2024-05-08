package com.huawei.hms.mlsdk.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Pair;
import com.huawei.hms.ml.common.utils.ImageConvertUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MLFrame {
    public static final int SCREEN_FIRST_QUADRANT = 0;
    public static final int SCREEN_FOURTH_QUADRANT = 3;
    public static final int SCREEN_SECOND_QUADRANT = 1;
    public static final int SCREEN_THIRD_QUADRANT = 2;
    private Bitmap bitmap;
    private ByteBuffer byteBuffer;
    private byte[] bytes;
    private volatile Boolean frameInit;
    private Property property;
    private int recMode;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Creator {
        private MLFrame frame = new MLFrame();

        public MLFrame create() {
            if (this.frame.byteBuffer == null && this.frame.bitmap == null) {
                throw new IllegalStateException("Failed to create image instance, both bitmap and byteBuffer data are not specified.");
            }
            return this.frame;
        }

        public Creator setBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.frame.bitmap = bitmap;
            Property acquireProperty = this.frame.acquireProperty();
            acquireProperty.width = width;
            acquireProperty.height = height;
            return this;
        }

        public Creator setFramePropertyExt(Property.Ext ext) {
            this.frame.acquireProperty().ext = ext;
            return this;
        }

        public Creator setItemIdentity(int i10) {
            this.frame.acquireProperty().itemIdentity = i10;
            return this;
        }

        public Creator setQuadrant(int i10) {
            this.frame.acquireProperty().quadrant = i10;
            return this;
        }

        public Creator setTimestamp(long j10) {
            this.frame.acquireProperty().timestamp = j10;
            return this;
        }

        public Creator writeByteBufferData(ByteBuffer byteBuffer, int i10, int i11, int i12) {
            if (byteBuffer != null) {
                if (byteBuffer.capacity() < i10 * i11) {
                    throw new IllegalArgumentException("Not enough capacity for image data size.");
                }
                if (i12 != 17 && i12 != 16 && i12 != 842094169) {
                    throw new IllegalArgumentException("Parameter formatType:" + i12 + " is not supported");
                }
                this.frame.byteBuffer = byteBuffer;
                Property acquireProperty = this.frame.acquireProperty();
                if (acquireProperty != null) {
                    acquireProperty.formatType = i12;
                    acquireProperty.width = i10;
                    acquireProperty.height = i11;
                }
                return this;
            }
            throw new IllegalArgumentException("Parameter： data is not specified");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Property {
        public static final int IMAGE_FORMAT_NV21 = 17;
        public static final int IMAGE_FORMAT_YV12 = 842094169;
        public static final int SCREEN_FIRST_QUADRANT = 0;
        public static final int SCREEN_FOURTH_QUADRANT = 3;
        public static final int SCREEN_SECOND_QUADRANT = 1;
        public static final int SCREEN_THIRD_QUADRANT = 2;
        private Ext ext;
        private int formatType;
        private int height;
        private int itemIdentity;
        private int quadrant;
        private long timestamp;
        private int width;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static class Creator {
            private Ext ext;
            private int formatType;
            private int height;
            private int itemIdentity;
            private int quadrant;
            private long timestamp;
            private int width;

            public Property create() {
                return new Property(this.width, this.height, this.quadrant, this.formatType, this.itemIdentity, this.timestamp, this.ext);
            }

            public Creator setExt(Ext ext) {
                this.ext = ext;
                return this;
            }

            public Creator setFormatType(int i10) {
                this.formatType = i10;
                return this;
            }

            public Creator setHeight(int i10) {
                this.height = i10;
                return this;
            }

            public Creator setItemIdentity(int i10) {
                this.itemIdentity = i10;
                return this;
            }

            public Creator setQuadrant(int i10) {
                this.quadrant = i10;
                return this;
            }

            public Creator setTimestamp(int i10) {
                this.timestamp = i10;
                return this;
            }

            public Creator setWidth(int i10) {
                this.width = i10;
                return this;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static class Ext {
            private int lensId;
            private int maxZoom;
            private Rect rect;
            private int zoom;

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
            public static class Creator {
                private int maxZoom;
                private Rect rect;
                private int lensId = 0;
                private int zoom = 0;

                public Ext build() {
                    return new Ext(this.lensId, this.zoom, this.maxZoom, this.rect);
                }

                public Creator setLensId(int i10) {
                    this.lensId = i10;
                    return this;
                }

                public Creator setMaxZoom(int i10) {
                    this.maxZoom = i10;
                    return this;
                }

                public Creator setRect(Rect rect) {
                    this.rect = rect;
                    return this;
                }

                public Creator setZoom(int i10) {
                    this.zoom = i10;
                    return this;
                }
            }

            public int getLensId() {
                return this.lensId;
            }

            public int getMaxZoom() {
                return this.maxZoom;
            }

            public Rect getRect() {
                return this.rect;
            }

            public int getZoom() {
                return this.zoom;
            }

            private Ext(int i10, int i11, int i12, Rect rect) {
                this.lensId = i10;
                this.zoom = i11;
                this.maxZoom = i12;
                this.rect = rect;
            }
        }

        public Ext getExt() {
            return this.ext;
        }

        public int getFormatType() {
            return this.formatType;
        }

        public int getHeight() {
            return this.height;
        }

        public int getItemIdentity() {
            return this.itemIdentity;
        }

        public int getQuadrant() {
            return this.quadrant;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public int getWidth() {
            return this.width;
        }

        public void resetWidthAndHeight() {
            if (this.quadrant % 2 != 0) {
                int i10 = this.width;
                this.width = this.height;
                this.height = i10;
            }
            this.quadrant = 0;
        }

        public Property() {
            this.quadrant = 0;
            this.formatType = -1;
            this.itemIdentity = -1;
            this.ext = new Ext.Creator().build();
        }

        public Property(Property property) {
            this.quadrant = 0;
            this.formatType = -1;
            this.itemIdentity = -1;
            this.width = property.getWidth();
            this.height = property.getHeight();
            this.formatType = property.getFormatType();
            this.quadrant = property.getQuadrant();
            this.itemIdentity = property.getItemIdentity();
            this.timestamp = property.getTimestamp();
            this.ext = property.getExt();
        }

        private Property(int i10, int i11, int i12, int i13, int i14, long j10, Ext ext) {
            this.width = i10;
            this.height = i11;
            this.quadrant = i12;
            this.formatType = i13;
            this.itemIdentity = i14;
            this.timestamp = j10;
            this.ext = ext;
        }
    }

    public MLFrame() {
        this.frameInit = Boolean.FALSE;
        this.property = new Property();
        this.byteBuffer = null;
        this.bitmap = null;
    }

    public static MLFrame fromBitmap(Bitmap bitmap) {
        return new MLFrame(bitmap);
    }

    public static MLFrame fromByteArray(byte[] bArr, Property property) {
        return new MLFrame(bArr, property);
    }

    public static MLFrame fromByteBuffer(ByteBuffer byteBuffer, Property property) {
        return new MLFrame(byteBuffer, property);
    }

    public static MLFrame fromFilePath(Context context, Uri uri) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("Parameter context is mandatory");
        }
        if (uri != null) {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
            Objects.requireNonNull(bitmap, "Failed to load bitmap from uri");
            return new MLFrame(bitmap);
        }
        throw new IllegalArgumentException("Parameter uri is mandatory");
    }

    public static MLFrame fromMediaImage(Image image, int i10) {
        int format = image.getFormat();
        if (format != 256 && format != 35) {
            throw new IllegalArgumentException("Unsupported format: " + image.getFormat() + ", Only JPEG and YUV_420_888 are supported");
        }
        MLFrame mLFrame = null;
        if (format == 256) {
            Image.Plane[] planes = image.getPlanes();
            if (planes != null && planes.length == 1 && planes[0] != null && planes[0].getBuffer() != null) {
                ByteBuffer buffer = planes[0].getBuffer();
                int remaining = buffer.remaining();
                byte[] bArr = new byte[remaining];
                buffer.get(bArr);
                if (i10 != 0) {
                    mLFrame = new MLFrame(rotate(BitmapFactory.decodeByteArray(bArr, 0, remaining), i10));
                } else {
                    mLFrame = new MLFrame(bArr);
                }
            }
        } else {
            Property.Creator creator = new Property.Creator();
            creator.setFormatType(17).setWidth(image.getWidth()).setHeight(image.getHeight()).setQuadrant(i10);
            mLFrame = new MLFrame(ImageConvertUtils.getDataFromImage(image, 2), creator.create());
        }
        if (mLFrame != null) {
            return mLFrame;
        }
        throw new IllegalStateException("Failed to create frame from media image.");
    }

    private Pair<Integer, Integer> getPreviewSize() {
        Property property = this.property;
        if (property == null) {
            return null;
        }
        if (property.getItemIdentity() != -1) {
            boolean z10 = true;
            if (this.property.getQuadrant() != 1 && this.property.getQuadrant() != 3) {
                z10 = false;
            }
            Property property2 = this.property;
            return Pair.create(Integer.valueOf(z10 ? property2.getHeight() : property2.getWidth()), Integer.valueOf(z10 ? this.property.getWidth() : this.property.getHeight()));
        }
        return Pair.create(Integer.valueOf(wrapBitmap().getWidth()), Integer.valueOf(wrapBitmap().getHeight()));
    }

    private boolean isSupportedYuvFormat(int i10) {
        return i10 == 842094169 || i10 == 17;
    }

    public static Bitmap rotate(Bitmap bitmap, int i10) {
        if (i10 < 0 || i10 > 3) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Invalid quadrant: ");
            sb2.append(i10);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i10 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i10 * 90);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private final Bitmap wrapBitmap() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            return bitmap;
        }
        if (this.property != null) {
            try {
                byte[] wrapJpeg = wrapJpeg(false);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(wrapJpeg, 0, wrapJpeg.length);
                if (this.property.getQuadrant() != 0) {
                    decodeByteArray = rotate(decodeByteArray, this.property.getQuadrant());
                }
                this.bitmap = decodeByteArray;
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | Exception unused) {
                return null;
            }
        }
        return this.bitmap;
    }

    public ByteBuffer acquireGrayByteBuffer() {
        ByteBuffer byteBuffer = this.byteBuffer;
        if (byteBuffer != null && this.property != null) {
            ImageConvertUtils.nv21ToGray(byteBuffer.array(), this.property.width, this.property.height);
        }
        return this.byteBuffer;
    }

    public Property acquireProperty() {
        return this.property;
    }

    public final Pair<byte[], Float> create(int i10, int i11) {
        byte[] bitmap2Jpeg;
        if (getPreviewSize() == null) {
            return null;
        }
        int intValue = ((Integer) getPreviewSize().first).intValue();
        int intValue2 = ((Integer) getPreviewSize().second).intValue();
        float min = Math.min(i10 / intValue, i11 / intValue2);
        float f10 = 1.0f;
        if (min >= 1.0f) {
            bitmap2Jpeg = wrapJpeg(true);
        } else {
            Matrix matrix = new Matrix();
            matrix.postScale(min, min);
            f10 = min;
            bitmap2Jpeg = ImageConvertUtils.bitmap2Jpeg(Bitmap.createBitmap(wrapBitmap(), 0, 0, intValue, intValue2, matrix, true), 100);
        }
        return Pair.create(bitmap2Jpeg, Float.valueOf(f10));
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public final synchronized MLFrame getFrame(boolean z10, boolean z11) {
        if (this.frameInit.booleanValue()) {
            return this;
        }
        if (!z10 && this.byteBuffer != null) {
            int formatType = this.property.getFormatType();
            if (z11 && formatType != 17) {
                if (formatType == 842094169) {
                    this.byteBuffer = ByteBuffer.wrap(ImageConvertUtils.byteToNv21(ImageConvertUtils.buffer2Byte(this.byteBuffer)));
                }
                Property.Creator creator = new Property.Creator();
                creator.setFormatType(17).setWidth(this.property.getWidth()).setHeight(this.property.getHeight()).setQuadrant(this.property.getQuadrant());
                this.property = creator.create();
                this.frameInit = Boolean.TRUE;
                return this;
            }
            this.frameInit = Boolean.TRUE;
            return this;
        }
        this.bitmap = getPreviewBitmap();
        this.property = new Creator().setBitmap(readBitmap()).create().property;
        this.frameInit = Boolean.TRUE;
        return this;
    }

    public Bitmap getPreviewBitmap() {
        if (this.bytes == null && this.byteBuffer == null && this.bitmap == null) {
            throw new IllegalStateException("At least one of bytes, byteBuffer or bitmap should be not null");
        }
        return wrapBitmap();
    }

    public int getRecMode() {
        return this.recMode;
    }

    public final void initialize() {
        ByteBuffer byteBuffer = this.byteBuffer;
        if (byteBuffer != null) {
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
            byteBuffer.rewind();
            allocate.put(byteBuffer);
            byteBuffer.rewind();
            allocate.flip();
            this.byteBuffer = allocate;
        }
    }

    public Bitmap readBitmap() {
        return this.bitmap;
    }

    public void setRecMode(int i10) {
        this.recMode = i10;
    }

    public final byte[] wrapJpeg(boolean z10) {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = null;
        if (this.byteBuffer != null) {
            int formatType = this.property.getFormatType();
            if (isSupportedYuvFormat(formatType)) {
                if (!z10 || this.property.getQuadrant() == 0) {
                    byte[] buffer2Byte = ImageConvertUtils.buffer2Byte(this.byteBuffer);
                    if (842094169 == formatType) {
                        buffer2Byte = ImageConvertUtils.byteToNv21(buffer2Byte);
                    }
                    bArr2 = ImageConvertUtils.nv21ToJpeg(buffer2Byte, this.property.getWidth(), this.property.getHeight());
                    if (this.property.getQuadrant() == 0) {
                        this.bytes = bArr2;
                    }
                }
            } else {
                throw new IllegalStateException("Only support NV21 or YV12");
            }
        }
        if (bArr2 != null) {
            return bArr2;
        }
        byte[] bitmap2Jpeg = ImageConvertUtils.bitmap2Jpeg(wrapBitmap(), 100);
        this.bytes = bitmap2Jpeg;
        return bitmap2Jpeg;
    }

    private MLFrame(ByteBuffer byteBuffer, Property property) {
        this.frameInit = Boolean.FALSE;
        this.byteBuffer = byteBuffer;
        this.property = property == null ? new Property() : property;
    }

    private MLFrame(byte[] bArr, Property property) {
        this(ByteBuffer.wrap(bArr), property);
    }

    private MLFrame(Bitmap bitmap) {
        this.frameInit = Boolean.FALSE;
        this.bitmap = bitmap;
    }

    private MLFrame(Bitmap bitmap, Property property) {
        this.frameInit = Boolean.FALSE;
        this.bitmap = bitmap;
        this.property = property == null ? new Property() : property;
    }

    private MLFrame(byte[] bArr) {
        this.frameInit = Boolean.FALSE;
        this.bytes = bArr;
    }
}
