package android.view.translation;

import android.annotation.NonNull;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.AnnotationValidations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TranslationResponseValue implements Parcelable {
    public static final Parcelable.Creator<TranslationResponseValue> CREATOR = new Parcelable.Creator<TranslationResponseValue>() { // from class: android.view.translation.TranslationResponseValue.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranslationResponseValue[] newArray(int size) {
            return new TranslationResponseValue[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranslationResponseValue createFromParcel(Parcel in) {
            return new TranslationResponseValue(in);
        }
    };
    public static final String EXTRA_DEFINITIONS = "android.view.translation.extra.DEFINITIONS";
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    private final Bundle mExtras;
    private final int mStatusCode;
    private final CharSequence mText;
    private final CharSequence mTransliteration;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface Status {
    }

    /* renamed from: -$$Nest$smdefaultExtras, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m867$$Nest$smdefaultExtras() {
        return defaultExtras();
    }

    /* renamed from: -$$Nest$smdefaultText, reason: not valid java name */
    static /* bridge */ /* synthetic */ CharSequence m868$$Nest$smdefaultText() {
        return defaultText();
    }

    /* renamed from: -$$Nest$smdefaultTransliteration, reason: not valid java name */
    static /* bridge */ /* synthetic */ CharSequence m869$$Nest$smdefaultTransliteration() {
        return defaultTransliteration();
    }

    public static TranslationResponseValue forError() {
        return new TranslationResponseValue(1, null, Bundle.EMPTY, null);
    }

    private static CharSequence defaultText() {
        return null;
    }

    private static Bundle defaultExtras() {
        return Bundle.EMPTY;
    }

    private boolean extrasEquals(Bundle other) {
        return Objects.equals(this.mExtras, other) || (this.mExtras.isEmpty() && other.isEmpty());
    }

    private static CharSequence defaultTransliteration() {
        return null;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static abstract class BaseBuilder {
        BaseBuilder() {
        }
    }

    public static String statusToString(int value) {
        switch (value) {
            case 0:
                return "STATUS_SUCCESS";
            case 1:
                return "STATUS_ERROR";
            default:
                return Integer.toHexString(value);
        }
    }

    TranslationResponseValue(int statusCode, CharSequence text, Bundle extras, CharSequence transliteration) {
        this.mStatusCode = statusCode;
        if (statusCode != 0 && statusCode != 1) {
            throw new IllegalArgumentException("statusCode was " + statusCode + " but must be one of: STATUS_SUCCESS(0), STATUS_ERROR(1)");
        }
        this.mText = text;
        this.mExtras = extras;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, extras);
        this.mTransliteration = transliteration;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public CharSequence getTransliteration() {
        return this.mTransliteration;
    }

    public String toString() {
        return "TranslationResponseValue { statusCode = " + statusToString(this.mStatusCode) + ", text = " + ((Object) this.mText) + ", extras = " + ((Object) this.mExtras) + ", transliteration = " + ((Object) this.mTransliteration) + " }";
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        TranslationResponseValue that = (TranslationResponseValue) o10;
        if (this.mStatusCode == that.mStatusCode && Objects.equals(this.mText, that.mText) && extrasEquals(that.mExtras) && Objects.equals(this.mTransliteration, that.mTransliteration)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + this.mStatusCode;
        return (((((_hash * 31) + Objects.hashCode(this.mText)) * 31) + Objects.hashCode(this.mExtras)) * 31) + Objects.hashCode(this.mTransliteration);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        byte flg = this.mText != null ? (byte) (0 | 2) : (byte) 0;
        if (this.mTransliteration != null) {
            flg = (byte) (flg | 8);
        }
        dest.writeByte(flg);
        dest.writeInt(this.mStatusCode);
        CharSequence charSequence = this.mText;
        if (charSequence != null) {
            dest.writeCharSequence(charSequence);
        }
        dest.writeBundle(this.mExtras);
        CharSequence charSequence2 = this.mTransliteration;
        if (charSequence2 != null) {
            dest.writeCharSequence(charSequence2);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    TranslationResponseValue(Parcel in) {
        byte flg = in.readByte();
        int statusCode = in.readInt();
        CharSequence text = (flg & 2) == 0 ? null : in.readCharSequence();
        Bundle extras = in.readBundle();
        CharSequence transliteration = (flg & 8) == 0 ? null : in.readCharSequence();
        this.mStatusCode = statusCode;
        if (statusCode != 0 && statusCode != 1) {
            throw new IllegalArgumentException("statusCode was " + statusCode + " but must be one of: STATUS_SUCCESS(0), STATUS_ERROR(1)");
        }
        this.mText = text;
        this.mExtras = extras;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, extras);
        this.mTransliteration = transliteration;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder extends BaseBuilder {
        private long mBuilderFieldsSet = 0;
        private Bundle mExtras;
        private int mStatusCode;
        private CharSequence mText;
        private CharSequence mTransliteration;

        public Builder(int statusCode) {
            this.mStatusCode = statusCode;
            if (statusCode != 0 && statusCode != 1) {
                throw new IllegalArgumentException("statusCode was " + this.mStatusCode + " but must be one of: STATUS_SUCCESS(0), STATUS_ERROR(1)");
            }
        }

        public Builder setText(CharSequence value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 2;
            this.mText = value;
            return this;
        }

        public Builder setExtras(Bundle value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 4;
            this.mExtras = value;
            return this;
        }

        public Builder setTransliteration(CharSequence value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 8;
            this.mTransliteration = value;
            return this;
        }

        public TranslationResponseValue build() {
            checkNotUsed();
            long j10 = this.mBuilderFieldsSet | 16;
            this.mBuilderFieldsSet = j10;
            if ((j10 & 2) == 0) {
                this.mText = TranslationResponseValue.m868$$Nest$smdefaultText();
            }
            if ((this.mBuilderFieldsSet & 4) == 0) {
                this.mExtras = TranslationResponseValue.m867$$Nest$smdefaultExtras();
            }
            if ((this.mBuilderFieldsSet & 8) == 0) {
                this.mTransliteration = TranslationResponseValue.m869$$Nest$smdefaultTransliteration();
            }
            TranslationResponseValue o10 = new TranslationResponseValue(this.mStatusCode, this.mText, this.mExtras, this.mTransliteration);
            return o10;
        }

        private void checkNotUsed() {
            if ((this.mBuilderFieldsSet & 16) != 0) {
                throw new IllegalStateException("This Builder should not be reused. Use a new Builder instance instead");
            }
        }
    }

    @Deprecated
    private void __metadata() {
    }
}
