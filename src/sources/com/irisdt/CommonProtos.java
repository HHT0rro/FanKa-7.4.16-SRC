package com.irisdt;

import com.android.internal.logging.nano.MetricsProto;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class CommonProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012CommonProtos.proto\u0012\ncom.irisdt\u001a\u0019google/protobuf/any.proto\"ö\u0003\n\u0006Common\u0012\u000e\n\u0006net_op\u0018\u0001 \u0001(\t\u0012\u000b\n\u0003net\u0018\u0002 \u0001(\t\u0012\u000b\n\u0003lat\u0018\u0003 \u0001(\t\u0012\u000b\n\u0003lon\u0018\u0004 \u0001(\t\u0012\u000f\n\u0007channel\u0018\u0005 \u0001(\t\u0012\u000b\n\u0003uid\u0018\u0006 \u0001(\u0003\u0012\u000f\n\u0007uid_str\u0018\u0007 \u0001(\t\u0012\u0010\n\bplatform\u0018\b \u0001(\t\u0012\u0013\n\u000bapp_version\u0018\t \u0001(\t\u0012\u0018\n\u0010app_version_code\u0018\n \u0001(\u0005\u0012\u0014\n\fscreen_width\u0018\u000b \u0001(\u0005\u0012\u0013\n\u000bscreen_high\u0018\f \u0001(\u0005\u0012\u0012\n\nos_version\u0018\r \u0001(\t\u0012\u000e\n\u0006device\u0018\u000e \u0001(\t\u0012\u0011\n\tclient_ip\u0018\u000f \u0001(\t\u0012\f\n\u0004idfa\u0018\u0010 \u0001(\t\u0012\f\n\u0004idfv\u0018\u0011 \u0001(\t\u0012\f\n\u0004smid\u0018\u0012 \u0001(\t\u0012\u000e\n\u0006box_id\u0018\u0013 \u0001(\t\u0012\u000f\n\u0007dev_dna\u0018\u0014 \u0001(\t\u0012\u0010\n\btimezone\u0018\u0015 \u0001(\t\u0012\u0012\n\nrequest_id\u0018\u0016 \u0001(\t\u0012\u0011\n\tserver_ip\u0018\u0017 \u0001(\t\u0012\u0010\n\blanguage\u0018\u0018 \u0001(\t\u0012\u000e\n\u0006region\u0018\u0019 \u0001(\t\u0012#\n\u0005extra\u0018\u001a \u0001(\u000b2\u0014.google.protobuf.Any\u0012\u0018\n\u0010sdk_version_code\u0018\u001b \u0001(\u0005B\t¢\u0002\u0006Commonb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_irisdt_Common_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_Common_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Common extends GeneratedMessageV3 implements CommonOrBuilder {
        public static final int APP_VERSION_CODE_FIELD_NUMBER = 10;
        public static final int APP_VERSION_FIELD_NUMBER = 9;
        public static final int BOX_ID_FIELD_NUMBER = 19;
        public static final int CHANNEL_FIELD_NUMBER = 5;
        public static final int CLIENT_IP_FIELD_NUMBER = 15;
        public static final int DEVICE_FIELD_NUMBER = 14;
        public static final int DEV_DNA_FIELD_NUMBER = 20;
        public static final int EXTRA_FIELD_NUMBER = 26;
        public static final int IDFA_FIELD_NUMBER = 16;
        public static final int IDFV_FIELD_NUMBER = 17;
        public static final int LANGUAGE_FIELD_NUMBER = 24;
        public static final int LAT_FIELD_NUMBER = 3;
        public static final int LON_FIELD_NUMBER = 4;
        public static final int NET_FIELD_NUMBER = 2;
        public static final int NET_OP_FIELD_NUMBER = 1;
        public static final int OS_VERSION_FIELD_NUMBER = 13;
        public static final int PLATFORM_FIELD_NUMBER = 8;
        public static final int REGION_FIELD_NUMBER = 25;
        public static final int REQUEST_ID_FIELD_NUMBER = 22;
        public static final int SCREEN_HIGH_FIELD_NUMBER = 12;
        public static final int SCREEN_WIDTH_FIELD_NUMBER = 11;
        public static final int SDK_VERSION_CODE_FIELD_NUMBER = 27;
        public static final int SERVER_IP_FIELD_NUMBER = 23;
        public static final int SMID_FIELD_NUMBER = 18;
        public static final int TIMEZONE_FIELD_NUMBER = 21;
        public static final int UID_FIELD_NUMBER = 6;
        public static final int UID_STR_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private int appVersionCode_;
        private volatile Object appVersion_;
        private volatile Object boxId_;
        private volatile Object channel_;
        private volatile Object clientIp_;
        private volatile Object devDna_;
        private volatile Object device_;
        private Any extra_;
        private volatile Object idfa_;
        private volatile Object idfv_;
        private volatile Object language_;
        private volatile Object lat_;
        private volatile Object lon_;
        private byte memoizedIsInitialized;
        private volatile Object netOp_;
        private volatile Object net_;
        private volatile Object osVersion_;
        private volatile Object platform_;
        private volatile Object region_;
        private volatile Object requestId_;
        private int screenHigh_;
        private int screenWidth_;
        private int sdkVersionCode_;
        private volatile Object serverIp_;
        private volatile Object smid_;
        private volatile Object timezone_;
        private volatile Object uidStr_;
        private long uid_;
        private static final Common DEFAULT_INSTANCE = new Common();
        private static final Parser<Common> PARSER = new AbstractParser<Common>() { // from class: com.irisdt.CommonProtos.Common.1
            @Override // com.google.protobuf.Parser
            public Common parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Common(codedInputStream, extensionRegistryLite);
            }
        };

        public static Common getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CommonProtos.internal_static_com_irisdt_Common_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Common parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Common) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Common parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Common> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Common)) {
                return super.equals(obj);
            }
            Common common = (Common) obj;
            if (getNetOp().equals(common.getNetOp()) && getNet().equals(common.getNet()) && getLat().equals(common.getLat()) && getLon().equals(common.getLon()) && getChannel().equals(common.getChannel()) && getUid() == common.getUid() && getUidStr().equals(common.getUidStr()) && getPlatform().equals(common.getPlatform()) && getAppVersion().equals(common.getAppVersion()) && getAppVersionCode() == common.getAppVersionCode() && getScreenWidth() == common.getScreenWidth() && getScreenHigh() == common.getScreenHigh() && getOsVersion().equals(common.getOsVersion()) && getDevice().equals(common.getDevice()) && getClientIp().equals(common.getClientIp()) && getIdfa().equals(common.getIdfa()) && getIdfv().equals(common.getIdfv()) && getSmid().equals(common.getSmid()) && getBoxId().equals(common.getBoxId()) && getDevDna().equals(common.getDevDna()) && getTimezone().equals(common.getTimezone()) && getRequestId().equals(common.getRequestId()) && getServerIp().equals(common.getServerIp()) && getLanguage().equals(common.getLanguage()) && getRegion().equals(common.getRegion()) && hasExtra() == common.hasExtra()) {
                return (!hasExtra() || getExtra().equals(common.getExtra())) && getSdkVersionCode() == common.getSdkVersionCode() && this.unknownFields.equals(common.unknownFields);
            }
            return false;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getAppVersion() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.appVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getAppVersionBytes() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public int getAppVersionCode() {
            return this.appVersionCode_;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getBoxId() {
            Object obj = this.boxId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.boxId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getBoxIdBytes() {
            Object obj = this.boxId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.boxId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getChannel() {
            Object obj = this.channel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.channel_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getChannelBytes() {
            Object obj = this.channel_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.channel_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getClientIp() {
            Object obj = this.clientIp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.clientIp_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getClientIpBytes() {
            Object obj = this.clientIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.clientIp_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getDevDna() {
            Object obj = this.devDna_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.devDna_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getDevDnaBytes() {
            Object obj = this.devDna_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.devDna_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getDevice() {
            Object obj = this.device_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.device_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getDeviceBytes() {
            Object obj = this.device_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.device_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public Any getExtra() {
            Any any = this.extra_;
            return any == null ? Any.getDefaultInstance() : any;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public AnyOrBuilder getExtraOrBuilder() {
            return getExtra();
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getIdfa() {
            Object obj = this.idfa_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.idfa_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getIdfaBytes() {
            Object obj = this.idfa_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.idfa_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getIdfv() {
            Object obj = this.idfv_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.idfv_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getIdfvBytes() {
            Object obj = this.idfv_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.idfv_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getLanguage() {
            Object obj = this.language_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.language_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getLanguageBytes() {
            Object obj = this.language_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.language_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getLat() {
            Object obj = this.lat_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lat_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getLatBytes() {
            Object obj = this.lat_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lat_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getLon() {
            Object obj = this.lon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getLonBytes() {
            Object obj = this.lon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getNet() {
            Object obj = this.net_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.net_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getNetBytes() {
            Object obj = this.net_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.net_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getNetOp() {
            Object obj = this.netOp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.netOp_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getNetOpBytes() {
            Object obj = this.netOp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.netOp_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getOsVersion() {
            Object obj = this.osVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.osVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getOsVersionBytes() {
            Object obj = this.osVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.osVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Common> getParserForType() {
            return PARSER;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getPlatform() {
            Object obj = this.platform_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.platform_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getPlatformBytes() {
            Object obj = this.platform_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.platform_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getRegion() {
            Object obj = this.region_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.region_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getRegionBytes() {
            Object obj = this.region_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.region_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getRequestId() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.requestId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getRequestIdBytes() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public int getScreenHigh() {
            return this.screenHigh_;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public int getScreenWidth() {
            return this.screenWidth_;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public int getSdkVersionCode() {
            return this.sdkVersionCode_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = getNetOpBytes().isEmpty() ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.netOp_);
            if (!getNetBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(2, this.net_);
            }
            if (!getLatBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(3, this.lat_);
            }
            if (!getLonBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(4, this.lon_);
            }
            if (!getChannelBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(5, this.channel_);
            }
            long j10 = this.uid_;
            if (j10 != 0) {
                computeStringSize += CodedOutputStream.computeInt64Size(6, j10);
            }
            if (!getUidStrBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(7, this.uidStr_);
            }
            if (!getPlatformBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(8, this.platform_);
            }
            if (!getAppVersionBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(9, this.appVersion_);
            }
            int i11 = this.appVersionCode_;
            if (i11 != 0) {
                computeStringSize += CodedOutputStream.computeInt32Size(10, i11);
            }
            int i12 = this.screenWidth_;
            if (i12 != 0) {
                computeStringSize += CodedOutputStream.computeInt32Size(11, i12);
            }
            int i13 = this.screenHigh_;
            if (i13 != 0) {
                computeStringSize += CodedOutputStream.computeInt32Size(12, i13);
            }
            if (!getOsVersionBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(13, this.osVersion_);
            }
            if (!getDeviceBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(14, this.device_);
            }
            if (!getClientIpBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(15, this.clientIp_);
            }
            if (!getIdfaBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(16, this.idfa_);
            }
            if (!getIdfvBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(17, this.idfv_);
            }
            if (!getSmidBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(18, this.smid_);
            }
            if (!getBoxIdBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(19, this.boxId_);
            }
            if (!getDevDnaBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(20, this.devDna_);
            }
            if (!getTimezoneBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(21, this.timezone_);
            }
            if (!getRequestIdBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(22, this.requestId_);
            }
            if (!getServerIpBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(23, this.serverIp_);
            }
            if (!getLanguageBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(24, this.language_);
            }
            if (!getRegionBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(25, this.region_);
            }
            if (this.extra_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(26, getExtra());
            }
            int i14 = this.sdkVersionCode_;
            if (i14 != 0) {
                computeStringSize += CodedOutputStream.computeInt32Size(27, i14);
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getServerIp() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.serverIp_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getServerIpBytes() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serverIp_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getSmid() {
            Object obj = this.smid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.smid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getSmidBytes() {
            Object obj = this.smid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.smid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getTimezone() {
            Object obj = this.timezone_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.timezone_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getTimezoneBytes() {
            Object obj = this.timezone_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.timezone_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public long getUid() {
            return this.uid_;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public String getUidStr() {
            Object obj = this.uidStr_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uidStr_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public ByteString getUidStrBytes() {
            Object obj = this.uidStr_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uidStr_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.CommonProtos.CommonOrBuilder
        public boolean hasExtra() {
            return this.extra_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getNetOp().hashCode()) * 37) + 2) * 53) + getNet().hashCode()) * 37) + 3) * 53) + getLat().hashCode()) * 37) + 4) * 53) + getLon().hashCode()) * 37) + 5) * 53) + getChannel().hashCode()) * 37) + 6) * 53) + Internal.hashLong(getUid())) * 37) + 7) * 53) + getUidStr().hashCode()) * 37) + 8) * 53) + getPlatform().hashCode()) * 37) + 9) * 53) + getAppVersion().hashCode()) * 37) + 10) * 53) + getAppVersionCode()) * 37) + 11) * 53) + getScreenWidth()) * 37) + 12) * 53) + getScreenHigh()) * 37) + 13) * 53) + getOsVersion().hashCode()) * 37) + 14) * 53) + getDevice().hashCode()) * 37) + 15) * 53) + getClientIp().hashCode()) * 37) + 16) * 53) + getIdfa().hashCode()) * 37) + 17) * 53) + getIdfv().hashCode()) * 37) + 18) * 53) + getSmid().hashCode()) * 37) + 19) * 53) + getBoxId().hashCode()) * 37) + 20) * 53) + getDevDna().hashCode()) * 37) + 21) * 53) + getTimezone().hashCode()) * 37) + 22) * 53) + getRequestId().hashCode()) * 37) + 23) * 53) + getServerIp().hashCode()) * 37) + 24) * 53) + getLanguage().hashCode()) * 37) + 25) * 53) + getRegion().hashCode();
            if (hasExtra()) {
                hashCode = (((hashCode * 37) + 26) * 53) + getExtra().hashCode();
            }
            int sdkVersionCode = (((((hashCode * 37) + 27) * 53) + getSdkVersionCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = sdkVersionCode;
            return sdkVersionCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CommonProtos.internal_static_com_irisdt_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.class, Builder.class);
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
            return new Common();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getNetOpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.netOp_);
            }
            if (!getNetBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.net_);
            }
            if (!getLatBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.lat_);
            }
            if (!getLonBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.lon_);
            }
            if (!getChannelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.channel_);
            }
            long j10 = this.uid_;
            if (j10 != 0) {
                codedOutputStream.writeInt64(6, j10);
            }
            if (!getUidStrBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.uidStr_);
            }
            if (!getPlatformBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.platform_);
            }
            if (!getAppVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.appVersion_);
            }
            int i10 = this.appVersionCode_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(10, i10);
            }
            int i11 = this.screenWidth_;
            if (i11 != 0) {
                codedOutputStream.writeInt32(11, i11);
            }
            int i12 = this.screenHigh_;
            if (i12 != 0) {
                codedOutputStream.writeInt32(12, i12);
            }
            if (!getOsVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.osVersion_);
            }
            if (!getDeviceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 14, this.device_);
            }
            if (!getClientIpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 15, this.clientIp_);
            }
            if (!getIdfaBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.idfa_);
            }
            if (!getIdfvBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 17, this.idfv_);
            }
            if (!getSmidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 18, this.smid_);
            }
            if (!getBoxIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 19, this.boxId_);
            }
            if (!getDevDnaBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 20, this.devDna_);
            }
            if (!getTimezoneBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 21, this.timezone_);
            }
            if (!getRequestIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 22, this.requestId_);
            }
            if (!getServerIpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 23, this.serverIp_);
            }
            if (!getLanguageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 24, this.language_);
            }
            if (!getRegionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 25, this.region_);
            }
            if (this.extra_ != null) {
                codedOutputStream.writeMessage(26, getExtra());
            }
            int i13 = this.sdkVersionCode_;
            if (i13 != 0) {
                codedOutputStream.writeInt32(27, i13);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommonOrBuilder {
            private int appVersionCode_;
            private Object appVersion_;
            private Object boxId_;
            private Object channel_;
            private Object clientIp_;
            private Object devDna_;
            private Object device_;
            private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> extraBuilder_;
            private Any extra_;
            private Object idfa_;
            private Object idfv_;
            private Object language_;
            private Object lat_;
            private Object lon_;
            private Object netOp_;
            private Object net_;
            private Object osVersion_;
            private Object platform_;
            private Object region_;
            private Object requestId_;
            private int screenHigh_;
            private int screenWidth_;
            private int sdkVersionCode_;
            private Object serverIp_;
            private Object smid_;
            private Object timezone_;
            private Object uidStr_;
            private long uid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CommonProtos.internal_static_com_irisdt_Common_descriptor;
            }

            private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getExtraFieldBuilder() {
                if (this.extraBuilder_ == null) {
                    this.extraBuilder_ = new SingleFieldBuilderV3<>(getExtra(), getParentForChildren(), isClean());
                    this.extra_ = null;
                }
                return this.extraBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAppVersion() {
                this.appVersion_ = Common.getDefaultInstance().getAppVersion();
                onChanged();
                return this;
            }

            public Builder clearAppVersionCode() {
                this.appVersionCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearBoxId() {
                this.boxId_ = Common.getDefaultInstance().getBoxId();
                onChanged();
                return this;
            }

            public Builder clearChannel() {
                this.channel_ = Common.getDefaultInstance().getChannel();
                onChanged();
                return this;
            }

            public Builder clearClientIp() {
                this.clientIp_ = Common.getDefaultInstance().getClientIp();
                onChanged();
                return this;
            }

            public Builder clearDevDna() {
                this.devDna_ = Common.getDefaultInstance().getDevDna();
                onChanged();
                return this;
            }

            public Builder clearDevice() {
                this.device_ = Common.getDefaultInstance().getDevice();
                onChanged();
                return this;
            }

            public Builder clearExtra() {
                if (this.extraBuilder_ == null) {
                    this.extra_ = null;
                    onChanged();
                } else {
                    this.extra_ = null;
                    this.extraBuilder_ = null;
                }
                return this;
            }

            public Builder clearIdfa() {
                this.idfa_ = Common.getDefaultInstance().getIdfa();
                onChanged();
                return this;
            }

            public Builder clearIdfv() {
                this.idfv_ = Common.getDefaultInstance().getIdfv();
                onChanged();
                return this;
            }

            public Builder clearLanguage() {
                this.language_ = Common.getDefaultInstance().getLanguage();
                onChanged();
                return this;
            }

            public Builder clearLat() {
                this.lat_ = Common.getDefaultInstance().getLat();
                onChanged();
                return this;
            }

            public Builder clearLon() {
                this.lon_ = Common.getDefaultInstance().getLon();
                onChanged();
                return this;
            }

            public Builder clearNet() {
                this.net_ = Common.getDefaultInstance().getNet();
                onChanged();
                return this;
            }

            public Builder clearNetOp() {
                this.netOp_ = Common.getDefaultInstance().getNetOp();
                onChanged();
                return this;
            }

            public Builder clearOsVersion() {
                this.osVersion_ = Common.getDefaultInstance().getOsVersion();
                onChanged();
                return this;
            }

            public Builder clearPlatform() {
                this.platform_ = Common.getDefaultInstance().getPlatform();
                onChanged();
                return this;
            }

            public Builder clearRegion() {
                this.region_ = Common.getDefaultInstance().getRegion();
                onChanged();
                return this;
            }

            public Builder clearRequestId() {
                this.requestId_ = Common.getDefaultInstance().getRequestId();
                onChanged();
                return this;
            }

            public Builder clearScreenHigh() {
                this.screenHigh_ = 0;
                onChanged();
                return this;
            }

            public Builder clearScreenWidth() {
                this.screenWidth_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSdkVersionCode() {
                this.sdkVersionCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearServerIp() {
                this.serverIp_ = Common.getDefaultInstance().getServerIp();
                onChanged();
                return this;
            }

            public Builder clearSmid() {
                this.smid_ = Common.getDefaultInstance().getSmid();
                onChanged();
                return this;
            }

            public Builder clearTimezone() {
                this.timezone_ = Common.getDefaultInstance().getTimezone();
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearUidStr() {
                this.uidStr_ = Common.getDefaultInstance().getUidStr();
                onChanged();
                return this;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getAppVersion() {
                Object obj = this.appVersion_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.appVersion_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getAppVersionBytes() {
                Object obj = this.appVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public int getAppVersionCode() {
                return this.appVersionCode_;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getBoxId() {
                Object obj = this.boxId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.boxId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getBoxIdBytes() {
                Object obj = this.boxId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.boxId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getChannel() {
                Object obj = this.channel_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.channel_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getChannelBytes() {
                Object obj = this.channel_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.channel_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getClientIp() {
                Object obj = this.clientIp_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.clientIp_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getClientIpBytes() {
                Object obj = this.clientIp_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.clientIp_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CommonProtos.internal_static_com_irisdt_Common_descriptor;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getDevDna() {
                Object obj = this.devDna_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.devDna_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getDevDnaBytes() {
                Object obj = this.devDna_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.devDna_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getDevice() {
                Object obj = this.device_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.device_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getDeviceBytes() {
                Object obj = this.device_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.device_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public Any getExtra() {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Any any = this.extra_;
                    return any == null ? Any.getDefaultInstance() : any;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Any.Builder getExtraBuilder() {
                onChanged();
                return getExtraFieldBuilder().getBuilder();
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public AnyOrBuilder getExtraOrBuilder() {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Any any = this.extra_;
                return any == null ? Any.getDefaultInstance() : any;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getIdfa() {
                Object obj = this.idfa_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.idfa_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getIdfaBytes() {
                Object obj = this.idfa_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.idfa_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getIdfv() {
                Object obj = this.idfv_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.idfv_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getIdfvBytes() {
                Object obj = this.idfv_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.idfv_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getLanguage() {
                Object obj = this.language_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.language_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getLanguageBytes() {
                Object obj = this.language_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.language_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getLat() {
                Object obj = this.lat_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.lat_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getLatBytes() {
                Object obj = this.lat_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.lat_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getLon() {
                Object obj = this.lon_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.lon_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getLonBytes() {
                Object obj = this.lon_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.lon_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getNet() {
                Object obj = this.net_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.net_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getNetBytes() {
                Object obj = this.net_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.net_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getNetOp() {
                Object obj = this.netOp_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.netOp_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getNetOpBytes() {
                Object obj = this.netOp_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.netOp_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getOsVersion() {
                Object obj = this.osVersion_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.osVersion_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getOsVersionBytes() {
                Object obj = this.osVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.osVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getPlatform() {
                Object obj = this.platform_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.platform_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getPlatformBytes() {
                Object obj = this.platform_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.platform_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getRegion() {
                Object obj = this.region_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.region_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getRegionBytes() {
                Object obj = this.region_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.region_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getRequestId() {
                Object obj = this.requestId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.requestId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getRequestIdBytes() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public int getScreenHigh() {
                return this.screenHigh_;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public int getScreenWidth() {
                return this.screenWidth_;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public int getSdkVersionCode() {
                return this.sdkVersionCode_;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getServerIp() {
                Object obj = this.serverIp_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.serverIp_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getServerIpBytes() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.serverIp_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getSmid() {
                Object obj = this.smid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.smid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getSmidBytes() {
                Object obj = this.smid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.smid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getTimezone() {
                Object obj = this.timezone_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.timezone_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getTimezoneBytes() {
                Object obj = this.timezone_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.timezone_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public long getUid() {
                return this.uid_;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public String getUidStr() {
                Object obj = this.uidStr_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.uidStr_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public ByteString getUidStrBytes() {
                Object obj = this.uidStr_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.uidStr_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.CommonProtos.CommonOrBuilder
            public boolean hasExtra() {
                return (this.extraBuilder_ == null && this.extra_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CommonProtos.internal_static_com_irisdt_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeExtra(Any any) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Any any2 = this.extra_;
                    if (any2 != null) {
                        this.extra_ = Any.newBuilder(any2).mergeFrom(any).buildPartial();
                    } else {
                        this.extra_ = any;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(any);
                }
                return this;
            }

            public Builder setAppVersion(String str) {
                Objects.requireNonNull(str);
                this.appVersion_ = str;
                onChanged();
                return this;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.appVersion_ = byteString;
                onChanged();
                return this;
            }

            public Builder setAppVersionCode(int i10) {
                this.appVersionCode_ = i10;
                onChanged();
                return this;
            }

            public Builder setBoxId(String str) {
                Objects.requireNonNull(str);
                this.boxId_ = str;
                onChanged();
                return this;
            }

            public Builder setBoxIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.boxId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setChannel(String str) {
                Objects.requireNonNull(str);
                this.channel_ = str;
                onChanged();
                return this;
            }

            public Builder setChannelBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.channel_ = byteString;
                onChanged();
                return this;
            }

            public Builder setClientIp(String str) {
                Objects.requireNonNull(str);
                this.clientIp_ = str;
                onChanged();
                return this;
            }

            public Builder setClientIpBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.clientIp_ = byteString;
                onChanged();
                return this;
            }

            public Builder setDevDna(String str) {
                Objects.requireNonNull(str);
                this.devDna_ = str;
                onChanged();
                return this;
            }

            public Builder setDevDnaBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.devDna_ = byteString;
                onChanged();
                return this;
            }

            public Builder setDevice(String str) {
                Objects.requireNonNull(str);
                this.device_ = str;
                onChanged();
                return this;
            }

            public Builder setDeviceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.device_ = byteString;
                onChanged();
                return this;
            }

            public Builder setExtra(Any any) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(any);
                    this.extra_ = any;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(any);
                }
                return this;
            }

            public Builder setIdfa(String str) {
                Objects.requireNonNull(str);
                this.idfa_ = str;
                onChanged();
                return this;
            }

            public Builder setIdfaBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.idfa_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIdfv(String str) {
                Objects.requireNonNull(str);
                this.idfv_ = str;
                onChanged();
                return this;
            }

            public Builder setIdfvBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.idfv_ = byteString;
                onChanged();
                return this;
            }

            public Builder setLanguage(String str) {
                Objects.requireNonNull(str);
                this.language_ = str;
                onChanged();
                return this;
            }

            public Builder setLanguageBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.language_ = byteString;
                onChanged();
                return this;
            }

            public Builder setLat(String str) {
                Objects.requireNonNull(str);
                this.lat_ = str;
                onChanged();
                return this;
            }

            public Builder setLatBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.lat_ = byteString;
                onChanged();
                return this;
            }

            public Builder setLon(String str) {
                Objects.requireNonNull(str);
                this.lon_ = str;
                onChanged();
                return this;
            }

            public Builder setLonBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.lon_ = byteString;
                onChanged();
                return this;
            }

            public Builder setNet(String str) {
                Objects.requireNonNull(str);
                this.net_ = str;
                onChanged();
                return this;
            }

            public Builder setNetBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.net_ = byteString;
                onChanged();
                return this;
            }

            public Builder setNetOp(String str) {
                Objects.requireNonNull(str);
                this.netOp_ = str;
                onChanged();
                return this;
            }

            public Builder setNetOpBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.netOp_ = byteString;
                onChanged();
                return this;
            }

            public Builder setOsVersion(String str) {
                Objects.requireNonNull(str);
                this.osVersion_ = str;
                onChanged();
                return this;
            }

            public Builder setOsVersionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.osVersion_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPlatform(String str) {
                Objects.requireNonNull(str);
                this.platform_ = str;
                onChanged();
                return this;
            }

            public Builder setPlatformBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.platform_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRegion(String str) {
                Objects.requireNonNull(str);
                this.region_ = str;
                onChanged();
                return this;
            }

            public Builder setRegionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.region_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRequestId(String str) {
                Objects.requireNonNull(str);
                this.requestId_ = str;
                onChanged();
                return this;
            }

            public Builder setRequestIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.requestId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setScreenHigh(int i10) {
                this.screenHigh_ = i10;
                onChanged();
                return this;
            }

            public Builder setScreenWidth(int i10) {
                this.screenWidth_ = i10;
                onChanged();
                return this;
            }

            public Builder setSdkVersionCode(int i10) {
                this.sdkVersionCode_ = i10;
                onChanged();
                return this;
            }

            public Builder setServerIp(String str) {
                Objects.requireNonNull(str);
                this.serverIp_ = str;
                onChanged();
                return this;
            }

            public Builder setServerIpBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.serverIp_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSmid(String str) {
                Objects.requireNonNull(str);
                this.smid_ = str;
                onChanged();
                return this;
            }

            public Builder setSmidBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.smid_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTimezone(String str) {
                Objects.requireNonNull(str);
                this.timezone_ = str;
                onChanged();
                return this;
            }

            public Builder setTimezoneBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.timezone_ = byteString;
                onChanged();
                return this;
            }

            public Builder setUid(long j10) {
                this.uid_ = j10;
                onChanged();
                return this;
            }

            public Builder setUidStr(String str) {
                Objects.requireNonNull(str);
                this.uidStr_ = str;
                onChanged();
                return this;
            }

            public Builder setUidStrBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.uidStr_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.netOp_ = "";
                this.net_ = "";
                this.lat_ = "";
                this.lon_ = "";
                this.channel_ = "";
                this.uidStr_ = "";
                this.platform_ = "";
                this.appVersion_ = "";
                this.osVersion_ = "";
                this.device_ = "";
                this.clientIp_ = "";
                this.idfa_ = "";
                this.idfv_ = "";
                this.smid_ = "";
                this.boxId_ = "";
                this.devDna_ = "";
                this.timezone_ = "";
                this.requestId_ = "";
                this.serverIp_ = "";
                this.language_ = "";
                this.region_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Common build() {
                Common buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Common buildPartial() {
                Common common = new Common(this);
                common.netOp_ = this.netOp_;
                common.net_ = this.net_;
                common.lat_ = this.lat_;
                common.lon_ = this.lon_;
                common.channel_ = this.channel_;
                common.uid_ = this.uid_;
                common.uidStr_ = this.uidStr_;
                common.platform_ = this.platform_;
                common.appVersion_ = this.appVersion_;
                common.appVersionCode_ = this.appVersionCode_;
                common.screenWidth_ = this.screenWidth_;
                common.screenHigh_ = this.screenHigh_;
                common.osVersion_ = this.osVersion_;
                common.device_ = this.device_;
                common.clientIp_ = this.clientIp_;
                common.idfa_ = this.idfa_;
                common.idfv_ = this.idfv_;
                common.smid_ = this.smid_;
                common.boxId_ = this.boxId_;
                common.devDna_ = this.devDna_;
                common.timezone_ = this.timezone_;
                common.requestId_ = this.requestId_;
                common.serverIp_ = this.serverIp_;
                common.language_ = this.language_;
                common.region_ = this.region_;
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    common.extra_ = this.extra_;
                } else {
                    common.extra_ = singleFieldBuilderV3.build();
                }
                common.sdkVersionCode_ = this.sdkVersionCode_;
                onBuilt();
                return common;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Common getDefaultInstanceForType() {
                return Common.getDefaultInstance();
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
                this.netOp_ = "";
                this.net_ = "";
                this.lat_ = "";
                this.lon_ = "";
                this.channel_ = "";
                this.uid_ = 0L;
                this.uidStr_ = "";
                this.platform_ = "";
                this.appVersion_ = "";
                this.appVersionCode_ = 0;
                this.screenWidth_ = 0;
                this.screenHigh_ = 0;
                this.osVersion_ = "";
                this.device_ = "";
                this.clientIp_ = "";
                this.idfa_ = "";
                this.idfv_ = "";
                this.smid_ = "";
                this.boxId_ = "";
                this.devDna_ = "";
                this.timezone_ = "";
                this.requestId_ = "";
                this.serverIp_ = "";
                this.language_ = "";
                this.region_ = "";
                if (this.extraBuilder_ == null) {
                    this.extra_ = null;
                } else {
                    this.extra_ = null;
                    this.extraBuilder_ = null;
                }
                this.sdkVersionCode_ = 0;
                return this;
            }

            public Builder setExtra(Any.Builder builder) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.extra_ = builder.build();
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
                if (message instanceof Common) {
                    return mergeFrom((Common) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Common common) {
                if (common == Common.getDefaultInstance()) {
                    return this;
                }
                if (!common.getNetOp().isEmpty()) {
                    this.netOp_ = common.netOp_;
                    onChanged();
                }
                if (!common.getNet().isEmpty()) {
                    this.net_ = common.net_;
                    onChanged();
                }
                if (!common.getLat().isEmpty()) {
                    this.lat_ = common.lat_;
                    onChanged();
                }
                if (!common.getLon().isEmpty()) {
                    this.lon_ = common.lon_;
                    onChanged();
                }
                if (!common.getChannel().isEmpty()) {
                    this.channel_ = common.channel_;
                    onChanged();
                }
                if (common.getUid() != 0) {
                    setUid(common.getUid());
                }
                if (!common.getUidStr().isEmpty()) {
                    this.uidStr_ = common.uidStr_;
                    onChanged();
                }
                if (!common.getPlatform().isEmpty()) {
                    this.platform_ = common.platform_;
                    onChanged();
                }
                if (!common.getAppVersion().isEmpty()) {
                    this.appVersion_ = common.appVersion_;
                    onChanged();
                }
                if (common.getAppVersionCode() != 0) {
                    setAppVersionCode(common.getAppVersionCode());
                }
                if (common.getScreenWidth() != 0) {
                    setScreenWidth(common.getScreenWidth());
                }
                if (common.getScreenHigh() != 0) {
                    setScreenHigh(common.getScreenHigh());
                }
                if (!common.getOsVersion().isEmpty()) {
                    this.osVersion_ = common.osVersion_;
                    onChanged();
                }
                if (!common.getDevice().isEmpty()) {
                    this.device_ = common.device_;
                    onChanged();
                }
                if (!common.getClientIp().isEmpty()) {
                    this.clientIp_ = common.clientIp_;
                    onChanged();
                }
                if (!common.getIdfa().isEmpty()) {
                    this.idfa_ = common.idfa_;
                    onChanged();
                }
                if (!common.getIdfv().isEmpty()) {
                    this.idfv_ = common.idfv_;
                    onChanged();
                }
                if (!common.getSmid().isEmpty()) {
                    this.smid_ = common.smid_;
                    onChanged();
                }
                if (!common.getBoxId().isEmpty()) {
                    this.boxId_ = common.boxId_;
                    onChanged();
                }
                if (!common.getDevDna().isEmpty()) {
                    this.devDna_ = common.devDna_;
                    onChanged();
                }
                if (!common.getTimezone().isEmpty()) {
                    this.timezone_ = common.timezone_;
                    onChanged();
                }
                if (!common.getRequestId().isEmpty()) {
                    this.requestId_ = common.requestId_;
                    onChanged();
                }
                if (!common.getServerIp().isEmpty()) {
                    this.serverIp_ = common.serverIp_;
                    onChanged();
                }
                if (!common.getLanguage().isEmpty()) {
                    this.language_ = common.language_;
                    onChanged();
                }
                if (!common.getRegion().isEmpty()) {
                    this.region_ = common.region_;
                    onChanged();
                }
                if (common.hasExtra()) {
                    mergeExtra(common.getExtra());
                }
                if (common.getSdkVersionCode() != 0) {
                    setSdkVersionCode(common.getSdkVersionCode());
                }
                mergeUnknownFields(common.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.netOp_ = "";
                this.net_ = "";
                this.lat_ = "";
                this.lon_ = "";
                this.channel_ = "";
                this.uidStr_ = "";
                this.platform_ = "";
                this.appVersion_ = "";
                this.osVersion_ = "";
                this.device_ = "";
                this.clientIp_ = "";
                this.idfa_ = "";
                this.idfv_ = "";
                this.smid_ = "";
                this.boxId_ = "";
                this.devDna_ = "";
                this.timezone_ = "";
                this.requestId_ = "";
                this.serverIp_ = "";
                this.language_ = "";
                this.region_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.CommonProtos.Common.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.CommonProtos.Common.access$3400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.CommonProtos$Common r3 = (com.irisdt.CommonProtos.Common) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.CommonProtos$Common r4 = (com.irisdt.CommonProtos.Common) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.CommonProtos.Common.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.CommonProtos$Common$Builder");
            }
        }

        public static Builder newBuilder(Common common) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(common);
        }

        public static Common parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private Common(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Common parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Common) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Common parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Common getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static Common parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Common() {
            this.memoizedIsInitialized = (byte) -1;
            this.netOp_ = "";
            this.net_ = "";
            this.lat_ = "";
            this.lon_ = "";
            this.channel_ = "";
            this.uidStr_ = "";
            this.platform_ = "";
            this.appVersion_ = "";
            this.osVersion_ = "";
            this.device_ = "";
            this.clientIp_ = "";
            this.idfa_ = "";
            this.idfv_ = "";
            this.smid_ = "";
            this.boxId_ = "";
            this.devDna_ = "";
            this.timezone_ = "";
            this.requestId_ = "";
            this.serverIp_ = "";
            this.language_ = "";
            this.region_ = "";
        }

        public static Common parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static Common parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Common parseFrom(InputStream inputStream) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Common parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Common parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Common parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
        private Common(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            case 10:
                                this.netOp_ = codedInputStream.readStringRequireUtf8();
                            case 18:
                                this.net_ = codedInputStream.readStringRequireUtf8();
                            case 26:
                                this.lat_ = codedInputStream.readStringRequireUtf8();
                            case 34:
                                this.lon_ = codedInputStream.readStringRequireUtf8();
                            case 42:
                                this.channel_ = codedInputStream.readStringRequireUtf8();
                            case 48:
                                this.uid_ = codedInputStream.readInt64();
                            case 58:
                                this.uidStr_ = codedInputStream.readStringRequireUtf8();
                            case 66:
                                this.platform_ = codedInputStream.readStringRequireUtf8();
                            case 74:
                                this.appVersion_ = codedInputStream.readStringRequireUtf8();
                            case 80:
                                this.appVersionCode_ = codedInputStream.readInt32();
                            case 88:
                                this.screenWidth_ = codedInputStream.readInt32();
                            case 96:
                                this.screenHigh_ = codedInputStream.readInt32();
                            case 106:
                                this.osVersion_ = codedInputStream.readStringRequireUtf8();
                            case 114:
                                this.device_ = codedInputStream.readStringRequireUtf8();
                            case 122:
                                this.clientIp_ = codedInputStream.readStringRequireUtf8();
                            case 130:
                                this.idfa_ = codedInputStream.readStringRequireUtf8();
                            case 138:
                                this.idfv_ = codedInputStream.readStringRequireUtf8();
                            case 146:
                                this.smid_ = codedInputStream.readStringRequireUtf8();
                            case 154:
                                this.boxId_ = codedInputStream.readStringRequireUtf8();
                            case 162:
                                this.devDna_ = codedInputStream.readStringRequireUtf8();
                            case 170:
                                this.timezone_ = codedInputStream.readStringRequireUtf8();
                            case 178:
                                this.requestId_ = codedInputStream.readStringRequireUtf8();
                            case 186:
                                this.serverIp_ = codedInputStream.readStringRequireUtf8();
                            case 194:
                                this.language_ = codedInputStream.readStringRequireUtf8();
                            case 202:
                                this.region_ = codedInputStream.readStringRequireUtf8();
                            case 210:
                                Any any = this.extra_;
                                Any.Builder builder = any != null ? any.toBuilder() : null;
                                Any any2 = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                this.extra_ = any2;
                                if (builder != null) {
                                    builder.mergeFrom(any2);
                                    this.extra_ = builder.buildPartial();
                                }
                            case 216:
                                this.sdkVersionCode_ = codedInputStream.readInt32();
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
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface CommonOrBuilder extends MessageOrBuilder {
        String getAppVersion();

        ByteString getAppVersionBytes();

        int getAppVersionCode();

        String getBoxId();

        ByteString getBoxIdBytes();

        String getChannel();

        ByteString getChannelBytes();

        String getClientIp();

        ByteString getClientIpBytes();

        String getDevDna();

        ByteString getDevDnaBytes();

        String getDevice();

        ByteString getDeviceBytes();

        Any getExtra();

        AnyOrBuilder getExtraOrBuilder();

        String getIdfa();

        ByteString getIdfaBytes();

        String getIdfv();

        ByteString getIdfvBytes();

        String getLanguage();

        ByteString getLanguageBytes();

        String getLat();

        ByteString getLatBytes();

        String getLon();

        ByteString getLonBytes();

        String getNet();

        ByteString getNetBytes();

        String getNetOp();

        ByteString getNetOpBytes();

        String getOsVersion();

        ByteString getOsVersionBytes();

        String getPlatform();

        ByteString getPlatformBytes();

        String getRegion();

        ByteString getRegionBytes();

        String getRequestId();

        ByteString getRequestIdBytes();

        int getScreenHigh();

        int getScreenWidth();

        int getSdkVersionCode();

        String getServerIp();

        ByteString getServerIpBytes();

        String getSmid();

        ByteString getSmidBytes();

        String getTimezone();

        ByteString getTimezoneBytes();

        long getUid();

        String getUidStr();

        ByteString getUidStrBytes();

        boolean hasExtra();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_irisdt_Common_descriptor = descriptor2;
        internal_static_com_irisdt_Common_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"NetOp", "Net", "Lat", "Lon", "Channel", "Uid", "UidStr", "Platform", "AppVersion", "AppVersionCode", "ScreenWidth", "ScreenHigh", "OsVersion", "Device", "ClientIp", "Idfa", "Idfv", "Smid", "BoxId", "DevDna", "Timezone", "RequestId", "ServerIp", "Language", "Region", "Extra", "SdkVersionCode"});
        AnyProto.getDescriptor();
    }

    private CommonProtos() {
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
