package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class StringValueTransformer<T> implements Transformer<T, String>, Serializable {
    private static final Transformer<Object, String> INSTANCE = new StringValueTransformer();
    private static final long serialVersionUID = 7511110693171758606L;

    private StringValueTransformer() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public static <T> Transformer<T, String> stringValueTransformer() {
        return (Transformer<T, String>) INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.Transformer
    public /* bridge */ /* synthetic */ String transform(Object obj) {
        return transform2((StringValueTransformer<T>) obj);
    }

    @Override // org.apache.commons.collections4.Transformer
    /* renamed from: transform, reason: avoid collision after fix types in other method */
    public String transform2(T t2) {
        return String.valueOf(t2);
    }
}
