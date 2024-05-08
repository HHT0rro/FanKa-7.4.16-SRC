package com.cupidapp.live.maskparty.helper;

import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.track.group.GroupOthersLog;
import j1.i;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyPromptHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyPromptHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MaskPartyPromptHelper f16347a = new MaskPartyPromptHelper();

    public final void a(@Nullable Context context, @NotNull final Function0<p> positiveCallback) {
        s.i(positiveCallback, "positiveCallback");
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null), R$string.exchange_match_number_prompt, 0, 2, null), R$string.determine, null, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showExchangeMatchNumberPrompt$1
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
                i.f50236a.a(PopupName.EXCHANGE_CONFIRM, PopupButtonName.Confirm, SensorPosition.PropCard);
            }
        }, 2, null), 0, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showExchangeMatchNumberPrompt$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i.f50236a.a(PopupName.EXCHANGE_CONFIRM, PopupButtonName.Cancel, SensorPosition.PropCard);
            }
        }, 1, null), null, 1, null);
        i.g(i.f50236a, PopupName.EXCHANGE_CONFIRM, SensorPosition.PropCard, null, 4, null);
    }

    public final void b(@Nullable Context context, @NotNull final Function0<p> positiveCallback) {
        s.i(positiveCallback, "positiveCallback");
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.f12698l.b(context, false).j(false), R$string.kick_room_prompt, 0, 2, null), R$string.leave_room, null, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showKickRoomPrompt$1
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
                i.f50236a.a(PopupName.MASK_PARTY_LEAVE, PopupButtonName.Leave, SensorPosition.ChatRoom);
            }
        }, 2, null).t(new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showKickRoomPrompt$2
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
                i.f50236a.a(PopupName.MASK_PARTY_LEAVE, PopupButtonName.Leave, SensorPosition.ChatRoom);
            }
        }), null, 1, null);
        i.g(i.f50236a, PopupName.MASK_PARTY_LEAVE, SensorPosition.ChatRoom, null, 4, null);
    }

    public final void c(@Nullable Context context, boolean z10, @NotNull final Function0<p> positiveCallback) {
        s.i(positiveCallback, "positiveCallback");
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.f12698l.b(context, false).j(false).D(R$string.leave_chat_room_title), z10 ? R$string.script_kill_quit_prompt : R$string.leave_chat_room_content, 0, 2, null), z10 ? R$string.leave_room : R$string.i_know_it, null, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showLeaveRoomPrompt$6
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
        }, 2, null).t(new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showLeaveRoomPrompt$7
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

    public final void d(@Nullable Context context, boolean z10, @NotNull final Function1<? super Boolean, p> positiveCallback, @NotNull final Function0<p> negativeCallback) {
        s.i(positiveCallback, "positiveCallback");
        s.i(negativeCallback, "negativeCallback");
        FKAlertDialog j10 = FKAlertDialog.o(FKAlertDialog.f12698l.b(context, false).D(R$string.leave_chat_room_title), z10 ? R$string.rematch_tips : R$string.leave_chat_room_content, 0, 2, null).j(false);
        if (z10) {
            j10.v(R$string.rematch, Integer.valueOf(R$string.rematch_tip), new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showLeaveRoomPrompt$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    positiveCallback.invoke(Boolean.TRUE);
                    GroupOthersLog.Y(GroupOthersLog.f18702a, "HE_LEAVE_CHAT_ROOM", SensorPosition.ChatRoom.getValue(), PopupButtonName.Rematch.getValue(), null, 8, null);
                }
            }).B(R$string.leave, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showLeaveRoomPrompt$2
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
                    negativeCallback.invoke();
                    GroupOthersLog.Y(GroupOthersLog.f18702a, "HE_LEAVE_CHAT_ROOM", SensorPosition.ChatRoom.getValue(), PopupButtonName.Leave.getValue(), null, 8, null);
                }
            }).t(new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showLeaveRoomPrompt$3
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
                    negativeCallback.invoke();
                    GroupOthersLog.Y(GroupOthersLog.f18702a, "HE_LEAVE_CHAT_ROOM", SensorPosition.ChatRoom.getValue(), PopupButtonName.Leave.getValue(), null, 8, null);
                }
            });
        } else {
            FKAlertDialog.w(j10, R$string.i_know_it, null, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showLeaveRoomPrompt$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    positiveCallback.invoke(Boolean.FALSE);
                }
            }, 2, null).t(new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showLeaveRoomPrompt$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    positiveCallback.invoke(Boolean.FALSE);
                }
            });
        }
        FKAlertDialog.G(j10, null, 1, null);
        GroupOthersLog.a0(GroupOthersLog.f18702a, "HE_LEAVE_CHAT_ROOM", SensorPosition.ChatRoom.getValue(), null, 4, null);
    }

    public final void e(@Nullable Context context, @NotNull final Function0<p> positiveCallback, @NotNull final Function0<p> negativeCallback) {
        s.i(positiveCallback, "positiveCallback");
        s.i(negativeCallback, "negativeCallback");
        FKAlertDialog.G(FKAlertDialog.o(FKAlertDialog.f12698l.b(context, false).j(false).D(R$string.others_kick_room_prompt_title), R$string.others_kick_room_prompt, 0, 2, null).v(R$string.rematch, Integer.valueOf(R$string.rematch_tip), new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showOthersKickRoomPrompt$1
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
                i.f50236a.a(PopupName.MASK_PARTY_BE_HANG_UP, PopupButtonName.Rematch, SensorPosition.ChatRoom);
            }
        }).B(R$string.leave, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showOthersKickRoomPrompt$2
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
                negativeCallback.invoke();
                i.f50236a.a(PopupName.MASK_PARTY_BE_HANG_UP, PopupButtonName.Leave, SensorPosition.ChatRoom);
            }
        }).t(new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showOthersKickRoomPrompt$3
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
                negativeCallback.invoke();
                i.f50236a.a(PopupName.MASK_PARTY_BE_HANG_UP, PopupButtonName.Leave, SensorPosition.ChatRoom);
            }
        }), null, 1, null);
        i.g(i.f50236a, PopupName.MASK_PARTY_BE_HANG_UP, SensorPosition.ChatRoom, null, 4, null);
    }

    public final void f(@Nullable Context context, @NotNull final Function0<p> positiveCallback) {
        s.i(positiveCallback, "positiveCallback");
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null), R$string.want_see_other_profile_and_need_public_my_profile, 0, 2, null), R$string.publish_profile, null, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showPublicProfilePrompt$1
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

    public final void g(@Nullable Context context, @NotNull final Function0<p> positiveCallback) {
        s.i(positiveCallback, "positiveCallback");
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null), R$string.quit_match_remind, 0, 2, null), R$string.determine, null, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showQuitMatchPrompt$1
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
        }, 2, null), 0, null, 3, null), null, 1, null);
    }

    public final void h(@Nullable Context context, int i10, @NotNull final Function0<p> negativeCallback) {
        s.i(negativeCallback, "negativeCallback");
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).D(R$string.quit_chat_title), i10, 0, 2, null), R$string.continue_chat, null, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showQuitRoomPrompt$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GroupOthersLog.Y(GroupOthersLog.f18702a, "LEAVE_CHAT_ROOM", SensorPosition.ChatRoom.getValue(), PopupButtonName.Continue.getValue(), null, 8, null);
            }
        }, 2, null).q(R$string.confirm_exit, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showQuitRoomPrompt$2
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
                negativeCallback.invoke();
                GroupOthersLog.Y(GroupOthersLog.f18702a, "LEAVE_CHAT_ROOM", SensorPosition.ChatRoom.getValue(), PopupButtonName.ConfirmExit.getValue(), null, 8, null);
            }
        }), null, 1, null);
        GroupOthersLog.a0(GroupOthersLog.f18702a, "LEAVE_CHAT_ROOM", SensorPosition.ChatRoom.getValue(), null, 4, null);
    }

    public final void i(@Nullable Context context, @NotNull final SensorPosition position, @NotNull final Function0<p> positiveCallback) {
        s.i(position, "position");
        s.i(positiveCallback, "positiveCallback");
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null), R$string.quit_room_prompt, 0, 2, null), R$string.go_to_try, null, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showRecommendUseItemCardPrompt$1
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
                i.f50236a.a(PopupName.USE_PROP_CARD_RECOMMEND, PopupButtonName.TRY, position);
            }
        }, 2, null), 0, null, 3, null), null, 1, null);
        i.g(i.f50236a, PopupName.USE_PROP_CARD_RECOMMEND, position, null, 4, null);
    }

    public final void j(@Nullable Context context, @NotNull final SensorPosition position, @NotNull final Function0<p> positiveCallback) {
        s.i(position, "position");
        s.i(positiveCallback, "positiveCallback");
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).D(R$string.stop_match_prompt_title), R$string.stop_match_prompt_message, 0, 2, null), R$string.stop_match, null, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showStopMatchPrompt$1
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
                i.f50236a.a(PopupName.CONFIRM_STOP_MATCH, PopupButtonName.Stop, position);
            }
        }, 2, null).q(R$string.continue_matching, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showStopMatchPrompt$2
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
                i.f50236a.a(PopupName.CONFIRM_STOP_MATCH, PopupButtonName.Continue, SensorPosition.this);
            }
        }), null, 1, null);
        i.g(i.f50236a, PopupName.CONFIRM_STOP_MATCH, position, null, 4, null);
    }

    public final void k(@Nullable Context context, @NotNull final SensorPosition position, @NotNull final Function0<p> positiveCallback) {
        s.i(position, "position");
        s.i(positiveCallback, "positiveCallback");
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null), R$string.use_item_card_prompt, 0, 2, null), R$string.determine, null, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showUseItemCardPrompt$1
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
                i.f50236a.a(PopupName.START_MATCH_EXCHANGE, PopupButtonName.Confirm, position);
            }
        }, 2, null), 0, new Function0<p>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper$showUseItemCardPrompt$2
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
                i.f50236a.a(PopupName.START_MATCH_EXCHANGE, PopupButtonName.Cancel, SensorPosition.this);
            }
        }, 1, null), null, 1, null);
        i.g(i.f50236a, PopupName.START_MATCH_EXCHANGE, position, null, 4, null);
    }
}
