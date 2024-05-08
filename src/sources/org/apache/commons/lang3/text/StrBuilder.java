package org.apache.commons.lang3.text;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.Builder;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class StrBuilder implements CharSequence, Appendable, Serializable, Builder<String> {
    public static final int CAPACITY = 32;
    private static final long serialVersionUID = 7628716375283629643L;
    public char[] buffer;
    private String newLine;
    private String nullText;
    public int size;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class StrBuilderTokenizer extends StrTokenizer {
        public StrBuilderTokenizer() {
        }

        @Override // org.apache.commons.lang3.text.StrTokenizer
        public String getContent() {
            String content = super.getContent();
            return content == null ? StrBuilder.this.toString() : content;
        }

        @Override // org.apache.commons.lang3.text.StrTokenizer
        public List<String> tokenize(char[] cArr, int i10, int i11) {
            if (cArr == null) {
                StrBuilder strBuilder = StrBuilder.this;
                return super.tokenize(strBuilder.buffer, 0, strBuilder.size());
            }
            return super.tokenize(cArr, i10, i11);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class StrBuilderWriter extends Writer {
        public StrBuilderWriter() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i10) {
            StrBuilder.this.append((char) i10);
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            StrBuilder.this.append(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            StrBuilder.this.append(cArr, i10, i11);
        }

        @Override // java.io.Writer
        public void write(String str) {
            StrBuilder.this.append(str);
        }

        @Override // java.io.Writer
        public void write(String str, int i10, int i11) {
            StrBuilder.this.append(str, i10, i11);
        }
    }

    public StrBuilder() {
        this(32);
    }

    private void deleteImpl(int i10, int i11, int i12) {
        char[] cArr = this.buffer;
        System.arraycopy((Object) cArr, i11, (Object) cArr, i10, this.size - i11);
        this.size -= i12;
    }

    private void replaceImpl(int i10, int i11, int i12, String str, int i13) {
        int i14 = (this.size - i12) + i13;
        if (i13 != i12) {
            ensureCapacity(i14);
            char[] cArr = this.buffer;
            System.arraycopy((Object) cArr, i11, (Object) cArr, i10 + i13, this.size - i11);
            this.size = i14;
        }
        if (i13 > 0) {
            str.getChars(0, i13, this.buffer, i10);
        }
    }

    public <T> StrBuilder appendAll(T... tArr) {
        if (tArr != null && tArr.length > 0) {
            for (T t2 : tArr) {
                append(t2);
            }
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(Object obj, int i10, char c4) {
        if (i10 > 0) {
            ensureCapacity(this.size + i10);
            String nullText = obj == null ? getNullText() : obj.toString();
            if (nullText == null) {
                nullText = "";
            }
            int length = nullText.length();
            if (length >= i10) {
                nullText.getChars(length - i10, length, this.buffer, this.size);
            } else {
                int i11 = i10 - length;
                for (int i12 = 0; i12 < i11; i12++) {
                    this.buffer[this.size + i12] = c4;
                }
                nullText.getChars(0, length, this.buffer, this.size + i11);
            }
            this.size += i10;
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadRight(Object obj, int i10, char c4) {
        if (i10 > 0) {
            ensureCapacity(this.size + i10);
            String nullText = obj == null ? getNullText() : obj.toString();
            if (nullText == null) {
                nullText = "";
            }
            int length = nullText.length();
            if (length >= i10) {
                nullText.getChars(0, i10, this.buffer, this.size);
            } else {
                int i11 = i10 - length;
                nullText.getChars(0, length, this.buffer, this.size);
                for (int i12 = 0; i12 < i11; i12++) {
                    this.buffer[this.size + length + i12] = c4;
                }
            }
            this.size += i10;
        }
        return this;
    }

    public StrBuilder appendNewLine() {
        String str = this.newLine;
        if (str == null) {
            append(System.lineSeparator());
            return this;
        }
        return append(str);
    }

    public StrBuilder appendNull() {
        String str = this.nullText;
        return str == null ? this : append(str);
    }

    public StrBuilder appendPadding(int i10, char c4) {
        if (i10 >= 0) {
            ensureCapacity(this.size + i10);
            for (int i11 = 0; i11 < i10; i11++) {
                char[] cArr = this.buffer;
                int i12 = this.size;
                this.size = i12 + 1;
                cArr[i12] = c4;
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(String str) {
        return appendSeparator(str, (String) null);
    }

    public void appendTo(Appendable appendable) throws IOException {
        if (appendable instanceof Writer) {
            ((Writer) appendable).write(this.buffer, 0, this.size);
            return;
        }
        if (appendable instanceof StringBuilder) {
            ((StringBuilder) appendable).append(this.buffer, 0, this.size);
            return;
        }
        if (appendable instanceof StringBuffer) {
            ((StringBuffer) appendable).append(this.buffer, 0, this.size);
        } else if (appendable instanceof CharBuffer) {
            ((CharBuffer) appendable).put(this.buffer, 0, this.size);
        } else {
            appendable.append(this);
        }
    }

    public StrBuilder appendWithSeparators(Object[] objArr, String str) {
        if (objArr != null && objArr.length > 0) {
            String objects = Objects.toString(str, "");
            append(objArr[0]);
            for (int i10 = 1; i10 < objArr.length; i10++) {
                append(objects);
                append(objArr[i10]);
            }
        }
        return this;
    }

    public StrBuilder appendln(Object obj) {
        return append(obj).appendNewLine();
    }

    public Reader asReader() {
        return new StrBuilderReader();
    }

    public StrTokenizer asTokenizer() {
        return new StrBuilderTokenizer();
    }

    public Writer asWriter() {
        return new StrBuilderWriter();
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        if (i10 >= 0 && i10 < length()) {
            return this.buffer[i10];
        }
        throw new StringIndexOutOfBoundsException(i10);
    }

    public StrBuilder clear() {
        this.size = 0;
        return this;
    }

    public boolean contains(char c4) {
        char[] cArr = this.buffer;
        for (int i10 = 0; i10 < this.size; i10++) {
            if (cArr[i10] == c4) {
                return true;
            }
        }
        return false;
    }

    public StrBuilder delete(int i10, int i11) {
        int validateRange = validateRange(i10, i11);
        int i12 = validateRange - i10;
        if (i12 > 0) {
            deleteImpl(i10, validateRange, i12);
        }
        return this;
    }

    public StrBuilder deleteAll(char c4) {
        int i10 = 0;
        while (i10 < this.size) {
            if (this.buffer[i10] == c4) {
                int i11 = i10;
                do {
                    i11++;
                    if (i11 >= this.size) {
                        break;
                    }
                } while (this.buffer[i11] == c4);
                int i12 = i11 - i10;
                deleteImpl(i10, i11, i12);
                i10 = i11 - i12;
            }
            i10++;
        }
        return this;
    }

    public StrBuilder deleteCharAt(int i10) {
        if (i10 >= 0 && i10 < this.size) {
            deleteImpl(i10, i10 + 1, 1);
            return this;
        }
        throw new StringIndexOutOfBoundsException(i10);
    }

    public StrBuilder deleteFirst(char c4) {
        int i10 = 0;
        while (true) {
            if (i10 >= this.size) {
                break;
            }
            if (this.buffer[i10] == c4) {
                deleteImpl(i10, i10 + 1, 1);
                break;
            }
            i10++;
        }
        return this;
    }

    public boolean endsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        int i10 = this.size;
        if (length > i10) {
            return false;
        }
        int i11 = i10 - length;
        int i12 = 0;
        while (i12 < length) {
            if (this.buffer[i11] != str.charAt(i12)) {
                return false;
            }
            i12++;
            i11++;
        }
        return true;
    }

    public StrBuilder ensureCapacity(int i10) {
        char[] cArr = this.buffer;
        if (i10 > cArr.length) {
            char[] cArr2 = new char[i10 * 2];
            this.buffer = cArr2;
            System.arraycopy((Object) cArr, 0, (Object) cArr2, 0, this.size);
        }
        return this;
    }

    public boolean equals(StrBuilder strBuilder) {
        int i10;
        if (this == strBuilder) {
            return true;
        }
        if (strBuilder == null || (i10 = this.size) != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (cArr[i11] != cArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public boolean equalsIgnoreCase(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i10 = this.size;
        if (i10 != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            char c4 = cArr[i11];
            char c10 = cArr2[i11];
            if (c4 != c10 && Character.toUpperCase(c4) != Character.toUpperCase(c10)) {
                return false;
            }
        }
        return true;
    }

    public char[] getChars(char[] cArr) {
        int length = length();
        if (cArr == null || cArr.length < length) {
            cArr = new char[length];
        }
        System.arraycopy((Object) this.buffer, 0, (Object) cArr, 0, length);
        return cArr;
    }

    public String getNewLineText() {
        return this.newLine;
    }

    public String getNullText() {
        return this.nullText;
    }

    public int hashCode() {
        char[] cArr = this.buffer;
        int i10 = 0;
        for (int i11 = this.size - 1; i11 >= 0; i11--) {
            i10 = (i10 * 31) + cArr[i11];
        }
        return i10;
    }

    public int indexOf(char c4) {
        return indexOf(c4, 0);
    }

    public StrBuilder insert(int i10, Object obj) {
        if (obj == null) {
            return insert(i10, this.nullText);
        }
        return insert(i10, obj.toString());
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int lastIndexOf(char c4) {
        return lastIndexOf(c4, this.size - 1);
    }

    public String leftString(int i10) {
        if (i10 <= 0) {
            return "";
        }
        int i11 = this.size;
        if (i10 >= i11) {
            return new String(this.buffer, 0, i11);
        }
        return new String(this.buffer, 0, i10);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.size;
    }

    public String midString(int i10, int i11) {
        int i12;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 <= 0 || i10 >= (i12 = this.size)) {
            return "";
        }
        if (i12 <= i10 + i11) {
            return new String(this.buffer, i10, i12 - i10);
        }
        return new String(this.buffer, i10, i11);
    }

    public StrBuilder minimizeCapacity() {
        if (this.buffer.length > length()) {
            char[] cArr = this.buffer;
            char[] cArr2 = new char[length()];
            this.buffer = cArr2;
            System.arraycopy((Object) cArr, 0, (Object) cArr2, 0, this.size);
        }
        return this;
    }

    public int readFrom(Readable readable) throws IOException {
        int i10 = this.size;
        if (readable instanceof Reader) {
            Reader reader = (Reader) readable;
            ensureCapacity(i10 + 1);
            while (true) {
                char[] cArr = this.buffer;
                int i11 = this.size;
                int read = reader.read(cArr, i11, cArr.length - i11);
                if (read == -1) {
                    break;
                }
                int i12 = this.size + read;
                this.size = i12;
                ensureCapacity(i12 + 1);
            }
        } else if (readable instanceof CharBuffer) {
            CharBuffer charBuffer = (CharBuffer) readable;
            int remaining = charBuffer.remaining();
            ensureCapacity(this.size + remaining);
            charBuffer.get(this.buffer, this.size, remaining);
            this.size += remaining;
        } else {
            while (true) {
                ensureCapacity(this.size + 1);
                char[] cArr2 = this.buffer;
                int i13 = this.size;
                int read2 = readable.read(CharBuffer.wrap(cArr2, i13, cArr2.length - i13));
                if (read2 == -1) {
                    break;
                }
                this.size += read2;
            }
        }
        return this.size - i10;
    }

    public StrBuilder replace(int i10, int i11, String str) {
        int validateRange = validateRange(i10, i11);
        replaceImpl(i10, validateRange, validateRange - i10, str, str == null ? 0 : str.length());
        return this;
    }

    public StrBuilder replaceAll(char c4, char c10) {
        if (c4 != c10) {
            for (int i10 = 0; i10 < this.size; i10++) {
                char[] cArr = this.buffer;
                if (cArr[i10] == c4) {
                    cArr[i10] = c10;
                }
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(char c4, char c10) {
        if (c4 != c10) {
            int i10 = 0;
            while (true) {
                if (i10 >= this.size) {
                    break;
                }
                char[] cArr = this.buffer;
                if (cArr[i10] == c4) {
                    cArr[i10] = c10;
                    break;
                }
                i10++;
            }
        }
        return this;
    }

    public StrBuilder reverse() {
        int i10 = this.size;
        if (i10 == 0) {
            return this;
        }
        int i11 = i10 / 2;
        char[] cArr = this.buffer;
        int i12 = 0;
        int i13 = i10 - 1;
        while (i12 < i11) {
            char c4 = cArr[i12];
            cArr[i12] = cArr[i13];
            cArr[i13] = c4;
            i12++;
            i13--;
        }
        return this;
    }

    public String rightString(int i10) {
        if (i10 <= 0) {
            return "";
        }
        int i11 = this.size;
        if (i10 >= i11) {
            return new String(this.buffer, 0, i11);
        }
        return new String(this.buffer, i11 - i10, i10);
    }

    public StrBuilder setCharAt(int i10, char c4) {
        if (i10 >= 0 && i10 < length()) {
            this.buffer[i10] = c4;
            return this;
        }
        throw new StringIndexOutOfBoundsException(i10);
    }

    public StrBuilder setLength(int i10) {
        if (i10 >= 0) {
            int i11 = this.size;
            if (i10 < i11) {
                this.size = i10;
            } else if (i10 > i11) {
                ensureCapacity(i10);
                this.size = i10;
                for (int i12 = this.size; i12 < i10; i12++) {
                    this.buffer[i12] = 0;
                }
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException(i10);
    }

    public StrBuilder setNewLineText(String str) {
        this.newLine = str;
        return this;
    }

    public StrBuilder setNullText(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.nullText = str;
        return this;
    }

    public int size() {
        return this.size;
    }

    public boolean startsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        if (length > this.size) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (this.buffer[i10] != str.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        if (i10 >= 0) {
            if (i11 > this.size) {
                throw new StringIndexOutOfBoundsException(i11);
            }
            if (i10 <= i11) {
                return substring(i10, i11);
            }
            throw new StringIndexOutOfBoundsException(i11 - i10);
        }
        throw new StringIndexOutOfBoundsException(i10);
    }

    public String substring(int i10) {
        return substring(i10, this.size);
    }

    public char[] toCharArray() {
        int i10 = this.size;
        if (i10 == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[i10];
        System.arraycopy((Object) this.buffer, 0, (Object) cArr, 0, i10);
        return cArr;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.size);
    }

    public StringBuffer toStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer(this.size);
        stringBuffer.append(this.buffer, 0, this.size);
        return stringBuffer;
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb2 = new StringBuilder(this.size);
        sb2.append(this.buffer, 0, this.size);
        return sb2;
    }

    public StrBuilder trim() {
        int i10 = this.size;
        if (i10 == 0) {
            return this;
        }
        char[] cArr = this.buffer;
        int i11 = 0;
        while (i11 < i10 && cArr[i11] <= ' ') {
            i11++;
        }
        while (i11 < i10 && cArr[i10 - 1] <= ' ') {
            i10--;
        }
        int i12 = this.size;
        if (i10 < i12) {
            delete(i10, i12);
        }
        if (i11 > 0) {
            delete(0, i11);
        }
        return this;
    }

    public void validateIndex(int i10) {
        if (i10 < 0 || i10 > this.size) {
            throw new StringIndexOutOfBoundsException(i10);
        }
    }

    public int validateRange(int i10, int i11) {
        if (i10 >= 0) {
            int i12 = this.size;
            if (i11 > i12) {
                i11 = i12;
            }
            if (i10 <= i11) {
                return i11;
            }
            throw new StringIndexOutOfBoundsException("end < start");
        }
        throw new StringIndexOutOfBoundsException(i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class StrBuilderReader extends Reader {
        private int mark;
        private int pos;

        public StrBuilderReader() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Reader
        public void mark(int i10) {
            this.mark = this.pos;
        }

        @Override // java.io.Reader
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.Reader
        public int read() {
            if (!ready()) {
                return -1;
            }
            StrBuilder strBuilder = StrBuilder.this;
            int i10 = this.pos;
            this.pos = i10 + 1;
            return strBuilder.charAt(i10);
        }

        @Override // java.io.Reader
        public boolean ready() {
            return this.pos < StrBuilder.this.size();
        }

        @Override // java.io.Reader
        public void reset() {
            this.pos = this.mark;
        }

        @Override // java.io.Reader
        public long skip(long j10) {
            if (this.pos + j10 > StrBuilder.this.size()) {
                j10 = StrBuilder.this.size() - this.pos;
            }
            if (j10 < 0) {
                return 0L;
            }
            this.pos = (int) (this.pos + j10);
            return j10;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) {
            int i12;
            if (i10 < 0 || i11 < 0 || i10 > cArr.length || (i12 = i10 + i11) > cArr.length || i12 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i11 == 0) {
                return 0;
            }
            if (this.pos >= StrBuilder.this.size()) {
                return -1;
            }
            if (this.pos + i11 > StrBuilder.this.size()) {
                i11 = StrBuilder.this.size() - this.pos;
            }
            StrBuilder strBuilder = StrBuilder.this;
            int i13 = this.pos;
            strBuilder.getChars(i13, i13 + i11, cArr, i10);
            this.pos += i11;
            return i11;
        }
    }

    public StrBuilder(int i10) {
        this.buffer = new char[i10 <= 0 ? 32 : i10];
    }

    public StrBuilder appendSeparator(String str, String str2) {
        if (isEmpty()) {
            str = str2;
        }
        if (str != null) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendln(String str) {
        return append(str).appendNewLine();
    }

    @Override // org.apache.commons.lang3.builder.Builder
    public String build() {
        return toString();
    }

    public int indexOf(char c4, int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        if (i10 >= this.size) {
            return -1;
        }
        char[] cArr = this.buffer;
        while (i10 < this.size) {
            if (cArr[i10] == c4) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public int lastIndexOf(char c4, int i10) {
        int i11 = this.size;
        if (i10 >= i11) {
            i10 = i11 - 1;
        }
        if (i10 < 0) {
            return -1;
        }
        while (i10 >= 0) {
            if (this.buffer[i10] == c4) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public String substring(int i10, int i11) {
        return new String(this.buffer, i10, validateRange(i10, i11) - i10);
    }

    public StrBuilder appendln(String str, int i10, int i11) {
        return append(str, i10, i11).appendNewLine();
    }

    public StrBuilder insert(int i10, String str) {
        int length;
        validateIndex(i10);
        if (str == null) {
            str = this.nullText;
        }
        if (str != null && (length = str.length()) > 0) {
            int i11 = this.size + length;
            ensureCapacity(i11);
            char[] cArr = this.buffer;
            System.arraycopy((Object) cArr, i10, (Object) cArr, i10 + length, this.size - i10);
            this.size = i11;
            str.getChars(0, length, this.buffer, i10);
        }
        return this;
    }

    public StrBuilder(String str) {
        if (str == null) {
            this.buffer = new char[32];
        } else {
            this.buffer = new char[str.length() + 32];
            append(str);
        }
    }

    public StrBuilder append(Object obj) {
        if (obj == null) {
            return appendNull();
        }
        if (obj instanceof CharSequence) {
            return append((CharSequence) obj);
        }
        return append(obj.toString());
    }

    public StrBuilder appendAll(Iterable<?> iterable) {
        if (iterable != null) {
            Iterator<?> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                append(iterator2.next());
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c4) {
        if (size() > 0) {
            append(c4);
        }
        return this;
    }

    public StrBuilder appendln(String str, Object... objArr) {
        return append(str, objArr).appendNewLine();
    }

    public boolean contains(String str) {
        return indexOf(str, 0) >= 0;
    }

    public StrBuilder deleteFirst(String str) {
        int indexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
            deleteImpl(indexOf, indexOf + length, length);
        }
        return this;
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.size - 1);
    }

    public StrBuilder replace(StrMatcher strMatcher, String str, int i10, int i11, int i12) {
        return replaceImpl(strMatcher, str, i10, validateRange(i10, i11), i12);
    }

    public StrBuilder replaceAll(String str, String str2) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int length2 = str2 == null ? 0 : str2.length();
            int indexOf = indexOf(str, 0);
            while (indexOf >= 0) {
                replaceImpl(indexOf, indexOf + length, length, str2, length2);
                indexOf = indexOf(str, indexOf + length2);
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(String str, String str2) {
        int indexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
            replaceImpl(indexOf, indexOf + length, length, str2, str2 == null ? 0 : str2.length());
        }
        return this;
    }

    public StrBuilder appendln(StringBuffer stringBuffer) {
        return append(stringBuffer).appendNewLine();
    }

    public boolean contains(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0) >= 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof StrBuilder) && equals((StrBuilder) obj);
    }

    public void getChars(int i10, int i11, char[] cArr, int i12) {
        if (i10 >= 0) {
            if (i11 < 0 || i11 > length()) {
                throw new StringIndexOutOfBoundsException(i11);
            }
            if (i10 <= i11) {
                System.arraycopy((Object) this.buffer, i10, (Object) cArr, i12, i11 - i10);
                return;
            }
            throw new StringIndexOutOfBoundsException("end < start");
        }
        throw new StringIndexOutOfBoundsException(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        r9 = r9 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int lastIndexOf(java.lang.String r8, int r9) {
        /*
            r7 = this;
            int r0 = r7.size
            r1 = 1
            if (r9 < r0) goto L7
            int r9 = r0 + (-1)
        L7:
            r0 = -1
            if (r8 == 0) goto L40
            if (r9 >= 0) goto Ld
            goto L40
        Ld:
            int r2 = r8.length()
            if (r2 <= 0) goto L3d
            int r3 = r7.size
            if (r2 > r3) goto L3d
            r3 = 0
            if (r2 != r1) goto L23
            char r8 = r8.charAt(r3)
            int r8 = r7.lastIndexOf(r8, r9)
            return r8
        L23:
            int r9 = r9 - r2
            int r9 = r9 + r1
        L25:
            if (r9 < 0) goto L40
            r1 = 0
        L28:
            if (r1 >= r2) goto L3c
            char r4 = r8.charAt(r1)
            char[] r5 = r7.buffer
            int r6 = r9 + r1
            char r5 = r5[r6]
            if (r4 == r5) goto L39
            int r9 = r9 + (-1)
            goto L25
        L39:
            int r1 = r1 + 1
            goto L28
        L3c:
            return r9
        L3d:
            if (r2 != 0) goto L40
            return r9
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.text.StrBuilder.lastIndexOf(java.lang.String, int):int");
    }

    public char[] toCharArray(int i10, int i11) {
        int validateRange = validateRange(i10, i11) - i10;
        if (validateRange == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[validateRange];
        System.arraycopy((Object) this.buffer, i10, (Object) cArr, 0, validateRange);
        return cArr;
    }

    private StrBuilder replaceImpl(StrMatcher strMatcher, String str, int i10, int i11, int i12) {
        if (strMatcher != null && this.size != 0) {
            int length = str == null ? 0 : str.length();
            int i13 = i10;
            while (i13 < i11 && i12 != 0) {
                int isMatch = strMatcher.isMatch(this.buffer, i13, i10, i11);
                if (isMatch > 0) {
                    replaceImpl(i13, i13 + isMatch, isMatch, str, length);
                    i11 = (i11 - isMatch) + length;
                    i13 = (i13 + length) - 1;
                    if (i12 > 0) {
                        i12--;
                    }
                }
                i13++;
            }
        }
        return this;
    }

    public StrBuilder appendAll(Iterator<?> it) {
        if (it != null) {
            while (it.hasNext()) {
                append(it.next());
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c4, char c10) {
        if (size() > 0) {
            append(c4);
        } else {
            append(c10);
        }
        return this;
    }

    public StrBuilder appendln(StringBuilder sb2) {
        return append(sb2).appendNewLine();
    }

    public StrBuilder deleteAll(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int indexOf = indexOf(str, 0);
            while (indexOf >= 0) {
                deleteImpl(indexOf, indexOf + length, length);
                indexOf = indexOf(str, indexOf);
            }
        }
        return this;
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public StrBuilder appendWithSeparators(Iterable<?> iterable, String str) {
        if (iterable != null) {
            String objects = Objects.toString(str, "");
            Iterator<?> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                append(iterator2.next());
                if (iterator2.hasNext()) {
                    append(objects);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(StringBuilder sb2, int i10, int i11) {
        return append(sb2, i10, i11).appendNewLine();
    }

    public StrBuilder deleteFirst(StrMatcher strMatcher) {
        return replace(strMatcher, null, 0, this.size, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        r10 = r10 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int indexOf(java.lang.String r9, int r10) {
        /*
            r8 = this;
            r0 = 0
            if (r10 >= 0) goto L4
            r10 = 0
        L4:
            r1 = -1
            if (r9 == 0) goto L3e
            int r2 = r8.size
            if (r10 < r2) goto Lc
            goto L3e
        Lc:
            int r2 = r9.length()
            r3 = 1
            if (r2 != r3) goto L1c
            char r9 = r9.charAt(r0)
            int r9 = r8.indexOf(r9, r10)
            return r9
        L1c:
            if (r2 != 0) goto L1f
            return r10
        L1f:
            int r4 = r8.size
            if (r2 <= r4) goto L24
            return r1
        L24:
            char[] r5 = r8.buffer
            int r4 = r4 - r2
            int r4 = r4 + r3
        L28:
            if (r10 >= r4) goto L3e
            r3 = 0
        L2b:
            if (r3 >= r2) goto L3d
            char r6 = r9.charAt(r3)
            int r7 = r10 + r3
            char r7 = r5[r7]
            if (r6 == r7) goto L3a
            int r10 = r10 + 1
            goto L28
        L3a:
            int r3 = r3 + 1
            goto L2b
        L3d:
            return r10
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.text.StrBuilder.indexOf(java.lang.String, int):int");
    }

    @Override // java.lang.Appendable
    public StrBuilder append(CharSequence charSequence) {
        if (charSequence == null) {
            return appendNull();
        }
        if (charSequence instanceof StrBuilder) {
            return append((StrBuilder) charSequence);
        }
        if (charSequence instanceof StringBuilder) {
            return append((StringBuilder) charSequence);
        }
        if (charSequence instanceof StringBuffer) {
            return append((StringBuffer) charSequence);
        }
        if (charSequence instanceof CharBuffer) {
            return append((CharBuffer) charSequence);
        }
        return append(charSequence.toString());
    }

    public StrBuilder appendFixedWidthPadLeft(int i10, int i11, char c4) {
        return appendFixedWidthPadLeft(String.valueOf(i10), i11, c4);
    }

    public StrBuilder appendFixedWidthPadRight(int i10, int i11, char c4) {
        return appendFixedWidthPadRight(String.valueOf(i10), i11, c4);
    }

    public StrBuilder appendln(StringBuffer stringBuffer, int i10, int i11) {
        return append(stringBuffer, i10, i11).appendNewLine();
    }

    public StrBuilder replaceFirst(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, 1);
    }

    public StrBuilder appendSeparator(String str, int i10) {
        if (str != null && i10 > 0) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendln(StrBuilder strBuilder) {
        return append(strBuilder).appendNewLine();
    }

    public StrBuilder replaceAll(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, -1);
    }

    public StrBuilder appendSeparator(char c4, int i10) {
        if (i10 > 0) {
            append(c4);
        }
        return this;
    }

    public StrBuilder appendln(StrBuilder strBuilder, int i10, int i11) {
        return append(strBuilder, i10, i11).appendNewLine();
    }

    public StrBuilder deleteAll(StrMatcher strMatcher) {
        return replace(strMatcher, null, 0, this.size, -1);
    }

    public int lastIndexOf(StrMatcher strMatcher) {
        return lastIndexOf(strMatcher, this.size);
    }

    public StrBuilder appendln(char[] cArr) {
        return append(cArr).appendNewLine();
    }

    public StrBuilder insert(int i10, char[] cArr) {
        validateIndex(i10);
        if (cArr == null) {
            return insert(i10, this.nullText);
        }
        int length = cArr.length;
        if (length > 0) {
            ensureCapacity(this.size + length);
            char[] cArr2 = this.buffer;
            System.arraycopy((Object) cArr2, i10, (Object) cArr2, i10 + length, this.size - i10);
            System.arraycopy((Object) cArr, 0, (Object) this.buffer, i10, length);
            this.size += length;
        }
        return this;
    }

    public int lastIndexOf(StrMatcher strMatcher, int i10) {
        int i11 = this.size;
        if (i10 >= i11) {
            i10 = i11 - 1;
        }
        if (strMatcher != null && i10 >= 0) {
            char[] cArr = this.buffer;
            int i12 = i10 + 1;
            while (i10 >= 0) {
                if (strMatcher.isMatch(cArr, i10, 0, i12) > 0) {
                    return i10;
                }
                i10--;
            }
        }
        return -1;
    }

    public StrBuilder appendln(char[] cArr, int i10, int i11) {
        return append(cArr, i10, i11).appendNewLine();
    }

    public StrBuilder appendWithSeparators(Iterator<?> it, String str) {
        if (it != null) {
            String objects = Objects.toString(str, "");
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(objects);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(boolean z10) {
        return append(z10).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0);
    }

    public StrBuilder appendln(char c4) {
        return append(c4).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher, int i10) {
        int i11;
        if (i10 < 0) {
            i10 = 0;
        }
        if (strMatcher != null && i10 < (i11 = this.size)) {
            char[] cArr = this.buffer;
            for (int i12 = i10; i12 < i11; i12++) {
                if (strMatcher.isMatch(cArr, i12, i10, i11) > 0) {
                    return i12;
                }
            }
        }
        return -1;
    }

    public StrBuilder appendln(int i10) {
        return append(i10).appendNewLine();
    }

    public StrBuilder appendln(long j10) {
        return append(j10).appendNewLine();
    }

    public StrBuilder appendln(float f10) {
        return append(f10).appendNewLine();
    }

    @Override // java.lang.Appendable
    public StrBuilder append(CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            return appendNull();
        }
        return append(charSequence.toString(), i10, i11);
    }

    public StrBuilder appendln(double d10) {
        return append(d10).appendNewLine();
    }

    public StrBuilder insert(int i10, char[] cArr, int i11, int i12) {
        validateIndex(i10);
        if (cArr == null) {
            return insert(i10, this.nullText);
        }
        if (i11 >= 0 && i11 <= cArr.length) {
            if (i12 < 0 || i11 + i12 > cArr.length) {
                throw new StringIndexOutOfBoundsException("Invalid length: " + i12);
            }
            if (i12 > 0) {
                ensureCapacity(this.size + i12);
                char[] cArr2 = this.buffer;
                System.arraycopy((Object) cArr2, i10, (Object) cArr2, i10 + i12, this.size - i10);
                System.arraycopy((Object) cArr, i11, (Object) this.buffer, i10, i12);
                this.size += i12;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("Invalid offset: " + i11);
    }

    public StrBuilder append(String str) {
        if (str == null) {
            return appendNull();
        }
        int length = str.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            str.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(String str, int i10, int i11) {
        int i12;
        if (str == null) {
            return appendNull();
        }
        if (i10 >= 0 && i10 <= str.length()) {
            if (i11 < 0 || (i12 = i10 + i11) > str.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i11 > 0) {
                int length = length();
                ensureCapacity(length + i11);
                str.getChars(i10, i12, this.buffer, length);
                this.size += i11;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public StrBuilder insert(int i10, boolean z10) {
        validateIndex(i10);
        if (z10) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            System.arraycopy((Object) cArr, i10, (Object) cArr, i10 + 4, this.size - i10);
            char[] cArr2 = this.buffer;
            int i11 = i10 + 1;
            cArr2[i10] = 't';
            int i12 = i11 + 1;
            cArr2[i11] = 'r';
            cArr2[i12] = 'u';
            cArr2[i12 + 1] = 'e';
            this.size += 4;
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr3 = this.buffer;
            System.arraycopy((Object) cArr3, i10, (Object) cArr3, i10 + 5, this.size - i10);
            char[] cArr4 = this.buffer;
            int i13 = i10 + 1;
            cArr4[i10] = 'f';
            int i14 = i13 + 1;
            cArr4[i13] = 'a';
            int i15 = i14 + 1;
            cArr4[i14] = 'l';
            cArr4[i15] = 's';
            cArr4[i15 + 1] = 'e';
            this.size += 5;
        }
        return this;
    }

    public StrBuilder append(String str, Object... objArr) {
        return append(String.format(str, objArr));
    }

    public StrBuilder append(CharBuffer charBuffer) {
        if (charBuffer == null) {
            return appendNull();
        }
        if (charBuffer.hasArray()) {
            int remaining = charBuffer.remaining();
            int length = length();
            ensureCapacity(length + remaining);
            System.arraycopy((Object) charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position(), (Object) this.buffer, length, remaining);
            this.size += remaining;
        } else {
            append(charBuffer.toString());
        }
        return this;
    }

    public StrBuilder append(CharBuffer charBuffer, int i10, int i11) {
        if (charBuffer == null) {
            return appendNull();
        }
        if (charBuffer.hasArray()) {
            int remaining = charBuffer.remaining();
            if (i10 < 0 || i10 > remaining) {
                throw new StringIndexOutOfBoundsException("startIndex must be valid");
            }
            if (i11 >= 0 && i10 + i11 <= remaining) {
                int length = length();
                ensureCapacity(length + i11);
                System.arraycopy((Object) charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + i10, (Object) this.buffer, length, i11);
                this.size += i11;
            } else {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
        } else {
            append(charBuffer.toString(), i10, i11);
        }
        return this;
    }

    public StrBuilder insert(int i10, char c4) {
        validateIndex(i10);
        ensureCapacity(this.size + 1);
        char[] cArr = this.buffer;
        System.arraycopy((Object) cArr, i10, (Object) cArr, i10 + 1, this.size - i10);
        this.buffer[i10] = c4;
        this.size++;
        return this;
    }

    public StrBuilder insert(int i10, int i11) {
        return insert(i10, String.valueOf(i11));
    }

    public StrBuilder insert(int i10, long j10) {
        return insert(i10, String.valueOf(j10));
    }

    public StrBuilder insert(int i10, float f10) {
        return insert(i10, String.valueOf(f10));
    }

    public StrBuilder insert(int i10, double d10) {
        return insert(i10, String.valueOf(d10));
    }

    public StrBuilder append(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return appendNull();
        }
        int length = stringBuffer.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            stringBuffer.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StringBuffer stringBuffer, int i10, int i11) {
        int i12;
        if (stringBuffer == null) {
            return appendNull();
        }
        if (i10 >= 0 && i10 <= stringBuffer.length()) {
            if (i11 < 0 || (i12 = i10 + i11) > stringBuffer.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i11 > 0) {
                int length = length();
                ensureCapacity(length + i11);
                stringBuffer.getChars(i10, i12, this.buffer, length);
                this.size += i11;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public StrBuilder append(StringBuilder sb2) {
        if (sb2 == null) {
            return appendNull();
        }
        int length = sb2.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            sb2.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StringBuilder sb2, int i10, int i11) {
        int i12;
        if (sb2 == null) {
            return appendNull();
        }
        if (i10 >= 0 && i10 <= sb2.length()) {
            if (i11 < 0 || (i12 = i10 + i11) > sb2.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i11 > 0) {
                int length = length();
                ensureCapacity(length + i11);
                sb2.getChars(i10, i12, this.buffer, length);
                this.size += i11;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public StrBuilder append(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return appendNull();
        }
        int length = strBuilder.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy((Object) strBuilder.buffer, 0, (Object) this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StrBuilder strBuilder, int i10, int i11) {
        int i12;
        if (strBuilder == null) {
            return appendNull();
        }
        if (i10 >= 0 && i10 <= strBuilder.length()) {
            if (i11 < 0 || (i12 = i10 + i11) > strBuilder.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i11 > 0) {
                int length = length();
                ensureCapacity(length + i11);
                strBuilder.getChars(i10, i12, this.buffer, length);
                this.size += i11;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public StrBuilder append(char[] cArr) {
        if (cArr == null) {
            return appendNull();
        }
        int length = cArr.length;
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy((Object) cArr, 0, (Object) this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(char[] cArr, int i10, int i11) {
        if (cArr == null) {
            return appendNull();
        }
        if (i10 >= 0 && i10 <= cArr.length) {
            if (i11 < 0 || i10 + i11 > cArr.length) {
                throw new StringIndexOutOfBoundsException("Invalid length: " + i11);
            }
            if (i11 > 0) {
                int length = length();
                ensureCapacity(length + i11);
                System.arraycopy((Object) cArr, i10, (Object) this.buffer, length, i11);
                this.size += i11;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("Invalid startIndex: " + i11);
    }

    public StrBuilder append(boolean z10) {
        if (z10) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            int i10 = this.size;
            int i11 = i10 + 1;
            this.size = i11;
            cArr[i10] = 't';
            int i12 = i11 + 1;
            this.size = i12;
            cArr[i11] = 'r';
            int i13 = i12 + 1;
            this.size = i13;
            cArr[i12] = 'u';
            this.size = i13 + 1;
            cArr[i13] = 'e';
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr2 = this.buffer;
            int i14 = this.size;
            int i15 = i14 + 1;
            this.size = i15;
            cArr2[i14] = 'f';
            int i16 = i15 + 1;
            this.size = i16;
            cArr2[i15] = 'a';
            int i17 = i16 + 1;
            this.size = i17;
            cArr2[i16] = 'l';
            int i18 = i17 + 1;
            this.size = i18;
            cArr2[i17] = 's';
            this.size = i18 + 1;
            cArr2[i18] = 'e';
        }
        return this;
    }

    @Override // java.lang.Appendable
    public StrBuilder append(char c4) {
        ensureCapacity(length() + 1);
        char[] cArr = this.buffer;
        int i10 = this.size;
        this.size = i10 + 1;
        cArr[i10] = c4;
        return this;
    }

    public StrBuilder append(int i10) {
        return append(String.valueOf(i10));
    }

    public StrBuilder append(long j10) {
        return append(String.valueOf(j10));
    }

    public StrBuilder append(float f10) {
        return append(String.valueOf(f10));
    }

    public StrBuilder append(double d10) {
        return append(String.valueOf(d10));
    }
}
