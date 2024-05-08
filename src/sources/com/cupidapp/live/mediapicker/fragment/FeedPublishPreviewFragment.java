package com.cupidapp.live.mediapicker.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.view.CustomIndicator;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.mediapicker.activity.FeedPublishActivity;
import com.cupidapp.live.mediapicker.newmediapicker.adapter.MediaPreviewPagerAdapter;
import com.cupidapp.live.mediapicker.newmediapicker.data.PreviewMediaData;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewItemFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.mediapicker.newmediapicker.view.FeedPublishVideoPreviewLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.w;
import z0.y;

/* compiled from: FeedPublishPreviewFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FeedPublishPreviewFragment extends FKBaseFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f17160h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public MediaPreviewPagerAdapter f17161e;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17163g = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f17162f = kotlin.c.b(new Function0<Float>() { // from class: com.cupidapp.live.mediapicker.fragment.FeedPublishPreviewFragment$imageScale$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Float invoke() {
            Bundle arguments = FeedPublishPreviewFragment.this.getArguments();
            return Float.valueOf(arguments != null ? arguments.getFloat("IMAGE_SCALE") : 1.0f);
        }
    });

    /* compiled from: FeedPublishPreviewFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedPublishPreviewFragment a(@Nullable ArrayList<String> arrayList, float f10, boolean z10) {
            FeedPublishPreviewFragment feedPublishPreviewFragment = new FeedPublishPreviewFragment();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_LIST", arrayList);
            bundle.putFloat("IMAGE_SCALE", f10);
            bundle.putBoolean("IS_VIDEO", z10);
            feedPublishPreviewFragment.setArguments(bundle);
            return feedPublishPreviewFragment;
        }
    }

    /* compiled from: FeedPublishPreviewFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements MediaPreviewPagerAdapter.a {
        @Override // com.cupidapp.live.mediapicker.newmediapicker.adapter.MediaPreviewPagerAdapter.a
        public void t0(@Nullable MediaPreviewItemFragment mediaPreviewItemFragment, @NotNull MediaPreviewItemFragment newFragment) {
            s.i(newFragment, "newFragment");
            if (mediaPreviewItemFragment != null) {
                mediaPreviewItemFragment.Y0();
            }
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17163g.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17163g;
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

    public final float T0() {
        return ((Number) this.f17162f.getValue()).floatValue();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_feed_publish_preview, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ((FeedPublishVideoPreviewLayout) S0(R$id.videoPreviewLayout)).g();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((FeedPublishVideoPreviewLayout) S0(R$id.videoPreviewLayout)).h();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        ((FKTitleBarLayout) S0(R$id.previewTitleBarLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.FeedPublishPreviewFragment$onViewCreated$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view2) {
                invoke2(view2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                FragmentActivity activity = FeedPublishPreviewFragment.this.getActivity();
                FeedPublishActivity feedPublishActivity = activity instanceof FeedPublishActivity ? (FeedPublishActivity) activity : null;
                if (feedPublishActivity != null) {
                    feedPublishActivity.onBackPressed();
                }
            }
        });
        Bundle arguments = getArguments();
        ArrayList<String> stringArrayList = arguments != null ? arguments.getStringArrayList("ITEM_LIST") : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && arguments2.getBoolean("IS_VIDEO")) {
            ((ViewPager) S0(R$id.feedPublishPreviewPager)).setVisibility(4);
            int i10 = R$id.videoPreviewLayout;
            ((FeedPublishVideoPreviewLayout) S0(i10)).setVisibility(0);
            ((FeedPublishVideoPreviewLayout) S0(i10)).f(stringArrayList != null ? stringArrayList.get(0) : null, stringArrayList != null ? stringArrayList.get(1) : null);
            FeedPublishVideoPreviewLayout videoPreviewLayout = (FeedPublishVideoPreviewLayout) S0(i10);
            s.h(videoPreviewLayout, "videoPreviewLayout");
            y.d(videoPreviewLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.FeedPublishPreviewFragment$onViewCreated$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(View view2) {
                    invoke2(view2);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view2) {
                    FragmentActivity activity = FeedPublishPreviewFragment.this.getActivity();
                    FeedPublishActivity feedPublishActivity = activity instanceof FeedPublishActivity ? (FeedPublishActivity) activity : null;
                    if (feedPublishActivity != null) {
                        feedPublishActivity.onBackPressed();
                    }
                }
            });
            return;
        }
        b bVar = new b();
        FragmentManager childFragmentManager = getChildFragmentManager();
        s.h(childFragmentManager, "childFragmentManager");
        this.f17161e = new MediaPreviewPagerAdapter(bVar, 0, childFragmentManager);
        ((ViewPager) S0(R$id.feedPublishPreviewPager)).setAdapter(this.f17161e);
        ArrayList arrayList = new ArrayList();
        if (stringArrayList != null) {
            Iterator<String> iterator2 = stringArrayList.iterator2();
            while (iterator2.hasNext()) {
                String next = iterator2.next();
                if (!(next == null || next.length() == 0)) {
                    arrayList.add(new LocalMedia(0L, null, w.f54826a.a(new File(next)).toString(), next, 0L, 0, 0, null, 0L, 499, null));
                }
            }
        }
        PreviewMediaData.INSTANCE.setList(arrayList);
        MediaPreviewPagerAdapter mediaPreviewPagerAdapter = this.f17161e;
        if (mediaPreviewPagerAdapter != null) {
            mediaPreviewPagerAdapter.b();
        }
        ((ViewPager) S0(R$id.feedPublishPreviewPager)).addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.cupidapp.live.mediapicker.fragment.FeedPublishPreviewFragment$onViewCreated$5
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i11) {
                ((CustomIndicator) FeedPublishPreviewFragment.this.S0(R$id.feedPublishPreviewIndicator)).n(i11);
            }
        });
        int i11 = R$id.feedPublishPreviewIndicator;
        ViewGroup.LayoutParams layoutParams = ((CustomIndicator) S0(i11)).getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.topMargin = (int) (((z0.h.l(this) / T0()) / 2) + z0.h.c(this, 10.0f));
        }
        ((CustomIndicator) S0(i11)).setLayoutParams(layoutParams2);
        ((CustomIndicator) S0(i11)).setVisibility(arrayList.size() <= 1 ? 8 : 0);
        ((CustomIndicator) S0(i11)).setPagerCount(arrayList.size());
    }
}
