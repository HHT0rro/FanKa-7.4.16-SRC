package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface WaitOperationRequestOrBuilder extends MessageOrBuilder {
    String getName();

    ByteString getNameBytes();

    Duration getTimeout();

    DurationOrBuilder getTimeoutOrBuilder();

    boolean hasTimeout();
}
