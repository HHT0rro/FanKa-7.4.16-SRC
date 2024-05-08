package com.tencent.cloud.huiyansdkface.okhttp3;

import com.android.internal.logging.nano.MetricsProto;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ConnectionSpec {

    /* renamed from: a, reason: collision with root package name */
    public static final ConnectionSpec f41352a;

    /* renamed from: b, reason: collision with root package name */
    public static final ConnectionSpec f41353b;

    /* renamed from: c, reason: collision with root package name */
    public static final ConnectionSpec f41354c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConnectionSpec f41355d;

    /* renamed from: i, reason: collision with root package name */
    private static final CipherSuite[] f41356i;

    /* renamed from: j, reason: collision with root package name */
    private static final CipherSuite[] f41357j;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f41358e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f41359f;

    /* renamed from: g, reason: collision with root package name */
    public final String[] f41360g;

    /* renamed from: h, reason: collision with root package name */
    public final String[] f41361h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41362a;

        /* renamed from: b, reason: collision with root package name */
        public String[] f41363b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f41364c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f41365d;

        public Builder(ConnectionSpec connectionSpec) {
            this.f41362a = connectionSpec.f41358e;
            this.f41363b = connectionSpec.f41360g;
            this.f41364c = connectionSpec.f41361h;
            this.f41365d = connectionSpec.f41359f;
        }

        public Builder(boolean z10) {
            this.f41362a = z10;
        }

        public Builder allEnabledCipherSuites() {
            if (!this.f41362a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            this.f41363b = null;
            return this;
        }

        public Builder allEnabledTlsVersions() {
            if (!this.f41362a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            this.f41364c = null;
            return this;
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this);
        }

        public Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (!this.f41362a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[cipherSuiteArr.length];
            for (int i10 = 0; i10 < cipherSuiteArr.length; i10++) {
                strArr[i10] = cipherSuiteArr[i10].bq;
            }
            return cipherSuites(strArr);
        }

        public Builder cipherSuites(String... strArr) {
            if (!this.f41362a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f41363b = (String[]) strArr.clone();
            return this;
        }

        public Builder supportsTlsExtensions(boolean z10) {
            if (!this.f41362a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f41365d = z10;
            return this;
        }

        public Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (!this.f41362a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i10 = 0; i10 < tlsVersionArr.length; i10++) {
                strArr[i10] = tlsVersionArr[i10].f41597f;
            }
            return tlsVersions(strArr);
        }

        public Builder tlsVersions(String... strArr) {
            if (!this.f41362a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f41364c = (String[]) strArr.clone();
            return this;
        }
    }

    static {
        CipherSuite cipherSuite = CipherSuite.bl;
        CipherSuite cipherSuite2 = CipherSuite.bm;
        CipherSuite cipherSuite3 = CipherSuite.bn;
        CipherSuite cipherSuite4 = CipherSuite.bo;
        CipherSuite cipherSuite5 = CipherSuite.bp;
        CipherSuite cipherSuite6 = CipherSuite.aX;
        CipherSuite cipherSuite7 = CipherSuite.f41315bb;
        CipherSuite cipherSuite8 = CipherSuite.aY;
        CipherSuite cipherSuite9 = CipherSuite.f41316bc;
        CipherSuite cipherSuite10 = CipherSuite.bi;
        CipherSuite cipherSuite11 = CipherSuite.bh;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11};
        f41356i = cipherSuiteArr;
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11, CipherSuite.aI, CipherSuite.aJ, CipherSuite.ag, CipherSuite.ah, CipherSuite.E, CipherSuite.I, CipherSuite.f41325i};
        f41357j = cipherSuiteArr2;
        Builder cipherSuites = new Builder(true).cipherSuites(cipherSuiteArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        f41352a = cipherSuites.tlsVersions(tlsVersion, tlsVersion2).supportsTlsExtensions(true).build();
        Builder cipherSuites2 = new Builder(true).cipherSuites(cipherSuiteArr2);
        TlsVersion tlsVersion3 = TlsVersion.TLS_1_0;
        f41353b = cipherSuites2.tlsVersions(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, tlsVersion3).supportsTlsExtensions(true).build();
        f41354c = new Builder(true).cipherSuites(cipherSuiteArr2).tlsVersions(tlsVersion3).supportsTlsExtensions(true).build();
        f41355d = new Builder(false).build();
    }

    public ConnectionSpec(Builder builder) {
        this.f41358e = builder.f41362a;
        this.f41360g = builder.f41363b;
        this.f41361h = builder.f41364c;
        this.f41359f = builder.f41365d;
    }

    private ConnectionSpec b(SSLSocket sSLSocket, boolean z10) {
        String[] intersect = this.f41360g != null ? Util.intersect(CipherSuite.f41306a, sSLSocket.getEnabledCipherSuites(), this.f41360g) : sSLSocket.getEnabledCipherSuites();
        String[] intersect2 = this.f41361h != null ? Util.intersect(Util.f41607h, sSLSocket.getEnabledProtocols(), this.f41361h) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int indexOf = Util.indexOf(CipherSuite.f41306a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z10 && indexOf != -1) {
            intersect = Util.concat(intersect, supportedCipherSuites[indexOf]);
        }
        return new Builder(this).cipherSuites(intersect).tlsVersions(intersect2).build();
    }

    public void a(SSLSocket sSLSocket, boolean z10) {
        ConnectionSpec b4 = b(sSLSocket, z10);
        String[] strArr = b4.f41361h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b4.f41360g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List<CipherSuite> cipherSuites() {
        String[] strArr = this.f41360g;
        if (strArr != null) {
            return CipherSuite.a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z10 = this.f41358e;
        if (z10 != connectionSpec.f41358e) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f41360g, connectionSpec.f41360g) && Arrays.equals(this.f41361h, connectionSpec.f41361h) && this.f41359f == connectionSpec.f41359f);
    }

    public int hashCode() {
        if (this.f41358e) {
            return ((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + Arrays.hashCode(this.f41360g)) * 31) + Arrays.hashCode(this.f41361h)) * 31) + (!this.f41359f ? 1 : 0);
        }
        return 17;
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.f41358e) {
            return false;
        }
        String[] strArr = this.f41361h;
        if (strArr != null && !Util.nonEmptyIntersection(Util.f41607h, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f41360g;
        return strArr2 == null || Util.nonEmptyIntersection(CipherSuite.f41306a, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean isTls() {
        return this.f41358e;
    }

    public boolean supportsTlsExtensions() {
        return this.f41359f;
    }

    public List<TlsVersion> tlsVersions() {
        String[] strArr = this.f41361h;
        if (strArr != null) {
            return TlsVersion.a(strArr);
        }
        return null;
    }

    public String toString() {
        if (!this.f41358e) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f41360g != null ? cipherSuites().toString() : "[all enabled]") + ", tlsVersions=" + (this.f41361h != null ? tlsVersions().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f41359f + ")";
    }
}
