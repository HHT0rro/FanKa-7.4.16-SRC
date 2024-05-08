package com.google.type;

import com.android.internal.logging.nano.MetricsProto;
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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import s8.o;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class PostalAddress extends GeneratedMessageV3 implements PostalAddressOrBuilder {
    public static final int ADDRESS_LINES_FIELD_NUMBER = 9;
    public static final int ADMINISTRATIVE_AREA_FIELD_NUMBER = 6;
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    public static final int LOCALITY_FIELD_NUMBER = 7;
    public static final int ORGANIZATION_FIELD_NUMBER = 11;
    public static final int POSTAL_CODE_FIELD_NUMBER = 4;
    public static final int RECIPIENTS_FIELD_NUMBER = 10;
    public static final int REGION_CODE_FIELD_NUMBER = 2;
    public static final int REVISION_FIELD_NUMBER = 1;
    public static final int SORTING_CODE_FIELD_NUMBER = 5;
    public static final int SUBLOCALITY_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private LazyStringList addressLines_;
    private volatile Object administrativeArea_;
    private volatile Object languageCode_;
    private volatile Object locality_;
    private byte memoizedIsInitialized;
    private volatile Object organization_;
    private volatile Object postalCode_;
    private LazyStringList recipients_;
    private volatile Object regionCode_;
    private int revision_;
    private volatile Object sortingCode_;
    private volatile Object sublocality_;
    private static final PostalAddress DEFAULT_INSTANCE = new PostalAddress();
    private static final Parser<PostalAddress> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PostalAddressOrBuilder {
        private LazyStringList addressLines_;
        private Object administrativeArea_;
        private int bitField0_;
        private Object languageCode_;
        private Object locality_;
        private Object organization_;
        private Object postalCode_;
        private LazyStringList recipients_;
        private Object regionCode_;
        private int revision_;
        private Object sortingCode_;
        private Object sublocality_;

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private void ensureAddressLinesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.addressLines_ = new LazyStringArrayList(this.addressLines_);
                this.bitField0_ |= 1;
            }
        }

        private void ensureRecipientsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.recipients_ = new LazyStringArrayList(this.recipients_);
                this.bitField0_ |= 2;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return o.f53669a;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder addAddressLines(String str) {
            Objects.requireNonNull(str);
            ensureAddressLinesIsMutable();
            this.addressLines_.add((LazyStringList) str);
            onChanged();
            return this;
        }

        public Builder addAddressLinesBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureAddressLinesIsMutable();
            this.addressLines_.add(byteString);
            onChanged();
            return this;
        }

        public Builder addAllAddressLines(Iterable<String> iterable) {
            ensureAddressLinesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.addressLines_);
            onChanged();
            return this;
        }

        public Builder addAllRecipients(Iterable<String> iterable) {
            ensureRecipientsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.recipients_);
            onChanged();
            return this;
        }

        public Builder addRecipients(String str) {
            Objects.requireNonNull(str);
            ensureRecipientsIsMutable();
            this.recipients_.add((LazyStringList) str);
            onChanged();
            return this;
        }

        public Builder addRecipientsBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureRecipientsIsMutable();
            this.recipients_.add(byteString);
            onChanged();
            return this;
        }

        public Builder clearAddressLines() {
            this.addressLines_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearAdministrativeArea() {
            this.administrativeArea_ = PostalAddress.getDefaultInstance().getAdministrativeArea();
            onChanged();
            return this;
        }

        public Builder clearLanguageCode() {
            this.languageCode_ = PostalAddress.getDefaultInstance().getLanguageCode();
            onChanged();
            return this;
        }

        public Builder clearLocality() {
            this.locality_ = PostalAddress.getDefaultInstance().getLocality();
            onChanged();
            return this;
        }

        public Builder clearOrganization() {
            this.organization_ = PostalAddress.getDefaultInstance().getOrganization();
            onChanged();
            return this;
        }

        public Builder clearPostalCode() {
            this.postalCode_ = PostalAddress.getDefaultInstance().getPostalCode();
            onChanged();
            return this;
        }

        public Builder clearRecipients() {
            this.recipients_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearRegionCode() {
            this.regionCode_ = PostalAddress.getDefaultInstance().getRegionCode();
            onChanged();
            return this;
        }

        public Builder clearRevision() {
            this.revision_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSortingCode() {
            this.sortingCode_ = PostalAddress.getDefaultInstance().getSortingCode();
            onChanged();
            return this;
        }

        public Builder clearSublocality() {
            this.sublocality_ = PostalAddress.getDefaultInstance().getSublocality();
            onChanged();
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getAddressLines(int i10) {
            return this.addressLines_.get(i10);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getAddressLinesBytes(int i10) {
            return this.addressLines_.getByteString(i10);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getAddressLinesCount() {
            return this.addressLines_.size();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getAdministrativeArea() {
            Object obj = this.administrativeArea_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.administrativeArea_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getAdministrativeAreaBytes() {
            Object obj = this.administrativeArea_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.administrativeArea_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return o.f53669a;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getLanguageCode() {
            Object obj = this.languageCode_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.languageCode_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getLanguageCodeBytes() {
            Object obj = this.languageCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.languageCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getLocality() {
            Object obj = this.locality_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.locality_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getLocalityBytes() {
            Object obj = this.locality_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.locality_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getOrganization() {
            Object obj = this.organization_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.organization_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getOrganizationBytes() {
            Object obj = this.organization_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.organization_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getPostalCode() {
            Object obj = this.postalCode_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.postalCode_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getPostalCodeBytes() {
            Object obj = this.postalCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.postalCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getRecipients(int i10) {
            return this.recipients_.get(i10);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getRecipientsBytes(int i10) {
            return this.recipients_.getByteString(i10);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getRecipientsCount() {
            return this.recipients_.size();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getRegionCode() {
            Object obj = this.regionCode_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.regionCode_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getRegionCodeBytes() {
            Object obj = this.regionCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.regionCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getRevision() {
            return this.revision_;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getSortingCode() {
            Object obj = this.sortingCode_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.sortingCode_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getSortingCodeBytes() {
            Object obj = this.sortingCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sortingCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getSublocality() {
            Object obj = this.sublocality_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.sublocality_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getSublocalityBytes() {
            Object obj = this.sublocality_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sublocality_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return o.f53670b.ensureFieldAccessorsInitialized(PostalAddress.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setAddressLines(int i10, String str) {
            Objects.requireNonNull(str);
            ensureAddressLinesIsMutable();
            this.addressLines_.set(i10, (int) str);
            onChanged();
            return this;
        }

        public Builder setAdministrativeArea(String str) {
            Objects.requireNonNull(str);
            this.administrativeArea_ = str;
            onChanged();
            return this;
        }

        public Builder setAdministrativeAreaBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.administrativeArea_ = byteString;
            onChanged();
            return this;
        }

        public Builder setLanguageCode(String str) {
            Objects.requireNonNull(str);
            this.languageCode_ = str;
            onChanged();
            return this;
        }

        public Builder setLanguageCodeBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.languageCode_ = byteString;
            onChanged();
            return this;
        }

        public Builder setLocality(String str) {
            Objects.requireNonNull(str);
            this.locality_ = str;
            onChanged();
            return this;
        }

        public Builder setLocalityBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.locality_ = byteString;
            onChanged();
            return this;
        }

        public Builder setOrganization(String str) {
            Objects.requireNonNull(str);
            this.organization_ = str;
            onChanged();
            return this;
        }

        public Builder setOrganizationBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.organization_ = byteString;
            onChanged();
            return this;
        }

        public Builder setPostalCode(String str) {
            Objects.requireNonNull(str);
            this.postalCode_ = str;
            onChanged();
            return this;
        }

        public Builder setPostalCodeBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.postalCode_ = byteString;
            onChanged();
            return this;
        }

        public Builder setRecipients(int i10, String str) {
            Objects.requireNonNull(str);
            ensureRecipientsIsMutable();
            this.recipients_.set(i10, (int) str);
            onChanged();
            return this;
        }

        public Builder setRegionCode(String str) {
            Objects.requireNonNull(str);
            this.regionCode_ = str;
            onChanged();
            return this;
        }

        public Builder setRegionCodeBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.regionCode_ = byteString;
            onChanged();
            return this;
        }

        public Builder setRevision(int i10) {
            this.revision_ = i10;
            onChanged();
            return this;
        }

        public Builder setSortingCode(String str) {
            Objects.requireNonNull(str);
            this.sortingCode_ = str;
            onChanged();
            return this;
        }

        public Builder setSortingCodeBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sortingCode_ = byteString;
            onChanged();
            return this;
        }

        public Builder setSublocality(String str) {
            Objects.requireNonNull(str);
            this.sublocality_ = str;
            onChanged();
            return this;
        }

        public Builder setSublocalityBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sublocality_ = byteString;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ProtocolStringList getAddressLinesList() {
            return this.addressLines_.getUnmodifiableView();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ProtocolStringList getRecipientsList() {
            return this.recipients_.getUnmodifiableView();
        }

        private Builder() {
            this.regionCode_ = "";
            this.languageCode_ = "";
            this.postalCode_ = "";
            this.sortingCode_ = "";
            this.administrativeArea_ = "";
            this.locality_ = "";
            this.sublocality_ = "";
            LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
            this.addressLines_ = lazyStringList;
            this.recipients_ = lazyStringList;
            this.organization_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PostalAddress build() {
            PostalAddress buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PostalAddress buildPartial() {
            PostalAddress postalAddress = new PostalAddress(this, (a) null);
            postalAddress.revision_ = this.revision_;
            postalAddress.regionCode_ = this.regionCode_;
            postalAddress.languageCode_ = this.languageCode_;
            postalAddress.postalCode_ = this.postalCode_;
            postalAddress.sortingCode_ = this.sortingCode_;
            postalAddress.administrativeArea_ = this.administrativeArea_;
            postalAddress.locality_ = this.locality_;
            postalAddress.sublocality_ = this.sublocality_;
            if ((this.bitField0_ & 1) != 0) {
                this.addressLines_ = this.addressLines_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            postalAddress.addressLines_ = this.addressLines_;
            if ((this.bitField0_ & 2) != 0) {
                this.recipients_ = this.recipients_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            postalAddress.recipients_ = this.recipients_;
            postalAddress.organization_ = this.organization_;
            onBuilt();
            return postalAddress;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PostalAddress getDefaultInstanceForType() {
            return PostalAddress.getDefaultInstance();
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
            this.revision_ = 0;
            this.regionCode_ = "";
            this.languageCode_ = "";
            this.postalCode_ = "";
            this.sortingCode_ = "";
            this.administrativeArea_ = "";
            this.locality_ = "";
            this.sublocality_ = "";
            LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
            this.addressLines_ = lazyStringList;
            int i10 = this.bitField0_ & (-2);
            this.recipients_ = lazyStringList;
            this.bitField0_ = i10 & (-3);
            this.organization_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof PostalAddress) {
                return mergeFrom((PostalAddress) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(PostalAddress postalAddress) {
            if (postalAddress == PostalAddress.getDefaultInstance()) {
                return this;
            }
            if (postalAddress.getRevision() != 0) {
                setRevision(postalAddress.getRevision());
            }
            if (!postalAddress.getRegionCode().isEmpty()) {
                this.regionCode_ = postalAddress.regionCode_;
                onChanged();
            }
            if (!postalAddress.getLanguageCode().isEmpty()) {
                this.languageCode_ = postalAddress.languageCode_;
                onChanged();
            }
            if (!postalAddress.getPostalCode().isEmpty()) {
                this.postalCode_ = postalAddress.postalCode_;
                onChanged();
            }
            if (!postalAddress.getSortingCode().isEmpty()) {
                this.sortingCode_ = postalAddress.sortingCode_;
                onChanged();
            }
            if (!postalAddress.getAdministrativeArea().isEmpty()) {
                this.administrativeArea_ = postalAddress.administrativeArea_;
                onChanged();
            }
            if (!postalAddress.getLocality().isEmpty()) {
                this.locality_ = postalAddress.locality_;
                onChanged();
            }
            if (!postalAddress.getSublocality().isEmpty()) {
                this.sublocality_ = postalAddress.sublocality_;
                onChanged();
            }
            if (!postalAddress.addressLines_.isEmpty()) {
                if (this.addressLines_.isEmpty()) {
                    this.addressLines_ = postalAddress.addressLines_;
                    this.bitField0_ &= -2;
                } else {
                    ensureAddressLinesIsMutable();
                    this.addressLines_.addAll(postalAddress.addressLines_);
                }
                onChanged();
            }
            if (!postalAddress.recipients_.isEmpty()) {
                if (this.recipients_.isEmpty()) {
                    this.recipients_ = postalAddress.recipients_;
                    this.bitField0_ &= -3;
                } else {
                    ensureRecipientsIsMutable();
                    this.recipients_.addAll(postalAddress.recipients_);
                }
                onChanged();
            }
            if (!postalAddress.getOrganization().isEmpty()) {
                this.organization_ = postalAddress.organization_;
                onChanged();
            }
            mergeUnknownFields(postalAddress.unknownFields);
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.regionCode_ = "";
            this.languageCode_ = "";
            this.postalCode_ = "";
            this.sortingCode_ = "";
            this.administrativeArea_ = "";
            this.locality_ = "";
            this.sublocality_ = "";
            LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
            this.addressLines_ = lazyStringList;
            this.recipients_ = lazyStringList;
            this.organization_ = "";
            maybeForceBuilderInitialization();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.type.PostalAddress.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.type.PostalAddress.access$1600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.type.PostalAddress r3 = (com.google.type.PostalAddress) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.type.PostalAddress r4 = (com.google.type.PostalAddress) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.type.PostalAddress.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.type.PostalAddress$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<PostalAddress> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PostalAddress parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PostalAddress(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ PostalAddress(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static PostalAddress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return o.f53669a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PostalAddress parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<PostalAddress> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PostalAddress)) {
            return super.equals(obj);
        }
        PostalAddress postalAddress = (PostalAddress) obj;
        return getRevision() == postalAddress.getRevision() && getRegionCode().equals(postalAddress.getRegionCode()) && getLanguageCode().equals(postalAddress.getLanguageCode()) && getPostalCode().equals(postalAddress.getPostalCode()) && getSortingCode().equals(postalAddress.getSortingCode()) && getAdministrativeArea().equals(postalAddress.getAdministrativeArea()) && getLocality().equals(postalAddress.getLocality()) && getSublocality().equals(postalAddress.getSublocality()) && getAddressLinesList().equals(postalAddress.getAddressLinesList()) && getRecipientsList().equals(postalAddress.getRecipientsList()) && getOrganization().equals(postalAddress.getOrganization()) && this.unknownFields.equals(postalAddress.unknownFields);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getAddressLines(int i10) {
        return this.addressLines_.get(i10);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getAddressLinesBytes(int i10) {
        return this.addressLines_.getByteString(i10);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getAddressLinesCount() {
        return this.addressLines_.size();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getAdministrativeArea() {
        Object obj = this.administrativeArea_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.administrativeArea_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getAdministrativeAreaBytes() {
        Object obj = this.administrativeArea_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.administrativeArea_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getLanguageCode() {
        Object obj = this.languageCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.languageCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getLanguageCodeBytes() {
        Object obj = this.languageCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.languageCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getLocality() {
        Object obj = this.locality_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.locality_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getLocalityBytes() {
        Object obj = this.locality_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.locality_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getOrganization() {
        Object obj = this.organization_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.organization_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getOrganizationBytes() {
        Object obj = this.organization_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.organization_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PostalAddress> getParserForType() {
        return PARSER;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getPostalCode() {
        Object obj = this.postalCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.postalCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getPostalCodeBytes() {
        Object obj = this.postalCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.postalCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getRecipients(int i10) {
        return this.recipients_.get(i10);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getRecipientsBytes(int i10) {
        return this.recipients_.getByteString(i10);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getRecipientsCount() {
        return this.recipients_.size();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getRegionCode() {
        Object obj = this.regionCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.regionCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getRegionCodeBytes() {
        Object obj = this.regionCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.regionCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getRevision() {
        return this.revision_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.revision_;
        int computeInt32Size = i11 != 0 ? CodedOutputStream.computeInt32Size(1, i11) + 0 : 0;
        if (!GeneratedMessageV3.isStringEmpty(this.regionCode_)) {
            computeInt32Size += GeneratedMessageV3.computeStringSize(2, this.regionCode_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.languageCode_)) {
            computeInt32Size += GeneratedMessageV3.computeStringSize(3, this.languageCode_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.postalCode_)) {
            computeInt32Size += GeneratedMessageV3.computeStringSize(4, this.postalCode_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.sortingCode_)) {
            computeInt32Size += GeneratedMessageV3.computeStringSize(5, this.sortingCode_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.administrativeArea_)) {
            computeInt32Size += GeneratedMessageV3.computeStringSize(6, this.administrativeArea_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.locality_)) {
            computeInt32Size += GeneratedMessageV3.computeStringSize(7, this.locality_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.sublocality_)) {
            computeInt32Size += GeneratedMessageV3.computeStringSize(8, this.sublocality_);
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.addressLines_.size(); i13++) {
            i12 += GeneratedMessageV3.computeStringSizeNoTag(this.addressLines_.getRaw(i13));
        }
        int size = computeInt32Size + i12 + (getAddressLinesList().size() * 1);
        int i14 = 0;
        for (int i15 = 0; i15 < this.recipients_.size(); i15++) {
            i14 += GeneratedMessageV3.computeStringSizeNoTag(this.recipients_.getRaw(i15));
        }
        int size2 = size + i14 + (getRecipientsList().size() * 1);
        if (!GeneratedMessageV3.isStringEmpty(this.organization_)) {
            size2 += GeneratedMessageV3.computeStringSize(11, this.organization_);
        }
        int serializedSize = size2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getSortingCode() {
        Object obj = this.sortingCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.sortingCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getSortingCodeBytes() {
        Object obj = this.sortingCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sortingCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getSublocality() {
        Object obj = this.sublocality_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.sublocality_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getSublocalityBytes() {
        Object obj = this.sublocality_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sublocality_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
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
        int hashCode = ((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getRevision()) * 37) + 2) * 53) + getRegionCode().hashCode()) * 37) + 3) * 53) + getLanguageCode().hashCode()) * 37) + 4) * 53) + getPostalCode().hashCode()) * 37) + 5) * 53) + getSortingCode().hashCode()) * 37) + 6) * 53) + getAdministrativeArea().hashCode()) * 37) + 7) * 53) + getLocality().hashCode()) * 37) + 8) * 53) + getSublocality().hashCode();
        if (getAddressLinesCount() > 0) {
            hashCode = (((hashCode * 37) + 9) * 53) + getAddressLinesList().hashCode();
        }
        if (getRecipientsCount() > 0) {
            hashCode = (((hashCode * 37) + 10) * 53) + getRecipientsList().hashCode();
        }
        int hashCode2 = (((((hashCode * 37) + 11) * 53) + getOrganization().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return o.f53670b.ensureFieldAccessorsInitialized(PostalAddress.class, Builder.class);
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
        return new PostalAddress();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i10 = this.revision_;
        if (i10 != 0) {
            codedOutputStream.writeInt32(1, i10);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.regionCode_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.regionCode_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.languageCode_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.languageCode_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.postalCode_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.postalCode_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.sortingCode_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.sortingCode_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.administrativeArea_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.administrativeArea_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.locality_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.locality_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.sublocality_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.sublocality_);
        }
        for (int i11 = 0; i11 < this.addressLines_.size(); i11++) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.addressLines_.getRaw(i11));
        }
        for (int i12 = 0; i12 < this.recipients_.size(); i12++) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.recipients_.getRaw(i12));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.organization_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.organization_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ PostalAddress(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(PostalAddress postalAddress) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(postalAddress);
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ProtocolStringList getAddressLinesList() {
        return this.addressLines_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ProtocolStringList getRecipientsList() {
        return this.recipients_;
    }

    private PostalAddress(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PostalAddress parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PostalAddress getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static PostalAddress parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private PostalAddress() {
        this.memoizedIsInitialized = (byte) -1;
        this.regionCode_ = "";
        this.languageCode_ = "";
        this.postalCode_ = "";
        this.sortingCode_ = "";
        this.administrativeArea_ = "";
        this.locality_ = "";
        this.sublocality_ = "";
        LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
        this.addressLines_ = lazyStringList;
        this.recipients_ = lazyStringList;
        this.organization_ = "";
    }

    public static PostalAddress parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static PostalAddress parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PostalAddress parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0013. Please report as an issue. */
    private PostalAddress(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            z10 = true;
                        case 8:
                            this.revision_ = codedInputStream.readInt32();
                        case 18:
                            this.regionCode_ = codedInputStream.readStringRequireUtf8();
                        case 26:
                            this.languageCode_ = codedInputStream.readStringRequireUtf8();
                        case 34:
                            this.postalCode_ = codedInputStream.readStringRequireUtf8();
                        case 42:
                            this.sortingCode_ = codedInputStream.readStringRequireUtf8();
                        case 50:
                            this.administrativeArea_ = codedInputStream.readStringRequireUtf8();
                        case 58:
                            this.locality_ = codedInputStream.readStringRequireUtf8();
                        case 66:
                            this.sublocality_ = codedInputStream.readStringRequireUtf8();
                        case 74:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            if ((i10 & 1) == 0) {
                                this.addressLines_ = new LazyStringArrayList();
                                i10 |= 1;
                            }
                            this.addressLines_.add((LazyStringList) readStringRequireUtf8);
                        case 82:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            if ((i10 & 2) == 0) {
                                this.recipients_ = new LazyStringArrayList();
                                i10 |= 2;
                            }
                            this.recipients_.add((LazyStringList) readStringRequireUtf82);
                        case 90:
                            this.organization_ = codedInputStream.readStringRequireUtf8();
                        default:
                            if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                z10 = true;
                            }
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (UninitializedMessageException e10) {
                    throw e10.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                }
            } finally {
                if ((i10 & 1) != 0) {
                    this.addressLines_ = this.addressLines_.getUnmodifiableView();
                }
                if ((i10 & 2) != 0) {
                    this.recipients_ = this.recipients_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }
}
