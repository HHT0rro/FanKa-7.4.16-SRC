package com.jd.ad.sdk.jad_it;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.alimm.tanx.ui.image.glide.load.data.HttpUrlFetcher;
import com.jd.ad.sdk.jad_it.jad_dq;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_jw implements jad_dq<InputStream> {

    @VisibleForTesting
    public static final jad_bo jad_fs = new jad_an();
    public final com.jd.ad.sdk.jad_oz.jad_jt jad_an;
    public final int jad_bo;
    public HttpURLConnection jad_cp;
    public InputStream jad_dq;
    public volatile boolean jad_er;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_an implements jad_bo {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface jad_bo {
    }

    @VisibleForTesting
    public jad_jw(com.jd.ad.sdk.jad_oz.jad_jt jad_jtVar, int i10, jad_bo jad_boVar) {
        this.jad_an = jad_jtVar;
        this.jad_bo = i10;
    }

    public static int jad_an(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e2) {
            if (!Log.isLoggable(HttpUrlFetcher.TAG, 3)) {
                return -1;
            }
            Logger.d(HttpUrlFetcher.TAG, "Failed to get a response code", e2);
            return -1;
        }
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    @NonNull
    public Class<InputStream> jad_an() {
        return InputStream.class;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    public void jad_an(@NonNull com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar, @NonNull jad_dq.jad_an<? super InputStream> jad_anVar) {
        long jad_an2 = com.jd.ad.sdk.jad_gp.jad_jt.jad_an();
        try {
            try {
                jad_anVar.jad_an((jad_dq.jad_an<? super InputStream>) jad_an(this.jad_an.jad_bo(), 0, null, this.jad_an.jad_bo.jad_an()));
                if (Log.isLoggable(HttpUrlFetcher.TAG, 2)) {
                    StringBuilder jad_an3 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Finished http url fetcher fetch in ");
                    jad_an3.append(com.jd.ad.sdk.jad_gp.jad_jt.jad_an(jad_an2));
                    Logger.v(HttpUrlFetcher.TAG, jad_an3.toString());
                }
            } catch (IOException e2) {
                if (Log.isLoggable(HttpUrlFetcher.TAG, 3)) {
                    Logger.d(HttpUrlFetcher.TAG, "Failed to load data for url", e2);
                }
                jad_anVar.jad_an((Exception) e2);
                if (Log.isLoggable(HttpUrlFetcher.TAG, 2)) {
                    StringBuilder jad_an4 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Finished http url fetcher fetch in ");
                    jad_an4.append(com.jd.ad.sdk.jad_gp.jad_jt.jad_an(jad_an2));
                    Logger.v(HttpUrlFetcher.TAG, jad_an4.toString());
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable(HttpUrlFetcher.TAG, 2)) {
                StringBuilder jad_an5 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Finished http url fetcher fetch in ");
                jad_an5.append(com.jd.ad.sdk.jad_gp.jad_jt.jad_an(jad_an2));
                Logger.v(HttpUrlFetcher.TAG, jad_an5.toString());
            }
            throw th;
        }
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    public void jad_bo() {
        InputStream inputStream = this.jad_dq;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.jad_cp;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.jad_cp = null;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    public void jad_cp() {
        this.jad_er = true;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    @NonNull
    public com.jd.ad.sdk.jad_hs.jad_an jad_dq() {
        return com.jd.ad.sdk.jad_hs.jad_an.REMOTE;
    }

    public final InputStream jad_an(URL url, int i10, URL url2, Map<String, String> map) {
        InputStream inputStream;
        if (i10 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new com.jd.ad.sdk.jad_hs.jad_er("In re-direct loop", -1, null);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setConnectTimeout(this.jad_bo);
                httpURLConnection.setReadTimeout(this.jad_bo);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                this.jad_cp = httpURLConnection;
                try {
                    httpURLConnection.connect();
                    this.jad_dq = this.jad_cp.getInputStream();
                    if (this.jad_er) {
                        return null;
                    }
                    int jad_an2 = jad_an(this.jad_cp);
                    int i11 = jad_an2 / 100;
                    if (i11 == 2) {
                        HttpURLConnection httpURLConnection2 = this.jad_cp;
                        try {
                            if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                                inputStream = new com.jd.ad.sdk.jad_gp.jad_cp(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                            } else {
                                if (Log.isLoggable(HttpUrlFetcher.TAG, 3)) {
                                    Logger.d(HttpUrlFetcher.TAG, "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                                }
                                inputStream = httpURLConnection2.getInputStream();
                            }
                            this.jad_dq = inputStream;
                            return inputStream;
                        } catch (IOException e2) {
                            throw new com.jd.ad.sdk.jad_hs.jad_er("Failed to obtain InputStream", jad_an(httpURLConnection2), e2);
                        }
                    }
                    if (!(i11 == 3)) {
                        if (jad_an2 == -1) {
                            throw new com.jd.ad.sdk.jad_hs.jad_er("Http request failed", jad_an2, null);
                        }
                        try {
                            throw new com.jd.ad.sdk.jad_hs.jad_er(this.jad_cp.getResponseMessage(), jad_an2, null);
                        } catch (IOException e10) {
                            throw new com.jd.ad.sdk.jad_hs.jad_er("Failed to get a response message", jad_an2, e10);
                        }
                    }
                    String headerField = this.jad_cp.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        throw new com.jd.ad.sdk.jad_hs.jad_er("Received empty or null redirect url", jad_an2, null);
                    }
                    try {
                        URL url3 = new URL(url, headerField);
                        jad_bo();
                        return jad_an(url3, i10 + 1, url, map);
                    } catch (MalformedURLException e11) {
                        throw new com.jd.ad.sdk.jad_hs.jad_er("Bad redirect url: " + headerField, jad_an2, e11);
                    }
                } catch (IOException e12) {
                    throw new com.jd.ad.sdk.jad_hs.jad_er("Failed to connect or obtain data", jad_an(this.jad_cp), e12);
                }
            } catch (IOException e13) {
                throw new com.jd.ad.sdk.jad_hs.jad_er("URL.openConnection threw", 0, e13);
            }
        }
        throw new com.jd.ad.sdk.jad_hs.jad_er("Too many (> 5) redirects!", -1, null);
    }
}
