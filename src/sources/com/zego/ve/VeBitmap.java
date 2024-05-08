package com.zego.ve;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class VeBitmap {
    private static final String TAG = "VeBitmap";

    public static int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int i14 = 1;
        if (i12 > i11 || i13 > i10) {
            int i15 = i12 / 2;
            int i16 = i13 / 2;
            while (i15 / i14 >= i11 && i16 / i14 >= i10) {
                i14 *= 2;
            }
        }
        return i14;
    }

    public static byte[] compress(Bitmap bitmap, int i10, int i11) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap.CompressFormat compressFormat = i10 != 0 ? null : Bitmap.CompressFormat.JPEG;
        if (compressFormat != null && bitmap.compress(compressFormat, i11, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public static Bitmap createBitmap(int i10, int i11, int i12) {
        if (i12 != 0) {
            return null;
        }
        return Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
    }

    public static Bitmap createBitmapRGBA(int i10, int i11) {
        return Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
    }

    public static Bitmap getBitmap(Context context, int i10, int i11, String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            return null;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1, str.length());
        if (substring.compareTo("asset") == 0) {
            return getBitmapFromAsset(context, substring2);
        }
        if (substring.compareTo("file") == 0) {
            return getBitmapFromPath(context, i10, i11, substring2);
        }
        if (substring.compareTo("content") == 0) {
            return getBitmapFromUri(context, i10, i11, str);
        }
        return null;
    }

    public static Bitmap getBitmapFromAsset(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            return Build.VERSION.SDK_INT > 23 ? rotateBitmap(new ExifInterface(open).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1), decodeStream) : decodeStream;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap getBitmapFromPath(Context context, int i10, int i11, String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = calculateInSampleSize(options, i10, i11);
            return rotateBitmap(new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1), BitmapFactory.decodeFile(str, options));
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap getBitmapFromUri(Context context, int i10, int i11, String str) {
        try {
            FileDescriptor fileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse(str), t.f36226k).getFileDescriptor();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = calculateInSampleSize(options, i10, i11);
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            return Build.VERSION.SDK_INT > 23 ? rotateBitmap(new ExifInterface(fileDescriptor).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1), decodeFileDescriptor) : decodeFileDescriptor;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap rotateBitmap(int i10, Bitmap bitmap) {
        int i11 = i10 != 3 ? i10 != 6 ? i10 != 8 ? 0 : 270 : 90 : 180;
        Matrix matrix = new Matrix();
        matrix.postRotate(i11);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static int saveBitmap(Bitmap bitmap) {
        File file = new File("/sdcard/", "snapshot-" + SystemClock.uptimeMillis() + ".jpg");
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }
}
