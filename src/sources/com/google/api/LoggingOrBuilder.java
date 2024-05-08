package com.google.api;

import com.google.api.Logging;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface LoggingOrBuilder extends MessageOrBuilder {
    Logging.LoggingDestination getConsumerDestinations(int i10);

    int getConsumerDestinationsCount();

    List<Logging.LoggingDestination> getConsumerDestinationsList();

    Logging.LoggingDestinationOrBuilder getConsumerDestinationsOrBuilder(int i10);

    List<? extends Logging.LoggingDestinationOrBuilder> getConsumerDestinationsOrBuilderList();

    Logging.LoggingDestination getProducerDestinations(int i10);

    int getProducerDestinationsCount();

    List<Logging.LoggingDestination> getProducerDestinationsList();

    Logging.LoggingDestinationOrBuilder getProducerDestinationsOrBuilder(int i10);

    List<? extends Logging.LoggingDestinationOrBuilder> getProducerDestinationsOrBuilderList();
}
