package com.google.longrunning;

import com.android.internal.logging.nano.MetricsProto;
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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.rpc.Status;
import com.google.rpc.StatusOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Operation extends GeneratedMessageV3 implements OperationOrBuilder {
    public static final int DONE_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int RESPONSE_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private boolean done_;
    private byte memoizedIsInitialized;
    private Any metadata_;
    private volatile Object name_;
    private int resultCase_;
    private Object result_;
    private static final Operation DEFAULT_INSTANCE = new Operation();
    private static final Parser<Operation> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OperationOrBuilder {
        private boolean done_;
        private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> errorBuilder_;
        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> metadataBuilder_;
        private Any metadata_;
        private Object name_;
        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> responseBuilder_;
        private int resultCase_;
        private Object result_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return h8.a.f49535b;
        }

        private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> getErrorFieldBuilder() {
            if (this.errorBuilder_ == null) {
                if (this.resultCase_ != 4) {
                    this.result_ = Status.getDefaultInstance();
                }
                this.errorBuilder_ = new SingleFieldBuilderV3<>((Status) this.result_, getParentForChildren(), isClean());
                this.result_ = null;
            }
            this.resultCase_ = 4;
            onChanged();
            return this.errorBuilder_;
        }

        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getMetadataFieldBuilder() {
            if (this.metadataBuilder_ == null) {
                this.metadataBuilder_ = new SingleFieldBuilderV3<>(getMetadata(), getParentForChildren(), isClean());
                this.metadata_ = null;
            }
            return this.metadataBuilder_;
        }

        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getResponseFieldBuilder() {
            if (this.responseBuilder_ == null) {
                if (this.resultCase_ != 5) {
                    this.result_ = Any.getDefaultInstance();
                }
                this.responseBuilder_ = new SingleFieldBuilderV3<>((Any) this.result_, getParentForChildren(), isClean());
                this.result_ = null;
            }
            this.resultCase_ = 5;
            onChanged();
            return this.responseBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearDone() {
            this.done_ = false;
            onChanged();
            return this;
        }

        public Builder clearError() {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.resultCase_ == 4) {
                    this.resultCase_ = 0;
                    this.result_ = null;
                    onChanged();
                }
            } else {
                if (this.resultCase_ == 4) {
                    this.resultCase_ = 0;
                    this.result_ = null;
                }
                singleFieldBuilderV3.clear();
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

        public Builder clearName() {
            this.name_ = Operation.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder clearResponse() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.resultCase_ == 5) {
                    this.resultCase_ = 0;
                    this.result_ = null;
                    onChanged();
                }
            } else {
                if (this.resultCase_ == 5) {
                    this.resultCase_ = 0;
                    this.result_ = null;
                }
                singleFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearResult() {
            this.resultCase_ = 0;
            this.result_ = null;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return h8.a.f49535b;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public boolean getDone() {
            return this.done_;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public Status getError() {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.resultCase_ == 4) {
                    return (Status) this.result_;
                }
                return Status.getDefaultInstance();
            }
            if (this.resultCase_ == 4) {
                return singleFieldBuilderV3.getMessage();
            }
            return Status.getDefaultInstance();
        }

        public Status.Builder getErrorBuilder() {
            return getErrorFieldBuilder().getBuilder();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public StatusOrBuilder getErrorOrBuilder() {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3;
            int i10 = this.resultCase_;
            if (i10 == 4 && (singleFieldBuilderV3 = this.errorBuilder_) != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i10 == 4) {
                return (Status) this.result_;
            }
            return Status.getDefaultInstance();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public Any getMetadata() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Any any = this.metadata_;
                return any == null ? Any.getDefaultInstance() : any;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Any.Builder getMetadataBuilder() {
            onChanged();
            return getMetadataFieldBuilder().getBuilder();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public AnyOrBuilder getMetadataOrBuilder() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Any any = this.metadata_;
            return any == null ? Any.getDefaultInstance() : any;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public Any getResponse() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.resultCase_ == 5) {
                    return (Any) this.result_;
                }
                return Any.getDefaultInstance();
            }
            if (this.resultCase_ == 5) {
                return singleFieldBuilderV3.getMessage();
            }
            return Any.getDefaultInstance();
        }

        public Any.Builder getResponseBuilder() {
            return getResponseFieldBuilder().getBuilder();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public AnyOrBuilder getResponseOrBuilder() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3;
            int i10 = this.resultCase_;
            if (i10 == 5 && (singleFieldBuilderV3 = this.responseBuilder_) != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i10 == 5) {
                return (Any) this.result_;
            }
            return Any.getDefaultInstance();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public ResultCase getResultCase() {
            return ResultCase.forNumber(this.resultCase_);
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public boolean hasError() {
            return this.resultCase_ == 4;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public boolean hasMetadata() {
            return (this.metadataBuilder_ == null && this.metadata_ == null) ? false : true;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public boolean hasResponse() {
            return this.resultCase_ == 5;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return h8.a.f49536c.ensureFieldAccessorsInitialized(Operation.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeError(Status status) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.resultCase_ == 4 && this.result_ != Status.getDefaultInstance()) {
                    this.result_ = Status.newBuilder((Status) this.result_).mergeFrom(status).buildPartial();
                } else {
                    this.result_ = status;
                }
                onChanged();
            } else if (this.resultCase_ == 4) {
                singleFieldBuilderV3.mergeFrom(status);
            } else {
                singleFieldBuilderV3.setMessage(status);
            }
            this.resultCase_ = 4;
            return this;
        }

        public Builder mergeMetadata(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Any any2 = this.metadata_;
                if (any2 != null) {
                    this.metadata_ = Any.newBuilder(any2).mergeFrom(any).buildPartial();
                } else {
                    this.metadata_ = any;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(any);
            }
            return this;
        }

        public Builder mergeResponse(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.resultCase_ == 5 && this.result_ != Any.getDefaultInstance()) {
                    this.result_ = Any.newBuilder((Any) this.result_).mergeFrom(any).buildPartial();
                } else {
                    this.result_ = any;
                }
                onChanged();
            } else if (this.resultCase_ == 5) {
                singleFieldBuilderV3.mergeFrom(any);
            } else {
                singleFieldBuilderV3.setMessage(any);
            }
            this.resultCase_ = 5;
            return this;
        }

        public Builder setDone(boolean z10) {
            this.done_ = z10;
            onChanged();
            return this;
        }

        public Builder setError(Status status) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(status);
                this.result_ = status;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(status);
            }
            this.resultCase_ = 4;
            return this;
        }

        public Builder setMetadata(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(any);
                this.metadata_ = any;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(any);
            }
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

        public Builder setResponse(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(any);
                this.result_ = any;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(any);
            }
            this.resultCase_ = 5;
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.resultCase_ = 0;
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Operation build() {
            Operation buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Operation buildPartial() {
            Operation operation = new Operation(this, (a) null);
            operation.name_ = this.name_;
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                operation.metadata_ = this.metadata_;
            } else {
                operation.metadata_ = singleFieldBuilderV3.build();
            }
            operation.done_ = this.done_;
            if (this.resultCase_ == 4) {
                SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV32 = this.errorBuilder_;
                if (singleFieldBuilderV32 == null) {
                    operation.result_ = this.result_;
                } else {
                    operation.result_ = singleFieldBuilderV32.build();
                }
            }
            if (this.resultCase_ == 5) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV33 = this.responseBuilder_;
                if (singleFieldBuilderV33 == null) {
                    operation.result_ = this.result_;
                } else {
                    operation.result_ = singleFieldBuilderV33.build();
                }
            }
            operation.resultCase_ = this.resultCase_;
            onBuilt();
            return operation;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Operation getDefaultInstanceForType() {
            return Operation.getDefaultInstance();
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
            this.name_ = "";
            if (this.metadataBuilder_ == null) {
                this.metadata_ = null;
            } else {
                this.metadata_ = null;
                this.metadataBuilder_ = null;
            }
            this.done_ = false;
            this.resultCase_ = 0;
            this.result_ = null;
            return this;
        }

        public Builder setMetadata(Any.Builder builder) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.metadata_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.resultCase_ = 0;
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Operation) {
                return mergeFrom((Operation) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setError(Status.Builder builder) {
            SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.result_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.resultCase_ = 4;
            return this;
        }

        public Builder setResponse(Any.Builder builder) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.result_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.resultCase_ = 5;
            return this;
        }

        public Builder mergeFrom(Operation operation) {
            if (operation == Operation.getDefaultInstance()) {
                return this;
            }
            if (!operation.getName().isEmpty()) {
                this.name_ = operation.name_;
                onChanged();
            }
            if (operation.hasMetadata()) {
                mergeMetadata(operation.getMetadata());
            }
            if (operation.getDone()) {
                setDone(operation.getDone());
            }
            int i10 = b.f27034a[operation.getResultCase().ordinal()];
            if (i10 == 1) {
                mergeError(operation.getError());
            } else if (i10 == 2) {
                mergeResponse(operation.getResponse());
            }
            mergeUnknownFields(operation.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.longrunning.Operation.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.longrunning.Operation.access$1000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.longrunning.Operation r3 = (com.google.longrunning.Operation) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.longrunning.Operation r4 = (com.google.longrunning.Operation) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.longrunning.Operation.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.longrunning.Operation$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum ResultCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        ERROR(4),
        RESPONSE(5),
        RESULT_NOT_SET(0);

        private final int value;

        ResultCase(int i10) {
            this.value = i10;
        }

        public static ResultCase forNumber(int i10) {
            if (i10 == 0) {
                return RESULT_NOT_SET;
            }
            if (i10 == 4) {
                return ERROR;
            }
            if (i10 != 5) {
                return null;
            }
            return RESPONSE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ResultCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<Operation> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Operation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Operation(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27034a;

        static {
            int[] iArr = new int[ResultCase.values().length];
            f27034a = iArr;
            try {
                iArr[ResultCase.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27034a[ResultCase.RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27034a[ResultCase.RESULT_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public /* synthetic */ Operation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static Operation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return h8.a.f49535b;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Operation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Operation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Operation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Operation> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Operation)) {
            return super.equals(obj);
        }
        Operation operation = (Operation) obj;
        if (!getName().equals(operation.getName()) || hasMetadata() != operation.hasMetadata()) {
            return false;
        }
        if ((hasMetadata() && !getMetadata().equals(operation.getMetadata())) || getDone() != operation.getDone() || !getResultCase().equals(operation.getResultCase())) {
            return false;
        }
        int i10 = this.resultCase_;
        if (i10 != 4) {
            if (i10 == 5 && !getResponse().equals(operation.getResponse())) {
                return false;
            }
        } else if (!getError().equals(operation.getError())) {
            return false;
        }
        return this.unknownFields.equals(operation.unknownFields);
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public boolean getDone() {
        return this.done_;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public Status getError() {
        if (this.resultCase_ == 4) {
            return (Status) this.result_;
        }
        return Status.getDefaultInstance();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public StatusOrBuilder getErrorOrBuilder() {
        if (this.resultCase_ == 4) {
            return (Status) this.result_;
        }
        return Status.getDefaultInstance();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public Any getMetadata() {
        Any any = this.metadata_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public AnyOrBuilder getMetadataOrBuilder() {
        return getMetadata();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Operation> getParserForType() {
        return PARSER;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public Any getResponse() {
        if (this.resultCase_ == 5) {
            return (Any) this.result_;
        }
        return Any.getDefaultInstance();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public AnyOrBuilder getResponseOrBuilder() {
        if (this.resultCase_ == 5) {
            return (Any) this.result_;
        }
        return Any.getDefaultInstance();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public ResultCase getResultCase() {
        return ResultCase.forNumber(this.resultCase_);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = GeneratedMessageV3.isStringEmpty(this.name_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
        if (this.metadata_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, getMetadata());
        }
        boolean z10 = this.done_;
        if (z10) {
            computeStringSize += CodedOutputStream.computeBoolSize(3, z10);
        }
        if (this.resultCase_ == 4) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, (Status) this.result_);
        }
        if (this.resultCase_ == 5) {
            computeStringSize += CodedOutputStream.computeMessageSize(5, (Any) this.result_);
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public boolean hasError() {
        return this.resultCase_ == 4;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public boolean hasResponse() {
        return this.resultCase_ == 5;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10;
        int hashCode;
        int i11 = this.memoizedHashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode2 = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (hasMetadata()) {
            hashCode2 = (((hashCode2 * 37) + 2) * 53) + getMetadata().hashCode();
        }
        int hashBoolean = (((hashCode2 * 37) + 3) * 53) + Internal.hashBoolean(getDone());
        int i12 = this.resultCase_;
        if (i12 == 4) {
            i10 = ((hashBoolean * 37) + 4) * 53;
            hashCode = getError().hashCode();
        } else {
            if (i12 == 5) {
                i10 = ((hashBoolean * 37) + 5) * 53;
                hashCode = getResponse().hashCode();
            }
            int hashCode3 = (hashBoolean * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode3;
            return hashCode3;
        }
        hashBoolean = i10 + hashCode;
        int hashCode32 = (hashBoolean * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode32;
        return hashCode32;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return h8.a.f49536c.ensureFieldAccessorsInitialized(Operation.class, Builder.class);
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
        return new Operation();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (this.metadata_ != null) {
            codedOutputStream.writeMessage(2, getMetadata());
        }
        boolean z10 = this.done_;
        if (z10) {
            codedOutputStream.writeBool(3, z10);
        }
        if (this.resultCase_ == 4) {
            codedOutputStream.writeMessage(4, (Status) this.result_);
        }
        if (this.resultCase_ == 5) {
            codedOutputStream.writeMessage(5, (Any) this.result_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ Operation(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(Operation operation) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(operation);
    }

    public static Operation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Operation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private Operation(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.resultCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Operation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Operation getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static Operation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Operation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    private Operation() {
        this.resultCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
    }

    public static Operation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Operation parseFrom(InputStream inputStream) throws IOException {
        return (Operation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Operation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Operation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Operation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    private Operation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag != 10) {
                                if (readTag == 18) {
                                    Any any = this.metadata_;
                                    Any.Builder builder = any != null ? any.toBuilder() : null;
                                    Any any2 = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                    this.metadata_ = any2;
                                    if (builder != null) {
                                        builder.mergeFrom(any2);
                                        this.metadata_ = builder.buildPartial();
                                    }
                                } else if (readTag == 24) {
                                    this.done_ = codedInputStream.readBool();
                                } else if (readTag == 34) {
                                    Status.Builder builder2 = this.resultCase_ == 4 ? ((Status) this.result_).toBuilder() : null;
                                    MessageLite readMessage = codedInputStream.readMessage(Status.parser(), extensionRegistryLite);
                                    this.result_ = readMessage;
                                    if (builder2 != null) {
                                        builder2.mergeFrom((Status) readMessage);
                                        this.result_ = builder2.buildPartial();
                                    }
                                    this.resultCase_ = 4;
                                } else if (readTag != 42) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    Any.Builder builder3 = this.resultCase_ == 5 ? ((Any) this.result_).toBuilder() : null;
                                    MessageLite readMessage2 = codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                    this.result_ = readMessage2;
                                    if (builder3 != null) {
                                        builder3.mergeFrom((Any) readMessage2);
                                        this.result_ = builder3.buildPartial();
                                    }
                                    this.resultCase_ = 5;
                                }
                            } else {
                                this.name_ = codedInputStream.readStringRequireUtf8();
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

    public static Operation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
