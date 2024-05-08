package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;
import u7.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class MonitoredResourceMetadata extends GeneratedMessageV3 implements MonitoredResourceMetadataOrBuilder {
    private static final MonitoredResourceMetadata DEFAULT_INSTANCE = new MonitoredResourceMetadata();
    private static final Parser<MonitoredResourceMetadata> PARSER = new a();
    public static final int SYSTEM_LABELS_FIELD_NUMBER = 1;
    public static final int USER_LABELS_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private Struct systemLabels_;
    private MapField<String, String> userLabels_;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MonitoredResourceMetadataOrBuilder {
        private int bitField0_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> systemLabelsBuilder_;
        private Struct systemLabels_;
        private MapField<String, String> userLabels_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return v.f53970g;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getSystemLabelsFieldBuilder() {
            if (this.systemLabelsBuilder_ == null) {
                this.systemLabelsBuilder_ = new SingleFieldBuilderV3<>(getSystemLabels(), getParentForChildren(), isClean());
                this.systemLabels_ = null;
            }
            return this.systemLabelsBuilder_;
        }

        private MapField<String, String> internalGetMutableUserLabels() {
            onChanged();
            if (this.userLabels_ == null) {
                this.userLabels_ = MapField.newMapField(b.f25932a);
            }
            if (!this.userLabels_.isMutable()) {
                this.userLabels_ = this.userLabels_.copy();
            }
            return this.userLabels_;
        }

        private MapField<String, String> internalGetUserLabels() {
            MapField<String, String> mapField = this.userLabels_;
            return mapField == null ? MapField.emptyMapField(b.f25932a) : mapField;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearSystemLabels() {
            if (this.systemLabelsBuilder_ == null) {
                this.systemLabels_ = null;
                onChanged();
            } else {
                this.systemLabels_ = null;
                this.systemLabelsBuilder_ = null;
            }
            return this;
        }

        public Builder clearUserLabels() {
            internalGetMutableUserLabels().getMutableMap().clear();
            return this;
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public boolean containsUserLabels(String str) {
            Objects.requireNonNull(str, "map key");
            return internalGetUserLabels().getMap().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return v.f53970g;
        }

        @Deprecated
        public Map<String, String> getMutableUserLabels() {
            return internalGetMutableUserLabels().getMutableMap();
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public Struct getSystemLabels() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.systemLabels_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Struct.Builder getSystemLabelsBuilder() {
            onChanged();
            return getSystemLabelsFieldBuilder().getBuilder();
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public StructOrBuilder getSystemLabelsOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.systemLabels_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        @Deprecated
        public Map<String, String> getUserLabels() {
            return getUserLabelsMap();
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public int getUserLabelsCount() {
            return internalGetUserLabels().getMap().size();
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public Map<String, String> getUserLabelsMap() {
            return internalGetUserLabels().getMap();
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public String getUserLabelsOrDefault(String str, String str2) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetUserLabels().getMap();
            return map.containsKey(str) ? map.get(str) : str2;
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public String getUserLabelsOrThrow(String str) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetUserLabels().getMap();
            if (map.containsKey(str)) {
                return map.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public boolean hasSystemLabels() {
            return (this.systemLabelsBuilder_ == null && this.systemLabels_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return v.f53971h.ensureFieldAccessorsInitialized(MonitoredResourceMetadata.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public MapField internalGetMapField(int i10) {
            if (i10 == 2) {
                return internalGetUserLabels();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public MapField internalGetMutableMapField(int i10) {
            if (i10 == 2) {
                return internalGetMutableUserLabels();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeSystemLabels(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct2 = this.systemLabels_;
                if (struct2 != null) {
                    this.systemLabels_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                } else {
                    this.systemLabels_ = struct;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(struct);
            }
            return this;
        }

        public Builder putAllUserLabels(Map<String, String> map) {
            internalGetMutableUserLabels().getMutableMap().putAll(map);
            return this;
        }

        public Builder putUserLabels(String str, String str2) {
            Objects.requireNonNull(str, "map key");
            Objects.requireNonNull(str2, "map value");
            internalGetMutableUserLabels().getMutableMap().put(str, str2);
            return this;
        }

        public Builder removeUserLabels(String str) {
            Objects.requireNonNull(str, "map key");
            internalGetMutableUserLabels().getMutableMap().remove(str);
            return this;
        }

        public Builder setSystemLabels(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(struct);
                this.systemLabels_ = struct;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(struct);
            }
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MonitoredResourceMetadata build() {
            MonitoredResourceMetadata buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MonitoredResourceMetadata buildPartial() {
            MonitoredResourceMetadata monitoredResourceMetadata = new MonitoredResourceMetadata(this, (a) null);
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
            if (singleFieldBuilderV3 == null) {
                monitoredResourceMetadata.systemLabels_ = this.systemLabels_;
            } else {
                monitoredResourceMetadata.systemLabels_ = singleFieldBuilderV3.build();
            }
            monitoredResourceMetadata.userLabels_ = internalGetUserLabels();
            monitoredResourceMetadata.userLabels_.makeImmutable();
            onBuilt();
            return monitoredResourceMetadata;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MonitoredResourceMetadata getDefaultInstanceForType() {
            return MonitoredResourceMetadata.getDefaultInstance();
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

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            if (this.systemLabelsBuilder_ == null) {
                this.systemLabels_ = null;
            } else {
                this.systemLabels_ = null;
                this.systemLabelsBuilder_ = null;
            }
            internalGetMutableUserLabels().clear();
            return this;
        }

        public Builder setSystemLabels(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.systemLabels_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
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
            if (message instanceof MonitoredResourceMetadata) {
                return mergeFrom((MonitoredResourceMetadata) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(MonitoredResourceMetadata monitoredResourceMetadata) {
            if (monitoredResourceMetadata == MonitoredResourceMetadata.getDefaultInstance()) {
                return this;
            }
            if (monitoredResourceMetadata.hasSystemLabels()) {
                mergeSystemLabels(monitoredResourceMetadata.getSystemLabels());
            }
            internalGetMutableUserLabels().mergeFrom(monitoredResourceMetadata.internalGetUserLabels());
            mergeUnknownFields(monitoredResourceMetadata.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.MonitoredResourceMetadata.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.MonitoredResourceMetadata.access$800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.MonitoredResourceMetadata r3 = (com.google.api.MonitoredResourceMetadata) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.MonitoredResourceMetadata r4 = (com.google.api.MonitoredResourceMetadata) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.MonitoredResourceMetadata.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.MonitoredResourceMetadata$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<MonitoredResourceMetadata> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MonitoredResourceMetadata parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new MonitoredResourceMetadata(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final MapEntry<String, String> f25932a;

        static {
            Descriptors.Descriptor descriptor = v.f53972i;
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            f25932a = MapEntry.newDefaultInstance(descriptor, fieldType, "", fieldType, "");
        }
    }

    public /* synthetic */ MonitoredResourceMetadata(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static MonitoredResourceMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return v.f53970g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MapField<String, String> internalGetUserLabels() {
        MapField<String, String> mapField = this.userLabels_;
        return mapField == null ? MapField.emptyMapField(b.f25932a) : mapField;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static MonitoredResourceMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MonitoredResourceMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<MonitoredResourceMetadata> parser() {
        return PARSER;
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public boolean containsUserLabels(String str) {
        Objects.requireNonNull(str, "map key");
        return internalGetUserLabels().getMap().containsKey(str);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MonitoredResourceMetadata)) {
            return super.equals(obj);
        }
        MonitoredResourceMetadata monitoredResourceMetadata = (MonitoredResourceMetadata) obj;
        if (hasSystemLabels() != monitoredResourceMetadata.hasSystemLabels()) {
            return false;
        }
        return (!hasSystemLabels() || getSystemLabels().equals(monitoredResourceMetadata.getSystemLabels())) && internalGetUserLabels().equals(monitoredResourceMetadata.internalGetUserLabels()) && this.unknownFields.equals(monitoredResourceMetadata.unknownFields);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MonitoredResourceMetadata> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeMessageSize = this.systemLabels_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getSystemLabels()) : 0;
        for (Map.Entry<String, String> entry : internalGetUserLabels().getMap().entrySet()) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, b.f25932a.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public Struct getSystemLabels() {
        Struct struct = this.systemLabels_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public StructOrBuilder getSystemLabelsOrBuilder() {
        return getSystemLabels();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    @Deprecated
    public Map<String, String> getUserLabels() {
        return getUserLabelsMap();
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public int getUserLabelsCount() {
        return internalGetUserLabels().getMap().size();
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public Map<String, String> getUserLabelsMap() {
        return internalGetUserLabels().getMap();
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public String getUserLabelsOrDefault(String str, String str2) {
        Objects.requireNonNull(str, "map key");
        Map<String, String> map = internalGetUserLabels().getMap();
        return map.containsKey(str) ? map.get(str) : str2;
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public String getUserLabelsOrThrow(String str) {
        Objects.requireNonNull(str, "map key");
        Map<String, String> map = internalGetUserLabels().getMap();
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public boolean hasSystemLabels() {
        return this.systemLabels_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode();
        if (hasSystemLabels()) {
            hashCode = (((hashCode * 37) + 1) * 53) + getSystemLabels().hashCode();
        }
        if (!internalGetUserLabels().getMap().isEmpty()) {
            hashCode = (((hashCode * 37) + 2) * 53) + internalGetUserLabels().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return v.f53971h.ensureFieldAccessorsInitialized(MonitoredResourceMetadata.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public MapField internalGetMapField(int i10) {
        if (i10 == 2) {
            return internalGetUserLabels();
        }
        throw new RuntimeException("Invalid map field number: " + i10);
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
        return new MonitoredResourceMetadata();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.systemLabels_ != null) {
            codedOutputStream.writeMessage(1, getSystemLabels());
        }
        GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetUserLabels(), b.f25932a, 2);
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ MonitoredResourceMetadata(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(MonitoredResourceMetadata monitoredResourceMetadata) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(monitoredResourceMetadata);
    }

    public static MonitoredResourceMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MonitoredResourceMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private MonitoredResourceMetadata(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MonitoredResourceMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MonitoredResourceMetadata getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static MonitoredResourceMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private MonitoredResourceMetadata() {
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MonitoredResourceMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static MonitoredResourceMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MonitoredResourceMetadata(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                Struct struct = this.systemLabels_;
                                Struct.Builder builder = struct != null ? struct.toBuilder() : null;
                                Struct struct2 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                this.systemLabels_ = struct2;
                                if (builder != null) {
                                    builder.mergeFrom(struct2);
                                    this.systemLabels_ = builder.buildPartial();
                                }
                            } else if (readTag != 18) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z11 & true)) {
                                    this.userLabels_ = MapField.newMapField(b.f25932a);
                                    z11 |= true;
                                }
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(b.f25932a.getParserForType(), extensionRegistryLite);
                                this.userLabels_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
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
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static MonitoredResourceMetadata parseFrom(InputStream inputStream) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static MonitoredResourceMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MonitoredResourceMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static MonitoredResourceMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
