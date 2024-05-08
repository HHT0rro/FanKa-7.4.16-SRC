package java.util.zip;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import sun.nio.cs.ArrayDecoder;
import sun.nio.cs.ArrayEncoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ZipCoder {
    private Charset cs;
    private CharsetDecoder dec;
    private CharsetEncoder enc;
    private boolean isUTF8;
    private ZipCoder utf8;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public String toString(byte[] ba2, int length) {
        CharsetDecoder reset = decoder().reset();
        int len = (int) (length * reset.maxCharsPerByte());
        char[] ca2 = new char[len];
        if (len == 0) {
            return new String(ca2);
        }
        if (this.isUTF8 && (reset instanceof ArrayDecoder)) {
            int clen = ((ArrayDecoder) reset).decode(ba2, 0, length, ca2);
            if (clen == -1) {
                throw new IllegalArgumentException("MALFORMED");
            }
            return new String(ca2, 0, clen);
        }
        ByteBuffer bb2 = ByteBuffer.wrap(ba2, 0, length);
        CharBuffer cb2 = CharBuffer.wrap(ca2);
        CoderResult cr = reset.decode(bb2, cb2, true);
        if (!cr.isUnderflow()) {
            throw new IllegalArgumentException(cr.toString());
        }
        CoderResult cr2 = reset.flush(cb2);
        if (!cr2.isUnderflow()) {
            throw new IllegalArgumentException(cr2.toString());
        }
        return new String(ca2, 0, cb2.position());
    }

    String toString(byte[] ba2) {
        return toString(ba2, ba2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public byte[] getBytes(String s2) {
        CharsetEncoder reset = encoder().reset();
        char[] ca2 = s2.toCharArray();
        int len = (int) (ca2.length * reset.maxBytesPerChar());
        byte[] ba2 = new byte[len];
        if (len == 0) {
            return ba2;
        }
        if (this.isUTF8 && (reset instanceof ArrayEncoder)) {
            int blen = ((ArrayEncoder) reset).encode(ca2, 0, ca2.length, ba2);
            if (blen == -1) {
                throw new IllegalArgumentException("MALFORMED");
            }
            return Arrays.copyOf(ba2, blen);
        }
        ByteBuffer bb2 = ByteBuffer.wrap(ba2);
        CharBuffer cb2 = CharBuffer.wrap(ca2);
        CoderResult cr = reset.encode(cb2, bb2, true);
        if (!cr.isUnderflow()) {
            throw new IllegalArgumentException(cr.toString());
        }
        CoderResult cr2 = reset.flush(bb2);
        if (!cr2.isUnderflow()) {
            throw new IllegalArgumentException(cr2.toString());
        }
        if (bb2.position() == ba2.length) {
            return ba2;
        }
        return Arrays.copyOf(ba2, bb2.position());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getBytesUTF8(String s2) {
        if (this.isUTF8) {
            return getBytes(s2);
        }
        if (this.utf8 == null) {
            this.utf8 = new ZipCoder(StandardCharsets.UTF_8);
        }
        return this.utf8.getBytes(s2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toStringUTF8(byte[] ba2, int len) {
        if (this.isUTF8) {
            return toString(ba2, len);
        }
        if (this.utf8 == null) {
            this.utf8 = new ZipCoder(StandardCharsets.UTF_8);
        }
        return this.utf8.toString(ba2, len);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isUTF8() {
        return this.isUTF8;
    }

    private ZipCoder(Charset cs) {
        this.cs = cs;
        this.isUTF8 = cs.name().equals(StandardCharsets.UTF_8.name());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZipCoder get(Charset charset) {
        return new ZipCoder(charset);
    }

    private CharsetDecoder decoder() {
        if (this.dec == null) {
            this.dec = this.cs.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        }
        return this.dec;
    }

    private CharsetEncoder encoder() {
        if (this.enc == null) {
            this.enc = this.cs.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        }
        return this.enc;
    }
}
