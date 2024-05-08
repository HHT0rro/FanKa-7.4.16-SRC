package com.tencent.cloud.huiyansdkface.okhttp3;

import android.view.InputDevice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class CipherSuite {
    public final String bq;

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator<String> f41306a = new Comparator<String>() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.CipherSuite.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            for (int i10 = 4; i10 < min; i10++) {
                char charAt = str.charAt(i10);
                char charAt2 = str2.charAt(i10);
                if (charAt != charAt2) {
                    return charAt < charAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    };
    private static final Map<String, CipherSuite> br = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final CipherSuite f41313b = a("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final CipherSuite f41319c = a("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final CipherSuite f41320d = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: e, reason: collision with root package name */
    public static final CipherSuite f41321e = a("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: f, reason: collision with root package name */
    public static final CipherSuite f41322f = a("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: g, reason: collision with root package name */
    public static final CipherSuite f41323g = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: h, reason: collision with root package name */
    public static final CipherSuite f41324h = a("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* renamed from: i, reason: collision with root package name */
    public static final CipherSuite f41325i = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: j, reason: collision with root package name */
    public static final CipherSuite f41326j = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* renamed from: k, reason: collision with root package name */
    public static final CipherSuite f41327k = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* renamed from: l, reason: collision with root package name */
    public static final CipherSuite f41328l = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* renamed from: m, reason: collision with root package name */
    public static final CipherSuite f41329m = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* renamed from: n, reason: collision with root package name */
    public static final CipherSuite f41330n = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* renamed from: o, reason: collision with root package name */
    public static final CipherSuite f41331o = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* renamed from: p, reason: collision with root package name */
    public static final CipherSuite f41332p = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* renamed from: q, reason: collision with root package name */
    public static final CipherSuite f41333q = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* renamed from: r, reason: collision with root package name */
    public static final CipherSuite f41334r = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* renamed from: s, reason: collision with root package name */
    public static final CipherSuite f41335s = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* renamed from: t, reason: collision with root package name */
    public static final CipherSuite f41336t = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* renamed from: u, reason: collision with root package name */
    public static final CipherSuite f41337u = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* renamed from: v, reason: collision with root package name */
    public static final CipherSuite f41338v = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* renamed from: w, reason: collision with root package name */
    public static final CipherSuite f41339w = a("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* renamed from: x, reason: collision with root package name */
    public static final CipherSuite f41340x = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* renamed from: y, reason: collision with root package name */
    public static final CipherSuite f41341y = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* renamed from: z, reason: collision with root package name */
    public static final CipherSuite f41342z = a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final CipherSuite A = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final CipherSuite B = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final CipherSuite C = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final CipherSuite D = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final CipherSuite E = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final CipherSuite F = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final CipherSuite G = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final CipherSuite H = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final CipherSuite I = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final CipherSuite J = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final CipherSuite K = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final CipherSuite L = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final CipherSuite M = a("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final CipherSuite N = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final CipherSuite O = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final CipherSuite P = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final CipherSuite Q = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final CipherSuite R = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final CipherSuite S = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final CipherSuite T = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final CipherSuite U = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final CipherSuite V = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final CipherSuite W = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final CipherSuite X = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final CipherSuite Y = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    public static final CipherSuite Z = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);

    /* renamed from: aa, reason: collision with root package name */
    public static final CipherSuite f41307aa = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* renamed from: ab, reason: collision with root package name */
    public static final CipherSuite f41308ab = a("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* renamed from: ac, reason: collision with root package name */
    public static final CipherSuite f41309ac = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* renamed from: ad, reason: collision with root package name */
    public static final CipherSuite f41310ad = a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* renamed from: ae, reason: collision with root package name */
    public static final CipherSuite f41311ae = a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final CipherSuite af = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final CipherSuite ag = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final CipherSuite ah = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final CipherSuite ai = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    public static final CipherSuite aj = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    public static final CipherSuite ak = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final CipherSuite al = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final CipherSuite am = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    public static final CipherSuite an = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final CipherSuite ao = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final CipherSuite ap = a("TLS_FALLBACK_SCSV", 22016);
    public static final CipherSuite aq = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: ar, reason: collision with root package name */
    public static final CipherSuite f41312ar = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", InputDevice.SOURCE_BLUETOOTH_STYLUS);
    public static final CipherSuite as = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final CipherSuite at = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final CipherSuite au = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final CipherSuite av = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final CipherSuite aw = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final CipherSuite ax = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final CipherSuite ay = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final CipherSuite az = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final CipherSuite aA = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final CipherSuite aB = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final CipherSuite aC = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final CipherSuite aD = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final CipherSuite aE = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final CipherSuite aF = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final CipherSuite aG = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final CipherSuite aH = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final CipherSuite aI = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final CipherSuite aJ = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final CipherSuite aK = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final CipherSuite aL = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final CipherSuite aM = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final CipherSuite aN = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final CipherSuite aO = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final CipherSuite aP = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final CipherSuite aQ = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final CipherSuite aR = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final CipherSuite aS = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final CipherSuite aT = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final CipherSuite aU = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final CipherSuite aV = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final CipherSuite aW = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final CipherSuite aX = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final CipherSuite aY = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final CipherSuite aZ = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: ba, reason: collision with root package name */
    public static final CipherSuite f41314ba = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: bb, reason: collision with root package name */
    public static final CipherSuite f41315bb = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: bc, reason: collision with root package name */
    public static final CipherSuite f41316bc = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: bd, reason: collision with root package name */
    public static final CipherSuite f41317bd = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: be, reason: collision with root package name */
    public static final CipherSuite f41318be = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final CipherSuite bf = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final CipherSuite bg = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final CipherSuite bh = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final CipherSuite bi = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    public static final CipherSuite bj = a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
    public static final CipherSuite bk = a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    public static final CipherSuite bl = a("TLS_AES_128_GCM_SHA256", 4865);
    public static final CipherSuite bm = a("TLS_AES_256_GCM_SHA384", 4866);
    public static final CipherSuite bn = a("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final CipherSuite bo = a("TLS_AES_128_CCM_SHA256", 4868);
    public static final CipherSuite bp = a("TLS_AES_256_CCM_8_SHA256", 4869);

    private CipherSuite(String str) {
        Objects.requireNonNull(str);
        this.bq = str;
    }

    private static CipherSuite a(String str, int i10) {
        CipherSuite cipherSuite = new CipherSuite(str);
        br.put(str, cipherSuite);
        return cipherSuite;
    }

    private static String a(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    public static List<CipherSuite> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(forJavaName(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static synchronized CipherSuite forJavaName(String str) {
        CipherSuite cipherSuite;
        synchronized (CipherSuite.class) {
            Map<String, CipherSuite> map = br;
            cipherSuite = map.get(str);
            if (cipherSuite == null) {
                cipherSuite = map.get(a(str));
                if (cipherSuite == null) {
                    cipherSuite = new CipherSuite(str);
                }
                map.put(str, cipherSuite);
            }
        }
        return cipherSuite;
    }

    public String javaName() {
        return this.bq;
    }

    public String toString() {
        return this.bq;
    }
}
