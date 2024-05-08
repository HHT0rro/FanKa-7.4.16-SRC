package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface VisibilityOrBuilder extends MessageOrBuilder {
    VisibilityRule getRules(int i10);

    int getRulesCount();

    List<VisibilityRule> getRulesList();

    VisibilityRuleOrBuilder getRulesOrBuilder(int i10);

    List<? extends VisibilityRuleOrBuilder> getRulesOrBuilderList();
}
