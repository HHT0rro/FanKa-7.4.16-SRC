package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import z0.z;

/* compiled from: NonexistentUserEnterViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NonexistentUserEnterViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17814c = new a(null);

    /* compiled from: NonexistentUserEnterViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NonexistentUserEnterViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            NonexistentUserEnterViewHolder nonexistentUserEnterViewHolder = new NonexistentUserEnterViewHolder(z.b(parent, R$layout.view_holder_nonexistent_user_enter, false, 2, null));
            nonexistentUserEnterViewHolder.q();
            return nonexistentUserEnterViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonexistentUserEnterViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }
}
