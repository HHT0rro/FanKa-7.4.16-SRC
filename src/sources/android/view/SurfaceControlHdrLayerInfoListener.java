package android.view;

import android.os.IBinder;
import android.util.ArrayMap;
import java.util.Objects;
import libcore.util.NativeAllocationRegistry;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class SurfaceControlHdrLayerInfoListener {
    private static final NativeAllocationRegistry sRegistry = NativeAllocationRegistry.createMalloced(SurfaceControlHdrLayerInfoListener.class.getClassLoader(), nGetDestructor());
    private ArrayMap<IBinder, Runnable> mRegisteredListeners = new ArrayMap<>();

    private static native long nGetDestructor();

    private native long nRegister(IBinder iBinder);

    public abstract void onHdrInfoChanged(IBinder iBinder, int i10, int i11, int i12, int i13, float f10);

    public void register(IBinder displayToken) {
        Objects.requireNonNull(displayToken);
        synchronized (this) {
            if (this.mRegisteredListeners.containsKey(displayToken)) {
                return;
            }
            long nativePtr = nRegister(displayToken);
            Runnable destructor = sRegistry.registerNativeAllocation(this, nativePtr);
            this.mRegisteredListeners.put(displayToken, destructor);
        }
    }

    public void unregister(IBinder displayToken) {
        Runnable destructor;
        Objects.requireNonNull(displayToken);
        synchronized (this) {
            destructor = this.mRegisteredListeners.remove(displayToken);
        }
        if (destructor != null) {
            destructor.run();
        }
    }

    public void unregisterAll() {
        ArrayMap<IBinder, Runnable> toDestroy;
        synchronized (this) {
            toDestroy = this.mRegisteredListeners;
            this.mRegisteredListeners = new ArrayMap<>();
        }
        for (Runnable destructor : toDestroy.values()) {
            destructor.run();
        }
    }
}
