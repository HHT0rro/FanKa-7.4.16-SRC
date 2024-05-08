package sun.security.x509;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import sun.misc.HexDumpEncoder;
import sun.security.util.BitArray;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IPAddressName implements GeneralNameInterface {
    private static final int MASKSIZE = 16;
    private byte[] address;
    private boolean isIPv4;
    private String name;

    public IPAddressName(DerValue derValue) throws IOException {
        this(derValue.getOctetString());
    }

    public IPAddressName(byte[] address) throws IOException {
        if (address.length == 4 || address.length == 8) {
            this.isIPv4 = true;
        } else if (address.length == 16 || address.length == 32) {
            this.isIPv4 = false;
        } else {
            throw new IOException("Invalid IPAddressName");
        }
        this.address = address;
    }

    public IPAddressName(String name) throws IOException {
        if (name == null || name.length() == 0) {
            throw new IOException("IPAddress cannot be null or empty");
        }
        if (name.charAt(name.length() - 1) == '/') {
            throw new IOException("Invalid IPAddress: " + name);
        }
        if (name.indexOf(58) >= 0) {
            parseIPv6(name);
            this.isIPv4 = false;
        } else {
            if (name.indexOf(46) >= 0) {
                parseIPv4(name);
                this.isIPv4 = true;
                return;
            }
            throw new IOException("Invalid IPAddress: " + name);
        }
    }

    private void parseIPv4(String name) throws IOException {
        int slashNdx = name.indexOf(47);
        if (slashNdx == -1) {
            this.address = InetAddress.getByName(name).getAddress();
            return;
        }
        this.address = new byte[8];
        byte[] mask = InetAddress.getByName(name.substring(slashNdx + 1)).getAddress();
        byte[] host = InetAddress.getByName(name.substring(0, slashNdx)).getAddress();
        System.arraycopy((Object) host, 0, (Object) this.address, 0, 4);
        System.arraycopy((Object) mask, 0, (Object) this.address, 4, 4);
    }

    private void parseIPv6(String name) throws IOException {
        int slashNdx = name.indexOf(47);
        if (slashNdx == -1) {
            this.address = InetAddress.getByName(name).getAddress();
            return;
        }
        this.address = new byte[32];
        byte[] base = InetAddress.getByName(name.substring(0, slashNdx)).getAddress();
        System.arraycopy((Object) base, 0, (Object) this.address, 0, 16);
        int prefixLen = Integer.parseInt(name.substring(slashNdx + 1));
        if (prefixLen < 0 || prefixLen > 128) {
            throw new IOException("IPv6Address prefix length (" + prefixLen + ") in out of valid range [0,128]");
        }
        BitArray bitArray = new BitArray(128);
        for (int i10 = 0; i10 < prefixLen; i10++) {
            bitArray.set(i10, true);
        }
        byte[] maskArray = bitArray.toByteArray();
        for (int i11 = 0; i11 < 16; i11++) {
            this.address[i11 + 16] = maskArray[i11];
        }
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int getType() {
        return 7;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public void encode(DerOutputStream out) throws IOException {
        out.putOctetString(this.address);
    }

    public String toString() {
        try {
            return "IPAddress: " + getName();
        } catch (IOException e2) {
            HexDumpEncoder enc = new HexDumpEncoder();
            return "IPAddress: " + enc.encodeBuffer(this.address);
        }
    }

    public String getName() throws IOException {
        String str = this.name;
        if (str != null) {
            return str;
        }
        if (this.isIPv4) {
            byte[] host = new byte[4];
            System.arraycopy((Object) this.address, 0, (Object) host, 0, 4);
            this.name = InetAddress.getByAddress(host).getHostAddress();
            byte[] bArr = this.address;
            if (bArr.length == 8) {
                byte[] mask = new byte[4];
                System.arraycopy((Object) bArr, 4, (Object) mask, 0, 4);
                this.name += "/" + InetAddress.getByAddress(mask).getHostAddress();
            }
        } else {
            byte[] host2 = new byte[16];
            System.arraycopy((Object) this.address, 0, (Object) host2, 0, 16);
            this.name = InetAddress.getByAddress(host2).getHostAddress();
            if (this.address.length == 32) {
                byte[] maskBytes = new byte[16];
                for (int i10 = 16; i10 < 32; i10++) {
                    maskBytes[i10 - 16] = this.address[i10];
                }
                BitArray ba2 = new BitArray(128, maskBytes);
                int i11 = 0;
                while (i11 < 128 && ba2.get(i11)) {
                    i11++;
                }
                this.name += "/" + i11;
                while (i11 < 128) {
                    if (!ba2.get(i11)) {
                        i11++;
                    } else {
                        throw new IOException("Invalid IPv6 subdomain - set bit " + i11 + " not contiguous");
                    }
                }
            }
        }
        return this.name;
    }

    public byte[] getBytes() {
        return (byte[]) this.address.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IPAddressName)) {
            return false;
        }
        IPAddressName otherName = (IPAddressName) obj;
        byte[] other = otherName.address;
        int length = other.length;
        byte[] bArr = this.address;
        if (length != bArr.length) {
            return false;
        }
        if (bArr.length == 8 || bArr.length == 32) {
            int maskLen = bArr.length / 2;
            for (int i10 = 0; i10 < maskLen; i10++) {
                byte[] bArr2 = this.address;
                byte maskedThis = (byte) (bArr2[i10 + maskLen] & bArr2[i10]);
                byte maskedOther = (byte) (other[i10] & other[i10 + maskLen]);
                if (maskedThis != maskedOther) {
                    return false;
                }
            }
            int i11 = maskLen;
            while (true) {
                byte[] bArr3 = this.address;
                if (i11 >= bArr3.length) {
                    return true;
                }
                if (bArr3[i11] != other[i11]) {
                    return false;
                }
                i11++;
            }
        } else {
            return Arrays.equals(other, bArr);
        }
    }

    public int hashCode() {
        int retval = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.address;
            if (i10 < bArr.length) {
                retval += bArr[i10] * i10;
                i10++;
            } else {
                return retval;
            }
        }
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int constrains(GeneralNameInterface inputName) throws UnsupportedOperationException {
        int constraintType;
        int constraintType2;
        int constraintType3;
        if (inputName == null) {
            return -1;
        }
        int constraintType4 = inputName.getType();
        if (constraintType4 != 7) {
            return -1;
        }
        if (((IPAddressName) inputName).equals(this)) {
            return 0;
        }
        IPAddressName otherName = (IPAddressName) inputName;
        byte[] otherAddress = otherName.address;
        if (otherAddress.length == 4 && this.address.length == 4) {
            return 3;
        }
        int constraintType5 = otherAddress.length;
        if ((constraintType5 != 8 || this.address.length != 8) && (otherAddress.length != 32 || this.address.length != 32)) {
            if (otherAddress.length == 8 || otherAddress.length == 32) {
                int i10 = 0;
                int maskOffset = otherAddress.length / 2;
                while (i10 < maskOffset && (this.address[i10] & otherAddress[i10 + maskOffset]) == otherAddress[i10]) {
                    i10++;
                }
                if (i10 == maskOffset) {
                    constraintType = 2;
                } else {
                    constraintType = 3;
                }
                return constraintType;
            }
            byte[] bArr = this.address;
            if (bArr.length == 8 || bArr.length == 32) {
                int i11 = 0;
                int maskOffset2 = bArr.length / 2;
                while (i11 < maskOffset2) {
                    byte b4 = otherAddress[i11];
                    byte[] bArr2 = this.address;
                    if ((b4 & bArr2[i11 + maskOffset2]) != bArr2[i11]) {
                        break;
                    }
                    i11++;
                }
                if (i11 == maskOffset2) {
                    constraintType2 = 1;
                } else {
                    constraintType2 = 3;
                }
                return constraintType2;
            }
            return 3;
        }
        boolean otherSubsetOfThis = true;
        boolean thisSubsetOfOther = true;
        boolean thisEmpty = false;
        boolean otherEmpty = false;
        int maskOffset3 = this.address.length / 2;
        for (int i12 = 0; i12 < maskOffset3; i12++) {
            byte[] bArr3 = this.address;
            byte b10 = bArr3[i12];
            if (((byte) (bArr3[i12 + maskOffset3] & b10)) != b10) {
                thisEmpty = true;
            }
            if (((byte) (otherAddress[i12] & otherAddress[i12 + maskOffset3])) != otherAddress[i12]) {
                otherEmpty = true;
            }
            if (((byte) (bArr3[i12 + maskOffset3] & otherAddress[i12 + maskOffset3])) != bArr3[i12 + maskOffset3] || ((byte) (bArr3[i12 + maskOffset3] & b10)) != ((byte) (otherAddress[i12] & bArr3[i12 + maskOffset3]))) {
                otherSubsetOfThis = false;
            }
            if (((byte) (bArr3[i12 + maskOffset3] & otherAddress[i12 + maskOffset3])) != otherAddress[i12 + maskOffset3] || ((byte) (otherAddress[i12] & otherAddress[i12 + maskOffset3])) != ((byte) (b10 & otherAddress[i12 + maskOffset3]))) {
                thisSubsetOfOther = false;
            }
        }
        if (thisEmpty || otherEmpty) {
            if (thisEmpty && otherEmpty) {
                constraintType3 = 0;
            } else if (thisEmpty) {
                constraintType3 = 2;
            } else {
                constraintType3 = 1;
            }
        } else if (otherSubsetOfThis) {
            constraintType3 = 1;
        } else if (thisSubsetOfOther) {
            constraintType3 = 2;
        } else {
            constraintType3 = 3;
        }
        return constraintType3;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int subtreeDepth() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("subtreeDepth() not defined for IPAddressName");
    }
}
