package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import org.apache.commons.io.Charsets;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ReversedLinesFileReader implements Closeable {
    private final int avoidNewlineSplitBufferSize;
    private final int blockSize;
    private final int byteDecrement;
    private FilePart currentFilePart;
    private final Charset encoding;
    private final byte[][] newLineSequences;
    private final RandomAccessFile randomAccessFile;
    private final long totalBlockCount;
    private final long totalByteLength;
    private boolean trailingNewlineOfFileSkipped;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class FilePart {
        private int currentLastBytePos;
        private final byte[] data;
        private byte[] leftOver;
        private final long no;

        private void createLeftOver() {
            int i10 = this.currentLastBytePos + 1;
            if (i10 > 0) {
                byte[] bArr = new byte[i10];
                this.leftOver = bArr;
                System.arraycopy((Object) this.data, 0, (Object) bArr, 0, i10);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] bArr, int i10) {
            for (byte[] bArr2 : ReversedLinesFileReader.this.newLineSequences) {
                boolean z10 = true;
                for (int length = bArr2.length - 1; length >= 0; length--) {
                    int length2 = (i10 + length) - (bArr2.length - 1);
                    z10 &= length2 >= 0 && bArr[length2] == bArr2[length];
                }
                if (z10) {
                    return bArr2.length;
                }
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String readLine() throws IOException {
            String str;
            byte[] bArr;
            boolean z10 = this.no == 1;
            int i10 = this.currentLastBytePos;
            while (true) {
                if (i10 > -1) {
                    if (!z10 && i10 < ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
                        createLeftOver();
                        break;
                    }
                    int newLineMatchByteCount = getNewLineMatchByteCount(this.data, i10);
                    if (newLineMatchByteCount > 0) {
                        int i11 = i10 + 1;
                        int i12 = (this.currentLastBytePos - i11) + 1;
                        if (i12 >= 0) {
                            byte[] bArr2 = new byte[i12];
                            System.arraycopy((Object) this.data, i11, (Object) bArr2, 0, i12);
                            str = new String(bArr2, ReversedLinesFileReader.this.encoding);
                            this.currentLastBytePos = i10 - newLineMatchByteCount;
                        } else {
                            throw new IllegalStateException("Unexpected negative line length=" + i12);
                        }
                    } else {
                        i10 -= ReversedLinesFileReader.this.byteDecrement;
                        if (i10 < 0) {
                            createLeftOver();
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            str = null;
            if (!z10 || (bArr = this.leftOver) == null) {
                return str;
            }
            String str2 = new String(bArr, ReversedLinesFileReader.this.encoding);
            this.leftOver = null;
            return str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FilePart rollOver() throws IOException {
            if (this.currentLastBytePos <= -1) {
                long j10 = this.no;
                if (j10 > 1) {
                    ReversedLinesFileReader reversedLinesFileReader = ReversedLinesFileReader.this;
                    return new FilePart(j10 - 1, reversedLinesFileReader.blockSize, this.leftOver);
                }
                if (this.leftOver == null) {
                    return null;
                }
                throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.this.encoding));
            }
            throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
        }

        private FilePart(long j10, int i10, byte[] bArr) throws IOException {
            this.no = j10;
            byte[] bArr2 = new byte[(bArr != null ? bArr.length : 0) + i10];
            this.data = bArr2;
            long j11 = (j10 - 1) * ReversedLinesFileReader.this.blockSize;
            if (j10 > 0) {
                ReversedLinesFileReader.this.randomAccessFile.seek(j11);
                if (ReversedLinesFileReader.this.randomAccessFile.read(bArr2, 0, i10) != i10) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy((Object) bArr, 0, (Object) bArr2, i10, bArr.length);
            }
            this.currentLastBytePos = bArr2.length - 1;
            this.leftOver = null;
        }
    }

    public ReversedLinesFileReader(File file) throws IOException {
        this(file, 4096, Charset.defaultCharset().toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.randomAccessFile.close();
    }

    public String readLine() throws IOException {
        String readLine = this.currentFilePart.readLine();
        while (readLine == null) {
            FilePart rollOver = this.currentFilePart.rollOver();
            this.currentFilePart = rollOver;
            if (rollOver == null) {
                break;
            }
            readLine = rollOver.readLine();
        }
        if (!"".equals(readLine) || this.trailingNewlineOfFileSkipped) {
            return readLine;
        }
        this.trailingNewlineOfFileSkipped = true;
        return readLine();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ReversedLinesFileReader(java.io.File r10, int r11, java.nio.charset.Charset r12) throws java.io.IOException {
        /*
            r9 = this;
            r9.<init>()
            r7 = 0
            r9.trailingNewlineOfFileSkipped = r7
            r9.blockSize = r11
            r9.encoding = r12
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "r"
            r1.<init>(r10, r2)
            r9.randomAccessFile = r1
            long r1 = r1.length()
            r9.totalByteLength = r1
            long r3 = (long) r11
            long r5 = r1 % r3
            int r6 = (int) r5
            if (r6 <= 0) goto L26
            long r1 = r1 / r3
            r3 = 1
            long r1 = r1 + r3
            r9.totalBlockCount = r1
            goto L32
        L26:
            long r3 = r1 / r3
            r9.totalBlockCount = r3
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L32
            r4 = r11
            goto L33
        L32:
            r4 = r6
        L33:
            org.apache.commons.io.input.ReversedLinesFileReader$FilePart r8 = new org.apache.commons.io.input.ReversedLinesFileReader$FilePart
            long r2 = r9.totalBlockCount
            r5 = 0
            r6 = 0
            r0 = r8
            r1 = r9
            r0.<init>(r2, r4, r5)
            r9.currentFilePart = r8
            java.nio.charset.Charset r0 = org.apache.commons.io.Charsets.toCharset(r12)
            java.nio.charset.CharsetEncoder r1 = r0.newEncoder()
            float r1 = r1.maxBytesPerChar()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 2
            r4 = 1
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L57
            r9.byteDecrement = r4
            goto Lac
        L57:
            java.lang.String r1 = "UTF-8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            if (r0 != r1) goto L62
            r9.byteDecrement = r4
            goto Lac
        L62:
            java.lang.String r1 = "Shift_JIS"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            if (r0 != r1) goto L6d
            r9.byteDecrement = r4
            goto Lac
        L6d:
            java.lang.String r1 = "UTF-16BE"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            if (r0 == r1) goto Laa
            java.lang.String r1 = "UTF-16LE"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            if (r0 != r1) goto L7e
            goto Laa
        L7e:
            java.lang.String r1 = "UTF-16"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            if (r0 != r1) goto L8e
            java.io.UnsupportedEncodingException r0 = new java.io.UnsupportedEncodingException
            java.lang.String r1 = "For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)"
            r0.<init>(r1)
            throw r0
        L8e:
            java.io.UnsupportedEncodingException r0 = new java.io.UnsupportedEncodingException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Encoding "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = " is not supported yet (feel free to submit a patch)"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        Laa:
            r9.byteDecrement = r3
        Lac:
            r0 = 3
            byte[][] r0 = new byte[r0]
            java.lang.String r1 = "\r\n"
            byte[] r1 = r1.getBytes(r12)
            r0[r7] = r1
            java.lang.String r1 = "\n"
            byte[] r1 = r1.getBytes(r12)
            r0[r4] = r1
            java.lang.String r1 = "\r"
            byte[] r1 = r1.getBytes(r12)
            r0[r3] = r1
            r9.newLineSequences = r0
            r0 = r0[r7]
            int r0 = r0.length
            r9.avoidNewlineSplitBufferSize = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.input.ReversedLinesFileReader.<init>(java.io.File, int, java.nio.charset.Charset):void");
    }

    public ReversedLinesFileReader(File file, int i10, String str) throws IOException {
        this(file, i10, Charsets.toCharset(str));
    }
}
