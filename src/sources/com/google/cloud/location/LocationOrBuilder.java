package com.google.cloud.location;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface LocationOrBuilder extends MessageOrBuilder {
    boolean containsLabels(String str);

    String getDisplayName();

    ByteString getDisplayNameBytes();

    @Deprecated
    Map<String, String> getLabels();

    int getLabelsCount();

    Map<String, String> getLabelsMap();

    String getLabelsOrDefault(String str, String str2);

    String getLabelsOrThrow(String str);

    String getLocationId();

    ByteString getLocationIdBytes();

    Any getMetadata();

    AnyOrBuilder getMetadataOrBuilder();

    String getName();

    ByteString getNameBytes();

    boolean hasMetadata();
}
