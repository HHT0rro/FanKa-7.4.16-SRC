package okhttp3.internal.tls;

import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.p;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* compiled from: OkHostnameVerifier.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (!isAscii(str)) {
            return str;
        }
        Locale locale = Locale.US;
        s.h(locale, "Locale.US");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(locale);
        s.h(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i10) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && !(!s.d(list.get(0), Integer.valueOf(i10))) && (obj = list.get(1)) != null) {
                        arrayList.add((String) obj);
                    }
                }
                return arrayList;
            }
            return kotlin.collections.s.j();
        } catch (CertificateParsingException unused) {
            return kotlin.collections.s.j();
        }
    }

    private final boolean isAscii(String str) {
        return str.length() == ((int) Utf8.size$default(str, 0, 0, 3, null));
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String asciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<String> iterator2 = subjectAltNames.iterator2();
        while (iterator2.hasNext()) {
            if (INSTANCE.verifyHostname(asciiToLowercase, iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<String> iterator2 = subjectAltNames.iterator2();
        while (iterator2.hasNext()) {
            if (s.d(canonicalHost, HostnamesKt.toCanonicalHost(iterator2.next()))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<String> allSubjectAltNames(@NotNull X509Certificate certificate) {
        s.i(certificate, "certificate");
        return CollectionsKt___CollectionsKt.k0(getSubjectAltNames(certificate, 7), getSubjectAltNames(certificate, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@NotNull String host, @NotNull SSLSession session) {
        Certificate certificate;
        s.i(host, "host");
        s.i(session, "session");
        if (isAscii(host)) {
            try {
                certificate = session.getPeerCertificates()[0];
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
            } catch (SSLException unused) {
                return false;
            }
        }
        return verify(host, (X509Certificate) certificate);
    }

    public final boolean verify(@NotNull String host, @NotNull X509Certificate certificate) {
        s.i(host, "host");
        s.i(certificate, "certificate");
        return Util.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        if (!(str == null || str.length() == 0) && !p.F(str, ".", false, 2, null) && !p.q(str, "..", false, 2, null)) {
            if (!(str2 == null || str2.length() == 0) && !p.F(str2, ".", false, 2, null) && !p.q(str2, "..", false, 2, null)) {
                if (!p.q(str, ".", false, 2, null)) {
                    str = str + ".";
                }
                String str3 = str;
                if (!p.q(str2, ".", false, 2, null)) {
                    str2 = str2 + ".";
                }
                String asciiToLowercase = asciiToLowercase(str2);
                if (!StringsKt__StringsKt.K(asciiToLowercase, StringUtils.NO_PRINT_CODE, false, 2, null)) {
                    return s.d(str3, asciiToLowercase);
                }
                if (!p.F(asciiToLowercase, "*.", false, 2, null) || StringsKt__StringsKt.W(asciiToLowercase, '*', 1, false, 4, null) != -1 || str3.length() < asciiToLowercase.length() || s.d("*.", asciiToLowercase)) {
                    return false;
                }
                String substring = asciiToLowercase.substring(1);
                s.h(substring, "(this as java.lang.String).substring(startIndex)");
                if (!p.q(str3, substring, false, 2, null)) {
                    return false;
                }
                int length = str3.length() - substring.length();
                return length <= 0 || StringsKt__StringsKt.c0(str3, '.', length + (-1), false, 4, null) == -1;
            }
        }
        return false;
    }
}
