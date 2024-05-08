package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.api.Advice;
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
import u7.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ConfigChange extends GeneratedMessageV3 implements ConfigChangeOrBuilder {
    public static final int ADVICES_FIELD_NUMBER = 5;
    public static final int CHANGE_TYPE_FIELD_NUMBER = 4;
    public static final int ELEMENT_FIELD_NUMBER = 1;
    public static final int NEW_VALUE_FIELD_NUMBER = 3;
    public static final int OLD_VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private List<Advice> advices_;
    private int changeType_;
    private volatile Object element_;
    private byte memoizedIsInitialized;
    private volatile Object newValue_;
    private volatile Object oldValue_;
    private static final ConfigChange DEFAULT_INSTANCE = new ConfigChange();
    private static final Parser<ConfigChange> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConfigChangeOrBuilder {
        private RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> advicesBuilder_;
        private List<Advice> advices_;
        private int bitField0_;
        private int changeType_;
        private Object element_;
        private Object newValue_;
        private Object oldValue_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureAdvicesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.advices_ = new ArrayList(this.advices_);
                this.bitField0_ |= 1;
            }
        }

        private RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> getAdvicesFieldBuilder() {
            if (this.advicesBuilder_ == null) {
                this.advicesBuilder_ = new RepeatedFieldBuilderV3<>(this.advices_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.advices_ = null;
            }
            return this.advicesBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return f.f53887a;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getAdvicesFieldBuilder();
            }
        }

        public Builder addAdvices(Advice advice) {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(advice);
                ensureAdvicesIsMutable();
                this.advices_.add(advice);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(advice);
            }
            return this;
        }

        public Advice.Builder addAdvicesBuilder() {
            return getAdvicesFieldBuilder().addBuilder(Advice.getDefaultInstance());
        }

        public Builder addAllAdvices(Iterable<? extends Advice> iterable) {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAdvicesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.advices_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder clearAdvices() {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.advices_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearChangeType() {
            this.changeType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearElement() {
            this.element_ = ConfigChange.getDefaultInstance().getElement();
            onChanged();
            return this;
        }

        public Builder clearNewValue() {
            this.newValue_ = ConfigChange.getDefaultInstance().getNewValue();
            onChanged();
            return this;
        }

        public Builder clearOldValue() {
            this.oldValue_ = ConfigChange.getDefaultInstance().getOldValue();
            onChanged();
            return this;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public Advice getAdvices(int i10) {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.advices_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public Advice.Builder getAdvicesBuilder(int i10) {
            return getAdvicesFieldBuilder().getBuilder(i10);
        }

        public List<Advice.Builder> getAdvicesBuilderList() {
            return getAdvicesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public int getAdvicesCount() {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.advices_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public List<Advice> getAdvicesList() {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.advices_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public AdviceOrBuilder getAdvicesOrBuilder(int i10) {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.advices_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public List<? extends AdviceOrBuilder> getAdvicesOrBuilderList() {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.advices_);
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public ChangeType getChangeType() {
            ChangeType valueOf = ChangeType.valueOf(this.changeType_);
            return valueOf == null ? ChangeType.UNRECOGNIZED : valueOf;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public int getChangeTypeValue() {
            return this.changeType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return f.f53887a;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public String getElement() {
            Object obj = this.element_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.element_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public ByteString getElementBytes() {
            Object obj = this.element_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.element_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public String getNewValue() {
            Object obj = this.newValue_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.newValue_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public ByteString getNewValueBytes() {
            Object obj = this.newValue_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.newValue_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public String getOldValue() {
            Object obj = this.oldValue_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.oldValue_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public ByteString getOldValueBytes() {
            Object obj = this.oldValue_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.oldValue_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return f.f53888b.ensureFieldAccessorsInitialized(ConfigChange.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder removeAdvices(int i10) {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAdvicesIsMutable();
                this.advices_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setAdvices(int i10, Advice advice) {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(advice);
                ensureAdvicesIsMutable();
                this.advices_.set(i10, advice);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, advice);
            }
            return this;
        }

        public Builder setChangeType(ChangeType changeType) {
            Objects.requireNonNull(changeType);
            this.changeType_ = changeType.getNumber();
            onChanged();
            return this;
        }

        public Builder setChangeTypeValue(int i10) {
            this.changeType_ = i10;
            onChanged();
            return this;
        }

        public Builder setElement(String str) {
            Objects.requireNonNull(str);
            this.element_ = str;
            onChanged();
            return this;
        }

        public Builder setElementBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.element_ = byteString;
            onChanged();
            return this;
        }

        public Builder setNewValue(String str) {
            Objects.requireNonNull(str);
            this.newValue_ = str;
            onChanged();
            return this;
        }

        public Builder setNewValueBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.newValue_ = byteString;
            onChanged();
            return this;
        }

        public Builder setOldValue(String str) {
            Objects.requireNonNull(str);
            this.oldValue_ = str;
            onChanged();
            return this;
        }

        public Builder setOldValueBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.oldValue_ = byteString;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        public Advice.Builder addAdvicesBuilder(int i10) {
            return getAdvicesFieldBuilder().addBuilder(i10, Advice.getDefaultInstance());
        }

        private Builder() {
            this.element_ = "";
            this.oldValue_ = "";
            this.newValue_ = "";
            this.changeType_ = 0;
            this.advices_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ConfigChange build() {
            ConfigChange buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ConfigChange buildPartial() {
            ConfigChange configChange = new ConfigChange(this, (a) null);
            configChange.element_ = this.element_;
            configChange.oldValue_ = this.oldValue_;
            configChange.newValue_ = this.newValue_;
            configChange.changeType_ = this.changeType_;
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.advices_ = Collections.unmodifiableList(this.advices_);
                    this.bitField0_ &= -2;
                }
                configChange.advices_ = this.advices_;
            } else {
                configChange.advices_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return configChange;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ConfigChange getDefaultInstanceForType() {
            return ConfigChange.getDefaultInstance();
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
            this.element_ = "";
            this.oldValue_ = "";
            this.newValue_ = "";
            this.changeType_ = 0;
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.advices_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder addAdvices(int i10, Advice advice) {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(advice);
                ensureAdvicesIsMutable();
                this.advices_.add(i10, advice);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, advice);
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
            if (message instanceof ConfigChange) {
                return mergeFrom((ConfigChange) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setAdvices(int i10, Advice.Builder builder) {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAdvicesIsMutable();
                this.advices_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.element_ = "";
            this.oldValue_ = "";
            this.newValue_ = "";
            this.changeType_ = 0;
            this.advices_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder mergeFrom(ConfigChange configChange) {
            if (configChange == ConfigChange.getDefaultInstance()) {
                return this;
            }
            if (!configChange.getElement().isEmpty()) {
                this.element_ = configChange.element_;
                onChanged();
            }
            if (!configChange.getOldValue().isEmpty()) {
                this.oldValue_ = configChange.oldValue_;
                onChanged();
            }
            if (!configChange.getNewValue().isEmpty()) {
                this.newValue_ = configChange.newValue_;
                onChanged();
            }
            if (configChange.changeType_ != 0) {
                setChangeTypeValue(configChange.getChangeTypeValue());
            }
            if (this.advicesBuilder_ == null) {
                if (!configChange.advices_.isEmpty()) {
                    if (this.advices_.isEmpty()) {
                        this.advices_ = configChange.advices_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAdvicesIsMutable();
                        this.advices_.addAll(configChange.advices_);
                    }
                    onChanged();
                }
            } else if (!configChange.advices_.isEmpty()) {
                if (this.advicesBuilder_.isEmpty()) {
                    this.advicesBuilder_.dispose();
                    this.advicesBuilder_ = null;
                    this.advices_ = configChange.advices_;
                    this.bitField0_ &= -2;
                    this.advicesBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getAdvicesFieldBuilder() : null;
                } else {
                    this.advicesBuilder_.addAllMessages(configChange.advices_);
                }
            }
            mergeUnknownFields(configChange.unknownFields);
            onChanged();
            return this;
        }

        public Builder addAdvices(Advice.Builder builder) {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAdvicesIsMutable();
                this.advices_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addAdvices(int i10, Advice.Builder builder) {
            RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAdvicesIsMutable();
                this.advices_.add(i10, builder.build());
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
        public com.google.api.ConfigChange.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.ConfigChange.access$1100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.ConfigChange r3 = (com.google.api.ConfigChange) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.ConfigChange r4 = (com.google.api.ConfigChange) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.ConfigChange.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.ConfigChange$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<ConfigChange> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConfigChange parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ConfigChange(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ ConfigChange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static ConfigChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return f.f53887a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ConfigChange parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ConfigChange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ConfigChange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<ConfigChange> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConfigChange)) {
            return super.equals(obj);
        }
        ConfigChange configChange = (ConfigChange) obj;
        return getElement().equals(configChange.getElement()) && getOldValue().equals(configChange.getOldValue()) && getNewValue().equals(configChange.getNewValue()) && this.changeType_ == configChange.changeType_ && getAdvicesList().equals(configChange.getAdvicesList()) && this.unknownFields.equals(configChange.unknownFields);
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public Advice getAdvices(int i10) {
        return this.advices_.get(i10);
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public int getAdvicesCount() {
        return this.advices_.size();
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public List<Advice> getAdvicesList() {
        return this.advices_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public AdviceOrBuilder getAdvicesOrBuilder(int i10) {
        return this.advices_.get(i10);
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public List<? extends AdviceOrBuilder> getAdvicesOrBuilderList() {
        return this.advices_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public ChangeType getChangeType() {
        ChangeType valueOf = ChangeType.valueOf(this.changeType_);
        return valueOf == null ? ChangeType.UNRECOGNIZED : valueOf;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public int getChangeTypeValue() {
        return this.changeType_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public String getElement() {
        Object obj = this.element_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.element_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public ByteString getElementBytes() {
        Object obj = this.element_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.element_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public String getNewValue() {
        Object obj = this.newValue_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.newValue_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public ByteString getNewValueBytes() {
        Object obj = this.newValue_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.newValue_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public String getOldValue() {
        Object obj = this.oldValue_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.oldValue_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public ByteString getOldValueBytes() {
        Object obj = this.oldValue_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.oldValue_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ConfigChange> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = !GeneratedMessageV3.isStringEmpty(this.element_) ? GeneratedMessageV3.computeStringSize(1, this.element_) + 0 : 0;
        if (!GeneratedMessageV3.isStringEmpty(this.oldValue_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.oldValue_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.newValue_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(3, this.newValue_);
        }
        if (this.changeType_ != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
            computeStringSize += CodedOutputStream.computeEnumSize(4, this.changeType_);
        }
        for (int i11 = 0; i11 < this.advices_.size(); i11++) {
            computeStringSize += CodedOutputStream.computeMessageSize(5, this.advices_.get(i11));
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getElement().hashCode()) * 37) + 2) * 53) + getOldValue().hashCode()) * 37) + 3) * 53) + getNewValue().hashCode()) * 37) + 4) * 53) + this.changeType_;
        if (getAdvicesCount() > 0) {
            hashCode = (((hashCode * 37) + 5) * 53) + getAdvicesList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return f.f53888b.ensureFieldAccessorsInitialized(ConfigChange.class, Builder.class);
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
        return new ConfigChange();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.element_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.element_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.oldValue_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.oldValue_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.newValue_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.newValue_);
        }
        if (this.changeType_ != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
            codedOutputStream.writeEnum(4, this.changeType_);
        }
        for (int i10 = 0; i10 < this.advices_.size(); i10++) {
            codedOutputStream.writeMessage(5, this.advices_.get(i10));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ ConfigChange(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(ConfigChange configChange) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(configChange);
    }

    public static ConfigChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConfigChange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ConfigChange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private ConfigChange(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ConfigChange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ConfigChange getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static ConfigChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private ConfigChange() {
        this.memoizedIsInitialized = (byte) -1;
        this.element_ = "";
        this.oldValue_ = "";
        this.newValue_ = "";
        this.changeType_ = 0;
        this.advices_ = Collections.emptyList();
    }

    public static ConfigChange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static ConfigChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ConfigChange parseFrom(InputStream inputStream) throws IOException {
        return (ConfigChange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ConfigChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConfigChange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ConfigChange parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ConfigChange) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ConfigChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConfigChange) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ConfigChange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.element_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.oldValue_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.newValue_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.changeType_ = codedInputStream.readEnum();
                            } else if (readTag != 42) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z11 & true)) {
                                    this.advices_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.advices_.add(codedInputStream.readMessage(Advice.parser(), extensionRegistryLite));
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (UninitializedMessageException e10) {
                        throw e10.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                    }
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                }
            } finally {
                if (z11 & true) {
                    this.advices_ = Collections.unmodifiableList(this.advices_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }
}
