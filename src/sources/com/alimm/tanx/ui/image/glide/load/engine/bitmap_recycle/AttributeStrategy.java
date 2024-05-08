package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.util.Util;
import nd.a;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AttributeStrategy implements LruPoolStrategy {
    public final KeyPool keyPool = new KeyPool();
    public final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Key implements Poolable {
        public Bitmap.Config config;
        public int height;
        public final KeyPool pool;
        public int width;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.width == key.width && this.height == key.height && this.config == key.config;
        }

        public int hashCode() {
            int i10 = ((this.width * 31) + this.height) * 31;
            Bitmap.Config config = this.config;
            return i10 + (config != null ? config.hashCode() : 0);
        }

        public void init(int i10, int i11, Bitmap.Config config) {
            this.width = i10;
            this.height = i11;
            this.config = config;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class KeyPool extends BaseKeyPool<Key> {
        public Key get(int i10, int i11, Bitmap.Config config) {
            Key key = get();
            key.init(i10, i11, config);
            return key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    public static String getBitmapString(Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int i10, int i11, Bitmap.Config config) {
        return this.groupedMap.get(this.keyPool.get(i10, i11, config));
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int i10, int i11, Bitmap.Config config) {
        return getBitmapString(i10, i11, config);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap) {
        this.groupedMap.put(this.keyPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }

    public String toString() {
        StringBuilder a10 = a.a("AttributeStrategy:\n  ");
        a10.append((Object) this.groupedMap);
        return a10.toString();
    }

    public static String getBitmapString(int i10, int i11, Bitmap.Config config) {
        return "[" + i10 + LanguageTag.PRIVATEUSE + i11 + "], " + ((Object) config);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }
}
