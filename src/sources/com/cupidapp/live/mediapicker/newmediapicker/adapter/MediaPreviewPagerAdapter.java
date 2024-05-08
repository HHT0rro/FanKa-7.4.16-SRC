package com.cupidapp.live.mediapicker.newmediapicker.adapter;

import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.base.view.viewpager.FKBaseFragmentStatePagerAdapter;
import com.cupidapp.live.mediapicker.newmediapicker.data.PreviewMediaData;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewItemFragment;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MeidaPreviewPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaPreviewPagerAdapter extends FKBaseFragmentStatePagerAdapter {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final a f17276b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17277c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public MediaPreviewItemFragment f17278d;

    /* compiled from: MeidaPreviewPagerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void t0(@Nullable MediaPreviewItemFragment mediaPreviewItemFragment, @NotNull MediaPreviewItemFragment mediaPreviewItemFragment2);
    }

    public /* synthetic */ MediaPreviewPagerAdapter(a aVar, int i10, FragmentManager fragmentManager, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : aVar, (i11 & 2) != 0 ? -16777216 : i10, fragmentManager);
    }

    @Nullable
    public final MediaPreviewItemFragment a() {
        return this.f17278d;
    }

    public final void b() {
        notifyDataSetChanged();
    }

    @Override // com.cupidapp.live.base.view.viewpager.FKBaseFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return PreviewMediaData.INSTANCE.size();
    }

    @Override // com.cupidapp.live.base.view.viewpager.FKBaseFragmentStatePagerAdapter, androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int i10) {
        return MediaPreviewItemFragment.f17309h.a(PreviewMediaData.INSTANCE.get(i10), this.f17277c);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object obj) {
        s.i(obj, "obj");
        return -2;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NotNull ViewGroup container, int i10, @NotNull Object obj) {
        a aVar;
        s.i(container, "container");
        s.i(obj, "obj");
        if (!s.d(a(), obj)) {
            MediaPreviewItemFragment mediaPreviewItemFragment = obj instanceof MediaPreviewItemFragment ? (MediaPreviewItemFragment) obj : null;
            if (mediaPreviewItemFragment != null && (aVar = this.f17276b) != null) {
                aVar.t0(this.f17278d, mediaPreviewItemFragment);
            }
            this.f17278d = mediaPreviewItemFragment;
        }
        super.setPrimaryItem(container, i10, obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaPreviewPagerAdapter(@Nullable a aVar, @ColorInt int i10, @NotNull FragmentManager fragmentManager) {
        super(fragmentManager);
        s.i(fragmentManager, "fragmentManager");
        this.f17276b = aVar;
        this.f17277c = i10;
    }
}
