package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ActivityFragmentLifecycle implements Lifecycle {
    private boolean isDestroyed;
    private boolean isStarted;
    private final Set<LifecycleListener> lifecycleListeners = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(@NonNull LifecycleListener lifecycleListener) {
        this.lifecycleListeners.add(lifecycleListener);
        if (this.isDestroyed) {
            lifecycleListener.onDestroy();
        } else if (this.isStarted) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    public void onDestroy() {
        this.isDestroyed = true;
        Iterator iterator2 = Util.getSnapshot(this.lifecycleListeners).iterator2();
        while (iterator2.hasNext()) {
            ((LifecycleListener) iterator2.next()).onDestroy();
        }
    }

    public void onStart() {
        this.isStarted = true;
        Iterator iterator2 = Util.getSnapshot(this.lifecycleListeners).iterator2();
        while (iterator2.hasNext()) {
            ((LifecycleListener) iterator2.next()).onStart();
        }
    }

    public void onStop() {
        this.isStarted = false;
        Iterator iterator2 = Util.getSnapshot(this.lifecycleListeners).iterator2();
        while (iterator2.hasNext()) {
            ((LifecycleListener) iterator2.next()).onStop();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(@NonNull LifecycleListener lifecycleListener) {
        this.lifecycleListeners.remove(lifecycleListener);
    }
}
