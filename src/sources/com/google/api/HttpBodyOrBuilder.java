package com.google.api;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface HttpBodyOrBuilder extends MessageOrBuilder {
    String getContentType();

    ByteString getContentTypeBytes();

    ByteString getData();

    Any getExtensions(int i10);

    int getExtensionsCount();

    List<Any> getExtensionsList();

    AnyOrBuilder getExtensionsOrBuilder(int i10);

    List<? extends AnyOrBuilder> getExtensionsOrBuilderList();
}
