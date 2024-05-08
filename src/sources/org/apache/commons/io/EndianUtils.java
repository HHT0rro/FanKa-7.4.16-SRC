package org.apache.commons.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class EndianUtils {
    private static int read(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (-1 != read) {
            return read;
        }
        throw new EOFException("Unexpected EOF reached");
    }

    public static double readSwappedDouble(byte[] bArr, int i10) {
        return Double.longBitsToDouble(readSwappedLong(bArr, i10));
    }

    public static float readSwappedFloat(byte[] bArr, int i10) {
        return Float.intBitsToFloat(readSwappedInteger(bArr, i10));
    }

    public static int readSwappedInteger(byte[] bArr, int i10) {
        return ((bArr[i10 + 0] & 255) << 0) + ((bArr[i10 + 1] & 255) << 8) + ((bArr[i10 + 2] & 255) << 16) + ((bArr[i10 + 3] & 255) << 24);
    }

    public static long readSwappedLong(byte[] bArr, int i10) {
        return ((((((bArr[i10 + 4] & 255) << 0) + ((bArr[i10 + 5] & 255) << 8)) + ((bArr[i10 + 6] & 255) << 16)) + ((bArr[i10 + 7] & 255) << 24)) << 32) + ((((bArr[i10 + 0] & 255) << 0) + ((bArr[i10 + 1] & 255) << 8) + ((bArr[i10 + 2] & 255) << 16) + ((bArr[i10 + 3] & 255) << 24)) & 4294967295L);
    }

    public static short readSwappedShort(byte[] bArr, int i10) {
        return (short) (((bArr[i10 + 0] & 255) << 0) + ((bArr[i10 + 1] & 255) << 8));
    }

    public static long readSwappedUnsignedInteger(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) + ((((bArr[i10 + 0] & 255) << 0) + ((bArr[i10 + 1] & 255) << 8) + ((bArr[i10 + 2] & 255) << 16)) & 4294967295L);
    }

    public static int readSwappedUnsignedShort(byte[] bArr, int i10) {
        return ((bArr[i10 + 0] & 255) << 0) + ((bArr[i10 + 1] & 255) << 8);
    }

    public static double swapDouble(double d10) {
        return Double.longBitsToDouble(swapLong(Double.doubleToLongBits(d10)));
    }

    public static float swapFloat(float f10) {
        return Float.intBitsToFloat(swapInteger(Float.floatToIntBits(f10)));
    }

    public static int swapInteger(int i10) {
        return (((i10 >> 0) & 255) << 24) + (((i10 >> 8) & 255) << 16) + (((i10 >> 16) & 255) << 8) + (((i10 >> 24) & 255) << 0);
    }

    public static long swapLong(long j10) {
        return (((j10 >> 0) & 255) << 56) + (((j10 >> 8) & 255) << 48) + (((j10 >> 16) & 255) << 40) + (((j10 >> 24) & 255) << 32) + (((j10 >> 32) & 255) << 24) + (((j10 >> 40) & 255) << 16) + (((j10 >> 48) & 255) << 8) + (((j10 >> 56) & 255) << 0);
    }

    public static short swapShort(short s2) {
        return (short) ((((s2 >> 0) & 255) << 8) + (((s2 >> 8) & 255) << 0));
    }

    public static void writeSwappedDouble(byte[] bArr, int i10, double d10) {
        writeSwappedLong(bArr, i10, Double.doubleToLongBits(d10));
    }

    public static void writeSwappedFloat(byte[] bArr, int i10, float f10) {
        writeSwappedInteger(bArr, i10, Float.floatToIntBits(f10));
    }

    public static void writeSwappedInteger(byte[] bArr, int i10, int i11) {
        bArr[i10 + 0] = (byte) ((i11 >> 0) & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
    }

    public static void writeSwappedLong(byte[] bArr, int i10, long j10) {
        bArr[i10 + 0] = (byte) ((j10 >> 0) & 255);
        bArr[i10 + 1] = (byte) ((j10 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((j10 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((j10 >> 24) & 255);
        bArr[i10 + 4] = (byte) ((j10 >> 32) & 255);
        bArr[i10 + 5] = (byte) ((j10 >> 40) & 255);
        bArr[i10 + 6] = (byte) ((j10 >> 48) & 255);
        bArr[i10 + 7] = (byte) ((j10 >> 56) & 255);
    }

    public static void writeSwappedShort(byte[] bArr, int i10, short s2) {
        bArr[i10 + 0] = (byte) ((s2 >> 0) & 255);
        bArr[i10 + 1] = (byte) ((s2 >> 8) & 255);
    }

    public static double readSwappedDouble(InputStream inputStream) throws IOException {
        return Double.longBitsToDouble(readSwappedLong(inputStream));
    }

    public static float readSwappedFloat(InputStream inputStream) throws IOException {
        return Float.intBitsToFloat(readSwappedInteger(inputStream));
    }

    public static int readSwappedInteger(InputStream inputStream) throws IOException {
        return ((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8) + ((read(inputStream) & 255) << 16) + ((read(inputStream) & 255) << 24);
    }

    public static short readSwappedShort(InputStream inputStream) throws IOException {
        return (short) (((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8));
    }

    public static int readSwappedUnsignedShort(InputStream inputStream) throws IOException {
        return ((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8);
    }

    public static void writeSwappedDouble(OutputStream outputStream, double d10) throws IOException {
        writeSwappedLong(outputStream, Double.doubleToLongBits(d10));
    }

    public static void writeSwappedFloat(OutputStream outputStream, float f10) throws IOException {
        writeSwappedInteger(outputStream, Float.floatToIntBits(f10));
    }

    public static long readSwappedLong(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8];
        for (int i10 = 0; i10 < 8; i10++) {
            bArr[i10] = (byte) read(inputStream);
        }
        return readSwappedLong(bArr, 0);
    }

    public static long readSwappedUnsignedInteger(InputStream inputStream) throws IOException {
        return ((read(inputStream) & 255) << 24) + ((((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8) + ((read(inputStream) & 255) << 16)) & 4294967295L);
    }

    public static void writeSwappedShort(OutputStream outputStream, short s2) throws IOException {
        outputStream.write((byte) ((s2 >> 0) & 255));
        outputStream.write((byte) ((s2 >> 8) & 255));
    }

    public static void writeSwappedInteger(OutputStream outputStream, int i10) throws IOException {
        outputStream.write((byte) ((i10 >> 0) & 255));
        outputStream.write((byte) ((i10 >> 8) & 255));
        outputStream.write((byte) ((i10 >> 16) & 255));
        outputStream.write((byte) ((i10 >> 24) & 255));
    }

    public static void writeSwappedLong(OutputStream outputStream, long j10) throws IOException {
        outputStream.write((byte) ((j10 >> 0) & 255));
        outputStream.write((byte) ((j10 >> 8) & 255));
        outputStream.write((byte) ((j10 >> 16) & 255));
        outputStream.write((byte) ((j10 >> 24) & 255));
        outputStream.write((byte) ((j10 >> 32) & 255));
        outputStream.write((byte) ((j10 >> 40) & 255));
        outputStream.write((byte) ((j10 >> 48) & 255));
        outputStream.write((byte) ((j10 >> 56) & 255));
    }
}
