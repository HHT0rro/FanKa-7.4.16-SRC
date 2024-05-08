package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b {
    public static File a(Context context, boolean z10) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = Array.get(invoke, i10);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z10 == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue() && !TextUtils.isEmpty(str)) {
                    return new File(str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return Environment.getExternalStorageDirectory();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i10 = 0; i10 < 256; i10++) {
            bArr3[i10] = (byte) i10;
        }
        if (bArr2.length == 0) {
            bArr3 = null;
        } else {
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < 256; i13++) {
                i12 = ((bArr2[i11] & 255) + (bArr3[i13] & 255) + i12) & 255;
                byte b4 = bArr3[i13];
                bArr3[i13] = bArr3[i12];
                bArr3[i12] = b4;
                i11 = (i11 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < bArr.length; i16++) {
            i14 = (i14 + 1) & 255;
            i15 = ((bArr3[i14] & 255) + i15) & 255;
            byte b10 = bArr3[i14];
            bArr3[i14] = bArr3[i15];
            bArr3[i15] = b10;
            int i17 = ((bArr3[i14] & 255) + (bArr3[i15] & 255)) & 255;
            bArr4[i16] = (byte) (bArr3[i17] ^ bArr[i16]);
            bArr4[i16] = (byte) (bArr4[i16] ^ ExifInterface.START_CODE);
        }
        return bArr4;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    return a(bArr, bArr2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    return a(bArr, bArr2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
