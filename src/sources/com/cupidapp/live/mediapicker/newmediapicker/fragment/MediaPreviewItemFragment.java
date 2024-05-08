package com.cupidapp.live.mediapicker.newmediapicker.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.TransformationType;
import com.cupidapp.live.base.view.zoom.ZoomImageView;
import com.cupidapp.live.mediapicker.activity.FeedPublishActivity;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.mediapicker.newmediapicker.model.MimeType;
import com.cupidapp.live.mediapicker.newmediapicker.view.VideoPreviewLayout;
import com.huawei.uikit.hwcommon.anim.HwFocusColorGradientAnimListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MediaPreviewItemFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaPreviewItemFragment extends FKBaseFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f17309h = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public LocalMedia f17311f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17312g = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Function1<? super Boolean, p> f17310e = new Function1<Boolean, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewItemFragment$fullScreenState$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
            invoke2(bool);
            return p.f51048a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Boolean bool) {
        }
    };

    /* compiled from: MediaPreviewItemFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MediaPreviewItemFragment a(@Nullable LocalMedia localMedia, @ColorInt int i10) {
            MediaPreviewItemFragment mediaPreviewItemFragment = new MediaPreviewItemFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(HwFocusColorGradientAnimListener.f34891a, i10);
            bundle.putParcelable("preview_media_data", localMedia);
            mediaPreviewItemFragment.setArguments(bundle);
            return mediaPreviewItemFragment;
        }
    }

    /* compiled from: MediaPreviewItemFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements VideoPreviewLayout.a {
        public b() {
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.view.VideoPreviewLayout.a
        public void a(boolean z10) {
            MediaPreviewItemFragment.this.W0(Boolean.valueOf(z10));
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17312g.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17312g;
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

    public final void V0() {
        if (getActivity() instanceof FeedPublishActivity) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        W0(null);
    }

    public final void W0(Boolean bool) {
        this.f17310e.invoke(bool);
    }

    public final void X0() {
        int i10;
        int i11;
        MimeType.a aVar = MimeType.Companion;
        LocalMedia localMedia = this.f17311f;
        if (aVar.b(localMedia != null ? localMedia.c() : null)) {
            ((ZoomImageView) S0(R$id.zivImagePreview)).setVisibility(8);
            int i12 = R$id.vplVideoPreview;
            ((VideoPreviewLayout) S0(i12)).setVisibility(0);
            VideoPreviewLayout videoPreviewLayout = (VideoPreviewLayout) S0(i12);
            LocalMedia localMedia2 = this.f17311f;
            videoPreviewLayout.h(Uri.parse(localMedia2 != null ? localMedia2.d() : null), new b());
            return;
        }
        int i13 = R$id.zivImagePreview;
        ((ZoomImageView) S0(i13)).setVisibility(0);
        LocalMedia localMedia3 = this.f17311f;
        if (localMedia3 != null) {
            int f10 = localMedia3.f();
            i11 = localMedia3.b();
            i10 = f10;
        } else {
            i10 = -1;
            i11 = -1;
        }
        ZoomImageView zivImagePreview = (ZoomImageView) S0(i13);
        s.h(zivImagePreview, "zivImagePreview");
        LocalMedia localMedia4 = this.f17311f;
        ImageLoaderView.f(zivImagePreview, new com.cupidapp.live.base.imageloader.b(false, localMedia4 != null ? localMedia4.d() : null, null, null, null, null, null, -16777216, 0, null, TransformationType.FitCenter, null, null, false, i10, i11, false, null, null, 473981, null), null, 2, null);
        ZoomImageView zoomImageView = (ZoomImageView) S0(i13);
        if (zoomImageView != null) {
            zoomImageView.setScaleEndType(ZoomImageView.ScaleEndType.RecentStyle);
        }
        ZoomImageView zoomImageView2 = (ZoomImageView) S0(i13);
        if (zoomImageView2 != null) {
            zoomImageView2.setZoomImageMinScale(0.2f);
        }
        ((ZoomImageView) S0(i13)).setOnSingleClick(new Function0<p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewItemFragment$initView$3
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
                MediaPreviewItemFragment.this.V0();
            }
        });
        ((VideoPreviewLayout) S0(R$id.vplVideoPreview)).setVisibility(8);
    }

    public final void Y0() {
        MimeType.a aVar = MimeType.Companion;
        LocalMedia localMedia = this.f17311f;
        if (aVar.b(localMedia != null ? localMedia.c() : null)) {
            VideoPreviewLayout videoPreviewLayout = (VideoPreviewLayout) S0(R$id.vplVideoPreview);
            if (videoPreviewLayout != null) {
                videoPreviewLayout.l();
                return;
            }
            return;
        }
        ZoomImageView zoomImageView = (ZoomImageView) S0(R$id.zivImagePreview);
        if (zoomImageView != null) {
            zoomImageView.B();
        }
    }

    public final void Z0(@NotNull Function1<? super Boolean, p> function1) {
        s.i(function1, "<set-?>");
        this.f17310e = function1;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_media_preview_item, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        VideoPreviewLayout videoPreviewLayout;
        super.onPause();
        MimeType.a aVar = MimeType.Companion;
        LocalMedia localMedia = this.f17311f;
        if (!aVar.b(localMedia != null ? localMedia.c() : null) || (videoPreviewLayout = (VideoPreviewLayout) S0(R$id.vplVideoPreview)) == null) {
            return;
        }
        videoPreviewLayout.i();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.f17311f = arguments != null ? (LocalMedia) arguments.getParcelable("preview_media_data") : null;
        Bundle arguments2 = getArguments();
        ((RelativeLayout) S0(R$id.rlPreviewContainerLayout)).setBackgroundColor(arguments2 != null ? arguments2.getInt(HwFocusColorGradientAnimListener.f34891a) : -16777216);
        X0();
    }
}
