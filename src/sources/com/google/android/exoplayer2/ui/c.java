package com.google.android.exoplayer2.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: CaptionStyleCompat.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: g, reason: collision with root package name */
    public static final c f22600g = new c(-1, -16777216, 0, 0, -1, null);

    /* renamed from: a, reason: collision with root package name */
    public final int f22601a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22602b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22603c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22604d;

    /* renamed from: e, reason: collision with root package name */
    public final int f22605e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final Typeface f22606f;

    public c(int i10, int i11, int i12, int i13, int i14, @Nullable Typeface typeface) {
        this.f22601a = i10;
        this.f22602b = i11;
        this.f22603c = i12;
        this.f22604d = i13;
        this.f22605e = i14;
        this.f22606f = typeface;
    }

    @RequiresApi(19)
    public static c a(CaptioningManager.CaptionStyle captionStyle) {
        if (com.google.android.exoplayer2.util.j0.f22990a >= 21) {
            return c(captionStyle);
        }
        return b(captionStyle);
    }

    @RequiresApi(19)
    public static c b(CaptioningManager.CaptionStyle captionStyle) {
        return new c(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @RequiresApi(21)
    public static c c(CaptioningManager.CaptionStyle captionStyle) {
        return new c(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f22600g.f22601a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f22600g.f22602b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f22600g.f22603c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f22600g.f22604d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f22600g.f22605e, captionStyle.getTypeface());
    }
}
