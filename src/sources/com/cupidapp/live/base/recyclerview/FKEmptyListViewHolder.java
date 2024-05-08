package com.cupidapp.live.base.recyclerview;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.KeyWordsSpanViewModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FKEmptyListViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKEmptyListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f12034c = new a(null);

    /* compiled from: FKEmptyListViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKEmptyListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            FKEmptyListViewHolder fKEmptyListViewHolder = new FKEmptyListViewHolder(z.b(parent, R$layout.view_holder_empty_list, false, 2, null));
            fKEmptyListViewHolder.q();
            return fKEmptyListViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKEmptyListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String emptyText;
        SpannableStringBuilder c4;
        if (obj instanceof FKEmptyViewModel) {
            FKEmptyViewModel fKEmptyViewModel = (FKEmptyViewModel) obj;
            if (fKEmptyViewModel.getBgColor() != null) {
                ((RelativeLayout) this.itemView.findViewById(R$id.emptyRootRl)).setBackgroundColor(fKEmptyViewModel.getBgColor().intValue());
            } else {
                ((RelativeLayout) this.itemView.findViewById(R$id.emptyRootRl)).setBackgroundColor(-1);
            }
            if (fKEmptyViewModel.getHeight() != null) {
                RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.emptyRootRl);
                s.h(relativeLayout, "itemView.emptyRootRl");
                y.n(relativeLayout, null, fKEmptyViewModel.getHeight());
            } else {
                RelativeLayout relativeLayout2 = (RelativeLayout) this.itemView.findViewById(R$id.emptyRootRl);
                s.h(relativeLayout2, "itemView.emptyRootRl");
                y.n(relativeLayout2, null, -1);
            }
            if (fKEmptyViewModel.getEmptyImage() != null) {
                ((ImageView) this.itemView.findViewById(R$id.emptyImg)).setImageResource(fKEmptyViewModel.getEmptyImage().intValue());
            }
            if (fKEmptyViewModel.getEmptyTextSize() != null) {
                ((TextView) this.itemView.findViewById(R$id.emptyPromptView)).setTextSize(fKEmptyViewModel.getEmptyTextSize().floatValue());
            }
            View view = this.itemView;
            int i10 = R$id.emptyPromptView;
            TextView textView = (TextView) view.findViewById(i10);
            Integer emptyTextColor = fKEmptyViewModel.getEmptyTextColor();
            textView.setTextColor(emptyTextColor != null ? emptyTextColor.intValue() : -2302756);
            if (fKEmptyViewModel.getBold()) {
                TextView textView2 = (TextView) this.itemView.findViewById(i10);
                s.h(textView2, "itemView.emptyPromptView");
                u.a(textView2);
            }
            if (fKEmptyViewModel.getEmptyTextRes() != null) {
                emptyText = this.itemView.getContext().getString(fKEmptyViewModel.getEmptyTextRes().intValue());
            } else {
                emptyText = fKEmptyViewModel.getEmptyText() != null ? fKEmptyViewModel.getEmptyText() : "";
            }
            String str = emptyText;
            s.h(str, "when {\n                m… else -> \"\"\n            }");
            if (fKEmptyViewModel.getKeywordsModel() == null) {
                ((TextView) this.itemView.findViewById(i10)).setText(str);
            } else {
                KeyWordsSpanViewModel keywordsModel = fKEmptyViewModel.getKeywordsModel();
                TextView textView3 = (TextView) this.itemView.findViewById(i10);
                c4 = q1.d.f53006a.c(str, keywordsModel.getKeywords(), (r18 & 4) != 0 ? null : Integer.valueOf(keywordsModel.getKeywordColor()), (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : keywordsModel.getClickableSpan(), (r18 & 64) != 0 ? null : null);
                textView3.setText(c4);
                ((TextView) this.itemView.findViewById(i10)).setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (fKEmptyViewModel.getEmptyBtnTextRes() == null) {
                ((TextView) this.itemView.findViewById(R$id.emptyPromptBtn)).setVisibility(8);
                return;
            }
            View view2 = this.itemView;
            int i11 = R$id.emptyPromptBtn;
            ((TextView) view2.findViewById(i11)).setVisibility(0);
            ((TextView) this.itemView.findViewById(i11)).setText(fKEmptyViewModel.getEmptyBtnTextRes().intValue());
        }
    }
}
