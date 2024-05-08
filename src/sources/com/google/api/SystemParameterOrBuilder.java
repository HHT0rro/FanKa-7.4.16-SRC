package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface SystemParameterOrBuilder extends MessageOrBuilder {
    String getHttpHeader();

    ByteString getHttpHeaderBytes();

    String getName();

    ByteString getNameBytes();

    String getUrlQueryParameter();

    ByteString getUrlQueryParameterBytes();
}
