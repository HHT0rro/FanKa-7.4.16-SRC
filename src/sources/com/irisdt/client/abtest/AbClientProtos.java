package com.irisdt.client.abtest;

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
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import com.irisdt.CommonProtos;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class AbClientProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014AbClientProtos.proto\u0012\u0018com.irisdt.client.abtest\u001a\u0012CommonProtos.proto\"Q\n\u0007Request\u0012\u0013\n\u000bdecision_id\u0018\u0001 \u0001(\t\u0012\r\n\u0005token\u0018\u0002 \u0001(\t\u0012\"\n\u0006common\u0018\u0003 \u0001(\u000b2\u0012.com.irisdt.Common\"~\n\bAbResult\u0012\u000b\n\u0003gid\u0018\u0001 \u0001(\u0003\u0012\u0012\n\nparam_type\u0018\u0002 \u0001(\u0005\u0012\u0013\n\u000bparam_value\u0018\u0003 \u0001(\t\u0012\u0010\n\bis_track\u0018\u0004 \u0001(\b\u0012\u0017\n\u000fis_group_freeze\u0018\u0005 \u0001(\b\u0012\u0011\n\tis_freeze\u0018\u0006 \u0001(\b\"¿\u0001\n\bResponse\u0012@\n\u0007results\u0018\u0001 \u0003(\u000b2/.com.irisdt.client.abtest.Response.ResultsEntry\u0012\f\n\u0004code\u0018\u0002 \u0001(\u0005\u0012\u000f\n\u0007message\u0018\u0003 \u0001(\t\u001aR\n\fResultsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u00121\n\u0005value\u0018\u0002 \u0001(\u000b2\".com.irisdt.client.abtest.AbResult:\u00028\u00012i\n\u000fAbClientService\u0012V\n\u000bgetAbResult\u0012!.com.irisdt.client.abtest.Request\u001a\".com.irisdt.client.abtest.Response\"\u0000B\f¢\u0002\tAB_RESULTb\u0006proto3"}, new Descriptors.FileDescriptor[]{CommonProtos.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_abtest_AbResult_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_abtest_AbResult_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_abtest_Request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_abtest_Request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_abtest_Response_ResultsEntry_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_abtest_Response_ResultsEntry_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_abtest_Response_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_abtest_Response_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class AbResult extends GeneratedMessageV3 implements AbResultOrBuilder {
        public static final int GID_FIELD_NUMBER = 1;
        public static final int IS_FREEZE_FIELD_NUMBER = 6;
        public static final int IS_GROUP_FREEZE_FIELD_NUMBER = 5;
        public static final int IS_TRACK_FIELD_NUMBER = 4;
        public static final int PARAM_TYPE_FIELD_NUMBER = 2;
        public static final int PARAM_VALUE_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private long gid_;
        private boolean isFreeze_;
        private boolean isGroupFreeze_;
        private boolean isTrack_;
        private byte memoizedIsInitialized;
        private int paramType_;
        private volatile Object paramValue_;
        private static final AbResult DEFAULT_INSTANCE = new AbResult();
        private static final Parser<AbResult> PARSER = new AbstractParser<AbResult>() { // from class: com.irisdt.client.abtest.AbClientProtos.AbResult.1
            @Override // com.google.protobuf.Parser
            public AbResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AbResult(codedInputStream, extensionRegistryLite);
            }
        };

        public static AbResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbClientProtos.internal_static_com_irisdt_client_abtest_AbResult_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static AbResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AbResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AbResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<AbResult> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbResult)) {
                return super.equals(obj);
            }
            AbResult abResult = (AbResult) obj;
            return getGid() == abResult.getGid() && getParamType() == abResult.getParamType() && getParamValue().equals(abResult.getParamValue()) && getIsTrack() == abResult.getIsTrack() && getIsGroupFreeze() == abResult.getIsGroupFreeze() && getIsFreeze() == abResult.getIsFreeze() && this.unknownFields.equals(abResult.unknownFields);
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
        public long getGid() {
            return this.gid_;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
        public boolean getIsFreeze() {
            return this.isFreeze_;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
        public boolean getIsGroupFreeze() {
            return this.isGroupFreeze_;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
        public boolean getIsTrack() {
            return this.isTrack_;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
        public int getParamType() {
            return this.paramType_;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
        public String getParamValue() {
            Object obj = this.paramValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.paramValue_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
        public ByteString getParamValueBytes() {
            Object obj = this.paramValue_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.paramValue_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbResult> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            long j10 = this.gid_;
            int computeInt64Size = j10 != 0 ? 0 + CodedOutputStream.computeInt64Size(1, j10) : 0;
            int i11 = this.paramType_;
            if (i11 != 0) {
                computeInt64Size += CodedOutputStream.computeInt32Size(2, i11);
            }
            if (!getParamValueBytes().isEmpty()) {
                computeInt64Size += GeneratedMessageV3.computeStringSize(3, this.paramValue_);
            }
            boolean z10 = this.isTrack_;
            if (z10) {
                computeInt64Size += CodedOutputStream.computeBoolSize(4, z10);
            }
            boolean z11 = this.isGroupFreeze_;
            if (z11) {
                computeInt64Size += CodedOutputStream.computeBoolSize(5, z11);
            }
            boolean z12 = this.isFreeze_;
            if (z12) {
                computeInt64Size += CodedOutputStream.computeBoolSize(6, z12);
            }
            int serializedSize = computeInt64Size + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getGid())) * 37) + 2) * 53) + getParamType()) * 37) + 3) * 53) + getParamValue().hashCode()) * 37) + 4) * 53) + Internal.hashBoolean(getIsTrack())) * 37) + 5) * 53) + Internal.hashBoolean(getIsGroupFreeze())) * 37) + 6) * 53) + Internal.hashBoolean(getIsFreeze())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbClientProtos.internal_static_com_irisdt_client_abtest_AbResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AbResult.class, Builder.class);
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
            return new AbResult();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j10 = this.gid_;
            if (j10 != 0) {
                codedOutputStream.writeInt64(1, j10);
            }
            int i10 = this.paramType_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(2, i10);
            }
            if (!getParamValueBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.paramValue_);
            }
            boolean z10 = this.isTrack_;
            if (z10) {
                codedOutputStream.writeBool(4, z10);
            }
            boolean z11 = this.isGroupFreeze_;
            if (z11) {
                codedOutputStream.writeBool(5, z11);
            }
            boolean z12 = this.isFreeze_;
            if (z12) {
                codedOutputStream.writeBool(6, z12);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbResultOrBuilder {
            private long gid_;
            private boolean isFreeze_;
            private boolean isGroupFreeze_;
            private boolean isTrack_;
            private int paramType_;
            private Object paramValue_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbClientProtos.internal_static_com_irisdt_client_abtest_AbResult_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearGid() {
                this.gid_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearIsFreeze() {
                this.isFreeze_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsGroupFreeze() {
                this.isGroupFreeze_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTrack() {
                this.isTrack_ = false;
                onChanged();
                return this;
            }

            public Builder clearParamType() {
                this.paramType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearParamValue() {
                this.paramValue_ = AbResult.getDefaultInstance().getParamValue();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbClientProtos.internal_static_com_irisdt_client_abtest_AbResult_descriptor;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
            public long getGid() {
                return this.gid_;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
            public boolean getIsFreeze() {
                return this.isFreeze_;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
            public boolean getIsGroupFreeze() {
                return this.isGroupFreeze_;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
            public boolean getIsTrack() {
                return this.isTrack_;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
            public int getParamType() {
                return this.paramType_;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
            public String getParamValue() {
                Object obj = this.paramValue_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.paramValue_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.AbResultOrBuilder
            public ByteString getParamValueBytes() {
                Object obj = this.paramValue_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.paramValue_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbClientProtos.internal_static_com_irisdt_client_abtest_AbResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AbResult.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setGid(long j10) {
                this.gid_ = j10;
                onChanged();
                return this;
            }

            public Builder setIsFreeze(boolean z10) {
                this.isFreeze_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsGroupFreeze(boolean z10) {
                this.isGroupFreeze_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsTrack(boolean z10) {
                this.isTrack_ = z10;
                onChanged();
                return this;
            }

            public Builder setParamType(int i10) {
                this.paramType_ = i10;
                onChanged();
                return this;
            }

            public Builder setParamValue(String str) {
                Objects.requireNonNull(str);
                this.paramValue_ = str;
                onChanged();
                return this;
            }

            public Builder setParamValueBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.paramValue_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.paramValue_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbResult build() {
                AbResult buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbResult buildPartial() {
                AbResult abResult = new AbResult(this);
                abResult.gid_ = this.gid_;
                abResult.paramType_ = this.paramType_;
                abResult.paramValue_ = this.paramValue_;
                abResult.isTrack_ = this.isTrack_;
                abResult.isGroupFreeze_ = this.isGroupFreeze_;
                abResult.isFreeze_ = this.isFreeze_;
                onBuilt();
                return abResult;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbResult getDefaultInstanceForType() {
                return AbResult.getDefaultInstance();
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
                this.gid_ = 0L;
                this.paramType_ = 0;
                this.paramValue_ = "";
                this.isTrack_ = false;
                this.isGroupFreeze_ = false;
                this.isFreeze_ = false;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.paramValue_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof AbResult) {
                    return mergeFrom((AbResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(AbResult abResult) {
                if (abResult == AbResult.getDefaultInstance()) {
                    return this;
                }
                if (abResult.getGid() != 0) {
                    setGid(abResult.getGid());
                }
                if (abResult.getParamType() != 0) {
                    setParamType(abResult.getParamType());
                }
                if (!abResult.getParamValue().isEmpty()) {
                    this.paramValue_ = abResult.paramValue_;
                    onChanged();
                }
                if (abResult.getIsTrack()) {
                    setIsTrack(abResult.getIsTrack());
                }
                if (abResult.getIsGroupFreeze()) {
                    setIsGroupFreeze(abResult.getIsGroupFreeze());
                }
                if (abResult.getIsFreeze()) {
                    setIsFreeze(abResult.getIsFreeze());
                }
                mergeUnknownFields(abResult.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.client.abtest.AbClientProtos.AbResult.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.client.abtest.AbClientProtos.AbResult.access$2700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.client.abtest.AbClientProtos$AbResult r3 = (com.irisdt.client.abtest.AbClientProtos.AbResult) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.client.abtest.AbClientProtos$AbResult r4 = (com.irisdt.client.abtest.AbClientProtos.AbResult) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.client.abtest.AbClientProtos.AbResult.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.client.abtest.AbClientProtos$AbResult$Builder");
            }
        }

        public static Builder newBuilder(AbResult abResult) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(abResult);
        }

        public static AbResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private AbResult(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static AbResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AbResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AbResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbResult getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static AbResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private AbResult() {
            this.memoizedIsInitialized = (byte) -1;
            this.paramValue_ = "";
        }

        public static AbResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static AbResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AbResult parseFrom(InputStream inputStream) throws IOException {
            return (AbResult) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private AbResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.gid_ = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.paramType_ = codedInputStream.readInt32();
                            } else if (readTag == 26) {
                                this.paramValue_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.isTrack_ = codedInputStream.readBool();
                            } else if (readTag == 40) {
                                this.isGroupFreeze_ = codedInputStream.readBool();
                            } else if (readTag != 48) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.isFreeze_ = codedInputStream.readBool();
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

        public static AbResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AbResult) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AbResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AbResult) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AbResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AbResult) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface AbResultOrBuilder extends MessageOrBuilder {
        long getGid();

        boolean getIsFreeze();

        boolean getIsGroupFreeze();

        boolean getIsTrack();

        int getParamType();

        String getParamValue();

        ByteString getParamValueBytes();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int COMMON_FIELD_NUMBER = 3;
        public static final int DECISION_ID_FIELD_NUMBER = 1;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.irisdt.client.abtest.AbClientProtos.Request.1
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TOKEN_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private CommonProtos.Common common_;
        private volatile Object decisionId_;
        private byte memoizedIsInitialized;
        private volatile Object token_;

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbClientProtos.internal_static_com_irisdt_client_abtest_Request_descriptor;
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
            if (getDecisionId().equals(request.getDecisionId()) && getToken().equals(request.getToken()) && hasCommon() == request.hasCommon()) {
                return (!hasCommon() || getCommon().equals(request.getCommon())) && this.unknownFields.equals(request.unknownFields);
            }
            return false;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
        public CommonProtos.Common getCommon() {
            CommonProtos.Common common = this.common_;
            return common == null ? CommonProtos.Common.getDefaultInstance() : common;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
        public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
        public String getDecisionId() {
            Object obj = this.decisionId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.decisionId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
        public ByteString getDecisionIdBytes() {
            Object obj = this.decisionId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.decisionId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
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
            int computeStringSize = getDecisionIdBytes().isEmpty() ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.decisionId_);
            if (!getTokenBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(2, this.token_);
            }
            if (this.common_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, getCommon());
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
        public String getToken() {
            Object obj = this.token_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.token_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
        public ByteString getTokenBytes() {
            Object obj = this.token_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.token_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getDecisionId().hashCode()) * 37) + 2) * 53) + getToken().hashCode();
            if (hasCommon()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getCommon().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbClientProtos.internal_static_com_irisdt_client_abtest_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
            if (!getDecisionIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.decisionId_);
            }
            if (!getTokenBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.token_);
            }
            if (this.common_ != null) {
                codedOutputStream.writeMessage(3, getCommon());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestOrBuilder {
            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
            private CommonProtos.Common common_;
            private Object decisionId_;
            private Object token_;

            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AbClientProtos.internal_static_com_irisdt_client_abtest_Request_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
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

            public Builder clearDecisionId() {
                this.decisionId_ = Request.getDefaultInstance().getDecisionId();
                onChanged();
                return this;
            }

            public Builder clearToken() {
                this.token_ = Request.getDefaultInstance().getToken();
                onChanged();
                return this;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
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

            @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
            public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                CommonProtos.Common common = this.common_;
                return common == null ? CommonProtos.Common.getDefaultInstance() : common;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
            public String getDecisionId() {
                Object obj = this.decisionId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.decisionId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
            public ByteString getDecisionIdBytes() {
                Object obj = this.decisionId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.decisionId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbClientProtos.internal_static_com_irisdt_client_abtest_Request_descriptor;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
            public String getToken() {
                Object obj = this.token_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.token_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
            public ByteString getTokenBytes() {
                Object obj = this.token_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.token_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.RequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbClientProtos.internal_static_com_irisdt_client_abtest_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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

            public Builder setDecisionId(String str) {
                Objects.requireNonNull(str);
                this.decisionId_ = str;
                onChanged();
                return this;
            }

            public Builder setDecisionIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.decisionId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setToken(String str) {
                Objects.requireNonNull(str);
                this.token_ = str;
                onChanged();
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.token_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.decisionId_ = "";
                this.token_ = "";
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
                request.decisionId_ = this.decisionId_;
                request.token_ = this.token_;
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    request.common_ = this.common_;
                } else {
                    request.common_ = singleFieldBuilderV3.build();
                }
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
                this.decisionId_ = "";
                this.token_ = "";
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                } else {
                    this.common_ = null;
                    this.commonBuilder_ = null;
                }
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

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.decisionId_ = "";
                this.token_ = "";
                maybeForceBuilderInitialization();
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
                if (!request.getDecisionId().isEmpty()) {
                    this.decisionId_ = request.decisionId_;
                    onChanged();
                }
                if (!request.getToken().isEmpty()) {
                    this.token_ = request.token_;
                    onChanged();
                }
                if (request.hasCommon()) {
                    mergeCommon(request.getCommon());
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
            public com.irisdt.client.abtest.AbClientProtos.Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.client.abtest.AbClientProtos.Request.access$1000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.client.abtest.AbClientProtos$Request r3 = (com.irisdt.client.abtest.AbClientProtos.Request) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.client.abtest.AbClientProtos$Request r4 = (com.irisdt.client.abtest.AbClientProtos.Request) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.client.abtest.AbClientProtos.Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.client.abtest.AbClientProtos$Request$Builder");
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
            this.decisionId_ = "";
            this.token_ = "";
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
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.decisionId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.token_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag != 26) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                CommonProtos.Common common = this.common_;
                                CommonProtos.Common.Builder builder = common != null ? common.toBuilder() : null;
                                CommonProtos.Common common2 = (CommonProtos.Common) codedInputStream.readMessage(CommonProtos.Common.parser(), extensionRegistryLite);
                                this.common_ = common2;
                                if (builder != null) {
                                    builder.mergeFrom(common2);
                                    this.common_ = builder.buildPartial();
                                }
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
        CommonProtos.Common getCommon();

        CommonProtos.CommonOrBuilder getCommonOrBuilder();

        String getDecisionId();

        ByteString getDecisionIdBytes();

        String getToken();

        ByteString getTokenBytes();

        boolean hasCommon();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 2;
        public static final int MESSAGE_FIELD_NUMBER = 3;
        public static final int RESULTS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;
        private volatile Object message_;
        private MapField<String, AbResult> results_;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final Parser<Response> PARSER = new AbstractParser<Response>() { // from class: com.irisdt.client.abtest.AbClientProtos.Response.1
            @Override // com.google.protobuf.Parser
            public Response parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Response(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class ResultsDefaultEntryHolder {
            public static final MapEntry<String, AbResult> defaultEntry = MapEntry.newDefaultInstance(AbClientProtos.internal_static_com_irisdt_client_abtest_Response_ResultsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, AbResult.getDefaultInstance());

            private ResultsDefaultEntryHolder() {
            }
        }

        public static Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbClientProtos.internal_static_com_irisdt_client_abtest_Response_descriptor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, AbResult> internalGetResults() {
            MapField<String, AbResult> mapField = this.results_;
            return mapField == null ? MapField.emptyMapField(ResultsDefaultEntryHolder.defaultEntry) : mapField;
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

        @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
        public boolean containsResults(String str) {
            Objects.requireNonNull(str);
            return internalGetResults().getMap().containsKey(str);
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
            return internalGetResults().equals(response.internalGetResults()) && getCode() == response.getCode() && getMessage().equals(response.getMessage()) && this.unknownFields.equals(response.unknownFields);
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
        public String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.message_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
        public ByteString getMessageBytes() {
            Object obj = this.message_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Response> getParserForType() {
            return PARSER;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
        @Deprecated
        public Map<String, AbResult> getResults() {
            return getResultsMap();
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
        public int getResultsCount() {
            return internalGetResults().getMap().size();
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
        public Map<String, AbResult> getResultsMap() {
            return internalGetResults().getMap();
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
        public AbResult getResultsOrDefault(String str, AbResult abResult) {
            Objects.requireNonNull(str);
            Map<String, AbResult> map = internalGetResults().getMap();
            return map.containsKey(str) ? map.get(str) : abResult;
        }

        @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
        public AbResult getResultsOrThrow(String str) {
            Objects.requireNonNull(str);
            Map<String, AbResult> map = internalGetResults().getMap();
            if (map.containsKey(str)) {
                return map.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (Map.Entry<String, AbResult> entry : internalGetResults().getMap().entrySet()) {
                i11 += CodedOutputStream.computeMessageSize(1, ResultsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int i12 = this.code_;
            if (i12 != 0) {
                i11 += CodedOutputStream.computeInt32Size(2, i12);
            }
            if (!getMessageBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.message_);
            }
            int serializedSize = i11 + this.unknownFields.getSerializedSize();
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
            int hashCode = MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode();
            if (!internalGetResults().getMap().isEmpty()) {
                hashCode = (((hashCode * 37) + 1) * 53) + internalGetResults().hashCode();
            }
            int code = (((((((((hashCode * 37) + 2) * 53) + getCode()) * 37) + 3) * 53) + getMessage().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = code;
            return code;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbClientProtos.internal_static_com_irisdt_client_abtest_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public MapField internalGetMapField(int i10) {
            if (i10 == 1) {
                return internalGetResults();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
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
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetResults(), ResultsDefaultEntryHolder.defaultEntry, 1);
            int i10 = this.code_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(2, i10);
            }
            if (!getMessageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.message_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResponseOrBuilder {
            private int bitField0_;
            private int code_;
            private Object message_;
            private MapField<String, AbResult> results_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbClientProtos.internal_static_com_irisdt_client_abtest_Response_descriptor;
            }

            private MapField<String, AbResult> internalGetMutableResults() {
                onChanged();
                if (this.results_ == null) {
                    this.results_ = MapField.newMapField(ResultsDefaultEntryHolder.defaultEntry);
                }
                if (!this.results_.isMutable()) {
                    this.results_ = this.results_.copy();
                }
                return this.results_;
            }

            private MapField<String, AbResult> internalGetResults() {
                MapField<String, AbResult> mapField = this.results_;
                return mapField == null ? MapField.emptyMapField(ResultsDefaultEntryHolder.defaultEntry) : mapField;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMessage() {
                this.message_ = Response.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public Builder clearResults() {
                internalGetMutableResults().getMutableMap().clear();
                return this;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
            public boolean containsResults(String str) {
                Objects.requireNonNull(str);
                return internalGetResults().getMap().containsKey(str);
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbClientProtos.internal_static_com_irisdt_client_abtest_Response_descriptor;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
            public String getMessage() {
                Object obj = this.message_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.message_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
            public ByteString getMessageBytes() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.message_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Deprecated
            public Map<String, AbResult> getMutableResults() {
                return internalGetMutableResults().getMutableMap();
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
            @Deprecated
            public Map<String, AbResult> getResults() {
                return getResultsMap();
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
            public int getResultsCount() {
                return internalGetResults().getMap().size();
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
            public Map<String, AbResult> getResultsMap() {
                return internalGetResults().getMap();
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
            public AbResult getResultsOrDefault(String str, AbResult abResult) {
                Objects.requireNonNull(str);
                Map<String, AbResult> map = internalGetResults().getMap();
                return map.containsKey(str) ? map.get(str) : abResult;
            }

            @Override // com.irisdt.client.abtest.AbClientProtos.ResponseOrBuilder
            public AbResult getResultsOrThrow(String str) {
                Objects.requireNonNull(str);
                Map<String, AbResult> map = internalGetResults().getMap();
                if (map.containsKey(str)) {
                    return map.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbClientProtos.internal_static_com_irisdt_client_abtest_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMapField(int i10) {
                if (i10 == 1) {
                    return internalGetResults();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMutableMapField(int i10) {
                if (i10 == 1) {
                    return internalGetMutableResults();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder putAllResults(Map<String, AbResult> map) {
                internalGetMutableResults().getMutableMap().putAll(map);
                return this;
            }

            public Builder putResults(String str, AbResult abResult) {
                Objects.requireNonNull(str);
                Objects.requireNonNull(abResult);
                internalGetMutableResults().getMutableMap().put(str, abResult);
                return this;
            }

            public Builder removeResults(String str) {
                Objects.requireNonNull(str);
                internalGetMutableResults().getMutableMap().remove(str);
                return this;
            }

            public Builder setCode(int i10) {
                this.code_ = i10;
                onChanged();
                return this;
            }

            public Builder setMessage(String str) {
                Objects.requireNonNull(str);
                this.message_ = str;
                onChanged();
                return this;
            }

            public Builder setMessageBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.message_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.message_ = "";
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
                response.results_ = internalGetResults();
                response.results_.makeImmutable();
                response.code_ = this.code_;
                response.message_ = this.message_;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                internalGetMutableResults().clear();
                this.code_ = 0;
                this.message_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
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
                internalGetMutableResults().mergeFrom(response.internalGetResults());
                if (response.getCode() != 0) {
                    setCode(response.getCode());
                }
                if (!response.getMessage().isEmpty()) {
                    this.message_ = response.message_;
                    onChanged();
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
            public com.irisdt.client.abtest.AbClientProtos.Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.client.abtest.AbClientProtos.Response.access$4200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.client.abtest.AbClientProtos$Response r3 = (com.irisdt.client.abtest.AbClientProtos.Response) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.irisdt.client.abtest.AbClientProtos$Response r4 = (com.irisdt.client.abtest.AbClientProtos.Response) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.client.abtest.AbClientProtos.Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.client.abtest.AbClientProtos$Response$Builder");
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
            this.message_ = "";
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

        public static Response parseFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Response(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    if (!(z11 & true)) {
                                        this.results_ = MapField.newMapField(ResultsDefaultEntryHolder.defaultEntry);
                                        z11 |= true;
                                    }
                                    MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(ResultsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                    this.results_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                                } else if (readTag == 16) {
                                    this.code_ = codedInputStream.readInt32();
                                } else if (readTag != 26) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.message_ = codedInputStream.readStringRequireUtf8();
                                }
                            }
                            z10 = true;
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
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
        boolean containsResults(String str);

        int getCode();

        String getMessage();

        ByteString getMessageBytes();

        @Deprecated
        Map<String, AbResult> getResults();

        int getResultsCount();

        Map<String, AbResult> getResultsMap();

        AbResult getResultsOrDefault(String str, AbResult abResult);

        AbResult getResultsOrThrow(String str);
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_irisdt_client_abtest_Request_descriptor = descriptor2;
        internal_static_com_irisdt_client_abtest_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"DecisionId", "Token", "Common"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_irisdt_client_abtest_AbResult_descriptor = descriptor3;
        internal_static_com_irisdt_client_abtest_AbResult_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Gid", "ParamType", "ParamValue", "IsTrack", "IsGroupFreeze", "IsFreeze"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_irisdt_client_abtest_Response_descriptor = descriptor4;
        internal_static_com_irisdt_client_abtest_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Results", "Code", "Message"});
        Descriptors.Descriptor descriptor5 = descriptor4.getNestedTypes().get(0);
        internal_static_com_irisdt_client_abtest_Response_ResultsEntry_descriptor = descriptor5;
        internal_static_com_irisdt_client_abtest_Response_ResultsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Key", "Value"});
        CommonProtos.getDescriptor();
    }

    private AbClientProtos() {
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
