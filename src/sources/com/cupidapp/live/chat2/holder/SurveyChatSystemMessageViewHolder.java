package com.cupidapp.live.chat2.holder;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.utils.h0;
import com.cupidapp.live.chat2.model.KeyMsgModel;
import com.cupidapp.live.chat2.model.SurveyChatSystemMessageModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SurveyChatSystemMessageViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatSystemMessageViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13396c = new a(null);

    /* compiled from: SurveyChatSystemMessageViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SurveyChatSystemMessageViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SurveyChatSystemMessageViewHolder(z.b(parent, R$layout.view_holder_survey_chat_system_message, false, 2, null));
        }
    }

    /* compiled from: SurveyChatSystemMessageViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends h0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ KeyMsgModel f13397b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f13398c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SurveyChatSystemMessageViewHolder f13399d;

        public b(KeyMsgModel keyMsgModel, Object obj, SurveyChatSystemMessageViewHolder surveyChatSystemMessageViewHolder) {
            this.f13397b = keyMsgModel;
            this.f13398c = obj;
            this.f13399d = surveyChatSystemMessageViewHolder;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            String url = this.f13397b.getUrl();
            if (url == null || url.length() == 0) {
                EventBus.c().l(new SelectionOptionEvent(((SurveyChatSystemMessageModel) this.f13398c).getId(), this.f13397b.getOptionId()));
            } else {
                j.a.b(j.f12156c, this.f13399d.itemView.getContext(), this.f13397b.getUrl(), null, 4, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurveyChatSystemMessageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        SpannableStringBuilder c4;
        if (obj instanceof SurveyChatSystemMessageModel) {
            SurveyChatSystemMessageModel surveyChatSystemMessageModel = (SurveyChatSystemMessageModel) obj;
            KeyMsgModel linkDict = surveyChatSystemMessageModel.getLinkDict();
            if (linkDict == null) {
                ((TextView) this.itemView.findViewById(R$id.system_message_txt)).setText(surveyChatSystemMessageModel.getContent());
                return;
            }
            ArrayList arrayList = new ArrayList();
            List o10 = kotlin.collections.s.o(linkDict.getKey());
            arrayList.add(new b(linkDict, obj, this));
            View view = this.itemView;
            int i10 = R$id.system_message_txt;
            TextView textView = (TextView) view.findViewById(i10);
            c4 = q1.d.f53006a.c(surveyChatSystemMessageModel.getContent(), o10, (r18 & 4) != 0 ? null : -49088, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList, (r18 & 64) != 0 ? null : null);
            textView.setText(c4);
            ((TextView) this.itemView.findViewById(i10)).setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
