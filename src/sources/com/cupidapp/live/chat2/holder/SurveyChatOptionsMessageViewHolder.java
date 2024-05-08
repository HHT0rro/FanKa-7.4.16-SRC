package com.cupidapp.live.chat2.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.chat2.model.SurveyChatOptionsMessageModel;
import com.cupidapp.live.chat2.model.SurveyChatOptionsModel;
import j1.i;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: SurveyChatOptionsMessageViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatOptionsMessageViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13395c = new a(null);

    /* compiled from: SurveyChatOptionsMessageViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SurveyChatOptionsMessageViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SurveyChatOptionsMessageViewHolder(z.b(parent, R$layout.view_holder_survey_chat_options_message, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurveyChatOptionsMessageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable final Object obj) {
        if (obj instanceof SurveyChatOptionsMessageModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.options_message_avatar_img);
            s.h(imageLoaderView, "itemView.options_message_avatar_img");
            SurveyChatOptionsMessageModel surveyChatOptionsMessageModel = (SurveyChatOptionsMessageModel) obj;
            ImageLoaderView.g(imageLoaderView, surveyChatOptionsMessageModel.getSender().getAvatarImage(), null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.options_message_layout;
            ((LinearLayout) view.findViewById(i10)).removeAllViews();
            TextView textView = new TextView(this.itemView.getContext());
            textView.setText(surveyChatOptionsMessageModel.getContent());
            textView.setTextSize(16.0f);
            textView.setTextColor(-12566464);
            u.a(textView);
            textView.setGravity(1);
            textView.setLineSpacing(h.c(textView, 4.0f), 1.0f);
            ((LinearLayout) this.itemView.findViewById(i10)).addView(textView);
            y.m(textView, null, null, null, Integer.valueOf(h.c(this, 8.0f)), 7, null);
            for (final SurveyChatOptionsModel surveyChatOptionsModel : surveyChatOptionsMessageModel.getOptions()) {
                View r10 = r(surveyChatOptionsModel);
                ((LinearLayout) this.itemView.findViewById(R$id.options_message_layout)).addView(r10);
                y.o(r10, null, Integer.valueOf(h.c(this, 44.0f)), 1, null);
                y.m(r10, null, Integer.valueOf(h.c(this, 8.0f)), null, null, 13, null);
                y.d(r10, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.holder.SurveyChatOptionsMessageViewHolder$config$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(View view2) {
                        invoke2(view2);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view2) {
                        if (SurveyChatOptionsModel.this.getSelectable()) {
                            String url = SurveyChatOptionsModel.this.getUrl();
                            if (url == null || url.length() == 0) {
                                EventBus.c().l(new SelectionOptionEvent(((SurveyChatOptionsMessageModel) obj).getId(), SurveyChatOptionsModel.this.getOptionId()));
                            } else {
                                j.a.b(j.f12156c, this.itemView.getContext(), SurveyChatOptionsModel.this.getUrl(), null, 4, null);
                            }
                            i.e(i.f50236a, PopupName.MESSAGE_OPTION_BOX, SurveyChatOptionsModel.this.getText(), null, ((SurveyChatOptionsMessageModel) obj).getContent(), 4, null);
                        }
                    }
                });
            }
        }
    }

    public final View r(SurveyChatOptionsModel surveyChatOptionsModel) {
        TextView textView = new TextView(this.itemView.getContext());
        textView.setText(surveyChatOptionsModel.getText());
        textView.setTextSize(14.0f);
        textView.setTextColor(surveyChatOptionsModel.getSelected() ? -1 : -15066598);
        u.a(textView);
        textView.setGravity(17);
        textView.setBackgroundResource(surveyChatOptionsModel.getSelected() ? R$drawable.rect_cor_100_sd_ff4040 : R$drawable.rect_cor_100_sd_ffffff);
        return textView;
    }
}
