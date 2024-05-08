package com.cupidapp.live.chat2.holder;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.chat2.helper.ChatViewHolderFactory;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ChatMarketViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatMarketViewHolder extends BaseChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13376d = new a(null);

    /* compiled from: ChatMarketViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements ChatViewHolderFactory {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.cupidapp.live.chat2.helper.ChatViewHolderFactory
        @NotNull
        public BaseChatViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new ChatMarketViewHolder(z.b(parent, R$layout.view_holder_chat_market, false, 2, null));
        }
    }

    /* compiled from: ChatMarketViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f13378c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ChatMessageModel f13379d;

        public b(String str, ChatMessageModel chatMessageModel) {
            this.f13378c = str;
            this.f13379d = chatMessageModel;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, ChatMarketViewHolder.this.itemView.getContext(), this.f13378c, null, 4, null);
            z3.b bVar = z3.b.f54828a;
            User sender = this.f13379d.getSender();
            bVar.i(sender != null ? sender.userId() : null, this.f13379d.getItemId(), this.f13379d.getMarketingLinkDict().getContent(), this.f13378c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMarketViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ImageLoaderView A() {
        return null;
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatMessageStateView B() {
        return null;
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatTimeStampView C() {
        return null;
    }

    public final void D(ChatMessageModel chatMessageModel) {
        String str;
        SpannableStringBuilder c4;
        Collection<String> values;
        Set<String> h10;
        if (chatMessageModel.getMarketingLinkDict() != null) {
            ArrayList arrayList = new ArrayList();
            Map<String, String> linkDict = chatMessageModel.getMarketingLinkDict().getLinkDict();
            if (linkDict == null || (h10 = linkDict.h()) == null || (str = (String) CollectionsKt___CollectionsKt.U(h10)) == null) {
                str = "";
            }
            Map<String, String> linkDict2 = chatMessageModel.getMarketingLinkDict().getLinkDict();
            String str2 = (linkDict2 == null || (values = linkDict2.values()) == null) ? null : (String) CollectionsKt___CollectionsKt.U(values);
            if (str.length() > 0) {
                arrayList.add(new b(str2, chatMessageModel));
                c4 = q1.d.f53006a.c(chatMessageModel.getMarketingLinkDict().getContent(), kotlin.collections.s.o(str), (r18 & 4) != 0 ? null : -49088, (r18 & 8) != 0 ? null : 0, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList, (r18 & 64) != 0 ? null : null);
                View view = this.itemView;
                int i10 = R$id.chat_market_text_view;
                ((TextView) view.findViewById(i10)).setText(c4);
                ((TextView) this.itemView.findViewById(i10)).setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
            ((TextView) this.itemView.findViewById(R$id.chat_market_text_view)).setText(chatMessageModel.getMarketingLinkDict().getContent());
        }
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ArrayList<LongClickActionType> v(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        return null;
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void y(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        D(model);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void z(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        D(model);
    }
}
