package java.security.spec;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class EdECPublicKeySpec implements KeySpec {
    private final NamedParameterSpec params;
    private final EdECPoint point;

    public EdECPublicKeySpec(NamedParameterSpec params, EdECPoint point) {
        Objects.requireNonNull(params, "params must not be null");
        Objects.requireNonNull(point, "point must not be null");
        this.params = params;
        this.point = point;
    }

    public NamedParameterSpec getParams() {
        return this.params;
    }

    public EdECPoint getPoint() {
        return this.point;
    }
}
