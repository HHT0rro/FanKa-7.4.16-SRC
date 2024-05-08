package com.cupidapp.live.base.recyclerview;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.model.FKErrorViewModel;
import com.cupidapp.live.base.recyclerview.model.KeyWordsSpanViewModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKErrorListViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKErrorListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f12035c = new a(null);

    /* compiled from: FKErrorListViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKErrorListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            FKErrorListViewHolder fKErrorListViewHolder = new FKErrorListViewHolder(z.b(parent, R$layout.view_holder_error_list, false, 2, null));
            fKErrorListViewHolder.q();
            return fKErrorListViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKErrorListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String errorText;
        SpannableStringBuilder c4;
        if (obj instanceof FKErrorViewModel) {
            FKErrorViewModel fKErrorViewModel = (FKErrorViewModel) obj;
            if (fKErrorViewModel.getErrorImage() != null) {
                ((ImageView) this.itemView.findViewById(R$id.errorImg)).setImageResource(fKErrorViewModel.getErrorImage().intValue());
            }
            View view = this.itemView;
            int i10 = R$id.errorPromptView;
            TextView textView = (TextView) view.findViewById(i10);
            Integer errorTextColor = fKErrorViewModel.getErrorTextColor();
            textView.setTextColor(errorTextColor != null ? errorTextColor.intValue() : -2302756);
            if (fKErrorViewModel.getErrorTextRes() != null) {
                errorText = this.itemView.getContext().getString(fKErrorViewModel.getErrorTextRes().intValue());
            } else {
                errorText = fKErrorViewModel.getErrorText() != null ? fKErrorViewModel.getErrorText() : "";
            }
            String str = errorText;
            s.h(str, "when {\n                m… else -> \"\"\n            }");
            if (fKErrorViewModel.getKeywordsModel() == null) {
                ((TextView) this.itemView.findViewById(i10)).setText(str);
                return;
            }
            KeyWordsSpanViewModel keywordsModel = fKErrorViewModel.getKeywordsModel();
            TextView textView2 = (TextView) this.itemView.findViewById(i10);
            c4 = q1.d.f53006a.c(str, keywordsModel.getKeywords(), (r18 & 4) != 0 ? null : Integer.valueOf(keywordsModel.getKeywordColor()), (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : keywordsModel.getClickableSpan(), (r18 & 64) != 0 ? null : null);
            textView2.setText(c4);
            ((TextView) this.itemView.findViewById(i10)).setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
