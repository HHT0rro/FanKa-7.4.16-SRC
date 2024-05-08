package com.cupidapp.live.feed.layout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.match.helper.FloatAvatarHelper;
import com.cupidapp.live.match.model.MapOverPopResult;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.irisdt.client.others.OthersProtos;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MapFloatLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MapFloatLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f14527b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f14528c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f14529d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public List<ImageModel> f14530e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14531f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapFloatLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14531f = new LinkedHashMap();
        this.f14527b = kotlin.c.b(MapFloatLayout$showMapFloatViewAnim$2.INSTANCE);
        this.f14528c = kotlin.c.b(MapFloatLayout$hideMapFloatViewAnim$2.INSTANCE);
        this.f14529d = kotlin.c.b(MapFloatLayout$animHelper$2.INSTANCE);
        j();
    }

    private final FloatAvatarHelper<ImageModel> getAnimHelper() {
        return (FloatAvatarHelper) this.f14529d.getValue();
    }

    private final ValueAnimator getHideMapFloatViewAnim() {
        return (ValueAnimator) this.f14528c.getValue();
    }

    private final ValueAnimator getShowMapFloatViewAnim() {
        return (ValueAnimator) this.f14527b.getValue();
    }

    public static final void h(final MapFloatLayout this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if ((this$0.getHideMapFloatViewAnim().isPaused() || !(this$0.getHideMapFloatViewAnim().isRunning() || this$0.getHideMapFloatViewAnim().isStarted())) && this$0.getTranslationX() < this$0.getWidth()) {
            this$0.getShowMapFloatViewAnim().pause();
            final float translationX = this$0.getTranslationX();
            final int width = this$0.getWidth();
            this$0.getHideMapFloatViewAnim().setDuration(300L);
            this$0.getHideMapFloatViewAnim().addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.feed.layout.m
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MapFloatLayout.i(MapFloatLayout.this, translationX, width, valueAnimator);
                }
            });
            this$0.getHideMapFloatViewAnim().start();
        }
    }

    public static final void i(MapFloatLayout this$0, float f10, int i10, ValueAnimator it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.s.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.setTranslationX(f10 + (i10 * floatValue));
        if (floatValue == 1.0f) {
            this$0.setVisibility(8);
        }
    }

    public static final void l(final MapFloatLayout this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if ((this$0.getShowMapFloatViewAnim().isPaused() || !(this$0.getShowMapFloatViewAnim().isStarted() || this$0.getShowMapFloatViewAnim().isRunning())) && this$0.getTranslationX() > 0.0f) {
            this$0.getHideMapFloatViewAnim().pause();
            this$0.setVisibility(0);
            final float translationX = this$0.getTranslationX();
            this$0.getShowMapFloatViewAnim().setDuration(300L);
            this$0.getShowMapFloatViewAnim().addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.feed.layout.l
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MapFloatLayout.m(MapFloatLayout.this, translationX, valueAnimator);
                }
            });
            this$0.getShowMapFloatViewAnim().start();
        }
    }

    public static final void m(MapFloatLayout this$0, float f10, ValueAnimator it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.s.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.setTranslationX(((Float) animatedValue).floatValue() * f10);
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f14531f;
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

    public final void f(@NotNull final MapOverPopResult model, @NotNull final OthersProtos.Enum_type type, int i10) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(type, "type");
        RelativeLayout float_action_root = (RelativeLayout) e(R$id.float_action_root);
        kotlin.jvm.internal.s.h(float_action_root, "float_action_root");
        y.o(float_action_root, Integer.valueOf(i10), null, 2, null);
        List<ImageModel> avatars = model.getAvatars();
        this.f14530e = avatars;
        if (avatars == null || avatars.isEmpty()) {
            setVisibility(8);
            return;
        }
        ((TextView) e(R$id.float_map_find_title)).setText(model.getTitle());
        ((TextView) e(R$id.float_map_find_subtitle)).setText(model.getSubtitle());
        List<ImageModel> list = this.f14530e;
        if (list != null) {
            getAnimHelper().k(list, (ImageLoaderView) e(R$id.float_firstAvatarImg), (ImageLoaderView) e(R$id.float_secondAvatarImg), new Function2<ImageModel, ImageModel, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.MapFloatLayout$configFloat$1$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(ImageModel imageModel, ImageModel imageModel2) {
                    invoke2(imageModel, imageModel2);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ImageModel firstData, @NotNull ImageModel secondData) {
                    kotlin.jvm.internal.s.i(firstData, "firstData");
                    kotlin.jvm.internal.s.i(secondData, "secondData");
                    ImageLoaderView imageLoaderView = (ImageLoaderView) MapFloatLayout.this.e(R$id.float_firstAvatarImg);
                    if (imageLoaderView != null) {
                        ImageLoaderView.g(imageLoaderView, firstData, null, null, 6, null);
                    }
                    ImageLoaderView imageLoaderView2 = (ImageLoaderView) MapFloatLayout.this.e(R$id.float_secondAvatarImg);
                    if (imageLoaderView2 != null) {
                        ImageLoaderView.g(imageLoaderView2, secondData, null, null, 6, null);
                    }
                }
            });
        }
        setVisibility(0);
        y.d(this, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.MapFloatLayout$configFloat$2
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
                j.a.b(com.cupidapp.live.base.router.j.f12156c, MapFloatLayout.this.getContext(), model.getUrl(), null, 4, null);
                GroupOthersLog.p(GroupOthersLog.f18702a, type, null, null, 6, null);
            }
        });
        GroupOthersLog.r(GroupOthersLog.f18702a, type, null, 2, null);
    }

    public final void g() {
        List<ImageModel> list = this.f14530e;
        if (list == null || list.isEmpty()) {
            setVisibility(8);
        } else {
            post(new Runnable() { // from class: com.cupidapp.live.feed.layout.o
                @Override // java.lang.Runnable
                public final void run() {
                    MapFloatLayout.h(MapFloatLayout.this);
                }
            });
        }
    }

    public final void j() {
        z.a(this, R$layout.layout_float_action, true);
        TextView float_map_find_title = (TextView) e(R$id.float_map_find_title);
        kotlin.jvm.internal.s.h(float_map_find_title, "float_map_find_title");
        z0.u.a(float_map_find_title);
    }

    public final void k() {
        List<ImageModel> list = this.f14530e;
        if (list == null || list.isEmpty()) {
            setVisibility(8);
        } else {
            post(new Runnable() { // from class: com.cupidapp.live.feed.layout.n
                @Override // java.lang.Runnable
                public final void run() {
                    MapFloatLayout.l(MapFloatLayout.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapFloatLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14531f = new LinkedHashMap();
        this.f14527b = kotlin.c.b(MapFloatLayout$showMapFloatViewAnim$2.INSTANCE);
        this.f14528c = kotlin.c.b(MapFloatLayout$hideMapFloatViewAnim$2.INSTANCE);
        this.f14529d = kotlin.c.b(MapFloatLayout$animHelper$2.INSTANCE);
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapFloatLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14531f = new LinkedHashMap();
        this.f14527b = kotlin.c.b(MapFloatLayout$showMapFloatViewAnim$2.INSTANCE);
        this.f14528c = kotlin.c.b(MapFloatLayout$hideMapFloatViewAnim$2.INSTANCE);
        this.f14529d = kotlin.c.b(MapFloatLayout$animHelper$2.INSTANCE);
        j();
    }
}
