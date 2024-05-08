package com.bef.effectsdk;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.ParcelFileDescriptor;
import h0.a;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;

@a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class OpenGLUtils {
    private static final String HEIGHT = "\"height\"";
    public static final int NOT_INIT = -1;
    public static final int NO_TEXTURE = -1;
    public static final int ON_DRAWN = 1;
    private static final String TEXTURE_ID = "\"textureId\"";
    private static final String WIDTH = "\"width\"";
    private static final String RES = "\"res\"";
    private static final String FAIL_RES = String.format(Locale.US, "{%s: false}", RES);

    @a
    public static void byte2Bitmap(byte[] bArr, int i10, int i11, String str) {
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(-16776961);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        saveBitmap(createBitmap, str);
    }

    public static void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": glError 0x" + Integer.toHexString(glGetError));
    }

    public static int getExternalOESTextureID() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public static int initEffectTexture(int i10, int i11, int[] iArr, int i12) {
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(i12, iArr[0]);
        GLES20.glTexParameterf(i12, 10240, 9729.0f);
        GLES20.glTexParameterf(i12, 10241, 9729.0f);
        GLES20.glTexParameterf(i12, 10242, 33071.0f);
        GLES20.glTexParameterf(i12, 10243, 33071.0f);
        GLES20.glTexImage2D(i12, 0, 6408, i10, i11, 0, 6408, 5121, null);
        return iArr[0];
    }

    @a
    public static Bitmap loadBitmap(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return decodeStream;
            } catch (Exception unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int loadProgram(String str, String str2) {
        int loadShader;
        int[] iArr = new int[1];
        int loadShader2 = loadShader(str, 35633);
        if (loadShader2 == 0 || (loadShader = loadShader(str2, 35632)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        GLES20.glAttachShader(glCreateProgram, loadShader);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            return 0;
        }
        GLES20.glDeleteShader(loadShader2);
        GLES20.glDeleteShader(loadShader);
        return glCreateProgram;
    }

    private static int loadShader(String str, int i10) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i10);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Compilation\n");
        sb2.append(GLES20.glGetShaderInfoLog(glCreateShader));
        return 0;
    }

    @a
    public static String loadTexture(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null) {
            return FAIL_RES;
        }
        return String.format(Locale.US, "{%s: true, %s: %d, %s: %d, %s: %d}", RES, WIDTH, Integer.valueOf(decodeFile.getWidth()), HEIGHT, Integer.valueOf(decodeFile.getHeight()), TEXTURE_ID, Integer.valueOf(loadTexture(decodeFile, -1, false)));
    }

    public static void saveBitmap(Bitmap bitmap, String str) {
    }

    @a
    public static Bitmap loadBitmap(FileDescriptor fileDescriptor, long j10, long j11) throws IOException {
        FileInputStream createInputStream = new AssetFileDescriptor(ParcelFileDescriptor.dup(fileDescriptor), j10, j11).createInputStream();
        try {
            return BitmapFactory.decodeStream(createInputStream);
        } finally {
            createInputStream.close();
        }
    }

    public static int loadShader(int i10, String str) {
        int glCreateShader = GLES20.glCreateShader(i10);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public static int loadTexture(Bitmap bitmap, int i10) {
        return loadTexture(bitmap, i10, false);
    }

    public static int loadTexture(Bitmap bitmap, int i10, boolean z10) {
        if (bitmap == null) {
            return -1;
        }
        int[] iArr = new int[1];
        if (i10 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i10);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            iArr[0] = i10;
        }
        if (z10) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    @a
    public static Bitmap loadBitmap(byte[] bArr, int i10, int i11, boolean z10) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPremultiplied = z10;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i10, i11, options);
        if (decodeByteArray == null) {
            return decodeByteArray;
        }
        Bitmap.Config config = decodeByteArray.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        return config != config2 ? decodeByteArray.copy(config2, true) : decodeByteArray;
    }
}
