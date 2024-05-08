package sun.misc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class HexDumpEncoder extends CharacterEncoder {
    private int currentByte;
    private int offset;
    private byte[] thisLine = new byte[16];
    private int thisLineLength;

    static void hexDigit(PrintStream p10, byte x10) {
        char c4;
        char c10;
        char c11 = (char) ((x10 >> 4) & 15);
        if (c11 > '\t') {
            c4 = (char) ((c11 - '\n') + 65);
        } else {
            c4 = (char) (c11 + '0');
        }
        p10.write(c4);
        char c12 = (char) (x10 & 15);
        if (c12 > '\t') {
            c10 = (char) ((c12 - '\n') + 65);
        } else {
            c10 = (char) (c12 + '0');
        }
        p10.write(c10);
    }

    @Override // sun.misc.CharacterEncoder
    protected int bytesPerAtom() {
        return 1;
    }

    @Override // sun.misc.CharacterEncoder
    protected int bytesPerLine() {
        return 16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sun.misc.CharacterEncoder
    public void encodeBufferPrefix(OutputStream o10) throws IOException {
        this.offset = 0;
        super.encodeBufferPrefix(o10);
    }

    @Override // sun.misc.CharacterEncoder
    protected void encodeLinePrefix(OutputStream o10, int len) throws IOException {
        hexDigit(this.pStream, (byte) ((this.offset >>> 8) & 255));
        hexDigit(this.pStream, (byte) (this.offset & 255));
        this.pStream.print(": ");
        this.currentByte = 0;
        this.thisLineLength = len;
    }

    @Override // sun.misc.CharacterEncoder
    protected void encodeAtom(OutputStream o10, byte[] buf, int off, int len) throws IOException {
        this.thisLine[this.currentByte] = buf[off];
        hexDigit(this.pStream, buf[off]);
        this.pStream.print(" ");
        int i10 = this.currentByte + 1;
        this.currentByte = i10;
        if (i10 == 8) {
            this.pStream.print("  ");
        }
    }

    @Override // sun.misc.CharacterEncoder
    protected void encodeLineSuffix(OutputStream o10) throws IOException {
        if (this.thisLineLength < 16) {
            for (int i10 = this.thisLineLength; i10 < 16; i10++) {
                this.pStream.print("   ");
                if (i10 == 7) {
                    this.pStream.print("  ");
                }
            }
        }
        this.pStream.print(" ");
        for (int i11 = 0; i11 < this.thisLineLength; i11++) {
            byte b4 = this.thisLine[i11];
            if (b4 < 32 || b4 > 122) {
                this.pStream.print(".");
            } else {
                this.pStream.write(this.thisLine[i11]);
            }
        }
        this.pStream.println();
        this.offset += this.thisLineLength;
    }
}
