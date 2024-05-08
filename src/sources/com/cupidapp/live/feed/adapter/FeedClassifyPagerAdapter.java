package com.cupidapp.live.feed.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.feed.activity.FeedClassifyFragment;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedClassifyPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedClassifyPagerAdapter extends FragmentStateAdapter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final FeedSensorContext f14174b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f14175c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final List<String> f14176d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedClassifyPagerAdapter(@NotNull FeedSensorContext sensorContext, @NotNull String tag, @Nullable List<String> list, @NotNull FragmentActivity activity) {
        super(activity);
        s.i(sensorContext, "sensorContext");
        s.i(tag, "tag");
        s.i(activity, "activity");
        this.f14174b = sensorContext;
        this.f14175c = tag;
        this.f14176d = list;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int i10) {
        FeedClassifyFragment.a aVar = FeedClassifyFragment.f14030l;
        String str = this.f14175c;
        List<String> list = this.f14176d;
        return aVar.a(str, list != null ? (String) CollectionsKt___CollectionsKt.W(list, i10) : null, this.f14174b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.f14176d;
        if (list != null) {
            return list.size();
        }
        return 1;
    }
}
