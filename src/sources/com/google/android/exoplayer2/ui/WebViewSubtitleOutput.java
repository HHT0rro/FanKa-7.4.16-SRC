package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class WebViewSubtitleOutput extends FrameLayout implements SubtitleView.a {

    /* renamed from: b, reason: collision with root package name */
    public final CanvasSubtitleOutput f22587b;

    /* renamed from: c, reason: collision with root package name */
    public final WebView f22588c;

    /* renamed from: d, reason: collision with root package name */
    public List<e6.a> f22589d;

    /* renamed from: e, reason: collision with root package name */
    public c f22590e;

    /* renamed from: f, reason: collision with root package name */
    public float f22591f;

    /* renamed from: g, reason: collision with root package name */
    public int f22592g;

    /* renamed from: h, reason: collision with root package name */
    public float f22593h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22594a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f22594a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22594a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22594a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WebViewSubtitleOutput(Context context) {
        this(context, null);
    }

    public static int b(int i10) {
        if (i10 != 1) {
            return i10 != 2 ? 0 : -100;
        }
        return -50;
    }

    public static String c(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return CSSAlignValue.AlignKey.CENTER;
        }
        int i10 = a.f22594a[alignment.ordinal()];
        return i10 != 1 ? i10 != 2 ? CSSAlignValue.AlignKey.CENTER : "end" : "start";
    }

    public static String d(c cVar) {
        int i10 = cVar.f22604d;
        if (i10 == 1) {
            return com.google.android.exoplayer2.util.j0.D("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", g.b(cVar.f22605e));
        }
        if (i10 == 2) {
            return com.google.android.exoplayer2.util.j0.D("0.1em 0.12em 0.15em %s", g.b(cVar.f22605e));
        }
        if (i10 != 3) {
            return i10 != 4 ? "unset" : com.google.android.exoplayer2.util.j0.D("-0.05em -0.05em 0.15em %s", g.b(cVar.f22605e));
        }
        return com.google.android.exoplayer2.util.j0.D("0.06em 0.08em 0.15em %s", g.b(cVar.f22605e));
    }

    public static String f(int i10) {
        return i10 != 1 ? i10 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    public static String h(e6.a aVar) {
        float f10 = aVar.f48900q;
        if (f10 == 0.0f) {
            return "";
        }
        int i10 = aVar.f48899p;
        return com.google.android.exoplayer2.util.j0.D("%s(%.2fdeg)", (i10 == 2 || i10 == 1) ? "skewY" : "skewX", Float.valueOf(f10));
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<e6.a> list, c cVar, float f10, int i10, float f11) {
        this.f22590e = cVar;
        this.f22591f = f10;
        this.f22592g = i10;
        this.f22593h = f11;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            e6.a aVar = list.get(i11);
            if (aVar.f48887d != null) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        if (!this.f22589d.isEmpty() || !arrayList2.isEmpty()) {
            this.f22589d = arrayList2;
            i();
        }
        this.f22587b.a(arrayList, cVar, f10, i10, f11);
        invalidate();
    }

    public final String e(int i10, float f10) {
        float h10 = l0.h(i10, f10, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return h10 == -3.4028235E38f ? "unset" : com.google.android.exoplayer2.util.j0.D("%.2fpx", Float.valueOf(h10 / getContext().getResources().getDisplayMetrics().density));
    }

    public void g() {
        this.f22588c.destroy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0148, code lost:
    
        if (r13 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x014d, code lost:
    
        r21 = "left";
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014f, code lost:
    
        r22 = "top";
        r13 = 2;
        r23 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014b, code lost:
    
        if (r13 != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.WebViewSubtitleOutput.i():void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!z10 || this.f22589d.isEmpty()) {
            return;
        }
        i();
    }

    public WebViewSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22589d = Collections.emptyList();
        this.f22590e = c.f22600g;
        this.f22591f = 0.0533f;
        this.f22592g = 0;
        this.f22593h = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        this.f22587b = canvasSubtitleOutput;
        WebView webView = new WebView(this, context, attributeSet) { // from class: com.google.android.exoplayer2.ui.WebViewSubtitleOutput.1
            @Override // android.webkit.WebView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                super.onTouchEvent(motionEvent);
                return false;
            }

            @Override // android.view.View
            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        this.f22588c = webView;
        webView.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(webView);
    }
}
