package com.alimm.tanx.ui.image.glide.load.resource;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SimpleResource<T> implements Resource<T> {
    public final T data;

    public SimpleResource(T t2) {
        Objects.requireNonNull(t2, "Data must not be null");
        this.data = t2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public final T get() {
        return this.data;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
    }
}
