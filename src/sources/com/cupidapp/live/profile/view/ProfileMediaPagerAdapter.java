package com.cupidapp.live.profile.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.base.view.viewpager.BasePagerAdapter;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ProfileMediaViewPagerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileMediaPagerAdapter extends BasePagerAdapter {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<AvatarProfileModel> f17861e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMediaPagerAdapter(@NotNull List<AvatarProfileModel> modelList) {
        super(modelList, null, 2, null);
        s.i(modelList, "modelList");
        this.f17861e = modelList;
    }

    @Override // com.cupidapp.live.base.view.viewpager.BasePagerAdapter
    public void a(@NotNull View itemView, @NotNull Object model, int i10, boolean z10) {
        s.i(itemView, "itemView");
        s.i(model, "model");
        if ((itemView instanceof SingleUserProfileMediaLayout) && (model instanceof AvatarProfileModel)) {
            ((SingleUserProfileMediaLayout) itemView).b((AvatarProfileModel) model);
        }
    }

    @Override // com.cupidapp.live.base.view.viewpager.BasePagerAdapter
    @NotNull
    public List<AvatarProfileModel> b() {
        return this.f17861e;
    }

    @Override // com.cupidapp.live.base.view.viewpager.BasePagerAdapter
    @NotNull
    public View c(@NotNull ViewGroup container, @NotNull Object model, int i10) {
        s.i(container, "container");
        s.i(model, "model");
        Context context = container.getContext();
        s.h(context, "container.context");
        return new SingleUserProfileMediaLayout(context);
    }
}
