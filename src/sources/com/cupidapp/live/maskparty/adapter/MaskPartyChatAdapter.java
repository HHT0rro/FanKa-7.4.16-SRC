package com.cupidapp.live.maskparty.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.network.download.SnapFileDownloader;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.maskparty.helper.MaskPartyChatTypeRegistry;
import com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder;
import com.cupidapp.live.maskparty.holder.MaskPartyChatUserInfoUiModel;
import com.cupidapp.live.maskparty.holder.PublicProfileModel;
import com.cupidapp.live.maskparty.holder.ScriptKillPromptModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageType;
import com.cupidapp.live.maskparty.model.MaskPartyChatRoomModel;
import com.cupidapp.live.maskparty.model.ScriptTaskScoreModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatAdapter extends FKBaseRecyclerViewAdapter {
    @Nullable
    public final Integer A(@NotNull String messageId) {
        Object obj;
        s.i(messageId, "messageId");
        List<Object> j10 = j();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : j10) {
            if (obj2 instanceof MaskPartyChatMessageModel) {
                arrayList.add(obj2);
            }
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            }
            obj = iterator2.next();
            if (s.d(((MaskPartyChatMessageModel) obj).getItemId(), messageId)) {
                break;
            }
        }
        MaskPartyChatMessageModel maskPartyChatMessageModel = (MaskPartyChatMessageModel) obj;
        if (maskPartyChatMessageModel == null) {
            return null;
        }
        int indexOf = j().indexOf(maskPartyChatMessageModel);
        if (f(indexOf)) {
            j().remove(indexOf);
            notifyItemRemoved(indexOf);
        }
        if (s.d(maskPartyChatMessageModel.getType(), MaskPartyChatMessageType.InboxMessageSnapImage.getValue())) {
            new SnapFileDownloader().e(maskPartyChatMessageModel.getSnapImageLargeUrl());
        }
        return Integer.valueOf(indexOf);
    }

    public final Long B(int i10) {
        if (!f(i10)) {
            return null;
        }
        Object obj = j().get(i10);
        MaskPartyChatMessageModel maskPartyChatMessageModel = obj instanceof MaskPartyChatMessageModel ? (MaskPartyChatMessageModel) obj : null;
        if (maskPartyChatMessageModel != null) {
            return Long.valueOf(maskPartyChatMessageModel.getCreateTimeMillis());
        }
        return null;
    }

    public final Long C(int i10) {
        if (i10 <= 0 || i10 >= j().size()) {
            return i10 == 0 ? 0L : null;
        }
        Object obj = j().get(i10 - 1);
        MaskPartyChatMessageModel maskPartyChatMessageModel = obj instanceof MaskPartyChatMessageModel ? (MaskPartyChatMessageModel) obj : null;
        if (maskPartyChatMessageModel != null) {
            return Long.valueOf(maskPartyChatMessageModel.getCreateTimeMillis());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0071 A[EDGE_INSN: B:27:0x0071->B:28:0x0071 BREAK  A[LOOP:1: B:13:0x0028->B:31:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[LOOP:1: B:13:0x0028->B:31:?, LOOP_END, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel D(@org.jetbrains.annotations.NotNull com.cupidapp.live.maskparty.model.NoticeButtonType r6) {
        /*
            r5 = this;
            java.lang.String r0 = "btnType"
            kotlin.jvm.internal.s.i(r6, r0)
            java.util.List r0 = r5.j()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator2()
        L12:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L24
            java.lang.Object r2 = r0.next()
            boolean r3 = r2 instanceof com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel
            if (r3 == 0) goto L12
            r1.add(r2)
            goto L12
        L24:
            java.util.Iterator r0 = r1.iterator2()
        L28:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L70
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel r2 = (com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel) r2
            com.cupidapp.live.maskparty.model.MaskPartyChatNotifyMessageModel r3 = r2.getNotice()
            java.lang.String r2 = r2.getType()
            com.cupidapp.live.maskparty.model.MaskPartyChatMessageType r4 = com.cupidapp.live.maskparty.model.MaskPartyChatMessageType.InboxMessageNotice
            java.lang.String r4 = r4.getValue()
            boolean r2 = kotlin.jvm.internal.s.d(r2, r4)
            if (r2 == 0) goto L6c
            if (r3 == 0) goto L6c
            java.lang.Integer r2 = r3.getButtonType()
            int r4 = r6.getType()
            if (r2 != 0) goto L56
            goto L6c
        L56:
            int r2 = r2.intValue()
            if (r2 != r4) goto L6c
            java.lang.String r2 = r3.getContent()
            java.lang.String r3 = r3.getActionCompleteContent()
            boolean r2 = kotlin.jvm.internal.s.d(r2, r3)
            if (r2 != 0) goto L6c
            r2 = 1
            goto L6d
        L6c:
            r2 = 0
        L6d:
            if (r2 == 0) goto L28
            goto L71
        L70:
            r1 = 0
        L71:
            com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel r1 = (com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.maskparty.adapter.MaskPartyChatAdapter.D(com.cupidapp.live.maskparty.model.NoticeButtonType):com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        FKBaseRecyclerViewHolder g3 = MaskPartyChatTypeRegistry.f16339a.g(parent, i10);
        g3.k(l());
        return g3;
    }

    public final void F() {
        Integer countdownLeftSeconds;
        List<Object> j10 = j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof MaskPartyChatMessageModel) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            MaskPartyChatMessageModel maskPartyChatMessageModel = (MaskPartyChatMessageModel) obj2;
            if (s.d(maskPartyChatMessageModel.getType(), MaskPartyChatMessageType.InboxMessageSnapImage.getValue()) && (countdownLeftSeconds = maskPartyChatMessageModel.getCountdownLeftSeconds()) != null && countdownLeftSeconds.intValue() == 0) {
                arrayList2.add(obj2);
            }
        }
        Iterator<E> iterator2 = arrayList2.iterator2();
        while (iterator2.hasNext()) {
            int indexOf = j().indexOf((MaskPartyChatMessageModel) iterator2.next());
            j().remove(indexOf);
            notifyItemRemoved(indexOf);
        }
    }

    public final void G(long j10, @NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        for (int l10 = kotlin.collections.s.l(j()); -1 < l10; l10--) {
            Object obj = j().get(l10);
            if ((obj instanceof MaskPartyChatMessageModel) && ((MaskPartyChatMessageModel) obj).getCreateTimeMillis() == j10) {
                j().set(l10, model);
                notifyItemChanged(l10);
                return;
            }
        }
    }

    public final void H(boolean z10) {
        int i10 = 0;
        for (Object obj : j()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            if (obj instanceof MaskPartyChatUserInfoUiModel) {
                ((MaskPartyChatUserInfoUiModel) obj).setMask(z10);
                notifyItemChanged(i10);
            } else if (obj instanceof MaskPartyChatMessageModel) {
                MaskPartyChatMessageModel maskPartyChatMessageModel = (MaskPartyChatMessageModel) obj;
                if (!maskPartyChatMessageModel.getMine()) {
                    maskPartyChatMessageModel.setMask(z10);
                    notifyItemChanged(i10);
                }
            }
            i10 = i11;
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (f(i10)) {
            return MaskPartyChatTypeRegistry.f16339a.b(j().get(i10));
        }
        throw new IllegalStateException(("MaskPartyChatAdapter getItemViewType error position:" + i10 + "  totalCount:" + j().size()).toString());
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NotNull FKBaseRecyclerViewHolder holder, int i10) {
        Long B;
        s.i(holder, "holder");
        super.onBindViewHolder(holder, i10);
        if (!(holder instanceof BaseMaskPartyChatViewHolder) || (B = B(i10)) == null) {
            return;
        }
        long longValue = B.longValue();
        Long C = C(i10);
        if (C != null) {
            ((BaseMaskPartyChatViewHolder) holder).v(longValue, C.longValue());
        }
    }

    public final void u(int i10, @NotNull MaskPartyChatMessageModel message) {
        s.i(message, "message");
        j().add(i10, message);
        notifyItemChanged(i10);
    }

    public final int v(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        int size = j().size();
        j().add(size, model);
        notifyItemChanged(size);
        return size;
    }

    public final int w(@NotNull String message) {
        s.i(message, "message");
        int size = j().size();
        j().add(size, new PublicProfileModel(message, false, 2, null));
        notifyItemChanged(size);
        return size;
    }

    public final void x(@NotNull String message) {
        s.i(message, "message");
        int size = j().size();
        j().add(size, new ScriptKillPromptModel(message));
        notifyItemChanged(size);
    }

    public final int y(@NotNull ScriptTaskScoreModel message) {
        s.i(message, "message");
        int size = j().size();
        j().add(size, message);
        notifyItemChanged(size);
        return size;
    }

    public final void z(@NotNull MaskPartyChatRoomModel model) {
        s.i(model, "model");
        int size = j().size();
        j().add(size, new MaskPartyChatUserInfoUiModel(model.getTargetUserInfo(), MaskPartyChatRoomModel.Companion.a(model.getScore())));
        notifyItemChanged(size);
    }
}
