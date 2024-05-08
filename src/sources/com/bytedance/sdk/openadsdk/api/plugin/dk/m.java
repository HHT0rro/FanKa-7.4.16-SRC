package com.bytedance.sdk.openadsdk.api.plugin.dk;

import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class m implements HostnameVerifier {

    /* renamed from: m, reason: collision with root package name */
    public static final m f11113m = new m();
    private static final Pattern dk = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private m() {
    }

    private boolean dk(String str, X509Certificate x509Certificate) {
        List<String> m10 = m(x509Certificate, 7);
        int size = m10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(m10.get(i10))) {
                return true;
            }
        }
        return false;
    }

    private boolean ej(String str, X509Certificate x509Certificate) {
        String m10;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> m11 = m(x509Certificate, 2);
        int size = m11.size();
        int i10 = 0;
        boolean z10 = false;
        while (i10 < size) {
            if (m(lowerCase, m11.get(i10))) {
                return true;
            }
            i10++;
            z10 = true;
        }
        if (z10 || (m10 = new dk(x509Certificate.getSubjectX500Principal()).m("cn")) == null) {
            return false;
        }
        return m(lowerCase, m10);
    }

    private boolean m(String str, X509Certificate x509Certificate) {
        if (m(str)) {
            return dk(str, x509Certificate);
        }
        return ej(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private static boolean m(String str) {
        return dk.matcher(str).matches();
    }

    private static List<String> m(X509Certificate x509Certificate, int i10) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i10 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private boolean m(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains(StringUtils.NO_PRINT_CODE)) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
