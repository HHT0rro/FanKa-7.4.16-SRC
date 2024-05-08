package com.cupidapp.live.voiceparty.helper;

import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import j1.i;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoicePartyPromptHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyPromptHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final VoicePartyPromptHelper f19013a = new VoicePartyPromptHelper();

    public final void a(@NotNull Context context, @NotNull final SensorPosition position, @NotNull final Function0<p> positiveCallback) {
        s.i(context, "context");
        s.i(position, "position");
        s.i(positiveCallback, "positiveCallback");
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).j(false).D(R$string.are_you_sure_want_to_hang_up), 0, null, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showHangUpPrompt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i.f50236a.a(PopupName.VOICE_HANG_UP_CONFIRM, PopupButtonName.Confirm, SensorPosition.this);
                positiveCallback.invoke();
            }
        }, 3, null), 0, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showHangUpPrompt$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i.f50236a.a(PopupName.VOICE_HANG_UP_CONFIRM, PopupButtonName.Cancel, SensorPosition.this);
            }
        }, 1, null).u(new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showHangUpPrompt$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i.g(i.f50236a, PopupName.VOICE_HANG_UP_CONFIRM, SensorPosition.this, null, 4, null);
            }
        }), null, 1, null);
    }

    public final void b(@NotNull Context context, @NotNull final Function0<p> positiveCallback) {
        s.i(context, "context");
        s.i(positiveCallback, "positiveCallback");
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null), R$string.want_see_other_profile_and_need_public_my_profile, 0, 2, null), R$string.publish_profile, null, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showNeedPublicMyProfilePrompt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                positiveCallback.invoke();
            }
        }, 2, null), R$string.not_look, null, 2, null), null, 1, null);
    }

    public final void c(@NotNull Context context, boolean z10, @NotNull final SensorPosition position, @NotNull final Function0<p> positiveCallback, @NotNull final Function0<p> negativeCallback) {
        s.i(context, "context");
        s.i(position, "position");
        s.i(positiveCallback, "positiveCallback");
        s.i(negativeCallback, "negativeCallback");
        FKAlertDialog u10 = FKAlertDialog.f12698l.b(context, false).j(false).D(R$string.other_has_hung_up_voice).u(new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showOtherLeaveRoomPrompt$dialog$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i.g(i.f50236a, PopupName.VOICE_HE_HANG_UP, SensorPosition.this, null, 4, null);
            }
        });
        if (z10) {
            u10.v(R$string.rematch, Integer.valueOf(R$string.rematch_tip), new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showOtherLeaveRoomPrompt$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    i.f50236a.a(PopupName.VOICE_HE_HANG_UP, PopupButtonName.Rematch, SensorPosition.this);
                    positiveCallback.invoke();
                }
            }).B(R$string.leave_room, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showOtherLeaveRoomPrompt$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    i.f50236a.a(PopupName.VOICE_HE_HANG_UP, PopupButtonName.Leave, SensorPosition.this);
                    negativeCallback.invoke();
                }
            }).t(new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showOtherLeaveRoomPrompt$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    i.f50236a.a(PopupName.VOICE_HE_HANG_UP, PopupButtonName.Leave, SensorPosition.this);
                    negativeCallback.invoke();
                }
            });
        } else {
            FKAlertDialog.w(u10, R$string.leave_room, null, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showOtherLeaveRoomPrompt$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    i.f50236a.a(PopupName.VOICE_HE_HANG_UP, PopupButtonName.Leave, SensorPosition.this);
                    negativeCallback.invoke();
                }
            }, 2, null).t(new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showOtherLeaveRoomPrompt$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    i.f50236a.a(PopupName.VOICE_HE_HANG_UP, PopupButtonName.Leave, SensorPosition.this);
                    negativeCallback.invoke();
                }
            });
        }
        FKAlertDialog.G(u10, null, 1, null);
    }

    public final void d(@NotNull Context context, @Nullable String str, @Nullable String str2, @NotNull final Function0<p> positiveCallback) {
        s.i(context, "context");
        s.i(positiveCallback, "positiveCallback");
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).j(false).E(str).n(str2), R$string.leave_room, null, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showRoomDissolvePrompt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                positiveCallback.invoke();
            }
        }, 2, null).t(new Function0<p>() { // from class: com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper$showRoomDissolvePrompt$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                positiveCallback.invoke();
            }
        }), null, 1, null);
    }
}
