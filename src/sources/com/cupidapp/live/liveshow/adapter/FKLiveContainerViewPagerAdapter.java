package com.cupidapp.live.liveshow.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.view.viewpager.FKBaseFragmentPagerAdapter;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveContainerViewPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveContainerViewPagerAdapter extends FKBaseFragmentPagerAdapter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final FragmentManager f14812b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveContainerViewPagerAdapter(@NotNull FragmentManager manager) {
        super(manager);
        s.i(manager, "manager");
        this.f14812b = manager;
    }

    public final void b(@NotNull List<? extends FKBaseFragment> list) {
        s.i(list, "list");
        a().addAll(list);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int i10) {
        s.i(container, "container");
        Object instantiateItem = super.instantiateItem(container, i10);
        s.g(instantiateItem, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Fragment fragment = (Fragment) instantiateItem;
        String tag = fragment.getTag();
        FKBaseFragment fKBaseFragment = a().get(i10);
        if (s.d(fragment.getClass().getSimpleName(), fKBaseFragment.getClass().getSimpleName())) {
            return fragment;
        }
        FragmentTransaction beginTransaction = this.f14812b.beginTransaction();
        s.h(beginTransaction, "manager.beginTransaction()");
        beginTransaction.remove(fragment);
        beginTransaction.add(container.getId(), fKBaseFragment, tag);
        beginTransaction.attach(fKBaseFragment);
        beginTransaction.commit();
        return fKBaseFragment;
    }
}
