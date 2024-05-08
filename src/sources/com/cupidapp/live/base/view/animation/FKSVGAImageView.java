package com.cupidapp.live.base.view.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.base.utils.j;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSVGAImageView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKSVGAImageView extends SVGAImageView {

    /* renamed from: q */
    @Nullable
    public Function0<p> f12603q;

    /* renamed from: r */
    @Nullable
    public Function1<? super Double, p> f12604r;

    /* renamed from: s */
    @NotNull
    public Map<Integer, View> f12605s;

    /* compiled from: FKSVGAImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements com.opensource.svgaplayer.b {
        public a() {
        }

        @Override // com.opensource.svgaplayer.b
        public void a() {
            Function0 function0 = FKSVGAImageView.this.f12603q;
            if (function0 != null) {
                function0.invoke();
            }
            j.f12332a.a("showSVGAAnimation", "onFinished");
        }

        @Override // com.opensource.svgaplayer.b
        public void b(int i10, double d10) {
            Function1 function1 = FKSVGAImageView.this.f12604r;
            if (function1 != null) {
                function1.invoke(Double.valueOf(d10));
            }
        }

        @Override // com.opensource.svgaplayer.b
        public void c() {
            j.f12332a.a("showSVGAAnimation", "onRepeat");
        }

        @Override // com.opensource.svgaplayer.b
        public void onPause() {
            j.f12332a.a("showSVGAAnimation", "onPause");
        }
    }

    /* compiled from: FKSVGAImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements SVGAParser.c {

        /* renamed from: b */
        public final /* synthetic */ Function1<Double, p> f12608b;

        /* renamed from: c */
        public final /* synthetic */ Function0<p> f12609c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Double, p> function1, Function0<p> function0) {
            this.f12608b = function1;
            this.f12609c = function0;
        }

        @Override // com.opensource.svgaplayer.SVGAParser.c
        public void a(@NotNull SVGAVideoEntity videoItem) {
            s.i(videoItem, "videoItem");
            j.f12332a.a("showSVGAAnimation", "onComplete videoItem: " + ((Object) videoItem));
            FKSVGAImageView.this.setVideoItem(videoItem);
            FKSVGAImageView.this.v(0, true);
            FKSVGAImageView.this.f12604r = this.f12608b;
            FKSVGAImageView.this.f12603q = this.f12609c;
        }

        @Override // com.opensource.svgaplayer.SVGAParser.c
        public void onError() {
            j.f12332a.a("showSVGAAnimation", "onError");
        }
    }

    /* compiled from: FKSVGAImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements SVGAParser.c {

        /* renamed from: a */
        public final /* synthetic */ Float f12610a;

        /* renamed from: b */
        public final /* synthetic */ int f12611b;

        /* renamed from: c */
        public final /* synthetic */ boolean f12612c;

        /* renamed from: d */
        public final /* synthetic */ Map<String, String> f12613d;

        /* renamed from: e */
        public final /* synthetic */ Map<String, Integer> f12614e;

        /* renamed from: f */
        public final /* synthetic */ Map<String, Bitmap> f12615f;

        /* renamed from: g */
        public final /* synthetic */ Map<String, String> f12616g;

        /* renamed from: h */
        public final /* synthetic */ FKSVGAImageView f12617h;

        /* renamed from: i */
        public final /* synthetic */ int f12618i;

        /* renamed from: j */
        public final /* synthetic */ Function0<p> f12619j;

        /* renamed from: k */
        public final /* synthetic */ Function1<Double, p> f12620k;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Float f10, int i10, boolean z10, Map<String, String> map, Map<String, Integer> map2, Map<String, Bitmap> map3, Map<String, String> map4, FKSVGAImageView fKSVGAImageView, int i11, Function0<p> function0, Function1<? super Double, p> function1) {
            this.f12610a = f10;
            this.f12611b = i10;
            this.f12612c = z10;
            this.f12613d = map;
            this.f12614e = map2;
            this.f12615f = map3;
            this.f12616g = map4;
            this.f12617h = fKSVGAImageView;
            this.f12618i = i11;
            this.f12619j = function0;
            this.f12620k = function1;
        }

        @Override // com.opensource.svgaplayer.SVGAParser.c
        public void a(@NotNull SVGAVideoEntity videoItem) {
            s.i(videoItem, "videoItem");
            e eVar = new e();
            TextPaint textPaint = new TextPaint();
            if (this.f12610a != null) {
                textPaint.setColor(this.f12611b);
                textPaint.setTextSize(this.f12610a.floatValue());
                textPaint.setFakeBoldText(this.f12612c);
            }
            Map<String, String> map = this.f12613d;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    eVar.m(entry.getValue(), entry.getKey());
                }
            }
            Map<String, Integer> map2 = this.f12614e;
            if (map2 != null) {
                FKSVGAImageView fKSVGAImageView = this.f12617h;
                for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
                    Bitmap bitmap = BitmapFactory.decodeResource(fKSVGAImageView.getContext().getResources(), entry2.getValue().intValue());
                    s.h(bitmap, "bitmap");
                    eVar.l(bitmap, entry2.getKey());
                }
            }
            Map<String, Bitmap> map3 = this.f12615f;
            if (map3 != null) {
                for (Map.Entry<String, Bitmap> entry3 : map3.entrySet()) {
                    eVar.l(entry3.getValue(), entry3.getKey());
                }
            }
            Map<String, String> map4 = this.f12616g;
            if (map4 != null) {
                for (Map.Entry<String, String> entry4 : map4.entrySet()) {
                    eVar.n(new StaticLayout(entry4.getValue(), textPaint, 0, Layout.Alignment.ALIGN_CENTER, 0.0f, 0.0f, false), entry4.getKey());
                }
            }
            this.f12617h.setVideoItem(videoItem, eVar);
            this.f12617h.v(this.f12618i, true);
            this.f12617h.f12603q = this.f12619j;
            this.f12617h.f12604r = this.f12620k;
        }

        @Override // com.opensource.svgaplayer.SVGAParser.c
        public void onError() {
            j.f12332a.a("showSVGAAnimation", "onError");
        }
    }

    /* compiled from: FKSVGAImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements SVGAParser.c {

        /* renamed from: a */
        public final /* synthetic */ Map<String, String> f12621a;

        /* renamed from: b */
        public final /* synthetic */ Map<String, Integer> f12622b;

        /* renamed from: c */
        public final /* synthetic */ Map<String, Pair<TextPaint, String>> f12623c;

        /* renamed from: d */
        public final /* synthetic */ FKSVGAImageView f12624d;

        /* renamed from: e */
        public final /* synthetic */ Function0<p> f12625e;

        /* renamed from: f */
        public final /* synthetic */ Function1<Double, p> f12626f;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Map<String, String> map, Map<String, Integer> map2, Map<String, ? extends Pair<? extends TextPaint, String>> map3, FKSVGAImageView fKSVGAImageView, Function0<p> function0, Function1<? super Double, p> function1) {
            this.f12621a = map;
            this.f12622b = map2;
            this.f12623c = map3;
            this.f12624d = fKSVGAImageView;
            this.f12625e = function0;
            this.f12626f = function1;
        }

        @Override // com.opensource.svgaplayer.SVGAParser.c
        public void a(@NotNull SVGAVideoEntity videoItem) {
            s.i(videoItem, "videoItem");
            e eVar = new e();
            Map<String, String> map = this.f12621a;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    eVar.m(entry.getValue(), entry.getKey());
                }
            }
            Map<String, Integer> map2 = this.f12622b;
            if (map2 != null) {
                FKSVGAImageView fKSVGAImageView = this.f12624d;
                for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
                    Bitmap bitmap = BitmapFactory.decodeResource(fKSVGAImageView.getContext().getResources(), entry2.getValue().intValue());
                    s.h(bitmap, "bitmap");
                    eVar.l(bitmap, entry2.getKey());
                }
            }
            Map<String, Pair<TextPaint, String>> map3 = this.f12623c;
            if (map3 != null) {
                for (Map.Entry<String, Pair<TextPaint, String>> entry3 : map3.entrySet()) {
                    TextPaint first = entry3.getValue().getFirst();
                    if (first == null) {
                        first = new TextPaint();
                    }
                    eVar.n(new StaticLayout(entry3.getValue().getSecond(), first, 0, Layout.Alignment.ALIGN_CENTER, 0.0f, 0.0f, false), entry3.getKey());
                }
            }
            this.f12624d.setVideoItem(videoItem, eVar);
            this.f12624d.v(0, true);
            this.f12624d.f12603q = this.f12625e;
            this.f12624d.f12604r = this.f12626f;
        }

        @Override // com.opensource.svgaplayer.SVGAParser.c
        public void onError() {
            j.f12332a.a("showSVGAAnimation", "onError");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSVGAImageView(@NotNull Context context) {
        super(context, null, 0, 6, null);
        s.i(context, "context");
        this.f12605s = new LinkedHashMap();
        D();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void F(FKSVGAImageView fKSVGAImageView, String str, Function1 function1, Function0 function0, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function1 = null;
        }
        if ((i10 & 4) != 0) {
            function0 = null;
        }
        fKSVGAImageView.E(str, function1, function0);
    }

    public final void C(@Nullable Map<String, ? extends Pair<? extends TextPaint, String>> map, int i10) {
        SVGAVideoEntity d10;
        Drawable drawable = getDrawable();
        com.opensource.svgaplayer.d dVar = drawable instanceof com.opensource.svgaplayer.d ? (com.opensource.svgaplayer.d) drawable : null;
        if (dVar == null || (d10 = dVar.d()) == null) {
            return;
        }
        e eVar = new e();
        if (map != null) {
            for (Map.Entry<String, ? extends Pair<? extends TextPaint, String>> entry : map.entrySet()) {
                TextPaint first = entry.getValue().getFirst();
                if (first == null) {
                    first = new TextPaint();
                }
                eVar.n(new StaticLayout(entry.getValue().getSecond(), first, 0, Layout.Alignment.ALIGN_CENTER, 0.0f, 0.0f, false), entry.getKey());
            }
        }
        setVideoItem(d10, eVar);
        v(i10, true);
    }

    public final void D() {
        setCallback(new a());
    }

    public final void E(@NotNull String fileName, @Nullable Function1<? super Double, p> function1, @Nullable Function0<p> function0) {
        s.i(fileName, "fileName");
        SVGAParser.o(SVGAParser.f37905h.b(), "svga/" + fileName, new b(function1, function0), null, 4, null);
    }

    public final void G(@NotNull String fileName, @Nullable Float f10, int i10, boolean z10, @Nullable Map<String, String> map, @Nullable Map<String, Integer> map2, @Nullable Map<String, String> map3, @Nullable Map<String, Bitmap> map4, int i11, @Nullable Function0<p> function0, @Nullable Function1<? super Double, p> function1) {
        s.i(fileName, "fileName");
        SVGAParser.o(SVGAParser.f37905h.b(), "svga/" + fileName, new c(f10, i10, z10, map, map2, map4, map3, this, i11, function0, function1), null, 4, null);
    }

    public final void I(@NotNull String fileName, @Nullable Map<String, String> map, @Nullable Map<String, Integer> map2, @Nullable Map<String, ? extends Pair<? extends TextPaint, String>> map3, @Nullable Function0<p> function0, @Nullable Function1<? super Double, p> function1) {
        s.i(fileName, "fileName");
        SVGAParser.o(SVGAParser.f37905h.b(), "svga/" + fileName, new d(map, map2, map3, this, function0, function1), null, 4, null);
    }

    public final void K() {
        if (k()) {
            w();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSVGAImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        s.i(context, "context");
        this.f12605s = new LinkedHashMap();
        D();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSVGAImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12605s = new LinkedHashMap();
        D();
    }
}
