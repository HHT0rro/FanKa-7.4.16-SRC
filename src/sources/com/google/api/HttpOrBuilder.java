package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface HttpOrBuilder extends MessageOrBuilder {
    boolean getFullyDecodeReservedExpansion();

    HttpRule getRules(int i10);

    int getRulesCount();

    List<HttpRule> getRulesList();

    HttpRuleOrBuilder getRulesOrBuilder(int i10);

    List<? extends HttpRuleOrBuilder> getRulesOrBuilderList();
}
