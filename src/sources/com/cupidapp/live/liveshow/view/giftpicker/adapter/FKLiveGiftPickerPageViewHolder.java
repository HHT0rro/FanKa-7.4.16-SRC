package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.GiftExpireModel;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.liveshow.model.GiftModel;
import com.cupidapp.live.liveshow.model.ParcelItemModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveGiftPickerPageAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftPickerPageViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f15429e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Function1<FKLiveGiftPickerItemViewModel, p> f15430c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f15431d;

    /* compiled from: FKLiveGiftPickerPageAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveGiftPickerPageViewHolder a(@NotNull ViewGroup parent, @NotNull Function1<? super FKLiveGiftPickerItemViewModel, p> showGiftExpiredList) {
            s.i(parent, "parent");
            s.i(showGiftExpiredList, "showGiftExpiredList");
            return new FKLiveGiftPickerPageViewHolder(z.b(parent, R$layout.view_holder_live_gift_picker_page, false, 2, null), showGiftExpiredList);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FKLiveGiftPickerPageViewHolder(@NotNull View itemView, @NotNull Function1<? super FKLiveGiftPickerItemViewModel, p> showGiftExpiredList) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(showGiftExpiredList, "showGiftExpiredList");
        this.f15430c = showGiftExpiredList;
        this.f15431d = c.b(new Function0<FKLiveGiftPickerItemAdapter>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.adapter.FKLiveGiftPickerPageViewHolder$itemAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveGiftPickerItemAdapter invoke() {
                FKLiveGiftPickerItemAdapter fKLiveGiftPickerItemAdapter = new FKLiveGiftPickerItemAdapter();
                final FKLiveGiftPickerPageViewHolder fKLiveGiftPickerPageViewHolder = FKLiveGiftPickerPageViewHolder.this;
                fKLiveGiftPickerItemAdapter.setHasStableIds(true);
                fKLiveGiftPickerItemAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.adapter.FKLiveGiftPickerPageViewHolder$itemAdapter$2$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof FKLiveGiftPickerItemViewModel) {
                            FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel = (FKLiveGiftPickerItemViewModel) obj;
                            if (fKLiveGiftPickerItemViewModel.isSelected()) {
                                return;
                            }
                            EventBus.c().l(new SelectCurrentGiftEvent(fKLiveGiftPickerItemViewModel.getGiftItemModel()));
                        }
                    }
                });
                fKLiveGiftPickerItemAdapter.l().h(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.adapter.FKLiveGiftPickerPageViewHolder$itemAdapter$2$1$2
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
                        if (obj instanceof FKLiveGiftPickerItemViewModel) {
                            GiftItemModel giftItemModel = ((FKLiveGiftPickerItemViewModel) obj).getGiftItemModel();
                            if (giftItemModel instanceof ParcelItemModel) {
                                List<GiftExpireModel> expirationDetails = ((ParcelItemModel) giftItemModel).getExpirationDetails();
                                if (expirationDetails == null || expirationDetails.isEmpty()) {
                                    return;
                                }
                                FKLiveGiftPickerPageViewHolder.this.s().invoke(obj);
                                return;
                            }
                            if (giftItemModel instanceof GiftModel) {
                                GiftModel giftModel = (GiftModel) giftItemModel;
                                if (giftModel.getUpgradeGiftList() != null && (!r5.isEmpty())) {
                                    r2 = true;
                                }
                                if (r2) {
                                    EventBus.c().l(new a(giftModel));
                                }
                            }
                        }
                    }
                });
                return fKLiveGiftPickerItemAdapter;
            }
        });
        RecyclerView recyclerView = (RecyclerView) itemView.findViewById(R$id.liveGiftPickerItemRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(itemView.getContext(), 4));
        recyclerView.setAdapter(r());
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKLiveGiftPickerPageViewModel) {
            r().j().clear();
            r().e(((FKLiveGiftPickerPageViewModel) obj).getOnePageGiftList());
            r().notifyDataSetChanged();
        }
    }

    public final FKLiveGiftPickerItemAdapter r() {
        return (FKLiveGiftPickerItemAdapter) this.f15431d.getValue();
    }

    @NotNull
    public final Function1<FKLiveGiftPickerItemViewModel, p> s() {
        return this.f15430c;
    }
}
