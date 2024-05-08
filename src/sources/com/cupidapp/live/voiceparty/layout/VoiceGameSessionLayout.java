package com.cupidapp.live.voiceparty.layout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.maskparty.model.DicePoint;
import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout;
import com.cupidapp.live.voiceparty.model.VoicePartyBtnType;
import com.cupidapp.live.voiceparty.model.VoicePartyGameSessionModel;
import com.cupidapp.live.voiceparty.model.VoicePartyGameSessionType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: VoiceGameSessionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoiceGameSessionLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f19020b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f19021c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a f19022d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public VoicePartyGameSessionModel f19023e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f19024f;

    /* compiled from: VoiceGameSessionLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {

        /* compiled from: VoiceGameSessionLayout.kt */
        @d
        /* renamed from: com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class C0176a {
            public static void a(@NotNull a aVar, boolean z10) {
            }

            public static void b(@NotNull a aVar, @NotNull MaskPartyChatDiceModel model) {
                s.i(model, "model");
            }

            public static void c(@NotNull a aVar) {
            }
        }

        void a();

        void b(@NotNull VoicePartyGameSessionType voicePartyGameSessionType);

        void c(boolean z10);

        void d(@NotNull MaskPartyChatDiceModel maskPartyChatDiceModel);

        void e();
    }

    /* compiled from: VoiceGameSessionLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19025a;

        static {
            int[] iArr = new int[VoicePartyBtnType.values().length];
            try {
                iArr[VoicePartyBtnType.OTHER_INVITE_ME_AGREE_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VoicePartyBtnType.OTHER_INVITE_ME_FOR_LATE_NIGHT_ACCEPT_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VoicePartyBtnType.OTHER_INVITE_ME_FOR_LATE_NIGHT_REFUSE_BTN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VoicePartyBtnType.INVITED_FOLLOW_OTHER_AGREE_BTN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f19025a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceGameSessionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f19024f = new LinkedHashMap();
        this.f19020b = c.b(VoiceGameSessionLayout$mBtnCountDownTimer$2.INSTANCE);
        this.f19021c = c.b(VoiceGameSessionLayout$mShowCountDownTimer$2.INSTANCE);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i getMBtnCountDownTimer() {
        return (i) this.f19020b.getValue();
    }

    private final i getMShowCountDownTimer() {
        return (i) this.f19021c.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f19024f;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void d(@NotNull VoicePartyBtnType btnType, boolean z10) {
        TextView textView;
        s.i(btnType, "btnType");
        int i10 = b.f19025a[btnType.ordinal()];
        if (i10 == 1) {
            textView = (TextView) a(R$id.voice_game_session_action_btn);
        } else if (i10 == 2) {
            textView = (TextView) a(R$id.voice_late_night_accept_btn);
        } else if (i10 == 3) {
            textView = (TextView) a(R$id.voice_late_night_refuse_btn);
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            textView = (TextView) a(R$id.voice_game_session_action_btn);
        }
        textView.setVisibility(z10 ? 0 : 4);
    }

    public final void e(@NotNull VoicePartyGameSessionModel model) {
        s.i(model, "model");
        this.f19023e = model;
        if (model.getType() == VoicePartyGameSessionType.OTHER_INVITE_ME_FOR_LATE_NIGHT) {
            g(model);
        } else {
            f(model);
        }
    }

    public final void f(final VoicePartyGameSessionModel voicePartyGameSessionModel) {
        ((ConstraintLayout) a(R$id.voice_game_session_root_layout)).setVisibility(0);
        ((ConstraintLayout) a(R$id.voice_dice_root_layout)).setVisibility(8);
        ((ConstraintLayout) a(R$id.voice_late_night_root_layout)).setVisibility(8);
        getMBtnCountDownTimer().g();
        getMShowCountDownTimer().g();
        String title = voicePartyGameSessionModel.getTitle();
        if (title == null || title.length() == 0) {
            ((TextView) a(R$id.voice_game_session_title)).setVisibility(4);
        } else {
            int i10 = R$id.voice_game_session_title;
            ((TextView) a(i10)).setVisibility(0);
            ((TextView) a(i10)).setText(voicePartyGameSessionModel.getTitle());
        }
        String desc = voicePartyGameSessionModel.getDesc();
        if (desc == null || desc.length() == 0) {
            ((TextView) a(R$id.voice_game_session_desc)).setVisibility(4);
        } else {
            int i11 = R$id.voice_game_session_desc;
            ((TextView) a(i11)).setVisibility(0);
            ((TextView) a(i11)).setText(voicePartyGameSessionModel.getDesc());
        }
        if (voicePartyGameSessionModel.getBtnCountdownSec() > 0) {
            int i12 = R$id.voice_game_session_action_btn;
            TextView textView = (TextView) a(i12);
            if (voicePartyGameSessionModel.getType() == VoicePartyGameSessionType.INVITED_FOLLOW_OTHER) {
                textView.setTextColor(-13703535);
                textView.setBackgroundTintList(ColorStateList.valueOf(-13703535));
                textView.setBackgroundResource(R$mipmap.icon_voice_outline_btn);
            } else {
                textView.setTextColor(-16777216);
                textView.setBackgroundTintList(ColorStateList.valueOf(-1));
                textView.setBackgroundResource(R$mipmap.icon_voice_fill_btn);
            }
            ((TextView) a(i12)).setVisibility(0);
            ((TextView) a(i12)).setText(getContext().getString(R$string.agree_btn_has_countdown_sec, Integer.valueOf(voicePartyGameSessionModel.getBtnCountdownSec())));
            getMBtnCountDownTimer().c(Integer.valueOf(voicePartyGameSessionModel.getBtnCountdownSec()), 1, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout$configGameSessionLayout$2
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
                    VoiceGameSessionLayout.a aVar;
                    aVar = VoiceGameSessionLayout.this.f19022d;
                    if (aVar != null) {
                        aVar.e();
                    }
                }
            }, new Function1<Integer, p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout$configGameSessionLayout$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Integer num) {
                    invoke(num.intValue());
                    return p.f51048a;
                }

                public final void invoke(int i13) {
                    ((TextView) VoiceGameSessionLayout.this.a(R$id.voice_game_session_action_btn)).setText(VoiceGameSessionLayout.this.getContext().getString(R$string.agree_btn_has_countdown_sec, Integer.valueOf(i13)));
                }
            });
            TextView voice_game_session_action_btn = (TextView) a(i12);
            s.h(voice_game_session_action_btn, "voice_game_session_action_btn");
            y.d(voice_game_session_action_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout$configGameSessionLayout$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    i mBtnCountDownTimer;
                    VoiceGameSessionLayout.a aVar;
                    mBtnCountDownTimer = VoiceGameSessionLayout.this.getMBtnCountDownTimer();
                    mBtnCountDownTimer.g();
                    aVar = VoiceGameSessionLayout.this.f19022d;
                    if (aVar != null) {
                        aVar.b(voicePartyGameSessionModel.getType());
                    }
                }
            });
        } else {
            ((TextView) a(R$id.voice_game_session_action_btn)).setVisibility(8);
        }
        if (voicePartyGameSessionModel.getShowCountdownSec() > 0) {
            int i13 = R$id.voice_game_session_countdown;
            ((TextView) a(i13)).setVisibility(0);
            ((TextView) a(i13)).setText(getContext().getString(R$string.count_down_seconds, Integer.valueOf(voicePartyGameSessionModel.getShowCountdownSec())));
            getMShowCountDownTimer().c(Integer.valueOf(voicePartyGameSessionModel.getShowCountdownSec()), 1, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout$configGameSessionLayout$5
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
                    VoiceGameSessionLayout.a aVar;
                    aVar = VoiceGameSessionLayout.this.f19022d;
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            }, new Function1<Integer, p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout$configGameSessionLayout$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Integer num) {
                    invoke(num.intValue());
                    return p.f51048a;
                }

                public final void invoke(int i14) {
                    ((TextView) VoiceGameSessionLayout.this.a(R$id.voice_game_session_countdown)).setText(VoiceGameSessionLayout.this.getContext().getString(R$string.count_down_seconds, Integer.valueOf(i14)));
                }
            });
        } else {
            ((TextView) a(R$id.voice_game_session_countdown)).setVisibility(8);
        }
        ((Group) a(R$id.voice_game_session_love_bg)).setVisibility(voicePartyGameSessionModel.isShowVoiceGameBtn() ? 0 : 8);
    }

    public final void g(VoicePartyGameSessionModel voicePartyGameSessionModel) {
        ((ConstraintLayout) a(R$id.voice_late_night_root_layout)).setVisibility(0);
        ((ConstraintLayout) a(R$id.voice_game_session_root_layout)).setVisibility(8);
        ((ConstraintLayout) a(R$id.voice_dice_root_layout)).setVisibility(8);
        ((TextView) a(R$id.voice_late_night_desc)).setText(voicePartyGameSessionModel.getDesc());
        int i10 = R$id.voice_late_night_refuse_btn;
        ((TextView) a(i10)).setVisibility(0);
        TextView voice_late_night_refuse_btn = (TextView) a(i10);
        s.h(voice_late_night_refuse_btn, "voice_late_night_refuse_btn");
        y.d(voice_late_night_refuse_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout$configLateNightLayout$1
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
                VoiceGameSessionLayout.a aVar;
                aVar = VoiceGameSessionLayout.this.f19022d;
                if (aVar != null) {
                    aVar.c(false);
                }
            }
        });
        int i11 = R$id.voice_late_night_accept_btn;
        ((TextView) a(i11)).setVisibility(0);
        TextView voice_late_night_accept_btn = (TextView) a(i11);
        s.h(voice_late_night_accept_btn, "voice_late_night_accept_btn");
        y.d(voice_late_night_accept_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout$configLateNightLayout$2
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
                VoiceGameSessionLayout.a aVar;
                aVar = VoiceGameSessionLayout.this.f19022d;
                if (aVar != null) {
                    aVar.c(true);
                }
            }
        });
        ((TextView) a(R$id.voice_late_night_tip_text)).setText(voicePartyGameSessionModel.getTip());
    }

    public final void h(@NotNull final MaskPartyChatDiceModel model, @NotNull String targetUserName) {
        s.i(model, "model");
        s.i(targetUserName, "targetUserName");
        ((ConstraintLayout) a(R$id.voice_dice_root_layout)).setVisibility(0);
        ((ConstraintLayout) a(R$id.voice_game_session_root_layout)).setVisibility(8);
        ((ConstraintLayout) a(R$id.voice_late_night_root_layout)).setVisibility(8);
        ((ImageView) a(R$id.voice_left_dice_img)).setVisibility(8);
        int i10 = R$id.voice_left_dice_svga;
        ((FKSVGAImageView) a(i10)).setVisibility(0);
        FKSVGAImageView voice_left_dice_svga = (FKSVGAImageView) a(i10);
        s.h(voice_left_dice_svga, "voice_left_dice_svga");
        FKSVGAImageView.F(voice_left_dice_svga, "play_dice.svga", null, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout$configRollDiceData$1
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
                ((FKSVGAImageView) VoiceGameSessionLayout.this.a(R$id.voice_left_dice_svga)).setVisibility(4);
                VoiceGameSessionLayout voiceGameSessionLayout = VoiceGameSessionLayout.this;
                int i11 = R$id.voice_left_dice_img;
                ((ImageView) voiceGameSessionLayout.a(i11)).setVisibility(0);
                DicePoint a10 = DicePoint.Companion.a(model.getTargetDiceNum());
                if (a10 != null) {
                    ((ImageView) VoiceGameSessionLayout.this.a(i11)).setImageResource(a10.getIcon());
                }
            }
        }, 2, null);
        ((TextView) a(R$id.voice_left_dice_user_name)).setText(targetUserName);
        ((ImageView) a(R$id.voice_right_dice_img)).setVisibility(8);
        int i11 = R$id.voice_right_dice_svga;
        ((FKSVGAImageView) a(i11)).setVisibility(0);
        FKSVGAImageView voice_right_dice_svga = (FKSVGAImageView) a(i11);
        s.h(voice_right_dice_svga, "voice_right_dice_svga");
        FKSVGAImageView.F(voice_right_dice_svga, "play_dice.svga", null, new VoiceGameSessionLayout$configRollDiceData$2(this, model), 2, null);
    }

    public final void i() {
        z.a(this, R$layout.layout_voice_game_session, true);
    }

    public final void j() {
        getMBtnCountDownTimer().g();
        getMShowCountDownTimer().g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int i10) {
        s.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, i10);
        if (i10 != 0) {
            VoicePartyGameSessionModel voicePartyGameSessionModel = this.f19023e;
            if ((voicePartyGameSessionModel != null ? voicePartyGameSessionModel.getType() : null) == VoicePartyGameSessionType.INVITED_FOLLOW_OTHER) {
                j();
            }
        }
    }

    public final void setVoiceGameSessionListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f19022d = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceGameSessionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f19024f = new LinkedHashMap();
        this.f19020b = c.b(VoiceGameSessionLayout$mBtnCountDownTimer$2.INSTANCE);
        this.f19021c = c.b(VoiceGameSessionLayout$mShowCountDownTimer$2.INSTANCE);
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceGameSessionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f19024f = new LinkedHashMap();
        this.f19020b = c.b(VoiceGameSessionLayout$mBtnCountDownTimer$2.INSTANCE);
        this.f19021c = c.b(VoiceGameSessionLayout$mShowCountDownTimer$2.INSTANCE);
        i();
    }
}
