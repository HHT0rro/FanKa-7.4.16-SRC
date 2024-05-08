package com.google.api;

import com.google.api.MetricDescriptor;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface MetricDescriptorOrBuilder extends MessageOrBuilder {
    String getDescription();

    ByteString getDescriptionBytes();

    String getDisplayName();

    ByteString getDisplayNameBytes();

    LabelDescriptor getLabels(int i10);

    int getLabelsCount();

    List<LabelDescriptor> getLabelsList();

    LabelDescriptorOrBuilder getLabelsOrBuilder(int i10);

    List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList();

    LaunchStage getLaunchStage();

    int getLaunchStageValue();

    MetricDescriptor.MetricDescriptorMetadata getMetadata();

    MetricDescriptor.MetricDescriptorMetadataOrBuilder getMetadataOrBuilder();

    MetricDescriptor.MetricKind getMetricKind();

    int getMetricKindValue();

    String getMonitoredResourceTypes(int i10);

    ByteString getMonitoredResourceTypesBytes(int i10);

    int getMonitoredResourceTypesCount();

    List<String> getMonitoredResourceTypesList();

    String getName();

    ByteString getNameBytes();

    String getType();

    ByteString getTypeBytes();

    String getUnit();

    ByteString getUnitBytes();

    MetricDescriptor.ValueType getValueType();

    int getValueTypeValue();

    boolean hasMetadata();
}
