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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import u7.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ContextRule extends GeneratedMessageV3 implements ContextRuleOrBuilder {
    public static final int ALLOWED_REQUEST_EXTENSIONS_FIELD_NUMBER = 4;
    public static final int ALLOWED_RESPONSE_EXTENSIONS_FIELD_NUMBER = 5;
    private static final ContextRule DEFAULT_INSTANCE = new ContextRule();
    private static final Parser<ContextRule> PARSER = new a();
    public static final int PROVIDED_FIELD_NUMBER = 3;
    public static final int REQUESTED_FIELD_NUMBER = 2;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private LazyStringList allowedRequestExtensions_;
    private LazyStringList allowedResponseExtensions_;
    private byte memoizedIsInitialized;
    private LazyStringList provided_;
    private LazyStringList requested_;
    private volatile Object selector_;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ContextRuleOrBuilder {
        private LazyStringList allowedRequestExtensions_;
        private LazyStringList allowedResponseExtensions_;
        private int bitField0_;
        private LazyStringList provided_;
        private LazyStringList requested_;
        private Object selector_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureAllowedRequestExtensionsIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.allowedRequestExtensions_ = new LazyStringArrayList(this.allowedRequestExtensions_);
                this.bitField0_ |= 4;
            }
        }

        private void ensureAllowedResponseExtensionsIsMutable() {
            if ((this.bitField0_ & 8) == 0) {
                this.allowedResponseExtensions_ = new LazyStringArrayList(this.allowedResponseExtensions_);
                this.bitField0_ |= 8;
            }
        }

        private void ensureProvidedIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.provided_ = new LazyStringArrayList(this.provided_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureRequestedIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.requested_ = new LazyStringArrayList(this.requested_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return h.f53899c;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder addAllAllowedRequestExtensions(Iterable<String> iterable) {
            ensureAllowedRequestExtensionsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.allowedRequestExtensions_);
            onChanged();
            return this;
        }

        public Builder addAllAllowedResponseExtensions(Iterable<String> iterable) {
            ensureAllowedResponseExtensionsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.allowedResponseExtensions_);
            onChanged();
            return this;
        }

        public Builder addAllProvided(Iterable<String> iterable) {
            ensureProvidedIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.provided_);
            onChanged();
            return this;
        }

        public Builder addAllRequested(Iterable<String> iterable) {
            ensureRequestedIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.requested_);
            onChanged();
            return this;
        }

        public Builder addAllowedRequestExtensions(String str) {
            Objects.requireNonNull(str);
            ensureAllowedRequestExtensionsIsMutable();
            this.allowedRequestExtensions_.add((LazyStringList) str);
            onChanged();
            return this;
        }

        public Builder addAllowedRequestExtensionsBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureAllowedRequestExtensionsIsMutable();
            this.allowedRequestExtensions_.add(byteString);
            onChanged();
            return this;
        }

        public Builder addAllowedResponseExtensions(String str) {
            Objects.requireNonNull(str);
            ensureAllowedResponseExtensionsIsMutable();
            this.allowedResponseExtensions_.add((LazyStringList) str);
            onChanged();
            return this;
        }

        public Builder addAllowedResponseExtensionsBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureAllowedResponseExtensionsIsMutable();
            this.allowedResponseExtensions_.add(byteString);
            onChanged();
            return this;
        }

        public Builder addProvided(String str) {
            Objects.requireNonNull(str);
            ensureProvidedIsMutable();
            this.provided_.add((LazyStringList) str);
            onChanged();
            return this;
        }

        public Builder addProvidedBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureProvidedIsMutable();
            this.provided_.add(byteString);
            onChanged();
            return this;
        }

        public Builder addRequested(String str) {
            Objects.requireNonNull(str);
            ensureRequestedIsMutable();
            this.requested_.add((LazyStringList) str);
            onChanged();
            return this;
        }

        public Builder addRequestedBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureRequestedIsMutable();
            this.requested_.add(byteString);
            onChanged();
            return this;
        }

        public Builder clearAllowedRequestExtensions() {
            this.allowedRequestExtensions_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearAllowedResponseExtensions() {
            this.allowedResponseExtensions_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearProvided() {
            this.provided_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearRequested() {
            this.requested_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearSelector() {
            this.selector_ = ContextRule.getDefaultInstance().getSelector();
            onChanged();
            return this;
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getAllowedRequestExtensions(int i10) {
            return this.allowedRequestExtensions_.get(i10);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getAllowedRequestExtensionsBytes(int i10) {
            return this.allowedRequestExtensions_.getByteString(i10);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getAllowedRequestExtensionsCount() {
            return this.allowedRequestExtensions_.size();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getAllowedResponseExtensions(int i10) {
            return this.allowedResponseExtensions_.get(i10);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getAllowedResponseExtensionsBytes(int i10) {
            return this.allowedResponseExtensions_.getByteString(i10);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getAllowedResponseExtensionsCount() {
            return this.allowedResponseExtensions_.size();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return h.f53899c;
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getProvided(int i10) {
            return this.provided_.get(i10);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getProvidedBytes(int i10) {
            return this.provided_.getByteString(i10);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getProvidedCount() {
            return this.provided_.size();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getRequested(int i10) {
            return this.requested_.get(i10);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getRequestedBytes(int i10) {
            return this.requested_.getByteString(i10);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getRequestedCount() {
            return this.requested_.size();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getSelector() {
            Object obj = this.selector_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.selector_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getSelectorBytes() {
            Object obj = this.selector_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.selector_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return h.f53900d.ensureFieldAccessorsInitialized(ContextRule.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setAllowedRequestExtensions(int i10, String str) {
            Objects.requireNonNull(str);
            ensureAllowedRequestExtensionsIsMutable();
            this.allowedRequestExtensions_.set(i10, (int) str);
            onChanged();
            return this;
        }

        public Builder setAllowedResponseExtensions(int i10, String str) {
            Objects.requireNonNull(str);
            ensureAllowedResponseExtensionsIsMutable();
            this.allowedResponseExtensions_.set(i10, (int) str);
            onChanged();
            return this;
        }

        public Builder setProvided(int i10, String str) {
            Objects.requireNonNull(str);
            ensureProvidedIsMutable();
            this.provided_.set(i10, (int) str);
            onChanged();
            return this;
        }

        public Builder setRequested(int i10, String str) {
            Objects.requireNonNull(str);
            ensureRequestedIsMutable();
            this.requested_.set(i10, (int) str);
            onChanged();
            return this;
        }

        public Builder setSelector(String str) {
            Objects.requireNonNull(str);
            this.selector_ = str;
            onChanged();
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.selector_ = byteString;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ProtocolStringList getAllowedRequestExtensionsList() {
            return this.allowedRequestExtensions_.getUnmodifiableView();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ProtocolStringList getAllowedResponseExtensionsList() {
            return this.allowedResponseExtensions_.getUnmodifiableView();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ProtocolStringList getProvidedList() {
            return this.provided_.getUnmodifiableView();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ProtocolStringList getRequestedList() {
            return this.requested_.getUnmodifiableView();
        }

        private Builder() {
            this.selector_ = "";
            LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
            this.requested_ = lazyStringList;
            this.provided_ = lazyStringList;
            this.allowedRequestExtensions_ = lazyStringList;
            this.allowedResponseExtensions_ = lazyStringList;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ContextRule build() {
            ContextRule buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ContextRule buildPartial() {
            ContextRule contextRule = new ContextRule(this, (a) null);
            contextRule.selector_ = this.selector_;
            if ((this.bitField0_ & 1) != 0) {
                this.requested_ = this.requested_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            contextRule.requested_ = this.requested_;
            if ((this.bitField0_ & 2) != 0) {
                this.provided_ = this.provided_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            contextRule.provided_ = this.provided_;
            if ((this.bitField0_ & 4) != 0) {
                this.allowedRequestExtensions_ = this.allowedRequestExtensions_.getUnmodifiableView();
                this.bitField0_ &= -5;
            }
            contextRule.allowedRequestExtensions_ = this.allowedRequestExtensions_;
            if ((this.bitField0_ & 8) != 0) {
                this.allowedResponseExtensions_ = this.allowedResponseExtensions_.getUnmodifiableView();
                this.bitField0_ &= -9;
            }
            contextRule.allowedResponseExtensions_ = this.allowedResponseExtensions_;
            onBuilt();
            return contextRule;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ContextRule getDefaultInstanceForType() {
            return ContextRule.getDefaultInstance();
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
            this.selector_ = "";
            LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
            this.requested_ = lazyStringList;
            int i10 = this.bitField0_ & (-2);
            this.provided_ = lazyStringList;
            this.allowedRequestExtensions_ = lazyStringList;
            this.allowedResponseExtensions_ = lazyStringList;
            this.bitField0_ = i10 & (-3) & (-5) & (-9);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ContextRule) {
                return mergeFrom((ContextRule) message);
            }
            super.mergeFrom(message);
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.selector_ = "";
            LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
            this.requested_ = lazyStringList;
            this.provided_ = lazyStringList;
            this.allowedRequestExtensions_ = lazyStringList;
            this.allowedResponseExtensions_ = lazyStringList;
            maybeForceBuilderInitialization();
        }

        public Builder mergeFrom(ContextRule contextRule) {
            if (contextRule == ContextRule.getDefaultInstance()) {
                return this;
            }
            if (!contextRule.getSelector().isEmpty()) {
                this.selector_ = contextRule.selector_;
                onChanged();
            }
            if (!contextRule.requested_.isEmpty()) {
                if (this.requested_.isEmpty()) {
                    this.requested_ = contextRule.requested_;
                    this.bitField0_ &= -2;
                } else {
                    ensureRequestedIsMutable();
                    this.requested_.addAll(contextRule.requested_);
                }
                onChanged();
            }
            if (!contextRule.provided_.isEmpty()) {
                if (this.provided_.isEmpty()) {
                    this.provided_ = contextRule.provided_;
                    this.bitField0_ &= -3;
                } else {
                    ensureProvidedIsMutable();
                    this.provided_.addAll(contextRule.provided_);
                }
                onChanged();
            }
            if (!contextRule.allowedRequestExtensions_.isEmpty()) {
                if (this.allowedRequestExtensions_.isEmpty()) {
                    this.allowedRequestExtensions_ = contextRule.allowedRequestExtensions_;
                    this.bitField0_ &= -5;
                } else {
                    ensureAllowedRequestExtensionsIsMutable();
                    this.allowedRequestExtensions_.addAll(contextRule.allowedRequestExtensions_);
                }
                onChanged();
            }
            if (!contextRule.allowedResponseExtensions_.isEmpty()) {
                if (this.allowedResponseExtensions_.isEmpty()) {
                    this.allowedResponseExtensions_ = contextRule.allowedResponseExtensions_;
                    this.bitField0_ &= -9;
                } else {
                    ensureAllowedResponseExtensionsIsMutable();
                    this.allowedResponseExtensions_.addAll(contextRule.allowedResponseExtensions_);
                }
                onChanged();
            }
            mergeUnknownFields(contextRule.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.ContextRule.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.ContextRule.access$1000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.ContextRule r3 = (com.google.api.ContextRule) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.ContextRule r4 = (com.google.api.ContextRule) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.ContextRule.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.ContextRule$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<ContextRule> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContextRule parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ContextRule(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ ContextRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static ContextRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return h.f53899c;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ContextRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ContextRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<ContextRule> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContextRule)) {
            return super.equals(obj);
        }
        ContextRule contextRule = (ContextRule) obj;
        return getSelector().equals(contextRule.getSelector()) && getRequestedList().equals(contextRule.getRequestedList()) && getProvidedList().equals(contextRule.getProvidedList()) && getAllowedRequestExtensionsList().equals(contextRule.getAllowedRequestExtensionsList()) && getAllowedResponseExtensionsList().equals(contextRule.getAllowedResponseExtensionsList()) && this.unknownFields.equals(contextRule.unknownFields);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getAllowedRequestExtensions(int i10) {
        return this.allowedRequestExtensions_.get(i10);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getAllowedRequestExtensionsBytes(int i10) {
        return this.allowedRequestExtensions_.getByteString(i10);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getAllowedRequestExtensionsCount() {
        return this.allowedRequestExtensions_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getAllowedResponseExtensions(int i10) {
        return this.allowedResponseExtensions_.get(i10);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getAllowedResponseExtensionsBytes(int i10) {
        return this.allowedResponseExtensions_.getByteString(i10);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getAllowedResponseExtensionsCount() {
        return this.allowedResponseExtensions_.size();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ContextRule> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getProvided(int i10) {
        return this.provided_.get(i10);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getProvidedBytes(int i10) {
        return this.provided_.getByteString(i10);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getProvidedCount() {
        return this.provided_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getRequested(int i10) {
        return this.requested_.get(i10);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getRequestedBytes(int i10) {
        return this.requested_.getByteString(i10);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getRequestedCount() {
        return this.requested_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getSelector() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.selector_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getSelectorBytes() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.selector_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = !GeneratedMessageV3.isStringEmpty(this.selector_) ? GeneratedMessageV3.computeStringSize(1, this.selector_) + 0 : 0;
        int i11 = 0;
        for (int i12 = 0; i12 < this.requested_.size(); i12++) {
            i11 += GeneratedMessageV3.computeStringSizeNoTag(this.requested_.getRaw(i12));
        }
        int size = computeStringSize + i11 + (getRequestedList().size() * 1);
        int i13 = 0;
        for (int i14 = 0; i14 < this.provided_.size(); i14++) {
            i13 += GeneratedMessageV3.computeStringSizeNoTag(this.provided_.getRaw(i14));
        }
        int size2 = size + i13 + (getProvidedList().size() * 1);
        int i15 = 0;
        for (int i16 = 0; i16 < this.allowedRequestExtensions_.size(); i16++) {
            i15 += GeneratedMessageV3.computeStringSizeNoTag(this.allowedRequestExtensions_.getRaw(i16));
        }
        int size3 = size2 + i15 + (getAllowedRequestExtensionsList().size() * 1);
        int i17 = 0;
        for (int i18 = 0; i18 < this.allowedResponseExtensions_.size(); i18++) {
            i17 += GeneratedMessageV3.computeStringSizeNoTag(this.allowedResponseExtensions_.getRaw(i18));
        }
        int size4 = size3 + i17 + (getAllowedResponseExtensionsList().size() * 1) + this.unknownFields.getSerializedSize();
        this.memoizedSize = size4;
        return size4;
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
        int hashCode = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getSelector().hashCode();
        if (getRequestedCount() > 0) {
            hashCode = (((hashCode * 37) + 2) * 53) + getRequestedList().hashCode();
        }
        if (getProvidedCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getProvidedList().hashCode();
        }
        if (getAllowedRequestExtensionsCount() > 0) {
            hashCode = (((hashCode * 37) + 4) * 53) + getAllowedRequestExtensionsList().hashCode();
        }
        if (getAllowedResponseExtensionsCount() > 0) {
            hashCode = (((hashCode * 37) + 5) * 53) + getAllowedResponseExtensionsList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return h.f53900d.ensureFieldAccessorsInitialized(ContextRule.class, Builder.class);
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
        return new ContextRule();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.selector_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.selector_);
        }
        for (int i10 = 0; i10 < this.requested_.size(); i10++) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.requested_.getRaw(i10));
        }
        for (int i11 = 0; i11 < this.provided_.size(); i11++) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.provided_.getRaw(i11));
        }
        for (int i12 = 0; i12 < this.allowedRequestExtensions_.size(); i12++) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.allowedRequestExtensions_.getRaw(i12));
        }
        for (int i13 = 0; i13 < this.allowedResponseExtensions_.size(); i13++) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.allowedResponseExtensions_.getRaw(i13));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ ContextRule(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(ContextRule contextRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(contextRule);
    }

    public static ContextRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ContextRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ProtocolStringList getAllowedRequestExtensionsList() {
        return this.allowedRequestExtensions_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ProtocolStringList getAllowedResponseExtensionsList() {
        return this.allowedResponseExtensions_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ProtocolStringList getProvidedList() {
        return this.provided_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ProtocolStringList getRequestedList() {
        return this.requested_;
    }

    private ContextRule(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ContextRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ContextRule getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static ContextRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private ContextRule() {
        this.memoizedIsInitialized = (byte) -1;
        this.selector_ = "";
        LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
        this.requested_ = lazyStringList;
        this.provided_ = lazyStringList;
        this.allowedRequestExtensions_ = lazyStringList;
        this.allowedResponseExtensions_ = lazyStringList;
    }

    public static ContextRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static ContextRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ContextRule parseFrom(InputStream inputStream) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ContextRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ContextRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ContextRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    private ContextRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.selector_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                if ((i10 & 1) == 0) {
                                    this.requested_ = new LazyStringArrayList();
                                    i10 |= 1;
                                }
                                this.requested_.add((LazyStringList) readStringRequireUtf8);
                            } else if (readTag == 26) {
                                String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                                if ((i10 & 2) == 0) {
                                    this.provided_ = new LazyStringArrayList();
                                    i10 |= 2;
                                }
                                this.provided_.add((LazyStringList) readStringRequireUtf82);
                            } else if (readTag == 34) {
                                String readStringRequireUtf83 = codedInputStream.readStringRequireUtf8();
                                if ((i10 & 4) == 0) {
                                    this.allowedRequestExtensions_ = new LazyStringArrayList();
                                    i10 |= 4;
                                }
                                this.allowedRequestExtensions_.add((LazyStringList) readStringRequireUtf83);
                            } else if (readTag != 42) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                String readStringRequireUtf84 = codedInputStream.readStringRequireUtf8();
                                if ((i10 & 8) == 0) {
                                    this.allowedResponseExtensions_ = new LazyStringArrayList();
                                    i10 |= 8;
                                }
                                this.allowedResponseExtensions_.add((LazyStringList) readStringRequireUtf84);
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
                if ((i10 & 1) != 0) {
                    this.requested_ = this.requested_.getUnmodifiableView();
                }
                if ((i10 & 2) != 0) {
                    this.provided_ = this.provided_.getUnmodifiableView();
                }
                if ((i10 & 4) != 0) {
                    this.allowedRequestExtensions_ = this.allowedRequestExtensions_.getUnmodifiableView();
                }
                if ((i10 & 8) != 0) {
                    this.allowedResponseExtensions_ = this.allowedResponseExtensions_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }
}
