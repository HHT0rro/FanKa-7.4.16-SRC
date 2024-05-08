package com.alicom.tools.networking;

import android.content.Context;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.HashMap;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SSLFactory {
    private static final String KEY_STORE_CLIENT_PATH = "KEY_STORE_CLIENT_PATH";
    private static final String KEY_STORE_PASSWORD = "KEY_STORE_PASSWORD";
    private static final String KEY_STORE_TRUST_PASSWORD = "KEY_STORE_TRUST_PASSWORD";
    private static final String KEY_STORE_TRUST_PATH = "KEY_STORE_TRUST_PATH";
    private static final String KEY_STORE_TYPE_BKS = "KEY_STORE_TYPE_BKS";
    private static final String KEY_STORE_TYPE_P12 = "KEY_STORE_TYPE_P12";
    private String typeBks = "bks";
    private String typePkcs = "PKCS12";
    private String client = "client.p12";
    private String trust = "client.truststore";
    private String pass = "123456";
    private String trustPass = "123456";

    private SSLContext getSSLContext(Context context) {
        try {
            KeyStore keyStore = KeyStore.getInstance(this.typePkcs);
            KeyStore keyStore2 = KeyStore.getInstance(this.typeBks);
            InputStream open = context.getResources().getAssets().open(this.client);
            InputStream open2 = context.getResources().getAssets().open(this.trust);
            try {
                try {
                    keyStore.load(open, this.pass.toCharArray());
                    keyStore2.load(open2, this.trustPass.toCharArray());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    open.close();
                } catch (Exception unused) {
                }
                try {
                    open2.close();
                } catch (Exception unused2) {
                }
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore2);
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("X509");
                keyManagerFactory.init(keyStore, this.pass.toCharArray());
                sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
                return sSLContext;
            } catch (Throwable th) {
                try {
                    open.close();
                } catch (Exception unused3) {
                }
                try {
                    open2.close();
                    throw th;
                } catch (Exception unused4) {
                    throw th;
                }
            }
        } catch (Exception e10) {
            e10.getMessage();
            return null;
        }
    }

    private void parseAttr(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        if (hashMap.get(KEY_STORE_TYPE_BKS) != null) {
            this.typeBks = hashMap.get(KEY_STORE_TYPE_BKS);
        }
        if (hashMap.get(KEY_STORE_TYPE_P12) != null) {
            this.typePkcs = hashMap.get(KEY_STORE_TYPE_P12);
        }
        if (hashMap.get(KEY_STORE_CLIENT_PATH) != null) {
            this.client = hashMap.get(KEY_STORE_CLIENT_PATH);
        }
        if (hashMap.get(KEY_STORE_TRUST_PATH) != null) {
            this.trust = hashMap.get(KEY_STORE_TRUST_PATH);
        }
        if (hashMap.get(KEY_STORE_PASSWORD) != null) {
            this.pass = hashMap.get(KEY_STORE_PASSWORD);
        }
        if (hashMap.get(KEY_STORE_TRUST_PASSWORD) != null) {
            this.trustPass = hashMap.get(KEY_STORE_TRUST_PASSWORD);
        }
    }
}
