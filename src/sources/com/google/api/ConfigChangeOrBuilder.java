package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ConfigChangeOrBuilder extends MessageOrBuilder {
    Advice getAdvices(int i10);

    int getAdvicesCount();

    List<Advice> getAdvicesList();

    AdviceOrBuilder getAdvicesOrBuilder(int i10);

    List<? extends AdviceOrBuilder> getAdvicesOrBuilderList();

    ChangeType getChangeType();

    int getChangeTypeValue();

    String getElement();

    ByteString getElementBytes();

    String getNewValue();

    ByteString getNewValueBytes();

    String getOldValue();

    ByteString getOldValueBytes();
}
