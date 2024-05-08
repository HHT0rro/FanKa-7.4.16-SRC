package com.cupidapp.live.setting.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.setting.model.AppIconLocalDataModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: PersonalIconViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PersonalIconViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f18191f = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f18192c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f18193d;

    /* renamed from: e, reason: collision with root package name */
    public final int f18194e;

    /* compiled from: PersonalIconViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PersonalIconViewHolder a(@NotNull ViewGroup parent, @Nullable String str, @Nullable String str2, int i10) {
            s.i(parent, "parent");
            return new PersonalIconViewHolder(z.b(parent, R$layout.item_personal_icon, false, 2, null), str, str2, i10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalIconViewHolder(@NotNull View itemView, @Nullable String str, @Nullable String str2, int i10) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f18192c = str;
        this.f18193d = str2;
        this.f18194e = i10;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        int i10;
        if (obj instanceof AppIconLocalDataModel) {
            View view = this.itemView;
            int i11 = R$id.item_personal_bg;
            View findViewById = view.findViewById(i11);
            s.h(findViewById, "itemView.item_personal_bg");
            y.n(findViewById, Integer.valueOf(this.f18194e), Integer.valueOf(this.f18194e));
            AppIconLocalDataModel appIconLocalDataModel = (AppIconLocalDataModel) obj;
            if (s.d(this.f18193d, appIconLocalDataModel.getName())) {
                View view2 = this.itemView;
                int i12 = R$id.item_personal_use_txt;
                ((TextView) view2.findViewById(i12)).setVisibility(0);
                TextView textView = (TextView) this.itemView.findViewById(i12);
                s.h(textView, "itemView.item_personal_use_txt");
                u.a(textView);
            } else {
                ((TextView) this.itemView.findViewById(R$id.item_personal_use_txt)).setVisibility(4);
            }
            View view3 = this.itemView;
            int i13 = R$id.item_personal_name;
            ((TextView) view3.findViewById(i13)).setText(appIconLocalDataModel.getIconDisplayNameRes());
            if (p.r(appIconLocalDataModel.getGrade(), "VIP", true)) {
                i10 = R$mipmap.aplus_logo;
            } else {
                i10 = p.r(appIconLocalDataModel.getGrade(), "SVIP", true) ? R$mipmap.super_aplus_logo : 0;
            }
            TextView textView2 = (TextView) this.itemView.findViewById(i13);
            s.h(textView2, "itemView.item_personal_name");
            u.e(textView2, 0, 0, i10, 0, 11, null);
            this.itemView.findViewById(i11).setSelected(s.d(this.f18192c, appIconLocalDataModel.getName()));
            ((ImageView) this.itemView.findViewById(R$id.item_personal_icon)).setImageResource(appIconLocalDataModel.getIconDisplayDrawableRes());
        }
    }

    public final void r(@Nullable String str) {
        this.f18192c = str;
    }

    public final void s(@Nullable String str) {
        this.f18193d = str;
    }
}
