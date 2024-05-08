package com.alimm.tanx.ui.image.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GlideUrl {
    public static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    public final Headers headers;
    public String safeStringUrl;
    public URL safeUrl;
    public final String stringUrl;
    public final URL url;

    public GlideUrl(URL url) {
        this(url, Headers.DEFAULT);
    }

    private String getSafeStringUrl() {
        if (TextUtils.isEmpty(this.safeStringUrl)) {
            String str = this.stringUrl;
            if (TextUtils.isEmpty(str)) {
                str = this.url.toString();
            }
            this.safeStringUrl = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        }
        return this.safeStringUrl;
    }

    private URL getSafeUrl() throws MalformedURLException {
        if (this.safeUrl == null) {
            this.safeUrl = new URL(getSafeStringUrl());
        }
        return this.safeUrl;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        return getCacheKey().equals(glideUrl.getCacheKey()) && this.headers.equals(glideUrl.headers);
    }

    public String getCacheKey() {
        String str = this.stringUrl;
        return str != null ? str : this.url.toString();
    }

    public Map<String, String> getHeaders() {
        return this.headers.getHeaders();
    }

    public int hashCode() {
        return this.headers.hashCode() + (getCacheKey().hashCode() * 31);
    }

    public String toString() {
        return getCacheKey() + '\n' + this.headers.toString();
    }

    public String toStringUrl() {
        return getSafeStringUrl();
    }

    public URL toURL() throws MalformedURLException {
        return getSafeUrl();
    }

    public GlideUrl(String str) {
        this(str, Headers.DEFAULT);
    }

    public GlideUrl(URL url, Headers headers) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (headers != null) {
            this.url = url;
            this.stringUrl = null;
            this.headers = headers;
            return;
        }
        throw new IllegalArgumentException("Headers must not be null");
    }

    public GlideUrl(String str, Headers headers) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        }
        if (headers != null) {
            this.stringUrl = str;
            this.url = null;
            this.headers = headers;
            return;
        }
        throw new IllegalArgumentException("Headers must not be null");
    }
}
