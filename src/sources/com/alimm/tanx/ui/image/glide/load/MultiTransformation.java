package com.alimm.tanx.ui.image.glide.load;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MultiTransformation<T> implements Transformation<T> {

    /* renamed from: id, reason: collision with root package name */
    public String f4189id;
    public final Collection<? extends Transformation<T>> transformations;

    @SafeVarargs
    public MultiTransformation(Transformation<T>... transformationArr) {
        if (transformationArr.length >= 1) {
            this.transformations = Arrays.asList(transformationArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        if (this.f4189id == null) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<? extends Transformation<T>> iterator2 = this.transformations.iterator2();
            while (iterator2.hasNext()) {
                sb2.append(iterator2.next().getId());
            }
            this.f4189id = sb2.toString();
        }
        return this.f4189id;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public Resource<T> transform(Resource<T> resource, int i10, int i11) {
        Iterator<? extends Transformation<T>> iterator2 = this.transformations.iterator2();
        Resource<T> resource2 = resource;
        while (iterator2.hasNext()) {
            Resource<T> transform = iterator2.next().transform(resource2, i10, i11);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(transform)) {
                resource2.recycle();
            }
            resource2 = transform;
        }
        return resource2;
    }

    public MultiTransformation(Collection<? extends Transformation<T>> collection) {
        if (collection.size() >= 1) {
            this.transformations = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
