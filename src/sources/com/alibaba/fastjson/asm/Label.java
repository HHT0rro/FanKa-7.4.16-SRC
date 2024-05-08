package com.alibaba.fastjson.asm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Label {
    public int inputStackTop;
    public Label next;
    public int outputStackMax;
    public int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    public int status;
    public Label successor;

    private void addReference(int i10, int i11) {
        if (this.srcAndRefPositions == null) {
            this.srcAndRefPositions = new int[6];
        }
        int i12 = this.referenceCount;
        int[] iArr = this.srcAndRefPositions;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, iArr.length);
            this.srcAndRefPositions = iArr2;
        }
        int[] iArr3 = this.srcAndRefPositions;
        int i13 = this.referenceCount;
        int i14 = i13 + 1;
        this.referenceCount = i14;
        iArr3[i13] = i10;
        this.referenceCount = i14 + 1;
        iArr3[i14] = i11;
    }

    public void put(MethodWriter methodWriter, ByteVector byteVector, int i10) {
        if ((this.status & 2) == 0) {
            addReference(i10, byteVector.length);
            byteVector.putShort(-1);
        } else {
            byteVector.putShort(this.position - i10);
        }
    }

    public void resolve(MethodWriter methodWriter, int i10, byte[] bArr) {
        this.status |= 2;
        this.position = i10;
        int i11 = 0;
        while (i11 < this.referenceCount) {
            int[] iArr = this.srcAndRefPositions;
            int i12 = i11 + 1;
            int i13 = iArr[i11];
            int i14 = iArr[i12];
            int i15 = i10 - i13;
            bArr[i14] = (byte) (i15 >>> 8);
            bArr[i14 + 1] = (byte) i15;
            i11 = i12 + 1;
        }
    }
}
