package android.view;

import android.annotation.NonNull;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.IInputMonitorHost;
import com.android.internal.util.AnnotationValidations;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class InputMonitor implements Parcelable {
    public static final Parcelable.Creator<InputMonitor> CREATOR = new Parcelable.Creator<InputMonitor>() { // from class: android.view.InputMonitor.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputMonitor[] newArray(int size) {
            return new InputMonitor[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputMonitor createFromParcel(Parcel in) {
            return new InputMonitor(in);
        }
    };
    private static final boolean DEBUG = false;
    private static final String TAG = "InputMonitor";
    private final IInputMonitorHost mHost;
    private final InputChannel mInputChannel;
    private final SurfaceControl mSurface;

    public void pilferPointers() {
        try {
            this.mHost.pilferPointers();
        } catch (RemoteException e2) {
            e2.rethrowFromSystemServer();
        }
    }

    public void dispose() {
        this.mInputChannel.dispose();
        this.mSurface.release();
        try {
            this.mHost.dispose();
        } catch (RemoteException e2) {
            e2.rethrowFromSystemServer();
        }
    }

    public InputMonitor(InputChannel inputChannel, IInputMonitorHost host, SurfaceControl surface) {
        this.mInputChannel = inputChannel;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, inputChannel);
        this.mHost = host;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, host);
        this.mSurface = surface;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, surface);
    }

    public InputChannel getInputChannel() {
        return this.mInputChannel;
    }

    public IInputMonitorHost getHost() {
        return this.mHost;
    }

    public SurfaceControl getSurface() {
        return this.mSurface;
    }

    public String toString() {
        return "InputMonitor { inputChannel = " + ((Object) this.mInputChannel) + ", host = " + ((Object) this.mHost) + ", surface = " + ((Object) this.mSurface) + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedObject(this.mInputChannel, flags);
        dest.writeStrongInterface(this.mHost);
        dest.writeTypedObject(this.mSurface, flags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    InputMonitor(Parcel in) {
        InputChannel inputChannel = (InputChannel) in.readTypedObject(InputChannel.CREATOR);
        IInputMonitorHost host = IInputMonitorHost.Stub.asInterface(in.readStrongBinder());
        SurfaceControl surface = (SurfaceControl) in.readTypedObject(SurfaceControl.CREATOR);
        this.mInputChannel = inputChannel;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, inputChannel);
        this.mHost = host;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, host);
        this.mSurface = surface;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, surface);
    }

    @Deprecated
    private void __metadata() {
    }
}
