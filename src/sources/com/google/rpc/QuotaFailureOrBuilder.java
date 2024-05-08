package com.google.rpc;

import com.google.protobuf.MessageOrBuilder;
import com.google.rpc.QuotaFailure;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface QuotaFailureOrBuilder extends MessageOrBuilder {
    QuotaFailure.Violation getViolations(int i10);

    int getViolationsCount();

    List<QuotaFailure.Violation> getViolationsList();

    QuotaFailure.ViolationOrBuilder getViolationsOrBuilder(int i10);

    List<? extends QuotaFailure.ViolationOrBuilder> getViolationsOrBuilderList();
}
