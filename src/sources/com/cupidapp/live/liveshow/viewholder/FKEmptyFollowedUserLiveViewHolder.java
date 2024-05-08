package com.cupidapp.live.liveshow.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import z0.h;

/* compiled from: FKEmptyFollowedUserLiveViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKEmptyFollowedUserLiveViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16031c = new a(null);

    /* compiled from: FKEmptyFollowedUserLiveViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKEmptyFollowedUserLiveViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            TextView textView = new TextView(parent.getContext());
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            textView.setGravity(1);
            textView.getPaint().setFakeBoldText(true);
            textView.setText(parent.getContext().getString(R$string.you_followed_anchor_not_living));
            textView.setTextSize(14.0f);
            textView.setTextColor(-5658199);
            textView.setPadding(0, h.c(textView, 20.0f), 0, h.c(textView, 8.0f));
            return new FKEmptyFollowedUserLiveViewHolder(textView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKEmptyFollowedUserLiveViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }
}
