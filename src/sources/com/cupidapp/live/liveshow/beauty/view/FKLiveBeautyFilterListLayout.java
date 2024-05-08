package com.cupidapp.live.liveshow.beauty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.CustomLayoutManager;
import com.cupidapp.live.base.view.ScrollTo;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.liveshow.beauty.adapter.FKLiveFilterAdapter;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyEditItemModel;
import com.cupidapp.live.mediapicker.view.BottomConfirmAndCancelLayout;
import com.cupidapp.live.mediapicker.view.CustomAnimationLayout;
import com.cupidapp.live.track.group.GroupLiveLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r2.i;
import z0.h;
import z0.z;

/* compiled from: FKLiveBeautyFilterListLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBeautyFilterListLayout extends CustomAnimationLayout {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public b f14879c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final FKLiveFilterAdapter f14880d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14881e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyFilterListLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f14881e = new LinkedHashMap();
        FKLiveFilterAdapter fKLiveFilterAdapter = new FKLiveFilterAdapter();
        fKLiveFilterAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyFilterListLayout$filterAdapter$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FKLiveFilterViewModel) {
                    FKLiveFilterViewModel fKLiveFilterViewModel = (FKLiveFilterViewModel) obj;
                    if (fKLiveFilterViewModel.isSelected()) {
                        if (fKLiveFilterViewModel.getFilterResource() != null) {
                            FKLiveBeautyFilterListLayout.this.q();
                        }
                    } else {
                        FKLiveBeautyFilterListLayout.this.k(fKLiveFilterViewModel);
                        i.f53231b.E(fKLiveFilterViewModel.getFilterResource(), fKLiveFilterViewModel.getFilterIntensity());
                    }
                }
            }
        });
        this.f14880d = fKLiveFilterAdapter;
        o();
    }

    private final List<FKLiveFilterViewModel> getFilterTypeModelList() {
        String string = getContext().getString(R$string.normal);
        s.h(string, "context.getString(R.string.normal)");
        String string2 = getContext().getString(R$string.filter_lengyang);
        s.h(string2, "context.getString(R.string.filter_lengyang)");
        String string3 = getContext().getString(R$string.filter_haibianrenxiang);
        s.h(string3, "context.getString(R.string.filter_haibianrenxiang)");
        String string4 = getContext().getString(R$string.filter_wenrou);
        s.h(string4, "context.getString(R.string.filter_wenrou)");
        String string5 = getContext().getString(R$string.filter_oxgen);
        s.h(string5, "context.getString(R.string.filter_oxgen)");
        String string6 = getContext().getString(R$string.filter_makalong);
        s.h(string6, "context.getString(R.string.filter_makalong)");
        String string7 = getContext().getString(R$string.filter_qiannuan);
        s.h(string7, "context.getString(R.string.filter_qiannuan)");
        String string8 = getContext().getString(R$string.filter_beihaidao);
        s.h(string8, "context.getString(R.string.filter_beihaidao)");
        String string9 = getContext().getString(R$string.filter_naicha);
        s.h(string9, "context.getString(R.string.filter_naicha)");
        String string10 = getContext().getString(R$string.filter_landiaojiaopian);
        s.h(string10, "context.getString(R.string.filter_landiaojiaopian)");
        String string11 = getContext().getString(R$string.filter_riza);
        s.h(string11, "context.getString(R.string.filter_riza)");
        return kotlin.collections.s.o(new FKLiveFilterViewModel(string, R$mipmap.icon_filter_normal, null, 0, null, false, 56, null), new FKLiveFilterViewModel(string2, R$mipmap.icon_filter_lengyang, "Filter_30_Po8", 40, null, false, 48, null), new FKLiveFilterViewModel(string3, R$mipmap.icon_filter_haibianrenxiang, "Filter_31_Po9", 50, null, false, 48, null), new FKLiveFilterViewModel(string4, R$mipmap.icon_filter_wenrou, "Filter_23_Po1", 60, null, false, 48, null), new FKLiveFilterViewModel(string5, R$mipmap.icon_filter_oxgen, "Filter_03_20", 50, null, false, 48, null), new FKLiveFilterViewModel(string6, R$mipmap.icon_filter_makalong, "Filter_07_06", 40, null, false, 48, null), new FKLiveFilterViewModel(string7, R$mipmap.icon_filter_qiannuan, "Filter_10_11", 50, null, false, 48, null), new FKLiveFilterViewModel(string8, R$mipmap.icon_filter_beihaidao, "Filter_12_08", 60, null, false, 48, null), new FKLiveFilterViewModel(string9, R$mipmap.icon_filter_naicha, "Filter_27_Po5", 40, null, false, 48, null), new FKLiveFilterViewModel(string10, R$mipmap.icon_filter_landiaojiaopian, "Filter_47_S5", 70, null, false, 48, null), new FKLiveFilterViewModel(string11, R$mipmap.icon_filter_riza, "Filter_13_02", 40, null, false, 48, null));
    }

    @Override // com.cupidapp.live.mediapicker.view.CustomAnimationLayout
    public void a() {
        if (((FKLiveSingleSeekBarLayout) f(R$id.filterIntensityAdjustLayout)).d()) {
            return;
        }
        b bVar = this.f14879c;
        if (bVar != null) {
            bVar.a();
        }
        Property<View, Float> ALPHA = View.ALPHA;
        s.h(ALPHA, "ALPHA");
        b(ALPHA);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f14881e;
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

    public final void k(FKLiveFilterViewModel fKLiveFilterViewModel) {
        if (fKLiveFilterViewModel == null) {
            return;
        }
        ((RecyclerView) f(R$id.buttonListRecyclerView)).setVisibility(0);
        ((BottomConfirmAndCancelLayout) f(R$id.buttonListSelectLayout)).setVisibility(0);
        Iterator<Object> iterator2 = this.f14880d.j().iterator2();
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            }
            Object next = iterator2.next();
            if ((next instanceof FKLiveFilterViewModel) && s.d(((FKLiveFilterViewModel) next).getFilterResource(), fKLiveFilterViewModel.getFilterResource())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            return;
        }
        int i11 = 0;
        for (Object obj : this.f14880d.j()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            if (obj instanceof FKLiveFilterViewModel) {
                FKLiveFilterViewModel fKLiveFilterViewModel2 = (FKLiveFilterViewModel) obj;
                fKLiveFilterViewModel2.setSelected(i11 == i10);
                if (i11 == i10) {
                    fKLiveFilterViewModel2.setFilterIntensity(fKLiveFilterViewModel.getFilterIntensity());
                }
            }
            i11 = i12;
        }
        this.f14880d.notifyDataSetChanged();
        ((RecyclerView) f(R$id.buttonListRecyclerView)).smoothScrollToPosition(i10);
    }

    public final void l(@Nullable FKLiveFilterViewModel fKLiveFilterViewModel) {
        this.f14880d.j().clear();
        List<FKLiveFilterViewModel> filterTypeModelList = getFilterTypeModelList();
        ArrayList arrayList = new ArrayList(t.t(filterTypeModelList, 10));
        for (FKLiveFilterViewModel fKLiveFilterViewModel2 : filterTypeModelList) {
            if (s.d(fKLiveFilterViewModel2.getFilterResource(), fKLiveFilterViewModel != null ? fKLiveFilterViewModel.getFilterResource() : null)) {
                fKLiveFilterViewModel2.setSelected(true);
                fKLiveFilterViewModel2.setFilterIntensity(fKLiveFilterViewModel != null ? fKLiveFilterViewModel.getFilterIntensity() : null);
            }
            arrayList.add(p.f51048a);
        }
        this.f14880d.e(filterTypeModelList);
        this.f14880d.notifyDataSetChanged();
    }

    public final void m(Function1<? super FKLiveFilterViewModel, p> function1) {
        Object obj;
        Iterator<Object> iterator2 = this.f14880d.j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = iterator2.next();
                if ((obj instanceof FKLiveFilterViewModel) && ((FKLiveFilterViewModel) obj).isSelected()) {
                    break;
                }
            }
        }
        if (obj == null || !(obj instanceof FKLiveFilterViewModel)) {
            return;
        }
        function1.invoke(obj);
    }

    public final void o() {
        z.a(this, R$layout.layout_beauty_edit_button_list, true);
        int i10 = R$id.buttonListRecyclerView;
        ((RecyclerView) f(i10)).setAdapter(this.f14880d);
        RecyclerView recyclerView = (RecyclerView) f(i10);
        Context context = getContext();
        s.h(context, "context");
        recyclerView.setLayoutManager(new CustomLayoutManager(context, 0, ScrollTo.Center, Float.valueOf(0.5f)));
        int c4 = h.c(this, 7.5f);
        ((RecyclerView) f(i10)).addItemDecoration(new FKAddExtraSpacingDecoration(c4, c4, c4, 0, c4, 0, 32, null));
        int i11 = R$id.buttonListSelectLayout;
        ((BottomConfirmAndCancelLayout) f(i11)).setConfirmButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyFilterListLayout$initView$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                final FKLiveBeautyFilterListLayout fKLiveBeautyFilterListLayout = FKLiveBeautyFilterListLayout.this;
                fKLiveBeautyFilterListLayout.m(new Function1<FKLiveFilterViewModel, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyFilterListLayout$initView$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(FKLiveFilterViewModel fKLiveFilterViewModel) {
                        invoke2(fKLiveFilterViewModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull FKLiveFilterViewModel model) {
                        b bVar;
                        s.i(model, "model");
                        bVar = FKLiveBeautyFilterListLayout.this.f14879c;
                        if (bVar != null) {
                            bVar.b(model);
                        }
                        GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
                        String string = FKLiveBeautyFilterListLayout.this.getContext().getString(FKLiveBeautyButtonEnum.Filter.typeName());
                        s.h(string, "context.getString(FKLive…onEnum.Filter.typeName())");
                        groupLiveLog.h(string, model.getFilterName());
                    }
                });
                FKLiveBeautyFilterListLayout fKLiveBeautyFilterListLayout2 = FKLiveBeautyFilterListLayout.this;
                Property<View, Float> ALPHA = View.ALPHA;
                s.h(ALPHA, "ALPHA");
                fKLiveBeautyFilterListLayout2.b(ALPHA);
            }
        });
        ((BottomConfirmAndCancelLayout) f(i11)).setCancelButtonClickEvent(new Function0<p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyFilterListLayout$initView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKLiveBeautyFilterListLayout.this.d();
            }
        });
        ((FKLiveSingleSeekBarLayout) f(R$id.filterIntensityAdjustLayout)).setSingleSeekBarListener(new d() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyFilterListLayout$initView$3
            @Override // com.cupidapp.live.liveshow.beauty.view.d
            public void a() {
                FKLiveBeautyFilterListLayout.this.m(new Function1<FKLiveFilterViewModel, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyFilterListLayout$initView$3$cancelButtonClick$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(FKLiveFilterViewModel fKLiveFilterViewModel) {
                        invoke2(fKLiveFilterViewModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull FKLiveFilterViewModel model) {
                        s.i(model, "model");
                        i.f53231b.E(model.getFilterResource(), model.getFilterIntensity());
                    }
                });
            }

            @Override // com.cupidapp.live.liveshow.beauty.view.d
            public void b(@Nullable FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel, @Nullable final FKLiveFilterViewModel fKLiveFilterViewModel) {
                FKLiveBeautyFilterListLayout.this.m(new Function1<FKLiveFilterViewModel, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyFilterListLayout$initView$3$confirmButtonClick$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(FKLiveFilterViewModel fKLiveFilterViewModel2) {
                        invoke2(fKLiveFilterViewModel2);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull FKLiveFilterViewModel it) {
                        s.i(it, "it");
                        FKLiveFilterViewModel fKLiveFilterViewModel2 = FKLiveFilterViewModel.this;
                        if ((fKLiveFilterViewModel2 != null ? fKLiveFilterViewModel2.getFilterIntensity() : null) != null) {
                            it.setFilterIntensity(FKLiveFilterViewModel.this.getFilterIntensity());
                        }
                    }
                });
            }
        });
    }

    public final void p(@Nullable FKLiveFilterViewModel fKLiveFilterViewModel) {
        i.f53231b.E(fKLiveFilterViewModel != null ? fKLiveFilterViewModel.getFilterResource() : null, fKLiveFilterViewModel != null ? fKLiveFilterViewModel.getFilterIntensity() : null);
    }

    public final void q() {
        m(new Function1<FKLiveFilterViewModel, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyFilterListLayout$showFilterIntensityAdjustLayout$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FKLiveFilterViewModel fKLiveFilterViewModel) {
                invoke2(fKLiveFilterViewModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FKLiveFilterViewModel model) {
                s.i(model, "model");
                ((FKLiveSingleSeekBarLayout) FKLiveBeautyFilterListLayout.this.f(R$id.filterIntensityAdjustLayout)).v(model);
            }
        });
        FKLiveSingleSeekBarLayout fKLiveSingleSeekBarLayout = (FKLiveSingleSeekBarLayout) f(R$id.filterIntensityAdjustLayout);
        Property<View, Float> ALPHA = View.ALPHA;
        s.h(ALPHA, "ALPHA");
        fKLiveSingleSeekBarLayout.e(ALPHA);
    }

    public final void setMediaEditFilterListListener(@NotNull b listener) {
        s.i(listener, "listener");
        this.f14879c = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyFilterListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f14881e = new LinkedHashMap();
        FKLiveFilterAdapter fKLiveFilterAdapter = new FKLiveFilterAdapter();
        fKLiveFilterAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyFilterListLayout$filterAdapter$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FKLiveFilterViewModel) {
                    FKLiveFilterViewModel fKLiveFilterViewModel = (FKLiveFilterViewModel) obj;
                    if (fKLiveFilterViewModel.isSelected()) {
                        if (fKLiveFilterViewModel.getFilterResource() != null) {
                            FKLiveBeautyFilterListLayout.this.q();
                        }
                    } else {
                        FKLiveBeautyFilterListLayout.this.k(fKLiveFilterViewModel);
                        i.f53231b.E(fKLiveFilterViewModel.getFilterResource(), fKLiveFilterViewModel.getFilterIntensity());
                    }
                }
            }
        });
        this.f14880d = fKLiveFilterAdapter;
        o();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyFilterListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f14881e = new LinkedHashMap();
        FKLiveFilterAdapter fKLiveFilterAdapter = new FKLiveFilterAdapter();
        fKLiveFilterAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyFilterListLayout$filterAdapter$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FKLiveFilterViewModel) {
                    FKLiveFilterViewModel fKLiveFilterViewModel = (FKLiveFilterViewModel) obj;
                    if (fKLiveFilterViewModel.isSelected()) {
                        if (fKLiveFilterViewModel.getFilterResource() != null) {
                            FKLiveBeautyFilterListLayout.this.q();
                        }
                    } else {
                        FKLiveBeautyFilterListLayout.this.k(fKLiveFilterViewModel);
                        i.f53231b.E(fKLiveFilterViewModel.getFilterResource(), fKLiveFilterViewModel.getFilterIntensity());
                    }
                }
            }
        });
        this.f14880d = fKLiveFilterAdapter;
        o();
    }
}
