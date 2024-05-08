package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CloneTransformer<T> implements Transformer<T, T> {
    public static final Transformer INSTANCE = new CloneTransformer();

    private CloneTransformer() {
    }

    public static <T> Transformer<T, T> cloneTransformer() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T t2) {
        if (t2 == null) {
            return null;
        }
        return (T) PrototypeFactory.prototypeFactory(t2).create();
    }
}
