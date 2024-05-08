package com.google.api;

import com.google.api.Monitoring;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface MonitoringOrBuilder extends MessageOrBuilder {
    Monitoring.MonitoringDestination getConsumerDestinations(int i10);

    int getConsumerDestinationsCount();

    List<Monitoring.MonitoringDestination> getConsumerDestinationsList();

    Monitoring.MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int i10);

    List<? extends Monitoring.MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList();

    Monitoring.MonitoringDestination getProducerDestinations(int i10);

    int getProducerDestinationsCount();

    List<Monitoring.MonitoringDestination> getProducerDestinationsList();

    Monitoring.MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int i10);

    List<? extends Monitoring.MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList();
}
