package com.android.internal.org.bouncycastle.crypto.engines;

import androidx.exifinterface.media.ExifInterface;
import com.android.internal.midi.MidiConstants;
import com.android.internal.org.bouncycastle.crypto.BlockCipher;
import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.DataLengthException;
import com.android.internal.org.bouncycastle.crypto.OutputLengthException;
import com.android.internal.org.bouncycastle.crypto.params.KeyParameter;
import java.io.ObjectStreamConstants;
import okio.Utf8;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TwofishEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int GF256_FDBK = 361;
    private static final int GF256_FDBK_2 = 180;
    private static final int GF256_FDBK_4 = 90;
    private static final int INPUT_WHITEN = 0;
    private static final int MAX_KEY_BITS = 256;
    private static final int MAX_ROUNDS = 16;
    private static final int OUTPUT_WHITEN = 4;
    private static final byte[][] P = {new byte[]{-87, 103, -77, -24, 4, -3, -93, ObjectStreamConstants.TC_CLASS, -102, -110, Byte.MIN_VALUE, ObjectStreamConstants.TC_ENDBLOCKDATA, -28, -35, -47, 56, 13, -58, 53, -104, 24, -9, -20, 108, 67, ObjectStreamConstants.TC_ARRAY, 55, 38, -6, 19, -108, 72, MidiConstants.STATUS_SONG_POSITION, MidiConstants.STATUS_CHANNEL_PRESSURE, -117, 48, -124, 84, -33, 35, Character.MATH_SYMBOL, 91, 61, 89, MidiConstants.STATUS_SONG_SELECT, -82, -94, -126, 99, 1, -125, 46, ExifInterface.MARKER_EOI, 81, -101, ObjectStreamConstants.TC_LONGSTRING, -90, -21, -91, -66, 22, 12, -29, 97, -64, -116, 58, -11, ObjectStreamConstants.TC_OBJECT, 44, 37, 11, -69, 78, -119, 107, 83, 106, -76, MidiConstants.STATUS_MIDI_TIME_CODE, ExifInterface.MARKER_APP1, -26, -67, 69, -30, -12, -74, 102, -52, -107, 3, 86, -44, 28, 30, -41, -5, -61, -114, -75, -23, -49, -65, -70, -22, ObjectStreamConstants.TC_BLOCKDATA, 57, -81, 51, -55, 98, ObjectStreamConstants.TC_REFERENCE, -127, ObjectStreamConstants.TC_RESET, 9, -83, 36, -51, -7, -40, -27, -59, -71, 77, 68, 8, -122, -25, -95, Character.INITIAL_QUOTE_PUNCTUATION, -86, -19, 6, 112, -78, -46, 65, ObjectStreamConstants.TC_EXCEPTION, MidiConstants.STATUS_POLYPHONIC_AFTERTOUCH, 17, 49, -62, 39, MidiConstants.STATUS_NOTE_ON, 32, -10, 96, -1, -106, 92, -79, -85, -98, -100, 82, 27, 95, -109, 10, -17, -111, -123, 73, -18, 45, 79, -113, 59, 71, -121, 109, 70, -42, 62, 105, 100, ExifInterface.START_CODE, -50, -53, 47, -4, -105, 5, ObjectStreamConstants.TC_BLOCKDATALONG, -84, Byte.MAX_VALUE, -43, Character.CURRENCY_SYMBOL, 75, 14, -89, 90, 40, 20, Utf8.REPLACEMENT_BYTE, 41, -120, 60, 76, 2, -72, -38, MidiConstants.STATUS_CONTROL_CHANGE, 23, 85, 31, -118, ObjectStreamConstants.TC_PROXYCLASSDESC, 87, -57, -115, ObjectStreamConstants.TC_STRING, -73, -60, -97, ObjectStreamConstants.TC_CLASSDESC, 126, 21, 34, 18, 88, 7, -103, 52, 110, 80, -34, 104, 101, -68, -37, -8, -56, -88, 43, DerValue.TAG_APPLICATION, -36, -2, 50, -92, -54, 16, 33, -16, -45, 93, 15, 0, 111, -99, 54, 66, 74, 94, -63, MidiConstants.STATUS_PITCH_BEND}, new byte[]{ObjectStreamConstants.TC_ARRAY, MidiConstants.STATUS_SONG_SELECT, -58, -12, -37, ObjectStreamConstants.TC_EXCEPTION, -5, -56, 74, -45, -26, 107, 69, ObjectStreamConstants.TC_PROXYCLASSDESC, -24, 75, -42, 50, -40, -3, 55, ObjectStreamConstants.TC_REFERENCE, MidiConstants.STATUS_MIDI_TIME_CODE, ExifInterface.MARKER_APP1, 48, 15, -8, 27, -121, -6, 6, Utf8.REPLACEMENT_BYTE, 94, -70, -82, 91, -118, 0, -68, -99, 109, -63, -79, 14, Byte.MIN_VALUE, 93, -46, -43, MidiConstants.STATUS_POLYPHONIC_AFTERTOUCH, -124, 7, 20, -75, MidiConstants.STATUS_NOTE_ON, 44, -93, -78, ObjectStreamConstants.TC_OBJECT, 76, 84, -110, ObjectStreamConstants.TC_STRING, 54, 81, 56, MidiConstants.STATUS_CONTROL_CHANGE, -67, 90, -4, 96, 98, -106, 108, 66, -9, 16, ObjectStreamConstants.TC_LONGSTRING, 40, 39, -116, 19, -107, -100, -57, 36, 70, 59, 112, -54, -29, -123, -53, 17, MidiConstants.STATUS_CHANNEL_PRESSURE, -109, -72, -90, -125, 32, -1, -97, ObjectStreamConstants.TC_BLOCKDATA, -61, -52, 3, 111, 8, -65, DerValue.TAG_APPLICATION, -25, 43, -30, ObjectStreamConstants.TC_RESET, 12, -86, -126, 65, 58, -22, -71, -28, -102, -92, -105, 126, -38, ObjectStreamConstants.TC_BLOCKDATALONG, 23, 102, -108, -95, Character.INITIAL_QUOTE_PUNCTUATION, 61, -16, -34, -77, 11, ObjectStreamConstants.TC_CLASSDESC, -89, 28, -17, -47, 83, 62, -113, 51, 38, 95, -20, ObjectStreamConstants.TC_CLASS, ExifInterface.START_CODE, 73, -127, -120, -18, 33, -60, Character.CURRENCY_SYMBOL, -21, ExifInterface.MARKER_EOI, -59, 57, -103, -51, -83, 49, -117, 1, 24, 35, -35, 31, 78, 45, -7, 72, 79, MidiConstants.STATUS_SONG_POSITION, 101, -114, ObjectStreamConstants.TC_ENDBLOCKDATA, 92, 88, Character.MATH_SYMBOL, -115, -27, -104, 87, 103, Byte.MAX_VALUE, 5, 100, -81, 99, -74, -2, -11, -73, 60, -91, -50, -23, 104, 68, MidiConstants.STATUS_PITCH_BEND, 77, 67, 105, 41, 46, -84, 21, 89, -88, 10, -98, 110, 71, -33, 52, 53, 106, -49, -36, 34, -55, -64, -101, -119, -44, -19, -85, 18, -94, 13, 82, -69, 2, 47, -87, -41, 97, 30, -76, 80, 4, -10, -62, 22, 37, -122, 86, 85, 9, -66, -111}};
    private static final int P_00 = 1;
    private static final int P_01 = 0;
    private static final int P_02 = 0;
    private static final int P_03 = 1;
    private static final int P_04 = 1;
    private static final int P_10 = 0;
    private static final int P_11 = 0;
    private static final int P_12 = 1;
    private static final int P_13 = 1;
    private static final int P_14 = 0;
    private static final int P_20 = 1;
    private static final int P_21 = 1;
    private static final int P_22 = 0;
    private static final int P_23 = 0;
    private static final int P_24 = 0;
    private static final int P_30 = 0;
    private static final int P_31 = 1;
    private static final int P_32 = 1;
    private static final int P_33 = 0;
    private static final int P_34 = 1;
    private static final int ROUNDS = 16;
    private static final int ROUND_SUBKEYS = 8;
    private static final int RS_GF_FDBK = 333;
    private static final int SK_BUMP = 16843009;
    private static final int SK_ROTL = 9;
    private static final int SK_STEP = 33686018;
    private static final int TOTAL_SUBKEYS = 40;
    private int[] gSBox;
    private int[] gSubKeys;
    private boolean encrypting = false;
    private int[] gMDS0 = new int[256];
    private int[] gMDS1 = new int[256];
    private int[] gMDS2 = new int[256];
    private int[] gMDS3 = new int[256];
    private int k64Cnt = 0;
    private byte[] workingKey = null;

    public TwofishEngine() {
        int[] m12 = new int[2];
        int[] mX = new int[2];
        int[] mY = new int[2];
        for (int i10 = 0; i10 < 256; i10++) {
            byte[][] bArr = P;
            int j10 = bArr[0][i10] & 255;
            m12[0] = j10;
            mX[0] = Mx_X(j10) & 255;
            mY[0] = Mx_Y(j10) & 255;
            int j11 = bArr[1][i10] & 255;
            m12[1] = j11;
            mX[1] = Mx_X(j11) & 255;
            mY[1] = Mx_Y(j11) & 255;
            this.gMDS0[i10] = m12[1] | (mX[1] << 8) | (mY[1] << 16) | (mY[1] << 24);
            this.gMDS1[i10] = mY[0] | (mY[0] << 8) | (mX[0] << 16) | (m12[0] << 24);
            this.gMDS2[i10] = (mY[1] << 24) | mX[1] | (mY[1] << 8) | (m12[1] << 16);
            this.gMDS3[i10] = mX[0] | (m12[0] << 8) | (mY[0] << 16) | (mX[0] << 24);
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public void init(boolean encrypting, CipherParameters params) {
        if (params instanceof KeyParameter) {
            this.encrypting = encrypting;
            byte[] key = ((KeyParameter) params).getKey();
            this.workingKey = key;
            this.k64Cnt = key.length / 8;
            setKey(key);
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Twofish init - " + params.getClass().getName());
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Twofish";
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] in, int inOff, byte[] out, int outOff) {
        if (this.workingKey == null) {
            throw new IllegalStateException("Twofish not initialised");
        }
        if (inOff + 16 > in.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (outOff + 16 > out.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.encrypting) {
            encryptBlock(in, inOff, out, outOff);
            return 16;
        }
        decryptBlock(in, inOff, out, outOff);
        return 16;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.workingKey;
        if (bArr != null) {
            setKey(bArr);
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    private void setKey(byte[] key) {
        int[] k32e;
        char c4;
        int[] k32e2 = new int[4];
        int[] k32o = new int[4];
        int[] sBoxKeys = new int[4];
        this.gSubKeys = new int[40];
        int i10 = this.k64Cnt;
        if (i10 < 1) {
            throw new IllegalArgumentException("Key size less than 64 bits");
        }
        if (i10 > 4) {
            throw new IllegalArgumentException("Key size larger than 256 bits");
        }
        for (int i11 = 0; i11 < this.k64Cnt; i11++) {
            int p10 = i11 * 8;
            k32e2[i11] = BytesTo32Bits(key, p10);
            k32o[i11] = BytesTo32Bits(key, p10 + 4);
            sBoxKeys[(this.k64Cnt - 1) - i11] = RS_MDS_Encode(k32e2[i11], k32o[i11]);
        }
        for (int i12 = 0; i12 < 20; i12++) {
            int q10 = SK_STEP * i12;
            int A = F32(q10, k32e2);
            int B = F32(16843009 + q10, k32o);
            int B2 = (B << 8) | (B >>> 24);
            int A2 = A + B2;
            int[] iArr = this.gSubKeys;
            iArr[i12 * 2] = A2;
            int A3 = A2 + B2;
            iArr[(i12 * 2) + 1] = (A3 << 9) | (A3 >>> 23);
        }
        int i13 = 0;
        int k02 = sBoxKeys[0];
        int k12 = sBoxKeys[1];
        int k22 = sBoxKeys[2];
        int i14 = 3;
        int k32 = sBoxKeys[3];
        this.gSBox = new int[1024];
        int i15 = 0;
        while (i15 < 256) {
            int b32 = i15;
            int b22 = i15;
            int b12 = i15;
            int b02 = i15;
            switch (this.k64Cnt & i14) {
                case 0:
                    byte[][] bArr = P;
                    b02 = (bArr[1][b02] & 255) ^ b0(k32);
                    b12 = (bArr[0][b12] & 255) ^ b1(k32);
                    b22 = (bArr[0][b22] & 255) ^ b2(k32);
                    c4 = 1;
                    b32 = (bArr[1][b32] & 255) ^ b3(k32);
                    break;
                case 1:
                    int[] iArr2 = this.gMDS0;
                    byte[][] bArr2 = P;
                    this.gSBox[i15 * 2] = iArr2[(bArr2[i13][b02] & 255) ^ b0(k02)];
                    this.gSBox[(i15 * 2) + 1] = this.gMDS1[(bArr2[0][b12] & 255) ^ b1(k02)];
                    this.gSBox[(i15 * 2) + 512] = this.gMDS2[(bArr2[1][b22] & 255) ^ b2(k02)];
                    this.gSBox[(i15 * 2) + 513] = this.gMDS3[(bArr2[1][b32] & 255) ^ b3(k02)];
                    k32e = k32e2;
                    continue;
                case 2:
                    int[] iArr3 = this.gMDS0;
                    byte[][] bArr3 = P;
                    byte[] bArr4 = bArr3[0];
                    k32e = k32e2;
                    this.gSBox[i15 * 2] = iArr3[(bArr4[(bArr4[b02] & 255) ^ b0(k12)] & 255) ^ b0(k02)];
                    this.gSBox[(i15 * 2) + 1] = this.gMDS1[(bArr3[0][(bArr3[1][b12] & 255) ^ b1(k12)] & 255) ^ b1(k02)];
                    this.gSBox[(i15 * 2) + 512] = this.gMDS2[(bArr3[1][(bArr3[0][b22] & 255) ^ b2(k12)] & 255) ^ b2(k02)];
                    int[] iArr4 = this.gMDS3;
                    byte[] bArr5 = bArr3[1];
                    this.gSBox[(i15 * 2) + 513] = iArr4[(bArr5[(bArr5[b32] & 255) ^ b3(k12)] & 255) ^ b3(k02)];
                    continue;
                case 3:
                    c4 = 1;
                    break;
                default:
                    k32e = k32e2;
                    continue;
            }
            byte[][] bArr6 = P;
            b02 = (bArr6[c4][b02] & 255) ^ b0(k22);
            b12 = (bArr6[c4][b12] & 255) ^ b1(k22);
            b22 = (bArr6[0][b22] & 255) ^ b2(k22);
            b32 = (bArr6[0][b32] & 255) ^ b3(k22);
            int[] iArr32 = this.gMDS0;
            byte[][] bArr32 = P;
            byte[] bArr42 = bArr32[0];
            k32e = k32e2;
            this.gSBox[i15 * 2] = iArr32[(bArr42[(bArr42[b02] & 255) ^ b0(k12)] & 255) ^ b0(k02)];
            this.gSBox[(i15 * 2) + 1] = this.gMDS1[(bArr32[0][(bArr32[1][b12] & 255) ^ b1(k12)] & 255) ^ b1(k02)];
            this.gSBox[(i15 * 2) + 512] = this.gMDS2[(bArr32[1][(bArr32[0][b22] & 255) ^ b2(k12)] & 255) ^ b2(k02)];
            int[] iArr42 = this.gMDS3;
            byte[] bArr52 = bArr32[1];
            this.gSBox[(i15 * 2) + 513] = iArr42[(bArr52[(bArr52[b32] & 255) ^ b3(k12)] & 255) ^ b3(k02)];
            continue;
            i15++;
            k32e2 = k32e;
            i13 = 0;
            i14 = 3;
        }
    }

    private void encryptBlock(byte[] src, int srcIndex, byte[] dst, int dstIndex) {
        int x02 = BytesTo32Bits(src, srcIndex) ^ this.gSubKeys[0];
        int x12 = BytesTo32Bits(src, srcIndex + 4) ^ this.gSubKeys[1];
        int x22 = BytesTo32Bits(src, srcIndex + 8) ^ this.gSubKeys[2];
        int x32 = BytesTo32Bits(src, srcIndex + 12) ^ this.gSubKeys[3];
        int t02 = 8;
        int r10 = 0;
        while (r10 < 16) {
            int t03 = Fe32_0(x02);
            int t12 = Fe32_3(x12);
            int[] iArr = this.gSubKeys;
            int k10 = t02 + 1;
            int x23 = x22 ^ ((t03 + t12) + iArr[t02]);
            x22 = (x23 >>> 1) | (x23 << 31);
            int k11 = k10 + 1;
            x32 = ((x32 << 1) | (x32 >>> 31)) ^ (((t12 * 2) + t03) + iArr[k10]);
            int t04 = Fe32_0(x22);
            int t13 = Fe32_3(x32);
            int[] iArr2 = this.gSubKeys;
            int k12 = k11 + 1;
            int x03 = x02 ^ ((t04 + t13) + iArr2[k11]);
            x02 = (x03 >>> 1) | (x03 << 31);
            x12 = ((x12 << 1) | (x12 >>> 31)) ^ (((t13 * 2) + t04) + iArr2[k12]);
            r10 += 2;
            t02 = k12 + 1;
        }
        Bits32ToBytes(this.gSubKeys[4] ^ x22, dst, dstIndex);
        Bits32ToBytes(this.gSubKeys[5] ^ x32, dst, dstIndex + 4);
        Bits32ToBytes(this.gSubKeys[6] ^ x02, dst, dstIndex + 8);
        Bits32ToBytes(this.gSubKeys[7] ^ x12, dst, dstIndex + 12);
    }

    private void decryptBlock(byte[] src, int srcIndex, byte[] dst, int dstIndex) {
        int x22 = BytesTo32Bits(src, srcIndex) ^ this.gSubKeys[4];
        int x32 = BytesTo32Bits(src, srcIndex + 4) ^ this.gSubKeys[5];
        int x02 = BytesTo32Bits(src, srcIndex + 8) ^ this.gSubKeys[6];
        int x12 = BytesTo32Bits(src, srcIndex + 12) ^ this.gSubKeys[7];
        int t02 = 39;
        int r10 = 0;
        while (r10 < 16) {
            int t03 = Fe32_0(x22);
            int t12 = Fe32_3(x32);
            int[] iArr = this.gSubKeys;
            int k10 = t02 - 1;
            int x13 = x12 ^ (((t12 * 2) + t03) + iArr[t02]);
            int k11 = k10 - 1;
            x02 = ((x02 << 1) | (x02 >>> 31)) ^ ((t03 + t12) + iArr[k10]);
            x12 = (x13 >>> 1) | (x13 << 31);
            int t04 = Fe32_0(x02);
            int t13 = Fe32_3(x12);
            int[] iArr2 = this.gSubKeys;
            int k12 = k11 - 1;
            int x33 = x32 ^ (((t13 * 2) + t04) + iArr2[k11]);
            x22 = ((x22 << 1) | (x22 >>> 31)) ^ ((t04 + t13) + iArr2[k12]);
            x32 = (x33 >>> 1) | (x33 << 31);
            r10 += 2;
            t02 = k12 - 1;
        }
        Bits32ToBytes(this.gSubKeys[0] ^ x02, dst, dstIndex);
        Bits32ToBytes(this.gSubKeys[1] ^ x12, dst, dstIndex + 4);
        Bits32ToBytes(this.gSubKeys[2] ^ x22, dst, dstIndex + 8);
        Bits32ToBytes(this.gSubKeys[3] ^ x32, dst, dstIndex + 12);
    }

    private int F32(int x10, int[] k32) {
        int b02 = b0(x10);
        int b12 = b1(x10);
        int b22 = b2(x10);
        int b32 = b3(x10);
        int k02 = k32[0];
        int k12 = k32[1];
        int k22 = k32[2];
        int k33 = k32[3];
        switch (3 & this.k64Cnt) {
            case 0:
                byte[][] bArr = P;
                b02 = (bArr[1][b02] & 255) ^ b0(k33);
                b12 = (bArr[0][b12] & 255) ^ b1(k33);
                b22 = (bArr[0][b22] & 255) ^ b2(k33);
                b32 = (bArr[1][b32] & 255) ^ b3(k33);
                break;
            case 1:
                int[] iArr = this.gMDS0;
                byte[][] bArr2 = P;
                int result = ((this.gMDS1[(bArr2[0][b12] & 255) ^ b1(k02)] ^ iArr[(bArr2[0][b02] & 255) ^ b0(k02)]) ^ this.gMDS2[(bArr2[1][b22] & 255) ^ b2(k02)]) ^ this.gMDS3[(bArr2[1][b32] & 255) ^ b3(k02)];
                return result;
            case 3:
                break;
            case 2:
                int[] iArr2 = this.gMDS0;
                byte[][] bArr3 = P;
                byte[] bArr4 = bArr3[0];
                int i10 = (this.gMDS1[(bArr3[0][(bArr3[1][b12] & 255) ^ b1(k12)] & 255) ^ b1(k02)] ^ iArr2[(bArr4[(bArr4[b02] & 255) ^ b0(k12)] & 255) ^ b0(k02)]) ^ this.gMDS2[(bArr3[1][(bArr3[0][b22] & 255) ^ b2(k12)] & 255) ^ b2(k02)];
                int[] iArr3 = this.gMDS3;
                byte[] bArr5 = bArr3[1];
                int result2 = i10 ^ iArr3[(bArr5[(bArr5[b32] & 255) ^ b3(k12)] & 255) ^ b3(k02)];
                return result2;
            default:
                return 0;
        }
        byte[][] bArr6 = P;
        b02 = (bArr6[1][b02] & 255) ^ b0(k22);
        b12 = (bArr6[1][b12] & 255) ^ b1(k22);
        b22 = (bArr6[0][b22] & 255) ^ b2(k22);
        b32 = (bArr6[0][b32] & 255) ^ b3(k22);
        int[] iArr22 = this.gMDS0;
        byte[][] bArr32 = P;
        byte[] bArr42 = bArr32[0];
        int i102 = (this.gMDS1[(bArr32[0][(bArr32[1][b12] & 255) ^ b1(k12)] & 255) ^ b1(k02)] ^ iArr22[(bArr42[(bArr42[b02] & 255) ^ b0(k12)] & 255) ^ b0(k02)]) ^ this.gMDS2[(bArr32[1][(bArr32[0][b22] & 255) ^ b2(k12)] & 255) ^ b2(k02)];
        int[] iArr32 = this.gMDS3;
        byte[] bArr52 = bArr32[1];
        int result22 = i102 ^ iArr32[(bArr52[(bArr52[b32] & 255) ^ b3(k12)] & 255) ^ b3(k02)];
        return result22;
    }

    private int RS_MDS_Encode(int k02, int k12) {
        int r10 = k12;
        for (int i10 = 0; i10 < 4; i10++) {
            r10 = RS_rem(r10);
        }
        int r11 = r10 ^ k02;
        for (int i11 = 0; i11 < 4; i11++) {
            r11 = RS_rem(r11);
        }
        return r11;
    }

    private int RS_rem(int x10) {
        int b4 = (x10 >>> 24) & 255;
        int g22 = ((b4 << 1) ^ ((b4 & 128) != 0 ? 333 : 0)) & 255;
        int g3 = ((b4 >>> 1) ^ ((b4 & 1) != 0 ? 166 : 0)) ^ g22;
        return ((((x10 << 8) ^ (g3 << 24)) ^ (g22 << 16)) ^ (g3 << 8)) ^ b4;
    }

    private int LFSR1(int x10) {
        return (x10 >> 1) ^ ((x10 & 1) != 0 ? 180 : 0);
    }

    private int LFSR2(int x10) {
        return ((x10 >> 2) ^ ((x10 & 2) != 0 ? 180 : 0)) ^ ((x10 & 1) != 0 ? 90 : 0);
    }

    private int Mx_X(int x10) {
        return LFSR2(x10) ^ x10;
    }

    private int Mx_Y(int x10) {
        return (LFSR1(x10) ^ x10) ^ LFSR2(x10);
    }

    private int b0(int x10) {
        return x10 & 255;
    }

    private int b1(int x10) {
        return (x10 >>> 8) & 255;
    }

    private int b2(int x10) {
        return (x10 >>> 16) & 255;
    }

    private int b3(int x10) {
        return (x10 >>> 24) & 255;
    }

    private int Fe32_0(int x10) {
        int[] iArr = this.gSBox;
        return iArr[(((x10 >>> 24) & 255) * 2) + 513] ^ ((iArr[((x10 & 255) * 2) + 0] ^ iArr[(((x10 >>> 8) & 255) * 2) + 1]) ^ iArr[(((x10 >>> 16) & 255) * 2) + 512]);
    }

    private int Fe32_3(int x10) {
        int[] iArr = this.gSBox;
        return iArr[(((x10 >>> 16) & 255) * 2) + 513] ^ ((iArr[(((x10 >>> 24) & 255) * 2) + 0] ^ iArr[((x10 & 255) * 2) + 1]) ^ iArr[(((x10 >>> 8) & 255) * 2) + 512]);
    }

    private int BytesTo32Bits(byte[] b4, int p10) {
        return (b4[p10] & 255) | ((b4[p10 + 1] & 255) << 8) | ((b4[p10 + 2] & 255) << 16) | ((b4[p10 + 3] & 255) << 24);
    }

    private void Bits32ToBytes(int in, byte[] b4, int offset) {
        b4[offset] = (byte) in;
        b4[offset + 1] = (byte) (in >> 8);
        b4[offset + 2] = (byte) (in >> 16);
        b4[offset + 3] = (byte) (in >> 24);
    }
}
