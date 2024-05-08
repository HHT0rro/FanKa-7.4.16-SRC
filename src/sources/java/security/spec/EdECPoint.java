package java.security.spec;

import java.math.BigInteger;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class EdECPoint {
    private final boolean xOdd;

    /* renamed from: y, reason: collision with root package name */
    private final BigInteger f50414y;

    public EdECPoint(boolean xOdd, BigInteger y10) {
        Objects.requireNonNull(y10, "y must not be null");
        this.xOdd = xOdd;
        this.f50414y = y10;
    }

    public boolean isXOdd() {
        return this.xOdd;
    }

    public BigInteger getY() {
        return this.f50414y;
    }
}
