package com.google.api;

import com.google.api.Property;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface PropertyOrBuilder extends MessageOrBuilder {
    String getDescription();

    ByteString getDescriptionBytes();

    String getName();

    ByteString getNameBytes();

    Property.PropertyType getType();

    int getTypeValue();
}
