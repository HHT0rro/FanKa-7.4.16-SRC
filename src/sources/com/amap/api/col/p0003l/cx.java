package com.amap.api.col.p0003l;

import com.huawei.quickcard.base.Attributes;

/* compiled from: StyleElementType.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum cx {
    STYLE_ELEMENT_LABELFILL_OLD("labels.text.fill", 0),
    STYLE_ELEMENT_LABELSTROKE_OLD("labels.text.stroke", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE_OLD("geometry.stroke", 2),
    STYLE_ELEMENT_GEOMETRYFILL_OLD("geometry.fill", 3),
    STYLE_ELEMENT_LABELFILL("textFillColor", 0),
    STYLE_ELEMENT_LABELSTROKE("textStrokeColor", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE("strokeColor", 2),
    STYLE_ELEMENT_GEOMETRYFILL("fillColor", 3),
    STYLE_ELEMENT_GEOMETRYFILL1("color", 3),
    STYLE_ELEMENT_GEOMETRYFILL2("textureName", 3),
    STYLE_ELEMENT_BACKGROUNDFILL("backgroundColor", 4),
    STYLE_ELEMENT_VISIBLE(Attributes.Visibility.VISIBLE, 5);


    /* renamed from: m, reason: collision with root package name */
    private String f5279m;

    /* renamed from: n, reason: collision with root package name */
    private int f5280n;

    cx(String str, int i10) {
        this.f5279m = str;
        this.f5280n = i10;
    }

    private String a() {
        return this.f5279m;
    }

    public static int a(String str) {
        for (cx cxVar : values()) {
            if (cxVar.a().equals(str)) {
                return cxVar.f5280n;
            }
        }
        return -1;
    }
}
