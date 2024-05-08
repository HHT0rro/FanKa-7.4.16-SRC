package com.alimm.tanx.ui.image.glide.load.resource.transcode;

import com.alimm.tanx.ui.image.glide.util.MultiClassKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TranscoderRegistry {
    public static final MultiClassKey GET_KEY = new MultiClassKey();
    public final Map<MultiClassKey, ResourceTranscoder<?, ?>> factories = new HashMap();

    public <Z, R> ResourceTranscoder<Z, R> get(Class<Z> cls, Class<R> cls2) {
        ResourceTranscoder<Z, R> resourceTranscoder;
        if (cls.equals(cls2)) {
            return UnitTranscoder.get();
        }
        MultiClassKey multiClassKey = GET_KEY;
        synchronized (multiClassKey) {
            multiClassKey.set(cls, cls2);
            resourceTranscoder = (ResourceTranscoder) this.factories.get(multiClassKey);
        }
        if (resourceTranscoder != null) {
            return resourceTranscoder;
        }
        throw new IllegalArgumentException("No transcoder registered for " + ((Object) cls) + " and " + ((Object) cls2));
    }

    public <Z, R> void register(Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        this.factories.put(new MultiClassKey(cls, cls2), resourceTranscoder);
    }
}