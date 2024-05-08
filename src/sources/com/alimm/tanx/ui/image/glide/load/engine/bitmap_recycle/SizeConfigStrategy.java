package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SizeConfigStrategy implements LruPoolStrategy {
    public static final int MAX_SIZE_MULTIPLE = 8;
    public static final Bitmap.Config[] ARGB_8888_IN_CONFIGS = {Bitmap.Config.ARGB_8888, null};
    public static final Bitmap.Config[] RGB_565_IN_CONFIGS = {Bitmap.Config.RGB_565};
    public static final Bitmap.Config[] ARGB_4444_IN_CONFIGS = {Bitmap.Config.ARGB_4444};
    public static final Bitmap.Config[] ALPHA_8_IN_CONFIGS = {Bitmap.Config.ALPHA_8};
    public final KeyPool keyPool = new KeyPool();
    public final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> sortedSizes = new HashMap();

    /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class KeyPool extends BaseKeyPool<Key> {
        public Key get(int i10, Bitmap.Config config) {
            Key key = get();
            key.init(i10, config);
            return key;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    private void decrementBitmapOfSize(Integer num, Bitmap.Config config) {
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(config);
        Integer num2 = sizesForConfig.get(num);
        if (num2.intValue() == 1) {
            sizesForConfig.remove(num);
        } else {
            sizesForConfig.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private Key findBestKey(Key key, int i10, Bitmap.Config config) {
        for (Bitmap.Config config2 : getInConfigs(config)) {
            Integer ceilingKey = getSizesForConfig(config2).ceilingKey(Integer.valueOf(i10));
            if (ceilingKey != null && ceilingKey.intValue() <= i10 * 8) {
                if (ceilingKey.intValue() == i10 && config2 != null && config2.equals(config)) {
                    return key;
                }
                this.keyPool.offer(key);
                return this.keyPool.get(ceilingKey.intValue(), config2);
            }
        }
        return key;
    }

    public static String getBitmapString(int i10, Bitmap.Config config) {
        return "[" + i10 + "](" + ((Object) config) + ")";
    }

    public static Bitmap.Config[] getInConfigs(Bitmap.Config config) {
        int i10 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i10 == 1) {
            return ARGB_8888_IN_CONFIGS;
        }
        if (i10 == 2) {
            return RGB_565_IN_CONFIGS;
        }
        if (i10 != 3) {
            return i10 != 4 ? new Bitmap.Config[]{config} : ALPHA_8_IN_CONFIGS;
        }
        return ARGB_4444_IN_CONFIGS;
    }

    private NavigableMap<Integer, Integer> getSizesForConfig(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(config, treeMap);
        return treeMap;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int i10, int i11, Bitmap.Config config) {
        int bitmapByteSize = Util.getBitmapByteSize(i10, i11, config);
        Bitmap bitmap = this.groupedMap.get(findBestKey(this.keyPool.get(bitmapByteSize, config), bitmapByteSize, config));
        if (bitmap != null) {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(bitmap)), bitmap.getConfig());
            bitmap.reconfigure(i10, i11, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return bitmap;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap) {
        Key key = this.keyPool.get(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        this.groupedMap.put(key, bitmap);
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num = sizesForConfig.get(Integer.valueOf(key.size));
        sizesForConfig.put(Integer.valueOf(key.size), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap removeLast = this.groupedMap.removeLast();
        if (removeLast != null) {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(removeLast)), removeLast.getConfig());
        }
        return removeLast;
    }

    public String toString() {
        StringBuilder a10 = a.a("SizeConfigStrategy{groupedMap=");
        a10.append((Object) this.groupedMap);
        a10.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.sortedSizes.entrySet()) {
            a10.append((Object) entry.getKey());
            a10.append('[');
            a10.append((Object) entry.getValue());
            a10.append("], ");
        }
        if (!this.sortedSizes.isEmpty()) {
            a10.replace(a10.length() - 2, a10.length(), "");
        }
        a10.append(")}");
        return a10.toString();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Key implements Poolable {
        public Bitmap.Config config;
        public final KeyPool pool;
        public int size;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.size != key.size) {
                return false;
            }
            Bitmap.Config config = this.config;
            Bitmap.Config config2 = key.config;
            if (config == null) {
                if (config2 != null) {
                    return false;
                }
            } else if (!config.equals(config2)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i10 = this.size * 31;
            Bitmap.Config config = this.config;
            return i10 + (config != null ? config.hashCode() : 0);
        }

        public void init(int i10, Bitmap.Config config) {
            this.size = i10;
            this.config = config;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return SizeConfigStrategy.getBitmapString(this.size, this.config);
        }

        public Key(KeyPool keyPool, int i10, Bitmap.Config config) {
            this.pool = keyPool;
            init(i10, config);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int i10, int i11, Bitmap.Config config) {
        return getBitmapString(Util.getBitmapByteSize(i10, i11, config), config);
    }
}
