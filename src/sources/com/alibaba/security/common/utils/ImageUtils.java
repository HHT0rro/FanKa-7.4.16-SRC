package com.alibaba.security.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Base64;
import com.alibaba.security.common.log.RPLogging;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ImageUtils {
    private static String TAG = "ImageUtils";
    private static String gestureCacheDir;
    private static String verifyCacheDir;

    public static String base64Encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    private static int calculateSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int i14 = 1;
        if (i12 > i11 || i13 > i10) {
            int i15 = i12 / 2;
            int i16 = i13 / 2;
            while (i15 / i14 > i11 && i16 / i14 > i10) {
                i14 *= 2;
            }
        }
        return i14;
    }

    public static byte[] compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > 50 && i10 >= 0) {
            byteArrayOutputStream.reset();
            i10 -= 10;
            bitmap.compress(Bitmap.CompressFormat.JPEG, i10, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String decryptImage(Context context, String str, String str2) {
        try {
            byte[] readFileSdcardFile = readFileSdcardFile(str2);
            if (readFileSdcardFile != null) {
                return saveImage(DESCoderUtils.decrypt(readFileSdcardFile, DESCoderUtils.initKey(str)), context);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (int i10 = 0; i10 < listFiles.length; i10++) {
                    if (listFiles[i10].isFile()) {
                        listFiles[i10].delete();
                    }
                }
            }
        }
    }

    public static byte[] getByteOfFile(String str) {
        try {
            File file = new File(str);
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            bufferedInputStream.read(bArr, 0, length);
            bufferedInputStream.close();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    private static String getGestureDir(Context context) {
        if (Environment.getExternalStorageState().equals("mounted") && context.getExternalCacheDir() != null) {
            gestureCacheDir = context.getExternalCacheDir().getAbsolutePath() + File.separator + "gesture";
        } else {
            gestureCacheDir = context.getFilesDir().getAbsolutePath() + File.separator + "gesture";
        }
        return gestureCacheDir;
    }

    public static String getImagePathByUrlSync(String str, Context context) {
        FileOutputStream fileOutputStream;
        Throwable th;
        InputStream inputStream;
        String str2 = stringToMD5(str) + str.substring(str.lastIndexOf("."));
        String gestureDir = getGestureDir(context);
        File file = new File(gestureDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(gestureDir, str2);
        if (file2.exists()) {
            return file2.getPath();
        }
        InputStream inputStream2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            if (httpURLConnection.getResponseCode() != 200) {
                return "";
            }
            inputStream = httpURLConnection.getInputStream();
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Exception unused) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                fileOutputStream = null;
                th = th2;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                String path = file2.getPath();
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                }
                return path;
            } catch (Exception unused4) {
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                if (fileOutputStream == null) {
                    return "";
                }
                try {
                    fileOutputStream.close();
                    return "";
                } catch (IOException unused6) {
                    return "";
                }
            } catch (Throwable th3) {
                th = th3;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused7) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException unused8) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Exception unused9) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            inputStream = null;
        }
    }

    public static String getVerifyCacheDir() {
        return verifyCacheDir;
    }

    public static String getVerifyDir(Context context) {
        if (Environment.getExternalStorageState().equals("mounted") && context.getExternalCacheDir() != null) {
            verifyCacheDir = context.getExternalCacheDir().getAbsolutePath() + File.separator + "verify";
        } else {
            verifyCacheDir = context.getFilesDir().getAbsolutePath() + File.separator + "verify";
        }
        return verifyCacheDir;
    }

    public static Bitmap loadBitmap(String str, int i10, int i11) {
        if (str != null && new File(str).exists()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inSampleSize = calculateSampleSize(options, i10, i11);
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                return BitmapFactory.decodeStream(new FileInputStream(str), null, options);
            } catch (Exception e2) {
                RPLogging.e(TAG, e2);
            }
        }
        return null;
    }

    public static byte[] readFileSdcardFile(String str) throws IOException {
        byte[] bArr;
        FileInputStream fileInputStream = null;
        byte[] bArr2 = null;
        fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    bArr2 = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr2);
                    fileInputStream2.close();
                    return bArr2;
                } catch (Exception e2) {
                    e = e2;
                    bArr = bArr2;
                    fileInputStream = fileInputStream2;
                    RPLogging.e(TAG, e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
            bArr = null;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i10) {
        if (i10 == 0 || i10 == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i10, bitmap.getWidth(), bitmap.getHeight());
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == createBitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static String saveImage(byte[] bArr, Context context) {
        FileOutputStream fileOutputStream;
        String valueOf = String.valueOf((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
        String verifyDir = getVerifyDir(context);
        File file = new File(verifyDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(verifyDir, valueOf);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
        } catch (IOException unused) {
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            String path = file2.getPath();
            try {
                fileOutputStream.close();
            } catch (IOException unused2) {
            }
            return path;
        } catch (IOException unused3) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public static String stringToMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder("");
            for (int i10 = 0; i10 < digest.length; i10++) {
                int i11 = digest[i10];
                if (i11 < 0) {
                    i11 += 256;
                }
                if (i11 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i11));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
