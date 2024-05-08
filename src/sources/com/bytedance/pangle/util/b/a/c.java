package com.bytedance.pangle.util.b.a;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f10973a = new byte[2];

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f10974b = new byte[4];

    public final int a(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.f10974b);
        return b(this.f10974b);
    }

    public final int b(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.f10973a);
        return a(this.f10973a);
    }

    private static int b(byte[] bArr) {
        return ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16) | (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream, int i10) {
        a(this.f10973a, i10);
        byteArrayOutputStream.write(this.f10973a);
    }

    private static void b(byte[] bArr, int i10) {
        bArr[3] = (byte) (i10 >>> 24);
        bArr[2] = (byte) (i10 >>> 16);
        bArr[1] = (byte) (i10 >>> 8);
        bArr[0] = (byte) (i10 & 255);
    }

    public final void a(OutputStream outputStream, int i10) {
        b(this.f10974b, i10);
        outputStream.write(this.f10974b);
    }

    private static int a(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    public static void a(byte[] bArr, int i10) {
        bArr[1] = (byte) (i10 >>> 8);
        bArr[0] = (byte) (i10 & 255);
    }
}
