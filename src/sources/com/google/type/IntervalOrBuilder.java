package com.google.type;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IntervalOrBuilder extends MessageOrBuilder {
    Timestamp getEndTime();

    TimestampOrBuilder getEndTimeOrBuilder();

    Timestamp getStartTime();

    TimestampOrBuilder getStartTimeOrBuilder();

    boolean hasEndTime();

    boolean hasStartTime();
}
