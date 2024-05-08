package com.android.internal.org.bouncycastle.asn1.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1Choice;
import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERIA5String;
import com.android.internal.org.bouncycastle.asn1.DEROctetString;
import com.android.internal.org.bouncycastle.asn1.DERTaggedObject;
import com.android.internal.org.bouncycastle.asn1.x500.X500Name;
import com.android.internal.org.bouncycastle.util.IPAddress;
import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.util.StringTokenizer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class GeneralName extends ASN1Object implements ASN1Choice {
    public static final int dNSName = 2;
    public static final int directoryName = 4;
    public static final int ediPartyName = 5;
    public static final int iPAddress = 7;
    public static final int otherName = 0;
    public static final int registeredID = 8;
    public static final int rfc822Name = 1;
    public static final int uniformResourceIdentifier = 6;
    public static final int x400Address = 3;
    private ASN1Encodable obj;
    private int tag;

    public GeneralName(X509Name dirName) {
        this.obj = X500Name.getInstance(dirName);
        this.tag = 4;
    }

    public GeneralName(X500Name dirName) {
        this.obj = dirName;
        this.tag = 4;
    }

    public GeneralName(int tag, ASN1Encodable name) {
        this.obj = name;
        this.tag = tag;
    }

    public GeneralName(int tag, String name) {
        this.tag = tag;
        if (tag == 1 || tag == 2 || tag == 6) {
            this.obj = new DERIA5String(name);
            return;
        }
        if (tag == 8) {
            this.obj = new ASN1ObjectIdentifier(name);
            return;
        }
        if (tag == 4) {
            this.obj = new X500Name(name);
        } else {
            if (tag == 7) {
                byte[] enc = toGeneralNameEncoding(name);
                if (enc != null) {
                    this.obj = new DEROctetString(enc);
                    return;
                }
                throw new IllegalArgumentException("IP Address is invalid");
            }
            throw new IllegalArgumentException("can't process String for tag: " + tag);
        }
    }

    public static GeneralName getInstance(Object obj) {
        if (obj == null || (obj instanceof GeneralName)) {
            return (GeneralName) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            ASN1TaggedObject tagObj = (ASN1TaggedObject) obj;
            int tag = tagObj.getTagNo();
            switch (tag) {
                case 0:
                case 3:
                case 5:
                    return new GeneralName(tag, ASN1Sequence.getInstance(tagObj, false));
                case 1:
                case 2:
                case 6:
                    return new GeneralName(tag, DERIA5String.getInstance(tagObj, false));
                case 4:
                    return new GeneralName(tag, X500Name.getInstance(tagObj, true));
                case 7:
                    return new GeneralName(tag, ASN1OctetString.getInstance(tagObj, false));
                case 8:
                    return new GeneralName(tag, ASN1ObjectIdentifier.getInstance(tagObj, false));
                default:
                    throw new IllegalArgumentException("unknown tag: " + tag);
            }
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e2) {
                throw new IllegalArgumentException("unable to parse encoded general name");
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static GeneralName getInstance(ASN1TaggedObject tagObj, boolean explicit) {
        return getInstance(ASN1TaggedObject.getInstance(tagObj, true));
    }

    public int getTagNo() {
        return this.tag;
    }

    public ASN1Encodable getName() {
        return this.obj;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(this.tag);
        buf.append(": ");
        switch (this.tag) {
            case 1:
            case 2:
            case 6:
                buf.append(DERIA5String.getInstance(this.obj).getString());
                break;
            case 3:
            case 5:
            default:
                buf.append(this.obj.toString());
                break;
            case 4:
                buf.append(X500Name.getInstance(this.obj).toString());
                break;
        }
        return buf.toString();
    }

    private byte[] toGeneralNameEncoding(String ip) {
        int[] parsedIp;
        if (IPAddress.isValidIPv6WithNetmask(ip) || IPAddress.isValidIPv6(ip)) {
            int slashIndex = ip.indexOf(47);
            if (slashIndex < 0) {
                byte[] addr = new byte[16];
                int[] parsedIp2 = parseIPv6(ip);
                copyInts(parsedIp2, addr, 0);
                return addr;
            }
            byte[] addr2 = new byte[32];
            int[] parsedIp3 = parseIPv6(ip.substring(0, slashIndex));
            copyInts(parsedIp3, addr2, 0);
            String mask = ip.substring(slashIndex + 1);
            if (mask.indexOf(58) > 0) {
                parsedIp = parseIPv6(mask);
            } else {
                parsedIp = parseMask(mask);
            }
            copyInts(parsedIp, addr2, 16);
            return addr2;
        }
        if (IPAddress.isValidIPv4WithNetmask(ip) || IPAddress.isValidIPv4(ip)) {
            int slashIndex2 = ip.indexOf(47);
            if (slashIndex2 < 0) {
                byte[] addr3 = new byte[4];
                parseIPv4(ip, addr3, 0);
                return addr3;
            }
            byte[] addr4 = new byte[8];
            parseIPv4(ip.substring(0, slashIndex2), addr4, 0);
            String mask2 = ip.substring(slashIndex2 + 1);
            if (mask2.indexOf(46) > 0) {
                parseIPv4(mask2, addr4, 4);
            } else {
                parseIPv4Mask(mask2, addr4, 4);
            }
            return addr4;
        }
        return null;
    }

    private void parseIPv4Mask(String mask, byte[] addr, int offset) {
        int maskVal = Integer.parseInt(mask);
        for (int i10 = 0; i10 != maskVal; i10++) {
            int i11 = (i10 / 8) + offset;
            addr[i11] = (byte) (addr[i11] | (1 << (7 - (i10 % 8))));
        }
    }

    private void parseIPv4(String ip, byte[] addr, int offset) {
        StringTokenizer sTok = new StringTokenizer(ip, "./");
        int index = 0;
        while (sTok.hasMoreTokens()) {
            addr[index + offset] = (byte) Integer.parseInt(sTok.nextToken());
            index++;
        }
    }

    private int[] parseMask(String mask) {
        int[] res = new int[8];
        int maskVal = Integer.parseInt(mask);
        for (int i10 = 0; i10 != maskVal; i10++) {
            int i11 = i10 / 16;
            res[i11] = res[i11] | (1 << (15 - (i10 % 16)));
        }
        return res;
    }

    private void copyInts(int[] parsedIp, byte[] addr, int offSet) {
        for (int i10 = 0; i10 != parsedIp.length; i10++) {
            addr[(i10 * 2) + offSet] = (byte) (parsedIp[i10] >> 8);
            addr[(i10 * 2) + 1 + offSet] = (byte) parsedIp[i10];
        }
    }

    private int[] parseIPv6(String ip) {
        StringTokenizer sTok = new StringTokenizer(ip, u.bD, true);
        int index = 0;
        int[] val = new int[8];
        if (ip.charAt(0) == ':' && ip.charAt(1) == ':') {
            sTok.nextToken();
        }
        int doubleColon = -1;
        while (sTok.hasMoreTokens()) {
            String e2 = sTok.nextToken();
            if (e2.equals(u.bD)) {
                doubleColon = index;
                val[index] = 0;
                index++;
            } else if (e2.indexOf(46) < 0) {
                int index2 = index + 1;
                val[index] = Integer.parseInt(e2, 16);
                if (sTok.hasMoreTokens()) {
                    sTok.nextToken();
                }
                index = index2;
            } else {
                StringTokenizer eTok = new StringTokenizer(e2, ".");
                int index3 = index + 1;
                val[index] = (Integer.parseInt(eTok.nextToken()) << 8) | Integer.parseInt(eTok.nextToken());
                index = index3 + 1;
                val[index3] = (Integer.parseInt(eTok.nextToken()) << 8) | Integer.parseInt(eTok.nextToken());
            }
        }
        if (index != val.length) {
            System.arraycopy((Object) val, doubleColon, (Object) val, val.length - (index - doubleColon), index - doubleColon);
            for (int i10 = doubleColon; i10 != val.length - (index - doubleColon); i10++) {
                val[i10] = 0;
            }
        }
        return val;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        int i10 = this.tag;
        boolean explicit = i10 == 4;
        return new DERTaggedObject(explicit, i10, this.obj);
    }
}
