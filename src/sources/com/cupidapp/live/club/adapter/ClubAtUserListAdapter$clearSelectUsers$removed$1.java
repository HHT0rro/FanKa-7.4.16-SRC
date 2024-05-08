package com.cupidapp.live.club.adapter;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClubAtUserListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class ClubAtUserListAdapter$clearSelectUsers$removed$1 extends Lambda implements Function1<Object, Boolean> {
    public final /* synthetic */ List<String> $list;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubAtUserListAdapter$clearSelectUsers$removed$1(List<String> list) {
        super(1);
        this.$list = list;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@NotNull Object it) {
        s.i(it, "it");
        return Boolean.valueOf((it instanceof User) && this.$list.contains(((User) it).userId()));
    }
}
