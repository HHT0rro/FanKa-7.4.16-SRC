package a0;

import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f665a = new String("idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#");

    public static String a() {
        String str = new String();
        for (int i10 = 0; i10 < f665a.length() - 1; i10 += 4) {
            str = str + f665a.charAt(i10);
        }
        return str;
    }

    public static String b(String str, String str2) {
        try {
            try {
                PBEKeySpec c4 = c(str);
                byte[] bytes = str2.getBytes();
                SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(c4).getEncoded(), AESEncrypt.ALGORITHM);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
                byte[] salt = c4.getSalt();
                ByteBuffer allocate = ByteBuffer.allocate(salt.length + cipher.getOutputSize(bytes.length));
                allocate.put(salt);
                cipher.doFinal(ByteBuffer.wrap(bytes), allocate);
                return g(allocate.array());
            } catch (Exception unused) {
                return g(e(d(str.getBytes()), str2.getBytes()));
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static PBEKeySpec c(String str) {
        Class<?> cls = Class.forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
        Object newInstance = cls.newInstance();
        byte[] bArr = new byte[16];
        Method method = cls.getMethod("nextBytes", bArr.getClass());
        method.setAccessible(true);
        method.invoke(newInstance, bArr);
        return new PBEKeySpec(str.toCharArray(), bArr, 10, 128);
    }

    public static byte[] d(byte[] bArr) {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AESEncrypt.ALGORITHM);
        Class<?> cls = Class.forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
        Object invoke = cls.getMethod("getInstance", String.class, String.class).invoke(null, "SHA1PRNG", "Crypto");
        Method method = cls.getMethod("setSeed", bArr.getClass());
        method.setAccessible(true);
        method.invoke(invoke, bArr);
        KeyGenerator.class.getMethod("init", Integer.TYPE, cls).invoke(keyGenerator, 128, invoke);
        return keyGenerator.generateKey().getEncoded();
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AESEncrypt.ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return cipher.doFinal(bArr2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String f(String str, String str2) {
        String str3;
        byte[] doFinal;
        try {
            PBEKeySpec c4 = c(str);
            byte[] h10 = h(str2);
            if (h10.length <= 16) {
                doFinal = null;
            } else {
                SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(c4.getPassword(), Arrays.copyOf(h10, 16), 10, 128)).getEncoded(), AESEncrypt.ALGORITHM);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
                doFinal = cipher.doFinal(h10, 16, h10.length - 16);
            }
        } catch (Exception unused) {
        }
        if (doFinal == null) {
            throw new Exception();
        }
        String str4 = new String(doFinal);
        if (z.a.h(str4)) {
            return str4;
        }
        try {
            byte[] d10 = d(str.getBytes());
            byte[] h11 = h(str2);
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(d10, AESEncrypt.ALGORITHM);
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher2.init(2, secretKeySpec2, new IvParameterSpec(new byte[cipher2.getBlockSize()]));
            str3 = new String(cipher2.doFinal(h11));
        } catch (Exception unused2) {
        }
        if (z.a.h(str3)) {
            return str3;
        }
        return null;
    }

    public static String g(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b4 : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b4 >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b4 & 15));
        }
        return stringBuffer.toString();
    }

    public static byte[] h(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = Integer.valueOf(str.substring(i11, i11 + 2), 16).byteValue();
        }
        return bArr;
    }
}
