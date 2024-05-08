package com.cupidapp.live.base.view.viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKBaseFragmentPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FKBaseFragmentPagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<FKBaseFragment> f12947a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBaseFragmentPagerAdapter(@NotNull FragmentManager manager) {
        super(manager, 1);
        s.i(manager, "manager");
        this.f12947a = new ArrayList();
    }

    @NotNull
    public final List<FKBaseFragment> a() {
        return this.f12947a;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f12947a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NotNull
    public Fragment getItem(int i10) {
        return this.f12947a.get(i10);
    }
}
