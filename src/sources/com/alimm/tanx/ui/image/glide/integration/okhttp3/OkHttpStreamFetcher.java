package com.alimm.tanx.ui.image.glide.integration.okhttp3;

import com.alimm.tanx.ui.image.glide.Priority;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.model.GlideUrl;
import com.alimm.tanx.ui.image.glide.util.ContentLengthInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import nd.a;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class OkHttpStreamFetcher implements DataFetcher<InputStream> {
    public volatile Call call;
    public final Call.Factory client;
    public ResponseBody responseBody;
    public InputStream stream;
    public final GlideUrl url;

    public OkHttpStreamFetcher(Call.Factory factory, GlideUrl glideUrl) {
        this.client = factory;
        this.url = glideUrl;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cleanup() {
        try {
            InputStream inputStream = this.stream;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.responseBody;
        if (responseBody != null) {
            responseBody.close();
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public String getId() {
        return this.url.getCacheKey();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public InputStream loadData(Priority priority) throws Exception {
        Request.Builder url = new Request.Builder().url(this.url.toStringUrl());
        for (Map.Entry<String, String> entry : this.url.getHeaders().entrySet()) {
            url.addHeader(entry.getKey(), entry.getValue());
        }
        this.call = this.client.newCall(url.build());
        Response execute = this.call.execute();
        this.responseBody = execute.body();
        if (execute.isSuccessful()) {
            InputStream obtain = ContentLengthInputStream.obtain(this.responseBody.byteStream(), this.responseBody.contentLength());
            this.stream = obtain;
            return obtain;
        }
        StringBuilder a10 = a.a("Request failed with code: ");
        a10.append(execute.code());
        throw new IOException(a10.toString());
    }
}
