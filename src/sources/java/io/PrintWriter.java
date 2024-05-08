package java.io;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Formatter;
import java.util.Locale;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PrintWriter extends Writer {
    private final boolean autoFlush;
    private Formatter formatter;
    protected Writer out;
    private PrintStream psOut;
    private boolean trouble;

    private static Charset toCharset(String csn) throws UnsupportedEncodingException {
        Objects.requireNonNull(csn, "charsetName");
        try {
            return Charset.forName(csn);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e2) {
            throw new UnsupportedEncodingException(csn);
        }
    }

    public PrintWriter(Writer out) {
        this(out, false);
    }

    public PrintWriter(Writer out, boolean autoFlush) {
        super(out);
        this.trouble = false;
        this.psOut = null;
        this.out = out;
        this.autoFlush = autoFlush;
    }

    public PrintWriter(OutputStream out) {
        this(out, false);
    }

    public PrintWriter(OutputStream out, boolean autoFlush) {
        this(out, autoFlush, Charset.defaultCharset());
    }

    public PrintWriter(OutputStream out, boolean autoFlush, Charset charset) {
        this(new BufferedWriter(new OutputStreamWriter(out, charset)), autoFlush);
        if (out instanceof PrintStream) {
            this.psOut = (PrintStream) out;
        }
    }

    public PrintWriter(String fileName) throws FileNotFoundException {
        this((Writer) new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName))), false);
    }

    private PrintWriter(Charset charset, File file) throws FileNotFoundException {
        this((Writer) new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset)), false);
    }

    public PrintWriter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(toCharset(csn), new File(fileName));
    }

    public PrintWriter(String fileName, Charset charset) throws IOException {
        this((Charset) Objects.requireNonNull(charset, "charset"), new File(fileName));
    }

    public PrintWriter(File file) throws FileNotFoundException {
        this((Writer) new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))), false);
    }

    public PrintWriter(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(toCharset(csn), file);
    }

    public PrintWriter(File file, Charset charset) throws IOException {
        this((Charset) Objects.requireNonNull(charset, "charset"), file);
    }

    private void ensureOpen() throws IOException {
        if (this.out == null) {
            throw new IOException("Stream closed");
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        try {
            synchronized (this.lock) {
                ensureOpen();
                this.out.flush();
            }
        } catch (IOException e2) {
            this.trouble = true;
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            synchronized (this.lock) {
                Writer writer = this.out;
                if (writer == null) {
                    return;
                }
                writer.close();
                this.out = null;
            }
        } catch (IOException e2) {
            this.trouble = true;
        }
    }

    public boolean checkError() {
        if (this.out != null) {
            flush();
        }
        Writer writer = this.out;
        if (writer instanceof PrintWriter) {
            PrintWriter pw = (PrintWriter) writer;
            return pw.checkError();
        }
        PrintStream printStream = this.psOut;
        if (printStream != null) {
            return printStream.checkError();
        }
        return this.trouble;
    }

    protected void setError() {
        this.trouble = true;
    }

    protected void clearError() {
        this.trouble = false;
    }

    @Override // java.io.Writer
    public void write(int c4) {
        try {
            synchronized (this.lock) {
                ensureOpen();
                this.out.write(c4);
            }
        } catch (InterruptedIOException e2) {
            Thread.currentThread().interrupt();
        } catch (IOException e10) {
            this.trouble = true;
        }
    }

    @Override // java.io.Writer
    public void write(char[] buf, int off, int len) {
        try {
            synchronized (this.lock) {
                ensureOpen();
                this.out.write(buf, off, len);
            }
        } catch (InterruptedIOException e2) {
            Thread.currentThread().interrupt();
        } catch (IOException e10) {
            this.trouble = true;
        }
    }

    @Override // java.io.Writer
    public void write(char[] buf) {
        write(buf, 0, buf.length);
    }

    @Override // java.io.Writer
    public void write(String s2, int off, int len) {
        try {
            synchronized (this.lock) {
                ensureOpen();
                this.out.write(s2, off, len);
            }
        } catch (InterruptedIOException e2) {
            Thread.currentThread().interrupt();
        } catch (IOException e10) {
            this.trouble = true;
        }
    }

    @Override // java.io.Writer
    public void write(String s2) {
        write(s2, 0, s2.length());
    }

    private void newLine() {
        try {
            synchronized (this.lock) {
                ensureOpen();
                this.out.write(System.lineSeparator());
                if (this.autoFlush) {
                    this.out.flush();
                }
            }
        } catch (InterruptedIOException e2) {
            Thread.currentThread().interrupt();
        } catch (IOException e10) {
            this.trouble = true;
        }
    }

    public void print(boolean b4) {
        write(String.valueOf(b4));
    }

    public void print(char c4) {
        write(c4);
    }

    public void print(int i10) {
        write(String.valueOf(i10));
    }

    public void print(long l10) {
        write(String.valueOf(l10));
    }

    public void print(float f10) {
        write(String.valueOf(f10));
    }

    public void print(double d10) {
        write(String.valueOf(d10));
    }

    public void print(char[] s2) {
        write(s2);
    }

    public void print(String s2) {
        write(String.valueOf(s2));
    }

    public void print(Object obj) {
        write(String.valueOf(obj));
    }

    public void println() {
        newLine();
    }

    public void println(boolean x10) {
        synchronized (this.lock) {
            print(x10);
            println();
        }
    }

    public void println(char x10) {
        synchronized (this.lock) {
            print(x10);
            println();
        }
    }

    public void println(int x10) {
        synchronized (this.lock) {
            print(x10);
            println();
        }
    }

    public void println(long x10) {
        synchronized (this.lock) {
            print(x10);
            println();
        }
    }

    public void println(float x10) {
        synchronized (this.lock) {
            print(x10);
            println();
        }
    }

    public void println(double x10) {
        synchronized (this.lock) {
            print(x10);
            println();
        }
    }

    public void println(char[] x10) {
        synchronized (this.lock) {
            print(x10);
            println();
        }
    }

    public void println(String x10) {
        synchronized (this.lock) {
            print(x10);
            println();
        }
    }

    public void println(Object x10) {
        String s2 = String.valueOf(x10);
        synchronized (this.lock) {
            print(s2);
            println();
        }
    }

    public PrintWriter printf(String format, Object... args) {
        return format(format, args);
    }

    public PrintWriter printf(Locale l10, String format, Object... args) {
        return format(l10, format, args);
    }

    public PrintWriter format(String format, Object... args) {
        try {
            synchronized (this.lock) {
                ensureOpen();
                Formatter formatter = this.formatter;
                if (formatter == null || formatter.locale() != Locale.getDefault()) {
                    this.formatter = new Formatter(this);
                }
                this.formatter.format(Locale.getDefault(), format, args);
                if (this.autoFlush) {
                    this.out.flush();
                }
            }
        } catch (InterruptedIOException e2) {
            Thread.currentThread().interrupt();
        } catch (IOException e10) {
            this.trouble = true;
        }
        return this;
    }

    public PrintWriter format(Locale l10, String format, Object... args) {
        try {
            synchronized (this.lock) {
                ensureOpen();
                Formatter formatter = this.formatter;
                if (formatter == null || formatter.locale() != l10) {
                    this.formatter = new Formatter(this, l10);
                }
                this.formatter.format(l10, format, args);
                if (this.autoFlush) {
                    this.out.flush();
                }
            }
        } catch (InterruptedIOException e2) {
            Thread.currentThread().interrupt();
        } catch (IOException e10) {
            this.trouble = true;
        }
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public PrintWriter append(CharSequence csq) {
        write(String.valueOf(csq));
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public PrintWriter append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        return append(csq.subSequence(start, end));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public PrintWriter append(char c4) {
        write(c4);
        return this;
    }
}
