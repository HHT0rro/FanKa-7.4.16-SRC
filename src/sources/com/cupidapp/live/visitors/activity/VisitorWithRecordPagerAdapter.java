package com.cupidapp.live.visitors.activity;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorWithRecordPagerAdapter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorWithRecordPagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f18908a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public FKBaseFragment f18909b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorWithRecordPagerAdapter(@Nullable String str, @NotNull FragmentManager fm) {
        super(fm, 1);
        s.i(fm, "fm");
        this.f18908a = str;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NotNull
    public Fragment getItem(int i10) {
        if (i10 == 0) {
            return VisitorsFragment.f18910q.a(this.f18908a);
        }
        return FootmarkFragment.f18887k.a();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NotNull ViewGroup container, int i10, @NotNull Object obj) {
        s.i(container, "container");
        s.i(obj, "obj");
        if (obj instanceof FKBaseFragment) {
            this.f18909b = (FKBaseFragment) obj;
        }
        super.setPrimaryItem(container, i10, obj);
    }
}
