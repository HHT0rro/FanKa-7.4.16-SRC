package com.cupidapp.live.maskparty.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$array;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.maskparty.helper.MaskPartyChatViewHolderFactory;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyLongClickActionType;
import com.cupidapp.live.maskparty.view.MaskPartyChatMessageStateView;
import com.cupidapp.live.maskparty.view.MaskPartyChatTimeStampView;
import java.util.ArrayList;
import kotlin.collections.m;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.z;

/* compiled from: MaskPartyChatTextViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatTextViewHolder extends BaseMaskPartyChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16358d = new a(null);

    /* compiled from: MaskPartyChatTextViewHolder.kt */
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
            return new MaskPartyChatTextViewHolder(z.b(parent, z10 ? R$layout.view_holder_mask_party_chat_text_right : R$layout.view_holder_mask_party_chat_text_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatTextViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public MaskPartyChatMessageStateView A() {
        return (MaskPartyChatMessageStateView) this.itemView.findViewById(R$id.right_text_message_state_view);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public MaskPartyChatTimeStampView B() {
        return (MaskPartyChatTimeStampView) this.itemView.findViewById(R$id.chat_text_time_stamp_view);
    }

    public final void C(String str, TextView textView, TextView textView2) {
        if (D(str)) {
            textView.setVisibility(8);
            textView2.setVisibility(0);
            textView2.setText(str);
        } else {
            textView2.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    public final boolean D(String str) {
        if (str == null || str.length() > 2 || !t.b(str)) {
            return false;
        }
        String[] stringArray = this.itemView.getContext().getResources().getStringArray(R$array.emoji_face);
        s.h(stringArray, "itemView.context.resourc…Array(R.array.emoji_face)");
        return m.t(stringArray, str);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @NotNull
    public ArrayList<MaskPartyLongClickActionType> u(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        if (model.getMine()) {
            ArrayList<MaskPartyLongClickActionType> arrayList = new ArrayList<>();
            arrayList.add(MaskPartyLongClickActionType.Copy);
            if (model.less2Min()) {
                arrayList.add(MaskPartyLongClickActionType.Cancel);
            }
            arrayList.add(MaskPartyLongClickActionType.Delete);
            return arrayList;
        }
        return kotlin.collections.s.f(MaskPartyLongClickActionType.Copy, MaskPartyLongClickActionType.Delete, MaskPartyLongClickActionType.Report);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    public void w(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        String text = model.getText();
        TextView textView = (TextView) this.itemView.findViewById(R$id.left_text_bubble_text_view);
        s.h(textView, "itemView.left_text_bubble_text_view");
        TextView textView2 = (TextView) this.itemView.findViewById(R$id.left_text_single_emoji_text);
        s.h(textView2, "itemView.left_text_single_emoji_text");
        C(text, textView, textView2);
        FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R$id.left_text_content_frame_layout);
        s.h(frameLayout, "itemView.left_text_content_frame_layout");
        s(frameLayout, model);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    public void x(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        String text = model.getText();
        TextView textView = (TextView) this.itemView.findViewById(R$id.right_text_bubble_text_view);
        s.h(textView, "itemView.right_text_bubble_text_view");
        TextView textView2 = (TextView) this.itemView.findViewById(R$id.right_text_single_emoji_text);
        s.h(textView2, "itemView.right_text_single_emoji_text");
        C(text, textView, textView2);
        FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R$id.right_text_content_frame_layout);
        s.h(frameLayout, "itemView.right_text_content_frame_layout");
        s(frameLayout, model);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public ImageLoaderView y() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.left_text_avatar_image);
    }
}
