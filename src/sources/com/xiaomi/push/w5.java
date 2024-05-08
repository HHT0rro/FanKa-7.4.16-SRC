package com.xiaomi.push;

import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.ObjectStreamConstants;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class w5 {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f48458a = {100, 23, 84, ObjectStreamConstants.TC_CLASSDESC, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32};

    public static Cipher a(byte[] bArr, int i10) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AESEncrypt.ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f48458a);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i10, secretKeySpec, ivParameterSpec);
        return cipher;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, 2).doFinal(bArr2);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        return a(bArr, 1).doFinal(bArr2);
    }
}
