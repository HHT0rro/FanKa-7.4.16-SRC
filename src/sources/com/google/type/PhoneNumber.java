package com.google.type;

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
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import s8.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class PhoneNumber extends GeneratedMessageV3 implements PhoneNumberOrBuilder {
    public static final int E164_NUMBER_FIELD_NUMBER = 1;
    public static final int EXTENSION_FIELD_NUMBER = 3;
    public static final int SHORT_CODE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Object extension_;
    private int kindCase_;
    private Object kind_;
    private byte memoizedIsInitialized;
    private static final PhoneNumber DEFAULT_INSTANCE = new PhoneNumber();
    private static final Parser<PhoneNumber> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PhoneNumberOrBuilder {
        private Object extension_;
        private int kindCase_;
        private Object kind_;
        private SingleFieldBuilderV3<ShortCode, ShortCode.Builder, ShortCodeOrBuilder> shortCodeBuilder_;

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return n.f53664a;
        }

        private SingleFieldBuilderV3<ShortCode, ShortCode.Builder, ShortCodeOrBuilder> getShortCodeFieldBuilder() {
            if (this.shortCodeBuilder_ == null) {
                if (this.kindCase_ != 2) {
                    this.kind_ = ShortCode.getDefaultInstance();
                }
                this.shortCodeBuilder_ = new SingleFieldBuilderV3<>((ShortCode) this.kind_, getParentForChildren(), isClean());
                this.kind_ = null;
            }
            this.kindCase_ = 2;
            onChanged();
            return this.shortCodeBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearE164Number() {
            if (this.kindCase_ == 1) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearExtension() {
            this.extension_ = PhoneNumber.getDefaultInstance().getExtension();
            onChanged();
            return this;
        }

        public Builder clearKind() {
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
            return this;
        }

        public Builder clearShortCode() {
            SingleFieldBuilderV3<ShortCode, ShortCode.Builder, ShortCodeOrBuilder> singleFieldBuilderV3 = this.shortCodeBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.kindCase_ == 2) {
                    this.kindCase_ = 0;
                    this.kind_ = null;
                    onChanged();
                }
            } else {
                if (this.kindCase_ == 2) {
                    this.kindCase_ = 0;
                    this.kind_ = null;
                }
                singleFieldBuilderV3.clear();
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return n.f53664a;
        }

        @Override // com.google.type.PhoneNumberOrBuilder
        public String getE164Number() {
            String str = this.kindCase_ == 1 ? this.kind_ : "";
            if (!(str instanceof String)) {
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.kindCase_ == 1) {
                    this.kind_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) str;
        }

        @Override // com.google.type.PhoneNumberOrBuilder
        public ByteString getE164NumberBytes() {
            String str = this.kindCase_ == 1 ? this.kind_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.kindCase_ == 1) {
                    this.kind_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.type.PhoneNumberOrBuilder
        public String getExtension() {
            Object obj = this.extension_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.extension_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.type.PhoneNumberOrBuilder
        public ByteString getExtensionBytes() {
            Object obj = this.extension_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.extension_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PhoneNumberOrBuilder
        public KindCase getKindCase() {
            return KindCase.forNumber(this.kindCase_);
        }

        @Override // com.google.type.PhoneNumberOrBuilder
        public ShortCode getShortCode() {
            SingleFieldBuilderV3<ShortCode, ShortCode.Builder, ShortCodeOrBuilder> singleFieldBuilderV3 = this.shortCodeBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.kindCase_ == 2) {
                    return (ShortCode) this.kind_;
                }
                return ShortCode.getDefaultInstance();
            }
            if (this.kindCase_ == 2) {
                return singleFieldBuilderV3.getMessage();
            }
            return ShortCode.getDefaultInstance();
        }

        public ShortCode.Builder getShortCodeBuilder() {
            return getShortCodeFieldBuilder().getBuilder();
        }

        @Override // com.google.type.PhoneNumberOrBuilder
        public ShortCodeOrBuilder getShortCodeOrBuilder() {
            SingleFieldBuilderV3<ShortCode, ShortCode.Builder, ShortCodeOrBuilder> singleFieldBuilderV3;
            int i10 = this.kindCase_;
            if (i10 == 2 && (singleFieldBuilderV3 = this.shortCodeBuilder_) != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i10 == 2) {
                return (ShortCode) this.kind_;
            }
            return ShortCode.getDefaultInstance();
        }

        @Override // com.google.type.PhoneNumberOrBuilder
        public boolean hasE164Number() {
            return this.kindCase_ == 1;
        }

        @Override // com.google.type.PhoneNumberOrBuilder
        public boolean hasShortCode() {
            return this.kindCase_ == 2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return n.f53665b.ensureFieldAccessorsInitialized(PhoneNumber.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeShortCode(ShortCode shortCode) {
            SingleFieldBuilderV3<ShortCode, ShortCode.Builder, ShortCodeOrBuilder> singleFieldBuilderV3 = this.shortCodeBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.kindCase_ == 2 && this.kind_ != ShortCode.getDefaultInstance()) {
                    this.kind_ = ShortCode.newBuilder((ShortCode) this.kind_).mergeFrom(shortCode).buildPartial();
                } else {
                    this.kind_ = shortCode;
                }
                onChanged();
            } else if (this.kindCase_ == 2) {
                singleFieldBuilderV3.mergeFrom(shortCode);
            } else {
                singleFieldBuilderV3.setMessage(shortCode);
            }
            this.kindCase_ = 2;
            return this;
        }

        public Builder setE164Number(String str) {
            Objects.requireNonNull(str);
            this.kindCase_ = 1;
            this.kind_ = str;
            onChanged();
            return this;
        }

        public Builder setE164NumberBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.kindCase_ = 1;
            this.kind_ = byteString;
            onChanged();
            return this;
        }

        public Builder setExtension(String str) {
            Objects.requireNonNull(str);
            this.extension_ = str;
            onChanged();
            return this;
        }

        public Builder setExtensionBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.extension_ = byteString;
            onChanged();
            return this;
        }

        public Builder setShortCode(ShortCode shortCode) {
            SingleFieldBuilderV3<ShortCode, ShortCode.Builder, ShortCodeOrBuilder> singleFieldBuilderV3 = this.shortCodeBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(shortCode);
                this.kind_ = shortCode;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(shortCode);
            }
            this.kindCase_ = 2;
            return this;
        }

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private Builder() {
            this.kindCase_ = 0;
            this.extension_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PhoneNumber build() {
            PhoneNumber buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PhoneNumber buildPartial() {
            PhoneNumber phoneNumber = new PhoneNumber(this, (a) null);
            if (this.kindCase_ == 1) {
                phoneNumber.kind_ = this.kind_;
            }
            if (this.kindCase_ == 2) {
                SingleFieldBuilderV3<ShortCode, ShortCode.Builder, ShortCodeOrBuilder> singleFieldBuilderV3 = this.shortCodeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    phoneNumber.kind_ = this.kind_;
                } else {
                    phoneNumber.kind_ = singleFieldBuilderV3.build();
                }
            }
            phoneNumber.extension_ = this.extension_;
            phoneNumber.kindCase_ = this.kindCase_;
            onBuilt();
            return phoneNumber;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PhoneNumber getDefaultInstanceForType() {
            return PhoneNumber.getDefaultInstance();
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
            this.extension_ = "";
            this.kindCase_ = 0;
            this.kind_ = null;
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.kindCase_ = 0;
            this.extension_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof PhoneNumber) {
                return mergeFrom((PhoneNumber) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setShortCode(ShortCode.Builder builder) {
            SingleFieldBuilderV3<ShortCode, ShortCode.Builder, ShortCodeOrBuilder> singleFieldBuilderV3 = this.shortCodeBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.kind_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.kindCase_ = 2;
            return this;
        }

        public Builder mergeFrom(PhoneNumber phoneNumber) {
            if (phoneNumber == PhoneNumber.getDefaultInstance()) {
                return this;
            }
            if (!phoneNumber.getExtension().isEmpty()) {
                this.extension_ = phoneNumber.extension_;
                onChanged();
            }
            int i10 = b.f27111a[phoneNumber.getKindCase().ordinal()];
            if (i10 == 1) {
                this.kindCase_ = 1;
                this.kind_ = phoneNumber.kind_;
                onChanged();
            } else if (i10 == 2) {
                mergeShortCode(phoneNumber.getShortCode());
            }
            mergeUnknownFields(phoneNumber.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.type.PhoneNumber.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.type.PhoneNumber.access$1900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.type.PhoneNumber r3 = (com.google.type.PhoneNumber) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.type.PhoneNumber r4 = (com.google.type.PhoneNumber) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.type.PhoneNumber.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.type.PhoneNumber$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum KindCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        E164_NUMBER(1),
        SHORT_CODE(2),
        KIND_NOT_SET(0);

        private final int value;

        KindCase(int i10) {
            this.value = i10;
        }

        public static KindCase forNumber(int i10) {
            if (i10 == 0) {
                return KIND_NOT_SET;
            }
            if (i10 == 1) {
                return E164_NUMBER;
            }
            if (i10 != 2) {
                return null;
            }
            return SHORT_CODE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static KindCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class ShortCode extends GeneratedMessageV3 implements ShortCodeOrBuilder {
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int REGION_CODE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object number_;
        private volatile Object regionCode_;
        private static final ShortCode DEFAULT_INSTANCE = new ShortCode();
        private static final Parser<ShortCode> PARSER = new a();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ShortCodeOrBuilder {
            private Object number_;
            private Object regionCode_;

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return n.f53666c;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearNumber() {
                this.number_ = ShortCode.getDefaultInstance().getNumber();
                onChanged();
                return this;
            }

            public Builder clearRegionCode() {
                this.regionCode_ = ShortCode.getDefaultInstance().getRegionCode();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return n.f53666c;
            }

            @Override // com.google.type.PhoneNumber.ShortCodeOrBuilder
            public String getNumber() {
                Object obj = this.number_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.number_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.type.PhoneNumber.ShortCodeOrBuilder
            public ByteString getNumberBytes() {
                Object obj = this.number_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.number_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.type.PhoneNumber.ShortCodeOrBuilder
            public String getRegionCode() {
                Object obj = this.regionCode_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.regionCode_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.type.PhoneNumber.ShortCodeOrBuilder
            public ByteString getRegionCodeBytes() {
                Object obj = this.regionCode_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.regionCode_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return n.f53667d.ensureFieldAccessorsInitialized(ShortCode.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setNumber(String str) {
                Objects.requireNonNull(str);
                this.number_ = str;
                onChanged();
                return this;
            }

            public Builder setNumberBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.number_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRegionCode(String str) {
                Objects.requireNonNull(str);
                this.regionCode_ = str;
                onChanged();
                return this;
            }

            public Builder setRegionCodeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.regionCode_ = byteString;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                this.regionCode_ = "";
                this.number_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShortCode build() {
                ShortCode buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShortCode buildPartial() {
                ShortCode shortCode = new ShortCode(this, (a) null);
                shortCode.regionCode_ = this.regionCode_;
                shortCode.number_ = this.number_;
                onBuilt();
                return shortCode;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ShortCode getDefaultInstanceForType() {
                return ShortCode.getDefaultInstance();
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
                this.regionCode_ = "";
                this.number_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.regionCode_ = "";
                this.number_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ShortCode) {
                    return mergeFrom((ShortCode) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ShortCode shortCode) {
                if (shortCode == ShortCode.getDefaultInstance()) {
                    return this;
                }
                if (!shortCode.getRegionCode().isEmpty()) {
                    this.regionCode_ = shortCode.regionCode_;
                    onChanged();
                }
                if (!shortCode.getNumber().isEmpty()) {
                    this.number_ = shortCode.number_;
                    onChanged();
                }
                mergeUnknownFields(shortCode.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.type.PhoneNumber.ShortCode.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.type.PhoneNumber.ShortCode.access$700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.type.PhoneNumber$ShortCode r3 = (com.google.type.PhoneNumber.ShortCode) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.type.PhoneNumber$ShortCode r4 = (com.google.type.PhoneNumber.ShortCode) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.type.PhoneNumber.ShortCode.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.type.PhoneNumber$ShortCode$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<ShortCode> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ShortCode parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ShortCode(codedInputStream, extensionRegistryLite, null);
            }
        }

        public /* synthetic */ ShortCode(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static ShortCode getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return n.f53666c;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ShortCode parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ShortCode) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ShortCode parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<ShortCode> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortCode)) {
                return super.equals(obj);
            }
            ShortCode shortCode = (ShortCode) obj;
            return getRegionCode().equals(shortCode.getRegionCode()) && getNumber().equals(shortCode.getNumber()) && this.unknownFields.equals(shortCode.unknownFields);
        }

        @Override // com.google.type.PhoneNumber.ShortCodeOrBuilder
        public String getNumber() {
            Object obj = this.number_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.number_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.PhoneNumber.ShortCodeOrBuilder
        public ByteString getNumberBytes() {
            Object obj = this.number_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.number_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ShortCode> getParserForType() {
            return PARSER;
        }

        @Override // com.google.type.PhoneNumber.ShortCodeOrBuilder
        public String getRegionCode() {
            Object obj = this.regionCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.regionCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.PhoneNumber.ShortCodeOrBuilder
        public ByteString getRegionCodeBytes() {
            Object obj = this.regionCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.regionCode_ = copyFromUtf8;
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
            int computeStringSize = GeneratedMessageV3.isStringEmpty(this.regionCode_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.regionCode_);
            if (!GeneratedMessageV3.isStringEmpty(this.number_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(2, this.number_);
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
            int hashCode = ((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getRegionCode().hashCode()) * 37) + 2) * 53) + getNumber().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return n.f53667d.ensureFieldAccessorsInitialized(ShortCode.class, Builder.class);
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
            return new ShortCode();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!GeneratedMessageV3.isStringEmpty(this.regionCode_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.regionCode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.number_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.number_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ ShortCode(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(ShortCode shortCode) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(shortCode);
        }

        public static ShortCode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ShortCode) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ShortCode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private ShortCode(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ShortCode parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ShortCode getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static ShortCode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private ShortCode() {
            this.memoizedIsInitialized = (byte) -1;
            this.regionCode_ = "";
            this.number_ = "";
        }

        public static ShortCode parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static ShortCode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ShortCode parseFrom(InputStream inputStream) throws IOException {
            return (ShortCode) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ShortCode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ShortCode) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        private ShortCode(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.regionCode_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag != 18) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.number_ = codedInputStream.readStringRequireUtf8();
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

        public static ShortCode parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ShortCode) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ShortCode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ShortCode) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ShortCodeOrBuilder extends MessageOrBuilder {
        String getNumber();

        ByteString getNumberBytes();

        String getRegionCode();

        ByteString getRegionCodeBytes();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<PhoneNumber> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhoneNumber parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PhoneNumber(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27111a;

        static {
            int[] iArr = new int[KindCase.values().length];
            f27111a = iArr;
            try {
                iArr[KindCase.E164_NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27111a[KindCase.SHORT_CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27111a[KindCase.KIND_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public /* synthetic */ PhoneNumber(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static PhoneNumber getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return n.f53664a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PhoneNumber parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PhoneNumber) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PhoneNumber parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<PhoneNumber> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneNumber)) {
            return super.equals(obj);
        }
        PhoneNumber phoneNumber = (PhoneNumber) obj;
        if (!getExtension().equals(phoneNumber.getExtension()) || !getKindCase().equals(phoneNumber.getKindCase())) {
            return false;
        }
        int i10 = this.kindCase_;
        if (i10 != 1) {
            if (i10 == 2 && !getShortCode().equals(phoneNumber.getShortCode())) {
                return false;
            }
        } else if (!getE164Number().equals(phoneNumber.getE164Number())) {
            return false;
        }
        return this.unknownFields.equals(phoneNumber.unknownFields);
    }

    @Override // com.google.type.PhoneNumberOrBuilder
    public String getE164Number() {
        String str = this.kindCase_ == 1 ? this.kind_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.kindCase_ == 1) {
            this.kind_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.type.PhoneNumberOrBuilder
    public ByteString getE164NumberBytes() {
        String str = this.kindCase_ == 1 ? this.kind_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.kindCase_ == 1) {
                this.kind_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.type.PhoneNumberOrBuilder
    public String getExtension() {
        Object obj = this.extension_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.extension_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PhoneNumberOrBuilder
    public ByteString getExtensionBytes() {
        Object obj = this.extension_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.extension_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PhoneNumberOrBuilder
    public KindCase getKindCase() {
        return KindCase.forNumber(this.kindCase_);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PhoneNumber> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = this.kindCase_ == 1 ? 0 + GeneratedMessageV3.computeStringSize(1, this.kind_) : 0;
        if (this.kindCase_ == 2) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, (ShortCode) this.kind_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.extension_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(3, this.extension_);
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.type.PhoneNumberOrBuilder
    public ShortCode getShortCode() {
        if (this.kindCase_ == 2) {
            return (ShortCode) this.kind_;
        }
        return ShortCode.getDefaultInstance();
    }

    @Override // com.google.type.PhoneNumberOrBuilder
    public ShortCodeOrBuilder getShortCodeOrBuilder() {
        if (this.kindCase_ == 2) {
            return (ShortCode) this.kind_;
        }
        return ShortCode.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.type.PhoneNumberOrBuilder
    public boolean hasE164Number() {
        return this.kindCase_ == 1;
    }

    @Override // com.google.type.PhoneNumberOrBuilder
    public boolean hasShortCode() {
        return this.kindCase_ == 2;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10;
        int hashCode;
        int i11 = this.memoizedHashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode2 = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 3) * 53) + getExtension().hashCode();
        int i12 = this.kindCase_;
        if (i12 == 1) {
            i10 = ((hashCode2 * 37) + 1) * 53;
            hashCode = getE164Number().hashCode();
        } else {
            if (i12 == 2) {
                i10 = ((hashCode2 * 37) + 2) * 53;
                hashCode = getShortCode().hashCode();
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
        return n.f53665b.ensureFieldAccessorsInitialized(PhoneNumber.class, Builder.class);
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
        return new PhoneNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.kindCase_ == 1) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.kind_);
        }
        if (this.kindCase_ == 2) {
            codedOutputStream.writeMessage(2, (ShortCode) this.kind_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.extension_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.extension_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ PhoneNumber(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(PhoneNumber phoneNumber) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(phoneNumber);
    }

    public static PhoneNumber parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PhoneNumber) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PhoneNumber parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private PhoneNumber(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.kindCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PhoneNumber parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PhoneNumber getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static PhoneNumber parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static PhoneNumber parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    private PhoneNumber() {
        this.kindCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
        this.extension_ = "";
    }

    public static PhoneNumber parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PhoneNumber parseFrom(InputStream inputStream) throws IOException {
        return (PhoneNumber) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PhoneNumber parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PhoneNumber) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PhoneNumber parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PhoneNumber) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    private PhoneNumber(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.kindCase_ = 1;
                                this.kind_ = readStringRequireUtf8;
                            } else if (readTag == 18) {
                                ShortCode.Builder builder = this.kindCase_ == 2 ? ((ShortCode) this.kind_).toBuilder() : null;
                                MessageLite readMessage = codedInputStream.readMessage(ShortCode.parser(), extensionRegistryLite);
                                this.kind_ = readMessage;
                                if (builder != null) {
                                    builder.mergeFrom((ShortCode) readMessage);
                                    this.kind_ = builder.buildPartial();
                                }
                                this.kindCase_ = 2;
                            } else if (readTag != 26) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.extension_ = codedInputStream.readStringRequireUtf8();
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
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static PhoneNumber parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PhoneNumber) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
