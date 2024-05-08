package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface AuthenticationOrBuilder extends MessageOrBuilder {
    AuthProvider getProviders(int i10);

    int getProvidersCount();

    List<AuthProvider> getProvidersList();

    AuthProviderOrBuilder getProvidersOrBuilder(int i10);

    List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList();

    AuthenticationRule getRules(int i10);

    int getRulesCount();

    List<AuthenticationRule> getRulesList();

    AuthenticationRuleOrBuilder getRulesOrBuilder(int i10);

    List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList();
}
