package com.cupidapp.live.base.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: FKBaseRecyclerViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FKBaseRecyclerViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Object f12031b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBaseRecyclerViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    public static final void l(FKBaseRecyclerViewHolder this$0, Function3 method, CompoundButton compoundButton, boolean z10) {
        s.i(this$0, "this$0");
        s.i(method, "$method");
        if (!compoundButton.isPressed() || this$0.getAdapterPosition() == -1) {
            return;
        }
        method.invoke(this$0.f12031b, Boolean.valueOf(z10), Integer.valueOf(this$0.getAdapterPosition()));
    }

    public static final boolean m(Function1 method, FKBaseRecyclerViewHolder this$0, View view) {
        s.i(method, "$method");
        s.i(this$0, "this$0");
        method.invoke(this$0.f12031b);
        return true;
    }

    public final void k(@NotNull final d viewHolderConfig) {
        s.i(viewHolderConfig, "viewHolderConfig");
        View itemView = this.itemView;
        s.h(itemView, "itemView");
        y.d(itemView, new Function1<View, p>() { // from class: com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder$bindViewClickEvent$1
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
                Function1<Object, p> a10 = d.this.a();
                if (a10 != null) {
                    a10.invoke(this.o());
                }
            }
        });
        View itemView2 = this.itemView;
        s.h(itemView2, "itemView");
        y.c(itemView2, new Function1<View, p>() { // from class: com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder$bindViewClickEvent$2
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
                Function1<Object, p> b4 = d.this.b();
                if (b4 != null) {
                    b4.invoke(this.o());
                }
            }
        });
        for (Map.Entry<Integer, Function1<Object, p>> entry : viewHolderConfig.d().entrySet()) {
            View subView = this.itemView.findViewById(entry.getKey().intValue());
            final Function1<Object, p> value = entry.getValue();
            if (subView != null) {
                s.h(subView, "subView");
                y.d(subView, new Function1<View, p>() { // from class: com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder$bindViewClickEvent$3$1
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
                        value.invoke(this.o());
                    }
                });
            }
        }
        for (Map.Entry<Integer, Function2<Object, Integer, p>> entry2 : viewHolderConfig.e().entrySet()) {
            View subView2 = this.itemView.findViewById(entry2.getKey().intValue());
            final Function2<Object, Integer, p> value2 = entry2.getValue();
            if (subView2 != null) {
                s.h(subView2, "subView");
                y.d(subView2, new Function1<View, p>() { // from class: com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder$bindViewClickEvent$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        if (FKBaseRecyclerViewHolder.this.getAdapterPosition() != -1) {
                            value2.mo1743invoke(FKBaseRecyclerViewHolder.this.o(), Integer.valueOf(FKBaseRecyclerViewHolder.this.getAdapterPosition()));
                        }
                    }
                });
            }
        }
        for (Map.Entry<Integer, Function3<Object, Boolean, Integer, p>> entry3 : viewHolderConfig.c().entrySet()) {
            CheckBox checkBox = (CheckBox) this.itemView.findViewById(entry3.getKey().intValue());
            final Function3<Object, Boolean, Integer, p> value3 = entry3.getValue();
            if (checkBox != null) {
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.base.recyclerview.b
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                        FKBaseRecyclerViewHolder.l(FKBaseRecyclerViewHolder.this, value3, compoundButton, z10);
                    }
                });
            }
        }
        for (Map.Entry<Integer, Function1<Object, p>> entry4 : viewHolderConfig.f().entrySet()) {
            View findViewById = this.itemView.findViewById(entry4.getKey().intValue());
            final Function1<Object, p> value4 = entry4.getValue();
            if (findViewById != null) {
                findViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.cupidapp.live.base.recyclerview.a
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean m10;
                        m10 = FKBaseRecyclerViewHolder.m(Function1.this, this, view);
                        return m10;
                    }
                });
            }
        }
    }

    public void n(@Nullable Object obj) {
    }

    @Nullable
    public final Object o() {
        return this.f12031b;
    }

    public final void p(@Nullable Object obj) {
        this.f12031b = obj;
        n(obj);
    }

    public final void q() {
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        StaggeredGridLayoutManager.LayoutParams layoutParams2 = layoutParams instanceof StaggeredGridLayoutManager.LayoutParams ? (StaggeredGridLayoutManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.setFullSpan(true);
    }
}
