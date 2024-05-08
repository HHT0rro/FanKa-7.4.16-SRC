package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.liveshow.model.FKHornType;
import com.cupidapp.live.liveshow.model.SendGiftCountModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKSendGiftCountSelectLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKSendGiftCountSelectLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15549b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSendGiftCountSelectLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15549b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15549b;
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

    public final void b(@NotNull List<SendGiftCountModel> list, int i10, int i11, int i12, int i13, @NotNull final g selectListener) {
        Object obj;
        Object obj2;
        s.i(list, "list");
        s.i(selectListener, "selectListener");
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<SendGiftCountModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(Integer.valueOf(iterator2.next().getCount()));
        }
        if (!arrayList.contains(Integer.valueOf(i10))) {
            int i14 = R$id.customizedSendCountTextView;
            ((TextView) a(i14)).setText(String.valueOf(i10));
            ((TextView) a(i14)).setTextColor(-12566464);
            ((TextView) a(i14)).setTextSize(16.0f);
            ((TextView) a(i14)).getPaint().setFakeBoldText(true);
        }
        ArrayList arrayList2 = new ArrayList();
        for (SendGiftCountModel sendGiftCountModel : CollectionsKt___CollectionsKt.n0(list)) {
            int count = sendGiftCountModel.getCount() * i11;
            if (count >= i13) {
                Iterator<E> iterator22 = arrayList2.iterator2();
                while (true) {
                    if (iterator22.hasNext()) {
                        obj = iterator22.next();
                        if (((FKSendGiftCountItemModel) obj).getHornType() == FKHornType.BigHornType) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj == null) {
                    arrayList2.add(new FKSendGiftCountItemModel(sendGiftCountModel, FKHornType.BigHornType));
                } else {
                    arrayList2.add(new FKSendGiftCountItemModel(sendGiftCountModel, null));
                }
            } else if (count >= i12) {
                Iterator<E> iterator23 = arrayList2.iterator2();
                while (true) {
                    if (iterator23.hasNext()) {
                        obj2 = iterator23.next();
                        if (((FKSendGiftCountItemModel) obj2).getHornType() == FKHornType.SmallHornType) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                if (obj2 == null) {
                    arrayList2.add(new FKSendGiftCountItemModel(sendGiftCountModel, FKHornType.SmallHornType));
                } else {
                    arrayList2.add(new FKSendGiftCountItemModel(sendGiftCountModel, null));
                }
            } else {
                arrayList2.add(new FKSendGiftCountItemModel(sendGiftCountModel, null));
            }
        }
        for (final FKSendGiftCountItemModel fKSendGiftCountItemModel : CollectionsKt___CollectionsKt.n0(arrayList2)) {
            Context context = getContext();
            s.h(context, "context");
            FKSendGiftCountSelectItemLayout fKSendGiftCountSelectItemLayout = new FKSendGiftCountSelectItemLayout(context);
            fKSendGiftCountSelectItemLayout.b(fKSendGiftCountItemModel, i10 == fKSendGiftCountItemModel.getGiftCountModel().getCount());
            y.d(fKSendGiftCountSelectItemLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKSendGiftCountSelectLayout$configGiftCountSelectLayout$3$1
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
                    g.this.a(fKSendGiftCountItemModel.getGiftCountModel().getCount());
                }
            });
            ((LinearLayout) a(R$id.sendGiftCountSelectContainerLayout)).addView(fKSendGiftCountSelectItemLayout);
        }
        TextView customizedSendCountTextView = (TextView) a(R$id.customizedSendCountTextView);
        s.h(customizedSendCountTextView, "customizedSendCountTextView");
        y.d(customizedSendCountTextView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKSendGiftCountSelectLayout$configGiftCountSelectLayout$4
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
                g.this.b();
            }
        });
    }

    public final void c() {
        z.a(this, R$layout.layout_send_gift_count_select, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSendGiftCountSelectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15549b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSendGiftCountSelectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15549b = new LinkedHashMap();
        c();
    }
}
