package com.google.api;

import com.google.api.ResourceDescriptor;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ResourceDescriptorOrBuilder extends MessageOrBuilder {
    ResourceDescriptor.History getHistory();

    int getHistoryValue();

    String getNameField();

    ByteString getNameFieldBytes();

    String getPattern(int i10);

    ByteString getPatternBytes(int i10);

    int getPatternCount();

    List<String> getPatternList();

    String getPlural();

    ByteString getPluralBytes();

    String getSingular();

    ByteString getSingularBytes();

    ResourceDescriptor.Style getStyle(int i10);

    int getStyleCount();

    List<ResourceDescriptor.Style> getStyleList();

    int getStyleValue(int i10);

    List<Integer> getStyleValueList();

    String getType();

    ByteString getTypeBytes();
}
