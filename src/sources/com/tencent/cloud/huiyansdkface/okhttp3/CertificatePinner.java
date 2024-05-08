package com.tencent.cloud.huiyansdkface.okhttp3;

import com.android.internal.logging.nano.MetricsProto;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.CertificateChainCleaner;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class CertificatePinner {

    /* renamed from: a, reason: collision with root package name */
    public static final CertificatePinner f41294a = new Builder().build();

    /* renamed from: b, reason: collision with root package name */
    private final CertificatePinProvider f41295b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<Pin> f41296c;

    /* renamed from: d, reason: collision with root package name */
    private final CertificateChainCleaner f41297d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final List<Pin> f41298a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private CertificatePinProvider f41299b;

        public Builder add(String str, String... strArr) {
            Objects.requireNonNull(str, "pattern == null");
            for (String str2 : strArr) {
                this.f41298a.add(new Pin(str, str2));
            }
            return this;
        }

        public CertificatePinner build() {
            return this.f41299b != null ? new CertificatePinner(this.f41299b, (CertificateChainCleaner) null) : new CertificatePinner(new LinkedHashSet(this.f41298a), (CertificateChainCleaner) null);
        }

        public Builder pinProvider(CertificatePinProvider certificatePinProvider) {
            Objects.requireNonNull(certificatePinProvider, "pin provider == null");
            this.f41299b = certificatePinProvider;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface CertificatePinProvider {
        Set<String> getPins(String str);

        void onPinVerifyFailed(String str, List<String> list);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Pin {

        /* renamed from: a, reason: collision with root package name */
        public final String f41300a;

        /* renamed from: b, reason: collision with root package name */
        public final String f41301b;

        /* renamed from: c, reason: collision with root package name */
        public final String f41302c;

        /* renamed from: d, reason: collision with root package name */
        public final ByteString f41303d;

        /* JADX WARN: Removed duplicated region for block: B:12:0x006f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0051  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Pin(java.lang.String r3, java.lang.String r4) {
            /*
                r2 = this;
                r2.<init>()
                r2.f41300a = r3
                java.lang.String r0 = "*."
                boolean r0 = r3.startsWith(r0)
                java.lang.String r1 = "http://"
                if (r0 == 0) goto L2c
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                r1 = 2
            L18:
                java.lang.String r3 = r3.substring(r1)
            L1c:
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl r3 = com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl.get(r3)
                java.lang.String r3 = r3.host()
                goto L47
            L2c:
                java.lang.String r0 = "**."
                boolean r0 = r3.startsWith(r0)
                if (r0 == 0) goto L3e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                r1 = 3
                goto L18
            L3e:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                goto L1c
            L47:
                r2.f41301b = r3
                java.lang.String r3 = "sha1/"
                boolean r0 = r4.startsWith(r3)
                if (r0 == 0) goto L5f
                r2.f41302c = r3
                r3 = 5
            L54:
                java.lang.String r3 = r4.substring(r3)
                com.tencent.cloud.huiyansdkface.okio.ByteString r3 = com.tencent.cloud.huiyansdkface.okio.ByteString.decodeBase64(r3)
                r2.f41303d = r3
                goto L6b
            L5f:
                java.lang.String r3 = "sha256/"
                boolean r0 = r4.startsWith(r3)
                if (r0 == 0) goto L87
                r2.f41302c = r3
                r3 = 7
                goto L54
            L6b:
                com.tencent.cloud.huiyansdkface.okio.ByteString r3 = r2.f41303d
                if (r3 == 0) goto L70
                return
            L70:
                java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "pins must be base64: "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r3.<init>(r4)
                throw r3
            L87:
                java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "pins must start with 'sha256/' or 'sha1/': "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r3.<init>(r4)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner.Pin.<init>(java.lang.String, java.lang.String):void");
        }

        public boolean a(String str) {
            if (this.f41300a.startsWith("**.")) {
                return str.endsWith("." + this.f41301b);
            }
            if (!this.f41300a.startsWith("*.")) {
                return str.equals(this.f41301b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f41301b.length()) {
                String str2 = this.f41301b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                if (this.f41300a.equals(pin.f41300a) && this.f41302c.equals(pin.f41302c) && this.f41303d.equals(pin.f41303d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f41300a.hashCode()) * 31) + this.f41302c.hashCode()) * 31) + this.f41303d.hashCode();
        }

        public String toString() {
            return this.f41302c + this.f41303d.base64();
        }
    }

    public CertificatePinner(CertificatePinProvider certificatePinProvider, CertificateChainCleaner certificateChainCleaner) {
        this.f41295b = certificatePinProvider;
        this.f41296c = new LinkedHashSet();
        this.f41297d = certificateChainCleaner;
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        this.f41296c = set;
        this.f41295b = null;
        this.f41297d = certificateChainCleaner;
    }

    public static ByteString a(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    public static ByteString b(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public static String pin(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + b((X509Certificate) certificate).base64();
    }

    public CertificatePinner a(CertificateChainCleaner certificateChainCleaner) {
        if (Util.equal(this.f41297d, certificateChainCleaner)) {
            return this;
        }
        CertificatePinProvider certificatePinProvider = this.f41295b;
        return certificatePinProvider != null ? new CertificatePinner(certificatePinProvider, certificateChainCleaner) : new CertificatePinner(this.f41296c, certificateChainCleaner);
    }

    public List<Pin> a(String str) {
        HashSet<Pin> hashSet = new HashSet();
        CertificatePinProvider certificatePinProvider = this.f41295b;
        if (certificatePinProvider != null) {
            Set<String> pins = certificatePinProvider.getPins(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<String> iterator2 = pins.iterator2();
            while (iterator2.hasNext()) {
                linkedHashSet.add(new Pin(str, iterator2.next()));
            }
            hashSet.addAll(linkedHashSet);
        }
        hashSet.addAll(this.f41296c);
        List<Pin> emptyList = Collections.emptyList();
        for (Pin pin : hashSet) {
            if (pin.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(pin);
            }
        }
        return emptyList;
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        check(str, list, true);
    }

    public void check(String str, List<Certificate> list, boolean z10) throws SSLPeerUnverifiedException {
        List<Pin> a10 = a(str);
        if (a10.isEmpty()) {
            return;
        }
        CertificateChainCleaner certificateChainCleaner = this.f41297d;
        if (certificateChainCleaner != null && z10) {
            list = certificateChainCleaner.clean(list, str);
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i10);
            int size2 = a10.size();
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (int i11 = 0; i11 < size2; i11++) {
                Pin pin = a10.get(i11);
                if (pin.f41302c.equals("sha256/")) {
                    if (byteString == null) {
                        byteString = b(x509Certificate);
                    }
                    if (pin.f41303d.equals(byteString)) {
                        return;
                    }
                } else {
                    if (!pin.f41302c.equals("sha1/")) {
                        throw new AssertionError((Object) ("unsupported hashAlgorithm: " + pin.f41302c));
                    }
                    if (byteString2 == null) {
                        byteString2 = a(x509Certificate);
                    }
                    if (pin.f41303d.equals(byteString2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Certificate pinning failure!");
        sb2.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i12 = 0; i12 < size3; i12++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i12);
            sb2.append("\n    ");
            sb2.append(pin(x509Certificate2));
            sb2.append(": ");
            sb2.append(x509Certificate2.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(str);
        sb2.append(u.bD);
        ArrayList arrayList = new ArrayList();
        int size4 = a10.size();
        for (int i13 = 0; i13 < size4; i13++) {
            Pin pin2 = a10.get(i13);
            sb2.append("\n    ");
            sb2.append((Object) pin2);
            arrayList.add(pin2.toString());
        }
        CertificatePinProvider certificatePinProvider = this.f41295b;
        if (certificatePinProvider != null) {
            certificatePinProvider.onPinVerifyFailed(str, arrayList);
        }
        throw new SSLPeerUnverifiedException(sb2.toString());
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr));
    }

    public void checkPin(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr), false);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Util.equal(this.f41297d, certificatePinner.f41297d) && this.f41296c.equals(certificatePinner.f41296c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner = this.f41297d;
        return ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31) + this.f41296c.hashCode();
    }
}
