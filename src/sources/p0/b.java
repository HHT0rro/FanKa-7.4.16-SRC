package p0;

import com.bytedance.hume.readapk.e;
import com.tencent.vasdolly.common.apk.ApkSigningBlockUtils;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {
    public static long a(FileChannel fileChannel) {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
        long j10 = size - 22;
        long min = Math.min(j10, 65535L);
        int i10 = 0;
        while (true) {
            long j11 = i10;
            if (j11 > min) {
                throw new IOException("ZIP End of Central Directory (EOCD) record not found");
            }
            long j12 = j10 - j11;
            ByteBuffer allocate = ByteBuffer.allocate(4);
            fileChannel.position(j12);
            fileChannel.read(allocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            if (allocate.getInt(0) == 101010256) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j12 + 20);
                fileChannel.read(allocate2);
                allocate2.order(byteOrder);
                short s2 = allocate2.getShort(0);
                if (s2 == i10) {
                    return s2;
                }
            }
            i10++;
        }
    }

    public static long b(FileChannel fileChannel, long j10) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        fileChannel.position((fileChannel.size() - j10) - 6);
        fileChannel.read(allocate);
        long j11 = allocate.getInt(0);
        if (j11 >= 0) {
            return j11;
        }
        fileChannel.read(allocate);
        byte[] bArr = new byte[8];
        for (int i10 = 4; i10 < 8; i10++) {
            bArr[i10] = allocate.get((8 - i10) - 1);
        }
        return ByteBuffer.wrap(bArr).getLong();
    }

    public static ByteBuffer c(ByteBuffer byteBuffer, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("size: " + i10);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i11 = i10 + position;
        if (i11 < position || i11 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i11);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i11);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    public static ByteBuffer d(ByteBuffer byteBuffer, int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("start: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("end < start: " + i11 + " < " + i10);
        }
        int capacity = byteBuffer.capacity();
        if (i11 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i11 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i11);
            byteBuffer.position(i10);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    public static Map<Integer, ByteBuffer> e(ByteBuffer byteBuffer) {
        h(byteBuffer);
        ByteBuffer d10 = d(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i10 = 0;
        while (d10.hasRemaining()) {
            i10++;
            if (d10.remaining() < 8) {
                throw new e("Insufficient data to read size of APK Signing Block entry #" + i10);
            }
            long j10 = d10.getLong();
            if (j10 < 4 || j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
                throw new e("APK Signing Block entry #" + i10 + " size out of range: " + j10);
            }
            int i11 = (int) j10;
            int position = d10.position() + i11;
            if (i11 > d10.remaining()) {
                throw new e("APK Signing Block entry #" + i10 + " size out of range: " + i11 + ", available: " + d10.remaining());
            }
            linkedHashMap.put(Integer.valueOf(d10.getInt()), c(d10, i11 - 4));
            d10.position(position);
        }
        return linkedHashMap;
    }

    public static long f(FileChannel fileChannel) {
        return b(fileChannel, a(fileChannel));
    }

    public static c<ByteBuffer, Long> g(FileChannel fileChannel, long j10) {
        if (j10 < 32) {
            throw new e("APK too small for APK Signing Block. ZIP Central Directory offset: " + j10);
        }
        fileChannel.position(j10 - 24);
        ByteBuffer allocate = ByteBuffer.allocate(24);
        fileChannel.read(allocate);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        allocate.order(byteOrder);
        if (allocate.getLong(8) != ApkSigningBlockUtils.APK_SIG_BLOCK_MAGIC_LO || allocate.getLong(16) != ApkSigningBlockUtils.APK_SIG_BLOCK_MAGIC_HI) {
            throw new e("No APK Signing Block before ZIP Central Directory");
        }
        long j11 = allocate.getLong(0);
        if (j11 < allocate.capacity() || j11 > 2147483639) {
            throw new e("APK Signing Block size out of range: " + j11);
        }
        int i10 = (int) (8 + j11);
        long j12 = j10 - i10;
        if (j12 < 0) {
            throw new e("APK Signing Block offset out of range: " + j12);
        }
        fileChannel.position(j12);
        ByteBuffer allocate2 = ByteBuffer.allocate(i10);
        fileChannel.read(allocate2);
        allocate2.order(byteOrder);
        long j13 = allocate2.getLong(0);
        if (j13 == j11) {
            return c.b(allocate2, Long.valueOf(j12));
        }
        throw new e("APK Signing Block sizes in header and footer do not match: " + j13 + " vs " + j11);
    }

    public static void h(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static c<ByteBuffer, Long> i(FileChannel fileChannel) {
        return g(fileChannel, f(fileChannel));
    }
}
