package com.android.internal.org.bouncycastle.util;

import java.math.BigInteger;
import java.util.NoSuchElementException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class Arrays {
    private Arrays() {
    }

    public static boolean areAllZeroes(byte[] buf, int off, int len) {
        int bits = 0;
        for (int i10 = 0; i10 < len; i10++) {
            bits |= buf[off + i10];
        }
        return bits == 0;
    }

    public static boolean areEqual(boolean[] a10, boolean[] b4) {
        return java.util.Arrays.equals(a10, b4);
    }

    public static boolean areEqual(byte[] a10, byte[] b4) {
        return java.util.Arrays.equals(a10, b4);
    }

    public static boolean areEqual(byte[] a10, int aFromIndex, int aToIndex, byte[] b4, int bFromIndex, int bToIndex) {
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        if (aLength != bLength) {
            return false;
        }
        for (int i10 = 0; i10 < aLength; i10++) {
            if (a10[aFromIndex + i10] != b4[bFromIndex + i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean areEqual(char[] a10, char[] b4) {
        return java.util.Arrays.equals(a10, b4);
    }

    public static boolean areEqual(int[] a10, int[] b4) {
        return java.util.Arrays.equals(a10, b4);
    }

    public static boolean areEqual(long[] a10, long[] b4) {
        return java.util.Arrays.equals(a10, b4);
    }

    public static boolean areEqual(Object[] a10, Object[] b4) {
        return java.util.Arrays.equals(a10, b4);
    }

    public static boolean areEqual(short[] a10, short[] b4) {
        return java.util.Arrays.equals(a10, b4);
    }

    public static boolean constantTimeAreEqual(byte[] expected, byte[] supplied) {
        if (expected == null || supplied == null) {
            return false;
        }
        if (expected == supplied) {
            return true;
        }
        int len = expected.length < supplied.length ? expected.length : supplied.length;
        int nonEqual = expected.length ^ supplied.length;
        for (int i10 = 0; i10 != len; i10++) {
            nonEqual |= expected[i10] ^ supplied[i10];
        }
        for (int i11 = len; i11 < supplied.length; i11++) {
            nonEqual |= supplied[i11] ^ (~supplied[i11]);
        }
        if (nonEqual != 0) {
            return false;
        }
        return true;
    }

    public static boolean constantTimeAreEqual(int len, byte[] a10, int aOff, byte[] b4, int bOff) {
        if (a10 == null) {
            throw new NullPointerException("'a' cannot be null");
        }
        if (b4 == null) {
            throw new NullPointerException("'b' cannot be null");
        }
        if (len < 0) {
            throw new IllegalArgumentException("'len' cannot be negative");
        }
        if (aOff > a10.length - len) {
            throw new IndexOutOfBoundsException("'aOff' value invalid for specified length");
        }
        if (bOff > b4.length - len) {
            throw new IndexOutOfBoundsException("'bOff' value invalid for specified length");
        }
        int d10 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            d10 |= a10[aOff + i10] ^ b4[bOff + i10];
        }
        return d10 == 0;
    }

    public static int compareUnsigned(byte[] a10, byte[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null) {
            return -1;
        }
        if (b4 == null) {
            return 1;
        }
        int minLen = Math.min(a10.length, b4.length);
        for (int i10 = 0; i10 < minLen; i10++) {
            int aVal = a10[i10] & 255;
            int bVal = b4[i10] & 255;
            if (aVal < bVal) {
                return -1;
            }
            if (aVal > bVal) {
                return 1;
            }
        }
        int i11 = a10.length;
        if (i11 < b4.length) {
            return -1;
        }
        if (a10.length <= b4.length) {
            return 0;
        }
        return 1;
    }

    public static boolean contains(boolean[] a10, boolean val) {
        for (boolean z10 : a10) {
            if (z10 == val) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(byte[] a10, byte val) {
        for (byte b4 : a10) {
            if (b4 == val) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(char[] a10, char val) {
        for (char c4 : a10) {
            if (c4 == val) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(int[] a10, int val) {
        for (int i10 : a10) {
            if (i10 == val) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(long[] a10, long val) {
        for (long j10 : a10) {
            if (j10 == val) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(short[] a10, short val) {
        for (short s2 : a10) {
            if (s2 == val) {
                return true;
            }
        }
        return false;
    }

    public static void fill(boolean[] a10, boolean val) {
        java.util.Arrays.fill(a10, val);
    }

    public static void fill(boolean[] a10, int fromIndex, int toIndex, boolean val) {
        java.util.Arrays.fill(a10, fromIndex, toIndex, val);
    }

    public static void fill(byte[] a10, byte val) {
        java.util.Arrays.fill(a10, val);
    }

    public static void fill(byte[] a10, int fromIndex, byte val) {
        fill(a10, fromIndex, a10.length, val);
    }

    public static void fill(byte[] a10, int fromIndex, int toIndex, byte val) {
        java.util.Arrays.fill(a10, fromIndex, toIndex, val);
    }

    public static void fill(char[] a10, char val) {
        java.util.Arrays.fill(a10, val);
    }

    public static void fill(char[] a10, int fromIndex, int toIndex, char val) {
        java.util.Arrays.fill(a10, fromIndex, toIndex, val);
    }

    public static void fill(int[] a10, int val) {
        java.util.Arrays.fill(a10, val);
    }

    public static void fill(int[] a10, int fromIndex, int val) {
        java.util.Arrays.fill(a10, fromIndex, a10.length, val);
    }

    public static void fill(int[] a10, int fromIndex, int toIndex, int val) {
        java.util.Arrays.fill(a10, fromIndex, toIndex, val);
    }

    public static void fill(long[] a10, long val) {
        java.util.Arrays.fill(a10, val);
    }

    public static void fill(long[] a10, int fromIndex, long val) {
        java.util.Arrays.fill(a10, fromIndex, a10.length, val);
    }

    public static void fill(long[] a10, int fromIndex, int toIndex, long val) {
        java.util.Arrays.fill(a10, fromIndex, toIndex, val);
    }

    public static void fill(Object[] a10, Object val) {
        java.util.Arrays.fill(a10, val);
    }

    public static void fill(Object[] a10, int fromIndex, int toIndex, Object val) {
        java.util.Arrays.fill(a10, fromIndex, toIndex, val);
    }

    public static void fill(short[] a10, short val) {
        java.util.Arrays.fill(a10, val);
    }

    public static void fill(short[] a10, int fromIndex, short val) {
        java.util.Arrays.fill(a10, fromIndex, a10.length, val);
    }

    public static void fill(short[] a10, int fromIndex, int toIndex, short val) {
        java.util.Arrays.fill(a10, fromIndex, toIndex, val);
    }

    public static int hashCode(byte[] data) {
        if (data == null) {
            return 0;
        }
        int i10 = data.length;
        int hc2 = i10 + 1;
        while (true) {
            i10--;
            if (i10 >= 0) {
                hc2 = (hc2 * 257) ^ data[i10];
            } else {
                return hc2;
            }
        }
    }

    public static int hashCode(byte[] data, int off, int len) {
        if (data == null) {
            return 0;
        }
        int i10 = len;
        int hc2 = i10 + 1;
        while (true) {
            i10--;
            if (i10 >= 0) {
                hc2 = (hc2 * 257) ^ data[off + i10];
            } else {
                return hc2;
            }
        }
    }

    public static int hashCode(char[] data) {
        if (data == null) {
            return 0;
        }
        int i10 = data.length;
        int hc2 = i10 + 1;
        while (true) {
            i10--;
            if (i10 >= 0) {
                hc2 = (hc2 * 257) ^ data[i10];
            } else {
                return hc2;
            }
        }
    }

    public static int hashCode(int[][] ints) {
        int hc2 = 0;
        for (int i10 = 0; i10 != ints.length; i10++) {
            hc2 = (hc2 * 257) + hashCode(ints[i10]);
        }
        return hc2;
    }

    public static int hashCode(int[] data) {
        if (data == null) {
            return 0;
        }
        int i10 = data.length;
        int hc2 = i10 + 1;
        while (true) {
            i10--;
            if (i10 >= 0) {
                hc2 = (hc2 * 257) ^ data[i10];
            } else {
                return hc2;
            }
        }
    }

    public static int hashCode(int[] data, int off, int len) {
        if (data == null) {
            return 0;
        }
        int i10 = len;
        int hc2 = i10 + 1;
        while (true) {
            i10--;
            if (i10 >= 0) {
                hc2 = (hc2 * 257) ^ data[off + i10];
            } else {
                return hc2;
            }
        }
    }

    public static int hashCode(long[] data) {
        if (data == null) {
            return 0;
        }
        int i10 = data.length;
        int hc2 = i10 + 1;
        while (true) {
            i10--;
            if (i10 >= 0) {
                long di = data[i10];
                hc2 = (((hc2 * 257) ^ ((int) di)) * 257) ^ ((int) (di >>> 32));
            } else {
                return hc2;
            }
        }
    }

    public static int hashCode(long[] data, int off, int len) {
        if (data == null) {
            return 0;
        }
        int i10 = len;
        int hc2 = i10 + 1;
        while (true) {
            i10--;
            if (i10 >= 0) {
                long di = data[off + i10];
                hc2 = (((hc2 * 257) ^ ((int) di)) * 257) ^ ((int) (di >>> 32));
            } else {
                return hc2;
            }
        }
    }

    public static int hashCode(short[][][] shorts) {
        int hc2 = 0;
        for (int i10 = 0; i10 != shorts.length; i10++) {
            hc2 = (hc2 * 257) + hashCode(shorts[i10]);
        }
        return hc2;
    }

    public static int hashCode(short[][] shorts) {
        int hc2 = 0;
        for (int i10 = 0; i10 != shorts.length; i10++) {
            hc2 = (hc2 * 257) + hashCode(shorts[i10]);
        }
        return hc2;
    }

    public static int hashCode(short[] data) {
        if (data == null) {
            return 0;
        }
        int i10 = data.length;
        int hc2 = i10 + 1;
        while (true) {
            i10--;
            if (i10 >= 0) {
                hc2 = (hc2 * 257) ^ (data[i10] & 255);
            } else {
                return hc2;
            }
        }
    }

    public static int hashCode(Object[] data) {
        if (data == null) {
            return 0;
        }
        int i10 = data.length;
        int hc2 = i10 + 1;
        while (true) {
            i10--;
            if (i10 >= 0) {
                hc2 = (hc2 * 257) ^ Objects.hashCode(data[i10]);
            } else {
                return hc2;
            }
        }
    }

    public static boolean[] clone(boolean[] data) {
        if (data == null) {
            return null;
        }
        return (boolean[]) data.clone();
    }

    public static byte[] clone(byte[] data) {
        if (data == null) {
            return null;
        }
        return (byte[]) data.clone();
    }

    public static char[] clone(char[] data) {
        if (data == null) {
            return null;
        }
        return (char[]) data.clone();
    }

    public static int[] clone(int[] data) {
        if (data == null) {
            return null;
        }
        return (int[]) data.clone();
    }

    public static long[] clone(long[] data) {
        if (data == null) {
            return null;
        }
        return (long[]) data.clone();
    }

    public static short[] clone(short[] data) {
        if (data == null) {
            return null;
        }
        return (short[]) data.clone();
    }

    public static BigInteger[] clone(BigInteger[] data) {
        if (data == null) {
            return null;
        }
        return (BigInteger[]) data.clone();
    }

    public static byte[] clone(byte[] data, byte[] existing) {
        if (data == null) {
            return null;
        }
        if (existing == null || existing.length != data.length) {
            return clone(data);
        }
        System.arraycopy((Object) data, 0, (Object) existing, 0, existing.length);
        return existing;
    }

    public static long[] clone(long[] data, long[] existing) {
        if (data == null) {
            return null;
        }
        if (existing == null || existing.length != data.length) {
            return clone(data);
        }
        System.arraycopy((Object) data, 0, (Object) existing, 0, existing.length);
        return existing;
    }

    public static byte[][] clone(byte[][] data) {
        if (data == null) {
            return null;
        }
        byte[][] copy = new byte[data.length];
        for (int i10 = 0; i10 != copy.length; i10++) {
            copy[i10] = clone(data[i10]);
        }
        return copy;
    }

    public static byte[][][] clone(byte[][][] data) {
        if (data == null) {
            return null;
        }
        byte[][][] copy = new byte[data.length][];
        for (int i10 = 0; i10 != copy.length; i10++) {
            copy[i10] = clone(data[i10]);
        }
        return copy;
    }

    public static boolean[] copyOf(boolean[] original, int newLength) {
        boolean[] copy = new boolean[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static byte[] copyOf(byte[] original, int newLength) {
        byte[] copy = new byte[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static char[] copyOf(char[] original, int newLength) {
        char[] copy = new char[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static int[] copyOf(int[] original, int newLength) {
        int[] copy = new int[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static long[] copyOf(long[] original, int newLength) {
        long[] copy = new long[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static short[] copyOf(short[] original, int newLength) {
        short[] copy = new short[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static BigInteger[] copyOf(BigInteger[] original, int newLength) {
        BigInteger[] copy = new BigInteger[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static boolean[] copyOfRange(boolean[] original, int from, int to) {
        int newLength = getLength(from, to);
        boolean[] copy = new boolean[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static byte[] copyOfRange(byte[] original, int from, int to) {
        int newLength = getLength(from, to);
        byte[] copy = new byte[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static char[] copyOfRange(char[] original, int from, int to) {
        int newLength = getLength(from, to);
        char[] copy = new char[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static int[] copyOfRange(int[] original, int from, int to) {
        int newLength = getLength(from, to);
        int[] copy = new int[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static long[] copyOfRange(long[] original, int from, int to) {
        int newLength = getLength(from, to);
        long[] copy = new long[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static short[] copyOfRange(short[] original, int from, int to) {
        int newLength = getLength(from, to);
        short[] copy = new short[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static BigInteger[] copyOfRange(BigInteger[] original, int from, int to) {
        int newLength = getLength(from, to);
        BigInteger[] copy = new BigInteger[newLength];
        System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    private static int getLength(int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            StringBuffer sb2 = new StringBuffer(from);
            sb2.append(" > ").append(to);
            throw new IllegalArgumentException(sb2.toString());
        }
        return newLength;
    }

    public static byte[] append(byte[] a10, byte b4) {
        if (a10 == null) {
            return new byte[]{b4};
        }
        int length = a10.length;
        byte[] result = new byte[length + 1];
        System.arraycopy((Object) a10, 0, (Object) result, 0, length);
        result[length] = b4;
        return result;
    }

    public static short[] append(short[] a10, short b4) {
        if (a10 == null) {
            return new short[]{b4};
        }
        int length = a10.length;
        short[] result = new short[length + 1];
        System.arraycopy((Object) a10, 0, (Object) result, 0, length);
        result[length] = b4;
        return result;
    }

    public static int[] append(int[] a10, int b4) {
        if (a10 == null) {
            return new int[]{b4};
        }
        int length = a10.length;
        int[] result = new int[length + 1];
        System.arraycopy((Object) a10, 0, (Object) result, 0, length);
        result[length] = b4;
        return result;
    }

    public static String[] append(String[] a10, String b4) {
        if (a10 == null) {
            return new String[]{b4};
        }
        int length = a10.length;
        String[] result = new String[length + 1];
        System.arraycopy(a10, 0, result, 0, length);
        result[length] = b4;
        return result;
    }

    public static byte[] concatenate(byte[] a10, byte[] b4) {
        if (a10 == null) {
            return clone(b4);
        }
        if (b4 == null) {
            return clone(a10);
        }
        byte[] r10 = new byte[a10.length + b4.length];
        System.arraycopy((Object) a10, 0, (Object) r10, 0, a10.length);
        System.arraycopy((Object) b4, 0, (Object) r10, a10.length, b4.length);
        return r10;
    }

    public static short[] concatenate(short[] a10, short[] b4) {
        if (a10 == null) {
            return clone(b4);
        }
        if (b4 == null) {
            return clone(a10);
        }
        short[] r10 = new short[a10.length + b4.length];
        System.arraycopy((Object) a10, 0, (Object) r10, 0, a10.length);
        System.arraycopy((Object) b4, 0, (Object) r10, a10.length, b4.length);
        return r10;
    }

    public static byte[] concatenate(byte[] a10, byte[] b4, byte[] c4) {
        if (a10 == null) {
            return concatenate(b4, c4);
        }
        if (b4 == null) {
            return concatenate(a10, c4);
        }
        if (c4 == null) {
            return concatenate(a10, b4);
        }
        byte[] r10 = new byte[a10.length + b4.length + c4.length];
        System.arraycopy((Object) a10, 0, (Object) r10, 0, a10.length);
        int pos = 0 + a10.length;
        System.arraycopy((Object) b4, 0, (Object) r10, pos, b4.length);
        System.arraycopy((Object) c4, 0, (Object) r10, pos + b4.length, c4.length);
        return r10;
    }

    public static byte[] concatenate(byte[] a10, byte[] b4, byte[] c4, byte[] d10) {
        if (a10 == null) {
            return concatenate(b4, c4, d10);
        }
        if (b4 == null) {
            return concatenate(a10, c4, d10);
        }
        if (c4 == null) {
            return concatenate(a10, b4, d10);
        }
        if (d10 == null) {
            return concatenate(a10, b4, c4);
        }
        byte[] r10 = new byte[a10.length + b4.length + c4.length + d10.length];
        System.arraycopy((Object) a10, 0, (Object) r10, 0, a10.length);
        int pos = 0 + a10.length;
        System.arraycopy((Object) b4, 0, (Object) r10, pos, b4.length);
        int pos2 = pos + b4.length;
        System.arraycopy((Object) c4, 0, (Object) r10, pos2, c4.length);
        System.arraycopy((Object) d10, 0, (Object) r10, pos2 + c4.length, d10.length);
        return r10;
    }

    public static byte[] concatenate(byte[][] arrays) {
        int size = 0;
        for (int i10 = 0; i10 != arrays.length; i10++) {
            size += arrays[i10].length;
        }
        byte[] rv = new byte[size];
        int offSet = 0;
        for (int i11 = 0; i11 != arrays.length; i11++) {
            System.arraycopy((Object) arrays[i11], 0, (Object) rv, offSet, arrays[i11].length);
            offSet += arrays[i11].length;
        }
        return rv;
    }

    public static int[] concatenate(int[] a10, int[] b4) {
        if (a10 == null) {
            return clone(b4);
        }
        if (b4 == null) {
            return clone(a10);
        }
        int[] r10 = new int[a10.length + b4.length];
        System.arraycopy((Object) a10, 0, (Object) r10, 0, a10.length);
        System.arraycopy((Object) b4, 0, (Object) r10, a10.length, b4.length);
        return r10;
    }

    public static byte[] prepend(byte[] a10, byte b4) {
        if (a10 == null) {
            return new byte[]{b4};
        }
        int length = a10.length;
        byte[] result = new byte[length + 1];
        System.arraycopy((Object) a10, 0, (Object) result, 1, length);
        result[0] = b4;
        return result;
    }

    public static short[] prepend(short[] a10, short b4) {
        if (a10 == null) {
            return new short[]{b4};
        }
        int length = a10.length;
        short[] result = new short[length + 1];
        System.arraycopy((Object) a10, 0, (Object) result, 1, length);
        result[0] = b4;
        return result;
    }

    public static int[] prepend(int[] a10, int b4) {
        if (a10 == null) {
            return new int[]{b4};
        }
        int length = a10.length;
        int[] result = new int[length + 1];
        System.arraycopy((Object) a10, 0, (Object) result, 1, length);
        result[0] = b4;
        return result;
    }

    public static byte[] reverse(byte[] a10) {
        if (a10 == null) {
            return null;
        }
        int p12 = 0;
        int p22 = a10.length;
        byte[] result = new byte[p22];
        while (true) {
            p22--;
            if (p22 >= 0) {
                result[p22] = a10[p12];
                p12++;
            } else {
                return result;
            }
        }
    }

    public static int[] reverse(int[] a10) {
        if (a10 == null) {
            return null;
        }
        int p12 = 0;
        int p22 = a10.length;
        int[] result = new int[p22];
        while (true) {
            p22--;
            if (p22 >= 0) {
                result[p22] = a10[p12];
                p12++;
            } else {
                return result;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Iterator<T> implements java.util.Iterator<T> {
        private final T[] dataArray;
        private int position = 0;

        public Iterator(T[] dataArray) {
            this.dataArray = dataArray;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.dataArray.length;
        }

        @Override // java.util.Iterator
        public T next() {
            int i10 = this.position;
            T[] tArr = this.dataArray;
            if (i10 == tArr.length) {
                throw new NoSuchElementException("Out of elements: " + this.position);
            }
            this.position = i10 + 1;
            return tArr[i10];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    public static void clear(byte[] data) {
        if (data != null) {
            java.util.Arrays.fill(data, (byte) 0);
        }
    }

    public static void clear(int[] data) {
        if (data != null) {
            java.util.Arrays.fill(data, 0);
        }
    }

    public static boolean isNullOrContainsNull(Object[] array) {
        if (array == null) {
            return true;
        }
        for (Object obj : array) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNullOrEmpty(byte[] array) {
        return array == null || array.length < 1;
    }

    public static boolean isNullOrEmpty(int[] array) {
        return array == null || array.length < 1;
    }

    public static boolean isNullOrEmpty(Object[] array) {
        return array == null || array.length < 1;
    }
}
