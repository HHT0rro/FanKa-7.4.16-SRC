package com.tencent.cloud.huiyansdkface.okhttp3;

import com.alipay.sdk.util.i;
import com.android.internal.logging.nano.MetricsProto;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Address {

    /* renamed from: a, reason: collision with root package name */
    public final HttpUrl f41221a;

    /* renamed from: b, reason: collision with root package name */
    public final Dns f41222b;

    /* renamed from: c, reason: collision with root package name */
    public final SocketFactory f41223c;

    /* renamed from: d, reason: collision with root package name */
    public final Authenticator f41224d;

    /* renamed from: e, reason: collision with root package name */
    public final List<Protocol> f41225e;

    /* renamed from: f, reason: collision with root package name */
    public final List<ConnectionSpec> f41226f;

    /* renamed from: g, reason: collision with root package name */
    public final ProxySelector f41227g;

    /* renamed from: h, reason: collision with root package name */
    public final Proxy f41228h;

    /* renamed from: i, reason: collision with root package name */
    public final SSLSocketFactory f41229i;

    /* renamed from: j, reason: collision with root package name */
    public final HostnameVerifier f41230j;

    /* renamed from: k, reason: collision with root package name */
    public final CertificatePinner f41231k;

    public Address(String str, int i10, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f41221a = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i10).build();
        Objects.requireNonNull(dns, "dns == null");
        this.f41222b = dns;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.f41223c = socketFactory;
        Objects.requireNonNull(authenticator, "proxyAuthenticator == null");
        this.f41224d = authenticator;
        Objects.requireNonNull(list, "protocols == null");
        this.f41225e = Util.immutableList(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f41226f = Util.immutableList(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.f41227g = proxySelector;
        this.f41228h = proxy;
        this.f41229i = sSLSocketFactory;
        this.f41230j = hostnameVerifier;
        this.f41231k = certificatePinner;
    }

    public boolean a(Address address) {
        return this.f41222b.equals(address.f41222b) && this.f41224d.equals(address.f41224d) && this.f41225e.equals(address.f41225e) && this.f41226f.equals(address.f41226f) && this.f41227g.equals(address.f41227g) && Util.equal(this.f41228h, address.f41228h) && Util.equal(this.f41229i, address.f41229i) && Util.equal(this.f41230j, address.f41230j) && Util.equal(this.f41231k, address.f41231k) && url().port() == address.url().port();
    }

    public CertificatePinner certificatePinner() {
        return this.f41231k;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f41226f;
    }

    public Dns dns() {
        return this.f41222b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (this.f41221a.equals(address.f41221a) && a(address)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f41221a.hashCode()) * 31) + this.f41222b.hashCode()) * 31) + this.f41224d.hashCode()) * 31) + this.f41225e.hashCode()) * 31) + this.f41226f.hashCode()) * 31) + this.f41227g.hashCode()) * 31;
        Proxy proxy = this.f41228h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f41229i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f41230j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f41231k;
        return hashCode4 + (certificatePinner != null ? certificatePinner.hashCode() : 0);
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f41230j;
    }

    public List<Protocol> protocols() {
        return this.f41225e;
    }

    public Proxy proxy() {
        return this.f41228h;
    }

    public Authenticator proxyAuthenticator() {
        return this.f41224d;
    }

    public ProxySelector proxySelector() {
        return this.f41227g;
    }

    public SocketFactory socketFactory() {
        return this.f41223c;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f41229i;
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f41221a.host());
        sb2.append(u.bD);
        sb2.append(this.f41221a.port());
        if (this.f41228h != null) {
            sb2.append(", proxy=");
            obj = this.f41228h;
        } else {
            sb2.append(", proxySelector=");
            obj = this.f41227g;
        }
        sb2.append(obj);
        sb2.append(i.f4738d);
        return sb2.toString();
    }

    public HttpUrl url() {
        return this.f41221a;
    }
}
