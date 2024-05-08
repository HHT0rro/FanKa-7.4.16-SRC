package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.api.JwtLocation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import u7.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class AuthProvider extends GeneratedMessageV3 implements AuthProviderOrBuilder {
    public static final int AUDIENCES_FIELD_NUMBER = 4;
    public static final int AUTHORIZATION_URL_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int ISSUER_FIELD_NUMBER = 2;
    public static final int JWKS_URI_FIELD_NUMBER = 3;
    public static final int JWT_LOCATIONS_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private volatile Object audiences_;
    private volatile Object authorizationUrl_;
    private volatile Object id_;
    private volatile Object issuer_;
    private volatile Object jwksUri_;
    private List<JwtLocation> jwtLocations_;
    private byte memoizedIsInitialized;
    private static final AuthProvider DEFAULT_INSTANCE = new AuthProvider();
    private static final Parser<AuthProvider> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthProviderOrBuilder {
        private Object audiences_;
        private Object authorizationUrl_;
        private int bitField0_;
        private Object id_;
        private Object issuer_;
        private Object jwksUri_;
        private RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> jwtLocationsBuilder_;
        private List<JwtLocation> jwtLocations_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureJwtLocationsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.jwtLocations_ = new ArrayList(this.jwtLocations_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return b.f53840g;
        }

        private RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> getJwtLocationsFieldBuilder() {
            if (this.jwtLocationsBuilder_ == null) {
                this.jwtLocationsBuilder_ = new RepeatedFieldBuilderV3<>(this.jwtLocations_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.jwtLocations_ = null;
            }
            return this.jwtLocationsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getJwtLocationsFieldBuilder();
            }
        }

        public Builder addAllJwtLocations(Iterable<? extends JwtLocation> iterable) {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureJwtLocationsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.jwtLocations_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addJwtLocations(JwtLocation jwtLocation) {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(jwtLocation);
                ensureJwtLocationsIsMutable();
                this.jwtLocations_.add(jwtLocation);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(jwtLocation);
            }
            return this;
        }

        public JwtLocation.Builder addJwtLocationsBuilder() {
            return getJwtLocationsFieldBuilder().addBuilder(JwtLocation.getDefaultInstance());
        }

        public Builder clearAudiences() {
            this.audiences_ = AuthProvider.getDefaultInstance().getAudiences();
            onChanged();
            return this;
        }

        public Builder clearAuthorizationUrl() {
            this.authorizationUrl_ = AuthProvider.getDefaultInstance().getAuthorizationUrl();
            onChanged();
            return this;
        }

        public Builder clearId() {
            this.id_ = AuthProvider.getDefaultInstance().getId();
            onChanged();
            return this;
        }

        public Builder clearIssuer() {
            this.issuer_ = AuthProvider.getDefaultInstance().getIssuer();
            onChanged();
            return this;
        }

        public Builder clearJwksUri() {
            this.jwksUri_ = AuthProvider.getDefaultInstance().getJwksUri();
            onChanged();
            return this;
        }

        public Builder clearJwtLocations() {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.jwtLocations_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public String getAudiences() {
            Object obj = this.audiences_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.audiences_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getAudiencesBytes() {
            Object obj = this.audiences_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.audiences_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public String getAuthorizationUrl() {
            Object obj = this.authorizationUrl_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.authorizationUrl_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getAuthorizationUrlBytes() {
            Object obj = this.authorizationUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.authorizationUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return b.f53840g;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.id_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public String getIssuer() {
            Object obj = this.issuer_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.issuer_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getIssuerBytes() {
            Object obj = this.issuer_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.issuer_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public String getJwksUri() {
            Object obj = this.jwksUri_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.jwksUri_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getJwksUriBytes() {
            Object obj = this.jwksUri_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.jwksUri_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public JwtLocation getJwtLocations(int i10) {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.jwtLocations_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public JwtLocation.Builder getJwtLocationsBuilder(int i10) {
            return getJwtLocationsFieldBuilder().getBuilder(i10);
        }

        public List<JwtLocation.Builder> getJwtLocationsBuilderList() {
            return getJwtLocationsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public int getJwtLocationsCount() {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.jwtLocations_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public List<JwtLocation> getJwtLocationsList() {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.jwtLocations_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public JwtLocationOrBuilder getJwtLocationsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.jwtLocations_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public List<? extends JwtLocationOrBuilder> getJwtLocationsOrBuilderList() {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.jwtLocations_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return b.f53841h.ensureFieldAccessorsInitialized(AuthProvider.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder removeJwtLocations(int i10) {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureJwtLocationsIsMutable();
                this.jwtLocations_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setAudiences(String str) {
            Objects.requireNonNull(str);
            this.audiences_ = str;
            onChanged();
            return this;
        }

        public Builder setAudiencesBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.audiences_ = byteString;
            onChanged();
            return this;
        }

        public Builder setAuthorizationUrl(String str) {
            Objects.requireNonNull(str);
            this.authorizationUrl_ = str;
            onChanged();
            return this;
        }

        public Builder setAuthorizationUrlBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.authorizationUrl_ = byteString;
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

        public Builder setIssuer(String str) {
            Objects.requireNonNull(str);
            this.issuer_ = str;
            onChanged();
            return this;
        }

        public Builder setIssuerBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.issuer_ = byteString;
            onChanged();
            return this;
        }

        public Builder setJwksUri(String str) {
            Objects.requireNonNull(str);
            this.jwksUri_ = str;
            onChanged();
            return this;
        }

        public Builder setJwksUriBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.jwksUri_ = byteString;
            onChanged();
            return this;
        }

        public Builder setJwtLocations(int i10, JwtLocation jwtLocation) {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(jwtLocation);
                ensureJwtLocationsIsMutable();
                this.jwtLocations_.set(i10, jwtLocation);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, jwtLocation);
            }
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.id_ = "";
            this.issuer_ = "";
            this.jwksUri_ = "";
            this.audiences_ = "";
            this.authorizationUrl_ = "";
            this.jwtLocations_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public JwtLocation.Builder addJwtLocationsBuilder(int i10) {
            return getJwtLocationsFieldBuilder().addBuilder(i10, JwtLocation.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuthProvider build() {
            AuthProvider buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuthProvider buildPartial() {
            AuthProvider authProvider = new AuthProvider(this, (a) null);
            authProvider.id_ = this.id_;
            authProvider.issuer_ = this.issuer_;
            authProvider.jwksUri_ = this.jwksUri_;
            authProvider.audiences_ = this.audiences_;
            authProvider.authorizationUrl_ = this.authorizationUrl_;
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.jwtLocations_ = Collections.unmodifiableList(this.jwtLocations_);
                    this.bitField0_ &= -2;
                }
                authProvider.jwtLocations_ = this.jwtLocations_;
            } else {
                authProvider.jwtLocations_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return authProvider;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AuthProvider getDefaultInstanceForType() {
            return AuthProvider.getDefaultInstance();
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
            this.id_ = "";
            this.issuer_ = "";
            this.jwksUri_ = "";
            this.audiences_ = "";
            this.authorizationUrl_ = "";
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.jwtLocations_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder addJwtLocations(int i10, JwtLocation jwtLocation) {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(jwtLocation);
                ensureJwtLocationsIsMutable();
                this.jwtLocations_.add(i10, jwtLocation);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, jwtLocation);
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
            if (message instanceof AuthProvider) {
                return mergeFrom((AuthProvider) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setJwtLocations(int i10, JwtLocation.Builder builder) {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureJwtLocationsIsMutable();
                this.jwtLocations_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder mergeFrom(AuthProvider authProvider) {
            if (authProvider == AuthProvider.getDefaultInstance()) {
                return this;
            }
            if (!authProvider.getId().isEmpty()) {
                this.id_ = authProvider.id_;
                onChanged();
            }
            if (!authProvider.getIssuer().isEmpty()) {
                this.issuer_ = authProvider.issuer_;
                onChanged();
            }
            if (!authProvider.getJwksUri().isEmpty()) {
                this.jwksUri_ = authProvider.jwksUri_;
                onChanged();
            }
            if (!authProvider.getAudiences().isEmpty()) {
                this.audiences_ = authProvider.audiences_;
                onChanged();
            }
            if (!authProvider.getAuthorizationUrl().isEmpty()) {
                this.authorizationUrl_ = authProvider.authorizationUrl_;
                onChanged();
            }
            if (this.jwtLocationsBuilder_ == null) {
                if (!authProvider.jwtLocations_.isEmpty()) {
                    if (this.jwtLocations_.isEmpty()) {
                        this.jwtLocations_ = authProvider.jwtLocations_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureJwtLocationsIsMutable();
                        this.jwtLocations_.addAll(authProvider.jwtLocations_);
                    }
                    onChanged();
                }
            } else if (!authProvider.jwtLocations_.isEmpty()) {
                if (this.jwtLocationsBuilder_.isEmpty()) {
                    this.jwtLocationsBuilder_.dispose();
                    this.jwtLocationsBuilder_ = null;
                    this.jwtLocations_ = authProvider.jwtLocations_;
                    this.bitField0_ &= -2;
                    this.jwtLocationsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getJwtLocationsFieldBuilder() : null;
                } else {
                    this.jwtLocationsBuilder_.addAllMessages(authProvider.jwtLocations_);
                }
            }
            mergeUnknownFields(authProvider.unknownFields);
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.id_ = "";
            this.issuer_ = "";
            this.jwksUri_ = "";
            this.audiences_ = "";
            this.authorizationUrl_ = "";
            this.jwtLocations_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder addJwtLocations(JwtLocation.Builder builder) {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureJwtLocationsIsMutable();
                this.jwtLocations_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addJwtLocations(int i10, JwtLocation.Builder builder) {
            RepeatedFieldBuilderV3<JwtLocation, JwtLocation.Builder, JwtLocationOrBuilder> repeatedFieldBuilderV3 = this.jwtLocationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureJwtLocationsIsMutable();
                this.jwtLocations_.add(i10, builder.build());
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
        public com.google.api.AuthProvider.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.AuthProvider.access$1200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.AuthProvider r3 = (com.google.api.AuthProvider) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.AuthProvider r4 = (com.google.api.AuthProvider) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.AuthProvider.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.AuthProvider$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<AuthProvider> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthProvider parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new AuthProvider(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ AuthProvider(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static AuthProvider getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return b.f53840g;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static AuthProvider parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthProvider) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AuthProvider parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<AuthProvider> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthProvider)) {
            return super.equals(obj);
        }
        AuthProvider authProvider = (AuthProvider) obj;
        return getId().equals(authProvider.getId()) && getIssuer().equals(authProvider.getIssuer()) && getJwksUri().equals(authProvider.getJwksUri()) && getAudiences().equals(authProvider.getAudiences()) && getAuthorizationUrl().equals(authProvider.getAuthorizationUrl()) && getJwtLocationsList().equals(authProvider.getJwtLocationsList()) && this.unknownFields.equals(authProvider.unknownFields);
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public String getAudiences() {
        Object obj = this.audiences_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.audiences_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getAudiencesBytes() {
        Object obj = this.audiences_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.audiences_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public String getAuthorizationUrl() {
        Object obj = this.authorizationUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.authorizationUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getAuthorizationUrlBytes() {
        Object obj = this.authorizationUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.authorizationUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public String getId() {
        Object obj = this.id_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.id_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getIdBytes() {
        Object obj = this.id_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.id_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public String getIssuer() {
        Object obj = this.issuer_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.issuer_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getIssuerBytes() {
        Object obj = this.issuer_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.issuer_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public String getJwksUri() {
        Object obj = this.jwksUri_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.jwksUri_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getJwksUriBytes() {
        Object obj = this.jwksUri_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.jwksUri_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public JwtLocation getJwtLocations(int i10) {
        return this.jwtLocations_.get(i10);
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public int getJwtLocationsCount() {
        return this.jwtLocations_.size();
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public List<JwtLocation> getJwtLocationsList() {
        return this.jwtLocations_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public JwtLocationOrBuilder getJwtLocationsOrBuilder(int i10) {
        return this.jwtLocations_.get(i10);
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public List<? extends JwtLocationOrBuilder> getJwtLocationsOrBuilderList() {
        return this.jwtLocations_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AuthProvider> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = !GeneratedMessageV3.isStringEmpty(this.id_) ? GeneratedMessageV3.computeStringSize(1, this.id_) + 0 : 0;
        if (!GeneratedMessageV3.isStringEmpty(this.issuer_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.issuer_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.jwksUri_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(3, this.jwksUri_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.audiences_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(4, this.audiences_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.authorizationUrl_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(5, this.authorizationUrl_);
        }
        for (int i11 = 0; i11 < this.jwtLocations_.size(); i11++) {
            computeStringSize += CodedOutputStream.computeMessageSize(6, this.jwtLocations_.get(i11));
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
        int hashCode = ((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getId().hashCode()) * 37) + 2) * 53) + getIssuer().hashCode()) * 37) + 3) * 53) + getJwksUri().hashCode()) * 37) + 4) * 53) + getAudiences().hashCode()) * 37) + 5) * 53) + getAuthorizationUrl().hashCode();
        if (getJwtLocationsCount() > 0) {
            hashCode = (((hashCode * 37) + 6) * 53) + getJwtLocationsList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return b.f53841h.ensureFieldAccessorsInitialized(AuthProvider.class, Builder.class);
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
        return new AuthProvider();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.id_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.id_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.issuer_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.issuer_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.jwksUri_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.jwksUri_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.audiences_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.audiences_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.authorizationUrl_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.authorizationUrl_);
        }
        for (int i10 = 0; i10 < this.jwtLocations_.size(); i10++) {
            codedOutputStream.writeMessage(6, this.jwtLocations_.get(i10));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ AuthProvider(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(AuthProvider authProvider) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(authProvider);
    }

    public static AuthProvider parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthProvider) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AuthProvider parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private AuthProvider(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static AuthProvider parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AuthProvider getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static AuthProvider parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private AuthProvider() {
        this.memoizedIsInitialized = (byte) -1;
        this.id_ = "";
        this.issuer_ = "";
        this.jwksUri_ = "";
        this.audiences_ = "";
        this.authorizationUrl_ = "";
        this.jwtLocations_ = Collections.emptyList();
    }

    public static AuthProvider parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static AuthProvider parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static AuthProvider parseFrom(InputStream inputStream) throws IOException {
        return (AuthProvider) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static AuthProvider parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthProvider) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AuthProvider parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthProvider) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static AuthProvider parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthProvider) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AuthProvider(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.id_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.issuer_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.jwksUri_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.audiences_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                this.authorizationUrl_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag != 50) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z11 & true)) {
                                    this.jwtLocations_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.jwtLocations_.add(codedInputStream.readMessage(JwtLocation.parser(), extensionRegistryLite));
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
                if (z11 & true) {
                    this.jwtLocations_ = Collections.unmodifiableList(this.jwtLocations_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }
}
