package com.cupidapp.live.mediapicker.newmediapicker.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.newmediapicker.adapter.MediaFolderAdapter;
import com.cupidapp.live.mediapicker.newmediapicker.adapter.MediaPickerAdapter;
import com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData;
import com.cupidapp.live.mediapicker.newmediapicker.data.PreviewMediaData;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.loader.LocalMediaLoader;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMediaFolder;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMediaPicked;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.mediapicker.newmediapicker.model.MimeType;
import com.cupidapp.live.mediapicker.newmediapicker.view.ImagePreviewBarLayout;
import com.cupidapp.live.mediapicker.view.MediaGridItemDecoration;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: MediaPickerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaPickerFragment extends FKBaseFragment {

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public static final a f17279p = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public MediaFolderAdapter f17280e;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public MediaPickerAdapter f17282g;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public b f17284i;

    /* renamed from: j, reason: collision with root package name */
    public long f17285j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f17286k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f17288m;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17290o = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    public long f17281f = -1;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Config f17283h = new Config(null, false, false, false, false, null, null, null, 255, null);

    /* renamed from: l, reason: collision with root package name */
    public int f17287l = 1;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public final Lazy f17289n = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final MediaPickerFragment mediaPickerFragment = MediaPickerFragment.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$loadMoreListener$2.1
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
                    MediaPickerFragment.this.B1();
                }
            });
        }
    });

    /* compiled from: MediaPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MediaPickerFragment a(@Nullable FragmentActivity fragmentActivity, @Nullable Integer num, @NotNull b listener, @NotNull Config config, int i10, int i11) {
            s.i(listener, "listener");
            s.i(config, "config");
            MediaPickerFragment b4 = b(config, listener);
            if (fragmentActivity != null && num != null) {
                fragmentActivity.getSupportFragmentManager().beginTransaction().setCustomAnimations(i10, 0, 0, i11).add(num.intValue(), b4).commit();
            }
            return b4;
        }

        @NotNull
        public final MediaPickerFragment b(@NotNull Config config, @NotNull b listener) {
            s.i(config, "config");
            s.i(listener, "listener");
            MediaPickerFragment mediaPickerFragment = new MediaPickerFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, config);
            mediaPickerFragment.setArguments(bundle);
            mediaPickerFragment.f17284i = listener;
            return mediaPickerFragment;
        }
    }

    /* compiled from: MediaPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {

        /* compiled from: MediaPickerFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a {
            public static void a(@NotNull b bVar, @NotNull List<String> pathList) {
                s.i(pathList, "pathList");
            }

            public static void b(@NotNull b bVar) {
            }

            public static void c(@NotNull b bVar, @NotNull LocalMedia media, int i10) {
                s.i(media, "media");
            }

            public static void d(@NotNull b bVar, long j10, int i10, int i11) {
            }

            public static void e(@NotNull b bVar, int i10) {
            }
        }

        void a();

        void b(int i10);

        void c(@NotNull List<String> list);

        void d(long j10, int i10, int i11);

        void e(@NotNull LocalMedia localMedia, int i10);

        void f();
    }

    /* compiled from: MediaPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements ImagePreviewBarLayout.a {
        public c() {
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.view.ImagePreviewBarLayout.a
        public void onFinish() {
            MediaPickerAdapter mediaPickerAdapter = MediaPickerFragment.this.f17282g;
            if (mediaPickerAdapter != null) {
                mediaPickerAdapter.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: MediaPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            s.i(animation, "animation");
            RelativeLayout relativeLayout = (RelativeLayout) MediaPickerFragment.this.U0(R$id.mediaFolderPickerLayout);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            if (MediaPickerFragment.this.f17286k) {
                MediaPickerAdapter mediaPickerAdapter = MediaPickerFragment.this.f17282g;
                if (mediaPickerAdapter != null) {
                    int n10 = mediaPickerAdapter.n();
                    mediaPickerAdapter.u();
                    mediaPickerAdapter.notifyItemRangeRemoved(0, n10);
                }
                MediaPickerFragment.this.y1();
                MediaPickerFragment.this.f17286k = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            s.i(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            s.i(animation, "animation");
            RelativeLayout relativeLayout = (RelativeLayout) MediaPickerFragment.this.U0(R$id.mediaFolderPickerLayout);
            if (relativeLayout == null) {
                return;
            }
            relativeLayout.setEnabled(false);
        }
    }

    /* compiled from: MediaPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e implements ImagePreviewBarLayout.a {
        public e() {
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.view.ImagePreviewBarLayout.a
        public void onFinish() {
            MediaPickerAdapter mediaPickerAdapter = MediaPickerFragment.this.f17282g;
            if (mediaPickerAdapter != null) {
                mediaPickerAdapter.notifyDataSetChanged();
            }
            MediaPickerFragment.this.L1(h.c(this, 90.0f));
        }
    }

    /* compiled from: MediaPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f implements Animation.AnimationListener {
        public f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            s.i(animation, "animation");
            ((RelativeLayout) MediaPickerFragment.this.U0(R$id.mediaFolderPickerLayout)).setEnabled(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            s.i(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            s.i(animation, "animation");
            ((RelativeLayout) MediaPickerFragment.this.U0(R$id.mediaFolderPickerLayout)).setEnabled(false);
        }
    }

    /* compiled from: MediaPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class g implements ImagePickedData.OnPickedStatusChangedListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f17296b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f17297c;

        public g(int i10, int i11) {
            this.f17296b = i10;
            this.f17297c = i11;
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData.OnPickedStatusChangedListener
        public void a() {
            FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, MediaPickerFragment.this.getContext(), false, 2, null), R$string.at_most_choose_pic, 0, 2, null), R$string.all_right, null, null, 6, null), null, 1, null);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData.OnPickedStatusChangedListener
        public void b(int i10) {
            ((ImagePreviewBarLayout) MediaPickerFragment.this.U0(R$id.previewImageBar)).e(i10 - 1);
            if (MediaPickerFragment.this.f17283h.getMediaType() != MediaType.VIDEO && i10 == 1) {
                MediaPickerFragment.this.H1();
                return;
            }
            MediaPickerAdapter mediaPickerAdapter = MediaPickerFragment.this.f17282g;
            if (mediaPickerAdapter != null) {
                mediaPickerAdapter.notifyItemChanged(this.f17296b);
            }
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData.OnPickedStatusChangedListener
        public void onRemoved(int i10, int i11) {
            MediaPickerAdapter mediaPickerAdapter;
            ((ImagePreviewBarLayout) MediaPickerFragment.this.U0(R$id.previewImageBar)).e(i10 == i11 ? i11 - 1 : i10);
            if (MediaPickerFragment.this.f17283h.getMediaType() != MediaType.VIDEO && i11 == 0) {
                MediaPickerFragment.this.t1();
                return;
            }
            MediaPickerAdapter mediaPickerAdapter2 = MediaPickerFragment.this.f17282g;
            if (mediaPickerAdapter2 != null) {
                mediaPickerAdapter2.notifyItemChanged(this.f17296b);
            }
            List<LocalMediaPicked> subList = ImagePickedData.INSTANCE.getSubList(i10);
            MediaPickerFragment mediaPickerFragment = MediaPickerFragment.this;
            int i12 = this.f17297c;
            for (LocalMediaPicked localMediaPicked : subList) {
                if (localMediaPicked.getBucketId() == mediaPickerFragment.f17281f && (mediaPickerAdapter = mediaPickerFragment.f17282g) != null) {
                    mediaPickerAdapter.notifyItemChanged(localMediaPicked.getPositionInFolder() + i12);
                }
            }
        }
    }

    public static final void A1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void C1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void G1(MediaPickerFragment mediaPickerFragment, Config config, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        mediaPickerFragment.F1(config, z10);
    }

    public final void B1() {
        if (this.f17288m) {
            return;
        }
        LocalMediaLoader localMediaLoader = LocalMediaLoader.f17323a;
        Context context = getContext();
        Observable<List<LocalMedia>> q10 = localMediaLoader.q(context != null ? context.getApplicationContext() : null, this.f17283h.getMediaType(), this.f17281f, this.f17287l);
        final Function1<List<LocalMedia>, p> function1 = new Function1<List<LocalMedia>, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$loadNextPageMediaDataInFolder$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<LocalMedia> list) {
                invoke2(list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<LocalMedia> list) {
                FKLoadMoreListener w12;
                int i10;
                w12 = MediaPickerFragment.this.w1();
                w12.c(false);
                MediaPickerFragment mediaPickerFragment = MediaPickerFragment.this;
                i10 = mediaPickerFragment.f17287l;
                mediaPickerFragment.f17287l = i10 + 1;
                if (list.size() == 0) {
                    MediaPickerFragment.this.f17288m = true;
                    return;
                }
                MediaPickerAdapter mediaPickerAdapter = MediaPickerFragment.this.f17282g;
                if (mediaPickerAdapter != null) {
                    int n10 = mediaPickerAdapter.n();
                    mediaPickerAdapter.e(list);
                    mediaPickerAdapter.notifyItemRangeInserted(n10, mediaPickerAdapter.n());
                }
            }
        };
        Disposable subscribe = q10.subscribe(new Consumer() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MediaPickerFragment.C1(Function1.this, obj);
            }
        });
        s.h(subscribe, "private fun loadNextPage…   }\n            })\n    }");
        H(subscribe);
    }

    public final void D1() {
        if (ImagePickedData.INSTANCE.isEmpty()) {
            ImagePreviewBarLayout imagePreviewBarLayout = (ImagePreviewBarLayout) U0(R$id.previewImageBar);
            if (imagePreviewBarLayout != null) {
                imagePreviewBarLayout.setVisibility(8);
            }
            L1(0);
        } else {
            int i10 = R$id.previewImageBar;
            ImagePreviewBarLayout imagePreviewBarLayout2 = (ImagePreviewBarLayout) U0(i10);
            if (imagePreviewBarLayout2 != null) {
                imagePreviewBarLayout2.setVisibility(0);
            }
            ImagePreviewBarLayout imagePreviewBarLayout3 = (ImagePreviewBarLayout) U0(i10);
            if (imagePreviewBarLayout3 != null) {
                imagePreviewBarLayout3.e(r0.size() - 1);
            }
            L1(h.c(this, 90.0f));
        }
        MediaPickerAdapter mediaPickerAdapter = this.f17282g;
        if (mediaPickerAdapter != null) {
            mediaPickerAdapter.notifyDataSetChanged();
        }
    }

    public final void E1(boolean z10) {
        if (z10) {
            return;
        }
        j1.g.f50233a.c(this.f17283h.getMediaType(), this.f17283h.getShowPosition(), this.f17283h.getWebTitle());
    }

    public final void F1(Config config, boolean z10) {
        this.f17283h = config;
        int i10 = R$id.statusBarLayout;
        if (U0(i10) == null) {
            return;
        }
        if (config.getShowStatusBar()) {
            ViewGroup.LayoutParams layoutParams = U0(i10).getLayoutParams();
            layoutParams.height = h.m(getContext());
            U0(i10).setLayoutParams(layoutParams);
        }
        if (config.getShowSetRealAvatarGuide()) {
            ((TextView) U0(R$id.realAvatarLayout)).setVisibility(0);
        }
        if (!config.getPickMultiplePhotos()) {
            ((ImagePreviewBarLayout) U0(R$id.previewImageBar)).setVisibility(8);
        }
        if (z10) {
            x1();
            s1();
            z1();
        }
    }

    public final void H1() {
        ((ImagePreviewBarLayout) U0(R$id.previewImageBar)).d(new e());
    }

    public final void I1() {
        int i10 = R$id.mediaFolderPickerLayout;
        RelativeLayout relativeLayout = (RelativeLayout) U0(i10);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R$anim.anim_activity_bottom_to_top);
        loadAnimation.setDuration(200L);
        loadAnimation.setAnimationListener(new f());
        RelativeLayout relativeLayout2 = (RelativeLayout) U0(i10);
        if (relativeLayout2 != null) {
            relativeLayout2.startAnimation(loadAnimation);
        }
    }

    public final void J1(@NotNull Config config) {
        s.i(config, "config");
        F1(config, (config.getMediaType() == this.f17283h.getMediaType() && config.getShowTakePhoto() == this.f17283h.getShowTakePhoto()) ? false : true);
    }

    public final void K1(LocalMedia localMedia, int i10) {
        boolean showTakePhoto = this.f17283h.getShowTakePhoto();
        ImagePickedData.INSTANCE.pick(new LocalMediaPicked(this.f17281f, i10 - (showTakePhoto ? 1 : 0), localMedia), new g(i10, showTakePhoto ? 1 : 0));
    }

    public final void L1(int i10) {
        int i11 = R$id.mediaPickerRecycler;
        if (((RecyclerView) U0(i11)) != null) {
            ViewGroup.LayoutParams layoutParams = ((RecyclerView) U0(i11)).getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, 0, 0, i10);
                ((RecyclerView) U0(i11)).setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17290o.clear();
    }

    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17290o;
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), MiniWindowCloseMethod.CloseMethodOther, false, true, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_media_picker, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        E1(z10);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        E1(isHidden());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Config config;
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (config = (Config) z0.g.b(arguments, Config.class)) == null) {
            return;
        }
        G1(this, config, false, 2, null);
    }

    public final void s1() {
        ImageView leftOptionView = (ImageView) U0(R$id.leftOptionView);
        s.h(leftOptionView, "leftOptionView");
        y.d(leftOptionView, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$bindClick$1
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
                MediaPickerFragment.b bVar;
                bVar = MediaPickerFragment.this.f17284i;
                if (bVar != null) {
                    bVar.a();
                }
            }
        });
        LinearLayout mediaFolderLayout = (LinearLayout) U0(R$id.mediaFolderLayout);
        s.h(mediaFolderLayout, "mediaFolderLayout");
        y.d(mediaFolderLayout, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$bindClick$2
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
                if (((RelativeLayout) MediaPickerFragment.this.U0(R$id.mediaFolderPickerLayout)).getVisibility() == 8) {
                    ((TextView) MediaPickerFragment.this.U0(R$id.arrowSignView)).setText(R$string.arrow_up);
                    MediaPickerFragment.this.I1();
                } else {
                    ((TextView) MediaPickerFragment.this.U0(R$id.arrowSignView)).setText(R$string.arrow);
                    MediaPickerFragment.this.v1();
                }
            }
        });
        MediaFolderAdapter mediaFolderAdapter = this.f17280e;
        com.cupidapp.live.base.recyclerview.d l10 = mediaFolderAdapter != null ? mediaFolderAdapter.l() : null;
        if (l10 != null) {
            l10.g(new Function1<Object, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$bindClick$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    if (obj instanceof LocalMediaFolder) {
                        LocalMediaFolder localMediaFolder = (LocalMediaFolder) obj;
                        if (MediaPickerFragment.this.f17281f != localMediaFolder.a()) {
                            MediaPickerFragment.this.f17281f = localMediaFolder.a();
                            ((TextView) MediaPickerFragment.this.U0(R$id.mediaFolderView)).setText(localMediaFolder.d());
                            MediaPickerFragment.this.f17286k = true;
                        }
                        ((TextView) MediaPickerFragment.this.U0(R$id.arrowSignView)).setText(R$string.arrow);
                        MediaPickerFragment.this.v1();
                    }
                }
            });
        }
        MediaPickerAdapter mediaPickerAdapter = this.f17282g;
        com.cupidapp.live.base.recyclerview.d l11 = mediaPickerAdapter != null ? mediaPickerAdapter.l() : null;
        if (l11 != null) {
            l11.k(i0.h(kotlin.f.a(Integer.valueOf(R$id.cameraView), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$bindClick$4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return p.f51048a;
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
                
                    r1 = r0.this$0.f17284i;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(@org.jetbrains.annotations.Nullable java.lang.Object r1, int r2) {
                    /*
                        r0 = this;
                        com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData r1 = com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData.INSTANCE
                        int r1 = r1.size()
                        if (r1 != 0) goto L13
                        com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment r1 = com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.this
                        com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$b r1 = com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.X0(r1)
                        if (r1 == 0) goto L13
                        r1.f()
                    L13:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$bindClick$4.invoke(java.lang.Object, int):void");
                }
            }), kotlin.f.a(Integer.valueOf(R$id.rlMediaPickerItemView), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$bindClick$5
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    long j10;
                    MediaPickerFragment.b bVar;
                    MediaPickerFragment.b bVar2;
                    int i11;
                    List<Object> j11;
                    long currentTimeMillis = System.currentTimeMillis();
                    j10 = MediaPickerFragment.this.f17285j;
                    if (currentTimeMillis - j10 > 500) {
                        MediaPickerFragment.this.f17285j = System.currentTimeMillis();
                        if (obj instanceof LocalMedia) {
                            if (MediaPickerFragment.this.f17283h.getPickMultiplePhotos()) {
                                if (MimeType.Companion.b(((LocalMedia) obj).c()) && ImagePickedData.INSTANCE.size() > 0) {
                                    com.cupidapp.live.base.view.h.f12779a.r(MediaPickerFragment.this.getContext(), R$string.cant_choose_video);
                                    return;
                                }
                                ArrayList arrayList = new ArrayList();
                                MediaPickerAdapter mediaPickerAdapter2 = MediaPickerFragment.this.f17282g;
                                if (mediaPickerAdapter2 != null && (j11 = mediaPickerAdapter2.j()) != null) {
                                    ArrayList arrayList2 = new ArrayList();
                                    for (Object obj2 : j11) {
                                        if (obj2 instanceof LocalMedia) {
                                            arrayList2.add(obj2);
                                        }
                                    }
                                    Iterator<E> iterator2 = arrayList2.iterator2();
                                    while (iterator2.hasNext()) {
                                        arrayList.add((LocalMedia) iterator2.next());
                                    }
                                }
                                if (MediaPickerFragment.this.f17283h.getShowTakePhoto()) {
                                    i10--;
                                }
                                if (arrayList.size() <= 0 || i10 >= arrayList.size()) {
                                    return;
                                }
                                PreviewMediaData.INSTANCE.setList(arrayList);
                                bVar2 = MediaPickerFragment.this.f17284i;
                                if (bVar2 != null) {
                                    long j12 = MediaPickerFragment.this.f17281f;
                                    i11 = MediaPickerFragment.this.f17287l;
                                    bVar2.d(j12, i10, i11);
                                    return;
                                }
                                return;
                            }
                            bVar = MediaPickerFragment.this.f17284i;
                            if (bVar != null) {
                                bVar.e((LocalMedia) obj, i10);
                            }
                        }
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.mcvMediaCheckedView), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$bindClick$6
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    if (obj instanceof LocalMedia) {
                        MediaPickerFragment.this.K1((LocalMedia) obj, i10);
                    }
                }
            })));
        }
        int i10 = R$id.previewImageBar;
        ((ImagePreviewBarLayout) U0(i10)).setCompleteClick(new Function0<p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$bindClick$7
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
                MediaPickerFragment.b bVar;
                ArrayList arrayList = new ArrayList();
                Iterator<LocalMediaPicked> iterator2 = ImagePickedData.INSTANCE.getList().iterator2();
                while (iterator2.hasNext()) {
                    String d10 = iterator2.next().getMedia().d();
                    if (d10 != null) {
                        arrayList.add(d10);
                    }
                }
                bVar = MediaPickerFragment.this.f17284i;
                if (bVar != null) {
                    bVar.c(arrayList);
                }
            }
        });
        ((ImagePreviewBarLayout) U0(i10)).setItemClick(new Function2<LocalMediaPicked, Integer, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$bindClick$8
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(LocalMediaPicked localMediaPicked, Integer num) {
                invoke(localMediaPicked, num.intValue());
                return p.f51048a;
            }

            public final void invoke(@NotNull LocalMediaPicked localMediaPicked, int i11) {
                MediaPickerFragment.b bVar;
                s.i(localMediaPicked, "<anonymous parameter 0>");
                ArrayList arrayList = new ArrayList();
                Iterator<LocalMediaPicked> iterator2 = ImagePickedData.INSTANCE.getList().iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(iterator2.next().getMedia());
                }
                if (arrayList.size() <= 0 || i11 >= arrayList.size()) {
                    return;
                }
                PreviewMediaData.INSTANCE.setList(arrayList);
                bVar = MediaPickerFragment.this.f17284i;
                if (bVar != null) {
                    bVar.b(i11);
                }
            }
        });
    }

    public final void t1() {
        L1(0);
        ((ImagePreviewBarLayout) U0(R$id.previewImageBar)).b(new c());
    }

    public final boolean u1() {
        RelativeLayout relativeLayout = (RelativeLayout) U0(R$id.mediaFolderPickerLayout);
        if (!(relativeLayout != null && relativeLayout.getVisibility() == 0)) {
            return false;
        }
        v1();
        return true;
    }

    public final void v1() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R$anim.anim_activity_top_to_bottom);
        loadAnimation.setAnimationListener(new d());
        RelativeLayout relativeLayout = (RelativeLayout) U0(R$id.mediaFolderPickerLayout);
        if (relativeLayout != null) {
            relativeLayout.startAnimation(loadAnimation);
        }
    }

    public final FKLoadMoreListener w1() {
        return (FKLoadMoreListener) this.f17289n.getValue();
    }

    public final void x1() {
        if (this.f17280e == null) {
            this.f17280e = new MediaFolderAdapter();
            int i10 = R$id.mediaListRecycler;
            ((RecyclerView) U0(i10)).setLayoutManager(new LinearLayoutManager(getContext()));
            ((RecyclerView) U0(i10)).addItemDecoration(new DividerItemDecoration(getContext(), 1));
            ((RecyclerView) U0(i10)).setAdapter(this.f17280e);
        }
        if (this.f17282g == null) {
            int i11 = R$id.mediaPickerRecycler;
            ((RecyclerView) U0(i11)).setHasFixedSize(true);
            ((RecyclerView) U0(i11)).setLayoutManager(new GridLayoutManager(getContext(), 4));
            ((RecyclerView) U0(i11)).addItemDecoration(new MediaGridItemDecoration(h.c(this, 2.0f), false));
            ((RecyclerView) U0(i11)).addOnScrollListener(w1());
            RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) U0(i11)).getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
        }
        this.f17282g = new MediaPickerAdapter(this.f17283h.getShowTakePhoto(), this.f17283h.getPickMultiplePhotos());
        ((RecyclerView) U0(R$id.mediaPickerRecycler)).setAdapter(this.f17282g);
    }

    public final void y1() {
        MediaPickerAdapter mediaPickerAdapter;
        this.f17288m = false;
        this.f17287l = 1;
        if (this.f17283h.getShowTakePhoto() && (mediaPickerAdapter = this.f17282g) != null) {
            mediaPickerAdapter.d(new d3.a());
            mediaPickerAdapter.notifyItemRangeInserted(0, 1);
        }
        B1();
    }

    public final void z1() {
        LocalMediaLoader localMediaLoader = LocalMediaLoader.f17323a;
        Context context = getContext();
        Observable<List<LocalMediaFolder>> n10 = localMediaLoader.n(context != null ? context.getApplicationContext() : null, this.f17283h.getMediaType());
        final Function1<List<LocalMediaFolder>, p> function1 = new Function1<List<LocalMediaFolder>, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment$loadMediaFolderData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<LocalMediaFolder> list) {
                invoke2(list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<LocalMediaFolder> list) {
                MediaFolderAdapter mediaFolderAdapter;
                int size = list.size();
                if (size == 0) {
                    ((TextView) MediaPickerFragment.this.U0(R$id.emptyView)).setVisibility(0);
                    return;
                }
                ((TextView) MediaPickerFragment.this.U0(R$id.emptyView)).setVisibility(8);
                mediaFolderAdapter = MediaPickerFragment.this.f17280e;
                if (mediaFolderAdapter != null) {
                    mediaFolderAdapter.e(list);
                    mediaFolderAdapter.notifyItemRangeInserted(0, size);
                }
                MediaPickerFragment.this.f17281f = list.get(0).a();
                MediaPickerFragment.this.y1();
            }
        };
        Disposable subscribe = n10.subscribe(new Consumer() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MediaPickerFragment.A1(Function1.this, obj);
            }
        });
        s.h(subscribe, "private fun loadMediaFol…   }\n            })\n    }");
        H(subscribe);
    }

    /* compiled from: MediaPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Config implements Serializable {

        @NotNull
        private final MediaType mediaType;
        private final boolean pickMultiplePhotos;

        @Nullable
        private SensorPosition showPosition;
        private final boolean showSetRealAvatarGuide;
        private final boolean showStatusBar;
        private final boolean showTakePhoto;

        @Nullable
        private final CameraStartPosition startPosition;

        @Nullable
        private final String webTitle;

        public Config() {
            this(null, false, false, false, false, null, null, null, 255, null);
        }

        public Config(@NotNull MediaType mediaType, boolean z10, boolean z11, boolean z12, boolean z13, @Nullable CameraStartPosition cameraStartPosition, @Nullable SensorPosition sensorPosition, @Nullable String str) {
            s.i(mediaType, "mediaType");
            this.mediaType = mediaType;
            this.showStatusBar = z10;
            this.showTakePhoto = z11;
            this.showSetRealAvatarGuide = z12;
            this.pickMultiplePhotos = z13;
            this.startPosition = cameraStartPosition;
            this.showPosition = sensorPosition;
            this.webTitle = str;
        }

        @NotNull
        public final MediaType component1() {
            return this.mediaType;
        }

        public final boolean component2() {
            return this.showStatusBar;
        }

        public final boolean component3() {
            return this.showTakePhoto;
        }

        public final boolean component4() {
            return this.showSetRealAvatarGuide;
        }

        public final boolean component5() {
            return this.pickMultiplePhotos;
        }

        @Nullable
        public final CameraStartPosition component6() {
            return this.startPosition;
        }

        @Nullable
        public final SensorPosition component7() {
            return this.showPosition;
        }

        @Nullable
        public final String component8() {
            return this.webTitle;
        }

        @NotNull
        public final Config copy(@NotNull MediaType mediaType, boolean z10, boolean z11, boolean z12, boolean z13, @Nullable CameraStartPosition cameraStartPosition, @Nullable SensorPosition sensorPosition, @Nullable String str) {
            s.i(mediaType, "mediaType");
            return new Config(mediaType, z10, z11, z12, z13, cameraStartPosition, sensorPosition, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return this.mediaType == config.mediaType && this.showStatusBar == config.showStatusBar && this.showTakePhoto == config.showTakePhoto && this.showSetRealAvatarGuide == config.showSetRealAvatarGuide && this.pickMultiplePhotos == config.pickMultiplePhotos && this.startPosition == config.startPosition && this.showPosition == config.showPosition && s.d(this.webTitle, config.webTitle);
        }

        @NotNull
        public final MediaType getMediaType() {
            return this.mediaType;
        }

        public final boolean getPickMultiplePhotos() {
            return this.pickMultiplePhotos;
        }

        @Nullable
        public final SensorPosition getShowPosition() {
            return this.showPosition;
        }

        public final boolean getShowSetRealAvatarGuide() {
            return this.showSetRealAvatarGuide;
        }

        public final boolean getShowStatusBar() {
            return this.showStatusBar;
        }

        public final boolean getShowTakePhoto() {
            return this.showTakePhoto;
        }

        @Nullable
        public final CameraStartPosition getStartPosition() {
            return this.startPosition;
        }

        @Nullable
        public final String getWebTitle() {
            return this.webTitle;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.mediaType.hashCode() * 31;
            boolean z10 = this.showStatusBar;
            int i10 = z10;
            if (z10 != 0) {
                i10 = 1;
            }
            int i11 = (hashCode + i10) * 31;
            boolean z11 = this.showTakePhoto;
            int i12 = z11;
            if (z11 != 0) {
                i12 = 1;
            }
            int i13 = (i11 + i12) * 31;
            boolean z12 = this.showSetRealAvatarGuide;
            int i14 = z12;
            if (z12 != 0) {
                i14 = 1;
            }
            int i15 = (i13 + i14) * 31;
            boolean z13 = this.pickMultiplePhotos;
            int i16 = (i15 + (z13 ? 1 : z13 ? 1 : 0)) * 31;
            CameraStartPosition cameraStartPosition = this.startPosition;
            int hashCode2 = (i16 + (cameraStartPosition == null ? 0 : cameraStartPosition.hashCode())) * 31;
            SensorPosition sensorPosition = this.showPosition;
            int hashCode3 = (hashCode2 + (sensorPosition == null ? 0 : sensorPosition.hashCode())) * 31;
            String str = this.webTitle;
            return hashCode3 + (str != null ? str.hashCode() : 0);
        }

        public final void setShowPosition(@Nullable SensorPosition sensorPosition) {
            this.showPosition = sensorPosition;
        }

        @NotNull
        public String toString() {
            MediaType mediaType = this.mediaType;
            boolean z10 = this.showStatusBar;
            boolean z11 = this.showTakePhoto;
            boolean z12 = this.showSetRealAvatarGuide;
            boolean z13 = this.pickMultiplePhotos;
            CameraStartPosition cameraStartPosition = this.startPosition;
            SensorPosition sensorPosition = this.showPosition;
            return "Config(mediaType=" + ((Object) mediaType) + ", showStatusBar=" + z10 + ", showTakePhoto=" + z11 + ", showSetRealAvatarGuide=" + z12 + ", pickMultiplePhotos=" + z13 + ", startPosition=" + ((Object) cameraStartPosition) + ", showPosition=" + ((Object) sensorPosition) + ", webTitle=" + this.webTitle + ")";
        }

        public /* synthetic */ Config(MediaType mediaType, boolean z10, boolean z11, boolean z12, boolean z13, CameraStartPosition cameraStartPosition, SensorPosition sensorPosition, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? MediaType.ALL : mediaType, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, (i10 & 16) == 0 ? z13 : false, (i10 & 32) != 0 ? CameraStartPosition.FeedPublish : cameraStartPosition, (i10 & 64) != 0 ? SensorPosition.Unknown : sensorPosition, (i10 & 128) != 0 ? null : str);
        }
    }
}
