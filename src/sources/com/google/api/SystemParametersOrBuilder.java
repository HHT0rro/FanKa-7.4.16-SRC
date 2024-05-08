package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface SystemParametersOrBuilder extends MessageOrBuilder {
    SystemParameterRule getRules(int i10);

    int getRulesCount();

    List<SystemParameterRule> getRulesList();

    SystemParameterRuleOrBuilder getRulesOrBuilder(int i10);

    List<? extends SystemParameterRuleOrBuilder> getRulesOrBuilderList();
}
