package com.android.internal.org.bouncycastle.crypto.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class Pack {
    public static int bigEndianToInt(byte[] bs, int off) {
        int n10 = bs[off] << 24;
        int off2 = off + 1;
        int n11 = n10 | ((bs[off2] & 255) << 16);
        int off3 = off2 + 1;
        return n11 | ((bs[off3] & 255) << 8) | (bs[off3 + 1] & 255);
    }

    public static void bigEndianToInt(byte[] bs, int off, int[] ns) {
        for (int i10 = 0; i10 < ns.length; i10++) {
            ns[i10] = bigEndianToInt(bs, off);
            off += 4;
        }
    }

    public static byte[] intToBigEndian(int n10) {
        byte[] bs = new byte[4];
        intToBigEndian(n10, bs, 0);
        return bs;
    }

    public static void intToBigEndian(int n10, byte[] bs, int off) {
        bs[off] = (byte) (n10 >>> 24);
        int off2 = off + 1;
        bs[off2] = (byte) (n10 >>> 16);
        int off3 = off2 + 1;
        bs[off3] = (byte) (n10 >>> 8);
        bs[off3 + 1] = (byte) n10;
    }

    public static byte[] intToBigEndian(int[] ns) {
        byte[] bs = new byte[ns.length * 4];
        intToBigEndian(ns, bs, 0);
        return bs;
    }

    public static void intToBigEndian(int[] ns, byte[] bs, int off) {
        for (int i10 : ns) {
            intToBigEndian(i10, bs, off);
            off += 4;
        }
    }

    public static long bigEndianToLong(byte[] bs, int off) {
        int hi = bigEndianToInt(bs, off);
        int lo = bigEndianToInt(bs, off + 4);
        return ((hi & 4294967295L) << 32) | (4294967295L & lo);
    }

    public static void bigEndianToLong(byte[] bs, int off, long[] ns) {
        for (int i10 = 0; i10 < ns.length; i10++) {
            ns[i10] = bigEndianToLong(bs, off);
            off += 8;
        }
    }

    public static byte[] longToBigEndian(long n10) {
        byte[] bs = new byte[8];
        longToBigEndian(n10, bs, 0);
        return bs;
    }

    public static void longToBigEndian(long n10, byte[] bs, int off) {
        intToBigEndian((int) (n10 >>> 32), bs, off);
        intToBigEndian((int) (4294967295L & n10), bs, off + 4);
    }

    public static byte[] longToBigEndian(long[] ns) {
        byte[] bs = new byte[ns.length * 8];
        longToBigEndian(ns, bs, 0);
        return bs;
    }

    public static void longToBigEndian(long[] ns, byte[] bs, int off) {
        for (long j10 : ns) {
            longToBigEndian(j10, bs, off);
            off += 8;
        }
    }

    public static int littleEndianToInt(byte[] bs, int off) {
        int n10 = bs[off] & 255;
        int off2 = off + 1;
        int n11 = n10 | ((bs[off2] & 255) << 8);
        int off3 = off2 + 1;
        return n11 | ((bs[off3] & 255) << 16) | (bs[off3 + 1] << 24);
    }

    public static void littleEndianToInt(byte[] bs, int off, int[] ns) {
        for (int i10 = 0; i10 < ns.length; i10++) {
            ns[i10] = littleEndianToInt(bs, off);
            off += 4;
        }
    }

    public static void littleEndianToInt(byte[] bs, int bOff, int[] ns, int nOff, int count) {
        for (int i10 = 0; i10 < count; i10++) {
            ns[nOff + i10] = littleEndianToInt(bs, bOff);
            bOff += 4;
        }
    }

    public static byte[] intToLittleEndian(int n10) {
        byte[] bs = new byte[4];
        intToLittleEndian(n10, bs, 0);
        return bs;
    }

    public static void intToLittleEndian(int n10, byte[] bs, int off) {
        bs[off] = (byte) n10;
        int off2 = off + 1;
        bs[off2] = (byte) (n10 >>> 8);
        int off3 = off2 + 1;
        bs[off3] = (byte) (n10 >>> 16);
        bs[off3 + 1] = (byte) (n10 >>> 24);
    }

    public static byte[] intToLittleEndian(int[] ns) {
        byte[] bs = new byte[ns.length * 4];
        intToLittleEndian(ns, bs, 0);
        return bs;
    }

    public static void intToLittleEndian(int[] ns, byte[] bs, int off) {
        for (int i10 : ns) {
            intToLittleEndian(i10, bs, off);
            off += 4;
        }
    }

    public static long littleEndianToLong(byte[] bs, int off) {
        int lo = littleEndianToInt(bs, off);
        int hi = littleEndianToInt(bs, off + 4);
        return ((hi & 4294967295L) << 32) | (4294967295L & lo);
    }

    public static void littleEndianToLong(byte[] bs, int off, long[] ns) {
        for (int i10 = 0; i10 < ns.length; i10++) {
            ns[i10] = littleEndianToLong(bs, off);
            off += 8;
        }
    }

    public static byte[] longToLittleEndian(long n10) {
        byte[] bs = new byte[8];
        longToLittleEndian(n10, bs, 0);
        return bs;
    }

    public static void longToLittleEndian(long n10, byte[] bs, int off) {
        intToLittleEndian((int) (4294967295L & n10), bs, off);
        intToLittleEndian((int) (n10 >>> 32), bs, off + 4);
    }

    public static byte[] longToLittleEndian(long[] ns) {
        byte[] bs = new byte[ns.length * 8];
        longToLittleEndian(ns, bs, 0);
        return bs;
    }

    public static void longToLittleEndian(long[] ns, byte[] bs, int off) {
        for (long j10 : ns) {
            longToLittleEndian(j10, bs, off);
            off += 8;
        }
    }
}
