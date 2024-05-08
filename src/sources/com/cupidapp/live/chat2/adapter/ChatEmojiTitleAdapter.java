package com.cupidapp.live.chat2.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatEmojiTitleAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatEmojiTitleAdapter extends FKBaseRecyclerViewAdapter {
    public final void u(@NotNull List<ChatEmojiTitleUiModel> list) {
        s.i(list, "list");
        j().clear();
        e(list);
        notifyItemRangeInserted(0, list.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        ChatEmojiTitleViewHolder a10 = ChatEmojiTitleViewHolder.f13303c.a(parent);
        a10.k(l());
        return a10;
    }

    public final void w(int i10, @NotNull Function0<p> selectedCallback) {
        s.i(selectedCallback, "selectedCallback");
        if (f(i10)) {
            int i11 = 0;
            for (Object obj : j()) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.s.s();
                }
                if (obj instanceof ChatEmojiTitleUiModel) {
                    if (i11 == i10) {
                        ((ChatEmojiTitleUiModel) obj).setSelected(true);
                        selectedCallback.invoke();
                    } else {
                        ((ChatEmojiTitleUiModel) obj).setSelected(false);
                    }
                }
                i11 = i12;
            }
            notifyItemRangeChanged(0, j().size());
        }
    }
}
