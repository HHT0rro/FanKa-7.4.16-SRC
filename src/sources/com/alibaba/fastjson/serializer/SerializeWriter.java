package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.RyuDouble;
import com.alibaba.fastjson.util.RyuFloat;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SerializeWriter extends Writer {
    private static int BUFFER_THRESHOLD;
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    private static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal<>();
    public static final int nonDirectFeatures;
    public boolean beanToArray;
    public boolean browserSecure;
    public char[] buf;
    public int count;
    public boolean disableCircularReferenceDetect;
    public int features;
    public char keySeperator;
    public int maxBufSize;
    public boolean notWriteDefaultValue;
    public boolean quoteFieldNames;
    public long sepcialBits;
    public boolean sortField;
    public boolean useSingleQuotes;
    public boolean writeDirect;
    public boolean writeEnumUsingName;
    public boolean writeEnumUsingToString;
    public boolean writeNonStringValueAsString;
    private final Writer writer;

    static {
        int parseInt;
        BUFFER_THRESHOLD = 131072;
        try {
            String stringProperty = IOUtils.getStringProperty("fastjson.serializer_buffer_threshold");
            if (stringProperty != null && stringProperty.length() > 0 && (parseInt = Integer.parseInt(stringProperty)) >= 64 && parseInt <= 65536) {
                BUFFER_THRESHOLD = parseInt * 1024;
            }
        } catch (Throwable unused) {
        }
        nonDirectFeatures = SerializerFeature.UseSingleQuotes.mask | 0 | SerializerFeature.BrowserCompatible.mask | SerializerFeature.PrettyFormat.mask | SerializerFeature.WriteEnumUsingToString.mask | SerializerFeature.WriteNonStringValueAsString.mask | SerializerFeature.WriteSlashAsSpecial.mask | SerializerFeature.IgnoreErrorGetter.mask | SerializerFeature.WriteClassName.mask | SerializerFeature.NotWriteDefaultValue.mask;
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        int i10 = (int) (this.count * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i10) {
            bArr = new byte[i10];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        outputStream.write(bArr, 0, encodeUTF8);
        return encodeUTF8;
    }

    private byte[] encodeToUTF8Bytes() {
        int i10 = (int) (this.count * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i10) {
            bArr = new byte[i10];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        byte[] bArr2 = new byte[encodeUTF8];
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, encodeUTF8);
        return bArr2;
    }

    private void writeEnumFieldValue(char c4, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c4, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c4, str, str2);
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        boolean z10 = true;
        int i10 = this.count + length + 1;
        int i11 = 0;
        if (i10 > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i12 = 0;
                while (true) {
                    if (i12 < length) {
                        char charAt = str.charAt(i12);
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        } else {
                            i12++;
                        }
                    } else {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    write(39);
                }
                while (i11 < length) {
                    char charAt2 = str.charAt(i11);
                    if (charAt2 < bArr.length && bArr[charAt2] != 0) {
                        write(92);
                        write(IOUtils.replaceChars[charAt2]);
                    } else {
                        write(charAt2);
                    }
                    i11++;
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
            if (c4 < bArr.length && bArr[c4] != 0) {
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
                    System.arraycopy((Object) cArr4, i11, (Object) cArr4, 1, i19);
                    char[] cArr5 = this.buf;
                    cArr5[i17] = '\'';
                    cArr5[i20] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                    int i21 = i20 + 1;
                    cArr5[i21] = IOUtils.replaceChars[c4];
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
                    cArr7[i19] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i22] = IOUtils.replaceChars[c4];
                    i18++;
                    i19 = i22;
                }
            }
            i19++;
            i11 = 0;
        }
        this.buf[i10 - 1] = ShortcutConstants.SERVICES_SEPARATOR;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= BUFFER_THRESHOLD) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void computeFeatures() {
        long j10;
        int i10 = this.features;
        boolean z10 = (SerializerFeature.QuoteFieldNames.mask & i10) != 0;
        this.quoteFieldNames = z10;
        boolean z11 = (SerializerFeature.UseSingleQuotes.mask & i10) != 0;
        this.useSingleQuotes = z11;
        this.sortField = (SerializerFeature.SortField.mask & i10) != 0;
        this.disableCircularReferenceDetect = (SerializerFeature.DisableCircularReferenceDetect.mask & i10) != 0;
        boolean z12 = (SerializerFeature.BeanToArray.mask & i10) != 0;
        this.beanToArray = z12;
        this.writeNonStringValueAsString = (SerializerFeature.WriteNonStringValueAsString.mask & i10) != 0;
        this.notWriteDefaultValue = (SerializerFeature.NotWriteDefaultValue.mask & i10) != 0;
        boolean z13 = (SerializerFeature.WriteEnumUsingName.mask & i10) != 0;
        this.writeEnumUsingName = z13;
        this.writeEnumUsingToString = (SerializerFeature.WriteEnumUsingToString.mask & i10) != 0;
        this.writeDirect = z10 && (nonDirectFeatures & i10) == 0 && (z12 || z13);
        this.keySeperator = z11 ? '\'' : '\"';
        boolean z14 = (SerializerFeature.BrowserSecure.mask & i10) != 0;
        this.browserSecure = z14;
        if (z14) {
            j10 = 5764610843043954687L;
        } else {
            j10 = (i10 & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
        }
        this.sepcialBits = j10;
    }

    public void config(SerializerFeature serializerFeature, boolean z10) {
        if (z10) {
            int mask = this.features | serializerFeature.getMask();
            this.features = mask;
            SerializerFeature serializerFeature2 = SerializerFeature.WriteEnumUsingToString;
            if (serializerFeature == serializerFeature2) {
                this.features = (~SerializerFeature.WriteEnumUsingName.getMask()) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features = (~serializerFeature2.getMask()) & mask;
            }
        } else {
            this.features = (~serializerFeature.getMask()) & this.features;
        }
        computeFeatures();
    }

    public void expandCapacity(int i10) {
        ThreadLocal<char[]> threadLocal;
        char[] cArr;
        int i11 = this.maxBufSize;
        if (i11 != -1 && i10 >= i11) {
            throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.maxBufSize + ", minimumCapacity=" + i10);
        }
        char[] cArr2 = this.buf;
        int length = cArr2.length + (cArr2.length >> 1) + 1;
        if (length >= i10) {
            i10 = length;
        }
        char[] cArr3 = new char[i10];
        System.arraycopy((Object) cArr2, 0, (Object) cArr3, 0, this.count);
        if (this.buf.length < BUFFER_THRESHOLD && ((cArr = (threadLocal = bufLocal).get()) == null || cArr.length < this.buf.length)) {
            threadLocal.set(this.buf);
        }
        this.buf = cArr3;
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
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public int getMaxBufSize() {
        return this.maxBufSize;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public void setMaxBufSize(int i10) {
        if (i10 >= this.buf.length) {
            this.maxBufSize = i10;
            return;
        }
        throw new JSONException("must > " + this.buf.length);
    }

    public int size() {
        return this.count;
    }

    public byte[] toBytes(String str) {
        Charset charset;
        if (str != null && !"UTF-8".equals(str)) {
            charset = Charset.forName(str);
        } else {
            charset = IOUtils.UTF8;
        }
        return toBytes(charset);
    }

    public char[] toCharArray() {
        if (this.writer == null) {
            int i10 = this.count;
            char[] cArr = new char[i10];
            System.arraycopy((Object) this.buf, 0, (Object) cArr, 0, i10);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer == null) {
            int i10 = this.count;
            char[] cArr = new char[i10 - 2];
            System.arraycopy((Object) this.buf, 1, (Object) cArr, 0, i10 - 2);
            return cArr;
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
        if (isEnabled(SerializerFeature.WriteClassName.mask)) {
            writeHex(bArr);
            return;
        }
        int length = bArr.length;
        boolean z10 = this.useSingleQuotes;
        char c4 = z10 ? '\'' : '\"';
        if (length == 0) {
            write(z10 ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.CA;
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

    public void writeDouble(double d10, boolean z10) {
        if (!Double.isNaN(d10) && !Double.isInfinite(d10)) {
            int i10 = this.count + 24;
            if (i10 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i10);
                } else {
                    String ryuDouble = RyuDouble.toString(d10);
                    write(ryuDouble, 0, ryuDouble.length());
                    if (z10 && isEnabled(SerializerFeature.WriteClassName)) {
                        write(68);
                        return;
                    }
                    return;
                }
            }
            this.count += RyuDouble.toString(d10, this.buf, this.count);
            if (z10 && isEnabled(SerializerFeature.WriteClassName)) {
                write(68);
                return;
            }
            return;
        }
        writeNull();
    }

    public void writeEnum(Enum<?> r32) {
        if (r32 == null) {
            writeNull();
            return;
        }
        String str = null;
        if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            str = r32.name();
        } else if (this.writeEnumUsingToString) {
            str = r32.toString();
        }
        if (str != null) {
            int i10 = isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
            write(i10);
            write(str);
            write(i10);
            return;
        }
        writeInt(r32.ordinal());
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldNameDirect(String str) {
        int length = str.length();
        int i10 = this.count + length + 3;
        if (i10 > this.buf.length) {
            expandCapacity(i10);
        }
        int i11 = this.count;
        char[] cArr = this.buf;
        cArr[i11] = '\"';
        str.getChars(0, length, cArr, i11 + 1);
        this.count = i10;
        char[] cArr2 = this.buf;
        cArr2[i10 - 2] = '\"';
        cArr2[i10 - 1] = ShortcutConstants.SERVICES_SEPARATOR;
    }

    public void writeFieldValue(char c4, String str, char c10) {
        write(c4);
        writeFieldName(str);
        if (c10 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c10));
        }
    }

    public void writeFieldValueStringWithDoubleQuote(char c4, String str, String str2) {
        int length = str.length();
        int i10 = this.count;
        int length2 = str2.length();
        int i11 = i10 + length + length2 + 6;
        if (i11 > this.buf.length) {
            if (this.writer != null) {
                write(c4);
                writeStringWithDoubleQuote(str, ShortcutConstants.SERVICES_SEPARATOR);
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i11);
        }
        char[] cArr = this.buf;
        int i12 = this.count;
        cArr[i12] = c4;
        int i13 = i12 + 2;
        int i14 = i13 + length;
        cArr[i12 + 1] = '\"';
        str.getChars(0, length, cArr, i13);
        this.count = i11;
        char[] cArr2 = this.buf;
        cArr2[i14] = '\"';
        int i15 = i14 + 1;
        int i16 = i15 + 1;
        cArr2[i15] = ShortcutConstants.SERVICES_SEPARATOR;
        cArr2[i16] = '\"';
        str2.getChars(0, length2, cArr2, i16 + 1);
        this.buf[this.count - 1] = '\"';
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0216, code lost:
    
        if (r3 != '>') goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d2, code lost:
    
        if (r1[r7] == 4) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeFieldValueStringWithDoubleQuoteCheck(char r21, java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 776
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeFieldValueStringWithDoubleQuoteCheck(char, java.lang.String, java.lang.String):void");
    }

    public void writeFloat(float f10, boolean z10) {
        if (f10 == f10 && f10 != Float.POSITIVE_INFINITY && f10 != Float.NEGATIVE_INFINITY) {
            int i10 = this.count + 15;
            if (i10 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i10);
                } else {
                    String ryuFloat = RyuFloat.toString(f10);
                    write(ryuFloat, 0, ryuFloat.length());
                    if (z10 && isEnabled(SerializerFeature.WriteClassName)) {
                        write(70);
                        return;
                    }
                    return;
                }
            }
            this.count += RyuFloat.toString(f10, this.buf, this.count);
            if (z10 && isEnabled(SerializerFeature.WriteClassName)) {
                write(70);
                return;
            }
            return;
        }
        writeNull();
    }

    public void writeHex(byte[] bArr) {
        int i10 = 2;
        int length = this.count + (bArr.length * 2) + 3;
        int i11 = 0;
        if (length > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[(bArr.length * 2) + 3];
                cArr[0] = Locale.PRIVATE_USE_EXTENSION;
                cArr[1] = '\'';
                while (i11 < bArr.length) {
                    int i12 = bArr[i11] & 255;
                    int i13 = i12 >> 4;
                    int i14 = i12 & 15;
                    int i15 = i10 + 1;
                    cArr[i10] = (char) (i13 + (i13 < 10 ? 48 : 55));
                    i10 = i15 + 1;
                    cArr[i15] = (char) (i14 + (i14 < 10 ? 48 : 55));
                    i11++;
                }
                cArr[i10] = '\'';
                try {
                    this.writer.write(cArr);
                    return;
                } catch (IOException e2) {
                    throw new JSONException("writeBytes error.", e2);
                }
            }
            expandCapacity(length);
        }
        char[] cArr2 = this.buf;
        int i16 = this.count;
        int i17 = i16 + 1;
        this.count = i17;
        cArr2[i16] = Locale.PRIVATE_USE_EXTENSION;
        this.count = i17 + 1;
        cArr2[i17] = '\'';
        while (i11 < bArr.length) {
            int i18 = bArr[i11] & 255;
            int i19 = i18 >> 4;
            int i20 = i18 & 15;
            char[] cArr3 = this.buf;
            int i21 = this.count;
            int i22 = i21 + 1;
            this.count = i22;
            cArr3[i21] = (char) (i19 + (i19 < 10 ? 48 : 55));
            this.count = i22 + 1;
            cArr3[i22] = (char) (i20 + (i20 < 10 ? 48 : 55));
            i11++;
        }
        char[] cArr4 = this.buf;
        int i23 = this.count;
        this.count = i23 + 1;
        cArr4[i23] = '\'';
    }

    public void writeInt(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int stringSize = i10 < 0 ? IOUtils.stringSize(-i10) + 1 : IOUtils.stringSize(i10);
        int i11 = this.count + stringSize;
        if (i11 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i11);
            } else {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(i10, stringSize, cArr);
                write(cArr, 0, stringSize);
                return;
            }
        }
        IOUtils.getChars(i10, i11, this.buf);
        this.count = i11;
    }

    public void writeLong(long j10) {
        boolean z10 = isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (j10 > 9007199254740991L || j10 < -9007199254740991L);
        if (j10 == Long.MIN_VALUE) {
            if (z10) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int stringSize = j10 < 0 ? IOUtils.stringSize(-j10) + 1 : IOUtils.stringSize(j10);
        int i10 = this.count + stringSize;
        if (z10) {
            i10 += 2;
        }
        if (i10 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i10);
            } else {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(j10, stringSize, cArr);
                if (z10) {
                    write(34);
                    write(cArr, 0, stringSize);
                    write(34);
                    return;
                }
                write(cArr, 0, stringSize);
                return;
            }
        }
        if (z10) {
            char[] cArr2 = this.buf;
            cArr2[this.count] = '\"';
            int i11 = i10 - 1;
            IOUtils.getChars(j10, i11, cArr2);
            this.buf[i11] = '\"';
        } else {
            IOUtils.getChars(j10, i10, this.buf);
        }
        this.count = i10;
    }

    public void writeLongAndChar(long j10, char c4) throws IOException {
        writeLong(j10);
        write(c4);
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str, char c4) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
            write(c4);
        } else {
            writeStringWithDoubleQuote(str, c4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:179:0x02eb, code lost:
    
        if (r8[r10] == 4) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0432, code lost:
    
        if (r4 != '>') goto L218;
     */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeStringWithDoubleQuote(java.lang.String r23, char r24) {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char):void");
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
                    if (charAt > '\r' && charAt != '\\' && charAt != '\'' && (charAt != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(charAt);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[charAt]);
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
            if (c10 <= '\r' || c10 == '\\' || c10 == '\'' || (c10 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
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
            cArr3[i16] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr3[i19] = IOUtils.replaceChars[c4];
        } else if (i10 > 1) {
            char[] cArr4 = this.buf;
            int i20 = i16 + 1;
            System.arraycopy((Object) cArr4, i20, (Object) cArr4, i16 + 2, (i15 - i16) - 1);
            char[] cArr5 = this.buf;
            cArr5[i16] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr5[i20] = IOUtils.replaceChars[c4];
            int i21 = i15 + 1;
            for (int i22 = i20 - 2; i22 >= i14; i22--) {
                char c11 = this.buf[i22];
                if (c11 <= '\r' || c11 == '\\' || c11 == '\'' || (c11 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.buf;
                    int i23 = i22 + 1;
                    System.arraycopy((Object) cArr6, i23, (Object) cArr6, i22 + 2, (i21 - i22) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i22] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i23] = IOUtils.replaceChars[c11];
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

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer == null) {
            if (charset == IOUtils.UTF8) {
                return encodeToUTF8(outputStream);
            }
            byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
            outputStream.write(bytes);
            return bytes.length;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public SerializeWriter(Writer writer) {
        this(writer, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public boolean isEnabled(int i10) {
        return (i10 & this.features) != 0;
    }

    public void writeFieldName(String str, boolean z10) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.useSingleQuotes) {
            if (this.quoteFieldNames) {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            } else {
                writeKeyWithSingleQuoteIfHasSpecial(str);
                return;
            }
        }
        if (this.quoteFieldNames) {
            writeStringWithDoubleQuote(str, ShortcutConstants.SERVICES_SEPARATOR);
            return;
        }
        boolean z11 = true;
        boolean z12 = str.length() == 0;
        int i10 = 0;
        while (true) {
            if (i10 >= str.length()) {
                z11 = z12;
                break;
            }
            char charAt = str.charAt(i10);
            if ((charAt < '@' && (this.sepcialBits & (1 << charAt)) != 0) || charAt == '\\') {
                break;
            } else {
                i10++;
            }
        }
        if (z11) {
            writeStringWithDoubleQuote(str, ShortcutConstants.SERVICES_SEPARATOR);
        } else {
            write(str);
            write(58);
        }
    }

    public void writeNull(SerializerFeature serializerFeature) {
        writeNull(0, serializerFeature.mask);
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    public void writeNull(int i10, int i11) {
        if ((i10 & i11) == 0 && (this.features & i11) == 0) {
            writeNull();
            return;
        }
        if (i11 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write("[]");
            return;
        }
        if (i11 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            writeString("");
            return;
        }
        if (i11 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i11 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            writeNull();
        }
    }

    public SerializeWriter(Writer writer, SerializerFeature... serializerFeatureArr) {
        this(writer, 0, serializerFeatureArr);
    }

    public byte[] toBytes(Charset charset) {
        if (this.writer == null) {
            if (charset == IOUtils.UTF8) {
                return encodeToUTF8Bytes();
            }
            return new String(this.buf, 0, this.count).getBytes(charset);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public SerializeWriter(Writer writer, int i10, SerializerFeature... serializerFeatureArr) {
        this.maxBufSize = -1;
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.buf = new char[2048];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i10 |= serializerFeature.getMask();
        }
        this.features = i10;
        computeFeatures();
    }

    public void writeFieldValue(char c4, String str, boolean z10) {
        if (!this.quoteFieldNames) {
            write(c4);
            writeFieldName(str);
            write(z10);
            return;
        }
        int i10 = z10 ? 4 : 5;
        int length = str.length();
        int i11 = this.count + length + 4 + i10;
        if (i11 > this.buf.length) {
            if (this.writer != null) {
                write(c4);
                writeString(str);
                write(58);
                write(z10);
                return;
            }
            expandCapacity(i11);
        }
        int i12 = this.count;
        this.count = i11;
        char[] cArr = this.buf;
        cArr[i12] = c4;
        int i13 = i12 + length + 1;
        cArr[i12 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i12 + 2);
        this.buf[i13 + 1] = this.keySeperator;
        if (z10) {
            System.arraycopy((Object) ":true".toCharArray(), 0, (Object) this.buf, i13 + 2, 5);
        } else {
            System.arraycopy((Object) ":false".toCharArray(), 0, (Object) this.buf, i13 + 2, 6);
        }
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0);
        }
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
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

    public void writeString(char[] cArr) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(cArr);
        } else {
            writeStringWithDoubleQuote(new String(cArr), (char) 0);
        }
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

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c4) {
        write(c4);
        return this;
    }

    public SerializeWriter(int i10) {
        this((Writer) null, i10);
    }

    public SerializeWriter(Writer writer, int i10) {
        this.maxBufSize = -1;
        this.writer = writer;
        if (i10 > 0) {
            this.buf = new char[i10];
            computeFeatures();
        } else {
            throw new IllegalArgumentException("Negative initial size: " + i10);
        }
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

    public void writeFieldValue(char c4, String str, int i10) {
        if (i10 != Integer.MIN_VALUE && this.quoteFieldNames) {
            int stringSize = i10 < 0 ? IOUtils.stringSize(-i10) + 1 : IOUtils.stringSize(i10);
            int length = str.length();
            int i11 = this.count + length + 4 + stringSize;
            if (i11 > this.buf.length) {
                if (this.writer != null) {
                    write(c4);
                    writeFieldName(str);
                    writeInt(i10);
                    return;
                }
                expandCapacity(i11);
            }
            int i12 = this.count;
            this.count = i11;
            char[] cArr = this.buf;
            cArr[i12] = c4;
            int i13 = i12 + length + 1;
            cArr[i12 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i12 + 2);
            char[] cArr2 = this.buf;
            cArr2[i13 + 1] = this.keySeperator;
            cArr2[i13 + 2] = ShortcutConstants.SERVICES_SEPARATOR;
            IOUtils.getChars(i10, this.count, cArr2);
            return;
        }
        write(c4);
        writeFieldName(str);
        writeInt(i10);
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(List<String> list) {
        boolean z10;
        int i10;
        if (list.isEmpty()) {
            write("[]");
            return;
        }
        int i11 = this.count;
        int size = list.size();
        int i12 = i11;
        int i13 = 0;
        while (i13 < size) {
            String str = list.get(i13);
            if (str == null) {
                z10 = true;
            } else {
                int length = str.length();
                z10 = false;
                for (int i14 = 0; i14 < length; i14++) {
                    char charAt = str.charAt(i14);
                    z10 = charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\\';
                    if (z10) {
                        break;
                    }
                }
            }
            if (z10) {
                this.count = i11;
                write(91);
                for (int i15 = 0; i15 < list.size(); i15++) {
                    String str2 = list.get(i15);
                    if (i15 != 0) {
                        write(44);
                    }
                    if (str2 == null) {
                        write("null");
                    } else {
                        writeStringWithDoubleQuote(str2, (char) 0);
                    }
                }
                write(93);
                return;
            }
            int length2 = str.length() + i12 + 3;
            if (i13 == list.size() - 1) {
                length2++;
            }
            if (length2 > this.buf.length) {
                this.count = i12;
                expandCapacity(length2);
            }
            if (i13 == 0) {
                i10 = i12 + 1;
                this.buf[i12] = '[';
            } else {
                i10 = i12 + 1;
                this.buf[i12] = ',';
            }
            int i16 = i10 + 1;
            this.buf[i10] = '\"';
            str.getChars(0, str.length(), this.buf, i16);
            int length3 = i16 + str.length();
            this.buf[length3] = '\"';
            i13++;
            i12 = length3 + 1;
        }
        this.buf[i12] = ']';
        this.count = i12 + 1;
    }

    public void writeStringWithSingleQuote(char[] cArr) {
        int i10 = 0;
        if (cArr == null) {
            int i11 = this.count + 4;
            if (i11 > this.buf.length) {
                expandCapacity(i11);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i11;
            return;
        }
        int length = cArr.length;
        int i12 = this.count + length + 2;
        if (i12 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i10 < cArr.length) {
                    char c4 = cArr[i10];
                    if (c4 > '\r' && c4 != '\\' && c4 != '\'' && (c4 != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(c4);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[c4]);
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
        int i15 = length + i14;
        char[] cArr2 = this.buf;
        cArr2[i13] = '\'';
        System.arraycopy((Object) cArr, 0, (Object) cArr2, i14, cArr.length);
        this.count = i12;
        int i16 = -1;
        char c10 = 0;
        for (int i17 = i14; i17 < i15; i17++) {
            char c11 = this.buf[i17];
            if (c11 <= '\r' || c11 == '\\' || c11 == '\'' || (c11 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i10++;
                i16 = i17;
                c10 = c11;
            }
        }
        int i18 = i12 + i10;
        if (i18 > this.buf.length) {
            expandCapacity(i18);
        }
        this.count = i18;
        if (i10 == 1) {
            char[] cArr3 = this.buf;
            int i19 = i16 + 1;
            System.arraycopy((Object) cArr3, i19, (Object) cArr3, i16 + 2, (i15 - i16) - 1);
            char[] cArr4 = this.buf;
            cArr4[i16] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr4[i19] = IOUtils.replaceChars[c10];
        } else if (i10 > 1) {
            char[] cArr5 = this.buf;
            int i20 = i16 + 1;
            System.arraycopy((Object) cArr5, i20, (Object) cArr5, i16 + 2, (i15 - i16) - 1);
            char[] cArr6 = this.buf;
            cArr6[i16] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr6[i20] = IOUtils.replaceChars[c10];
            int i21 = i15 + 1;
            for (int i22 = i20 - 2; i22 >= i14; i22--) {
                char c12 = this.buf[i22];
                if (c12 <= '\r' || c12 == '\\' || c12 == '\'' || (c12 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.buf;
                    int i23 = i22 + 1;
                    System.arraycopy((Object) cArr7, i23, (Object) cArr7, i22 + 2, (i21 - i22) - 1);
                    char[] cArr8 = this.buf;
                    cArr8[i22] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr8[i23] = IOUtils.replaceChars[c12];
                    i21++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeFieldValue(char c4, String str, long j10) {
        if (j10 != Long.MIN_VALUE && this.quoteFieldNames && !isEnabled(SerializerFeature.BrowserCompatible.mask)) {
            int stringSize = j10 < 0 ? IOUtils.stringSize(-j10) + 1 : IOUtils.stringSize(j10);
            int length = str.length();
            int i10 = this.count + length + 4 + stringSize;
            if (i10 > this.buf.length) {
                if (this.writer != null) {
                    write(c4);
                    writeFieldName(str);
                    writeLong(j10);
                    return;
                }
                expandCapacity(i10);
            }
            int i11 = this.count;
            this.count = i10;
            char[] cArr = this.buf;
            cArr[i11] = c4;
            int i12 = i11 + length + 1;
            cArr[i11 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i11 + 2);
            char[] cArr2 = this.buf;
            cArr2[i12 + 1] = this.keySeperator;
            cArr2[i12 + 2] = ShortcutConstants.SERVICES_SEPARATOR;
            IOUtils.getChars(j10, this.count, cArr2);
            return;
        }
        write(c4);
        writeFieldName(str);
        writeLong(j10);
    }

    public void write(boolean z10) {
        if (z10) {
            write("true");
        } else {
            write("false");
        }
    }

    public void writeFieldValue(char c4, String str, float f10) {
        write(c4);
        writeFieldName(str);
        writeFloat(f10, false);
    }

    public void writeFieldValue(char c4, String str, double d10) {
        write(c4);
        writeFieldName(str);
        writeDouble(d10, false);
    }

    public void writeFieldValue(char c4, String str, String str2) {
        if (this.quoteFieldNames) {
            if (this.useSingleQuotes) {
                write(c4);
                writeFieldName(str);
                if (str2 == null) {
                    writeNull();
                    return;
                } else {
                    writeString(str2);
                    return;
                }
            }
            if (isEnabled(SerializerFeature.BrowserCompatible)) {
                write(c4);
                writeStringWithDoubleQuote(str, ShortcutConstants.SERVICES_SEPARATOR);
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            writeFieldValueStringWithDoubleQuoteCheck(c4, str, str2);
            return;
        }
        write(c4);
        writeFieldName(str);
        if (str2 == null) {
            writeNull();
        } else {
            writeString(str2);
        }
    }

    public void writeFieldValue(char c4, String str, Enum<?> r42) {
        if (r42 == null) {
            write(c4);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c4, str, r42.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c4, str, r42.toString());
        } else {
            writeFieldValue(c4, str, r42.ordinal());
        }
    }

    public void writeFieldValue(char c4, String str, BigDecimal bigDecimal) {
        String bigDecimal2;
        write(c4);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
            return;
        }
        int scale = bigDecimal.scale();
        if (isEnabled(SerializerFeature.WriteBigDecimalAsPlain) && scale >= -100 && scale < 100) {
            bigDecimal2 = bigDecimal.toPlainString();
        } else {
            bigDecimal2 = bigDecimal.toString();
        }
        write(bigDecimal2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x02e7, code lost:
    
        if (r7[r10] == 4) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x042e, code lost:
    
        if (r3 != '>') goto L220;
     */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeStringWithDoubleQuote(char[] r24, char r25) {
        /*
            Method dump skipped, instructions count: 1332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(char[], char):void");
    }
}
