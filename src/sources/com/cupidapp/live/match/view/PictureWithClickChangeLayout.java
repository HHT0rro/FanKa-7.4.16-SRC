package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PictureWithClickChangeLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PictureWithClickChangeLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16995b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureWithClickChangeLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16995b = new LinkedHashMap();
        d();
    }

    public static final void e(PictureWithClickChangeLayout this$0, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int i10 = R$id.pictureViewPager;
        if (((ViewPager2) this$0.c(i10)).getCurrentItem() - 1 >= 0) {
            ((ViewPager2) this$0.c(i10)).setCurrentItem(((ViewPager2) this$0.c(i10)).getCurrentItem() - 1, false);
        }
    }

    public static final void f(PictureWithClickChangeLayout this$0, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int i10 = R$id.pictureViewPager;
        int currentItem = ((ViewPager2) this$0.c(i10)).getCurrentItem() + 1;
        RecyclerView.Adapter adapter = ((ViewPager2) this$0.c(i10)).getAdapter();
        if (currentItem < (adapter != null ? adapter.getItemCount() : 0)) {
            ((ViewPager2) this$0.c(i10)).setCurrentItem(((ViewPager2) this$0.c(i10)).getCurrentItem() + 1, false);
        }
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f16995b;
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

    public final void d() {
        z0.z.a(this, R$layout.layout_picture_change, true);
        c(R$id.LeftChangeBtn).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.match.view.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PictureWithClickChangeLayout.e(PictureWithClickChangeLayout.this, view);
            }
        });
        c(R$id.rightChangeBtn).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.match.view.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PictureWithClickChangeLayout.f(PictureWithClickChangeLayout.this, view);
            }
        });
    }

    public final void g(@NotNull ViewPager2.OnPageChangeCallback pageChangeCallback) {
        kotlin.jvm.internal.s.i(pageChangeCallback, "pageChangeCallback");
        int i10 = R$id.pictureViewPager;
        if (((ViewPager2) c(i10)) != null) {
            ((ViewPager2) c(i10)).registerOnPageChangeCallback(pageChangeCallback);
        }
    }

    public final void h(@NotNull ViewPager2.OnPageChangeCallback pageChangeCallback) {
        kotlin.jvm.internal.s.i(pageChangeCallback, "pageChangeCallback");
        int i10 = R$id.pictureViewPager;
        if (((ViewPager2) c(i10)) != null) {
            ((ViewPager2) c(i10)).unregisterOnPageChangeCallback(pageChangeCallback);
        }
    }

    public final void setAdapter(@NotNull FKBaseRecyclerViewAdapter adapter) {
        kotlin.jvm.internal.s.i(adapter, "adapter");
        ((ViewPager2) c(R$id.pictureViewPager)).setAdapter(adapter);
    }

    public final void setViewPagerUserInputEnabled(boolean z10) {
        ((ViewPager2) c(R$id.pictureViewPager)).setUserInputEnabled(z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureWithClickChangeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16995b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureWithClickChangeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16995b = new LinkedHashMap();
        d();
    }
}
