package com.google.cloud.audit;

import com.android.internal.logging.nano.MetricsProto;
import com.google.cloud.audit.AuthenticationInfo;
import com.google.cloud.audit.AuthorizationInfo;
import com.google.cloud.audit.RequestMetadata;
import com.google.cloud.audit.ResourceLocation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.rpc.Status;
import com.google.rpc.StatusOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class AuditLog extends GeneratedMessageV3 implements AuditLogOrBuilder {
    public static final int AUTHENTICATION_INFO_FIELD_NUMBER = 3;
    public static final int AUTHORIZATION_INFO_FIELD_NUMBER = 9;
    public static final int METADATA_FIELD_NUMBER = 18;
    public static final int METHOD_NAME_FIELD_NUMBER = 8;
    public static final int NUM_RESPONSE_ITEMS_FIELD_NUMBER = 12;
    public static final int REQUEST_FIELD_NUMBER = 16;
    public static final int REQUEST_METADATA_FIELD_NUMBER = 4;
    public static final int RESOURCE_LOCATION_FIELD_NUMBER = 20;
    public static final int RESOURCE_NAME_FIELD_NUMBER = 11;
    public static final int RESOURCE_ORIGINAL_STATE_FIELD_NUMBER = 19;
    public static final int RESPONSE_FIELD_NUMBER = 17;
    public static final int SERVICE_DATA_FIELD_NUMBER = 15;
    public static final int SERVICE_NAME_FIELD_NUMBER = 7;
    public static final int STATUS_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private AuthenticationInfo authenticationInfo_;
    private List<AuthorizationInfo> authorizationInfo_;
    private byte memoizedIsInitialized;
    private Struct metadata_;
    private volatile Object methodName_;
    private long numResponseItems_;
    private RequestMetadata requestMetadata_;
    private Struct request_;
    private ResourceLocation resourceLocation_;
    private volatile Object resourceName_;
    private Struct resourceOriginalState_;
    private Struct response_;
    private Any serviceData_;
    private volatile Object serviceName_;
    private Status status_;
    private static final AuditLog DEFAULT_INSTANCE = new AuditLog();
    private static final Parser<AuditLog> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuditLogOrBuilder {
        private SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> authenticationInfoBuilder_;
        private AuthenticationInfo authenticationInfo_;
        private RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> authorizationInfoBuilder_;
        private List<AuthorizationInfo> authorizationInfo_;
        private int bitField0_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> metadataBuilder_;
        private Struct metadata_;
        private Object methodName_;
        private long numResponseItems_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> requestBuilder_;
        private SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> requestMetadataBuilder_;
        private RequestMetadata requestMetadata_;
        private Struct request_;
        private SingleFieldBuilderV3<ResourceLocation, ResourceLocation.Builder, ResourceLocationOrBuilder> resourceLocationBuilder_;
        private ResourceLocation resourceLocation_;
        private Object resourceName_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> resourceOriginalStateBuilder_;
        private Struct resourceOriginalState_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> responseBuilder_;
        private Struct response_;
        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> serviceDataBuilder_;
        private Any serviceData_;
        private Object serviceName_;
        private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> statusBuilder_;
        private Status status_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureAuthorizationInfoIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.authorizationInfo_ = new ArrayList(this.authorizationInfo_);
                this.bitField0_ |= 1;
            }
        }

        private SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> getAuthenticationInfoFieldBuilder() {
            if (this.authenticationInfoBuilder_ == null) {
                this.authenticationInfoBuilder_ = new SingleFieldBuilderV3<>(getAuthenticationInfo(), getParentForChildren(), isClean());
                this.authenticationInfo_ = null;
            }
            return this.authenticationInfoBuilder_;
        }

        private RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> getAuthorizationInfoFieldBuilder() {
            if (this.authorizationInfoBuilder_ == null) {
                this.authorizationInfoBuilder_ = new RepeatedFieldBuilderV3<>(this.authorizationInfo_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.authorizationInfo_ = null;
            }
            return this.authorizationInfoBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return w7.a.f54270a;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getMetadataFieldBuilder() {
            if (this.metadataBuilder_ == null) {
                this.metadataBuilder_ = new SingleFieldBuilderV3<>(getMetadata(), getParentForChildren(), isClean());
                this.metadata_ = null;
            }
            return this.metadataBuilder_;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getRequestFieldBuilder() {
            if (this.requestBuilder_ == null) {
                this.requestBuilder_ = new SingleFieldBuilderV3<>(getRequest(), getParentForChildren(), isClean());
                this.request_ = null;
            }
            return this.requestBuilder_;
        }

        private SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> getRequestMetadataFieldBuilder() {
            if (this.requestMetadataBuilder_ == null) {
                this.requestMetadataBuilder_ = new SingleFieldBuilderV3<>(getRequestMetadata(), getParentForChildren(), isClean());
                this.requestMetadata_ = null;
            }
            return this.requestMetadataBuilder_;
        }

        private SingleFieldBuilderV3<ResourceLocation, ResourceLocation.Builder, ResourceLocationOrBuilder> getResourceLocationFieldBuilder() {
            if (this.resourceLocationBuilder_ == null) {
                this.resourceLocationBuilder_ = new SingleFieldBuilderV3<>(getResourceLocation(), getParentForChildren(), isClean());
                this.resourceLocation_ = null;
            }
            return this.resourceLocationBuilder_;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getResourceOriginalStateFieldBuilder() {
            if (this.resourceOriginalStateBuilder_ == null) {
                this.resourceOriginalStateBuilder_ = new SingleFieldBuilderV3<>(getResourceOriginalState(), getParentForChildren(), isClean());
                this.resourceOriginalState_ = null;
            }
            return this.resourceOriginalStateBuilder_;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getResponseFieldBuilder() {
            if (this.responseBuilder_ == null) {
                this.responseBuilder_ = new SingleFieldBuilderV3<>(getResponse(), getParentForChildren(), isClean());
                this.response_ = null;
            }
            return this.responseBuilder_;
        }

        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getServiceDataFieldBuilder() {
            if (this.serviceDataBuilder_ == null) {
                this.serviceDataBuilder_ = new SingleFieldBuilderV3<>(getServiceData(), getParentForChildren(), isClean());
                this.serviceData_ = null;
            }
            return this.serviceDataBuilder_;
        }

        private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> getStatusFieldBuilder() {
            if (this.statusBuilder_ == null) {
                this.statusBuilder_ = new SingleFieldBuilderV3<>(getStatus(), getParentForChildren(), isClean());
                this.status_ = null;
            }
            return this.statusBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getAuthorizationInfoFieldBuilder();
            }
        }

        public Builder addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> iterable) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAuthorizationInfoIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.authorizationInfo_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAuthorizationInfo(AuthorizationInfo authorizationInfo) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authorizationInfo);
                ensureAuthorizationInfoIsMutable();
                this.authorizationInfo_.add(authorizationInfo);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(authorizationInfo);
            }
            return this;
        }

        public AuthorizationInfo.Builder addAuthorizationInfoBuilder() {
            return getAuthorizationInfoFieldBuilder().addBuilder(AuthorizationInfo.getDefaultInstance());
        }

        public Builder clearAuthenticationInfo() {
            if (this.authenticationInfoBuilder_ == null) {
                this.authenticationInfo_ = null;
                onChanged();
            } else {
                this.authenticationInfo_ = null;
                this.authenticationInfoBuilder_ = null;
            }
            return this;
        }

        public Builder clearAuthorizationInfo() {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.authorizationInfo_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearMetadata() {
            if (this.metadataBuilder_ == null) {
                this.metadata_ = null;
                onChanged();
            } else {
                this.metadata_ = null;
                this.metadataBuilder_ = null;
            }
            return this;
        }

        public Builder clearMethodName() {
            this.methodName_ = AuditLog.getDefaultInstance().getMethodName();
            onChanged();
            return this;
        }

        public Builder clearNumResponseItems() {
            this.numResponseItems_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearRequest() {
            if (this.requestBuilder_ == null) {
                this.request_ = null;
                onChanged();
            } else {
                this.request_ = null;
                this.requestBuilder_ = null;
            }
            return this;
        }

        public Builder clearRequestMetadata() {
            if (this.requestMetadataBuilder_ == null) {
                this.requestMetadata_ = null;
                onChanged();
            } else {
                this.requestMetadata_ = null;
                this.requestMetadataBuilder_ = null;
            }
            return this;
        }

        public Builder clearResourceLocation() {
            if (this.resourceLocationBuilder_ == null) {
                this.resourceLocation_ = null;
                onChanged();
            } else {
                this.resourceLocation_ = null;
                this.resourceLocationBuilder_ = null;
            }
            return this;
        }

        public Builder clearResourceName() {
            this.resourceName_ = AuditLog.getDefaultInstance().getResourceName();
            onChanged();
            return this;
        }

        public Builder clearResourceOriginalState() {
            if (this.resourceOriginalStateBuilder_ == null) {
                this.resourceOriginalState_ = null;
                onChanged();
            } else {
                this.resourceOriginalState_ = null;
                this.resourceOriginalStateBuilder_ = null;
            }
            return this;
        }

        public Builder clearResponse() {
            if (this.responseBuilder_ == null) {
                this.response_ = null;
                onChanged();
            } else {
                this.response_ = null;
                this.responseBuilder_ = null;
            }
            return this;
        }

        @Deprecated
        public Builder clearServiceData() {
            if (this.serviceDataBuilder_ == null) {
                this.serviceData_ = null;
                onChanged();
            } else {
                this.serviceData_ = null;
                this.serviceDataBuilder_ = null;
            }
            return this;
        }

        public Builder clearServiceName() {
            this.serviceName_ = AuditLog.getDefaultInstance().getServiceName();
            onChanged();
            return this;
        }

        public Builder clearStatus() {
            if (this.statusBuilder_ == null) {
                this.status_ = null;
                onChanged();
            } else {
                this.status_ = null;
                this.statusBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthenticationInfo getAuthenticationInfo() {
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                AuthenticationInfo authenticationInfo = this.authenticationInfo_;
                return authenticationInfo == null ? AuthenticationInfo.getDefaultInstance() : authenticationInfo;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public AuthenticationInfo.Builder getAuthenticationInfoBuilder() {
            onChanged();
            return getAuthenticationInfoFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthenticationInfoOrBuilder getAuthenticationInfoOrBuilder() {
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            AuthenticationInfo authenticationInfo = this.authenticationInfo_;
            return authenticationInfo == null ? AuthenticationInfo.getDefaultInstance() : authenticationInfo;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthorizationInfo getAuthorizationInfo(int i10) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.authorizationInfo_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public AuthorizationInfo.Builder getAuthorizationInfoBuilder(int i10) {
            return getAuthorizationInfoFieldBuilder().getBuilder(i10);
        }

        public List<AuthorizationInfo.Builder> getAuthorizationInfoBuilderList() {
            return getAuthorizationInfoFieldBuilder().getBuilderList();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public int getAuthorizationInfoCount() {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.authorizationInfo_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public List<AuthorizationInfo> getAuthorizationInfoList() {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.authorizationInfo_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int i10) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.authorizationInfo_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.authorizationInfo_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return w7.a.f54270a;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Struct getMetadata() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.metadata_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Struct.Builder getMetadataBuilder() {
            onChanged();
            return getMetadataFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public StructOrBuilder getMetadataOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.metadata_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getMethodName() {
            Object obj = this.methodName_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.methodName_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getMethodNameBytes() {
            Object obj = this.methodName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.methodName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public long getNumResponseItems() {
            return this.numResponseItems_;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Struct getRequest() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.request_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Struct.Builder getRequestBuilder() {
            onChanged();
            return getRequestFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public RequestMetadata getRequestMetadata() {
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                RequestMetadata requestMetadata = this.requestMetadata_;
                return requestMetadata == null ? RequestMetadata.getDefaultInstance() : requestMetadata;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public RequestMetadata.Builder getRequestMetadataBuilder() {
            onChanged();
            return getRequestMetadataFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public RequestMetadataOrBuilder getRequestMetadataOrBuilder() {
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            RequestMetadata requestMetadata = this.requestMetadata_;
            return requestMetadata == null ? RequestMetadata.getDefaultInstance() : requestMetadata;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public StructOrBuilder getRequestOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.request_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ResourceLocation getResourceLocation() {
            SingleFieldBuilderV3<ResourceLocation, ResourceLocation.Builder, ResourceLocationOrBuilder> singleFieldBuilderV3 = this.resourceLocationBuilder_;
            if (singleFieldBuilderV3 == null) {
                ResourceLocation resourceLocation = this.resourceLocation_;
                return resourceLocation == null ? ResourceLocation.getDefaultInstance() : resourceLocation;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public ResourceLocation.Builder getResourceLocationBuilder() {
            onChanged();
            return getResourceLocationFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ResourceLocationOrBuilder getResourceLocationOrBuilder() {
            SingleFieldBuilderV3<ResourceLocation, ResourceLocation.Builder, ResourceLocationOrBuilder> singleFieldBuilderV3 = this.resourceLocationBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            ResourceLocation resourceLocation = this.resourceLocation_;
            return resourceLocation == null ? ResourceLocation.getDefaultInstance() : resourceLocation;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getResourceName() {
            Object obj = this.resourceName_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.resourceName_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getResourceNameBytes() {
            Object obj = this.resourceName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.resourceName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Struct getResourceOriginalState() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.resourceOriginalStateBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.resourceOriginalState_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Struct.Builder getResourceOriginalStateBuilder() {
            onChanged();
            return getResourceOriginalStateFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public StructOrBuilder getResourceOriginalStateOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.resourceOriginalStateBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.resourceOriginalState_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Struct getResponse() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.response_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Struct.Builder getResponseBuilder() {
            onChanged();
            return getResponseFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public StructOrBuilder getResponseOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.response_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        @Deprecated
        public Any getServiceData() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Any any = this.serviceData_;
                return any == null ? Any.getDefaultInstance() : any;
            }
            return singleFieldBuilderV3.getMessage();
        }

        @Deprecated
        public Any.Builder getServiceDataBuilder() {
            onChanged();
            return getServiceDataFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        @Deprecated
        public AnyOrBuilder getServiceDataOrBuilder() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Any any = this.serviceData_;
            return any == null ? Any.getDefaultInstance() : any;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getServiceName() {
            Object obj = this.serviceName_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.serviceName_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getServiceNameBytes() {
            Object obj = this.serviceName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serviceName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Status getStatus() {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
            if (singleFieldBuilderV3 == null) {
                Status status = this.status_;
                return status == null ? Status.getDefaultInstance() : status;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Status.Builder getStatusBuilder() {
            onChanged();
            return getStatusFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public StatusOrBuilder getStatusOrBuilder() {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Status status = this.status_;
            return status == null ? Status.getDefaultInstance() : status;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasAuthenticationInfo() {
            return (this.authenticationInfoBuilder_ == null && this.authenticationInfo_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasMetadata() {
            return (this.metadataBuilder_ == null && this.metadata_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasRequest() {
            return (this.requestBuilder_ == null && this.request_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasRequestMetadata() {
            return (this.requestMetadataBuilder_ == null && this.requestMetadata_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasResourceLocation() {
            return (this.resourceLocationBuilder_ == null && this.resourceLocation_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasResourceOriginalState() {
            return (this.resourceOriginalStateBuilder_ == null && this.resourceOriginalState_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasResponse() {
            return (this.responseBuilder_ == null && this.response_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        @Deprecated
        public boolean hasServiceData() {
            return (this.serviceDataBuilder_ == null && this.serviceData_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasStatus() {
            return (this.statusBuilder_ == null && this.status_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return w7.a.f54271b.ensureFieldAccessorsInitialized(AuditLog.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                AuthenticationInfo authenticationInfo2 = this.authenticationInfo_;
                if (authenticationInfo2 != null) {
                    this.authenticationInfo_ = AuthenticationInfo.newBuilder(authenticationInfo2).mergeFrom(authenticationInfo).buildPartial();
                } else {
                    this.authenticationInfo_ = authenticationInfo;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(authenticationInfo);
            }
            return this;
        }

        public Builder mergeMetadata(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct2 = this.metadata_;
                if (struct2 != null) {
                    this.metadata_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                } else {
                    this.metadata_ = struct;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(struct);
            }
            return this;
        }

        public Builder mergeRequest(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct2 = this.request_;
                if (struct2 != null) {
                    this.request_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                } else {
                    this.request_ = struct;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(struct);
            }
            return this;
        }

        public Builder mergeRequestMetadata(RequestMetadata requestMetadata) {
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                RequestMetadata requestMetadata2 = this.requestMetadata_;
                if (requestMetadata2 != null) {
                    this.requestMetadata_ = RequestMetadata.newBuilder(requestMetadata2).mergeFrom(requestMetadata).buildPartial();
                } else {
                    this.requestMetadata_ = requestMetadata;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(requestMetadata);
            }
            return this;
        }

        public Builder mergeResourceLocation(ResourceLocation resourceLocation) {
            SingleFieldBuilderV3<ResourceLocation, ResourceLocation.Builder, ResourceLocationOrBuilder> singleFieldBuilderV3 = this.resourceLocationBuilder_;
            if (singleFieldBuilderV3 == null) {
                ResourceLocation resourceLocation2 = this.resourceLocation_;
                if (resourceLocation2 != null) {
                    this.resourceLocation_ = ResourceLocation.newBuilder(resourceLocation2).mergeFrom(resourceLocation).buildPartial();
                } else {
                    this.resourceLocation_ = resourceLocation;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(resourceLocation);
            }
            return this;
        }

        public Builder mergeResourceOriginalState(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.resourceOriginalStateBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct2 = this.resourceOriginalState_;
                if (struct2 != null) {
                    this.resourceOriginalState_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                } else {
                    this.resourceOriginalState_ = struct;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(struct);
            }
            return this;
        }

        public Builder mergeResponse(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct2 = this.response_;
                if (struct2 != null) {
                    this.response_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                } else {
                    this.response_ = struct;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(struct);
            }
            return this;
        }

        @Deprecated
        public Builder mergeServiceData(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Any any2 = this.serviceData_;
                if (any2 != null) {
                    this.serviceData_ = Any.newBuilder(any2).mergeFrom(any).buildPartial();
                } else {
                    this.serviceData_ = any;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(any);
            }
            return this;
        }

        public Builder mergeStatus(Status status) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
            if (singleFieldBuilderV3 == null) {
                Status status2 = this.status_;
                if (status2 != null) {
                    this.status_ = Status.newBuilder(status2).mergeFrom(status).buildPartial();
                } else {
                    this.status_ = status;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(status);
            }
            return this;
        }

        public Builder removeAuthorizationInfo(int i10) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAuthorizationInfoIsMutable();
                this.authorizationInfo_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(authenticationInfo);
                this.authenticationInfo_ = authenticationInfo;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(authenticationInfo);
            }
            return this;
        }

        public Builder setAuthorizationInfo(int i10, AuthorizationInfo authorizationInfo) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authorizationInfo);
                ensureAuthorizationInfoIsMutable();
                this.authorizationInfo_.set(i10, authorizationInfo);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, authorizationInfo);
            }
            return this;
        }

        public Builder setMetadata(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(struct);
                this.metadata_ = struct;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(struct);
            }
            return this;
        }

        public Builder setMethodName(String str) {
            Objects.requireNonNull(str);
            this.methodName_ = str;
            onChanged();
            return this;
        }

        public Builder setMethodNameBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.methodName_ = byteString;
            onChanged();
            return this;
        }

        public Builder setNumResponseItems(long j10) {
            this.numResponseItems_ = j10;
            onChanged();
            return this;
        }

        public Builder setRequest(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(struct);
                this.request_ = struct;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(struct);
            }
            return this;
        }

        public Builder setRequestMetadata(RequestMetadata requestMetadata) {
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(requestMetadata);
                this.requestMetadata_ = requestMetadata;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(requestMetadata);
            }
            return this;
        }

        public Builder setResourceLocation(ResourceLocation resourceLocation) {
            SingleFieldBuilderV3<ResourceLocation, ResourceLocation.Builder, ResourceLocationOrBuilder> singleFieldBuilderV3 = this.resourceLocationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(resourceLocation);
                this.resourceLocation_ = resourceLocation;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(resourceLocation);
            }
            return this;
        }

        public Builder setResourceName(String str) {
            Objects.requireNonNull(str);
            this.resourceName_ = str;
            onChanged();
            return this;
        }

        public Builder setResourceNameBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.resourceName_ = byteString;
            onChanged();
            return this;
        }

        public Builder setResourceOriginalState(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.resourceOriginalStateBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(struct);
                this.resourceOriginalState_ = struct;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(struct);
            }
            return this;
        }

        public Builder setResponse(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(struct);
                this.response_ = struct;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(struct);
            }
            return this;
        }

        @Deprecated
        public Builder setServiceData(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(any);
                this.serviceData_ = any;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(any);
            }
            return this;
        }

        public Builder setServiceName(String str) {
            Objects.requireNonNull(str);
            this.serviceName_ = str;
            onChanged();
            return this;
        }

        public Builder setServiceNameBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.serviceName_ = byteString;
            onChanged();
            return this;
        }

        public Builder setStatus(Status status) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(status);
                this.status_ = status;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(status);
            }
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.serviceName_ = "";
            this.methodName_ = "";
            this.resourceName_ = "";
            this.authorizationInfo_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public AuthorizationInfo.Builder addAuthorizationInfoBuilder(int i10) {
            return getAuthorizationInfoFieldBuilder().addBuilder(i10, AuthorizationInfo.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuditLog build() {
            AuditLog buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuditLog buildPartial() {
            AuditLog auditLog = new AuditLog(this, (a) null);
            auditLog.serviceName_ = this.serviceName_;
            auditLog.methodName_ = this.methodName_;
            auditLog.resourceName_ = this.resourceName_;
            SingleFieldBuilderV3<ResourceLocation, ResourceLocation.Builder, ResourceLocationOrBuilder> singleFieldBuilderV3 = this.resourceLocationBuilder_;
            if (singleFieldBuilderV3 == null) {
                auditLog.resourceLocation_ = this.resourceLocation_;
            } else {
                auditLog.resourceLocation_ = singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV32 = this.resourceOriginalStateBuilder_;
            if (singleFieldBuilderV32 == null) {
                auditLog.resourceOriginalState_ = this.resourceOriginalState_;
            } else {
                auditLog.resourceOriginalState_ = singleFieldBuilderV32.build();
            }
            auditLog.numResponseItems_ = this.numResponseItems_;
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV33 = this.statusBuilder_;
            if (singleFieldBuilderV33 == null) {
                auditLog.status_ = this.status_;
            } else {
                auditLog.status_ = singleFieldBuilderV33.build();
            }
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV34 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV34 == null) {
                auditLog.authenticationInfo_ = this.authenticationInfo_;
            } else {
                auditLog.authenticationInfo_ = singleFieldBuilderV34.build();
            }
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.authorizationInfo_ = Collections.unmodifiableList(this.authorizationInfo_);
                    this.bitField0_ &= -2;
                }
                auditLog.authorizationInfo_ = this.authorizationInfo_;
            } else {
                auditLog.authorizationInfo_ = repeatedFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV35 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV35 == null) {
                auditLog.requestMetadata_ = this.requestMetadata_;
            } else {
                auditLog.requestMetadata_ = singleFieldBuilderV35.build();
            }
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV36 = this.requestBuilder_;
            if (singleFieldBuilderV36 == null) {
                auditLog.request_ = this.request_;
            } else {
                auditLog.request_ = singleFieldBuilderV36.build();
            }
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV37 = this.responseBuilder_;
            if (singleFieldBuilderV37 == null) {
                auditLog.response_ = this.response_;
            } else {
                auditLog.response_ = singleFieldBuilderV37.build();
            }
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV38 = this.metadataBuilder_;
            if (singleFieldBuilderV38 == null) {
                auditLog.metadata_ = this.metadata_;
            } else {
                auditLog.metadata_ = singleFieldBuilderV38.build();
            }
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV39 = this.serviceDataBuilder_;
            if (singleFieldBuilderV39 == null) {
                auditLog.serviceData_ = this.serviceData_;
            } else {
                auditLog.serviceData_ = singleFieldBuilderV39.build();
            }
            onBuilt();
            return auditLog;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AuditLog getDefaultInstanceForType() {
            return AuditLog.getDefaultInstance();
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
            this.serviceName_ = "";
            this.methodName_ = "";
            this.resourceName_ = "";
            if (this.resourceLocationBuilder_ == null) {
                this.resourceLocation_ = null;
            } else {
                this.resourceLocation_ = null;
                this.resourceLocationBuilder_ = null;
            }
            if (this.resourceOriginalStateBuilder_ == null) {
                this.resourceOriginalState_ = null;
            } else {
                this.resourceOriginalState_ = null;
                this.resourceOriginalStateBuilder_ = null;
            }
            this.numResponseItems_ = 0L;
            if (this.statusBuilder_ == null) {
                this.status_ = null;
            } else {
                this.status_ = null;
                this.statusBuilder_ = null;
            }
            if (this.authenticationInfoBuilder_ == null) {
                this.authenticationInfo_ = null;
            } else {
                this.authenticationInfo_ = null;
                this.authenticationInfoBuilder_ = null;
            }
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.authorizationInfo_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            if (this.requestMetadataBuilder_ == null) {
                this.requestMetadata_ = null;
            } else {
                this.requestMetadata_ = null;
                this.requestMetadataBuilder_ = null;
            }
            if (this.requestBuilder_ == null) {
                this.request_ = null;
            } else {
                this.request_ = null;
                this.requestBuilder_ = null;
            }
            if (this.responseBuilder_ == null) {
                this.response_ = null;
            } else {
                this.response_ = null;
                this.responseBuilder_ = null;
            }
            if (this.metadataBuilder_ == null) {
                this.metadata_ = null;
            } else {
                this.metadata_ = null;
                this.metadataBuilder_ = null;
            }
            if (this.serviceDataBuilder_ == null) {
                this.serviceData_ = null;
            } else {
                this.serviceData_ = null;
                this.serviceDataBuilder_ = null;
            }
            return this;
        }

        public Builder setAuthenticationInfo(AuthenticationInfo.Builder builder) {
            SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.authenticationInfo_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setMetadata(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.metadata_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setRequest(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.request_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setRequestMetadata(RequestMetadata.Builder builder) {
            SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.requestMetadata_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setResourceLocation(ResourceLocation.Builder builder) {
            SingleFieldBuilderV3<ResourceLocation, ResourceLocation.Builder, ResourceLocationOrBuilder> singleFieldBuilderV3 = this.resourceLocationBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.resourceLocation_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setResourceOriginalState(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.resourceOriginalStateBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.resourceOriginalState_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setResponse(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.response_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        @Deprecated
        public Builder setServiceData(Any.Builder builder) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.serviceData_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setStatus(Status.Builder builder) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.status_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder addAuthorizationInfo(int i10, AuthorizationInfo authorizationInfo) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authorizationInfo);
                ensureAuthorizationInfoIsMutable();
                this.authorizationInfo_.add(i10, authorizationInfo);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, authorizationInfo);
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
            if (message instanceof AuditLog) {
                return mergeFrom((AuditLog) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setAuthorizationInfo(int i10, AuthorizationInfo.Builder builder) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAuthorizationInfoIsMutable();
                this.authorizationInfo_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.serviceName_ = "";
            this.methodName_ = "";
            this.resourceName_ = "";
            this.authorizationInfo_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder mergeFrom(AuditLog auditLog) {
            if (auditLog == AuditLog.getDefaultInstance()) {
                return this;
            }
            if (!auditLog.getServiceName().isEmpty()) {
                this.serviceName_ = auditLog.serviceName_;
                onChanged();
            }
            if (!auditLog.getMethodName().isEmpty()) {
                this.methodName_ = auditLog.methodName_;
                onChanged();
            }
            if (!auditLog.getResourceName().isEmpty()) {
                this.resourceName_ = auditLog.resourceName_;
                onChanged();
            }
            if (auditLog.hasResourceLocation()) {
                mergeResourceLocation(auditLog.getResourceLocation());
            }
            if (auditLog.hasResourceOriginalState()) {
                mergeResourceOriginalState(auditLog.getResourceOriginalState());
            }
            if (auditLog.getNumResponseItems() != 0) {
                setNumResponseItems(auditLog.getNumResponseItems());
            }
            if (auditLog.hasStatus()) {
                mergeStatus(auditLog.getStatus());
            }
            if (auditLog.hasAuthenticationInfo()) {
                mergeAuthenticationInfo(auditLog.getAuthenticationInfo());
            }
            if (this.authorizationInfoBuilder_ == null) {
                if (!auditLog.authorizationInfo_.isEmpty()) {
                    if (this.authorizationInfo_.isEmpty()) {
                        this.authorizationInfo_ = auditLog.authorizationInfo_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAuthorizationInfoIsMutable();
                        this.authorizationInfo_.addAll(auditLog.authorizationInfo_);
                    }
                    onChanged();
                }
            } else if (!auditLog.authorizationInfo_.isEmpty()) {
                if (this.authorizationInfoBuilder_.isEmpty()) {
                    this.authorizationInfoBuilder_.dispose();
                    this.authorizationInfoBuilder_ = null;
                    this.authorizationInfo_ = auditLog.authorizationInfo_;
                    this.bitField0_ &= -2;
                    this.authorizationInfoBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getAuthorizationInfoFieldBuilder() : null;
                } else {
                    this.authorizationInfoBuilder_.addAllMessages(auditLog.authorizationInfo_);
                }
            }
            if (auditLog.hasRequestMetadata()) {
                mergeRequestMetadata(auditLog.getRequestMetadata());
            }
            if (auditLog.hasRequest()) {
                mergeRequest(auditLog.getRequest());
            }
            if (auditLog.hasResponse()) {
                mergeResponse(auditLog.getResponse());
            }
            if (auditLog.hasMetadata()) {
                mergeMetadata(auditLog.getMetadata());
            }
            if (auditLog.hasServiceData()) {
                mergeServiceData(auditLog.getServiceData());
            }
            mergeUnknownFields(auditLog.unknownFields);
            onChanged();
            return this;
        }

        public Builder addAuthorizationInfo(AuthorizationInfo.Builder builder) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAuthorizationInfoIsMutable();
                this.authorizationInfo_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addAuthorizationInfo(int i10, AuthorizationInfo.Builder builder) {
            RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAuthorizationInfoIsMutable();
                this.authorizationInfo_.add(i10, builder.build());
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
        public com.google.cloud.audit.AuditLog.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.cloud.audit.AuditLog.access$2000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.cloud.audit.AuditLog r3 = (com.google.cloud.audit.AuditLog) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.cloud.audit.AuditLog r4 = (com.google.cloud.audit.AuditLog) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.cloud.audit.AuditLog.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.cloud.audit.AuditLog$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<AuditLog> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuditLog parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new AuditLog(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ AuditLog(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static AuditLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return w7.a.f54270a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AuditLog parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<AuditLog> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuditLog)) {
            return super.equals(obj);
        }
        AuditLog auditLog = (AuditLog) obj;
        if (!getServiceName().equals(auditLog.getServiceName()) || !getMethodName().equals(auditLog.getMethodName()) || !getResourceName().equals(auditLog.getResourceName()) || hasResourceLocation() != auditLog.hasResourceLocation()) {
            return false;
        }
        if ((hasResourceLocation() && !getResourceLocation().equals(auditLog.getResourceLocation())) || hasResourceOriginalState() != auditLog.hasResourceOriginalState()) {
            return false;
        }
        if ((hasResourceOriginalState() && !getResourceOriginalState().equals(auditLog.getResourceOriginalState())) || getNumResponseItems() != auditLog.getNumResponseItems() || hasStatus() != auditLog.hasStatus()) {
            return false;
        }
        if ((hasStatus() && !getStatus().equals(auditLog.getStatus())) || hasAuthenticationInfo() != auditLog.hasAuthenticationInfo()) {
            return false;
        }
        if ((hasAuthenticationInfo() && !getAuthenticationInfo().equals(auditLog.getAuthenticationInfo())) || !getAuthorizationInfoList().equals(auditLog.getAuthorizationInfoList()) || hasRequestMetadata() != auditLog.hasRequestMetadata()) {
            return false;
        }
        if ((hasRequestMetadata() && !getRequestMetadata().equals(auditLog.getRequestMetadata())) || hasRequest() != auditLog.hasRequest()) {
            return false;
        }
        if ((hasRequest() && !getRequest().equals(auditLog.getRequest())) || hasResponse() != auditLog.hasResponse()) {
            return false;
        }
        if ((hasResponse() && !getResponse().equals(auditLog.getResponse())) || hasMetadata() != auditLog.hasMetadata()) {
            return false;
        }
        if ((!hasMetadata() || getMetadata().equals(auditLog.getMetadata())) && hasServiceData() == auditLog.hasServiceData()) {
            return (!hasServiceData() || getServiceData().equals(auditLog.getServiceData())) && this.unknownFields.equals(auditLog.unknownFields);
        }
        return false;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthenticationInfo getAuthenticationInfo() {
        AuthenticationInfo authenticationInfo = this.authenticationInfo_;
        return authenticationInfo == null ? AuthenticationInfo.getDefaultInstance() : authenticationInfo;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthenticationInfoOrBuilder getAuthenticationInfoOrBuilder() {
        return getAuthenticationInfo();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthorizationInfo getAuthorizationInfo(int i10) {
        return this.authorizationInfo_.get(i10);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public int getAuthorizationInfoCount() {
        return this.authorizationInfo_.size();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public List<AuthorizationInfo> getAuthorizationInfoList() {
        return this.authorizationInfo_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int i10) {
        return this.authorizationInfo_.get(i10);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
        return this.authorizationInfo_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Struct getMetadata() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public StructOrBuilder getMetadataOrBuilder() {
        return getMetadata();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getMethodName() {
        Object obj = this.methodName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.methodName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getMethodNameBytes() {
        Object obj = this.methodName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.methodName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public long getNumResponseItems() {
        return this.numResponseItems_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AuditLog> getParserForType() {
        return PARSER;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Struct getRequest() {
        Struct struct = this.request_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public RequestMetadata getRequestMetadata() {
        RequestMetadata requestMetadata = this.requestMetadata_;
        return requestMetadata == null ? RequestMetadata.getDefaultInstance() : requestMetadata;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public RequestMetadataOrBuilder getRequestMetadataOrBuilder() {
        return getRequestMetadata();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public StructOrBuilder getRequestOrBuilder() {
        return getRequest();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ResourceLocation getResourceLocation() {
        ResourceLocation resourceLocation = this.resourceLocation_;
        return resourceLocation == null ? ResourceLocation.getDefaultInstance() : resourceLocation;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ResourceLocationOrBuilder getResourceLocationOrBuilder() {
        return getResourceLocation();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getResourceName() {
        Object obj = this.resourceName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.resourceName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getResourceNameBytes() {
        Object obj = this.resourceName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.resourceName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Struct getResourceOriginalState() {
        Struct struct = this.resourceOriginalState_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public StructOrBuilder getResourceOriginalStateOrBuilder() {
        return getResourceOriginalState();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Struct getResponse() {
        Struct struct = this.response_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public StructOrBuilder getResponseOrBuilder() {
        return getResponse();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeMessageSize = this.status_ != null ? CodedOutputStream.computeMessageSize(2, getStatus()) + 0 : 0;
        if (this.authenticationInfo_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, getAuthenticationInfo());
        }
        if (this.requestMetadata_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, getRequestMetadata());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.serviceName_)) {
            computeMessageSize += GeneratedMessageV3.computeStringSize(7, this.serviceName_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.methodName_)) {
            computeMessageSize += GeneratedMessageV3.computeStringSize(8, this.methodName_);
        }
        for (int i11 = 0; i11 < this.authorizationInfo_.size(); i11++) {
            computeMessageSize += CodedOutputStream.computeMessageSize(9, this.authorizationInfo_.get(i11));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.resourceName_)) {
            computeMessageSize += GeneratedMessageV3.computeStringSize(11, this.resourceName_);
        }
        long j10 = this.numResponseItems_;
        if (j10 != 0) {
            computeMessageSize += CodedOutputStream.computeInt64Size(12, j10);
        }
        if (this.serviceData_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(15, getServiceData());
        }
        if (this.request_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(16, getRequest());
        }
        if (this.response_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(17, getResponse());
        }
        if (this.metadata_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(18, getMetadata());
        }
        if (this.resourceOriginalState_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(19, getResourceOriginalState());
        }
        if (this.resourceLocation_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(20, getResourceLocation());
        }
        int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    @Deprecated
    public Any getServiceData() {
        Any any = this.serviceData_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    @Deprecated
    public AnyOrBuilder getServiceDataOrBuilder() {
        return getServiceData();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getServiceName() {
        Object obj = this.serviceName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.serviceName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getServiceNameBytes() {
        Object obj = this.serviceName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.serviceName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Status getStatus() {
        Status status = this.status_;
        return status == null ? Status.getDefaultInstance() : status;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public StatusOrBuilder getStatusOrBuilder() {
        return getStatus();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasAuthenticationInfo() {
        return this.authenticationInfo_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasRequest() {
        return this.request_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasRequestMetadata() {
        return this.requestMetadata_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasResourceLocation() {
        return this.resourceLocation_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasResourceOriginalState() {
        return this.resourceOriginalState_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasResponse() {
        return this.response_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    @Deprecated
    public boolean hasServiceData() {
        return this.serviceData_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasStatus() {
        return this.status_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 7) * 53) + getServiceName().hashCode()) * 37) + 8) * 53) + getMethodName().hashCode()) * 37) + 11) * 53) + getResourceName().hashCode();
        if (hasResourceLocation()) {
            hashCode = (((hashCode * 37) + 20) * 53) + getResourceLocation().hashCode();
        }
        if (hasResourceOriginalState()) {
            hashCode = (((hashCode * 37) + 19) * 53) + getResourceOriginalState().hashCode();
        }
        int hashLong = (((hashCode * 37) + 12) * 53) + Internal.hashLong(getNumResponseItems());
        if (hasStatus()) {
            hashLong = (((hashLong * 37) + 2) * 53) + getStatus().hashCode();
        }
        if (hasAuthenticationInfo()) {
            hashLong = (((hashLong * 37) + 3) * 53) + getAuthenticationInfo().hashCode();
        }
        if (getAuthorizationInfoCount() > 0) {
            hashLong = (((hashLong * 37) + 9) * 53) + getAuthorizationInfoList().hashCode();
        }
        if (hasRequestMetadata()) {
            hashLong = (((hashLong * 37) + 4) * 53) + getRequestMetadata().hashCode();
        }
        if (hasRequest()) {
            hashLong = (((hashLong * 37) + 16) * 53) + getRequest().hashCode();
        }
        if (hasResponse()) {
            hashLong = (((hashLong * 37) + 17) * 53) + getResponse().hashCode();
        }
        if (hasMetadata()) {
            hashLong = (((hashLong * 37) + 18) * 53) + getMetadata().hashCode();
        }
        if (hasServiceData()) {
            hashLong = (((hashLong * 37) + 15) * 53) + getServiceData().hashCode();
        }
        int hashCode2 = (hashLong * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return w7.a.f54271b.ensureFieldAccessorsInitialized(AuditLog.class, Builder.class);
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
        return new AuditLog();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.status_ != null) {
            codedOutputStream.writeMessage(2, getStatus());
        }
        if (this.authenticationInfo_ != null) {
            codedOutputStream.writeMessage(3, getAuthenticationInfo());
        }
        if (this.requestMetadata_ != null) {
            codedOutputStream.writeMessage(4, getRequestMetadata());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.serviceName_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.serviceName_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.methodName_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.methodName_);
        }
        for (int i10 = 0; i10 < this.authorizationInfo_.size(); i10++) {
            codedOutputStream.writeMessage(9, this.authorizationInfo_.get(i10));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.resourceName_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.resourceName_);
        }
        long j10 = this.numResponseItems_;
        if (j10 != 0) {
            codedOutputStream.writeInt64(12, j10);
        }
        if (this.serviceData_ != null) {
            codedOutputStream.writeMessage(15, getServiceData());
        }
        if (this.request_ != null) {
            codedOutputStream.writeMessage(16, getRequest());
        }
        if (this.response_ != null) {
            codedOutputStream.writeMessage(17, getResponse());
        }
        if (this.metadata_ != null) {
            codedOutputStream.writeMessage(18, getMetadata());
        }
        if (this.resourceOriginalState_ != null) {
            codedOutputStream.writeMessage(19, getResourceOriginalState());
        }
        if (this.resourceLocation_ != null) {
            codedOutputStream.writeMessage(20, getResourceLocation());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ AuditLog(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(AuditLog auditLog) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(auditLog);
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private AuditLog(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static AuditLog parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AuditLog getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static AuditLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private AuditLog() {
        this.memoizedIsInitialized = (byte) -1;
        this.serviceName_ = "";
        this.methodName_ = "";
        this.resourceName_ = "";
        this.authorizationInfo_ = Collections.emptyList();
    }

    public static AuditLog parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static AuditLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static AuditLog parseFrom(InputStream inputStream) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static AuditLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0014. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private AuditLog(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        switch (readTag) {
                            case 0:
                                z10 = true;
                            case 18:
                                Status status = this.status_;
                                Status.Builder builder = status != null ? status.toBuilder() : null;
                                Status status2 = (Status) codedInputStream.readMessage(Status.parser(), extensionRegistryLite);
                                this.status_ = status2;
                                if (builder != null) {
                                    builder.mergeFrom(status2);
                                    this.status_ = builder.buildPartial();
                                }
                            case 26:
                                AuthenticationInfo authenticationInfo = this.authenticationInfo_;
                                AuthenticationInfo.Builder builder2 = authenticationInfo != null ? authenticationInfo.toBuilder() : null;
                                AuthenticationInfo authenticationInfo2 = (AuthenticationInfo) codedInputStream.readMessage(AuthenticationInfo.parser(), extensionRegistryLite);
                                this.authenticationInfo_ = authenticationInfo2;
                                if (builder2 != null) {
                                    builder2.mergeFrom(authenticationInfo2);
                                    this.authenticationInfo_ = builder2.buildPartial();
                                }
                            case 34:
                                RequestMetadata requestMetadata = this.requestMetadata_;
                                RequestMetadata.Builder builder3 = requestMetadata != null ? requestMetadata.toBuilder() : null;
                                RequestMetadata requestMetadata2 = (RequestMetadata) codedInputStream.readMessage(RequestMetadata.parser(), extensionRegistryLite);
                                this.requestMetadata_ = requestMetadata2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(requestMetadata2);
                                    this.requestMetadata_ = builder3.buildPartial();
                                }
                            case 58:
                                this.serviceName_ = codedInputStream.readStringRequireUtf8();
                            case 66:
                                this.methodName_ = codedInputStream.readStringRequireUtf8();
                            case 74:
                                if (!(z11 & true)) {
                                    this.authorizationInfo_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.authorizationInfo_.add(codedInputStream.readMessage(AuthorizationInfo.parser(), extensionRegistryLite));
                            case 90:
                                this.resourceName_ = codedInputStream.readStringRequireUtf8();
                            case 96:
                                this.numResponseItems_ = codedInputStream.readInt64();
                            case 122:
                                Any any = this.serviceData_;
                                Any.Builder builder4 = any != null ? any.toBuilder() : null;
                                Any any2 = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                this.serviceData_ = any2;
                                if (builder4 != null) {
                                    builder4.mergeFrom(any2);
                                    this.serviceData_ = builder4.buildPartial();
                                }
                            case 130:
                                Struct struct = this.request_;
                                Struct.Builder builder5 = struct != null ? struct.toBuilder() : null;
                                Struct struct2 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                this.request_ = struct2;
                                if (builder5 != null) {
                                    builder5.mergeFrom(struct2);
                                    this.request_ = builder5.buildPartial();
                                }
                            case 138:
                                Struct struct3 = this.response_;
                                Struct.Builder builder6 = struct3 != null ? struct3.toBuilder() : null;
                                Struct struct4 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                this.response_ = struct4;
                                if (builder6 != null) {
                                    builder6.mergeFrom(struct4);
                                    this.response_ = builder6.buildPartial();
                                }
                            case 146:
                                Struct struct5 = this.metadata_;
                                Struct.Builder builder7 = struct5 != null ? struct5.toBuilder() : null;
                                Struct struct6 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                this.metadata_ = struct6;
                                if (builder7 != null) {
                                    builder7.mergeFrom(struct6);
                                    this.metadata_ = builder7.buildPartial();
                                }
                            case 154:
                                Struct struct7 = this.resourceOriginalState_;
                                Struct.Builder builder8 = struct7 != null ? struct7.toBuilder() : null;
                                Struct struct8 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                this.resourceOriginalState_ = struct8;
                                if (builder8 != null) {
                                    builder8.mergeFrom(struct8);
                                    this.resourceOriginalState_ = builder8.buildPartial();
                                }
                            case 162:
                                ResourceLocation resourceLocation = this.resourceLocation_;
                                ResourceLocation.Builder builder9 = resourceLocation != null ? resourceLocation.toBuilder() : null;
                                ResourceLocation resourceLocation2 = (ResourceLocation) codedInputStream.readMessage(ResourceLocation.parser(), extensionRegistryLite);
                                this.resourceLocation_ = resourceLocation2;
                                if (builder9 != null) {
                                    builder9.mergeFrom(resourceLocation2);
                                    this.resourceLocation_ = builder9.buildPartial();
                                }
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
                if (z11 & true) {
                    this.authorizationInfo_ = Collections.unmodifiableList(this.authorizationInfo_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }
}
