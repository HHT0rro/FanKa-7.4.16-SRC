package okhttp3;

import com.android.internal.logging.nano.MetricsProto;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.constant.u;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.z;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.p;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CertificatePinner.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final CertificatePinner DEFAULT = new Builder().build();

    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;

    @NotNull
    private final Set<Pin> pins;

    /* compiled from: CertificatePinner.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Builder {

        @NotNull
        private final List<Pin> pins = new ArrayList();

        @NotNull
        public final Builder add(@NotNull String pattern, @NotNull String... pins) {
            s.i(pattern, "pattern");
            s.i(pins, "pins");
            for (String str : pins) {
                this.pins.add(new Pin(pattern, str));
            }
            return this;
        }

        @NotNull
        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt___CollectionsKt.A0(this.pins), null, 2, 0 == true ? 1 : 0);
        }

        @NotNull
        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    /* compiled from: CertificatePinner.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String pin(@NotNull Certificate certificate) {
            s.i(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        @NotNull
        public final ByteString sha1Hash(@NotNull X509Certificate sha1Hash) {
            s.i(sha1Hash, "$this$sha1Hash");
            ByteString.Companion companion = ByteString.Companion;
            PublicKey publicKey = sha1Hash.getPublicKey();
            s.h(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            s.h(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha1();
        }

        @NotNull
        public final ByteString sha256Hash(@NotNull X509Certificate sha256Hash) {
            s.i(sha256Hash, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.Companion;
            PublicKey publicKey = sha256Hash.getPublicKey();
            s.h(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            s.h(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha256();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CertificatePinner.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Pin {

        @NotNull
        private final ByteString hash;

        @NotNull
        private final String hashAlgorithm;

        @NotNull
        private final String pattern;

        public Pin(@NotNull String pattern, @NotNull String pin) {
            s.i(pattern, "pattern");
            s.i(pin, "pin");
            if ((p.F(pattern, "*.", false, 2, null) && StringsKt__StringsKt.X(pattern, StringUtils.NO_PRINT_CODE, 1, false, 4, null) == -1) || (p.F(pattern, "**.", false, 2, null) && StringsKt__StringsKt.X(pattern, StringUtils.NO_PRINT_CODE, 2, false, 4, null) == -1) || StringsKt__StringsKt.X(pattern, StringUtils.NO_PRINT_CODE, 0, false, 6, null) == -1) {
                String canonicalHost = HostnamesKt.toCanonicalHost(pattern);
                if (canonicalHost != null) {
                    this.pattern = canonicalHost;
                    if (p.F(pin, "sha1/", false, 2, null)) {
                        this.hashAlgorithm = "sha1";
                        ByteString.Companion companion = ByteString.Companion;
                        String substring = pin.substring(5);
                        s.h(substring, "(this as java.lang.String).substring(startIndex)");
                        ByteString decodeBase64 = companion.decodeBase64(substring);
                        if (decodeBase64 != null) {
                            this.hash = decodeBase64;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid pin hash: " + pin);
                    }
                    if (p.F(pin, "sha256/", false, 2, null)) {
                        this.hashAlgorithm = ax.aq;
                        ByteString.Companion companion2 = ByteString.Companion;
                        String substring2 = pin.substring(7);
                        s.h(substring2, "(this as java.lang.String).substring(startIndex)");
                        ByteString decodeBase642 = companion2.decodeBase64(substring2);
                        if (decodeBase642 != null) {
                            this.hash = decodeBase642;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid pin hash: " + pin);
                    }
                    throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + pin);
                }
                throw new IllegalArgumentException("Invalid pattern: " + pattern);
            }
            throw new IllegalArgumentException(("Unexpected pattern: " + pattern).toString());
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return ((s.d(this.pattern, pin.pattern) ^ true) || (s.d(this.hashAlgorithm, pin.hashAlgorithm) ^ true) || (s.d(this.hash, pin.hash) ^ true)) ? false : true;
        }

        @NotNull
        public final ByteString getHash() {
            return this.hash;
        }

        @NotNull
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(@NotNull X509Certificate certificate) {
            s.i(certificate, "certificate");
            String str = this.hashAlgorithm;
            int hashCode = str.hashCode();
            if (hashCode != -903629273) {
                if (hashCode == 3528965 && str.equals("sha1")) {
                    return s.d(this.hash, CertificatePinner.Companion.sha1Hash(certificate));
                }
            } else if (str.equals(ax.aq)) {
                return s.d(this.hash, CertificatePinner.Companion.sha256Hash(certificate));
            }
            return false;
        }

        public final boolean matchesHostname(@NotNull String hostname) {
            boolean u10;
            boolean u11;
            s.i(hostname, "hostname");
            if (p.F(this.pattern, "**.", false, 2, null)) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                u11 = p.u(hostname, hostname.length() - length, this.pattern, 3, length, (r12 & 16) != 0 ? false : false);
                if (!u11) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else if (p.F(this.pattern, "*.", false, 2, null)) {
                int length3 = this.pattern.length() - 1;
                int length4 = hostname.length() - length3;
                u10 = p.u(hostname, hostname.length() - length3, this.pattern, 1, length3, (r12 & 16) != 0 ? false : false);
                if (!u10 || StringsKt__StringsKt.c0(hostname, '.', length4 - 1, false, 4, null) != -1) {
                    return false;
                }
            } else {
                return s.d(hostname, this.pattern);
            }
            return true;
        }

        @NotNull
        public String toString() {
            return this.hashAlgorithm + IOUtils.DIR_SEPARATOR_UNIX + this.hash.base64();
        }
    }

    public CertificatePinner(@NotNull Set<Pin> pins, @Nullable CertificateChainCleaner certificateChainCleaner) {
        s.i(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    @NotNull
    public static final String pin(@NotNull Certificate certificate) {
        return Companion.pin(certificate);
    }

    @NotNull
    public static final ByteString sha1Hash(@NotNull X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    @NotNull
    public static final ByteString sha256Hash(@NotNull X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(@NotNull final String hostname, @NotNull final List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        s.i(hostname, "hostname");
        s.i(peerCertificates, "peerCertificates");
        check$okhttp(hostname, new Function0<List<? extends X509Certificate>>() { // from class: okhttp3.CertificatePinner$check$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends X509Certificate> invoke() {
                List<Certificate> list;
                CertificateChainCleaner certificateChainCleaner$okhttp = CertificatePinner.this.getCertificateChainCleaner$okhttp();
                if (certificateChainCleaner$okhttp == null || (list = certificateChainCleaner$okhttp.clean(peerCertificates, hostname)) == null) {
                    list = peerCertificates;
                }
                ArrayList arrayList = new ArrayList(t.t(list, 10));
                for (Certificate certificate : list) {
                    Objects.requireNonNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            }
        });
    }

    public final void check$okhttp(@NotNull String hostname, @NotNull Function0<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) {
        s.i(hostname, "hostname");
        s.i(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<Pin> findMatchingPins = findMatchingPins(hostname);
        if (findMatchingPins.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> invoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : invoke) {
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (Pin pin : findMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                int hashCode = hashAlgorithm.hashCode();
                if (hashCode != -903629273) {
                    if (hashCode == 3528965 && hashAlgorithm.equals("sha1")) {
                        if (byteString2 == null) {
                            byteString2 = Companion.sha1Hash(x509Certificate);
                        }
                        if (s.d(pin.getHash(), byteString2)) {
                            return;
                        }
                    }
                    throw new AssertionError((Object) ("unsupported hashAlgorithm: " + pin.getHashAlgorithm()));
                }
                if (hashAlgorithm.equals(ax.aq)) {
                    if (byteString == null) {
                        byteString = Companion.sha256Hash(x509Certificate);
                    }
                    if (s.d(pin.getHash(), byteString)) {
                        return;
                    }
                } else {
                    throw new AssertionError((Object) ("unsupported hashAlgorithm: " + pin.getHashAlgorithm()));
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Certificate pinning failure!");
        sb2.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : invoke) {
            sb2.append("\n    ");
            sb2.append(Companion.pin(x509Certificate2));
            sb2.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            s.h(subjectDN, "element.subjectDN");
            sb2.append(subjectDN.getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(hostname);
        sb2.append(u.bD);
        for (Pin pin2 : findMatchingPins) {
            sb2.append("\n    ");
            sb2.append((Object) pin2);
        }
        String sb3 = sb2.toString();
        s.h(sb3, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(sb3);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (s.d(certificatePinner.pins, this.pins) && s.d(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<Pin> findMatchingPins(@NotNull String hostname) {
        s.i(hostname, "hostname");
        Set<Pin> set = this.pins;
        List<Pin> j10 = kotlin.collections.s.j();
        for (Pin pin : set) {
            if (pin.matchesHostname(hostname)) {
                if (j10.isEmpty()) {
                    j10 = new ArrayList<>();
                }
                z.c(j10).add(pin);
            }
        }
        return j10;
    }

    @Nullable
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    @NotNull
    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int hashCode = (MetricsProto.MetricsEvent.FIELD_CALLING_UID_HAS_ANY_VISIBLE_WINDOW + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return hashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    @NotNull
    public final CertificatePinner withCertificateChainCleaner$okhttp(@NotNull CertificateChainCleaner certificateChainCleaner) {
        s.i(certificateChainCleaner, "certificateChainCleaner");
        return s.d(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i10 & 2) != 0 ? null : certificateChainCleaner);
    }

    public final void check(@NotNull String hostname, @NotNull Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        s.i(hostname, "hostname");
        s.i(peerCertificates, "peerCertificates");
        check(hostname, m.M(peerCertificates));
    }
}
