package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    @VisibleForTesting
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        private ModelKey() {
        }

        public static <A> ModelKey<A> get(A a10, int i10, int i11) {
            ModelKey<A> modelKey;
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                modelKey = (ModelKey) queue.poll();
            }
            if (modelKey == null) {
                modelKey = new ModelKey<>();
            }
            modelKey.init(a10, i10, i11);
            return modelKey;
        }

        private void init(A a10, int i10, int i11) {
            this.model = a10;
            this.width = i10;
            this.height = i11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            return this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model);
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
        }

        public void release() {
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                queue.offer(this);
            }
        }
    }

    public ModelCache() {
        this(250L);
    }

    public void clear() {
        this.cache.clearMemory();
    }

    @Nullable
    public B get(A a10, int i10, int i11) {
        ModelKey<A> modelKey = ModelKey.get(a10, i10, i11);
        B b4 = this.cache.get(modelKey);
        modelKey.release();
        return b4;
    }

    public void put(A a10, int i10, int i11, B b4) {
        this.cache.put(ModelKey.get(a10, i10, i11), b4);
    }

    public ModelCache(long j10) {
        this.cache = new LruCache<ModelKey<A>, B>(j10) { // from class: com.bumptech.glide.load.model.ModelCache.1
            @Override // com.bumptech.glide.util.LruCache
            public /* bridge */ /* synthetic */ void onItemEvicted(@NonNull Object obj, @Nullable Object obj2) {
                onItemEvicted((ModelKey) obj, (ModelKey<A>) obj2);
            }

            public void onItemEvicted(@NonNull ModelKey<A> modelKey, @Nullable B b4) {
                modelKey.release();
            }
        };
    }
}
