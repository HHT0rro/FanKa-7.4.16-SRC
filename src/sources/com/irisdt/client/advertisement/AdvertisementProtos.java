package com.irisdt.client.advertisement;

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
public final class AdvertisementProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019AdvertisementProtos.proto\u0012\u001fcom.irisdt.client.advertisement\"Â\u0004\n\u0012AdvertisementProto\u00125\n\u0005event\u0018\u0001 \u0001(\u000e2&.com.irisdt.client.advertisement.Event\u0012\f\n\u0004type\u0018\u0002 \u0001(\t\u0012\n\n\u0002id\u0018\u0003 \u0001(\t\u0012\u000f\n\u0007is_true\u0018\u0004 \u0001(\b\u0012\u000e\n\u0006reason\u0018\u0005 \u0001(\t\u0012\f\n\u0004time\u0018\u0006 \u0001(\u0002\u0012\u000f\n\u0007content\u0018\u0007 \u0001(\t\u0012\u000b\n\u0003url\u0018\b \u0001(\t\u0012\u000f\n\u0007post_id\u0018\t \u0001(\t\u0012\f\n\u0004name\u0018\n \u0001(\t\u0012\u0010\n\bposition\u0018\u000b \u0001(\t\u0012\r\n\u0005index\u0018\f \u0001(\u0005\u0012\r\n\u0005ad_id\u0018\r \u0001(\t\u0012\u000f\n\u0007is_full\u0018\u000e \u0001(\b\u0012\u000b\n\u0003num\u0018\u000f \u0001(\u0005\u0012\u000e\n\u0006req_id\u0018\u0010 \u0001(\t\u0012\u0012\n\nrequest_id\u0018\u0011 \u0001(\t\u0012\u0015\n\rrequest_times\u0018\u0012 \u0001(\u0005\u0012\u0011\n\tad_source\u0018\u0013 \u0001(\t\u0012\u000f\n\u0007code_id\u0018\u0014 \u0001(\t\u0012\u000f\n\u0007ad_type\u0018\u0015 \u0001(\t\u0012\u0014\n\frequest_type\u0018\u0016 \u0001(\t\u0012\u0012\n\nis_success\u0018\u0017 \u0001(\b\u0012\u0014\n\fsuccess_type\u0018\u0018 \u0001(\t\u0012\u0011\n\tcost_time\u0018\u0019 \u0001(\u0003\u0012\u0015\n\ris_compliance\u0018\u001a \u0001(\b\u0012\u0010\n\bad_price\u0018\u001b \u0001(\u0003\u0012\u0011\n\tshow_time\u0018\u001c \u0001(\u0003\u0012\u0010\n\bend_type\u0018\u001d \u0001(\t\u0012\u0010\n\bis_cache\u0018\u001e \u0001(\b*Ú\u0003\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010\u0000\u0012\u0014\n\u0010OPEN_APP_AD_SHOW\u0010\u0001\u0012\u0015\n\u0011OPEN_APP_AD_CLICK\u0010\u0002\u0012\u0014\n\u0010OPEN_APP_AD_SKIP\u0010\u0003\u0012\u001b\n\u0017OPEN_APP_AD_SHOW_FINISH\u0010\u0004\u0012\u0015\n\u0011SPONSOR_POST_SHOW\u0010\u0005\u0012\u0016\n\u0012SPONSOR_POST_CLICK\u0010\u0006\u0012\u0014\n\u0010LIVE_BANNER_SHOW\u0010\u0007\u0012\u0015\n\u0011LIVE_BANNER_CLICK\u0010\b\u0012\u000f\n\u000bMSG_AD_SHOW\u0010\t\u0012\u0010\n\fMSG_AD_CLICK\u0010\n\u0012\u0010\n\fMSG_AD_CLOSE\u0010\u000b\u0012\r\n\tHORN_SHOW\u0010\f\u0012\u0010\n\fCARD_AD_SHOW\u0010\r\u0012\u0011\n\rCARD_AD_CLICK\u0010\u000e\u0012\u000e\n\nHORN_CLICK\u0010\u000f\u0012\u0014\n\u0010HIGHLIGHT_MOMENT\u0010\u0010\u0012\u0012\n\u000eOPEN_APP_NO_AD\u0010\u0011\u0012\u000e\n\nAD_REQUEST\u0010\u0012\u0012\r\n\tAD_RETURN\u0010\u0013\u0012\u000b\n\u0007AD_SHOW\u0010\u0014\u0012\f\n\bAD_CLICK\u0010\u0015\u0012\n\n\u0006AD_END\u0010\u0016\u0012\u0019\n\u0015AD_TIME_SPENT_MONITOR\u0010\u0017B\u0010¢\u0002\rADVERTISEMENTb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_advertisement_AdvertisementProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_advertisement_AdvertisementProto_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class AdvertisementProto extends GeneratedMessageV3 implements AdvertisementProtoOrBuilder {
        public static final int AD_ID_FIELD_NUMBER = 13;
        public static final int AD_PRICE_FIELD_NUMBER = 27;
        public static final int AD_SOURCE_FIELD_NUMBER = 19;
        public static final int AD_TYPE_FIELD_NUMBER = 21;
        public static final int CODE_ID_FIELD_NUMBER = 20;
        public static final int CONTENT_FIELD_NUMBER = 7;
        public static final int COST_TIME_FIELD_NUMBER = 25;
        public static final int END_TYPE_FIELD_NUMBER = 29;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int ID_FIELD_NUMBER = 3;
        public static final int INDEX_FIELD_NUMBER = 12;
        public static final int IS_CACHE_FIELD_NUMBER = 30;
        public static final int IS_COMPLIANCE_FIELD_NUMBER = 26;
        public static final int IS_FULL_FIELD_NUMBER = 14;
        public static final int IS_SUCCESS_FIELD_NUMBER = 23;
        public static final int IS_TRUE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 10;
        public static final int NUM_FIELD_NUMBER = 15;
        public static final int POSITION_FIELD_NUMBER = 11;
        public static final int POST_ID_FIELD_NUMBER = 9;
        public static final int REASON_FIELD_NUMBER = 5;
        public static final int REQUEST_ID_FIELD_NUMBER = 17;
        public static final int REQUEST_TIMES_FIELD_NUMBER = 18;
        public static final int REQUEST_TYPE_FIELD_NUMBER = 22;
        public static final int REQ_ID_FIELD_NUMBER = 16;
        public static final int SHOW_TIME_FIELD_NUMBER = 28;
        public static final int SUCCESS_TYPE_FIELD_NUMBER = 24;
        public static final int TIME_FIELD_NUMBER = 6;
        public static final int TYPE_FIELD_NUMBER = 2;
        public static final int URL_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private volatile Object adId_;
        private long adPrice_;
        private volatile Object adSource_;
        private volatile Object adType_;
        private volatile Object codeId_;
        private volatile Object content_;
        private long costTime_;
        private volatile Object endType_;
        private int event_;
        private volatile Object id_;
        private int index_;
        private boolean isCache_;
        private boolean isCompliance_;
        private boolean isFull_;
        private boolean isSuccess_;
        private boolean isTrue_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int num_;
        private volatile Object position_;
        private volatile Object postId_;
        private volatile Object reason_;
        private volatile Object reqId_;
        private volatile Object requestId_;
        private int requestTimes_;
        private volatile Object requestType_;
        private long showTime_;
        private volatile Object successType_;
        private float time_;
        private volatile Object type_;
        private volatile Object url_;
        private static final AdvertisementProto DEFAULT_INSTANCE = new AdvertisementProto();
        private static final Parser<AdvertisementProto> PARSER = new AbstractParser<AdvertisementProto>() { // from class: com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProto.1
            @Override // com.google.protobuf.Parser
            public AdvertisementProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AdvertisementProto(codedInputStream, extensionRegistryLite);
            }
        };

        private AdvertisementProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static AdvertisementProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AdvertisementProtos.internal_static_com_irisdt_client_advertisement_AdvertisementProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static AdvertisementProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AdvertisementProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AdvertisementProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<AdvertisementProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AdvertisementProto)) {
                return super.equals(obj);
            }
            AdvertisementProto advertisementProto = (AdvertisementProto) obj;
            return this.event_ == advertisementProto.event_ && getType().equals(advertisementProto.getType()) && getId().equals(advertisementProto.getId()) && getIsTrue() == advertisementProto.getIsTrue() && getReason().equals(advertisementProto.getReason()) && Float.floatToIntBits(getTime()) == Float.floatToIntBits(advertisementProto.getTime()) && getContent().equals(advertisementProto.getContent()) && getUrl().equals(advertisementProto.getUrl()) && getPostId().equals(advertisementProto.getPostId()) && getName().equals(advertisementProto.getName()) && getPosition().equals(advertisementProto.getPosition()) && getIndex() == advertisementProto.getIndex() && getAdId().equals(advertisementProto.getAdId()) && getIsFull() == advertisementProto.getIsFull() && getNum() == advertisementProto.getNum() && getReqId().equals(advertisementProto.getReqId()) && getRequestId().equals(advertisementProto.getRequestId()) && getRequestTimes() == advertisementProto.getRequestTimes() && getAdSource().equals(advertisementProto.getAdSource()) && getCodeId().equals(advertisementProto.getCodeId()) && getAdType().equals(advertisementProto.getAdType()) && getRequestType().equals(advertisementProto.getRequestType()) && getIsSuccess() == advertisementProto.getIsSuccess() && getSuccessType().equals(advertisementProto.getSuccessType()) && getCostTime() == advertisementProto.getCostTime() && getIsCompliance() == advertisementProto.getIsCompliance() && getAdPrice() == advertisementProto.getAdPrice() && getShowTime() == advertisementProto.getShowTime() && getEndType().equals(advertisementProto.getEndType()) && getIsCache() == advertisementProto.getIsCache() && this.unknownFields.equals(advertisementProto.unknownFields);
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getAdId() {
            Object obj = this.adId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.adId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getAdIdBytes() {
            Object obj = this.adId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.adId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public long getAdPrice() {
            return this.adPrice_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getAdSource() {
            Object obj = this.adSource_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.adSource_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getAdSourceBytes() {
            Object obj = this.adSource_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.adSource_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getAdType() {
            Object obj = this.adType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.adType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getAdTypeBytes() {
            Object obj = this.adType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.adType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getCodeId() {
            Object obj = this.codeId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.codeId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getCodeIdBytes() {
            Object obj = this.codeId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.codeId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public long getCostTime() {
            return this.costTime_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getEndType() {
            Object obj = this.endType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.endType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getEndTypeBytes() {
            Object obj = this.endType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.endType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            return valueOf == null ? Event.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public boolean getIsCache() {
            return this.isCache_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public boolean getIsCompliance() {
            return this.isCompliance_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public boolean getIsFull() {
            return this.isFull_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public boolean getIsTrue() {
            return this.isTrue_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AdvertisementProto> getParserForType() {
            return PARSER;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getPosition() {
            Object obj = this.position_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.position_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getPositionBytes() {
            Object obj = this.position_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.position_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getPostId() {
            Object obj = this.postId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.postId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getPostIdBytes() {
            Object obj = this.postId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.postId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getReason() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reason_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getReasonBytes() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reason_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getReqId() {
            Object obj = this.reqId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reqId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getReqIdBytes() {
            Object obj = this.reqId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reqId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getRequestId() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.requestId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getRequestIdBytes() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public int getRequestTimes() {
            return this.requestTimes_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getRequestType() {
            Object obj = this.requestType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.requestType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getRequestTypeBytes() {
            Object obj = this.requestType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestType_ = copyFromUtf8;
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
            int computeEnumSize = this.event_ != Event.UNKNOWN_EVENT.getNumber() ? 0 + CodedOutputStream.computeEnumSize(1, this.event_) : 0;
            if (!getTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(2, this.type_);
            }
            if (!getIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(3, this.id_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                computeEnumSize += CodedOutputStream.computeBoolSize(4, z10);
            }
            if (!getReasonBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(5, this.reason_);
            }
            float f10 = this.time_;
            if (f10 != 0.0f) {
                computeEnumSize += CodedOutputStream.computeFloatSize(6, f10);
            }
            if (!getContentBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(7, this.content_);
            }
            if (!getUrlBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(8, this.url_);
            }
            if (!getPostIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(9, this.postId_);
            }
            if (!getNameBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(10, this.name_);
            }
            if (!getPositionBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(11, this.position_);
            }
            int i11 = this.index_;
            if (i11 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(12, i11);
            }
            if (!getAdIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(13, this.adId_);
            }
            boolean z11 = this.isFull_;
            if (z11) {
                computeEnumSize += CodedOutputStream.computeBoolSize(14, z11);
            }
            int i12 = this.num_;
            if (i12 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(15, i12);
            }
            if (!getReqIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(16, this.reqId_);
            }
            if (!getRequestIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(17, this.requestId_);
            }
            int i13 = this.requestTimes_;
            if (i13 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(18, i13);
            }
            if (!getAdSourceBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(19, this.adSource_);
            }
            if (!getCodeIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(20, this.codeId_);
            }
            if (!getAdTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(21, this.adType_);
            }
            if (!getRequestTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(22, this.requestType_);
            }
            boolean z12 = this.isSuccess_;
            if (z12) {
                computeEnumSize += CodedOutputStream.computeBoolSize(23, z12);
            }
            if (!getSuccessTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(24, this.successType_);
            }
            long j10 = this.costTime_;
            if (j10 != 0) {
                computeEnumSize += CodedOutputStream.computeInt64Size(25, j10);
            }
            boolean z13 = this.isCompliance_;
            if (z13) {
                computeEnumSize += CodedOutputStream.computeBoolSize(26, z13);
            }
            long j11 = this.adPrice_;
            if (j11 != 0) {
                computeEnumSize += CodedOutputStream.computeInt64Size(27, j11);
            }
            long j12 = this.showTime_;
            if (j12 != 0) {
                computeEnumSize += CodedOutputStream.computeInt64Size(28, j12);
            }
            if (!getEndTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(29, this.endType_);
            }
            boolean z14 = this.isCache_;
            if (z14) {
                computeEnumSize += CodedOutputStream.computeBoolSize(30, z14);
            }
            int serializedSize = computeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public long getShowTime() {
            return this.showTime_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getSuccessType() {
            Object obj = this.successType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.successType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getSuccessTypeBytes() {
            Object obj = this.successType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.successType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public float getTime() {
            return this.time_;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + getType().hashCode()) * 37) + 3) * 53) + getId().hashCode()) * 37) + 4) * 53) + Internal.hashBoolean(getIsTrue())) * 37) + 5) * 53) + getReason().hashCode()) * 37) + 6) * 53) + Float.floatToIntBits(getTime())) * 37) + 7) * 53) + getContent().hashCode()) * 37) + 8) * 53) + getUrl().hashCode()) * 37) + 9) * 53) + getPostId().hashCode()) * 37) + 10) * 53) + getName().hashCode()) * 37) + 11) * 53) + getPosition().hashCode()) * 37) + 12) * 53) + getIndex()) * 37) + 13) * 53) + getAdId().hashCode()) * 37) + 14) * 53) + Internal.hashBoolean(getIsFull())) * 37) + 15) * 53) + getNum()) * 37) + 16) * 53) + getReqId().hashCode()) * 37) + 17) * 53) + getRequestId().hashCode()) * 37) + 18) * 53) + getRequestTimes()) * 37) + 19) * 53) + getAdSource().hashCode()) * 37) + 20) * 53) + getCodeId().hashCode()) * 37) + 21) * 53) + getAdType().hashCode()) * 37) + 22) * 53) + getRequestType().hashCode()) * 37) + 23) * 53) + Internal.hashBoolean(getIsSuccess())) * 37) + 24) * 53) + getSuccessType().hashCode()) * 37) + 25) * 53) + Internal.hashLong(getCostTime())) * 37) + 26) * 53) + Internal.hashBoolean(getIsCompliance())) * 37) + 27) * 53) + Internal.hashLong(getAdPrice())) * 37) + 28) * 53) + Internal.hashLong(getShowTime())) * 37) + 29) * 53) + getEndType().hashCode()) * 37) + 30) * 53) + Internal.hashBoolean(getIsCache())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AdvertisementProtos.internal_static_com_irisdt_client_advertisement_AdvertisementProto_fieldAccessorTable.ensureFieldAccessorsInitialized(AdvertisementProto.class, Builder.class);
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
            return new AdvertisementProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.type_);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.id_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                codedOutputStream.writeBool(4, z10);
            }
            if (!getReasonBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.reason_);
            }
            float f10 = this.time_;
            if (f10 != 0.0f) {
                codedOutputStream.writeFloat(6, f10);
            }
            if (!getContentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.content_);
            }
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.url_);
            }
            if (!getPostIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.postId_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.name_);
            }
            if (!getPositionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.position_);
            }
            int i10 = this.index_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(12, i10);
            }
            if (!getAdIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.adId_);
            }
            boolean z11 = this.isFull_;
            if (z11) {
                codedOutputStream.writeBool(14, z11);
            }
            int i11 = this.num_;
            if (i11 != 0) {
                codedOutputStream.writeInt32(15, i11);
            }
            if (!getReqIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.reqId_);
            }
            if (!getRequestIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 17, this.requestId_);
            }
            int i12 = this.requestTimes_;
            if (i12 != 0) {
                codedOutputStream.writeInt32(18, i12);
            }
            if (!getAdSourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 19, this.adSource_);
            }
            if (!getCodeIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 20, this.codeId_);
            }
            if (!getAdTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 21, this.adType_);
            }
            if (!getRequestTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 22, this.requestType_);
            }
            boolean z12 = this.isSuccess_;
            if (z12) {
                codedOutputStream.writeBool(23, z12);
            }
            if (!getSuccessTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 24, this.successType_);
            }
            long j10 = this.costTime_;
            if (j10 != 0) {
                codedOutputStream.writeInt64(25, j10);
            }
            boolean z13 = this.isCompliance_;
            if (z13) {
                codedOutputStream.writeBool(26, z13);
            }
            long j11 = this.adPrice_;
            if (j11 != 0) {
                codedOutputStream.writeInt64(27, j11);
            }
            long j12 = this.showTime_;
            if (j12 != 0) {
                codedOutputStream.writeInt64(28, j12);
            }
            if (!getEndTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 29, this.endType_);
            }
            boolean z14 = this.isCache_;
            if (z14) {
                codedOutputStream.writeBool(30, z14);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AdvertisementProtoOrBuilder {
            private Object adId_;
            private long adPrice_;
            private Object adSource_;
            private Object adType_;
            private Object codeId_;
            private Object content_;
            private long costTime_;
            private Object endType_;
            private int event_;
            private Object id_;
            private int index_;
            private boolean isCache_;
            private boolean isCompliance_;
            private boolean isFull_;
            private boolean isSuccess_;
            private boolean isTrue_;
            private Object name_;
            private int num_;
            private Object position_;
            private Object postId_;
            private Object reason_;
            private Object reqId_;
            private Object requestId_;
            private int requestTimes_;
            private Object requestType_;
            private long showTime_;
            private Object successType_;
            private float time_;
            private Object type_;
            private Object url_;

            private Builder() {
                this.event_ = 0;
                this.type_ = "";
                this.id_ = "";
                this.reason_ = "";
                this.content_ = "";
                this.url_ = "";
                this.postId_ = "";
                this.name_ = "";
                this.position_ = "";
                this.adId_ = "";
                this.reqId_ = "";
                this.requestId_ = "";
                this.adSource_ = "";
                this.codeId_ = "";
                this.adType_ = "";
                this.requestType_ = "";
                this.successType_ = "";
                this.endType_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AdvertisementProtos.internal_static_com_irisdt_client_advertisement_AdvertisementProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAdId() {
                this.adId_ = AdvertisementProto.getDefaultInstance().getAdId();
                onChanged();
                return this;
            }

            public Builder clearAdPrice() {
                this.adPrice_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearAdSource() {
                this.adSource_ = AdvertisementProto.getDefaultInstance().getAdSource();
                onChanged();
                return this;
            }

            public Builder clearAdType() {
                this.adType_ = AdvertisementProto.getDefaultInstance().getAdType();
                onChanged();
                return this;
            }

            public Builder clearCodeId() {
                this.codeId_ = AdvertisementProto.getDefaultInstance().getCodeId();
                onChanged();
                return this;
            }

            public Builder clearContent() {
                this.content_ = AdvertisementProto.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder clearCostTime() {
                this.costTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearEndType() {
                this.endType_ = AdvertisementProto.getDefaultInstance().getEndType();
                onChanged();
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = AdvertisementProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsCache() {
                this.isCache_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsCompliance() {
                this.isCompliance_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsFull() {
                this.isFull_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsSuccess() {
                this.isSuccess_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTrue() {
                this.isTrue_ = false;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = AdvertisementProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.num_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPosition() {
                this.position_ = AdvertisementProto.getDefaultInstance().getPosition();
                onChanged();
                return this;
            }

            public Builder clearPostId() {
                this.postId_ = AdvertisementProto.getDefaultInstance().getPostId();
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = AdvertisementProto.getDefaultInstance().getReason();
                onChanged();
                return this;
            }

            public Builder clearReqId() {
                this.reqId_ = AdvertisementProto.getDefaultInstance().getReqId();
                onChanged();
                return this;
            }

            public Builder clearRequestId() {
                this.requestId_ = AdvertisementProto.getDefaultInstance().getRequestId();
                onChanged();
                return this;
            }

            public Builder clearRequestTimes() {
                this.requestTimes_ = 0;
                onChanged();
                return this;
            }

            public Builder clearRequestType() {
                this.requestType_ = AdvertisementProto.getDefaultInstance().getRequestType();
                onChanged();
                return this;
            }

            public Builder clearShowTime() {
                this.showTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearSuccessType() {
                this.successType_ = AdvertisementProto.getDefaultInstance().getSuccessType();
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = AdvertisementProto.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = AdvertisementProto.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getAdId() {
                Object obj = this.adId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.adId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getAdIdBytes() {
                Object obj = this.adId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.adId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public long getAdPrice() {
                return this.adPrice_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getAdSource() {
                Object obj = this.adSource_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.adSource_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getAdSourceBytes() {
                Object obj = this.adSource_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.adSource_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getAdType() {
                Object obj = this.adType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.adType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getAdTypeBytes() {
                Object obj = this.adType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.adType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getCodeId() {
                Object obj = this.codeId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.codeId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getCodeIdBytes() {
                Object obj = this.codeId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.codeId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getContent() {
                Object obj = this.content_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.content_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public long getCostTime() {
                return this.costTime_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AdvertisementProtos.internal_static_com_irisdt_client_advertisement_AdvertisementProto_descriptor;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getEndType() {
                Object obj = this.endType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.endType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getEndTypeBytes() {
                Object obj = this.endType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.endType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                return valueOf == null ? Event.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.id_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public int getIndex() {
                return this.index_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public boolean getIsCache() {
                return this.isCache_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public boolean getIsCompliance() {
                return this.isCompliance_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public boolean getIsFull() {
                return this.isFull_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public boolean getIsSuccess() {
                return this.isSuccess_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public boolean getIsTrue() {
                return this.isTrue_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.name_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public int getNum() {
                return this.num_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getPosition() {
                Object obj = this.position_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.position_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getPositionBytes() {
                Object obj = this.position_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.position_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getPostId() {
                Object obj = this.postId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.postId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getPostIdBytes() {
                Object obj = this.postId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.postId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getReason() {
                Object obj = this.reason_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.reason_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getReasonBytes() {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reason_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getReqId() {
                Object obj = this.reqId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.reqId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getReqIdBytes() {
                Object obj = this.reqId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reqId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getRequestId() {
                Object obj = this.requestId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.requestId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getRequestIdBytes() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public int getRequestTimes() {
                return this.requestTimes_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getRequestType() {
                Object obj = this.requestType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.requestType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getRequestTypeBytes() {
                Object obj = this.requestType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public long getShowTime() {
                return this.showTime_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getSuccessType() {
                Object obj = this.successType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.successType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getSuccessTypeBytes() {
                Object obj = this.successType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.successType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public float getTime() {
                return this.time_;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.type_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.url_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProtoOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AdvertisementProtos.internal_static_com_irisdt_client_advertisement_AdvertisementProto_fieldAccessorTable.ensureFieldAccessorsInitialized(AdvertisementProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAdId(String str) {
                Objects.requireNonNull(str);
                this.adId_ = str;
                onChanged();
                return this;
            }

            public Builder setAdIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.adId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setAdPrice(long j10) {
                this.adPrice_ = j10;
                onChanged();
                return this;
            }

            public Builder setAdSource(String str) {
                Objects.requireNonNull(str);
                this.adSource_ = str;
                onChanged();
                return this;
            }

            public Builder setAdSourceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.adSource_ = byteString;
                onChanged();
                return this;
            }

            public Builder setAdType(String str) {
                Objects.requireNonNull(str);
                this.adType_ = str;
                onChanged();
                return this;
            }

            public Builder setAdTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.adType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setCodeId(String str) {
                Objects.requireNonNull(str);
                this.codeId_ = str;
                onChanged();
                return this;
            }

            public Builder setCodeIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.codeId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setContent(String str) {
                Objects.requireNonNull(str);
                this.content_ = str;
                onChanged();
                return this;
            }

            public Builder setContentBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.content_ = byteString;
                onChanged();
                return this;
            }

            public Builder setCostTime(long j10) {
                this.costTime_ = j10;
                onChanged();
                return this;
            }

            public Builder setEndType(String str) {
                Objects.requireNonNull(str);
                this.endType_ = str;
                onChanged();
                return this;
            }

            public Builder setEndTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.endType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setEvent(Event event) {
                Objects.requireNonNull(event);
                this.event_ = event.getNumber();
                onChanged();
                return this;
            }

            public Builder setEventValue(int i10) {
                this.event_ = i10;
                onChanged();
                return this;
            }

            public Builder setId(String str) {
                Objects.requireNonNull(str);
                this.id_ = str;
                onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.id_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIndex(int i10) {
                this.index_ = i10;
                onChanged();
                return this;
            }

            public Builder setIsCache(boolean z10) {
                this.isCache_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsCompliance(boolean z10) {
                this.isCompliance_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsFull(boolean z10) {
                this.isFull_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsSuccess(boolean z10) {
                this.isSuccess_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsTrue(boolean z10) {
                this.isTrue_ = z10;
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

            public Builder setNum(int i10) {
                this.num_ = i10;
                onChanged();
                return this;
            }

            public Builder setPosition(String str) {
                Objects.requireNonNull(str);
                this.position_ = str;
                onChanged();
                return this;
            }

            public Builder setPositionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.position_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPostId(String str) {
                Objects.requireNonNull(str);
                this.postId_ = str;
                onChanged();
                return this;
            }

            public Builder setPostIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.postId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setReason(String str) {
                Objects.requireNonNull(str);
                this.reason_ = str;
                onChanged();
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.reason_ = byteString;
                onChanged();
                return this;
            }

            public Builder setReqId(String str) {
                Objects.requireNonNull(str);
                this.reqId_ = str;
                onChanged();
                return this;
            }

            public Builder setReqIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.reqId_ = byteString;
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

            public Builder setRequestTimes(int i10) {
                this.requestTimes_ = i10;
                onChanged();
                return this;
            }

            public Builder setRequestType(String str) {
                Objects.requireNonNull(str);
                this.requestType_ = str;
                onChanged();
                return this;
            }

            public Builder setRequestTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.requestType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setShowTime(long j10) {
                this.showTime_ = j10;
                onChanged();
                return this;
            }

            public Builder setSuccessType(String str) {
                Objects.requireNonNull(str);
                this.successType_ = str;
                onChanged();
                return this;
            }

            public Builder setSuccessTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.successType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTime(float f10) {
                this.time_ = f10;
                onChanged();
                return this;
            }

            public Builder setType(String str) {
                Objects.requireNonNull(str);
                this.type_ = str;
                onChanged();
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.type_ = byteString;
                onChanged();
                return this;
            }

            public Builder setUrl(String str) {
                Objects.requireNonNull(str);
                this.url_ = str;
                onChanged();
                return this;
            }

            public Builder setUrlBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.url_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AdvertisementProto build() {
                AdvertisementProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AdvertisementProto buildPartial() {
                AdvertisementProto advertisementProto = new AdvertisementProto(this);
                advertisementProto.event_ = this.event_;
                advertisementProto.type_ = this.type_;
                advertisementProto.id_ = this.id_;
                advertisementProto.isTrue_ = this.isTrue_;
                advertisementProto.reason_ = this.reason_;
                advertisementProto.time_ = this.time_;
                advertisementProto.content_ = this.content_;
                advertisementProto.url_ = this.url_;
                advertisementProto.postId_ = this.postId_;
                advertisementProto.name_ = this.name_;
                advertisementProto.position_ = this.position_;
                advertisementProto.index_ = this.index_;
                advertisementProto.adId_ = this.adId_;
                advertisementProto.isFull_ = this.isFull_;
                advertisementProto.num_ = this.num_;
                advertisementProto.reqId_ = this.reqId_;
                advertisementProto.requestId_ = this.requestId_;
                advertisementProto.requestTimes_ = this.requestTimes_;
                advertisementProto.adSource_ = this.adSource_;
                advertisementProto.codeId_ = this.codeId_;
                advertisementProto.adType_ = this.adType_;
                advertisementProto.requestType_ = this.requestType_;
                advertisementProto.isSuccess_ = this.isSuccess_;
                advertisementProto.successType_ = this.successType_;
                advertisementProto.costTime_ = this.costTime_;
                advertisementProto.isCompliance_ = this.isCompliance_;
                advertisementProto.adPrice_ = this.adPrice_;
                advertisementProto.showTime_ = this.showTime_;
                advertisementProto.endType_ = this.endType_;
                advertisementProto.isCache_ = this.isCache_;
                onBuilt();
                return advertisementProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AdvertisementProto getDefaultInstanceForType() {
                return AdvertisementProto.getDefaultInstance();
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
                this.event_ = 0;
                this.type_ = "";
                this.id_ = "";
                this.isTrue_ = false;
                this.reason_ = "";
                this.time_ = 0.0f;
                this.content_ = "";
                this.url_ = "";
                this.postId_ = "";
                this.name_ = "";
                this.position_ = "";
                this.index_ = 0;
                this.adId_ = "";
                this.isFull_ = false;
                this.num_ = 0;
                this.reqId_ = "";
                this.requestId_ = "";
                this.requestTimes_ = 0;
                this.adSource_ = "";
                this.codeId_ = "";
                this.adType_ = "";
                this.requestType_ = "";
                this.isSuccess_ = false;
                this.successType_ = "";
                this.costTime_ = 0L;
                this.isCompliance_ = false;
                this.adPrice_ = 0L;
                this.showTime_ = 0L;
                this.endType_ = "";
                this.isCache_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof AdvertisementProto) {
                    return mergeFrom((AdvertisementProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(AdvertisementProto advertisementProto) {
                if (advertisementProto == AdvertisementProto.getDefaultInstance()) {
                    return this;
                }
                if (advertisementProto.event_ != 0) {
                    setEventValue(advertisementProto.getEventValue());
                }
                if (!advertisementProto.getType().isEmpty()) {
                    this.type_ = advertisementProto.type_;
                    onChanged();
                }
                if (!advertisementProto.getId().isEmpty()) {
                    this.id_ = advertisementProto.id_;
                    onChanged();
                }
                if (advertisementProto.getIsTrue()) {
                    setIsTrue(advertisementProto.getIsTrue());
                }
                if (!advertisementProto.getReason().isEmpty()) {
                    this.reason_ = advertisementProto.reason_;
                    onChanged();
                }
                if (advertisementProto.getTime() != 0.0f) {
                    setTime(advertisementProto.getTime());
                }
                if (!advertisementProto.getContent().isEmpty()) {
                    this.content_ = advertisementProto.content_;
                    onChanged();
                }
                if (!advertisementProto.getUrl().isEmpty()) {
                    this.url_ = advertisementProto.url_;
                    onChanged();
                }
                if (!advertisementProto.getPostId().isEmpty()) {
                    this.postId_ = advertisementProto.postId_;
                    onChanged();
                }
                if (!advertisementProto.getName().isEmpty()) {
                    this.name_ = advertisementProto.name_;
                    onChanged();
                }
                if (!advertisementProto.getPosition().isEmpty()) {
                    this.position_ = advertisementProto.position_;
                    onChanged();
                }
                if (advertisementProto.getIndex() != 0) {
                    setIndex(advertisementProto.getIndex());
                }
                if (!advertisementProto.getAdId().isEmpty()) {
                    this.adId_ = advertisementProto.adId_;
                    onChanged();
                }
                if (advertisementProto.getIsFull()) {
                    setIsFull(advertisementProto.getIsFull());
                }
                if (advertisementProto.getNum() != 0) {
                    setNum(advertisementProto.getNum());
                }
                if (!advertisementProto.getReqId().isEmpty()) {
                    this.reqId_ = advertisementProto.reqId_;
                    onChanged();
                }
                if (!advertisementProto.getRequestId().isEmpty()) {
                    this.requestId_ = advertisementProto.requestId_;
                    onChanged();
                }
                if (advertisementProto.getRequestTimes() != 0) {
                    setRequestTimes(advertisementProto.getRequestTimes());
                }
                if (!advertisementProto.getAdSource().isEmpty()) {
                    this.adSource_ = advertisementProto.adSource_;
                    onChanged();
                }
                if (!advertisementProto.getCodeId().isEmpty()) {
                    this.codeId_ = advertisementProto.codeId_;
                    onChanged();
                }
                if (!advertisementProto.getAdType().isEmpty()) {
                    this.adType_ = advertisementProto.adType_;
                    onChanged();
                }
                if (!advertisementProto.getRequestType().isEmpty()) {
                    this.requestType_ = advertisementProto.requestType_;
                    onChanged();
                }
                if (advertisementProto.getIsSuccess()) {
                    setIsSuccess(advertisementProto.getIsSuccess());
                }
                if (!advertisementProto.getSuccessType().isEmpty()) {
                    this.successType_ = advertisementProto.successType_;
                    onChanged();
                }
                if (advertisementProto.getCostTime() != 0) {
                    setCostTime(advertisementProto.getCostTime());
                }
                if (advertisementProto.getIsCompliance()) {
                    setIsCompliance(advertisementProto.getIsCompliance());
                }
                if (advertisementProto.getAdPrice() != 0) {
                    setAdPrice(advertisementProto.getAdPrice());
                }
                if (advertisementProto.getShowTime() != 0) {
                    setShowTime(advertisementProto.getShowTime());
                }
                if (!advertisementProto.getEndType().isEmpty()) {
                    this.endType_ = advertisementProto.endType_;
                    onChanged();
                }
                if (advertisementProto.getIsCache()) {
                    setIsCache(advertisementProto.getIsCache());
                }
                mergeUnknownFields(advertisementProto.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.type_ = "";
                this.id_ = "";
                this.reason_ = "";
                this.content_ = "";
                this.url_ = "";
                this.postId_ = "";
                this.name_ = "";
                this.position_ = "";
                this.adId_ = "";
                this.reqId_ = "";
                this.requestId_ = "";
                this.adSource_ = "";
                this.codeId_ = "";
                this.adType_ = "";
                this.requestType_ = "";
                this.successType_ = "";
                this.endType_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProto.W()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.client.advertisement.AdvertisementProtos$AdvertisementProto r3 = (com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProto) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.client.advertisement.AdvertisementProtos$AdvertisementProto r4 = (com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProto) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.client.advertisement.AdvertisementProtos.AdvertisementProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.client.advertisement.AdvertisementProtos$AdvertisementProto$Builder");
            }
        }

        public static Builder newBuilder(AdvertisementProto advertisementProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(advertisementProto);
        }

        public static AdvertisementProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private AdvertisementProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.type_ = "";
            this.id_ = "";
            this.reason_ = "";
            this.content_ = "";
            this.url_ = "";
            this.postId_ = "";
            this.name_ = "";
            this.position_ = "";
            this.adId_ = "";
            this.reqId_ = "";
            this.requestId_ = "";
            this.adSource_ = "";
            this.codeId_ = "";
            this.adType_ = "";
            this.requestType_ = "";
            this.successType_ = "";
            this.endType_ = "";
        }

        public static AdvertisementProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdvertisementProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdvertisementProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AdvertisementProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static AdvertisementProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static AdvertisementProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static AdvertisementProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AdvertisementProto parseFrom(InputStream inputStream) throws IOException {
            return (AdvertisementProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AdvertisementProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdvertisementProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdvertisementProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AdvertisementProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AdvertisementProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdvertisementProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
        private AdvertisementProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z10 = true;
                                case 8:
                                    this.event_ = codedInputStream.readEnum();
                                case 18:
                                    this.type_ = codedInputStream.readStringRequireUtf8();
                                case 26:
                                    this.id_ = codedInputStream.readStringRequireUtf8();
                                case 32:
                                    this.isTrue_ = codedInputStream.readBool();
                                case 42:
                                    this.reason_ = codedInputStream.readStringRequireUtf8();
                                case 53:
                                    this.time_ = codedInputStream.readFloat();
                                case 58:
                                    this.content_ = codedInputStream.readStringRequireUtf8();
                                case 66:
                                    this.url_ = codedInputStream.readStringRequireUtf8();
                                case 74:
                                    this.postId_ = codedInputStream.readStringRequireUtf8();
                                case 82:
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                case 90:
                                    this.position_ = codedInputStream.readStringRequireUtf8();
                                case 96:
                                    this.index_ = codedInputStream.readInt32();
                                case 106:
                                    this.adId_ = codedInputStream.readStringRequireUtf8();
                                case 112:
                                    this.isFull_ = codedInputStream.readBool();
                                case 120:
                                    this.num_ = codedInputStream.readInt32();
                                case 130:
                                    this.reqId_ = codedInputStream.readStringRequireUtf8();
                                case 138:
                                    this.requestId_ = codedInputStream.readStringRequireUtf8();
                                case 144:
                                    this.requestTimes_ = codedInputStream.readInt32();
                                case 154:
                                    this.adSource_ = codedInputStream.readStringRequireUtf8();
                                case 162:
                                    this.codeId_ = codedInputStream.readStringRequireUtf8();
                                case 170:
                                    this.adType_ = codedInputStream.readStringRequireUtf8();
                                case 178:
                                    this.requestType_ = codedInputStream.readStringRequireUtf8();
                                case 184:
                                    this.isSuccess_ = codedInputStream.readBool();
                                case 194:
                                    this.successType_ = codedInputStream.readStringRequireUtf8();
                                case 200:
                                    this.costTime_ = codedInputStream.readInt64();
                                case 208:
                                    this.isCompliance_ = codedInputStream.readBool();
                                case 216:
                                    this.adPrice_ = codedInputStream.readInt64();
                                case 224:
                                    this.showTime_ = codedInputStream.readInt64();
                                case 234:
                                    this.endType_ = codedInputStream.readStringRequireUtf8();
                                case 240:
                                    this.isCache_ = codedInputStream.readBool();
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        z10 = true;
                                    }
                            }
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
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface AdvertisementProtoOrBuilder extends MessageOrBuilder {
        String getAdId();

        ByteString getAdIdBytes();

        long getAdPrice();

        String getAdSource();

        ByteString getAdSourceBytes();

        String getAdType();

        ByteString getAdTypeBytes();

        String getCodeId();

        ByteString getCodeIdBytes();

        String getContent();

        ByteString getContentBytes();

        long getCostTime();

        String getEndType();

        ByteString getEndTypeBytes();

        Event getEvent();

        int getEventValue();

        String getId();

        ByteString getIdBytes();

        int getIndex();

        boolean getIsCache();

        boolean getIsCompliance();

        boolean getIsFull();

        boolean getIsSuccess();

        boolean getIsTrue();

        String getName();

        ByteString getNameBytes();

        int getNum();

        String getPosition();

        ByteString getPositionBytes();

        String getPostId();

        ByteString getPostIdBytes();

        String getReason();

        ByteString getReasonBytes();

        String getReqId();

        ByteString getReqIdBytes();

        String getRequestId();

        ByteString getRequestIdBytes();

        int getRequestTimes();

        String getRequestType();

        ByteString getRequestTypeBytes();

        long getShowTime();

        String getSuccessType();

        ByteString getSuccessTypeBytes();

        float getTime();

        String getType();

        ByteString getTypeBytes();

        String getUrl();

        ByteString getUrlBytes();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        OPEN_APP_AD_SHOW(1),
        OPEN_APP_AD_CLICK(2),
        OPEN_APP_AD_SKIP(3),
        OPEN_APP_AD_SHOW_FINISH(4),
        SPONSOR_POST_SHOW(5),
        SPONSOR_POST_CLICK(6),
        LIVE_BANNER_SHOW(7),
        LIVE_BANNER_CLICK(8),
        MSG_AD_SHOW(9),
        MSG_AD_CLICK(10),
        MSG_AD_CLOSE(11),
        HORN_SHOW(12),
        CARD_AD_SHOW(13),
        CARD_AD_CLICK(14),
        HORN_CLICK(15),
        HIGHLIGHT_MOMENT(16),
        OPEN_APP_NO_AD(17),
        AD_REQUEST(18),
        AD_RETURN(19),
        AD_SHOW(20),
        AD_CLICK(21),
        AD_END(22),
        AD_TIME_SPENT_MONITOR(23),
        UNRECOGNIZED(-1);

        public static final int AD_CLICK_VALUE = 21;
        public static final int AD_END_VALUE = 22;
        public static final int AD_REQUEST_VALUE = 18;
        public static final int AD_RETURN_VALUE = 19;
        public static final int AD_SHOW_VALUE = 20;
        public static final int AD_TIME_SPENT_MONITOR_VALUE = 23;
        public static final int CARD_AD_CLICK_VALUE = 14;
        public static final int CARD_AD_SHOW_VALUE = 13;
        public static final int HIGHLIGHT_MOMENT_VALUE = 16;
        public static final int HORN_CLICK_VALUE = 15;
        public static final int HORN_SHOW_VALUE = 12;
        public static final int LIVE_BANNER_CLICK_VALUE = 8;
        public static final int LIVE_BANNER_SHOW_VALUE = 7;
        public static final int MSG_AD_CLICK_VALUE = 10;
        public static final int MSG_AD_CLOSE_VALUE = 11;
        public static final int MSG_AD_SHOW_VALUE = 9;
        public static final int OPEN_APP_AD_CLICK_VALUE = 2;
        public static final int OPEN_APP_AD_SHOW_FINISH_VALUE = 4;
        public static final int OPEN_APP_AD_SHOW_VALUE = 1;
        public static final int OPEN_APP_AD_SKIP_VALUE = 3;
        public static final int OPEN_APP_NO_AD_VALUE = 17;
        public static final int SPONSOR_POST_CLICK_VALUE = 6;
        public static final int SPONSOR_POST_SHOW_VALUE = 5;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.irisdt.client.advertisement.AdvertisementProtos.Event.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Event findValueByNumber(int i10) {
                return Event.forNumber(i10);
            }
        };
        private static final Event[] VALUES = values();

        Event(int i10) {
            this.value = i10;
        }

        public static Event forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_EVENT;
                case 1:
                    return OPEN_APP_AD_SHOW;
                case 2:
                    return OPEN_APP_AD_CLICK;
                case 3:
                    return OPEN_APP_AD_SKIP;
                case 4:
                    return OPEN_APP_AD_SHOW_FINISH;
                case 5:
                    return SPONSOR_POST_SHOW;
                case 6:
                    return SPONSOR_POST_CLICK;
                case 7:
                    return LIVE_BANNER_SHOW;
                case 8:
                    return LIVE_BANNER_CLICK;
                case 9:
                    return MSG_AD_SHOW;
                case 10:
                    return MSG_AD_CLICK;
                case 11:
                    return MSG_AD_CLOSE;
                case 12:
                    return HORN_SHOW;
                case 13:
                    return CARD_AD_SHOW;
                case 14:
                    return CARD_AD_CLICK;
                case 15:
                    return HORN_CLICK;
                case 16:
                    return HIGHLIGHT_MOMENT;
                case 17:
                    return OPEN_APP_NO_AD;
                case 18:
                    return AD_REQUEST;
                case 19:
                    return AD_RETURN;
                case 20:
                    return AD_SHOW;
                case 21:
                    return AD_CLICK;
                case 22:
                    return AD_END;
                case 23:
                    return AD_TIME_SPENT_MONITOR;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return AdvertisementProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Event> internalGetValueMap() {
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
        public static Event valueOf(int i10) {
            return forNumber(i10);
        }

        public static Event valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
        internal_static_com_irisdt_client_advertisement_AdvertisementProto_descriptor = descriptor2;
        internal_static_com_irisdt_client_advertisement_AdvertisementProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{com.huawei.hianalytics.core.storage.Event.TAG, "Type", "Id", "IsTrue", "Reason", "Time", "Content", "Url", "PostId", "Name", "Position", "Index", "AdId", "IsFull", "Num", "ReqId", "RequestId", "RequestTimes", "AdSource", "CodeId", "AdType", "RequestType", "IsSuccess", "SuccessType", "CostTime", "IsCompliance", "AdPrice", "ShowTime", "EndType", "IsCache"});
    }

    private AdvertisementProtos() {
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
