package android.view.contentcapture;

import android.annotation.NonNull;
import android.app.ActivityThread;
import android.content.LocusId;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.AnnotationValidations;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class DataShareRequest implements Parcelable {
    public static final Parcelable.Creator<DataShareRequest> CREATOR = new Parcelable.Creator<DataShareRequest>() { // from class: android.view.contentcapture.DataShareRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataShareRequest[] newArray(int size) {
            return new DataShareRequest[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataShareRequest createFromParcel(Parcel in) {
            return new DataShareRequest(in);
        }
    };
    private final LocusId mLocusId;
    private final String mMimeType;
    private final String mPackageName;

    public DataShareRequest(LocusId locusId, String mimeType) {
        Objects.requireNonNull(mimeType);
        this.mPackageName = ActivityThread.currentActivityThread().getApplication().getPackageName();
        this.mLocusId = locusId;
        this.mMimeType = mimeType;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public LocusId getLocusId() {
        return this.mLocusId;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public String toString() {
        return "DataShareRequest { packageName = " + this.mPackageName + ", locusId = " + ((Object) this.mLocusId) + ", mimeType = " + this.mMimeType + " }";
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        DataShareRequest that = (DataShareRequest) o10;
        if (Objects.equals(this.mPackageName, that.mPackageName) && Objects.equals(this.mLocusId, that.mLocusId) && Objects.equals(this.mMimeType, that.mMimeType)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + Objects.hashCode(this.mPackageName);
        return (((_hash * 31) + Objects.hashCode(this.mLocusId)) * 31) + Objects.hashCode(this.mMimeType);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        byte flg = this.mLocusId != null ? (byte) (0 | 2) : (byte) 0;
        dest.writeByte(flg);
        dest.writeString(this.mPackageName);
        LocusId locusId = this.mLocusId;
        if (locusId != null) {
            dest.writeTypedObject(locusId, flags);
        }
        dest.writeString(this.mMimeType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    DataShareRequest(Parcel in) {
        byte flg = in.readByte();
        String packageName = in.readString();
        LocusId locusId = (flg & 2) == 0 ? null : (LocusId) in.readTypedObject(LocusId.CREATOR);
        String mimeType = in.readString();
        this.mPackageName = packageName;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, packageName);
        this.mLocusId = locusId;
        this.mMimeType = mimeType;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, mimeType);
    }

    @Deprecated
    private void __metadata() {
    }
}
