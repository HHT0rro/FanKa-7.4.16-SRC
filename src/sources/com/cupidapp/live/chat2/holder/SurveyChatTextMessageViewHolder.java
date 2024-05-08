package com.cupidapp.live.chat2.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.chat2.model.SurveyChatTextMessageModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SurveyChatTextMessageViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatTextMessageViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13400c = new a(null);

    /* compiled from: SurveyChatTextMessageViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SurveyChatTextMessageViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SurveyChatTextMessageViewHolder(z.b(parent, R$layout.view_holder_survey_chat_text_message, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurveyChatTextMessageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof SurveyChatTextMessageModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.text_message_avatar_img);
            s.h(imageLoaderView, "itemView.text_message_avatar_img");
            SurveyChatTextMessageModel surveyChatTextMessageModel = (SurveyChatTextMessageModel) obj;
            ImageLoaderView.g(imageLoaderView, surveyChatTextMessageModel.getSender().getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.text_message_txt)).setText(surveyChatTextMessageModel.getContent());
        }
    }
}
