package io.flutter.embedding.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FlutterEngineGroupCache {
    private static volatile FlutterEngineGroupCache instance;
    private final Map<String, FlutterEngineGroup> cachedEngineGroups = new HashMap();

    @VisibleForTesting
    public FlutterEngineGroupCache() {
    }

    @NonNull
    public static FlutterEngineGroupCache getInstance() {
        if (instance == null) {
            synchronized (FlutterEngineGroupCache.class) {
                if (instance == null) {
                    instance = new FlutterEngineGroupCache();
                }
            }
        }
        return instance;
    }

    public void clear() {
        this.cachedEngineGroups.clear();
    }

    public boolean contains(@NonNull String str) {
        return this.cachedEngineGroups.containsKey(str);
    }

    @Nullable
    public FlutterEngineGroup get(@NonNull String str) {
        return this.cachedEngineGroups.get(str);
    }

    public void put(@NonNull String str, @Nullable FlutterEngineGroup flutterEngineGroup) {
        if (flutterEngineGroup != null) {
            this.cachedEngineGroups.put(str, flutterEngineGroup);
        } else {
            this.cachedEngineGroups.remove(str);
        }
    }

    public void remove(@NonNull String str) {
        put(str, null);
    }
}
