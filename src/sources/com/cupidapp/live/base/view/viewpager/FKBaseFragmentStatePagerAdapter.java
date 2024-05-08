package com.cupidapp.live.base.view.viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKBaseFragmentStatePagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FKBaseFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<Fragment> f12948a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBaseFragmentStatePagerAdapter(@NotNull FragmentManager fm) {
        super(fm, 1);
        s.i(fm, "fm");
        this.f12948a = new ArrayList();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f12948a.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int i10) {
        return this.f12948a.get(i10);
    }
}
