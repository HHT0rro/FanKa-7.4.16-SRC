package com.google.geo.type;

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
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.type.LatLng;
import com.google.type.LatLngOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Viewport extends GeneratedMessageV3 implements ViewportOrBuilder {
    public static final int HIGH_FIELD_NUMBER = 2;
    public static final int LOW_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private LatLng high_;
    private LatLng low_;
    private byte memoizedIsInitialized;
    private static final Viewport DEFAULT_INSTANCE = new Viewport();
    private static final Parser<Viewport> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ViewportOrBuilder {
        private SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> highBuilder_;
        private LatLng high_;
        private SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> lowBuilder_;
        private LatLng low_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return f8.a.f49230a;
        }

        private SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> getHighFieldBuilder() {
            if (this.highBuilder_ == null) {
                this.highBuilder_ = new SingleFieldBuilderV3<>(getHigh(), getParentForChildren(), isClean());
                this.high_ = null;
            }
            return this.highBuilder_;
        }

        private SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> getLowFieldBuilder() {
            if (this.lowBuilder_ == null) {
                this.lowBuilder_ = new SingleFieldBuilderV3<>(getLow(), getParentForChildren(), isClean());
                this.low_ = null;
            }
            return this.lowBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearHigh() {
            if (this.highBuilder_ == null) {
                this.high_ = null;
                onChanged();
            } else {
                this.high_ = null;
                this.highBuilder_ = null;
            }
            return this;
        }

        public Builder clearLow() {
            if (this.lowBuilder_ == null) {
                this.low_ = null;
                onChanged();
            } else {
                this.low_ = null;
                this.lowBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return f8.a.f49230a;
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public LatLng getHigh() {
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.highBuilder_;
            if (singleFieldBuilderV3 == null) {
                LatLng latLng = this.high_;
                return latLng == null ? LatLng.getDefaultInstance() : latLng;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public LatLng.Builder getHighBuilder() {
            onChanged();
            return getHighFieldBuilder().getBuilder();
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public LatLngOrBuilder getHighOrBuilder() {
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.highBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            LatLng latLng = this.high_;
            return latLng == null ? LatLng.getDefaultInstance() : latLng;
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public LatLng getLow() {
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
            if (singleFieldBuilderV3 == null) {
                LatLng latLng = this.low_;
                return latLng == null ? LatLng.getDefaultInstance() : latLng;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public LatLng.Builder getLowBuilder() {
            onChanged();
            return getLowFieldBuilder().getBuilder();
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public LatLngOrBuilder getLowOrBuilder() {
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            LatLng latLng = this.low_;
            return latLng == null ? LatLng.getDefaultInstance() : latLng;
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public boolean hasHigh() {
            return (this.highBuilder_ == null && this.high_ == null) ? false : true;
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public boolean hasLow() {
            return (this.lowBuilder_ == null && this.low_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return f8.a.f49231b.ensureFieldAccessorsInitialized(Viewport.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeHigh(LatLng latLng) {
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.highBuilder_;
            if (singleFieldBuilderV3 == null) {
                LatLng latLng2 = this.high_;
                if (latLng2 != null) {
                    this.high_ = LatLng.newBuilder(latLng2).mergeFrom(latLng).buildPartial();
                } else {
                    this.high_ = latLng;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(latLng);
            }
            return this;
        }

        public Builder mergeLow(LatLng latLng) {
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
            if (singleFieldBuilderV3 == null) {
                LatLng latLng2 = this.low_;
                if (latLng2 != null) {
                    this.low_ = LatLng.newBuilder(latLng2).mergeFrom(latLng).buildPartial();
                } else {
                    this.low_ = latLng;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(latLng);
            }
            return this;
        }

        public Builder setHigh(LatLng latLng) {
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.highBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(latLng);
                this.high_ = latLng;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(latLng);
            }
            return this;
        }

        public Builder setLow(LatLng latLng) {
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(latLng);
                this.low_ = latLng;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(latLng);
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
        public Viewport build() {
            Viewport buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Viewport buildPartial() {
            Viewport viewport = new Viewport(this, (a) null);
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
            if (singleFieldBuilderV3 == null) {
                viewport.low_ = this.low_;
            } else {
                viewport.low_ = singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV32 = this.highBuilder_;
            if (singleFieldBuilderV32 == null) {
                viewport.high_ = this.high_;
            } else {
                viewport.high_ = singleFieldBuilderV32.build();
            }
            onBuilt();
            return viewport;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Viewport getDefaultInstanceForType() {
            return Viewport.getDefaultInstance();
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
            if (this.lowBuilder_ == null) {
                this.low_ = null;
            } else {
                this.low_ = null;
                this.lowBuilder_ = null;
            }
            if (this.highBuilder_ == null) {
                this.high_ = null;
            } else {
                this.high_ = null;
                this.highBuilder_ = null;
            }
            return this;
        }

        public Builder setHigh(LatLng.Builder builder) {
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.highBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.high_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setLow(LatLng.Builder builder) {
            SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.low_ = builder.build();
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
            if (message instanceof Viewport) {
                return mergeFrom((Viewport) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Viewport viewport) {
            if (viewport == Viewport.getDefaultInstance()) {
                return this;
            }
            if (viewport.hasLow()) {
                mergeLow(viewport.getLow());
            }
            if (viewport.hasHigh()) {
                mergeHigh(viewport.getHigh());
            }
            mergeUnknownFields(viewport.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.geo.type.Viewport.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.geo.type.Viewport.access$700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.geo.type.Viewport r3 = (com.google.geo.type.Viewport) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.geo.type.Viewport r4 = (com.google.geo.type.Viewport) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.geo.type.Viewport.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.geo.type.Viewport$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<Viewport> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Viewport parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Viewport(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ Viewport(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static Viewport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return f8.a.f49230a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Viewport parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Viewport) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Viewport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Viewport> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Viewport)) {
            return super.equals(obj);
        }
        Viewport viewport = (Viewport) obj;
        if (hasLow() != viewport.hasLow()) {
            return false;
        }
        if ((!hasLow() || getLow().equals(viewport.getLow())) && hasHigh() == viewport.hasHigh()) {
            return (!hasHigh() || getHigh().equals(viewport.getHigh())) && this.unknownFields.equals(viewport.unknownFields);
        }
        return false;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public LatLng getHigh() {
        LatLng latLng = this.high_;
        return latLng == null ? LatLng.getDefaultInstance() : latLng;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public LatLngOrBuilder getHighOrBuilder() {
        return getHigh();
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public LatLng getLow() {
        LatLng latLng = this.low_;
        return latLng == null ? LatLng.getDefaultInstance() : latLng;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public LatLngOrBuilder getLowOrBuilder() {
        return getLow();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Viewport> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeMessageSize = this.low_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getLow()) : 0;
        if (this.high_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, getHigh());
        }
        int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public boolean hasHigh() {
        return this.high_ != null;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public boolean hasLow() {
        return this.low_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode();
        if (hasLow()) {
            hashCode = (((hashCode * 37) + 1) * 53) + getLow().hashCode();
        }
        if (hasHigh()) {
            hashCode = (((hashCode * 37) + 2) * 53) + getHigh().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return f8.a.f49231b.ensureFieldAccessorsInitialized(Viewport.class, Builder.class);
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
        return new Viewport();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.low_ != null) {
            codedOutputStream.writeMessage(1, getLow());
        }
        if (this.high_ != null) {
            codedOutputStream.writeMessage(2, getHigh());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ Viewport(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(Viewport viewport) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(viewport);
    }

    public static Viewport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Viewport) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Viewport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private Viewport(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Viewport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Viewport getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static Viewport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Viewport() {
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Viewport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static Viewport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    private Viewport(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        LatLng.Builder builder;
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                LatLng latLng = this.low_;
                                builder = latLng != null ? latLng.toBuilder() : null;
                                LatLng latLng2 = (LatLng) codedInputStream.readMessage(LatLng.parser(), extensionRegistryLite);
                                this.low_ = latLng2;
                                if (builder != null) {
                                    builder.mergeFrom(latLng2);
                                    this.low_ = builder.buildPartial();
                                }
                            } else if (readTag != 18) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                LatLng latLng3 = this.high_;
                                builder = latLng3 != null ? latLng3.toBuilder() : null;
                                LatLng latLng4 = (LatLng) codedInputStream.readMessage(LatLng.parser(), extensionRegistryLite);
                                this.high_ = latLng4;
                                if (builder != null) {
                                    builder.mergeFrom(latLng4);
                                    this.high_ = builder.buildPartial();
                                }
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

    public static Viewport parseFrom(InputStream inputStream) throws IOException {
        return (Viewport) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Viewport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Viewport) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Viewport parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Viewport) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Viewport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Viewport) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
