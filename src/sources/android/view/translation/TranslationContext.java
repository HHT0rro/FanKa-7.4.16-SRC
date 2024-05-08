package android.view.translation;

import android.annotation.NonNull;
import android.annotation.SystemApi;
import android.app.assist.ActivityId;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.AnnotationValidations;
import com.android.internal.util.BitUtils;
import com.android.internal.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.function.IntFunction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TranslationContext implements Parcelable {
    public static final Parcelable.Creator<TranslationContext> CREATOR = new Parcelable.Creator<TranslationContext>() { // from class: android.view.translation.TranslationContext.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranslationContext[] newArray(int size) {
            return new TranslationContext[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranslationContext createFromParcel(Parcel in) {
            return new TranslationContext(in);
        }
    };
    public static final int FLAG_DEFINITIONS = 4;
    public static final int FLAG_LOW_LATENCY = 1;
    public static final int FLAG_TRANSLITERATION = 2;
    private final ActivityId mActivityId;
    private final TranslationSpec mSourceSpec;
    private final TranslationSpec mTargetSpec;
    private final int mTranslationFlags;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface TranslationFlag {
    }

    /* renamed from: -$$Nest$smdefaultActivityId, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityId m855$$Nest$smdefaultActivityId() {
        return defaultActivityId();
    }

    /* renamed from: -$$Nest$smdefaultTranslationFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m856$$Nest$smdefaultTranslationFlags() {
        return defaultTranslationFlags();
    }

    private static int defaultTranslationFlags() {
        return 0;
    }

    private static ActivityId defaultActivityId() {
        return null;
    }

    private void parcelActivityId(Parcel dest, int flags) {
        dest.writeBoolean(this.mActivityId != null);
        ActivityId activityId = this.mActivityId;
        if (activityId != null) {
            activityId.writeToParcel(dest, flags);
        }
    }

    private ActivityId unparcelActivityId(Parcel in) {
        boolean hasActivityId = in.readBoolean();
        if (hasActivityId) {
            return new ActivityId(in);
        }
        return null;
    }

    @SystemApi
    public ActivityId getActivityId() {
        return this.mActivityId;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static abstract class BaseBuilder {
        BaseBuilder() {
        }
    }

    public static String translationFlagToString(int value) {
        return BitUtils.flagsToString(value, new IntFunction() { // from class: android.view.translation.TranslationContext$$ExternalSyntheticLambda0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return TranslationContext.singleTranslationFlagToString(i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String singleTranslationFlagToString(int value) {
        switch (value) {
            case 1:
                return "FLAG_LOW_LATENCY";
            case 2:
                return "FLAG_TRANSLITERATION";
            case 3:
            default:
                return Integer.toHexString(value);
            case 4:
                return "FLAG_DEFINITIONS";
        }
    }

    TranslationContext(TranslationSpec sourceSpec, TranslationSpec targetSpec, int translationFlags, ActivityId activityId) {
        this.mSourceSpec = sourceSpec;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, sourceSpec);
        this.mTargetSpec = targetSpec;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, targetSpec);
        this.mTranslationFlags = translationFlags;
        Preconditions.checkFlagsArgument(translationFlags, 7);
        this.mActivityId = activityId;
    }

    public TranslationSpec getSourceSpec() {
        return this.mSourceSpec;
    }

    public TranslationSpec getTargetSpec() {
        return this.mTargetSpec;
    }

    public int getTranslationFlags() {
        return this.mTranslationFlags;
    }

    public String toString() {
        return "TranslationContext { sourceSpec = " + ((Object) this.mSourceSpec) + ", targetSpec = " + ((Object) this.mTargetSpec) + ", translationFlags = " + translationFlagToString(this.mTranslationFlags) + ", activityId = " + ((Object) this.mActivityId) + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        byte flg = this.mActivityId != null ? (byte) (0 | 8) : (byte) 0;
        dest.writeByte(flg);
        dest.writeTypedObject(this.mSourceSpec, flags);
        dest.writeTypedObject(this.mTargetSpec, flags);
        dest.writeInt(this.mTranslationFlags);
        parcelActivityId(dest, flags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    TranslationContext(Parcel in) {
        in.readByte();
        TranslationSpec sourceSpec = (TranslationSpec) in.readTypedObject(TranslationSpec.CREATOR);
        TranslationSpec targetSpec = (TranslationSpec) in.readTypedObject(TranslationSpec.CREATOR);
        int translationFlags = in.readInt();
        ActivityId activityId = unparcelActivityId(in);
        this.mSourceSpec = sourceSpec;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, sourceSpec);
        this.mTargetSpec = targetSpec;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, targetSpec);
        this.mTranslationFlags = translationFlags;
        Preconditions.checkFlagsArgument(translationFlags, 7);
        this.mActivityId = activityId;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder extends BaseBuilder {
        private ActivityId mActivityId;
        private long mBuilderFieldsSet = 0;
        private TranslationSpec mSourceSpec;
        private TranslationSpec mTargetSpec;
        private int mTranslationFlags;

        public Builder(TranslationSpec sourceSpec, TranslationSpec targetSpec) {
            this.mSourceSpec = sourceSpec;
            AnnotationValidations.validate(NonNull.class, (NonNull) null, sourceSpec);
            this.mTargetSpec = targetSpec;
            AnnotationValidations.validate(NonNull.class, (NonNull) null, targetSpec);
        }

        public Builder setTranslationFlags(int value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 4;
            this.mTranslationFlags = value;
            return this;
        }

        public Builder setActivityId(ActivityId value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 8;
            this.mActivityId = value;
            return this;
        }

        public TranslationContext build() {
            checkNotUsed();
            long j10 = this.mBuilderFieldsSet | 16;
            this.mBuilderFieldsSet = j10;
            if ((j10 & 4) == 0) {
                this.mTranslationFlags = TranslationContext.m856$$Nest$smdefaultTranslationFlags();
            }
            if ((this.mBuilderFieldsSet & 8) == 0) {
                this.mActivityId = TranslationContext.m855$$Nest$smdefaultActivityId();
            }
            TranslationContext o10 = new TranslationContext(this.mSourceSpec, this.mTargetSpec, this.mTranslationFlags, this.mActivityId);
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
