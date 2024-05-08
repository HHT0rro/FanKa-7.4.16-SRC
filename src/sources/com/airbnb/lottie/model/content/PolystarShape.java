package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.layer.BaseLayer;
import i.b;
import i.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PolystarShape implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f1966a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f1967b;

    /* renamed from: c, reason: collision with root package name */
    public final b f1968c;

    /* renamed from: d, reason: collision with root package name */
    public final m<PointF, PointF> f1969d;

    /* renamed from: e, reason: collision with root package name */
    public final b f1970e;

    /* renamed from: f, reason: collision with root package name */
    public final b f1971f;

    /* renamed from: g, reason: collision with root package name */
    public final b f1972g;

    /* renamed from: h, reason: collision with root package name */
    public final b f1973h;

    /* renamed from: i, reason: collision with root package name */
    public final b f1974i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f1975j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f1976k;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum Type {
        STAR(1),
        POLYGON(2);

        private final int value;

        Type(int i10) {
            this.value = i10;
        }

        public static Type forValue(int i10) {
            for (Type type : values()) {
                if (type.value == i10) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, b bVar, m<PointF, PointF> mVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, boolean z10, boolean z11) {
        this.f1966a = str;
        this.f1967b = type;
        this.f1968c = bVar;
        this.f1969d = mVar;
        this.f1970e = bVar2;
        this.f1971f = bVar3;
        this.f1972g = bVar4;
        this.f1973h = bVar5;
        this.f1974i = bVar6;
        this.f1975j = z10;
        this.f1976k = z11;
    }

    public b a() {
        return this.f1971f;
    }

    public b b() {
        return this.f1973h;
    }

    public String c() {
        return this.f1966a;
    }

    public b d() {
        return this.f1972g;
    }

    public b e() {
        return this.f1974i;
    }

    public b f() {
        return this.f1968c;
    }

    public m<PointF, PointF> g() {
        return this.f1969d;
    }

    public b h() {
        return this.f1970e;
    }

    public Type i() {
        return this.f1967b;
    }

    public boolean j() {
        return this.f1975j;
    }

    public boolean k() {
        return this.f1976k;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new e.m(lottieDrawable, baseLayer, this);
    }
}
