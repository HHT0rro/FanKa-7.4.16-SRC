package com.alimm.tanx.ui.image.glide.provider;

import com.alimm.tanx.ui.image.glide.util.MultiClassKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DataLoadProviderRegistry {
    public static final MultiClassKey GET_KEY = new MultiClassKey();
    public final Map<MultiClassKey, DataLoadProvider<?, ?>> providers = new HashMap();

    public <T, Z> DataLoadProvider<T, Z> get(Class<T> cls, Class<Z> cls2) {
        DataLoadProvider<T, Z> dataLoadProvider;
        MultiClassKey multiClassKey = GET_KEY;
        synchronized (multiClassKey) {
            multiClassKey.set(cls, cls2);
            dataLoadProvider = (DataLoadProvider) this.providers.get(multiClassKey);
        }
        return dataLoadProvider == null ? EmptyDataLoadProvider.get() : dataLoadProvider;
    }

    public <T, Z> void register(Class<T> cls, Class<Z> cls2, DataLoadProvider<T, Z> dataLoadProvider) {
        this.providers.put(new MultiClassKey(cls, cls2), dataLoadProvider);
    }
}
