package com.google.common.io;

import com.google.common.base.o;
import com.google.common.math.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import jdk.internal.util.ArraysSupport;

/* compiled from: ByteStreams.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final OutputStream f26674a = new C0238a();

    /* compiled from: ByteStreams.java */
    /* renamed from: com.google.common.io.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class C0238a extends OutputStream {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            o.r(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            o.r(bArr);
            o.w(i10, i11 + i10, bArr.length);
        }
    }

    public static byte[] a(Queue<byte[]> queue, int i10) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i10) {
            return remove;
        }
        int length = i10 - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i10);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy((Object) remove2, 0, (Object) copyOf, i10 - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        o.r(inputStream);
        o.r(outputStream);
        byte[] c4 = c();
        long j10 = 0;
        while (true) {
            int read = inputStream.read(c4);
            if (read == -1) {
                return j10;
            }
            outputStream.write(c4, 0, read);
            j10 += read;
        }
    }

    public static byte[] c() {
        return new byte[8192];
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        o.r(inputStream);
        return e(inputStream, new ArrayDeque(20), 0);
    }

    public static byte[] e(InputStream inputStream, Queue<byte[]> queue, int i10) throws IOException {
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i10) * 2));
        while (i10 < 2147483639) {
            int min2 = Math.min(min, ArraysSupport.SOFT_MAX_ARRAY_LENGTH - i10);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i11 = 0;
            while (i11 < min2) {
                int read = inputStream.read(bArr, i11, min2 - i11);
                if (read == -1) {
                    return a(queue, i10);
                }
                i11 += read;
                i10 += read;
            }
            min = d.h(min, min < 4096 ? 4 : 2);
        }
        if (inputStream.read() == -1) {
            return a(queue, ArraysSupport.SOFT_MAX_ARRAY_LENGTH);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
