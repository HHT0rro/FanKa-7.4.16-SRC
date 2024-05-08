package android.window;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.window.ITaskFragmentOrganizer;
import com.alipay.sdk.util.i;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TaskFragmentOrganizerToken implements Parcelable {
    public static final Parcelable.Creator<TaskFragmentOrganizerToken> CREATOR = new Parcelable.Creator<TaskFragmentOrganizerToken>() { // from class: android.window.TaskFragmentOrganizerToken.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskFragmentOrganizerToken createFromParcel(Parcel in) {
            ITaskFragmentOrganizer realToken = ITaskFragmentOrganizer.Stub.asInterface(in.readStrongBinder());
            if (realToken == null) {
                return null;
            }
            return new TaskFragmentOrganizerToken(realToken);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskFragmentOrganizerToken[] newArray(int size) {
            return new TaskFragmentOrganizerToken[size];
        }
    };
    private final ITaskFragmentOrganizer mRealToken;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaskFragmentOrganizerToken(ITaskFragmentOrganizer realToken) {
        this.mRealToken = realToken;
    }

    public IBinder asBinder() {
        return this.mRealToken.asBinder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongInterface(this.mRealToken);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return this.mRealToken.asBinder().hashCode();
    }

    public String toString() {
        return "TaskFragmentOrganizerToken{" + ((Object) this.mRealToken) + i.f4738d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof TaskFragmentOrganizerToken) && this.mRealToken.asBinder() == ((TaskFragmentOrganizerToken) obj).asBinder();
    }
}
