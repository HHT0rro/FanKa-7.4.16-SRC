package com.google.api;

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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import u7.y;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ResourceDescriptor extends GeneratedMessageV3 implements ResourceDescriptorOrBuilder {
    public static final int HISTORY_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_FIELD_NUMBER = 3;
    public static final int PATTERN_FIELD_NUMBER = 2;
    public static final int PLURAL_FIELD_NUMBER = 5;
    public static final int SINGULAR_FIELD_NUMBER = 6;
    public static final int STYLE_FIELD_NUMBER = 10;
    public static final int TYPE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int history_;
    private byte memoizedIsInitialized;
    private volatile Object nameField_;
    private LazyStringList pattern_;
    private volatile Object plural_;
    private volatile Object singular_;
    private int styleMemoizedSerializedSize;
    private List<Integer> style_;
    private volatile Object type_;
    private static final Internal.ListAdapter.Converter<Integer, Style> style_converter_ = new a();
    private static final ResourceDescriptor DEFAULT_INSTANCE = new ResourceDescriptor();
    private static final Parser<ResourceDescriptor> PARSER = new b();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResourceDescriptorOrBuilder {
        private int bitField0_;
        private int history_;
        private Object nameField_;
        private LazyStringList pattern_;
        private Object plural_;
        private Object singular_;
        private List<Integer> style_;
        private Object type_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensurePatternIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.pattern_ = new LazyStringArrayList(this.pattern_);
                this.bitField0_ |= 1;
            }
        }

        private void ensureStyleIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.style_ = new ArrayList(this.style_);
                this.bitField0_ |= 2;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return y.f53994d;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder addAllPattern(Iterable<String> iterable) {
            ensurePatternIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.pattern_);
            onChanged();
            return this;
        }

        public Builder addAllStyle(Iterable<? extends Style> iterable) {
            ensureStyleIsMutable();
            Iterator<? extends Style> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                this.style_.add(Integer.valueOf(iterator2.next().getNumber()));
            }
            onChanged();
            return this;
        }

        public Builder addAllStyleValue(Iterable<Integer> iterable) {
            ensureStyleIsMutable();
            Iterator<Integer> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                this.style_.add(Integer.valueOf(iterator2.next().intValue()));
            }
            onChanged();
            return this;
        }

        public Builder addPattern(String str) {
            Objects.requireNonNull(str);
            ensurePatternIsMutable();
            this.pattern_.add((LazyStringList) str);
            onChanged();
            return this;
        }

        public Builder addPatternBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensurePatternIsMutable();
            this.pattern_.add(byteString);
            onChanged();
            return this;
        }

        public Builder addStyle(Style style) {
            Objects.requireNonNull(style);
            ensureStyleIsMutable();
            this.style_.add(Integer.valueOf(style.getNumber()));
            onChanged();
            return this;
        }

        public Builder addStyleValue(int i10) {
            ensureStyleIsMutable();
            this.style_.add(Integer.valueOf(i10));
            onChanged();
            return this;
        }

        public Builder clearHistory() {
            this.history_ = 0;
            onChanged();
            return this;
        }

        public Builder clearNameField() {
            this.nameField_ = ResourceDescriptor.getDefaultInstance().getNameField();
            onChanged();
            return this;
        }

        public Builder clearPattern() {
            this.pattern_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearPlural() {
            this.plural_ = ResourceDescriptor.getDefaultInstance().getPlural();
            onChanged();
            return this;
        }

        public Builder clearSingular() {
            this.singular_ = ResourceDescriptor.getDefaultInstance().getSingular();
            onChanged();
            return this;
        }

        public Builder clearStyle() {
            this.style_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = ResourceDescriptor.getDefaultInstance().getType();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return y.f53994d;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public History getHistory() {
            History valueOf = History.valueOf(this.history_);
            return valueOf == null ? History.UNRECOGNIZED : valueOf;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public int getHistoryValue() {
            return this.history_;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getNameField() {
            Object obj = this.nameField_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.nameField_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getNameFieldBytes() {
            Object obj = this.nameField_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nameField_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getPattern(int i10) {
            return this.pattern_.get(i10);
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getPatternBytes(int i10) {
            return this.pattern_.getByteString(i10);
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public int getPatternCount() {
            return this.pattern_.size();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getPlural() {
            Object obj = this.plural_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.plural_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getPluralBytes() {
            Object obj = this.plural_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.plural_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getSingular() {
            Object obj = this.singular_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.singular_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getSingularBytes() {
            Object obj = this.singular_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.singular_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public Style getStyle(int i10) {
            return (Style) ResourceDescriptor.style_converter_.convert(this.style_.get(i10));
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public int getStyleCount() {
            return this.style_.size();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public List<Style> getStyleList() {
            return new Internal.ListAdapter(this.style_, ResourceDescriptor.style_converter_);
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public int getStyleValue(int i10) {
            return this.style_.get(i10).intValue();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public List<Integer> getStyleValueList() {
            return Collections.unmodifiableList(this.style_);
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return y.f53995e.ensureFieldAccessorsInitialized(ResourceDescriptor.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setHistory(History history) {
            Objects.requireNonNull(history);
            this.history_ = history.getNumber();
            onChanged();
            return this;
        }

        public Builder setHistoryValue(int i10) {
            this.history_ = i10;
            onChanged();
            return this;
        }

        public Builder setNameField(String str) {
            Objects.requireNonNull(str);
            this.nameField_ = str;
            onChanged();
            return this;
        }

        public Builder setNameFieldBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.nameField_ = byteString;
            onChanged();
            return this;
        }

        public Builder setPattern(int i10, String str) {
            Objects.requireNonNull(str);
            ensurePatternIsMutable();
            this.pattern_.set(i10, (int) str);
            onChanged();
            return this;
        }

        public Builder setPlural(String str) {
            Objects.requireNonNull(str);
            this.plural_ = str;
            onChanged();
            return this;
        }

        public Builder setPluralBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.plural_ = byteString;
            onChanged();
            return this;
        }

        public Builder setSingular(String str) {
            Objects.requireNonNull(str);
            this.singular_ = str;
            onChanged();
            return this;
        }

        public Builder setSingularBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.singular_ = byteString;
            onChanged();
            return this;
        }

        public Builder setStyle(int i10, Style style) {
            Objects.requireNonNull(style);
            ensureStyleIsMutable();
            this.style_.set(i10, Integer.valueOf(style.getNumber()));
            onChanged();
            return this;
        }

        public Builder setStyleValue(int i10, int i11) {
            ensureStyleIsMutable();
            this.style_.set(i10, Integer.valueOf(i11));
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

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ProtocolStringList getPatternList() {
            return this.pattern_.getUnmodifiableView();
        }

        private Builder() {
            this.type_ = "";
            this.pattern_ = LazyStringArrayList.EMPTY;
            this.nameField_ = "";
            this.history_ = 0;
            this.plural_ = "";
            this.singular_ = "";
            this.style_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ResourceDescriptor build() {
            ResourceDescriptor buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ResourceDescriptor buildPartial() {
            ResourceDescriptor resourceDescriptor = new ResourceDescriptor(this, (a) null);
            resourceDescriptor.type_ = this.type_;
            if ((this.bitField0_ & 1) != 0) {
                this.pattern_ = this.pattern_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            resourceDescriptor.pattern_ = this.pattern_;
            resourceDescriptor.nameField_ = this.nameField_;
            resourceDescriptor.history_ = this.history_;
            resourceDescriptor.plural_ = this.plural_;
            resourceDescriptor.singular_ = this.singular_;
            if ((this.bitField0_ & 2) != 0) {
                this.style_ = Collections.unmodifiableList(this.style_);
                this.bitField0_ &= -3;
            }
            resourceDescriptor.style_ = this.style_;
            onBuilt();
            return resourceDescriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ResourceDescriptor getDefaultInstanceForType() {
            return ResourceDescriptor.getDefaultInstance();
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
            this.type_ = "";
            this.pattern_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            this.nameField_ = "";
            this.history_ = 0;
            this.plural_ = "";
            this.singular_ = "";
            this.style_ = Collections.emptyList();
            this.bitField0_ &= -3;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ResourceDescriptor) {
                return mergeFrom((ResourceDescriptor) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(ResourceDescriptor resourceDescriptor) {
            if (resourceDescriptor == ResourceDescriptor.getDefaultInstance()) {
                return this;
            }
            if (!resourceDescriptor.getType().isEmpty()) {
                this.type_ = resourceDescriptor.type_;
                onChanged();
            }
            if (!resourceDescriptor.pattern_.isEmpty()) {
                if (this.pattern_.isEmpty()) {
                    this.pattern_ = resourceDescriptor.pattern_;
                    this.bitField0_ &= -2;
                } else {
                    ensurePatternIsMutable();
                    this.pattern_.addAll(resourceDescriptor.pattern_);
                }
                onChanged();
            }
            if (!resourceDescriptor.getNameField().isEmpty()) {
                this.nameField_ = resourceDescriptor.nameField_;
                onChanged();
            }
            if (resourceDescriptor.history_ != 0) {
                setHistoryValue(resourceDescriptor.getHistoryValue());
            }
            if (!resourceDescriptor.getPlural().isEmpty()) {
                this.plural_ = resourceDescriptor.plural_;
                onChanged();
            }
            if (!resourceDescriptor.getSingular().isEmpty()) {
                this.singular_ = resourceDescriptor.singular_;
                onChanged();
            }
            if (!resourceDescriptor.style_.isEmpty()) {
                if (this.style_.isEmpty()) {
                    this.style_ = resourceDescriptor.style_;
                    this.bitField0_ &= -3;
                } else {
                    ensureStyleIsMutable();
                    this.style_.addAll(resourceDescriptor.style_);
                }
                onChanged();
            }
            mergeUnknownFields(resourceDescriptor.unknownFields);
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.type_ = "";
            this.pattern_ = LazyStringArrayList.EMPTY;
            this.nameField_ = "";
            this.history_ = 0;
            this.plural_ = "";
            this.singular_ = "";
            this.style_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.ResourceDescriptor.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.ResourceDescriptor.access$1200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.ResourceDescriptor r3 = (com.google.api.ResourceDescriptor) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.ResourceDescriptor r4 = (com.google.api.ResourceDescriptor) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.ResourceDescriptor.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.ResourceDescriptor$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum History implements ProtocolMessageEnum {
        HISTORY_UNSPECIFIED(0),
        ORIGINALLY_SINGLE_PATTERN(1),
        FUTURE_MULTI_PATTERN(2),
        UNRECOGNIZED(-1);

        public static final int FUTURE_MULTI_PATTERN_VALUE = 2;
        public static final int HISTORY_UNSPECIFIED_VALUE = 0;
        public static final int ORIGINALLY_SINGLE_PATTERN_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<History> internalValueMap = new a();
        private static final History[] VALUES = values();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a implements Internal.EnumLiteMap<History> {
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public History findValueByNumber(int i10) {
                return History.forNumber(i10);
            }
        }

        History(int i10) {
            this.value = i10;
        }

        public static History forNumber(int i10) {
            if (i10 == 0) {
                return HISTORY_UNSPECIFIED;
            }
            if (i10 == 1) {
                return ORIGINALLY_SINGLE_PATTERN;
            }
            if (i10 != 2) {
                return null;
            }
            return FUTURE_MULTI_PATTERN;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ResourceDescriptor.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<History> internalGetValueMap() {
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
        public static History valueOf(int i10) {
            return forNumber(i10);
        }

        public static History valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Style implements ProtocolMessageEnum {
        STYLE_UNSPECIFIED(0),
        DECLARATIVE_FRIENDLY(1),
        UNRECOGNIZED(-1);

        public static final int DECLARATIVE_FRIENDLY_VALUE = 1;
        public static final int STYLE_UNSPECIFIED_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Style> internalValueMap = new a();
        private static final Style[] VALUES = values();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a implements Internal.EnumLiteMap<Style> {
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Style findValueByNumber(int i10) {
                return Style.forNumber(i10);
            }
        }

        Style(int i10) {
            this.value = i10;
        }

        public static Style forNumber(int i10) {
            if (i10 == 0) {
                return STYLE_UNSPECIFIED;
            }
            if (i10 != 1) {
                return null;
            }
            return DECLARATIVE_FRIENDLY;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ResourceDescriptor.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<Style> internalGetValueMap() {
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
        public static Style valueOf(int i10) {
            return forNumber(i10);
        }

        public static Style valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements Internal.ListAdapter.Converter<Integer, Style> {
        @Override // com.google.protobuf.Internal.ListAdapter.Converter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Style convert(Integer num) {
            Style valueOf = Style.valueOf(num.intValue());
            return valueOf == null ? Style.UNRECOGNIZED : valueOf;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b extends AbstractParser<ResourceDescriptor> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResourceDescriptor parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ResourceDescriptor(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ ResourceDescriptor(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static ResourceDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return y.f53994d;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ResourceDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ResourceDescriptor) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ResourceDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<ResourceDescriptor> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResourceDescriptor)) {
            return super.equals(obj);
        }
        ResourceDescriptor resourceDescriptor = (ResourceDescriptor) obj;
        return getType().equals(resourceDescriptor.getType()) && getPatternList().equals(resourceDescriptor.getPatternList()) && getNameField().equals(resourceDescriptor.getNameField()) && this.history_ == resourceDescriptor.history_ && getPlural().equals(resourceDescriptor.getPlural()) && getSingular().equals(resourceDescriptor.getSingular()) && this.style_.equals(resourceDescriptor.style_) && this.unknownFields.equals(resourceDescriptor.unknownFields);
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public History getHistory() {
        History valueOf = History.valueOf(this.history_);
        return valueOf == null ? History.UNRECOGNIZED : valueOf;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public int getHistoryValue() {
        return this.history_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getNameField() {
        Object obj = this.nameField_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.nameField_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getNameFieldBytes() {
        Object obj = this.nameField_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.nameField_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ResourceDescriptor> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getPattern(int i10) {
        return this.pattern_.get(i10);
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getPatternBytes(int i10) {
        return this.pattern_.getByteString(i10);
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public int getPatternCount() {
        return this.pattern_.size();
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getPlural() {
        Object obj = this.plural_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.plural_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getPluralBytes() {
        Object obj = this.plural_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.plural_ = copyFromUtf8;
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
        int computeStringSize = !GeneratedMessageV3.isStringEmpty(this.type_) ? GeneratedMessageV3.computeStringSize(1, this.type_) + 0 : 0;
        int i11 = 0;
        for (int i12 = 0; i12 < this.pattern_.size(); i12++) {
            i11 += GeneratedMessageV3.computeStringSizeNoTag(this.pattern_.getRaw(i12));
        }
        int size = computeStringSize + i11 + (getPatternList().size() * 1);
        if (!GeneratedMessageV3.isStringEmpty(this.nameField_)) {
            size += GeneratedMessageV3.computeStringSize(3, this.nameField_);
        }
        if (this.history_ != History.HISTORY_UNSPECIFIED.getNumber()) {
            size += CodedOutputStream.computeEnumSize(4, this.history_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.plural_)) {
            size += GeneratedMessageV3.computeStringSize(5, this.plural_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.singular_)) {
            size += GeneratedMessageV3.computeStringSize(6, this.singular_);
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.style_.size(); i14++) {
            i13 += CodedOutputStream.computeEnumSizeNoTag(this.style_.get(i14).intValue());
        }
        int i15 = size + i13;
        if (!getStyleList().isEmpty()) {
            i15 = i15 + 1 + CodedOutputStream.computeUInt32SizeNoTag(i13);
        }
        this.styleMemoizedSerializedSize = i13;
        int serializedSize = i15 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getSingular() {
        Object obj = this.singular_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.singular_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getSingularBytes() {
        Object obj = this.singular_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.singular_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public Style getStyle(int i10) {
        return style_converter_.convert(this.style_.get(i10));
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public int getStyleCount() {
        return this.style_.size();
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public List<Style> getStyleList() {
        return new Internal.ListAdapter(this.style_, style_converter_);
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public int getStyleValue(int i10) {
        return this.style_.get(i10).intValue();
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public List<Integer> getStyleValueList() {
        return this.style_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getType() {
        Object obj = this.type_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.type_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
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

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getType().hashCode();
        if (getPatternCount() > 0) {
            hashCode = (((hashCode * 37) + 2) * 53) + getPatternList().hashCode();
        }
        int hashCode2 = (((((((((((((((hashCode * 37) + 3) * 53) + getNameField().hashCode()) * 37) + 4) * 53) + this.history_) * 37) + 5) * 53) + getPlural().hashCode()) * 37) + 6) * 53) + getSingular().hashCode();
        if (getStyleCount() > 0) {
            hashCode2 = (((hashCode2 * 37) + 10) * 53) + this.style_.hashCode();
        }
        int hashCode3 = (hashCode2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return y.f53995e.ensureFieldAccessorsInitialized(ResourceDescriptor.class, Builder.class);
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
        return new ResourceDescriptor();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if (!GeneratedMessageV3.isStringEmpty(this.type_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.type_);
        }
        for (int i10 = 0; i10 < this.pattern_.size(); i10++) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.pattern_.getRaw(i10));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.nameField_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.nameField_);
        }
        if (this.history_ != History.HISTORY_UNSPECIFIED.getNumber()) {
            codedOutputStream.writeEnum(4, this.history_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.plural_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.plural_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.singular_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.singular_);
        }
        if (getStyleList().size() > 0) {
            codedOutputStream.writeUInt32NoTag(82);
            codedOutputStream.writeUInt32NoTag(this.styleMemoizedSerializedSize);
        }
        for (int i11 = 0; i11 < this.style_.size(); i11++) {
            codedOutputStream.writeEnumNoTag(this.style_.get(i11).intValue());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ ResourceDescriptor(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(ResourceDescriptor resourceDescriptor) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(resourceDescriptor);
    }

    public static ResourceDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ProtocolStringList getPatternList() {
        return this.pattern_;
    }

    private ResourceDescriptor(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ResourceDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ResourceDescriptor getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static ResourceDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private ResourceDescriptor() {
        this.memoizedIsInitialized = (byte) -1;
        this.type_ = "";
        this.pattern_ = LazyStringArrayList.EMPTY;
        this.nameField_ = "";
        this.history_ = 0;
        this.plural_ = "";
        this.singular_ = "";
        this.style_ = Collections.emptyList();
    }

    public static ResourceDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static ResourceDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(InputStream inputStream) throws IOException {
        return (ResourceDescriptor) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ResourceDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ResourceDescriptor) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ResourceDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    private ResourceDescriptor(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.type_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                if ((i10 & 1) == 0) {
                                    this.pattern_ = new LazyStringArrayList();
                                    i10 |= 1;
                                }
                                this.pattern_.add((LazyStringList) readStringRequireUtf8);
                            } else if (readTag == 26) {
                                this.nameField_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.history_ = codedInputStream.readEnum();
                            } else if (readTag == 42) {
                                this.plural_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 50) {
                                this.singular_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 80) {
                                int readEnum = codedInputStream.readEnum();
                                if ((i10 & 2) == 0) {
                                    this.style_ = new ArrayList();
                                    i10 |= 2;
                                }
                                this.style_.add(Integer.valueOf(readEnum));
                            } else if (readTag != 82) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    int readEnum2 = codedInputStream.readEnum();
                                    if ((i10 & 2) == 0) {
                                        this.style_ = new ArrayList();
                                        i10 |= 2;
                                    }
                                    this.style_.add(Integer.valueOf(readEnum2));
                                }
                                codedInputStream.popLimit(pushLimit);
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
                if ((i10 & 1) != 0) {
                    this.pattern_ = this.pattern_.getUnmodifiableView();
                }
                if ((i10 & 2) != 0) {
                    this.style_ = Collections.unmodifiableList(this.style_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }
}
