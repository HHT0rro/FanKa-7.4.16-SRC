package com.cupidapp.live.feed.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.feed.holder.FeedLimitItemViewHolder;
import com.cupidapp.live.feed.model.UserWithPostLimitStatusModel;
import h1.a;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedLimitItemAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedLimitItemAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f14181f;

    public FeedLimitItemAdapter(@NotNull RecyclerView recyclerView, @Nullable String str) {
        s.i(recyclerView, "recyclerView");
        this.f14181f = str;
        k().add(UserWithPostLimitStatusModel.class);
        t(new RecyclerExposureHelper(ExposureScene.FeedLimit, recyclerView, 0.0f, 0L, str, new Function1<List<? extends a>, p>() { // from class: com.cupidapp.live.feed.adapter.FeedLimitItemAdapter.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends a> list) {
                invoke2((List<a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<a> itemList) {
                s.i(itemList, "itemList");
                FeedLimitItemAdapter feedLimitItemAdapter = FeedLimitItemAdapter.this;
                Iterator<a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof UserWithPostLimitStatusModel) {
                        SensorsLogFeed.f12208a.s(((UserWithPostLimitStatusModel) a10).getId(), feedLimitItemAdapter.j().indexOf(a10) + 1, feedLimitItemAdapter.u());
                    }
                }
            }
        }, 12, null));
    }

    @Nullable
    public final String u() {
        return this.f14181f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        FeedLimitItemViewHolder a10 = FeedLimitItemViewHolder.f14383c.a(parent);
        a10.k(l());
        return a10;
    }

    public final void w() {
        RecyclerExposureHelper g3 = g();
        if (g3 != null) {
            g3.j();
        }
        RecyclerExposureHelper g10 = g();
        if (g10 != null) {
            g10.d();
        }
    }
}
