package com.ss.android.socialbase.downloader.reader;

import com.ss.android.socialbase.downloader.segment.Buffer;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SyncStreamReader implements IStreamReader {
    private final Buffer buffer;
    private final InputStream inputStream;

    public SyncStreamReader(InputStream inputStream, int i10) {
        this.inputStream = inputStream;
        this.buffer = new Buffer(i10);
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public void close() {
        DownloadUtils.safeClose(this.inputStream);
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public Buffer read() throws IOException {
        Buffer buffer = this.buffer;
        buffer.size = this.inputStream.read(buffer.data);
        return this.buffer;
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public void recycle(Buffer buffer) {
    }
}
