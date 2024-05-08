package com.alimm.tanx.ui.image.glide.request;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ResourceCallback {
    void onException(Exception exc);

    void onResourceReady(Resource<?> resource);
}
