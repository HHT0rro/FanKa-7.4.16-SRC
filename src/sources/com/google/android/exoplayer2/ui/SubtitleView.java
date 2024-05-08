package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import e6.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SubtitleView extends FrameLayout implements e6.j {

    /* renamed from: b, reason: collision with root package name */
    public List<e6.a> f22557b;

    /* renamed from: c, reason: collision with root package name */
    public c f22558c;

    /* renamed from: d, reason: collision with root package name */
    public int f22559d;

    /* renamed from: e, reason: collision with root package name */
    public float f22560e;

    /* renamed from: f, reason: collision with root package name */
    public float f22561f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22562g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f22563h;

    /* renamed from: i, reason: collision with root package name */
    public int f22564i;

    /* renamed from: j, reason: collision with root package name */
    public a f22565j;

    /* renamed from: k, reason: collision with root package name */
    public View f22566k;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(List<e6.a> list, c cVar, float f10, int i10, float f11);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    private List<e6.a> getCuesWithStylingPreferencesApplied() {
        if (this.f22562g && this.f22563h) {
            return this.f22557b;
        }
        ArrayList arrayList = new ArrayList(this.f22557b.size());
        for (int i10 = 0; i10 < this.f22557b.size(); i10++) {
            arrayList.add(a(this.f22557b.get(i10)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (com.google.android.exoplayer2.util.j0.f22990a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private c getUserCaptionStyle() {
        if (com.google.android.exoplayer2.util.j0.f22990a >= 19 && !isInEditMode()) {
            CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
            if (captioningManager != null && captioningManager.isEnabled()) {
                return c.a(captioningManager.getUserStyle());
            }
            return c.f22600g;
        }
        return c.f22600g;
    }

    private <T extends View & a> void setView(T t2) {
        removeView(this.f22566k);
        View view = this.f22566k;
        if (view instanceof WebViewSubtitleOutput) {
            ((WebViewSubtitleOutput) view).g();
        }
        this.f22566k = t2;
        this.f22565j = t2;
        addView(t2);
    }

    public final e6.a a(e6.a aVar) {
        a.b a10 = aVar.a();
        if (!this.f22562g) {
            l0.e(a10);
        } else if (!this.f22563h) {
            l0.f(a10);
        }
        return a10.a();
    }

    public final void b(int i10, float f10) {
        this.f22559d = i10;
        this.f22560e = f10;
        c();
    }

    public final void c() {
        this.f22565j.a(getCuesWithStylingPreferencesApplied(), this.f22558c, this.f22560e, this.f22559d, this.f22561f);
    }

    @Override // e6.j
    public void onCues(List<e6.a> list) {
        setCues(list);
    }

    public void setApplyEmbeddedFontSizes(boolean z10) {
        this.f22563h = z10;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z10) {
        this.f22562g = z10;
        c();
    }

    public void setBottomPaddingFraction(float f10) {
        this.f22561f = f10;
        c();
    }

    public void setCues(@Nullable List<e6.a> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f22557b = list;
        c();
    }

    public void setFixedTextSize(@Dimension int i10, float f10) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        b(2, TypedValue.applyDimension(i10, f10, resources.getDisplayMetrics()));
    }

    public void setFractionalTextSize(float f10) {
        setFractionalTextSize(f10, false);
    }

    public void setStyle(c cVar) {
        this.f22558c = cVar;
        c();
    }

    public void setUserDefaultStyle() {
        setStyle(getUserCaptionStyle());
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setViewType(int i10) {
        if (this.f22564i == i10) {
            return;
        }
        if (i10 == 1) {
            setView(new CanvasSubtitleOutput(getContext()));
        } else if (i10 == 2) {
            setView(new WebViewSubtitleOutput(getContext()));
        } else {
            throw new IllegalArgumentException();
        }
        this.f22564i = i10;
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22557b = Collections.emptyList();
        this.f22558c = c.f22600g;
        this.f22559d = 0;
        this.f22560e = 0.0533f;
        this.f22561f = 0.08f;
        this.f22562g = true;
        this.f22563h = true;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context);
        this.f22565j = canvasSubtitleOutput;
        this.f22566k = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.f22564i = 1;
    }

    public void setFractionalTextSize(float f10, boolean z10) {
        b(z10 ? 1 : 0, f10);
    }
}
