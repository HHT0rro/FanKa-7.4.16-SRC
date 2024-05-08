package com.irisdt.client;

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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class CommonExtraProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017CommonExtraProtos.proto\u0012\u0011com.irisdt.client\"\u0095\u0002\n\u0010CommonExtraProto\u0012\u000e\n\u0006is_vip\u0018\u0001 \u0001(\b\u0012\u0012\n\nis_visitor\u0018\u0002 \u0001(\b\u0012-\n\bvip_type\u0018\u0003 \u0001(\u000e2\u001b.com.irisdt.client.VIP_TYPE\u0012\u000f\n\u0007is_fake\u0018\u0004 \u0001(\b\u0012\u0016\n\u000esuper_like_cnt\u0018\u0005 \u0001(\u0005\u0012\u000f\n\u0007vip_cnt\u0018\u0006 \u0001(\u0005\u0012\u0010\n\bsvip_cnt\u0018\u0007 \u0001(\u0005\u0012\u0013\n\u000bvisitor_cnt\u0018\b \u0001(\u0005\u0012\u0011\n\tssvip_cnt\u0018\t \u0001(\u0005\u0012\f\n\u0004oaid\u0018\n \u0001(\t\u0012\f\n\u0004imei\u0018\u000b \u0001(\t\u0012\n\n\u0002ua\u0018\f \u0001(\t\u0012\u0012\n\nandroid_id\u0018\r \u0001(\t*J\n\bVIP_TYPE\u0012\u0014\n\u0010UNKNOWN_VIP_TYPE\u0010\u0000\u0012\n\n\u0006NORMAL\u0010\u0001\u0012\u0007\n\u0003VIP\u0010\u0002\u0012\b\n\u0004SVIP\u0010\u0003\u0012\t\n\u0005SSVIP\u0010\u0004B\u000f¢\u0002\fCOMMON_EXTRAb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_CommonExtraProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_CommonExtraProto_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class CommonExtraProto extends GeneratedMessageV3 implements CommonExtraProtoOrBuilder {
        public static final int ANDROID_ID_FIELD_NUMBER = 13;
        public static final int IMEI_FIELD_NUMBER = 11;
        public static final int IS_FAKE_FIELD_NUMBER = 4;
        public static final int IS_VIP_FIELD_NUMBER = 1;
        public static final int IS_VISITOR_FIELD_NUMBER = 2;
        public static final int OAID_FIELD_NUMBER = 10;
        public static final int SSVIP_CNT_FIELD_NUMBER = 9;
        public static final int SUPER_LIKE_CNT_FIELD_NUMBER = 5;
        public static final int SVIP_CNT_FIELD_NUMBER = 7;
        public static final int UA_FIELD_NUMBER = 12;
        public static final int VIP_CNT_FIELD_NUMBER = 6;
        public static final int VIP_TYPE_FIELD_NUMBER = 3;
        public static final int VISITOR_CNT_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private volatile Object androidId_;
        private volatile Object imei_;
        private boolean isFake_;
        private boolean isVip_;
        private boolean isVisitor_;
        private byte memoizedIsInitialized;
        private volatile Object oaid_;
        private int ssvipCnt_;
        private int superLikeCnt_;
        private int svipCnt_;
        private volatile Object ua_;
        private int vipCnt_;
        private int vipType_;
        private int visitorCnt_;
        private static final CommonExtraProto DEFAULT_INSTANCE = new CommonExtraProto();
        private static final Parser<CommonExtraProto> PARSER = new AbstractParser<CommonExtraProto>() { // from class: com.irisdt.client.CommonExtraProtos.CommonExtraProto.1
            @Override // com.google.protobuf.Parser
            public CommonExtraProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CommonExtraProto(codedInputStream, extensionRegistryLite);
            }
        };

        private CommonExtraProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static CommonExtraProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CommonExtraProtos.internal_static_com_irisdt_client_CommonExtraProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CommonExtraProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CommonExtraProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<CommonExtraProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CommonExtraProto)) {
                return super.equals(obj);
            }
            CommonExtraProto commonExtraProto = (CommonExtraProto) obj;
            return getIsVip() == commonExtraProto.getIsVip() && getIsVisitor() == commonExtraProto.getIsVisitor() && this.vipType_ == commonExtraProto.vipType_ && getIsFake() == commonExtraProto.getIsFake() && getSuperLikeCnt() == commonExtraProto.getSuperLikeCnt() && getVipCnt() == commonExtraProto.getVipCnt() && getSvipCnt() == commonExtraProto.getSvipCnt() && getVisitorCnt() == commonExtraProto.getVisitorCnt() && getSsvipCnt() == commonExtraProto.getSsvipCnt() && getOaid().equals(commonExtraProto.getOaid()) && getImei().equals(commonExtraProto.getImei()) && getUa().equals(commonExtraProto.getUa()) && getAndroidId().equals(commonExtraProto.getAndroidId()) && this.unknownFields.equals(commonExtraProto.unknownFields);
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public String getAndroidId() {
            Object obj = this.androidId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.androidId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public ByteString getAndroidIdBytes() {
            Object obj = this.androidId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.androidId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public String getImei() {
            Object obj = this.imei_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imei_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public ByteString getImeiBytes() {
            Object obj = this.imei_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imei_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public boolean getIsFake() {
            return this.isFake_;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public boolean getIsVip() {
            return this.isVip_;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public boolean getIsVisitor() {
            return this.isVisitor_;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public String getOaid() {
            Object obj = this.oaid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.oaid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public ByteString getOaidBytes() {
            Object obj = this.oaid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.oaid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CommonExtraProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            boolean z10 = this.isVip_;
            int computeBoolSize = z10 ? 0 + CodedOutputStream.computeBoolSize(1, z10) : 0;
            boolean z11 = this.isVisitor_;
            if (z11) {
                computeBoolSize += CodedOutputStream.computeBoolSize(2, z11);
            }
            if (this.vipType_ != VIP_TYPE.UNKNOWN_VIP_TYPE.getNumber()) {
                computeBoolSize += CodedOutputStream.computeEnumSize(3, this.vipType_);
            }
            boolean z12 = this.isFake_;
            if (z12) {
                computeBoolSize += CodedOutputStream.computeBoolSize(4, z12);
            }
            int i11 = this.superLikeCnt_;
            if (i11 != 0) {
                computeBoolSize += CodedOutputStream.computeInt32Size(5, i11);
            }
            int i12 = this.vipCnt_;
            if (i12 != 0) {
                computeBoolSize += CodedOutputStream.computeInt32Size(6, i12);
            }
            int i13 = this.svipCnt_;
            if (i13 != 0) {
                computeBoolSize += CodedOutputStream.computeInt32Size(7, i13);
            }
            int i14 = this.visitorCnt_;
            if (i14 != 0) {
                computeBoolSize += CodedOutputStream.computeInt32Size(8, i14);
            }
            int i15 = this.ssvipCnt_;
            if (i15 != 0) {
                computeBoolSize += CodedOutputStream.computeInt32Size(9, i15);
            }
            if (!getOaidBytes().isEmpty()) {
                computeBoolSize += GeneratedMessageV3.computeStringSize(10, this.oaid_);
            }
            if (!getImeiBytes().isEmpty()) {
                computeBoolSize += GeneratedMessageV3.computeStringSize(11, this.imei_);
            }
            if (!getUaBytes().isEmpty()) {
                computeBoolSize += GeneratedMessageV3.computeStringSize(12, this.ua_);
            }
            if (!getAndroidIdBytes().isEmpty()) {
                computeBoolSize += GeneratedMessageV3.computeStringSize(13, this.androidId_);
            }
            int serializedSize = computeBoolSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public int getSsvipCnt() {
            return this.ssvipCnt_;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public int getSuperLikeCnt() {
            return this.superLikeCnt_;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public int getSvipCnt() {
            return this.svipCnt_;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public String getUa() {
            Object obj = this.ua_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.ua_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public ByteString getUaBytes() {
            Object obj = this.ua_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ua_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public int getVipCnt() {
            return this.vipCnt_;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public VIP_TYPE getVipType() {
            VIP_TYPE valueOf = VIP_TYPE.valueOf(this.vipType_);
            return valueOf == null ? VIP_TYPE.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public int getVipTypeValue() {
            return this.vipType_;
        }

        @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public int getVisitorCnt() {
            return this.visitorCnt_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashBoolean(getIsVip())) * 37) + 2) * 53) + Internal.hashBoolean(getIsVisitor())) * 37) + 3) * 53) + this.vipType_) * 37) + 4) * 53) + Internal.hashBoolean(getIsFake())) * 37) + 5) * 53) + getSuperLikeCnt()) * 37) + 6) * 53) + getVipCnt()) * 37) + 7) * 53) + getSvipCnt()) * 37) + 8) * 53) + getVisitorCnt()) * 37) + 9) * 53) + getSsvipCnt()) * 37) + 10) * 53) + getOaid().hashCode()) * 37) + 11) * 53) + getImei().hashCode()) * 37) + 12) * 53) + getUa().hashCode()) * 37) + 13) * 53) + getAndroidId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CommonExtraProtos.internal_static_com_irisdt_client_CommonExtraProto_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonExtraProto.class, Builder.class);
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
            return new CommonExtraProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            boolean z10 = this.isVip_;
            if (z10) {
                codedOutputStream.writeBool(1, z10);
            }
            boolean z11 = this.isVisitor_;
            if (z11) {
                codedOutputStream.writeBool(2, z11);
            }
            if (this.vipType_ != VIP_TYPE.UNKNOWN_VIP_TYPE.getNumber()) {
                codedOutputStream.writeEnum(3, this.vipType_);
            }
            boolean z12 = this.isFake_;
            if (z12) {
                codedOutputStream.writeBool(4, z12);
            }
            int i10 = this.superLikeCnt_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(5, i10);
            }
            int i11 = this.vipCnt_;
            if (i11 != 0) {
                codedOutputStream.writeInt32(6, i11);
            }
            int i12 = this.svipCnt_;
            if (i12 != 0) {
                codedOutputStream.writeInt32(7, i12);
            }
            int i13 = this.visitorCnt_;
            if (i13 != 0) {
                codedOutputStream.writeInt32(8, i13);
            }
            int i14 = this.ssvipCnt_;
            if (i14 != 0) {
                codedOutputStream.writeInt32(9, i14);
            }
            if (!getOaidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.oaid_);
            }
            if (!getImeiBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.imei_);
            }
            if (!getUaBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.ua_);
            }
            if (!getAndroidIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.androidId_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommonExtraProtoOrBuilder {
            private Object androidId_;
            private Object imei_;
            private boolean isFake_;
            private boolean isVip_;
            private boolean isVisitor_;
            private Object oaid_;
            private int ssvipCnt_;
            private int superLikeCnt_;
            private int svipCnt_;
            private Object ua_;
            private int vipCnt_;
            private int vipType_;
            private int visitorCnt_;

            private Builder() {
                this.vipType_ = 0;
                this.oaid_ = "";
                this.imei_ = "";
                this.ua_ = "";
                this.androidId_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CommonExtraProtos.internal_static_com_irisdt_client_CommonExtraProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAndroidId() {
                this.androidId_ = CommonExtraProto.getDefaultInstance().getAndroidId();
                onChanged();
                return this;
            }

            public Builder clearImei() {
                this.imei_ = CommonExtraProto.getDefaultInstance().getImei();
                onChanged();
                return this;
            }

            public Builder clearIsFake() {
                this.isFake_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsVip() {
                this.isVip_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsVisitor() {
                this.isVisitor_ = false;
                onChanged();
                return this;
            }

            public Builder clearOaid() {
                this.oaid_ = CommonExtraProto.getDefaultInstance().getOaid();
                onChanged();
                return this;
            }

            public Builder clearSsvipCnt() {
                this.ssvipCnt_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSuperLikeCnt() {
                this.superLikeCnt_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSvipCnt() {
                this.svipCnt_ = 0;
                onChanged();
                return this;
            }

            public Builder clearUa() {
                this.ua_ = CommonExtraProto.getDefaultInstance().getUa();
                onChanged();
                return this;
            }

            public Builder clearVipCnt() {
                this.vipCnt_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVipType() {
                this.vipType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVisitorCnt() {
                this.visitorCnt_ = 0;
                onChanged();
                return this;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public String getAndroidId() {
                Object obj = this.androidId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.androidId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public ByteString getAndroidIdBytes() {
                Object obj = this.androidId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.androidId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CommonExtraProtos.internal_static_com_irisdt_client_CommonExtraProto_descriptor;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public String getImei() {
                Object obj = this.imei_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.imei_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public ByteString getImeiBytes() {
                Object obj = this.imei_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.imei_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public boolean getIsFake() {
                return this.isFake_;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public boolean getIsVip() {
                return this.isVip_;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public boolean getIsVisitor() {
                return this.isVisitor_;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public String getOaid() {
                Object obj = this.oaid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.oaid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public ByteString getOaidBytes() {
                Object obj = this.oaid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.oaid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public int getSsvipCnt() {
                return this.ssvipCnt_;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public int getSuperLikeCnt() {
                return this.superLikeCnt_;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public int getSvipCnt() {
                return this.svipCnt_;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public String getUa() {
                Object obj = this.ua_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ua_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public ByteString getUaBytes() {
                Object obj = this.ua_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ua_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public int getVipCnt() {
                return this.vipCnt_;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public VIP_TYPE getVipType() {
                VIP_TYPE valueOf = VIP_TYPE.valueOf(this.vipType_);
                return valueOf == null ? VIP_TYPE.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public int getVipTypeValue() {
                return this.vipType_;
            }

            @Override // com.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public int getVisitorCnt() {
                return this.visitorCnt_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CommonExtraProtos.internal_static_com_irisdt_client_CommonExtraProto_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonExtraProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAndroidId(String str) {
                Objects.requireNonNull(str);
                this.androidId_ = str;
                onChanged();
                return this;
            }

            public Builder setAndroidIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.androidId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setImei(String str) {
                Objects.requireNonNull(str);
                this.imei_ = str;
                onChanged();
                return this;
            }

            public Builder setImeiBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.imei_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIsFake(boolean z10) {
                this.isFake_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsVip(boolean z10) {
                this.isVip_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsVisitor(boolean z10) {
                this.isVisitor_ = z10;
                onChanged();
                return this;
            }

            public Builder setOaid(String str) {
                Objects.requireNonNull(str);
                this.oaid_ = str;
                onChanged();
                return this;
            }

            public Builder setOaidBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.oaid_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSsvipCnt(int i10) {
                this.ssvipCnt_ = i10;
                onChanged();
                return this;
            }

            public Builder setSuperLikeCnt(int i10) {
                this.superLikeCnt_ = i10;
                onChanged();
                return this;
            }

            public Builder setSvipCnt(int i10) {
                this.svipCnt_ = i10;
                onChanged();
                return this;
            }

            public Builder setUa(String str) {
                Objects.requireNonNull(str);
                this.ua_ = str;
                onChanged();
                return this;
            }

            public Builder setUaBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.ua_ = byteString;
                onChanged();
                return this;
            }

            public Builder setVipCnt(int i10) {
                this.vipCnt_ = i10;
                onChanged();
                return this;
            }

            public Builder setVipType(VIP_TYPE vip_type) {
                Objects.requireNonNull(vip_type);
                this.vipType_ = vip_type.getNumber();
                onChanged();
                return this;
            }

            public Builder setVipTypeValue(int i10) {
                this.vipType_ = i10;
                onChanged();
                return this;
            }

            public Builder setVisitorCnt(int i10) {
                this.visitorCnt_ = i10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CommonExtraProto build() {
                CommonExtraProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CommonExtraProto buildPartial() {
                CommonExtraProto commonExtraProto = new CommonExtraProto(this);
                commonExtraProto.isVip_ = this.isVip_;
                commonExtraProto.isVisitor_ = this.isVisitor_;
                commonExtraProto.vipType_ = this.vipType_;
                commonExtraProto.isFake_ = this.isFake_;
                commonExtraProto.superLikeCnt_ = this.superLikeCnt_;
                commonExtraProto.vipCnt_ = this.vipCnt_;
                commonExtraProto.svipCnt_ = this.svipCnt_;
                commonExtraProto.visitorCnt_ = this.visitorCnt_;
                commonExtraProto.ssvipCnt_ = this.ssvipCnt_;
                commonExtraProto.oaid_ = this.oaid_;
                commonExtraProto.imei_ = this.imei_;
                commonExtraProto.ua_ = this.ua_;
                commonExtraProto.androidId_ = this.androidId_;
                onBuilt();
                return commonExtraProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CommonExtraProto getDefaultInstanceForType() {
                return CommonExtraProto.getDefaultInstance();
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
                this.isVip_ = false;
                this.isVisitor_ = false;
                this.vipType_ = 0;
                this.isFake_ = false;
                this.superLikeCnt_ = 0;
                this.vipCnt_ = 0;
                this.svipCnt_ = 0;
                this.visitorCnt_ = 0;
                this.ssvipCnt_ = 0;
                this.oaid_ = "";
                this.imei_ = "";
                this.ua_ = "";
                this.androidId_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof CommonExtraProto) {
                    return mergeFrom((CommonExtraProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.vipType_ = 0;
                this.oaid_ = "";
                this.imei_ = "";
                this.ua_ = "";
                this.androidId_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(CommonExtraProto commonExtraProto) {
                if (commonExtraProto == CommonExtraProto.getDefaultInstance()) {
                    return this;
                }
                if (commonExtraProto.getIsVip()) {
                    setIsVip(commonExtraProto.getIsVip());
                }
                if (commonExtraProto.getIsVisitor()) {
                    setIsVisitor(commonExtraProto.getIsVisitor());
                }
                if (commonExtraProto.vipType_ != 0) {
                    setVipTypeValue(commonExtraProto.getVipTypeValue());
                }
                if (commonExtraProto.getIsFake()) {
                    setIsFake(commonExtraProto.getIsFake());
                }
                if (commonExtraProto.getSuperLikeCnt() != 0) {
                    setSuperLikeCnt(commonExtraProto.getSuperLikeCnt());
                }
                if (commonExtraProto.getVipCnt() != 0) {
                    setVipCnt(commonExtraProto.getVipCnt());
                }
                if (commonExtraProto.getSvipCnt() != 0) {
                    setSvipCnt(commonExtraProto.getSvipCnt());
                }
                if (commonExtraProto.getVisitorCnt() != 0) {
                    setVisitorCnt(commonExtraProto.getVisitorCnt());
                }
                if (commonExtraProto.getSsvipCnt() != 0) {
                    setSsvipCnt(commonExtraProto.getSsvipCnt());
                }
                if (!commonExtraProto.getOaid().isEmpty()) {
                    this.oaid_ = commonExtraProto.oaid_;
                    onChanged();
                }
                if (!commonExtraProto.getImei().isEmpty()) {
                    this.imei_ = commonExtraProto.imei_;
                    onChanged();
                }
                if (!commonExtraProto.getUa().isEmpty()) {
                    this.ua_ = commonExtraProto.ua_;
                    onChanged();
                }
                if (!commonExtraProto.getAndroidId().isEmpty()) {
                    this.androidId_ = commonExtraProto.androidId_;
                    onChanged();
                }
                mergeUnknownFields(commonExtraProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.client.CommonExtraProtos.CommonExtraProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.client.CommonExtraProtos.CommonExtraProto.t()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.client.CommonExtraProtos$CommonExtraProto r3 = (com.irisdt.client.CommonExtraProtos.CommonExtraProto) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.client.CommonExtraProtos$CommonExtraProto r4 = (com.irisdt.client.CommonExtraProtos.CommonExtraProto) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.client.CommonExtraProtos.CommonExtraProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.client.CommonExtraProtos$CommonExtraProto$Builder");
            }
        }

        public static Builder newBuilder(CommonExtraProto commonExtraProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(commonExtraProto);
        }

        public static CommonExtraProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private CommonExtraProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.vipType_ = 0;
            this.oaid_ = "";
            this.imei_ = "";
            this.ua_ = "";
            this.androidId_ = "";
        }

        public static CommonExtraProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CommonExtraProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CommonExtraProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static CommonExtraProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static CommonExtraProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static CommonExtraProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CommonExtraProto parseFrom(InputStream inputStream) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CommonExtraProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
        private CommonExtraProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z10 = true;
                            case 8:
                                this.isVip_ = codedInputStream.readBool();
                            case 16:
                                this.isVisitor_ = codedInputStream.readBool();
                            case 24:
                                this.vipType_ = codedInputStream.readEnum();
                            case 32:
                                this.isFake_ = codedInputStream.readBool();
                            case 40:
                                this.superLikeCnt_ = codedInputStream.readInt32();
                            case 48:
                                this.vipCnt_ = codedInputStream.readInt32();
                            case 56:
                                this.svipCnt_ = codedInputStream.readInt32();
                            case 64:
                                this.visitorCnt_ = codedInputStream.readInt32();
                            case 72:
                                this.ssvipCnt_ = codedInputStream.readInt32();
                            case 82:
                                this.oaid_ = codedInputStream.readStringRequireUtf8();
                            case 90:
                                this.imei_ = codedInputStream.readStringRequireUtf8();
                            case 98:
                                this.ua_ = codedInputStream.readStringRequireUtf8();
                            case 106:
                                this.androidId_ = codedInputStream.readStringRequireUtf8();
                            default:
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    z10 = true;
                                }
                        }
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

        public static CommonExtraProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CommonExtraProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface CommonExtraProtoOrBuilder extends MessageOrBuilder {
        String getAndroidId();

        ByteString getAndroidIdBytes();

        String getImei();

        ByteString getImeiBytes();

        boolean getIsFake();

        boolean getIsVip();

        boolean getIsVisitor();

        String getOaid();

        ByteString getOaidBytes();

        int getSsvipCnt();

        int getSuperLikeCnt();

        int getSvipCnt();

        String getUa();

        ByteString getUaBytes();

        int getVipCnt();

        VIP_TYPE getVipType();

        int getVipTypeValue();

        int getVisitorCnt();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum VIP_TYPE implements ProtocolMessageEnum {
        UNKNOWN_VIP_TYPE(0),
        NORMAL(1),
        VIP(2),
        SVIP(3),
        SSVIP(4),
        UNRECOGNIZED(-1);

        public static final int NORMAL_VALUE = 1;
        public static final int SSVIP_VALUE = 4;
        public static final int SVIP_VALUE = 3;
        public static final int UNKNOWN_VIP_TYPE_VALUE = 0;
        public static final int VIP_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<VIP_TYPE> internalValueMap = new Internal.EnumLiteMap<VIP_TYPE>() { // from class: com.irisdt.client.CommonExtraProtos.VIP_TYPE.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public VIP_TYPE findValueByNumber(int i10) {
                return VIP_TYPE.forNumber(i10);
            }
        };
        private static final VIP_TYPE[] VALUES = values();

        VIP_TYPE(int i10) {
            this.value = i10;
        }

        public static VIP_TYPE forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_VIP_TYPE;
            }
            if (i10 == 1) {
                return NORMAL;
            }
            if (i10 == 2) {
                return VIP;
            }
            if (i10 == 3) {
                return SVIP;
            }
            if (i10 != 4) {
                return null;
            }
            return SSVIP;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return CommonExtraProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<VIP_TYPE> internalGetValueMap() {
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
        public static VIP_TYPE valueOf(int i10) {
            return forNumber(i10);
        }

        public static VIP_TYPE valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
        internal_static_com_irisdt_client_CommonExtraProto_descriptor = descriptor2;
        internal_static_com_irisdt_client_CommonExtraProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"IsVip", "IsVisitor", "VipType", "IsFake", "SuperLikeCnt", "VipCnt", "SvipCnt", "VisitorCnt", "SsvipCnt", "Oaid", "Imei", "Ua", "AndroidId"});
    }

    private CommonExtraProtos() {
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
