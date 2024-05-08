package com.cupidapp.live.push;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.cupidapp.live.base.grpc.ConnectorMessageEvent;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.grpc.DynamicGuideModel;
import com.cupidapp.live.chat.model.ChatConnectorMessage;
import com.cupidapp.live.chat.model.RefreshSessionLiveStatusGrpcModel;
import com.cupidapp.live.chat.util.SessionLocalListUtil;
import com.cupidapp.live.club.model.ClubNewMessageConnectorMessageModel;
import com.cupidapp.live.liveshow.model.FKHornType;
import com.cupidapp.live.liveshow.model.FKLiveBaseHornModel;
import com.cupidapp.live.liveshow.model.FollowAnchorModel;
import com.cupidapp.live.maskparty.model.MaskPartyRecommendModel;
import com.cupidapp.live.push.util.AppTopTipPopup;
import he.j;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKGRPCMessageWatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKGRPCMessageWatcher implements LifecycleObserver {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Context f17885b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final b f17886c;

    /* compiled from: FKGRPCMessageWatcher.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17887a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17888b;

        static {
            int[] iArr = new int[CuConnectorOuterClass.MessageType.values().length];
            try {
                iArr[CuConnectorOuterClass.MessageType.PushMessage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveHorn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchRecPopover.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.DynamicGuide.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.UnreadCountsUpdate.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.GroupMessageNew.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.RefreshSession.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f17887a = iArr;
            int[] iArr2 = new int[FKPushType.values().length];
            try {
                iArr2[FKPushType.MessageNewSnapText.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[FKPushType.MessageScreenCapture.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[FKPushType.MessageNewSnapPhoto.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[FKPushType.MessageNotice.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[FKPushType.InboxMessageNewFocus.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[FKPushType.InboxMessageNewIntimate.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[FKPushType.MessageNewSnapPhotoFocus.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[FKPushType.MessageNewSnapPhotoIntimate.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[FKPushType.InboxMessageNew.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            f17888b = iArr2;
        }
    }

    public FKGRPCMessageWatcher(@NotNull Context context, @NotNull b callback) {
        s.i(context, "context");
        s.i(callback, "callback");
        this.f17885b = context;
        this.f17886c = callback;
    }

    public final void a(@NotNull Lifecycle lifecycle) {
        s.i(lifecycle, "lifecycle");
        lifecycle.addObserver(this);
        EventBus.c().q(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        EventBus.c().t(this);
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ConnectorMessageEvent event) {
        s.i(event, "event");
        String body = event.getMessage().getBody();
        if (body == null || body.length() == 0) {
            return;
        }
        CuConnectorOuterClass.MessageType type = event.getMessage().getType();
        switch (type == null ? -1 : a.f17887a[type.ordinal()]) {
            case 1:
                if (event.getModel() instanceof FKPushModel) {
                    this.f17886c.e((FKPushModel) event.getModel());
                    return;
                }
                return;
            case 2:
                if ((event.getModel() instanceof FKLiveBaseHornModel) && ((FKLiveBaseHornModel) event.getModel()).getEntity().getType() == FKHornType.BigHornType.getHornType()) {
                    com.cupidapp.live.base.utils.j.f12332a.a("FKLiveHornLayout", "收到喇叭 " + ((FKLiveBaseHornModel) event.getModel()).getEntity().getType());
                    this.f17886c.f(((FKLiveBaseHornModel) event.getModel()).getEntity());
                    return;
                }
                return;
            case 3:
                if (event.getModel() instanceof MaskPartyRecommendModel) {
                    this.f17886c.d((MaskPartyRecommendModel) event.getModel());
                    return;
                }
                return;
            case 4:
                if (event.getModel() instanceof DynamicGuideModel) {
                    AppTopTipPopup.f17896a.h(((DynamicGuideModel) event.getModel()).getGuideInfo());
                    return;
                }
                return;
            case 5:
                if (event.getModel() instanceof FollowAnchorModel) {
                    this.f17886c.a((FollowAnchorModel) event.getModel());
                    return;
                }
                return;
            case 6:
                if (event.getModel() instanceof ClubNewMessageConnectorMessageModel) {
                    this.f17886c.c((ClubNewMessageConnectorMessageModel) event.getModel());
                    return;
                }
                return;
            case 7:
                if (event.getModel() instanceof RefreshSessionLiveStatusGrpcModel) {
                    SessionLocalListUtil.f13179a.g((RefreshSessionLiveStatusGrpcModel) event.getModel());
                    return;
                }
                return;
            default:
                return;
        }
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatConnectorMessage event) {
        s.i(event, "event");
        com.cupidapp.live.base.utils.j.f12332a.a("ChatConnectorMessage", " " + ((Object) event.getType()));
        switch (a.f17888b[event.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                SessionLocalListUtil.f13179a.c(this.f17885b, event.getSessionId());
                this.f17886c.b();
                return;
            default:
                return;
        }
    }
}
