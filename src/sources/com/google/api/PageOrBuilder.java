package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface PageOrBuilder extends MessageOrBuilder {
    String getContent();

    ByteString getContentBytes();

    String getName();

    ByteString getNameBytes();

    Page getSubpages(int i10);

    int getSubpagesCount();

    List<Page> getSubpagesList();

    PageOrBuilder getSubpagesOrBuilder(int i10);

    List<? extends PageOrBuilder> getSubpagesOrBuilderList();
}
