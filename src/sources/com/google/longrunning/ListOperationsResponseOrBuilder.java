package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ListOperationsResponseOrBuilder extends MessageOrBuilder {
    String getNextPageToken();

    ByteString getNextPageTokenBytes();

    Operation getOperations(int i10);

    int getOperationsCount();

    List<Operation> getOperationsList();

    OperationOrBuilder getOperationsOrBuilder(int i10);

    List<? extends OperationOrBuilder> getOperationsOrBuilderList();
}
