package android.view.translation;

import android.annotation.NonNull;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.android.internal.util.AnnotationValidations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TranslationResponse implements Parcelable {
    public static final Parcelable.Creator<TranslationResponse> CREATOR = new Parcelable.Creator<TranslationResponse>() { // from class: android.view.translation.TranslationResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranslationResponse[] newArray(int size) {
            return new TranslationResponse[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranslationResponse createFromParcel(Parcel in) {
            return new TranslationResponse(in);
        }
    };
    public static final int TRANSLATION_STATUS_CONTEXT_UNSUPPORTED = 2;
    public static final int TRANSLATION_STATUS_SUCCESS = 0;
    public static final int TRANSLATION_STATUS_UNKNOWN_ERROR = 1;
    private final boolean mFinalResponse;
    private final SparseArray<TranslationResponseValue> mTranslationResponseValues;
    private final int mTranslationStatus;
    private final SparseArray<ViewTranslationResponse> mViewTranslationResponses;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface TranslationStatus {
    }

    /* renamed from: -$$Nest$smdefaultFinalResponse, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m862$$Nest$smdefaultFinalResponse() {
        return defaultFinalResponse();
    }

    /* renamed from: -$$Nest$smdefaultTranslationResponseValues, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m863$$Nest$smdefaultTranslationResponseValues() {
        return defaultTranslationResponseValues();
    }

    /* renamed from: -$$Nest$smdefaultViewTranslationResponses, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m864$$Nest$smdefaultViewTranslationResponses() {
        return defaultViewTranslationResponses();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static abstract class BaseBuilder {
        @Deprecated
        public abstract Builder setTranslationStatus(int i10);

        BaseBuilder() {
        }

        public Builder setTranslationResponseValue(int index, TranslationResponseValue value) {
            Objects.requireNonNull(value, "value should not be null");
            Builder builder = (Builder) this;
            if (builder.mTranslationResponseValues == null) {
                builder.setTranslationResponseValues(new SparseArray<>());
            }
            builder.mTranslationResponseValues.put(index, value);
            return builder;
        }

        public Builder setViewTranslationResponse(int index, ViewTranslationResponse response) {
            Objects.requireNonNull(response, "value should not be null");
            Builder builder = (Builder) this;
            if (builder.mViewTranslationResponses == null) {
                builder.setViewTranslationResponses(new SparseArray<>());
            }
            builder.mViewTranslationResponses.put(index, response);
            return builder;
        }
    }

    private static SparseArray<TranslationResponseValue> defaultTranslationResponseValues() {
        return new SparseArray<>();
    }

    private static SparseArray<ViewTranslationResponse> defaultViewTranslationResponses() {
        return new SparseArray<>();
    }

    private static boolean defaultFinalResponse() {
        return true;
    }

    public static String translationStatusToString(int value) {
        switch (value) {
            case 0:
                return "TRANSLATION_STATUS_SUCCESS";
            case 1:
                return "TRANSLATION_STATUS_UNKNOWN_ERROR";
            case 2:
                return "TRANSLATION_STATUS_CONTEXT_UNSUPPORTED";
            default:
                return Integer.toHexString(value);
        }
    }

    TranslationResponse(int translationStatus, SparseArray<TranslationResponseValue> translationResponseValues, SparseArray<ViewTranslationResponse> viewTranslationResponses, boolean finalResponse) {
        this.mTranslationStatus = translationStatus;
        if (translationStatus != 0 && translationStatus != 1 && translationStatus != 2) {
            throw new IllegalArgumentException("translationStatus was " + translationStatus + " but must be one of: TRANSLATION_STATUS_SUCCESS(0), TRANSLATION_STATUS_UNKNOWN_ERROR(1), TRANSLATION_STATUS_CONTEXT_UNSUPPORTED(2)");
        }
        this.mTranslationResponseValues = translationResponseValues;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, translationResponseValues);
        this.mViewTranslationResponses = viewTranslationResponses;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, viewTranslationResponses);
        this.mFinalResponse = finalResponse;
    }

    public int getTranslationStatus() {
        return this.mTranslationStatus;
    }

    public SparseArray<TranslationResponseValue> getTranslationResponseValues() {
        return this.mTranslationResponseValues;
    }

    public SparseArray<ViewTranslationResponse> getViewTranslationResponses() {
        return this.mViewTranslationResponses;
    }

    public boolean isFinalResponse() {
        return this.mFinalResponse;
    }

    public String toString() {
        return "TranslationResponse { translationStatus = " + translationStatusToString(this.mTranslationStatus) + ", translationResponseValues = " + ((Object) this.mTranslationResponseValues) + ", viewTranslationResponses = " + ((Object) this.mViewTranslationResponses) + ", finalResponse = " + this.mFinalResponse + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        byte flg = this.mFinalResponse ? (byte) (0 | 8) : (byte) 0;
        dest.writeByte(flg);
        dest.writeInt(this.mTranslationStatus);
        dest.writeSparseArray(this.mTranslationResponseValues);
        dest.writeSparseArray(this.mViewTranslationResponses);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    TranslationResponse(Parcel in) {
        byte flg = in.readByte();
        boolean finalResponse = (flg & 8) != 0;
        int translationStatus = in.readInt();
        SparseArray<TranslationResponseValue> translationResponseValues = in.readSparseArray(TranslationResponseValue.class.getClassLoader());
        SparseArray<ViewTranslationResponse> viewTranslationResponses = in.readSparseArray(ViewTranslationResponse.class.getClassLoader());
        this.mTranslationStatus = translationStatus;
        if (translationStatus != 0 && translationStatus != 1 && translationStatus != 2) {
            throw new IllegalArgumentException("translationStatus was " + translationStatus + " but must be one of: TRANSLATION_STATUS_SUCCESS(0), TRANSLATION_STATUS_UNKNOWN_ERROR(1), TRANSLATION_STATUS_CONTEXT_UNSUPPORTED(2)");
        }
        this.mTranslationResponseValues = translationResponseValues;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, translationResponseValues);
        this.mViewTranslationResponses = viewTranslationResponses;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, viewTranslationResponses);
        this.mFinalResponse = finalResponse;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder extends BaseBuilder {
        private long mBuilderFieldsSet = 0;
        private boolean mFinalResponse;
        private SparseArray<TranslationResponseValue> mTranslationResponseValues;
        private int mTranslationStatus;
        private SparseArray<ViewTranslationResponse> mViewTranslationResponses;

        @Override // android.view.translation.TranslationResponse.BaseBuilder
        public /* bridge */ /* synthetic */ Builder setTranslationResponseValue(int i10, TranslationResponseValue translationResponseValue) {
            return super.setTranslationResponseValue(i10, translationResponseValue);
        }

        @Override // android.view.translation.TranslationResponse.BaseBuilder
        public /* bridge */ /* synthetic */ Builder setViewTranslationResponse(int i10, ViewTranslationResponse viewTranslationResponse) {
            return super.setViewTranslationResponse(i10, viewTranslationResponse);
        }

        public Builder(int translationStatus) {
            this.mTranslationStatus = translationStatus;
            if (translationStatus != 0 && translationStatus != 1 && translationStatus != 2) {
                throw new IllegalArgumentException("translationStatus was " + this.mTranslationStatus + " but must be one of: TRANSLATION_STATUS_SUCCESS(0), TRANSLATION_STATUS_UNKNOWN_ERROR(1), TRANSLATION_STATUS_CONTEXT_UNSUPPORTED(2)");
            }
        }

        @Override // android.view.translation.TranslationResponse.BaseBuilder
        @Deprecated
        public Builder setTranslationStatus(int value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 1;
            this.mTranslationStatus = value;
            return this;
        }

        public Builder setTranslationResponseValues(SparseArray<TranslationResponseValue> value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 2;
            this.mTranslationResponseValues = value;
            return this;
        }

        public Builder setViewTranslationResponses(SparseArray<ViewTranslationResponse> value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 4;
            this.mViewTranslationResponses = value;
            return this;
        }

        public Builder setFinalResponse(boolean value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 8;
            this.mFinalResponse = value;
            return this;
        }

        public TranslationResponse build() {
            checkNotUsed();
            long j10 = this.mBuilderFieldsSet | 16;
            this.mBuilderFieldsSet = j10;
            if ((j10 & 2) == 0) {
                this.mTranslationResponseValues = TranslationResponse.m863$$Nest$smdefaultTranslationResponseValues();
            }
            if ((this.mBuilderFieldsSet & 4) == 0) {
                this.mViewTranslationResponses = TranslationResponse.m864$$Nest$smdefaultViewTranslationResponses();
            }
            if ((this.mBuilderFieldsSet & 8) == 0) {
                this.mFinalResponse = TranslationResponse.m862$$Nest$smdefaultFinalResponse();
            }
            TranslationResponse o10 = new TranslationResponse(this.mTranslationStatus, this.mTranslationResponseValues, this.mViewTranslationResponses, this.mFinalResponse);
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
