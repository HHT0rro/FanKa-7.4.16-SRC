package android.view.inputmethod;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ParcelableHandwritingGesture implements Parcelable {
    public static final Parcelable.Creator<ParcelableHandwritingGesture> CREATOR = new Parcelable.Creator<ParcelableHandwritingGesture>() { // from class: android.view.inputmethod.ParcelableHandwritingGesture.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableHandwritingGesture createFromParcel(Parcel in) {
            int gestureType = in.readInt();
            return new ParcelableHandwritingGesture(ParcelableHandwritingGesture.createFromParcelInternal(gestureType, in));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableHandwritingGesture[] newArray(int size) {
            return new ParcelableHandwritingGesture[size];
        }
    };
    private final HandwritingGesture mGesture;
    private final Parcelable mGestureAsParcelable;

    /* JADX WARN: Multi-variable type inference failed */
    private ParcelableHandwritingGesture(HandwritingGesture handwritingGesture) {
        this.mGesture = handwritingGesture;
        this.mGestureAsParcelable = (Parcelable) handwritingGesture;
    }

    public static ParcelableHandwritingGesture of(HandwritingGesture gesture) {
        return new ParcelableHandwritingGesture((HandwritingGesture) Objects.requireNonNull(gesture));
    }

    public HandwritingGesture get() {
        return this.mGesture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HandwritingGesture createFromParcelInternal(int gestureType, Parcel parcel) {
        switch (gestureType) {
            case 0:
                throw new UnsupportedOperationException("GESTURE_TYPE_NONE is not supported");
            case 1:
                return SelectGesture.CREATOR.createFromParcel(parcel);
            case 2:
                return InsertGesture.CREATOR.createFromParcel(parcel);
            case 4:
                return DeleteGesture.CREATOR.createFromParcel(parcel);
            case 8:
                return RemoveSpaceGesture.CREATOR.createFromParcel(parcel);
            case 16:
                return JoinOrSplitGesture.CREATOR.createFromParcel(parcel);
            case 32:
                return SelectRangeGesture.CREATOR.createFromParcel(parcel);
            case 64:
                return DeleteRangeGesture.CREATOR.createFromParcel(parcel);
            case 128:
                return InsertModeGesture.CREATOR.createFromParcel(parcel);
            default:
                throw new UnsupportedOperationException("Unknown type=" + gestureType);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mGestureAsParcelable.describeContents();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mGesture.getGestureType());
        this.mGestureAsParcelable.writeToParcel(dest, flags);
    }
}
