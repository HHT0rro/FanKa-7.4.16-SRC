package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.base.view.indicator.PagerIndicatorLayout;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.liveshow.model.GiftModel;
import com.cupidapp.live.liveshow.model.ParcelItemModel;
import com.cupidapp.live.liveshow.model.SingleTabGiftConfigModel;
import com.cupidapp.live.liveshow.model.SingleTabGiftListModel;
import com.cupidapp.live.liveshow.view.giftpicker.adapter.BaseLiveGiftPickerPagerUiModel;
import com.cupidapp.live.liveshow.view.giftpicker.adapter.FKLiveGiftExpireAdapter;
import com.cupidapp.live.liveshow.view.giftpicker.adapter.FKLiveGiftPickerEmptyUiModel;
import com.cupidapp.live.liveshow.view.giftpicker.adapter.FKLiveGiftPickerItemViewModel;
import com.cupidapp.live.liveshow.view.giftpicker.adapter.FKLiveGiftPickerPageAdapter;
import com.cupidapp.live.liveshow.view.giftpicker.adapter.FKLiveGiftPickerPageViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.z;

/* compiled from: FKLiveGiftPickerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftPickerLayout extends FrameLayout {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f15514g = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f15515b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f15516c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public h f15517d;

    /* renamed from: e, reason: collision with root package name */
    public int f15518e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15519f;

    /* compiled from: FKLiveGiftPickerLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftPickerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15519f = new LinkedHashMap();
        this.f15515b = kotlin.c.b(new Function0<FKLiveGiftPickerPageAdapter>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftPickerLayout$giftPickerAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveGiftPickerPageAdapter invoke() {
                final FKLiveGiftPickerLayout fKLiveGiftPickerLayout = FKLiveGiftPickerLayout.this;
                return new FKLiveGiftPickerPageAdapter(new Function1<FKLiveGiftPickerItemViewModel, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftPickerLayout$giftPickerAdapter$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel) {
                        invoke2(fKLiveGiftPickerItemViewModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull FKLiveGiftPickerItemViewModel it) {
                        s.i(it, "it");
                        GiftItemModel giftItemModel = it.getGiftItemModel();
                        if (giftItemModel instanceof ParcelItemModel) {
                            FKLiveGiftPickerLayout.this.n((ParcelItemModel) giftItemModel);
                        }
                    }
                });
            }
        });
        this.f15516c = kotlin.c.b(FKLiveGiftPickerLayout$expireAdapter$2.INSTANCE);
        h();
    }

    private final FKLiveGiftExpireAdapter getExpireAdapter() {
        return (FKLiveGiftExpireAdapter) this.f15516c.getValue();
    }

    private final FKLiveGiftPickerPageAdapter getGiftPickerAdapter() {
        return (FKLiveGiftPickerPageAdapter) this.f15515b.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15519f;
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

    public final void d(@Nullable List<SingleTabGiftConfigModel> list, @Nullable final String str, @NotNull Function1<? super GiftItemModel, p> selectedGiftCallback) {
        s.i(selectedGiftCallback, "selectedGiftCallback");
        if (list == null) {
            return;
        }
        e(list, new Function1<GiftItemModel, Boolean>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftPickerLayout$configGiftPickerLayoutData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GiftItemModel it) {
                s.i(it, "it");
                return Boolean.valueOf(s.d(String.this, it.getItemId()));
            }
        }, selectedGiftCallback);
    }

    public final void e(@NotNull List<SingleTabGiftConfigModel> allTabGiftList, @NotNull Function1<? super GiftItemModel, Boolean> selectedGiftCondition, @NotNull Function1<? super GiftItemModel, p> selectedGiftCallback) {
        FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel;
        s.i(allTabGiftList, "allTabGiftList");
        s.i(selectedGiftCondition, "selectedGiftCondition");
        s.i(selectedGiftCallback, "selectedGiftCallback");
        o();
        getGiftPickerAdapter().j().clear();
        int i10 = 0;
        for (SingleTabGiftConfigModel singleTabGiftConfigModel : allTabGiftList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            g(i10, singleTabGiftConfigModel, selectedGiftCondition);
            i10 = i11;
        }
        getGiftPickerAdapter().notifyDataSetChanged();
        int i12 = 0;
        int i13 = 0;
        for (Object obj : getGiftPickerAdapter().j()) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                kotlin.collections.s.s();
            }
            if (obj instanceof FKLiveGiftPickerPageViewModel) {
                FKLiveGiftPickerPageViewModel fKLiveGiftPickerPageViewModel = (FKLiveGiftPickerPageViewModel) obj;
                Iterator<FKLiveGiftPickerItemViewModel> iterator2 = fKLiveGiftPickerPageViewModel.getOnePageGiftList().iterator2();
                while (true) {
                    if (iterator2.hasNext()) {
                        fKLiveGiftPickerItemViewModel = iterator2.next();
                        if (fKLiveGiftPickerItemViewModel.isSelected()) {
                            break;
                        }
                    } else {
                        fKLiveGiftPickerItemViewModel = null;
                        break;
                    }
                }
                FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel2 = fKLiveGiftPickerItemViewModel;
                if (fKLiveGiftPickerItemViewModel2 != null) {
                    this.f15518e = fKLiveGiftPickerPageViewModel.getTabPosition();
                    selectedGiftCallback.invoke(fKLiveGiftPickerItemViewModel2.getGiftItemModel());
                    i12 = i13;
                }
            }
            i13 = i14;
        }
        ((ViewPager2) a(R$id.giftPickerViewPager)).setCurrentItem(i12, false);
        f(i12);
    }

    public final void f(int i10) {
        if (getGiftPickerAdapter().f(i10)) {
            Object obj = getGiftPickerAdapter().j().get(i10);
            if (obj instanceof FKLiveGiftPickerEmptyUiModel) {
                ((PagerIndicatorLayout) a(R$id.giftPickerIndicatorLayout)).setVisibility(8);
                p((BaseLiveGiftPickerPagerUiModel) obj);
            } else if (obj instanceof FKLiveGiftPickerPageViewModel) {
                int i11 = R$id.giftPickerIndicatorLayout;
                ((PagerIndicatorLayout) a(i11)).setVisibility(0);
                FKLiveGiftPickerPageViewModel fKLiveGiftPickerPageViewModel = (FKLiveGiftPickerPageViewModel) obj;
                if (((PagerIndicatorLayout) a(i11)).getPagerCount() != fKLiveGiftPickerPageViewModel.getTotalIndicatorCount()) {
                    ((PagerIndicatorLayout) a(i11)).setPagerCount(fKLiveGiftPickerPageViewModel.getTotalIndicatorCount());
                }
                if (((PagerIndicatorLayout) a(i11)).getCurrentPager() != fKLiveGiftPickerPageViewModel.getCurrentIndicatorCount()) {
                    ((PagerIndicatorLayout) a(i11)).setCurrentPager(fKLiveGiftPickerPageViewModel.getCurrentIndicatorCount());
                }
                p((BaseLiveGiftPickerPagerUiModel) obj);
            }
        }
    }

    public final void g(int i10, SingleTabGiftConfigModel singleTabGiftConfigModel, Function1<? super GiftItemModel, Boolean> function1) {
        if (singleTabGiftConfigModel.getList().isEmpty()) {
            getGiftPickerAdapter().d(new FKLiveGiftPickerEmptyUiModel(Integer.valueOf(R$mipmap.icon_live_empty_package), singleTabGiftConfigModel.getEmptyText(), i10, singleTabGiftConfigModel.getTitle()));
            return;
        }
        int ceil = (int) Math.ceil(singleTabGiftConfigModel.getList().size() / 8);
        ArrayList arrayList = null;
        int i11 = 0;
        int i12 = 0;
        for (GiftItemModel giftItemModel : singleTabGiftConfigModel.getList()) {
            int i13 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            GiftItemModel giftItemModel2 = giftItemModel;
            if (i11 % 8 == 0) {
                arrayList = new ArrayList();
                getGiftPickerAdapter().d(new FKLiveGiftPickerPageViewModel(arrayList, ceil, i12, i10, singleTabGiftConfigModel.getTitle()));
                i12++;
            }
            boolean booleanValue = function1.invoke(giftItemModel2).booleanValue();
            if (arrayList != null) {
                arrayList.add(new FKLiveGiftPickerItemViewModel(giftItemModel2, booleanValue));
            }
            i11 = i13;
        }
    }

    @NotNull
    public final List<FKLiveGiftPickerItemViewModel> getCurrentTabGiftList() {
        List<Object> j10 = getGiftPickerAdapter().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FKLiveGiftPickerPageViewModel) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            x.x(arrayList2, ((FKLiveGiftPickerPageViewModel) iterator2.next()).getOnePageGiftList());
        }
        return arrayList2;
    }

    public final void h() {
        z.a(this, R$layout.layout_live_gift_picker, true);
        int i10 = R$id.giftPickerViewPager;
        ((ViewPager2) a(i10)).setAdapter(getGiftPickerAdapter());
        ((ViewPager2) a(i10)).registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftPickerLayout$initView$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i11) {
                FKLiveGiftPickerLayout.this.f(i11);
            }
        });
    }

    public final void i(int i10, @Nullable SingleTabGiftListModel singleTabGiftListModel) {
        List<GiftModel> giftList = singleTabGiftListModel != null ? singleTabGiftListModel.getGiftList() : null;
        if (giftList == null || giftList.isEmpty()) {
            return;
        }
        m(i10);
        List<Object> j10 = getGiftPickerAdapter().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FKLiveGiftPickerPageViewModel) {
                arrayList.add(obj);
            }
        }
        ArrayList<FKLiveGiftPickerItemViewModel> arrayList2 = new ArrayList();
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            x.x(arrayList2, ((FKLiveGiftPickerPageViewModel) iterator2.next()).getOnePageGiftList());
        }
        for (FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel : arrayList2) {
            Iterator<GiftModel> iterator22 = giftList.iterator2();
            int i11 = 0;
            while (true) {
                if (!iterator22.hasNext()) {
                    i11 = -1;
                    break;
                } else if (s.d(iterator22.next().getItemId(), fKLiveGiftPickerItemViewModel.getGiftItemModel().getItemId())) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 != -1) {
                fKLiveGiftPickerItemViewModel.setGiftItemModel(giftList.get(i11));
            }
        }
        getGiftPickerAdapter().notifyDataSetChanged();
    }

    public final void j(@Nullable String str) {
        if (str == null) {
            return;
        }
        for (FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel : getCurrentTabGiftList()) {
            fKLiveGiftPickerItemViewModel.setSelected(s.d(fKLiveGiftPickerItemViewModel.getGiftItemModel().getItemId(), str));
            if (!fKLiveGiftPickerItemViewModel.isSelected()) {
                fKLiveGiftPickerItemViewModel.stopItemAnimator();
            }
        }
        getGiftPickerAdapter().notifyDataSetChanged();
    }

    public final void k(@NotNull Function1<? super GiftItemModel, Boolean> selectedGiftCondition) {
        s.i(selectedGiftCondition, "selectedGiftCondition");
        for (FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel : getCurrentTabGiftList()) {
            fKLiveGiftPickerItemViewModel.setSelected(selectedGiftCondition.invoke(fKLiveGiftPickerItemViewModel.getGiftItemModel()).booleanValue());
            if (!fKLiveGiftPickerItemViewModel.isSelected()) {
                fKLiveGiftPickerItemViewModel.stopItemAnimator();
            }
        }
        getGiftPickerAdapter().notifyDataSetChanged();
    }

    public final void l() {
        for (FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel : getCurrentTabGiftList()) {
            fKLiveGiftPickerItemViewModel.setSelected(false);
            fKLiveGiftPickerItemViewModel.stopItemAnimator();
        }
        getGiftPickerAdapter().notifyDataSetChanged();
    }

    public final void m(int i10) {
        Iterator<Object> iterator2 = getGiftPickerAdapter().j().iterator2();
        int i11 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i11 = -1;
                break;
            }
            Object next = iterator2.next();
            if ((next instanceof BaseLiveGiftPickerPagerUiModel) && ((BaseLiveGiftPickerPagerUiModel) next).getTabPosition() == i10) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 != -1) {
            this.f15518e = i10;
            ((ViewPager2) a(R$id.giftPickerViewPager)).setCurrentItem(i11, false);
        }
    }

    public final void n(ParcelItemModel parcelItemModel) {
        Context context;
        final AlertDialog g3;
        if (parcelItemModel.getExpirationDetails() == null || (context = getContext()) == null) {
            return;
        }
        View layout = View.inflate(context, R$layout.live_gift_expired_times, null);
        z0.b bVar = z0.b.f54812a;
        s.h(layout, "layout");
        g3 = bVar.g(context, layout, 0, 0, z0.h.c(this, 280.0f), -2, (r32 & 64) != 0 ? 17 : 17, (r32 & 128) != 0 ? null : null, (r32 & 256) != 0 ? null : null, (r32 & 512) != 0 ? null : null, (r32 & 1024) != 0 ? null : null, (r32 & 2048) != 0 ? null : null, (r32 & 4096) != 0 ? null : null, (r32 & 8192) != 0 ? null : null);
        ImageLoaderView icon = (ImageLoaderView) layout.findViewById(R$id.expired_gift_icon);
        ViewGroup.LayoutParams layoutParams = icon.getLayoutParams();
        ImageModel image = parcelItemModel.getImage();
        s.h(icon, "showGiftExpiredListDialog$lambda$1$lambda$0");
        layoutParams.width = image.getScaleWidthByHeight(z0.h.c(icon, 64.0f));
        s.h(icon, "icon");
        ImageLoaderView.g(icon, parcelItemModel.getImage(), null, null, 6, null);
        TextView textView = (TextView) layout.findViewById(R$id.expired_gift_count);
        textView.getPaint().setFakeBoldText(true);
        String name = parcelItemModel.getName();
        y yVar = y.f51038a;
        String string = getContext().getString(R$string.total_count);
        s.h(string, "context.getString(R.string.total_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(parcelItemModel.getCount())}, 1));
        s.h(format, "format(format, *args)");
        textView.setText(t.k(name + " " + format, -49088, new String[]{String.valueOf(parcelItemModel.getCount())}, false, 4, null));
        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R$id.expired_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        recyclerView.addItemDecoration(new FKAddExtraSpacingDecoration(0, 0, 0, z0.h.c(this, 8.0f), 0, 0, 32, null));
        recyclerView.setAdapter(getExpireAdapter());
        getExpireAdapter().j().clear();
        getExpireAdapter().j().addAll(parcelItemModel.getExpirationDetails());
        getExpireAdapter().notifyDataSetChanged();
        View findViewById = layout.findViewById(R$id.expired_btn);
        s.h(findViewById, "layout.findViewById<View>(R.id.expired_btn)");
        z0.y.d(findViewById, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftPickerLayout$showGiftExpiredListDialog$1$1
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
                g3.dismiss();
            }
        });
        g3.setCanceledOnTouchOutside(false);
    }

    public final void o() {
        FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel;
        Iterator<FKLiveGiftPickerItemViewModel> iterator2 = getCurrentTabGiftList().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                fKLiveGiftPickerItemViewModel = null;
                break;
            } else {
                fKLiveGiftPickerItemViewModel = iterator2.next();
                if (fKLiveGiftPickerItemViewModel.isSelected()) {
                    break;
                }
            }
        }
        FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel2 = fKLiveGiftPickerItemViewModel;
        if (fKLiveGiftPickerItemViewModel2 != null) {
            fKLiveGiftPickerItemViewModel2.stopItemAnimator();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    public final void p(BaseLiveGiftPickerPagerUiModel baseLiveGiftPickerPagerUiModel) {
        if (this.f15518e != baseLiveGiftPickerPagerUiModel.getTabPosition()) {
            h hVar = this.f15517d;
            if (hVar != null) {
                hVar.a(baseLiveGiftPickerPagerUiModel.getTabPosition(), baseLiveGiftPickerPagerUiModel.getTabName());
            }
            this.f15518e = baseLiveGiftPickerPagerUiModel.getTabPosition();
        }
    }

    public final void setListener(@NotNull h listener) {
        s.i(listener, "listener");
        this.f15517d = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftPickerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15519f = new LinkedHashMap();
        this.f15515b = kotlin.c.b(new Function0<FKLiveGiftPickerPageAdapter>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftPickerLayout$giftPickerAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveGiftPickerPageAdapter invoke() {
                final FKLiveGiftPickerLayout fKLiveGiftPickerLayout = FKLiveGiftPickerLayout.this;
                return new FKLiveGiftPickerPageAdapter(new Function1<FKLiveGiftPickerItemViewModel, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftPickerLayout$giftPickerAdapter$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel) {
                        invoke2(fKLiveGiftPickerItemViewModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull FKLiveGiftPickerItemViewModel it) {
                        s.i(it, "it");
                        GiftItemModel giftItemModel = it.getGiftItemModel();
                        if (giftItemModel instanceof ParcelItemModel) {
                            FKLiveGiftPickerLayout.this.n((ParcelItemModel) giftItemModel);
                        }
                    }
                });
            }
        });
        this.f15516c = kotlin.c.b(FKLiveGiftPickerLayout$expireAdapter$2.INSTANCE);
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftPickerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15519f = new LinkedHashMap();
        this.f15515b = kotlin.c.b(new Function0<FKLiveGiftPickerPageAdapter>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftPickerLayout$giftPickerAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveGiftPickerPageAdapter invoke() {
                final FKLiveGiftPickerLayout fKLiveGiftPickerLayout = FKLiveGiftPickerLayout.this;
                return new FKLiveGiftPickerPageAdapter(new Function1<FKLiveGiftPickerItemViewModel, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftPickerLayout$giftPickerAdapter$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel) {
                        invoke2(fKLiveGiftPickerItemViewModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull FKLiveGiftPickerItemViewModel it) {
                        s.i(it, "it");
                        GiftItemModel giftItemModel = it.getGiftItemModel();
                        if (giftItemModel instanceof ParcelItemModel) {
                            FKLiveGiftPickerLayout.this.n((ParcelItemModel) giftItemModel);
                        }
                    }
                });
            }
        });
        this.f15516c = kotlin.c.b(FKLiveGiftPickerLayout$expireAdapter$2.INSTANCE);
        h();
    }
}
