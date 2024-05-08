package com.alimm.tanx.ui.image.glide.load;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Transformation<T> {
    String getId();

    Resource<T> transform(Resource<T> resource, int i10, int i11);
}
