package sun.security.x509;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.feature.dynamic.f.e;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import sun.security.pkcs.PKCS9Attribute;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: AVA.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class AVAKeyword {
    private String keyword;
    private ObjectIdentifier oid;
    private boolean rfc1779Compliant;
    private boolean rfc2253Compliant;
    private static final Map<ObjectIdentifier, AVAKeyword> oidMap = new HashMap();
    private static final Map<String, AVAKeyword> keywordMap = new HashMap();

    private AVAKeyword(String keyword, ObjectIdentifier oid, boolean rfc1779Compliant, boolean rfc2253Compliant) {
        this.keyword = keyword;
        this.oid = oid;
        this.rfc1779Compliant = rfc1779Compliant;
        this.rfc2253Compliant = rfc2253Compliant;
        oidMap.put(oid, this);
        keywordMap.put(keyword, this);
    }

    private boolean isCompliant(int standard) {
        switch (standard) {
            case 1:
                return true;
            case 2:
                return this.rfc1779Compliant;
            case 3:
                return this.rfc2253Compliant;
            default:
                throw new IllegalArgumentException("Invalid standard " + standard);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectIdentifier getOID(String keyword, int standard, Map<String, String> extraKeywordMap) throws IOException {
        char ch;
        String keyword2 = keyword.toUpperCase(Locale.ENGLISH);
        if (standard == 3) {
            if (keyword2.startsWith(" ") || keyword2.endsWith(" ")) {
                throw new IOException("Invalid leading or trailing space in keyword \"" + keyword2 + "\"");
            }
        } else {
            keyword2 = keyword2.trim();
        }
        String oidString = extraKeywordMap.get(keyword2);
        if (oidString == null) {
            AVAKeyword ak = keywordMap.get(keyword2);
            if (ak != null && ak.isCompliant(standard)) {
                return ak.oid;
            }
            if (standard == 1 && keyword2.startsWith("OID.")) {
                keyword2 = keyword2.substring(4);
            }
            boolean number = false;
            if (keyword2.length() != 0 && (ch = keyword2.charAt(0)) >= '0' && ch <= '9') {
                number = true;
            }
            if (!number) {
                throw new IOException("Invalid keyword \"" + keyword2 + "\"");
            }
            return new ObjectIdentifier(keyword2);
        }
        return new ObjectIdentifier(oidString);
    }

    static String getKeyword(ObjectIdentifier oid, int standard) {
        return getKeyword(oid, standard, Collections.emptyMap());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getKeyword(ObjectIdentifier oid, int standard, Map<String, String> extraOidMap) {
        String oidString = oid.toString();
        String keywordString = extraOidMap.get(oidString);
        if (keywordString == null) {
            AVAKeyword ak = oidMap.get(oid);
            if (ak != null && ak.isCompliant(standard)) {
                return ak.keyword;
            }
            if (standard == 3) {
                return oidString;
            }
            return "OID." + oidString;
        }
        if (keywordString.length() == 0) {
            throw new IllegalArgumentException("keyword cannot be empty");
        }
        String keywordString2 = keywordString.trim();
        char c4 = keywordString2.charAt(0);
        if (c4 < 'A' || c4 > 'z' || (c4 > 'Z' && c4 < 'a')) {
            throw new IllegalArgumentException("keyword does not start with letter");
        }
        for (int i10 = 1; i10 < keywordString2.length(); i10++) {
            char c10 = keywordString2.charAt(i10);
            if ((c10 < 'A' || c10 > 'z' || (c10 > 'Z' && c10 < 'a')) && ((c10 < '0' || c10 > '9') && c10 != '_')) {
                throw new IllegalArgumentException("keyword character is not a letter, digit, or underscore");
            }
        }
        return keywordString2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasKeyword(ObjectIdentifier oid, int standard) {
        AVAKeyword ak = oidMap.get(oid);
        if (ak == null) {
            return false;
        }
        return ak.isCompliant(standard);
    }

    static {
        new AVAKeyword("CN", X500Name.commonName_oid, true, true);
        new AVAKeyword("C", X500Name.countryName_oid, true, true);
        new AVAKeyword("L", X500Name.localityName_oid, true, true);
        new AVAKeyword(ExifInterface.LATITUDE_SOUTH, X500Name.stateName_oid, false, false);
        new AVAKeyword("ST", X500Name.stateName_oid, true, true);
        new AVAKeyword("O", X500Name.orgName_oid, true, true);
        new AVAKeyword(e.f29914d, X500Name.orgUnitName_oid, true, true);
        new AVAKeyword(ExifInterface.GPS_DIRECTION_TRUE, X500Name.title_oid, false, false);
        new AVAKeyword("IP", X500Name.ipAddress_oid, false, false);
        new AVAKeyword("STREET", X500Name.streetAddress_oid, true, true);
        new AVAKeyword("DC", X500Name.DOMAIN_COMPONENT_OID, false, true);
        new AVAKeyword("DNQUALIFIER", X500Name.DNQUALIFIER_OID, false, false);
        new AVAKeyword("DNQ", X500Name.DNQUALIFIER_OID, false, false);
        new AVAKeyword("SURNAME", X500Name.SURNAME_OID, false, false);
        new AVAKeyword("GIVENNAME", X500Name.GIVENNAME_OID, false, false);
        new AVAKeyword("INITIALS", X500Name.INITIALS_OID, false, false);
        new AVAKeyword("GENERATION", X500Name.GENERATIONQUALIFIER_OID, false, false);
        new AVAKeyword("EMAIL", PKCS9Attribute.EMAIL_ADDRESS_OID, false, false);
        new AVAKeyword("EMAILADDRESS", PKCS9Attribute.EMAIL_ADDRESS_OID, false, false);
        new AVAKeyword("UID", X500Name.userid_oid, false, true);
        new AVAKeyword("SERIALNUMBER", X500Name.SERIALNUMBER_OID, false, false);
    }
}
