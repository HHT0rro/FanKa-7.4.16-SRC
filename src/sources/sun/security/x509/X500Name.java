package sun.security.x509;

import io.flutter.plugins.imagepicker.ImagePickerDelegate;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.Principal;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X500Name implements GeneralNameInterface, Principal {
    private static final int[] DNQUALIFIER_DATA;
    public static final ObjectIdentifier DNQUALIFIER_OID;
    private static final int[] DOMAIN_COMPONENT_DATA;
    public static final ObjectIdentifier DOMAIN_COMPONENT_OID;
    private static final int[] GENERATIONQUALIFIER_DATA;
    public static final ObjectIdentifier GENERATIONQUALIFIER_OID;
    private static final int[] GIVENNAME_DATA;
    public static final ObjectIdentifier GIVENNAME_OID;
    private static final int[] INITIALS_DATA;
    public static final ObjectIdentifier INITIALS_OID;
    private static final int[] SERIALNUMBER_DATA;
    public static final ObjectIdentifier SERIALNUMBER_OID;
    private static final int[] SURNAME_DATA;
    public static final ObjectIdentifier SURNAME_OID;
    private static final int[] commonName_data;
    public static final ObjectIdentifier commonName_oid;
    private static final int[] countryName_data;
    public static final ObjectIdentifier countryName_oid;
    private static final Map<ObjectIdentifier, ObjectIdentifier> internedOIDs = new HashMap();
    private static final int[] ipAddress_data;
    public static final ObjectIdentifier ipAddress_oid;
    private static final int[] localityName_data;
    public static final ObjectIdentifier localityName_oid;
    private static final int[] orgName_data;
    public static final ObjectIdentifier orgName_oid;
    private static final int[] orgUnitName_data;
    public static final ObjectIdentifier orgUnitName_oid;
    private static final Constructor<X500Principal> principalConstructor;
    private static final Field principalField;
    private static final int[] stateName_data;
    public static final ObjectIdentifier stateName_oid;
    private static final int[] streetAddress_data;
    public static final ObjectIdentifier streetAddress_oid;
    private static final int[] title_data;
    public static final ObjectIdentifier title_oid;
    private static final int[] userid_data;
    public static final ObjectIdentifier userid_oid;
    private volatile List<AVA> allAvaList;
    private String canonicalDn;
    private String dn;
    private byte[] encoded;
    private RDN[] names;
    private volatile List<RDN> rdnList;
    private String rfc1779Dn;
    private String rfc2253Dn;
    private X500Principal x500Principal;

    public X500Name(String dname) throws IOException {
        this(dname, (Map<String, String>) Collections.emptyMap());
    }

    public X500Name(String dname, Map<String, String> keywordMap) throws IOException {
        parseDN(dname, keywordMap);
    }

    public X500Name(String dname, String format) throws IOException {
        if (dname == null) {
            throw new NullPointerException("Name must not be null");
        }
        if (format.equalsIgnoreCase(X500Principal.RFC2253)) {
            parseRFC2253DN(dname);
        } else {
            if (format.equalsIgnoreCase("DEFAULT")) {
                parseDN(dname, Collections.emptyMap());
                return;
            }
            throw new IOException("Unsupported format " + format);
        }
    }

    public X500Name(String commonName, String organizationUnit, String organizationName, String country) throws IOException {
        RDN[] rdnArr = new RDN[4];
        this.names = rdnArr;
        rdnArr[3] = new RDN(1);
        this.names[3].assertion[0] = new AVA(commonName_oid, new DerValue(commonName));
        this.names[2] = new RDN(1);
        this.names[2].assertion[0] = new AVA(orgUnitName_oid, new DerValue(organizationUnit));
        this.names[1] = new RDN(1);
        this.names[1].assertion[0] = new AVA(orgName_oid, new DerValue(organizationName));
        this.names[0] = new RDN(1);
        this.names[0].assertion[0] = new AVA(countryName_oid, new DerValue(country));
    }

    public X500Name(String commonName, String organizationUnit, String organizationName, String localityName, String stateName, String country) throws IOException {
        RDN[] rdnArr = new RDN[6];
        this.names = rdnArr;
        rdnArr[5] = new RDN(1);
        this.names[5].assertion[0] = new AVA(commonName_oid, new DerValue(commonName));
        this.names[4] = new RDN(1);
        this.names[4].assertion[0] = new AVA(orgUnitName_oid, new DerValue(organizationUnit));
        this.names[3] = new RDN(1);
        this.names[3].assertion[0] = new AVA(orgName_oid, new DerValue(organizationName));
        this.names[2] = new RDN(1);
        this.names[2].assertion[0] = new AVA(localityName_oid, new DerValue(localityName));
        this.names[1] = new RDN(1);
        this.names[1].assertion[0] = new AVA(stateName_oid, new DerValue(stateName));
        this.names[0] = new RDN(1);
        this.names[0].assertion[0] = new AVA(countryName_oid, new DerValue(country));
    }

    public X500Name(RDN[] rdnArray) throws IOException {
        if (rdnArray == null) {
            this.names = new RDN[0];
            return;
        }
        this.names = (RDN[]) rdnArray.clone();
        int i10 = 0;
        while (true) {
            RDN[] rdnArr = this.names;
            if (i10 < rdnArr.length) {
                if (rdnArr[i10] != null) {
                    i10++;
                } else {
                    throw new IOException("Cannot create an X500Name");
                }
            } else {
                return;
            }
        }
    }

    public X500Name(DerValue value) throws IOException {
        this(value.toDerInputStream());
    }

    public X500Name(DerInputStream in) throws IOException {
        parseDER(in);
    }

    public X500Name(byte[] name) throws IOException {
        DerInputStream in = new DerInputStream(name);
        parseDER(in);
    }

    public List<RDN> rdns() {
        List<RDN> list = this.rdnList;
        if (list == null) {
            List<RDN> list2 = Collections.unmodifiableList(Arrays.asList(this.names));
            this.rdnList = list2;
            return list2;
        }
        return list;
    }

    public int size() {
        return this.names.length;
    }

    public List<AVA> allAvas() {
        List<AVA> list = this.allAvaList;
        if (list == null) {
            List<AVA> list2 = new ArrayList<>();
            int i10 = 0;
            while (true) {
                RDN[] rdnArr = this.names;
                if (i10 < rdnArr.length) {
                    list2.addAll(rdnArr[i10].avas());
                    i10++;
                } else {
                    List<AVA> list3 = Collections.unmodifiableList(list2);
                    this.allAvaList = list3;
                    return list3;
                }
            }
        } else {
            return list;
        }
    }

    public int avaSize() {
        return allAvas().size();
    }

    public boolean isEmpty() {
        int n10 = this.names.length;
        for (int i10 = 0; i10 < n10; i10++) {
            if (this.names[i10].assertion.length != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // java.security.Principal
    public int hashCode() {
        return getRFC2253CanonicalName().hashCode();
    }

    @Override // java.security.Principal
    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X500Name)) {
            return false;
        }
        X500Name other = (X500Name) obj;
        String str2 = this.canonicalDn;
        if (str2 != null && (str = other.canonicalDn) != null) {
            return str2.equals(str);
        }
        int n10 = this.names.length;
        if (n10 != other.names.length) {
            return false;
        }
        for (int i10 = 0; i10 < n10; i10++) {
            RDN r12 = this.names[i10];
            RDN r22 = other.names[i10];
            if (r12.assertion.length != r22.assertion.length) {
                return false;
            }
        }
        String thisCanonical = getRFC2253CanonicalName();
        String otherCanonical = other.getRFC2253CanonicalName();
        return thisCanonical.equals(otherCanonical);
    }

    private String getString(DerValue attribute) throws IOException {
        if (attribute == null) {
            return null;
        }
        String value = attribute.getAsString();
        if (value == null) {
            throw new IOException("not a DER string encoding, " + ((int) attribute.tag));
        }
        return value;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int getType() {
        return 4;
    }

    public String getCountry() throws IOException {
        DerValue attr = findAttribute(countryName_oid);
        return getString(attr);
    }

    public String getOrganization() throws IOException {
        DerValue attr = findAttribute(orgName_oid);
        return getString(attr);
    }

    public String getOrganizationalUnit() throws IOException {
        DerValue attr = findAttribute(orgUnitName_oid);
        return getString(attr);
    }

    public String getCommonName() throws IOException {
        DerValue attr = findAttribute(commonName_oid);
        return getString(attr);
    }

    public String getLocality() throws IOException {
        DerValue attr = findAttribute(localityName_oid);
        return getString(attr);
    }

    public String getState() throws IOException {
        DerValue attr = findAttribute(stateName_oid);
        return getString(attr);
    }

    public String getDomain() throws IOException {
        DerValue attr = findAttribute(DOMAIN_COMPONENT_OID);
        return getString(attr);
    }

    public String getDNQualifier() throws IOException {
        DerValue attr = findAttribute(DNQUALIFIER_OID);
        return getString(attr);
    }

    public String getSurname() throws IOException {
        DerValue attr = findAttribute(SURNAME_OID);
        return getString(attr);
    }

    public String getGivenName() throws IOException {
        DerValue attr = findAttribute(GIVENNAME_OID);
        return getString(attr);
    }

    public String getInitials() throws IOException {
        DerValue attr = findAttribute(INITIALS_OID);
        return getString(attr);
    }

    public String getGeneration() throws IOException {
        DerValue attr = findAttribute(GENERATIONQUALIFIER_OID);
        return getString(attr);
    }

    public String getIP() throws IOException {
        DerValue attr = findAttribute(ipAddress_oid);
        return getString(attr);
    }

    @Override // java.security.Principal
    public String toString() {
        if (this.dn == null) {
            generateDN();
        }
        return this.dn;
    }

    public String getRFC1779Name() {
        return getRFC1779Name(Collections.emptyMap());
    }

    public String getRFC1779Name(Map<String, String> oidMap) throws IllegalArgumentException {
        if (oidMap.isEmpty()) {
            String str = this.rfc1779Dn;
            if (str != null) {
                return str;
            }
            String generateRFC1779DN = generateRFC1779DN(oidMap);
            this.rfc1779Dn = generateRFC1779DN;
            return generateRFC1779DN;
        }
        return generateRFC1779DN(oidMap);
    }

    public String getRFC2253Name() {
        return getRFC2253Name(Collections.emptyMap());
    }

    public String getRFC2253Name(Map<String, String> oidMap) {
        if (oidMap.isEmpty()) {
            String str = this.rfc2253Dn;
            if (str != null) {
                return str;
            }
            String generateRFC2253DN = generateRFC2253DN(oidMap);
            this.rfc2253Dn = generateRFC2253DN;
            return generateRFC2253DN;
        }
        return generateRFC2253DN(oidMap);
    }

    private String generateRFC2253DN(Map<String, String> oidMap) {
        if (this.names.length == 0) {
            return "";
        }
        StringBuilder fullname = new StringBuilder(48);
        for (int i10 = this.names.length - 1; i10 >= 0; i10--) {
            if (i10 < this.names.length - 1) {
                fullname.append(',');
            }
            fullname.append(this.names[i10].toRFC2253String(oidMap));
        }
        return fullname.toString();
    }

    public String getRFC2253CanonicalName() {
        String str = this.canonicalDn;
        if (str != null) {
            return str;
        }
        if (this.names.length == 0) {
            this.canonicalDn = "";
            return "";
        }
        StringBuilder fullname = new StringBuilder(48);
        for (int i10 = this.names.length - 1; i10 >= 0; i10--) {
            if (i10 < this.names.length - 1) {
                fullname.append(',');
            }
            fullname.append(this.names[i10].toRFC2253String(true));
        }
        String sb2 = fullname.toString();
        this.canonicalDn = sb2;
        return sb2;
    }

    @Override // java.security.Principal
    public String getName() {
        return toString();
    }

    private DerValue findAttribute(ObjectIdentifier attribute) {
        if (this.names != null) {
            int i10 = 0;
            while (true) {
                RDN[] rdnArr = this.names;
                if (i10 < rdnArr.length) {
                    DerValue value = rdnArr[i10].findAttribute(attribute);
                    if (value == null) {
                        i10++;
                    } else {
                        return value;
                    }
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    public DerValue findMostSpecificAttribute(ObjectIdentifier attribute) {
        RDN[] rdnArr = this.names;
        if (rdnArr != null) {
            for (int i10 = rdnArr.length - 1; i10 >= 0; i10--) {
                DerValue value = this.names[i10].findAttribute(attribute);
                if (value != null) {
                    return value;
                }
            }
            return null;
        }
        return null;
    }

    private void parseDER(DerInputStream in) throws IOException {
        DerValue[] nameseq;
        byte[] derBytes = in.toByteArray();
        try {
            nameseq = in.getSequence(5);
        } catch (IOException e2) {
            if (derBytes == null) {
                nameseq = null;
            } else {
                DerValue derVal = new DerValue((byte) 48, derBytes);
                nameseq = new DerInputStream(derVal.toByteArray()).getSequence(5);
            }
        }
        if (nameseq == null) {
            this.names = new RDN[0];
            return;
        }
        this.names = new RDN[nameseq.length];
        for (int i10 = 0; i10 < nameseq.length; i10++) {
            this.names[i10] = new RDN(nameseq[i10]);
        }
    }

    @Deprecated
    public void emit(DerOutputStream out) throws IOException {
        encode(out);
    }

    @Override // sun.security.x509.GeneralNameInterface
    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        int i10 = 0;
        while (true) {
            RDN[] rdnArr = this.names;
            if (i10 < rdnArr.length) {
                rdnArr[i10].encode(tmp);
                i10++;
            } else {
                out.write((byte) 48, tmp);
                return;
            }
        }
    }

    public byte[] getEncodedInternal() throws IOException {
        if (this.encoded == null) {
            DerOutputStream out = new DerOutputStream();
            DerOutputStream tmp = new DerOutputStream();
            int i10 = 0;
            while (true) {
                RDN[] rdnArr = this.names;
                if (i10 >= rdnArr.length) {
                    break;
                }
                rdnArr[i10].encode(tmp);
                i10++;
            }
            out.write((byte) 48, tmp);
            this.encoded = out.toByteArray();
        }
        return this.encoded;
    }

    public byte[] getEncoded() throws IOException {
        return (byte[]) getEncodedInternal().clone();
    }

    private void parseDN(String input, Map<String, String> keywordMap) throws IOException {
        int rdnEnd;
        if (input == null || input.length() == 0) {
            this.names = new RDN[0];
            return;
        }
        checkNoNewLinesNorTabsAtBeginningOfDN(input);
        List<RDN> dnVector = new ArrayList<>();
        int dnOffset = 0;
        int quoteCount = 0;
        int searchOffset = 0;
        int nextComma = input.indexOf(44);
        int nextSemiColon = input.indexOf(59);
        while (true) {
            if (nextComma >= 0 || nextSemiColon >= 0) {
                if (nextSemiColon < 0) {
                    rdnEnd = nextComma;
                } else if (nextComma < 0) {
                    rdnEnd = nextSemiColon;
                } else {
                    rdnEnd = Math.min(nextComma, nextSemiColon);
                }
                quoteCount += countQuotes(input, searchOffset, rdnEnd);
                if (rdnEnd >= 0 && quoteCount != 1 && !escaped(rdnEnd, searchOffset, input)) {
                    String rdnString = input.substring(dnOffset, rdnEnd);
                    RDN rdn = new RDN(rdnString, keywordMap);
                    dnVector.add(rdn);
                    dnOffset = rdnEnd + 1;
                    quoteCount = 0;
                }
                searchOffset = rdnEnd + 1;
                nextComma = input.indexOf(44, searchOffset);
                nextSemiColon = input.indexOf(59, searchOffset);
            } else {
                String rdnString2 = input.substring(dnOffset);
                RDN rdn2 = new RDN(rdnString2, keywordMap);
                dnVector.add(rdn2);
                Collections.reverse(dnVector);
                this.names = (RDN[]) dnVector.toArray(new RDN[dnVector.size()]);
                return;
            }
        }
    }

    private void checkNoNewLinesNorTabsAtBeginningOfDN(String input) {
        for (int i10 = 0; i10 < input.length(); i10++) {
            char c4 = input.charAt(i10);
            if (c4 != ' ') {
                if (c4 == '\t' || c4 == '\n') {
                    throw new IllegalArgumentException("DN cannot start with newline nor tab");
                }
                return;
            }
        }
    }

    private void parseRFC2253DN(String dnString) throws IOException {
        if (dnString.length() == 0) {
            this.names = new RDN[0];
            return;
        }
        List<RDN> dnVector = new ArrayList<>();
        int dnOffset = 0;
        int searchOffset = 0;
        int rdnEnd = dnString.indexOf(44);
        while (rdnEnd >= 0) {
            if (rdnEnd > 0 && !escaped(rdnEnd, searchOffset, dnString)) {
                String rdnString = dnString.substring(dnOffset, rdnEnd);
                RDN rdn = new RDN(rdnString, X500Principal.RFC2253);
                dnVector.add(rdn);
                dnOffset = rdnEnd + 1;
            }
            searchOffset = rdnEnd + 1;
            rdnEnd = dnString.indexOf(44, searchOffset);
        }
        String rdnString2 = dnString.substring(dnOffset);
        RDN rdn2 = new RDN(rdnString2, X500Principal.RFC2253);
        dnVector.add(rdn2);
        Collections.reverse(dnVector);
        this.names = (RDN[]) dnVector.toArray(new RDN[dnVector.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int countQuotes(String string, int from, int to) {
        int count = 0;
        int escape = 0;
        for (int i10 = from; i10 < to; i10++) {
            if (string.charAt(i10) == '\"' && escape % 2 == 0) {
                count++;
            }
            escape = string.charAt(i10) == '\\' ? escape + 1 : 0;
        }
        return count;
    }

    private static boolean escaped(int rdnEnd, int searchOffset, String dnString) {
        if (rdnEnd == 1 && dnString.charAt(rdnEnd - 1) == '\\') {
            return true;
        }
        if (rdnEnd > 1 && dnString.charAt(rdnEnd - 1) == '\\' && dnString.charAt(rdnEnd - 2) != '\\') {
            return true;
        }
        if (rdnEnd <= 1 || dnString.charAt(rdnEnd - 1) != '\\' || dnString.charAt(rdnEnd - 2) != '\\') {
            return false;
        }
        int count = 0;
        for (int rdnEnd2 = rdnEnd - 1; rdnEnd2 >= searchOffset; rdnEnd2--) {
            if (dnString.charAt(rdnEnd2) == '\\') {
                count++;
            }
        }
        return count % 2 != 0;
    }

    private void generateDN() {
        RDN[] rdnArr = this.names;
        if (rdnArr.length == 1) {
            this.dn = rdnArr[0].toString();
            return;
        }
        StringBuilder sb2 = new StringBuilder(48);
        RDN[] rdnArr2 = this.names;
        if (rdnArr2 != null) {
            for (int i10 = rdnArr2.length - 1; i10 >= 0; i10--) {
                if (i10 != this.names.length - 1) {
                    sb2.append(", ");
                }
                sb2.append(this.names[i10].toString());
            }
        }
        this.dn = sb2.toString();
    }

    private String generateRFC1779DN(Map<String, String> oidMap) {
        RDN[] rdnArr = this.names;
        if (rdnArr.length == 1) {
            return rdnArr[0].toRFC1779String(oidMap);
        }
        StringBuilder sb2 = new StringBuilder(48);
        RDN[] rdnArr2 = this.names;
        if (rdnArr2 != null) {
            for (int i10 = rdnArr2.length - 1; i10 >= 0; i10--) {
                if (i10 != this.names.length - 1) {
                    sb2.append(", ");
                }
                sb2.append(this.names[i10].toRFC1779String(oidMap));
            }
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectIdentifier intern(ObjectIdentifier oid) {
        ObjectIdentifier interned = internedOIDs.putIfAbsent(oid, oid);
        return interned == null ? oid : interned;
    }

    static {
        int[] iArr = {2, 5, 4, 3};
        commonName_data = iArr;
        int[] iArr2 = {2, 5, 4, 4};
        SURNAME_DATA = iArr2;
        int[] iArr3 = {2, 5, 4, 5};
        SERIALNUMBER_DATA = iArr3;
        int[] iArr4 = {2, 5, 4, 6};
        countryName_data = iArr4;
        int[] iArr5 = {2, 5, 4, 7};
        localityName_data = iArr5;
        int[] iArr6 = {2, 5, 4, 8};
        stateName_data = iArr6;
        int[] iArr7 = {2, 5, 4, 9};
        streetAddress_data = iArr7;
        int[] iArr8 = {2, 5, 4, 10};
        orgName_data = iArr8;
        int[] iArr9 = {2, 5, 4, 11};
        orgUnitName_data = iArr9;
        int[] iArr10 = {2, 5, 4, 12};
        title_data = iArr10;
        int[] iArr11 = {2, 5, 4, 42};
        GIVENNAME_DATA = iArr11;
        int[] iArr12 = {2, 5, 4, 43};
        INITIALS_DATA = iArr12;
        int[] iArr13 = {2, 5, 4, 44};
        GENERATIONQUALIFIER_DATA = iArr13;
        int[] iArr14 = {2, 5, 4, 46};
        DNQUALIFIER_DATA = iArr14;
        int[] iArr15 = {1, 3, 6, 1, 4, 1, 42, 2, 11, 2, 1};
        ipAddress_data = iArr15;
        int[] iArr16 = {0, 9, ImagePickerDelegate.REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY, 19200300, 100, 1, 25};
        DOMAIN_COMPONENT_DATA = iArr16;
        int[] iArr17 = {0, 9, ImagePickerDelegate.REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY, 19200300, 100, 1, 1};
        userid_data = iArr17;
        commonName_oid = intern(ObjectIdentifier.newInternal(iArr));
        SERIALNUMBER_OID = intern(ObjectIdentifier.newInternal(iArr3));
        countryName_oid = intern(ObjectIdentifier.newInternal(iArr4));
        localityName_oid = intern(ObjectIdentifier.newInternal(iArr5));
        orgName_oid = intern(ObjectIdentifier.newInternal(iArr8));
        orgUnitName_oid = intern(ObjectIdentifier.newInternal(iArr9));
        stateName_oid = intern(ObjectIdentifier.newInternal(iArr6));
        streetAddress_oid = intern(ObjectIdentifier.newInternal(iArr7));
        title_oid = intern(ObjectIdentifier.newInternal(iArr10));
        DNQUALIFIER_OID = intern(ObjectIdentifier.newInternal(iArr14));
        SURNAME_OID = intern(ObjectIdentifier.newInternal(iArr2));
        GIVENNAME_OID = intern(ObjectIdentifier.newInternal(iArr11));
        INITIALS_OID = intern(ObjectIdentifier.newInternal(iArr12));
        GENERATIONQUALIFIER_OID = intern(ObjectIdentifier.newInternal(iArr13));
        ipAddress_oid = intern(ObjectIdentifier.newInternal(iArr15));
        DOMAIN_COMPONENT_OID = intern(ObjectIdentifier.newInternal(iArr16));
        userid_oid = intern(ObjectIdentifier.newInternal(iArr17));
        PrivilegedExceptionAction<Object[]> pa2 = new PrivilegedExceptionAction<Object[]>() { // from class: sun.security.x509.X500Name.1
            @Override // java.security.PrivilegedExceptionAction
            public Object[] run() throws Exception {
                Class<?>[] args = {X500Name.class};
                Constructor<X500Principal> cons = X500Principal.class.getDeclaredConstructor(args);
                cons.setAccessible(true);
                Field field = X500Principal.class.getDeclaredField("thisX500Name");
                field.setAccessible(true);
                return new Object[]{cons, field};
            }
        };
        try {
            Object[] result = (Object[]) AccessController.doPrivileged(pa2);
            Constructor<X500Principal> constr = (Constructor) result[0];
            principalConstructor = constr;
            principalField = (Field) result[1];
        } catch (Exception e2) {
            throw new InternalError("Could not obtain X500Principal access", e2);
        }
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int constrains(GeneralNameInterface inputName) throws UnsupportedOperationException {
        if (inputName == null) {
            return -1;
        }
        int constraintType = inputName.getType();
        if (constraintType != 4) {
            return -1;
        }
        X500Name inputX500 = (X500Name) inputName;
        if (inputX500.equals(this)) {
            return 0;
        }
        if (inputX500.names.length == 0) {
            return 2;
        }
        if (this.names.length != 0 && !inputX500.isWithinSubtree(this)) {
            if (isWithinSubtree(inputX500)) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    private boolean isWithinSubtree(X500Name other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        RDN[] rdnArr = other.names;
        if (rdnArr.length == 0) {
            return true;
        }
        RDN[] rdnArr2 = this.names;
        if (rdnArr2.length == 0 || rdnArr2.length < rdnArr.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            RDN[] rdnArr3 = other.names;
            if (i10 >= rdnArr3.length) {
                return true;
            }
            if (!this.names[i10].equals(rdnArr3[i10])) {
                return false;
            }
            i10++;
        }
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int subtreeDepth() throws UnsupportedOperationException {
        return this.names.length;
    }

    public X500Name commonAncestor(X500Name other) {
        if (other == null) {
            return null;
        }
        int otherLen = other.names.length;
        int thisLen = this.names.length;
        if (thisLen == 0 || otherLen == 0) {
            return null;
        }
        int minLen = thisLen < otherLen ? thisLen : otherLen;
        int i10 = 0;
        while (true) {
            if (i10 >= minLen) {
                break;
            }
            if (this.names[i10].equals(other.names[i10])) {
                i10++;
            } else if (i10 == 0) {
                return null;
            }
        }
        RDN[] ancestor = new RDN[i10];
        for (int j10 = 0; j10 < i10; j10++) {
            ancestor[j10] = this.names[j10];
        }
        try {
            X500Name commonAncestor = new X500Name(ancestor);
            return commonAncestor;
        } catch (IOException e2) {
            return null;
        }
    }

    public X500Principal asX500Principal() {
        if (this.x500Principal == null) {
            try {
                Object[] args = {this};
                this.x500Principal = principalConstructor.newInstance(args);
            } catch (Exception e2) {
                throw new RuntimeException("Unexpected exception", e2);
            }
        }
        return this.x500Principal;
    }

    public static X500Name asX500Name(X500Principal p10) {
        try {
            X500Name name = (X500Name) principalField.get(p10);
            name.x500Principal = p10;
            return name;
        } catch (Exception e2) {
            throw new RuntimeException("Unexpected exception", e2);
        }
    }
}
