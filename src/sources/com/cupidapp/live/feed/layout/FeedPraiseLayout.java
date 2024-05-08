package com.cupidapp.live.feed.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.base.extension.NetworkStateConstants;
import com.cupidapp.live.base.imageloader.TransformationType;
import com.cupidapp.live.base.imageloader.c;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.view.CanScrollLinearLayoutManager;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import com.cupidapp.live.base.view.zoom.ZoomImageView;
import com.cupidapp.live.feed.activity.FeedDetailActivity;
import com.cupidapp.live.feed.activity.FeedDetailListActivity;
import com.cupidapp.live.feed.event.SwipeRefreshIsEnabledEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedPraiseLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedPraiseLayout extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f14474j = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public boolean f14475b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public b f14476c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14477d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FKWebpAnimationView f14478e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public ZoomImageView f14479f;

    /* renamed from: g, reason: collision with root package name */
    public float f14480g;

    /* renamed from: h, reason: collision with root package name */
    public float f14481h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14482i;

    /* compiled from: FeedPraiseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FeedPraiseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void h(boolean z10);
    }

    /* compiled from: FeedPraiseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements ZoomImageView.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f14484b;

        public c(ViewGroup viewGroup) {
            this.f14484b = viewGroup;
        }

        @Override // com.cupidapp.live.base.view.zoom.ZoomImageView.b
        public void a() {
            FeedPraiseLayout.this.g(this.f14484b);
        }
    }

    /* compiled from: FeedPraiseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements com.cupidapp.live.base.imageloader.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f14486b;

        public d(ViewGroup viewGroup) {
            this.f14486b = viewGroup;
        }

        @Override // com.cupidapp.live.base.imageloader.c
        public void a(@NotNull Drawable drawable) {
            kotlin.jvm.internal.s.i(drawable, "drawable");
            if (FeedPraiseLayout.this.f14479f == null || this.f14486b.indexOfChild(FeedPraiseLayout.this.f14479f) != -1) {
                return;
            }
            if (FeedPraiseLayout.this.i()) {
                b feedClickEventListener = FeedPraiseLayout.this.getFeedClickEventListener();
                if (feedClickEventListener != null) {
                    feedClickEventListener.h(true);
                }
                ZoomImageView zoomImageView = FeedPraiseLayout.this.f14479f;
                if (zoomImageView != null) {
                    zoomImageView.setVisibility(0);
                }
            } else {
                ZoomImageView zoomImageView2 = FeedPraiseLayout.this.f14479f;
                if (zoomImageView2 != null) {
                    zoomImageView2.setVisibility(8);
                }
            }
            this.f14486b.addView(FeedPraiseLayout.this.f14479f);
        }

        @Override // com.cupidapp.live.base.imageloader.c
        public void b() {
            FeedPraiseLayout.this.g(this.f14486b);
        }

        @Override // com.cupidapp.live.base.imageloader.c
        public void c(@NotNull Bitmap bitmap) {
            c.a.a(this, bitmap);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPraiseLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14482i = new LinkedHashMap();
    }

    private final int getPraiseLayoutYCoordinatesOnScreen() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return iArr[1];
    }

    private final float getYDiff() {
        float f10;
        float a10;
        int praiseLayoutYCoordinatesOnScreen = getPraiseLayoutYCoordinatesOnScreen();
        if (!(getContext() instanceof FeedDetailListActivity) && !(getContext() instanceof FeedDetailActivity)) {
            int m10 = z0.h.m(getContext());
            f10 = praiseLayoutYCoordinatesOnScreen - m10;
            a10 = ((z0.s.f54824a.a() - m10) - z0.h.f(getContext())) - getHeight();
        } else {
            f10 = praiseLayoutYCoordinatesOnScreen;
            a10 = (z0.s.f54824a.a() - z0.h.f(getContext())) - getHeight();
        }
        return f10 - (a10 / 2.0f);
    }

    public static final void l(FKWebpAnimationView subView, FeedPraiseLayout this$0) {
        kotlin.jvm.internal.s.i(subView, "$subView");
        kotlin.jvm.internal.s.i(this$0, "this$0");
        subView.i();
        this$0.removeAllViews();
        this$0.f14475b = false;
    }

    public final void e(@Nullable MotionEvent motionEvent, @Nullable ImageModel imageModel) {
        if (motionEvent == null) {
            return;
        }
        if ((motionEvent.getAction() & 255) == 5 && motionEvent.getPointerCount() == 2) {
            if (z0.h.g(getContext()) == NetworkStateConstants.DISCONNECT) {
                return;
            }
            if (this.f14475b || this.f14477d) {
                m();
            }
            this.f14479f = null;
            f(false);
            Context context = getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            ViewGroup viewGroup = activity != null ? (ViewGroup) activity.findViewById(16908290) : null;
            if (viewGroup == null) {
                return;
            }
            Context context2 = getContext();
            kotlin.jvm.internal.s.h(context2, "context");
            ZoomImageView zoomImageView = new ZoomImageView(context2);
            zoomImageView.F(getYDiff());
            zoomImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            zoomImageView.setOnTouchUpListener(new c(viewGroup));
            this.f14479f = zoomImageView;
            this.f14480g = h(motionEvent);
            zoomImageView.d(new com.cupidapp.live.base.imageloader.b(false, imageModel != null ? imageModel.getUrl(z0.h.l(this)) : null, null, null, null, null, null, 0, 0, null, TransformationType.FitCenter, null, null, false, getWidth(), getHeight(), false, null, null, 474109, null), new d(viewGroup));
        }
        if (motionEvent.getPointerCount() > 2) {
            Context context3 = getContext();
            Activity activity2 = context3 instanceof Activity ? (Activity) context3 : null;
            ViewGroup viewGroup2 = activity2 != null ? (ViewGroup) activity2.findViewById(16908290) : null;
            if (viewGroup2 == null) {
                return;
            }
            g(viewGroup2);
            return;
        }
        this.f14481h = h(motionEvent);
        ZoomImageView zoomImageView2 = this.f14479f;
        if (zoomImageView2 != null) {
            if (!(zoomImageView2 != null && zoomImageView2.getVisibility() == 0) && i()) {
                b bVar = this.f14476c;
                if (bVar != null) {
                    bVar.h(true);
                }
                ZoomImageView zoomImageView3 = this.f14479f;
                if (zoomImageView3 != null) {
                    zoomImageView3.setVisibility(0);
                }
            }
        }
        ZoomImageView zoomImageView4 = this.f14479f;
        if (zoomImageView4 != null) {
            zoomImageView4.s(motionEvent, getPraiseLayoutYCoordinatesOnScreen());
        }
    }

    public final void f(boolean z10) {
        CanScrollLinearLayoutManager.f12424a.b(z10);
        BaseViewPagerForShortVideo.f14428h.a(z10);
        EventBus.c().l(new SwipeRefreshIsEnabledEvent(z10));
    }

    public final void g(ViewGroup viewGroup) {
        b bVar = this.f14476c;
        if (bVar != null) {
            bVar.h(false);
        }
        f(true);
        viewGroup.removeView(this.f14479f);
        this.f14479f = null;
        this.f14480g = 0.0f;
        this.f14481h = 0.0f;
    }

    @Nullable
    public final b getFeedClickEventListener() {
        return this.f14476c;
    }

    public final float h(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 2) {
            return com.cupidapp.live.base.view.zoom.b.f13001a.b(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        }
        return 0.0f;
    }

    public final boolean i() {
        float f10 = this.f14481h;
        if (!(f10 == 0.0f)) {
            float f11 = this.f14480g;
            if (!(f11 == 0.0f) && Math.abs(f10 - f11) > 25.0f) {
                return true;
            }
        }
        return false;
    }

    public final void j(@NotNull String fileName) {
        kotlin.jvm.internal.s.i(fileName, "fileName");
        if (this.f14477d) {
            return;
        }
        removeAllViews();
        this.f14477d = true;
        if (this.f14478e == null) {
            Context context = getContext();
            kotlin.jvm.internal.s.h(context, "context");
            this.f14478e = new FKWebpAnimationView(context);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FKWebpAnimationView fKWebpAnimationView = this.f14478e;
        if (fKWebpAnimationView != null) {
            fKWebpAnimationView.setLayoutParams(layoutParams);
        }
        FKWebpAnimationView fKWebpAnimationView2 = this.f14478e;
        if (fKWebpAnimationView2 != null) {
            fKWebpAnimationView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        setBackgroundResource(R$drawable.shape_match_guide_bg);
        addView(this.f14478e);
        FKWebpAnimationView fKWebpAnimationView3 = this.f14478e;
        if (fKWebpAnimationView3 != null) {
            FKWebpAnimationView.d(fKWebpAnimationView3, fileName, 0, null, 4, null);
        }
    }

    public final void k(boolean z10, float f10, float f11) {
        if (this.f14475b) {
            return;
        }
        removeAllViews();
        this.f14475b = true;
        Context context = getContext();
        kotlin.jvm.internal.s.h(context, "context");
        final FKWebpAnimationView fKWebpAnimationView = new FKWebpAnimationView(context);
        int c4 = z0.h.c(this, 200.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c4, c4);
        if (z10) {
            float f12 = c4 / 2;
            fKWebpAnimationView.setX((getWidth() / 2) - f12);
            fKWebpAnimationView.setY((getHeight() / 2) - f12);
        } else {
            float f13 = c4 / 2;
            fKWebpAnimationView.setX(f10 - f13);
            fKWebpAnimationView.setY(f11 - f13);
        }
        fKWebpAnimationView.setLayoutParams(layoutParams);
        addView(fKWebpAnimationView);
        FKWebpAnimationView.d(fKWebpAnimationView, "short_video_praise_webp.webp", 0, null, 6, null);
        fKWebpAnimationView.postDelayed(new Runnable() { // from class: com.cupidapp.live.feed.layout.e
            @Override // java.lang.Runnable
            public final void run() {
                FeedPraiseLayout.l(FKWebpAnimationView.this, this);
            }
        }, 1000L);
    }

    public final void m() {
        if (this.f14477d) {
            this.f14477d = false;
            FKWebpAnimationView fKWebpAnimationView = this.f14478e;
            if (fKWebpAnimationView != null) {
                fKWebpAnimationView.i();
            }
            setBackgroundResource(0);
            removeAllViews();
        }
    }

    public final void setFeedClickEventListener(@Nullable b bVar) {
        this.f14476c = bVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPraiseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14482i = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPraiseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14482i = new LinkedHashMap();
    }
}
