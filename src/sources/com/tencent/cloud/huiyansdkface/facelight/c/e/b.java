package com.tencent.cloud.huiyansdkface.facelight.c.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.cloud.huiyansdkface.facelight.c.f;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40676a = "b";

    public static String a(Context context, byte[] bArr) {
        if (context == null) {
            WLogger.e(f40676a, "byteToProguardVideo context is null!");
            return "";
        }
        File file = new File(context.getCacheDir().getAbsolutePath());
        if (!file.exists() && !file.mkdirs()) {
            WLogger.i(f40676a, "failed to createAdapter media dir!");
        }
        String str = file.getPath() + File.separator + ("proguard_" + ("" + System.currentTimeMillis()) + ".mp4");
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(bArr, 0, bArr.length);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = (bArr[i10] & 255) / 16;
            int i12 = bArr[i10] & 15;
            stringBuffer.append("0123456789abcdef".charAt(i11));
            stringBuffer.append("0123456789abcdef".charAt(i12));
        }
        return stringBuffer.toString();
    }

    public static String a(byte[] bArr, String str) throws Exception {
        return a(b(bArr, str));
    }

    public static String a(byte[] bArr, byte[] bArr2, String str) throws Exception {
        byte[] bArr3;
        String str2 = f40676a;
        WLogger.d(str2, "salt=" + str);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bArr4 = null;
        if (bArr == null || bArr.length == 0) {
            WLogger.e(str2, "generateFileMd5 video is null!");
            bArr3 = null;
        } else {
            bArr3 = Base64.encode(bArr, 2);
        }
        if (bArr2 == null || bArr2.length == 0) {
            WLogger.e(str2, "generateFileMd5 wbVideo is null!");
        } else {
            bArr4 = Base64.encode(bArr2, 2);
        }
        if (bArr3 == null && bArr4 == null) {
            return "";
        }
        byte[] a10 = a(bArr3, bArr4);
        WLogger.d(str2, "after arrayBytes=" + a10.length);
        if (a10.length == 0) {
            return "";
        }
        String a11 = a(a10, str);
        WLogger.d(str2, "md5=" + a11);
        return a11;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            String str2 = f40676a;
            WLogger.d(str2, "old video exist!");
            if (file.delete()) {
                WLogger.d(str2, "old video detele!");
            } else {
                WLogger.i("video file detele failed!");
            }
        }
    }

    public static byte[] a(File file) {
        byte[] bArr = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return c(bArr2);
        }
        if (bArr2 == null) {
            return c(bArr);
        }
        WLogger.d(f40676a, "array1=" + bArr.length + ",array2=" + bArr2.length);
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, bArr.length);
        System.arraycopy((Object) bArr2, 0, (Object) bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            WLogger.e(f40676a, "proguardMp4Byte video length is 0!");
            return null;
        }
        String str = f40676a;
        WLogger.d(str, "proguardMp4Byte videoByte=" + bArr.length);
        if (bArr.length < 200) {
            WLogger.e(str, "proguardMp4Byte video length < 200!no proguard!");
            return bArr;
        }
        String a10 = f.a(1);
        String a11 = f.a(1);
        String a12 = f.a(1);
        WLogger.d(str, "first=" + a10 + ",len=" + a10.getBytes().length + ";second=" + a11 + ",len=" + a11.getBytes().length + ";third=" + a12 + ",len=" + a12.getBytes().length);
        int length = bArr.length + a10.getBytes().length + a11.getBytes().length + a12.getBytes().length;
        byte[] bArr2 = new byte[length];
        System.arraycopy((Object) a10.getBytes(), 0, (Object) bArr2, 0, a10.getBytes().length);
        int length2 = a10.getBytes().length + 0;
        System.arraycopy((Object) bArr, 0, (Object) bArr2, length2, 99);
        int i10 = length2 + 99;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("after1 destPos=");
        sb2.append(i10);
        WLogger.d(str, sb2.toString());
        System.arraycopy((Object) a11.getBytes(), 0, (Object) bArr2, i10, a11.getBytes().length);
        int length3 = i10 + a11.getBytes().length;
        WLogger.d(str, "after2 destPos=" + length3);
        System.arraycopy((Object) bArr, 99, (Object) bArr2, length3, 99);
        int i11 = length3 + 99;
        WLogger.d(str, "after3 destPos=" + i11);
        System.arraycopy((Object) a12.getBytes(), 0, (Object) bArr2, i11, a12.getBytes().length);
        int length4 = i11 + a12.getBytes().length;
        WLogger.d(str, "after4 destPos=" + length4);
        System.arraycopy((Object) bArr, 198, (Object) bArr2, length4, bArr.length - 198);
        WLogger.d(str, "after5 destPos=" + length4);
        WLogger.d(str, "after RESULT=" + length);
        return bArr2;
    }

    public static byte[] b(byte[] bArr, String str) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "HmacMD5");
        Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
        mac.init(secretKeySpec);
        return mac.doFinal(bArr);
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }
}
