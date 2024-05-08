package android.view.translation;

import android.annotation.SystemApi;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@SystemApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class UiTranslationSpec implements Parcelable {
    public static final Parcelable.Creator<UiTranslationSpec> CREATOR = new Parcelable.Creator<UiTranslationSpec>() { // from class: android.view.translation.UiTranslationSpec.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UiTranslationSpec[] newArray(int size) {
            return new UiTranslationSpec[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UiTranslationSpec createFromParcel(Parcel in) {
            return new UiTranslationSpec(in);
        }
    };
    private boolean mShouldPadContentForCompat;

    public boolean shouldPadContentForCompat() {
        return this.mShouldPadContentForCompat;
    }

    UiTranslationSpec(boolean shouldPadContentForCompat) {
        this.mShouldPadContentForCompat = false;
        this.mShouldPadContentForCompat = shouldPadContentForCompat;
    }

    public String toString() {
        return "UiTranslationSpec { shouldPadContentForCompat = " + this.mShouldPadContentForCompat + " }";
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        UiTranslationSpec that = (UiTranslationSpec) o10;
        if (this.mShouldPadContentForCompat == that.mShouldPadContentForCompat) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + Boolean.hashCode(this.mShouldPadContentForCompat);
        return _hash;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        byte flg = this.mShouldPadContentForCompat ? (byte) (0 | 1) : (byte) 0;
        dest.writeByte(flg);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    UiTranslationSpec(Parcel in) {
        this.mShouldPadContentForCompat = false;
        byte flg = in.readByte();
        boolean shouldPadContentForCompat = (flg & 1) != 0;
        this.mShouldPadContentForCompat = shouldPadContentForCompat;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder {
        private long mBuilderFieldsSet = 0;
        private boolean mShouldPadContentForCompat;

        public Builder setShouldPadContentForCompat(boolean value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 1;
            this.mShouldPadContentForCompat = value;
            return this;
        }

        public UiTranslationSpec build() {
            checkNotUsed();
            long j10 = this.mBuilderFieldsSet | 2;
            this.mBuilderFieldsSet = j10;
            if ((j10 & 1) == 0) {
                this.mShouldPadContentForCompat = false;
            }
            UiTranslationSpec o10 = new UiTranslationSpec(this.mShouldPadContentForCompat);
            return o10;
        }

        private void checkNotUsed() {
            if ((this.mBuilderFieldsSet & 2) != 0) {
                throw new IllegalStateException("This Builder should not be reused. Use a new Builder instance instead");
            }
        }
    }

    @Deprecated
    private void __metadata() {
    }
}
