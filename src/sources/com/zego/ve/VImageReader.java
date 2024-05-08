package com.zego.ve;

import android.media.Image;
import android.media.ImageReader;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class VImageReader implements ImageReader.OnImageAvailableListener {
    private static final String TAG = "VImageReader";
    private long pthis = 0;
    private ImageReader mImgRdr = null;
    private Image mImg = null;
    private Object mLock = new Object();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ImageReaderBuffer {
        private long nTimeStamp;
        private ByteBuffer uBuffer;
        private ByteBuffer vBuffer;
        private ByteBuffer yBuffer;

        public ImageReaderBuffer(Image.Plane[] planeArr, long j10) {
            this.yBuffer = planeArr[0].getBuffer();
            this.uBuffer = planeArr[1].getBuffer();
            this.vBuffer = planeArr[2].getBuffer();
            this.nTimeStamp = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ImageReaderFormat {
        public int height;
        public int uvPixelStride;
        public int uvStride;
        public int width;
        public int yStride;

        public ImageReaderFormat(int i10, int i11, Image.Plane[] planeArr) {
            this.width = i10;
            this.height = i11;
            this.yStride = planeArr[0].getRowStride();
            this.uvStride = planeArr[1].getRowStride();
            this.uvPixelStride = planeArr[1].getPixelStride();
        }
    }

    private void closeImage() {
        Image image = this.mImg;
        if (image != null) {
            image.close();
        }
    }

    private ImageReaderBuffer getImageReaderBuffer() {
        try {
            Image acquireLatestImage = this.mImgRdr.acquireLatestImage();
            this.mImg = acquireLatestImage;
            if (acquireLatestImage == null) {
                return null;
            }
            Image.Plane[] planes = acquireLatestImage.getPlanes();
            long timestamp = this.mImg.getTimestamp();
            if (planes.length > 1) {
                return new ImageReaderBuffer(planes, timestamp);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private ImageReaderFormat getImageReaderFormat() {
        try {
            Image acquireLatestImage = this.mImgRdr.acquireLatestImage();
            this.mImg = acquireLatestImage;
            if (acquireLatestImage == null) {
                return null;
            }
            Image.Plane[] planes = acquireLatestImage.getPlanes();
            if (planes.length > 1) {
                return new ImageReaderFormat(this.mImg.getWidth(), this.mImg.getHeight(), planes);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static native int on_image(long j10, int i10);

    public int create(long j10, int i10, int i11) {
        this.pthis = j10;
        try {
            ImageReader newInstance = ImageReader.newInstance(i10, i11, 35, 2);
            this.mImgRdr = newInstance;
            newInstance.setOnImageAvailableListener(this, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ImageReader imageReader = this.mImgRdr;
        if (imageReader == null) {
            return -1;
        }
        return imageReader.hashCode();
    }

    public void destroy() {
        synchronized (this.mLock) {
            this.pthis = 0L;
        }
        Image image = this.mImg;
        if (image != null) {
            image.close();
            this.mImg = null;
        }
        this.mImgRdr.setOnImageAvailableListener(null, null);
        this.mImgRdr.close();
        this.mImgRdr = null;
    }

    public ImageReader get() {
        return this.mImgRdr;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        try {
            synchronized (this.mLock) {
                long j10 = this.pthis;
                if (j10 != 0) {
                    on_image(j10, imageReader.hashCode());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
