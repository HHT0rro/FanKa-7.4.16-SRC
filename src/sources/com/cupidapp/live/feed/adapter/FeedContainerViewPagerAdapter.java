package com.cupidapp.live.feed.adapter;

import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.view.viewpager.FKBaseFragmentPagerAdapter;
import com.cupidapp.live.club.fragment.ActivityListFragment;
import com.cupidapp.live.feed.fragment.FeedRecommendFragment;
import com.cupidapp.live.feed.fragment.TrendFeedListFragment;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedContainerViewPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedContainerViewPagerAdapter extends FKBaseFragmentPagerAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedContainerViewPagerAdapter(@NotNull FragmentManager fm) {
        super(fm);
        s.i(fm, "fm");
    }

    public final void b(@NotNull FKBaseFragment fragment, int i10) {
        s.i(fragment, "fragment");
        a().add(i10, fragment);
        notifyDataSetChanged();
    }

    public final void c(@NotNull List<? extends FKBaseFragment> fragments) {
        s.i(fragments, "fragments");
        a().addAll(fragments);
        notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i10) {
        FKBaseFragment fKBaseFragment = a().get(i10);
        if (fKBaseFragment instanceof ActivityListFragment) {
            return 0L;
        }
        if (fKBaseFragment instanceof TrendFeedListFragment) {
            return 1L;
        }
        if (fKBaseFragment instanceof FeedRecommendFragment) {
            return 2L;
        }
        return super.getItemId(i10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object object) {
        s.i(object, "object");
        return -2;
    }
}
