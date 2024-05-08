package com.airbnb.lottie.model.content;

import i.d;
import i.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Mask {

    /* renamed from: a, reason: collision with root package name */
    public final MaskMode f1959a;

    /* renamed from: b, reason: collision with root package name */
    public final h f1960b;

    /* renamed from: c, reason: collision with root package name */
    public final d f1961c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1962d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, h hVar, d dVar, boolean z10) {
        this.f1959a = maskMode;
        this.f1960b = hVar;
        this.f1961c = dVar;
        this.f1962d = z10;
    }

    public MaskMode a() {
        return this.f1959a;
    }

    public h b() {
        return this.f1960b;
    }

    public d c() {
        return this.f1961c;
    }

    public boolean d() {
        return this.f1962d;
    }
}
