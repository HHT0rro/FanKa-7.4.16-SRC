package com.cupidapp.live.feed.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.base.view.viewpager.BasePagerAdapter;
import com.cupidapp.live.feed.layout.SingleFeedImageLayout;
import com.cupidapp.live.feed.model.FeedImageInfoModel;
import d2.a;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedMultiImageAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedMultiImageAdapter extends BasePagerAdapter {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<FeedImageInfoModel> f14182e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public a f14183f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedMultiImageAdapter(@NotNull List<FeedImageInfoModel> modelList) {
        super(modelList, null, 2, null);
        s.i(modelList, "modelList");
        this.f14182e = modelList;
    }

    @Override // com.cupidapp.live.base.view.viewpager.BasePagerAdapter
    public void a(@NotNull View itemView, @NotNull Object model, int i10, boolean z10) {
        s.i(itemView, "itemView");
        s.i(model, "model");
        if ((itemView instanceof SingleFeedImageLayout) && (model instanceof FeedImageInfoModel)) {
            ((SingleFeedImageLayout) itemView).d((FeedImageInfoModel) model);
        }
    }

    @Override // com.cupidapp.live.base.view.viewpager.BasePagerAdapter
    @NotNull
    public List<FeedImageInfoModel> b() {
        return this.f14182e;
    }

    @Override // com.cupidapp.live.base.view.viewpager.BasePagerAdapter
    @NotNull
    public View c(@NotNull ViewGroup container, @NotNull Object model, int i10) {
        s.i(container, "container");
        s.i(model, "model");
        Context context = container.getContext();
        s.h(context, "container.context");
        SingleFeedImageLayout singleFeedImageLayout = new SingleFeedImageLayout(context);
        singleFeedImageLayout.setFeedImageClickListener(this.f14183f);
        return singleFeedImageLayout;
    }

    public final void d(@NotNull a listener) {
        s.i(listener, "listener");
        this.f14183f = listener;
    }
}
