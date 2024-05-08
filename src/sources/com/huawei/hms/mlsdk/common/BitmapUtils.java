package com.huawei.hms.mlsdk.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.huawei.hms.ml.common.utils.StreamUtils;
import com.huawei.hms.mlsdk.common.MLFrame;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class BitmapUtils {
    private static final String TAG = "BitmapUtils";

    public static Bitmap cut(Bitmap bitmap, Point[] pointArr, int i10) {
        if (bitmap == null || pointArr == null || pointArr.length != 4) {
            return null;
        }
        for (Point point : pointArr) {
            if (point == null) {
                return null;
            }
        }
        Point point2 = pointArr[0];
        Point point3 = pointArr[1];
        Point point4 = pointArr[2];
        double atan2 = Math.atan2(point3.y - point2.y, point3.x - point2.x);
        float degrees = (float) Math.toDegrees(atan2);
        if (Math.abs((int) degrees) <= 0) {
            return cutPaddingExtendRect(bitmap, point2, point4, 0, 0, i10);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i11 = width >> 1;
        int i12 = height >> 1;
        Point point5 = new Point(i11, i12);
        Matrix matrix = new Matrix();
        matrix.setRotate(-degrees, i11, i12);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        return cutPaddingExtendRect(createBitmap, rotateCoordinate(bitmap, point5, point2, atan2), rotateCoordinate(bitmap, point5, point4, atan2), (createBitmap.getWidth() - width) >> 1, (createBitmap.getHeight() - height) >> 1, i10);
    }

    private static Bitmap cutPaddingExtendRect(Bitmap bitmap, Point point, Point point2, int i10, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i13 = (point.x + i10) - i12;
        if (i13 < 0) {
            i13 = 0;
        }
        int i14 = (point.y + i11) - i12;
        int i15 = i14 >= 0 ? i14 : 0;
        int i16 = point2.x + i10 + i12;
        if (i16 <= width) {
            width = i16;
        }
        int i17 = point2.y + i11 + i12;
        if (i17 <= height) {
            height = i17;
        }
        return Bitmap.createBitmap(bitmap, i13, i15, width - i13, height - i15);
    }

    public static Bitmap getBitmap(ByteBuffer byteBuffer, MLFrame.Property property) {
        YuvImage yuvImage;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteBuffer.rewind();
            int limit = byteBuffer.limit();
            byte[] bArr = new byte[limit];
            byteBuffer.get(bArr, 0, limit);
            yuvImage = new YuvImage(bArr, 17, property.getWidth(), property.getHeight(), null);
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            yuvImage.compressToJpeg(new Rect(0, 0, property.getWidth(), property.getHeight()), 100, byteArrayOutputStream);
            Bitmap rotateBitmap = rotateBitmap(BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size()), property.getQuadrant());
            StreamUtils.closeStreams(byteArrayOutputStream);
            return rotateBitmap;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            StreamUtils.closeStreams(byteArrayOutputStream2);
            throw th;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i10) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i10 != 1 ? i10 != 2 ? i10 != 3 ? 0 : 270 : 180 : 90);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static Point rotateCoordinate(Bitmap bitmap, Point point, Point point2, double d10) {
        int height = bitmap.getHeight();
        int i10 = point2.x;
        int i11 = height - point2.y;
        int i12 = point.x;
        int i13 = height - point.y;
        double d11 = i10 - i12;
        double d12 = i11 - i13;
        return new Point((int) (((Math.cos(d10) * d11) - (Math.sin(d10) * d12)) + i12), height - ((int) (((d11 * Math.sin(d10)) + (d12 * Math.cos(d10))) + i13)));
    }
}
