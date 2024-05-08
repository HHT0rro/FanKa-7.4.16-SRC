package com.alimm.tanx.ui.image.glide.load.resource;

import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UnitTransformation<T> implements Transformation<T> {
    public static final Transformation<?> TRANSFORMATION = new UnitTransformation();

    public static <T> UnitTransformation<T> get() {
        return (UnitTransformation) TRANSFORMATION;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        return "";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public Resource<T> transform(Resource<T> resource, int i10, int i11) {
        return resource;
    }
}
