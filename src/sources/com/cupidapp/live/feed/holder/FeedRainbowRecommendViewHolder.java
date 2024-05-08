package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.decoration.ExtraSpacingDecoration;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.feed.adapter.FeedRainbowRecommendAdapter;
import com.cupidapp.live.feed.adapter.FeedRainbowRecommendItemModel;
import com.cupidapp.live.match.activity.NearByMiniProfileActivity;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: FeedRainbowRecommendViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRainbowRecommendViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f14385e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public f f14386c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f14387d;

    /* compiled from: FeedRainbowRecommendViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedRainbowRecommendViewHolder a(@NotNull ViewGroup parent, @Nullable f fVar) {
            s.i(parent, "parent");
            FeedRainbowRecommendViewHolder feedRainbowRecommendViewHolder = new FeedRainbowRecommendViewHolder(z.b(parent, R$layout.view_holder_feed_rainbow_recommend, false, 2, null));
            feedRainbowRecommendViewHolder.f14386c = fVar;
            return feedRainbowRecommendViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedRainbowRecommendViewHolder(@NotNull final View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f14387d = kotlin.c.b(new Function0<FeedRainbowRecommendAdapter>() { // from class: com.cupidapp.live.feed.holder.FeedRainbowRecommendViewHolder$rainbowRecommendAdapter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FeedRainbowRecommendAdapter invoke() {
                FeedRainbowRecommendAdapter feedRainbowRecommendAdapter = new FeedRainbowRecommendAdapter();
                final View view = View.this;
                final FeedRainbowRecommendViewHolder feedRainbowRecommendViewHolder = this;
                feedRainbowRecommendAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.holder.FeedRainbowRecommendViewHolder$rainbowRecommendAdapter$2$1$1
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
                        if (obj instanceof FeedRainbowRecommendItemModel) {
                            FeedRainbowRecommendItemModel feedRainbowRecommendItemModel = (FeedRainbowRecommendItemModel) obj;
                            NearByMiniProfileActivity.f16517r.a(View.this.getContext(), new NearbyUserModel(feedRainbowRecommendItemModel.getUser().getId(), false, false, false, false, false, feedRainbowRecommendItemModel.getUser().getAvatarImage(), feedRainbowRecommendItemModel.getUser().getName(), null, null, false, false, false, null, null, null, null, false, false, false, null, 2096958, null), SensorScene.FeedRainbowRecommend, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? false : false, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : SensorPosition.Feed, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? false : true);
                        }
                    }
                });
                feedRainbowRecommendAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.recommend_textview), new Function1<Object, p>() { // from class: com.cupidapp.live.feed.holder.FeedRainbowRecommendViewHolder$rainbowRecommendAdapter$2$1$2
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
                        f fVar;
                        fVar = FeedRainbowRecommendViewHolder.this.f14386c;
                        if (fVar != null) {
                            fVar.a();
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.aloha_imageview), new Function1<Object, p>() { // from class: com.cupidapp.live.feed.holder.FeedRainbowRecommendViewHolder$rainbowRecommendAdapter$2$1$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r0 = r1.f14386c;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.feed.adapter.FeedRainbowRecommendItemModel
                            if (r0 == 0) goto L19
                            com.cupidapp.live.feed.holder.FeedRainbowRecommendViewHolder r0 = com.cupidapp.live.feed.holder.FeedRainbowRecommendViewHolder.this
                            com.cupidapp.live.feed.holder.f r0 = com.cupidapp.live.feed.holder.FeedRainbowRecommendViewHolder.r(r0)
                            if (r0 == 0) goto L19
                            com.cupidapp.live.feed.adapter.FeedRainbowRecommendItemModel r2 = (com.cupidapp.live.feed.adapter.FeedRainbowRecommendItemModel) r2
                            com.cupidapp.live.feed.model.UserWithPostLimitStatusModel r2 = r2.getUser()
                            java.lang.String r2 = r2.getId()
                            r0.b(r2)
                        L19:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.holder.FeedRainbowRecommendViewHolder$rainbowRecommendAdapter$2$1$3.invoke2(java.lang.Object):void");
                    }
                })));
                ExposureScene exposureScene = ExposureScene.RainbowRecommend;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.rainbow_recommend_recyclerview);
                s.h(recyclerView, "itemView.rainbow_recommend_recyclerview");
                feedRainbowRecommendAdapter.t(new RecyclerExposureHelper(exposureScene, recyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.feed.holder.FeedRainbowRecommendViewHolder$rainbowRecommendAdapter$2$1$4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(List<? extends h1.a> list) {
                        invoke2((List<h1.a>) list);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull List<h1.a> list) {
                        s.i(list, "list");
                        Iterator<h1.a> iterator2 = list.iterator2();
                        while (iterator2.hasNext()) {
                            Object a10 = iterator2.next().a();
                            if (a10 instanceof FeedRainbowRecommendItemModel) {
                                GroupSocialLog.f18708a.w(SensorScene.FeedRainbowRecommend.getValue(), ((FeedRainbowRecommendItemModel) a10).getUser().getId(), (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : true, (r29 & 2048) != 0 ? false : false);
                            }
                        }
                    }
                }, 28, null));
                return feedRainbowRecommendAdapter;
            }
        });
        TextView textView = (TextView) itemView.findViewById(R$id.rainbow_recommend_textview);
        s.h(textView, "itemView.rainbow_recommend_textview");
        u.a(textView);
        TextView textView2 = (TextView) itemView.findViewById(R$id.see_more_textview);
        s.h(textView2, "itemView.see_more_textview");
        u.a(textView2);
        RecyclerView _init_$lambda$0 = (RecyclerView) itemView.findViewById(R$id.rainbow_recommend_recyclerview);
        _init_$lambda$0.setAdapter(t());
        _init_$lambda$0.setLayoutManager(new LinearLayoutManager(itemView.getContext(), 0, false));
        s.h(_init_$lambda$0, "_init_$lambda$0");
        _init_$lambda$0.addItemDecoration(new ExtraSpacingDecoration(z0.h.c(_init_$lambda$0, 6.0f), 0, z0.h.c(_init_$lambda$0, 6.0f), 0, z0.h.c(_init_$lambda$0, 6.0f)));
        RecyclerView.ItemAnimator itemAnimator = _init_$lambda$0.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator == null) {
            return;
        }
        simpleItemAnimator.setSupportsChangeAnimations(false);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedRainbowRecommendModel) {
            t().j().clear();
            t().e(((FeedRainbowRecommendModel) obj).getRecommendList());
            t().notifyDataSetChanged();
        }
    }

    public final FeedRainbowRecommendAdapter t() {
        return (FeedRainbowRecommendAdapter) this.f14387d.getValue();
    }

    public final void u(@NotNull String userId, boolean z10) {
        Object obj;
        s.i(userId, "userId");
        List<Object> j10 = t().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : j10) {
            if (obj2 instanceof FeedRainbowRecommendItemModel) {
                arrayList.add(obj2);
            }
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (true) {
            if (iterator2.hasNext()) {
                obj = iterator2.next();
                if (s.d(((FeedRainbowRecommendItemModel) obj).getUser().getId(), userId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedRainbowRecommendItemModel feedRainbowRecommendItemModel = (FeedRainbowRecommendItemModel) obj;
        if (feedRainbowRecommendItemModel != null) {
            feedRainbowRecommendItemModel.getUser().setAloha(Boolean.valueOf(z10));
            t().notifyItemChanged(t().j().indexOf(feedRainbowRecommendItemModel));
        }
    }
}
