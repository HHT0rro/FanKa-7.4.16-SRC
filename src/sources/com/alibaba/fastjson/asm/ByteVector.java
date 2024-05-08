package com.alibaba.fastjson.asm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ByteVector {
    public byte[] data;
    public int length;

    public ByteVector() {
        this.data = new byte[64];
    }

    private void enlarge(int i10) {
        byte[] bArr = this.data;
        int length = bArr.length * 2;
        int i11 = this.length;
        int i12 = i10 + i11;
        if (length <= i12) {
            length = i12;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i11);
        this.data = bArr2;
    }

    public ByteVector put11(int i10, int i11) {
        int i12 = this.length;
        if (i12 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] bArr = this.data;
        int i13 = i12 + 1;
        bArr[i12] = (byte) i10;
        bArr[i13] = (byte) i11;
        this.length = i13 + 1;
        return this;
    }

    public ByteVector put12(int i10, int i11) {
        int i12 = this.length;
        if (i12 + 3 > this.data.length) {
            enlarge(3);
        }
        byte[] bArr = this.data;
        int i13 = i12 + 1;
        bArr[i12] = (byte) i10;
        int i14 = i13 + 1;
        bArr[i13] = (byte) (i11 >>> 8);
        bArr[i14] = (byte) i11;
        this.length = i14 + 1;
        return this;
    }

    public ByteVector putByte(int i10) {
        int i11 = this.length;
        int i12 = i11 + 1;
        if (i12 > this.data.length) {
            enlarge(1);
        }
        this.data[i11] = (byte) i10;
        this.length = i12;
        return this;
    }

    public ByteVector putByteArray(byte[] bArr, int i10, int i11) {
        if (this.length + i11 > this.data.length) {
            enlarge(i11);
        }
        if (bArr != null) {
            System.arraycopy((Object) bArr, i10, (Object) this.data, this.length, i11);
        }
        this.length += i11;
        return this;
    }

    public ByteVector putInt(int i10) {
        int i11 = this.length;
        if (i11 + 4 > this.data.length) {
            enlarge(4);
        }
        byte[] bArr = this.data;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i10 >>> 24);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i10 >>> 16);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (i10 >>> 8);
        bArr[i14] = (byte) i10;
        this.length = i14 + 1;
        return this;
    }

    public ByteVector putShort(int i10) {
        int i11 = this.length;
        if (i11 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] bArr = this.data;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i10 >>> 8);
        bArr[i12] = (byte) i10;
        this.length = i12 + 1;
        return this;
    }

    public ByteVector putUTF8(String str) {
        int length = str.length();
        int i10 = this.length;
        if (i10 + 2 + length > this.data.length) {
            enlarge(length + 2);
        }
        byte[] bArr = this.data;
        int i11 = i10 + 1;
        bArr[i10] = (byte) (length >>> 8);
        int i12 = i11 + 1;
        bArr[i11] = (byte) length;
        int i13 = 0;
        while (i13 < length) {
            char charAt = str.charAt(i13);
            if (charAt >= 1 && charAt <= 127) {
                bArr[i12] = (byte) charAt;
                i13++;
                i12++;
            } else {
                throw new UnsupportedOperationException();
            }
        }
        this.length = i12;
        return this;
    }

    public ByteVector(int i10) {
        this.data = new byte[i10];
    }
}
