package com.google.api;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface SourceInfoOrBuilder extends MessageOrBuilder {
    Any getSourceFiles(int i10);

    int getSourceFilesCount();

    List<Any> getSourceFilesList();

    AnyOrBuilder getSourceFilesOrBuilder(int i10);

    List<? extends AnyOrBuilder> getSourceFilesOrBuilderList();
}
