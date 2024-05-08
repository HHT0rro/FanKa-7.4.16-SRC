package android.view.translation;

import android.annotation.NonNull;
import android.icu.util.ULocale;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.AnnotationValidations;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TranslationSpec implements Parcelable {
    public static final Parcelable.Creator<TranslationSpec> CREATOR = new Parcelable.Creator<TranslationSpec>() { // from class: android.view.translation.TranslationSpec.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranslationSpec[] newArray(int size) {
            return new TranslationSpec[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranslationSpec createFromParcel(Parcel in) {
            return new TranslationSpec(in);
        }
    };
    public static final int DATA_FORMAT_TEXT = 1;
    private final int mDataFormat;

    @Deprecated
    private final String mLanguage;
    private final ULocale mLocale;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface DataFormat {
    }

    void parcelLocale(Parcel dest, int flags) {
        dest.writeSerializable(this.mLocale);
    }

    static ULocale unparcelLocale(Parcel in) {
        return (ULocale) in.readSerializable(ULocale.class.getClassLoader(), ULocale.class);
    }

    @Deprecated
    public TranslationSpec(String language, int dataFormat) {
        this.mLanguage = language;
        this.mDataFormat = dataFormat;
        this.mLocale = new ULocale.Builder().setLanguage(language).build();
    }

    public TranslationSpec(ULocale locale, int dataFormat) {
        Objects.requireNonNull(locale);
        this.mLanguage = locale.getLanguage();
        this.mLocale = locale;
        this.mDataFormat = dataFormat;
    }

    @Deprecated
    public String getLanguage() {
        return this.mLanguage;
    }

    public ULocale getLocale() {
        return this.mLocale;
    }

    public int getDataFormat() {
        return this.mDataFormat;
    }

    public String toString() {
        return "TranslationSpec { language = " + this.mLanguage + ", locale = " + ((Object) this.mLocale) + ", dataFormat = " + this.mDataFormat + " }";
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        TranslationSpec that = (TranslationSpec) o10;
        if (Objects.equals(this.mLanguage, that.mLanguage) && Objects.equals(this.mLocale, that.mLocale) && this.mDataFormat == that.mDataFormat) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + Objects.hashCode(this.mLanguage);
        return (((_hash * 31) + Objects.hashCode(this.mLocale)) * 31) + this.mDataFormat;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mLanguage);
        parcelLocale(dest, flags);
        dest.writeInt(this.mDataFormat);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    TranslationSpec(Parcel in) {
        String language = in.readString();
        ULocale locale = unparcelLocale(in);
        int dataFormat = in.readInt();
        this.mLanguage = language;
        AnnotationValidations.validate(Deprecated.class, (Annotation) null, language);
        AnnotationValidations.validate(NonNull.class, (NonNull) null, language);
        this.mLocale = locale;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, locale);
        this.mDataFormat = dataFormat;
        AnnotationValidations.validate(DataFormat.class, (Annotation) null, dataFormat);
    }

    @Deprecated
    private void __metadata() {
    }
}
