package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface DocumentationOrBuilder extends MessageOrBuilder {
    String getDocumentationRootUrl();

    ByteString getDocumentationRootUrlBytes();

    String getOverview();

    ByteString getOverviewBytes();

    Page getPages(int i10);

    int getPagesCount();

    List<Page> getPagesList();

    PageOrBuilder getPagesOrBuilder(int i10);

    List<? extends PageOrBuilder> getPagesOrBuilderList();

    DocumentationRule getRules(int i10);

    int getRulesCount();

    List<DocumentationRule> getRulesList();

    DocumentationRuleOrBuilder getRulesOrBuilder(int i10);

    List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList();

    String getServiceRootUrl();

    ByteString getServiceRootUrlBytes();

    String getSummary();

    ByteString getSummaryBytes();
}
