package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ProxyWriter extends FilterWriter {
    public ProxyWriter(Writer writer) {
        super(writer);
    }

    public void afterWrite(int i10) throws IOException {
    }

    public void beforeWrite(int i10) throws IOException {
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.out.close();
        } catch (IOException e2) {
            handleIOException(e2);
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.out.flush();
        } catch (IOException e2) {
            handleIOException(e2);
        }
    }

    public void handleIOException(IOException iOException) throws IOException {
        throw iOException;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(int i10) throws IOException {
        try {
            beforeWrite(1);
            this.out.write(i10);
            afterWrite(1);
        } catch (IOException e2) {
            handleIOException(e2);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c4) throws IOException {
        try {
            beforeWrite(1);
            this.out.append(c4);
            afterWrite(1);
        } catch (IOException e2) {
            handleIOException(e2);
        }
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        int i10 = 0;
        if (cArr != null) {
            try {
                i10 = cArr.length;
            } catch (IOException e2) {
                handleIOException(e2);
                return;
            }
        }
        beforeWrite(i10);
        this.out.write(cArr);
        afterWrite(i10);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i10, int i11) throws IOException {
        int i12 = i11 - i10;
        try {
            beforeWrite(i12);
            this.out.append(charSequence, i10, i11);
            afterWrite(i12);
        } catch (IOException e2) {
            handleIOException(e2);
        }
        return this;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i10, int i11) throws IOException {
        try {
            beforeWrite(i11);
            this.out.write(cArr, i10, i11);
            afterWrite(i11);
        } catch (IOException e2) {
            handleIOException(e2);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        int i10 = 0;
        if (charSequence != null) {
            try {
                i10 = charSequence.length();
            } catch (IOException e2) {
                handleIOException(e2);
            }
        }
        beforeWrite(i10);
        this.out.append(charSequence);
        afterWrite(i10);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        int i10 = 0;
        if (str != null) {
            try {
                i10 = str.length();
            } catch (IOException e2) {
                handleIOException(e2);
                return;
            }
        }
        beforeWrite(i10);
        this.out.write(str);
        afterWrite(i10);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String str, int i10, int i11) throws IOException {
        try {
            beforeWrite(i11);
            this.out.write(str, i10, i11);
            afterWrite(i11);
        } catch (IOException e2) {
            handleIOException(e2);
        }
    }
}
