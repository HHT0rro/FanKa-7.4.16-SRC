package com.alimm.tanx.ui.image.glide.load.engine;

import com.alimm.tanx.ui.image.glide.load.Key;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface EngineJobListener {
    void onEngineJobCancelled(EngineJob engineJob, Key key);

    void onEngineJobComplete(Key key, EngineResource<?> engineResource);
}
