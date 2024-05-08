package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: NinePatchTool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dm {
    public static Drawable a(Context context, String str) throws Exception {
        Bitmap b4 = b(context, str);
        if (b4.getNinePatchChunk() == null) {
            return new BitmapDrawable(context.getResources(), b4);
        }
        Rect rect = new Rect();
        a(b4.getNinePatchChunk(), rect);
        return new NinePatchDrawable(context.getResources(), b4, b4.getNinePatchChunk(), rect, null);
    }

    private static Bitmap b(Context context, String str) throws Exception {
        InputStream open = dr.a(context).open(str);
        Bitmap a10 = a(open);
        open.close();
        return a10;
    }

    private static Bitmap a(InputStream inputStream) throws Exception {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        byte[] a10 = a(decodeStream);
        if (!NinePatch.isNinePatchChunk(a10)) {
            return decodeStream;
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
        dx.a(decodeStream);
        if (Build.VERSION.SDK_INT >= 28) {
            Method declaredMethod = createBitmap.getClass().getDeclaredMethod("setNinePatchChunk", byte[].class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(createBitmap, a10);
        } else {
            Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
            declaredField.setAccessible(true);
            declaredField.set(createBitmap, a10);
        }
        return createBitmap;
    }

    private static void a(byte[] bArr, Rect rect) {
        rect.left = a(bArr, 12);
        rect.right = a(bArr, 16);
        rect.top = a(bArr, 20);
        rect.bottom = a(bArr, 24);
    }

    private static byte[] a(Bitmap bitmap) throws IOException {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i10 = 0; i10 < 32; i10++) {
            byteArrayOutputStream.write(0);
        }
        int i11 = width - 2;
        int[] iArr = new int[i11];
        bitmap.getPixels(iArr, 0, width, 1, 0, i11, 1);
        boolean z10 = iArr[0] == -16777216;
        boolean z11 = iArr[i11 + (-1)] == -16777216;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            if (i12 != iArr[i14]) {
                i13++;
                a(byteArrayOutputStream, i14);
                i12 = iArr[i14];
            }
        }
        if (z11) {
            i13++;
            a(byteArrayOutputStream, i11);
        }
        int i15 = i13 + 1;
        if (z10) {
            i15--;
        }
        if (z11) {
            i15--;
        }
        int i16 = height - 2;
        int[] iArr2 = new int[i16];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i16);
        boolean z12 = iArr2[0] == -16777216;
        boolean z13 = iArr2[i16 + (-1)] == -16777216;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i16; i19++) {
            if (i17 != iArr2[i19]) {
                i18++;
                a(byteArrayOutputStream, i19);
                i17 = iArr2[i19];
            }
        }
        if (z13) {
            i18++;
            a(byteArrayOutputStream, i16);
        }
        int i20 = i18 + 1;
        if (z12) {
            i20--;
        }
        if (z13) {
            i20--;
        }
        int i21 = 0;
        while (true) {
            int i22 = i15 * i20;
            if (i21 < i22) {
                a(byteArrayOutputStream, 1);
                i21++;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i13;
                byteArray[2] = (byte) i18;
                byteArray[3] = (byte) i22;
                a(bitmap, byteArray);
                return byteArray;
            }
        }
    }

    private static void a(Bitmap bitmap, byte[] bArr) {
        int width = bitmap.getWidth() - 2;
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, width, 1, bitmap.getHeight() - 1, width, 1);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= width) {
                break;
            }
            if (-16777216 == iArr[i11]) {
                a(bArr, 12, i11);
                break;
            }
            i11++;
        }
        int i12 = width - 1;
        while (true) {
            if (i12 < 0) {
                break;
            }
            if (-16777216 == iArr[i12]) {
                a(bArr, 16, (width - i12) - 2);
                break;
            }
            i12--;
        }
        int height = bitmap.getHeight() - 2;
        int[] iArr2 = new int[height];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, height);
        while (true) {
            if (i10 >= height) {
                break;
            }
            if (-16777216 == iArr2[i10]) {
                a(bArr, 20, i10);
                break;
            }
            i10++;
        }
        for (int i13 = height - 1; i13 >= 0; i13--) {
            if (-16777216 == iArr2[i13]) {
                a(bArr, 24, (height - i13) - 2);
                return;
            }
        }
    }

    private static void a(OutputStream outputStream, int i10) throws IOException {
        outputStream.write((i10 >> 0) & 255);
        outputStream.write((i10 >> 8) & 255);
        outputStream.write((i10 >> 16) & 255);
        outputStream.write((i10 >> 24) & 255);
    }

    private static void a(byte[] bArr, int i10, int i11) {
        bArr[i10 + 0] = (byte) (i11 >> 0);
        bArr[i10 + 1] = (byte) (i11 >> 8);
        bArr[i10 + 2] = (byte) (i11 >> 16);
        bArr[i10 + 3] = (byte) (i11 >> 24);
    }

    private static int a(byte[] bArr, int i10) {
        byte b4 = bArr[i10 + 0];
        byte b10 = bArr[i10 + 1];
        byte b11 = bArr[i10 + 2];
        return (bArr[i10 + 3] << 24) | (b4 & 255) | (b10 << 8) | (b11 << 16);
    }
}
