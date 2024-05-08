package com.alibaba.fastjson.util;

import java.lang.ref.SoftReference;
import java.nio.charset.CharsetDecoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ThreadLocalCache {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BYTES_CACH_INIT_SIZE = 1024;
    public static final int BYTES_CACH_INIT_SIZE_EXP = 10;
    public static final int BYTES_CACH_MAX_SIZE = 131072;
    public static final int BYTES_CACH_MAX_SIZE_EXP = 17;
    public static final int CHARS_CACH_INIT_SIZE = 1024;
    public static final int CHARS_CACH_INIT_SIZE_EXP = 10;
    public static final int CHARS_CACH_MAX_SIZE = 131072;
    public static final int CHARS_CACH_MAX_SIZE_EXP = 17;
    private static final ThreadLocal<SoftReference<char[]>> charsBufLocal = new ThreadLocal<>();
    private static final ThreadLocal<CharsetDecoder> decoderLocal = new ThreadLocal<>();
    private static final ThreadLocal<SoftReference<byte[]>> bytesBufLocal = new ThreadLocal<>();

    private static char[] allocate(int i10) {
        if (i10 > 131072) {
            return new char[i10];
        }
        char[] cArr = new char[getAllocateLengthExp(10, 17, i10)];
        charsBufLocal.set(new SoftReference<>(cArr));
        return cArr;
    }

    private static byte[] allocateBytes(int i10) {
        if (i10 > 131072) {
            return new byte[i10];
        }
        byte[] bArr = new byte[getAllocateLengthExp(10, 17, i10)];
        bytesBufLocal.set(new SoftReference<>(bArr));
        return bArr;
    }

    public static void clearBytes() {
        bytesBufLocal.set(null);
    }

    public static void clearChars() {
        charsBufLocal.set(null);
    }

    private static int getAllocateLengthExp(int i10, int i11, int i12) {
        return (i12 >>> i10) <= 0 ? 1 << i10 : 1 << (32 - Integer.numberOfLeadingZeros(i12 - 1));
    }

    public static byte[] getBytes(int i10) {
        SoftReference<byte[]> softReference = bytesBufLocal.get();
        if (softReference == null) {
            return allocateBytes(i10);
        }
        byte[] bArr = softReference.get();
        if (bArr == null) {
            return allocateBytes(i10);
        }
        return bArr.length < i10 ? allocateBytes(i10) : bArr;
    }

    public static char[] getChars(int i10) {
        SoftReference<char[]> softReference = charsBufLocal.get();
        if (softReference == null) {
            return allocate(i10);
        }
        char[] cArr = softReference.get();
        if (cArr == null) {
            return allocate(i10);
        }
        return cArr.length < i10 ? allocate(i10) : cArr;
    }

    public static CharsetDecoder getUTF8Decoder() {
        ThreadLocal<CharsetDecoder> threadLocal = decoderLocal;
        CharsetDecoder charsetDecoder = threadLocal.get();
        if (charsetDecoder != null) {
            return charsetDecoder;
        }
        UTF8Decoder uTF8Decoder = new UTF8Decoder();
        threadLocal.set(uTF8Decoder);
        return uTF8Decoder;
    }
}
