package com.wangmai.okhttp.request.base;

import com.wangmai.okhttp.callback.Callback;
import com.wangmai.okhttp.model.Progress;
import com.wangmai.okhttp.utils.HttpUtils;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ProgressRequestBody<T> extends RequestBody {
    public Callback<T> callback;
    public UploadInterceptor interceptor;
    public RequestBody requestBody;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class CountingSink extends ForwardingSink {
        public Progress progress;

        public CountingSink(Sink sink) {
            super(sink);
            Progress progress = new Progress();
            this.progress = progress;
            progress.totalSize = ProgressRequestBody.this.contentLength();
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            super.write(buffer, j10);
            Progress.changeProgress(this.progress, j10, new Progress.Action() { // from class: com.wangmai.okhttp.request.base.ProgressRequestBody.CountingSink.1
                @Override // com.wangmai.okhttp.model.Progress.Action
                public void call(Progress progress) {
                    if (ProgressRequestBody.this.interceptor != null) {
                        ProgressRequestBody.this.interceptor.uploadProgress(progress);
                    } else {
                        ProgressRequestBody.this.onProgress(progress);
                    }
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface UploadInterceptor {
        void uploadProgress(Progress progress);
    }

    public ProgressRequestBody(RequestBody requestBody, Callback<T> callback) {
        this.requestBody = requestBody;
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(final Progress progress) {
        HttpUtils.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.request.base.ProgressRequestBody.1
            @Override // java.lang.Runnable
            public void run() {
                if (ProgressRequestBody.this.callback != null) {
                    ProgressRequestBody.this.callback.uploadProgress(progress);
                }
            }
        });
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.requestBody.contentLength();
        } catch (IOException unused) {
            return -1L;
        }
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.requestBody.contentType();
    }

    public void setInterceptor(UploadInterceptor uploadInterceptor) {
        this.interceptor = uploadInterceptor;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink buffer = Okio.buffer(new CountingSink(bufferedSink));
        this.requestBody.writeTo(buffer);
        buffer.flush();
    }
}
