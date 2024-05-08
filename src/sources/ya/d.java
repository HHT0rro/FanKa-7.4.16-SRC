package ya;

import com.alibaba.security.biometrics.build.al;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import za.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f54700a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f54701b;

    static {
        String[] strArr = {"ac", "co", "com", al.aZ, "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        f54701b = strArr;
        Arrays.sort(strArr);
    }

    public static final void a(String str, X509Certificate x509Certificate, boolean z10) throws SSLException {
        String[] d10 = d(x509Certificate);
        String[] f10 = f(x509Certificate);
        f.b("", "cn is : " + Arrays.toString(d10));
        f.b("", "san is : " + Arrays.toString(f10));
        b(str, d10, f10, z10);
    }

    public static final void b(String str, String[] strArr, String[] strArr2, boolean z10) throws SSLException {
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0 && strArr[0] != null) {
            linkedList.add(strArr[0]);
        }
        if (strArr2 != null) {
            for (String str2 : strArr2) {
                if (str2 != null) {
                    linkedList.add(str2);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            Iterator<E> it = linkedList.iterator2();
            boolean z11 = false;
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
                stringBuffer.append(" <");
                stringBuffer.append(lowerCase2);
                stringBuffer.append('>');
                if (it.hasNext()) {
                    stringBuffer.append(" OR");
                }
                if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && c(lowerCase2) && !g(str)) {
                    boolean endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                    if (endsWith && z10) {
                        z11 = e(lowerCase) == e(lowerCase2);
                    } else {
                        z11 = endsWith;
                    }
                } else {
                    z11 = lowerCase.equals(lowerCase2);
                }
                if (z11) {
                    break;
                }
            }
            if (z11) {
                return;
            }
            throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) stringBuffer));
        }
        throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
    }

    public static boolean c(String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i10 = length - 3;
        if (str.charAt(i10) == '.') {
            return Arrays.binarySearch(f54701b, str.substring(2, i10)) < 0;
        }
        return true;
    }

    public static String[] d(X509Certificate x509Certificate) {
        List<String> d10 = new c(x509Certificate.getSubjectX500Principal()).d("cn");
        if (d10.isEmpty()) {
            return null;
        }
        String[] strArr = new String[d10.size()];
        d10.toArray(strArr);
        return strArr;
    }

    public static int e(String str) {
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (str.charAt(i11) == '.') {
                i10++;
            }
        }
        return i10;
    }

    public static String[] f(X509Certificate x509Certificate) {
        Collection<List<?>> collection;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e2) {
            f.c("", "Error parsing certificate.", e2);
            collection = null;
        }
        if (collection != null) {
            for (List<?> list : collection) {
                if (((Integer) list.get(0)).intValue() == 2) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    public static boolean g(String str) {
        return f54700a.matcher(str).matches();
    }
}
