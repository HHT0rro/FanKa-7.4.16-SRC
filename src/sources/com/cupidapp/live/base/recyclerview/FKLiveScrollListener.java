package com.cupidapp.live.base.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.utils.c0;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.viewholder.FKLiveStreamViewHolder;
import com.cupidapp.live.liveshow.viewholder.LiveStreamModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveScrollListener.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveScrollListener extends RecyclerView.OnScrollListener {
    public final void b(@NotNull RecyclerView recyclerView) {
        Pair<Integer, Integer> b4;
        Object obj;
        s.i(recyclerView, "recyclerView");
        if (m()) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (b4 = c0.b(linearLayoutManager)) == null) {
            return;
        }
        ArrayList<FKLiveStreamViewHolder> arrayList = new ArrayList();
        int intValue = b4.getFirst().intValue();
        int intValue2 = b4.getSecond().intValue();
        if (intValue <= intValue2) {
            while (true) {
                RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(intValue);
                if (findViewHolderForLayoutPosition instanceof FKLiveStreamViewHolder) {
                    arrayList.add(findViewHolderForLayoutPosition);
                }
                if (intValue == intValue2) {
                    break;
                } else {
                    intValue++;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            int top = recyclerView.getTop();
            int bottom = recyclerView.getBottom();
            Iterator<E> iterator2 = arrayList.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = iterator2.next();
                FKLiveStreamViewHolder fKLiveStreamViewHolder = (FKLiveStreamViewHolder) obj;
                if (fKLiveStreamViewHolder.itemView.getTop() > top && fKLiveStreamViewHolder.itemView.getBottom() < bottom) {
                    break;
                }
            }
            FKLiveStreamViewHolder fKLiveStreamViewHolder2 = (FKLiveStreamViewHolder) obj;
            if (fKLiveStreamViewHolder2 == null) {
                return;
            }
            for (FKLiveStreamViewHolder fKLiveStreamViewHolder3 : arrayList) {
                Object o10 = fKLiveStreamViewHolder3.o();
                LiveStreamModel liveStreamModel = o10 instanceof LiveStreamModel ? (LiveStreamModel) o10 : null;
                boolean n10 = n(liveStreamModel != null ? liveStreamModel.getLiveShow() : null);
                if (!s.d(fKLiveStreamViewHolder3, fKLiveStreamViewHolder2)) {
                    fKLiveStreamViewHolder3.x();
                } else if (!n10) {
                    fKLiveStreamViewHolder3.w();
                }
            }
        }
    }

    public final boolean m() {
        return FKLiveMiniWindow.f15074m.a().H();
    }

    public final boolean n(LiveShowModel liveShowModel) {
        if ((liveShowModel != null ? liveShowModel.getStreamId() : null) != null) {
            List<String> c4 = FKLiveUtil.f14913a.c();
            if (c4 != null && c4.contains(liveShowModel.getStreamId())) {
                return true;
            }
        }
        return false;
    }

    public final void o(@NotNull RecyclerView recyclerView) {
        Pair<Integer, Integer> b4;
        int intValue;
        int intValue2;
        s.i(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (b4 = c0.b(linearLayoutManager)) == null || (intValue = b4.getFirst().intValue()) > (intValue2 = b4.getSecond().intValue())) {
            return;
        }
        while (true) {
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(intValue);
            FKLiveStreamViewHolder fKLiveStreamViewHolder = findViewHolderForLayoutPosition instanceof FKLiveStreamViewHolder ? (FKLiveStreamViewHolder) findViewHolderForLayoutPosition : null;
            if (fKLiveStreamViewHolder != null) {
                if (m()) {
                    fKLiveStreamViewHolder.t(true);
                } else {
                    fKLiveStreamViewHolder.x();
                }
            }
            if (intValue == intValue2) {
                return;
            } else {
                intValue++;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i10) {
        s.i(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i10);
        if (i10 == 0) {
            b(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i10, int i11) {
        s.i(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i10, i11);
        p(recyclerView);
    }

    public final void p(RecyclerView recyclerView) {
        Pair<Integer, Integer> b4;
        int intValue;
        int intValue2;
        if (m()) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (b4 = c0.b(linearLayoutManager)) == null || (intValue = b4.getFirst().intValue()) > (intValue2 = b4.getSecond().intValue())) {
            return;
        }
        while (true) {
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(intValue);
            FKLiveStreamViewHolder fKLiveStreamViewHolder = findViewHolderForLayoutPosition instanceof FKLiveStreamViewHolder ? (FKLiveStreamViewHolder) findViewHolderForLayoutPosition : null;
            Object o10 = fKLiveStreamViewHolder != null ? fKLiveStreamViewHolder.o() : null;
            LiveStreamModel liveStreamModel = o10 instanceof LiveStreamModel ? (LiveStreamModel) o10 : null;
            if (fKLiveStreamViewHolder != null) {
                boolean n10 = n(liveStreamModel != null ? liveStreamModel.getLiveShow() : null);
                View findViewByPosition = linearLayoutManager.findViewByPosition(intValue);
                int height = fKLiveStreamViewHolder.itemView.getHeight();
                int bottom = findViewByPosition != null ? findViewByPosition.getBottom() : 0;
                int bottom2 = recyclerView.getBottom();
                if ((bottom <= height / 3 || bottom - bottom2 >= (height * 2) / 3) && n10) {
                    fKLiveStreamViewHolder.x();
                }
            }
            if (intValue == intValue2) {
                return;
            } else {
                intValue++;
            }
        }
    }
}
