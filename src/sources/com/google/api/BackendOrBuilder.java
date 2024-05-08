package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface BackendOrBuilder extends MessageOrBuilder {
    BackendRule getRules(int i10);

    int getRulesCount();

    List<BackendRule> getRulesList();

    BackendRuleOrBuilder getRulesOrBuilder(int i10);

    List<? extends BackendRuleOrBuilder> getRulesOrBuilderList();
}
