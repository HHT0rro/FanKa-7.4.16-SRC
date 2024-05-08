package com.cupidapp.live.ai.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.ai.adapter.AiPhotoItemAdapter;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.view.indicator.TopIndicatorLayout;
import com.cupidapp.live.feed.layout.ClickChangePageLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: AiIdentifyPhotoPagerLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AiIdentifyPhotoPagerLayout extends ClickChangePageLayout {

    /* renamed from: l, reason: collision with root package name */
    public int f11647l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final Lazy f11648m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11649n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiIdentifyPhotoPagerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f11649n = new LinkedHashMap();
        this.f11648m = c.b(AiIdentifyPhotoPagerLayout$adapter$2.INSTANCE);
    }

    private final AiPhotoItemAdapter getAdapter() {
        return (AiPhotoItemAdapter) this.f11648m.getValue();
    }

    @Override // com.cupidapp.live.feed.layout.ClickChangePageLayout
    public boolean d() {
        return false;
    }

    @Override // com.cupidapp.live.feed.layout.ClickChangePageLayout
    public boolean e() {
        return false;
    }

    @Override // com.cupidapp.live.feed.layout.ClickChangePageLayout
    @NotNull
    public TopIndicatorLayout getTopIndicatorLayout() {
        TopIndicatorLayout ai_indicator_layout = (TopIndicatorLayout) k(R$id.ai_indicator_layout);
        s.h(ai_indicator_layout, "ai_indicator_layout");
        return ai_indicator_layout;
    }

    @Override // com.cupidapp.live.feed.layout.ClickChangePageLayout
    @NotNull
    public ViewPager2 getViewPager2() {
        ViewPager2 ai_pager_view_pager = (ViewPager2) k(R$id.ai_pager_view_pager);
        s.h(ai_pager_view_pager, "ai_pager_view_pager");
        return ai_pager_view_pager;
    }

    @Override // com.cupidapp.live.feed.layout.ClickChangePageLayout
    public int i() {
        return R$layout.layout_ai_identify_photo_pager;
    }

    @Nullable
    public View k(int i10) {
        Map<Integer, View> map = this.f11649n;
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

    public final void m(@Nullable List<ImageModel> list) {
        int l10 = h.l(this) - h.c(this, 46.0f);
        h(new Rect(0, 0, l10, ((l10 * 4) / 3) - h.c(this, 130.0f)));
        getViewPager2().setAdapter(getAdapter());
        getAdapter().j().clear();
        getAdapter().j().addAll(list != null ? list : kotlin.collections.s.j());
        getAdapter().notifyDataSetChanged();
        setPagerSize(list != null ? list.size() : 0);
        getViewPager2().registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.ai.view.AiIdentifyPhotoPagerLayout$configData$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                AiIdentifyPhotoPagerLayout.this.f11647l = i10;
            }
        });
        getViewPager2().setCurrentItem(this.f11647l, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiIdentifyPhotoPagerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f11649n = new LinkedHashMap();
        this.f11648m = c.b(AiIdentifyPhotoPagerLayout$adapter$2.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiIdentifyPhotoPagerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f11649n = new LinkedHashMap();
        this.f11648m = c.b(AiIdentifyPhotoPagerLayout$adapter$2.INSTANCE);
    }
}
