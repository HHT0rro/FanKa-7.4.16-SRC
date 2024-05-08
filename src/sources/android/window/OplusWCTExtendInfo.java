package android.window;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OplusWCTExtendInfo implements Parcelable {
    public static final Parcelable.Creator<OplusWCTExtendInfo> CREATOR = new Parcelable.Creator<OplusWCTExtendInfo>() { // from class: android.window.OplusWCTExtendInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusWCTExtendInfo createFromParcel(Parcel in) {
            return new OplusWCTExtendInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusWCTExtendInfo[] newArray(int size) {
            return new OplusWCTExtendInfo[size];
        }
    };
    private int mFlags;
    private boolean mIsRecentTransition;
    private boolean mRecentInterrupt;
    private boolean mRemoteInterrupt;

    public OplusWCTExtendInfo() {
        this.mRemoteInterrupt = false;
        this.mRecentInterrupt = false;
        this.mIsRecentTransition = false;
        this.mFlags = 0;
    }

    protected OplusWCTExtendInfo(Parcel in) {
        this.mRemoteInterrupt = false;
        this.mRecentInterrupt = false;
        this.mIsRecentTransition = false;
        this.mFlags = 0;
        this.mRemoteInterrupt = in.readBoolean();
        this.mRecentInterrupt = in.readBoolean();
        this.mIsRecentTransition = in.readBoolean();
        this.mFlags = in.readInt();
    }

    public void setRemoteInterrupt(boolean interruptAnim) {
        this.mRemoteInterrupt = interruptAnim;
    }

    public boolean getRemoteInterrupt() {
        return this.mRemoteInterrupt;
    }

    public boolean isRecentInterrupt() {
        return this.mRecentInterrupt;
    }

    public void setRecentInterrupt(boolean recentInterrupt) {
        this.mRecentInterrupt = recentInterrupt;
    }

    public boolean isRecentTransition() {
        return this.mIsRecentTransition;
    }

    public void setRecentTransition(boolean isRecentTransition) {
        this.mIsRecentTransition = isRecentTransition;
    }

    public void addFlags(int flags, int mask) {
        this.mFlags = (this.mFlags & (~mask)) | (flags & mask);
    }

    public void addFlags(int flags) {
        this.mFlags |= flags;
    }

    public int getFlags() {
        return this.mFlags;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBoolean(this.mRemoteInterrupt);
        dest.writeBoolean(this.mRecentInterrupt);
        dest.writeBoolean(this.mIsRecentTransition);
        dest.writeInt(this.mFlags);
    }

    public String toString() {
        return "OplusWCTExtendInfo{mRemoteInterrupt=" + this.mRemoteInterrupt + ", mRecentInterrupt=" + this.mRecentInterrupt + ", mIsRecentTransition=" + this.mIsRecentTransition + '}';
    }
}
