package sun.security.util;

import com.google.android.material.datepicker.UtcDates;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.zip.ZipUtils;
import sun.util.calendar.CalendarDate;
import sun.util.calendar.CalendarSystem;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DerInputBuffer extends ByteArrayInputStream implements Cloneable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DerInputBuffer(byte[] buf) {
        super(buf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DerInputBuffer(byte[] buf, int offset, int len) {
        super(buf, offset, len);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DerInputBuffer dup() {
        try {
            DerInputBuffer retval = (DerInputBuffer) clone();
            retval.mark(Integer.MAX_VALUE);
            return retval;
        } catch (CloneNotSupportedException e2) {
            throw new IllegalArgumentException(e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] toByteArray() {
        int len = available();
        if (len <= 0) {
            return null;
        }
        byte[] retval = new byte[len];
        System.arraycopy((Object) this.buf, this.pos, (Object) retval, 0, len);
        return retval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPos() {
        return this.pos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getSlice(int startPos, int size) {
        byte[] result = new byte[size];
        System.arraycopy((Object) this.buf, startPos, (Object) result, 0, size);
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int peek() throws IOException {
        if (this.pos >= this.count) {
            throw new IOException("out of data");
        }
        return this.buf[this.pos];
    }

    public boolean equals(Object other) {
        if (other instanceof DerInputBuffer) {
            return equals((DerInputBuffer) other);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean equals(DerInputBuffer other) {
        if (this == other) {
            return true;
        }
        int max = available();
        if (other.available() != max) {
            return false;
        }
        for (int i10 = 0; i10 < max; i10++) {
            if (this.buf[this.pos + i10] != other.buf[other.pos + i10]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int retval = 0;
        int len = available();
        int p10 = this.pos;
        for (int i10 = 0; i10 < len; i10++) {
            retval += this.buf[p10 + i10] * i10;
        }
        return retval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void truncate(int len) throws IOException {
        if (len > available()) {
            throw new IOException("insufficient data");
        }
        this.count = this.pos + len;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger getBigInteger(int len, boolean makePositive) throws IOException {
        if (len > available()) {
            throw new IOException("short read of integer");
        }
        if (len == 0) {
            throw new IOException("Invalid encoding: zero length Int value");
        }
        byte[] bytes = new byte[len];
        System.arraycopy((Object) this.buf, this.pos, (Object) bytes, 0, len);
        skip(len);
        if (len >= 2 && bytes[0] == 0 && bytes[1] >= 0) {
            throw new IOException("Invalid encoding: redundant leading 0s");
        }
        if (makePositive) {
            return new BigInteger(1, bytes);
        }
        return new BigInteger(bytes);
    }

    public int getInteger(int len) throws IOException {
        BigInteger result = getBigInteger(len, false);
        if (result.compareTo(BigInteger.valueOf(-2147483648L)) < 0) {
            throw new IOException("Integer below minimum valid value");
        }
        if (result.compareTo(BigInteger.valueOf(ZipUtils.UPPER_UNIXTIME_BOUND)) > 0) {
            throw new IOException("Integer exceeds maximum valid value");
        }
        return result.intValue();
    }

    public byte[] getBitString(int len) throws IOException {
        if (len > available()) {
            throw new IOException("short read of bit string");
        }
        if (len == 0) {
            throw new IOException("Invalid encoding: zero length bit string");
        }
        int numOfPadBits = this.buf[this.pos];
        if (numOfPadBits < 0 || numOfPadBits > 7) {
            throw new IOException("Invalid number of padding bits");
        }
        byte[] retval = new byte[len - 1];
        System.arraycopy((Object) this.buf, this.pos + 1, (Object) retval, 0, len - 1);
        if (numOfPadBits != 0) {
            int i10 = len - 2;
            retval[i10] = (byte) (retval[i10] & (255 << numOfPadBits));
        }
        skip(len);
        return retval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getBitString() throws IOException {
        return getBitString(available());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitArray getUnalignedBitString() throws IOException {
        if (this.pos >= this.count) {
            return null;
        }
        int len = available();
        int unusedBits = this.buf[this.pos] & 255;
        if (unusedBits > 7) {
            throw new IOException("Invalid value for unused bits: " + unusedBits);
        }
        byte[] bits = new byte[len - 1];
        int length = bits.length == 0 ? 0 : (bits.length * 8) - unusedBits;
        System.arraycopy((Object) this.buf, this.pos + 1, (Object) bits, 0, len - 1);
        BitArray bitArray = new BitArray(length, bits);
        this.pos = this.count;
        return bitArray;
    }

    public Date getUTCTime(int len) throws IOException {
        if (len > available()) {
            throw new IOException("short read of DER UTC Time");
        }
        if (len < 11 || len > 17) {
            throw new IOException("DER UTC Time length error");
        }
        return getTime(len, false);
    }

    public Date getGeneralizedTime(int len) throws IOException {
        if (len > available()) {
            throw new IOException("short read of DER Generalized Time");
        }
        if (len < 13 || len > 23) {
            throw new IOException("DER Generalized Time length error");
        }
        return getTime(len, true);
    }

    private Date getTime(int len, boolean generalized) throws IOException {
        String type;
        int year;
        int len2;
        int second;
        long time;
        if (generalized) {
            type = "Generalized";
            byte[] bArr = this.buf;
            int i10 = this.pos;
            this.pos = i10 + 1;
            int year2 = Character.digit((char) bArr[i10], 10) * 1000;
            byte[] bArr2 = this.buf;
            int i11 = this.pos;
            this.pos = i11 + 1;
            int year3 = year2 + (Character.digit((char) bArr2[i11], 10) * 100);
            byte[] bArr3 = this.buf;
            int i12 = this.pos;
            this.pos = i12 + 1;
            int year4 = year3 + (Character.digit((char) bArr3[i12], 10) * 10);
            byte[] bArr4 = this.buf;
            int i13 = this.pos;
            this.pos = i13 + 1;
            year = year4 + Character.digit((char) bArr4[i13], 10);
            len2 = len - 2;
        } else {
            type = UtcDates.UTC;
            byte[] bArr5 = this.buf;
            int i14 = this.pos;
            this.pos = i14 + 1;
            int year5 = Character.digit((char) bArr5[i14], 10) * 10;
            byte[] bArr6 = this.buf;
            int i15 = this.pos;
            this.pos = i15 + 1;
            int year6 = year5 + Character.digit((char) bArr6[i15], 10);
            if (year6 < 50) {
                year = year6 + 2000;
                len2 = len;
            } else {
                year = year6 + 1900;
                len2 = len;
            }
        }
        byte[] bArr7 = this.buf;
        int i16 = this.pos;
        this.pos = i16 + 1;
        int month = Character.digit((char) bArr7[i16], 10) * 10;
        byte[] bArr8 = this.buf;
        int i17 = this.pos;
        this.pos = i17 + 1;
        int month2 = month + Character.digit((char) bArr8[i17], 10);
        byte[] bArr9 = this.buf;
        int i18 = this.pos;
        this.pos = i18 + 1;
        int day = Character.digit((char) bArr9[i18], 10) * 10;
        byte[] bArr10 = this.buf;
        int i19 = this.pos;
        this.pos = i19 + 1;
        int day2 = day + Character.digit((char) bArr10[i19], 10);
        byte[] bArr11 = this.buf;
        int i20 = this.pos;
        this.pos = i20 + 1;
        int hour = Character.digit((char) bArr11[i20], 10) * 10;
        byte[] bArr12 = this.buf;
        int i21 = this.pos;
        this.pos = i21 + 1;
        int hour2 = hour + Character.digit((char) bArr12[i21], 10);
        byte[] bArr13 = this.buf;
        int i22 = this.pos;
        this.pos = i22 + 1;
        int minute = Character.digit((char) bArr13[i22], 10) * 10;
        byte[] bArr14 = this.buf;
        int i23 = this.pos;
        this.pos = i23 + 1;
        int minute2 = minute + Character.digit((char) bArr14[i23], 10);
        int len3 = len2 - 10;
        int millis = 0;
        if (len3 > 2 && len3 < 12) {
            byte[] bArr15 = this.buf;
            int i24 = this.pos;
            this.pos = i24 + 1;
            int second2 = Character.digit((char) bArr15[i24], 10) * 10;
            byte[] bArr16 = this.buf;
            int i25 = this.pos;
            this.pos = i25 + 1;
            second = second2 + Character.digit((char) bArr16[i25], 10);
            len3 -= 2;
            if (this.buf[this.pos] == 46 || this.buf[this.pos] == 44) {
                int len4 = len3 - 1;
                this.pos++;
                int precision = 0;
                int peek = this.pos;
                while (this.buf[peek] != 90 && this.buf[peek] != 43 && this.buf[peek] != 45) {
                    peek++;
                    precision++;
                }
                switch (precision) {
                    case 1:
                        byte[] bArr17 = this.buf;
                        int i26 = this.pos;
                        this.pos = i26 + 1;
                        millis = 0 + (Character.digit((char) bArr17[i26], 10) * 100);
                        break;
                    case 2:
                        byte[] bArr18 = this.buf;
                        int i27 = this.pos;
                        this.pos = i27 + 1;
                        int millis2 = 0 + (Character.digit((char) bArr18[i27], 10) * 100);
                        byte[] bArr19 = this.buf;
                        int i28 = this.pos;
                        this.pos = i28 + 1;
                        millis = millis2 + (Character.digit((char) bArr19[i28], 10) * 10);
                        break;
                    case 3:
                        byte[] bArr20 = this.buf;
                        int i29 = this.pos;
                        this.pos = i29 + 1;
                        int millis3 = 0 + (Character.digit((char) bArr20[i29], 10) * 100);
                        byte[] bArr21 = this.buf;
                        int i30 = this.pos;
                        this.pos = i30 + 1;
                        int millis4 = millis3 + (Character.digit((char) bArr21[i30], 10) * 10);
                        byte[] bArr22 = this.buf;
                        int i31 = this.pos;
                        this.pos = i31 + 1;
                        millis = millis4 + Character.digit((char) bArr22[i31], 10);
                        break;
                    default:
                        throw new IOException("Parse " + type + " time, unsupported precision for seconds value");
                }
                len3 = len4 - precision;
            }
        } else {
            second = 0;
        }
        if (month2 == 0 || day2 == 0 || month2 > 12 || day2 > 31 || hour2 >= 24 || minute2 >= 60 || second >= 60) {
            throw new IOException("Parse " + type + " time, invalid format");
        }
        CalendarSystem gcal = CalendarSystem.getGregorianCalendar();
        CalendarDate date = gcal.newCalendarDate(null);
        date.setDate(year, month2, day2);
        date.setTimeOfDay(hour2, minute2, second, millis);
        long time2 = gcal.getTime(date);
        if (len3 != 1 && len3 != 5) {
            throw new IOException("Parse " + type + " time, invalid offset");
        }
        byte[] bArr23 = this.buf;
        int i32 = this.pos;
        this.pos = i32 + 1;
        switch (bArr23[i32]) {
            case 43:
                byte[] bArr24 = this.buf;
                int i33 = this.pos;
                this.pos = i33 + 1;
                int hr = Character.digit((char) bArr24[i33], 10) * 10;
                byte[] bArr25 = this.buf;
                int i34 = this.pos;
                this.pos = i34 + 1;
                int hr2 = hr + Character.digit((char) bArr25[i34], 10);
                byte[] bArr26 = this.buf;
                int i35 = this.pos;
                this.pos = i35 + 1;
                int min = Character.digit((char) bArr26[i35], 10) * 10;
                byte[] bArr27 = this.buf;
                int i36 = this.pos;
                this.pos = i36 + 1;
                int min2 = min + Character.digit((char) bArr27[i36], 10);
                if (hr2 >= 24 || min2 >= 60) {
                    throw new IOException("Parse " + type + " time, +hhmm");
                }
                time = time2 - ((((hr2 * 60) + min2) * 60) * 1000);
                break;
            case 45:
                byte[] bArr28 = this.buf;
                int i37 = this.pos;
                this.pos = i37 + 1;
                int hr3 = Character.digit((char) bArr28[i37], 10) * 10;
                byte[] bArr29 = this.buf;
                int i38 = this.pos;
                int year7 = i38 + 1;
                this.pos = year7;
                int hr4 = hr3 + Character.digit((char) bArr29[i38], 10);
                byte[] bArr30 = this.buf;
                int i39 = this.pos;
                this.pos = i39 + 1;
                int min3 = Character.digit((char) bArr30[i39], 10) * 10;
                byte[] bArr31 = this.buf;
                int i40 = this.pos;
                this.pos = i40 + 1;
                int min4 = min3 + Character.digit((char) bArr31[i40], 10);
                if (hr4 >= 24 || min4 >= 60) {
                    throw new IOException("Parse " + type + " time, -hhmm");
                }
                time = time2 + (((hr4 * 60) + min4) * 60 * 1000);
                break;
                break;
            case 90:
                time = time2;
                break;
            default:
                throw new IOException("Parse " + type + " time, garbage offset");
        }
        return new Date(time);
    }
}
