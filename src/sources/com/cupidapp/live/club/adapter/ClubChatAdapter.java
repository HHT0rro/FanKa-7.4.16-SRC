package com.cupidapp.live.club.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.club.helper.ClubChatTypeRegistry;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.model.QuoteInfoModel;
import com.cupidapp.live.club.viewholder.BaseClubChatViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatAdapter extends FKBaseRecyclerViewAdapter {
    public static /* synthetic */ void B(ClubChatAdapter clubChatAdapter, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        clubChatAdapter.A(z10, z11);
    }

    public static /* synthetic */ void v(ClubChatAdapter clubChatAdapter, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        clubChatAdapter.u(list, z10);
    }

    public final void A(boolean z10, boolean z11) {
        if (z10) {
            r0 = z11 ? 0 : j().size();
            c(r0, new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
            notifyItemInserted(r0);
            return;
        }
        Iterator<Object> iterator2 = j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                r0 = -1;
                break;
            } else if (iterator2.next() instanceof FKFooterViewModel) {
                break;
            } else {
                r0++;
            }
        }
        if (f(r0)) {
            j().remove(r0);
            notifyItemRemoved(r0);
        }
    }

    public final void C(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        int indexOf = j().indexOf(model);
        if (f(indexOf)) {
            j().remove(indexOf);
            notifyItemRemoved(indexOf);
        }
    }

    public final Long D(int i10) {
        if (!f(i10)) {
            return null;
        }
        Object obj = j().get(i10);
        ClubChatMsgModel clubChatMsgModel = obj instanceof ClubChatMsgModel ? (ClubChatMsgModel) obj : null;
        if (clubChatMsgModel != null) {
            return Long.valueOf(clubChatMsgModel.getCreateTimeMillis());
        }
        return null;
    }

    public final Long E(int i10) {
        if (i10 <= 0 || i10 >= j().size()) {
            return i10 == 0 ? 0L : null;
        }
        Object obj = j().get(i10 - 1);
        ClubChatMsgModel clubChatMsgModel = obj instanceof ClubChatMsgModel ? (ClubChatMsgModel) obj : null;
        if (clubChatMsgModel != null) {
            return Long.valueOf(clubChatMsgModel.getCreateTimeMillis());
        }
        return null;
    }

    @Nullable
    public final String F() {
        Integer G = G();
        if (G != null) {
            for (int intValue = G.intValue(); -1 < intValue; intValue--) {
                Object obj = j().get(intValue);
                if (obj instanceof ClubChatMsgModel) {
                    ClubChatMsgModel clubChatMsgModel = (ClubChatMsgModel) obj;
                    if (!clubChatMsgModel.getMine()) {
                        return clubChatMsgModel.getMessageId();
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    public final Integer G() {
        int l10 = kotlin.collections.s.l(j());
        if (l10 == -1) {
            return null;
        }
        return Integer.valueOf(l10);
    }

    public final void H(@NotNull ClubChatMsgModel model, int i10) {
        s.i(model, "model");
        c(i10, model);
        notifyItemInserted(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        FKBaseRecyclerViewHolder d10 = ClubChatTypeRegistry.f13608a.d(parent, i10);
        d10.k(l());
        return d10;
    }

    public final void J(@NotNull ClubChatMsgModel message, int i10) {
        s.i(message, "message");
        message.setStatus(Integer.valueOf(i10));
        if (j().contains(message)) {
            notifyItemChanged(j().indexOf(message));
        }
    }

    public final void K(long j10, @NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        Integer G = G();
        if (G != null) {
            for (int intValue = G.intValue(); -1 < intValue; intValue--) {
                Object obj = j().get(intValue);
                if ((obj instanceof ClubChatMsgModel) && ((ClubChatMsgModel) obj).getCreateTimeMillis() == j10) {
                    j().set(intValue, model);
                    notifyItemChanged(intValue);
                    return;
                }
            }
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (f(i10)) {
            return ClubChatTypeRegistry.f13608a.b(j().get(i10));
        }
        throw new IllegalStateException(("ClubChatAdapter getItemViewType error position:" + i10 + "  totalCount:" + j().size()).toString());
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NotNull FKBaseRecyclerViewHolder holder, int i10) {
        Long D;
        s.i(holder, "holder");
        super.onBindViewHolder(holder, i10);
        if (!(holder instanceof BaseClubChatViewHolder) || (D = D(i10)) == null) {
            return;
        }
        long longValue = D.longValue();
        Long E = E(i10);
        if (E != null) {
            ((BaseClubChatViewHolder) holder).x(longValue, E.longValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[LOOP:1: B:26:0x0049->B:43:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(@org.jetbrains.annotations.Nullable java.util.List<com.cupidapp.live.club.model.ClubChatMsgModel> r7, boolean r8) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto Ld
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto Lb
            goto Ld
        Lb:
            r2 = 0
            goto Le
        Ld:
            r2 = 1
        Le:
            if (r2 == 0) goto L11
            return
        L11:
            if (r8 == 0) goto L25
            java.util.List r8 = r6.j()
            r8.clear()
            java.util.List r8 = r6.j()
            int r8 = r8.size()
            r6.notifyItemRangeRemoved(r1, r8)
        L25:
            java.util.Iterator r8 = r7.iterator2()
        L29:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L85
            java.lang.Object r2 = r8.next()
            com.cupidapp.live.club.model.ClubChatMsgModel r2 = (com.cupidapp.live.club.model.ClubChatMsgModel) r2
            java.util.List r3 = r6.j()
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L45
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L45
        L43:
            r2 = 0
            goto L7f
        L45:
            java.util.Iterator r3 = r3.iterator2()
        L49:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L43
            java.lang.Object r4 = r3.next()
            boolean r5 = r4 instanceof com.cupidapp.live.club.model.ClubChatMsgModel
            if (r5 == 0) goto L7b
            com.cupidapp.live.club.model.ClubChatMsgModel r4 = (com.cupidapp.live.club.model.ClubChatMsgModel) r4
            java.lang.String r5 = r4.getMessageId()
            if (r5 == 0) goto L68
            int r5 = r5.length()
            if (r5 != 0) goto L66
            goto L68
        L66:
            r5 = 0
            goto L69
        L68:
            r5 = 1
        L69:
            if (r5 != 0) goto L7b
            java.lang.String r4 = r4.getMessageId()
            java.lang.String r5 = r2.getMessageId()
            boolean r4 = kotlin.jvm.internal.s.d(r4, r5)
            if (r4 == 0) goto L7b
            r4 = 1
            goto L7c
        L7b:
            r4 = 0
        L7c:
            if (r4 == 0) goto L49
            r2 = 1
        L7f:
            if (r2 == 0) goto L29
            r8.remove()
            goto L29
        L85:
            java.util.List r8 = r6.j()
            r8.addAll(r1, r7)
            int r7 = r7.size()
            r6.notifyItemRangeInserted(r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.club.adapter.ClubChatAdapter.u(java.util.List, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x006a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[LOOP:1: B:24:0x0035->B:41:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w(@org.jetbrains.annotations.Nullable java.util.List<com.cupidapp.live.club.model.ClubChatMsgModel> r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            if (r8 == 0) goto Ld
            boolean r2 = r8.isEmpty()
            if (r2 == 0) goto Lb
            goto Ld
        Lb:
            r2 = 0
            goto Le
        Ld:
            r2 = 1
        Le:
            if (r2 == 0) goto L11
            return
        L11:
            java.util.Iterator r2 = r8.iterator2()
        L15:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L71
            java.lang.Object r3 = r2.next()
            com.cupidapp.live.club.model.ClubChatMsgModel r3 = (com.cupidapp.live.club.model.ClubChatMsgModel) r3
            java.util.List r4 = r7.j()
            boolean r5 = r4 instanceof java.util.Collection
            if (r5 == 0) goto L31
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L31
        L2f:
            r3 = 0
            goto L6b
        L31:
            java.util.Iterator r4 = r4.iterator2()
        L35:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L2f
            java.lang.Object r5 = r4.next()
            boolean r6 = r5 instanceof com.cupidapp.live.club.model.ClubChatMsgModel
            if (r6 == 0) goto L67
            com.cupidapp.live.club.model.ClubChatMsgModel r5 = (com.cupidapp.live.club.model.ClubChatMsgModel) r5
            java.lang.String r6 = r5.getMessageId()
            if (r6 == 0) goto L54
            int r6 = r6.length()
            if (r6 != 0) goto L52
            goto L54
        L52:
            r6 = 0
            goto L55
        L54:
            r6 = 1
        L55:
            if (r6 != 0) goto L67
            java.lang.String r5 = r5.getMessageId()
            java.lang.String r6 = r3.getMessageId()
            boolean r5 = kotlin.jvm.internal.s.d(r5, r6)
            if (r5 == 0) goto L67
            r5 = 1
            goto L68
        L67:
            r5 = 0
        L68:
            if (r5 == 0) goto L35
            r3 = 1
        L6b:
            if (r3 == 0) goto L15
            r2.remove()
            goto L15
        L71:
            boolean r0 = r8.isEmpty()
            r0 = r0 ^ r1
            if (r0 == 0) goto L8e
            java.util.List r0 = r7.j()
            int r0 = r0.size()
            java.util.List r1 = r7.j()
            r1.addAll(r0, r8)
            int r8 = r8.size()
            r7.notifyItemRangeInserted(r0, r8)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.club.adapter.ClubChatAdapter.w(java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006c A[EDGE_INSN: B:35:0x006c->B:13:0x006c BREAK  A[LOOP:1: B:20:0x0037->B:36:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[LOOP:1: B:20:0x0037->B:36:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void x(@org.jetbrains.annotations.NotNull java.util.List<com.cupidapp.live.club.model.ClubChatMsgModel> r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.p> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "list"
            kotlin.jvm.internal.s.i(r8, r0)
            java.lang.String r0 = "success"
            kotlin.jvm.internal.s.i(r9, r0)
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L11
            return
        L11:
            java.util.Iterator r0 = r8.iterator2()
        L15:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L72
            java.lang.Object r1 = r0.next()
            com.cupidapp.live.club.model.ClubChatMsgModel r1 = (com.cupidapp.live.club.model.ClubChatMsgModel) r1
            java.util.List r3 = r7.j()
            boolean r4 = r3 instanceof java.util.Collection
            r5 = 0
            if (r4 == 0) goto L33
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L33
        L31:
            r2 = 0
            goto L6c
        L33:
            java.util.Iterator r3 = r3.iterator2()
        L37:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L31
            java.lang.Object r4 = r3.next()
            boolean r6 = r4 instanceof com.cupidapp.live.club.model.ClubChatMsgModel
            if (r6 == 0) goto L69
            com.cupidapp.live.club.model.ClubChatMsgModel r4 = (com.cupidapp.live.club.model.ClubChatMsgModel) r4
            java.lang.String r6 = r4.getMessageId()
            if (r6 == 0) goto L56
            int r6 = r6.length()
            if (r6 != 0) goto L54
            goto L56
        L54:
            r6 = 0
            goto L57
        L56:
            r6 = 1
        L57:
            if (r6 != 0) goto L69
            java.lang.String r4 = r4.getMessageId()
            java.lang.String r6 = r1.getMessageId()
            boolean r4 = kotlin.jvm.internal.s.d(r4, r6)
            if (r4 == 0) goto L69
            r4 = 1
            goto L6a
        L69:
            r4 = 0
        L6a:
            if (r4 == 0) goto L37
        L6c:
            if (r2 == 0) goto L15
            r0.remove()
            goto L15
        L72:
            boolean r0 = r8.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L93
            java.util.List r0 = r7.j()
            int r0 = kotlin.collections.s.l(r0)
            int r0 = r0 + r2
            java.util.List r1 = r7.j()
            r1.addAll(r0, r8)
            int r8 = r8.size()
            r7.notifyItemRangeInserted(r0, r8)
            r9.invoke()
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.club.adapter.ClubChatAdapter.x(java.util.List, kotlin.jvm.functions.Function0):void");
    }

    public final void y(@Nullable List<ClubChatMsgModel> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        j().addAll(0, list);
        notifyItemRangeInserted(0, list.size());
        j().removeAll(j().subList(list.size(), j().size()));
        notifyItemRangeRemoved(list.size(), j().size());
    }

    public final void z(@NotNull String msgId, @NotNull ClubChatMsgModel noticeMsg) {
        s.i(msgId, "msgId");
        s.i(noticeMsg, "noticeMsg");
        Integer G = G();
        if (G != null) {
            for (int intValue = G.intValue(); -1 < intValue; intValue--) {
                Object obj = j().get(intValue);
                if (obj instanceof ClubChatMsgModel) {
                    ClubChatMsgModel clubChatMsgModel = (ClubChatMsgModel) obj;
                    if (s.d(clubChatMsgModel.getMessageId(), msgId)) {
                        j().set(intValue, noticeMsg);
                        notifyItemChanged(intValue);
                    }
                    QuoteInfoModel quoteInfo = clubChatMsgModel.getQuoteInfo();
                    if (s.d(quoteInfo != null ? quoteInfo.getMessageId() : null, msgId)) {
                        clubChatMsgModel.getQuoteInfo().setCancel(Boolean.TRUE);
                        clubChatMsgModel.getQuoteInfo().setText("引用消息已被撤回");
                        notifyItemChanged(intValue);
                    }
                }
            }
        }
    }
}
