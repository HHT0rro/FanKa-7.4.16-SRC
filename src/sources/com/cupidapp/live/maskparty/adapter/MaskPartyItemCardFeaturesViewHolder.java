package com.cupidapp.live.maskparty.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesModel;
import com.cupidapp.live.maskparty.model.ItemCardType;
import com.cupidapp.live.maskparty.model.RoleType;
import com.cupidapp.live.maskparty.view.MaskPartyItemCardChooseRoleLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.c;
import kotlin.collections.i0;
import kotlin.collections.t;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.z;

/* compiled from: MaskPartyItemCardAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardFeaturesViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f16257e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function1<? super ItemCardFeaturesItemModel, p> f16258c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f16259d;

    /* compiled from: MaskPartyItemCardAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MaskPartyItemCardFeaturesViewHolder a(@NotNull ViewGroup parent, @Nullable Function1<? super ItemCardFeaturesItemModel, p> function1) {
            s.i(parent, "parent");
            MaskPartyItemCardFeaturesViewHolder maskPartyItemCardFeaturesViewHolder = new MaskPartyItemCardFeaturesViewHolder(z.b(parent, R$layout.view_holder_mask_party_item_card_features, false, 2, null));
            maskPartyItemCardFeaturesViewHolder.f16258c = function1;
            return maskPartyItemCardFeaturesViewHolder;
        }
    }

    /* compiled from: MaskPartyItemCardAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16260a;

        static {
            int[] iArr = new int[ItemCardType.values().length];
            try {
                iArr[ItemCardType.AttackMatch.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemCardType.CitySearch.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemCardType.SpeedUpMatch.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ItemCardType.MatchNumber.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f16260a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardFeaturesViewHolder(@NotNull final View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16259d = c.b(new Function0<MaskPartyItemCardFeaturesAdapter>() { // from class: com.cupidapp.live.maskparty.adapter.MaskPartyItemCardFeaturesViewHolder$featuresAdapter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MaskPartyItemCardFeaturesAdapter invoke() {
                MaskPartyItemCardFeaturesAdapter maskPartyItemCardFeaturesAdapter = new MaskPartyItemCardFeaturesAdapter();
                final MaskPartyItemCardFeaturesViewHolder maskPartyItemCardFeaturesViewHolder = MaskPartyItemCardFeaturesViewHolder.this;
                final View view = itemView;
                maskPartyItemCardFeaturesAdapter.l().k(i0.h(f.a(Integer.valueOf(R$id.choose_role_textview), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.maskparty.adapter.MaskPartyItemCardFeaturesViewHolder$featuresAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i10) {
                        if (obj instanceof ItemCardFeaturesItemModel) {
                            View findViewById = view.findViewById(R$id.choose_role_textview);
                            s.h(findViewById, "itemView.findViewById(R.id.choose_role_textview)");
                            MaskPartyItemCardFeaturesViewHolder.this.w((ItemCardFeaturesItemModel) obj, i10, findViewById);
                            SensorsLogKeyButtonClick.PropCard.CHOOSE_ROLE.click();
                        }
                    }
                }), f.a(Integer.valueOf(R$id.user_item_card_textview), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.maskparty.adapter.MaskPartyItemCardFeaturesViewHolder$featuresAdapter$2$1$2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i10) {
                        if (obj instanceof ItemCardFeaturesItemModel) {
                            MaskPartyItemCardFeaturesViewHolder.this.y((ItemCardFeaturesItemModel) obj, i10);
                        }
                    }
                })));
                return maskPartyItemCardFeaturesAdapter;
            }
        });
        RecyclerView recyclerView = (RecyclerView) itemView.findViewById(R$id.item_card_features_recyclerview);
        recyclerView.setAdapter(x());
        recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), 1, false));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator == null) {
            return;
        }
        simpleItemAnimator.setSupportsChangeAnimations(false);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ItemCardFeaturesModel) {
            x().j().clear();
            x().e(((ItemCardFeaturesModel) obj).getList());
            x().notifyDataSetChanged();
        }
    }

    public final void w(final ItemCardFeaturesItemModel itemCardFeaturesItemModel, final int i10, View view) {
        MaskPartyItemCardChooseRoleLayout.a aVar = MaskPartyItemCardChooseRoleLayout.f16400c;
        Context context = this.itemView.getContext();
        s.h(context, "itemView.context");
        aVar.b(context, view, new Function1<List<? extends RoleType>, p>() { // from class: com.cupidapp.live.maskparty.adapter.MaskPartyItemCardFeaturesViewHolder$chooseRole$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends RoleType> list) {
                invoke2(list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<? extends RoleType> list) {
                MaskPartyItemCardFeaturesAdapter x10;
                Function1 function1;
                s.i(list, "list");
                ItemCardFeaturesItemModel itemCardFeaturesItemModel2 = ItemCardFeaturesItemModel.this;
                ArrayList arrayList = new ArrayList(t.t(list, 10));
                Iterator<? extends RoleType> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(Integer.valueOf(iterator2.next().getType()));
                }
                itemCardFeaturesItemModel2.setValues(arrayList);
                if (ItemCardFeaturesItemModel.this.getSelected()) {
                    if (list.isEmpty()) {
                        ItemCardFeaturesItemModel.this.setSelected(false);
                        g.f52734a.P1(null);
                        function1 = this.f16258c;
                        if (function1 != null) {
                            function1.invoke(null);
                        }
                    } else {
                        g.f52734a.P1(ItemCardFeaturesItemModel.this);
                    }
                }
                x10 = this.x();
                x10.notifyItemChanged(i10);
            }
        });
    }

    public final MaskPartyItemCardFeaturesAdapter x() {
        return (MaskPartyItemCardFeaturesAdapter) this.f16259d.getValue();
    }

    public final void y(ItemCardFeaturesItemModel itemCardFeaturesItemModel, int i10) {
        SensorsLogKeyButtonClick.PropCard propCard;
        if (itemCardFeaturesItemModel.getSelected()) {
            itemCardFeaturesItemModel.setSelected(false);
            x().notifyItemChanged(i10);
            g.f52734a.P1(null);
            Function1<? super ItemCardFeaturesItemModel, p> function1 = this.f16258c;
            if (function1 != null) {
                function1.invoke(null);
                return;
            }
            return;
        }
        Function1<? super ItemCardFeaturesItemModel, p> function12 = this.f16258c;
        if (function12 != null) {
            function12.invoke(itemCardFeaturesItemModel);
        }
        int i11 = b.f16260a[itemCardFeaturesItemModel.getType().ordinal()];
        if (i11 == 1) {
            propCard = SensorsLogKeyButtonClick.PropCard.SEME_UKE;
        } else if (i11 == 2) {
            propCard = SensorsLogKeyButtonClick.PropCard.SAME_CITY;
        } else if (i11 == 3) {
            propCard = SensorsLogKeyButtonClick.PropCard.SPEED;
        } else {
            if (i11 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            propCard = SensorsLogKeyButtonClick.PropCard.SINGLE;
        }
        SensorsLogKeyButtonClick.f12211a.c(SensorPosition.PropCard.getValue(), propCard.buttonName());
    }
}
