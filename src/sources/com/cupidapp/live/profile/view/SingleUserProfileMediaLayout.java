package com.cupidapp.live.profile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.LifecycleObserver;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.video.AppVideoLayout;
import com.cupidapp.live.base.view.viewpager.FKBasePagerLayout;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SingleUserProfileMediaLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SingleUserProfileMediaLayout extends FKBasePagerLayout implements LifecycleObserver {

    /* renamed from: c, reason: collision with root package name */
    public boolean f17872c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17873d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleUserProfileMediaLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17873d = new LinkedHashMap();
        this.f17872c = true;
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17873d;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b(@NotNull AvatarProfileModel model) {
        s.i(model, "model");
        if (model.getAvatarVideo() == null) {
            this.f17872c = false;
            int i10 = R$id.userImageView;
            ((ImageLoaderView) a(i10)).setVisibility(0);
            ImageLoaderView userImageView = (ImageLoaderView) a(i10);
            s.h(userImageView, "userImageView");
            ImageLoaderView.g(userImageView, model.getAvatarImage(), null, null, 6, null);
            return;
        }
        this.f17872c = true;
        int i11 = R$id.userVideoLayout;
        ((AppVideoLayout) a(i11)).setVisibility(0);
        ((AppVideoLayout) a(i11)).d(model.getAvatarVideo(), model.getAvatarImage());
    }

    public final void c() {
        z.a(this, R$layout.layout_single_user_profile_media, true);
    }

    public final void d() {
        if (this.f17872c) {
            ((AppVideoLayout) a(R$id.userVideoLayout)).e();
        }
    }

    public final void e() {
        if (this.f17872c) {
            ((AppVideoLayout) a(R$id.userVideoLayout)).f();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleUserProfileMediaLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17873d = new LinkedHashMap();
        this.f17872c = true;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleUserProfileMediaLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17873d = new LinkedHashMap();
        this.f17872c = true;
        c();
    }
}
