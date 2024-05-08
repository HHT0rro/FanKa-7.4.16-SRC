package com.huawei.appgallery.agd.serverreq.http;

import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import xa.c;
import xa.d;
import ya.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SafeHttpsSetting {
    public HostnameVerifier getHostnameVerifier() {
        return new a();
    }

    public SSLSocketFactory getSSLSocketFactory() {
        try {
            return c.b(ApplicationWrapper.getInstance().getContext());
        } catch (Exception e2) {
            throw new AssertionError(e2);
        }
    }

    public X509TrustManager getX509TrustManager() {
        try {
            return d.a(ApplicationWrapper.getInstance().getContext());
        } catch (Exception e2) {
            throw new AssertionError(e2);
        }
    }
}
