package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class AutoCloseInputStream extends ProxyInputStream {
    public AutoCloseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    public void afterRead(int i10) throws IOException {
        if (i10 == -1) {
            close();
        }
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
        this.in = new ClosedInputStream();
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
