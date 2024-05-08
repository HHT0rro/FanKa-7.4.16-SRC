package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ContextRuleOrBuilder extends MessageOrBuilder {
    String getAllowedRequestExtensions(int i10);

    ByteString getAllowedRequestExtensionsBytes(int i10);

    int getAllowedRequestExtensionsCount();

    List<String> getAllowedRequestExtensionsList();

    String getAllowedResponseExtensions(int i10);

    ByteString getAllowedResponseExtensionsBytes(int i10);

    int getAllowedResponseExtensionsCount();

    List<String> getAllowedResponseExtensionsList();

    String getProvided(int i10);

    ByteString getProvidedBytes(int i10);

    int getProvidedCount();

    List<String> getProvidedList();

    String getRequested(int i10);

    ByteString getRequestedBytes(int i10);

    int getRequestedCount();

    List<String> getRequestedList();

    String getSelector();

    ByteString getSelectorBytes();
}
