package com.cupidapp.live.chat2.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.network.download.SnapFileDownloader;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.chat2.helper.ChatTypeRegistry;
import com.cupidapp.live.chat2.holder.BaseChatViewHolder;
import com.cupidapp.live.chat2.holder.ChatOtherStoryLabelUiModel;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.ChatMessageType;
import com.cupidapp.live.chat2.view.ChatDetailTitleLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatDetailAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatDetailAdapter extends FKBaseRecyclerViewAdapter {
    public final void A(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        int indexOf = j().indexOf(model);
        if (f(indexOf)) {
            j().remove(indexOf);
            notifyItemRemoved(indexOf);
        }
    }

    public final void B(@NotNull String msgId) {
        s.i(msgId, "msgId");
        Integer F = F();
        if (F != null) {
            for (int intValue = F.intValue(); -1 < intValue; intValue--) {
                Object obj = j().get(intValue);
                if ((obj instanceof ChatMessageModel) && s.d(((ChatMessageModel) obj).getItemId(), msgId)) {
                    j().remove(intValue);
                    notifyItemRemoved(intValue);
                    return;
                }
            }
        }
    }

    public final Long C(int i10) {
        if (!f(i10)) {
            return null;
        }
        Object obj = j().get(i10);
        ChatMessageModel chatMessageModel = obj instanceof ChatMessageModel ? (ChatMessageModel) obj : null;
        if (chatMessageModel != null) {
            return Long.valueOf(chatMessageModel.getCreateTimeMillis());
        }
        return null;
    }

    public final Long D(int i10) {
        if (i10 <= 0 || i10 >= j().size()) {
            return i10 == 0 ? 0L : null;
        }
        Object obj = j().get(i10 - 1);
        ChatMessageModel chatMessageModel = obj instanceof ChatMessageModel ? (ChatMessageModel) obj : null;
        if (chatMessageModel != null) {
            return Long.valueOf(chatMessageModel.getCreateTimeMillis());
        }
        return null;
    }

    @Nullable
    public final String E() {
        Integer F = F();
        if (F != null) {
            for (int intValue = F.intValue(); -1 < intValue; intValue--) {
                Object obj = j().get(intValue);
                if (obj instanceof ChatMessageModel) {
                    ChatMessageModel chatMessageModel = (ChatMessageModel) obj;
                    if (!chatMessageModel.getMine()) {
                        return chatMessageModel.getItemId();
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    public final Integer F() {
        int l10 = kotlin.collections.s.l(j());
        if (l10 == -1) {
            return null;
        }
        return Integer.valueOf(l10);
    }

    public final boolean G(@NotNull RecyclerView recycler) {
        s.i(recycler, "recycler");
        RecyclerView.LayoutManager layoutManager = recycler.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return false;
        }
        int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        if (f(findFirstCompletelyVisibleItemPosition) && f(findLastCompletelyVisibleItemPosition) && findFirstCompletelyVisibleItemPosition <= findLastCompletelyVisibleItemPosition && findFirstCompletelyVisibleItemPosition <= findLastCompletelyVisibleItemPosition) {
            while (true) {
                Object obj = j().get(findFirstCompletelyVisibleItemPosition);
                if (obj instanceof ChatMessageModel) {
                    ChatMessageModel chatMessageModel = (ChatMessageModel) obj;
                    if (chatMessageModel.isSnapMessage() && !chatMessageModel.getMine()) {
                        return true;
                    }
                }
                if (findFirstCompletelyVisibleItemPosition == findLastCompletelyVisibleItemPosition) {
                    break;
                }
                findFirstCompletelyVisibleItemPosition++;
            }
        }
        return false;
    }

    public final void H() {
        notifyItemRangeChanged(0, j().size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        FKBaseRecyclerViewHolder e2 = ChatTypeRegistry.f13347a.e(parent, i10);
        e2.k(l());
        return e2;
    }

    public final void J() {
        Integer countdownLeftSeconds;
        ListIterator<Object> listIterator = j().listIterator();
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            Object next = listIterator.next();
            if (next instanceof ChatMessageModel) {
                ChatMessageModel chatMessageModel = (ChatMessageModel) next;
                if (s.d(chatMessageModel.getType(), ChatMessageType.InboxMessageSnapImage.getValue()) && (countdownLeftSeconds = chatMessageModel.getCountdownLeftSeconds()) != null && countdownLeftSeconds.intValue() == 0) {
                    listIterator.remove();
                    notifyItemRemoved(nextIndex);
                }
            }
        }
    }

    public final void K(long j10, @NotNull ChatMessageModel model) {
        s.i(model, "model");
        Integer F = F();
        if (F != null) {
            for (int intValue = F.intValue(); -1 < intValue; intValue--) {
                Object obj = j().get(intValue);
                if (obj instanceof ChatMessageModel) {
                    ChatMessageModel chatMessageModel = (ChatMessageModel) obj;
                    if (chatMessageModel.getCreateTimeMillis() == j10) {
                        if (s.d(chatMessageModel.getType(), ChatMessageType.InboxMessageImage.getValue()) || s.d(chatMessageModel.getType(), ChatMessageType.InboxMessageSnapImage.getValue())) {
                            model.setImagePath(chatMessageModel.getImagePath());
                        }
                        j().set(intValue, model);
                        notifyItemChanged(intValue);
                        return;
                    }
                }
            }
        }
    }

    public final void L(List<ChatMessageModel> list) {
        for (ChatMessageModel chatMessageModel : list) {
            if (chatMessageModel.snapImgCountDownIsPause()) {
                chatMessageModel.startSnapCountDown();
            }
        }
    }

    public final void M() {
        for (Object obj : j()) {
            if (obj instanceof ChatMessageModel) {
                ChatMessageModel chatMessageModel = (ChatMessageModel) obj;
                if (chatMessageModel.snapImgCountDownIsRunning()) {
                    chatMessageModel.stopSnapImgCountDown();
                }
            }
        }
    }

    public final void N(@NotNull List<String> msgIds) {
        s.i(msgIds, "msgIds");
        if (msgIds.isEmpty()) {
            return;
        }
        ListIterator<Object> listIterator = j().listIterator();
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            Object next = listIterator.next();
            if (next instanceof ChatMessageModel) {
                ChatMessageModel chatMessageModel = (ChatMessageModel) next;
                String itemId = chatMessageModel.getItemId();
                if (!(itemId == null || itemId.length() == 0) && msgIds.contains(chatMessageModel.getItemId())) {
                    if (s.d(chatMessageModel.getType(), ChatMessageType.InboxMessageSnapImage.getValue())) {
                        j().remove(nextIndex);
                        notifyItemRemoved(nextIndex);
                        new SnapFileDownloader().e(chatMessageModel.getSnapImageLargeUrl());
                    } else {
                        chatMessageModel.setReceiverUnread(Boolean.FALSE);
                        notifyItemChanged(nextIndex);
                    }
                    msgIds.remove(chatMessageModel.getItemId());
                    if (msgIds.isEmpty()) {
                        return;
                    }
                }
            }
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (f(i10)) {
            return ChatTypeRegistry.f13347a.b(j().get(i10));
        }
        throw new IllegalStateException(("ChatDetailAdapter getItemViewType error position:" + i10 + "  totalCount:" + j().size()).toString());
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NotNull FKBaseRecyclerViewHolder holder, int i10) {
        Long C;
        s.i(holder, "holder");
        super.onBindViewHolder(holder, i10);
        if (!(holder instanceof BaseChatViewHolder) || (C = C(i10)) == null) {
            return;
        }
        long longValue = C.longValue();
        Long D = D(i10);
        if (D != null) {
            ((BaseChatViewHolder) holder).x(longValue, D.longValue());
        }
    }

    public final void u(@Nullable List<ChatMessageModel> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        j().addAll(0, list);
        notifyItemRangeInserted(0, list.size());
        L(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006c A[EDGE_INSN: B:35:0x006c->B:13:0x006c BREAK  A[LOOP:1: B:20:0x0037->B:36:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[LOOP:1: B:20:0x0037->B:36:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v(@org.jetbrains.annotations.NotNull java.util.List<com.cupidapp.live.chat2.model.ChatMessageModel> r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.p> r9) {
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
            com.cupidapp.live.chat2.model.ChatMessageModel r1 = (com.cupidapp.live.chat2.model.ChatMessageModel) r1
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
            boolean r6 = r4 instanceof com.cupidapp.live.chat2.model.ChatMessageModel
            if (r6 == 0) goto L69
            com.cupidapp.live.chat2.model.ChatMessageModel r4 = (com.cupidapp.live.chat2.model.ChatMessageModel) r4
            java.lang.String r6 = r4.getItemId()
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
            java.lang.String r4 = r4.getItemId()
            java.lang.String r6 = r1.getItemId()
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
            r7.notifyItemRangeChanged(r0, r8)
            r9.invoke()
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat2.adapter.ChatDetailAdapter.v(java.util.List, kotlin.jvm.functions.Function0):void");
    }

    public final void w(@NotNull ChatOtherStoryLabelUiModel model) {
        int l10;
        s.i(model, "model");
        int i10 = 0;
        if (model.getInsertTop() != null && !model.getInsertTop().booleanValue() && (l10 = kotlin.collections.s.l(j())) != -1) {
            i10 = l10;
        }
        j().add(i10, model);
        notifyItemInserted(i10);
    }

    public final boolean x(@NotNull ChatBundleData data) {
        boolean z10;
        s.i(data, "data");
        if (ChatDetailTitleLayout.f13442d.a(data.getOtherUser().userId()) || data.getFeedModel() != null || data.isFromStoryLabel()) {
            return false;
        }
        List<Object> j10 = j();
        if (!(j10 instanceof Collection) || !j10.isEmpty()) {
            Iterator<Object> iterator2 = j10.iterator2();
            while (iterator2.hasNext()) {
                if (iterator2.next() instanceof ChatMessageModel) {
                    z10 = false;
                    break;
                }
            }
        }
        z10 = true;
        return z10;
    }

    public final void y(@NotNull String msgId, @NotNull ChatMessageModel noticeMsg) {
        s.i(msgId, "msgId");
        s.i(noticeMsg, "noticeMsg");
        Integer F = F();
        if (F != null) {
            for (int intValue = F.intValue(); -1 < intValue; intValue--) {
                Object obj = j().get(intValue);
                if ((obj instanceof ChatMessageModel) && s.d(((ChatMessageModel) obj).getItemId(), msgId)) {
                    j().set(intValue, noticeMsg);
                    notifyItemChanged(intValue);
                    return;
                }
            }
        }
    }

    public final void z(boolean z10) {
        int i10 = 0;
        if (z10) {
            c(0, new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
            notifyItemInserted(0);
            return;
        }
        Iterator<Object> iterator2 = j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            } else if (iterator2.next() instanceof FKFooterViewModel) {
                break;
            } else {
                i10++;
            }
        }
        if (f(i10)) {
            j().remove(i10);
            notifyItemRemoved(i10);
        }
    }
}
