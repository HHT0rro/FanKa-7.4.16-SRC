package com.cupidapp.live.superlike.helper;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.match.view.FKClickAnimationLayout;
import com.cupidapp.live.superlike.view.SuperLikeDeliveryAnimLayout;
import com.cupidapp.live.superlike.view.SuperLikeDialogLayout;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: SuperLikeClickHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikeClickHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SuperLikeClickHelper f18616a = new SuperLikeClickHelper();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final CompositeDisposable f18617b = new CompositeDisposable();

    /* renamed from: c, reason: collision with root package name */
    public static int f18618c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f18619d;

    /* compiled from: SuperLikeClickHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements com.cupidapp.live.match.view.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperLikeDeliveryAnimLayout f18620a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<Integer, p> f18621b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(SuperLikeDeliveryAnimLayout superLikeDeliveryAnimLayout, Function1<? super Integer, p> function1) {
            this.f18620a = superLikeDeliveryAnimLayout;
            this.f18621b = function1;
        }

        @Override // com.cupidapp.live.match.view.b
        public void a(boolean z10) {
            SuperLikeClickHelper.f18616a.k(z10, this.f18620a, this.f18621b);
        }
    }

    public static final void i(SuperLikeDeliveryAnimLayout animLayout, Function1 clickListener, View view, boolean z10) {
        s.i(animLayout, "$animLayout");
        s.i(clickListener, "$clickListener");
        if (z10) {
            return;
        }
        f18616a.k(false, animLayout, clickListener);
    }

    public final void f(@Nullable SuperLikeDeliveryAnimLayout superLikeDeliveryAnimLayout) {
        f18619d = true;
        f18617b.clear();
        if (superLikeDeliveryAnimLayout != null) {
            superLikeDeliveryAnimLayout.d();
        }
    }

    public final void g(@NotNull final Context context, @NotNull final Lifecycle lifecycle, @NotNull final SensorPosition position, @NotNull final FKClickAnimationLayout view, @NotNull final SuperLikeDeliveryAnimLayout animLayout, @Nullable final Function0<p> function0, @NotNull final Function1<? super Integer, p> clickListener) {
        s.i(context, "context");
        s.i(lifecycle, "lifecycle");
        s.i(position, "position");
        s.i(view, "view");
        s.i(animLayout, "animLayout");
        s.i(clickListener, "clickListener");
        view.setTouchChangeListener(new a(animLayout, clickListener));
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.cupidapp.live.superlike.helper.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z10) {
                SuperLikeClickHelper.i(SuperLikeDeliveryAnimLayout.this, clickListener, view2, z10);
            }
        });
        y.d(view, new Function1<View, p>() { // from class: com.cupidapp.live.superlike.helper.SuperLikeClickHelper$configSuperLikeClickEvent$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view2) {
                invoke2(view2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                if (FKClickAnimationLayout.this.getVisibility() != 0 || FKClickAnimationLayout.this.getAlpha() < 1.0f) {
                    return;
                }
                GroupOthersLog.f18702a.Q(position.name(), "SUPER_LIKE_CLICK_BTN");
                SuperLikeClickHelper superLikeClickHelper = SuperLikeClickHelper.f18616a;
                SuperLikeClickHelper.f18619d = false;
                clickListener.invoke(1);
            }
        });
        y.c(view, new Function1<View, p>() { // from class: com.cupidapp.live.superlike.helper.SuperLikeClickHelper$configSuperLikeClickEvent$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view2) {
                invoke2(view2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                if (FKClickAnimationLayout.this.getVisibility() != 0 || FKClickAnimationLayout.this.getAlpha() < 1.0f) {
                    return;
                }
                GroupOthersLog.f18702a.Q(position.name(), "SUPER_LIKE_LONG_CLICK_BTN");
                SuperLikeClickHelper superLikeClickHelper = SuperLikeClickHelper.f18616a;
                SuperLikeClickHelper.f18619d = false;
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                superLikeClickHelper.j(context, lifecycle, animLayout, clickListener);
            }
        });
        y.d(animLayout, new Function1<View, p>() { // from class: com.cupidapp.live.superlike.helper.SuperLikeClickHelper$configSuperLikeClickEvent$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view2) {
                invoke2(view2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                SuperLikeClickHelper.f18616a.k(false, SuperLikeDeliveryAnimLayout.this, clickListener);
            }
        });
    }

    public final void j(@NotNull Context context, @NotNull Lifecycle lifecycle, @NotNull SuperLikeDeliveryAnimLayout superlikeDelivery, @NotNull Function1<? super Integer, p> clickListener) {
        s.i(context, "context");
        s.i(lifecycle, "lifecycle");
        s.i(superlikeDelivery, "superlikeDelivery");
        s.i(clickListener, "clickListener");
        SuperLikeDialogLayout.f18632h.a(context, lifecycle, VipPurchaseEntranceType.SuperLikeMatch, new SuperLikeClickHelper$superLikeBtnLongClick$1(superlikeDelivery, clickListener));
    }

    public final void k(boolean z10, @NotNull SuperLikeDeliveryAnimLayout superlikeDelivery, @NotNull Function1<? super Integer, p> clickListener) {
        s.i(superlikeDelivery, "superlikeDelivery");
        s.i(clickListener, "clickListener");
        if (z10) {
            return;
        }
        f18617b.clear();
        superlikeDelivery.d();
        if (f18619d) {
            superlikeDelivery.getAndResetSendCount();
        } else if (superlikeDelivery.getSendCount() > 0) {
            clickListener.invoke(Integer.valueOf(superlikeDelivery.getAndResetSendCount()));
        }
    }
}
