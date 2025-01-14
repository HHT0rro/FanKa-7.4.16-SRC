package android.view.inputmethod;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class InputBinding implements Parcelable {
    public static final Parcelable.Creator<InputBinding> CREATOR = new Parcelable.Creator<InputBinding>() { // from class: android.view.inputmethod.InputBinding.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputBinding createFromParcel(Parcel source) {
            return new InputBinding(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputBinding[] newArray(int size) {
            return new InputBinding[size];
        }
    };
    static final String TAG = "InputBinding";
    final InputConnection mConnection;
    final IBinder mConnectionToken;
    final int mPid;
    final int mUid;

    public InputBinding(InputConnection conn, IBinder connToken, int uid, int pid) {
        this.mConnection = conn;
        this.mConnectionToken = connToken;
        this.mUid = uid;
        this.mPid = pid;
    }

    public InputBinding(InputConnection conn, InputBinding binding) {
        this.mConnection = conn;
        this.mConnectionToken = binding.getConnectionToken();
        this.mUid = binding.getUid();
        this.mPid = binding.getPid();
    }

    InputBinding(Parcel source) {
        this.mConnection = null;
        this.mConnectionToken = source.readStrongBinder();
        this.mUid = source.readInt();
        this.mPid = source.readInt();
    }

    public InputConnection getConnection() {
        return this.mConnection;
    }

    public IBinder getConnectionToken() {
        return this.mConnectionToken;
    }

    public int getUid() {
        return this.mUid;
    }

    public int getPid() {
        return this.mPid;
    }

    public String toString() {
        return "InputBinding{" + ((Object) this.mConnectionToken) + " / uid " + this.mUid + " / pid " + this.mPid + i.f4738d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(this.mConnectionToken);
        dest.writeInt(this.mUid);
        dest.writeInt(this.mPid);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
