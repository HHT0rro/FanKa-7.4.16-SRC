package l1;

import android.util.Base64;
import com.alicom.tools.networking.RSA;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Crypt.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {
    @NotNull
    public static final byte[] a(@NotNull String str, @Nullable String str2) {
        byte[] doFinal;
        s.i(str, "<this>");
        if (str2 != null) {
            byte[] bytes = str2.getBytes(c.f51097b);
            s.h(bytes, "this as java.lang.String).getBytes(charset)");
            if (bytes.length == 16) {
                try {
                    Charset forName = Charset.forName("UTF-8");
                    s.h(forName, "forName(charsetName)");
                    byte[] bytes2 = str2.getBytes(forName);
                    s.h(bytes2, "this as java.lang.String).getBytes(charset)");
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, AESEncrypt.ALGORITHM);
                    Cipher cipher = Cipher.getInstance(RSA.AES_ALGORITHM);
                    s.h(cipher, "getInstance(\"AES/ECB/PKCS5Padding\")");
                    cipher.init(2, secretKeySpec);
                    synchronized (cipher) {
                        try {
                            byte[] decode = Base64.decode(str, 0);
                            s.h(decode, "decode(this, Base64.DEFAULT)");
                            doFinal = cipher.doFinal(decode);
                            s.h(doFinal, "cipherDecrypt.doFinal(encrypted1)");
                        } catch (BadPaddingException e2) {
                            throw new RuntimeException("AES解密失败", e2);
                        } catch (IllegalBlockSizeException e10) {
                            throw new RuntimeException("AES解密失败", e10);
                        }
                    }
                    return doFinal;
                } catch (UnsupportedEncodingException e11) {
                    throw new RuntimeException("Cipher初始化失败", e11);
                } catch (InvalidKeyException e12) {
                    throw new RuntimeException("Cipher初始化失败", e12);
                } catch (NoSuchAlgorithmException e13) {
                    throw new RuntimeException("Cipher初始化失败", e13);
                } catch (NoSuchPaddingException e14) {
                    throw new RuntimeException("Cipher初始化失败", e14);
                }
            }
        }
        throw new IllegalArgumentException("key长度必须为16");
    }

    @NotNull
    public static final byte[] b(@NotNull byte[] bArr, @NotNull String key) {
        byte[] doFinal;
        s.i(bArr, "<this>");
        s.i(key, "key");
        byte[] bytes = key.getBytes(c.f51097b);
        s.h(bytes, "this as java.lang.String).getBytes(charset)");
        if (bytes.length == 16) {
            try {
                Charset forName = Charset.forName("UTF-8");
                s.h(forName, "forName(charsetName)");
                byte[] bytes2 = key.getBytes(forName);
                s.h(bytes2, "this as java.lang.String).getBytes(charset)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, AESEncrypt.ALGORITHM);
                Cipher cipher = Cipher.getInstance(RSA.AES_ALGORITHM);
                s.h(cipher, "getInstance(\"AES/ECB/PKCS5Padding\")");
                cipher.init(2, secretKeySpec);
                synchronized (cipher) {
                    try {
                        doFinal = cipher.doFinal(bArr);
                        s.h(doFinal, "cipherDecrypt.doFinal(this)");
                    } catch (BadPaddingException e2) {
                        throw new RuntimeException("AES解密失败", e2);
                    } catch (IllegalBlockSizeException e10) {
                        throw new RuntimeException("AES解密失败", e10);
                    }
                }
                return doFinal;
            } catch (UnsupportedEncodingException e11) {
                throw new RuntimeException("Cipher初始化失败", e11);
            } catch (InvalidKeyException e12) {
                throw new RuntimeException("Cipher初始化失败", e12);
            } catch (NoSuchAlgorithmException e13) {
                throw new RuntimeException("Cipher初始化失败", e13);
            } catch (NoSuchPaddingException e14) {
                throw new RuntimeException("Cipher初始化失败", e14);
            }
        }
        throw new IllegalArgumentException("key长度必须为16");
    }

    @NotNull
    public static final byte[] c(@NotNull String str, @NotNull String key) {
        byte[] doFinal;
        s.i(str, "<this>");
        s.i(key, "key");
        Charset charset = c.f51097b;
        byte[] bytes = key.getBytes(charset);
        s.h(bytes, "this as java.lang.String).getBytes(charset)");
        if (bytes.length == 16) {
            try {
                Charset forName = Charset.forName("UTF-8");
                s.h(forName, "forName(charsetName)");
                byte[] bytes2 = key.getBytes(forName);
                s.h(bytes2, "this as java.lang.String).getBytes(charset)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, AESEncrypt.ALGORITHM);
                Cipher cipher = Cipher.getInstance(RSA.AES_ALGORITHM);
                s.h(cipher, "getInstance(\"AES/ECB/PKCS5Padding\")");
                cipher.init(1, secretKeySpec);
                synchronized (cipher) {
                    try {
                        byte[] bytes3 = str.getBytes(charset);
                        s.h(bytes3, "this as java.lang.String).getBytes(charset)");
                        doFinal = cipher.doFinal(bytes3);
                        s.h(doFinal, "cipherEncrypt.doFinal(toByteArray())");
                    } catch (BadPaddingException e2) {
                        throw new RuntimeException("AES加密失败", e2);
                    } catch (IllegalBlockSizeException e10) {
                        throw new RuntimeException("AES加密失败", e10);
                    }
                }
                return doFinal;
            } catch (UnsupportedEncodingException e11) {
                throw new RuntimeException("Cipher初始化失败", e11);
            } catch (InvalidKeyException e12) {
                throw new RuntimeException("Cipher初始化失败", e12);
            } catch (NoSuchAlgorithmException e13) {
                throw new RuntimeException("Cipher初始化失败", e13);
            } catch (NoSuchPaddingException e14) {
                throw new RuntimeException("Cipher初始化失败", e14);
            }
        }
        throw new IllegalArgumentException("key长度必须为16");
    }

    @NotNull
    public static final String d(@NotNull String str, @NotNull String key) {
        s.i(str, "<this>");
        s.i(key, "key");
        byte[] a10 = a(str, key);
        Charset UTF_8 = StandardCharsets.UTF_8;
        s.h(UTF_8, "UTF_8");
        return new String(a10, UTF_8);
    }

    @NotNull
    public static final String e(@NotNull String str) {
        s.i(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(c.f51097b);
        s.h(bytes, "this as java.lang.String).getBytes(charset)");
        String bigInteger = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
        s.h(bigInteger, "BigInteger(1, md.digest(…yteArray())).toString(16)");
        return StringsKt__StringsKt.i0(bigInteger, 32, '0');
    }
}
