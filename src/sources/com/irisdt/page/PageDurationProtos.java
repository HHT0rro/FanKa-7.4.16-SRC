package com.irisdt.page;

import com.android.internal.logging.nano.MetricsProto;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.irisdt.CommonProtos;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class PageDurationProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018PageDurationProtos.proto\u0012\u000fcom.irisdt.page\u001a\u0012CommonProtos.proto\"È\u0001\n\u0007Request\u0012\f\n\u0004time\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005takes\u0018\u0002 \u0001(\u0005\u0012\u0013\n\u000bdescription\u0018\u0003 \u0001(\t\u0012\f\n\u0004name\u0018\u0004 \u0001(\t\u0012\"\n\u0006common\u0018\u0005 \u0001(\u000b2\u0012.com.irisdt.Common\u0012\u0011\n\tpage_code\u0018\u0006 \u0001(\t\u0012\f\n\u0004path\u0018\u0007 \u0001(\t\u0012#\n\u0004type\u0018\b \u0001(\u000e2\u0015.com.irisdt.page.Type\u0012\u0013\n\u000bclient_time\u0018\t \u0001(\u0003\"Y\n\bRequests\u0012\"\n\u0006common\u0018\u0001 \u0001(\u000b2\u0012.com.irisdt.Common\u0012)\n\u0007request\u0018\u0002 \u0003(\u000b2\u0018.com.irisdt.page.Request\"\u0018\n\bResponse\u0012\f\n\u0004code\u0018\u0001 \u0001(\u0005*+\n\u0004Type\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\f\n\bDURATION\u0010\u0001\u0012\b\n\u0004PATH\u0010\u00022V\n\rReportService\u0012E\n\u000bBatchReport\u0012\u0019.com.irisdt.page.Requests\u001a\u0019.com.irisdt.page.Response\"\u0000B\u0007¢\u0002\u0004PAGEb\u0006proto3"}, new Descriptors.FileDescriptor[]{CommonProtos.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_irisdt_page_Request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_page_Request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_irisdt_page_Requests_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_page_Requests_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_irisdt_page_Response_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_page_Response_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int CLIENT_TIME_FIELD_NUMBER = 9;
        public static final int COMMON_FIELD_NUMBER = 5;
        public static final int DESCRIPTION_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 4;
        public static final int PAGE_CODE_FIELD_NUMBER = 6;
        public static final int PATH_FIELD_NUMBER = 7;
        public static final int TAKES_FIELD_NUMBER = 2;
        public static final int TIME_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private long clientTime_;
        private CommonProtos.Common common_;
        private volatile Object description_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private volatile Object pageCode_;
        private volatile Object path_;
        private int takes_;
        private long time_;
        private int type_;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.irisdt.page.PageDurationProtos.Request.1
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PageDurationProtos.internal_static_com_irisdt_page_Request_descriptor;
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
            if (getTime() == request.getTime() && getTakes() == request.getTakes() && getDescription().equals(request.getDescription()) && getName().equals(request.getName()) && hasCommon() == request.hasCommon()) {
                return (!hasCommon() || getCommon().equals(request.getCommon())) && getPageCode().equals(request.getPageCode()) && getPath().equals(request.getPath()) && this.type_ == request.type_ && getClientTime() == request.getClientTime() && this.unknownFields.equals(request.unknownFields);
            }
            return false;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public long getClientTime() {
            return this.clientTime_;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public CommonProtos.Common getCommon() {
            CommonProtos.Common common = this.common_;
            return common == null ? CommonProtos.Common.getDefaultInstance() : common;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.description_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public ByteString getDescriptionBytes() {
            Object obj = this.description_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.description_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public String getPageCode() {
            Object obj = this.pageCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.pageCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public ByteString getPageCodeBytes() {
            Object obj = this.pageCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.pageCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Request> getParserForType() {
            return PARSER;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public String getPath() {
            Object obj = this.path_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.path_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public ByteString getPathBytes() {
            Object obj = this.path_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.path_ = copyFromUtf8;
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
            long j10 = this.time_;
            int computeInt64Size = j10 != 0 ? 0 + CodedOutputStream.computeInt64Size(1, j10) : 0;
            int i11 = this.takes_;
            if (i11 != 0) {
                computeInt64Size += CodedOutputStream.computeInt32Size(2, i11);
            }
            if (!getDescriptionBytes().isEmpty()) {
                computeInt64Size += GeneratedMessageV3.computeStringSize(3, this.description_);
            }
            if (!getNameBytes().isEmpty()) {
                computeInt64Size += GeneratedMessageV3.computeStringSize(4, this.name_);
            }
            if (this.common_ != null) {
                computeInt64Size += CodedOutputStream.computeMessageSize(5, getCommon());
            }
            if (!getPageCodeBytes().isEmpty()) {
                computeInt64Size += GeneratedMessageV3.computeStringSize(6, this.pageCode_);
            }
            if (!getPathBytes().isEmpty()) {
                computeInt64Size += GeneratedMessageV3.computeStringSize(7, this.path_);
            }
            if (this.type_ != Type.UNKNOWN.getNumber()) {
                computeInt64Size += CodedOutputStream.computeEnumSize(8, this.type_);
            }
            long j11 = this.clientTime_;
            if (j11 != 0) {
                computeInt64Size += CodedOutputStream.computeInt64Size(9, j11);
            }
            int serializedSize = computeInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public int getTakes() {
            return this.takes_;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public long getTime() {
            return this.time_;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public Type getType() {
            Type valueOf = Type.valueOf(this.type_);
            return valueOf == null ? Type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getTime())) * 37) + 2) * 53) + getTakes()) * 37) + 3) * 53) + getDescription().hashCode()) * 37) + 4) * 53) + getName().hashCode();
            if (hasCommon()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getCommon().hashCode();
            }
            int hashCode2 = (((((((((((((((((hashCode * 37) + 6) * 53) + getPageCode().hashCode()) * 37) + 7) * 53) + getPath().hashCode()) * 37) + 8) * 53) + this.type_) * 37) + 9) * 53) + Internal.hashLong(getClientTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PageDurationProtos.internal_static_com_irisdt_page_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
            int i10 = this.takes_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(2, i10);
            }
            if (!getDescriptionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.description_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.name_);
            }
            if (this.common_ != null) {
                codedOutputStream.writeMessage(5, getCommon());
            }
            if (!getPageCodeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.pageCode_);
            }
            if (!getPathBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.path_);
            }
            if (this.type_ != Type.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(8, this.type_);
            }
            long j11 = this.clientTime_;
            if (j11 != 0) {
                codedOutputStream.writeInt64(9, j11);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestOrBuilder {
            private long clientTime_;
            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
            private CommonProtos.Common common_;
            private Object description_;
            private Object name_;
            private Object pageCode_;
            private Object path_;
            private int takes_;
            private long time_;
            private int type_;

            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PageDurationProtos.internal_static_com_irisdt_page_Request_descriptor;
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

            public Builder clearDescription() {
                this.description_ = Request.getDefaultInstance().getDescription();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = Request.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder clearPageCode() {
                this.pageCode_ = Request.getDefaultInstance().getPageCode();
                onChanged();
                return this;
            }

            public Builder clearPath() {
                this.path_ = Request.getDefaultInstance().getPath();
                onChanged();
                return this;
            }

            public Builder clearTakes() {
                this.takes_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public long getClientTime() {
                return this.clientTime_;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
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

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                CommonProtos.Common common = this.common_;
                return common == null ? CommonProtos.Common.getDefaultInstance() : common;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public String getDescription() {
                Object obj = this.description_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.description_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public ByteString getDescriptionBytes() {
                Object obj = this.description_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.description_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PageDurationProtos.internal_static_com_irisdt_page_Request_descriptor;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.name_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public String getPageCode() {
                Object obj = this.pageCode_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.pageCode_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public ByteString getPageCodeBytes() {
                Object obj = this.pageCode_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.pageCode_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public String getPath() {
                Object obj = this.path_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.path_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public ByteString getPathBytes() {
                Object obj = this.path_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.path_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public int getTakes() {
                return this.takes_;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public long getTime() {
                return this.time_;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public Type getType() {
                Type valueOf = Type.valueOf(this.type_);
                return valueOf == null ? Type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PageDurationProtos.internal_static_com_irisdt_page_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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

            public Builder setDescription(String str) {
                Objects.requireNonNull(str);
                this.description_ = str;
                onChanged();
                return this;
            }

            public Builder setDescriptionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.description_ = byteString;
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

            public Builder setPageCode(String str) {
                Objects.requireNonNull(str);
                this.pageCode_ = str;
                onChanged();
                return this;
            }

            public Builder setPageCodeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.pageCode_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPath(String str) {
                Objects.requireNonNull(str);
                this.path_ = str;
                onChanged();
                return this;
            }

            public Builder setPathBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.path_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTakes(int i10) {
                this.takes_ = i10;
                onChanged();
                return this;
            }

            public Builder setTime(long j10) {
                this.time_ = j10;
                onChanged();
                return this;
            }

            public Builder setType(Type type) {
                Objects.requireNonNull(type);
                this.type_ = type.getNumber();
                onChanged();
                return this;
            }

            public Builder setTypeValue(int i10) {
                this.type_ = i10;
                onChanged();
                return this;
            }

            private Builder() {
                this.description_ = "";
                this.name_ = "";
                this.pageCode_ = "";
                this.path_ = "";
                this.type_ = 0;
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
                request.takes_ = this.takes_;
                request.description_ = this.description_;
                request.name_ = this.name_;
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    request.common_ = this.common_;
                } else {
                    request.common_ = singleFieldBuilderV3.build();
                }
                request.pageCode_ = this.pageCode_;
                request.path_ = this.path_;
                request.type_ = this.type_;
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
                this.takes_ = 0;
                this.description_ = "";
                this.name_ = "";
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                } else {
                    this.common_ = null;
                    this.commonBuilder_ = null;
                }
                this.pageCode_ = "";
                this.path_ = "";
                this.type_ = 0;
                this.clientTime_ = 0L;
                return this;
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

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.description_ = "";
                this.name_ = "";
                this.pageCode_ = "";
                this.path_ = "";
                this.type_ = 0;
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                if (request.getTime() != 0) {
                    setTime(request.getTime());
                }
                if (request.getTakes() != 0) {
                    setTakes(request.getTakes());
                }
                if (!request.getDescription().isEmpty()) {
                    this.description_ = request.description_;
                    onChanged();
                }
                if (!request.getName().isEmpty()) {
                    this.name_ = request.name_;
                    onChanged();
                }
                if (request.hasCommon()) {
                    mergeCommon(request.getCommon());
                }
                if (!request.getPageCode().isEmpty()) {
                    this.pageCode_ = request.pageCode_;
                    onChanged();
                }
                if (!request.getPath().isEmpty()) {
                    this.path_ = request.path_;
                    onChanged();
                }
                if (request.type_ != 0) {
                    setTypeValue(request.getTypeValue());
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
            public com.irisdt.page.PageDurationProtos.Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.page.PageDurationProtos.Request.access$1600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.page.PageDurationProtos$Request r3 = (com.irisdt.page.PageDurationProtos.Request) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.page.PageDurationProtos$Request r4 = (com.irisdt.page.PageDurationProtos.Request) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.page.PageDurationProtos.Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.page.PageDurationProtos$Request$Builder");
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
            this.description_ = "";
            this.name_ = "";
            this.pageCode_ = "";
            this.path_ = "";
            this.type_ = 0;
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

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        private Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.time_ = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.takes_ = codedInputStream.readInt32();
                            } else if (readTag == 26) {
                                this.description_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                CommonProtos.Common common = this.common_;
                                CommonProtos.Common.Builder builder = common != null ? common.toBuilder() : null;
                                CommonProtos.Common common2 = (CommonProtos.Common) codedInputStream.readMessage(CommonProtos.Common.parser(), extensionRegistryLite);
                                this.common_ = common2;
                                if (builder != null) {
                                    builder.mergeFrom(common2);
                                    this.common_ = builder.buildPartial();
                                }
                            } else if (readTag == 50) {
                                this.pageCode_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 58) {
                                this.path_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 64) {
                                this.type_ = codedInputStream.readEnum();
                            } else if (readTag != 72) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.clientTime_ = codedInputStream.readInt64();
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

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface RequestOrBuilder extends MessageOrBuilder {
        long getClientTime();

        CommonProtos.Common getCommon();

        CommonProtos.CommonOrBuilder getCommonOrBuilder();

        String getDescription();

        ByteString getDescriptionBytes();

        String getName();

        ByteString getNameBytes();

        String getPageCode();

        ByteString getPageCodeBytes();

        String getPath();

        ByteString getPathBytes();

        int getTakes();

        long getTime();

        Type getType();

        int getTypeValue();

        boolean hasCommon();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Requests extends GeneratedMessageV3 implements RequestsOrBuilder {
        public static final int COMMON_FIELD_NUMBER = 1;
        private static final Requests DEFAULT_INSTANCE = new Requests();
        private static final Parser<Requests> PARSER = new AbstractParser<Requests>() { // from class: com.irisdt.page.PageDurationProtos.Requests.1
            @Override // com.google.protobuf.Parser
            public Requests parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Requests(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REQUEST_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private CommonProtos.Common common_;
        private byte memoizedIsInitialized;
        private List<Request> request_;

        public static Requests getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PageDurationProtos.internal_static_com_irisdt_page_Requests_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Requests parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Requests) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Requests parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Requests> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Requests)) {
                return super.equals(obj);
            }
            Requests requests = (Requests) obj;
            if (hasCommon() != requests.hasCommon()) {
                return false;
            }
            return (!hasCommon() || getCommon().equals(requests.getCommon())) && getRequestList().equals(requests.getRequestList()) && this.unknownFields.equals(requests.unknownFields);
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
        public CommonProtos.Common getCommon() {
            CommonProtos.Common common = this.common_;
            return common == null ? CommonProtos.Common.getDefaultInstance() : common;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
        public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Requests> getParserForType() {
            return PARSER;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
        public Request getRequest(int i10) {
            return this.request_.get(i10);
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
        public int getRequestCount() {
            return this.request_.size();
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
        public List<Request> getRequestList() {
            return this.request_;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
        public RequestOrBuilder getRequestOrBuilder(int i10) {
            return this.request_.get(i10);
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
        public List<? extends RequestOrBuilder> getRequestOrBuilderList() {
            return this.request_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeMessageSize = this.common_ != null ? CodedOutputStream.computeMessageSize(1, getCommon()) + 0 : 0;
            for (int i11 = 0; i11 < this.request_.size(); i11++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.request_.get(i11));
            }
            int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode();
            if (hasCommon()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getCommon().hashCode();
            }
            if (getRequestCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getRequestList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PageDurationProtos.internal_static_com_irisdt_page_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(Requests.class, Builder.class);
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
            return new Requests();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.common_ != null) {
                codedOutputStream.writeMessage(1, getCommon());
            }
            for (int i10 = 0; i10 < this.request_.size(); i10++) {
                codedOutputStream.writeMessage(2, this.request_.get(i10));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestsOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
            private CommonProtos.Common common_;
            private RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> requestBuilder_;
            private List<Request> request_;

            private void ensureRequestIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.request_ = new ArrayList(this.request_);
                    this.bitField0_ |= 1;
                }
            }

            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PageDurationProtos.internal_static_com_irisdt_page_Requests_descriptor;
            }

            private RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> getRequestFieldBuilder() {
                if (this.requestBuilder_ == null) {
                    this.requestBuilder_ = new RepeatedFieldBuilderV3<>(this.request_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.request_ = null;
                }
                return this.requestBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getRequestFieldBuilder();
                }
            }

            public Builder addAllRequest(Iterable<? extends Request> iterable) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRequestIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.request_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder addRequest(Request request) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    Objects.requireNonNull(request);
                    ensureRequestIsMutable();
                    this.request_.add(request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(request);
                }
                return this;
            }

            public Request.Builder addRequestBuilder() {
                return getRequestFieldBuilder().addBuilder(Request.getDefaultInstance());
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

            public Builder clearRequest() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.request_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
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

            @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
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
                return PageDurationProtos.internal_static_com_irisdt_page_Requests_descriptor;
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
            public Request getRequest(int i10) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.request_.get(i10);
                }
                return repeatedFieldBuilderV3.getMessage(i10);
            }

            public Request.Builder getRequestBuilder(int i10) {
                return getRequestFieldBuilder().getBuilder(i10);
            }

            public List<Request.Builder> getRequestBuilderList() {
                return getRequestFieldBuilder().getBuilderList();
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
            public int getRequestCount() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.request_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
            public List<Request> getRequestList() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.request_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
            public RequestOrBuilder getRequestOrBuilder(int i10) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.request_.get(i10);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
            public List<? extends RequestOrBuilder> getRequestOrBuilderList() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.request_);
            }

            @Override // com.irisdt.page.PageDurationProtos.RequestsOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PageDurationProtos.internal_static_com_irisdt_page_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(Requests.class, Builder.class);
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

            public Builder removeRequest(int i10) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRequestIsMutable();
                    this.request_.remove(i10);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i10);
                }
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

            public Builder setRequest(int i10, Request request) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    Objects.requireNonNull(request);
                    ensureRequestIsMutable();
                    this.request_.set(i10, request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i10, request);
                }
                return this;
            }

            private Builder() {
                this.request_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Requests build() {
                Requests buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Requests buildPartial() {
                Requests requests = new Requests(this);
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    requests.common_ = this.common_;
                } else {
                    requests.common_ = singleFieldBuilderV3.build();
                }
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.request_ = Collections.unmodifiableList(this.request_);
                        this.bitField0_ &= -2;
                    }
                    requests.request_ = this.request_;
                } else {
                    requests.request_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return requests;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Requests getDefaultInstanceForType() {
                return Requests.getDefaultInstance();
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

            public Request.Builder addRequestBuilder(int i10) {
                return getRequestFieldBuilder().addBuilder(i10, Request.getDefaultInstance());
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
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                } else {
                    this.common_ = null;
                    this.commonBuilder_ = null;
                }
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.request_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.request_ = Collections.emptyList();
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

            public Builder addRequest(int i10, Request request) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    Objects.requireNonNull(request);
                    ensureRequestIsMutable();
                    this.request_.add(i10, request);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i10, request);
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
                if (message instanceof Requests) {
                    return mergeFrom((Requests) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder setRequest(int i10, Request.Builder builder) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRequestIsMutable();
                    this.request_.set(i10, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(Requests requests) {
                if (requests == Requests.getDefaultInstance()) {
                    return this;
                }
                if (requests.hasCommon()) {
                    mergeCommon(requests.getCommon());
                }
                if (this.requestBuilder_ == null) {
                    if (!requests.request_.isEmpty()) {
                        if (this.request_.isEmpty()) {
                            this.request_ = requests.request_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRequestIsMutable();
                            this.request_.addAll(requests.request_);
                        }
                        onChanged();
                    }
                } else if (!requests.request_.isEmpty()) {
                    if (this.requestBuilder_.isEmpty()) {
                        this.requestBuilder_.dispose();
                        this.requestBuilder_ = null;
                        this.request_ = requests.request_;
                        this.bitField0_ &= -2;
                        this.requestBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getRequestFieldBuilder() : null;
                    } else {
                        this.requestBuilder_.addAllMessages(requests.request_);
                    }
                }
                mergeUnknownFields(requests.unknownFields);
                onChanged();
                return this;
            }

            public Builder addRequest(Request.Builder builder) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRequestIsMutable();
                    this.request_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addRequest(int i10, Request.Builder builder) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRequestIsMutable();
                    this.request_.add(i10, builder.build());
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
            public com.irisdt.page.PageDurationProtos.Requests.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.page.PageDurationProtos.Requests.access$3200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.page.PageDurationProtos$Requests r3 = (com.irisdt.page.PageDurationProtos.Requests) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.page.PageDurationProtos$Requests r4 = (com.irisdt.page.PageDurationProtos.Requests) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.page.PageDurationProtos.Requests.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.page.PageDurationProtos$Requests$Builder");
            }
        }

        public static Builder newBuilder(Requests requests) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(requests);
        }

        public static Requests parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private Requests(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Requests parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Requests) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Requests parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Requests getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static Requests parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Requests() {
            this.memoizedIsInitialized = (byte) -1;
            this.request_ = Collections.emptyList();
        }

        public static Requests parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static Requests parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Requests parseFrom(InputStream inputStream) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Requests(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    CommonProtos.Common common = this.common_;
                                    CommonProtos.Common.Builder builder = common != null ? common.toBuilder() : null;
                                    CommonProtos.Common common2 = (CommonProtos.Common) codedInputStream.readMessage(CommonProtos.Common.parser(), extensionRegistryLite);
                                    this.common_ = common2;
                                    if (builder != null) {
                                        builder.mergeFrom(common2);
                                        this.common_ = builder.buildPartial();
                                    }
                                } else if (readTag != 18) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    if (!(z11 & true)) {
                                        this.request_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.request_.add(codedInputStream.readMessage(Request.parser(), extensionRegistryLite));
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
                    if (z11 & true) {
                        this.request_ = Collections.unmodifiableList(this.request_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static Requests parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Requests parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Requests parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface RequestsOrBuilder extends MessageOrBuilder {
        CommonProtos.Common getCommon();

        CommonProtos.CommonOrBuilder getCommonOrBuilder();

        Request getRequest(int i10);

        int getRequestCount();

        List<Request> getRequestList();

        RequestOrBuilder getRequestOrBuilder(int i10);

        List<? extends RequestOrBuilder> getRequestOrBuilderList();

        boolean hasCommon();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final Parser<Response> PARSER = new AbstractParser<Response>() { // from class: com.irisdt.page.PageDurationProtos.Response.1
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
            return PageDurationProtos.internal_static_com_irisdt_page_Response_descriptor;
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

        @Override // com.irisdt.page.PageDurationProtos.ResponseOrBuilder
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
            return PageDurationProtos.internal_static_com_irisdt_page_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
                return PageDurationProtos.internal_static_com_irisdt_page_Response_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            @Override // com.irisdt.page.PageDurationProtos.ResponseOrBuilder
            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PageDurationProtos.internal_static_com_irisdt_page_Response_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PageDurationProtos.internal_static_com_irisdt_page_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
            public com.irisdt.page.PageDurationProtos.Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.page.PageDurationProtos.Response.access$4200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.page.PageDurationProtos$Response r3 = (com.irisdt.page.PageDurationProtos.Response) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.page.PageDurationProtos$Response r4 = (com.irisdt.page.PageDurationProtos.Response) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.page.PageDurationProtos.Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.page.PageDurationProtos$Response$Builder");
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

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Type implements ProtocolMessageEnum {
        UNKNOWN(0),
        DURATION(1),
        PATH(2),
        UNRECOGNIZED(-1);

        public static final int DURATION_VALUE = 1;
        public static final int PATH_VALUE = 2;
        public static final int UNKNOWN_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.irisdt.page.PageDurationProtos.Type.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Type findValueByNumber(int i10) {
                return Type.forNumber(i10);
            }
        };
        private static final Type[] VALUES = values();

        Type(int i10) {
            this.value = i10;
        }

        public static Type forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN;
            }
            if (i10 == 1) {
                return DURATION;
            }
            if (i10 != 2) {
                return null;
            }
            return PATH;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PageDurationProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Type> internalGetValueMap() {
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
        public static Type valueOf(int i10) {
            return forNumber(i10);
        }

        public static Type valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_irisdt_page_Request_descriptor = descriptor2;
        internal_static_com_irisdt_page_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Time", "Takes", "Description", "Name", "Common", "PageCode", "Path", "Type", "ClientTime"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_irisdt_page_Requests_descriptor = descriptor3;
        internal_static_com_irisdt_page_Requests_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Common", "Request"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_irisdt_page_Response_descriptor = descriptor4;
        internal_static_com_irisdt_page_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Code"});
        CommonProtos.getDescriptor();
    }

    private PageDurationProtos() {
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
