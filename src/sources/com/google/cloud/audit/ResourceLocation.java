package com.google.cloud.audit;

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

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ResourceLocation extends GeneratedMessageV3 implements ResourceLocationOrBuilder {
    public static final int CURRENT_LOCATIONS_FIELD_NUMBER = 1;
    public static final int ORIGINAL_LOCATIONS_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private LazyStringList currentLocations_;
    private byte memoizedIsInitialized;
    private LazyStringList originalLocations_;
    private static final ResourceLocation DEFAULT_INSTANCE = new ResourceLocation();
    private static final Parser<ResourceLocation> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResourceLocationOrBuilder {
        private int bitField0_;
        private LazyStringList currentLocations_;
        private LazyStringList originalLocations_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureCurrentLocationsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.currentLocations_ = new LazyStringArrayList(this.currentLocations_);
                this.bitField0_ |= 1;
            }
        }

        private void ensureOriginalLocationsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.originalLocations_ = new LazyStringArrayList(this.originalLocations_);
                this.bitField0_ |= 2;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return w7.a.f54278i;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder addAllCurrentLocations(Iterable<String> iterable) {
            ensureCurrentLocationsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.currentLocations_);
            onChanged();
            return this;
        }

        public Builder addAllOriginalLocations(Iterable<String> iterable) {
            ensureOriginalLocationsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.originalLocations_);
            onChanged();
            return this;
        }

        public Builder addCurrentLocations(String str) {
            Objects.requireNonNull(str);
            ensureCurrentLocationsIsMutable();
            this.currentLocations_.add((LazyStringList) str);
            onChanged();
            return this;
        }

        public Builder addCurrentLocationsBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureCurrentLocationsIsMutable();
            this.currentLocations_.add(byteString);
            onChanged();
            return this;
        }

        public Builder addOriginalLocations(String str) {
            Objects.requireNonNull(str);
            ensureOriginalLocationsIsMutable();
            this.originalLocations_.add((LazyStringList) str);
            onChanged();
            return this;
        }

        public Builder addOriginalLocationsBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureOriginalLocationsIsMutable();
            this.originalLocations_.add(byteString);
            onChanged();
            return this;
        }

        public Builder clearCurrentLocations() {
            this.currentLocations_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearOriginalLocations() {
            this.originalLocations_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        @Override // com.google.cloud.audit.ResourceLocationOrBuilder
        public String getCurrentLocations(int i10) {
            return this.currentLocations_.get(i10);
        }

        @Override // com.google.cloud.audit.ResourceLocationOrBuilder
        public ByteString getCurrentLocationsBytes(int i10) {
            return this.currentLocations_.getByteString(i10);
        }

        @Override // com.google.cloud.audit.ResourceLocationOrBuilder
        public int getCurrentLocationsCount() {
            return this.currentLocations_.size();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return w7.a.f54278i;
        }

        @Override // com.google.cloud.audit.ResourceLocationOrBuilder
        public String getOriginalLocations(int i10) {
            return this.originalLocations_.get(i10);
        }

        @Override // com.google.cloud.audit.ResourceLocationOrBuilder
        public ByteString getOriginalLocationsBytes(int i10) {
            return this.originalLocations_.getByteString(i10);
        }

        @Override // com.google.cloud.audit.ResourceLocationOrBuilder
        public int getOriginalLocationsCount() {
            return this.originalLocations_.size();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return w7.a.f54279j.ensureFieldAccessorsInitialized(ResourceLocation.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setCurrentLocations(int i10, String str) {
            Objects.requireNonNull(str);
            ensureCurrentLocationsIsMutable();
            this.currentLocations_.set(i10, (int) str);
            onChanged();
            return this;
        }

        public Builder setOriginalLocations(int i10, String str) {
            Objects.requireNonNull(str);
            ensureOriginalLocationsIsMutable();
            this.originalLocations_.set(i10, (int) str);
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        @Override // com.google.cloud.audit.ResourceLocationOrBuilder
        public ProtocolStringList getCurrentLocationsList() {
            return this.currentLocations_.getUnmodifiableView();
        }

        @Override // com.google.cloud.audit.ResourceLocationOrBuilder
        public ProtocolStringList getOriginalLocationsList() {
            return this.originalLocations_.getUnmodifiableView();
        }

        private Builder() {
            LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
            this.currentLocations_ = lazyStringList;
            this.originalLocations_ = lazyStringList;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ResourceLocation build() {
            ResourceLocation buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ResourceLocation buildPartial() {
            ResourceLocation resourceLocation = new ResourceLocation(this, (a) null);
            if ((this.bitField0_ & 1) != 0) {
                this.currentLocations_ = this.currentLocations_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            resourceLocation.currentLocations_ = this.currentLocations_;
            if ((this.bitField0_ & 2) != 0) {
                this.originalLocations_ = this.originalLocations_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            resourceLocation.originalLocations_ = this.originalLocations_;
            onBuilt();
            return resourceLocation;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ResourceLocation getDefaultInstanceForType() {
            return ResourceLocation.getDefaultInstance();
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
            LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
            this.currentLocations_ = lazyStringList;
            int i10 = this.bitField0_ & (-2);
            this.originalLocations_ = lazyStringList;
            this.bitField0_ = i10 & (-3);
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
            this.currentLocations_ = lazyStringList;
            this.originalLocations_ = lazyStringList;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ResourceLocation) {
                return mergeFrom((ResourceLocation) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(ResourceLocation resourceLocation) {
            if (resourceLocation == ResourceLocation.getDefaultInstance()) {
                return this;
            }
            if (!resourceLocation.currentLocations_.isEmpty()) {
                if (this.currentLocations_.isEmpty()) {
                    this.currentLocations_ = resourceLocation.currentLocations_;
                    this.bitField0_ &= -2;
                } else {
                    ensureCurrentLocationsIsMutable();
                    this.currentLocations_.addAll(resourceLocation.currentLocations_);
                }
                onChanged();
            }
            if (!resourceLocation.originalLocations_.isEmpty()) {
                if (this.originalLocations_.isEmpty()) {
                    this.originalLocations_ = resourceLocation.originalLocations_;
                    this.bitField0_ &= -3;
                } else {
                    ensureOriginalLocationsIsMutable();
                    this.originalLocations_.addAll(resourceLocation.originalLocations_);
                }
                onChanged();
            }
            mergeUnknownFields(resourceLocation.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.cloud.audit.ResourceLocation.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.cloud.audit.ResourceLocation.access$700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.cloud.audit.ResourceLocation r3 = (com.google.cloud.audit.ResourceLocation) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.cloud.audit.ResourceLocation r4 = (com.google.cloud.audit.ResourceLocation) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.cloud.audit.ResourceLocation.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.cloud.audit.ResourceLocation$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<ResourceLocation> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResourceLocation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ResourceLocation(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ ResourceLocation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static ResourceLocation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return w7.a.f54278i;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ResourceLocation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ResourceLocation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ResourceLocation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<ResourceLocation> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResourceLocation)) {
            return super.equals(obj);
        }
        ResourceLocation resourceLocation = (ResourceLocation) obj;
        return getCurrentLocationsList().equals(resourceLocation.getCurrentLocationsList()) && getOriginalLocationsList().equals(resourceLocation.getOriginalLocationsList()) && this.unknownFields.equals(resourceLocation.unknownFields);
    }

    @Override // com.google.cloud.audit.ResourceLocationOrBuilder
    public String getCurrentLocations(int i10) {
        return this.currentLocations_.get(i10);
    }

    @Override // com.google.cloud.audit.ResourceLocationOrBuilder
    public ByteString getCurrentLocationsBytes(int i10) {
        return this.currentLocations_.getByteString(i10);
    }

    @Override // com.google.cloud.audit.ResourceLocationOrBuilder
    public int getCurrentLocationsCount() {
        return this.currentLocations_.size();
    }

    @Override // com.google.cloud.audit.ResourceLocationOrBuilder
    public String getOriginalLocations(int i10) {
        return this.originalLocations_.get(i10);
    }

    @Override // com.google.cloud.audit.ResourceLocationOrBuilder
    public ByteString getOriginalLocationsBytes(int i10) {
        return this.originalLocations_.getByteString(i10);
    }

    @Override // com.google.cloud.audit.ResourceLocationOrBuilder
    public int getOriginalLocationsCount() {
        return this.originalLocations_.size();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ResourceLocation> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.currentLocations_.size(); i12++) {
            i11 += GeneratedMessageV3.computeStringSizeNoTag(this.currentLocations_.getRaw(i12));
        }
        int size = i11 + 0 + (getCurrentLocationsList().size() * 1);
        int i13 = 0;
        for (int i14 = 0; i14 < this.originalLocations_.size(); i14++) {
            i13 += GeneratedMessageV3.computeStringSizeNoTag(this.originalLocations_.getRaw(i14));
        }
        int size2 = size + i13 + (getOriginalLocationsList().size() * 1) + this.unknownFields.getSerializedSize();
        this.memoizedSize = size2;
        return size2;
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
        if (getCurrentLocationsCount() > 0) {
            hashCode = (((hashCode * 37) + 1) * 53) + getCurrentLocationsList().hashCode();
        }
        if (getOriginalLocationsCount() > 0) {
            hashCode = (((hashCode * 37) + 2) * 53) + getOriginalLocationsList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return w7.a.f54279j.ensureFieldAccessorsInitialized(ResourceLocation.class, Builder.class);
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
        return new ResourceLocation();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i10 = 0; i10 < this.currentLocations_.size(); i10++) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.currentLocations_.getRaw(i10));
        }
        for (int i11 = 0; i11 < this.originalLocations_.size(); i11++) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.originalLocations_.getRaw(i11));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ ResourceLocation(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(ResourceLocation resourceLocation) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(resourceLocation);
    }

    public static ResourceLocation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceLocation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ResourceLocation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    @Override // com.google.cloud.audit.ResourceLocationOrBuilder
    public ProtocolStringList getCurrentLocationsList() {
        return this.currentLocations_;
    }

    @Override // com.google.cloud.audit.ResourceLocationOrBuilder
    public ProtocolStringList getOriginalLocationsList() {
        return this.originalLocations_;
    }

    private ResourceLocation(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ResourceLocation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ResourceLocation getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static ResourceLocation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private ResourceLocation() {
        this.memoizedIsInitialized = (byte) -1;
        LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
        this.currentLocations_ = lazyStringList;
        this.originalLocations_ = lazyStringList;
    }

    public static ResourceLocation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static ResourceLocation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ResourceLocation parseFrom(InputStream inputStream) throws IOException {
        return (ResourceLocation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ResourceLocation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceLocation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    private ResourceLocation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                if ((i10 & 1) == 0) {
                                    this.currentLocations_ = new LazyStringArrayList();
                                    i10 |= 1;
                                }
                                this.currentLocations_.add((LazyStringList) readStringRequireUtf8);
                            } else if (readTag != 18) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                                if ((i10 & 2) == 0) {
                                    this.originalLocations_ = new LazyStringArrayList();
                                    i10 |= 2;
                                }
                                this.originalLocations_.add((LazyStringList) readStringRequireUtf82);
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
                    this.currentLocations_ = this.currentLocations_.getUnmodifiableView();
                }
                if ((i10 & 2) != 0) {
                    this.originalLocations_ = this.originalLocations_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static ResourceLocation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ResourceLocation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ResourceLocation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceLocation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
