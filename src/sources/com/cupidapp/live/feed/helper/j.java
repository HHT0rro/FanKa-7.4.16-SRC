package com.cupidapp.live.feed.helper;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.utils.c0;
import com.cupidapp.live.feed.FeedType;
import com.cupidapp.live.feed.holder.BaseFeedViewHolder;
import com.cupidapp.live.feed.holder.LimitPostViewHolder;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedPostLimitGuideModel;
import com.cupidapp.live.feed.model.FeedPraiseGuideModel;
import com.cupidapp.live.feed.model.FeedZoomGuideModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedVideoPlayHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f14342h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final RecyclerView f14343a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14344b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14345c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<Object>[] f14346d;

    /* renamed from: e, reason: collision with root package name */
    public int f14347e;

    /* renamed from: f, reason: collision with root package name */
    public final int f14348f;

    /* renamed from: g, reason: collision with root package name */
    public final int f14349g;

    /* compiled from: FeedVideoPlayHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(@NotNull Context context, @NotNull RecyclerView feedRecyclerView, int i10, int i11, @NotNull List<Object>... modelList) {
        s.i(context, "context");
        s.i(feedRecyclerView, "feedRecyclerView");
        s.i(modelList, "modelList");
        this.f14343a = feedRecyclerView;
        this.f14344b = i10;
        this.f14345c = i11;
        this.f14346d = modelList;
        this.f14347e = -1;
        this.f14348f = z0.h.m(context) + z0.h.c(this, 48.0f);
        this.f14349g = z0.h.k(this) - z0.h.c(this, 200.0f);
    }

    public final void a() {
        Pair<Integer, Integer> b4;
        LinearLayoutManager g3;
        View findViewByPosition;
        p1.g gVar = p1.g.f52734a;
        FeedPraiseGuideModel A = gVar.A();
        if (A != null && A.isFirstDisplay() && A.isClickPraiseButton()) {
            int showPosition = A.getShowPosition();
            LinearLayoutManager g10 = g();
            if (g10 == null || (b4 = c0.b(g10)) == null) {
                return;
            }
            if (!(showPosition <= b4.getSecond().intValue() && b4.getFirst().intValue() <= showPosition) || (g3 = g()) == null || (findViewByPosition = g3.findViewByPosition(showPosition)) == null) {
                return;
            }
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.f14343a.findViewHolderForLayoutPosition(showPosition);
            BaseFeedViewHolder baseFeedViewHolder = findViewHolderForLayoutPosition instanceof BaseFeedViewHolder ? (BaseFeedViewHolder) findViewHolderForLayoutPosition : null;
            if (baseFeedViewHolder != null && findViewByPosition.getTop() <= this.f14349g && findViewByPosition.getBottom() >= this.f14348f) {
                if (baseFeedViewHolder.G()) {
                    A.setShowPosition(A.getShowPosition() + 1);
                    gVar.k2(A);
                } else {
                    baseFeedViewHolder.R("feed_praise_guide_webp.webp");
                    A.setFirstDisplay(false);
                    gVar.k2(A);
                }
            }
        }
    }

    public final void b() {
        Pair<Integer, Integer> b4;
        p1.g gVar = p1.g.f52734a;
        FeedZoomGuideModel D = gVar.D();
        if (D == null || !D.isFirstDisplay()) {
            return;
        }
        FeedPraiseGuideModel A = gVar.A();
        if (A != null && D.getBottomPosition() == A.getShowPosition()) {
            D.setTopPosition(D.getBottomPosition() - 10);
            D.setBottomPosition(D.getBottomPosition() + 10);
            gVar.n2(D);
            return;
        }
        LinearLayoutManager g3 = g();
        if (g3 == null || (b4 = c0.b(g3)) == null) {
            return;
        }
        int intValue = b4.getFirst().intValue();
        int intValue2 = b4.getSecond().intValue();
        int topPosition = D.getTopPosition();
        boolean z10 = false;
        if (intValue <= topPosition && topPosition <= intValue2) {
            FeedModel f10 = f(D.getTopPosition());
            if (s.d(f10 != null ? f10.getType() : null, FeedType.VideoPost.getValue())) {
                D.setTopPosition(D.getTopPosition() - 1);
                gVar.n2(D);
                return;
            } else {
                n(D, D.getTopPosition());
                return;
            }
        }
        int intValue3 = b4.getFirst().intValue();
        int intValue4 = b4.getSecond().intValue();
        int bottomPosition = D.getBottomPosition();
        if (intValue3 <= bottomPosition && bottomPosition <= intValue4) {
            z10 = true;
        }
        if (z10) {
            FeedModel f11 = f(D.getBottomPosition());
            if (s.d(f11 != null ? f11.getType() : null, FeedType.VideoPost.getValue())) {
                D.setBottomPosition(D.getBottomPosition() + 1);
                gVar.n2(D);
            } else {
                n(D, D.getBottomPosition());
            }
        }
    }

    public final void c() {
        LinearLayoutManager g3;
        Pair<Integer, Integer> b4;
        FeedPostLimitGuideModel z10 = p1.g.f52734a.z();
        if (z10 == null || !z10.isFirstDisplay() || z10.getShowPosition() == -1 || (g3 = g()) == null || (b4 = c0.b(g3)) == null || z10.getShowPosition() <= b4.getFirst().intValue() || z10.getShowPosition() >= b4.getSecond().intValue()) {
            return;
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.f14343a.findViewHolderForLayoutPosition(z10.getShowPosition());
        LimitPostViewHolder limitPostViewHolder = findViewHolderForLayoutPosition instanceof LimitPostViewHolder ? (LimitPostViewHolder) findViewHolderForLayoutPosition : null;
        if (limitPostViewHolder != null) {
            limitPostViewHolder.t();
        }
    }

    @Nullable
    public final FeedModel d() {
        Pair<Integer, Integer> b4;
        int intValue;
        LinearLayoutManager g3 = g();
        if (g3 == null || (b4 = c0.b(g3)) == null) {
            return null;
        }
        Pair<Integer, Integer> a10 = c0.a(g3);
        if (a10 != null && (intValue = a10.getFirst().intValue()) <= a10.getSecond().intValue()) {
            if (i() > intValue) {
                return f(intValue);
            }
            return null;
        }
        int intValue2 = b4.getFirst().intValue();
        int intValue3 = b4.getSecond().intValue();
        if (intValue2 <= intValue3) {
            while (true) {
                View findViewByPosition = g3.findViewByPosition(intValue2);
                RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.f14343a.findViewHolderForLayoutPosition(intValue2);
                BaseFeedViewHolder baseFeedViewHolder = findViewHolderForLayoutPosition instanceof BaseFeedViewHolder ? (BaseFeedViewHolder) findViewHolderForLayoutPosition : null;
                if (i() > intValue2) {
                    FeedModel f10 = f(intValue2);
                    if (baseFeedViewHolder != null && f10 != null) {
                        int height = baseFeedViewHolder.itemView.getHeight();
                        int top = findViewByPosition != null ? findViewByPosition.getTop() : 0;
                        int i10 = height + top;
                        int i11 = this.f14344b;
                        if (i10 >= i11 && top <= i11) {
                            return f10;
                        }
                    }
                }
                if (intValue2 == intValue3) {
                    break;
                }
                intValue2++;
            }
        }
        return null;
    }

    public final int e(@NotNull FeedModel value) {
        s.i(value, "value");
        int length = this.f14346d.length;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = -1;
            if (i10 >= length) {
                return -1;
            }
            List<Object> list = this.f14346d[i10];
            Iterator<Object> iterator2 = list.iterator2();
            int i13 = 0;
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                if (s.d(iterator2.next(), value)) {
                    i12 = i13;
                    break;
                }
                i13++;
            }
            if (i12 >= 0) {
                return i12 + i11;
            }
            i11 += list.size();
            i10++;
        }
    }

    public final FeedModel f(int i10) {
        int i11 = i();
        if (i10 < 0 || i10 >= i11) {
            return null;
        }
        int length = this.f14346d.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            List<Object> list = this.f14346d[i13];
            if (i10 < list.size() + i12) {
                Object obj = list.get(i10 - i12);
                if (obj instanceof FeedModel) {
                    return (FeedModel) obj;
                }
                return null;
            }
            i12 += list.size();
        }
        return null;
    }

    public final LinearLayoutManager g() {
        RecyclerView.LayoutManager layoutManager = this.f14343a.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        return null;
    }

    public final com.cupidapp.live.feed.holder.d h() {
        int i10 = this.f14347e;
        if (i10 <= -1) {
            return null;
        }
        Object findViewHolderForLayoutPosition = this.f14343a.findViewHolderForLayoutPosition(i10);
        if (findViewHolderForLayoutPosition instanceof com.cupidapp.live.feed.holder.d) {
            return (com.cupidapp.live.feed.holder.d) findViewHolderForLayoutPosition;
        }
        return null;
    }

    public final int i() {
        int i10 = 0;
        for (List<Object> list : this.f14346d) {
            i10 += list.size();
        }
        return i10;
    }

    public final void j() {
        com.cupidapp.live.feed.holder.d h10 = h();
        if (h10 != null) {
            h10.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k() {
        Pair<Integer, Integer> b4;
        int intValue;
        int intValue2;
        LinearLayoutManager g3 = g();
        if (g3 == null || (b4 = c0.b(g3)) == null || (intValue = b4.getFirst().intValue()) > (intValue2 = b4.getSecond().intValue())) {
            return;
        }
        while (true) {
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.f14343a.findViewHolderForLayoutPosition(intValue);
            FKBaseRecyclerViewHolder fKBaseRecyclerViewHolder = findViewHolderForLayoutPosition instanceof FKBaseRecyclerViewHolder ? (FKBaseRecyclerViewHolder) findViewHolderForLayoutPosition : 0;
            if (fKBaseRecyclerViewHolder != 0 && (fKBaseRecyclerViewHolder instanceof com.cupidapp.live.feed.holder.d) && i() > intValue) {
                int top = fKBaseRecyclerViewHolder.itemView.getTop();
                int i10 = this.f14345c;
                if (top < i10) {
                    p((com.cupidapp.live.feed.holder.d) fKBaseRecyclerViewHolder);
                } else {
                    int i11 = this.f14344b;
                    int top2 = fKBaseRecyclerViewHolder.itemView.getTop();
                    boolean z10 = false;
                    if (i10 <= top2 && top2 <= i11) {
                        z10 = true;
                    }
                    if (z10) {
                        this.f14347e = intValue;
                        ((com.cupidapp.live.feed.holder.d) fKBaseRecyclerViewHolder).a();
                        return;
                    }
                }
            }
            if (intValue == intValue2) {
                return;
            } else {
                intValue++;
            }
        }
    }

    public final void l(@NotNull FeedModel model) {
        s.i(model, "model");
        int e2 = e(model);
        if (e2 > -1) {
            Object findViewHolderForLayoutPosition = this.f14343a.findViewHolderForLayoutPosition(e2);
            com.cupidapp.live.feed.holder.d dVar = findViewHolderForLayoutPosition instanceof com.cupidapp.live.feed.holder.d ? (com.cupidapp.live.feed.holder.d) findViewHolderForLayoutPosition : null;
            if (dVar != null) {
                o();
                this.f14347e = e2;
                dVar.a();
            }
        }
    }

    public final void m() {
        com.cupidapp.live.feed.holder.d h10 = h();
        if (h10 != null) {
            h10.c();
        }
    }

    public final void n(FeedZoomGuideModel feedZoomGuideModel, int i10) {
        LinearLayoutManager g3;
        View findViewByPosition;
        if (!feedZoomGuideModel.isFirstDisplay() || (g3 = g()) == null || (findViewByPosition = g3.findViewByPosition(i10)) == null) {
            return;
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.f14343a.findViewHolderForLayoutPosition(i10);
        BaseFeedViewHolder baseFeedViewHolder = findViewHolderForLayoutPosition instanceof BaseFeedViewHolder ? (BaseFeedViewHolder) findViewHolderForLayoutPosition : null;
        if (baseFeedViewHolder != null && findViewByPosition.getTop() <= this.f14349g && findViewByPosition.getBottom() >= this.f14348f) {
            if (baseFeedViewHolder.G()) {
                if (feedZoomGuideModel.getTopPosition() == i10) {
                    feedZoomGuideModel.setTopPosition(feedZoomGuideModel.getTopPosition() - 1);
                } else if (feedZoomGuideModel.getBottomPosition() == i10) {
                    feedZoomGuideModel.setBottomPosition(feedZoomGuideModel.getBottomPosition() + 1);
                }
                p1.g.f52734a.n2(feedZoomGuideModel);
                return;
            }
            baseFeedViewHolder.R("feed_zoom_guide_webp.webp");
            feedZoomGuideModel.setFirstDisplay(false);
            p1.g.f52734a.n2(feedZoomGuideModel);
        }
    }

    public final void o() {
        com.cupidapp.live.feed.holder.d h10 = h();
        if (h10 != null) {
            p(h10);
        }
    }

    public final void p(com.cupidapp.live.feed.holder.d dVar) {
        dVar.f();
        this.f14347e = -1;
    }
}
