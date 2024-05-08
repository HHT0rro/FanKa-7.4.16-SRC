package android.widget.inline;

import android.annotation.NonNull;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Size;
import com.android.internal.util.AnnotationValidations;
import com.android.internal.widget.InlinePresentationStyleUtils;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class InlinePresentationSpec implements Parcelable {
    public static final Parcelable.Creator<InlinePresentationSpec> CREATOR = new Parcelable.Creator<InlinePresentationSpec>() { // from class: android.widget.inline.InlinePresentationSpec.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InlinePresentationSpec[] newArray(int size) {
            return new InlinePresentationSpec[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InlinePresentationSpec createFromParcel(Parcel in) {
            return new InlinePresentationSpec(in);
        }
    };
    private final Size mMaxSize;
    private final Size mMinSize;
    private final Bundle mStyle;

    /* renamed from: -$$Nest$smdefaultStyle, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m1600$$Nest$smdefaultStyle() {
        return defaultStyle();
    }

    private static Bundle defaultStyle() {
        return Bundle.EMPTY;
    }

    private boolean styleEquals(Bundle style) {
        return InlinePresentationStyleUtils.bundleEquals(this.mStyle, style);
    }

    public void filterContentTypes() {
        InlinePresentationStyleUtils.filterContentTypes(this.mStyle);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static abstract class BaseBuilder {
        BaseBuilder() {
        }
    }

    InlinePresentationSpec(Size minSize, Size maxSize, Bundle style) {
        this.mMinSize = minSize;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, minSize);
        this.mMaxSize = maxSize;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, maxSize);
        this.mStyle = style;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, style);
    }

    public Size getMinSize() {
        return this.mMinSize;
    }

    public Size getMaxSize() {
        return this.mMaxSize;
    }

    public Bundle getStyle() {
        return this.mStyle;
    }

    public String toString() {
        return "InlinePresentationSpec { minSize = " + ((Object) this.mMinSize) + ", maxSize = " + ((Object) this.mMaxSize) + ", style = " + ((Object) this.mStyle) + " }";
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        InlinePresentationSpec that = (InlinePresentationSpec) o10;
        if (Objects.equals(this.mMinSize, that.mMinSize) && Objects.equals(this.mMaxSize, that.mMaxSize) && styleEquals(that.mStyle)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + Objects.hashCode(this.mMinSize);
        return (((_hash * 31) + Objects.hashCode(this.mMaxSize)) * 31) + Objects.hashCode(this.mStyle);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSize(this.mMinSize);
        dest.writeSize(this.mMaxSize);
        dest.writeBundle(this.mStyle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    InlinePresentationSpec(Parcel in) {
        Size minSize = in.readSize();
        Size maxSize = in.readSize();
        Bundle style = in.readBundle();
        this.mMinSize = minSize;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, minSize);
        this.mMaxSize = maxSize;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, maxSize);
        this.mStyle = style;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, style);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder extends BaseBuilder {
        private long mBuilderFieldsSet = 0;
        private Size mMaxSize;
        private Size mMinSize;
        private Bundle mStyle;

        public Builder(Size minSize, Size maxSize) {
            this.mMinSize = minSize;
            AnnotationValidations.validate(NonNull.class, (NonNull) null, minSize);
            this.mMaxSize = maxSize;
            AnnotationValidations.validate(NonNull.class, (NonNull) null, maxSize);
        }

        public Builder setStyle(Bundle value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 4;
            this.mStyle = value;
            return this;
        }

        public InlinePresentationSpec build() {
            checkNotUsed();
            long j10 = this.mBuilderFieldsSet | 8;
            this.mBuilderFieldsSet = j10;
            if ((j10 & 4) == 0) {
                this.mStyle = InlinePresentationSpec.m1600$$Nest$smdefaultStyle();
            }
            InlinePresentationSpec o10 = new InlinePresentationSpec(this.mMinSize, this.mMaxSize, this.mStyle);
            return o10;
        }

        private void checkNotUsed() {
            if ((this.mBuilderFieldsSet & 8) != 0) {
                throw new IllegalStateException("This Builder should not be reused. Use a new Builder instance instead");
            }
        }
    }

    @Deprecated
    private void __metadata() {
    }
}
