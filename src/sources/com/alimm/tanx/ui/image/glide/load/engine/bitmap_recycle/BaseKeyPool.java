package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.Poolable;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BaseKeyPool<T extends Poolable> {
    public static final int MAX_SIZE = 20;
    public final Queue<T> keyPool = Util.createQueue(20);

    public abstract T create();

    public T get() {
        T poll = this.keyPool.poll();
        return poll == null ? create() : poll;
    }

    public void offer(T t2) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(t2);
        }
    }
}
