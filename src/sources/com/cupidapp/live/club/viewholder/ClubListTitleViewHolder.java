package com.cupidapp.live.club.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.FKRecyclerTitleLayout;
import com.cupidapp.live.base.view.FKTitleViewModel;
import com.cupidapp.live.base.view.TitleConfigModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: ClubListTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubListTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13692d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function1<? super Integer, p> f13693c;

    /* compiled from: ClubListTitleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ClubListTitleViewHolder a(@NotNull ViewGroup parent, @Nullable Function1<? super Integer, p> function1) {
            s.i(parent, "parent");
            ClubListTitleViewHolder clubListTitleViewHolder = new ClubListTitleViewHolder(z.b(parent, R$layout.view_holder_club_list_title, false, 2, null));
            clubListTitleViewHolder.f13693c = function1;
            return clubListTitleViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubListTitleViewHolder(@NotNull final View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.settle_in_club_textview);
        s.h(textView, "itemView.settle_in_club_textview");
        u.a(textView);
        ((FKRecyclerTitleLayout) itemView.findViewById(R$id.club_title_layout)).setTitleClickListener(new Function2<Integer, FKTitleViewModel, p>() { // from class: com.cupidapp.live.club.viewholder.ClubListTitleViewHolder.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, FKTitleViewModel fKTitleViewModel) {
                invoke(num.intValue(), fKTitleViewModel);
                return p.f51048a;
            }

            public final void invoke(int i10, @NotNull FKTitleViewModel fKTitleViewModel) {
                s.i(fKTitleViewModel, "<anonymous parameter 1>");
                ((FKRecyclerTitleLayout) View.this.findViewById(R$id.club_title_layout)).g(i10);
                Function1 function1 = this.f13693c;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(i10));
                }
            }
        });
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ClubListTitleModel) {
            TitleConfigModel titleConfigModel = new TitleConfigModel(16.0f, -15066598, true);
            TitleConfigModel titleConfigModel2 = new TitleConfigModel(16.0f, -5658199, false);
            ClubListTitleModel clubListTitleModel = (ClubListTitleModel) obj;
            List<String> title = clubListTitleModel.getTitle();
            ArrayList arrayList = new ArrayList(t.t(title, 10));
            for (String str : title) {
                arrayList.add(new FKTitleViewModel(str, titleConfigModel, titleConfigModel2, null, s.d(str, clubListTitleModel.getSelectTitle())));
            }
            ((FKRecyclerTitleLayout) this.itemView.findViewById(R$id.club_title_layout)).c(arrayList, clubListTitleModel.getTitle().indexOf(clubListTitleModel.getSelectTitle()));
            TextView textView = (TextView) this.itemView.findViewById(R$id.settle_in_club_textview);
            s.h(textView, "itemView.settle_in_club_textview");
            textView.setVisibility(clubListTitleModel.getShowSettleIn() ^ true ? 4 : 0);
            View itemView = this.itemView;
            s.h(itemView, "itemView");
            y.m(itemView, null, Integer.valueOf(clubListTitleModel.getTopMargin()), null, null, 13, null);
        }
    }
}
