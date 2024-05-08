package java.security.spec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ECPublicKeySpec implements KeySpec {
    private ECParameterSpec params;

    /* renamed from: w, reason: collision with root package name */
    private ECPoint f50413w;

    public ECPublicKeySpec(ECPoint w3, ECParameterSpec params) {
        if (w3 == null) {
            throw new NullPointerException("w is null");
        }
        if (params == null) {
            throw new NullPointerException("params is null");
        }
        if (w3 == ECPoint.POINT_INFINITY) {
            throw new IllegalArgumentException("w is ECPoint.POINT_INFINITY");
        }
        this.f50413w = w3;
        this.params = params;
    }

    public ECPoint getW() {
        return this.f50413w;
    }

    public ECParameterSpec getParams() {
        return this.params;
    }
}
