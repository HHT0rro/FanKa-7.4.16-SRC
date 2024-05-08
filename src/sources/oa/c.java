package oa;

import android.text.TextUtils;
import com.huawei.hms.feature.dynamic.f.e;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {
    public static String a(String str, String str2) {
        int indexOf = str.toUpperCase(Locale.getDefault()).indexOf(str2 + "=");
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(",", indexOf);
        int length = indexOf + str2.length() + 1;
        return indexOf2 != -1 ? str.substring(length, indexOf2) : str.substring(length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r6 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0036, code lost:
    
        if (r6 == null) goto L39;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.cert.X509Certificate b(android.content.Context r6) {
        /*
            java.lang.String r0 = "close stream failed"
            java.lang.String r1 = "X509CertUtil"
            r2 = 0
            android.content.res.Resources r6 = r6.getResources()     // Catch: java.lang.Throwable -> L29 java.security.cert.CertificateException -> L2e java.io.IOException -> L3c android.content.res.Resources.NotFoundException -> L47
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch: java.lang.Throwable -> L29 java.security.cert.CertificateException -> L2e java.io.IOException -> L3c android.content.res.Resources.NotFoundException -> L47
            java.lang.String r3 = "ag_sdk_cbg_root.cer"
            java.io.InputStream r6 = r6.open(r3)     // Catch: java.lang.Throwable -> L29 java.security.cert.CertificateException -> L2e java.io.IOException -> L3c android.content.res.Resources.NotFoundException -> L47
            java.lang.String r3 = "X.509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch: java.security.cert.CertificateException -> L2f java.io.IOException -> L3d android.content.res.Resources.NotFoundException -> L48 java.lang.Throwable -> L58
            java.security.cert.Certificate r3 = r3.generateCertificate(r6)     // Catch: java.security.cert.CertificateException -> L2f java.io.IOException -> L3d android.content.res.Resources.NotFoundException -> L48 java.lang.Throwable -> L58
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3     // Catch: java.security.cert.CertificateException -> L2f java.io.IOException -> L3d android.content.res.Resources.NotFoundException -> L48 java.lang.Throwable -> L58
            if (r6 == 0) goto L27
            r6.close()     // Catch: java.io.IOException -> L25
            goto L27
        L25:
            r2 = r3
            goto L52
        L27:
            r2 = r3
            goto L57
        L29:
            r6 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
            goto L59
        L2e:
            r6 = r2
        L2f:
            pa.b r3 = pa.b.f52973b     // Catch: java.lang.Throwable -> L58
            java.lang.String r4 = "CertificateException"
            r3.a(r1, r4)     // Catch: java.lang.Throwable -> L58
            if (r6 == 0) goto L57
        L38:
            r6.close()     // Catch: java.io.IOException -> L52
            goto L57
        L3c:
            r6 = r2
        L3d:
            pa.b r3 = pa.b.f52973b     // Catch: java.lang.Throwable -> L58
            java.lang.String r4 = "can not open cbg root cer"
            r3.a(r1, r4)     // Catch: java.lang.Throwable -> L58
            if (r6 == 0) goto L57
            goto L38
        L47:
            r6 = r2
        L48:
            pa.b r3 = pa.b.f52973b     // Catch: java.lang.Throwable -> L58
            java.lang.String r4 = "can not found cbg root cer"
            r3.a(r1, r4)     // Catch: java.lang.Throwable -> L58
            if (r6 == 0) goto L57
            goto L38
        L52:
            pa.b r6 = pa.b.f52973b
            r6.a(r1, r0)
        L57:
            return r2
        L58:
            r2 = move-exception
        L59:
            if (r6 == 0) goto L64
            r6.close()     // Catch: java.io.IOException -> L5f
            goto L64
        L5f:
            pa.b r6 = pa.b.f52973b
            r6.a(r1, r0)
        L64:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: oa.c.b(android.content.Context):java.security.cert.X509Certificate");
    }

    public static X509Certificate c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d(a.a(str));
    }

    public static X509Certificate d(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                Certificate generateCertificate = CertificateFactory.getInstance(e.f29912b).generateCertificate(new ByteArrayInputStream(bArr));
                if (generateCertificate instanceof X509Certificate) {
                    return (X509Certificate) generateCertificate;
                }
            } catch (CertificateException e2) {
                pa.b.f52973b.a(e.f29911a, "Failed to get cert: " + e2.getMessage());
            }
        }
        return null;
    }

    public static boolean e(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }

    public static boolean f(X509Certificate x509Certificate, String str) {
        return g(x509Certificate, "CN", str);
    }

    public static boolean g(X509Certificate x509Certificate, String str, String str2) {
        if (x509Certificate == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(a(x509Certificate.getSubjectDN().getName(), str));
    }

    public static boolean h(X509Certificate x509Certificate, List<X509Certificate> list) {
        if (list != null && list.size() != 0) {
            if (x509Certificate == null) {
                pa.b.f52973b.a(e.f29911a, "rootCert is null,verify failed ");
                return false;
            }
            try {
                x509Certificate.checkValidity();
                PublicKey publicKey = x509Certificate.getPublicKey();
                for (int size = list.size() - 1; size >= 0; size--) {
                    X509Certificate x509Certificate2 = list.get(size);
                    if (x509Certificate2 != null) {
                        try {
                            x509Certificate2.verify(publicKey);
                            x509Certificate2.checkValidity();
                            publicKey = x509Certificate2.getPublicKey();
                        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e2) {
                            pa.b.f52973b.a(e.f29911a, "verify failed " + e2.getMessage());
                        }
                    }
                    return false;
                }
                return j(list);
            } catch (CertificateExpiredException | CertificateNotYetValidException e10) {
                pa.b.f52973b.a(e.f29911a, "verifyCertChain Exception:" + e10.getMessage());
            }
        }
        return false;
    }

    public static boolean i(X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) {
        if (x509Certificate == null || bArr == null || bArr2 == null || bArr2.length == 0) {
            pa.b.f52973b.d(e.f29911a, "checkSignature parameter is null");
            return false;
        }
        try {
            Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
            signature.initVerify(x509Certificate.getPublicKey());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e2) {
            pa.b.f52973b.b(e.f29911a, "failed checkSignature,Exception:", e2);
            return false;
        }
    }

    public static boolean j(List<X509Certificate> list) {
        for (int i10 = 1; i10 < list.size(); i10++) {
            if (!e(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static List<X509Certificate> k(String str) {
        return l(n(str));
    }

    public static List<X509Certificate> l(List<String> list) {
        if (list == null) {
            pa.b.f52973b.d(e.f29911a, "base64 CertChain is null.");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            X509Certificate c4 = c(iterator2.next());
            if (c4 == null) {
                pa.b.f52973b.a(e.f29911a, "Failed to get cert from CertChain");
            } else {
                arrayList.add(c4);
            }
        }
        return arrayList;
    }

    public static boolean m(X509Certificate x509Certificate, String str) {
        return g(x509Certificate, e.f29914d, str);
    }

    public static List<String> n(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 1) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                arrayList.add(jSONArray.getString(i10));
            }
            return arrayList;
        } catch (JSONException e2) {
            pa.b.f52973b.a(e.f29911a, "Failed to getCertChain: " + e2.getMessage());
            return Collections.emptyList();
        }
    }
}
