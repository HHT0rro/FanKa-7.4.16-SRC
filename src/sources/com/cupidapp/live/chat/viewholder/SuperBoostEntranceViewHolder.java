package com.cupidapp.live.chat.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.chat.service.SuperBoostEntranceModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superboost.dialog.SuperBoostManager;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: SuperBoostEntranceViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SuperBoostEntranceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13258c = new a(null);

    /* compiled from: SuperBoostEntranceViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SuperBoostEntranceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SuperBoostEntranceViewHolder(z.b(parent, R$layout.view_holder_super_boost_entrance, false, 2, null));
        }
    }

    /* compiled from: SuperBoostEntranceViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements SuperBoostManager.a {
        public b() {
        }

        @Override // com.cupidapp.live.superboost.dialog.SuperBoostManager.a
        public void a() {
            SuperBoostEntranceViewHolder.this.s(false);
        }

        @Override // com.cupidapp.live.superboost.dialog.SuperBoostManager.a
        public void b(@NotNull String remainTime, @NotNull String min, @NotNull String sec) {
            s.i(remainTime, "remainTime");
            s.i(min, "min");
            s.i(sec, "sec");
            SuperBoostEntranceViewHolder.this.s(true);
            ((TextView) SuperBoostEntranceViewHolder.this.itemView.findViewById(R$id.super_boost_entrance_min_time)).setText(min);
            ((TextView) SuperBoostEntranceViewHolder.this.itemView.findViewById(R$id.super_boost_entrance_sec_time)).setText(sec);
        }

        @Override // com.cupidapp.live.superboost.dialog.SuperBoostManager.a
        public void c(boolean z10) {
            SuperBoostEntranceViewHolder.this.s(z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBoostEntranceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.super_boost_entrance_btn_name);
        s.h(textView, "itemView.super_boost_entrance_btn_name");
        u.a(textView);
        TextView textView2 = (TextView) itemView.findViewById(R$id.super_boost_entrance_min_time);
        s.h(textView2, "itemView.super_boost_entrance_min_time");
        u.a(textView2);
        TextView textView3 = (TextView) itemView.findViewById(R$id.super_boost_entrance_sec_time);
        s.h(textView3, "itemView.super_boost_entrance_sec_time");
        u.a(textView3);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof SuperBoostEntranceModel) {
            int b4 = FKNewMatchUserItemViewHolder.f13253c.b();
            View findViewById = this.itemView.findViewById(R$id.super_boost_entrance_bg);
            s.h(findViewById, "itemView.super_boost_entrance_bg");
            y.n(findViewById, Integer.valueOf((int) (b4 * 0.75f)), Integer.valueOf(b4));
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.super_boost_entrance_avatar_img);
            s.h(imageLoaderView, "itemView.super_boost_entrance_avatar_img");
            User X = g.f52734a.X();
            ImageLoaderView.g(imageLoaderView, X != null ? X.getAvatarImage() : null, null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.super_boost_entrance_btn_name)).setText(((SuperBoostEntranceModel) obj).getContent());
            SuperBoostManager.f18580a.q(new b());
        }
    }

    public final void s(boolean z10) {
        if (z10) {
            ((Group) this.itemView.findViewById(R$id.super_boost_entrance_btn_group)).setVisibility(8);
            ((Group) this.itemView.findViewById(R$id.super_boost_entrance_time_group)).setVisibility(0);
        } else {
            ((Group) this.itemView.findViewById(R$id.super_boost_entrance_btn_group)).setVisibility(0);
            ((Group) this.itemView.findViewById(R$id.super_boost_entrance_time_group)).setVisibility(8);
        }
    }
}
