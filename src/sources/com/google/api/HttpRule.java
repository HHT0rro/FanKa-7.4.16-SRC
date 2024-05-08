package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.api.CustomHttpPattern;
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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import u7.p;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class HttpRule extends GeneratedMessageV3 implements HttpRuleOrBuilder {
    public static final int ADDITIONAL_BINDINGS_FIELD_NUMBER = 11;
    public static final int BODY_FIELD_NUMBER = 7;
    public static final int CUSTOM_FIELD_NUMBER = 8;
    public static final int DELETE_FIELD_NUMBER = 5;
    public static final int GET_FIELD_NUMBER = 2;
    public static final int PATCH_FIELD_NUMBER = 6;
    public static final int POST_FIELD_NUMBER = 4;
    public static final int PUT_FIELD_NUMBER = 3;
    public static final int RESPONSE_BODY_FIELD_NUMBER = 12;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<HttpRule> additionalBindings_;
    private volatile Object body_;
    private byte memoizedIsInitialized;
    private int patternCase_;
    private Object pattern_;
    private volatile Object responseBody_;
    private volatile Object selector_;
    private static final HttpRule DEFAULT_INSTANCE = new HttpRule();
    private static final Parser<HttpRule> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HttpRuleOrBuilder {
        private RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> additionalBindingsBuilder_;
        private List<HttpRule> additionalBindings_;
        private int bitField0_;
        private Object body_;
        private SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> customBuilder_;
        private int patternCase_;
        private Object pattern_;
        private Object responseBody_;
        private Object selector_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureAdditionalBindingsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.additionalBindings_ = new ArrayList(this.additionalBindings_);
                this.bitField0_ |= 1;
            }
        }

        private RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> getAdditionalBindingsFieldBuilder() {
            if (this.additionalBindingsBuilder_ == null) {
                this.additionalBindingsBuilder_ = new RepeatedFieldBuilderV3<>(this.additionalBindings_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.additionalBindings_ = null;
            }
            return this.additionalBindingsBuilder_;
        }

        private SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> getCustomFieldBuilder() {
            if (this.customBuilder_ == null) {
                if (this.patternCase_ != 8) {
                    this.pattern_ = CustomHttpPattern.getDefaultInstance();
                }
                this.customBuilder_ = new SingleFieldBuilderV3<>((CustomHttpPattern) this.pattern_, getParentForChildren(), isClean());
                this.pattern_ = null;
            }
            this.patternCase_ = 8;
            onChanged();
            return this.customBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return p.f53938c;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getAdditionalBindingsFieldBuilder();
            }
        }

        public Builder addAdditionalBindings(HttpRule httpRule) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(httpRule);
                ensureAdditionalBindingsIsMutable();
                this.additionalBindings_.add(httpRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(httpRule);
            }
            return this;
        }

        public Builder addAdditionalBindingsBuilder() {
            return getAdditionalBindingsFieldBuilder().addBuilder(HttpRule.getDefaultInstance());
        }

        public Builder addAllAdditionalBindings(Iterable<? extends HttpRule> iterable) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAdditionalBindingsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.additionalBindings_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder clearAdditionalBindings() {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.additionalBindings_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearBody() {
            this.body_ = HttpRule.getDefaultInstance().getBody();
            onChanged();
            return this;
        }

        public Builder clearCustom() {
            SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.patternCase_ == 8) {
                    this.patternCase_ = 0;
                    this.pattern_ = null;
                    onChanged();
                }
            } else {
                if (this.patternCase_ == 8) {
                    this.patternCase_ = 0;
                    this.pattern_ = null;
                }
                singleFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearDelete() {
            if (this.patternCase_ == 5) {
                this.patternCase_ = 0;
                this.pattern_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearGet() {
            if (this.patternCase_ == 2) {
                this.patternCase_ = 0;
                this.pattern_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearPatch() {
            if (this.patternCase_ == 6) {
                this.patternCase_ = 0;
                this.pattern_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearPattern() {
            this.patternCase_ = 0;
            this.pattern_ = null;
            onChanged();
            return this;
        }

        public Builder clearPost() {
            if (this.patternCase_ == 4) {
                this.patternCase_ = 0;
                this.pattern_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearPut() {
            if (this.patternCase_ == 3) {
                this.patternCase_ = 0;
                this.pattern_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearResponseBody() {
            this.responseBody_ = HttpRule.getDefaultInstance().getResponseBody();
            onChanged();
            return this;
        }

        public Builder clearSelector() {
            this.selector_ = HttpRule.getDefaultInstance().getSelector();
            onChanged();
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public HttpRule getAdditionalBindings(int i10) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.additionalBindings_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public Builder getAdditionalBindingsBuilder(int i10) {
            return getAdditionalBindingsFieldBuilder().getBuilder(i10);
        }

        public List<Builder> getAdditionalBindingsBuilderList() {
            return getAdditionalBindingsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public int getAdditionalBindingsCount() {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.additionalBindings_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public List<HttpRule> getAdditionalBindingsList() {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.additionalBindings_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.additionalBindings_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList() {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.additionalBindings_);
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getBody() {
            Object obj = this.body_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.body_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getBodyBytes() {
            Object obj = this.body_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.body_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public CustomHttpPattern getCustom() {
            SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.patternCase_ == 8) {
                    return (CustomHttpPattern) this.pattern_;
                }
                return CustomHttpPattern.getDefaultInstance();
            }
            if (this.patternCase_ == 8) {
                return singleFieldBuilderV3.getMessage();
            }
            return CustomHttpPattern.getDefaultInstance();
        }

        public CustomHttpPattern.Builder getCustomBuilder() {
            return getCustomFieldBuilder().getBuilder();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public CustomHttpPatternOrBuilder getCustomOrBuilder() {
            SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3;
            int i10 = this.patternCase_;
            if (i10 == 8 && (singleFieldBuilderV3 = this.customBuilder_) != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i10 == 8) {
                return (CustomHttpPattern) this.pattern_;
            }
            return CustomHttpPattern.getDefaultInstance();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getDelete() {
            String str = this.patternCase_ == 5 ? this.pattern_ : "";
            if (!(str instanceof String)) {
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.patternCase_ == 5) {
                    this.pattern_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getDeleteBytes() {
            String str = this.patternCase_ == 5 ? this.pattern_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.patternCase_ == 5) {
                    this.pattern_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return p.f53938c;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getGet() {
            String str = this.patternCase_ == 2 ? this.pattern_ : "";
            if (!(str instanceof String)) {
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.patternCase_ == 2) {
                    this.pattern_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getGetBytes() {
            String str = this.patternCase_ == 2 ? this.pattern_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.patternCase_ == 2) {
                    this.pattern_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPatch() {
            String str = this.patternCase_ == 6 ? this.pattern_ : "";
            if (!(str instanceof String)) {
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.patternCase_ == 6) {
                    this.pattern_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPatchBytes() {
            String str = this.patternCase_ == 6 ? this.pattern_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.patternCase_ == 6) {
                    this.pattern_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public PatternCase getPatternCase() {
            return PatternCase.forNumber(this.patternCase_);
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPost() {
            String str = this.patternCase_ == 4 ? this.pattern_ : "";
            if (!(str instanceof String)) {
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.patternCase_ == 4) {
                    this.pattern_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPostBytes() {
            String str = this.patternCase_ == 4 ? this.pattern_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.patternCase_ == 4) {
                    this.pattern_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPut() {
            String str = this.patternCase_ == 3 ? this.pattern_ : "";
            if (!(str instanceof String)) {
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.patternCase_ == 3) {
                    this.pattern_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPutBytes() {
            String str = this.patternCase_ == 3 ? this.pattern_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.patternCase_ == 3) {
                    this.pattern_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getResponseBody() {
            Object obj = this.responseBody_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.responseBody_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getResponseBodyBytes() {
            Object obj = this.responseBody_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.responseBody_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getSelector() {
            Object obj = this.selector_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.selector_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getSelectorBytes() {
            Object obj = this.selector_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.selector_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public boolean hasCustom() {
            return this.patternCase_ == 8;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public boolean hasDelete() {
            return this.patternCase_ == 5;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public boolean hasGet() {
            return this.patternCase_ == 2;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public boolean hasPatch() {
            return this.patternCase_ == 6;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public boolean hasPost() {
            return this.patternCase_ == 4;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public boolean hasPut() {
            return this.patternCase_ == 3;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return p.f53939d.ensureFieldAccessorsInitialized(HttpRule.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeCustom(CustomHttpPattern customHttpPattern) {
            SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.patternCase_ == 8 && this.pattern_ != CustomHttpPattern.getDefaultInstance()) {
                    this.pattern_ = CustomHttpPattern.newBuilder((CustomHttpPattern) this.pattern_).mergeFrom(customHttpPattern).buildPartial();
                } else {
                    this.pattern_ = customHttpPattern;
                }
                onChanged();
            } else if (this.patternCase_ == 8) {
                singleFieldBuilderV3.mergeFrom(customHttpPattern);
            } else {
                singleFieldBuilderV3.setMessage(customHttpPattern);
            }
            this.patternCase_ = 8;
            return this;
        }

        public Builder removeAdditionalBindings(int i10) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAdditionalBindingsIsMutable();
                this.additionalBindings_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setAdditionalBindings(int i10, HttpRule httpRule) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(httpRule);
                ensureAdditionalBindingsIsMutable();
                this.additionalBindings_.set(i10, httpRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, httpRule);
            }
            return this;
        }

        public Builder setBody(String str) {
            Objects.requireNonNull(str);
            this.body_ = str;
            onChanged();
            return this;
        }

        public Builder setBodyBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.body_ = byteString;
            onChanged();
            return this;
        }

        public Builder setCustom(CustomHttpPattern customHttpPattern) {
            SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(customHttpPattern);
                this.pattern_ = customHttpPattern;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(customHttpPattern);
            }
            this.patternCase_ = 8;
            return this;
        }

        public Builder setDelete(String str) {
            Objects.requireNonNull(str);
            this.patternCase_ = 5;
            this.pattern_ = str;
            onChanged();
            return this;
        }

        public Builder setDeleteBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.patternCase_ = 5;
            this.pattern_ = byteString;
            onChanged();
            return this;
        }

        public Builder setGet(String str) {
            Objects.requireNonNull(str);
            this.patternCase_ = 2;
            this.pattern_ = str;
            onChanged();
            return this;
        }

        public Builder setGetBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.patternCase_ = 2;
            this.pattern_ = byteString;
            onChanged();
            return this;
        }

        public Builder setPatch(String str) {
            Objects.requireNonNull(str);
            this.patternCase_ = 6;
            this.pattern_ = str;
            onChanged();
            return this;
        }

        public Builder setPatchBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.patternCase_ = 6;
            this.pattern_ = byteString;
            onChanged();
            return this;
        }

        public Builder setPost(String str) {
            Objects.requireNonNull(str);
            this.patternCase_ = 4;
            this.pattern_ = str;
            onChanged();
            return this;
        }

        public Builder setPostBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.patternCase_ = 4;
            this.pattern_ = byteString;
            onChanged();
            return this;
        }

        public Builder setPut(String str) {
            Objects.requireNonNull(str);
            this.patternCase_ = 3;
            this.pattern_ = str;
            onChanged();
            return this;
        }

        public Builder setPutBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.patternCase_ = 3;
            this.pattern_ = byteString;
            onChanged();
            return this;
        }

        public Builder setResponseBody(String str) {
            Objects.requireNonNull(str);
            this.responseBody_ = str;
            onChanged();
            return this;
        }

        public Builder setResponseBodyBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.responseBody_ = byteString;
            onChanged();
            return this;
        }

        public Builder setSelector(String str) {
            Objects.requireNonNull(str);
            this.selector_ = str;
            onChanged();
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.selector_ = byteString;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.patternCase_ = 0;
            this.selector_ = "";
            this.body_ = "";
            this.responseBody_ = "";
            this.additionalBindings_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder addAdditionalBindingsBuilder(int i10) {
            return getAdditionalBindingsFieldBuilder().addBuilder(i10, HttpRule.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public HttpRule build() {
            HttpRule buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public HttpRule buildPartial() {
            HttpRule httpRule = new HttpRule(this, (a) null);
            httpRule.selector_ = this.selector_;
            if (this.patternCase_ == 2) {
                httpRule.pattern_ = this.pattern_;
            }
            if (this.patternCase_ == 3) {
                httpRule.pattern_ = this.pattern_;
            }
            if (this.patternCase_ == 4) {
                httpRule.pattern_ = this.pattern_;
            }
            if (this.patternCase_ == 5) {
                httpRule.pattern_ = this.pattern_;
            }
            if (this.patternCase_ == 6) {
                httpRule.pattern_ = this.pattern_;
            }
            if (this.patternCase_ == 8) {
                SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
                if (singleFieldBuilderV3 == null) {
                    httpRule.pattern_ = this.pattern_;
                } else {
                    httpRule.pattern_ = singleFieldBuilderV3.build();
                }
            }
            httpRule.body_ = this.body_;
            httpRule.responseBody_ = this.responseBody_;
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.additionalBindings_ = Collections.unmodifiableList(this.additionalBindings_);
                    this.bitField0_ &= -2;
                }
                httpRule.additionalBindings_ = this.additionalBindings_;
            } else {
                httpRule.additionalBindings_ = repeatedFieldBuilderV3.build();
            }
            httpRule.patternCase_ = this.patternCase_;
            onBuilt();
            return httpRule;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HttpRule getDefaultInstanceForType() {
            return HttpRule.getDefaultInstance();
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
            this.selector_ = "";
            this.body_ = "";
            this.responseBody_ = "";
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.additionalBindings_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.patternCase_ = 0;
            this.pattern_ = null;
            return this;
        }

        public Builder addAdditionalBindings(int i10, HttpRule httpRule) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(httpRule);
                ensureAdditionalBindingsIsMutable();
                this.additionalBindings_.add(i10, httpRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, httpRule);
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
            if (message instanceof HttpRule) {
                return mergeFrom((HttpRule) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setAdditionalBindings(int i10, Builder builder) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAdditionalBindingsIsMutable();
                this.additionalBindings_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder setCustom(CustomHttpPattern.Builder builder) {
            SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.pattern_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.patternCase_ = 8;
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.patternCase_ = 0;
            this.selector_ = "";
            this.body_ = "";
            this.responseBody_ = "";
            this.additionalBindings_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder mergeFrom(HttpRule httpRule) {
            if (httpRule == HttpRule.getDefaultInstance()) {
                return this;
            }
            if (!httpRule.getSelector().isEmpty()) {
                this.selector_ = httpRule.selector_;
                onChanged();
            }
            if (!httpRule.getBody().isEmpty()) {
                this.body_ = httpRule.body_;
                onChanged();
            }
            if (!httpRule.getResponseBody().isEmpty()) {
                this.responseBody_ = httpRule.responseBody_;
                onChanged();
            }
            if (this.additionalBindingsBuilder_ == null) {
                if (!httpRule.additionalBindings_.isEmpty()) {
                    if (this.additionalBindings_.isEmpty()) {
                        this.additionalBindings_ = httpRule.additionalBindings_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAdditionalBindingsIsMutable();
                        this.additionalBindings_.addAll(httpRule.additionalBindings_);
                    }
                    onChanged();
                }
            } else if (!httpRule.additionalBindings_.isEmpty()) {
                if (this.additionalBindingsBuilder_.isEmpty()) {
                    this.additionalBindingsBuilder_.dispose();
                    this.additionalBindingsBuilder_ = null;
                    this.additionalBindings_ = httpRule.additionalBindings_;
                    this.bitField0_ &= -2;
                    this.additionalBindingsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getAdditionalBindingsFieldBuilder() : null;
                } else {
                    this.additionalBindingsBuilder_.addAllMessages(httpRule.additionalBindings_);
                }
            }
            switch (b.f25927a[httpRule.getPatternCase().ordinal()]) {
                case 1:
                    this.patternCase_ = 2;
                    this.pattern_ = httpRule.pattern_;
                    onChanged();
                    break;
                case 2:
                    this.patternCase_ = 3;
                    this.pattern_ = httpRule.pattern_;
                    onChanged();
                    break;
                case 3:
                    this.patternCase_ = 4;
                    this.pattern_ = httpRule.pattern_;
                    onChanged();
                    break;
                case 4:
                    this.patternCase_ = 5;
                    this.pattern_ = httpRule.pattern_;
                    onChanged();
                    break;
                case 5:
                    this.patternCase_ = 6;
                    this.pattern_ = httpRule.pattern_;
                    onChanged();
                    break;
                case 6:
                    mergeCustom(httpRule.getCustom());
                    break;
            }
            mergeUnknownFields(httpRule.unknownFields);
            onChanged();
            return this;
        }

        public Builder addAdditionalBindings(Builder builder) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAdditionalBindingsIsMutable();
                this.additionalBindings_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addAdditionalBindings(int i10, Builder builder) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureAdditionalBindingsIsMutable();
                this.additionalBindings_.add(i10, builder.build());
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
        public com.google.api.HttpRule.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.HttpRule.access$1200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.HttpRule r3 = (com.google.api.HttpRule) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.HttpRule r4 = (com.google.api.HttpRule) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.HttpRule.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.HttpRule$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum PatternCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        GET(2),
        PUT(3),
        POST(4),
        DELETE(5),
        PATCH(6),
        CUSTOM(8),
        PATTERN_NOT_SET(0);

        private final int value;

        PatternCase(int i10) {
            this.value = i10;
        }

        public static PatternCase forNumber(int i10) {
            if (i10 == 0) {
                return PATTERN_NOT_SET;
            }
            if (i10 == 8) {
                return CUSTOM;
            }
            if (i10 == 2) {
                return GET;
            }
            if (i10 == 3) {
                return PUT;
            }
            if (i10 == 4) {
                return POST;
            }
            if (i10 == 5) {
                return DELETE;
            }
            if (i10 != 6) {
                return null;
            }
            return PATCH;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static PatternCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<HttpRule> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HttpRule parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new HttpRule(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25927a;

        static {
            int[] iArr = new int[PatternCase.values().length];
            f25927a = iArr;
            try {
                iArr[PatternCase.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25927a[PatternCase.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25927a[PatternCase.POST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25927a[PatternCase.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25927a[PatternCase.PATCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25927a[PatternCase.CUSTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25927a[PatternCase.PATTERN_NOT_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public /* synthetic */ HttpRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static HttpRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return p.f53938c;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static HttpRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static HttpRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<HttpRule> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HttpRule)) {
            return super.equals(obj);
        }
        HttpRule httpRule = (HttpRule) obj;
        if (!getSelector().equals(httpRule.getSelector()) || !getBody().equals(httpRule.getBody()) || !getResponseBody().equals(httpRule.getResponseBody()) || !getAdditionalBindingsList().equals(httpRule.getAdditionalBindingsList()) || !getPatternCase().equals(httpRule.getPatternCase())) {
            return false;
        }
        int i10 = this.patternCase_;
        if (i10 != 2) {
            if (i10 != 3) {
                if (i10 != 4) {
                    if (i10 != 5) {
                        if (i10 != 6) {
                            if (i10 == 8 && !getCustom().equals(httpRule.getCustom())) {
                                return false;
                            }
                        } else if (!getPatch().equals(httpRule.getPatch())) {
                            return false;
                        }
                    } else if (!getDelete().equals(httpRule.getDelete())) {
                        return false;
                    }
                } else if (!getPost().equals(httpRule.getPost())) {
                    return false;
                }
            } else if (!getPut().equals(httpRule.getPut())) {
                return false;
            }
        } else if (!getGet().equals(httpRule.getGet())) {
            return false;
        }
        return this.unknownFields.equals(httpRule.unknownFields);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public HttpRule getAdditionalBindings(int i10) {
        return this.additionalBindings_.get(i10);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public int getAdditionalBindingsCount() {
        return this.additionalBindings_.size();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public List<HttpRule> getAdditionalBindingsList() {
        return this.additionalBindings_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int i10) {
        return this.additionalBindings_.get(i10);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList() {
        return this.additionalBindings_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getBody() {
        Object obj = this.body_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.body_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getBodyBytes() {
        Object obj = this.body_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.body_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public CustomHttpPattern getCustom() {
        if (this.patternCase_ == 8) {
            return (CustomHttpPattern) this.pattern_;
        }
        return CustomHttpPattern.getDefaultInstance();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public CustomHttpPatternOrBuilder getCustomOrBuilder() {
        if (this.patternCase_ == 8) {
            return (CustomHttpPattern) this.pattern_;
        }
        return CustomHttpPattern.getDefaultInstance();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getDelete() {
        String str = this.patternCase_ == 5 ? this.pattern_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.patternCase_ == 5) {
            this.pattern_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getDeleteBytes() {
        String str = this.patternCase_ == 5 ? this.pattern_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.patternCase_ == 5) {
                this.pattern_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getGet() {
        String str = this.patternCase_ == 2 ? this.pattern_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.patternCase_ == 2) {
            this.pattern_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getGetBytes() {
        String str = this.patternCase_ == 2 ? this.pattern_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.patternCase_ == 2) {
                this.pattern_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<HttpRule> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPatch() {
        String str = this.patternCase_ == 6 ? this.pattern_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.patternCase_ == 6) {
            this.pattern_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPatchBytes() {
        String str = this.patternCase_ == 6 ? this.pattern_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.patternCase_ == 6) {
                this.pattern_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public PatternCase getPatternCase() {
        return PatternCase.forNumber(this.patternCase_);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPost() {
        String str = this.patternCase_ == 4 ? this.pattern_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.patternCase_ == 4) {
            this.pattern_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPostBytes() {
        String str = this.patternCase_ == 4 ? this.pattern_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.patternCase_ == 4) {
                this.pattern_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPut() {
        String str = this.patternCase_ == 3 ? this.pattern_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.patternCase_ == 3) {
            this.pattern_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPutBytes() {
        String str = this.patternCase_ == 3 ? this.pattern_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.patternCase_ == 3) {
                this.pattern_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getResponseBody() {
        Object obj = this.responseBody_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.responseBody_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getResponseBodyBytes() {
        Object obj = this.responseBody_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.responseBody_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getSelector() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.selector_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getSelectorBytes() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.selector_ = copyFromUtf8;
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
        int computeStringSize = !GeneratedMessageV3.isStringEmpty(this.selector_) ? GeneratedMessageV3.computeStringSize(1, this.selector_) + 0 : 0;
        if (this.patternCase_ == 2) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.pattern_);
        }
        if (this.patternCase_ == 3) {
            computeStringSize += GeneratedMessageV3.computeStringSize(3, this.pattern_);
        }
        if (this.patternCase_ == 4) {
            computeStringSize += GeneratedMessageV3.computeStringSize(4, this.pattern_);
        }
        if (this.patternCase_ == 5) {
            computeStringSize += GeneratedMessageV3.computeStringSize(5, this.pattern_);
        }
        if (this.patternCase_ == 6) {
            computeStringSize += GeneratedMessageV3.computeStringSize(6, this.pattern_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.body_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(7, this.body_);
        }
        if (this.patternCase_ == 8) {
            computeStringSize += CodedOutputStream.computeMessageSize(8, (CustomHttpPattern) this.pattern_);
        }
        for (int i11 = 0; i11 < this.additionalBindings_.size(); i11++) {
            computeStringSize += CodedOutputStream.computeMessageSize(11, this.additionalBindings_.get(i11));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.responseBody_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(12, this.responseBody_);
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public boolean hasCustom() {
        return this.patternCase_ == 8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public boolean hasDelete() {
        return this.patternCase_ == 5;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public boolean hasGet() {
        return this.patternCase_ == 2;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public boolean hasPatch() {
        return this.patternCase_ == 6;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public boolean hasPost() {
        return this.patternCase_ == 4;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public boolean hasPut() {
        return this.patternCase_ == 3;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10;
        int hashCode;
        int i11 = this.memoizedHashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode2 = ((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getSelector().hashCode()) * 37) + 7) * 53) + getBody().hashCode()) * 37) + 12) * 53) + getResponseBody().hashCode();
        if (getAdditionalBindingsCount() > 0) {
            hashCode2 = (((hashCode2 * 37) + 11) * 53) + getAdditionalBindingsList().hashCode();
        }
        int i12 = this.patternCase_;
        if (i12 == 2) {
            i10 = ((hashCode2 * 37) + 2) * 53;
            hashCode = getGet().hashCode();
        } else if (i12 == 3) {
            i10 = ((hashCode2 * 37) + 3) * 53;
            hashCode = getPut().hashCode();
        } else if (i12 == 4) {
            i10 = ((hashCode2 * 37) + 4) * 53;
            hashCode = getPost().hashCode();
        } else if (i12 == 5) {
            i10 = ((hashCode2 * 37) + 5) * 53;
            hashCode = getDelete().hashCode();
        } else if (i12 == 6) {
            i10 = ((hashCode2 * 37) + 6) * 53;
            hashCode = getPatch().hashCode();
        } else {
            if (i12 == 8) {
                i10 = ((hashCode2 * 37) + 8) * 53;
                hashCode = getCustom().hashCode();
            }
            int hashCode3 = (hashCode2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode3;
            return hashCode3;
        }
        hashCode2 = i10 + hashCode;
        int hashCode32 = (hashCode2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode32;
        return hashCode32;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return p.f53939d.ensureFieldAccessorsInitialized(HttpRule.class, Builder.class);
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
        return new HttpRule();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.selector_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.selector_);
        }
        if (this.patternCase_ == 2) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.pattern_);
        }
        if (this.patternCase_ == 3) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.pattern_);
        }
        if (this.patternCase_ == 4) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.pattern_);
        }
        if (this.patternCase_ == 5) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.pattern_);
        }
        if (this.patternCase_ == 6) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.pattern_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.body_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.body_);
        }
        if (this.patternCase_ == 8) {
            codedOutputStream.writeMessage(8, (CustomHttpPattern) this.pattern_);
        }
        for (int i10 = 0; i10 < this.additionalBindings_.size(); i10++) {
            codedOutputStream.writeMessage(11, this.additionalBindings_.get(i10));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.responseBody_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 12, this.responseBody_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ HttpRule(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(HttpRule httpRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(httpRule);
    }

    public static HttpRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HttpRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private HttpRule(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.patternCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static HttpRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public HttpRule getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static HttpRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static HttpRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    private HttpRule() {
        this.patternCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
        this.selector_ = "";
        this.body_ = "";
        this.responseBody_ = "";
        this.additionalBindings_ = Collections.emptyList();
    }

    public static HttpRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static HttpRule parseFrom(InputStream inputStream) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static HttpRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HttpRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static HttpRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0013. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private HttpRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z10 = true;
                                case 10:
                                    this.selector_ = codedInputStream.readStringRequireUtf8();
                                case 18:
                                    String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    this.patternCase_ = 2;
                                    this.pattern_ = readStringRequireUtf8;
                                case 26:
                                    String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                                    this.patternCase_ = 3;
                                    this.pattern_ = readStringRequireUtf82;
                                case 34:
                                    String readStringRequireUtf83 = codedInputStream.readStringRequireUtf8();
                                    this.patternCase_ = 4;
                                    this.pattern_ = readStringRequireUtf83;
                                case 42:
                                    String readStringRequireUtf84 = codedInputStream.readStringRequireUtf8();
                                    this.patternCase_ = 5;
                                    this.pattern_ = readStringRequireUtf84;
                                case 50:
                                    String readStringRequireUtf85 = codedInputStream.readStringRequireUtf8();
                                    this.patternCase_ = 6;
                                    this.pattern_ = readStringRequireUtf85;
                                case 58:
                                    this.body_ = codedInputStream.readStringRequireUtf8();
                                case 66:
                                    CustomHttpPattern.Builder builder = this.patternCase_ == 8 ? ((CustomHttpPattern) this.pattern_).toBuilder() : null;
                                    MessageLite readMessage = codedInputStream.readMessage(CustomHttpPattern.parser(), extensionRegistryLite);
                                    this.pattern_ = readMessage;
                                    if (builder != null) {
                                        builder.mergeFrom((CustomHttpPattern) readMessage);
                                        this.pattern_ = builder.buildPartial();
                                    }
                                    this.patternCase_ = 8;
                                case 90:
                                    if (!(z11 & true)) {
                                        this.additionalBindings_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.additionalBindings_.add(codedInputStream.readMessage(parser(), extensionRegistryLite));
                                case 98:
                                    this.responseBody_ = codedInputStream.readStringRequireUtf8();
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        z10 = true;
                                    }
                            }
                        } catch (UninitializedMessageException e2) {
                            throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                        }
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e11) {
                    throw e11.setUnfinishedMessage(this);
                }
            } finally {
                if (z11 & true) {
                    this.additionalBindings_ = Collections.unmodifiableList(this.additionalBindings_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }
}
