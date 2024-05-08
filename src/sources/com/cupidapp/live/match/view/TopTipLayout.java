package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.match.model.NearByTopTipModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TopTipLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TopTipLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public float f17001b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Disposable f17002c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17003d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopTipLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f17003d = new LinkedHashMap();
        i();
    }

    public static final void g(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void h(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final boolean j(TopTipLayout this$0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        view.performClick();
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.f17001b = motionEvent.getRawY();
            return true;
        }
        if (action != 2) {
            return true;
        }
        if (this$0.f17001b - motionEvent.getRawY() <= z0.h.c(this$0, 20.0f)) {
            return true;
        }
        this$0.e();
        return true;
    }

    @Nullable
    public View d(int i10) {
        Map<Integer, View> map = this.f17003d;
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

    public final void e() {
        Disposable disposable = this.f17002c;
        if (disposable != null) {
            disposable.dispose();
        }
        setVisibility(8);
    }

    public final void f(@NotNull final NearByTopTipModel model) {
        kotlin.jvm.internal.s.i(model, "model");
        String buttonUrl = model.getButtonUrl();
        if (buttonUrl == null || buttonUrl.length() == 0) {
            setVisibility(8);
            return;
        }
        TextView near_top_btn = (TextView) d(R$id.near_top_btn);
        kotlin.jvm.internal.s.h(near_top_btn, "near_top_btn");
        z0.y.d(near_top_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.TopTipLayout$configData$1
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
                j.a.b(com.cupidapp.live.base.router.j.f12156c, TopTipLayout.this.getContext(), model.getButtonUrl(), null, 4, null);
                GroupOthersLog.f18702a.m(model.getTitle() + model.getSubtitle(), model.getTrackName());
                TopTipLayout.this.e();
            }
        });
        if (this.f17002c != null) {
            e();
        }
        Observable observeOn = Observable.just(model).observeOn(AndroidSchedulers.mainThread());
        final Function1<NearByTopTipModel, kotlin.p> function1 = new Function1<NearByTopTipModel, kotlin.p>() { // from class: com.cupidapp.live.match.view.TopTipLayout$configData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NearByTopTipModel nearByTopTipModel) {
                invoke2(nearByTopTipModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NearByTopTipModel nearByTopTipModel) {
                ImageLoaderView near_top_icon = (ImageLoaderView) TopTipLayout.this.d(R$id.near_top_icon);
                kotlin.jvm.internal.s.h(near_top_icon, "near_top_icon");
                ImageLoaderView.g(near_top_icon, model.getIcon(), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, ContextCompat.getColor(TopTipLayout.this.getContext(), R$color.app_transparent), 0, null, null, null, null, false, 0, 0, false, null, null, 524159, null), null, 4, null);
                ((TextView) TopTipLayout.this.d(R$id.near_top_title)).setText(model.getTitle());
                ((TextView) TopTipLayout.this.d(R$id.near_top_des)).setText(model.getSubtitle());
                ((TextView) TopTipLayout.this.d(R$id.near_top_btn)).setText(model.getButtonName());
                TopTipLayout.this.setVisibility(0);
            }
        };
        Observable observeOn2 = observeOn.doOnNext(new Consumer() { // from class: com.cupidapp.live.match.view.d0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TopTipLayout.g(Function1.this, obj);
            }
        }).observeOn(Schedulers.io()).delay(5L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
        final Function1<NearByTopTipModel, kotlin.p> function12 = new Function1<NearByTopTipModel, kotlin.p>() { // from class: com.cupidapp.live.match.view.TopTipLayout$configData$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NearByTopTipModel nearByTopTipModel) {
                invoke2(nearByTopTipModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NearByTopTipModel nearByTopTipModel) {
                TopTipLayout.this.e();
            }
        };
        this.f17002c = observeOn2.subscribe(new Consumer() { // from class: com.cupidapp.live.match.view.c0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TopTipLayout.h(Function1.this, obj);
            }
        });
        GroupOthersLog.f18702a.n(model.getTitle() + model.getSubtitle(), model.getTrackName());
    }

    public final void i() {
        setVisibility(8);
        z0.z.a(this, R$layout.near_by_top_tip, true);
        TextView near_top_title = (TextView) d(R$id.near_top_title);
        kotlin.jvm.internal.s.h(near_top_title, "near_top_title");
        z0.u.a(near_top_title);
        TextView near_top_btn = (TextView) d(R$id.near_top_btn);
        kotlin.jvm.internal.s.h(near_top_btn, "near_top_btn");
        z0.u.a(near_top_btn);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.match.view.b0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean j10;
                j10 = TopTipLayout.j(TopTipLayout.this, view, motionEvent);
                return j10;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopTipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f17003d = new LinkedHashMap();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopTipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f17003d = new LinkedHashMap();
        i();
    }
}
