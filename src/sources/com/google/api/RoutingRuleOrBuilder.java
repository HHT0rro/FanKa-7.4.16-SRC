package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface RoutingRuleOrBuilder extends MessageOrBuilder {
    RoutingParameter getRoutingParameters(int i10);

    int getRoutingParametersCount();

    List<RoutingParameter> getRoutingParametersList();

    RoutingParameterOrBuilder getRoutingParametersOrBuilder(int i10);

    List<? extends RoutingParameterOrBuilder> getRoutingParametersOrBuilderList();
}
