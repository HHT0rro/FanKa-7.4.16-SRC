package com.cupidapp.live.mediapicker.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.zoom.ZoomImageView;
import com.cupidapp.live.mediapicker.model.ImageTrimModel;
import com.cupidapp.live.mediapicker.model.UpdateImageEditPathEventModel;
import com.cupidapp.live.mediapicker.view.ImageTrimBoxLayout;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;
import z0.y;

/* compiled from: ImageTrimFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageTrimFragment extends FKBaseFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f17190h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public ImageTrimModel f17191e;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17193g = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public RectF f17192f = new RectF();

    /* compiled from: ImageTrimFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImageTrimFragment a(@NotNull ImageTrimModel model) {
            s.i(model, "model");
            ImageTrimFragment imageTrimFragment = new ImageTrimFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, model);
            imageTrimFragment.setArguments(bundle);
            return imageTrimFragment;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17193g.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17193g;
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

    public final void V0(@NotNull ImageTrimModel model) {
        s.i(model, "model");
        this.f17191e = model;
        ((ZoomImageView) S0(R$id.zoomRotationImageView)).B();
        Y0();
    }

    public final void W0() {
        ((FKTitleBarLayout) S0(R$id.imageTrimTitleBarLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageTrimFragment$bindClickEvent$1
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
                ImageTrimModel imageTrimModel;
                EventBus c4 = EventBus.c();
                imageTrimModel = ImageTrimFragment.this.f17191e;
                c4.l(new UpdateImageEditPathEventModel(imageTrimModel != null ? imageTrimModel.getCompressedImagePath() : null, null, null, null, 14, null));
                FragmentActivity activity = ImageTrimFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
        FKUniversalButton saveImageTrimButton = (FKUniversalButton) S0(R$id.saveImageTrimButton);
        s.h(saveImageTrimButton, "saveImageTrimButton");
        y.d(saveImageTrimButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageTrimFragment$bindClickEvent$2
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
                ImageTrimModel imageTrimModel;
                ImageTrimModel imageTrimModel2;
                Bitmap Z0;
                ImageTrimModel imageTrimModel3;
                Bitmap Z02;
                String valueOf = String.valueOf(System.currentTimeMillis());
                k.a aVar = z0.k.f54819a;
                File i10 = aVar.i(ImageTrimFragment.this.getContext(), valueOf + "_effect_after_trim.jpg");
                if (i10 != null) {
                    ImageTrimFragment imageTrimFragment = ImageTrimFragment.this;
                    imageTrimModel3 = imageTrimFragment.f17191e;
                    Z02 = imageTrimFragment.Z0(imageTrimModel3 != null ? imageTrimModel3.getImageViewPath() : null);
                    if (Z02 != null) {
                        z0.f.f(Z02, i10, 100);
                    }
                } else {
                    i10 = null;
                }
                File i11 = aVar.i(ImageTrimFragment.this.getContext(), valueOf + "_original_after_trim.jpg");
                if (i11 != null) {
                    ImageTrimFragment imageTrimFragment2 = ImageTrimFragment.this;
                    imageTrimModel2 = imageTrimFragment2.f17191e;
                    Z0 = imageTrimFragment2.Z0(imageTrimModel2 != null ? imageTrimModel2.getCompressedImagePath() : null);
                    if (Z0 != null) {
                        z0.f.f(Z0, i11, 100);
                    }
                } else {
                    i11 = null;
                }
                EventBus c4 = EventBus.c();
                imageTrimModel = ImageTrimFragment.this.f17191e;
                c4.l(new UpdateImageEditPathEventModel(imageTrimModel != null ? imageTrimModel.getCompressedImagePath() : null, i10 != null ? i10.getAbsolutePath() : null, i11 != null ? i11.getAbsolutePath() : null, ((ZoomImageView) ImageTrimFragment.this.S0(R$id.zoomRotationImageView)).v(null)));
                FragmentActivity activity = ImageTrimFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
    }

    public final float X0(float f10) {
        if (f10 < 0.0f) {
            return 0.0f;
        }
        if (f10 > 1.0f) {
            return 1.0f;
        }
        return f10;
    }

    public final void Y0() {
        String imageViewPath;
        float c4 = z0.h.c(this, 25.0f);
        float f10 = 2;
        float l10 = z0.h.l(this) - (c4 * f10);
        ImageTrimModel imageTrimModel = this.f17191e;
        float aspectRatio = l10 / (imageTrimModel != null ? imageTrimModel.getAspectRatio() : 1.0f);
        float a10 = (z0.s.f54824a.a() - aspectRatio) / f10;
        this.f17192f.set(c4, a10, l10 + c4, aspectRatio + a10);
        ViewGroup.LayoutParams layoutParams = S0(R$id.whiteBackgroundView).getLayoutParams();
        layoutParams.width = (int) this.f17192f.width();
        layoutParams.height = (int) this.f17192f.height();
        int i10 = R$id.zoomRotationImageView;
        ZoomImageView zoomImageView = (ZoomImageView) S0(i10);
        RectF rectF = this.f17192f;
        zoomImageView.r((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        zoomImageView.setScaleEndType(ZoomImageView.ScaleEndType.RecentStyle);
        zoomImageView.setZoomImageMinScale(0.2f);
        ImageTrimBoxLayout imageTrimBoxLayout = (ImageTrimBoxLayout) S0(R$id.trimBoxLayout);
        imageTrimBoxLayout.a(-1);
        imageTrimBoxLayout.b(1.5f, com.cupidapp.live.base.utils.h.a(-16777216, 0.5f));
        imageTrimBoxLayout.setTrimBoxSize(this.f17192f.width(), this.f17192f.height());
        ImageTrimModel imageTrimModel2 = this.f17191e;
        if (imageTrimModel2 == null || (imageViewPath = imageTrimModel2.getImageViewPath()) == null) {
            return;
        }
        ((ZoomImageView) S0(i10)).setImageURI(Uri.parse(imageViewPath));
        ZoomImageView zoomImageView2 = (ZoomImageView) S0(i10);
        ImageTrimModel imageTrimModel3 = this.f17191e;
        zoomImageView2.G(imageTrimModel3 != null ? imageTrimModel3.getAfterTrimImageBoundRectF() : null);
    }

    public final Bitmap Z0(String str) {
        Bitmap b4;
        Bitmap bitmap = null;
        if (str == null) {
            return null;
        }
        RectF v2 = ((ZoomImageView) S0(R$id.zoomRotationImageView)).v(null);
        float f10 = v2.left;
        float f11 = this.f17192f.left;
        float width = f10 < f11 ? (f11 - f10) / v2.width() : 0.0f;
        float f12 = v2.right;
        float f13 = this.f17192f.right;
        float width2 = f12 > f13 ? (f13 - v2.left) / v2.width() : 1.0f;
        float f14 = v2.top;
        float f15 = this.f17192f.top;
        float height = f14 < f15 ? (f15 - f14) / v2.height() : 0.0f;
        float f16 = v2.bottom;
        float f17 = this.f17192f.bottom;
        float height2 = f16 > f17 ? (f17 - v2.top) / v2.height() : 1.0f;
        float X0 = X0(width);
        float X02 = X0(width2);
        float X03 = X0(height);
        float X04 = X0(height2);
        float f18 = v2.left;
        RectF rectF = this.f17192f;
        boolean z10 = true;
        boolean z11 = f18 > rectF.left && v2.right < rectF.right;
        boolean z12 = v2.top > rectF.top && v2.bottom < rectF.bottom;
        if (!z11 && !z12) {
            z10 = false;
        }
        try {
            b4 = z0.f.b(getContext(), str, X0, X03, X02, X04);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (b4 == null) {
            return null;
        }
        int i10 = MetricsProto.MetricsEvent.ACTION_HUSH_GESTURE;
        float width3 = MetricsProto.MetricsEvent.ACTION_HUSH_GESTURE / b4.getWidth();
        if (width3 < 1.0f) {
            b4 = z0.f.u(b4, width3);
        }
        if (!z10) {
            return b4;
        }
        if (!z0.f.l(getContext(), str).isVertical()) {
            i10 = Math.min(MetricsProto.MetricsEvent.ACTION_HUSH_GESTURE, b4.getWidth());
        }
        float f19 = i10;
        ImageTrimModel imageTrimModel = this.f17191e;
        int aspectRatio = (int) (f19 / (imageTrimModel != null ? imageTrimModel.getAspectRatio() : 1.0f));
        float width4 = f19 / this.f17192f.width();
        float height3 = aspectRatio / this.f17192f.height();
        float max = Math.max(v2.left, this.f17192f.left);
        RectF rectF2 = this.f17192f;
        float f20 = (max - rectF2.left) * width4;
        float max2 = Math.max(v2.top, rectF2.top);
        RectF rectF3 = this.f17192f;
        float f21 = (max2 - rectF3.top) * height3;
        float min = Math.min(v2.right, rectF3.right);
        RectF rectF4 = this.f17192f;
        bitmap = z0.f.a(b4, i10, aspectRatio, new RectF(f20, f21, (min - rectF4.left) * width4, (Math.min(v2.bottom, rectF4.bottom) - this.f17192f.top) * height3));
        b4.recycle();
        return bitmap;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_image_trim, viewGroup, false);
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
        this.f17191e = arguments != null ? (ImageTrimModel) z0.g.b(arguments, ImageTrimModel.class) : null;
        Context context = getContext();
        if (context != null) {
            ((FKUniversalButton) S0(R$id.saveImageTrimButton)).setTextColor(ContextCompat.getColor(context, R$color.app_black));
        }
        Y0();
        W0();
    }
}
