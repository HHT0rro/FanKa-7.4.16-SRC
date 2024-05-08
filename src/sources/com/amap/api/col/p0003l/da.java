package com.amap.api.col.p0003l;

import com.autonavi.base.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: StyleParserResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class da {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, StyleItem> f5321a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private Object f5322b = null;

    /* renamed from: c, reason: collision with root package name */
    private StyleItem[] f5323c;

    public final Map<Integer, StyleItem> a() {
        return this.f5321a;
    }

    public final StyleItem[] b() {
        Map<Integer, StyleItem> map = this.f5321a;
        if (map != null && map.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (StyleItem styleItem : this.f5321a.values()) {
                if (styleItem.isValid()) {
                    arrayList.add(styleItem);
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                StyleItem[] styleItemArr = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
                this.f5323c = styleItemArr;
                return styleItemArr;
            }
        }
        return null;
    }

    public final StyleItem[] c() {
        return this.f5323c;
    }

    public final Object d() {
        return this.f5322b;
    }
}
