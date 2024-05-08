package java.util.jar;

import com.huawei.openalliance.ad.constant.u;
import com.tencent.connect.common.Constants;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import sun.security.util.SecurityProperties;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Manifest implements Cloneable {
    private final Attributes attr;
    private final Map<String, Attributes> entries;
    private final JarVerifier jv;

    public Manifest() {
        this.attr = new Attributes();
        this.entries = new HashMap();
        this.jv = null;
    }

    public Manifest(InputStream is) throws IOException {
        this(null, is, null);
    }

    Manifest(InputStream is, String jarFilename) throws IOException {
        this(null, is, jarFilename);
    }

    Manifest(JarVerifier jv, InputStream is, String jarFilename) throws IOException {
        this.attr = new Attributes();
        this.entries = new HashMap();
        read(is, jarFilename);
        this.jv = jv;
    }

    public Manifest(Manifest man) {
        Attributes attributes = new Attributes();
        this.attr = attributes;
        HashMap hashMap = new HashMap();
        this.entries = hashMap;
        attributes.putAll(man.getMainAttributes());
        hashMap.putAll(man.getEntries());
        this.jv = man.jv;
    }

    public Attributes getMainAttributes() {
        return this.attr;
    }

    public Map<String, Attributes> getEntries() {
        return this.entries;
    }

    public Attributes getAttributes(String name) {
        return getEntries().get(name);
    }

    Attributes getTrustedAttributes(String name) {
        JarVerifier jarVerifier;
        Attributes result = getAttributes(name);
        if (result != null && (jarVerifier = this.jv) != null && !jarVerifier.isTrustedManifestEntry(name)) {
            throw new SecurityException("Untrusted manifest entry: " + name);
        }
        return result;
    }

    public void clear() {
        this.attr.clear();
        this.entries.clear();
    }

    public void write(OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        this.attr.writeMain(dos);
        StringBuilder buffer = this.entries.isEmpty() ? null : new StringBuilder(72);
        for (Map.Entry<String, Attributes> e2 : this.entries.entrySet()) {
            buffer.setLength(0);
            buffer.append("Name: ");
            buffer.append(e2.getKey());
            println72(dos, buffer.toString());
            e2.getValue().write(dos);
        }
        dos.flush();
    }

    @Deprecated(since = Constants.VIA_REPORT_TYPE_JOININ_GROUP)
    static void make72Safe(StringBuffer line) {
        int index = 72;
        for (int length = line.length(); index < length; length += 3) {
            line.insert(index, "\r\n ");
            index += 74;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void println72(OutputStream out, String line) throws IOException {
        if (!line.isEmpty()) {
            byte[] lineBytes = line.getBytes(StandardCharsets.UTF_8);
            int length = lineBytes.length;
            out.write(lineBytes[0]);
            int pos = 1;
            while (length - pos > 71) {
                out.write(lineBytes, pos, 71);
                pos += 71;
                println(out);
                out.write(32);
            }
            out.write(lineBytes, pos, length - pos);
        }
        println(out);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void println(OutputStream out) throws IOException {
        out.write(13);
        out.write(10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getErrorPosition(String filename, int lineNumber) {
        if (filename == null || !SecurityProperties.INCLUDE_JAR_NAME_IN_EXCEPTIONS) {
            return "line " + lineNumber;
        }
        return "manifest of " + filename + u.bD + lineNumber;
    }

    public void read(InputStream is) throws IOException {
        read(is, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void read(java.io.InputStream r19, java.lang.String r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.Manifest.read(java.io.InputStream, java.lang.String):void");
    }

    private String parseName(byte[] lbuf, int len) {
        if (toLower(lbuf[0]) == 110 && toLower(lbuf[1]) == 97 && toLower(lbuf[2]) == 109 && toLower(lbuf[3]) == 101 && lbuf[4] == 58 && lbuf[5] == 32) {
            return new String(lbuf, 6, len - 6, StandardCharsets.UTF_8);
        }
        return null;
    }

    private int toLower(int c4) {
        return (c4 < 65 || c4 > 90) ? c4 : (c4 - 65) + 97;
    }

    public boolean equals(Object o10) {
        if (!(o10 instanceof Manifest)) {
            return false;
        }
        Manifest other = (Manifest) o10;
        return this.attr.equals(other.getMainAttributes()) && this.entries.equals(other.getEntries());
    }

    public int hashCode() {
        return this.attr.hashCode() + this.entries.hashCode();
    }

    public Object clone() {
        return new Manifest(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class FastInputStream extends FilterInputStream {
        private byte[] buf;
        private int count;
        private int pos;

        FastInputStream(InputStream in) {
            this(in, 8192);
        }

        FastInputStream(InputStream in, int size) {
            super(in);
            this.count = 0;
            this.pos = 0;
            this.buf = new byte[size];
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.pos >= this.count) {
                fill();
                if (this.pos >= this.count) {
                    return -1;
                }
            }
            byte[] bArr = this.buf;
            int i10 = this.pos;
            this.pos = i10 + 1;
            return Byte.toUnsignedInt(bArr[i10]);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] b4, int off, int len) throws IOException {
            int avail = this.count - this.pos;
            if (avail <= 0) {
                if (len >= this.buf.length) {
                    return this.in.read(b4, off, len);
                }
                fill();
                avail = this.count - this.pos;
                if (avail <= 0) {
                    return -1;
                }
            }
            if (len > avail) {
                len = avail;
            }
            System.arraycopy((Object) this.buf, this.pos, (Object) b4, off, len);
            this.pos += len;
            return len;
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x0078, code lost:
        
            return r1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int readLine(byte[] r11, int r12, int r13) throws java.io.IOException {
            /*
                r10 = this;
                byte[] r0 = r10.buf
                r1 = 0
            L3:
                if (r1 >= r13) goto L78
                int r2 = r10.count
                int r3 = r10.pos
                int r2 = r2 - r3
                if (r2 > 0) goto L19
                r10.fill()
                int r3 = r10.count
                int r4 = r10.pos
                int r2 = r3 - r4
                if (r2 > 0) goto L19
                r3 = -1
                return r3
            L19:
                int r3 = r13 - r1
                if (r3 <= r2) goto L1e
                r3 = r2
            L1e:
                int r4 = r10.pos
                int r5 = r4 + r3
                r6 = 0
            L23:
                r7 = 13
                r8 = 10
                if (r4 >= r5) goto L35
                int r9 = r4 + 1
                r4 = r0[r4]
                r6 = r4
                if (r4 == r8) goto L34
                if (r6 == r7) goto L34
                r4 = r9
                goto L23
            L34:
                r4 = r9
            L35:
                if (r6 != r7) goto L3f
                if (r4 >= r5) goto L3f
                r9 = r0[r4]
                if (r9 != r8) goto L3f
                int r4 = r4 + 1
            L3f:
                int r9 = r10.pos
                int r3 = r4 - r9
                java.lang.System.arraycopy(r0, r9, r11, r12, r3)
                int r12 = r12 + r3
                int r1 = r1 + r3
                r10.pos = r4
                int r9 = r4 + (-1)
                r6 = r0[r9]
                if (r6 != r8) goto L51
                goto L78
            L51:
                if (r6 != r7) goto L77
                int r7 = r10.count
                if (r7 != r4) goto L78
                r10.fill()
                int r7 = r10.pos
                int r9 = r10.count
                if (r7 >= r9) goto L78
                r9 = r0[r7]
                if (r9 != r8) goto L78
                if (r1 >= r13) goto L6e
                int r9 = r12 + 1
                r11[r12] = r8
                int r1 = r1 + 1
                r12 = r9
                goto L72
            L6e:
                int r9 = r12 + (-1)
                r11[r9] = r8
            L72:
                int r7 = r7 + 1
                r10.pos = r7
                goto L78
            L77:
                goto L3
            L78:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.jar.Manifest.FastInputStream.readLine(byte[], int, int):int");
        }

        public byte peek() throws IOException {
            if (this.pos == this.count) {
                fill();
            }
            int i10 = this.pos;
            if (i10 == this.count) {
                return (byte) -1;
            }
            return this.buf[i10];
        }

        public int readLine(byte[] b4) throws IOException {
            return readLine(b4, 0, b4.length);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long n10) throws IOException {
            if (n10 <= 0) {
                return 0L;
            }
            int i10 = this.count;
            int i11 = this.pos;
            long avail = i10 - i11;
            if (avail <= 0) {
                return this.in.skip(n10);
            }
            if (n10 > avail) {
                n10 = avail;
            }
            this.pos = (int) (i11 + n10);
            return n10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (this.count - this.pos) + this.in.available();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.in != null) {
                this.in.close();
                this.in = null;
                this.buf = null;
            }
        }

        private void fill() throws IOException {
            this.pos = 0;
            this.count = 0;
            InputStream inputStream = this.in;
            byte[] bArr = this.buf;
            int n10 = inputStream.read(bArr, 0, bArr.length);
            if (n10 > 0) {
                this.count = n10;
            }
        }
    }
}
