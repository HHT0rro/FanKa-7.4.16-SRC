package org.apache.commons.lang3;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class BitField {
    private final int _mask;
    private final int _shift_count;

    public BitField(int i10) {
        this._mask = i10;
        this._shift_count = i10 == 0 ? 0 : Integer.numberOfTrailingZeros(i10);
    }

    public int clear(int i10) {
        return i10 & (~this._mask);
    }

    public byte clearByte(byte b4) {
        return (byte) clear(b4);
    }

    public short clearShort(short s2) {
        return (short) clear(s2);
    }

    public int getRawValue(int i10) {
        return i10 & this._mask;
    }

    public short getShortRawValue(short s2) {
        return (short) getRawValue(s2);
    }

    public short getShortValue(short s2) {
        return (short) getValue(s2);
    }

    public int getValue(int i10) {
        return getRawValue(i10) >> this._shift_count;
    }

    public boolean isAllSet(int i10) {
        int i11 = this._mask;
        return (i10 & i11) == i11;
    }

    public boolean isSet(int i10) {
        return (i10 & this._mask) != 0;
    }

    public int set(int i10) {
        return i10 | this._mask;
    }

    public int setBoolean(int i10, boolean z10) {
        return z10 ? set(i10) : clear(i10);
    }

    public byte setByte(byte b4) {
        return (byte) set(b4);
    }

    public byte setByteBoolean(byte b4, boolean z10) {
        return z10 ? setByte(b4) : clearByte(b4);
    }

    public short setShort(short s2) {
        return (short) set(s2);
    }

    public short setShortBoolean(short s2, boolean z10) {
        return z10 ? setShort(s2) : clearShort(s2);
    }

    public short setShortValue(short s2, short s10) {
        return (short) setValue(s2, s10);
    }

    public int setValue(int i10, int i11) {
        int i12 = this._mask;
        return (i10 & (~i12)) | ((i11 << this._shift_count) & i12);
    }
}
