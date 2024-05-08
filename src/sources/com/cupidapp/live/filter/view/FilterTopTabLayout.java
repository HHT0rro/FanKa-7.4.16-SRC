package com.cupidapp.live.filter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.filter.adapter.TopFilterTabAdapter;
import com.cupidapp.live.filter.model.FilterTopOptionsUiModel;
import com.cupidapp.live.filter.model.FilterTopRangeUiModel;
import com.cupidapp.live.filter.model.FilterTopTabItemModel;
import com.cupidapp.live.filter.model.FilterTopTabModel;
import com.cupidapp.live.filter.model.FilterTopTabType;
import com.cupidapp.live.filter.model.FilterTopTabUiBaseModel;
import com.cupidapp.live.filter.model.TabLayoutStyle;
import com.cupidapp.live.filter.util.ContactFilterRangeBarPopupHelper;
import com.cupidapp.live.match.event.ShowPurchaseDialogEvent;
import com.cupidapp.live.match.model.FilterOption;
import com.cupidapp.live.match.model.MatchFilterModel;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.o;
import z0.y;
import z0.z;

/* compiled from: FilterTopTabLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FilterTopTabLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public TabLayoutStyle f14640d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14641e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public SensorPosition f14642f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public String f14643g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public xb.b f14644h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f14645i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.filter.view.a f14646j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f14647k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14648l;

    /* compiled from: FilterTopTabLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14649a;

        static {
            int[] iArr = new int[PurchaseProductType.values().length];
            try {
                iArr[PurchaseProductType.SVIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f14649a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterTopTabLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f14648l = new LinkedHashMap();
        this.f14640d = TabLayoutStyle.RED_WHITE;
        this.f14642f = SensorPosition.Unknown;
        this.f14643g = "";
        this.f14645i = c.b(new Function0<View>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$alphaBgView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view = new View(FilterTopTabLayout.this.getContext());
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                view.setBackgroundResource(R$color.app_black_45_alpha);
                return view;
            }
        });
        this.f14647k = c.b(new Function0<TopFilterTabAdapter>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TopFilterTabAdapter invoke() {
                TopFilterTabAdapter topFilterTabAdapter = new TopFilterTabAdapter();
                final FilterTopTabLayout filterTopTabLayout = FilterTopTabLayout.this;
                topFilterTabAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$adapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable final Object obj) {
                        SensorPosition sensorPosition;
                        xb.b bVar;
                        xb.b bVar2;
                        if (obj instanceof FilterTopTabUiBaseModel) {
                            Context context2 = FilterTopTabLayout.this.getContext();
                            if (context2 != null) {
                                final FilterTopTabLayout filterTopTabLayout2 = FilterTopTabLayout.this;
                                bVar = filterTopTabLayout2.f14644h;
                                if (bVar != null) {
                                    LocationUtils.Companion companion = LocationUtils.f12270h;
                                    bVar2 = filterTopTabLayout2.f14644h;
                                    s.f(bVar2);
                                    companion.e(context2, bVar2, new Function0<p>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$adapter$2$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            FilterTopTabLayout.this.q((FilterTopTabUiBaseModel) obj);
                                        }
                                    });
                                } else {
                                    filterTopTabLayout2.q((FilterTopTabUiBaseModel) obj);
                                }
                            }
                            GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                            sensorPosition = FilterTopTabLayout.this.f14642f;
                            groupOthersLog.Q(sensorPosition.getValue(), ((FilterTopTabUiBaseModel) obj).getKey());
                        }
                    }
                });
                return topFilterTabAdapter;
            }
        });
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TopFilterTabAdapter getAdapter() {
        return (TopFilterTabAdapter) this.f14647k.getValue();
    }

    private final View getAlphaBgView() {
        return (View) this.f14645i.getValue();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f14648l;
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

    public final void k(@NotNull TabLayoutStyle style) {
        s.i(style, "style");
        this.f14640d = style;
        for (Object obj : getAdapter().j()) {
            if (obj instanceof FilterTopTabUiBaseModel) {
                FilterTopTabUiBaseModel filterTopTabUiBaseModel = (FilterTopTabUiBaseModel) obj;
                filterTopTabUiBaseModel.setStyle(style);
                filterTopTabUiBaseModel.setOpened(false);
            }
        }
        getAdapter().notifyDataSetChanged();
        w();
    }

    public final void l(@NotNull FilterTopTabModel model, @NotNull TabLayoutStyle tabStyle, @NotNull SensorPosition position, @NotNull String trackPre, @NotNull xb.b rxPermissions) {
        s.i(model, "model");
        s.i(tabStyle, "tabStyle");
        s.i(position, "position");
        s.i(trackPre, "trackPre");
        s.i(rxPermissions, "rxPermissions");
        this.f14644h = rxPermissions;
        this.f14640d = tabStyle;
        this.f14642f = position;
        this.f14643g = trackPre;
        this.f14641e = model.getUseFilter();
        List<FilterTopTabUiBaseModel> s2 = s(model, tabStyle);
        getAdapter().j().clear();
        getAdapter().j().addAll(s2);
        getAdapter().notifyDataSetChanged();
        w();
    }

    public final String m(List<FilterOption> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (FilterOption filterOption : list) {
            if (filterOption.getChecked()) {
                sb2.append(filterOption.getLabel());
                sb2.append((char) 12289);
            }
        }
        String sb3 = sb2.toString();
        s.h(sb3, "content.toString()");
        return StringsKt__StringsKt.R0(sb3, 12289);
    }

    public final String o(RangeMatchFilterViewModel rangeMatchFilterViewModel) {
        String string;
        if (rangeMatchFilterViewModel == null) {
            return "";
        }
        boolean z10 = rangeMatchFilterViewModel.getMin() == rangeMatchFilterViewModel.getMatchFilterModel().getDefaultMin();
        boolean z11 = rangeMatchFilterViewModel.getMax() == rangeMatchFilterViewModel.getMatchFilterModel().getDefaultMax();
        if (z10 && z11) {
            return "";
        }
        if (z10 && !rangeMatchFilterViewModel.getSearchHasMin()) {
            string = getContext().getString(R$string.range_max, Integer.valueOf(rangeMatchFilterViewModel.getMax()), rangeMatchFilterViewModel.getMatchFilterModel().getUnit());
            s.h(string, "{\n                contex…Model.unit)\n            }");
        } else if (z11 && !rangeMatchFilterViewModel.getSearchHasMax()) {
            string = getContext().getString(R$string.range_min, Integer.valueOf(rangeMatchFilterViewModel.getMin()), rangeMatchFilterViewModel.getMatchFilterModel().getUnit());
            s.h(string, "{\n                contex…Model.unit)\n            }");
        } else {
            String string2 = getContext().getString(R$string.range_min_to_max_unit, Integer.valueOf(rangeMatchFilterViewModel.getMin()), Integer.valueOf(rangeMatchFilterViewModel.getMax()), rangeMatchFilterViewModel.getMatchFilterModel().getUnit());
            s.h(string2, "{\n                contex…          )\n            }");
            return string2;
        }
        return string;
    }

    public final VipPurchaseEntranceType p(PurchaseProductType purchaseProductType) {
        if (a.f14649a[purchaseProductType.ordinal()] == 1) {
            VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.SuperFilterCommon;
            vipPurchaseEntranceType.setPosition(this.f14642f);
            return vipPurchaseEntranceType;
        }
        VipPurchaseEntranceType vipPurchaseEntranceType2 = VipPurchaseEntranceType.FilterCommon;
        vipPurchaseEntranceType2.setPosition(this.f14642f);
        return vipPurchaseEntranceType2;
    }

    public final void q(FilterTopTabUiBaseModel filterTopTabUiBaseModel) {
        PurchaseProductType f10 = PurchaseProductType.Companion.f(filterTopTabUiBaseModel.getProductType());
        if (t(f10, filterTopTabUiBaseModel)) {
            com.cupidapp.live.filter.view.a aVar = this.f14646j;
            if (aVar != null) {
                aVar.a(filterTopTabUiBaseModel);
                return;
            }
            return;
        }
        EventBus.c().l(new ShowPurchaseDialogEvent(p(f10), this.f14643g + filterTopTabUiBaseModel.getKey(), f10));
    }

    public final void r() {
        z.a(this, R$layout.layout_contact_filter, true);
        int i10 = R$id.contact_filter_rv;
        ((RecyclerView) e(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) e(i10)).setAdapter(getAdapter());
        ((RecyclerView) e(i10)).addItemDecoration(new FKAddExtraSpacingDecoration(0, 0, h.c(this, 8.0f), 0, h.c(this, 8.0f), 0, 32, null));
        ImageView filter_tab_img = (ImageView) e(R$id.filter_tab_img);
        s.h(filter_tab_img, "filter_tab_img");
        y.d(filter_tab_img, new Function1<View, p>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$initView$1
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
                xb.b bVar;
                a aVar;
                xb.b bVar2;
                bVar = FilterTopTabLayout.this.f14644h;
                if (bVar != null) {
                    LocationUtils.Companion companion = LocationUtils.f12270h;
                    Context context = FilterTopTabLayout.this.getContext();
                    s.h(context, "context");
                    bVar2 = FilterTopTabLayout.this.f14644h;
                    s.f(bVar2);
                    final FilterTopTabLayout filterTopTabLayout = FilterTopTabLayout.this;
                    companion.e(context, bVar2, new Function0<p>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$initView$1.1
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
                            a aVar2;
                            aVar2 = FilterTopTabLayout.this.f14646j;
                            if (aVar2 != null) {
                                aVar2.b();
                            }
                        }
                    });
                    return;
                }
                aVar = FilterTopTabLayout.this.f14646j;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
    }

    public final List<FilterTopTabUiBaseModel> s(FilterTopTabModel filterTopTabModel, TabLayoutStyle tabLayoutStyle) {
        FilterTopTabUiBaseModel filterTopOptionsUiModel;
        List<FilterTopTabItemModel> list = filterTopTabModel.getList();
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        for (FilterTopTabItemModel filterTopTabItemModel : list) {
            if (s.d(filterTopTabItemModel.getFilterType(), FilterTopTabType.Range.getValue())) {
                RangeMatchFilterViewModel rangeMatchFilterViewModel = new RangeMatchFilterViewModel(new MatchFilterModel(filterTopTabItemModel.getName(), filterTopTabItemModel.getKey(), MatchFilterModel.MatchFilterType.Range, null, null, filterTopTabItemModel.getMinValue(), filterTopTabItemModel.getMaxValue(), filterTopTabItemModel.getDefaultMin(), filterTopTabItemModel.getDefaultMax(), filterTopTabItemModel.getUnit()), 0, 0, s.d(filterTopTabItemModel.getKey(), "filterActiveTime"), s.d(filterTopTabItemModel.getKey(), "filterAge"), null, 38, null);
                filterTopOptionsUiModel = new FilterTopRangeUiModel(o(rangeMatchFilterViewModel), filterTopTabItemModel.getKey(), filterTopTabItemModel.getProductType(), tabLayoutStyle, false, filterTopTabItemModel.getName(), rangeMatchFilterViewModel, filterTopTabModel.getLimitTimeReward());
            } else {
                String m10 = m(filterTopTabItemModel.getOptions());
                String key = filterTopTabItemModel.getKey();
                int productType = filterTopTabItemModel.getProductType();
                String name = filterTopTabItemModel.getName();
                List<FilterOption> options = filterTopTabItemModel.getOptions();
                if (options == null) {
                    options = kotlin.collections.s.j();
                }
                filterTopOptionsUiModel = new FilterTopOptionsUiModel(m10, key, productType, tabLayoutStyle, false, name, options, filterTopTabModel.getLimitTimeReward());
            }
            arrayList.add(filterTopOptionsUiModel);
        }
        return arrayList;
    }

    public final void setClickListener(@NotNull com.cupidapp.live.filter.view.a listener) {
        s.i(listener, "listener");
        this.f14646j = listener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if ((r3 != null && r3.getPro()) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean t(com.cupidapp.live.match.model.PurchaseProductType r5, com.cupidapp.live.filter.model.FilterTopTabUiBaseModel r6) {
        /*
            r4 = this;
            com.cupidapp.live.match.model.PurchaseProductType r0 = com.cupidapp.live.match.model.PurchaseProductType.NO
            r1 = 0
            r2 = 1
            if (r5 == r0) goto L25
            com.cupidapp.live.match.model.PurchaseProductType r0 = com.cupidapp.live.match.model.PurchaseProductType.VIP
            if (r5 != r0) goto L1d
            p1.g r3 = p1.g.f52734a
            com.cupidapp.live.profile.model.User r3 = r3.X()
            if (r3 == 0) goto L1a
            boolean r3 = r3.getPro()
            if (r3 != r2) goto L1a
            r3 = 1
            goto L1b
        L1a:
            r3 = 0
        L1b:
            if (r3 != 0) goto L25
        L1d:
            if (r5 != r0) goto L26
            boolean r5 = r6.getLimitTimeReward()
            if (r5 == 0) goto L26
        L25:
            r1 = 1
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.filter.view.FilterTopTabLayout.t(com.cupidapp.live.match.model.PurchaseProductType, com.cupidapp.live.filter.model.FilterTopTabUiBaseModel):boolean");
    }

    public final void u(@NotNull FilterTopTabUiBaseModel model) {
        s.i(model, "model");
        v(model);
        if (model instanceof FilterTopOptionsUiModel) {
            x((FilterTopOptionsUiModel) model);
        } else if (model instanceof FilterTopRangeUiModel) {
            y((FilterTopRangeUiModel) model);
        }
    }

    public final void v(FilterTopTabUiBaseModel filterTopTabUiBaseModel) {
        for (Object obj : getAdapter().j()) {
            if (obj instanceof FilterTopTabUiBaseModel) {
                FilterTopTabUiBaseModel filterTopTabUiBaseModel2 = (FilterTopTabUiBaseModel) obj;
                filterTopTabUiBaseModel2.setOpened(s.d(filterTopTabUiBaseModel.getKey(), filterTopTabUiBaseModel2.getKey()));
            }
        }
        getAdapter().notifyDataSetChanged();
    }

    public final void w() {
        if (this.f14641e) {
            TabLayoutStyle tabLayoutStyle = this.f14640d;
            if (tabLayoutStyle == TabLayoutStyle.GOLD) {
                ImageView filter_tab_img = (ImageView) e(R$id.filter_tab_img);
                s.h(filter_tab_img, "filter_tab_img");
                o.b(filter_tab_img, -207721);
            } else if (tabLayoutStyle == TabLayoutStyle.RED_BLACK) {
                ImageView filter_tab_img2 = (ImageView) e(R$id.filter_tab_img);
                s.h(filter_tab_img2, "filter_tab_img");
                o.b(filter_tab_img2, -40864);
            } else {
                ImageView filter_tab_img3 = (ImageView) e(R$id.filter_tab_img);
                s.h(filter_tab_img3, "filter_tab_img");
                o.b(filter_tab_img3, -49088);
            }
        } else if (this.f14640d == TabLayoutStyle.RED_WHITE) {
            ImageView filter_tab_img4 = (ImageView) e(R$id.filter_tab_img);
            s.h(filter_tab_img4, "filter_tab_img");
            o.b(filter_tab_img4, -15066598);
        } else {
            ImageView filter_tab_img5 = (ImageView) e(R$id.filter_tab_img);
            s.h(filter_tab_img5, "filter_tab_img");
            o.b(filter_tab_img5, -1);
        }
        if (this.f14640d == TabLayoutStyle.RED_WHITE) {
            ((ImageView) e(R$id.filter_tab_img)).setBackgroundResource(R$drawable.rect_cor_16_sk_eeeeee);
        } else {
            ((ImageView) e(R$id.filter_tab_img)).setBackgroundResource(R$drawable.rect_cor_16_sk_404040);
        }
    }

    public final void x(final FilterTopOptionsUiModel filterTopOptionsUiModel) {
        ContactFilterRangeBarPopupHelper contactFilterRangeBarPopupHelper = ContactFilterRangeBarPopupHelper.f14616a;
        Context context = getContext();
        s.h(context, "context");
        contactFilterRangeBarPopupHelper.h(context, this, getAlphaBgView(), filterTopOptionsUiModel, this.f14640d, new Function0<p>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$showOptionSelect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                TopFilterTabAdapter adapter;
                a aVar;
                FilterTopOptionsUiModel.this.setOpened(false);
                adapter = this.getAdapter();
                adapter.notifyDataSetChanged();
                aVar = this.f14646j;
                if (aVar != null) {
                    aVar.c(FilterTopOptionsUiModel.this);
                }
            }
        });
    }

    public final void y(final FilterTopRangeUiModel filterTopRangeUiModel) {
        ContactFilterRangeBarPopupHelper contactFilterRangeBarPopupHelper = ContactFilterRangeBarPopupHelper.f14616a;
        Context context = getContext();
        s.h(context, "context");
        contactFilterRangeBarPopupHelper.j(context, this, getAlphaBgView(), filterTopRangeUiModel, this.f14640d, new Function0<p>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$showRangeBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                TopFilterTabAdapter adapter;
                a aVar;
                FilterTopRangeUiModel.this.setOpened(false);
                adapter = this.getAdapter();
                adapter.notifyDataSetChanged();
                aVar = this.f14646j;
                if (aVar != null) {
                    aVar.c(FilterTopRangeUiModel.this);
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterTopTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f14648l = new LinkedHashMap();
        this.f14640d = TabLayoutStyle.RED_WHITE;
        this.f14642f = SensorPosition.Unknown;
        this.f14643g = "";
        this.f14645i = c.b(new Function0<View>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$alphaBgView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view = new View(FilterTopTabLayout.this.getContext());
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                view.setBackgroundResource(R$color.app_black_45_alpha);
                return view;
            }
        });
        this.f14647k = c.b(new Function0<TopFilterTabAdapter>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TopFilterTabAdapter invoke() {
                TopFilterTabAdapter topFilterTabAdapter = new TopFilterTabAdapter();
                final FilterTopTabLayout filterTopTabLayout = FilterTopTabLayout.this;
                topFilterTabAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$adapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable final Object obj) {
                        SensorPosition sensorPosition;
                        xb.b bVar;
                        xb.b bVar2;
                        if (obj instanceof FilterTopTabUiBaseModel) {
                            Context context2 = FilterTopTabLayout.this.getContext();
                            if (context2 != null) {
                                final FilterTopTabLayout filterTopTabLayout2 = FilterTopTabLayout.this;
                                bVar = filterTopTabLayout2.f14644h;
                                if (bVar != null) {
                                    LocationUtils.Companion companion = LocationUtils.f12270h;
                                    bVar2 = filterTopTabLayout2.f14644h;
                                    s.f(bVar2);
                                    companion.e(context2, bVar2, new Function0<p>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$adapter$2$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            FilterTopTabLayout.this.q((FilterTopTabUiBaseModel) obj);
                                        }
                                    });
                                } else {
                                    filterTopTabLayout2.q((FilterTopTabUiBaseModel) obj);
                                }
                            }
                            GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                            sensorPosition = FilterTopTabLayout.this.f14642f;
                            groupOthersLog.Q(sensorPosition.getValue(), ((FilterTopTabUiBaseModel) obj).getKey());
                        }
                    }
                });
                return topFilterTabAdapter;
            }
        });
        r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterTopTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f14648l = new LinkedHashMap();
        this.f14640d = TabLayoutStyle.RED_WHITE;
        this.f14642f = SensorPosition.Unknown;
        this.f14643g = "";
        this.f14645i = c.b(new Function0<View>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$alphaBgView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view = new View(FilterTopTabLayout.this.getContext());
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                view.setBackgroundResource(R$color.app_black_45_alpha);
                return view;
            }
        });
        this.f14647k = c.b(new Function0<TopFilterTabAdapter>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TopFilterTabAdapter invoke() {
                TopFilterTabAdapter topFilterTabAdapter = new TopFilterTabAdapter();
                final FilterTopTabLayout filterTopTabLayout = FilterTopTabLayout.this;
                topFilterTabAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$adapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable final Object obj) {
                        SensorPosition sensorPosition;
                        xb.b bVar;
                        xb.b bVar2;
                        if (obj instanceof FilterTopTabUiBaseModel) {
                            Context context2 = FilterTopTabLayout.this.getContext();
                            if (context2 != null) {
                                final FilterTopTabLayout filterTopTabLayout2 = FilterTopTabLayout.this;
                                bVar = filterTopTabLayout2.f14644h;
                                if (bVar != null) {
                                    LocationUtils.Companion companion = LocationUtils.f12270h;
                                    bVar2 = filterTopTabLayout2.f14644h;
                                    s.f(bVar2);
                                    companion.e(context2, bVar2, new Function0<p>() { // from class: com.cupidapp.live.filter.view.FilterTopTabLayout$adapter$2$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            FilterTopTabLayout.this.q((FilterTopTabUiBaseModel) obj);
                                        }
                                    });
                                } else {
                                    filterTopTabLayout2.q((FilterTopTabUiBaseModel) obj);
                                }
                            }
                            GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                            sensorPosition = FilterTopTabLayout.this.f14642f;
                            groupOthersLog.Q(sensorPosition.getValue(), ((FilterTopTabUiBaseModel) obj).getKey());
                        }
                    }
                });
                return topFilterTabAdapter;
            }
        });
        r();
    }
}
