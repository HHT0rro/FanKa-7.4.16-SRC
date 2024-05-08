package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: PromotionUserAvatarsLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PromotionUserAvatarsLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12551b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionUserAvatarsLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12551b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12551b;
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

    public final void b(@Nullable List<ImageModel> list, int i10) {
        int size = list != null ? list.size() : 0;
        if (size > 0) {
            int i11 = R$id.avatar_first_avatar;
            ImageLoaderView imageLoaderView = (ImageLoaderView) a(i11);
            if (imageLoaderView != null) {
                y.n(imageLoaderView, Integer.valueOf(i10), Integer.valueOf(i10));
            }
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) a(i11);
            if (imageLoaderView2 != null) {
                ImageLoaderView.g(imageLoaderView2, list != null ? list.get(0) : null, null, null, 6, null);
            }
        }
        if (size > 1) {
            ImageLoaderView imageLoaderView3 = (ImageLoaderView) a(R$id.avatar_first_avatar);
            if (imageLoaderView3 != null) {
                y.m(imageLoaderView3, Integer.valueOf(size * 0), null, null, null, 14, null);
            }
            int i12 = R$id.avatar_second_avatar;
            ImageLoaderView imageLoaderView4 = (ImageLoaderView) a(i12);
            if (imageLoaderView4 != null) {
                imageLoaderView4.setVisibility(0);
            }
            ImageLoaderView imageLoaderView5 = (ImageLoaderView) a(i12);
            if (imageLoaderView5 != null) {
                ImageLoaderView.g(imageLoaderView5, list != null ? list.get(1) : null, null, null, 6, null);
            }
        }
        if (size > 2) {
            ImageLoaderView imageLoaderView6 = (ImageLoaderView) a(R$id.avatar_first_avatar);
            if (imageLoaderView6 != null) {
                y.m(imageLoaderView6, Integer.valueOf(size * 1), null, null, null, 14, null);
            }
            int i13 = R$id.avatar_third_avatar;
            ImageLoaderView imageLoaderView7 = (ImageLoaderView) a(i13);
            if (imageLoaderView7 != null) {
                imageLoaderView7.setVisibility(0);
            }
            ImageLoaderView imageLoaderView8 = (ImageLoaderView) a(i13);
            if (imageLoaderView8 != null) {
                ImageLoaderView.g(imageLoaderView8, list != null ? list.get(2) : null, null, null, 6, null);
            }
        }
    }

    public final void c() {
        z.a(this, R$layout.view_promotion_avatars, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionUserAvatarsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12551b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionUserAvatarsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12551b = new LinkedHashMap();
        c();
    }
}
