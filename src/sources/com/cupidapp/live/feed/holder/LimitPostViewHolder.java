package com.cupidapp.live.feed.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.dialog.BgColor;
import com.cupidapp.live.base.view.dialog.FKPointerDialog;
import com.cupidapp.live.base.view.dialog.PointerPos;
import com.cupidapp.live.feed.adapter.FeedLimitItemAdapter;
import com.cupidapp.live.feed.model.FeedPostLimitGuideModel;
import com.cupidapp.live.feed.model.UserWithPostLimitStatusModel;
import com.cupidapp.live.profile.model.PostLimitReadStatus;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: LimitPostViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LimitPostViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f14398d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public FeedLimitItemAdapter f14399c;

    /* compiled from: LimitPostViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LimitPostViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new LimitPostViewHolder(z.b(parent, R$layout.view_holder_feed_limit_time, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LimitPostViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((RecyclerView) itemView.findViewById(R$id.limit_feed_rv)).setLayoutManager(new LinearLayoutManager(itemView.getContext(), 0, false));
    }

    public static final void u(RecyclerView recyclerView, LimitPostViewHolder this$0) {
        s.i(this$0, "this$0");
        int[] iArr = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        FKPointerDialog.a aVar = FKPointerDialog.f12718p;
        Context context = this$0.itemView.getContext();
        s.h(context, "itemView.context");
        FKPointerDialog a10 = aVar.a(context);
        String string = this$0.itemView.getContext().getString(R$string.publish_txt_post_limit);
        s.h(string, "itemView.context.getStri…g.publish_txt_post_limit)");
        FKPointerDialog.t(a10.n(string).o(8388611).j(Float.valueOf(0.0f)).q(PointerPos.BOTTOM_LEFT, BgColor.DEFAULT), z0.h.c(this$0, 12.0f), iArr[1] - z0.h.c(this$0, 82.0f), null, BadgeDrawable.TOP_START, 0, null, 52, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        if (kotlin.jvm.internal.s.d(r0 != null ? r0.u() : null, ((com.cupidapp.live.feed.model.PostLimitFriendsModel) r4).getRcmdType()) == false) goto L11;
     */
    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n(@org.jetbrains.annotations.Nullable java.lang.Object r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.itemView
            int r1 = com.cupidapp.live.R$id.post_limit_title
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "itemView.post_limit_title"
            kotlin.jvm.internal.s.h(r0, r2)
            z0.u.a(r0)
            boolean r0 = r4 instanceof com.cupidapp.live.feed.model.PostLimitFriendsModel
            if (r0 == 0) goto Lad
            com.cupidapp.live.feed.adapter.FeedLimitItemAdapter r0 = r3.f14399c
            if (r0 == 0) goto L2f
            if (r0 == 0) goto L21
            java.lang.String r0 = r0.u()
            goto L22
        L21:
            r0 = 0
        L22:
            r2 = r4
            com.cupidapp.live.feed.model.PostLimitFriendsModel r2 = (com.cupidapp.live.feed.model.PostLimitFriendsModel) r2
            java.lang.String r2 = r2.getRcmdType()
            boolean r0 = kotlin.jvm.internal.s.d(r0, r2)
            if (r0 != 0) goto L4b
        L2f:
            r0 = r4
            com.cupidapp.live.feed.model.PostLimitFriendsModel r0 = (com.cupidapp.live.feed.model.PostLimitFriendsModel) r0
            java.lang.String r0 = r0.getRcmdType()
            com.cupidapp.live.feed.adapter.FeedLimitItemAdapter r0 = r3.v(r0)
            r3.f14399c = r0
            android.view.View r0 = r3.itemView
            int r2 = com.cupidapp.live.R$id.limit_feed_rv
            android.view.View r0 = r0.findViewById(r2)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            com.cupidapp.live.feed.adapter.FeedLimitItemAdapter r2 = r3.f14399c
            r0.setAdapter(r2)
        L4b:
            com.cupidapp.live.feed.model.PostLimitFriendsModel r4 = (com.cupidapp.live.feed.model.PostLimitFriendsModel) r4
            java.lang.String r0 = r4.getTitle()
            r2 = 0
            if (r0 == 0) goto L5d
            int r0 = r0.length()
            if (r0 != 0) goto L5b
            goto L5d
        L5b:
            r0 = 0
            goto L5e
        L5d:
            r0 = 1
        L5e:
            if (r0 == 0) goto L6e
            android.view.View r0 = r3.itemView
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 8
            r0.setVisibility(r1)
            goto L88
        L6e:
            android.view.View r0 = r3.itemView
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r2)
            android.view.View r0 = r3.itemView
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r4.getTitle()
            r0.setText(r1)
        L88:
            com.cupidapp.live.feed.adapter.FeedLimitItemAdapter r0 = r3.f14399c
            if (r0 == 0) goto L95
            java.util.List r0 = r0.j()
            if (r0 == 0) goto L95
            r0.clear()
        L95:
            com.cupidapp.live.feed.adapter.FeedLimitItemAdapter r0 = r3.f14399c
            if (r0 == 0) goto La6
            java.util.List r0 = r0.j()
            if (r0 == 0) goto La6
            java.util.List r4 = r4.getData()
            r0.addAll(r4)
        La6:
            com.cupidapp.live.feed.adapter.FeedLimitItemAdapter r4 = r3.f14399c
            if (r4 == 0) goto Lad
            r4.notifyDataSetChanged()
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.holder.LimitPostViewHolder.n(java.lang.Object):void");
    }

    public final void t() {
        p1.g.f52734a.j2(new FeedPostLimitGuideModel(false, -1));
        final RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R$id.limit_feed_rv);
        recyclerView.post(new Runnable() { // from class: com.cupidapp.live.feed.holder.e
            @Override // java.lang.Runnable
            public final void run() {
                LimitPostViewHolder.u(RecyclerView.this, this);
            }
        });
    }

    @NotNull
    public final FeedLimitItemAdapter v(@Nullable String str) {
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R$id.limit_feed_rv);
        s.h(recyclerView, "itemView.limit_feed_rv");
        FeedLimitItemAdapter feedLimitItemAdapter = new FeedLimitItemAdapter(recyclerView, str);
        feedLimitItemAdapter.l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.item_feed_limit_root), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.feed.holder.LimitPostViewHolder$getLimitAdapter$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                FeedLimitItemAdapter feedLimitItemAdapter2;
                List j10;
                FeedLimitItemAdapter feedLimitItemAdapter3;
                List<Object> j11;
                if (obj instanceof UserWithPostLimitStatusModel) {
                    UserWithPostLimitStatusModel userWithPostLimitStatusModel = (UserWithPostLimitStatusModel) obj;
                    if (s.d(userWithPostLimitStatusModel.getReadStatus(), PostLimitReadStatus.NoPostLimit.getValue()) && com.cupidapp.live.profile.logic.c.f17839a.a(userWithPostLimitStatusModel.getId())) {
                        EventBus.c().l(new OpenPostEditEvent());
                        return;
                    }
                    EventBus c4 = EventBus.c();
                    feedLimitItemAdapter2 = LimitPostViewHolder.this.f14399c;
                    if (feedLimitItemAdapter2 != null && (j11 = feedLimitItemAdapter2.j()) != null) {
                        j10 = new ArrayList();
                        for (Object obj2 : j11) {
                            String id2 = obj2 instanceof UserWithPostLimitStatusModel ? ((UserWithPostLimitStatusModel) obj2).getId() : null;
                            if (id2 != null) {
                                j10.add(id2);
                            }
                        }
                    } else {
                        j10 = kotlin.collections.s.j();
                    }
                    feedLimitItemAdapter3 = LimitPostViewHolder.this.f14399c;
                    c4.l(new OpenPostLimitEvent(j10, i10, feedLimitItemAdapter3 != null ? feedLimitItemAdapter3.u() : null));
                }
            }
        })));
        return feedLimitItemAdapter;
    }

    public final void w() {
        FeedLimitItemAdapter feedLimitItemAdapter = this.f14399c;
        if (feedLimitItemAdapter != null) {
            feedLimitItemAdapter.w();
        }
    }

    public final void x() {
        ((RecyclerView) this.itemView.findViewById(R$id.limit_feed_rv)).scrollToPosition(0);
    }
}
