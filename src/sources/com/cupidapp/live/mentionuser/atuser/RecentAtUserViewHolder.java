package com.cupidapp.live.mentionuser.atuser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mentionuser.model.RecentAtUserUIModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: RecentAtUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RecentAtUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f17481d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final Function1<User, p> f17482c;

    /* compiled from: RecentAtUserViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecentAtUserViewHolder a(@NotNull ViewGroup parent, @Nullable Function1<? super User, p> function1) {
            s.i(parent, "parent");
            return new RecentAtUserViewHolder(z.b(parent, R$layout.item_recent_at_user, false, 2, null), function1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RecentAtUserViewHolder(@NotNull View itemView, @Nullable Function1<? super User, p> function1) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f17482c = function1;
    }

    public static final void s(RecentAtUserViewHolder this$0, User item, View view) {
        s.i(this$0, "this$0");
        s.i(item, "$item");
        Function1<User, p> function1 = this$0.f17482c;
        if (function1 != null) {
            function1.invoke(item);
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof RecentAtUserUIModel) {
            View view = this.itemView;
            int i10 = R$id.recent_at_ll;
            ((LinearLayout) view.findViewById(i10)).removeAllViews();
            ((LinearLayout) this.itemView.findViewById(i10)).setWeightSum(Math.max(5.0f, r10.getList().size()));
            for (final User user : ((RecentAtUserUIModel) obj).getList()) {
                View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.layout_recent_user, (ViewGroup) null);
                ImageLoaderView avatarImg = (ImageLoaderView) inflate.findViewById(R$id.recent_user_avatar);
                TextView textView = (TextView) inflate.findViewById(R$id.recent_user_name_txt);
                s.h(avatarImg, "avatarImg");
                ImageLoaderView.g(avatarImg, user.getAvatarImage(), null, null, 6, null);
                textView.setText(user.getName());
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.mentionuser.atuser.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        RecentAtUserViewHolder.s(RecentAtUserViewHolder.this, user, view2);
                    }
                });
                LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.recent_at_ll);
                if (linearLayout != null) {
                    linearLayout.addView(inflate, new LinearLayout.LayoutParams(0, -2, 1.0f));
                }
            }
        }
    }
}
