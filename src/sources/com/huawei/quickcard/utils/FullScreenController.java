package com.huawei.quickcard.utils;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FullScreenController {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<FullScreenImpl> f34269a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Integer, WeakReference<IFullScreenEventListener>> f34270b = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface IFullScreenEventListener {
        void onEnterFullScreen();

        void onExitFullScreen();
    }

    public static int addListeners(@NonNull IFullScreenEventListener iFullScreenEventListener) {
        int hashCode = iFullScreenEventListener.hashCode();
        f34270b.put(Integer.valueOf(hashCode), new WeakReference<>(iFullScreenEventListener));
        return hashCode;
    }

    public static void callNotifyEnterEvent() {
        IFullScreenEventListener iFullScreenEventListener;
        Iterator<Map.Entry<Integer, WeakReference<IFullScreenEventListener>>> iterator2 = f34270b.entrySet().iterator2();
        while (iterator2.hasNext()) {
            WeakReference<IFullScreenEventListener> value = iterator2.next().getValue();
            if (value != null && (iFullScreenEventListener = value.get()) != null) {
                iFullScreenEventListener.onEnterFullScreen();
            }
        }
    }

    public static void callNotifyExitEvent() {
        IFullScreenEventListener iFullScreenEventListener;
        Iterator<Map.Entry<Integer, WeakReference<IFullScreenEventListener>>> iterator2 = f34270b.entrySet().iterator2();
        while (iterator2.hasNext()) {
            WeakReference<IFullScreenEventListener> value = iterator2.next().getValue();
            if (value != null && (iFullScreenEventListener = value.get()) != null) {
                iFullScreenEventListener.onExitFullScreen();
            }
        }
    }

    public static void clearListeners() {
        f34270b.clear();
    }

    public static void exitFullScreen() {
        FullScreenImpl fullScreenImpl;
        WeakReference<FullScreenImpl> weakReference = f34269a;
        if (weakReference == null || (fullScreenImpl = weakReference.get()) == null) {
            return;
        }
        fullScreenImpl.exitFullScreen();
    }

    public static boolean isFullScreen() {
        WeakReference<FullScreenImpl> weakReference = f34269a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public static void removeListener(int i10) {
        f34270b.remove(Integer.valueOf(i10));
    }

    public static void setFullScreenImpl(FullScreenImpl fullScreenImpl) {
        if (fullScreenImpl == null) {
            f34269a = null;
        } else {
            f34269a = new WeakReference<>(fullScreenImpl);
        }
    }
}
