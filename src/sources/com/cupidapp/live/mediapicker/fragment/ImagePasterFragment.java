package com.cupidapp.live.mediapicker.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.TransformationType;
import com.cupidapp.live.base.imageloader.c;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.decoration.ExtraSpacingDecoration;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.mediapicker.activity.FeedPublishActivity;
import com.cupidapp.live.mediapicker.activity.ImagePasterViewModel;
import com.cupidapp.live.mediapicker.adapter.ImagePasterListAdapter;
import com.cupidapp.live.mediapicker.model.FrameAspectRatio;
import com.cupidapp.live.mediapicker.model.ImageContentModel;
import com.cupidapp.live.mediapicker.model.PasterModel;
import com.cupidapp.live.mediapicker.model.UploadImageModel;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;
import z0.y;

/* compiled from: ImagePasterFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePasterFragment extends FKBaseFragment {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f17177j = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public ImagePasterSourceModel f17179f;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17182i = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public FrameAspectRatio f17178e = FrameAspectRatio.THREE_TO_FOUR;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f17180g = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ImagePasterViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            s.h(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.getViewModelStore();
            s.h(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            s.h(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f17181h = kotlin.c.b(new Function0<ImagePasterListAdapter>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterFragment$imagePasterListAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ImagePasterListAdapter invoke() {
            return new ImagePasterListAdapter(ImagePasterFragment.this.b1());
        }
    });

    /* compiled from: ImagePasterFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImagePasterFragment a(@NotNull ImagePasterSourceModel model) {
            s.i(model, "model");
            ImagePasterFragment imagePasterFragment = new ImagePasterFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("source_model", model);
            imagePasterFragment.setArguments(bundle);
            return imagePasterFragment;
        }
    }

    /* compiled from: ImagePasterFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements com.cupidapp.live.base.imageloader.c {
        public b() {
        }

        @Override // com.cupidapp.live.base.imageloader.c
        public void a(@NotNull Drawable drawable) {
            s.i(drawable, "drawable");
            c.a.b(this, drawable);
            ImagePasterFragment.this.b1().changeLoadingState(false);
        }

        @Override // com.cupidapp.live.base.imageloader.c
        public void b() {
            c.a.c(this);
            ImagePasterFragment.this.b1().changeLoadingState(false);
            com.cupidapp.live.base.view.h.f12779a.r(ImagePasterFragment.this.getContext(), R$string.load_fail);
        }

        @Override // com.cupidapp.live.base.imageloader.c
        public void c(@NotNull Bitmap bitmap) {
            c.a.a(this, bitmap);
        }
    }

    public static final void f1(ImagePasterFragment this$0, StateResult stateResult) {
        s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.b) {
            this$0.b1().changeLoadingState(true);
            return;
        }
        if (stateResult instanceof StateResult.c) {
            List<PasterModel> list = (List) stateResult.getData();
            if (list != null) {
                this$0.a1().d(list);
            }
            FKTitleBarLayout paster_title_view = (FKTitleBarLayout) this$0.V0(R$id.paster_title_view);
            s.h(paster_title_view, "paster_title_view");
            FKTitleBarLayout.setRightText$default(paster_title_view, this$0.getString(R$string.save), -1, 0, false, 8, null);
            return;
        }
        if (stateResult instanceof StateResult.a) {
            FKTitleBarLayout paster_title_view2 = (FKTitleBarLayout) this$0.V0(R$id.paster_title_view);
            s.h(paster_title_view2, "paster_title_view");
            FKTitleBarLayout.setRightText$default(paster_title_view2, this$0.getString(R$string.save), -1, 8, false, 8, null);
            com.cupidapp.live.base.view.h.f12779a.r(this$0.getContext(), R$string.no_network_tip);
        }
    }

    public static final void g1(ImagePasterFragment this$0, PasterModel pasterModel) {
        s.i(this$0, "this$0");
        this$0.b1().changeLoadingState(true);
        int i10 = R$id.paster_cover_img;
        ((ImageLoaderView) this$0.V0(i10)).e(pasterModel.getLargeImage(), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, ((ImageLoaderView) this$0.V0(i10)).getDrawable(), null, null, null, false, 0, 0, false, null, null, 523775, null), new b());
        this$0.a1().notifyDataSetChanged();
    }

    public static final void k1(ImagePasterFragment this$0) {
        s.i(this$0, "this$0");
        this$0.b1().changeLoadingState(true);
        int i10 = R$id.paster_source_img;
        Bitmap bitmap = Bitmap.createBitmap(((ImageLoaderView) this$0.V0(i10)).getWidth(), ((ImageLoaderView) this$0.V0(i10)).getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        ((ImageLoaderView) this$0.V0(i10)).draw(canvas);
        ((ImageLoaderView) this$0.V0(R$id.paster_cover_img)).draw(canvas);
        k.a aVar = z0.k.f54819a;
        File k10 = aVar.k(this$0.getContext(), System.currentTimeMillis() + ".jpg");
        if (k10 != null) {
            s.h(bitmap, "bitmap");
            ImagePasterSourceModel imagePasterSourceModel = null;
            z0.f.g(bitmap, k10, 0, 2, null);
            this$0.b1().changeLoadingState(false);
            if (k10.exists()) {
                Context it = this$0.getContext();
                if (it != null) {
                    s.h(it, "it");
                    k.a.H(aVar, it, k10, "2022_" + System.currentTimeMillis() + ".jpg", null, 8, null);
                }
                String absolutePath = k10.getAbsolutePath();
                s.h(absolutePath, "file.absolutePath");
                this$0.c1(absolutePath);
                j1.g gVar = j1.g.f50233a;
                ImagePasterSourceModel imagePasterSourceModel2 = this$0.f17179f;
                if (imagePasterSourceModel2 == null) {
                    s.A("imageSourceModel");
                    imagePasterSourceModel2 = null;
                }
                String mediaType = imagePasterSourceModel2.getMediaType();
                SensorPosition sensorPosition = SensorPosition.Web;
                ImagePasterSourceModel imagePasterSourceModel3 = this$0.f17179f;
                if (imagePasterSourceModel3 == null) {
                    s.A("imageSourceModel");
                } else {
                    imagePasterSourceModel = imagePasterSourceModel3;
                }
                gVar.a(mediaType, sensorPosition, 1, imagePasterSourceModel.getWebTitle());
            }
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17182i.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17182i;
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

    public final ImagePasterListAdapter a1() {
        return (ImagePasterListAdapter) this.f17181h.getValue();
    }

    public final ImagePasterViewModel b1() {
        return (ImagePasterViewModel) this.f17180g.getValue();
    }

    public final void c1(String str) {
        ImageContentModel imageContentModel = new ImageContentModel(kotlin.collections.s.f(new UploadImageModel(null, str, null, 5, null)), this.f17178e, null, 4, null);
        FeedPublishActivity.a aVar = FeedPublishActivity.K;
        FragmentActivity activity = getActivity();
        ImagePasterSourceModel imagePasterSourceModel = this.f17179f;
        ImagePasterSourceModel imagePasterSourceModel2 = null;
        if (imagePasterSourceModel == null) {
            s.A("imageSourceModel");
            imagePasterSourceModel = null;
        }
        HashTagSimpleModel hashTagSimpleModel = imagePasterSourceModel.getHashTagSimpleModel();
        SensorPosition sensorPosition = SensorPosition.Web;
        ImagePasterSourceModel imagePasterSourceModel3 = this.f17179f;
        if (imagePasterSourceModel3 == null) {
            s.A("imageSourceModel");
        } else {
            imagePasterSourceModel2 = imagePasterSourceModel3;
        }
        aVar.a(activity, imageContentModel, null, hashTagSimpleModel, 1212, "上传", sensorPosition, false, false, imagePasterSourceModel2.getWebTitle());
        com.cupidapp.live.base.view.h.f12779a.l(getContext(), R$string.save_to_local);
    }

    public final void d1() {
        FKSVGAImageView trim_svga = (FKSVGAImageView) V0(R$id.trim_svga);
        s.h(trim_svga, "trim_svga");
        y.d(trim_svga, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterFragment$initClick$1
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
                ((FKSVGAImageView) ImagePasterFragment.this.V0(R$id.trim_svga)).K();
                ImagePasterFragment.this.V0(R$id.svga_bg).setVisibility(8);
            }
        });
        int i10 = R$id.paster_title_view;
        ((FKTitleBarLayout) V0(i10)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterFragment$initClick$2
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
                FragmentActivity activity = ImagePasterFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
        ((FKTitleBarLayout) V0(i10)).setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterFragment$initClick$3
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
                ImagePasterSourceModel imagePasterSourceModel;
                ImagePasterFragment.this.b1().saveImgRecord();
                ImagePasterFragment.this.j1();
                SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                SensorsLogFeed.BtnName btnName = SensorsLogFeed.BtnName.SAVE;
                imagePasterSourceModel = ImagePasterFragment.this.f17179f;
                if (imagePasterSourceModel == null) {
                    s.A("imageSourceModel");
                    imagePasterSourceModel = null;
                }
                String webTitle = imagePasterSourceModel.getWebTitle();
                PasterModel value = ImagePasterFragment.this.b1().getImagePasterSelect().getValue();
                sensorsLogFeed.H(btnName, webTitle, value != null ? value.getId() : null);
            }
        });
        ImageView paster_trim_img = (ImageView) V0(R$id.paster_trim_img);
        s.h(paster_trim_img, "paster_trim_img");
        y.d(paster_trim_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterFragment$initClick$4
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
                ImagePasterSourceModel imagePasterSourceModel;
                FrameAspectRatio frameAspectRatio;
                ImagePasterSourceModel imagePasterSourceModel2;
                ImagePasterViewModel b12 = ImagePasterFragment.this.b1();
                imagePasterSourceModel = ImagePasterFragment.this.f17179f;
                if (imagePasterSourceModel == null) {
                    s.A("imageSourceModel");
                    imagePasterSourceModel = null;
                }
                frameAspectRatio = ImagePasterFragment.this.f17178e;
                b12.openImagePasterTrimFragment(imagePasterSourceModel, frameAspectRatio);
                SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                SensorsLogFeed.BtnName btnName = SensorsLogFeed.BtnName.CUT;
                imagePasterSourceModel2 = ImagePasterFragment.this.f17179f;
                if (imagePasterSourceModel2 == null) {
                    s.A("imageSourceModel");
                    imagePasterSourceModel2 = null;
                }
                String webTitle = imagePasterSourceModel2.getWebTitle();
                PasterModel value = ImagePasterFragment.this.b1().getImagePasterSelect().getValue();
                sensorsLogFeed.H(btnName, webTitle, value != null ? value.getId() : null);
            }
        });
        ImageLoaderView paster_cover_img = (ImageLoaderView) V0(R$id.paster_cover_img);
        s.h(paster_cover_img, "paster_cover_img");
        y.c(paster_cover_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterFragment$initClick$5
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
                ImagePasterSourceModel imagePasterSourceModel;
                FrameAspectRatio frameAspectRatio;
                ImagePasterSourceModel imagePasterSourceModel2;
                ImagePasterViewModel b12 = ImagePasterFragment.this.b1();
                imagePasterSourceModel = ImagePasterFragment.this.f17179f;
                if (imagePasterSourceModel == null) {
                    s.A("imageSourceModel");
                    imagePasterSourceModel = null;
                }
                frameAspectRatio = ImagePasterFragment.this.f17178e;
                b12.openImagePasterTrimFragment(imagePasterSourceModel, frameAspectRatio);
                SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                SensorsLogFeed.BtnName btnName = SensorsLogFeed.BtnName.CUT;
                imagePasterSourceModel2 = ImagePasterFragment.this.f17179f;
                if (imagePasterSourceModel2 == null) {
                    s.A("imageSourceModel");
                    imagePasterSourceModel2 = null;
                }
                String webTitle = imagePasterSourceModel2.getWebTitle();
                PasterModel value = ImagePasterFragment.this.b1().getImagePasterSelect().getValue();
                sensorsLogFeed.H(btnName, webTitle, value != null ? value.getId() : null);
            }
        });
    }

    public final void e1() {
        b1().getImagePasterResult().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.mediapicker.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ImagePasterFragment.f1(ImagePasterFragment.this, (StateResult) obj);
            }
        });
        b1().getImagePasterSelect().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.mediapicker.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ImagePasterFragment.g1(ImagePasterFragment.this, (PasterModel) obj);
            }
        });
        b1().getSourceImgPath().observe(getViewLifecycleOwner(), new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String path) {
                s.i(path, "path");
                ImagePasterFragment.this.h1(path);
            }
        }));
    }

    public final void h1(String str) {
        int l10 = z0.h.l(this);
        int l11 = (int) (z0.h.l(this) / this.f17178e.getRatio());
        int i10 = R$id.paster_source_img;
        ImageLoaderView paster_source_img = (ImageLoaderView) V0(i10);
        s.h(paster_source_img, "paster_source_img");
        y.n(paster_source_img, Integer.valueOf(l10), Integer.valueOf(l11));
        ImageLoaderView paster_source_img2 = (ImageLoaderView) V0(i10);
        s.h(paster_source_img2, "paster_source_img");
        ImageLoaderView.f(paster_source_img2, new com.cupidapp.live.base.imageloader.b(false, str, null, null, null, null, null, -16777216, 0, null, TransformationType.CenterCrop, null, null, false, l10, l11, false, null, null, 473981, null), null, 2, null);
    }

    public final void i1() {
        int i10 = R$id.paster_recycler;
        ((RecyclerView) V0(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) V0(i10)).setAdapter(a1());
        ((RecyclerView) V0(i10)).addItemDecoration(new ExtraSpacingDecoration(z0.h.c(this, 8.0f), 0, z0.h.c(this, 8.0f), 0, 0));
    }

    public final void j1() {
        ImageLoaderView imageLoaderView = (ImageLoaderView) V0(R$id.paster_source_img);
        if (imageLoaderView != null) {
            imageLoaderView.post(new Runnable() { // from class: com.cupidapp.live.mediapicker.fragment.d
                @Override // java.lang.Runnable
                public final void run() {
                    ImagePasterFragment.k1(ImagePasterFragment.this);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_image_paster, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        ImagePasterSourceModel imagePasterSourceModel = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("source_model") : null;
        ImagePasterSourceModel imagePasterSourceModel2 = serializable instanceof ImagePasterSourceModel ? (ImagePasterSourceModel) serializable : null;
        if (imagePasterSourceModel2 == null) {
            return;
        }
        this.f17179f = imagePasterSourceModel2;
        this.f17178e = imagePasterSourceModel2.getFrameType();
        i1();
        b1().initData(imagePasterSourceModel2.getWebTitle());
        ImagePasterViewModel b12 = b1();
        ImagePasterSourceModel imagePasterSourceModel3 = this.f17179f;
        if (imagePasterSourceModel3 == null) {
            s.A("imageSourceModel");
        } else {
            imagePasterSourceModel = imagePasterSourceModel3;
        }
        b12.changePasterSourceImgPath(imagePasterSourceModel.getMediaContentPath());
        b1().loadData();
        e1();
        d1();
        p1.g gVar = p1.g.f52734a;
        if (s.d(gVar.f1(), Boolean.TRUE)) {
            gVar.r3(Boolean.FALSE);
            int i10 = R$id.trim_svga;
            ((FKSVGAImageView) V0(i10)).setVisibility(0);
            V0(R$id.svga_bg).setVisibility(0);
            FKSVGAImageView trim_svga = (FKSVGAImageView) V0(i10);
            s.h(trim_svga, "trim_svga");
            FKSVGAImageView.F(trim_svga, "image_paster_tip.svga", null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterFragment$onViewCreated$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((FKSVGAImageView) ImagePasterFragment.this.V0(R$id.trim_svga)).setVisibility(8);
                    ImagePasterFragment.this.V0(R$id.svga_bg).setVisibility(8);
                }
            }, 2, null);
        }
    }
}
