package com.alibaba.security.realidentity.http;

import com.alibaba.security.common.http.ok.MediaType;
import com.alibaba.security.common.http.ok.RequestBody;
import com.alibaba.security.common.http.okio.BufferedSink;
import com.alibaba.security.common.http.okio.RPOkio;
import com.alibaba.security.common.http.okio.Source;
import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RpOkHttpProgressRequestBody extends RequestBody {
    private static final int SEGMENT_SIZE = 2048;
    private final ProgressCallback callback;
    private final String contentType;
    private final File file;

    public RpOkHttpProgressRequestBody(File file, String str, ProgressCallback progressCallback) {
        this.file = file;
        this.contentType = str;
        this.callback = progressCallback;
    }

    @Override // com.alibaba.security.common.http.ok.RequestBody
    public long contentLength() throws IOException {
        return this.file.length();
    }

    @Override // com.alibaba.security.common.http.ok.RequestBody
    public MediaType contentType() {
        return MediaType.parse(this.contentType);
    }

    @Override // com.alibaba.security.common.http.ok.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = RPOkio.source(this.file);
        long j10 = 0;
        while (j10 < contentLength()) {
            long read = source.read(bufferedSink.buffer(), Math.min(contentLength() - j10, 2048L));
            if (read == -1) {
                break;
            }
            j10 += read;
            bufferedSink.flush();
            ProgressCallback progressCallback = this.callback;
            if (progressCallback != null && j10 != 0) {
                progressCallback.onProgress(j10, contentLength());
            }
        }
        if (source != null) {
            source.close();
        }
    }
}
