package com.google.logging.type;

import com.android.internal.logging.nano.MetricsProto;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class HttpRequest extends GeneratedMessageV3 implements HttpRequestOrBuilder {
    public static final int CACHE_FILL_BYTES_FIELD_NUMBER = 12;
    public static final int CACHE_HIT_FIELD_NUMBER = 9;
    public static final int CACHE_LOOKUP_FIELD_NUMBER = 11;
    public static final int CACHE_VALIDATED_WITH_ORIGIN_SERVER_FIELD_NUMBER = 10;
    public static final int LATENCY_FIELD_NUMBER = 14;
    public static final int PROTOCOL_FIELD_NUMBER = 15;
    public static final int REFERER_FIELD_NUMBER = 8;
    public static final int REMOTE_IP_FIELD_NUMBER = 7;
    public static final int REQUEST_METHOD_FIELD_NUMBER = 1;
    public static final int REQUEST_SIZE_FIELD_NUMBER = 3;
    public static final int REQUEST_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_SIZE_FIELD_NUMBER = 5;
    public static final int SERVER_IP_FIELD_NUMBER = 13;
    public static final int STATUS_FIELD_NUMBER = 4;
    public static final int USER_AGENT_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private long cacheFillBytes_;
    private boolean cacheHit_;
    private boolean cacheLookup_;
    private boolean cacheValidatedWithOriginServer_;
    private Duration latency_;
    private byte memoizedIsInitialized;
    private volatile Object protocol_;
    private volatile Object referer_;
    private volatile Object remoteIp_;
    private volatile Object requestMethod_;
    private long requestSize_;
    private volatile Object requestUrl_;
    private long responseSize_;
    private volatile Object serverIp_;
    private int status_;
    private volatile Object userAgent_;
    private static final HttpRequest DEFAULT_INSTANCE = new HttpRequest();
    private static final Parser<HttpRequest> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HttpRequestOrBuilder {
        private long cacheFillBytes_;
        private boolean cacheHit_;
        private boolean cacheLookup_;
        private boolean cacheValidatedWithOriginServer_;
        private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> latencyBuilder_;
        private Duration latency_;
        private Object protocol_;
        private Object referer_;
        private Object remoteIp_;
        private Object requestMethod_;
        private long requestSize_;
        private Object requestUrl_;
        private long responseSize_;
        private Object serverIp_;
        private int status_;
        private Object userAgent_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return g8.a.f49417a;
        }

        private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getLatencyFieldBuilder() {
            if (this.latencyBuilder_ == null) {
                this.latencyBuilder_ = new SingleFieldBuilderV3<>(getLatency(), getParentForChildren(), isClean());
                this.latency_ = null;
            }
            return this.latencyBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearCacheFillBytes() {
            this.cacheFillBytes_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearCacheHit() {
            this.cacheHit_ = false;
            onChanged();
            return this;
        }

        public Builder clearCacheLookup() {
            this.cacheLookup_ = false;
            onChanged();
            return this;
        }

        public Builder clearCacheValidatedWithOriginServer() {
            this.cacheValidatedWithOriginServer_ = false;
            onChanged();
            return this;
        }

        public Builder clearLatency() {
            if (this.latencyBuilder_ == null) {
                this.latency_ = null;
                onChanged();
            } else {
                this.latency_ = null;
                this.latencyBuilder_ = null;
            }
            return this;
        }

        public Builder clearProtocol() {
            this.protocol_ = HttpRequest.getDefaultInstance().getProtocol();
            onChanged();
            return this;
        }

        public Builder clearReferer() {
            this.referer_ = HttpRequest.getDefaultInstance().getReferer();
            onChanged();
            return this;
        }

        public Builder clearRemoteIp() {
            this.remoteIp_ = HttpRequest.getDefaultInstance().getRemoteIp();
            onChanged();
            return this;
        }

        public Builder clearRequestMethod() {
            this.requestMethod_ = HttpRequest.getDefaultInstance().getRequestMethod();
            onChanged();
            return this;
        }

        public Builder clearRequestSize() {
            this.requestSize_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearRequestUrl() {
            this.requestUrl_ = HttpRequest.getDefaultInstance().getRequestUrl();
            onChanged();
            return this;
        }

        public Builder clearResponseSize() {
            this.responseSize_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearServerIp() {
            this.serverIp_ = HttpRequest.getDefaultInstance().getServerIp();
            onChanged();
            return this;
        }

        public Builder clearStatus() {
            this.status_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUserAgent() {
            this.userAgent_ = HttpRequest.getDefaultInstance().getUserAgent();
            onChanged();
            return this;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public long getCacheFillBytes() {
            return this.cacheFillBytes_;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean getCacheHit() {
            return this.cacheHit_;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean getCacheLookup() {
            return this.cacheLookup_;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean getCacheValidatedWithOriginServer() {
            return this.cacheValidatedWithOriginServer_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return g8.a.f49417a;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public Duration getLatency() {
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
            if (singleFieldBuilderV3 == null) {
                Duration duration = this.latency_;
                return duration == null ? Duration.getDefaultInstance() : duration;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Duration.Builder getLatencyBuilder() {
            onChanged();
            return getLatencyFieldBuilder().getBuilder();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public DurationOrBuilder getLatencyOrBuilder() {
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Duration duration = this.latency_;
            return duration == null ? Duration.getDefaultInstance() : duration;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getProtocol() {
            Object obj = this.protocol_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.protocol_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getProtocolBytes() {
            Object obj = this.protocol_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.protocol_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getReferer() {
            Object obj = this.referer_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.referer_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRefererBytes() {
            Object obj = this.referer_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.referer_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getRemoteIp() {
            Object obj = this.remoteIp_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.remoteIp_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRemoteIpBytes() {
            Object obj = this.remoteIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.remoteIp_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getRequestMethod() {
            Object obj = this.requestMethod_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.requestMethod_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRequestMethodBytes() {
            Object obj = this.requestMethod_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestMethod_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public long getRequestSize() {
            return this.requestSize_;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getRequestUrl() {
            Object obj = this.requestUrl_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.requestUrl_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRequestUrlBytes() {
            Object obj = this.requestUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public long getResponseSize() {
            return this.responseSize_;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getServerIp() {
            Object obj = this.serverIp_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.serverIp_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getServerIpBytes() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serverIp_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getUserAgent() {
            Object obj = this.userAgent_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.userAgent_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getUserAgentBytes() {
            Object obj = this.userAgent_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userAgent_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean hasLatency() {
            return (this.latencyBuilder_ == null && this.latency_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return g8.a.f49418b.ensureFieldAccessorsInitialized(HttpRequest.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeLatency(Duration duration) {
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
            if (singleFieldBuilderV3 == null) {
                Duration duration2 = this.latency_;
                if (duration2 != null) {
                    this.latency_ = Duration.newBuilder(duration2).mergeFrom(duration).buildPartial();
                } else {
                    this.latency_ = duration;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(duration);
            }
            return this;
        }

        public Builder setCacheFillBytes(long j10) {
            this.cacheFillBytes_ = j10;
            onChanged();
            return this;
        }

        public Builder setCacheHit(boolean z10) {
            this.cacheHit_ = z10;
            onChanged();
            return this;
        }

        public Builder setCacheLookup(boolean z10) {
            this.cacheLookup_ = z10;
            onChanged();
            return this;
        }

        public Builder setCacheValidatedWithOriginServer(boolean z10) {
            this.cacheValidatedWithOriginServer_ = z10;
            onChanged();
            return this;
        }

        public Builder setLatency(Duration duration) {
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(duration);
                this.latency_ = duration;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(duration);
            }
            return this;
        }

        public Builder setProtocol(String str) {
            Objects.requireNonNull(str);
            this.protocol_ = str;
            onChanged();
            return this;
        }

        public Builder setProtocolBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.protocol_ = byteString;
            onChanged();
            return this;
        }

        public Builder setReferer(String str) {
            Objects.requireNonNull(str);
            this.referer_ = str;
            onChanged();
            return this;
        }

        public Builder setRefererBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.referer_ = byteString;
            onChanged();
            return this;
        }

        public Builder setRemoteIp(String str) {
            Objects.requireNonNull(str);
            this.remoteIp_ = str;
            onChanged();
            return this;
        }

        public Builder setRemoteIpBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.remoteIp_ = byteString;
            onChanged();
            return this;
        }

        public Builder setRequestMethod(String str) {
            Objects.requireNonNull(str);
            this.requestMethod_ = str;
            onChanged();
            return this;
        }

        public Builder setRequestMethodBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.requestMethod_ = byteString;
            onChanged();
            return this;
        }

        public Builder setRequestSize(long j10) {
            this.requestSize_ = j10;
            onChanged();
            return this;
        }

        public Builder setRequestUrl(String str) {
            Objects.requireNonNull(str);
            this.requestUrl_ = str;
            onChanged();
            return this;
        }

        public Builder setRequestUrlBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.requestUrl_ = byteString;
            onChanged();
            return this;
        }

        public Builder setResponseSize(long j10) {
            this.responseSize_ = j10;
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

        public Builder setStatus(int i10) {
            this.status_ = i10;
            onChanged();
            return this;
        }

        public Builder setUserAgent(String str) {
            Objects.requireNonNull(str);
            this.userAgent_ = str;
            onChanged();
            return this;
        }

        public Builder setUserAgentBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userAgent_ = byteString;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.requestMethod_ = "";
            this.requestUrl_ = "";
            this.userAgent_ = "";
            this.remoteIp_ = "";
            this.serverIp_ = "";
            this.referer_ = "";
            this.protocol_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public HttpRequest build() {
            HttpRequest buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public HttpRequest buildPartial() {
            HttpRequest httpRequest = new HttpRequest(this, (a) null);
            httpRequest.requestMethod_ = this.requestMethod_;
            httpRequest.requestUrl_ = this.requestUrl_;
            httpRequest.requestSize_ = this.requestSize_;
            httpRequest.status_ = this.status_;
            httpRequest.responseSize_ = this.responseSize_;
            httpRequest.userAgent_ = this.userAgent_;
            httpRequest.remoteIp_ = this.remoteIp_;
            httpRequest.serverIp_ = this.serverIp_;
            httpRequest.referer_ = this.referer_;
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
            if (singleFieldBuilderV3 == null) {
                httpRequest.latency_ = this.latency_;
            } else {
                httpRequest.latency_ = singleFieldBuilderV3.build();
            }
            httpRequest.cacheLookup_ = this.cacheLookup_;
            httpRequest.cacheHit_ = this.cacheHit_;
            httpRequest.cacheValidatedWithOriginServer_ = this.cacheValidatedWithOriginServer_;
            httpRequest.cacheFillBytes_ = this.cacheFillBytes_;
            httpRequest.protocol_ = this.protocol_;
            onBuilt();
            return httpRequest;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HttpRequest getDefaultInstanceForType() {
            return HttpRequest.getDefaultInstance();
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
            this.requestMethod_ = "";
            this.requestUrl_ = "";
            this.requestSize_ = 0L;
            this.status_ = 0;
            this.responseSize_ = 0L;
            this.userAgent_ = "";
            this.remoteIp_ = "";
            this.serverIp_ = "";
            this.referer_ = "";
            if (this.latencyBuilder_ == null) {
                this.latency_ = null;
            } else {
                this.latency_ = null;
                this.latencyBuilder_ = null;
            }
            this.cacheLookup_ = false;
            this.cacheHit_ = false;
            this.cacheValidatedWithOriginServer_ = false;
            this.cacheFillBytes_ = 0L;
            this.protocol_ = "";
            return this;
        }

        public Builder setLatency(Duration.Builder builder) {
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.latency_ = builder.build();
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
            if (message instanceof HttpRequest) {
                return mergeFrom((HttpRequest) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(HttpRequest httpRequest) {
            if (httpRequest == HttpRequest.getDefaultInstance()) {
                return this;
            }
            if (!httpRequest.getRequestMethod().isEmpty()) {
                this.requestMethod_ = httpRequest.requestMethod_;
                onChanged();
            }
            if (!httpRequest.getRequestUrl().isEmpty()) {
                this.requestUrl_ = httpRequest.requestUrl_;
                onChanged();
            }
            if (httpRequest.getRequestSize() != 0) {
                setRequestSize(httpRequest.getRequestSize());
            }
            if (httpRequest.getStatus() != 0) {
                setStatus(httpRequest.getStatus());
            }
            if (httpRequest.getResponseSize() != 0) {
                setResponseSize(httpRequest.getResponseSize());
            }
            if (!httpRequest.getUserAgent().isEmpty()) {
                this.userAgent_ = httpRequest.userAgent_;
                onChanged();
            }
            if (!httpRequest.getRemoteIp().isEmpty()) {
                this.remoteIp_ = httpRequest.remoteIp_;
                onChanged();
            }
            if (!httpRequest.getServerIp().isEmpty()) {
                this.serverIp_ = httpRequest.serverIp_;
                onChanged();
            }
            if (!httpRequest.getReferer().isEmpty()) {
                this.referer_ = httpRequest.referer_;
                onChanged();
            }
            if (httpRequest.hasLatency()) {
                mergeLatency(httpRequest.getLatency());
            }
            if (httpRequest.getCacheLookup()) {
                setCacheLookup(httpRequest.getCacheLookup());
            }
            if (httpRequest.getCacheHit()) {
                setCacheHit(httpRequest.getCacheHit());
            }
            if (httpRequest.getCacheValidatedWithOriginServer()) {
                setCacheValidatedWithOriginServer(httpRequest.getCacheValidatedWithOriginServer());
            }
            if (httpRequest.getCacheFillBytes() != 0) {
                setCacheFillBytes(httpRequest.getCacheFillBytes());
            }
            if (!httpRequest.getProtocol().isEmpty()) {
                this.protocol_ = httpRequest.protocol_;
                onChanged();
            }
            mergeUnknownFields(httpRequest.unknownFields);
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.requestMethod_ = "";
            this.requestUrl_ = "";
            this.userAgent_ = "";
            this.remoteIp_ = "";
            this.serverIp_ = "";
            this.referer_ = "";
            this.protocol_ = "";
            maybeForceBuilderInitialization();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.logging.type.HttpRequest.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.logging.type.HttpRequest.access$2000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.logging.type.HttpRequest r3 = (com.google.logging.type.HttpRequest) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.logging.type.HttpRequest r4 = (com.google.logging.type.HttpRequest) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.logging.type.HttpRequest.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.logging.type.HttpRequest$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<HttpRequest> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HttpRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new HttpRequest(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ HttpRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static HttpRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return g8.a.f49417a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static HttpRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HttpRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static HttpRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<HttpRequest> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HttpRequest)) {
            return super.equals(obj);
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        if (getRequestMethod().equals(httpRequest.getRequestMethod()) && getRequestUrl().equals(httpRequest.getRequestUrl()) && getRequestSize() == httpRequest.getRequestSize() && getStatus() == httpRequest.getStatus() && getResponseSize() == httpRequest.getResponseSize() && getUserAgent().equals(httpRequest.getUserAgent()) && getRemoteIp().equals(httpRequest.getRemoteIp()) && getServerIp().equals(httpRequest.getServerIp()) && getReferer().equals(httpRequest.getReferer()) && hasLatency() == httpRequest.hasLatency()) {
            return (!hasLatency() || getLatency().equals(httpRequest.getLatency())) && getCacheLookup() == httpRequest.getCacheLookup() && getCacheHit() == httpRequest.getCacheHit() && getCacheValidatedWithOriginServer() == httpRequest.getCacheValidatedWithOriginServer() && getCacheFillBytes() == httpRequest.getCacheFillBytes() && getProtocol().equals(httpRequest.getProtocol()) && this.unknownFields.equals(httpRequest.unknownFields);
        }
        return false;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public long getCacheFillBytes() {
        return this.cacheFillBytes_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean getCacheHit() {
        return this.cacheHit_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean getCacheLookup() {
        return this.cacheLookup_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean getCacheValidatedWithOriginServer() {
        return this.cacheValidatedWithOriginServer_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public Duration getLatency() {
        Duration duration = this.latency_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public DurationOrBuilder getLatencyOrBuilder() {
        return getLatency();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<HttpRequest> getParserForType() {
        return PARSER;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getProtocol() {
        Object obj = this.protocol_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.protocol_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getProtocolBytes() {
        Object obj = this.protocol_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.protocol_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getReferer() {
        Object obj = this.referer_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.referer_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRefererBytes() {
        Object obj = this.referer_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.referer_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getRemoteIp() {
        Object obj = this.remoteIp_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.remoteIp_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRemoteIpBytes() {
        Object obj = this.remoteIp_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.remoteIp_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getRequestMethod() {
        Object obj = this.requestMethod_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.requestMethod_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRequestMethodBytes() {
        Object obj = this.requestMethod_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.requestMethod_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public long getRequestSize() {
        return this.requestSize_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getRequestUrl() {
        Object obj = this.requestUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.requestUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRequestUrlBytes() {
        Object obj = this.requestUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.requestUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public long getResponseSize() {
        return this.responseSize_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = GeneratedMessageV3.isStringEmpty(this.requestMethod_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.requestMethod_);
        if (!GeneratedMessageV3.isStringEmpty(this.requestUrl_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.requestUrl_);
        }
        long j10 = this.requestSize_;
        if (j10 != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(3, j10);
        }
        int i11 = this.status_;
        if (i11 != 0) {
            computeStringSize += CodedOutputStream.computeInt32Size(4, i11);
        }
        long j11 = this.responseSize_;
        if (j11 != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(5, j11);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.userAgent_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(6, this.userAgent_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.remoteIp_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(7, this.remoteIp_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.referer_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(8, this.referer_);
        }
        boolean z10 = this.cacheHit_;
        if (z10) {
            computeStringSize += CodedOutputStream.computeBoolSize(9, z10);
        }
        boolean z11 = this.cacheValidatedWithOriginServer_;
        if (z11) {
            computeStringSize += CodedOutputStream.computeBoolSize(10, z11);
        }
        boolean z12 = this.cacheLookup_;
        if (z12) {
            computeStringSize += CodedOutputStream.computeBoolSize(11, z12);
        }
        long j12 = this.cacheFillBytes_;
        if (j12 != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(12, j12);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.serverIp_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(13, this.serverIp_);
        }
        if (this.latency_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(14, getLatency());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.protocol_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(15, this.protocol_);
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getServerIp() {
        Object obj = this.serverIp_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.serverIp_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getServerIpBytes() {
        Object obj = this.serverIp_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.serverIp_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public int getStatus() {
        return this.status_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getUserAgent() {
        Object obj = this.userAgent_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.userAgent_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getUserAgentBytes() {
        Object obj = this.userAgent_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.userAgent_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean hasLatency() {
        return this.latency_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getRequestMethod().hashCode()) * 37) + 2) * 53) + getRequestUrl().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getRequestSize())) * 37) + 4) * 53) + getStatus()) * 37) + 5) * 53) + Internal.hashLong(getResponseSize())) * 37) + 6) * 53) + getUserAgent().hashCode()) * 37) + 7) * 53) + getRemoteIp().hashCode()) * 37) + 13) * 53) + getServerIp().hashCode()) * 37) + 8) * 53) + getReferer().hashCode();
        if (hasLatency()) {
            hashCode = (((hashCode * 37) + 14) * 53) + getLatency().hashCode();
        }
        int hashBoolean = (((((((((((((((((((((hashCode * 37) + 11) * 53) + Internal.hashBoolean(getCacheLookup())) * 37) + 9) * 53) + Internal.hashBoolean(getCacheHit())) * 37) + 10) * 53) + Internal.hashBoolean(getCacheValidatedWithOriginServer())) * 37) + 12) * 53) + Internal.hashLong(getCacheFillBytes())) * 37) + 15) * 53) + getProtocol().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashBoolean;
        return hashBoolean;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return g8.a.f49418b.ensureFieldAccessorsInitialized(HttpRequest.class, Builder.class);
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
        return new HttpRequest();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.requestMethod_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.requestMethod_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.requestUrl_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.requestUrl_);
        }
        long j10 = this.requestSize_;
        if (j10 != 0) {
            codedOutputStream.writeInt64(3, j10);
        }
        int i10 = this.status_;
        if (i10 != 0) {
            codedOutputStream.writeInt32(4, i10);
        }
        long j11 = this.responseSize_;
        if (j11 != 0) {
            codedOutputStream.writeInt64(5, j11);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.userAgent_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.userAgent_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.remoteIp_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.remoteIp_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.referer_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.referer_);
        }
        boolean z10 = this.cacheHit_;
        if (z10) {
            codedOutputStream.writeBool(9, z10);
        }
        boolean z11 = this.cacheValidatedWithOriginServer_;
        if (z11) {
            codedOutputStream.writeBool(10, z11);
        }
        boolean z12 = this.cacheLookup_;
        if (z12) {
            codedOutputStream.writeBool(11, z12);
        }
        long j12 = this.cacheFillBytes_;
        if (j12 != 0) {
            codedOutputStream.writeInt64(12, j12);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.serverIp_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 13, this.serverIp_);
        }
        if (this.latency_ != null) {
            codedOutputStream.writeMessage(14, getLatency());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.protocol_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 15, this.protocol_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ HttpRequest(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(HttpRequest httpRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(httpRequest);
    }

    public static HttpRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private HttpRequest(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static HttpRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public HttpRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static HttpRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private HttpRequest() {
        this.memoizedIsInitialized = (byte) -1;
        this.requestMethod_ = "";
        this.requestUrl_ = "";
        this.userAgent_ = "";
        this.remoteIp_ = "";
        this.serverIp_ = "";
        this.referer_ = "";
        this.protocol_ = "";
    }

    public static HttpRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static HttpRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(InputStream inputStream) throws IOException {
        return (HttpRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static HttpRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HttpRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static HttpRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
    private HttpRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            case 10:
                                this.requestMethod_ = codedInputStream.readStringRequireUtf8();
                            case 18:
                                this.requestUrl_ = codedInputStream.readStringRequireUtf8();
                            case 24:
                                this.requestSize_ = codedInputStream.readInt64();
                            case 32:
                                this.status_ = codedInputStream.readInt32();
                            case 40:
                                this.responseSize_ = codedInputStream.readInt64();
                            case 50:
                                this.userAgent_ = codedInputStream.readStringRequireUtf8();
                            case 58:
                                this.remoteIp_ = codedInputStream.readStringRequireUtf8();
                            case 66:
                                this.referer_ = codedInputStream.readStringRequireUtf8();
                            case 72:
                                this.cacheHit_ = codedInputStream.readBool();
                            case 80:
                                this.cacheValidatedWithOriginServer_ = codedInputStream.readBool();
                            case 88:
                                this.cacheLookup_ = codedInputStream.readBool();
                            case 96:
                                this.cacheFillBytes_ = codedInputStream.readInt64();
                            case 106:
                                this.serverIp_ = codedInputStream.readStringRequireUtf8();
                            case 114:
                                Duration duration = this.latency_;
                                Duration.Builder builder = duration != null ? duration.toBuilder() : null;
                                Duration duration2 = (Duration) codedInputStream.readMessage(Duration.parser(), extensionRegistryLite);
                                this.latency_ = duration2;
                                if (builder != null) {
                                    builder.mergeFrom(duration2);
                                    this.latency_ = builder.buildPartial();
                                }
                            case 122:
                                this.protocol_ = codedInputStream.readStringRequireUtf8();
                            default:
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    z10 = true;
                                }
                        }
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
}
