package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.api.DocumentationRule;
import com.google.api.Page;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import u7.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Documentation extends GeneratedMessageV3 implements DocumentationOrBuilder {
    public static final int DOCUMENTATION_ROOT_URL_FIELD_NUMBER = 4;
    public static final int OVERVIEW_FIELD_NUMBER = 2;
    public static final int PAGES_FIELD_NUMBER = 5;
    public static final int RULES_FIELD_NUMBER = 3;
    public static final int SERVICE_ROOT_URL_FIELD_NUMBER = 6;
    public static final int SUMMARY_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private volatile Object documentationRootUrl_;
    private byte memoizedIsInitialized;
    private volatile Object overview_;
    private List<Page> pages_;
    private List<DocumentationRule> rules_;
    private volatile Object serviceRootUrl_;
    private volatile Object summary_;
    private static final Documentation DEFAULT_INSTANCE = new Documentation();
    private static final Parser<Documentation> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DocumentationOrBuilder {
        private int bitField0_;
        private Object documentationRootUrl_;
        private Object overview_;
        private RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> pagesBuilder_;
        private List<Page> pages_;
        private RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> rulesBuilder_;
        private List<DocumentationRule> rules_;
        private Object serviceRootUrl_;
        private Object summary_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensurePagesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.pages_ = new ArrayList(this.pages_);
                this.bitField0_ |= 1;
            }
        }

        private void ensureRulesIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.rules_ = new ArrayList(this.rules_);
                this.bitField0_ |= 2;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return k.f53920a;
        }

        private RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> getPagesFieldBuilder() {
            if (this.pagesBuilder_ == null) {
                this.pagesBuilder_ = new RepeatedFieldBuilderV3<>(this.pages_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.pages_ = null;
            }
            return this.pagesBuilder_;
        }

        private RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> getRulesFieldBuilder() {
            if (this.rulesBuilder_ == null) {
                this.rulesBuilder_ = new RepeatedFieldBuilderV3<>(this.rules_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.rules_ = null;
            }
            return this.rulesBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getPagesFieldBuilder();
                getRulesFieldBuilder();
            }
        }

        public Builder addAllPages(Iterable<? extends Page> iterable) {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensurePagesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.pages_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAllRules(Iterable<? extends DocumentationRule> iterable) {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRulesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.rules_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addPages(Page page) {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(page);
                ensurePagesIsMutable();
                this.pages_.add(page);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(page);
            }
            return this;
        }

        public Page.Builder addPagesBuilder() {
            return getPagesFieldBuilder().addBuilder(Page.getDefaultInstance());
        }

        public Builder addRules(DocumentationRule documentationRule) {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(documentationRule);
                ensureRulesIsMutable();
                this.rules_.add(documentationRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(documentationRule);
            }
            return this;
        }

        public DocumentationRule.Builder addRulesBuilder() {
            return getRulesFieldBuilder().addBuilder(DocumentationRule.getDefaultInstance());
        }

        public Builder clearDocumentationRootUrl() {
            this.documentationRootUrl_ = Documentation.getDefaultInstance().getDocumentationRootUrl();
            onChanged();
            return this;
        }

        public Builder clearOverview() {
            this.overview_ = Documentation.getDefaultInstance().getOverview();
            onChanged();
            return this;
        }

        public Builder clearPages() {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.pages_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearRules() {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.rules_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearServiceRootUrl() {
            this.serviceRootUrl_ = Documentation.getDefaultInstance().getServiceRootUrl();
            onChanged();
            return this;
        }

        public Builder clearSummary() {
            this.summary_ = Documentation.getDefaultInstance().getSummary();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return k.f53920a;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public String getDocumentationRootUrl() {
            Object obj = this.documentationRootUrl_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.documentationRootUrl_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getDocumentationRootUrlBytes() {
            Object obj = this.documentationRootUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.documentationRootUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public String getOverview() {
            Object obj = this.overview_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.overview_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getOverviewBytes() {
            Object obj = this.overview_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.overview_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public Page getPages(int i10) {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.pages_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public Page.Builder getPagesBuilder(int i10) {
            return getPagesFieldBuilder().getBuilder(i10);
        }

        public List<Page.Builder> getPagesBuilderList() {
            return getPagesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public int getPagesCount() {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.pages_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public List<Page> getPagesList() {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.pages_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public PageOrBuilder getPagesOrBuilder(int i10) {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.pages_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.DocumentationOrBuilder
        public List<? extends PageOrBuilder> getPagesOrBuilderList() {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.pages_);
        }

        @Override // com.google.api.DocumentationOrBuilder
        public DocumentationRule getRules(int i10) {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.rules_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public DocumentationRule.Builder getRulesBuilder(int i10) {
            return getRulesFieldBuilder().getBuilder(i10);
        }

        public List<DocumentationRule.Builder> getRulesBuilderList() {
            return getRulesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public int getRulesCount() {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.rules_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public List<DocumentationRule> getRulesList() {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.rules_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public DocumentationRuleOrBuilder getRulesOrBuilder(int i10) {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.rules_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.DocumentationOrBuilder
        public List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList() {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.rules_);
        }

        @Override // com.google.api.DocumentationOrBuilder
        public String getServiceRootUrl() {
            Object obj = this.serviceRootUrl_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.serviceRootUrl_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getServiceRootUrlBytes() {
            Object obj = this.serviceRootUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serviceRootUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public String getSummary() {
            Object obj = this.summary_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.summary_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getSummaryBytes() {
            Object obj = this.summary_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.summary_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return k.f53921b.ensureFieldAccessorsInitialized(Documentation.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder removePages(int i10) {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensurePagesIsMutable();
                this.pages_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder removeRules(int i10) {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRulesIsMutable();
                this.rules_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setDocumentationRootUrl(String str) {
            Objects.requireNonNull(str);
            this.documentationRootUrl_ = str;
            onChanged();
            return this;
        }

        public Builder setDocumentationRootUrlBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.documentationRootUrl_ = byteString;
            onChanged();
            return this;
        }

        public Builder setOverview(String str) {
            Objects.requireNonNull(str);
            this.overview_ = str;
            onChanged();
            return this;
        }

        public Builder setOverviewBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.overview_ = byteString;
            onChanged();
            return this;
        }

        public Builder setPages(int i10, Page page) {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(page);
                ensurePagesIsMutable();
                this.pages_.set(i10, page);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, page);
            }
            return this;
        }

        public Builder setRules(int i10, DocumentationRule documentationRule) {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(documentationRule);
                ensureRulesIsMutable();
                this.rules_.set(i10, documentationRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, documentationRule);
            }
            return this;
        }

        public Builder setServiceRootUrl(String str) {
            Objects.requireNonNull(str);
            this.serviceRootUrl_ = str;
            onChanged();
            return this;
        }

        public Builder setServiceRootUrlBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.serviceRootUrl_ = byteString;
            onChanged();
            return this;
        }

        public Builder setSummary(String str) {
            Objects.requireNonNull(str);
            this.summary_ = str;
            onChanged();
            return this;
        }

        public Builder setSummaryBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.summary_ = byteString;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        public Page.Builder addPagesBuilder(int i10) {
            return getPagesFieldBuilder().addBuilder(i10, Page.getDefaultInstance());
        }

        private Builder() {
            this.summary_ = "";
            this.pages_ = Collections.emptyList();
            this.rules_ = Collections.emptyList();
            this.documentationRootUrl_ = "";
            this.serviceRootUrl_ = "";
            this.overview_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public DocumentationRule.Builder addRulesBuilder(int i10) {
            return getRulesFieldBuilder().addBuilder(i10, DocumentationRule.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Documentation build() {
            Documentation buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Documentation buildPartial() {
            Documentation documentation = new Documentation(this, (a) null);
            documentation.summary_ = this.summary_;
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.pages_ = Collections.unmodifiableList(this.pages_);
                    this.bitField0_ &= -2;
                }
                documentation.pages_ = this.pages_;
            } else {
                documentation.pages_ = repeatedFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV32 = this.rulesBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.rules_ = Collections.unmodifiableList(this.rules_);
                    this.bitField0_ &= -3;
                }
                documentation.rules_ = this.rules_;
            } else {
                documentation.rules_ = repeatedFieldBuilderV32.build();
            }
            documentation.documentationRootUrl_ = this.documentationRootUrl_;
            documentation.serviceRootUrl_ = this.serviceRootUrl_;
            documentation.overview_ = this.overview_;
            onBuilt();
            return documentation;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Documentation getDefaultInstanceForType() {
            return Documentation.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.summary_ = "";
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.pages_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV32 = this.rulesBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                this.rules_ = Collections.emptyList();
                this.bitField0_ &= -3;
            } else {
                repeatedFieldBuilderV32.clear();
            }
            this.documentationRootUrl_ = "";
            this.serviceRootUrl_ = "";
            this.overview_ = "";
            return this;
        }

        public Builder addPages(int i10, Page page) {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(page);
                ensurePagesIsMutable();
                this.pages_.add(i10, page);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, page);
            }
            return this;
        }

        public Builder addRules(int i10, DocumentationRule documentationRule) {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(documentationRule);
                ensureRulesIsMutable();
                this.rules_.add(i10, documentationRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, documentationRule);
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Documentation) {
                return mergeFrom((Documentation) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setPages(int i10, Page.Builder builder) {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensurePagesIsMutable();
                this.pages_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder setRules(int i10, DocumentationRule.Builder builder) {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRulesIsMutable();
                this.rules_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder mergeFrom(Documentation documentation) {
            if (documentation == Documentation.getDefaultInstance()) {
                return this;
            }
            if (!documentation.getSummary().isEmpty()) {
                this.summary_ = documentation.summary_;
                onChanged();
            }
            if (this.pagesBuilder_ == null) {
                if (!documentation.pages_.isEmpty()) {
                    if (this.pages_.isEmpty()) {
                        this.pages_ = documentation.pages_;
                        this.bitField0_ &= -2;
                    } else {
                        ensurePagesIsMutable();
                        this.pages_.addAll(documentation.pages_);
                    }
                    onChanged();
                }
            } else if (!documentation.pages_.isEmpty()) {
                if (this.pagesBuilder_.isEmpty()) {
                    this.pagesBuilder_.dispose();
                    this.pagesBuilder_ = null;
                    this.pages_ = documentation.pages_;
                    this.bitField0_ &= -2;
                    this.pagesBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getPagesFieldBuilder() : null;
                } else {
                    this.pagesBuilder_.addAllMessages(documentation.pages_);
                }
            }
            if (this.rulesBuilder_ == null) {
                if (!documentation.rules_.isEmpty()) {
                    if (this.rules_.isEmpty()) {
                        this.rules_ = documentation.rules_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureRulesIsMutable();
                        this.rules_.addAll(documentation.rules_);
                    }
                    onChanged();
                }
            } else if (!documentation.rules_.isEmpty()) {
                if (this.rulesBuilder_.isEmpty()) {
                    this.rulesBuilder_.dispose();
                    this.rulesBuilder_ = null;
                    this.rules_ = documentation.rules_;
                    this.bitField0_ &= -3;
                    this.rulesBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getRulesFieldBuilder() : null;
                } else {
                    this.rulesBuilder_.addAllMessages(documentation.rules_);
                }
            }
            if (!documentation.getDocumentationRootUrl().isEmpty()) {
                this.documentationRootUrl_ = documentation.documentationRootUrl_;
                onChanged();
            }
            if (!documentation.getServiceRootUrl().isEmpty()) {
                this.serviceRootUrl_ = documentation.serviceRootUrl_;
                onChanged();
            }
            if (!documentation.getOverview().isEmpty()) {
                this.overview_ = documentation.overview_;
                onChanged();
            }
            mergeUnknownFields(documentation.unknownFields);
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.summary_ = "";
            this.pages_ = Collections.emptyList();
            this.rules_ = Collections.emptyList();
            this.documentationRootUrl_ = "";
            this.serviceRootUrl_ = "";
            this.overview_ = "";
            maybeForceBuilderInitialization();
        }

        public Builder addPages(Page.Builder builder) {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensurePagesIsMutable();
                this.pages_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addRules(DocumentationRule.Builder builder) {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRulesIsMutable();
                this.rules_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addPages(int i10, Page.Builder builder) {
            RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensurePagesIsMutable();
                this.pages_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        public Builder addRules(int i10, DocumentationRule.Builder builder) {
            RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRulesIsMutable();
                this.rules_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.Documentation.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.Documentation.access$1300()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.Documentation r3 = (com.google.api.Documentation) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                if (r3 == 0) goto L10
                r2.mergeFrom(r3)
            L10:
                return r2
            L11:
                r3 = move-exception
                goto L21
            L13:
                r3 = move-exception
                com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                com.google.api.Documentation r4 = (com.google.api.Documentation) r4     // Catch: java.lang.Throwable -> L11
                java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                throw r3     // Catch: java.lang.Throwable -> L1f
            L1f:
                r3 = move-exception
                r0 = r4
            L21:
                if (r0 == 0) goto L26
                r2.mergeFrom(r0)
            L26:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Documentation.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Documentation$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<Documentation> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Documentation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Documentation(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ Documentation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static Documentation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return k.f53920a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Documentation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Documentation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Documentation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Documentation> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Documentation)) {
            return super.equals(obj);
        }
        Documentation documentation = (Documentation) obj;
        return getSummary().equals(documentation.getSummary()) && getPagesList().equals(documentation.getPagesList()) && getRulesList().equals(documentation.getRulesList()) && getDocumentationRootUrl().equals(documentation.getDocumentationRootUrl()) && getServiceRootUrl().equals(documentation.getServiceRootUrl()) && getOverview().equals(documentation.getOverview()) && this.unknownFields.equals(documentation.unknownFields);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public String getDocumentationRootUrl() {
        Object obj = this.documentationRootUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.documentationRootUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getDocumentationRootUrlBytes() {
        Object obj = this.documentationRootUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.documentationRootUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public String getOverview() {
        Object obj = this.overview_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.overview_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getOverviewBytes() {
        Object obj = this.overview_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.overview_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public Page getPages(int i10) {
        return this.pages_.get(i10);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public int getPagesCount() {
        return this.pages_.size();
    }

    @Override // com.google.api.DocumentationOrBuilder
    public List<Page> getPagesList() {
        return this.pages_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public PageOrBuilder getPagesOrBuilder(int i10) {
        return this.pages_.get(i10);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public List<? extends PageOrBuilder> getPagesOrBuilderList() {
        return this.pages_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Documentation> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public DocumentationRule getRules(int i10) {
        return this.rules_.get(i10);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.DocumentationOrBuilder
    public List<DocumentationRule> getRulesList() {
        return this.rules_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public DocumentationRuleOrBuilder getRulesOrBuilder(int i10) {
        return this.rules_.get(i10);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = !GeneratedMessageV3.isStringEmpty(this.summary_) ? GeneratedMessageV3.computeStringSize(1, this.summary_) + 0 : 0;
        if (!GeneratedMessageV3.isStringEmpty(this.overview_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.overview_);
        }
        for (int i11 = 0; i11 < this.rules_.size(); i11++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, this.rules_.get(i11));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.documentationRootUrl_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(4, this.documentationRootUrl_);
        }
        for (int i12 = 0; i12 < this.pages_.size(); i12++) {
            computeStringSize += CodedOutputStream.computeMessageSize(5, this.pages_.get(i12));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.serviceRootUrl_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(6, this.serviceRootUrl_);
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public String getServiceRootUrl() {
        Object obj = this.serviceRootUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.serviceRootUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getServiceRootUrlBytes() {
        Object obj = this.serviceRootUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.serviceRootUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public String getSummary() {
        Object obj = this.summary_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.summary_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getSummaryBytes() {
        Object obj = this.summary_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.summary_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getSummary().hashCode();
        if (getPagesCount() > 0) {
            hashCode = (((hashCode * 37) + 5) * 53) + getPagesList().hashCode();
        }
        if (getRulesCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getRulesList().hashCode();
        }
        int hashCode2 = (((((((((((((hashCode * 37) + 4) * 53) + getDocumentationRootUrl().hashCode()) * 37) + 6) * 53) + getServiceRootUrl().hashCode()) * 37) + 2) * 53) + getOverview().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return k.f53921b.ensureFieldAccessorsInitialized(Documentation.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b4 = this.memoizedIsInitialized;
        if (b4 == 1) {
            return true;
        }
        if (b4 == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Documentation();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.summary_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.summary_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.overview_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.overview_);
        }
        for (int i10 = 0; i10 < this.rules_.size(); i10++) {
            codedOutputStream.writeMessage(3, this.rules_.get(i10));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.documentationRootUrl_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.documentationRootUrl_);
        }
        for (int i11 = 0; i11 < this.pages_.size(); i11++) {
            codedOutputStream.writeMessage(5, this.pages_.get(i11));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.serviceRootUrl_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.serviceRootUrl_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ Documentation(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(Documentation documentation) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(documentation);
    }

    public static Documentation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Documentation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private Documentation(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Documentation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Documentation getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static Documentation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Documentation() {
        this.memoizedIsInitialized = (byte) -1;
        this.summary_ = "";
        this.pages_ = Collections.emptyList();
        this.rules_ = Collections.emptyList();
        this.documentationRootUrl_ = "";
        this.serviceRootUrl_ = "";
        this.overview_ = "";
    }

    public static Documentation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static Documentation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Documentation parseFrom(InputStream inputStream) throws IOException {
        return (Documentation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Documentation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Documentation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Documentation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Documentation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Documentation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.summary_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.overview_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                if ((i10 & 2) == 0) {
                                    this.rules_ = new ArrayList();
                                    i10 |= 2;
                                }
                                this.rules_.add(codedInputStream.readMessage(DocumentationRule.parser(), extensionRegistryLite));
                            } else if (readTag == 34) {
                                this.documentationRootUrl_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                if ((i10 & 1) == 0) {
                                    this.pages_ = new ArrayList();
                                    i10 |= 1;
                                }
                                this.pages_.add(codedInputStream.readMessage(Page.parser(), extensionRegistryLite));
                            } else if (readTag != 50) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.serviceRootUrl_ = codedInputStream.readStringRequireUtf8();
                            }
                        }
                        z10 = true;
                    } catch (UninitializedMessageException e2) {
                        throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e11) {
                    throw e11.setUnfinishedMessage(this);
                }
            } finally {
                if ((i10 & 2) != 0) {
                    this.rules_ = Collections.unmodifiableList(this.rules_);
                }
                if ((i10 & 1) != 0) {
                    this.pages_ = Collections.unmodifiableList(this.pages_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }
}
