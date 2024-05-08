package com.cupidapp.live.maskparty.holder;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.utils.h0;
import com.cupidapp.live.maskparty.helper.MaskPartyChatViewHolderFactory;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatNotifyMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyLongClickActionType;
import com.cupidapp.live.maskparty.view.MaskPartyChatMessageStateView;
import com.cupidapp.live.maskparty.view.MaskPartyChatTimeStampView;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: MaskPartyChatNotifyViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatNotifyViewHolder extends BaseMaskPartyChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16355d = new a(null);

    /* compiled from: MaskPartyChatNotifyViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements MaskPartyChatViewHolderFactory {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.cupidapp.live.maskparty.helper.MaskPartyChatViewHolderFactory
        @NotNull
        public BaseMaskPartyChatViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new MaskPartyChatNotifyViewHolder(z.b(parent, R$layout.view_holder_mask_party_chat_notice, false, 2, null));
        }
    }

    /* compiled from: MaskPartyChatNotifyViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends h0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaskPartyChatMessageModel f16356b;

        public b(MaskPartyChatMessageModel maskPartyChatMessageModel) {
            this.f16356b = maskPartyChatMessageModel;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            EventBus.c().l(this.f16356b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatNotifyViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public MaskPartyChatMessageStateView A() {
        return null;
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public MaskPartyChatTimeStampView B() {
        return null;
    }

    public final void C(MaskPartyChatMessageModel maskPartyChatMessageModel) {
        CharSequence content;
        MaskPartyChatNotifyMessageModel notice = maskPartyChatMessageModel.getNotice();
        if (notice == null) {
            return;
        }
        String content2 = notice.getContent();
        if (content2 == null || content2.length() == 0) {
            return;
        }
        View view = this.itemView;
        int i10 = R$id.mask_party_chat_notice_text_view;
        TextView textView = (TextView) view.findViewById(i10);
        String buttonText = notice.getButtonText();
        if (!(buttonText == null || buttonText.length() == 0)) {
            content = q1.d.f53006a.c(notice.getContent(), kotlin.collections.s.o(notice.getButtonText()), -16084993, null, true, kotlin.collections.s.o(new b(maskPartyChatMessageModel)), Integer.valueOf(h.c(this, 13.0f)));
        } else {
            List<String> highLight = notice.getHighLight();
            if (!(highLight == null || highLight.isEmpty())) {
                content = q1.d.f53006a.c(notice.getContent(), notice.getHighLight(), (r18 & 4) != 0 ? null : -49088, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
            } else {
                content = notice.getContent();
            }
        }
        textView.setText(content);
        ((TextView) this.itemView.findViewById(i10)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public ArrayList<MaskPartyLongClickActionType> u(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        return null;
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    public void w(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        C(model);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    public void x(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        C(model);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public ImageLoaderView y() {
        return null;
    }
}
