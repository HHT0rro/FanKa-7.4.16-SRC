package java.util;

import android.compat.Compatibility;
import dalvik.system.VMRuntime;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import okio.Utf8;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class UUID implements Serializable, Comparable<UUID> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final long ENABLE_STRICT_VALIDATION = 263076149;
    private static final long serialVersionUID = -4856846361193249489L;
    private final long leastSigBits;
    private final long mostSigBits;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Holder {
        static final SecureRandom numberGenerator = new SecureRandom();

        private Holder() {
        }
    }

    private UUID(byte[] data) {
        long msb = 0;
        long lsb = 0;
        for (int i10 = 0; i10 < 8; i10++) {
            msb = (msb << 8) | (data[i10] & 255);
        }
        for (int i11 = 8; i11 < 16; i11++) {
            lsb = (lsb << 8) | (data[i11] & 255);
        }
        this.mostSigBits = msb;
        this.leastSigBits = lsb;
    }

    public UUID(long mostSigBits, long leastSigBits) {
        this.mostSigBits = mostSigBits;
        this.leastSigBits = leastSigBits;
    }

    public static UUID randomUUID() {
        SecureRandom ng = Holder.numberGenerator;
        byte[] randomBytes = new byte[16];
        ng.nextBytes(randomBytes);
        randomBytes[6] = (byte) (randomBytes[6] & 15);
        randomBytes[6] = (byte) (randomBytes[6] | DerValue.TAG_APPLICATION);
        randomBytes[8] = (byte) (randomBytes[8] & Utf8.REPLACEMENT_BYTE);
        randomBytes[8] = (byte) (randomBytes[8] | 128);
        return new UUID(randomBytes);
    }

    public static UUID nameUUIDFromBytes(byte[] name) {
        try {
            MessageDigest md2 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md2.digest(name);
            md5Bytes[6] = (byte) (md5Bytes[6] & 15);
            md5Bytes[6] = (byte) (md5Bytes[6] | 48);
            md5Bytes[8] = (byte) (md5Bytes[8] & Utf8.REPLACEMENT_BYTE);
            md5Bytes[8] = (byte) (md5Bytes[8] | 128);
            return new UUID(md5Bytes);
        } catch (NoSuchAlgorithmException nsae) {
            throw new InternalError("MD5 not supported", nsae);
        }
    }

    public static UUID fromString(String name) {
        if (VMRuntime.getSdkVersion() < 34 || !Compatibility.isChangeEnabled(ENABLE_STRICT_VALIDATION)) {
            return fromStringJava8(name);
        }
        return fromStringJava11(name);
    }

    public static UUID fromStringJava11(String name) {
        int len = name.length();
        if (len <= 36) {
            int dash1 = name.indexOf(45, 0);
            int dash2 = name.indexOf(45, dash1 + 1);
            int dash3 = name.indexOf(45, dash2 + 1);
            int dash4 = name.indexOf(45, dash3 + 1);
            int dash5 = name.indexOf(45, dash4 + 1);
            if (dash4 >= 0 && dash5 < 0) {
                long mostSigBits = Long.parseLong(name, 0, dash1, 16) & 4294967295L;
                long mostSigBits2 = (((mostSigBits << 16) | (Long.parseLong(name, dash1 + 1, dash2, 16) & 65535)) << 16) | (Long.parseLong(name, dash2 + 1, dash3, 16) & 65535);
                long leastSigBits = Long.parseLong(name, dash3 + 1, dash4, 16) & 65535;
                return new UUID(mostSigBits2, (leastSigBits << 48) | (Long.parseLong(name, dash4 + 1, len, 16) & 281474976710655L));
            }
            throw new IllegalArgumentException("Invalid UUID string: " + name);
        }
        throw new IllegalArgumentException("UUID string too large");
    }

    public static UUID fromStringJava8(String name) {
        String[] components = name.split("-");
        if (components.length != 5) {
            throw new IllegalArgumentException("Invalid UUID string: " + name);
        }
        for (int i10 = 0; i10 < 5; i10++) {
            components[i10] = "0x" + components[i10];
        }
        long mostSigBits = Long.decode(components[0]).longValue();
        long mostSigBits2 = (((mostSigBits << 16) | Long.decode(components[1]).longValue()) << 16) | Long.decode(components[2]).longValue();
        long leastSigBits = Long.decode(components[3]).longValue();
        return new UUID(mostSigBits2, (leastSigBits << 48) | Long.decode(components[4]).longValue());
    }

    public long getLeastSignificantBits() {
        return this.leastSigBits;
    }

    public long getMostSignificantBits() {
        return this.mostSigBits;
    }

    public int version() {
        return (int) ((this.mostSigBits >> 12) & 15);
    }

    public int variant() {
        long j10 = this.leastSigBits;
        return (int) ((j10 >> 63) & (j10 >>> ((int) (64 - (j10 >>> 62)))));
    }

    public long timestamp() {
        if (version() != 1) {
            throw new UnsupportedOperationException("Not a time-based UUID");
        }
        long j10 = this.mostSigBits;
        return (j10 >>> 32) | ((4095 & j10) << 48) | (((j10 >> 16) & 65535) << 32);
    }

    public int clockSequence() {
        if (version() != 1) {
            throw new UnsupportedOperationException("Not a time-based UUID");
        }
        return (int) ((this.leastSigBits & 4611404543450677248L) >>> 48);
    }

    public long node() {
        if (version() != 1) {
            throw new UnsupportedOperationException("Not a time-based UUID");
        }
        return this.leastSigBits & 281474976710655L;
    }

    public String toString() {
        return digits(this.mostSigBits >> 32, 8) + "-" + digits(this.mostSigBits >> 16, 4) + "-" + digits(this.mostSigBits, 4) + "-" + digits(this.leastSigBits >> 48, 4) + "-" + digits(this.leastSigBits, 12);
    }

    private static String digits(long val, int digits) {
        long hi = 1 << (digits * 4);
        return Long.toHexString(((hi - 1) & val) | hi).substring(1);
    }

    public int hashCode() {
        long hilo = this.mostSigBits ^ this.leastSigBits;
        return ((int) (hilo >> 32)) ^ ((int) hilo);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != UUID.class) {
            return false;
        }
        UUID id2 = (UUID) obj;
        return this.mostSigBits == id2.mostSigBits && this.leastSigBits == id2.leastSigBits;
    }

    @Override // java.lang.Comparable
    public int compareTo(UUID val) {
        long j10 = this.mostSigBits;
        long j11 = val.mostSigBits;
        if (j10 < j11) {
            return -1;
        }
        if (j10 > j11) {
            return 1;
        }
        long j12 = this.leastSigBits;
        long j13 = val.leastSigBits;
        if (j12 < j13) {
            return -1;
        }
        return j12 > j13 ? 1 : 0;
    }
}
