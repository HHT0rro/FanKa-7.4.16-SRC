package com.cupidapp.live.visitors.viewholder;

import android.content.Context;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.visitors.model.VisitorMarketingInfoModel;
import java.util.Arrays;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.t;
import z0.z;

/* compiled from: VisitorMarksViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorMarksViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18965d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final com.cupidapp.live.visitors.viewholder.a f18966c;

    /* compiled from: VisitorMarksViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VisitorMarksViewHolder a(@NotNull ViewGroup parent, @Nullable com.cupidapp.live.visitors.viewholder.a aVar) {
            s.i(parent, "parent");
            return new VisitorMarksViewHolder(z.b(parent, R$layout.item_visitor_marks, false, 2, null), aVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorMarksViewHolder(@NotNull View itemView, @Nullable com.cupidapp.live.visitors.viewholder.a aVar) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f18966c = aVar;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof VisitorMarketingUIModel) {
            LinearLayout markRootLinear = (LinearLayout) this.itemView.findViewById(R$id.mark_root_linear);
            markRootLinear.removeAllViews();
            VisitorMarketingUIModel visitorMarketingUIModel = (VisitorMarketingUIModel) obj;
            List<VisitorMarketingInfoModel> list = visitorMarketingUIModel.getList();
            int size = list != null ? list.size() : 0;
            int i10 = R$id.visitor_mark_content;
            int i11 = R$id.visitor_mark_btn;
            String str = "markItemView";
            ViewGroup viewGroup = null;
            if (size > 1) {
                markRootLinear.setWeightSum(size);
                markRootLinear.setDividerPadding(4);
                List<VisitorMarketingInfoModel> list2 = visitorMarketingUIModel.getList();
                if (list2 != null) {
                    for (VisitorMarketingInfoModel visitorMarketingInfoModel : list2) {
                        View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.item_visitor_mark_item, viewGroup);
                        s.h(inflate, str);
                        View findViewById = inflate.findViewById(R$id.visitor_mark_title);
                        s.h(findViewById, "markItemView.findViewById(R.id.visitor_mark_title)");
                        TextView textView = (TextView) findViewById;
                        View findViewById2 = inflate.findViewById(i11);
                        s.h(findViewById2, "markItemView.findViewById(R.id.visitor_mark_btn)");
                        TextView textView2 = (TextView) findViewById2;
                        View findViewById3 = inflate.findViewById(i10);
                        s.h(findViewById3, "markItemView.findViewByI….id.visitor_mark_content)");
                        s.h(markRootLinear, "markRootLinear");
                        r(inflate, textView, textView2, (TextView) findViewById3, visitorMarketingInfoModel, markRootLinear);
                        viewGroup = viewGroup;
                        str = str;
                        i10 = R$id.visitor_mark_content;
                        i11 = R$id.visitor_mark_btn;
                    }
                    return;
                }
                return;
            }
            markRootLinear.setWeightSum(1.0f);
            markRootLinear.setDividerPadding(4);
            List<VisitorMarketingInfoModel> list3 = visitorMarketingUIModel.getList();
            if (list3 != null) {
                for (VisitorMarketingInfoModel visitorMarketingInfoModel2 : list3) {
                    View markItemView = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.item_visitor_mark_only_one, (ViewGroup) null);
                    s.h(markItemView, "markItemView");
                    View findViewById4 = markItemView.findViewById(R$id.visitor_mark_title);
                    s.h(findViewById4, "markItemView.findViewById(R.id.visitor_mark_title)");
                    TextView textView3 = (TextView) findViewById4;
                    View findViewById5 = markItemView.findViewById(R$id.visitor_mark_btn);
                    s.h(findViewById5, "markItemView.findViewById(R.id.visitor_mark_btn)");
                    TextView textView4 = (TextView) findViewById5;
                    View findViewById6 = markItemView.findViewById(R$id.visitor_mark_content);
                    s.h(findViewById6, "markItemView.findViewByI….id.visitor_mark_content)");
                    s.h(markRootLinear, "markRootLinear");
                    r(markItemView, textView3, textView4, (TextView) findViewById6, visitorMarketingInfoModel2, markRootLinear);
                }
            }
        }
    }

    public final void r(View view, TextView textView, TextView textView2, TextView textView3, final VisitorMarketingInfoModel visitorMarketingInfoModel, LinearLayout linearLayout) {
        textView.getPaint().setFakeBoldText(true);
        textView2.getPaint().setFakeBoldText(true);
        y yVar = y.f51038a;
        String string = this.itemView.getContext().getString(R$string.people_count);
        s.h(string, "itemView.context.getString(R.string.people_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(visitorMarketingInfoModel.getNumber())}, 1));
        s.h(format, "format(format, *args)");
        Context context = this.itemView.getContext();
        s.h(context, "itemView.context");
        textView.setText(t.n(format, new AbsoluteSizeSpan(h.w(context, 18)), new String[]{String.valueOf(visitorMarketingInfoModel.getNumber())}, false, 4, null));
        textView2.setText(visitorMarketingInfoModel.getActionName());
        textView3.setText(visitorMarketingInfoModel.getTitle());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMargins(h.c(this, 4.0f), h.c(this, 16.0f), h.c(this, 4.0f), h.c(this, 16.0f));
        linearLayout.addView(view, layoutParams);
        z0.y.d(textView2, new Function1<View, p>() { // from class: com.cupidapp.live.visitors.viewholder.VisitorMarksViewHolder$configItemData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view2) {
                invoke2(view2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                a s2 = VisitorMarksViewHolder.this.s();
                if (s2 != null) {
                    s2.a(visitorMarketingInfoModel);
                }
            }
        });
    }

    @Nullable
    public final com.cupidapp.live.visitors.viewholder.a s() {
        return this.f18966c;
    }
}
