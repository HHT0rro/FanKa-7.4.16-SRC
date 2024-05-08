package com.cupidapp.live.liveshow.view.tag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.model.GiftWallModel;
import com.cupidapp.live.liveshow.model.LightUpGiftModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.o;
import z0.y;
import z0.z;

/* compiled from: UserGiftWallLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserGiftWallLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15991b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserGiftWallLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15991b = new LinkedHashMap();
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(UserGiftWallLayout userGiftWallLayout, GiftWallModel giftWallModel, Function0 function0, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function0 = null;
        }
        userGiftWallLayout.b(giftWallModel, function0);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15991b;
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

    public final void b(@NotNull final GiftWallModel giftWall, @Nullable final Function0<p> function0) {
        s.i(giftWall, "giftWall");
        ((TextView) a(R$id.gift_wall_desc)).setText(giftWall.getDesc());
        ((LinearLayout) a(R$id.gift_wall_icon_linear)).removeAllViews();
        int c4 = h.c(this, 33.0f);
        List<LightUpGiftModel> lightUpList = giftWall.getLightUpList();
        if (lightUpList != null) {
            for (LightUpGiftModel lightUpGiftModel : lightUpList) {
                ImageLoaderView d10 = d(lightUpGiftModel.getGiftIcon(), c4, lightUpGiftModel.getLight());
                o.b(d10, -5658199);
                ((LinearLayout) a(R$id.gift_wall_icon_linear)).addView(d10);
            }
        }
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.tag.UserGiftWallLayout$configUserGiftWall$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(GiftWallModel.this.getUrl(), true));
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        });
    }

    public final ImageLoaderView d(ImageModel imageModel, int i10, boolean z10) {
        Context context = getContext();
        s.h(context, "context");
        ImageLoaderView imageLoaderView = new ImageLoaderView(context);
        ImageLoaderView.g(imageLoaderView, imageModel, null, null, 6, null);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i10, i10);
        marginLayoutParams.setMarginStart(h.c(marginLayoutParams, 4.0f));
        imageLoaderView.setLayoutParams(marginLayoutParams);
        if (!z10) {
            o.a(imageLoaderView, 0.0f);
        } else {
            o.a(imageLoaderView, 1.0f);
        }
        return imageLoaderView;
    }

    public final void e() {
        z.a(this, R$layout.layout_gift_wall, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserGiftWallLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15991b = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserGiftWallLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15991b = new LinkedHashMap();
        e();
    }
}
