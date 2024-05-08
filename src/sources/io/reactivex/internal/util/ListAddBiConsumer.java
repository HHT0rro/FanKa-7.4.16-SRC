package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ListAddBiConsumer implements BiFunction<List, Object, List> {
    INSTANCE;

    public static <T> BiFunction<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.functions.BiFunction
    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}