package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MapTransformer<I, O> implements Transformer<I, O>, Serializable {
    private static final long serialVersionUID = 862391807045468939L;
    private final Map<? super I, ? extends O> iMap;

    private MapTransformer(Map<? super I, ? extends O> map) {
        this.iMap = map;
    }

    public static <I, O> Transformer<I, O> mapTransformer(Map<? super I, ? extends O> map) {
        if (map == null) {
            return ConstantTransformer.nullTransformer();
        }
        return new MapTransformer(map);
    }

    public Map<? super I, ? extends O> getMap() {
        return this.iMap;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i10) {
        return this.iMap.get(i10);
    }
}
