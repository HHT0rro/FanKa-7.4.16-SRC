package java.security.spec;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class NamedParameterSpec implements AlgorithmParameterSpec {
    private String name;
    public static final NamedParameterSpec X25519 = new NamedParameterSpec("X25519");
    public static final NamedParameterSpec X448 = new NamedParameterSpec("X448");
    public static final NamedParameterSpec ED25519 = new NamedParameterSpec("Ed25519");
    public static final NamedParameterSpec ED448 = new NamedParameterSpec("Ed448");

    public NamedParameterSpec(String stdName) {
        Objects.requireNonNull(stdName, "stdName must not be null");
        this.name = stdName;
    }

    public String getName() {
        return this.name;
    }
}
