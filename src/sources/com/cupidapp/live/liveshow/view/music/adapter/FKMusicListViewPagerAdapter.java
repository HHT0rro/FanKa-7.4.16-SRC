package com.cupidapp.live.liveshow.view.music.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKMusicSheetViewPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKMusicListViewPagerAdapter extends FragmentStateAdapter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<String> f15795b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKMusicListViewPagerAdapter(@NotNull FragmentActivity activity, @NotNull List<String> musicSheetList) {
        super(activity);
        s.i(activity, "activity");
        s.i(musicSheetList, "musicSheetList");
        this.f15795b = musicSheetList;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int i10) {
        return FKMusicListViewFragment.f15786j.a(this.f15795b.get(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f15795b.size();
    }
}
