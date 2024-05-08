package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity;
import com.cupidapp.live.feed.adapter.FeedClassifyAdapter;
import com.cupidapp.live.feed.adapter.FeedClassifyItemViewHolder;
import com.cupidapp.live.feed.adapter.FeedClassifyModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FeedClassifyViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedClassifyViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f14375d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f14376c;

    /* compiled from: FeedClassifyViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedClassifyViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            FeedClassifyViewHolder feedClassifyViewHolder = new FeedClassifyViewHolder(z.b(parent, R$layout.view_holder_feed_classify, false, 2, null));
            feedClassifyViewHolder.q();
            return feedClassifyViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedClassifyViewHolder(@NotNull final View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f14376c = kotlin.c.b(new Function0<FeedClassifyAdapter>() { // from class: com.cupidapp.live.feed.holder.FeedClassifyViewHolder$classifyAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FeedClassifyAdapter invoke() {
                FeedClassifyAdapter feedClassifyAdapter = new FeedClassifyAdapter();
                final View view = View.this;
                feedClassifyAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.holder.FeedClassifyViewHolder$classifyAdapter$2$1$1
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
                        if (obj instanceof FeedClassifyModel) {
                            FeedClassifyModel feedClassifyModel = (FeedClassifyModel) obj;
                            String url = feedClassifyModel.getUrl();
                            if (url == null || url.length() == 0) {
                                FeedClassifyDetailListActivity.f14021x.a(View.this.getContext(), feedClassifyModel.getTag(), feedClassifyModel.getTagName(), null, new FeedSensorContext(SensorPosition.FindPageCategory, SensorPosition.RecommendFeed, null, SensorScene.RecommendFeed));
                            } else {
                                j.a.b(j.f12156c, View.this.getContext(), feedClassifyModel.getUrl(), null, 4, null);
                            }
                            GroupSocialLog.f18708a.f(feedClassifyModel.getTag());
                        }
                    }
                });
                return feedClassifyAdapter;
            }
        });
        RecyclerView _init_$lambda$0 = (RecyclerView) itemView.findViewById(R$id.classify_recyclerview);
        _init_$lambda$0.setLayoutManager(new GridLayoutManager(itemView.getContext(), 4));
        _init_$lambda$0.setAdapter(r());
        RecyclerView.ItemAnimator itemAnimator = _init_$lambda$0.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        s.h(_init_$lambda$0, "_init_$lambda$0");
        int c4 = z0.h.c(_init_$lambda$0, 52.0f) - FeedClassifyItemViewHolder.f14172c.b();
        _init_$lambda$0.setPadding(c4, z0.h.c(_init_$lambda$0, 14.0f), c4, z0.h.c(_init_$lambda$0, 12.0f));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedClassifyListModel) {
            r().j().clear();
            r().e(((FeedClassifyListModel) obj).getList());
            r().notifyDataSetChanged();
        }
    }

    public final FeedClassifyAdapter r() {
        return (FeedClassifyAdapter) this.f14376c.getValue();
    }
}
