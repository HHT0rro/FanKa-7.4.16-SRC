package com.cupidapp.live.chat2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.ChatMessageSendFailResendEvent;
import com.cupidapp.live.chat2.model.MessageSendState;
import com.cupidapp.live.club.model.ClubChatMessageSendFailResendEvent;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;

/* compiled from: ChatMessageStateView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatMessageStateView extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13449b;

    /* compiled from: ChatMessageStateView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13450a;

        static {
            int[] iArr = new int[MessageSendState.values().length];
            try {
                iArr[MessageSendState.FromServer.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageSendState.Sending.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageSendState.Resend.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f13450a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessageStateView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13449b = new LinkedHashMap();
        c();
    }

    public static /* synthetic */ void e(ChatMessageStateView chatMessageStateView, int i10, Integer num, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        chatMessageStateView.d(i10, num, i11);
    }

    public final void a(@NotNull final ChatMessageModel model) {
        s.i(model, "model");
        MessageSendState messageSendState = model.getMessageSendState();
        int i10 = messageSendState == null ? -1 : a.f13450a[messageSendState.ordinal()];
        if (i10 == -1 || i10 == 1) {
            e(this, -3750202, Integer.valueOf(s.d(model.getReceiverUnread(), Boolean.FALSE) ? R$string.have_read : R$string.send_message_success), 0, 4, null);
            y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatMessageStateView$configMessageSendState$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                }
            });
        } else if (i10 == 2) {
            e(this, -3750202, Integer.valueOf(R$string.sending_message), 0, 4, null);
            y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatMessageStateView$configMessageSendState$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                }
            });
        } else {
            if (i10 != 3) {
                return;
            }
            d(-49088, Integer.valueOf(R$string.resend), R$mipmap.chat_resend);
            y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatMessageStateView$configMessageSendState$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    EventBus.c().l(new ChatMessageSendFailResendEvent(ChatMessageModel.this));
                }
            });
        }
    }

    public final void b(@NotNull final ClubChatMsgModel model) {
        s.i(model, "model");
        MessageSendState messageSendState = model.getMessageSendState();
        int i10 = messageSendState == null ? -1 : a.f13450a[messageSendState.ordinal()];
        if (i10 == -1 || i10 == 1) {
            e(this, -3750202, null, 0, 4, null);
            y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatMessageStateView$configMessageSendState$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                }
            });
        } else if (i10 == 2) {
            e(this, -3750202, Integer.valueOf(R$string.sending_message), 0, 4, null);
            y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatMessageStateView$configMessageSendState$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                }
            });
        } else {
            if (i10 != 3) {
                return;
            }
            d(-49088, Integer.valueOf(R$string.resend), R$mipmap.chat_resend);
            y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatMessageStateView$configMessageSendState$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    EventBus.c().l(new ClubChatMessageSendFailResendEvent(ClubChatMsgModel.this));
                }
            });
        }
    }

    public final void c() {
        setGravity(17);
        setTextColor(-3750202);
        setTextSize(10.0f);
        setPadding(0, 0, z0.h.c(this, 5.0f), 0);
    }

    public final void d(@ColorInt int i10, @StringRes Integer num, int i11) {
        setTextColor(i10);
        if (num == null) {
            setText((CharSequence) null);
        } else {
            setText(num.intValue());
        }
        u.e(this, i11, 0, 0, 0, 14, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessageStateView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13449b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessageStateView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13449b = new LinkedHashMap();
        c();
    }
}
