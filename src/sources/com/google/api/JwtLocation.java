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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class JwtLocation extends GeneratedMessageV3 implements JwtLocationOrBuilder {
    public static final int HEADER_FIELD_NUMBER = 1;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int VALUE_PREFIX_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int inCase_;
    private Object in_;
    private byte memoizedIsInitialized;
    private volatile Object valuePrefix_;
    private static final JwtLocation DEFAULT_INSTANCE = new JwtLocation();
    private static final Parser<JwtLocation> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements JwtLocationOrBuilder {
        private int inCase_;
        private Object in_;
        private Object valuePrefix_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return u7.b.f53838e;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearHeader() {
            if (this.inCase_ == 1) {
                this.inCase_ = 0;
                this.in_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearIn() {
            this.inCase_ = 0;
            this.in_ = null;
            onChanged();
            return this;
        }

        public Builder clearQuery() {
            if (this.inCase_ == 2) {
                this.inCase_ = 0;
                this.in_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearValuePrefix() {
            this.valuePrefix_ = JwtLocation.getDefaultInstance().getValuePrefix();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return u7.b.f53838e;
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public String getHeader() {
            String str = this.inCase_ == 1 ? this.in_ : "";
            if (!(str instanceof String)) {
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.inCase_ == 1) {
                    this.in_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) str;
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public ByteString getHeaderBytes() {
            String str = this.inCase_ == 1 ? this.in_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.inCase_ == 1) {
                    this.in_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public InCase getInCase() {
            return InCase.forNumber(this.inCase_);
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public String getQuery() {
            String str = this.inCase_ == 2 ? this.in_ : "";
            if (!(str instanceof String)) {
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.inCase_ == 2) {
                    this.in_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) str;
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public ByteString getQueryBytes() {
            String str = this.inCase_ == 2 ? this.in_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.inCase_ == 2) {
                    this.in_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public String getValuePrefix() {
            Object obj = this.valuePrefix_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.valuePrefix_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public ByteString getValuePrefixBytes() {
            Object obj = this.valuePrefix_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.valuePrefix_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public boolean hasHeader() {
            return this.inCase_ == 1;
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public boolean hasQuery() {
            return this.inCase_ == 2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return u7.b.f53839f.ensureFieldAccessorsInitialized(JwtLocation.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setHeader(String str) {
            Objects.requireNonNull(str);
            this.inCase_ = 1;
            this.in_ = str;
            onChanged();
            return this;
        }

        public Builder setHeaderBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.inCase_ = 1;
            this.in_ = byteString;
            onChanged();
            return this;
        }

        public Builder setQuery(String str) {
            Objects.requireNonNull(str);
            this.inCase_ = 2;
            this.in_ = str;
            onChanged();
            return this;
        }

        public Builder setQueryBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.inCase_ = 2;
            this.in_ = byteString;
            onChanged();
            return this;
        }

        public Builder setValuePrefix(String str) {
            Objects.requireNonNull(str);
            this.valuePrefix_ = str;
            onChanged();
            return this;
        }

        public Builder setValuePrefixBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.valuePrefix_ = byteString;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.inCase_ = 0;
            this.valuePrefix_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public JwtLocation build() {
            JwtLocation buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public JwtLocation buildPartial() {
            JwtLocation jwtLocation = new JwtLocation(this, (a) null);
            if (this.inCase_ == 1) {
                jwtLocation.in_ = this.in_;
            }
            if (this.inCase_ == 2) {
                jwtLocation.in_ = this.in_;
            }
            jwtLocation.valuePrefix_ = this.valuePrefix_;
            jwtLocation.inCase_ = this.inCase_;
            onBuilt();
            return jwtLocation;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public JwtLocation getDefaultInstanceForType() {
            return JwtLocation.getDefaultInstance();
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
            this.valuePrefix_ = "";
            this.inCase_ = 0;
            this.in_ = null;
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.inCase_ = 0;
            this.valuePrefix_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof JwtLocation) {
                return mergeFrom((JwtLocation) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(JwtLocation jwtLocation) {
            if (jwtLocation == JwtLocation.getDefaultInstance()) {
                return this;
            }
            if (!jwtLocation.getValuePrefix().isEmpty()) {
                this.valuePrefix_ = jwtLocation.valuePrefix_;
                onChanged();
            }
            int i10 = b.f25928a[jwtLocation.getInCase().ordinal()];
            if (i10 == 1) {
                this.inCase_ = 1;
                this.in_ = jwtLocation.in_;
                onChanged();
            } else if (i10 == 2) {
                this.inCase_ = 2;
                this.in_ = jwtLocation.in_;
                onChanged();
            }
            mergeUnknownFields(jwtLocation.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.JwtLocation.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.JwtLocation.access$800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.JwtLocation r3 = (com.google.api.JwtLocation) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.JwtLocation r4 = (com.google.api.JwtLocation) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.JwtLocation.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.JwtLocation$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum InCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        HEADER(1),
        QUERY(2),
        IN_NOT_SET(0);

        private final int value;

        InCase(int i10) {
            this.value = i10;
        }

        public static InCase forNumber(int i10) {
            if (i10 == 0) {
                return IN_NOT_SET;
            }
            if (i10 == 1) {
                return HEADER;
            }
            if (i10 != 2) {
                return null;
            }
            return QUERY;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static InCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<JwtLocation> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JwtLocation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new JwtLocation(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25928a;

        static {
            int[] iArr = new int[InCase.values().length];
            f25928a = iArr;
            try {
                iArr[InCase.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25928a[InCase.QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25928a[InCase.IN_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public /* synthetic */ JwtLocation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static JwtLocation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return u7.b.f53838e;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static JwtLocation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (JwtLocation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static JwtLocation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<JwtLocation> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JwtLocation)) {
            return super.equals(obj);
        }
        JwtLocation jwtLocation = (JwtLocation) obj;
        if (!getValuePrefix().equals(jwtLocation.getValuePrefix()) || !getInCase().equals(jwtLocation.getInCase())) {
            return false;
        }
        int i10 = this.inCase_;
        if (i10 != 1) {
            if (i10 == 2 && !getQuery().equals(jwtLocation.getQuery())) {
                return false;
            }
        } else if (!getHeader().equals(jwtLocation.getHeader())) {
            return false;
        }
        return this.unknownFields.equals(jwtLocation.unknownFields);
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public String getHeader() {
        String str = this.inCase_ == 1 ? this.in_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.inCase_ == 1) {
            this.in_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public ByteString getHeaderBytes() {
        String str = this.inCase_ == 1 ? this.in_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.inCase_ == 1) {
                this.in_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public InCase getInCase() {
        return InCase.forNumber(this.inCase_);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<JwtLocation> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public String getQuery() {
        String str = this.inCase_ == 2 ? this.in_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.inCase_ == 2) {
            this.in_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public ByteString getQueryBytes() {
        String str = this.inCase_ == 2 ? this.in_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.inCase_ == 2) {
                this.in_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = this.inCase_ == 1 ? 0 + GeneratedMessageV3.computeStringSize(1, this.in_) : 0;
        if (this.inCase_ == 2) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.in_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.valuePrefix_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(3, this.valuePrefix_);
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public String getValuePrefix() {
        Object obj = this.valuePrefix_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.valuePrefix_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public ByteString getValuePrefixBytes() {
        Object obj = this.valuePrefix_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.valuePrefix_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public boolean hasHeader() {
        return this.inCase_ == 1;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public boolean hasQuery() {
        return this.inCase_ == 2;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10;
        int hashCode;
        int i11 = this.memoizedHashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode2 = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 3) * 53) + getValuePrefix().hashCode();
        int i12 = this.inCase_;
        if (i12 == 1) {
            i10 = ((hashCode2 * 37) + 1) * 53;
            hashCode = getHeader().hashCode();
        } else {
            if (i12 == 2) {
                i10 = ((hashCode2 * 37) + 2) * 53;
                hashCode = getQuery().hashCode();
            }
            int hashCode3 = (hashCode2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode3;
            return hashCode3;
        }
        hashCode2 = i10 + hashCode;
        int hashCode32 = (hashCode2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode32;
        return hashCode32;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return u7.b.f53839f.ensureFieldAccessorsInitialized(JwtLocation.class, Builder.class);
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
        return new JwtLocation();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.inCase_ == 1) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.in_);
        }
        if (this.inCase_ == 2) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.in_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.valuePrefix_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.valuePrefix_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ JwtLocation(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(JwtLocation jwtLocation) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(jwtLocation);
    }

    public static JwtLocation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtLocation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static JwtLocation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private JwtLocation(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.inCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static JwtLocation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public JwtLocation getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static JwtLocation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static JwtLocation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    private JwtLocation() {
        this.inCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
        this.valuePrefix_ = "";
    }

    public static JwtLocation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static JwtLocation parseFrom(InputStream inputStream) throws IOException {
        return (JwtLocation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static JwtLocation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtLocation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static JwtLocation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (JwtLocation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    private JwtLocation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
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
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                this.inCase_ = 1;
                                this.in_ = readStringRequireUtf8;
                            } else if (readTag == 18) {
                                String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                                this.inCase_ = 2;
                                this.in_ = readStringRequireUtf82;
                            } else if (readTag != 26) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.valuePrefix_ = codedInputStream.readStringRequireUtf8();
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

    public static JwtLocation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtLocation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
