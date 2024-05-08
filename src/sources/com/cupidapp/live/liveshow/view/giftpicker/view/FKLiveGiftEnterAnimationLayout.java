package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.liveshow.model.LiveShowGiftModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveGiftEnterAnimationLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftEnterAnimationLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<p> f15508b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<LiveShowGiftModel> f15509c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Map<String, LiveShowGiftModel> f15510d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15511e;

    /* compiled from: FKLiveGiftEnterAnimationLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements com.cupidapp.live.liveshow.view.giftpicker.view.b {
        public a() {
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.view.b
        public void a() {
            FKLiveGiftEnterAnimationLayout fKLiveGiftEnterAnimationLayout = FKLiveGiftEnterAnimationLayout.this;
            FKLiveSingleGiftEnterAnimationLayout bottomGiftEnterAnimationLayout = (FKLiveSingleGiftEnterAnimationLayout) fKLiveGiftEnterAnimationLayout.a(R$id.bottomGiftEnterAnimationLayout);
            s.h(bottomGiftEnterAnimationLayout, "bottomGiftEnterAnimationLayout");
            FKLiveSingleGiftEnterAnimationLayout topGiftEnterAnimationLayout = (FKLiveSingleGiftEnterAnimationLayout) FKLiveGiftEnterAnimationLayout.this.a(R$id.topGiftEnterAnimationLayout);
            s.h(topGiftEnterAnimationLayout, "topGiftEnterAnimationLayout");
            fKLiveGiftEnterAnimationLayout.g(bottomGiftEnterAnimationLayout, topGiftEnterAnimationLayout);
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.view.b
        public void b() {
            FKLiveGiftEnterAnimationLayout fKLiveGiftEnterAnimationLayout = FKLiveGiftEnterAnimationLayout.this;
            FKLiveSingleGiftEnterAnimationLayout bottomGiftEnterAnimationLayout = (FKLiveSingleGiftEnterAnimationLayout) fKLiveGiftEnterAnimationLayout.a(R$id.bottomGiftEnterAnimationLayout);
            s.h(bottomGiftEnterAnimationLayout, "bottomGiftEnterAnimationLayout");
            FKLiveSingleGiftEnterAnimationLayout topGiftEnterAnimationLayout = (FKLiveSingleGiftEnterAnimationLayout) FKLiveGiftEnterAnimationLayout.this.a(R$id.topGiftEnterAnimationLayout);
            s.h(topGiftEnterAnimationLayout, "topGiftEnterAnimationLayout");
            fKLiveGiftEnterAnimationLayout.d(bottomGiftEnterAnimationLayout, topGiftEnterAnimationLayout);
        }
    }

    /* compiled from: FKLiveGiftEnterAnimationLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.liveshow.view.giftpicker.view.b {
        public b() {
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.view.b
        public void a() {
            FKLiveGiftEnterAnimationLayout fKLiveGiftEnterAnimationLayout = FKLiveGiftEnterAnimationLayout.this;
            FKLiveSingleGiftEnterAnimationLayout bottomGiftEnterAnimationLayout = (FKLiveSingleGiftEnterAnimationLayout) fKLiveGiftEnterAnimationLayout.a(R$id.bottomGiftEnterAnimationLayout);
            s.h(bottomGiftEnterAnimationLayout, "bottomGiftEnterAnimationLayout");
            FKLiveSingleGiftEnterAnimationLayout topGiftEnterAnimationLayout = (FKLiveSingleGiftEnterAnimationLayout) FKLiveGiftEnterAnimationLayout.this.a(R$id.topGiftEnterAnimationLayout);
            s.h(topGiftEnterAnimationLayout, "topGiftEnterAnimationLayout");
            fKLiveGiftEnterAnimationLayout.g(bottomGiftEnterAnimationLayout, topGiftEnterAnimationLayout);
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.view.b
        public void b() {
            FKLiveGiftEnterAnimationLayout fKLiveGiftEnterAnimationLayout = FKLiveGiftEnterAnimationLayout.this;
            FKLiveSingleGiftEnterAnimationLayout topGiftEnterAnimationLayout = (FKLiveSingleGiftEnterAnimationLayout) fKLiveGiftEnterAnimationLayout.a(R$id.topGiftEnterAnimationLayout);
            s.h(topGiftEnterAnimationLayout, "topGiftEnterAnimationLayout");
            FKLiveSingleGiftEnterAnimationLayout bottomGiftEnterAnimationLayout = (FKLiveSingleGiftEnterAnimationLayout) FKLiveGiftEnterAnimationLayout.this.a(R$id.bottomGiftEnterAnimationLayout);
            s.h(bottomGiftEnterAnimationLayout, "bottomGiftEnterAnimationLayout");
            fKLiveGiftEnterAnimationLayout.d(topGiftEnterAnimationLayout, bottomGiftEnterAnimationLayout);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftEnterAnimationLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15511e = new LinkedHashMap();
        this.f15509c = new ArrayList();
        this.f15510d = new LinkedHashMap();
        i();
    }

    public static /* synthetic */ void f(FKLiveGiftEnterAnimationLayout fKLiveGiftEnterAnimationLayout, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        fKLiveGiftEnterAnimationLayout.e(z10, str);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15511e;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void d(FKLiveSingleGiftEnterAnimationLayout fKLiveSingleGiftEnterAnimationLayout, FKLiveSingleGiftEnterAnimationLayout fKLiveSingleGiftEnterAnimationLayout2) {
        List<LiveShowGiftModel> list = this.f15509c;
        if (list == null || list.isEmpty()) {
            FKLiveSingleGiftEnterAnimationLayout.n(fKLiveSingleGiftEnterAnimationLayout, null, 1, null);
            return;
        }
        if (fKLiveSingleGiftEnterAnimationLayout2.j()) {
            for (LiveShowGiftModel liveShowGiftModel : this.f15509c) {
                String rushId = liveShowGiftModel.getRushId();
                LiveShowGiftModel giftModel = fKLiveSingleGiftEnterAnimationLayout2.getGiftModel();
                if (!s.d(rushId, giftModel != null ? giftModel.getRushId() : null)) {
                    String rushId2 = liveShowGiftModel.getRushId();
                    LiveShowGiftModel giftModel2 = fKLiveSingleGiftEnterAnimationLayout.getGiftModel();
                    if (s.d(rushId2, giftModel2 != null ? giftModel2.getRushId() : null)) {
                        fKLiveSingleGiftEnterAnimationLayout.k(liveShowGiftModel);
                    } else {
                        fKLiveSingleGiftEnterAnimationLayout.m(liveShowGiftModel);
                    }
                    this.f15509c.remove(liveShowGiftModel);
                    return;
                }
            }
            FKLiveSingleGiftEnterAnimationLayout.n(fKLiveSingleGiftEnterAnimationLayout, null, 1, null);
            return;
        }
        String rushId3 = this.f15509c.get(0).getRushId();
        LiveShowGiftModel giftModel3 = fKLiveSingleGiftEnterAnimationLayout.getGiftModel();
        if (s.d(rushId3, giftModel3 != null ? giftModel3.getRushId() : null)) {
            fKLiveSingleGiftEnterAnimationLayout.k(this.f15509c.get(0));
        } else {
            fKLiveSingleGiftEnterAnimationLayout.m(this.f15509c.get(0));
        }
        this.f15509c.remove(0);
    }

    public final void e(boolean z10, @Nullable String str) {
        int i10 = R$id.topGiftEnterAnimationLayout;
        ((FKLiveSingleGiftEnterAnimationLayout) a(i10)).e(z10);
        int i11 = R$id.bottomGiftEnterAnimationLayout;
        ((FKLiveSingleGiftEnterAnimationLayout) a(i11)).e(z10);
        ViewGroup.LayoutParams layoutParams = ((FKLiveSingleGiftEnterAnimationLayout) a(i11)).getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = z10 ? 0 : z0.h.c(this, 10.0f);
        }
        ((FKLiveSingleGiftEnterAnimationLayout) a(i11)).setLayoutParams(marginLayoutParams);
        ((FKLiveSingleGiftEnterAnimationLayout) a(i10)).setEnterSource(str);
        ((FKLiveSingleGiftEnterAnimationLayout) a(i11)).setEnterSource(str);
    }

    public final void g(FKLiveSingleGiftEnterAnimationLayout fKLiveSingleGiftEnterAnimationLayout, FKLiveSingleGiftEnterAnimationLayout fKLiveSingleGiftEnterAnimationLayout2) {
        if (this.f15509c.isEmpty()) {
            Function0<p> function0 = this.f15508b;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        if (fKLiveSingleGiftEnterAnimationLayout.j() && fKLiveSingleGiftEnterAnimationLayout2.j()) {
            return;
        }
        if (!fKLiveSingleGiftEnterAnimationLayout.j() && !fKLiveSingleGiftEnterAnimationLayout2.j()) {
            fKLiveSingleGiftEnterAnimationLayout.g(this.f15509c.get(0)).l();
            this.f15509c.remove(0);
            return;
        }
        if (!fKLiveSingleGiftEnterAnimationLayout.j() && fKLiveSingleGiftEnterAnimationLayout2.j()) {
            for (LiveShowGiftModel liveShowGiftModel : this.f15509c) {
                String rushId = liveShowGiftModel.getRushId();
                LiveShowGiftModel giftModel = fKLiveSingleGiftEnterAnimationLayout2.getGiftModel();
                if (!s.d(rushId, giftModel != null ? giftModel.getRushId() : null)) {
                    fKLiveSingleGiftEnterAnimationLayout.g(liveShowGiftModel).l();
                    this.f15509c.remove(liveShowGiftModel);
                    return;
                }
            }
            return;
        }
        g(fKLiveSingleGiftEnterAnimationLayout2, fKLiveSingleGiftEnterAnimationLayout);
    }

    @Nullable
    public final Function0<p> getGiftEnterAnimationFinished() {
        return this.f15508b;
    }

    public final boolean h() {
        return ((FKLiveSingleGiftEnterAnimationLayout) a(R$id.topGiftEnterAnimationLayout)).j() || ((FKLiveSingleGiftEnterAnimationLayout) a(R$id.bottomGiftEnterAnimationLayout)).j();
    }

    public final void i() {
        z.a(this, R$layout.layout_live_gift_enter_animation, true);
        ((FKLiveSingleGiftEnterAnimationLayout) a(R$id.bottomGiftEnterAnimationLayout)).setCheckGiftListAnimationListener(new a());
        ((FKLiveSingleGiftEnterAnimationLayout) a(R$id.topGiftEnterAnimationLayout)).setCheckGiftListAnimationListener(new b());
    }

    public final void j(@NotNull LiveShowGiftModel giftModel) {
        LiveShowGiftModel liveShowGiftModel;
        s.i(giftModel, "giftModel");
        if (giftModel.getRushId() == null) {
            liveShowGiftModel = null;
        } else {
            Map<String, LiveShowGiftModel> map = this.f15510d;
            String rushId = giftModel.getRushId();
            s.f(rushId);
            liveShowGiftModel = map.get(rushId);
        }
        if (liveShowGiftModel == null) {
            if (giftModel.getRushId() != null) {
                Map<String, LiveShowGiftModel> map2 = this.f15510d;
                String rushId2 = giftModel.getRushId();
                s.f(rushId2);
                map2.put(rushId2, giftModel);
            }
            this.f15509c.add(giftModel);
        } else if (liveShowGiftModel.getRushCounter() < giftModel.getRushCounter()) {
            if (giftModel.getRushId() != null) {
                Map<String, LiveShowGiftModel> map3 = this.f15510d;
                String rushId3 = giftModel.getRushId();
                s.f(rushId3);
                map3.put(rushId3, giftModel);
            }
            this.f15509c.add(giftModel);
        }
        FKLiveSingleGiftEnterAnimationLayout bottomGiftEnterAnimationLayout = (FKLiveSingleGiftEnterAnimationLayout) a(R$id.bottomGiftEnterAnimationLayout);
        s.h(bottomGiftEnterAnimationLayout, "bottomGiftEnterAnimationLayout");
        FKLiveSingleGiftEnterAnimationLayout topGiftEnterAnimationLayout = (FKLiveSingleGiftEnterAnimationLayout) a(R$id.topGiftEnterAnimationLayout);
        s.h(topGiftEnterAnimationLayout, "topGiftEnterAnimationLayout");
        g(bottomGiftEnterAnimationLayout, topGiftEnterAnimationLayout);
    }

    public final void setGiftEnterAnimationFinished(@Nullable Function0<p> function0) {
        this.f15508b = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftEnterAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15511e = new LinkedHashMap();
        this.f15509c = new ArrayList();
        this.f15510d = new LinkedHashMap();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftEnterAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15511e = new LinkedHashMap();
        this.f15509c = new ArrayList();
        this.f15510d = new LinkedHashMap();
        i();
    }
}
