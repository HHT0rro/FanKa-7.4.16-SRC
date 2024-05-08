package com.huawei.jmessage.api;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.huawei.jmessage.api.EventCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class EventSource {
    private Firer mFirer;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Firer {
        void fire(Object obj);
    }

    public void fire(Object obj) {
        Firer firer = this.mFirer;
        if (firer != null) {
            firer.fire(obj);
        }
    }

    public boolean onDispatch(@NonNull Subscriber subscriber, @NonNull EventCallback.Message message) {
        return true;
    }

    public Object onFire(Object obj) {
        return obj;
    }

    @CallSuper
    public void onInitialize(Firer firer) {
        this.mFirer = firer;
    }

    public void onRelease() {
    }

    public boolean onSubscribe(@NonNull Subscriber subscriber) {
        return true;
    }

    public void onUnsubscribe(@NonNull Subscriber subscriber) {
    }
}
