package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface UsageOrBuilder extends MessageOrBuilder {
    String getProducerNotificationChannel();

    ByteString getProducerNotificationChannelBytes();

    String getRequirements(int i10);

    ByteString getRequirementsBytes(int i10);

    int getRequirementsCount();

    List<String> getRequirementsList();

    UsageRule getRules(int i10);

    int getRulesCount();

    List<UsageRule> getRulesList();

    UsageRuleOrBuilder getRulesOrBuilder(int i10);

    List<? extends UsageRuleOrBuilder> getRulesOrBuilderList();
}
