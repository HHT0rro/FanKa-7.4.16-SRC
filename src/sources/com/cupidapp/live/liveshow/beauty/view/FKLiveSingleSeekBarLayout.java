package com.cupidapp.live.liveshow.beauty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyEditItemModel;
import com.cupidapp.live.mediapicker.view.BottomConfirmAndCancelLayout;
import com.cupidapp.live.mediapicker.view.CustomAnimationLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r2.i;
import z0.y;
import z0.z;

/* compiled from: FKLiveSingleSeekBarLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveSingleSeekBarLayout extends CustomAnimationLayout {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public FKLiveBeautyEditItemModel f14897c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public FKLiveFilterViewModel f14898d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Float f14899e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public d f14900f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14901g;

    /* compiled from: FKLiveSingleSeekBarLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@Nullable SeekBar seekBar, int i10, boolean z10) {
            FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel = FKLiveSingleSeekBarLayout.this.f14897c;
            if (fKLiveBeautyEditItemModel != null) {
                FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout = FKLiveSingleSeekBarLayout.this;
                if (z10) {
                    fKLiveSingleSeekBarLayout.q(i10, fKLiveBeautyEditItemModel);
                }
            }
            if (FKLiveSingleSeekBarLayout.this.f14898d != null) {
                FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout2 = FKLiveSingleSeekBarLayout.this;
                if (z10) {
                    fKLiveSingleSeekBarLayout2.r(i10);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
            FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel = FKLiveSingleSeekBarLayout.this.f14897c;
            if (fKLiveBeautyEditItemModel != null) {
                FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout = FKLiveSingleSeekBarLayout.this;
                ((TextView) fKLiveSingleSeekBarLayout.g(R$id.seekBarProgressTextView)).setText(fKLiveSingleSeekBarLayout.getContext().getText(fKLiveBeautyEditItemModel.getButtonType().typeName()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSingleSeekBarLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f14901g = new LinkedHashMap();
        w();
    }

    public static final boolean x(View view, MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            i.f53231b.D(false);
        } else if (valueOf != null && valueOf.intValue() == 1) {
            view.performClick();
            i.f53231b.D(true);
        }
        return true;
    }

    public final void A(float f10, FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel) {
        int i10;
        FKLiveBeautyButtonEnum buttonType = fKLiveBeautyEditItemModel.getButtonType();
        if (FKLiveBeautyButtonEnum.Companion.b(buttonType)) {
            float f11 = 50;
            i10 = (int) ((f10 * f11) + f11);
        } else {
            i10 = (int) (100 * f10);
        }
        s(Integer.valueOf(i10));
        i.f53231b.N(buttonType.nodeName(), buttonType.getEffectId(), f10);
    }

    public final void B() {
        Integer filterIntensity;
        FKLiveFilterViewModel fKLiveFilterViewModel = this.f14898d;
        if (fKLiveFilterViewModel == null) {
            return;
        }
        s(fKLiveFilterViewModel != null ? fKLiveFilterViewModel.getFilterIntensity() : null);
        FKLiveFilterViewModel fKLiveFilterViewModel2 = this.f14898d;
        t((fKLiveFilterViewModel2 == null || (filterIntensity = fKLiveFilterViewModel2.getFilterIntensity()) == null) ? null : filterIntensity.toString());
        i iVar = i.f53231b;
        FKLiveFilterViewModel fKLiveFilterViewModel3 = this.f14898d;
        String filterResource = fKLiveFilterViewModel3 != null ? fKLiveFilterViewModel3.getFilterResource() : null;
        FKLiveFilterViewModel fKLiveFilterViewModel4 = this.f14898d;
        iVar.E(filterResource, fKLiveFilterViewModel4 != null ? fKLiveFilterViewModel4.getFilterIntensity() : null);
    }

    @Override // com.cupidapp.live.mediapicker.view.CustomAnimationLayout
    public void a() {
        Float f10 = this.f14899e;
        if (f10 != null) {
            FKLiveFilterViewModel fKLiveFilterViewModel = this.f14898d;
            if (fKLiveFilterViewModel != null) {
                s.f(f10);
                fKLiveFilterViewModel.setFilterIntensity(Integer.valueOf((int) f10.floatValue()));
            }
            FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel = this.f14897c;
            if (fKLiveBeautyEditItemModel != null) {
                Float f11 = this.f14899e;
                s.f(f11);
                fKLiveBeautyEditItemModel.setCacheValue(f11);
            }
        }
        z();
        d dVar = this.f14900f;
        if (dVar != null) {
            dVar.a();
        }
        y();
        Property<View, Float> ALPHA = View.ALPHA;
        s.h(ALPHA, "ALPHA");
        b(ALPHA);
    }

    @Nullable
    public View g(int i10) {
        Map<Integer, View> map = this.f14901g;
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

    public final void q(int i10, FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel) {
        float f10;
        float f11;
        FKLiveBeautyButtonEnum buttonType = fKLiveBeautyEditItemModel.getButtonType();
        FKLiveBeautyButtonEnum.a aVar = FKLiveBeautyButtonEnum.Companion;
        t(String.valueOf(aVar.b(buttonType) ? (i10 * 2) - 100 : i10));
        if (aVar.b(buttonType)) {
            f10 = i10 - 50;
            f11 = 50.0f;
        } else {
            f10 = i10;
            f11 = 100.0f;
        }
        float f12 = f10 / f11;
        i.f53231b.N(buttonType.nodeName(), buttonType.getEffectId(), f12);
        FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel2 = this.f14897c;
        if (fKLiveBeautyEditItemModel2 == null) {
            return;
        }
        fKLiveBeautyEditItemModel2.setCacheValue(Float.valueOf(f12));
    }

    public final void r(int i10) {
        FKLiveFilterViewModel fKLiveFilterViewModel = this.f14898d;
        if (fKLiveFilterViewModel != null) {
            fKLiveFilterViewModel.setFilterIntensity(Integer.valueOf(i10));
        }
        t(String.valueOf(i10));
        i.f53231b.P(Integer.valueOf(i10));
    }

    public final void s(Integer num) {
        if (num != null) {
            num.intValue();
            ((SeekBar) g(R$id.mediaEditSingleSeekBar)).setProgress(num.intValue());
        }
    }

    public final void setSingleSeekBarListener(@NotNull d listener) {
        s.i(listener, "listener");
        this.f14900f = listener;
    }

    public final void t(String str) {
        if (str != null) {
            ((TextView) g(R$id.seekBarProgressTextView)).setText(str);
        }
    }

    public final void u(@NotNull FKLiveBeautyEditItemModel model) {
        float floatValue;
        s.i(model, "model");
        this.f14897c = model;
        if (model.getCacheValue() == null) {
            floatValue = model.getButtonType().defaultValue();
        } else {
            Float cacheValue = model.getCacheValue();
            s.f(cacheValue);
            floatValue = cacheValue.floatValue();
        }
        this.f14899e = Float.valueOf(floatValue);
        A(floatValue, model);
        ((TextView) g(R$id.seekBarProgressTextView)).setText(getContext().getText(model.getButtonType().typeName()));
    }

    public final void v(@NotNull FKLiveFilterViewModel model) {
        s.i(model, "model");
        this.f14898d = model;
        this.f14899e = model.getFilterIntensity() != null ? Float.valueOf(r2.intValue()) : null;
        B();
    }

    public final void w() {
        z.a(this, R$layout.layout_live_beauty_edit_single_seek_bar, true);
        ((TextView) g(R$id.seekBarProgressTextView)).getPaint().setFakeBoldText(true);
        int i10 = R$id.mediaEditSingleSeekBar;
        ((SeekBar) g(i10)).setSplitTrack(false);
        ((SeekBar) g(i10)).setOnSeekBarChangeListener(new a());
        int i11 = R$id.singleSeekBarSelectLayout;
        ((BottomConfirmAndCancelLayout) g(i11)).setConfirmButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveSingleSeekBarLayout$initView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                d dVar;
                dVar = FKLiveSingleSeekBarLayout.this.f14900f;
                if (dVar != null) {
                    dVar.b(FKLiveSingleSeekBarLayout.this.f14897c, FKLiveSingleSeekBarLayout.this.f14898d);
                }
                FKLiveSingleSeekBarLayout.this.y();
                FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout = FKLiveSingleSeekBarLayout.this;
                Property<View, Float> ALPHA = View.ALPHA;
                s.h(ALPHA, "ALPHA");
                fKLiveSingleSeekBarLayout.b(ALPHA);
            }
        });
        ((BottomConfirmAndCancelLayout) g(i11)).setCancelButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveSingleSeekBarLayout$initView$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKLiveSingleSeekBarLayout.this.d();
            }
        });
        View liveBeautyCloseSeekBarLayout = g(R$id.liveBeautyCloseSeekBarLayout);
        s.h(liveBeautyCloseSeekBarLayout, "liveBeautyCloseSeekBarLayout");
        y.d(liveBeautyCloseSeekBarLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveSingleSeekBarLayout$initView$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKLiveSingleSeekBarLayout.this.d();
            }
        });
        TextView liveBeautySeekBarReset = (TextView) g(R$id.liveBeautySeekBarReset);
        s.h(liveBeautySeekBarReset, "liveBeautySeekBarReset");
        y.d(liveBeautySeekBarReset, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveSingleSeekBarLayout$initView$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel = FKLiveSingleSeekBarLayout.this.f14897c;
                if (fKLiveBeautyEditItemModel != null) {
                    FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout = FKLiveSingleSeekBarLayout.this;
                    fKLiveSingleSeekBarLayout.A(fKLiveBeautyEditItemModel.getButtonType().defaultValue(), fKLiveBeautyEditItemModel);
                    FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel2 = fKLiveSingleSeekBarLayout.f14897c;
                    if (fKLiveBeautyEditItemModel2 != null) {
                        fKLiveBeautyEditItemModel2.setCacheValue(Float.valueOf(fKLiveBeautyEditItemModel.getButtonType().defaultValue()));
                    }
                }
                FKLiveFilterViewModel fKLiveFilterViewModel = FKLiveSingleSeekBarLayout.this.f14898d;
                if (fKLiveFilterViewModel != null) {
                    FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout2 = FKLiveSingleSeekBarLayout.this;
                    FKLiveFilterViewModel fKLiveFilterViewModel2 = fKLiveSingleSeekBarLayout2.f14898d;
                    if (fKLiveFilterViewModel2 != null) {
                        fKLiveFilterViewModel2.setFilterIntensity(Integer.valueOf(fKLiveFilterViewModel.getFilterDefaults()));
                    }
                    fKLiveSingleSeekBarLayout2.B();
                }
            }
        });
        ((TextView) g(R$id.liveBeautySeekBarContrast)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.liveshow.beauty.view.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean x10;
                x10 = FKLiveSingleSeekBarLayout.x(view, motionEvent);
                return x10;
            }
        });
    }

    public final void y() {
        this.f14899e = null;
        this.f14897c = null;
        this.f14898d = null;
        s(0);
    }

    public final void z() {
        FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel = this.f14897c;
        FKLiveBeautyButtonEnum buttonType = fKLiveBeautyEditItemModel != null ? fKLiveBeautyEditItemModel.getButtonType() : null;
        FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel2 = this.f14897c;
        Float cacheValue = fKLiveBeautyEditItemModel2 != null ? fKLiveBeautyEditItemModel2.getCacheValue() : null;
        if (buttonType == null || cacheValue == null) {
            return;
        }
        i.f53231b.N(buttonType.nodeName(), buttonType.getEffectId(), cacheValue.floatValue());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSingleSeekBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f14901g = new LinkedHashMap();
        w();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSingleSeekBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f14901g = new LinkedHashMap();
        w();
    }
}
