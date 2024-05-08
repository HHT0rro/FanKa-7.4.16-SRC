package com.cupidapp.live.push;

import android.content.Context;
import android.content.Intent;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.chat.model.ChatConnectorMessage;
import com.cupidapp.live.chat.model.ChatReadConnectorMessage;
import com.cupidapp.live.main.event.RefreshAllTabUnreadCountEvent;
import com.cupidapp.live.match.event.FKMatchUserNotifyEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.push.model.FKPushTokenModel;
import com.cupidapp.live.push.util.PushExtraData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import x2.a;

/* compiled from: FKPushModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKPushModel implements Serializable {

    @Nullable
    private final Boolean guide;

    @NotNull
    private final FKPushMessageModel pushMessageModel;

    /* compiled from: FKPushModel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17889a;

        static {
            int[] iArr = new int[FKPushType.values().length];
            try {
                iArr[FKPushType.NewMatch.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FKPushType.PostAt.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FKPushType.PostCommentAt.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FKPushType.PostCommentAtFocus.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FKPushType.PostCommentAtIntimate.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FKPushType.PostAtFocus.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FKPushType.PostAtIntimate.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FKPushType.NewIntimate.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FKPushType.PostComment.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FKPushType.PostCommentFocus.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[FKPushType.PostCommentIntimate.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[FKPushType.Aloha.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[FKPushType.PostTag.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[FKPushType.PostLike.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[FKPushType.PostLikeIntimate.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[FKPushType.PostLikeFocus.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[FKPushType.PostPublish.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[FKPushType.PostPublishFocus.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[FKPushType.PostPublishIntimate.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[FKPushType.PostCommentLike.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[FKPushType.RainbowComment.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[FKPushType.RainbowCommentLike.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[FKPushType.MessageCancel.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[FKPushType.MessageDestory.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[FKPushType.MessageNewSnapText.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[FKPushType.MessageScreenCapture.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[FKPushType.MessageNewSnapPhoto.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[FKPushType.MessageNewSnapPhotoFocus.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[FKPushType.MessageNewSnapPhotoIntimate.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[FKPushType.MessageNotice.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[FKPushType.InboxMessageNewFocus.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[FKPushType.InboxMessageNewIntimate.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[FKPushType.InboxMessageNew.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[FKPushType.MessageRead.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            f17889a = iArr;
        }
    }

    public FKPushModel(@NotNull FKPushMessageModel pushMessageModel, @Nullable Boolean bool) {
        s.i(pushMessageModel, "pushMessageModel");
        this.pushMessageModel = pushMessageModel;
        this.guide = bool;
    }

    private final void chatConnectMessage() {
        PushExtraData a10 = com.cupidapp.live.push.util.b.a(this.pushMessageModel.getData());
        String sessionId = a10 != null ? a10.getSessionId() : null;
        if (sessionId == null || sessionId.length() == 0) {
            return;
        }
        String messageId = a10 != null ? a10.getMessageId() : null;
        if (messageId == null || messageId.length() == 0) {
            return;
        }
        EventBus c4 = EventBus.c();
        FKPushType pushType = this.pushMessageModel.getPushType();
        s.f(a10);
        String sessionId2 = a10.getSessionId();
        s.f(sessionId2);
        String messageId2 = a10.getMessageId();
        s.f(messageId2);
        c4.l(new ChatConnectorMessage(pushType, sessionId2, messageId2));
    }

    private final boolean showNotification() {
        if (AppApplication.f11612d.g()) {
            FKPushTokenModel L0 = g.f52734a.L0();
            if (!s.d(L0 != null ? L0.getType() : null, FKPushTunnel.Vivo.getType())) {
                return true;
            }
        } else {
            g gVar = g.f52734a;
            FKPushTokenModel L02 = gVar.L0();
            if (!s.d(L02 != null ? L02.getType() : null, FKPushTunnel.Huawei.getType())) {
                FKPushTokenModel L03 = gVar.L0();
                if (!s.d(L03 != null ? L03.getType() : null, FKPushTunnel.Xiaomi.getType())) {
                    FKPushTokenModel L04 = gVar.L0();
                    if (!s.d(L04 != null ? L04.getType() : null, FKPushTunnel.Vivo.getType())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final void triggerPush(Context context, boolean z10) {
        if (this.pushMessageModel.getUrl() == null) {
            return;
        }
        switch (a.f17889a[this.pushMessageModel.getPushType().ordinal()]) {
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 31:
            case 32:
            case 33:
                PushExtraData a10 = com.cupidapp.live.push.util.b.a(this.pushMessageModel.getData());
                String sessionId = a10 != null ? a10.getSessionId() : null;
                if (!(sessionId == null || sessionId.length() == 0)) {
                    String messageId = a10 != null ? a10.getMessageId() : null;
                    if (!(messageId == null || messageId.length() == 0)) {
                        Intent intent = new Intent(FKPushType.InboxMessageNew.getType());
                        intent.putExtra("notification.sessionId", a10 != null ? a10.getSessionId() : null);
                        intent.putExtra("notification.messageId", a10 != null ? a10.getMessageId() : null);
                        context.sendBroadcast(intent);
                        break;
                    }
                }
                break;
        }
        if (z10) {
            d.f17892a.k(context, this.pushMessageModel);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applicationActiveAction(@NotNull Context context) {
        String userId;
        s.i(context, "context");
        switch (a.f17889a[this.pushMessageModel.getPushType().ordinal()]) {
            case 1:
                if (d.f17892a.f()) {
                    return;
                }
                final PushExtraData a10 = com.cupidapp.live.push.util.b.a(this.pushMessageModel.getData());
                j.f12332a.f("NewMatch", " pushInfo == " + (a10 != null ? a10.getUserId() : null));
                if (a10 != null && (userId = a10.getUserId()) != null) {
                    Observable z10 = a.C0836a.z(NetworkClient.f11868a.N(), userId, null, null, false, null, 30, null);
                    com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
                    Disposable disposed = z10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.push.FKPushModel$applicationActiveAction$lambda$1$$inlined$handleByContext$default$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                            m2777invoke(profileResult);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2777invoke(ProfileResult profileResult) {
                            ProfileResult profileResult2 = profileResult;
                            j.f12332a.f("NewMatch", " user == " + ((Object) profileResult2.getUser()));
                            EventBus c4 = EventBus.c();
                            User user = profileResult2.getUser();
                            Boolean initiativeMatch = PushExtraData.this.getInitiativeMatch();
                            c4.l(new FKMatchUserNotifyEvent(user, initiativeMatch != null ? initiativeMatch.booleanValue() : false, this.getGuide()));
                        }
                    }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                        if (gVar != null) {
                            gVar.H(disposed);
                        }
                    }
                    s.h(disposed, "disposed");
                }
                EventBus.c().l(new RefreshAllTabUnreadCountEvent());
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                EventBus.c().l(new RefreshAllTabUnreadCountEvent());
                break;
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
                chatConnectMessage();
                break;
            case 34:
                PushExtraData a11 = com.cupidapp.live.push.util.b.a(this.pushMessageModel.getData());
                String sessionId = a11 != null ? a11.getSessionId() : null;
                if (!(sessionId == null || sessionId.length() == 0)) {
                    List<String> messageIds = a11 != null ? a11.getMessageIds() : null;
                    if (!(messageIds == null || messageIds.isEmpty())) {
                        EventBus c4 = EventBus.c();
                        s.f(a11);
                        String sessionId2 = a11.getSessionId();
                        s.f(sessionId2);
                        List<String> messageIds2 = a11.getMessageIds();
                        s.f(messageIds2);
                        c4.l(new ChatReadConnectorMessage(sessionId2, messageIds2));
                        break;
                    }
                }
                break;
        }
        triggerPush(context, showNotification());
    }

    public void applicationNotActiveAction(@NotNull Context context) {
        s.i(context, "context");
        triggerPush(context, showNotification());
    }

    @Nullable
    public final Boolean getGuide() {
        return this.guide;
    }

    @NotNull
    public final FKPushMessageModel getPushMessageModel() {
        return this.pushMessageModel;
    }

    public /* synthetic */ FKPushModel(FKPushMessageModel fKPushMessageModel, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(fKPushMessageModel, (i10 & 2) != 0 ? Boolean.FALSE : bool);
    }
}
