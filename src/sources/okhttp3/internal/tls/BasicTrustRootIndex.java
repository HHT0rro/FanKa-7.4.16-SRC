package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BasicTrustRootIndex.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class BasicTrustRootIndex implements TrustRootIndex {
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    public BasicTrustRootIndex(@NotNull X509Certificate... caCerts) {
        s.i(caCerts, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : caCerts) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            s.h(subjectX500Principal, "caCert.subjectX500Principal");
            Object obj = linkedHashMap.get(subjectX500Principal);
            if (obj == null) {
                obj = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, obj);
            }
            ((Set) obj).add(x509Certificate);
        }
        this.subjectToCaCerts = linkedHashMap;
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof BasicTrustRootIndex) && s.d(((BasicTrustRootIndex) obj).subjectToCaCerts, this.subjectToCaCerts));
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    @Nullable
    public X509Certificate findByIssuerAndSignature(@NotNull X509Certificate cert) {
        boolean z10;
        s.i(cert, "cert");
        Set<X509Certificate> set = this.subjectToCaCerts.get(cert.getIssuerX500Principal());
        X509Certificate x509Certificate = null;
        if (set == null) {
            return null;
        }
        Iterator<X509Certificate> iterator2 = set.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            X509Certificate next = iterator2.next();
            try {
                cert.verify(next.getPublicKey());
                z10 = true;
            } catch (Exception unused) {
                z10 = false;
            }
            if (z10) {
                x509Certificate = next;
                break;
            }
        }
        return x509Certificate;
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
