package okhttp3;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Handshake.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Handshake {
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final CipherSuite cipherSuite;

    @NotNull
    private final List<Certificate> localCertificates;

    @NotNull
    private final Lazy peerCertificates$delegate;

    @NotNull
    private final TlsVersion tlsVersion;

    /* compiled from: Handshake.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        private final List<Certificate> toImmutableList(Certificate[] certificateArr) {
            if (certificateArr != null) {
                return Util.immutableListOf((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length));
            }
            return s.j();
        }

        @NotNull
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final Handshake m3640deprecated_get(@NotNull SSLSession sslSession) throws IOException {
            kotlin.jvm.internal.s.i(sslSession, "sslSession");
            return get(sslSession);
        }

        @NotNull
        public final Handshake get(@NotNull SSLSession handshake) throws IOException {
            final List<Certificate> j10;
            kotlin.jvm.internal.s.i(handshake, "$this$handshake");
            String cipherSuite = handshake.getCipherSuite();
            if (cipherSuite != null) {
                int hashCode = cipherSuite.hashCode();
                if (hashCode == 1019404634 ? !cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : !(hashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL"))) {
                    CipherSuite forJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
                    String protocol = handshake.getProtocol();
                    if (protocol != null) {
                        if (!kotlin.jvm.internal.s.d("NONE", protocol)) {
                            TlsVersion forJavaName2 = TlsVersion.Companion.forJavaName(protocol);
                            try {
                                j10 = toImmutableList(handshake.getPeerCertificates());
                            } catch (SSLPeerUnverifiedException unused) {
                                j10 = s.j();
                            }
                            return new Handshake(forJavaName2, forJavaName, toImmutableList(handshake.getLocalCertificates()), new Function0<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$handshake$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                @NotNull
                                public final List<? extends Certificate> invoke() {
                                    return List.this;
                                }
                            });
                        }
                        throw new IOException("tlsVersion == NONE");
                    }
                    throw new IllegalStateException("tlsVersion == null".toString());
                }
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            throw new IllegalStateException("cipherSuite == null".toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Handshake get(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> peerCertificates, @NotNull List<? extends Certificate> localCertificates) {
            kotlin.jvm.internal.s.i(tlsVersion, "tlsVersion");
            kotlin.jvm.internal.s.i(cipherSuite, "cipherSuite");
            kotlin.jvm.internal.s.i(peerCertificates, "peerCertificates");
            kotlin.jvm.internal.s.i(localCertificates, "localCertificates");
            final List immutableList = Util.toImmutableList(peerCertificates);
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(localCertificates), new Function0<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$get$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends Certificate> invoke() {
                    return List.this;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> localCertificates, @NotNull final Function0<? extends List<? extends Certificate>> peerCertificatesFn) {
        kotlin.jvm.internal.s.i(tlsVersion, "tlsVersion");
        kotlin.jvm.internal.s.i(cipherSuite, "cipherSuite");
        kotlin.jvm.internal.s.i(localCertificates, "localCertificates");
        kotlin.jvm.internal.s.i(peerCertificatesFn, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = localCertificates;
        this.peerCertificates$delegate = c.b(new Function0<List<? extends Certificate>>() { // from class: okhttp3.Handshake$peerCertificates$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends Certificate> invoke() {
                try {
                    return (List) Function0.this.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return s.j();
                }
            }
        });
    }

    @NotNull
    public static final Handshake get(@NotNull SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    @NotNull
    public static final Handshake get(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> list, @NotNull List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        kotlin.jvm.internal.s.h(type, "type");
        return type;
    }

    @NotNull
    /* renamed from: -deprecated_cipherSuite, reason: not valid java name */
    public final CipherSuite m3634deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @NotNull
    /* renamed from: -deprecated_localCertificates, reason: not valid java name */
    public final List<Certificate> m3635deprecated_localCertificates() {
        return this.localCertificates;
    }

    @Nullable
    /* renamed from: -deprecated_localPrincipal, reason: not valid java name */
    public final Principal m3636deprecated_localPrincipal() {
        return localPrincipal();
    }

    @NotNull
    /* renamed from: -deprecated_peerCertificates, reason: not valid java name */
    public final List<Certificate> m3637deprecated_peerCertificates() {
        return peerCertificates();
    }

    @Nullable
    /* renamed from: -deprecated_peerPrincipal, reason: not valid java name */
    public final Principal m3638deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @NotNull
    /* renamed from: -deprecated_tlsVersion, reason: not valid java name */
    public final TlsVersion m3639deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @NotNull
    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.tlsVersion == this.tlsVersion && kotlin.jvm.internal.s.d(handshake.cipherSuite, this.cipherSuite) && kotlin.jvm.internal.s.d(handshake.peerCertificates(), peerCertificates()) && kotlin.jvm.internal.s.d(handshake.localCertificates, this.localCertificates)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + peerCertificates().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    @NotNull
    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    @Nullable
    public final Principal localPrincipal() {
        Object V = CollectionsKt___CollectionsKt.V(this.localCertificates);
        if (!(V instanceof X509Certificate)) {
            V = null;
        }
        X509Certificate x509Certificate = (X509Certificate) V;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    @NotNull
    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    @Nullable
    public final Principal peerPrincipal() {
        Object V = CollectionsKt___CollectionsKt.V(peerCertificates());
        if (!(V instanceof X509Certificate)) {
            V = null;
        }
        X509Certificate x509Certificate = (X509Certificate) V;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    @NotNull
    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    @NotNull
    public String toString() {
        List<Certificate> peerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(t.t(peerCertificates, 10));
        Iterator<Certificate> iterator2 = peerCertificates.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(getName(iterator2.next()));
        }
        String obj = arrayList.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Handshake{");
        sb2.append("tlsVersion=");
        sb2.append((Object) this.tlsVersion);
        sb2.append(' ');
        sb2.append("cipherSuite=");
        sb2.append((Object) this.cipherSuite);
        sb2.append(' ');
        sb2.append("peerCertificates=");
        sb2.append(obj);
        sb2.append(' ');
        sb2.append("localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(t.t(list, 10));
        Iterator<Certificate> iterator22 = list.iterator2();
        while (iterator22.hasNext()) {
            arrayList2.add(getName(iterator22.next()));
        }
        sb2.append((Object) arrayList2);
        sb2.append('}');
        return sb2.toString();
    }
}
