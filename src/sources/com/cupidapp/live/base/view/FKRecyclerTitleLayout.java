package com.cupidapp.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.recyclerview.decoration.ExtraSpacingDecoration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKRecyclerTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKRecyclerTitleLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function2<? super Integer, ? super FKTitleViewModel, kotlin.p> f12518b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f12519c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12520d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKRecyclerTitleLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12520d = new LinkedHashMap();
        this.f12519c = kotlin.c.b(new Function0<FKTitleRecyclerViewAdapter>() { // from class: com.cupidapp.live.base.view.FKRecyclerTitleLayout$titleAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKTitleRecyclerViewAdapter invoke() {
                final FKTitleRecyclerViewAdapter fKTitleRecyclerViewAdapter = new FKTitleRecyclerViewAdapter();
                final FKRecyclerTitleLayout fKRecyclerTitleLayout = FKRecyclerTitleLayout.this;
                fKTitleRecyclerViewAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.base.view.FKRecyclerTitleLayout$titleAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (!(obj instanceof FKTitleViewModel) || ((FKTitleViewModel) obj).isSelected()) {
                            return;
                        }
                        int indexOf = FKTitleRecyclerViewAdapter.this.j().indexOf(obj);
                        Function2<Integer, FKTitleViewModel, kotlin.p> titleClickListener = fKRecyclerTitleLayout.getTitleClickListener();
                        if (titleClickListener != null) {
                            titleClickListener.mo1743invoke(Integer.valueOf(indexOf), obj);
                        }
                    }
                });
                return fKTitleRecyclerViewAdapter;
            }
        });
        f(this, context, null, 2, null);
    }

    public static /* synthetic */ void d(FKRecyclerTitleLayout fKRecyclerTitleLayout, List list, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        fKRecyclerTitleLayout.c(list, i10);
    }

    public static /* synthetic */ void f(FKRecyclerTitleLayout fKRecyclerTitleLayout, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        fKRecyclerTitleLayout.e(context, attributeSet);
    }

    private final FKTitleRecyclerViewAdapter getTitleAdapter() {
        return (FKTitleRecyclerViewAdapter) this.f12519c.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12520d;
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

    public final void b(int i10) {
        int i11 = 0;
        for (Object obj : getTitleAdapter().j()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            if (obj instanceof FKTitleViewModel) {
                ((FKTitleViewModel) obj).setSelected(i11 == i10);
            }
            i11 = i12;
        }
        getTitleAdapter().notifyDataSetChanged();
    }

    public final void c(@NotNull List<FKTitleViewModel> titles, int i10) {
        kotlin.jvm.internal.s.i(titles, "titles");
        if (i10 < 0 || i10 >= titles.size()) {
            return;
        }
        getTitleAdapter().j().clear();
        int i11 = 0;
        for (FKTitleViewModel fKTitleViewModel : titles) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            FKTitleViewModel fKTitleViewModel2 = fKTitleViewModel;
            fKTitleViewModel2.setSelected(i11 == i10);
            getTitleAdapter().d(fKTitleViewModel2);
            i11 = i12;
        }
        getTitleAdapter().notifyDataSetChanged();
        ((RecyclerView) a(R$id.titleRecyclerView)).smoothScrollToPosition(i10);
    }

    public final void e(Context context, AttributeSet attributeSet) {
        z.a(this, R$layout.layout_recycler_title, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FKRecyclerTitleLayout);
        kotlin.jvm.internal.s.h(obtainStyledAttributes, "context.obtainStyledAttr…le.FKRecyclerTitleLayout)");
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, z0.h.c(this, 12.0f));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        RecyclerView recyclerView = (RecyclerView) a(R$id.titleRecyclerView);
        recyclerView.setAdapter(getTitleAdapter());
        recyclerView.setLayoutManager(new CustomLayoutManager(context, 0, ScrollTo.Center, null, 8, null));
        recyclerView.addItemDecoration(new ExtraSpacingDecoration(dimensionPixelSize, 0, dimensionPixelSize, 0, dimensionPixelSize2));
        recyclerView.setNestedScrollingEnabled(false);
    }

    public final void g(int i10) {
        b(i10);
        ((RecyclerView) a(R$id.titleRecyclerView)).smoothScrollToPosition(i10);
    }

    @NotNull
    public final String getCurrentTitle() {
        List<Object> j10 = getTitleAdapter().j();
        ArrayList<FKTitleViewModel> arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FKTitleViewModel) {
                arrayList.add(obj);
            }
        }
        for (FKTitleViewModel fKTitleViewModel : arrayList) {
            if (fKTitleViewModel.isSelected()) {
                return fKTitleViewModel.getText();
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Nullable
    public final Function2<Integer, FKTitleViewModel, kotlin.p> getTitleClickListener() {
        return this.f12518b;
    }

    public final void setTitleClickListener(@Nullable Function2<? super Integer, ? super FKTitleViewModel, kotlin.p> function2) {
        this.f12518b = function2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKRecyclerTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12520d = new LinkedHashMap();
        this.f12519c = kotlin.c.b(new Function0<FKTitleRecyclerViewAdapter>() { // from class: com.cupidapp.live.base.view.FKRecyclerTitleLayout$titleAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKTitleRecyclerViewAdapter invoke() {
                final FKTitleRecyclerViewAdapter fKTitleRecyclerViewAdapter = new FKTitleRecyclerViewAdapter();
                final FKRecyclerTitleLayout fKRecyclerTitleLayout = FKRecyclerTitleLayout.this;
                fKTitleRecyclerViewAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.base.view.FKRecyclerTitleLayout$titleAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (!(obj instanceof FKTitleViewModel) || ((FKTitleViewModel) obj).isSelected()) {
                            return;
                        }
                        int indexOf = FKTitleRecyclerViewAdapter.this.j().indexOf(obj);
                        Function2<Integer, FKTitleViewModel, kotlin.p> titleClickListener = fKRecyclerTitleLayout.getTitleClickListener();
                        if (titleClickListener != null) {
                            titleClickListener.mo1743invoke(Integer.valueOf(indexOf), obj);
                        }
                    }
                });
                return fKTitleRecyclerViewAdapter;
            }
        });
        e(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKRecyclerTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12520d = new LinkedHashMap();
        this.f12519c = kotlin.c.b(new Function0<FKTitleRecyclerViewAdapter>() { // from class: com.cupidapp.live.base.view.FKRecyclerTitleLayout$titleAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKTitleRecyclerViewAdapter invoke() {
                final FKTitleRecyclerViewAdapter fKTitleRecyclerViewAdapter = new FKTitleRecyclerViewAdapter();
                final FKRecyclerTitleLayout fKRecyclerTitleLayout = FKRecyclerTitleLayout.this;
                fKTitleRecyclerViewAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.base.view.FKRecyclerTitleLayout$titleAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (!(obj instanceof FKTitleViewModel) || ((FKTitleViewModel) obj).isSelected()) {
                            return;
                        }
                        int indexOf = FKTitleRecyclerViewAdapter.this.j().indexOf(obj);
                        Function2<Integer, FKTitleViewModel, kotlin.p> titleClickListener = fKRecyclerTitleLayout.getTitleClickListener();
                        if (titleClickListener != null) {
                            titleClickListener.mo1743invoke(Integer.valueOf(indexOf), obj);
                        }
                    }
                });
                return fKTitleRecyclerViewAdapter;
            }
        });
        e(context, attributeSet);
    }
}
