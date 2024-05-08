package com.google.protobuf;

import com.google.protobuf.GeneratedMessageV3;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class NewInstanceSchemaFull implements NewInstanceSchema {
    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object obj) {
        return ((GeneratedMessageV3) obj).newInstance(GeneratedMessageV3.UnusedPrivateParameter.INSTANCE);
    }
}
