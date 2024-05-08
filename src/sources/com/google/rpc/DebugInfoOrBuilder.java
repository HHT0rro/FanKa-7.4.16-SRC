package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface DebugInfoOrBuilder extends MessageOrBuilder {
    String getDetail();

    ByteString getDetailBytes();

    String getStackEntries(int i10);

    ByteString getStackEntriesBytes(int i10);

    int getStackEntriesCount();

    List<String> getStackEntriesList();
}
