package com.cupidapp.live.startup.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.video.ExoMediaPlayer;
import com.cupidapp.live.startup.model.AdImageModel;
import com.cupidapp.live.startup.model.AdVideoModel;
import com.cupidapp.live.startup.model.ApiAdContentModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: ApiAdDisplayView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ApiAdDisplayView extends FrameLayout implements DefaultLifecycleObserver {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public d f18545b;

    /* renamed from: c, reason: collision with root package name */
    public int f18546c;

    /* renamed from: d, reason: collision with root package name */
    public int f18547d;

    /* renamed from: e, reason: collision with root package name */
    public int f18548e;

    /* renamed from: f, reason: collision with root package name */
    public int f18549f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f18550g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18551h;

    /* compiled from: ApiAdDisplayView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18552a;

        static {
            int[] iArr = new int[FKVideoPlayState.values().length];
            try {
                iArr[FKVideoPlayState.RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FKVideoPlayState.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FKVideoPlayState.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f18552a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiAdDisplayView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18551h = new LinkedHashMap();
        h();
    }

    private final void setVideoPlayState(FKVideoPlayState fKVideoPlayState) {
        if (this.f18550g) {
            int i10 = a.f18552a[fKVideoPlayState.ordinal()];
            if (i10 == 1) {
                ExoMediaPlayer.f12408a.v();
                return;
            }
            if (i10 == 2) {
                ExoMediaPlayer.f12408a.p();
            } else {
                if (i10 != 3) {
                    return;
                }
                ((FrameLayout) a(R$id.start_up_api_video_container_layout)).removeAllViews();
                ExoMediaPlayer.f12408a.z();
            }
        }
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18551h;
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

    public final void g(@NotNull ApiAdContentModel model) {
        AdVideoModel adVideoModel;
        s.i(model, "model");
        this.f18550g = false;
        List<AdVideoModel> videos = model.getVideos();
        if (((videos == null || (adVideoModel = (AdVideoModel) CollectionsKt___CollectionsKt.V(videos)) == null) ? null : adVideoModel.getUrl()) != null) {
            this.f18550g = true;
            int i10 = R$id.start_up_api_video_container_layout;
            ((FrameLayout) a(i10)).removeAllViews();
            FrameLayout frameLayout = (FrameLayout) a(i10);
            ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
            frameLayout.addView(exoMediaPlayer.k(true));
            AdVideoModel adVideoModel2 = (AdVideoModel) CollectionsKt___CollectionsKt.V(model.getVideos());
            ExoMediaPlayer.t(exoMediaPlayer, adVideoModel2 != null ? adVideoModel2.getUrl() : null, true, null, false, 12, null);
            ((FrameLayout) a(i10)).setVisibility(0);
        } else {
            List<AdImageModel> imgs = model.getImgs();
            if (imgs != null && (imgs.isEmpty() ^ true)) {
                int i11 = R$id.start_up_api_image_view;
                ((ImageView) a(i11)).setVisibility(0);
                RequestManager with = Glide.with(getContext());
                AdImageModel adImageModel = (AdImageModel) CollectionsKt___CollectionsKt.V(model.getImgs());
                with.load(adImageModel != null ? adImageModel.getUrl() : null).override(h.l(this), h.k(this)).into((ImageView) a(i11));
            }
        }
        setVisibility(0);
        d dVar = this.f18545b;
        if (dVar != null) {
            dVar.a(this.f18550g);
        }
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.startup.view.ApiAdDisplayView$configData$1
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
                d dVar2;
                int i12;
                int i13;
                int i14;
                int i15;
                dVar2 = ApiAdDisplayView.this.f18545b;
                if (dVar2 != null) {
                    i12 = ApiAdDisplayView.this.f18546c;
                    Integer valueOf = Integer.valueOf(i12);
                    i13 = ApiAdDisplayView.this.f18547d;
                    Integer valueOf2 = Integer.valueOf(i13);
                    i14 = ApiAdDisplayView.this.f18549f;
                    Integer valueOf3 = Integer.valueOf(i14);
                    i15 = ApiAdDisplayView.this.f18548e;
                    dVar2.b(valueOf, valueOf2, valueOf3, Integer.valueOf(i15));
                }
            }
        });
    }

    public final void h() {
        z.a(this, R$layout.view_ad_api_display, true);
        setVisibility(4);
        ((FrameLayout) a(R$id.start_up_api_video_container_layout)).setVisibility(8);
        ((ImageView) a(R$id.start_up_api_image_view)).setVisibility(8);
    }

    public final void i(@Nullable LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver(this);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        setVideoPlayState(FKVideoPlayState.STOP);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        setVideoPlayState(FKVideoPlayState.PAUSE);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        setVideoPlayState(FKVideoPlayState.RESUME);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.f(this, lifecycleOwner);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        if ((r5 != null && r5.getAction() == 3) != false) goto L22;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable android.view.MotionEvent r5) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 == 0) goto Lc
            int r2 = r5.getAction()
            if (r2 != 0) goto Lc
            r2 = 1
            goto Ld
        Lc:
            r2 = 0
        Ld:
            if (r2 == 0) goto L1e
            float r0 = r5.getX()
            int r0 = (int) r0
            r4.f18546c = r0
            float r0 = r5.getY()
            int r0 = (int) r0
            r4.f18547d = r0
            goto L46
        L1e:
            if (r5 == 0) goto L28
            int r2 = r5.getAction()
            if (r2 != r0) goto L28
            r2 = 1
            goto L29
        L28:
            r2 = 0
        L29:
            if (r2 != 0) goto L38
            if (r5 == 0) goto L35
            int r2 = r5.getAction()
            r3 = 3
            if (r2 != r3) goto L35
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 == 0) goto L46
        L38:
            float r0 = r5.getX()
            int r0 = (int) r0
            r4.f18549f = r0
            float r0 = r5.getY()
            int r0 = (int) r0
            r4.f18548e = r0
        L46:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.startup.view.ApiAdDisplayView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setListener(@NotNull d adListener) {
        s.i(adListener, "adListener");
        this.f18545b = adListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiAdDisplayView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18551h = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiAdDisplayView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18551h = new LinkedHashMap();
        h();
    }
}
