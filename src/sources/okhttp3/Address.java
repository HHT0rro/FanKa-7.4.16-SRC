package okhttp3;

import com.alipay.sdk.util.i;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.android.internal.logging.nano.MetricsProto;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.d;
import kotlin.jvm.internal.s;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Address.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Address {

    @Nullable
    private final CertificatePinner certificatePinner;

    @NotNull
    private final List<ConnectionSpec> connectionSpecs;

    @NotNull
    private final Dns dns;

    @Nullable
    private final HostnameVerifier hostnameVerifier;

    @NotNull
    private final List<Protocol> protocols;

    @Nullable
    private final Proxy proxy;

    @NotNull
    private final Authenticator proxyAuthenticator;

    @NotNull
    private final ProxySelector proxySelector;

    @NotNull
    private final SocketFactory socketFactory;

    @Nullable
    private final SSLSocketFactory sslSocketFactory;

    @NotNull
    private final HttpUrl url;

    public Address(@NotNull String uriHost, int i10, @NotNull Dns dns, @NotNull SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable CertificatePinner certificatePinner, @NotNull Authenticator proxyAuthenticator, @Nullable Proxy proxy, @NotNull List<? extends Protocol> protocols, @NotNull List<ConnectionSpec> connectionSpecs, @NotNull ProxySelector proxySelector) {
        s.i(uriHost, "uriHost");
        s.i(dns, "dns");
        s.i(socketFactory, "socketFactory");
        s.i(proxyAuthenticator, "proxyAuthenticator");
        s.i(protocols, "protocols");
        s.i(connectionSpecs, "connectionSpecs");
        s.i(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(uriHost).port(i10).build();
        this.protocols = Util.toImmutableList(protocols);
        this.connectionSpecs = Util.toImmutableList(connectionSpecs);
    }

    @Nullable
    /* renamed from: -deprecated_certificatePinner, reason: not valid java name */
    public final CertificatePinner m3593deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @NotNull
    /* renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m3594deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @NotNull
    /* renamed from: -deprecated_dns, reason: not valid java name */
    public final Dns m3595deprecated_dns() {
        return this.dns;
    }

    @Nullable
    /* renamed from: -deprecated_hostnameVerifier, reason: not valid java name */
    public final HostnameVerifier m3596deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @NotNull
    /* renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m3597deprecated_protocols() {
        return this.protocols;
    }

    @Nullable
    /* renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m3598deprecated_proxy() {
        return this.proxy;
    }

    @NotNull
    /* renamed from: -deprecated_proxyAuthenticator, reason: not valid java name */
    public final Authenticator m3599deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @NotNull
    /* renamed from: -deprecated_proxySelector, reason: not valid java name */
    public final ProxySelector m3600deprecated_proxySelector() {
        return this.proxySelector;
    }

    @NotNull
    /* renamed from: -deprecated_socketFactory, reason: not valid java name */
    public final SocketFactory m3601deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Nullable
    /* renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m3602deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @NotNull
    /* renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m3603deprecated_url() {
        return this.url;
    }

    @Nullable
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @NotNull
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @NotNull
    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (s.d(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(@NotNull Address that) {
        s.i(that, "that");
        return s.d(this.dns, that.dns) && s.d(this.proxyAuthenticator, that.proxyAuthenticator) && s.d(this.protocols, that.protocols) && s.d(this.connectionSpecs, that.connectionSpecs) && s.d(this.proxySelector, that.proxySelector) && s.d(this.proxy, that.proxy) && s.d(this.sslSocketFactory, that.sslSocketFactory) && s.d(this.hostnameVerifier, that.hostnameVerifier) && s.d(this.certificatePinner, that.certificatePinner) && this.url.port() == that.url.port();
    }

    public int hashCode() {
        return ((((((((((((((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    @Nullable
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @NotNull
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @Nullable
    public final Proxy proxy() {
        return this.proxy;
    }

    @NotNull
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @NotNull
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @NotNull
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @Nullable
    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2;
        Object obj;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Address{");
        sb3.append(this.url.host());
        sb3.append(ShortcutConstants.SERVICES_SEPARATOR);
        sb3.append(this.url.port());
        sb3.append(", ");
        if (this.proxy != null) {
            sb2 = new StringBuilder();
            sb2.append("proxy=");
            obj = this.proxy;
        } else {
            sb2 = new StringBuilder();
            sb2.append("proxySelector=");
            obj = this.proxySelector;
        }
        sb2.append(obj);
        sb3.append(sb2.toString());
        sb3.append(i.f4738d);
        return sb3.toString();
    }

    @NotNull
    public final HttpUrl url() {
        return this.url;
    }
}
