package sun.security.util;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DerIndefLenConverter {
    private static final int CLASS_MASK = 192;
    private static final int FORM_MASK = 32;
    private static final int LEN_LONG = 128;
    private static final int LEN_MASK = 127;
    private static final int SKIP_EOC_BYTES = 2;
    private static final int TAG_MASK = 31;
    private byte[] data;
    private int dataPos;
    private int dataSize;
    private int index;
    private byte[] newData;
    private int newDataPos;
    private int unresolved = 0;
    private ArrayList<Object> ndefsList = new ArrayList<>();
    private int numOfTotalLenBytes = 0;

    private boolean isEOC(int tag) {
        return (tag & 31) == 0 && (tag & 32) == 0 && (tag & 192) == 0;
    }

    static boolean isLongForm(int lengthByte) {
        return (lengthByte & 128) == 128;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isIndefinite(int lengthByte) {
        return isLongForm(lengthByte) && (lengthByte & 127) == 0;
    }

    private void parseTag() throws IOException {
        int i10 = this.dataPos;
        if (i10 == this.dataSize) {
            return;
        }
        if (isEOC(this.data[i10]) && this.data[this.dataPos + 1] == 0) {
            int numOfEncapsulatedLenBytes = 0;
            Object elem = null;
            int index = this.ndefsList.size() - 1;
            while (index >= 0) {
                elem = this.ndefsList.get(index);
                if (elem instanceof Integer) {
                    break;
                }
                numOfEncapsulatedLenBytes += ((byte[]) elem).length - 3;
                index--;
            }
            if (index < 0) {
                throw new IOException("EOC does not have matching indefinite-length tag");
            }
            int sectionLen = (this.dataPos - ((Integer) elem).intValue()) + numOfEncapsulatedLenBytes;
            byte[] sectionLenBytes = getLengthBytes(sectionLen);
            this.ndefsList.set(index, sectionLenBytes);
            this.unresolved--;
            this.numOfTotalLenBytes += sectionLenBytes.length - 3;
        }
        int numOfEncapsulatedLenBytes2 = this.dataPos;
        this.dataPos = numOfEncapsulatedLenBytes2 + 1;
    }

    private void writeTag() {
        int i10 = this.dataPos;
        if (i10 == this.dataSize) {
            return;
        }
        byte[] bArr = this.data;
        this.dataPos = i10 + 1;
        int tag = bArr[i10];
        if (isEOC(tag)) {
            byte[] bArr2 = this.data;
            int i11 = this.dataPos;
            if (bArr2[i11] == 0) {
                this.dataPos = i11 + 1;
                writeTag();
                return;
            }
        }
        byte[] bArr3 = this.newData;
        int i12 = this.newDataPos;
        this.newDataPos = i12 + 1;
        bArr3[i12] = (byte) tag;
    }

    private int parseLength() throws IOException {
        int curLen = 0;
        int i10 = this.dataPos;
        if (i10 == this.dataSize) {
            return 0;
        }
        byte[] bArr = this.data;
        this.dataPos = i10 + 1;
        int lenByte = bArr[i10] & 255;
        if (isIndefinite(lenByte)) {
            this.ndefsList.add(new Integer(this.dataPos));
            this.unresolved++;
            return 0;
        }
        if (isLongForm(lenByte)) {
            int lenByte2 = lenByte & 127;
            if (lenByte2 > 4) {
                throw new IOException("Too much data");
            }
            if (this.dataSize - this.dataPos < lenByte2 + 1) {
                throw new IOException("Too little data");
            }
            for (int i11 = 0; i11 < lenByte2; i11++) {
                byte[] bArr2 = this.data;
                int i12 = this.dataPos;
                this.dataPos = i12 + 1;
                curLen = (curLen << 8) + (bArr2[i12] & 255);
            }
            if (curLen < 0) {
                throw new IOException("Invalid length bytes");
            }
            return curLen;
        }
        int curLen2 = lenByte & 127;
        return curLen2;
    }

    private void writeLengthAndValue() throws IOException {
        int i10 = this.dataPos;
        if (i10 == this.dataSize) {
            return;
        }
        int curLen = 0;
        byte[] bArr = this.data;
        this.dataPos = i10 + 1;
        int lenByte = bArr[i10] & 255;
        if (isIndefinite(lenByte)) {
            ArrayList<Object> arrayList = this.ndefsList;
            int i11 = this.index;
            this.index = i11 + 1;
            byte[] lenBytes = (byte[]) arrayList.get(i11);
            System.arraycopy((Object) lenBytes, 0, (Object) this.newData, this.newDataPos, lenBytes.length);
            this.newDataPos += lenBytes.length;
            return;
        }
        if (isLongForm(lenByte)) {
            int lenByte2 = lenByte & 127;
            for (int i12 = 0; i12 < lenByte2; i12++) {
                byte[] bArr2 = this.data;
                int i13 = this.dataPos;
                this.dataPos = i13 + 1;
                curLen = (curLen << 8) + (bArr2[i13] & 255);
            }
            if (curLen < 0) {
                throw new IOException("Invalid length bytes");
            }
        } else {
            curLen = lenByte & 127;
        }
        writeLength(curLen);
        writeValue(curLen);
    }

    private void writeLength(int curLen) {
        if (curLen < 128) {
            byte[] bArr = this.newData;
            int i10 = this.newDataPos;
            this.newDataPos = i10 + 1;
            bArr[i10] = (byte) curLen;
            return;
        }
        if (curLen < 256) {
            byte[] bArr2 = this.newData;
            int i11 = this.newDataPos;
            int i12 = i11 + 1;
            this.newDataPos = i12;
            bArr2[i11] = -127;
            this.newDataPos = i12 + 1;
            bArr2[i12] = (byte) curLen;
            return;
        }
        if (curLen < 65536) {
            byte[] bArr3 = this.newData;
            int i13 = this.newDataPos;
            int i14 = i13 + 1;
            this.newDataPos = i14;
            bArr3[i13] = -126;
            int i15 = i14 + 1;
            this.newDataPos = i15;
            bArr3[i14] = (byte) (curLen >> 8);
            this.newDataPos = i15 + 1;
            bArr3[i15] = (byte) curLen;
            return;
        }
        if (curLen < 16777216) {
            byte[] bArr4 = this.newData;
            int i16 = this.newDataPos;
            int i17 = i16 + 1;
            this.newDataPos = i17;
            bArr4[i16] = -125;
            int i18 = i17 + 1;
            this.newDataPos = i18;
            bArr4[i17] = (byte) (curLen >> 16);
            int i19 = i18 + 1;
            this.newDataPos = i19;
            bArr4[i18] = (byte) (curLen >> 8);
            this.newDataPos = i19 + 1;
            bArr4[i19] = (byte) curLen;
            return;
        }
        byte[] bArr5 = this.newData;
        int i20 = this.newDataPos;
        int i21 = i20 + 1;
        this.newDataPos = i21;
        bArr5[i20] = -124;
        int i22 = i21 + 1;
        this.newDataPos = i22;
        bArr5[i21] = (byte) (curLen >> 24);
        int i23 = i22 + 1;
        this.newDataPos = i23;
        bArr5[i22] = (byte) (curLen >> 16);
        int i24 = i23 + 1;
        this.newDataPos = i24;
        bArr5[i23] = (byte) (curLen >> 8);
        this.newDataPos = i24 + 1;
        bArr5[i24] = (byte) curLen;
    }

    private byte[] getLengthBytes(int curLen) {
        if (curLen < 128) {
            int i10 = 0 + 1;
            return new byte[]{(byte) curLen};
        }
        if (curLen < 256) {
            byte[] lenBytes = new byte[2];
            int index = 0 + 1;
            lenBytes[0] = -127;
            int i11 = index + 1;
            lenBytes[index] = (byte) curLen;
            return lenBytes;
        }
        if (curLen < 65536) {
            byte[] lenBytes2 = new byte[3];
            int index2 = 0 + 1;
            lenBytes2[0] = -126;
            int index3 = index2 + 1;
            lenBytes2[index2] = (byte) (curLen >> 8);
            int i12 = index3 + 1;
            lenBytes2[index3] = (byte) curLen;
            return lenBytes2;
        }
        if (curLen < 16777216) {
            byte[] lenBytes3 = new byte[4];
            int index4 = 0 + 1;
            lenBytes3[0] = -125;
            int index5 = index4 + 1;
            lenBytes3[index4] = (byte) (curLen >> 16);
            int index6 = index5 + 1;
            lenBytes3[index5] = (byte) (curLen >> 8);
            int i13 = index6 + 1;
            lenBytes3[index6] = (byte) curLen;
            return lenBytes3;
        }
        byte[] lenBytes4 = new byte[5];
        int index7 = 0 + 1;
        lenBytes4[0] = -124;
        int index8 = index7 + 1;
        lenBytes4[index7] = (byte) (curLen >> 24);
        int index9 = index8 + 1;
        lenBytes4[index8] = (byte) (curLen >> 16);
        int index10 = index9 + 1;
        lenBytes4[index9] = (byte) (curLen >> 8);
        int i14 = index10 + 1;
        lenBytes4[index10] = (byte) curLen;
        return lenBytes4;
    }

    private int getNumOfLenBytes(int len) {
        if (len < 128) {
            return 1;
        }
        if (len < 256) {
            return 2;
        }
        if (len < 65536) {
            return 3;
        }
        if (len < 16777216) {
            return 4;
        }
        return 5;
    }

    private void parseValue(int curLen) {
        this.dataPos += curLen;
    }

    private void writeValue(int curLen) {
        for (int i10 = 0; i10 < curLen; i10++) {
            byte[] bArr = this.newData;
            int i11 = this.newDataPos;
            this.newDataPos = i11 + 1;
            byte[] bArr2 = this.data;
            int i12 = this.dataPos;
            this.dataPos = i12 + 1;
            bArr[i11] = bArr2[i12];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] convert(byte[] indefData) throws IOException {
        this.data = indefData;
        this.dataPos = 0;
        this.index = 0;
        this.dataSize = indefData.length;
        int unused = 0;
        while (true) {
            if (this.dataPos >= this.dataSize) {
                break;
            }
            parseTag();
            int len = parseLength();
            parseValue(len);
            if (this.unresolved == 0) {
                int i10 = this.dataSize;
                int i11 = this.dataPos;
                unused = i10 - i11;
                this.dataSize = i11;
                break;
            }
        }
        if (this.unresolved != 0) {
            throw new IOException("not all indef len BER resolved");
        }
        this.newData = new byte[this.dataSize + this.numOfTotalLenBytes + unused];
        this.dataPos = 0;
        this.newDataPos = 0;
        this.index = 0;
        while (true) {
            int i12 = this.dataPos;
            int i13 = this.dataSize;
            if (i12 < i13) {
                writeTag();
                writeLengthAndValue();
            } else {
                System.arraycopy((Object) indefData, i13, (Object) this.newData, this.numOfTotalLenBytes + i13, unused);
                return this.newData;
            }
        }
    }
}
