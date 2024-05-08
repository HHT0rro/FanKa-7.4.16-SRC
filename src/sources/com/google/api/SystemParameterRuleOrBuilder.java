package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface SystemParameterRuleOrBuilder extends MessageOrBuilder {
    SystemParameter getParameters(int i10);

    int getParametersCount();

    List<SystemParameter> getParametersList();

    SystemParameterOrBuilder getParametersOrBuilder(int i10);

    List<? extends SystemParameterOrBuilder> getParametersOrBuilderList();

    String getSelector();

    ByteString getSelectorBytes();
}
