package com.bytedance.pangle.util.a;

import com.bytedance.pangle.util.f;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f10969a = "";

    public static String[] a(File file) {
        String str;
        ByteBuffer b4;
        boolean z10;
        String str2 = "";
        try {
            b4 = b(file);
        } catch (Exception unused) {
            str = "";
        }
        if (b4.order() == ByteOrder.LITTLE_ENDIAN) {
            ByteBuffer a10 = a(b4, b4.capacity() - 24);
            int i10 = 0;
            while (a10.hasRemaining()) {
                i10++;
                if (a10.remaining() >= 8) {
                    long j10 = a10.getLong();
                    if (j10 >= 4 && j10 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
                        int i11 = (int) j10;
                        int position = a10.position() + i11;
                        if (i11 <= a10.remaining()) {
                            int i12 = a10.getInt();
                            if (i12 == -262969152) {
                                f10969a = "V3";
                            } else if (i12 == 1896449818) {
                                f10969a = "V2";
                            } else {
                                a10.position(position);
                            }
                            z10 = true;
                            break;
                        }
                        throw new Exception("APK Signing Block entry #" + i10 + " size out of range: " + i11 + ", available: " + a10.remaining());
                    }
                    throw new Exception("APK Signing Block entry #" + i10 + " size out of range: " + j10);
                }
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i10)));
            }
            z10 = false;
            if (z10) {
                str2 = f.a(b4.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
            return new String[]{str2, f10969a, str};
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[Catch: all -> 0x018c, TryCatch #0 {all -> 0x018c, blocks: (B:5:0x0008, B:9:0x0024, B:11:0x003a, B:15:0x004b, B:17:0x005d, B:21:0x0075, B:23:0x00a8, B:25:0x00b5, B:29:0x00c9, B:31:0x00d3, B:33:0x00f4, B:37:0x0104, B:38:0x011f, B:39:0x0120, B:40:0x012f, B:41:0x0130, B:42:0x013f, B:43:0x0140, B:44:0x0147, B:45:0x0148, B:46:0x0157, B:47:0x0158, B:48:0x015f, B:49:0x0160, B:50:0x017b, B:51:0x017c, B:52:0x0183, B:54:0x0184, B:55:0x018b, B:56:0x0014, B:59:0x001b), top: B:4:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017c A[Catch: all -> 0x018c, TryCatch #0 {all -> 0x018c, blocks: (B:5:0x0008, B:9:0x0024, B:11:0x003a, B:15:0x004b, B:17:0x005d, B:21:0x0075, B:23:0x00a8, B:25:0x00b5, B:29:0x00c9, B:31:0x00d3, B:33:0x00f4, B:37:0x0104, B:38:0x011f, B:39:0x0120, B:40:0x012f, B:41:0x0130, B:42:0x013f, B:43:0x0140, B:44:0x0147, B:45:0x0148, B:46:0x0157, B:47:0x0158, B:48:0x015f, B:49:0x0160, B:50:0x017b, B:51:0x017c, B:52:0x0183, B:54:0x0184, B:55:0x018b, B:56:0x0014, B:59:0x001b), top: B:4:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.nio.ByteBuffer b(java.io.File r13) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.a.b.b(java.io.File):java.nio.ByteBuffer");
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i10) {
        if (i10 >= 8) {
            int capacity = byteBuffer.capacity();
            if (i10 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i10);
                    byteBuffer.position(8);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i10 + " > " + capacity);
        }
        throw new IllegalArgumentException("end < start: " + i10 + " < 8");
    }
}
