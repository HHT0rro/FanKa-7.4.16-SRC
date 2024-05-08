package android.view;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import libcore.util.NativeAllocationRegistry;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class InputChannel implements Parcelable {
    private static final boolean DEBUG = false;
    private static final String TAG = "InputChannel";
    private long mPtr;
    private static final NativeAllocationRegistry sRegistry = NativeAllocationRegistry.createMalloced(InputChannel.class.getClassLoader(), nativeGetFinalizer());
    public static final Parcelable.Creator<InputChannel> CREATOR = new Parcelable.Creator<InputChannel>() { // from class: android.view.InputChannel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputChannel createFromParcel(Parcel source) {
            InputChannel result = new InputChannel();
            result.readFromParcel(source);
            return result;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputChannel[] newArray(int size) {
            return new InputChannel[size];
        }
    };

    private native void nativeDispose(long j10);

    private native long nativeDup(long j10);

    private static native long nativeGetFinalizer();

    private native String nativeGetName(long j10);

    private native IBinder nativeGetToken(long j10);

    private static native long[] nativeOpenInputChannelPair(String str);

    private native long nativeReadFromParcel(Parcel parcel);

    private native void nativeWriteToParcel(Parcel parcel, long j10);

    private void setNativeInputChannel(long nativeChannel) {
        if (nativeChannel == 0) {
            throw new IllegalArgumentException("Attempting to set native input channel to null.");
        }
        if (this.mPtr != 0) {
            throw new IllegalArgumentException("Already has native input channel.");
        }
        sRegistry.registerNativeAllocation(this, nativeChannel);
        this.mPtr = nativeChannel;
    }

    public static InputChannel[] openInputChannelPair(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        InputChannel[] channels = new InputChannel[2];
        long[] nativeChannels = nativeOpenInputChannelPair(name);
        for (int i10 = 0; i10 < 2; i10++) {
            channels[i10] = new InputChannel();
            channels[i10].setNativeInputChannel(nativeChannels[i10]);
        }
        return channels;
    }

    public String getName() {
        String name = nativeGetName(this.mPtr);
        return name != null ? name : "uninitialized";
    }

    public void dispose() {
        nativeDispose(this.mPtr);
    }

    public void release() {
    }

    public void copyTo(InputChannel outParameter) {
        if (outParameter == null) {
            throw new IllegalArgumentException("outParameter must not be null");
        }
        if (outParameter.mPtr != 0) {
            throw new IllegalArgumentException("Other object already has a native input channel.");
        }
        outParameter.setNativeInputChannel(nativeDup(this.mPtr));
    }

    public InputChannel dup() {
        InputChannel target = new InputChannel();
        target.setNativeInputChannel(nativeDup(this.mPtr));
        return target;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    public void readFromParcel(Parcel in) {
        if (in == null) {
            throw new IllegalArgumentException("in must not be null");
        }
        long nativeIn = nativeReadFromParcel(in);
        if (nativeIn != 0) {
            setNativeInputChannel(nativeIn);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        if (out == null) {
            throw new IllegalArgumentException("out must not be null");
        }
        nativeWriteToParcel(out, this.mPtr);
        if ((flags & 1) != 0) {
            dispose();
        }
    }

    public String toString() {
        return getName();
    }

    public IBinder getToken() {
        return nativeGetToken(this.mPtr);
    }
}
