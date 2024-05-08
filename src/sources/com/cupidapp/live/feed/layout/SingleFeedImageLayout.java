package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.DiskCacheType;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.utils.k0;
import com.cupidapp.live.base.view.viewpager.FKBasePagerLayout;
import com.cupidapp.live.feed.holder.BaseFeedViewHolder;
import com.cupidapp.live.feed.model.FeedImageInfoModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SingleFeedImageLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SingleFeedImageLayout extends FKBasePagerLayout {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public d2.a f14571c;

    /* renamed from: d, reason: collision with root package name */
    public float f14572d;

    /* renamed from: e, reason: collision with root package name */
    public float f14573e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public FeedImageInfoModel f14574f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14575g;

    /* compiled from: SingleFeedImageLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends k0 {
        public a() {
            super(300L);
        }

        @Override // com.cupidapp.live.base.utils.k0
        public void c(@Nullable View view) {
            d2.a feedImageClickListener = SingleFeedImageLayout.this.getFeedImageClickListener();
            if (feedImageClickListener != null) {
                feedImageClickListener.d();
            }
        }

        @Override // com.cupidapp.live.base.utils.k0
        public void d(@Nullable View view) {
            d2.a feedImageClickListener = SingleFeedImageLayout.this.getFeedImageClickListener();
            if (feedImageClickListener != null) {
                feedImageClickListener.e(SingleFeedImageLayout.this.f14572d, SingleFeedImageLayout.this.f14573e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleFeedImageLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14575g = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f14575g;
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

    public final void d(@NotNull FeedImageInfoModel imageInfo) {
        kotlin.jvm.internal.s.i(imageInfo, "imageInfo");
        this.f14574f = imageInfo;
        Pair<Integer, Integer> a10 = BaseFeedViewHolder.f14365i.a(imageInfo.getImage());
        int i10 = R$id.postImageView;
        ((ImageLoaderView) a(i10)).getLayoutParams().height = a10.getSecond().intValue();
        ImageLoaderView postImageView = (ImageLoaderView) a(i10);
        kotlin.jvm.internal.s.h(postImageView, "postImageView");
        ImageLoaderView.g(postImageView, imageInfo.getImage(), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, null, null, false, a10.getFirst().intValue(), a10.getSecond().intValue(), false, DiskCacheType.DATA, null, 344063, null), null, 4, null);
    }

    public final void e() {
        setOnClickListener(new a());
    }

    public final void f() {
        z.a(this, R$layout.layout_single_feed_image, true);
        e();
    }

    @Nullable
    public final d2.a getFeedImageClickListener() {
        return this.f14571c;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        boolean z10 = false;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            z10 = true;
        }
        if (z10) {
            this.f14572d = motionEvent.getX();
            this.f14573e = motionEvent.getY();
        }
        d2.a aVar = this.f14571c;
        if (aVar != null) {
            FeedImageInfoModel feedImageInfoModel = this.f14574f;
            aVar.g(motionEvent, feedImageInfoModel != null ? feedImageInfoModel.getImage() : null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setFeedImageClickListener(@Nullable d2.a aVar) {
        this.f14571c = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleFeedImageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14575g = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleFeedImageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14575g = new LinkedHashMap();
        f();
    }
}
