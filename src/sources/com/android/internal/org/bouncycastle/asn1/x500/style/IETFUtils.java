package com.android.internal.org.bouncycastle.asn1.x500.style;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1String;
import com.android.internal.org.bouncycastle.asn1.DERUniversalString;
import com.android.internal.org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import com.android.internal.org.bouncycastle.asn1.x500.RDN;
import com.android.internal.org.bouncycastle.asn1.x500.X500NameBuilder;
import com.android.internal.org.bouncycastle.asn1.x500.X500NameStyle;
import com.android.internal.org.bouncycastle.util.Strings;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class IETFUtils {
    private static String unescape(String elt) {
        if (elt.length() == 0 || (elt.indexOf(92) < 0 && elt.indexOf(34) < 0)) {
            return elt.trim();
        }
        char[] elts = elt.toCharArray();
        boolean escaped = false;
        boolean quoted = false;
        StringBuffer buf = new StringBuffer(elt.length());
        int start = 0;
        if (elts[0] == '\\' && elts[1] == '#') {
            start = 2;
            buf.append("\\#");
        }
        boolean nonWhiteSpaceEncountered = false;
        int lastEscaped = 0;
        char hex1 = 0;
        for (int i10 = start; i10 != elts.length; i10++) {
            char c4 = elts[i10];
            if (c4 != ' ') {
                nonWhiteSpaceEncountered = true;
            }
            if (c4 == '\"') {
                if (!escaped) {
                    quoted = !quoted;
                } else {
                    buf.append(c4);
                }
                escaped = false;
            } else if (c4 == '\\' && !escaped && !quoted) {
                escaped = true;
                lastEscaped = buf.length();
            } else if (c4 != ' ' || escaped || nonWhiteSpaceEncountered) {
                if (escaped && isHexDigit(c4)) {
                    if (hex1 != 0) {
                        buf.append((char) ((convertHex(hex1) * 16) + convertHex(c4)));
                        escaped = false;
                        hex1 = 0;
                    } else {
                        hex1 = c4;
                    }
                } else {
                    buf.append(c4);
                    escaped = false;
                }
            }
        }
        if (buf.length() > 0) {
            while (buf.charAt(buf.length() - 1) == ' ' && lastEscaped != buf.length() - 1) {
                buf.setLength(buf.length() - 1);
            }
        }
        return buf.toString();
    }

    private static boolean isHexDigit(char c4) {
        return ('0' <= c4 && c4 <= '9') || ('a' <= c4 && c4 <= 'f') || ('A' <= c4 && c4 <= 'F');
    }

    private static int convertHex(char c4) {
        if ('0' <= c4 && c4 <= '9') {
            return c4 - '0';
        }
        if ('a' <= c4 && c4 <= 'f') {
            return (c4 - 'a') + 10;
        }
        return (c4 - 'A') + 10;
    }

    public static RDN[] rDNsFromString(String name, X500NameStyle x500Style) {
        X500NameTokenizer nTok = new X500NameTokenizer(name);
        X500NameBuilder builder = new X500NameBuilder(x500Style);
        while (nTok.hasMoreTokens()) {
            String token = nTok.nextToken();
            if (token.indexOf(43) > 0) {
                X500NameTokenizer pTok = new X500NameTokenizer(token, '+');
                X500NameTokenizer vTok = new X500NameTokenizer(pTok.nextToken(), '=');
                String attr = vTok.nextToken();
                if (!vTok.hasMoreTokens()) {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
                String value = vTok.nextToken();
                ASN1ObjectIdentifier oid = x500Style.attrNameToOID(attr.trim());
                if (pTok.hasMoreTokens()) {
                    Vector oids = new Vector();
                    Vector values = new Vector();
                    oids.addElement(oid);
                    values.addElement(unescape(value));
                    while (pTok.hasMoreTokens()) {
                        X500NameTokenizer vTok2 = new X500NameTokenizer(pTok.nextToken(), '=');
                        String attr2 = vTok2.nextToken();
                        if (!vTok2.hasMoreTokens()) {
                            throw new IllegalArgumentException("badly formatted directory string");
                        }
                        String value2 = vTok2.nextToken();
                        oids.addElement(x500Style.attrNameToOID(attr2.trim()));
                        values.addElement(unescape(value2));
                    }
                    builder.addMultiValuedRDN(toOIDArray(oids), toValueArray(values));
                } else {
                    builder.addRDN(oid, unescape(value));
                }
            } else {
                X500NameTokenizer vTok3 = new X500NameTokenizer(token, '=');
                String attr3 = vTok3.nextToken();
                if (!vTok3.hasMoreTokens()) {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
                builder.addRDN(x500Style.attrNameToOID(attr3.trim()), unescape(vTok3.nextToken()));
            }
        }
        return builder.build().getRDNs();
    }

    private static String[] toValueArray(Vector values) {
        String[] tmp = new String[values.size()];
        for (int i10 = 0; i10 != tmp.length; i10++) {
            tmp[i10] = (String) values.elementAt(i10);
        }
        return tmp;
    }

    private static ASN1ObjectIdentifier[] toOIDArray(Vector oids) {
        ASN1ObjectIdentifier[] tmp = new ASN1ObjectIdentifier[oids.size()];
        for (int i10 = 0; i10 != tmp.length; i10++) {
            tmp[i10] = (ASN1ObjectIdentifier) oids.elementAt(i10);
        }
        return tmp;
    }

    public static String[] findAttrNamesForOID(ASN1ObjectIdentifier oid, Hashtable lookup) {
        int count = 0;
        Enumeration en = lookup.elements();
        while (en.hasMoreElements()) {
            if (oid.equals(en.nextElement())) {
                count++;
            }
        }
        String[] aliases = new String[count];
        int count2 = 0;
        Enumeration en2 = lookup.keys();
        while (en2.hasMoreElements()) {
            String key = (String) en2.nextElement();
            if (oid.equals(lookup.get(key))) {
                aliases[count2] = key;
                count2++;
            }
        }
        return aliases;
    }

    public static ASN1ObjectIdentifier decodeAttrName(String name, Hashtable lookUp) {
        if (Strings.toUpperCase(name).startsWith("OID.")) {
            return new ASN1ObjectIdentifier(name.substring(4));
        }
        if (name.charAt(0) >= '0' && name.charAt(0) <= '9') {
            return new ASN1ObjectIdentifier(name);
        }
        ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) lookUp.get(Strings.toLowerCase(name));
        if (oid == null) {
            throw new IllegalArgumentException("Unknown object id - " + name + " - passed to distinguished name");
        }
        return oid;
    }

    public static ASN1Encodable valueFromHexString(String str, int off) throws IOException {
        byte[] data = new byte[(str.length() - off) / 2];
        for (int index = 0; index != data.length; index++) {
            char left = str.charAt((index * 2) + off);
            char right = str.charAt((index * 2) + off + 1);
            data[index] = (byte) ((convertHex(left) << 4) | convertHex(right));
        }
        return ASN1Primitive.fromByteArray(data);
    }

    public static void appendRDN(StringBuffer buf, RDN rdn, Hashtable oidSymbols) {
        if (rdn.isMultiValued()) {
            AttributeTypeAndValue[] atv = rdn.getTypesAndValues();
            boolean firstAtv = true;
            for (int j10 = 0; j10 != atv.length; j10++) {
                if (firstAtv) {
                    firstAtv = false;
                } else {
                    buf.append('+');
                }
                appendTypeAndValue(buf, atv[j10], oidSymbols);
            }
            return;
        }
        if (rdn.getFirst() != null) {
            appendTypeAndValue(buf, rdn.getFirst(), oidSymbols);
        }
    }

    public static void appendTypeAndValue(StringBuffer buf, AttributeTypeAndValue typeAndValue, Hashtable oidSymbols) {
        String sym = (String) oidSymbols.get(typeAndValue.getType());
        if (sym != null) {
            buf.append(sym);
        } else {
            buf.append(typeAndValue.getType().getId());
        }
        buf.append('=');
        buf.append(valueToString(typeAndValue.getValue()));
    }

    public static String valueToString(ASN1Encodable value) {
        StringBuffer vBuf = new StringBuffer();
        if ((value instanceof ASN1String) && !(value instanceof DERUniversalString)) {
            String v2 = ((ASN1String) value).getString();
            if (v2.length() > 0 && v2.charAt(0) == '#') {
                vBuf.append(IOUtils.DIR_SEPARATOR_WINDOWS);
            }
            vBuf.append(v2);
        } else {
            try {
                vBuf.append('#');
                vBuf.append(Hex.toHexString(value.toASN1Primitive().getEncoded(ASN1Encoding.DER)));
            } catch (IOException e2) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        }
        int end = vBuf.length();
        int index = 0;
        if (vBuf.length() >= 2 && vBuf.charAt(0) == '\\' && vBuf.charAt(1) == '#') {
            index = 0 + 2;
        }
        while (index != end) {
            switch (vBuf.charAt(index)) {
                case '\"':
                case '+':
                case ',':
                case ';':
                case '<':
                case '=':
                case '>':
                case '\\':
                    vBuf.insert(index, "\\");
                    index += 2;
                    end++;
                    break;
                default:
                    index++;
                    break;
            }
        }
        if (vBuf.length() > 0) {
            for (int start = 0; vBuf.length() > start && vBuf.charAt(start) == ' '; start += 2) {
                vBuf.insert(start, "\\");
            }
        }
        for (int endBuf = vBuf.length() - 1; endBuf >= 0 && vBuf.charAt(endBuf) == ' '; endBuf--) {
            vBuf.insert(endBuf, IOUtils.DIR_SEPARATOR_WINDOWS);
        }
        return vBuf.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
    
        if (r5 >= r2) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String canonicalize(java.lang.String r8) {
        /*
            int r0 = r8.length()
            if (r0 <= 0) goto L1e
            r0 = 0
            char r0 = r8.charAt(r0)
            r1 = 35
            if (r0 != r1) goto L1e
            com.android.internal.org.bouncycastle.asn1.ASN1Primitive r0 = decodeObject(r8)
            boolean r1 = r0 instanceof com.android.internal.org.bouncycastle.asn1.ASN1String
            if (r1 == 0) goto L1e
            r1 = r0
            com.android.internal.org.bouncycastle.asn1.ASN1String r1 = (com.android.internal.org.bouncycastle.asn1.ASN1String) r1
            java.lang.String r8 = r1.getString()
        L1e:
            java.lang.String r8 = com.android.internal.org.bouncycastle.util.Strings.toLowerCase(r8)
            int r0 = r8.length()
            r1 = 2
            if (r0 >= r1) goto L2a
            return r8
        L2a:
            r1 = 0
            int r2 = r0 + (-1)
        L2d:
            r3 = 32
            r4 = 92
            if (r1 >= r2) goto L44
            char r5 = r8.charAt(r1)
            if (r5 != r4) goto L44
            int r5 = r1 + 1
            char r5 = r8.charAt(r5)
            if (r5 != r3) goto L44
            int r1 = r1 + 2
            goto L2d
        L44:
            r5 = r2
            int r6 = r1 + 1
        L47:
            if (r5 <= r6) goto L5a
            int r7 = r5 + (-1)
            char r7 = r8.charAt(r7)
            if (r7 != r4) goto L5a
            char r7 = r8.charAt(r5)
            if (r7 != r3) goto L5a
            int r5 = r5 + (-2)
            goto L47
        L5a:
            if (r1 > 0) goto L5e
            if (r5 >= r2) goto L64
        L5e:
            int r3 = r5 + 1
            java.lang.String r8 = r8.substring(r1, r3)
        L64:
            java.lang.String r3 = stripInternalSpaces(r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.org.bouncycastle.asn1.x500.style.IETFUtils.canonicalize(java.lang.String):java.lang.String");
    }

    public static String canonicalString(ASN1Encodable value) {
        return canonicalize(valueToString(value));
    }

    private static ASN1Primitive decodeObject(String oValue) {
        try {
            return ASN1Primitive.fromByteArray(Hex.decodeStrict(oValue, 1, oValue.length() - 1));
        } catch (IOException e2) {
            throw new IllegalStateException("unknown encoding in name: " + ((Object) e2));
        }
    }

    public static String stripInternalSpaces(String str) {
        if (str.indexOf("  ") < 0) {
            return str;
        }
        StringBuffer res = new StringBuffer();
        char c12 = str.charAt(0);
        res.append(c12);
        for (int k10 = 1; k10 < str.length(); k10++) {
            char c22 = str.charAt(k10);
            if (c12 != ' ' || c22 != ' ') {
                res.append(c22);
                c12 = c22;
            }
        }
        return res.toString();
    }

    public static boolean rDNAreEqual(RDN rdn1, RDN rdn2) {
        if (rdn1.size() != rdn2.size()) {
            return false;
        }
        AttributeTypeAndValue[] atvs1 = rdn1.getTypesAndValues();
        AttributeTypeAndValue[] atvs2 = rdn2.getTypesAndValues();
        if (atvs1.length != atvs2.length) {
            return false;
        }
        for (int i10 = 0; i10 != atvs1.length; i10++) {
            if (!atvAreEqual(atvs1[i10], atvs2[i10])) {
                return false;
            }
        }
        return true;
    }

    private static boolean atvAreEqual(AttributeTypeAndValue atv1, AttributeTypeAndValue atv2) {
        if (atv1 == atv2) {
            return true;
        }
        if (atv1 == null || atv2 == null) {
            return false;
        }
        ASN1ObjectIdentifier o12 = atv1.getType();
        ASN1ObjectIdentifier o22 = atv2.getType();
        if (!o12.equals((ASN1Primitive) o22)) {
            return false;
        }
        String v12 = canonicalString(atv1.getValue());
        String v2 = canonicalString(atv2.getValue());
        if (v12.equals(v2)) {
            return true;
        }
        return false;
    }
}
