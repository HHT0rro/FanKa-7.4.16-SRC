package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.c;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements com.kwad.framework.filedownloader.a.b {
    public URLConnection afi;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private Proxy afj;
        private Integer afk;
        private Integer afl;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b implements c.b {
        private final a afm;

        public b() {
            this(null);
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b be(String str) {
            return new c(str, this.afm);
        }

        private b(a aVar) {
            this.afm = null;
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.afi.addRequestProperty(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String bd(String str) {
        return this.afi.getHeaderField(str);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() {
        this.afi.connect();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() {
        return ((j) ServiceProvider.get(j.class)).wrapInputStream(this.afi.getInputStream());
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() {
        URLConnection uRLConnection = this.afi;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return 0;
        }
        try {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> vc() {
        return this.afi.getRequestProperties();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> vd() {
        return this.afi.getHeaderFields();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void ve() {
    }

    private c(URL url, a aVar) {
        if (aVar != null && aVar.afj != null) {
            this.afi = url.openConnection(aVar.afj);
        } else {
            this.afi = url.openConnection();
        }
        try {
            TLSConnectionUtils.wrapHttpURLConnection(this.afi);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            if (aVar.afk != null) {
                this.afi.setReadTimeout(aVar.afk.intValue());
            }
            if (aVar.afl != null) {
                this.afi.setConnectTimeout(aVar.afl.intValue());
            }
        }
    }
}
