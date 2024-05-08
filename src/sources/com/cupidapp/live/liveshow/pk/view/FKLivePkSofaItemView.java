package com.cupidapp.live.liveshow.pk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLivePkSofaItemView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePkSofaItemView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15160b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePkSofaItemView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15160b = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15160b;
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

    public final void b(@Nullable ImageModel imageModel, boolean z10, int i10) {
        if (imageModel != null) {
            ((ImageView) a(R$id.chairImageView)).setVisibility(8);
            int i11 = R$id.sofaAvatarImageView;
            ((ImageLoaderView) a(i11)).setVisibility(0);
            ImageLoaderView sofaAvatarImageView = (ImageLoaderView) a(i11);
            s.h(sofaAvatarImageView, "sofaAvatarImageView");
            ImageLoaderView.g(sofaAvatarImageView, imageModel, null, null, 6, null);
        } else {
            int i12 = R$id.chairImageView;
            ((ImageView) a(i12)).setVisibility(0);
            ((ImageLoaderView) a(R$id.sofaAvatarImageView)).setVisibility(8);
            ((ImageView) a(i12)).setImageResource(z10 ? R$mipmap.icon_left_chair : R$mipmap.icon_right_chair);
        }
        ((ImageView) a(R$id.rankIconView)).setImageResource(c(z10, i10));
    }

    public final int c(boolean z10, int i10) {
        if (z10) {
            if (i10 == 0) {
                return R$mipmap.icon_left_first;
            }
            if (i10 == 1) {
                return R$mipmap.icon_left_second;
            }
            if (i10 != 2) {
                return 0;
            }
            return R$mipmap.icon_left_third;
        }
        if (i10 == 0) {
            return R$mipmap.icon_right_first;
        }
        if (i10 == 1) {
            return R$mipmap.icon_right_second;
        }
        if (i10 != 2) {
            return 0;
        }
        return R$mipmap.icon_right_third;
    }

    public final void d() {
        z.a(this, R$layout.layout_live_pk_sofa_item_view, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePkSofaItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15160b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePkSofaItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15160b = new LinkedHashMap();
        d();
    }
}
