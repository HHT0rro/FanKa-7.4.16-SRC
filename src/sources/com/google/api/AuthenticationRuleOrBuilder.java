package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface AuthenticationRuleOrBuilder extends MessageOrBuilder {
    boolean getAllowWithoutCredential();

    OAuthRequirements getOauth();

    OAuthRequirementsOrBuilder getOauthOrBuilder();

    AuthRequirement getRequirements(int i10);

    int getRequirementsCount();

    List<AuthRequirement> getRequirementsList();

    AuthRequirementOrBuilder getRequirementsOrBuilder(int i10);

    List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList();

    String getSelector();

    ByteString getSelectorBytes();

    boolean hasOauth();
}
