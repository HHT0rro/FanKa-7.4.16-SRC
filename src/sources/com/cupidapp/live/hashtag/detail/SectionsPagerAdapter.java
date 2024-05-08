package com.cupidapp.live.hashtag.detail;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagMainPagerAdapter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SectionsPagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f14696a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f14697b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final FKSensorContext f14698c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Context f14699d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public HashTagFragment f14700e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SectionsPagerAdapter(@Nullable String str, @NotNull String hashTagId, @Nullable FKSensorContext fKSensorContext, @NotNull Context context, @NotNull FragmentManager fm, int i10) {
        super(fm, i10);
        s.i(hashTagId, "hashTagId");
        s.i(context, "context");
        s.i(fm, "fm");
        this.f14696a = str;
        this.f14697b = hashTagId;
        this.f14698c = fKSensorContext;
        this.f14699d = context;
    }

    @Nullable
    public final HashTagFragment a() {
        return this.f14700e;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return a.a().length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NotNull
    public Fragment getItem(int i10) {
        SensorPosition sensorPosition;
        SensorPosition third = a.a()[i10].getThird();
        FKSensorContext fKSensorContext = this.f14698c;
        if (fKSensorContext == null || (sensorPosition = fKSensorContext.getPosition()) == null) {
            sensorPosition = SensorPosition.Unknown;
        }
        FKSensorContext fKSensorContext2 = this.f14698c;
        return HashTagFragment.f14669q.a(a.a()[i10].getSecond().intValue(), this.f14697b, this.f14696a, new FKSensorContext(third, sensorPosition, fKSensorContext2 != null ? fKSensorContext2.getSource() : null, SensorScene.Hashtag));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public CharSequence getPageTitle(int i10) {
        String string = this.f14699d.getResources().getString(a.a()[i10].getFirst().intValue());
        s.h(string, "context.resources.getStr…B_TITLES[position].first)");
        return string;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NotNull ViewGroup container, int i10, @NotNull Object obj) {
        s.i(container, "container");
        s.i(obj, "obj");
        if (obj instanceof HashTagFragment) {
            this.f14700e = (HashTagFragment) obj;
        }
        super.setPrimaryItem(container, i10, obj);
    }
}
