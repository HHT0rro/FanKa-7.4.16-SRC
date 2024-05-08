package com.tencent.cloud.huiyansdkface.okhttp3;

import com.android.internal.logging.nano.MetricsProto;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Handshake {

    /* renamed from: a, reason: collision with root package name */
    private final TlsVersion f41406a;

    /* renamed from: b, reason: collision with root package name */
    private final CipherSuite f41407b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Certificate> f41408c;

    /* renamed from: d, reason: collision with root package name */
    private final List<Certificate> f41409d;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f41406a = tlsVersion;
        this.f41407b = cipherSuite;
        this.f41408c = list;
        this.f41409d = list2;
    }

    public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        Objects.requireNonNull(tlsVersion, "tlsVersion == null");
        Objects.requireNonNull(cipherSuite, "cipherSuite == null");
        return new Handshake(tlsVersion, cipherSuite, Util.immutableList(list), Util.immutableList(list2));
    }

    public static Handshake get(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List immutableList = certificateArr != null ? Util.immutableList(certificateArr) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new Handshake(forJavaName2, forJavaName, immutableList, localCertificates != null ? Util.immutableList(localCertificates) : Collections.emptyList());
    }

    public CipherSuite cipherSuite() {
        return this.f41407b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return this.f41406a.equals(handshake.f41406a) && this.f41407b.equals(handshake.f41407b) && this.f41408c.equals(handshake.f41408c) && this.f41409d.equals(handshake.f41409d);
    }

    public int hashCode() {
        return ((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f41406a.hashCode()) * 31) + this.f41407b.hashCode()) * 31) + this.f41408c.hashCode()) * 31) + this.f41409d.hashCode();
    }

    public List<Certificate> localCertificates() {
        return this.f41409d;
    }

    public Principal localPrincipal() {
        if (this.f41409d.isEmpty()) {
            return null;
        }
        return ((X509Certificate) this.f41409d.get(0)).getSubjectX500Principal();
    }

    public List<Certificate> peerCertificates() {
        return this.f41408c;
    }

    public Principal peerPrincipal() {
        if (this.f41408c.isEmpty()) {
            return null;
        }
        return ((X509Certificate) this.f41408c.get(0)).getSubjectX500Principal();
    }

    public TlsVersion tlsVersion() {
        return this.f41406a;
    }
}
