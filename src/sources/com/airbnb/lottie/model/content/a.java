package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import e.h;
import i.b;
import i.c;
import i.d;
import i.f;
import java.util.List;

/* compiled from: GradientStroke.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f1995a;

    /* renamed from: b, reason: collision with root package name */
    public final GradientType f1996b;

    /* renamed from: c, reason: collision with root package name */
    public final c f1997c;

    /* renamed from: d, reason: collision with root package name */
    public final d f1998d;

    /* renamed from: e, reason: collision with root package name */
    public final f f1999e;

    /* renamed from: f, reason: collision with root package name */
    public final f f2000f;

    /* renamed from: g, reason: collision with root package name */
    public final b f2001g;

    /* renamed from: h, reason: collision with root package name */
    public final ShapeStroke.LineCapType f2002h;

    /* renamed from: i, reason: collision with root package name */
    public final ShapeStroke.LineJoinType f2003i;

    /* renamed from: j, reason: collision with root package name */
    public final float f2004j;

    /* renamed from: k, reason: collision with root package name */
    public final List<b> f2005k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public final b f2006l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f2007m;

    public a(String str, GradientType gradientType, c cVar, d dVar, f fVar, f fVar2, b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f10, List<b> list, @Nullable b bVar2, boolean z10) {
        this.f1995a = str;
        this.f1996b = gradientType;
        this.f1997c = cVar;
        this.f1998d = dVar;
        this.f1999e = fVar;
        this.f2000f = fVar2;
        this.f2001g = bVar;
        this.f2002h = lineCapType;
        this.f2003i = lineJoinType;
        this.f2004j = f10;
        this.f2005k = list;
        this.f2006l = bVar2;
        this.f2007m = z10;
    }

    public ShapeStroke.LineCapType a() {
        return this.f2002h;
    }

    @Nullable
    public b b() {
        return this.f2006l;
    }

    public f c() {
        return this.f2000f;
    }

    public c d() {
        return this.f1997c;
    }

    public GradientType e() {
        return this.f1996b;
    }

    public ShapeStroke.LineJoinType f() {
        return this.f2003i;
    }

    public List<b> g() {
        return this.f2005k;
    }

    public float h() {
        return this.f2004j;
    }

    public String i() {
        return this.f1995a;
    }

    public d j() {
        return this.f1998d;
    }

    public f k() {
        return this.f1999e;
    }

    public b l() {
        return this.f2001g;
    }

    public boolean m() {
        return this.f2007m;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new h(lottieDrawable, baseLayer, this);
    }
}
