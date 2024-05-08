package android.view.displayhash;

import android.annotation.NonNull;
import android.annotation.SystemApi;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.AnnotationValidations;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class DisplayHash implements Parcelable {
    public static final Parcelable.Creator<DisplayHash> CREATOR = new Parcelable.Creator<DisplayHash>() { // from class: android.view.displayhash.DisplayHash.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisplayHash[] newArray(int size) {
            return new DisplayHash[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisplayHash createFromParcel(Parcel in) {
            return new DisplayHash(in);
        }
    };
    private final Rect mBoundsInWindow;
    private final String mHashAlgorithm;
    private final byte[] mHmac;
    private final byte[] mImageHash;
    private final long mTimeMillis;

    @SystemApi
    public DisplayHash(long timeMillis, Rect boundsInWindow, String hashAlgorithm, byte[] imageHash, byte[] hmac) {
        this.mTimeMillis = timeMillis;
        this.mBoundsInWindow = boundsInWindow;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, boundsInWindow);
        this.mHashAlgorithm = hashAlgorithm;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, hashAlgorithm);
        this.mImageHash = imageHash;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, imageHash);
        this.mHmac = hmac;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, hmac);
    }

    @SystemApi
    public long getTimeMillis() {
        return this.mTimeMillis;
    }

    @SystemApi
    public Rect getBoundsInWindow() {
        return this.mBoundsInWindow;
    }

    @SystemApi
    public String getHashAlgorithm() {
        return this.mHashAlgorithm;
    }

    @SystemApi
    public byte[] getImageHash() {
        return this.mImageHash;
    }

    @SystemApi
    public byte[] getHmac() {
        return this.mHmac;
    }

    public String toString() {
        return "DisplayHash { timeMillis = " + this.mTimeMillis + ", boundsInWindow = " + ((Object) this.mBoundsInWindow) + ", hashAlgorithm = " + this.mHashAlgorithm + ", imageHash = " + byteArrayToString(this.mImageHash) + ", hmac = " + byteArrayToString(this.mHmac) + " }";
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

    @Override // android.os.Parcelable
    @SystemApi
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.mTimeMillis);
        dest.writeTypedObject(this.mBoundsInWindow, flags);
        dest.writeString(this.mHashAlgorithm);
        dest.writeByteArray(this.mImageHash);
        dest.writeByteArray(this.mHmac);
    }

    @Override // android.os.Parcelable
    @SystemApi
    public int describeContents() {
        return 0;
    }

    private DisplayHash(Parcel in) {
        this.mTimeMillis = in.readLong();
        Rect boundsInWindow = (Rect) in.readTypedObject(Rect.CREATOR);
        String hashAlgorithm = in.readString();
        byte[] imageHash = in.createByteArray();
        byte[] hmac = in.createByteArray();
        this.mBoundsInWindow = boundsInWindow;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, boundsInWindow);
        this.mHashAlgorithm = hashAlgorithm;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, hashAlgorithm);
        this.mImageHash = imageHash;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, imageHash);
        this.mHmac = hmac;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, hmac);
    }
}
