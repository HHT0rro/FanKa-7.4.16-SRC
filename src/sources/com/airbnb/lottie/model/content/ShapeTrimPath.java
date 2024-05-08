package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.alipay.sdk.util.i;
import e.t;
import i.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ShapeTrimPath implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f1989a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f1990b;

    /* renamed from: c, reason: collision with root package name */
    public final b f1991c;

    /* renamed from: d, reason: collision with root package name */
    public final b f1992d;

    /* renamed from: e, reason: collision with root package name */
    public final b f1993e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1994f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i10) {
            if (i10 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i10 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i10);
        }
    }

    public ShapeTrimPath(String str, Type type, b bVar, b bVar2, b bVar3, boolean z10) {
        this.f1989a = str;
        this.f1990b = type;
        this.f1991c = bVar;
        this.f1992d = bVar2;
        this.f1993e = bVar3;
        this.f1994f = z10;
    }

    public b a() {
        return this.f1992d;
    }

    public String b() {
        return this.f1989a;
    }

    public b c() {
        return this.f1993e;
    }

    public b d() {
        return this.f1991c;
    }

    public Type e() {
        return this.f1990b;
    }

    public boolean f() {
        return this.f1994f;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new t(baseLayer, this);
    }

    public String toString() {
        return "Trim Path: {start: " + ((Object) this.f1991c) + ", end: " + ((Object) this.f1992d) + ", offset: " + ((Object) this.f1993e) + i.f4738d;
    }
}
