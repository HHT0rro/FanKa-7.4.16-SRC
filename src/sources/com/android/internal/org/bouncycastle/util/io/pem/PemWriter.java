package com.android.internal.org.bouncycastle.util.io.pem;

import com.android.internal.org.bouncycastle.util.Strings;
import com.android.internal.org.bouncycastle.util.encoders.Base64;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PemWriter extends BufferedWriter {
    private static final int LINE_LENGTH = 64;
    private char[] buf;
    private final int nlLength;

    public PemWriter(Writer out) {
        super(out);
        this.buf = new char[64];
        String nl = Strings.lineSeparator();
        if (nl != null) {
            this.nlLength = nl.length();
        } else {
            this.nlLength = 2;
        }
    }

    public int getOutputSize(PemObject obj) {
        int size = ((obj.getType().length() + 10 + this.nlLength) * 2) + 6 + 4;
        if (!obj.getHeaders().isEmpty()) {
            for (PemHeader hdr : obj.getHeaders()) {
                size += hdr.getName().length() + ": ".length() + hdr.getValue().length() + this.nlLength;
            }
            size += this.nlLength;
        }
        int dataLen = ((obj.getContent().length + 2) / 3) * 4;
        return size + ((((dataLen + 64) - 1) / 64) * this.nlLength) + dataLen;
    }

    public void writeObject(PemObjectGenerator objGen) throws IOException {
        PemObject obj = objGen.generate();
        writePreEncapsulationBoundary(obj.getType());
        if (!obj.getHeaders().isEmpty()) {
            for (PemHeader hdr : obj.getHeaders()) {
                write(hdr.getName());
                write(": ");
                write(hdr.getValue());
                newLine();
            }
            newLine();
        }
        writeEncoded(obj.getContent());
        writePostEncapsulationBoundary(obj.getType());
    }

    private void writeEncoded(byte[] bytes) throws IOException {
        char[] cArr;
        byte[] bytes2 = Base64.encode(bytes);
        int i10 = 0;
        while (i10 < bytes2.length) {
            int index = 0;
            while (true) {
                cArr = this.buf;
                if (index != cArr.length && i10 + index < bytes2.length) {
                    cArr[index] = (char) bytes2[i10 + index];
                    index++;
                }
            }
            write(cArr, 0, index);
            newLine();
            i10 += this.buf.length;
        }
    }

    private void writePreEncapsulationBoundary(String type) throws IOException {
        write("-----BEGIN " + type + "-----");
        newLine();
    }

    private void writePostEncapsulationBoundary(String type) throws IOException {
        write("-----END " + type + "-----");
        newLine();
    }
}
