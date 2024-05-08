package com.cupidapp.live.club.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.club.activity.ClubChatActivity;
import com.cupidapp.live.club.adapter.MyClubAdapter;
import com.cupidapp.live.club.model.ClubModel;
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
import z0.z;

/* compiled from: MyClubViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MyClubViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13695d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f13696c;

    /* compiled from: MyClubViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MyClubViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new MyClubViewHolder(z.b(parent, R$layout.view_holder_my_club, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyClubViewHolder(@NotNull final View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f13696c = c.b(new Function0<MyClubAdapter>() { // from class: com.cupidapp.live.club.viewholder.MyClubViewHolder$myClubAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MyClubAdapter invoke() {
                MyClubAdapter myClubAdapter = new MyClubAdapter();
                final View view = View.this;
                myClubAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.club.viewholder.MyClubViewHolder$myClubAdapter$2$1$1
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
                        if (obj instanceof ClubModel) {
                            ClubChatActivity.f13469x.a(View.this.getContext(), ((ClubModel) obj).getGroupId());
                        }
                    }
                });
                return myClubAdapter;
            }
        });
        ((TextView) itemView.findViewById(R$id.my_club_textview)).getPaint().setFakeBoldText(true);
        RecyclerView recyclerView = (RecyclerView) itemView.findViewById(R$id.my_club_recyclerview);
        recyclerView.setAdapter(r());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator == null) {
            return;
        }
        simpleItemAnimator.setSupportsChangeAnimations(false);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof MyClubModel) {
            r().j().clear();
            r().e(((MyClubModel) obj).getClubList());
            r().notifyDataSetChanged();
        }
    }

    public final MyClubAdapter r() {
        return (MyClubAdapter) this.f13696c.getValue();
    }
}
