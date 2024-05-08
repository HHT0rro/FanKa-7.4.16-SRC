package com.cupidapp.live.liveshow.view.horn;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.liveshow.model.FKHornType;
import com.cupidapp.live.liveshow.model.FKLiveHornModel;
import com.cupidapp.live.liveshow.model.LiveHornStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: FKLiveBaseHornLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBaseHornLayout extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f15668f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public static List<FKLiveHornModel> f15669g;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Boolean f15670b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public i f15671c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f15672d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15673e;

    /* compiled from: FKLiveBaseHornLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FKLiveBaseHornLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FKLiveHornModel f15675c;

        public b(FKLiveHornModel fKLiveHornModel) {
            this.f15675c = fKLiveHornModel;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            FKLiveBaseHornLayout.this.removeAllViews();
            i iVar = FKLiveBaseHornLayout.this.f15671c;
            if (iVar != null) {
                iVar.g();
            }
            this.f15675c.setAnimatorEnd(true);
            this.f15675c.setBigHornSurplusTime(null);
            FKLiveBaseHornLayout.this.f15671c = null;
            FKLiveBaseHornLayout.this.f15670b = null;
            FKLiveBaseHornLayout.this.l();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBaseHornLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15673e = new LinkedHashMap();
    }

    public static final void h(FKLiveBaseHornLayout this$0, FKLiveHornModel model) {
        s.i(this$0, "this$0");
        s.i(model, "$model");
        ObjectAnimator objectAnimator = this$0.f15672d;
        if (objectAnimator != null) {
            objectAnimator.addListener(new b(model));
        }
        ObjectAnimator objectAnimator2 = this$0.f15672d;
        if (objectAnimator2 != null) {
            objectAnimator2.start();
        }
    }

    public final void f(@NotNull FKLiveHornModel model) {
        s.i(model, "model");
        List<FKLiveHornModel> list = f15669g;
        if (list == null || list.isEmpty()) {
            f15669g = kotlin.collections.s.o(model);
        } else if (s.d(model.getStyle(), LiveHornStyle.Lucky.getValue())) {
            List<FKLiveHornModel> list2 = f15669g;
            if (list2 != null) {
                list2.add(0, model);
            }
        } else {
            List<FKLiveHornModel> list3 = f15669g;
            if (list3 != null) {
                list3.add(model);
            }
        }
        l();
    }

    public final void g(final FKLiveHornModel fKLiveHornModel, FKLiveHornLayout fKLiveHornLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(fKLiveHornLayout, (Property<FKLiveHornLayout, Float>) View.TRANSLATION_X, -h.c(this, 5.0f), -h.l(this));
        this.f15672d = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(500L);
        }
        postDelayed(new Runnable() { // from class: com.cupidapp.live.liveshow.view.horn.a
            @Override // java.lang.Runnable
            public final void run() {
                FKLiveBaseHornLayout.h(FKLiveBaseHornLayout.this, fKLiveHornModel);
            }
        }, (fKLiveHornModel.getBigHornSurplusTime() != null ? r0.intValue() : fKLiveHornModel.getSuspTime()) * 1000);
    }

    public final void i(FKLiveHornModel fKLiveHornModel, FKLiveHornLayout fKLiveHornLayout) {
        if (!fKLiveHornModel.getAnimatorStart()) {
            SensorsLogLiveShow.f12212a.s(String.valueOf(fKLiveHornModel.getHornCode()), FKHornType.Companion.a(fKLiveHornModel.getType()), fKLiveHornModel.getScene());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(fKLiveHornLayout, (Property<FKLiveHornLayout, Float>) View.TRANSLATION_X, h.l(this), -h.c(this, 5.0f));
            ofFloat.setDuration(500L);
            fKLiveHornModel.setAnimatorStart(true);
            ofFloat.start();
            return;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(fKLiveHornLayout, (Property<FKLiveHornLayout, Float>) View.TRANSLATION_X, 0.0f, -h.c(this, 5.0f));
        ofFloat2.setDuration(1L);
        ofFloat2.start();
    }

    public final void j() {
        try {
            ObjectAnimator objectAnimator = this.f15672d;
            if (objectAnimator != null) {
                objectAnimator.pause();
            }
            ObjectAnimator objectAnimator2 = this.f15672d;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.f15672d = null;
            i iVar = this.f15671c;
            if (iVar != null) {
                iVar.g();
            }
            this.f15671c = null;
            this.f15670b = null;
            removeAllViews();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void k() {
        try {
            List<FKLiveHornModel> list = f15669g;
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (FKLiveHornModel fKLiveHornModel : list) {
                    if (fKLiveHornModel.getType() == FKHornType.BigHornType.getHornType()) {
                        arrayList.add(fKLiveHornModel);
                    }
                }
                List<FKLiveHornModel> list2 = f15669g;
                if (list2 != null) {
                    list2.clear();
                }
                List<FKLiveHornModel> list3 = f15669g;
                if (list3 != null) {
                    list3.addAll(arrayList);
                }
            }
            l();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void l() {
        if (s.d(this.f15670b, Boolean.TRUE)) {
            return;
        }
        List<FKLiveHornModel> list = f15669g;
        FKLiveHornModel fKLiveHornModel = null;
        if (list != null) {
            Iterator<FKLiveHornModel> iterator2 = list.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                FKLiveHornModel next = iterator2.next();
                if (!next.getAnimatorEnd()) {
                    fKLiveHornModel = next;
                    break;
                }
            }
            fKLiveHornModel = fKLiveHornModel;
        }
        if (fKLiveHornModel == null) {
            List<FKLiveHornModel> list2 = f15669g;
            if (list2 != null) {
                list2.clear();
                return;
            }
            return;
        }
        this.f15670b = Boolean.TRUE;
        Context context = getContext();
        s.h(context, "context");
        FKLiveHornLayout fKLiveHornLayout = new FKLiveHornLayout(context, fKLiveHornModel);
        addView(fKLiveHornLayout);
        m(fKLiveHornModel);
        i(fKLiveHornModel, fKLiveHornLayout);
        g(fKLiveHornModel, fKLiveHornLayout);
    }

    public final void m(final FKLiveHornModel fKLiveHornModel) {
        if (fKLiveHornModel.getType() == FKHornType.SmallHornType.getHornType()) {
            fKLiveHornModel.setAnimatorEnd(true);
            return;
        }
        i iVar = new i();
        this.f15671c = iVar;
        Integer bigHornSurplusTime = fKLiveHornModel.getBigHornSurplusTime();
        iVar.c(Integer.valueOf(bigHornSurplusTime != null ? bigHornSurplusTime.intValue() : fKLiveHornModel.getSuspTime()), 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.horn.FKLiveBaseHornLayout$startCountDown$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        }, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.view.horn.FKLiveBaseHornLayout$startCountDown$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i10) {
                j.f12332a.a("FKLiveHornLayout", "surplusTime " + i10);
                FKLiveHornModel.this.setBigHornSurplusTime(Integer.valueOf(i10));
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBaseHornLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15673e = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBaseHornLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15673e = new LinkedHashMap();
    }
}
