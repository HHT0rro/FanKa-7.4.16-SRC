package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.BaseLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: AdPostTagLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AdPostTagLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14427d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdPostTagLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14427d = new LinkedHashMap();
        g();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f14427d;
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

    public final void f(@Nullable ImageModel imageModel, @Nullable String str, @Nullable final String str2) {
        int i10 = R$id.ad_tag_title;
        TextView ad_tag_title = (TextView) e(i10);
        kotlin.jvm.internal.s.h(ad_tag_title, "ad_tag_title");
        z0.u.a(ad_tag_title);
        ((TextView) e(i10)).setText(str);
        ImageLoaderView ad_tag_img = (ImageLoaderView) e(R$id.ad_tag_img);
        kotlin.jvm.internal.s.h(ad_tag_img, "ad_tag_img");
        ImageLoaderView.g(ad_tag_img, imageModel, null, null, 6, null);
        y.d(this, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.AdPostTagLayout$configData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                j.a.b(com.cupidapp.live.base.router.j.f12156c, AdPostTagLayout.this.getContext(), str2, null, 4, null);
            }
        });
    }

    public final void g() {
        z.a(this, R$layout.layout_ad_post_tag, true);
        setBackgroundColor(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdPostTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14427d = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdPostTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14427d = new LinkedHashMap();
        g();
    }
}
