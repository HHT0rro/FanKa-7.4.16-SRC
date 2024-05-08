package java.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Properties extends Hashtable<Object, Object> {
    private static final char[] hexDigit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final long serialVersionUID = 4112578634029874840L;
    protected Properties defaults;

    public Properties() {
        this(null);
    }

    public Properties(Properties defaults) {
        this.defaults = defaults;
    }

    public synchronized Object setProperty(String key, String value) {
        return put(key, value);
    }

    public synchronized void load(Reader reader) throws IOException {
        load0(new LineReader(reader));
    }

    public synchronized void load(InputStream inStream) throws IOException {
        load0(new LineReader(inStream));
    }

    private void load0(LineReader lr) throws IOException {
        char[] convtBuf = new char[1024];
        while (true) {
            int limit = lr.readLine();
            if (limit >= 0) {
                int keyLen = 0;
                int valueStart = limit;
                boolean hasSep = false;
                boolean precedingBackslash = false;
                while (true) {
                    if (keyLen < limit) {
                        char c4 = lr.lineBuf[keyLen];
                        if ((c4 == '=' || c4 == ':') && !precedingBackslash) {
                            valueStart = keyLen + 1;
                            hasSep = true;
                            break;
                        } else {
                            if (Character.isWhitespace(c4) && !precedingBackslash) {
                                valueStart = keyLen + 1;
                                break;
                            }
                            if (c4 == '\\') {
                                precedingBackslash = precedingBackslash ? false : true;
                            } else {
                                precedingBackslash = false;
                            }
                            keyLen++;
                        }
                    } else {
                        break;
                    }
                }
                while (valueStart < limit) {
                    char c10 = lr.lineBuf[valueStart];
                    if (!Character.isWhitespace(c10)) {
                        if (!hasSep && (c10 == '=' || c10 == ':')) {
                            hasSep = true;
                        }
                        String key = loadConvert(lr.lineBuf, 0, keyLen, convtBuf);
                        String value = loadConvert(lr.lineBuf, valueStart, limit - valueStart, convtBuf);
                        put(key, value);
                    }
                    valueStart++;
                }
                String key2 = loadConvert(lr.lineBuf, 0, keyLen, convtBuf);
                String value2 = loadConvert(lr.lineBuf, valueStart, limit - valueStart, convtBuf);
                put(key2, value2);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class LineReader {
        byte[] inByteBuf;
        char[] inCharBuf;
        int inLimit;
        int inOff;
        InputStream inStream;
        char[] lineBuf;
        Reader reader;

        public LineReader(InputStream inStream) {
            this.lineBuf = new char[1024];
            this.inLimit = 0;
            this.inOff = 0;
            this.inStream = inStream;
            this.inByteBuf = new byte[8192];
        }

        public LineReader(Reader reader) {
            this.lineBuf = new char[1024];
            this.inLimit = 0;
            this.inOff = 0;
            this.reader = reader;
            this.inCharBuf = new char[8192];
        }

        int readLine() throws IOException {
            char c4;
            int read;
            int len = 0;
            boolean skipWhiteSpace = true;
            boolean isCommentLine = false;
            boolean isNewLine = true;
            boolean appendedLineBegin = false;
            boolean precedingBackslash = false;
            boolean skipLF = false;
            while (true) {
                if (this.inOff >= this.inLimit) {
                    InputStream inputStream = this.inStream;
                    int read2 = inputStream == null ? this.reader.read(this.inCharBuf) : inputStream.read(this.inByteBuf);
                    this.inLimit = read2;
                    this.inOff = 0;
                    if (read2 <= 0) {
                        if (len == 0 || isCommentLine) {
                            return -1;
                        }
                        if (precedingBackslash) {
                            return len - 1;
                        }
                        return len;
                    }
                }
                if (this.inStream != null) {
                    byte[] bArr = this.inByteBuf;
                    int i10 = this.inOff;
                    this.inOff = i10 + 1;
                    c4 = (char) (bArr[i10] & 255);
                } else {
                    char[] cArr = this.inCharBuf;
                    int i11 = this.inOff;
                    this.inOff = i11 + 1;
                    c4 = cArr[i11];
                }
                if (skipLF) {
                    skipLF = false;
                    if (c4 == '\n') {
                        continue;
                    }
                }
                if (skipWhiteSpace) {
                    if (!Character.isWhitespace(c4) && (appendedLineBegin || (c4 != '\r' && c4 != '\n'))) {
                        skipWhiteSpace = false;
                        appendedLineBegin = false;
                    }
                }
                if (isNewLine) {
                    isNewLine = false;
                    if (c4 == '#' || c4 == '!') {
                        isCommentLine = true;
                    }
                }
                if (c4 != '\n' && c4 != '\r') {
                    char[] cArr2 = this.lineBuf;
                    int len2 = len + 1;
                    cArr2[len] = c4;
                    if (len2 == cArr2.length) {
                        int newLength = cArr2.length * 2;
                        if (newLength < 0) {
                            newLength = Integer.MAX_VALUE;
                        }
                        char[] buf = new char[newLength];
                        System.arraycopy((Object) cArr2, 0, (Object) buf, 0, cArr2.length);
                        this.lineBuf = buf;
                    }
                    if (c4 == '\\') {
                        precedingBackslash = precedingBackslash ? false : true;
                        len = len2;
                    } else {
                        precedingBackslash = false;
                        len = len2;
                    }
                } else if (isCommentLine || len == 0) {
                    isCommentLine = false;
                    isNewLine = true;
                    skipWhiteSpace = true;
                    len = 0;
                } else {
                    if (this.inOff >= this.inLimit) {
                        InputStream inputStream2 = this.inStream;
                        if (inputStream2 == null) {
                            read = this.reader.read(this.inCharBuf);
                        } else {
                            read = inputStream2.read(this.inByteBuf);
                        }
                        this.inLimit = read;
                        this.inOff = 0;
                        if (read <= 0) {
                            if (precedingBackslash) {
                                return len - 1;
                            }
                            return len;
                        }
                    }
                    if (precedingBackslash) {
                        len--;
                        skipWhiteSpace = true;
                        appendedLineBegin = true;
                        precedingBackslash = false;
                        if (c4 == '\r') {
                            skipLF = true;
                        }
                    } else {
                        return len;
                    }
                }
            }
        }
    }

    private String loadConvert(char[] in, int off, int len, char[] convtBuf) {
        int value;
        if (convtBuf.length < len) {
            int newLen = len * 2;
            if (newLen < 0) {
                newLen = Integer.MAX_VALUE;
            }
            convtBuf = new char[newLen];
        }
        char[] out = convtBuf;
        int outLen = 0;
        int end = off + len;
        while (off < end) {
            int off2 = off + 1;
            char aChar = in[off];
            if (aChar == '\\') {
                int off3 = off2 + 1;
                char aChar2 = in[off2];
                if (aChar2 == 'u') {
                    int value2 = 0;
                    int i10 = 0;
                    while (i10 < 4) {
                        int off4 = off3 + 1;
                        char aChar3 = in[off3];
                        switch (aChar3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = ((value2 << 4) + aChar3) - 48;
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (((value2 << 4) + 10) + aChar3) - 65;
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (((value2 << 4) + 10) + aChar3) - 97;
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
                        }
                        value2 = value;
                        i10++;
                        off3 = off4;
                    }
                    int i11 = outLen + 1;
                    out[outLen] = (char) value2;
                    off = off3;
                    outLen = i11;
                } else {
                    if (aChar2 == 't') {
                        aChar2 = '\t';
                    } else if (aChar2 == 'r') {
                        aChar2 = CharUtils.CR;
                    } else if (aChar2 == 'n') {
                        aChar2 = '\n';
                    } else if (aChar2 == 'f') {
                        aChar2 = '\f';
                    }
                    out[outLen] = aChar2;
                    outLen++;
                    off = off3;
                }
            } else {
                out[outLen] = aChar;
                off = off2;
                outLen++;
            }
        }
        return new String(out, 0, outLen);
    }

    private String saveConvert(String theString, boolean escapeSpace, boolean escapeUnicode) {
        int len = theString.length();
        int bufLen = len * 2;
        if (bufLen < 0) {
            bufLen = Integer.MAX_VALUE;
        }
        StringBuffer outBuffer = new StringBuffer(bufLen);
        for (int x10 = 0; x10 < len; x10++) {
            char aChar = theString.charAt(x10);
            if (aChar > '=' && aChar < 127) {
                if (aChar == '\\') {
                    outBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    outBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                } else {
                    outBuffer.append(aChar);
                }
            } else {
                switch (aChar) {
                    case '\t':
                        outBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                        outBuffer.append('t');
                        break;
                    case '\n':
                        outBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                        outBuffer.append('n');
                        break;
                    case '\f':
                        outBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                        outBuffer.append('f');
                        break;
                    case '\r':
                        outBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                        outBuffer.append('r');
                        break;
                    case ' ':
                        if (x10 == 0 || escapeSpace) {
                            outBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                        }
                        outBuffer.append(' ');
                        break;
                    case '!':
                    case '#':
                    case ':':
                    case '=':
                        outBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                        outBuffer.append(aChar);
                        break;
                    default:
                        if ((aChar < ' ' || aChar > '~') & escapeUnicode) {
                            outBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            outBuffer.append('u');
                            outBuffer.append(toHex((aChar >> '\f') & 15));
                            outBuffer.append(toHex((aChar >> '\b') & 15));
                            outBuffer.append(toHex((aChar >> 4) & 15));
                            outBuffer.append(toHex(aChar & 15));
                            break;
                        } else {
                            outBuffer.append(aChar);
                            break;
                        }
                        break;
                }
            }
        }
        return outBuffer.toString();
    }

    private static void writeComments(BufferedWriter bw, String comments) throws IOException {
        bw.write("#");
        int len = comments.length();
        int current = 0;
        int last = 0;
        char[] uu = new char[6];
        uu[0] = IOUtils.DIR_SEPARATOR_WINDOWS;
        uu[1] = 'u';
        while (current < len) {
            char c4 = comments.charAt(current);
            if (c4 > 255 || c4 == '\n' || c4 == '\r') {
                if (last != current) {
                    bw.write(comments.substring(last, current));
                }
                if (c4 > 255) {
                    uu[2] = toHex((c4 >> '\f') & 15);
                    uu[3] = toHex((c4 >> '\b') & 15);
                    uu[4] = toHex((c4 >> 4) & 15);
                    uu[5] = toHex(c4 & 15);
                    bw.write(new String(uu));
                } else {
                    bw.newLine();
                    if (c4 == '\r' && current != len - 1 && comments.charAt(current + 1) == '\n') {
                        current++;
                    }
                    if (current == len - 1 || (comments.charAt(current + 1) != '#' && comments.charAt(current + 1) != '!')) {
                        bw.write("#");
                    }
                }
                last = current + 1;
            }
            current++;
        }
        if (last != current) {
            bw.write(comments.substring(last, current));
        }
        bw.newLine();
    }

    @Deprecated
    public void save(OutputStream out, String comments) {
        try {
            store(out, comments);
        } catch (IOException e2) {
        }
    }

    public void store(Writer writer, String comments) throws IOException {
        store0(writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer), comments, false);
    }

    public void store(OutputStream out, String comments) throws IOException {
        store0(new BufferedWriter(new OutputStreamWriter(out, "8859_1")), comments, true);
    }

    private void store0(BufferedWriter bw, String comments, boolean escUnicode) throws IOException {
        if (comments != null) {
            writeComments(bw, comments);
        }
        bw.write("#" + new Date().toString());
        bw.newLine();
        synchronized (this) {
            Enumeration<?> e2 = keys();
            while (e2.hasMoreElements()) {
                String key = (String) e2.nextElement();
                String val = (String) get(key);
                bw.write(saveConvert(key, true, escUnicode) + "=" + saveConvert(val, false, escUnicode));
                bw.newLine();
            }
        }
        bw.flush();
    }

    public synchronized void loadFromXML(InputStream in) throws IOException, InvalidPropertiesFormatException {
        XMLUtils.load(this, (InputStream) Objects.requireNonNull(in));
        in.close();
    }

    public void storeToXML(OutputStream os, String comment) throws IOException {
        storeToXML(os, comment, "UTF-8");
    }

    public void storeToXML(OutputStream os, String comment, String encoding) throws IOException {
        XMLUtils.save(this, (OutputStream) Objects.requireNonNull(os), comment, (String) Objects.requireNonNull(encoding));
    }

    public String getProperty(String key) {
        Properties properties;
        Object oval = super.get(key);
        String sval = oval instanceof String ? (String) oval : null;
        return (sval != null || (properties = this.defaults) == null) ? sval : properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        String val = getProperty(key);
        return val == null ? defaultValue : val;
    }

    public Enumeration<?> propertyNames() {
        Hashtable<String, Object> h10 = new Hashtable<>();
        enumerate(h10);
        return h10.keys();
    }

    public Set<String> stringPropertyNames() {
        Hashtable<String, String> h10 = new Hashtable<>();
        enumerateStringProperties(h10);
        return h10.h();
    }

    public void list(PrintStream out) {
        out.println("-- listing properties --");
        Hashtable<String, Object> h10 = new Hashtable<>();
        enumerate(h10);
        Enumeration<String> e2 = h10.keys();
        while (e2.hasMoreElements()) {
            String key = e2.nextElement();
            String val = (String) h10.get(key);
            if (val.length() > 40) {
                val = val.substring(0, 37) + "...";
            }
            out.println(key + "=" + val);
        }
    }

    public void list(PrintWriter out) {
        out.println("-- listing properties --");
        Hashtable<String, Object> h10 = new Hashtable<>();
        enumerate(h10);
        Enumeration<String> e2 = h10.keys();
        while (e2.hasMoreElements()) {
            String key = e2.nextElement();
            String val = (String) h10.get(key);
            if (val.length() > 40) {
                val = val.substring(0, 37) + "...";
            }
            out.println(key + "=" + val);
        }
    }

    private synchronized void enumerate(Hashtable<String, Object> h10) {
        Properties properties = this.defaults;
        if (properties != null) {
            properties.enumerate(h10);
        }
        Enumeration<?> e2 = keys();
        while (e2.hasMoreElements()) {
            String key = (String) e2.nextElement();
            h10.put(key, get(key));
        }
    }

    private synchronized void enumerateStringProperties(Hashtable<String, String> h10) {
        Properties properties = this.defaults;
        if (properties != null) {
            properties.enumerateStringProperties(h10);
        }
        Enumeration<?> e2 = keys();
        while (e2.hasMoreElements()) {
            Object k10 = e2.nextElement();
            Object v2 = get(k10);
            if ((k10 instanceof String) && (v2 instanceof String)) {
                h10.put((String) k10, (String) v2);
            }
        }
    }

    private static char toHex(int nibble) {
        return hexDigit[nibble & 15];
    }
}
