package java.util.zip;

import java.lang.ref.Reference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import jdk.internal.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class CRC32C implements Checksum {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CRC32C_POLY = 517762881;
    private static final int REVERSED_CRC32C_POLY = Integer.reverse(CRC32C_POLY);
    private static final Unsafe UNSAFE = Unsafe.getUnsafe();
    private static final int[] byteTable;
    private static final int[] byteTable0;
    private static final int[] byteTable1;
    private static final int[] byteTable2;
    private static final int[] byteTable3;
    private static final int[] byteTable4;
    private static final int[] byteTable5;
    private static final int[] byteTable6;
    private static final int[] byteTable7;
    private static final int[][] byteTables;
    private int crc = -1;

    static {
        int[][] iArr;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, 8, 256);
        byteTables = iArr2;
        byteTable0 = iArr2[0];
        byteTable1 = iArr2[1];
        byteTable2 = iArr2[2];
        byteTable3 = iArr2[3];
        byteTable4 = iArr2[4];
        byteTable5 = iArr2[5];
        byteTable6 = iArr2[6];
        byteTable7 = iArr2[7];
        for (int index = 0; index < byteTables[0].length; index++) {
            int r10 = index;
            for (int i10 = 0; i10 < 8; i10++) {
                if ((r10 & 1) != 0) {
                    r10 = (r10 >>> 1) ^ REVERSED_CRC32C_POLY;
                } else {
                    r10 >>>= 1;
                }
            }
            byteTables[0][index] = r10;
        }
        int index2 = 0;
        while (true) {
            iArr = byteTables;
            int[] iArr3 = iArr[0];
            if (index2 >= iArr3.length) {
                break;
            }
            int r11 = iArr3[index2];
            int k10 = 1;
            while (true) {
                int[][] iArr4 = byteTables;
                if (k10 < iArr4.length) {
                    r11 = iArr4[0][r11 & 255] ^ (r11 >>> 8);
                    iArr4[k10][index2] = r11;
                    k10++;
                }
            }
            index2++;
        }
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            byteTable = iArr[0];
            return;
        }
        int[] iArr5 = byteTable0;
        int[] iArr6 = new int[iArr5.length];
        byteTable = iArr6;
        System.arraycopy((Object) iArr5, 0, (Object) iArr6, 0, iArr5.length);
        for (int[] table : iArr) {
            for (int index3 = 0; index3 < table.length; index3++) {
                table[index3] = Integer.reverseBytes(table[index3]);
            }
        }
    }

    @Override // java.util.zip.Checksum
    public void update(int b4) {
        int i10 = this.crc;
        this.crc = byteTable[(i10 ^ (b4 & 255)) & 255] ^ (i10 >>> 8);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] b4, int off, int len) {
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || off > b4.length - len) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.crc = updateBytes(this.crc, b4, off, off + len);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.zip.Checksum
    public void update(ByteBuffer byteBuffer) {
        int pos = byteBuffer.position();
        int limit = byteBuffer.limit();
        int rem = limit - pos;
        if (rem <= 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            try {
                this.crc = updateDirectByteBuffer(this.crc, ((DirectBuffer) byteBuffer).address(), pos, limit);
            } finally {
                Reference.reachabilityFence(byteBuffer);
            }
        } else if (byteBuffer.hasArray()) {
            this.crc = updateBytes(this.crc, byteBuffer.array(), byteBuffer.arrayOffset() + pos, byteBuffer.arrayOffset() + limit);
        } else {
            byte[] b4 = new byte[Math.min(byteBuffer.remaining(), 4096)];
            while (byteBuffer.hasRemaining()) {
                int length = Math.min(byteBuffer.remaining(), b4.length);
                byteBuffer.get(b4, 0, length);
                update(b4, 0, length);
            }
        }
        byteBuffer.position(limit);
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.crc = -1;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        return (~this.crc) & 4294967295L;
    }

    private static int updateBytes(int crc, byte[] b4, int off, int end) {
        int firstHalf;
        int secondHalf;
        int i10;
        int i11;
        if (end - off >= 8 && Unsafe.ARRAY_BYTE_INDEX_SCALE == 1) {
            int alignLength = (8 - ((Unsafe.ARRAY_BYTE_BASE_OFFSET + off) & 7)) & 7;
            int alignEnd = off + alignLength;
            while (off < alignEnd) {
                crc = (crc >>> 8) ^ byteTable[(b4[off] ^ crc) & 255];
                off++;
            }
            if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                crc = Integer.reverseBytes(crc);
            }
            while (off < end - 8) {
                if (Unsafe.ADDRESS_SIZE == 4) {
                    Unsafe unsafe = UNSAFE;
                    firstHalf = unsafe.getInt(b4, Unsafe.ARRAY_BYTE_BASE_OFFSET + off);
                    secondHalf = unsafe.getInt(b4, Unsafe.ARRAY_BYTE_BASE_OFFSET + off + 4);
                } else {
                    long value = UNSAFE.getLong(b4, Unsafe.ARRAY_BYTE_BASE_OFFSET + off);
                    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                        int firstHalf2 = (int) value;
                        firstHalf = firstHalf2;
                        secondHalf = (int) (value >>> 32);
                    } else {
                        int firstHalf3 = (int) (value >>> 32);
                        firstHalf = firstHalf3;
                        secondHalf = (int) value;
                    }
                }
                int crc2 = crc ^ firstHalf;
                if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                    i10 = (((((byteTable7[crc2 & 255] ^ byteTable6[(crc2 >>> 8) & 255]) ^ byteTable5[(crc2 >>> 16) & 255]) ^ byteTable4[crc2 >>> 24]) ^ byteTable3[secondHalf & 255]) ^ byteTable2[(secondHalf >>> 8) & 255]) ^ byteTable1[(secondHalf >>> 16) & 255];
                    i11 = byteTable0[secondHalf >>> 24];
                } else {
                    i10 = (((((byteTable0[secondHalf & 255] ^ byteTable1[(secondHalf >>> 8) & 255]) ^ byteTable2[(secondHalf >>> 16) & 255]) ^ byteTable3[secondHalf >>> 24]) ^ byteTable4[crc2 & 255]) ^ byteTable5[(crc2 >>> 8) & 255]) ^ byteTable6[(crc2 >>> 16) & 255];
                    i11 = byteTable7[crc2 >>> 24];
                }
                crc = i10 ^ i11;
                off += 8;
            }
            if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                crc = Integer.reverseBytes(crc);
            }
        }
        while (off < end) {
            crc = (crc >>> 8) ^ byteTable[(b4[off] ^ crc) & 255];
            off++;
        }
        return crc;
    }

    private static int updateDirectByteBuffer(int crc, long address, int off, int end) {
        int i10;
        int i11;
        if (end - off >= 8) {
            int alignLength = (8 - ((int) ((off + address) & 7))) & 7;
            int alignEnd = off + alignLength;
            while (off < alignEnd) {
                crc = (crc >>> 8) ^ byteTable[(UNSAFE.getByte(off + address) ^ crc) & 255];
                off++;
            }
            if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                crc = Integer.reverseBytes(crc);
            }
            while (off <= end - 8) {
                Unsafe unsafe = UNSAFE;
                int firstHalf = unsafe.getInt(off + address);
                int secondHalf = unsafe.getInt(off + address + 4);
                int crc2 = crc ^ firstHalf;
                if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                    i10 = (((((byteTable7[crc2 & 255] ^ byteTable6[(crc2 >>> 8) & 255]) ^ byteTable5[(crc2 >>> 16) & 255]) ^ byteTable4[crc2 >>> 24]) ^ byteTable3[secondHalf & 255]) ^ byteTable2[(secondHalf >>> 8) & 255]) ^ byteTable1[(secondHalf >>> 16) & 255];
                    i11 = byteTable0[secondHalf >>> 24];
                } else {
                    i10 = (((((byteTable0[secondHalf & 255] ^ byteTable1[(secondHalf >>> 8) & 255]) ^ byteTable2[(secondHalf >>> 16) & 255]) ^ byteTable3[secondHalf >>> 24]) ^ byteTable4[crc2 & 255]) ^ byteTable5[(crc2 >>> 8) & 255]) ^ byteTable6[(crc2 >>> 16) & 255];
                    i11 = byteTable7[crc2 >>> 24];
                }
                crc = i10 ^ i11;
                off += 8;
            }
            if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                crc = Integer.reverseBytes(crc);
            }
        }
        while (off < end) {
            crc = (crc >>> 8) ^ byteTable[(UNSAFE.getByte(off + address) ^ crc) & 255];
            off++;
        }
        return crc;
    }
}
