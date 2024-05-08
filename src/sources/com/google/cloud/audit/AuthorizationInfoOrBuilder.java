package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.rpc.context.AttributeContext;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface AuthorizationInfoOrBuilder extends MessageOrBuilder {
    boolean getGranted();

    String getPermission();

    ByteString getPermissionBytes();

    String getResource();

    AttributeContext.Resource getResourceAttributes();

    AttributeContext.ResourceOrBuilder getResourceAttributesOrBuilder();

    ByteString getResourceBytes();

    boolean hasResourceAttributes();
}
