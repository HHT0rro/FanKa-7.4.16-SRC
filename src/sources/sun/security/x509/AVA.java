package sun.security.x509;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.security.AccessController;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import sun.security.action.GetBooleanAction;
import sun.security.pkcs.PKCS9Attribute;
import sun.security.util.Debug;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AVA implements DerEncoder {
    static final int DEFAULT = 1;
    static final int RFC1779 = 2;
    static final int RFC2253 = 3;
    private static final String escapedDefault = ",+<>;\"";
    private static final String hexDigits = "0123456789ABCDEF";
    private static final String specialChars1779 = ",=\n+<>#;\\\"";
    private static final String specialChars2253 = ",=+<>#;\\\"";
    private static final String specialCharsDefault = ",=\n+<>#;\\\" ";
    final ObjectIdentifier oid;
    final DerValue value;
    private static final Debug debug = Debug.getInstance(X509CertImpl.NAME, "\t[AVA]");
    private static final boolean PRESERVE_OLD_DC_ENCODING = ((Boolean) AccessController.doPrivileged(new GetBooleanAction("com.sun.security.preserveOldDCEncoding"))).booleanValue();

    public AVA(ObjectIdentifier type, DerValue val) {
        if (type == null || val == null) {
            throw new NullPointerException();
        }
        this.oid = type;
        this.value = val;
    }

    AVA(Reader in) throws IOException {
        this(in, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AVA(Reader in, Map<String, String> keywordMap) throws IOException {
        this(in, 1, keywordMap);
    }

    AVA(Reader in, int format) throws IOException {
        this(in, format, Collections.emptyMap());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AVA(Reader in, int format, Map<String, String> keywordMap) throws IOException {
        int c4;
        StringBuilder temp = new StringBuilder();
        while (true) {
            int c10 = readChar(in, "Incorrect AVA format");
            if (c10 == 61) {
                break;
            } else {
                temp.append((char) c10);
            }
        }
        this.oid = AVAKeyword.getOID(temp.toString(), format, keywordMap);
        temp.setLength(0);
        if (format != 3) {
            while (true) {
                c4 = in.read();
                if (c4 != 32 && c4 != 10) {
                    break;
                }
            }
        } else {
            c4 = in.read();
            if (c4 == 32) {
                throw new IOException("Incorrect AVA RFC2253 format - leading space must be escaped");
            }
        }
        if (c4 == -1) {
            this.value = new DerValue("");
            return;
        }
        if (c4 == 35) {
            this.value = parseHexString(in, format);
        } else if (c4 == 34 && format != 3) {
            this.value = parseQuotedString(in, temp);
        } else {
            this.value = parseString(in, c4, format, temp);
        }
    }

    public ObjectIdentifier getObjectIdentifier() {
        return this.oid;
    }

    public DerValue getDerValue() {
        return this.value;
    }

    public String getValueString() {
        try {
            String s2 = this.value.getAsString();
            if (s2 == null) {
                throw new RuntimeException("AVA string is null");
            }
            return s2;
        } catch (IOException e2) {
            throw new RuntimeException("AVA error: " + ((Object) e2), e2);
        }
    }

    private static DerValue parseHexString(Reader in, int format) throws IOException {
        int c4;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte b4 = 0;
        int cNdx = 0;
        while (true) {
            c4 = in.read();
            if (isTerminator(c4, format)) {
                break;
            }
            if (c4 == 32 || c4 == 10) {
                break;
            }
            int cVal = hexDigits.indexOf(Character.toUpperCase((char) c4));
            if (cVal == -1) {
                throw new IOException("AVA parse, invalid hex digit: " + ((char) c4));
            }
            if (cNdx % 2 == 1) {
                b4 = (byte) ((b4 * 16) + ((byte) cVal));
                baos.write(b4);
            } else {
                b4 = (byte) cVal;
            }
            cNdx++;
        }
        do {
            if (c4 != 32 && c4 != 10) {
                throw new IOException("AVA parse, invalid hex digit: " + ((char) c4));
            }
            c4 = in.read();
        } while (!isTerminator(c4, format));
        if (cNdx == 0) {
            throw new IOException("AVA parse, zero hex digits");
        }
        if (cNdx % 2 == 1) {
            throw new IOException("AVA parse, odd number of hex digits");
        }
        return new DerValue(baos.toByteArray());
    }

    private DerValue parseQuotedString(Reader in, StringBuilder temp) throws IOException {
        int c4;
        int c10 = readChar(in, "Quoted string did not end in quote");
        List<Byte> embeddedHex = new ArrayList<>();
        boolean isPrintableString = true;
        while (c10 != 34) {
            if (c10 == 92) {
                c10 = readChar(in, "Quoted string did not end in quote");
                Byte hexByte = getEmbeddedHexPair(c10, in);
                if (hexByte != null) {
                    isPrintableString = false;
                    embeddedHex.add(hexByte);
                    c10 = in.read();
                } else if (specialChars1779.indexOf((char) c10) < 0) {
                    throw new IOException("Invalid escaped character in AVA: " + ((char) c10));
                }
            }
            if (embeddedHex.size() > 0) {
                String hexString = getEmbeddedHexString(embeddedHex);
                temp.append(hexString);
                embeddedHex.clear();
            }
            isPrintableString &= DerValue.isPrintableStringChar((char) c10);
            temp.append((char) c10);
            c10 = readChar(in, "Quoted string did not end in quote");
        }
        if (embeddedHex.size() > 0) {
            String hexString2 = getEmbeddedHexString(embeddedHex);
            temp.append(hexString2);
            embeddedHex.clear();
        }
        while (true) {
            c4 = in.read();
            if (c4 != 10 && c4 != 32) {
                break;
            }
        }
        if (c4 != -1) {
            throw new IOException("AVA had characters other than whitespace after terminating quote");
        }
        if (this.oid.equals((Object) PKCS9Attribute.EMAIL_ADDRESS_OID) || (this.oid.equals((Object) X500Name.DOMAIN_COMPONENT_OID) && !PRESERVE_OLD_DC_ENCODING)) {
            return new DerValue((byte) 22, temp.toString());
        }
        if (isPrintableString) {
            return new DerValue(temp.toString());
        }
        return new DerValue((byte) 12, temp.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x017e A[LOOP:0: B:2:0x0017->B:9:0x017e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private sun.security.util.DerValue parseString(java.io.Reader r17, int r18, int r19, java.lang.StringBuilder r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.x509.AVA.parseString(java.io.Reader, int, int, java.lang.StringBuilder):sun.security.util.DerValue");
    }

    private static Byte getEmbeddedHexPair(int c12, Reader in) throws IOException {
        if (hexDigits.indexOf(Character.toUpperCase((char) c12)) >= 0) {
            int c22 = readChar(in, "unexpected EOF - escaped hex value must include two valid digits");
            if (hexDigits.indexOf(Character.toUpperCase((char) c22)) >= 0) {
                int hi = Character.digit((char) c12, 16);
                int lo = Character.digit((char) c22, 16);
                return new Byte((byte) ((hi << 4) + lo));
            }
            throw new IOException("escaped hex value must include two valid digits");
        }
        return null;
    }

    private static String getEmbeddedHexString(List<Byte> hexList) throws IOException {
        int n10 = hexList.size();
        byte[] hexBytes = new byte[n10];
        for (int i10 = 0; i10 < n10; i10++) {
            hexBytes[i10] = hexList.get(i10).byteValue();
        }
        return new String(hexBytes, "UTF8");
    }

    private static boolean isTerminator(int ch, int format) {
        switch (ch) {
            case -1:
            case 43:
            case 44:
                return true;
            case 59:
                return format != 3;
            default:
                return false;
        }
    }

    private static int readChar(Reader in, String errMsg) throws IOException {
        int c4 = in.read();
        if (c4 == -1) {
            throw new IOException(errMsg);
        }
        return c4;
    }

    private static boolean trailingSpace(Reader in) throws IOException {
        boolean trailing;
        if (!in.markSupported()) {
            return true;
        }
        in.mark(9999);
        while (true) {
            int nextChar = in.read();
            if (nextChar == -1) {
                trailing = true;
                break;
            }
            if (nextChar != 32) {
                if (nextChar == 92) {
                    int followingChar = in.read();
                    if (followingChar != 32) {
                        trailing = false;
                        break;
                    }
                } else {
                    trailing = false;
                    break;
                }
            }
        }
        in.reset();
        return trailing;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AVA(DerValue derval) throws IOException {
        if (derval.tag != 48) {
            throw new IOException("AVA not a sequence");
        }
        this.oid = X500Name.intern(derval.data.getOID());
        this.value = derval.data.getDerValue();
        if (derval.data.available() != 0) {
            throw new IOException("AVA, extra bytes = " + derval.data.available());
        }
    }

    AVA(DerInputStream in) throws IOException {
        this(in.getDerValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AVA)) {
            return false;
        }
        AVA other = (AVA) obj;
        return toRFC2253CanonicalString().equals(other.toRFC2253CanonicalString());
    }

    public int hashCode() {
        return toRFC2253CanonicalString().hashCode();
    }

    public void encode(DerOutputStream out) throws IOException {
        derEncode(out);
    }

    @Override // sun.security.util.DerEncoder
    public void derEncode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        DerOutputStream tmp2 = new DerOutputStream();
        tmp.putOID(this.oid);
        this.value.encode(tmp);
        tmp2.write((byte) 48, tmp);
        out.write(tmp2.toByteArray());
    }

    private String toKeyword(int format, Map<String, String> oidMap) {
        return AVAKeyword.getKeyword(this.oid, format, oidMap);
    }

    public String toString() {
        return toKeywordValueString(toKeyword(1, Collections.emptyMap()));
    }

    public String toRFC1779String() {
        return toRFC1779String(Collections.emptyMap());
    }

    public String toRFC1779String(Map<String, String> oidMap) {
        return toKeywordValueString(toKeyword(2, oidMap));
    }

    public String toRFC2253String() {
        return toRFC2253String(Collections.emptyMap());
    }

    public String toRFC2253String(Map<String, String> oidMap) {
        StringBuilder typeAndValue = new StringBuilder(100);
        typeAndValue.append(toKeyword(3, oidMap));
        typeAndValue.append('=');
        if ((typeAndValue.charAt(0) >= '0' && typeAndValue.charAt(0) <= '9') || !isDerString(this.value, false)) {
            try {
                byte[] data = this.value.toByteArray();
                typeAndValue.append('#');
                for (byte b4 : data) {
                    typeAndValue.append(Character.forDigit((b4 >>> 4) & 15, 16));
                    typeAndValue.append(Character.forDigit(b4 & 15, 16));
                }
            } catch (IOException e2) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        } else {
            try {
                String valStr = new String(this.value.getDataBytes(), "UTF8");
                StringBuilder sbuffer = new StringBuilder();
                for (int i10 = 0; i10 < valStr.length(); i10++) {
                    char c4 = valStr.charAt(i10);
                    if (DerValue.isPrintableStringChar(c4) || ",=+<>#;\"\\".indexOf(c4) >= 0) {
                        if (",=+<>#;\"\\".indexOf(c4) >= 0) {
                            sbuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                        }
                        sbuffer.append(c4);
                    } else if (c4 == 0) {
                        sbuffer.append("\\00");
                    } else if (debug != null && Debug.isOn("ava")) {
                        try {
                            byte[] valueBytes = Character.toString(c4).getBytes("UTF8");
                            for (int j10 = 0; j10 < valueBytes.length; j10++) {
                                sbuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                                char hexChar = Character.forDigit((valueBytes[j10] >>> 4) & 15, 16);
                                sbuffer.append(Character.toUpperCase(hexChar));
                                char hexChar2 = Character.forDigit(valueBytes[j10] & 15, 16);
                                sbuffer.append(Character.toUpperCase(hexChar2));
                            }
                        } catch (IOException e10) {
                            throw new IllegalArgumentException("DER Value conversion");
                        }
                    } else {
                        sbuffer.append(c4);
                    }
                }
                char[] chars = sbuffer.toString().toCharArray();
                StringBuilder sbuffer2 = new StringBuilder();
                int lead = 0;
                while (lead < chars.length && (chars[lead] == ' ' || chars[lead] == '\r')) {
                    lead++;
                }
                int trail = chars.length - 1;
                while (trail >= 0 && (chars[trail] == ' ' || chars[trail] == '\r')) {
                    trail--;
                }
                for (int i11 = 0; i11 < chars.length; i11++) {
                    char c10 = chars[i11];
                    if (i11 < lead || i11 > trail) {
                        sbuffer2.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    }
                    sbuffer2.append(c10);
                }
                typeAndValue.append(sbuffer2.toString());
            } catch (IOException e11) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        }
        return typeAndValue.toString();
    }

    public String toRFC2253CanonicalString() {
        StringBuilder typeAndValue = new StringBuilder(40);
        typeAndValue.append(toKeyword(3, Collections.emptyMap()));
        typeAndValue.append('=');
        if ((typeAndValue.charAt(0) >= '0' && typeAndValue.charAt(0) <= '9') || (!isDerString(this.value, true) && this.value.tag != 20)) {
            try {
                byte[] data = this.value.toByteArray();
                typeAndValue.append('#');
                for (byte b4 : data) {
                    typeAndValue.append(Character.forDigit((b4 >>> 4) & 15, 16));
                    typeAndValue.append(Character.forDigit(b4 & 15, 16));
                }
            } catch (IOException e2) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        } else {
            try {
                String valStr = new String(this.value.getDataBytes(), "UTF8");
                StringBuilder sbuffer = new StringBuilder();
                boolean previousWhite = false;
                for (int i10 = 0; i10 < valStr.length(); i10++) {
                    char c4 = valStr.charAt(i10);
                    if (DerValue.isPrintableStringChar(c4) || ",+<>;\"\\".indexOf(c4) >= 0 || (i10 == 0 && c4 == '#')) {
                        if ((i10 == 0 && c4 == '#') || ",+<>;\"\\".indexOf(c4) >= 0) {
                            sbuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                        }
                        if (!Character.isWhitespace(c4)) {
                            previousWhite = false;
                            sbuffer.append(c4);
                        } else if (!previousWhite) {
                            previousWhite = true;
                            sbuffer.append(c4);
                        }
                    } else if (debug != null && Debug.isOn("ava")) {
                        previousWhite = false;
                        try {
                            byte[] valueBytes = Character.toString(c4).getBytes("UTF8");
                            for (int j10 = 0; j10 < valueBytes.length; j10++) {
                                sbuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                                sbuffer.append(Character.forDigit((valueBytes[j10] >>> 4) & 15, 16));
                                sbuffer.append(Character.forDigit(valueBytes[j10] & 15, 16));
                            }
                        } catch (IOException e10) {
                            throw new IllegalArgumentException("DER Value conversion");
                        }
                    } else {
                        previousWhite = false;
                        sbuffer.append(c4);
                    }
                }
                typeAndValue.append(sbuffer.toString().trim());
            } catch (IOException e11) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        }
        String canon = typeAndValue.toString();
        return Normalizer.normalize(canon.toUpperCase(Locale.US).toLowerCase(Locale.US), Normalizer.Form.NFKD);
    }

    private static boolean isDerString(DerValue value, boolean canonical) {
        if (canonical) {
            switch (value.tag) {
                case 12:
                case 19:
                    return true;
                default:
                    return false;
            }
        }
        switch (value.tag) {
            case 12:
            case 19:
            case 20:
            case 22:
            case 27:
            case 30:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasRFC2253Keyword() {
        return AVAKeyword.hasKeyword(this.oid, 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00fb, code lost:
    
        if (r14 != 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fd, code lost:
    
        if (r12 == ' ') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0101, code lost:
    
        if (r12 == '\n') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0109, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0107, code lost:
    
        if (",+=\n<>#;\\\"".indexOf(r12) < 0) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String toKeywordValueString(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.x509.AVA.toKeywordValueString(java.lang.String):java.lang.String");
    }
}
