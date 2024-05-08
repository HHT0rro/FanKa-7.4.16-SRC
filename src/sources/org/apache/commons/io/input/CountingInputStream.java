package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CountingInputStream extends ProxyInputStream {
    private long count;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    public synchronized void afterRead(int i10) {
        if (i10 != -1) {
            this.count += i10;
        }
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public int getCount() {
        long byteCount = getByteCount();
        if (byteCount <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            return (int) byteCount;
        }
        throw new ArithmeticException("The byte count " + byteCount + " is too large to be converted to an int");
    }

    public synchronized long resetByteCount() {
        long j10;
        j10 = this.count;
        this.count = 0L;
        return j10;
    }

    public int resetCount() {
        long resetByteCount = resetByteCount();
        if (resetByteCount <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            return (int) resetByteCount;
        }
        throw new ArithmeticException("The byte count " + resetByteCount + " is too large to be converted to an int");
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) throws IOException {
        long skip;
        skip = super.skip(j10);
        this.count += skip;
        return skip;
    }
}
