package android.view.translation;

import android.annotation.NonNull;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.view.autofill.AutofillId;
import com.android.internal.util.AnnotationValidations;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ViewTranslationResponse implements Parcelable {
    public static final Parcelable.Creator<ViewTranslationResponse> CREATOR = new Parcelable.Creator<ViewTranslationResponse>() { // from class: android.view.translation.ViewTranslationResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ViewTranslationResponse[] newArray(int size) {
            return new ViewTranslationResponse[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ViewTranslationResponse createFromParcel(Parcel in) {
            return new ViewTranslationResponse(in);
        }
    };
    private final AutofillId mAutofillId;
    private final Map<String, TranslationResponseValue> mTranslationResponseValues;

    /* renamed from: -$$Nest$smdefaultTranslationResponseValues, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m875$$Nest$smdefaultTranslationResponseValues() {
        return defaultTranslationResponseValues();
    }

    public TranslationResponseValue getValue(String key) {
        Objects.requireNonNull(key);
        if (!this.mTranslationResponseValues.containsKey(key)) {
            throw new IllegalArgumentException("Request does not contain value for key=" + key);
        }
        return this.mTranslationResponseValues.get(key);
    }

    public Set<String> getKeys() {
        return this.mTranslationResponseValues.h();
    }

    public AutofillId getAutofillId() {
        return this.mAutofillId;
    }

    private static Map<String, TranslationResponseValue> defaultTranslationResponseValues() {
        return Collections.emptyMap();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static abstract class BaseBuilder {
        abstract Builder setTranslationResponseValues(Map<String, TranslationResponseValue> map);

        BaseBuilder() {
        }

        public Builder setValue(String key, TranslationResponseValue value) {
            Builder builder = (Builder) this;
            if (builder.mTranslationResponseValues == null) {
                setTranslationResponseValues(new ArrayMap());
            }
            builder.mTranslationResponseValues.put(key, value);
            return builder;
        }
    }

    ViewTranslationResponse(AutofillId autofillId, Map<String, TranslationResponseValue> translationResponseValues) {
        this.mAutofillId = autofillId;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, autofillId);
        this.mTranslationResponseValues = translationResponseValues;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, translationResponseValues);
    }

    public String toString() {
        return "ViewTranslationResponse { autofillId = " + ((Object) this.mAutofillId) + ", translationResponseValues = " + ((Object) this.mTranslationResponseValues) + " }";
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        ViewTranslationResponse that = (ViewTranslationResponse) o10;
        if (Objects.equals(this.mAutofillId, that.mAutofillId) && Objects.equals(this.mTranslationResponseValues, that.mTranslationResponseValues)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + Objects.hashCode(this.mAutofillId);
        return (_hash * 31) + Objects.hashCode(this.mTranslationResponseValues);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedObject(this.mAutofillId, flags);
        dest.writeMap(this.mTranslationResponseValues);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ViewTranslationResponse(Parcel in) {
        AutofillId autofillId = (AutofillId) in.readTypedObject(AutofillId.CREATOR);
        Map<String, TranslationResponseValue> translationResponseValues = new LinkedHashMap<>();
        in.readMap(translationResponseValues, TranslationResponseValue.class.getClassLoader());
        this.mAutofillId = autofillId;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, autofillId);
        this.mTranslationResponseValues = translationResponseValues;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, translationResponseValues);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder extends BaseBuilder {
        private AutofillId mAutofillId;
        private long mBuilderFieldsSet = 0;
        private Map<String, TranslationResponseValue> mTranslationResponseValues;

        @Override // android.view.translation.ViewTranslationResponse.BaseBuilder
        public /* bridge */ /* synthetic */ Builder setValue(String str, TranslationResponseValue translationResponseValue) {
            return super.setValue(str, translationResponseValue);
        }

        public Builder(AutofillId autofillId) {
            this.mAutofillId = autofillId;
            AnnotationValidations.validate(NonNull.class, (NonNull) null, autofillId);
        }

        @Override // android.view.translation.ViewTranslationResponse.BaseBuilder
        Builder setTranslationResponseValues(Map<String, TranslationResponseValue> value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 2;
            this.mTranslationResponseValues = value;
            return this;
        }

        public ViewTranslationResponse build() {
            checkNotUsed();
            long j10 = this.mBuilderFieldsSet | 4;
            this.mBuilderFieldsSet = j10;
            if ((j10 & 2) == 0) {
                this.mTranslationResponseValues = ViewTranslationResponse.m875$$Nest$smdefaultTranslationResponseValues();
            }
            ViewTranslationResponse o10 = new ViewTranslationResponse(this.mAutofillId, this.mTranslationResponseValues);
            return o10;
        }

        private void checkNotUsed() {
            if ((this.mBuilderFieldsSet & 4) != 0) {
                throw new IllegalStateException("This Builder should not be reused. Use a new Builder instance instead");
            }
        }
    }

    @Deprecated
    private void __metadata() {
    }
}
