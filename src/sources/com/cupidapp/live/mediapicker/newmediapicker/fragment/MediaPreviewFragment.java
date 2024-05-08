package com.cupidapp.live.mediapicker.newmediapicker.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.mediapicker.newmediapicker.adapter.MediaPreviewPagerAdapter;
import com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData;
import com.cupidapp.live.mediapicker.newmediapicker.data.PreviewMediaData;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment;
import com.cupidapp.live.mediapicker.newmediapicker.loader.LocalMediaLoader;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMediaPicked;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.mediapicker.newmediapicker.model.MimeType;
import com.cupidapp.live.mediapicker.newmediapicker.view.ImagePreviewBarLayout;
import com.cupidapp.live.mediapicker.view.MediaCheckedView;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z0.y;
import z0.z;

/* compiled from: MediaPreviewFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaPreviewFragment extends FKBaseFragment implements ViewPager.OnPageChangeListener, MediaPreviewPagerAdapter.a {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f17298l = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public MediaPreviewPagerAdapter f17300f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public b f17301g;

    /* renamed from: h, reason: collision with root package name */
    public int f17302h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f17304j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17305k = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Config f17299e = new Config(false, false, 0, 0, null, 0, 63, null);

    /* renamed from: i, reason: collision with root package name */
    public int f17303i = 1;

    /* compiled from: MediaPreviewFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MediaPreviewFragment a(@NotNull Config config, @NotNull b listener) {
            s.i(config, "config");
            s.i(listener, "listener");
            MediaPreviewFragment mediaPreviewFragment = new MediaPreviewFragment();
            Bundle bundle = new Bundle();
            g.d(bundle, config);
            mediaPreviewFragment.setArguments(bundle);
            mediaPreviewFragment.f17301g = listener;
            return mediaPreviewFragment;
        }
    }

    /* compiled from: MediaPreviewFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a();

        void b(@NotNull MediaType mediaType, @NotNull List<String> list);
    }

    /* compiled from: MediaPreviewFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f17307b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f17308c;

        public c(View view, int i10) {
            this.f17307b = view;
            this.f17308c = i10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            s.i(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            View view = this.f17307b;
            if (view == null) {
                return;
            }
            view.setVisibility(this.f17308c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            s.i(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            s.i(animation, "animation");
        }
    }

    public static final void k1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void n1(MediaPreviewFragment mediaPreviewFragment, View view, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        if ((i11 & 4) != 0) {
            i10 = 8;
        }
        mediaPreviewFragment.m1(view, z10, i10);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17305k.clear();
    }

    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17305k;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void f1() {
        ImageView previewBack = (ImageView) T0(R$id.previewBack);
        s.h(previewBack, "previewBack");
        y.d(previewBack, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment$bindClick$1
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
                MediaPreviewFragment.b bVar;
                bVar = MediaPreviewFragment.this.f17301g;
                if (bVar != null) {
                    bVar.a();
                }
            }
        });
        int i10 = R$id.previewImageBar;
        ((ImagePreviewBarLayout) T0(i10)).setCompleteClick(new Function0<p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment$bindClick$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
            
                r1 = r3.this$0.f17301g;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2() {
                /*
                    r3 = this;
                    com.cupidapp.live.mediapicker.newmediapicker.data.PreviewMediaData r0 = com.cupidapp.live.mediapicker.newmediapicker.data.PreviewMediaData.INSTANCE
                    com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment r1 = com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment.this
                    int r1 = com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment.Y0(r1)
                    com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia r0 = r0.get(r1)
                    com.cupidapp.live.mediapicker.newmediapicker.model.MimeType$a r1 = com.cupidapp.live.mediapicker.newmediapicker.model.MimeType.Companion
                    java.lang.String r2 = r0.c()
                    boolean r1 = r1.b(r2)
                    if (r1 == 0) goto L30
                    java.lang.String r0 = r0.d()
                    if (r0 == 0) goto L43
                    com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment r1 = com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment.this
                    com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment$b r1 = com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment.U0(r1)
                    if (r1 == 0) goto L43
                    com.cupidapp.live.mediapicker.newmediapicker.model.MediaType r2 = com.cupidapp.live.mediapicker.newmediapicker.model.MediaType.VIDEO
                    java.util.List r0 = kotlin.collections.r.e(r0)
                    r1.b(r2, r0)
                    goto L43
                L30:
                    com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment r0 = com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment.this
                    com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment$b r0 = com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment.U0(r0)
                    if (r0 == 0) goto L43
                    com.cupidapp.live.mediapicker.newmediapicker.model.MediaType r1 = com.cupidapp.live.mediapicker.newmediapicker.model.MediaType.IMAGE
                    com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData r2 = com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData.INSTANCE
                    java.util.List r2 = r2.getPathList()
                    r0.b(r1, r2)
                L43:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment$bindClick$2.invoke2():void");
            }
        });
        ((ImagePreviewBarLayout) T0(i10)).setItemClick(new Function2<LocalMediaPicked, Integer, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment$bindClick$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(LocalMediaPicked localMediaPicked, Integer num) {
                invoke(localMediaPicked, num.intValue());
                return p.f51048a;
            }

            public final void invoke(@NotNull LocalMediaPicked model, int i11) {
                MediaPreviewFragment.Config config;
                MediaPreviewFragment.Config config2;
                s.i(model, "model");
                int index = PreviewMediaData.INSTANCE.index(model.getMedia());
                config = MediaPreviewFragment.this.f17299e;
                if (config.getFromPreviewBar()) {
                    ((ViewPager) MediaPreviewFragment.this.T0(R$id.previewViewpager)).setCurrentItem(index, false);
                    return;
                }
                config2 = MediaPreviewFragment.this.f17299e;
                if (config2.getBucketId() == model.getBucketId()) {
                    ((ViewPager) MediaPreviewFragment.this.T0(R$id.previewViewpager)).setCurrentItem(index, false);
                }
            }
        });
        MediaCheckedView previewCheckBox = (MediaCheckedView) T0(R$id.previewCheckBox);
        s.h(previewCheckBox, "previewCheckBox");
        y.d(previewCheckBox, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment$bindClick$4

            /* compiled from: MediaPreviewFragment.kt */
            @d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public static final class a implements ImagePickedData.OnPickedStatusChangedListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ MediaPreviewFragment f17306a;

                public a(MediaPreviewFragment mediaPreviewFragment) {
                    this.f17306a = mediaPreviewFragment;
                }

                @Override // com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData.OnPickedStatusChangedListener
                public void a() {
                    FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this.f17306a.getContext(), false, 2, null), R$string.at_most_choose_pic, 0, 2, null), R$string.all_right, null, null, 6, null), null, 1, null);
                }

                @Override // com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData.OnPickedStatusChangedListener
                public void b(int i10) {
                    int i11 = i10 - 1;
                    MediaPreviewFragment mediaPreviewFragment = this.f17306a;
                    int i12 = R$id.previewImageBar;
                    ((ImagePreviewBarLayout) mediaPreviewFragment.T0(i12)).e(i11);
                    ((ImagePreviewBarLayout) this.f17306a.T0(i12)).setCheckedItem(Integer.valueOf(i11));
                    ((Button) ((ImagePreviewBarLayout) this.f17306a.T0(i12)).a(R$id.previewComplete)).setVisibility(0);
                    ((ImagePreviewBarLayout) this.f17306a.T0(i12)).setCompleteText(this.f17306a.getText(R$string.complete).toString());
                    MediaPreviewFragment mediaPreviewFragment2 = this.f17306a;
                    int i13 = R$id.previewBottomLayout;
                    if (((RelativeLayout) mediaPreviewFragment2.T0(i13)).getVisibility() == 8 && i10 == 1) {
                        MediaPreviewFragment mediaPreviewFragment3 = this.f17306a;
                        mediaPreviewFragment3.m1((RelativeLayout) mediaPreviewFragment3.T0(i13), true, 0);
                    }
                    ((MediaCheckedView) this.f17306a.T0(R$id.previewCheckBox)).setCheckBoxNum(i11);
                }

                @Override // com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData.OnPickedStatusChangedListener
                public void onRemoved(int i10, int i11) {
                    ImagePreviewBarLayout imagePreviewBarLayout = (ImagePreviewBarLayout) this.f17306a.T0(R$id.previewImageBar);
                    if (i10 == i11) {
                        i10 = i11 - 1;
                    }
                    imagePreviewBarLayout.e(i10);
                    MediaPreviewFragment mediaPreviewFragment = this.f17306a;
                    int i12 = R$id.previewBottomLayout;
                    if (((RelativeLayout) mediaPreviewFragment.T0(i12)).getVisibility() == 0 && i11 == 0) {
                        MediaPreviewFragment mediaPreviewFragment2 = this.f17306a;
                        MediaPreviewFragment.n1(mediaPreviewFragment2, (RelativeLayout) mediaPreviewFragment2.T0(i12), false, 0, 4, null);
                    }
                    ((MediaCheckedView) this.f17306a.T0(R$id.previewCheckBox)).c();
                }
            }

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
                MediaPreviewFragment.Config config;
                int i11;
                int i12;
                config = MediaPreviewFragment.this.f17299e;
                long bucketId = config.getBucketId();
                i11 = MediaPreviewFragment.this.f17302h;
                PreviewMediaData previewMediaData = PreviewMediaData.INSTANCE;
                i12 = MediaPreviewFragment.this.f17302h;
                ImagePickedData.INSTANCE.pick(new LocalMediaPicked(bucketId, i11, previewMediaData.get(i12)), new a(MediaPreviewFragment.this));
            }
        });
    }

    public final void g1() {
        n1(this, (RelativeLayout) T0(R$id.previewTitleBar), true, 0, 4, null);
        n1(this, (RelativeLayout) T0(R$id.previewBottomLayout), false, 0, 4, null);
    }

    public final void h1(@NotNull Config config) {
        s.i(config, "config");
        boolean z10 = true;
        boolean z11 = this.f17299e.getPosition() == config.getPosition();
        this.f17299e = config;
        this.f17303i = config.getPage();
        MediaPreviewPagerAdapter mediaPreviewPagerAdapter = this.f17300f;
        if (mediaPreviewPagerAdapter != null) {
            mediaPreviewPagerAdapter.b();
        }
        int i10 = R$id.previewImageBar;
        ((ImagePreviewBarLayout) T0(i10)).setBackground(h.a(-16777216, 0.5f));
        ((ImagePreviewBarLayout) T0(i10)).e(-1);
        if (config.getFromPreviewBar()) {
            ImagePickedData.INSTANCE.updatePreviewList();
        }
        int position = config.getPosition();
        PreviewMediaData previewMediaData = PreviewMediaData.INSTANCE;
        if (position >= previewMediaData.size()) {
            return;
        }
        LocalMedia localMedia = previewMediaData.get(config.getPosition());
        if (ImagePickedData.INSTANCE.isEmpty() && !MimeType.Companion.b(localMedia.c())) {
            z10 = false;
        }
        ((RelativeLayout) T0(R$id.previewBottomLayout)).setVisibility(z10 ? 0 : 8);
        ((ViewPager) T0(R$id.previewViewpager)).setCurrentItem(config.getPosition(), false);
        if (z11) {
            q1(config.getPosition());
        }
    }

    public final void i1() {
        if (Build.VERSION.SDK_INT >= 23) {
            int i10 = R$id.statusBar;
            ViewGroup.LayoutParams layoutParams = T0(i10).getLayoutParams();
            layoutParams.height = z0.h.m(getContext());
            T0(i10).setLayoutParams(layoutParams);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        s.h(childFragmentManager, "childFragmentManager");
        this.f17300f = new MediaPreviewPagerAdapter(this, 0, childFragmentManager, 2, null);
        int i11 = R$id.previewViewpager;
        ((ViewPager) T0(i11)).setAdapter(this.f17300f);
        ((ViewPager) T0(i11)).addOnPageChangeListener(this);
    }

    public final void j1() {
        if (this.f17304j) {
            return;
        }
        LocalMediaLoader localMediaLoader = LocalMediaLoader.f17323a;
        Context context = getContext();
        Observable<List<LocalMedia>> q10 = localMediaLoader.q(context != null ? context.getApplicationContext() : null, this.f17299e.getMediaType(), this.f17299e.getBucketId(), this.f17303i);
        final Function1<List<LocalMedia>, p> function1 = new Function1<List<LocalMedia>, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment$loadNextPageMediaDataInFolder$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<LocalMedia> list) {
                invoke2(list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<LocalMedia> mediaList) {
                int i10;
                MediaPreviewPagerAdapter mediaPreviewPagerAdapter;
                MediaPreviewFragment mediaPreviewFragment = MediaPreviewFragment.this;
                i10 = mediaPreviewFragment.f17303i;
                mediaPreviewFragment.f17303i = i10 + 1;
                if (mediaList.size() == 0) {
                    MediaPreviewFragment.this.f17304j = true;
                    return;
                }
                PreviewMediaData previewMediaData = PreviewMediaData.INSTANCE;
                s.h(mediaList, "mediaList");
                previewMediaData.addList(mediaList);
                mediaPreviewPagerAdapter = MediaPreviewFragment.this.f17300f;
                if (mediaPreviewPagerAdapter != null) {
                    mediaPreviewPagerAdapter.b();
                }
            }
        };
        Disposable subscribe = q10.subscribe(new Consumer() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MediaPreviewFragment.k1(Function1.this, obj);
            }
        });
        s.h(subscribe, "private fun loadNextPage…        }\n        )\n    }");
        H(subscribe);
    }

    public final void l1() {
        MediaPreviewItemFragment a10;
        MediaPreviewPagerAdapter mediaPreviewPagerAdapter = this.f17300f;
        if (mediaPreviewPagerAdapter == null || (a10 = mediaPreviewPagerAdapter.a()) == null) {
            return;
        }
        a10.Y0();
    }

    public final void m1(View view, boolean z10, int i10) {
        if (view != null && view.getVisibility() == i10) {
            return;
        }
        if (view != null) {
            view.setVisibility(0);
        }
        float f10 = 0.0f;
        float f11 = 1.0f;
        if (!z10) {
            f10 = 1.0f;
            f11 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.TRANSLATION_Y, f10, f11);
        ofFloat.setDuration(100L);
        ofFloat.addListener(new c(view, i10));
        ofFloat.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (com.cupidapp.live.mediapicker.newmediapicker.model.MimeType.Companion.b(r0.get(r3).c()) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void o1() {
        /*
            r4 = this;
            com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData r0 = com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData.INSTANCE
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto L23
            com.cupidapp.live.mediapicker.newmediapicker.data.PreviewMediaData r0 = com.cupidapp.live.mediapicker.newmediapicker.data.PreviewMediaData.INSTANCE
            int r2 = r0.size()
            int r3 = r4.f17302h
            if (r2 <= r3) goto L2f
            com.cupidapp.live.mediapicker.newmediapicker.model.MimeType$a r2 = com.cupidapp.live.mediapicker.newmediapicker.model.MimeType.Companion
            com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia r0 = r0.get(r3)
            java.lang.String r0 = r0.c()
            boolean r0 = r2.b(r0)
            if (r0 == 0) goto L2f
        L23:
            int r0 = com.cupidapp.live.R$id.previewBottomLayout
            android.view.View r0 = r4.T0(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r2 = 1
            r4.m1(r0, r2, r1)
        L2f:
            int r0 = com.cupidapp.live.R$id.previewTitleBar
            android.view.View r0 = r4.T0(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r4.m1(r0, r1, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment.o1():void");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        if (viewGroup != null) {
            return z.b(viewGroup, R$layout.fragment_media_picker_preview, false, 2, null);
        }
        return null;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i10, float f10, int i11) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i10) {
        if (this.f17302h != i10) {
            q1(i10);
        }
        this.f17302h = i10;
        if (this.f17304j) {
            return;
        }
        int i11 = i10 + 5;
        PreviewMediaData previewMediaData = PreviewMediaData.INSTANCE;
        if (i11 == previewMediaData.size() || i10 + 1 == previewMediaData.size()) {
            j1();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Config config;
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (config = (Config) g.b(arguments, Config.class)) == null) {
            return;
        }
        i1();
        if (PreviewMediaData.INSTANCE.size() == 0) {
            b bVar = this.f17301g;
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        h1(config);
        f1();
    }

    public final void p1(LocalMedia localMedia, int i10) {
        if (localMedia != null) {
            if (MimeType.Companion.b(localMedia.c())) {
                ((MediaCheckedView) T0(R$id.previewCheckBox)).setVisibility(8);
                ImagePickedData imagePickedData = ImagePickedData.INSTANCE;
                if (imagePickedData.size() <= 0) {
                    ((TextView) T0(R$id.previewVideoTips)).setVisibility(8);
                    m1((RelativeLayout) T0(R$id.previewBottomLayout), true, 0);
                    if (localMedia.a() < com.huawei.openalliance.ad.ipc.c.Code) {
                        ((Button) ((ImagePreviewBarLayout) T0(R$id.previewImageBar)).a(R$id.previewComplete)).setVisibility(8);
                        int i11 = R$id.previewVideoCutTips;
                        ((TextView) T0(i11)).setVisibility(0);
                        ((TextView) T0(i11)).setText(getString(R$string.cant_choose_less_than_three_seconds_video));
                        return;
                    }
                    if (localMedia.a() > 60000) {
                        int i12 = R$id.previewImageBar;
                        ((ImagePreviewBarLayout) T0(i12)).setCompleteText("截取");
                        ((Button) ((ImagePreviewBarLayout) T0(i12)).a(R$id.previewComplete)).setVisibility(0);
                        int i13 = R$id.previewVideoCutTips;
                        ((TextView) T0(i13)).setVisibility(0);
                        ((TextView) T0(i13)).setText(getText(R$string.preview_video_cut_tips));
                        return;
                    }
                    int i14 = R$id.previewImageBar;
                    ((ImagePreviewBarLayout) T0(i14)).setCompleteText(getText(R$string.complete).toString());
                    ((Button) ((ImagePreviewBarLayout) T0(i14)).a(R$id.previewComplete)).setVisibility(0);
                    ((TextView) T0(R$id.previewVideoCutTips)).setVisibility(8);
                    return;
                }
                ((TextView) T0(R$id.previewVideoTips)).setVisibility(0);
                ((TextView) T0(R$id.previewVideoCutTips)).setVisibility(8);
                ((Button) ((ImagePreviewBarLayout) T0(R$id.previewImageBar)).a(R$id.previewComplete)).setVisibility(imagePickedData.isEmpty() ? 8 : 0);
                return;
            }
            ((TextView) T0(R$id.previewVideoTips)).setVisibility(8);
            ((TextView) T0(R$id.previewVideoCutTips)).setVisibility(8);
            if (this.f17299e.getPickMultiplePhotos()) {
                int i15 = R$id.previewCheckBox;
                ((MediaCheckedView) T0(i15)).setVisibility(0);
                if (i10 == -1) {
                    ((MediaCheckedView) T0(i15)).c();
                } else {
                    ((MediaCheckedView) T0(i15)).setCheckBoxNum(i10);
                }
                int i16 = R$id.previewImageBar;
                ((ImagePreviewBarLayout) T0(i16)).setCompleteText(getText(R$string.complete).toString());
                if (ImagePickedData.INSTANCE.isEmpty()) {
                    n1(this, (RelativeLayout) T0(R$id.previewBottomLayout), false, 0, 4, null);
                } else {
                    ((Button) ((ImagePreviewBarLayout) T0(i16)).a(R$id.previewComplete)).setVisibility(0);
                }
            }
        }
    }

    public final void q1(int i10) {
        if (((RelativeLayout) T0(R$id.previewTitleBar)).getVisibility() == 8) {
            o1();
        }
        LocalMedia localMedia = PreviewMediaData.INSTANCE.get(i10);
        int index = ImagePickedData.INSTANCE.index(localMedia);
        ((ImagePreviewBarLayout) T0(R$id.previewImageBar)).setCheckedItem(Integer.valueOf(index));
        p1(localMedia, index);
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.adapter.MediaPreviewPagerAdapter.a
    public void t0(@Nullable MediaPreviewItemFragment mediaPreviewItemFragment, @NotNull MediaPreviewItemFragment newFragment) {
        s.i(newFragment, "newFragment");
        if (mediaPreviewItemFragment != null) {
            mediaPreviewItemFragment.Y0();
        }
        newFragment.Z0(new Function1<Boolean, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment$currentFragmentIsChanged$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke2(bool);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Boolean bool) {
                if (bool != null) {
                    if (bool.booleanValue()) {
                        MediaPreviewFragment.this.g1();
                        return;
                    } else {
                        MediaPreviewFragment.this.o1();
                        return;
                    }
                }
                RelativeLayout relativeLayout = (RelativeLayout) MediaPreviewFragment.this.T0(R$id.previewTitleBar);
                boolean z10 = false;
                if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
                    z10 = true;
                }
                if (z10) {
                    MediaPreviewFragment.this.g1();
                } else {
                    MediaPreviewFragment.this.o1();
                }
            }
        });
    }

    /* compiled from: MediaPreviewFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Config implements Serializable {
        private final long bucketId;
        private final boolean fromPreviewBar;

        @NotNull
        private final MediaType mediaType;
        private final int page;
        private final boolean pickMultiplePhotos;
        private final int position;

        public Config() {
            this(false, false, 0, 0L, null, 0, 63, null);
        }

        public Config(boolean z10, boolean z11, int i10, long j10, @NotNull MediaType mediaType, int i11) {
            s.i(mediaType, "mediaType");
            this.pickMultiplePhotos = z10;
            this.fromPreviewBar = z11;
            this.position = i10;
            this.bucketId = j10;
            this.mediaType = mediaType;
            this.page = i11;
        }

        public static /* synthetic */ Config copy$default(Config config, boolean z10, boolean z11, int i10, long j10, MediaType mediaType, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                z10 = config.pickMultiplePhotos;
            }
            if ((i12 & 2) != 0) {
                z11 = config.fromPreviewBar;
            }
            boolean z12 = z11;
            if ((i12 & 4) != 0) {
                i10 = config.position;
            }
            int i13 = i10;
            if ((i12 & 8) != 0) {
                j10 = config.bucketId;
            }
            long j11 = j10;
            if ((i12 & 16) != 0) {
                mediaType = config.mediaType;
            }
            MediaType mediaType2 = mediaType;
            if ((i12 & 32) != 0) {
                i11 = config.page;
            }
            return config.copy(z10, z12, i13, j11, mediaType2, i11);
        }

        public final boolean component1() {
            return this.pickMultiplePhotos;
        }

        public final boolean component2() {
            return this.fromPreviewBar;
        }

        public final int component3() {
            return this.position;
        }

        public final long component4() {
            return this.bucketId;
        }

        @NotNull
        public final MediaType component5() {
            return this.mediaType;
        }

        public final int component6() {
            return this.page;
        }

        @NotNull
        public final Config copy(boolean z10, boolean z11, int i10, long j10, @NotNull MediaType mediaType, int i11) {
            s.i(mediaType, "mediaType");
            return new Config(z10, z11, i10, j10, mediaType, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return this.pickMultiplePhotos == config.pickMultiplePhotos && this.fromPreviewBar == config.fromPreviewBar && this.position == config.position && this.bucketId == config.bucketId && this.mediaType == config.mediaType && this.page == config.page;
        }

        public final long getBucketId() {
            return this.bucketId;
        }

        public final boolean getFromPreviewBar() {
            return this.fromPreviewBar;
        }

        @NotNull
        public final MediaType getMediaType() {
            return this.mediaType;
        }

        public final int getPage() {
            return this.page;
        }

        public final boolean getPickMultiplePhotos() {
            return this.pickMultiplePhotos;
        }

        public final int getPosition() {
            return this.position;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        public int hashCode() {
            boolean z10 = this.pickMultiplePhotos;
            ?? r02 = z10;
            if (z10) {
                r02 = 1;
            }
            int i10 = r02 * 31;
            boolean z11 = this.fromPreviewBar;
            return ((((((((i10 + (z11 ? 1 : z11 ? 1 : 0)) * 31) + this.position) * 31) + b2.a.a(this.bucketId)) * 31) + this.mediaType.hashCode()) * 31) + this.page;
        }

        @NotNull
        public String toString() {
            boolean z10 = this.pickMultiplePhotos;
            boolean z11 = this.fromPreviewBar;
            int i10 = this.position;
            long j10 = this.bucketId;
            MediaType mediaType = this.mediaType;
            return "Config(pickMultiplePhotos=" + z10 + ", fromPreviewBar=" + z11 + ", position=" + i10 + ", bucketId=" + j10 + ", mediaType=" + ((Object) mediaType) + ", page=" + this.page + ")";
        }

        public /* synthetic */ Config(boolean z10, boolean z11, int i10, long j10, MediaType mediaType, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? true : z10, (i12 & 2) != 0 ? false : z11, (i12 & 4) == 0 ? i10 : 0, (i12 & 8) != 0 ? -2L : j10, (i12 & 16) != 0 ? MediaType.ALL : mediaType, (i12 & 32) != 0 ? 1 : i11);
        }
    }
}
