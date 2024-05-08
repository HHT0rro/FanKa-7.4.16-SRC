package android.window;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.SurfaceControl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OplusTransitionExtendedInfo implements Parcelable {
    public static final Parcelable.Creator<OplusTransitionExtendedInfo> CREATOR = new Parcelable.Creator<OplusTransitionExtendedInfo>() { // from class: android.window.OplusTransitionExtendedInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusTransitionExtendedInfo createFromParcel(Parcel in) {
            return new OplusTransitionExtendedInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusTransitionExtendedInfo[] newArray(int size) {
            return new OplusTransitionExtendedInfo[size];
        }
    };
    private boolean mInOplusCompatMode;
    private SurfaceControl.Transaction mTmpFinishT;

    public OplusTransitionExtendedInfo() {
    }

    protected OplusTransitionExtendedInfo(Parcel in) {
        this.mTmpFinishT = (SurfaceControl.Transaction) in.readParcelable(SurfaceControl.Transaction.class.getClassLoader(), SurfaceControl.Transaction.class);
        this.mInOplusCompatMode = in.readBoolean();
    }

    public void setTmpFinishT(SurfaceControl.Transaction tmpFinishT) {
        this.mTmpFinishT = tmpFinishT;
    }

    public SurfaceControl.Transaction getTmpFinishT() {
        return this.mTmpFinishT;
    }

    public void setOplusCompatMode(boolean inOplusCompatMode) {
        this.mInOplusCompatMode = inOplusCompatMode;
    }

    public boolean inOplusCompatMode() {
        return this.mInOplusCompatMode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mTmpFinishT, flags);
        dest.writeBoolean(this.mInOplusCompatMode);
    }

    public String toString() {
        return "OplusTransitionExtendedInfo{mTmpFinishT=" + ((Object) this.mTmpFinishT) + "mInOplusCompatMode=" + this.mInOplusCompatMode + '}';
    }
}
