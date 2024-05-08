package com.github.penfeizhou.animation.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import h4.d;
import h4.f;

/* compiled from: Frame.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class a<R extends d, W extends f> {

    /* renamed from: a, reason: collision with root package name */
    public final R f19253a;

    /* renamed from: b, reason: collision with root package name */
    public int f19254b;

    /* renamed from: c, reason: collision with root package name */
    public int f19255c;

    /* renamed from: d, reason: collision with root package name */
    public int f19256d;

    /* renamed from: e, reason: collision with root package name */
    public int f19257e;

    /* renamed from: f, reason: collision with root package name */
    public int f19258f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f19259g = new Rect();

    /* renamed from: h, reason: collision with root package name */
    public final Rect f19260h = new Rect();

    public a(R r10) {
        this.f19253a = r10;
    }

    public abstract Bitmap a(Canvas canvas, Paint paint, int i10, Bitmap bitmap, W w3);
}
