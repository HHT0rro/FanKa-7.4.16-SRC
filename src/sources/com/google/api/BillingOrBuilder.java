package com.google.api;

import com.google.api.Billing;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface BillingOrBuilder extends MessageOrBuilder {
    Billing.BillingDestination getConsumerDestinations(int i10);

    int getConsumerDestinationsCount();

    List<Billing.BillingDestination> getConsumerDestinationsList();

    Billing.BillingDestinationOrBuilder getConsumerDestinationsOrBuilder(int i10);

    List<? extends Billing.BillingDestinationOrBuilder> getConsumerDestinationsOrBuilderList();
}
