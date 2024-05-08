package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface QuotaOrBuilder extends MessageOrBuilder {
    QuotaLimit getLimits(int i10);

    int getLimitsCount();

    List<QuotaLimit> getLimitsList();

    QuotaLimitOrBuilder getLimitsOrBuilder(int i10);

    List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList();

    MetricRule getMetricRules(int i10);

    int getMetricRulesCount();

    List<MetricRule> getMetricRulesList();

    MetricRuleOrBuilder getMetricRulesOrBuilder(int i10);

    List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList();
}
