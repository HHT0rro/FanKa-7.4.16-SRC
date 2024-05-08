package com.cupidapp.live.club.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.web.WebConfigViewModel;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import com.cupidapp.live.club.fragment.ActivityListFragment;
import com.cupidapp.live.club.fragment.ClubListFragment;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import p1.g;

/* compiled from: ClubListPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubListPagerAdapter extends FragmentStateAdapter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<String> f13516b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubListPagerAdapter(@NotNull FragmentActivity activity, @NotNull List<String> fragmentList) {
        super(activity);
        s.i(activity, "activity");
        s.i(fragmentList, "fragmentList");
        this.f13516b = fragmentList;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int i10) {
        ConstantsUrlModel urlModel;
        String str = this.f13516b.get(i10);
        if (s.d(str, ClubListFragment.class.getSimpleName())) {
            return new ClubListFragment();
        }
        String str2 = null;
        if (s.d(str, ActivityListFragment.class.getSimpleName())) {
            return ActivityListFragment.a.b(ActivityListFragment.f13535n, SensorPosition.ClubActivity, null, 2, null);
        }
        FKWebViewFragment.a aVar = FKWebViewFragment.f13075p;
        ConstantsResult q10 = g.f52734a.q();
        if (q10 != null && (urlModel = q10.getUrlModel()) != null) {
            str2 = urlModel.getClubRankListUrl();
        }
        return FKWebViewFragment.a.e(aVar, str2, null, new WebConfigViewModel(false, false, false, false, false, null, false, 126, null), 2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13516b.size();
    }
}
