package javax.net.ssl;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SNIServerName {
    private static final char[] HEXES = "0123456789ABCDEF".toCharArray();
    private final byte[] encoded;
    private final int type;

    /* JADX INFO: Access modifiers changed from: protected */
    public SNIServerName(int type, byte[] encoded) {
        if (type < 0) {
            throw new IllegalArgumentException("Server name type cannot be less than zero");
        }
        if (type > 255) {
            throw new IllegalArgumentException("Server name type cannot be greater than 255");
        }
        this.type = type;
        if (encoded == null) {
            throw new NullPointerException("Server name encoded value cannot be null");
        }
        this.encoded = (byte[]) encoded.clone();
    }

    public final int getType() {
        return this.type;
    }

    public final byte[] getEncoded() {
        return (byte[]) this.encoded.clone();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        SNIServerName that = (SNIServerName) other;
        return this.type == that.type && Arrays.equals(this.encoded, that.encoded);
    }

    public int hashCode() {
        int result = (17 * 31) + this.type;
        return (result * 31) + Arrays.hashCode(this.encoded);
    }

    public String toString() {
        if (this.type == 0) {
            return "type=host_name (0), value=" + toHexString(this.encoded);
        }
        return "type=(" + this.type + "), value=" + toHexString(this.encoded);
    }

    private static String toHexString(byte[] bytes) {
        if (bytes.length == 0) {
            return "(empty)";
        }
        StringBuilder sb2 = new StringBuilder((bytes.length * 3) - 1);
        boolean isInitial = true;
        for (byte b4 : bytes) {
            if (isInitial) {
                isInitial = false;
            } else {
                sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
            }
            int k10 = b4 & 255;
            char[] cArr = HEXES;
            sb2.append(cArr[k10 >>> 4]);
            sb2.append(cArr[k10 & 15]);
        }
        return sb2.toString();
    }
}
