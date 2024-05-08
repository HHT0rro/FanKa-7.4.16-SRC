package java.io;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Formatter;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PrintStream extends FilterOutputStream implements Appendable, Closeable {
    private final boolean autoFlush;
    private OutputStreamWriter charOut;
    private Charset charset;
    private boolean closing;
    private Formatter formatter;
    private BufferedWriter textOut;
    private boolean trouble;

    private static <T> T requireNonNull(T obj, String message) {
        if (obj == null) {
            throw new NullPointerException(message);
        }
        return obj;
    }

    private static Charset toCharset(String csn) throws UnsupportedEncodingException {
        requireNonNull(csn, "charsetName");
        try {
            return Charset.forName(csn);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e2) {
            throw new UnsupportedEncodingException(csn);
        }
    }

    private PrintStream(boolean autoFlush, OutputStream out) {
        super(out);
        this.trouble = false;
        this.closing = false;
        this.autoFlush = autoFlush;
    }

    private PrintStream(boolean autoFlush, Charset charset, OutputStream out) {
        this(out, autoFlush, charset);
    }

    public PrintStream(OutputStream out) {
        this(out, false);
    }

    public PrintStream(OutputStream out, boolean autoFlush) {
        this(autoFlush, (OutputStream) requireNonNull(out, "Null output stream"));
    }

    public PrintStream(OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException {
        this((OutputStream) requireNonNull(out, "Null output stream"), autoFlush, toCharset(encoding));
    }

    public PrintStream(OutputStream out, boolean autoFlush, Charset charset) {
        super(out);
        this.trouble = false;
        this.closing = false;
        this.autoFlush = autoFlush;
        this.charOut = new OutputStreamWriter(this, charset);
        this.textOut = new BufferedWriter(this.charOut);
    }

    public PrintStream(String fileName) throws FileNotFoundException {
        this(false, (OutputStream) new FileOutputStream(fileName));
    }

    public PrintStream(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(false, toCharset(csn), (OutputStream) new FileOutputStream(fileName));
    }

    public PrintStream(String fileName, Charset charset) throws IOException {
        this(false, (Charset) requireNonNull(charset, "charset"), (OutputStream) new FileOutputStream(fileName));
    }

    public PrintStream(File file) throws FileNotFoundException {
        this(false, (OutputStream) new FileOutputStream(file));
    }

    public PrintStream(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(false, toCharset(csn), (OutputStream) new FileOutputStream(file));
    }

    public PrintStream(File file, Charset charset) throws IOException {
        this(false, (Charset) requireNonNull(charset, "charset"), (OutputStream) new FileOutputStream(file));
    }

    private void ensureOpen() throws IOException {
        if (this.out == null) {
            throw new IOException("Stream closed");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        synchronized (this) {
            try {
                ensureOpen();
                this.out.flush();
            } catch (IOException e2) {
                this.trouble = true;
            }
        }
    }

    private BufferedWriter getTextOut() {
        if (this.textOut == null) {
            Charset charset = this.charset;
            this.charOut = charset != null ? new OutputStreamWriter(this, charset) : new OutputStreamWriter(this);
            this.textOut = new BufferedWriter(this.charOut);
        }
        return this.textOut;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.closing) {
                this.closing = true;
                try {
                    BufferedWriter bufferedWriter = this.textOut;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    this.out.close();
                } catch (IOException e2) {
                    this.trouble = true;
                }
                this.textOut = null;
                this.charOut = null;
                this.out = null;
            }
        }
    }

    public boolean checkError() {
        if (this.out != null) {
            flush();
        }
        OutputStream outputStream = this.out;
        if (outputStream instanceof PrintStream) {
            PrintStream ps = (PrintStream) outputStream;
            return ps.checkError();
        }
        return this.trouble;
    }

    protected void setError() {
        this.trouble = true;
    }

    protected void clearError() {
        this.trouble = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int b4) {
        try {
            synchronized (this) {
                ensureOpen();
                this.out.write(b4);
                if (b4 == 10 && this.autoFlush) {
                    this.out.flush();
                }
            }
        } catch (InterruptedIOException e2) {
            Thread.currentThread().interrupt();
        } catch (IOException e10) {
            this.trouble = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] buf, int off, int len) {
        try {
            synchronized (this) {
                ensureOpen();
                this.out.write(buf, off, len);
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

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] buf) throws IOException {
        write(buf, 0, buf.length);
    }

    public void writeBytes(byte[] buf) {
        write(buf, 0, buf.length);
    }

    private void write(char[] buf) {
        try {
            synchronized (this) {
                ensureOpen();
                BufferedWriter textOut = getTextOut();
                textOut.write(buf);
                textOut.flushBuffer();
                this.charOut.flushBuffer();
                if (this.autoFlush) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= buf.length) {
                            break;
                        }
                        if (buf[i10] != '\n') {
                            i10++;
                        } else {
                            this.out.flush();
                            break;
                        }
                    }
                }
            }
        } catch (InterruptedIOException e2) {
            Thread.currentThread().interrupt();
        } catch (IOException e10) {
            this.trouble = true;
        }
    }

    private void writeln(char[] buf) {
        try {
            synchronized (this) {
                ensureOpen();
                BufferedWriter textOut = getTextOut();
                textOut.write(buf);
                textOut.newLine();
                textOut.flushBuffer();
                this.charOut.flushBuffer();
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

    private void write(String s2) {
        try {
            synchronized (this) {
                ensureOpen();
                BufferedWriter textOut = getTextOut();
                textOut.write(s2);
                textOut.flushBuffer();
                this.charOut.flushBuffer();
                if (this.autoFlush && s2.indexOf(10) >= 0) {
                    this.out.flush();
                }
            }
        } catch (InterruptedIOException e2) {
            Thread.currentThread().interrupt();
        } catch (IOException e10) {
            this.trouble = true;
        }
    }

    private void writeln(String s2) {
        try {
            synchronized (this) {
                ensureOpen();
                BufferedWriter textOut = getTextOut();
                textOut.write(s2);
                textOut.newLine();
                textOut.flushBuffer();
                this.charOut.flushBuffer();
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

    private void newLine() {
        try {
            synchronized (this) {
                ensureOpen();
                BufferedWriter textOut = getTextOut();
                textOut.newLine();
                textOut.flushBuffer();
                this.charOut.flushBuffer();
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
        write(String.valueOf(c4));
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
        if (getClass() == PrintStream.class) {
            writeln(String.valueOf(x10));
            return;
        }
        synchronized (this) {
            print(x10);
            newLine();
        }
    }

    public void println(char x10) {
        if (getClass() == PrintStream.class) {
            writeln(String.valueOf(x10));
            return;
        }
        synchronized (this) {
            print(x10);
            newLine();
        }
    }

    public void println(int x10) {
        if (getClass() == PrintStream.class) {
            writeln(String.valueOf(x10));
            return;
        }
        synchronized (this) {
            print(x10);
            newLine();
        }
    }

    public void println(long x10) {
        if (getClass() == PrintStream.class) {
            writeln(String.valueOf(x10));
            return;
        }
        synchronized (this) {
            print(x10);
            newLine();
        }
    }

    public void println(float x10) {
        if (getClass() == PrintStream.class) {
            writeln(String.valueOf(x10));
            return;
        }
        synchronized (this) {
            print(x10);
            newLine();
        }
    }

    public void println(double x10) {
        if (getClass() == PrintStream.class) {
            writeln(String.valueOf(x10));
            return;
        }
        synchronized (this) {
            print(x10);
            newLine();
        }
    }

    public void println(char[] x10) {
        if (getClass() == PrintStream.class) {
            writeln(x10);
            return;
        }
        synchronized (this) {
            print(x10);
            newLine();
        }
    }

    public void println(String x10) {
        if (getClass() == PrintStream.class) {
            writeln(String.valueOf(x10));
            return;
        }
        synchronized (this) {
            print(x10);
            newLine();
        }
    }

    public void println(Object x10) {
        String s2 = String.valueOf(x10);
        if (getClass() == PrintStream.class) {
            writeln(String.valueOf(s2));
            return;
        }
        synchronized (this) {
            print(s2);
            newLine();
        }
    }

    public PrintStream printf(String format, Object... args) {
        return format(format, args);
    }

    public PrintStream printf(Locale l10, String format, Object... args) {
        return format(l10, format, args);
    }

    public PrintStream format(String format, Object... args) {
        try {
            synchronized (this) {
                ensureOpen();
                Formatter formatter = this.formatter;
                if (formatter == null || formatter.locale() != Locale.getDefault(Locale.Category.FORMAT)) {
                    this.formatter = new Formatter((Appendable) this);
                }
                this.formatter.format(Locale.getDefault(Locale.Category.FORMAT), format, args);
            }
        } catch (InterruptedIOException e2) {
            Thread.currentThread().interrupt();
        } catch (IOException e10) {
            this.trouble = true;
        }
        return this;
    }

    public PrintStream format(Locale l10, String format, Object... args) {
        try {
            synchronized (this) {
                ensureOpen();
                Formatter formatter = this.formatter;
                if (formatter == null || formatter.locale() != l10) {
                    this.formatter = new Formatter(this, l10);
                }
                this.formatter.format(l10, format, args);
            }
        } catch (InterruptedIOException e2) {
            Thread.currentThread().interrupt();
        } catch (IOException e10) {
            this.trouble = true;
        }
        return this;
    }

    @Override // java.lang.Appendable
    public PrintStream append(CharSequence csq) {
        print(String.valueOf(csq));
        return this;
    }

    @Override // java.lang.Appendable
    public PrintStream append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        return append(csq.subSequence(start, end));
    }

    @Override // java.lang.Appendable
    public PrintStream append(char c4) {
        print(c4);
        return this;
    }
}
