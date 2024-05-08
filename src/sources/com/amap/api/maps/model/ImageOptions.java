package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ImageOptions {

    @JBindingInclude
    public int color;

    @JBindingInclude
    public String content;

    @JBindingInclude
    public int fontSize;

    @JBindingInclude
    public float radius;

    @JBindingInclude
    public double[] rgba;

    @JBindingInclude
    public int type;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ShapeType {
        DEFAULT(0),
        CIRCLE(1),
        TEXT(2);

        private int index;

        ShapeType(int i10) {
            this.index = i10;
        }

        public final int value() {
            return this.index;
        }
    }

    @JBindingInclude
    public ImageOptions() {
    }
}
