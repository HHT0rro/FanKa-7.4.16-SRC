package com.cupidapp.live.maskparty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageSendFailResendEvent;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageSendState;
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

/* compiled from: MaskPartyChatMessageStateView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatMessageStateView extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16386b;

    /* compiled from: MaskPartyChatMessageStateView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16387a;

        static {
            int[] iArr = new int[MaskPartyChatMessageSendState.values().length];
            try {
                iArr[MaskPartyChatMessageSendState.Sending.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MaskPartyChatMessageSendState.Resend.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MaskPartyChatMessageSendState.SendSuccess.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16387a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatMessageStateView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16386b = new LinkedHashMap();
        b();
    }

    public static /* synthetic */ void d(MaskPartyChatMessageStateView maskPartyChatMessageStateView, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i12 = 0;
        }
        maskPartyChatMessageStateView.c(i10, i11, i12);
    }

    public final void a(@NotNull final MaskPartyChatMessageModel model) {
        s.i(model, "model");
        MaskPartyChatMessageSendState messageSendState = model.getMessageSendState();
        int i10 = messageSendState == null ? -1 : a.f16387a[messageSendState.ordinal()];
        if (i10 == 1) {
            setVisibility(0);
            d(this, -12566464, R$string.sending_message, 0, 4, null);
            y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatMessageStateView$configMessageSendState$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                }
            });
        } else if (i10 != 2) {
            if (i10 != 3) {
                return;
            }
            setVisibility(8);
        } else {
            setVisibility(0);
            c(-49088, R$string.resend, R$mipmap.icon_mask_party_message_resend);
            y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatMessageStateView$configMessageSendState$2
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
                    EventBus.c().l(new MaskPartyChatMessageSendFailResendEvent(MaskPartyChatMessageModel.this));
                }
            });
        }
    }

    public final void b() {
        setGravity(17);
        setTextColor(-12566464);
        setTextSize(11.0f);
        setPadding(0, 0, z0.h.c(this, 5.0f), 0);
    }

    public final void c(@ColorInt int i10, @StringRes int i11, int i12) {
        setTextColor(i10);
        setText(i11);
        u.e(this, i12, 0, 0, 0, 14, null);
        setCompoundDrawablePadding(z0.h.c(this, 4.0f));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatMessageStateView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16386b = new LinkedHashMap();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatMessageStateView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16386b = new LinkedHashMap();
        b();
    }
}
