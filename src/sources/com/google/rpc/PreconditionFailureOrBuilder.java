package com.google.rpc;

import com.google.protobuf.MessageOrBuilder;
import com.google.rpc.PreconditionFailure;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface PreconditionFailureOrBuilder extends MessageOrBuilder {
    PreconditionFailure.Violation getViolations(int i10);

    int getViolationsCount();

    List<PreconditionFailure.Violation> getViolationsList();

    PreconditionFailure.ViolationOrBuilder getViolationsOrBuilder(int i10);

    List<? extends PreconditionFailure.ViolationOrBuilder> getViolationsOrBuilderList();
}
