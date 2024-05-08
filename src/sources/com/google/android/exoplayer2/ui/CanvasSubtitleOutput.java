package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.SubtitleView;
import e6.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class CanvasSubtitleOutput extends View implements SubtitleView.a {

    /* renamed from: b, reason: collision with root package name */
    public final List<i0> f22361b;

    /* renamed from: c, reason: collision with root package name */
    public List<e6.a> f22362c;

    /* renamed from: d, reason: collision with root package name */
    public int f22363d;

    /* renamed from: e, reason: collision with root package name */
    public float f22364e;

    /* renamed from: f, reason: collision with root package name */
    public c f22365f;

    /* renamed from: g, reason: collision with root package name */
    public float f22366g;

    public CanvasSubtitleOutput(Context context) {
        this(context, null);
    }

    public static e6.a b(e6.a aVar) {
        a.b p10 = aVar.a().k(-3.4028235E38f).l(Integer.MIN_VALUE).p(null);
        if (aVar.f48889f == 0) {
            p10.h(1.0f - aVar.f48888e, 0);
        } else {
            p10.h((-aVar.f48888e) - 1.0f, 1);
        }
        int i10 = aVar.f48890g;
        if (i10 == 0) {
            p10.i(2);
        } else if (i10 == 2) {
            p10.i(0);
        }
        return p10.a();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<e6.a> list, c cVar, float f10, int i10, float f11) {
        this.f22362c = list;
        this.f22365f = cVar;
        this.f22364e = f10;
        this.f22363d = i10;
        this.f22366g = f11;
        while (this.f22361b.size() < list.size()) {
            this.f22361b.add(new i0(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<e6.a> list = this.f22362c;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i10 = paddingBottom - paddingTop;
        float h10 = l0.h(this.f22363d, this.f22364e, height, i10);
        if (h10 <= 0.0f) {
            return;
        }
        int size = list.size();
        int i11 = 0;
        while (i11 < size) {
            e6.a aVar = list.get(i11);
            if (aVar.f48899p != Integer.MIN_VALUE) {
                aVar = b(aVar);
            }
            e6.a aVar2 = aVar;
            int i12 = paddingBottom;
            this.f22361b.get(i11).b(aVar2, this.f22365f, h10, l0.h(aVar2.f48897n, aVar2.f48898o, height, i10), this.f22366g, canvas, paddingLeft, paddingTop, width, i12);
            i11++;
            size = size;
            i10 = i10;
            paddingBottom = i12;
            width = width;
        }
    }

    public CanvasSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22361b = new ArrayList();
        this.f22362c = Collections.emptyList();
        this.f22363d = 0;
        this.f22364e = 0.0533f;
        this.f22365f = c.f22600g;
        this.f22366g = 0.08f;
    }
}
