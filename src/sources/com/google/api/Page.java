package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
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
public final class Page extends GeneratedMessageV3 implements PageOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int SUBPAGES_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private volatile Object content_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<Page> subpages_;
    private static final Page DEFAULT_INSTANCE = new Page();
    private static final Parser<Page> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PageOrBuilder {
        private int bitField0_;
        private Object content_;
        private Object name_;
        private RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> subpagesBuilder_;
        private List<Page> subpages_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureSubpagesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.subpages_ = new ArrayList(this.subpages_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return k.f53924e;
        }

        private RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> getSubpagesFieldBuilder() {
            if (this.subpagesBuilder_ == null) {
                this.subpagesBuilder_ = new RepeatedFieldBuilderV3<>(this.subpages_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.subpages_ = null;
            }
            return this.subpagesBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getSubpagesFieldBuilder();
            }
        }

        public Builder addAllSubpages(Iterable<? extends Page> iterable) {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSubpagesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.subpages_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addSubpages(Page page) {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(page);
                ensureSubpagesIsMutable();
                this.subpages_.add(page);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(page);
            }
            return this;
        }

        public Builder addSubpagesBuilder() {
            return getSubpagesFieldBuilder().addBuilder(Page.getDefaultInstance());
        }

        public Builder clearContent() {
            this.content_ = Page.getDefaultInstance().getContent();
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Page.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder clearSubpages() {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.subpages_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        @Override // com.google.api.PageOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.content_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.PageOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return k.f53924e;
        }

        @Override // com.google.api.PageOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.PageOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.PageOrBuilder
        public Page getSubpages(int i10) {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.subpages_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public Builder getSubpagesBuilder(int i10) {
            return getSubpagesFieldBuilder().getBuilder(i10);
        }

        public List<Builder> getSubpagesBuilderList() {
            return getSubpagesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.PageOrBuilder
        public int getSubpagesCount() {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.subpages_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.PageOrBuilder
        public List<Page> getSubpagesList() {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.subpages_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.PageOrBuilder
        public PageOrBuilder getSubpagesOrBuilder(int i10) {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.subpages_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.PageOrBuilder
        public List<? extends PageOrBuilder> getSubpagesOrBuilderList() {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.subpages_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return k.f53925f.ensureFieldAccessorsInitialized(Page.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder removeSubpages(int i10) {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSubpagesIsMutable();
                this.subpages_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setContent(String str) {
            Objects.requireNonNull(str);
            this.content_ = str;
            onChanged();
            return this;
        }

        public Builder setContentBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.content_ = byteString;
            onChanged();
            return this;
        }

        public Builder setName(String str) {
            Objects.requireNonNull(str);
            this.name_ = str;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            onChanged();
            return this;
        }

        public Builder setSubpages(int i10, Page page) {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(page);
                ensureSubpagesIsMutable();
                this.subpages_.set(i10, page);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, page);
            }
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        public Builder addSubpagesBuilder(int i10) {
            return getSubpagesFieldBuilder().addBuilder(i10, Page.getDefaultInstance());
        }

        private Builder() {
            this.name_ = "";
            this.content_ = "";
            this.subpages_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Page build() {
            Page buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Page buildPartial() {
            Page page = new Page(this, (a) null);
            page.name_ = this.name_;
            page.content_ = this.content_;
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.subpages_ = Collections.unmodifiableList(this.subpages_);
                    this.bitField0_ &= -2;
                }
                page.subpages_ = this.subpages_;
            } else {
                page.subpages_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return page;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Page getDefaultInstanceForType() {
            return Page.getDefaultInstance();
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
            this.name_ = "";
            this.content_ = "";
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.subpages_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder addSubpages(int i10, Page page) {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(page);
                ensureSubpagesIsMutable();
                this.subpages_.add(i10, page);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, page);
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
            if (message instanceof Page) {
                return mergeFrom((Page) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setSubpages(int i10, Builder builder) {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSubpagesIsMutable();
                this.subpages_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.content_ = "";
            this.subpages_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder mergeFrom(Page page) {
            if (page == Page.getDefaultInstance()) {
                return this;
            }
            if (!page.getName().isEmpty()) {
                this.name_ = page.name_;
                onChanged();
            }
            if (!page.getContent().isEmpty()) {
                this.content_ = page.content_;
                onChanged();
            }
            if (this.subpagesBuilder_ == null) {
                if (!page.subpages_.isEmpty()) {
                    if (this.subpages_.isEmpty()) {
                        this.subpages_ = page.subpages_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureSubpagesIsMutable();
                        this.subpages_.addAll(page.subpages_);
                    }
                    onChanged();
                }
            } else if (!page.subpages_.isEmpty()) {
                if (this.subpagesBuilder_.isEmpty()) {
                    this.subpagesBuilder_.dispose();
                    this.subpagesBuilder_ = null;
                    this.subpages_ = page.subpages_;
                    this.bitField0_ &= -2;
                    this.subpagesBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getSubpagesFieldBuilder() : null;
                } else {
                    this.subpagesBuilder_.addAllMessages(page.subpages_);
                }
            }
            mergeUnknownFields(page.unknownFields);
            onChanged();
            return this;
        }

        public Builder addSubpages(Builder builder) {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSubpagesIsMutable();
                this.subpages_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addSubpages(int i10, Builder builder) {
            RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSubpagesIsMutable();
                this.subpages_.add(i10, builder.build());
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
        public com.google.api.Page.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.Page.access$900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.Page r3 = (com.google.api.Page) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.Page r4 = (com.google.api.Page) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Page.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Page$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<Page> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Page parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Page(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ Page(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static Page getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return k.f53924e;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Page parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Page) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Page parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Page> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Page)) {
            return super.equals(obj);
        }
        Page page = (Page) obj;
        return getName().equals(page.getName()) && getContent().equals(page.getContent()) && getSubpagesList().equals(page.getSubpagesList()) && this.unknownFields.equals(page.unknownFields);
    }

    @Override // com.google.api.PageOrBuilder
    public String getContent() {
        Object obj = this.content_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.content_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.PageOrBuilder
    public ByteString getContentBytes() {
        Object obj = this.content_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.content_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.PageOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.PageOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Page> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = !GeneratedMessageV3.isStringEmpty(this.name_) ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        if (!GeneratedMessageV3.isStringEmpty(this.content_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.content_);
        }
        for (int i11 = 0; i11 < this.subpages_.size(); i11++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, this.subpages_.get(i11));
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.api.PageOrBuilder
    public Page getSubpages(int i10) {
        return this.subpages_.get(i10);
    }

    @Override // com.google.api.PageOrBuilder
    public int getSubpagesCount() {
        return this.subpages_.size();
    }

    @Override // com.google.api.PageOrBuilder
    public List<Page> getSubpagesList() {
        return this.subpages_;
    }

    @Override // com.google.api.PageOrBuilder
    public PageOrBuilder getSubpagesOrBuilder(int i10) {
        return this.subpages_.get(i10);
    }

    @Override // com.google.api.PageOrBuilder
    public List<? extends PageOrBuilder> getSubpagesOrBuilderList() {
        return this.subpages_;
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
        int hashCode = ((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getContent().hashCode();
        if (getSubpagesCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getSubpagesList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return k.f53925f.ensureFieldAccessorsInitialized(Page.class, Builder.class);
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
        return new Page();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.content_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.content_);
        }
        for (int i10 = 0; i10 < this.subpages_.size(); i10++) {
            codedOutputStream.writeMessage(3, this.subpages_.get(i10));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ Page(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(Page page) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(page);
    }

    public static Page parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Page) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Page parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private Page(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Page parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Page getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static Page parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Page() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.content_ = "";
        this.subpages_ = Collections.emptyList();
    }

    public static Page parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static Page parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Page parseFrom(InputStream inputStream) throws IOException {
        return (Page) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Page parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Page) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Page parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Page) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Page(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.content_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag != 26) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z11 & true)) {
                                    this.subpages_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.subpages_.add(codedInputStream.readMessage(parser(), extensionRegistryLite));
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
                if (z11 & true) {
                    this.subpages_ = Collections.unmodifiableList(this.subpages_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static Page parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Page) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
