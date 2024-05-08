package com.android.internal.org.bouncycastle.crypto.engines;

import androidx.exifinterface.media.ExifInterface;
import com.android.internal.midi.MidiConstants;
import com.android.internal.org.bouncycastle.crypto.BlockCipher;
import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.DataLengthException;
import com.android.internal.org.bouncycastle.crypto.OutputLengthException;
import com.android.internal.org.bouncycastle.crypto.params.KeyParameter;
import com.android.internal.org.bouncycastle.crypto.params.RC2Parameters;
import java.io.ObjectStreamConstants;
import okio.Utf8;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RC2Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 8;
    private static byte[] piTable = {ExifInterface.MARKER_EOI, ObjectStreamConstants.TC_ENDBLOCKDATA, -7, -60, Character.MATH_SYMBOL, -35, -75, -19, 40, -23, -3, ObjectStreamConstants.TC_RESET, 74, MidiConstants.STATUS_POLYPHONIC_AFTERTOUCH, -40, -99, -58, 126, 55, -125, 43, ObjectStreamConstants.TC_CLASS, 83, -114, 98, 76, 100, -120, 68, -117, -5, -94, 23, -102, 89, -11, -121, -77, 79, 19, 97, 69, 109, -115, 9, -127, ObjectStreamConstants.TC_PROXYCLASSDESC, 50, -67, -113, DerValue.TAG_APPLICATION, -21, -122, -73, ObjectStreamConstants.TC_EXCEPTION, 11, -16, -107, 33, 34, 92, 107, 78, -126, 84, -42, 101, -109, -50, 96, -78, 28, ObjectStreamConstants.TC_OBJECT, 86, -64, 20, -89, -116, MidiConstants.STATUS_MIDI_TIME_CODE, -36, 18, ObjectStreamConstants.TC_ARRAY, -54, 31, 59, -66, -28, -47, 66, 61, -44, 48, -93, 60, -74, 38, 111, -65, 14, -38, 70, 105, 7, 87, 39, MidiConstants.STATUS_SONG_POSITION, Character.INITIAL_QUOTE_PUNCTUATION, -101, -68, -108, 67, 3, -8, 17, -57, -10, MidiConstants.STATUS_NOTE_ON, -17, 62, -25, 6, -61, -43, 47, -56, 102, 30, -41, 8, -24, -22, -34, Byte.MIN_VALUE, 82, -18, -9, -124, -86, ObjectStreamConstants.TC_CLASSDESC, -84, 53, 77, 106, ExifInterface.START_CODE, -106, Character.CURRENCY_SYMBOL, -46, ObjectStreamConstants.TC_REFERENCE, 90, 21, 73, ObjectStreamConstants.TC_STRING, 75, -97, MidiConstants.STATUS_CHANNEL_PRESSURE, 94, 4, 24, -92, -20, -62, MidiConstants.STATUS_PITCH_BEND, 65, 110, 15, 81, -53, -52, 36, -111, -81, 80, -95, -12, 112, 57, -103, ObjectStreamConstants.TC_LONGSTRING, 58, -123, 35, -72, -76, ObjectStreamConstants.TC_BLOCKDATALONG, -4, 2, 54, 91, 37, 85, -105, 49, 45, 93, -6, -104, -29, -118, -110, -82, 5, -33, 41, 16, 103, 108, -70, -55, -45, 0, -26, -49, ExifInterface.MARKER_APP1, -98, -88, 44, 99, 22, 1, Utf8.REPLACEMENT_BYTE, 88, -30, -119, -87, 13, 56, 52, 27, -85, 51, -1, MidiConstants.STATUS_CONTROL_CHANGE, -69, 72, 12, 95, -71, -79, -51, 46, -59, MidiConstants.STATUS_SONG_SELECT, -37, 71, -27, -91, -100, ObjectStreamConstants.TC_BLOCKDATA, 10, -90, 32, 104, -2, Byte.MAX_VALUE, -63, -83};
    private boolean encrypting;
    private int[] workingKey;

    private int[] generateWorkingKey(byte[] key, int bits) {
        int[] xKey = new int[128];
        for (int i10 = 0; i10 != key.length; i10++) {
            xKey[i10] = key[i10] & 255;
        }
        int len = key.length;
        if (len < 128) {
            int len2 = 0;
            int x10 = xKey[len - 1];
            while (true) {
                byte[] bArr = piTable;
                int index = len2 + 1;
                int index2 = xKey[len2];
                x10 = bArr[(index2 + x10) & 255] & 255;
                int len3 = len + 1;
                xKey[len] = x10;
                len = len3;
                if (len3 >= 128) {
                    break;
                }
                len2 = index;
            }
        }
        int len4 = (bits + 7) >> 3;
        int x11 = piTable[xKey[128 - len4] & (255 >> ((-bits) & 7))] & 255;
        xKey[128 - len4] = x11;
        for (int i11 = (128 - len4) - 1; i11 >= 0; i11--) {
            x11 = piTable[xKey[i11 + len4] ^ x11] & 255;
            xKey[i11] = x11;
        }
        int[] newKey = new int[64];
        for (int i12 = 0; i12 != newKey.length; i12++) {
            newKey[i12] = xKey[i12 * 2] + (xKey[(i12 * 2) + 1] << 8);
        }
        return newKey;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public void init(boolean encrypting, CipherParameters params) {
        this.encrypting = encrypting;
        if (params instanceof RC2Parameters) {
            RC2Parameters param = (RC2Parameters) params;
            this.workingKey = generateWorkingKey(param.getKey(), param.getEffectiveKeyBits());
        } else {
            if (params instanceof KeyParameter) {
                byte[] key = ((KeyParameter) params).getKey();
                this.workingKey = generateWorkingKey(key, key.length * 8);
                return;
            }
            throw new IllegalArgumentException("invalid parameter passed to RC2 init - " + params.getClass().getName());
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC2";
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.BlockCipher
    public final int processBlock(byte[] in, int inOff, byte[] out, int outOff) {
        if (this.workingKey == null) {
            throw new IllegalStateException("RC2 engine not initialised");
        }
        if (inOff + 8 > in.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (outOff + 8 > out.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.encrypting) {
            encryptBlock(in, inOff, out, outOff);
            return 8;
        }
        decryptBlock(in, inOff, out, outOff);
        return 8;
    }

    private int rotateWordLeft(int x10, int y10) {
        int x11 = x10 & 65535;
        return (x11 << y10) | (x11 >> (16 - y10));
    }

    private void encryptBlock(byte[] in, int inOff, byte[] out, int outOff) {
        int x76 = ((in[inOff + 7] & 255) << 8) + (in[inOff + 6] & 255);
        int x54 = ((in[inOff + 5] & 255) << 8) + (in[inOff + 4] & 255);
        int x32 = ((in[inOff + 3] & 255) << 8) + (in[inOff + 2] & 255);
        int x10 = ((in[inOff + 1] & 255) << 8) + (in[inOff + 0] & 255);
        for (int i10 = 0; i10 <= 16; i10 += 4) {
            x10 = rotateWordLeft(((~x76) & x32) + x10 + (x54 & x76) + this.workingKey[i10], 1);
            x32 = rotateWordLeft(((~x10) & x54) + x32 + (x76 & x10) + this.workingKey[i10 + 1], 2);
            x54 = rotateWordLeft(((~x32) & x76) + x54 + (x10 & x32) + this.workingKey[i10 + 2], 3);
            x76 = rotateWordLeft(((~x54) & x10) + x76 + (x32 & x54) + this.workingKey[i10 + 3], 5);
        }
        int[] iArr = this.workingKey;
        int x102 = x10 + iArr[x76 & 63];
        int x322 = x32 + iArr[x102 & 63];
        int x542 = x54 + iArr[x322 & 63];
        int x762 = x76 + iArr[x542 & 63];
        for (int i11 = 20; i11 <= 40; i11 += 4) {
            x102 = rotateWordLeft(((~x762) & x322) + x102 + (x542 & x762) + this.workingKey[i11], 1);
            x322 = rotateWordLeft(((~x102) & x542) + x322 + (x762 & x102) + this.workingKey[i11 + 1], 2);
            x542 = rotateWordLeft(((~x322) & x762) + x542 + (x102 & x322) + this.workingKey[i11 + 2], 3);
            x762 = rotateWordLeft(((~x542) & x102) + x762 + (x322 & x542) + this.workingKey[i11 + 3], 5);
        }
        int[] iArr2 = this.workingKey;
        int x103 = x102 + iArr2[x762 & 63];
        int x323 = x322 + iArr2[x103 & 63];
        int x543 = x542 + iArr2[x323 & 63];
        int x763 = x762 + iArr2[x543 & 63];
        for (int i12 = 44; i12 < 64; i12 += 4) {
            x103 = rotateWordLeft(((~x763) & x323) + x103 + (x543 & x763) + this.workingKey[i12], 1);
            x323 = rotateWordLeft(((~x103) & x543) + x323 + (x763 & x103) + this.workingKey[i12 + 1], 2);
            x543 = rotateWordLeft(((~x323) & x763) + x543 + (x103 & x323) + this.workingKey[i12 + 2], 3);
            x763 = rotateWordLeft(((~x543) & x103) + x763 + (x323 & x543) + this.workingKey[i12 + 3], 5);
        }
        int i13 = outOff + 0;
        out[i13] = (byte) x103;
        out[outOff + 1] = (byte) (x103 >> 8);
        out[outOff + 2] = (byte) x323;
        out[outOff + 3] = (byte) (x323 >> 8);
        out[outOff + 4] = (byte) x543;
        out[outOff + 5] = (byte) (x543 >> 8);
        out[outOff + 6] = (byte) x763;
        out[outOff + 7] = (byte) (x763 >> 8);
    }

    private void decryptBlock(byte[] in, int inOff, byte[] out, int outOff) {
        int x76 = ((in[inOff + 7] & 255) << 8) + (in[inOff + 6] & 255);
        int x54 = ((in[inOff + 5] & 255) << 8) + (in[inOff + 4] & 255);
        int x32 = ((in[inOff + 3] & 255) << 8) + (in[inOff + 2] & 255);
        int x10 = ((in[inOff + 1] & 255) << 8) + (in[inOff + 0] & 255);
        for (int i10 = 60; i10 >= 44; i10 -= 4) {
            x76 = rotateWordLeft(x76, 11) - ((((~x54) & x10) + (x32 & x54)) + this.workingKey[i10 + 3]);
            x54 = rotateWordLeft(x54, 13) - ((((~x32) & x76) + (x10 & x32)) + this.workingKey[i10 + 2]);
            x32 = rotateWordLeft(x32, 14) - ((((~x10) & x54) + (x76 & x10)) + this.workingKey[i10 + 1]);
            x10 = rotateWordLeft(x10, 15) - ((((~x76) & x32) + (x54 & x76)) + this.workingKey[i10]);
        }
        int[] iArr = this.workingKey;
        int x762 = x76 - iArr[x54 & 63];
        int x542 = x54 - iArr[x32 & 63];
        int x322 = x32 - iArr[x10 & 63];
        int x102 = x10 - iArr[x762 & 63];
        for (int i11 = 40; i11 >= 20; i11 -= 4) {
            x762 = rotateWordLeft(x762, 11) - ((((~x542) & x102) + (x322 & x542)) + this.workingKey[i11 + 3]);
            x542 = rotateWordLeft(x542, 13) - ((((~x322) & x762) + (x102 & x322)) + this.workingKey[i11 + 2]);
            x322 = rotateWordLeft(x322, 14) - ((((~x102) & x542) + (x762 & x102)) + this.workingKey[i11 + 1]);
            x102 = rotateWordLeft(x102, 15) - ((((~x762) & x322) + (x542 & x762)) + this.workingKey[i11]);
        }
        int[] iArr2 = this.workingKey;
        int x763 = x762 - iArr2[x542 & 63];
        int x543 = x542 - iArr2[x322 & 63];
        int x323 = x322 - iArr2[x102 & 63];
        int x103 = x102 - iArr2[x763 & 63];
        for (int i12 = 16; i12 >= 0; i12 -= 4) {
            x763 = rotateWordLeft(x763, 11) - ((((~x543) & x103) + (x323 & x543)) + this.workingKey[i12 + 3]);
            x543 = rotateWordLeft(x543, 13) - ((((~x323) & x763) + (x103 & x323)) + this.workingKey[i12 + 2]);
            x323 = rotateWordLeft(x323, 14) - ((((~x103) & x543) + (x763 & x103)) + this.workingKey[i12 + 1]);
            x103 = rotateWordLeft(x103, 15) - ((((~x763) & x323) + (x543 & x763)) + this.workingKey[i12]);
        }
        int i13 = outOff + 0;
        out[i13] = (byte) x103;
        out[outOff + 1] = (byte) (x103 >> 8);
        out[outOff + 2] = (byte) x323;
        out[outOff + 3] = (byte) (x323 >> 8);
        out[outOff + 4] = (byte) x543;
        out[outOff + 5] = (byte) (x543 >> 8);
        out[outOff + 6] = (byte) x763;
        out[outOff + 7] = (byte) (x763 >> 8);
    }
}
