package com.cupidapp.live.consult.viewholder;

import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.consult.model.ConsultCommentModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ConsultCommentViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultCommentViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13894c = new a(null);

    /* compiled from: ConsultCommentViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConsultCommentViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ConsultCommentViewHolder(z.b(parent, R$layout.view_holder_consult_comment, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultCommentViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ConsultCommentModel) {
            ConsultCommentModel consultCommentModel = (ConsultCommentModel) obj;
            String str = consultCommentModel.getSenderName() + "：";
            ((TextView) this.itemView.findViewById(R$id.consult_comment_message_text)).setText(q1.d.f53006a.g(str + consultCommentModel.getMessage(), str, new ForegroundColorSpan(h.a(-1, 0.5f))));
        }
    }
}
