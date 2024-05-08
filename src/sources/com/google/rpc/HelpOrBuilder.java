package com.google.rpc;

import com.google.protobuf.MessageOrBuilder;
import com.google.rpc.Help;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface HelpOrBuilder extends MessageOrBuilder {
    Help.Link getLinks(int i10);

    int getLinksCount();

    List<Help.Link> getLinksList();

    Help.LinkOrBuilder getLinksOrBuilder(int i10);

    List<? extends Help.LinkOrBuilder> getLinksOrBuilderList();
}
