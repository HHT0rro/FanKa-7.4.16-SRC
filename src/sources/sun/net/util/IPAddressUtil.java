package sun.net.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IPAddressUtil {
    private static final int INADDR16SZ = 16;
    private static final int INADDR4SZ = 4;
    private static final int INT16SZ = 2;

    public static byte[] textToNumericFormatV4(String src) {
        byte[] res = new byte[4];
        long tmpValue = 0;
        int currByte = 0;
        boolean newOctet = true;
        int len = src.length();
        if (len == 0 || len > 15) {
            return null;
        }
        for (int i10 = 0; i10 < len; i10++) {
            char c4 = src.charAt(i10);
            if (c4 == '.') {
                if (newOctet || tmpValue < 0 || tmpValue > 255 || currByte == 3) {
                    return null;
                }
                res[currByte] = (byte) (tmpValue & 255);
                tmpValue = 0;
                newOctet = true;
                currByte++;
            } else {
                int digit = Character.digit(c4, 10);
                if (digit < 0) {
                    return null;
                }
                tmpValue = (tmpValue * 10) + digit;
                newOctet = false;
            }
        }
        if (newOctet || tmpValue < 0 || tmpValue >= (1 << ((4 - currByte) * 8))) {
            return null;
        }
        switch (currByte) {
            case 0:
            case 1:
            case 2:
                return null;
            case 3:
                res[3] = (byte) ((tmpValue >> 0) & 255);
            default:
                return res;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d5, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00db, code lost:
    
        if ((r10 + 2) <= 16) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00dd, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00de, code lost:
    
        r0 = r10 + 1;
        r4[r10] = (byte) ((r14 >> 8) & 255);
        r10 = r0 + 1;
        r4[r0] = (byte) (r14 & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ef, code lost:
    
        if (r8 == (-1)) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f1, code lost:
    
        r0 = r10 - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f5, code lost:
    
        if (r10 != 16) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f7, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f9, code lost:
    
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fb, code lost:
    
        if (r9 > r0) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00fd, code lost:
    
        r4[16 - r9] = r4[(r8 + r0) - r9];
        r4[(r8 + r0) - r9] = 0;
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x010f, code lost:
    
        r10 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0113, code lost:
    
        if (r10 == 16) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0115, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0117, code lost:
    
        r0 = convertFromIPv4MappedAddress(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011b, code lost:
    
        if (r0 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x011d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x011e, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] textToNumericFormatV6(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.util.IPAddressUtil.textToNumericFormatV6(java.lang.String):byte[]");
    }

    public static boolean isIPv4LiteralAddress(String src) {
        return textToNumericFormatV4(src) != null;
    }

    public static boolean isIPv6LiteralAddress(String src) {
        return textToNumericFormatV6(src) != null;
    }

    public static byte[] convertFromIPv4MappedAddress(byte[] addr) {
        if (isIPv4MappedAddress(addr)) {
            byte[] newAddr = new byte[4];
            System.arraycopy((Object) addr, 12, (Object) newAddr, 0, 4);
            return newAddr;
        }
        return null;
    }

    private static boolean isIPv4MappedAddress(byte[] addr) {
        return addr.length >= 16 && addr[0] == 0 && addr[1] == 0 && addr[2] == 0 && addr[3] == 0 && addr[4] == 0 && addr[5] == 0 && addr[6] == 0 && addr[7] == 0 && addr[8] == 0 && addr[9] == 0 && addr[10] == -1 && addr[11] == -1;
    }
}
