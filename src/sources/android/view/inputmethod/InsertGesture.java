package android.view.inputmethod;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class InsertGesture extends HandwritingGesture implements Parcelable {
    public static final Parcelable.Creator<InsertGesture> CREATOR = new Parcelable.Creator<InsertGesture>() { // from class: android.view.inputmethod.InsertGesture.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InsertGesture createFromParcel(Parcel source) {
            return new InsertGesture(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InsertGesture[] newArray(int size) {
            return new InsertGesture[size];
        }
    };
    private PointF mPoint;
    private String mTextToInsert;

    private InsertGesture(String text, PointF point, String fallbackText) {
        this.mType = 2;
        this.mPoint = point;
        this.mTextToInsert = text;
        this.mFallbackText = fallbackText;
    }

    private InsertGesture(Parcel source) {
        this.mType = 2;
        this.mFallbackText = source.readString8();
        this.mTextToInsert = source.readString8();
        this.mPoint = (PointF) source.readTypedObject(PointF.CREATOR);
    }

    public String getTextToInsert() {
        return this.mTextToInsert;
    }

    public PointF getInsertionPoint() {
        return this.mPoint;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder {
        private String mFallbackText;
        private PointF mPoint;
        private String mText;

        public Builder setTextToInsert(String text) {
            this.mText = text;
            return this;
        }

        public Builder setInsertionPoint(PointF point) {
            this.mPoint = point;
            return this;
        }

        public Builder setFallbackText(String fallbackText) {
            this.mFallbackText = fallbackText;
            return this;
        }

        public InsertGesture build() {
            if (this.mPoint == null) {
                throw new IllegalArgumentException("Insertion point must be set.");
            }
            if (this.mText == null) {
                throw new IllegalArgumentException("Text to insert must be set.");
            }
            return new InsertGesture(this.mText, this.mPoint, this.mFallbackText);
        }
    }

    public int hashCode() {
        return Objects.hash(this.mPoint, this.mTextToInsert, this.mFallbackText);
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (!(o10 instanceof InsertGesture)) {
            return false;
        }
        InsertGesture that = (InsertGesture) o10;
        if (Objects.equals(this.mFallbackText, that.mFallbackText) && Objects.equals(this.mTextToInsert, that.mTextToInsert)) {
            return Objects.equals(this.mPoint, that.mPoint);
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
        dest.writeString8(this.mTextToInsert);
        dest.writeTypedObject(this.mPoint, flags);
    }
}
