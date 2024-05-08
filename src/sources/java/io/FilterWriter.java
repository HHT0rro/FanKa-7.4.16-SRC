package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class FilterWriter extends Writer {
    protected Writer out;

    /* JADX INFO: Access modifiers changed from: protected */
    public FilterWriter(Writer out) {
        super(out);
        this.out = out;
    }

    @Override // java.io.Writer
    public void write(int c4) throws IOException {
        this.out.write(c4);
    }

    @Override // java.io.Writer
    public void write(char[] cbuf, int off, int len) throws IOException {
        this.out.write(cbuf, off, len);
    }

    @Override // java.io.Writer
    public void write(String str, int off, int len) throws IOException {
        this.out.write(str, off, len);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }
}
