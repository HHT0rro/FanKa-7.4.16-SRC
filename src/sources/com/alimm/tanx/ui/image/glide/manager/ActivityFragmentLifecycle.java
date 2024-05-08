package com.alimm.tanx.ui.image.glide.manager;

import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ActivityFragmentLifecycle implements Lifecycle {
    public boolean isDestroyed;
    public boolean isStarted;
    public final Set<LifecycleListener> lifecycleListeners = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.alimm.tanx.ui.image.glide.manager.Lifecycle
    public void addListener(LifecycleListener lifecycleListener) {
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
}
