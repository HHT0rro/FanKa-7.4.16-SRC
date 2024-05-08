package com.cupidapp.live.mediapicker.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.utils.a0;
import com.cupidapp.live.base.view.zoom.ZoomImageView;
import com.cupidapp.live.mediapicker.activity.ImagePasterViewModel;
import com.cupidapp.live.mediapicker.model.ImageTrimModel;
import com.cupidapp.live.mediapicker.view.ImageTrimBoxLayout;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: ImagePasterTrimFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePasterTrimFragment extends FKBaseFragment {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f17184j = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public ImageTrimModel f17186f;

    /* renamed from: h, reason: collision with root package name */
    public int f17188h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17189i = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f17185e = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ImagePasterViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterTrimFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterTrimFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public RectF f17187g = new RectF();

    /* compiled from: ImagePasterTrimFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImagePasterTrimFragment a(@NotNull ImageTrimModel model, int i10) {
            s.i(model, "model");
            ImagePasterTrimFragment imagePasterTrimFragment = new ImagePasterTrimFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, model);
            bundle.putInt("PAGE_HEIGHT", i10);
            imagePasterTrimFragment.setArguments(bundle);
            return imagePasterTrimFragment;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17189i.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17189i;
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

    public final void W0() {
        ImageView closeImg = (ImageView) S0(R$id.closeImg);
        s.h(closeImg, "closeImg");
        y.d(closeImg, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterTrimFragment$bindClickEvent$1
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
                FragmentActivity activity = ImagePasterTrimFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
        ImageView saveImageTrimImg = (ImageView) S0(R$id.saveImageTrimImg);
        s.h(saveImageTrimImg, "saveImageTrimImg");
        y.d(saveImageTrimImg, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImagePasterTrimFragment$bindClickEvent$2
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
                ImagePasterViewModel Y0;
                RectF rectF;
                ImageTrimModel imageTrimModel;
                ImageTrimModel imageTrimModel2;
                String valueOf = String.valueOf(System.currentTimeMillis());
                File i10 = z0.k.f54819a.i(ImagePasterTrimFragment.this.getContext(), valueOf + "_paster_after_trim.jpg");
                if (i10 != null) {
                    ImagePasterTrimFragment imagePasterTrimFragment = ImagePasterTrimFragment.this;
                    a0 a0Var = a0.f12283a;
                    Context context = imagePasterTrimFragment.getContext();
                    rectF = imagePasterTrimFragment.f17187g;
                    RectF v2 = ((ZoomImageView) imagePasterTrimFragment.S0(R$id.zoomRotationImageView)).v(null);
                    imageTrimModel = imagePasterTrimFragment.f17186f;
                    String imageViewPath = imageTrimModel != null ? imageTrimModel.getImageViewPath() : null;
                    imageTrimModel2 = imagePasterTrimFragment.f17186f;
                    Bitmap b4 = a0Var.b(context, rectF, v2, imageViewPath, MetricsProto.MetricsEvent.ACTION_HUSH_GESTURE, imageTrimModel2 != null ? imageTrimModel2.getAspectRatio() : 1.0f);
                    if (b4 != null) {
                        z0.f.f(b4, i10, 100);
                    }
                } else {
                    i10 = null;
                }
                Y0 = ImagePasterTrimFragment.this.Y0();
                Y0.changePasterSourceImgPath(i10 != null ? i10.getAbsolutePath() : null);
                FragmentActivity activity = ImagePasterTrimFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
    }

    public final void X0() {
        String imageViewPath;
        float c4 = z0.h.c(this, 16.0f);
        float f10 = 2;
        float l10 = z0.h.l(this) - (c4 * f10);
        ImageTrimModel imageTrimModel = this.f17186f;
        float aspectRatio = l10 / (imageTrimModel != null ? imageTrimModel.getAspectRatio() : 1.0f);
        float f11 = (this.f17188h - aspectRatio) / f10;
        this.f17187g.set(c4, f11, l10 + c4, aspectRatio + f11);
        ViewGroup.LayoutParams layoutParams = S0(R$id.whiteBackgroundView).getLayoutParams();
        layoutParams.width = (int) this.f17187g.width();
        layoutParams.height = (int) this.f17187g.height();
        int i10 = R$id.zoomRotationImageView;
        ZoomImageView zoomImageView = (ZoomImageView) S0(i10);
        RectF rectF = this.f17187g;
        zoomImageView.r((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        zoomImageView.setScaleEndType(ZoomImageView.ScaleEndType.RecentStyle);
        zoomImageView.setZoomImageMinScale(0.2f);
        ImageTrimBoxLayout imageTrimBoxLayout = (ImageTrimBoxLayout) S0(R$id.trimBoxLayout);
        imageTrimBoxLayout.a(-1);
        imageTrimBoxLayout.b(1.5f, com.cupidapp.live.base.utils.h.a(-16777216, 0.1f));
        imageTrimBoxLayout.setTrimBoxSize(this.f17187g.width(), this.f17187g.height());
        ImageTrimModel imageTrimModel2 = this.f17186f;
        if (imageTrimModel2 == null || (imageViewPath = imageTrimModel2.getImageViewPath()) == null) {
            return;
        }
        ((ZoomImageView) S0(i10)).setImageURI(Uri.parse(imageViewPath));
        ZoomImageView zoomImageView2 = (ZoomImageView) S0(i10);
        ImageTrimModel imageTrimModel3 = this.f17186f;
        zoomImageView2.G(imageTrimModel3 != null ? imageTrimModel3.getAfterTrimImageBoundRectF() : null);
    }

    public final ImagePasterViewModel Y0() {
        return (ImagePasterViewModel) this.f17185e.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_image_paster_trim, viewGroup, false);
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
        this.f17186f = arguments != null ? (ImageTrimModel) z0.g.b(arguments, ImageTrimModel.class) : null;
        Bundle arguments2 = getArguments();
        this.f17188h = arguments2 != null ? arguments2.getInt("PAGE_HEIGHT") : z0.s.f54824a.a();
        X0();
        W0();
    }
}
