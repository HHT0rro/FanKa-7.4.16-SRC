package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.SecurityLevel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class GrpcAttributes {
    public static final Attributes.Key<SecurityLevel> ATTR_SECURITY_LEVEL = Attributes.Key.create("io.grpc.internal.GrpcAttributes.securityLevel");
    public static final Attributes.Key<Attributes> ATTR_CLIENT_EAG_ATTRS = Attributes.Key.create("io.grpc.internal.GrpcAttributes.clientEagAttrs");

    private GrpcAttributes() {
    }
}
