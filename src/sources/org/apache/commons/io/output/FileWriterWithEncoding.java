package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Objects;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FileWriterWithEncoding extends Writer {
    private final Writer out;

    public FileWriterWithEncoding(String str, String str2) throws IOException {
        this(new File(str), str2, false);
    }

    private static Writer initWriter(File file, Object obj, boolean z10) throws IOException {
        FileOutputStream fileOutputStream;
        Objects.requireNonNull(file, "File is missing");
        Objects.requireNonNull(obj, "Encoding is missing");
        boolean exists = file.exists();
        try {
            fileOutputStream = new FileOutputStream(file, z10);
            try {
                if (obj instanceof Charset) {
                    return new OutputStreamWriter(fileOutputStream, (Charset) obj);
                }
                if (obj instanceof CharsetEncoder) {
                    return new OutputStreamWriter(fileOutputStream, (CharsetEncoder) obj);
                }
                return new OutputStreamWriter(fileOutputStream, (String) obj);
            } catch (IOException e2) {
                e = e2;
                IOUtils.closeQuietly((Writer) null);
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                if (!exists) {
                    FileUtils.deleteQuietly(file);
                }
                throw e;
            } catch (RuntimeException e10) {
                e = e10;
                IOUtils.closeQuietly((Writer) null);
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                if (!exists) {
                    FileUtils.deleteQuietly(file);
                }
                throw e;
            }
        } catch (IOException e11) {
            e = e11;
            fileOutputStream = null;
        } catch (RuntimeException e12) {
            e = e12;
            fileOutputStream = null;
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.Writer
    public void write(int i10) throws IOException {
        this.out.write(i10);
    }

    public FileWriterWithEncoding(String str, String str2, boolean z10) throws IOException {
        this(new File(str), str2, z10);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        this.out.write(cArr);
    }

    public FileWriterWithEncoding(String str, Charset charset) throws IOException {
        this(new File(str), charset, false);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) throws IOException {
        this.out.write(cArr, i10, i11);
    }

    public FileWriterWithEncoding(String str, Charset charset, boolean z10) throws IOException {
        this(new File(str), charset, z10);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        this.out.write(str);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder) throws IOException {
        this(new File(str), charsetEncoder, false);
    }

    @Override // java.io.Writer
    public void write(String str, int i10, int i11) throws IOException {
        this.out.write(str, i10, i11);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder, boolean z10) throws IOException {
        this(new File(str), charsetEncoder, z10);
    }

    public FileWriterWithEncoding(File file, String str) throws IOException {
        this(file, str, false);
    }

    public FileWriterWithEncoding(File file, String str, boolean z10) throws IOException {
        this.out = initWriter(file, str, z10);
    }

    public FileWriterWithEncoding(File file, Charset charset) throws IOException {
        this(file, charset, false);
    }

    public FileWriterWithEncoding(File file, Charset charset, boolean z10) throws IOException {
        this.out = initWriter(file, charset, z10);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder) throws IOException {
        this(file, charsetEncoder, false);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder, boolean z10) throws IOException {
        this.out = initWriter(file, charsetEncoder, z10);
    }
}
