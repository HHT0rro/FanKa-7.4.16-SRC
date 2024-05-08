package com.google.rpc;

import com.google.protobuf.MessageOrBuilder;
import com.google.rpc.BadRequest;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface BadRequestOrBuilder extends MessageOrBuilder {
    BadRequest.FieldViolation getFieldViolations(int i10);

    int getFieldViolationsCount();

    List<BadRequest.FieldViolation> getFieldViolationsList();

    BadRequest.FieldViolationOrBuilder getFieldViolationsOrBuilder(int i10);

    List<? extends BadRequest.FieldViolationOrBuilder> getFieldViolationsOrBuilderList();
}
