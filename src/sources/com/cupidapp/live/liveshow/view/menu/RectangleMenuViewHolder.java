package com.cupidapp.live.liveshow.view.menu;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuListModel;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuModel;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: LiveFunctionMenuAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RectangleMenuViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f15745e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function1<? super LiveFunctionMenuModel, p> f15746c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f15747d;

    /* compiled from: LiveFunctionMenuAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RectangleMenuViewHolder a(@NotNull ViewGroup parent, @Nullable Function1<? super LiveFunctionMenuModel, p> function1) {
            s.i(parent, "parent");
            RectangleMenuViewHolder rectangleMenuViewHolder = new RectangleMenuViewHolder(new RecyclerView(parent.getContext()));
            rectangleMenuViewHolder.f15746c = function1;
            return rectangleMenuViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectangleMenuViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f15747d = c.b(new Function0<RectangleMenuAdapter>() { // from class: com.cupidapp.live.liveshow.view.menu.RectangleMenuViewHolder$rectangleMenuAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RectangleMenuAdapter invoke() {
                RectangleMenuAdapter rectangleMenuAdapter = new RectangleMenuAdapter();
                final RectangleMenuViewHolder rectangleMenuViewHolder = RectangleMenuViewHolder.this;
                rectangleMenuAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.menu.RectangleMenuViewHolder$rectangleMenuAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r0 = r1.f15746c;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.liveshow.model.LiveFunctionMenuModel
                            if (r0 == 0) goto Lf
                            com.cupidapp.live.liveshow.view.menu.RectangleMenuViewHolder r0 = com.cupidapp.live.liveshow.view.menu.RectangleMenuViewHolder.this
                            kotlin.jvm.functions.Function1 r0 = com.cupidapp.live.liveshow.view.menu.RectangleMenuViewHolder.r(r0)
                            if (r0 == 0) goto Lf
                            r0.invoke(r2)
                        Lf:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.menu.RectangleMenuViewHolder$rectangleMenuAdapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                });
                return rectangleMenuAdapter;
            }
        });
        RecyclerView recyclerView = itemView instanceof RecyclerView ? (RecyclerView) itemView : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(t());
            recyclerView.setLayoutManager(new GridLayoutManager(((RecyclerView) itemView).getContext(), 2));
            recyclerView.setPadding(0, 0, 0, h.c(recyclerView, 4.0f));
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveFunctionMenuListModel) {
            t().j().clear();
            t().e(((LiveFunctionMenuListModel) obj).getMenus());
            t().notifyDataSetChanged();
        }
    }

    public final RectangleMenuAdapter t() {
        return (RectangleMenuAdapter) this.f15747d.getValue();
    }
}
