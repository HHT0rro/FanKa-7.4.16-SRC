package com.irisdt.dau;

import com.android.internal.logging.nano.MetricsProto;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.irisdt.CommonProtos;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class DayActiveUserProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019DayActiveUserProtos.proto\u0012\u000ecom.irisdt.dau\u001a\u0012CommonProtos.proto\"t\n\u0007Request\u0012\f\n\u0004time\u0018\u0001 \u0001(\u0003\u0012\"\n\u0004name\u0018\u0002 \u0001(\u000e2\u0014.com.irisdt.dau.NAME\u0012\"\n\u0006common\u0018\u0003 \u0001(\u000b2\u0012.com.irisdt.Common\u0012\u0013\n\u000bclient_time\u0018\u0004 \u0001(\u0003\"\u0018\n\bResponse\u0012\f\n\u0004code\u0018\u0001 \u0001(\u0005*`\n\u0004NAME\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\t\n\u0005LOGIN\u0010\u0001\u0012\u0013\n\u000fSWITCH_TO_FRONT\u0010\u0002\u0012\u0012\n\u000eSWITCH_TO_BACK\u0010\u0003\u0012\u000b\n\u0007REGULAR\u0010\u0004\u0012\n\n\u0006LOGOUT\u0010\u00052N\n\rReportService\u0012=\n\u0006Report\u0012\u0017.com.irisdt.dau.Request\u001a\u0018.com.irisdt.dau.Response\"\u0000B\u0012¢\u0002\u000fDAY_ACTIVE_USERb\u0006proto3"}, new Descriptors.FileDescriptor[]{CommonProtos.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_irisdt_dau_Request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_dau_Request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_irisdt_dau_Response_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_dau_Response_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum NAME implements ProtocolMessageEnum {
        UNKNOWN(0),
        LOGIN(1),
        SWITCH_TO_FRONT(2),
        SWITCH_TO_BACK(3),
        REGULAR(4),
        LOGOUT(5),
        UNRECOGNIZED(-1);

        public static final int LOGIN_VALUE = 1;
        public static final int LOGOUT_VALUE = 5;
        public static final int REGULAR_VALUE = 4;
        public static final int SWITCH_TO_BACK_VALUE = 3;
        public static final int SWITCH_TO_FRONT_VALUE = 2;
        public static final int UNKNOWN_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<NAME> internalValueMap = new Internal.EnumLiteMap<NAME>() { // from class: com.irisdt.dau.DayActiveUserProtos.NAME.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public NAME findValueByNumber(int i10) {
                return NAME.forNumber(i10);
            }
        };
        private static final NAME[] VALUES = values();

        NAME(int i10) {
            this.value = i10;
        }

        public static NAME forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN;
            }
            if (i10 == 1) {
                return LOGIN;
            }
            if (i10 == 2) {
                return SWITCH_TO_FRONT;
            }
            if (i10 == 3) {
                return SWITCH_TO_BACK;
            }
            if (i10 == 4) {
                return REGULAR;
            }
            if (i10 != 5) {
                return null;
            }
            return LOGOUT;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return DayActiveUserProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<NAME> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static NAME valueOf(int i10) {
            return forNumber(i10);
        }

        public static NAME valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int CLIENT_TIME_FIELD_NUMBER = 4;
        public static final int COMMON_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int TIME_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private long clientTime_;
        private CommonProtos.Common common_;
        private byte memoizedIsInitialized;
        private int name_;
        private long time_;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.irisdt.dau.DayActiveUserProtos.Request.1
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DayActiveUserProtos.internal_static_com_irisdt_dau_Request_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return super.equals(obj);
            }
            Request request = (Request) obj;
            if (getTime() == request.getTime() && this.name_ == request.name_ && hasCommon() == request.hasCommon()) {
                return (!hasCommon() || getCommon().equals(request.getCommon())) && getClientTime() == request.getClientTime() && this.unknownFields.equals(request.unknownFields);
            }
            return false;
        }

        @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
        public long getClientTime() {
            return this.clientTime_;
        }

        @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
        public CommonProtos.Common getCommon() {
            CommonProtos.Common common = this.common_;
            return common == null ? CommonProtos.Common.getDefaultInstance() : common;
        }

        @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
        public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
        public NAME getName() {
            NAME valueOf = NAME.valueOf(this.name_);
            return valueOf == null ? NAME.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
        public int getNameValue() {
            return this.name_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Request> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            long j10 = this.time_;
            int computeInt64Size = j10 != 0 ? 0 + CodedOutputStream.computeInt64Size(1, j10) : 0;
            if (this.name_ != NAME.UNKNOWN.getNumber()) {
                computeInt64Size += CodedOutputStream.computeEnumSize(2, this.name_);
            }
            if (this.common_ != null) {
                computeInt64Size += CodedOutputStream.computeMessageSize(3, getCommon());
            }
            long j11 = this.clientTime_;
            if (j11 != 0) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, j11);
            }
            int serializedSize = computeInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
        public long getTime() {
            return this.time_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getTime())) * 37) + 2) * 53) + this.name_;
            if (hasCommon()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getCommon().hashCode();
            }
            int hashLong = (((((hashCode * 37) + 4) * 53) + Internal.hashLong(getClientTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashLong;
            return hashLong;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DayActiveUserProtos.internal_static_com_irisdt_dau_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
            return new Request();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j10 = this.time_;
            if (j10 != 0) {
                codedOutputStream.writeInt64(1, j10);
            }
            if (this.name_ != NAME.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(2, this.name_);
            }
            if (this.common_ != null) {
                codedOutputStream.writeMessage(3, getCommon());
            }
            long j11 = this.clientTime_;
            if (j11 != 0) {
                codedOutputStream.writeInt64(4, j11);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestOrBuilder {
            private long clientTime_;
            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
            private CommonProtos.Common common_;
            private int name_;
            private long time_;

            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DayActiveUserProtos.internal_static_com_irisdt_dau_Request_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearClientTime() {
                this.clientTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearCommon() {
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                    onChanged();
                } else {
                    this.common_ = null;
                    this.commonBuilder_ = null;
                }
                return this;
            }

            public Builder clearName() {
                this.name_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
            public long getClientTime() {
                return this.clientTime_;
            }

            @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
            public CommonProtos.Common getCommon() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    CommonProtos.Common common = this.common_;
                    return common == null ? CommonProtos.Common.getDefaultInstance() : common;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public CommonProtos.Common.Builder getCommonBuilder() {
                onChanged();
                return getCommonFieldBuilder().getBuilder();
            }

            @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
            public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                CommonProtos.Common common = this.common_;
                return common == null ? CommonProtos.Common.getDefaultInstance() : common;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DayActiveUserProtos.internal_static_com_irisdt_dau_Request_descriptor;
            }

            @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
            public NAME getName() {
                NAME valueOf = NAME.valueOf(this.name_);
                return valueOf == null ? NAME.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
            public int getNameValue() {
                return this.name_;
            }

            @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
            public long getTime() {
                return this.time_;
            }

            @Override // com.irisdt.dau.DayActiveUserProtos.RequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DayActiveUserProtos.internal_static_com_irisdt_dau_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    CommonProtos.Common common2 = this.common_;
                    if (common2 != null) {
                        this.common_ = CommonProtos.Common.newBuilder(common2).mergeFrom(common).buildPartial();
                    } else {
                        this.common_ = common;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(common);
                }
                return this;
            }

            public Builder setClientTime(long j10) {
                this.clientTime_ = j10;
                onChanged();
                return this;
            }

            public Builder setCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(common);
                    this.common_ = common;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(common);
                }
                return this;
            }

            public Builder setName(NAME name) {
                Objects.requireNonNull(name);
                this.name_ = name.getNumber();
                onChanged();
                return this;
            }

            public Builder setNameValue(int i10) {
                this.name_ = i10;
                onChanged();
                return this;
            }

            public Builder setTime(long j10) {
                this.time_ = j10;
                onChanged();
                return this;
            }

            private Builder() {
                this.name_ = 0;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request build() {
                Request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request buildPartial() {
                Request request = new Request(this);
                request.time_ = this.time_;
                request.name_ = this.name_;
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    request.common_ = this.common_;
                } else {
                    request.common_ = singleFieldBuilderV3.build();
                }
                request.clientTime_ = this.clientTime_;
                onBuilt();
                return request;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
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
                this.time_ = 0L;
                this.name_ = 0;
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                } else {
                    this.common_ = null;
                    this.commonBuilder_ = null;
                }
                this.clientTime_ = 0L;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = 0;
                maybeForceBuilderInitialization();
            }

            public Builder setCommon(CommonProtos.Common.Builder builder) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.common_ = builder.build();
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
                if (message instanceof Request) {
                    return mergeFrom((Request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                if (request.getTime() != 0) {
                    setTime(request.getTime());
                }
                if (request.name_ != 0) {
                    setNameValue(request.getNameValue());
                }
                if (request.hasCommon()) {
                    mergeCommon(request.getCommon());
                }
                if (request.getClientTime() != 0) {
                    setClientTime(request.getClientTime());
                }
                mergeUnknownFields(request.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.dau.DayActiveUserProtos.Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.dau.DayActiveUserProtos.Request.access$1100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.dau.DayActiveUserProtos$Request r3 = (com.irisdt.dau.DayActiveUserProtos.Request) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.dau.DayActiveUserProtos$Request r4 = (com.irisdt.dau.DayActiveUserProtos.Request) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.dau.DayActiveUserProtos.Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.dau.DayActiveUserProtos$Request$Builder");
            }
        }

        public static Builder newBuilder(Request request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(request);
        }

        public static Request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private Request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Request() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = 0;
        }

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static Request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 8) {
                                    this.time_ = codedInputStream.readInt64();
                                } else if (readTag == 16) {
                                    this.name_ = codedInputStream.readEnum();
                                } else if (readTag == 26) {
                                    CommonProtos.Common common = this.common_;
                                    CommonProtos.Common.Builder builder = common != null ? common.toBuilder() : null;
                                    CommonProtos.Common common2 = (CommonProtos.Common) codedInputStream.readMessage(CommonProtos.Common.parser(), extensionRegistryLite);
                                    this.common_ = common2;
                                    if (builder != null) {
                                        builder.mergeFrom(common2);
                                        this.common_ = builder.buildPartial();
                                    }
                                } else if (readTag != 32) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.clientTime_ = codedInputStream.readInt64();
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface RequestOrBuilder extends MessageOrBuilder {
        long getClientTime();

        CommonProtos.Common getCommon();

        CommonProtos.CommonOrBuilder getCommonOrBuilder();

        NAME getName();

        int getNameValue();

        long getTime();

        boolean hasCommon();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final Parser<Response> PARSER = new AbstractParser<Response>() { // from class: com.irisdt.dau.DayActiveUserProtos.Response.1
            @Override // com.google.protobuf.Parser
            public Response parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Response(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;

        public static Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DayActiveUserProtos.internal_static_com_irisdt_dau_Response_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Response parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Response parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Response> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Response)) {
                return super.equals(obj);
            }
            Response response = (Response) obj;
            return getCode() == response.getCode() && this.unknownFields.equals(response.unknownFields);
        }

        @Override // com.irisdt.dau.DayActiveUserProtos.ResponseOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Response> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = this.code_;
            int computeInt32Size = (i11 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i11) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = computeInt32Size;
            return computeInt32Size;
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
            int hashCode = ((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DayActiveUserProtos.internal_static_com_irisdt_dau_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
            return new Response();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i10 = this.code_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(1, i10);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResponseOrBuilder {
            private int code_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DayActiveUserProtos.internal_static_com_irisdt_dau_Response_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            @Override // com.irisdt.dau.DayActiveUserProtos.ResponseOrBuilder
            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DayActiveUserProtos.internal_static_com_irisdt_dau_Response_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DayActiveUserProtos.internal_static_com_irisdt_dau_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setCode(int i10) {
                this.code_ = i10;
                onChanged();
                return this;
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response build() {
                Response buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response buildPartial() {
                Response response = new Response(this);
                response.code_ = this.code_;
                onBuilt();
                return response;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Response getDefaultInstanceForType() {
                return Response.getDefaultInstance();
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
                this.code_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Response) {
                    return mergeFrom((Response) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Response response) {
                if (response == Response.getDefaultInstance()) {
                    return this;
                }
                if (response.getCode() != 0) {
                    setCode(response.getCode());
                }
                mergeUnknownFields(response.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.dau.DayActiveUserProtos.Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.dau.DayActiveUserProtos.Response.access$2100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.dau.DayActiveUserProtos$Response r3 = (com.irisdt.dau.DayActiveUserProtos.Response) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.dau.DayActiveUserProtos$Response r4 = (com.irisdt.dau.DayActiveUserProtos.Response) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.dau.DayActiveUserProtos.Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.dau.DayActiveUserProtos$Response$Builder");
            }
        }

        public static Builder newBuilder(Response response) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(response);
        }

        public static Response parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private Response(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Response parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Response getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static Response parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Response() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Response parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static Response parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        private Response(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 8) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.code_ = codedInputStream.readInt32();
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static Response parseFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Response parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Response parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface ResponseOrBuilder extends MessageOrBuilder {
        int getCode();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_irisdt_dau_Request_descriptor = descriptor2;
        internal_static_com_irisdt_dau_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Time", "Name", "Common", "ClientTime"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_irisdt_dau_Response_descriptor = descriptor3;
        internal_static_com_irisdt_dau_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Code"});
        CommonProtos.getDescriptor();
    }

    private DayActiveUserProtos() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
