package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.api.RoutingParameter;
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
import u7.z;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class RoutingRule extends GeneratedMessageV3 implements RoutingRuleOrBuilder {
    private static final RoutingRule DEFAULT_INSTANCE = new RoutingRule();
    private static final Parser<RoutingRule> PARSER = new a();
    public static final int ROUTING_PARAMETERS_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<RoutingParameter> routingParameters_;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RoutingRuleOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> routingParametersBuilder_;
        private List<RoutingParameter> routingParameters_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureRoutingParametersIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.routingParameters_ = new ArrayList(this.routingParameters_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return z.f54000b;
        }

        private RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> getRoutingParametersFieldBuilder() {
            if (this.routingParametersBuilder_ == null) {
                this.routingParametersBuilder_ = new RepeatedFieldBuilderV3<>(this.routingParameters_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.routingParameters_ = null;
            }
            return this.routingParametersBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getRoutingParametersFieldBuilder();
            }
        }

        public Builder addAllRoutingParameters(Iterable<? extends RoutingParameter> iterable) {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRoutingParametersIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.routingParameters_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addRoutingParameters(RoutingParameter routingParameter) {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(routingParameter);
                ensureRoutingParametersIsMutable();
                this.routingParameters_.add(routingParameter);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(routingParameter);
            }
            return this;
        }

        public RoutingParameter.Builder addRoutingParametersBuilder() {
            return getRoutingParametersFieldBuilder().addBuilder(RoutingParameter.getDefaultInstance());
        }

        public Builder clearRoutingParameters() {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.routingParameters_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return z.f54000b;
        }

        @Override // com.google.api.RoutingRuleOrBuilder
        public RoutingParameter getRoutingParameters(int i10) {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.routingParameters_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public RoutingParameter.Builder getRoutingParametersBuilder(int i10) {
            return getRoutingParametersFieldBuilder().getBuilder(i10);
        }

        public List<RoutingParameter.Builder> getRoutingParametersBuilderList() {
            return getRoutingParametersFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.RoutingRuleOrBuilder
        public int getRoutingParametersCount() {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.routingParameters_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.RoutingRuleOrBuilder
        public List<RoutingParameter> getRoutingParametersList() {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.routingParameters_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.RoutingRuleOrBuilder
        public RoutingParameterOrBuilder getRoutingParametersOrBuilder(int i10) {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.routingParameters_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.RoutingRuleOrBuilder
        public List<? extends RoutingParameterOrBuilder> getRoutingParametersOrBuilderList() {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.routingParameters_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return z.f54001c.ensureFieldAccessorsInitialized(RoutingRule.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder removeRoutingParameters(int i10) {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRoutingParametersIsMutable();
                this.routingParameters_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setRoutingParameters(int i10, RoutingParameter routingParameter) {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(routingParameter);
                ensureRoutingParametersIsMutable();
                this.routingParameters_.set(i10, routingParameter);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, routingParameter);
            }
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.routingParameters_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public RoutingParameter.Builder addRoutingParametersBuilder(int i10) {
            return getRoutingParametersFieldBuilder().addBuilder(i10, RoutingParameter.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public RoutingRule build() {
            RoutingRule buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public RoutingRule buildPartial() {
            RoutingRule routingRule = new RoutingRule(this, (a) null);
            int i10 = this.bitField0_;
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i10 & 1) != 0) {
                    this.routingParameters_ = Collections.unmodifiableList(this.routingParameters_);
                    this.bitField0_ &= -2;
                }
                routingRule.routingParameters_ = this.routingParameters_;
            } else {
                routingRule.routingParameters_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return routingRule;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RoutingRule getDefaultInstanceForType() {
            return RoutingRule.getDefaultInstance();
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
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.routingParameters_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.routingParameters_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder addRoutingParameters(int i10, RoutingParameter routingParameter) {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(routingParameter);
                ensureRoutingParametersIsMutable();
                this.routingParameters_.add(i10, routingParameter);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, routingParameter);
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
            if (message instanceof RoutingRule) {
                return mergeFrom((RoutingRule) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setRoutingParameters(int i10, RoutingParameter.Builder builder) {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRoutingParametersIsMutable();
                this.routingParameters_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder mergeFrom(RoutingRule routingRule) {
            if (routingRule == RoutingRule.getDefaultInstance()) {
                return this;
            }
            if (this.routingParametersBuilder_ == null) {
                if (!routingRule.routingParameters_.isEmpty()) {
                    if (this.routingParameters_.isEmpty()) {
                        this.routingParameters_ = routingRule.routingParameters_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRoutingParametersIsMutable();
                        this.routingParameters_.addAll(routingRule.routingParameters_);
                    }
                    onChanged();
                }
            } else if (!routingRule.routingParameters_.isEmpty()) {
                if (this.routingParametersBuilder_.isEmpty()) {
                    this.routingParametersBuilder_.dispose();
                    this.routingParametersBuilder_ = null;
                    this.routingParameters_ = routingRule.routingParameters_;
                    this.bitField0_ &= -2;
                    this.routingParametersBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getRoutingParametersFieldBuilder() : null;
                } else {
                    this.routingParametersBuilder_.addAllMessages(routingRule.routingParameters_);
                }
            }
            mergeUnknownFields(routingRule.unknownFields);
            onChanged();
            return this;
        }

        public Builder addRoutingParameters(RoutingParameter.Builder builder) {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRoutingParametersIsMutable();
                this.routingParameters_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addRoutingParameters(int i10, RoutingParameter.Builder builder) {
            RepeatedFieldBuilderV3<RoutingParameter, RoutingParameter.Builder, RoutingParameterOrBuilder> repeatedFieldBuilderV3 = this.routingParametersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRoutingParametersIsMutable();
                this.routingParameters_.add(i10, builder.build());
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
        public com.google.api.RoutingRule.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.RoutingRule.access$700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.RoutingRule r3 = (com.google.api.RoutingRule) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.RoutingRule r4 = (com.google.api.RoutingRule) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.RoutingRule.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.RoutingRule$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<RoutingRule> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RoutingRule parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RoutingRule(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ RoutingRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static RoutingRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return z.f54000b;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static RoutingRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RoutingRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static RoutingRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<RoutingRule> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoutingRule)) {
            return super.equals(obj);
        }
        RoutingRule routingRule = (RoutingRule) obj;
        return getRoutingParametersList().equals(routingRule.getRoutingParametersList()) && this.unknownFields.equals(routingRule.unknownFields);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<RoutingRule> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.RoutingRuleOrBuilder
    public RoutingParameter getRoutingParameters(int i10) {
        return this.routingParameters_.get(i10);
    }

    @Override // com.google.api.RoutingRuleOrBuilder
    public int getRoutingParametersCount() {
        return this.routingParameters_.size();
    }

    @Override // com.google.api.RoutingRuleOrBuilder
    public List<RoutingParameter> getRoutingParametersList() {
        return this.routingParameters_;
    }

    @Override // com.google.api.RoutingRuleOrBuilder
    public RoutingParameterOrBuilder getRoutingParametersOrBuilder(int i10) {
        return this.routingParameters_.get(i10);
    }

    @Override // com.google.api.RoutingRuleOrBuilder
    public List<? extends RoutingParameterOrBuilder> getRoutingParametersOrBuilderList() {
        return this.routingParameters_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.routingParameters_.size(); i12++) {
            i11 += CodedOutputStream.computeMessageSize(2, this.routingParameters_.get(i12));
        }
        int serializedSize = i11 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
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
        int hashCode = MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode();
        if (getRoutingParametersCount() > 0) {
            hashCode = (((hashCode * 37) + 2) * 53) + getRoutingParametersList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return z.f54001c.ensureFieldAccessorsInitialized(RoutingRule.class, Builder.class);
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
        return new RoutingRule();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i10 = 0; i10 < this.routingParameters_.size(); i10++) {
            codedOutputStream.writeMessage(2, this.routingParameters_.get(i10));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ RoutingRule(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(RoutingRule routingRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(routingRule);
    }

    public static RoutingRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RoutingRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RoutingRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private RoutingRule(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static RoutingRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public RoutingRule getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static RoutingRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private RoutingRule() {
        this.memoizedIsInitialized = (byte) -1;
        this.routingParameters_ = Collections.emptyList();
    }

    public static RoutingRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static RoutingRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RoutingRule parseFrom(InputStream inputStream) throws IOException {
        return (RoutingRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RoutingRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag != 18) {
                            if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            if (!(z11 & true)) {
                                this.routingParameters_ = new ArrayList();
                                z11 |= true;
                            }
                            this.routingParameters_.add(codedInputStream.readMessage(RoutingParameter.parser(), extensionRegistryLite));
                        }
                    }
                    z10 = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (UninitializedMessageException e10) {
                    throw e10.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                }
            } finally {
                if (z11 & true) {
                    this.routingParameters_ = Collections.unmodifiableList(this.routingParameters_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static RoutingRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RoutingRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RoutingRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RoutingRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static RoutingRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RoutingRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
