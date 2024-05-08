package com.cupidapp.live.club.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.club.adapter.ClubChatAdapter;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.model.ClubChatMsgResult;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClubChatRoomFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatRoomFragment$initObserve$1 extends Lambda implements Function1<ClubChatMsgResult, kotlin.p> {
    public final /* synthetic */ ClubChatRoomFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatRoomFragment$initObserve$1(ClubChatRoomFragment clubChatRoomFragment) {
        super(1);
        this.this$0 = clubChatRoomFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(ClubChatRoomFragment this$0, ClubChatMsgResult it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(it, "$it");
        this$0.M1(it.getUnreadTip());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(ClubChatMsgResult clubChatMsgResult) {
        invoke2(clubChatMsgResult);
        return kotlin.p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final ClubChatMsgResult it) {
        ClubChatAdapter clubChatAdapter;
        kotlin.jvm.internal.s.i(it, "it");
        clubChatAdapter = this.this$0.f13556g;
        List<ClubChatMsgModel> list = it.getList();
        ClubChatAdapter.v(clubChatAdapter, list != null ? CollectionsKt___CollectionsKt.z0(list) : null, false, 2, null);
        this.this$0.K1();
        RecyclerView recyclerView = (RecyclerView) this.this$0.d1(R$id.club_chat_recycler_view);
        final ClubChatRoomFragment clubChatRoomFragment = this.this$0;
        recyclerView.post(new Runnable() { // from class: com.cupidapp.live.club.fragment.p
            @Override // java.lang.Runnable
            public final void run() {
                ClubChatRoomFragment$initObserve$1.invoke$lambda$0(ClubChatRoomFragment.this, it);
            }
        });
    }
}
