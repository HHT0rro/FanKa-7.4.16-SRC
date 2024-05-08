package android.view.inputmethod;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class DeleteGesture extends PreviewableHandwritingGesture implements Parcelable {
    public static final Parcelable.Creator<DeleteGesture> CREATOR = new Parcelable.Creator<DeleteGesture>() { // from class: android.view.inputmethod.DeleteGesture.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeleteGesture createFromParcel(Parcel source) {
            return new DeleteGesture(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeleteGesture[] newArray(int size) {
            return new DeleteGesture[size];
        }
    };
    private RectF mArea;
    private int mGranularity;

    private DeleteGesture(int granularity, RectF area, String fallbackText) {
        this.mType = 4;
        this.mArea = area;
        this.mGranularity = granularity;
        this.mFallbackText = fallbackText;
    }

    private DeleteGesture(Parcel source) {
        this.mType = 4;
        this.mFallbackText = source.readString8();
        this.mGranularity = source.readInt();
        this.mArea = (RectF) source.readTypedObject(RectF.CREATOR);
    }

    public int getGranularity() {
        return this.mGranularity;
    }

    public RectF getDeletionArea() {
        return this.mArea;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder {
        private RectF mArea;
        private String mFallbackText;
        private int mGranularity;

        public Builder setGranularity(int granularity) {
            this.mGranularity = granularity;
            return this;
        }

        public Builder setDeletionArea(RectF area) {
            this.mArea = area;
            return this;
        }

        public Builder setFallbackText(String fallbackText) {
            this.mFallbackText = fallbackText;
            return this;
        }

        public DeleteGesture build() {
            RectF rectF = this.mArea;
            if (rectF == null || rectF.isEmpty()) {
                throw new IllegalArgumentException("Deletion area must be set.");
            }
            if (this.mGranularity <= 0) {
                throw new IllegalArgumentException("Deletion granularity must be set.");
            }
            return new DeleteGesture(this.mGranularity, this.mArea, this.mFallbackText);
        }
    }

    public int hashCode() {
        return Objects.hash(this.mArea, Integer.valueOf(this.mGranularity), this.mFallbackText);
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (!(o10 instanceof DeleteGesture)) {
            return false;
        }
        DeleteGesture that = (DeleteGesture) o10;
        if (this.mGranularity == that.mGranularity && Objects.equals(this.mFallbackText, that.mFallbackText)) {
            return Objects.equals(this.mArea, that.mArea);
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString8(this.mFallbackText);
        dest.writeInt(this.mGranularity);
        dest.writeTypedObject(this.mArea, flags);
    }
}
