package java.security.spec;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class EllipticCurve {

    /* renamed from: a, reason: collision with root package name */
    private final BigInteger f50415a;

    /* renamed from: b, reason: collision with root package name */
    private final BigInteger f50416b;
    private final ECField field;
    private final byte[] seed;

    private static void checkValidity(ECField field, BigInteger c4, String cName) {
        if (field instanceof ECFieldFp) {
            BigInteger p10 = ((ECFieldFp) field).getP();
            if (p10.compareTo(c4) != 1) {
                throw new IllegalArgumentException(cName + " is too large");
            }
            if (c4.signum() < 0) {
                throw new IllegalArgumentException(cName + " is negative");
            }
            return;
        }
        if (field instanceof ECFieldF2m) {
            int m10 = ((ECFieldF2m) field).getM();
            if (c4.bitLength() > m10) {
                throw new IllegalArgumentException(cName + " is too large");
            }
        }
    }

    public EllipticCurve(ECField field, BigInteger a10, BigInteger b4) {
        this(field, a10, b4, null);
    }

    public EllipticCurve(ECField field, BigInteger a10, BigInteger b4, byte[] seed) {
        if (field == null) {
            throw new NullPointerException("field is null");
        }
        if (a10 == null) {
            throw new NullPointerException("first coefficient is null");
        }
        if (b4 == null) {
            throw new NullPointerException("second coefficient is null");
        }
        checkValidity(field, a10, "first coefficient");
        checkValidity(field, b4, "second coefficient");
        this.field = field;
        this.f50415a = a10;
        this.f50416b = b4;
        if (seed != null) {
            this.seed = (byte[]) seed.clone();
        } else {
            this.seed = null;
        }
    }

    public ECField getField() {
        return this.field;
    }

    public BigInteger getA() {
        return this.f50415a;
    }

    public BigInteger getB() {
        return this.f50416b;
    }

    public byte[] getSeed() {
        byte[] bArr = this.seed;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EllipticCurve) {
            EllipticCurve curve = (EllipticCurve) obj;
            if (this.field.equals(curve.field) && this.f50415a.equals(curve.f50415a) && this.f50416b.equals(curve.f50416b)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return this.field.hashCode() << (((this.f50415a.hashCode() << 4) + 6) + (this.f50416b.hashCode() << 2));
    }
}
