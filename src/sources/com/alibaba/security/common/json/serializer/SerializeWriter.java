package com.alibaba.security.common.json.serializer;

import com.alibaba.security.common.json.RPJSON;
import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.parser.JSONLexer;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.time.Year;
import java.util.Locale;
import java.util.zip.ZipUtils;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SerializeWriter extends Writer {
    public static final char[] DIGITS;
    public static final byte[] specicalFlags_doubleQuotes;
    public static final byte[] specicalFlags_singleQuotes;
    public char[] buf;
    public int count;
    public int features;
    public final Writer writer;
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    public static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, Year.MAX_VALUE, Integer.MAX_VALUE};
    public static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z'};
    public static final char[] DigitTens = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    public static final char[] DigitOnes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char[] ascii_chars = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    public static final char[] replaceChars = new char[93];

    static {
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i10 = 14; i10 <= 31; i10++) {
            specicalFlags_doubleQuotes[i10] = 4;
            specicalFlags_singleQuotes[i10] = 4;
        }
        for (int i11 = 127; i11 < 160; i11++) {
            specicalFlags_doubleQuotes[i11] = 4;
            specicalFlags_singleQuotes[i11] = 4;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = IOUtils.DIR_SEPARATOR_UNIX;
        cArr[92] = IOUtils.DIR_SEPARATOR_WINDOWS;
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    public static void getChars(long j10, int i10, char[] cArr) {
        char c4;
        if (j10 < 0) {
            c4 = '-';
            j10 = -j10;
        } else {
            c4 = 0;
        }
        while (j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            long j11 = j10 / 100;
            int i11 = (int) (j10 - (((j11 << 6) + (j11 << 5)) + (j11 << 2)));
            int i12 = i10 - 1;
            cArr[i12] = DigitOnes[i11];
            i10 = i12 - 1;
            cArr[i10] = DigitTens[i11];
            j10 = j11;
        }
        int i13 = (int) j10;
        while (i13 >= 65536) {
            int i14 = i13 / 100;
            int i15 = i13 - (((i14 << 6) + (i14 << 5)) + (i14 << 2));
            int i16 = i10 - 1;
            cArr[i16] = DigitOnes[i15];
            i10 = i16 - 1;
            cArr[i10] = DigitTens[i15];
            i13 = i14;
        }
        while (true) {
            int i17 = (52429 * i13) >>> 19;
            i10--;
            cArr[i10] = digits[i13 - ((i17 << 3) + (i17 << 1))];
            if (i17 == 0) {
                break;
            } else {
                i13 = i17;
            }
        }
        if (c4 != 0) {
            cArr[i10 - 1] = c4;
        }
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z10 = true;
        int i10 = this.count + length + 1;
        if (i10 > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    char charAt = str.charAt(i11);
                    byte[] bArr = specicalFlags_doubleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z10) {
                    write(34);
                }
                for (int i12 = 0; i12 < length; i12++) {
                    char charAt2 = str.charAt(i12);
                    byte[] bArr2 = specicalFlags_doubleQuotes;
                    if (charAt2 < bArr2.length && bArr2[charAt2] != 0) {
                        write(92);
                        write(replaceChars[charAt2]);
                    } else {
                        write(charAt2);
                    }
                }
                if (z10) {
                    write(34);
                }
                write(58);
                return;
            }
            expandCapacity(i10);
        }
        if (length == 0) {
            int i13 = this.count;
            if (i13 + 3 > this.buf.length) {
                expandCapacity(i13 + 3);
            }
            char[] cArr = this.buf;
            int i14 = this.count;
            int i15 = i14 + 1;
            this.count = i15;
            cArr[i14] = '\"';
            int i16 = i15 + 1;
            this.count = i16;
            cArr[i15] = '\"';
            this.count = i16 + 1;
            cArr[i16] = ShortcutConstants.SERVICES_SEPARATOR;
            return;
        }
        int i17 = this.count;
        int i18 = i17 + length;
        str.getChars(0, length, this.buf, i17);
        this.count = i10;
        int i19 = i17;
        boolean z11 = false;
        while (i19 < i18) {
            char[] cArr2 = this.buf;
            char c4 = cArr2[i19];
            byte[] bArr3 = specicalFlags_doubleQuotes;
            if (c4 < bArr3.length && bArr3[c4] != 0) {
                if (!z11) {
                    i10 += 3;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr3 = this.buf;
                    int i20 = i19 + 1;
                    System.arraycopy((Object) cArr3, i20, (Object) cArr3, i19 + 3, (i18 - i19) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy((Object) cArr4, 0, (Object) cArr4, 1, i19);
                    char[] cArr5 = this.buf;
                    cArr5[i17] = '\"';
                    cArr5[i20] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    int i21 = i20 + 1;
                    cArr5[i21] = replaceChars[c4];
                    i18 += 2;
                    cArr5[this.count - 2] = '\"';
                    i19 = i21;
                    z11 = true;
                } else {
                    i10++;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr6 = this.buf;
                    int i22 = i19 + 1;
                    System.arraycopy((Object) cArr6, i22, (Object) cArr6, i19 + 2, i18 - i19);
                    char[] cArr7 = this.buf;
                    cArr7[i19] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i22] = replaceChars[c4];
                    i18++;
                    i19 = i22;
                }
            }
            i19++;
        }
        this.buf[this.count - 1] = ShortcutConstants.SERVICES_SEPARATOR;
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z10 = true;
        int i10 = this.count + length + 1;
        if (i10 > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    char charAt = str.charAt(i11);
                    byte[] bArr = specicalFlags_singleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z10) {
                    write(39);
                }
                for (int i12 = 0; i12 < length; i12++) {
                    char charAt2 = str.charAt(i12);
                    byte[] bArr2 = specicalFlags_singleQuotes;
                    if (charAt2 < bArr2.length && bArr2[charAt2] != 0) {
                        write(92);
                        write(replaceChars[charAt2]);
                    } else {
                        write(charAt2);
                    }
                }
                if (z10) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i10);
        }
        if (length == 0) {
            int i13 = this.count;
            if (i13 + 3 > this.buf.length) {
                expandCapacity(i13 + 3);
            }
            char[] cArr = this.buf;
            int i14 = this.count;
            int i15 = i14 + 1;
            this.count = i15;
            cArr[i14] = '\'';
            int i16 = i15 + 1;
            this.count = i16;
            cArr[i15] = '\'';
            this.count = i16 + 1;
            cArr[i16] = ShortcutConstants.SERVICES_SEPARATOR;
            return;
        }
        int i17 = this.count;
        int i18 = i17 + length;
        str.getChars(0, length, this.buf, i17);
        this.count = i10;
        int i19 = i17;
        boolean z11 = false;
        while (i19 < i18) {
            char[] cArr2 = this.buf;
            char c4 = cArr2[i19];
            byte[] bArr3 = specicalFlags_singleQuotes;
            if (c4 < bArr3.length && bArr3[c4] != 0) {
                if (!z11) {
                    i10 += 3;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr3 = this.buf;
                    int i20 = i19 + 1;
                    System.arraycopy((Object) cArr3, i20, (Object) cArr3, i19 + 3, (i18 - i19) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy((Object) cArr4, 0, (Object) cArr4, 1, i19);
                    char[] cArr5 = this.buf;
                    cArr5[i17] = '\'';
                    cArr5[i20] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    int i21 = i20 + 1;
                    cArr5[i21] = replaceChars[c4];
                    i18 += 2;
                    cArr5[this.count - 2] = '\'';
                    i19 = i21;
                    z11 = true;
                } else {
                    i10++;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr6 = this.buf;
                    int i22 = i19 + 1;
                    System.arraycopy((Object) cArr6, i22, (Object) cArr6, i19 + 2, i18 - i19);
                    char[] cArr7 = this.buf;
                    cArr7[i19] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i22] = replaceChars[c4];
                    i18++;
                    i19 = i22;
                }
            }
            i19++;
        }
        this.buf[i10 - 1] = ShortcutConstants.SERVICES_SEPARATOR;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 8192) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void config(SerializerFeature serializerFeature, boolean z10) {
        if (z10) {
            this.features = serializerFeature.mask | this.features;
        } else {
            this.features = (~serializerFeature.mask) & this.features;
        }
    }

    public void expandCapacity(int i10) {
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i10) {
            i10 = length;
        }
        char[] cArr2 = new char[i10];
        System.arraycopy((Object) cArr, 0, (Object) cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e2) {
            throw new RPJSONException(e2.getMessage(), e2);
        }
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public byte[] toBytes(String str) {
        if (this.writer == null) {
            if (str == null) {
                str = "UTF-8";
            }
            try {
                return new String(this.buf, 0, this.count).getBytes(str);
            } catch (UnsupportedEncodingException e2) {
                throw new RPJSONException("toBytes error", e2);
            }
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i10) {
        int i11 = 1;
        int i12 = this.count + 1;
        if (i12 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i12);
            } else {
                flush();
                this.buf[this.count] = (char) i10;
                this.count = i11;
            }
        }
        i11 = i12;
        this.buf[this.count] = (char) i10;
        this.count = i11;
    }

    public void writeByteArray(byte[] bArr) {
        int length = bArr.length;
        boolean z10 = (this.features & SerializerFeature.UseSingleQuotes.mask) != 0;
        char c4 = z10 ? '\'' : '\"';
        if (length == 0) {
            write(z10 ? "''" : "\"\"");
            return;
        }
        char[] cArr = JSONLexer.CA;
        int i10 = (length / 3) * 3;
        int i11 = length - 1;
        int i12 = this.count;
        int i13 = (((i11 / 3) + 1) << 2) + i12 + 2;
        if (i13 > this.buf.length) {
            if (this.writer != null) {
                write(c4);
                int i14 = 0;
                while (i14 < i10) {
                    int i15 = i14 + 1;
                    int i16 = i15 + 1;
                    int i17 = ((bArr[i14] & 255) << 16) | ((bArr[i15] & 255) << 8) | (bArr[i16] & 255);
                    write(cArr[(i17 >>> 18) & 63]);
                    write(cArr[(i17 >>> 12) & 63]);
                    write(cArr[(i17 >>> 6) & 63]);
                    write(cArr[i17 & 63]);
                    i14 = i16 + 1;
                }
                int i18 = length - i10;
                if (i18 > 0) {
                    int i19 = ((bArr[i10] & 255) << 10) | (i18 == 2 ? (bArr[i11] & 255) << 2 : 0);
                    write(cArr[i19 >> 12]);
                    write(cArr[(i19 >>> 6) & 63]);
                    write(i18 == 2 ? cArr[i19 & 63] : '=');
                    write(61);
                }
                write(c4);
                return;
            }
            expandCapacity(i13);
        }
        this.count = i13;
        int i20 = i12 + 1;
        this.buf[i12] = c4;
        int i21 = 0;
        while (i21 < i10) {
            int i22 = i21 + 1;
            int i23 = i22 + 1;
            int i24 = ((bArr[i21] & 255) << 16) | ((bArr[i22] & 255) << 8);
            int i25 = i23 + 1;
            int i26 = i24 | (bArr[i23] & 255);
            char[] cArr2 = this.buf;
            int i27 = i20 + 1;
            cArr2[i20] = cArr[(i26 >>> 18) & 63];
            int i28 = i27 + 1;
            cArr2[i27] = cArr[(i26 >>> 12) & 63];
            int i29 = i28 + 1;
            cArr2[i28] = cArr[(i26 >>> 6) & 63];
            i20 = i29 + 1;
            cArr2[i29] = cArr[i26 & 63];
            i21 = i25;
        }
        int i30 = length - i10;
        if (i30 > 0) {
            int i31 = ((bArr[i10] & 255) << 10) | (i30 == 2 ? (bArr[i11] & 255) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i13 - 5] = cArr[i31 >> 12];
            cArr3[i13 - 4] = cArr[(i31 >>> 6) & 63];
            cArr3[i13 - 3] = i30 == 2 ? cArr[i31 & 63] : '=';
            cArr3[i13 - 2] = '=';
        }
        this.buf[i13 - 1] = c4;
    }

    public void writeFieldName(String str, boolean z10) {
        int i10 = this.features;
        if ((SerializerFeature.UseSingleQuotes.mask & i10) != 0) {
            if ((SerializerFeature.QuoteFieldNames.mask & i10) != 0) {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            } else {
                writeKeyWithSingleQuoteIfHasSpecial(str);
                return;
            }
        }
        if ((i10 & SerializerFeature.QuoteFieldNames.mask) != 0) {
            writeStringWithDoubleQuote(str, ShortcutConstants.SERVICES_SEPARATOR, z10);
        } else {
            writeKeyWithDoubleQuoteIfHasSpecial(str);
        }
    }

    public void writeInt(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i11 = 0;
        while ((i10 < 0 ? -i10 : i10) > sizeTable[i11]) {
            i11++;
        }
        int i12 = i11 + 1;
        if (i10 < 0) {
            i12++;
        }
        int i13 = this.count + i12;
        if (i13 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i13);
            } else {
                char[] cArr = new char[i12];
                getChars(i10, i12, cArr);
                write(cArr, 0, i12);
                return;
            }
        }
        getChars(i10, i13, this.buf);
        this.count = i13;
    }

    public void writeLong(long j10) {
        if (j10 == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        long j11 = j10 < 0 ? -j10 : j10;
        int i10 = 1;
        long j12 = 10;
        while (true) {
            if (i10 >= 19) {
                i10 = 0;
                break;
            } else {
                if (j11 < j12) {
                    break;
                }
                j12 *= 10;
                i10++;
            }
        }
        int i11 = i10 != 0 ? i10 : 19;
        if (j10 < 0) {
            i11++;
        }
        int i12 = this.count + i11;
        if (i12 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i12);
            } else {
                char[] cArr = new char[i11];
                getChars(j10, i11, cArr);
                write(cArr, 0, i11);
                return;
            }
        }
        getChars(j10, i12, this.buf);
        this.count = i12;
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str) {
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0092, code lost:
    
        if (r14 == (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0094, code lost:
    
        r15 = r3;
        r14 = r12;
        r16 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e4, code lost:
    
        if (r14 == (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c0, code lost:
    
        if ((com.alibaba.security.common.json.serializer.SerializerFeature.WriteSlashAsSpecial.mask & r17.features) != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00c8, code lost:
    
        if (r3 != '\\') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00d1, code lost:
    
        if (r3 != '\"') goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeStringWithDoubleQuote(java.lang.String r18, char r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char, boolean):void");
    }

    public void writeStringWithSingleQuote(String str) {
        int i10 = 0;
        if (str == null) {
            int i11 = this.count + 4;
            if (i11 > this.buf.length) {
                expandCapacity(i11);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i11;
            return;
        }
        int length = str.length();
        int i12 = this.count + length + 2;
        if (i12 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i10 < str.length()) {
                    char charAt = str.charAt(i10);
                    if (charAt > '\r' && charAt != '\\' && charAt != '\'' && (charAt != '/' || (this.features & SerializerFeature.WriteSlashAsSpecial.mask) == 0)) {
                        write(charAt);
                    } else {
                        write(92);
                        write(replaceChars[charAt]);
                    }
                    i10++;
                }
                write(39);
                return;
            }
            expandCapacity(i12);
        }
        int i13 = this.count;
        int i14 = i13 + 1;
        int i15 = i14 + length;
        char[] cArr = this.buf;
        cArr[i13] = '\'';
        str.getChars(0, length, cArr, i14);
        this.count = i12;
        int i16 = -1;
        char c4 = 0;
        for (int i17 = i14; i17 < i15; i17++) {
            char c10 = this.buf[i17];
            if (c10 <= '\r' || c10 == '\\' || c10 == '\'' || (c10 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                i10++;
                i16 = i17;
                c4 = c10;
            }
        }
        int i18 = i12 + i10;
        if (i18 > this.buf.length) {
            expandCapacity(i18);
        }
        this.count = i18;
        if (i10 == 1) {
            char[] cArr2 = this.buf;
            int i19 = i16 + 1;
            System.arraycopy((Object) cArr2, i19, (Object) cArr2, i16 + 2, (i15 - i16) - 1);
            char[] cArr3 = this.buf;
            cArr3[i16] = IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr3[i19] = replaceChars[c4];
        } else if (i10 > 1) {
            char[] cArr4 = this.buf;
            int i20 = i16 + 1;
            System.arraycopy((Object) cArr4, i20, (Object) cArr4, i16 + 2, (i15 - i16) - 1);
            char[] cArr5 = this.buf;
            cArr5[i16] = IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr5[i20] = replaceChars[c4];
            int i21 = i15 + 1;
            for (int i22 = i20 - 2; i22 >= i14; i22--) {
                char[] cArr6 = this.buf;
                char c11 = cArr6[i22];
                if (c11 <= '\r' || c11 == '\\' || c11 == '\'' || (c11 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                    int i23 = i22 + 1;
                    System.arraycopy((Object) cArr6, i23, (Object) cArr6, i22 + 2, (i21 - i22) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i22] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i23] = replaceChars[c11];
                    i21++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer == null) {
            writer.write(this.buf, 0, this.count);
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public SerializeWriter(Writer writer) {
        this.writer = writer;
        this.features = RPJSON.DEFAULT_GENERATE_FEATURE;
        ThreadLocal<char[]> threadLocal = bufLocal;
        this.buf = threadLocal.get();
        if (threadLocal != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer == null) {
            outputStream.write(new String(this.buf, 0, this.count).getBytes(charset.name()));
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > cArr.length || i11 < 0 || (i12 = i10 + i11) > cArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == 0) {
            return;
        }
        int i13 = this.count + i11;
        if (i13 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i13);
            }
            do {
                char[] cArr2 = this.buf;
                int length = cArr2.length;
                int i14 = this.count;
                int i15 = length - i14;
                System.arraycopy((Object) cArr, i10, (Object) cArr2, i14, i15);
                this.count = this.buf.length;
                flush();
                i11 -= i15;
                i10 += i15;
            } while (i11 > this.buf.length);
            i13 = i11;
        }
        System.arraycopy((Object) cArr, i10, (Object) this.buf, this.count, i11);
        this.count = i13;
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this(null, 0, serializerFeatureArr);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i10, i11).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public SerializeWriter(Writer writer, int i10, SerializerFeature[] serializerFeatureArr) {
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i10 |= serializerFeature.mask;
        }
        this.features = i10;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c4) {
        write(c4);
        return this;
    }

    public SerializeWriter(int i10) {
        this(null, i10);
    }

    public SerializeWriter(Writer writer, int i10) {
        this.writer = writer;
        if (i10 > 0) {
            this.buf = new char[i10];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i10);
    }

    @Override // java.io.Writer
    public void write(String str, int i10, int i11) {
        int i12;
        int i13 = this.count + i11;
        if (i13 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i13);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i14 = this.count;
                    int i15 = length - i14;
                    i12 = i10 + i15;
                    str.getChars(i10, i12, cArr, i14);
                    this.count = this.buf.length;
                    flush();
                    i11 -= i15;
                    if (i11 <= this.buf.length) {
                        break;
                    } else {
                        i10 = i12;
                    }
                }
                i13 = i11;
                i10 = i12;
            }
        }
        str.getChars(i10, i11 + i10, this.buf, this.count);
        this.count = i13;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(boolean z10) {
        write(z10 ? "true" : "false");
    }
}
