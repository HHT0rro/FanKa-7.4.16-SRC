package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.AlohaOrNopeGuideModel;
import com.cupidapp.live.base.view.BaseLayout;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardMoreSwipeLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardMoreSwipeLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16897d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardMoreSwipeLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16897d = new LinkedHashMap();
        k();
    }

    public static final void i(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void j(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Nullable
    public View g(int i10) {
        Map<Integer, View> map = this.f16897d;
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

    public final void h(@Nullable AlohaOrNopeGuideModel alohaOrNopeGuideModel, @NotNull final Function0<kotlin.p> clickCallback) {
        kotlin.jvm.internal.s.i(clickCallback, "clickCallback");
        if (alohaOrNopeGuideModel == null) {
            l(false);
            return;
        }
        ImageLoaderView earn_more_swipe_img = (ImageLoaderView) g(R$id.earn_more_swipe_img);
        kotlin.jvm.internal.s.h(earn_more_swipe_img, "earn_more_swipe_img");
        ImageLoaderView.g(earn_more_swipe_img, alohaOrNopeGuideModel.getIcon(), null, null, 6, null);
        ((TextView) g(R$id.earn_more_txt)).setText(alohaOrNopeGuideModel.getTitle());
        LinearLayout earn_more_swipe_root = (LinearLayout) g(R$id.earn_more_swipe_root);
        kotlin.jvm.internal.s.h(earn_more_swipe_root, "earn_more_swipe_root");
        z0.y.d(earn_more_swipe_root, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardMoreSwipeLayout$configData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                clickCallback.invoke();
                this.l(false);
            }
        });
        l(true);
        Observable<Long> observeOn = Observable.timer(5L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
        final Function1<Long, kotlin.p> function1 = new Function1<Long, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardMoreSwipeLayout$configData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Long l10) {
                invoke2(l10);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l10) {
                FKSwipeCardMoreSwipeLayout.this.l(false);
            }
        };
        Consumer<? super Long> consumer = new Consumer() { // from class: com.cupidapp.live.match.view.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FKSwipeCardMoreSwipeLayout.i(Function1.this, obj);
            }
        };
        final FKSwipeCardMoreSwipeLayout$configData$3 fKSwipeCardMoreSwipeLayout$configData$3 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardMoreSwipeLayout$configData$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.view.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FKSwipeCardMoreSwipeLayout.j(Function1.this, obj);
            }
        });
        kotlin.jvm.internal.s.h(subscribe, "fun configData(model: Al…   }, {})\n        )\n    }");
        H(subscribe);
    }

    public final void k() {
        z0.z.a(this, R$layout.layout_earn_more_swipe, true);
        setVisibility(8);
        TextView earn_more_txt = (TextView) g(R$id.earn_more_txt);
        kotlin.jvm.internal.s.h(earn_more_txt, "earn_more_txt");
        z0.u.a(earn_more_txt);
    }

    public final void l(boolean z10) {
        if (z10) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardMoreSwipeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16897d = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardMoreSwipeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16897d = new LinkedHashMap();
        k();
    }
}
