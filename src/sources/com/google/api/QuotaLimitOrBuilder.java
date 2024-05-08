package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface QuotaLimitOrBuilder extends MessageOrBuilder {
    boolean containsValues(String str);

    long getDefaultLimit();

    String getDescription();

    ByteString getDescriptionBytes();

    String getDisplayName();

    ByteString getDisplayNameBytes();

    String getDuration();

    ByteString getDurationBytes();

    long getFreeTier();

    long getMaxLimit();

    String getMetric();

    ByteString getMetricBytes();

    String getName();

    ByteString getNameBytes();

    String getUnit();

    ByteString getUnitBytes();

    @Deprecated
    Map<String, Long> getValues();

    int getValuesCount();

    Map<String, Long> getValuesMap();

    long getValuesOrDefault(String str, long j10);

    long getValuesOrThrow(String str);
}
