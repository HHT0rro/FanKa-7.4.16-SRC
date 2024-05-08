package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.feed.adapter.FeedMultiImageAdapter;
import com.cupidapp.live.feed.holder.BaseFeedViewHolder;
import com.cupidapp.live.feed.layout.FeedImageContentLayout;
import com.cupidapp.live.feed.model.FeedImageInfoModel;
import com.cupidapp.live.feed.model.FeedModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FeedImageContentLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedImageContentLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public SensorPosition f14462b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public SensorScene f14463c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public FeedMultiImageAdapter f14464d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FeedModel f14465e;

    /* renamed from: f, reason: collision with root package name */
    public int f14466f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public a f14467g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14468h;

    /* compiled from: FeedImageContentLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a(int i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedImageContentLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14468h = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f14468h;
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

    public final void e(final FeedModel feedModel) {
        ImageModel imageListFirst = feedModel.getImageListFirst();
        if (imageListFirst == null) {
            return;
        }
        int i10 = R$id.multiImageViewPager;
        ((FeedImageViewPager) a(i10)).getLayoutParams().height = BaseFeedViewHolder.f14365i.a(imageListFirst).getSecond().intValue();
        List<FeedImageInfoModel> imageInfoList = feedModel.getImageInfoList();
        if (imageInfoList != null) {
            this.f14464d = new FeedMultiImageAdapter(imageInfoList);
        }
        ((FeedImageViewPager) a(i10)).setOffscreenPageLimit(2);
        ((FeedImageViewPager) a(i10)).setAdapter(this.f14464d);
        ((FeedImageViewPager) a(i10)).addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.cupidapp.live.feed.layout.FeedImageContentLayout$configImageContent$2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i11) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i11, float f10, int i12) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i11) {
                FeedImageContentLayout.a aVar;
                SensorScene sensorScene;
                aVar = FeedImageContentLayout.this.f14467g;
                if (aVar != null) {
                    aVar.a(i11);
                }
                ((TextView) FeedImageContentLayout.this.a(R$id.imageProportion)).setText(FeedImageContentLayout.this.getContext().getString(R$string.proportion, Integer.valueOf(i11 + 1), Integer.valueOf(feedModel.getImageListCount())));
                FeedImageContentLayout feedImageContentLayout = FeedImageContentLayout.this;
                sensorScene = feedImageContentLayout.f14463c;
                feedImageContentLayout.g(i11, sensorScene);
            }
        });
        FeedMultiImageAdapter feedMultiImageAdapter = this.f14464d;
        if (feedMultiImageAdapter != null) {
            feedMultiImageAdapter.notifyDataSetChanged();
        }
        if (feedModel.getImageListCount() <= 1) {
            ((TextView) a(R$id.imageProportion)).setVisibility(8);
        } else {
            int i11 = R$id.imageProportion;
            ((TextView) a(i11)).setVisibility(0);
            ((TextView) a(i11)).setText(getContext().getString(R$string.proportion, 1, Integer.valueOf(feedModel.getImageListCount())));
        }
        a(R$id.feedImageBottomLineView).setVisibility((!feedModel.haveSponsor() || feedModel.getImageListCount() > 1) ? 0 : 8);
        h(feedModel);
    }

    public final void f() {
        z.a(this, R$layout.layout_feed_image_content, true);
        ((TextView) a(R$id.imageProportion)).getPaint().setFakeBoldText(true);
    }

    public final void g(int i10, SensorScene sensorScene) {
        FeedModel feedModel = this.f14465e;
        if (feedModel != null && i10 > this.f14466f) {
            SensorsLogMatch.f12215a.d(feedModel.getUser().userId(), i10, feedModel.getImageListCount(), feedModel.getPostId(), this.f14462b, sensorScene, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? null : null);
        }
        this.f14466f = i10;
    }

    @Nullable
    public final FeedModel getFeedModel() {
        return this.f14465e;
    }

    public final void h(FeedModel feedModel) {
        if (feedModel.getImageListCount() > 1) {
            p1.g gVar = p1.g.f52734a;
            if (kotlin.jvm.internal.s.d(gVar.y(), Boolean.TRUE)) {
                int i10 = R$id.multiImageGuide;
                ((ImageView) a(i10)).setVisibility(0);
                ImageView multiImageGuide = (ImageView) a(i10);
                kotlin.jvm.internal.s.h(multiImageGuide, "multiImageGuide");
                y.d(multiImageGuide, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedImageContentLayout$showMultiImageGuide$1
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
                        ((ImageView) FeedImageContentLayout.this.a(R$id.multiImageGuide)).setVisibility(8);
                    }
                });
                gVar.i2(Boolean.FALSE);
                return;
            }
        }
        ((ImageView) a(R$id.multiImageGuide)).setVisibility(8);
    }

    public final void setFeedImageClickListener(@NotNull d2.a listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        FeedMultiImageAdapter feedMultiImageAdapter = this.f14464d;
        if (feedMultiImageAdapter != null) {
            feedMultiImageAdapter.d(listener);
        }
    }

    public final void setFeedModel(@Nullable FeedModel feedModel) {
        this.f14465e = feedModel;
        if (feedModel == null) {
            return;
        }
        e(feedModel);
    }

    public final void setOnImageContentListener(@NotNull a listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f14467g = listener;
    }

    public final void setSensorPos(@Nullable SensorPosition sensorPosition) {
        this.f14462b = sensorPosition;
    }

    public final void setSensorScene(@Nullable SensorScene sensorScene) {
        this.f14463c = sensorScene;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedImageContentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14468h = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedImageContentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14468h = new LinkedHashMap();
        f();
    }
}
