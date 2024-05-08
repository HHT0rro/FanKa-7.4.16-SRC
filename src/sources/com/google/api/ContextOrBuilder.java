package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ContextOrBuilder extends MessageOrBuilder {
    ContextRule getRules(int i10);

    int getRulesCount();

    List<ContextRule> getRulesList();

    ContextRuleOrBuilder getRulesOrBuilder(int i10);

    List<? extends ContextRuleOrBuilder> getRulesOrBuilderList();
}
