package com.google.rpc;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface StatusOrBuilder extends MessageOrBuilder {
    int getCode();

    Any getDetails(int i10);

    int getDetailsCount();

    List<Any> getDetailsList();

    AnyOrBuilder getDetailsOrBuilder(int i10);

    List<? extends AnyOrBuilder> getDetailsOrBuilderList();

    String getMessage();

    ByteString getMessageBytes();
}
