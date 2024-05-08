package com.alimm.tanx.ui.image.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.Priority;
import com.alimm.tanx.ui.image.glide.load.model.GlideUrl;
import com.alimm.tanx.ui.image.glide.util.ContentLengthInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {
    public static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory(null);
    public static final int MAXIMUM_REDIRECTS = 5;
    public static final String TAG = "HttpUrlFetcher";
    public final HttpUrlConnectionFactory connectionFactory;
    public final GlideUrl glideUrl;
    public volatile boolean isCancelled;
    public InputStream stream;
    public HttpURLConnection urlConnection;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        public DefaultHttpUrlConnectionFactory() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection build(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }

        public /* synthetic */ DefaultHttpUrlConnectionFactory(AnonymousClass1 anonymousClass1) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl) {
        HttpUrlConnectionFactory httpUrlConnectionFactory = DEFAULT_CONNECTION_FACTORY;
        this.glideUrl = glideUrl;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.stream = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(TAG, 3)) {
                a.a("Got non empty content encoding: ").append(httpURLConnection.getContentEncoding());
            }
            this.stream = httpURLConnection.getInputStream();
        }
        return this.stream;
    }

    private InputStream loadDataWithRedirects(URL url, int i10, URL url2, Map<String, String> map) throws IOException {
        if (i10 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new IOException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.urlConnection = this.connectionFactory.build(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.urlConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.urlConnection.setConnectTimeout(2500);
            this.urlConnection.setReadTimeout(2500);
            this.urlConnection.setUseCaches(false);
            this.urlConnection.setDoInput(true);
            this.urlConnection.connect();
            if (this.isCancelled) {
                return null;
            }
            int responseCode = this.urlConnection.getResponseCode();
            int i11 = responseCode / 100;
            if (i11 == 2) {
                return getStreamForSuccessfulRequest(this.urlConnection);
            }
            if (i11 == 3) {
                String headerField = this.urlConnection.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    return loadDataWithRedirects(new URL(url, headerField), i10 + 1, url, map);
                }
                throw new IOException("Received empty or null redirect url");
            }
            if (responseCode == -1) {
                throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
            }
            throw new IOException("Request failed " + responseCode + ": " + this.urlConnection.getResponseMessage());
        }
        throw new IOException("Too many (> 5) redirects!");
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public String getId() {
        return this.glideUrl.getCacheKey();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public InputStream loadData(Priority priority) throws Exception {
        return loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders());
    }

    public HttpUrlFetcher(GlideUrl glideUrl, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl;
        this.connectionFactory = httpUrlConnectionFactory;
    }
}
