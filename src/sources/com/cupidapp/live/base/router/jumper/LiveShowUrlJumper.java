package com.cupidapp.live.base.router.jumper;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.beauty.view.ShowStickerEvent;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.OpenLiveGiftEvent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveShowUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowUrlJumper implements com.cupidapp.live.base.router.h {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public FKWebView f12160b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Activity f12161c;

    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return;
        }
        this.f12161c = activity;
        this.f12160b = (FKWebView) activity.findViewById(R$id.appWebView);
        String path = uri.getPath();
        String A = path != null ? kotlin.text.p.A(path, "/", "", false, 4, null) : null;
        if (A != null) {
            switch (A.hashCode()) {
                case -1890252483:
                    if (A.equals("sticker")) {
                        EventBus.c().l(new ShowStickerEvent(uri.getQueryParameter("resourcePath")));
                        return;
                    }
                    return;
                case -1220535902:
                    if (A.equals("autoLightUp")) {
                        EventBus.c().l(new ShowAutoLightUpDialogEvent());
                        return;
                    }
                    return;
                case -505033062:
                    if (A.equals("openGift")) {
                        EventBus.c().l(new OpenLiveGiftEvent(null, null, null, 7, null));
                        return;
                    }
                    return;
                case 109400031:
                    if (A.equals("share")) {
                        EventBus.c().l(new ShareLiveShowEvent());
                        return;
                    }
                    return;
                case 1164567403:
                    if (A.equals("exitFanClub")) {
                        EventBus.c().l(new ExitFanClubEvent());
                        return;
                    }
                    return;
                case 1247062232:
                    if (A.equals("sendGift")) {
                        String queryParameter = uri.getQueryParameter("giftId");
                        String queryParameter2 = uri.getQueryParameter("count");
                        Integer valueOf = queryParameter2 != null ? Integer.valueOf(z0.t.q(queryParameter2)) : null;
                        final String queryParameter3 = uri.getQueryParameter("callback");
                        if (queryParameter == null || valueOf == null || !(context instanceof FKLiveForViewerActivity)) {
                            return;
                        }
                        ((FKLiveForViewerActivity) context).a2(queryParameter, valueOf.intValue(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.LiveShowUrlJumper$jump$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                                invoke2();
                                return kotlin.p.f51048a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                FKWebView fKWebView;
                                ConstantsUrlModel urlModel;
                                fKWebView = LiveShowUrlJumper.this.f12160b;
                                if (fKWebView != null) {
                                    ConstantsResult q10 = p1.g.f52734a.q();
                                    fKWebView.u((q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getUrlPurchasePay());
                                }
                            }
                        }, new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.LiveShowUrlJumper$jump$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return kotlin.p.f51048a;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
                            
                                r3 = r2.this$0.f12160b;
                             */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public final void invoke(boolean r3) {
                                /*
                                    r2 = this;
                                    if (r3 == 0) goto L21
                                    com.cupidapp.live.base.router.jumper.LiveShowUrlJumper r3 = com.cupidapp.live.base.router.jumper.LiveShowUrlJumper.this
                                    com.cupidapp.live.base.web.FKWebView r3 = com.cupidapp.live.base.router.jumper.LiveShowUrlJumper.b(r3)
                                    if (r3 == 0) goto L21
                                    java.lang.String r0 = r2
                                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                    r1.<init>()
                                    r1.append(r0)
                                    java.lang.String r0 = "()"
                                    r1.append(r0)
                                    java.lang.String r0 = r1.toString()
                                    r1 = 0
                                    r3.evaluateJavascript(r0, r1)
                                L21:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.router.jumper.LiveShowUrlJumper$jump$2.invoke(boolean):void");
                            }
                        });
                        return;
                    }
                    return;
                case 1585646268:
                    if (A.equals("close-popups")) {
                        EventBus.c().l(new ClosePopupsEvent());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
