package org.apache.commons.io;

import java.io.Serializable;
import org.apache.commons.lang3.CharEncoding;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ByteOrderMark implements Serializable {
    private static final long serialVersionUID = 1;
    private final int[] bytes;
    private final String charsetName;
    public static final ByteOrderMark UTF_8 = new ByteOrderMark("UTF-8", 239, 187, 191);
    public static final ByteOrderMark UTF_16BE = new ByteOrderMark(CharEncoding.UTF_16BE, 254, 255);
    public static final ByteOrderMark UTF_16LE = new ByteOrderMark(CharEncoding.UTF_16LE, 255, 254);
    public static final ByteOrderMark UTF_32BE = new ByteOrderMark("UTF-32BE", 0, 0, 254, 255);
    public static final ByteOrderMark UTF_32LE = new ByteOrderMark("UTF-32LE", 255, 254, 0, 0);

    public ByteOrderMark(String str, int... iArr) {
        if (str != null && str.length() != 0) {
            if (iArr != null && iArr.length != 0) {
                this.charsetName = str;
                int[] iArr2 = new int[iArr.length];
                this.bytes = iArr2;
                System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, iArr.length);
                return;
            }
            throw new IllegalArgumentException("No bytes specified");
        }
        throw new IllegalArgumentException("No charsetName specified");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ByteOrderMark)) {
            return false;
        }
        ByteOrderMark byteOrderMark = (ByteOrderMark) obj;
        if (this.bytes.length != byteOrderMark.length()) {
            return false;
        }
        int i10 = 0;
        while (true) {
            int[] iArr = this.bytes;
            if (i10 >= iArr.length) {
                return true;
            }
            if (iArr[i10] != byteOrderMark.get(i10)) {
                return false;
            }
            i10++;
        }
    }

    public int get(int i10) {
        return this.bytes[i10];
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[this.bytes.length];
        int i10 = 0;
        while (true) {
            int[] iArr = this.bytes;
            if (i10 >= iArr.length) {
                return bArr;
            }
            bArr[i10] = (byte) iArr[i10];
            i10++;
        }
    }

    public String getCharsetName() {
        return this.charsetName;
    }

    public int hashCode() {
        int hashCode = getClass().hashCode();
        for (int i10 : this.bytes) {
            hashCode += i10;
        }
        return hashCode;
    }

    public int length() {
        return this.bytes.length;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('[');
        sb2.append(this.charsetName);
        sb2.append(": ");
        for (int i10 = 0; i10 < this.bytes.length; i10++) {
            if (i10 > 0) {
                sb2.append(",");
            }
            sb2.append("0x");
            sb2.append(Integer.toHexString(this.bytes[i10] & 255).toUpperCase());
        }
        sb2.append(']');
        return sb2.toString();
    }
}
