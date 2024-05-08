package android.view.displayhash;

import android.annotation.CurrentTimeMillisLong;
import android.annotation.NonNull;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.AnnotationValidations;
import java.lang.annotation.Annotation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class VerifiedDisplayHash implements Parcelable {
    public static final Parcelable.Creator<VerifiedDisplayHash> CREATOR = new Parcelable.Creator<VerifiedDisplayHash>() { // from class: android.view.displayhash.VerifiedDisplayHash.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerifiedDisplayHash[] newArray(int size) {
            return new VerifiedDisplayHash[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerifiedDisplayHash createFromParcel(Parcel in) {
            return new VerifiedDisplayHash(in);
        }
    };
    private final Rect mBoundsInWindow;
    private final String mHashAlgorithm;
    private final byte[] mImageHash;
    private final long mTimeMillis;

    private String imageHashToString() {
        return byteArrayToString(this.mImageHash);
    }

    private String byteArrayToString(byte[] byteArray) {
        if (byteArray == null) {
            return "null";
        }
        int iMax = byteArray.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            String formatted = String.format("%02X", Integer.valueOf(byteArray[i10] & 255));
            b4.append(formatted);
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(", ");
            i10++;
        }
    }

    public VerifiedDisplayHash(long timeMillis, Rect boundsInWindow, String hashAlgorithm, byte[] imageHash) {
        this.mTimeMillis = timeMillis;
        AnnotationValidations.validate(CurrentTimeMillisLong.class, (Annotation) null, timeMillis);
        this.mBoundsInWindow = boundsInWindow;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, boundsInWindow);
        this.mHashAlgorithm = hashAlgorithm;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, hashAlgorithm);
        this.mImageHash = imageHash;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, imageHash);
    }

    public long getTimeMillis() {
        return this.mTimeMillis;
    }

    public Rect getBoundsInWindow() {
        return this.mBoundsInWindow;
    }

    public String getHashAlgorithm() {
        return this.mHashAlgorithm;
    }

    public byte[] getImageHash() {
        return this.mImageHash;
    }

    public String toString() {
        return "VerifiedDisplayHash { timeMillis = " + this.mTimeMillis + ", boundsInWindow = " + ((Object) this.mBoundsInWindow) + ", hashAlgorithm = " + this.mHashAlgorithm + ", imageHash = " + imageHashToString() + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.mTimeMillis);
        dest.writeTypedObject(this.mBoundsInWindow, flags);
        dest.writeString(this.mHashAlgorithm);
        dest.writeByteArray(this.mImageHash);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    VerifiedDisplayHash(Parcel in) {
        long timeMillis = in.readLong();
        Rect boundsInWindow = (Rect) in.readTypedObject(Rect.CREATOR);
        String hashAlgorithm = in.readString();
        byte[] imageHash = in.createByteArray();
        this.mTimeMillis = timeMillis;
        AnnotationValidations.validate(CurrentTimeMillisLong.class, (Annotation) null, timeMillis);
        this.mBoundsInWindow = boundsInWindow;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, boundsInWindow);
        this.mHashAlgorithm = hashAlgorithm;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, hashAlgorithm);
        this.mImageHash = imageHash;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, imageHash);
    }

    @Deprecated
    private void __metadata() {
    }
}
