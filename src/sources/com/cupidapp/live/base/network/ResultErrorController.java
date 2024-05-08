package com.cupidapp.live.base.network;

import android.app.Activity;
import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.event.InvalidEvent;
import com.cupidapp.live.base.network.event.JumpToWebEvent;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.TrackAppErrorType;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.web.activity.FKBaseWebActivity;
import com.cupidapp.live.profile.model.User;
import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

/* compiled from: ResultErrorHandler.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ResultErrorController {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f11894a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Map<Integer, Function1<String, p>> f11895b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final Function0<p> f11896c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final ErrorMessageHandler f11897d;

    /* compiled from: ResultErrorHandler.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ErrorMessageHandler {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final Function1<ResultException, p> f11898a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final Function1<ResultException, p> f11899b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public final Function1<ResultException, p> f11900c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public final Map<String, Function1<ResultException, p>> f11901d;

        public ErrorMessageHandler(@Nullable final Context context) {
            Function1<ResultException, p> function1 = new Function1<ResultException, p>() { // from class: com.cupidapp.live.base.network.ResultErrorController$ErrorMessageHandler$alertHandler$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(ResultException resultException) {
                    invoke2(resultException);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable ResultException resultException) {
                    Context context2 = context;
                    if (context2 == null) {
                        WeakReference<Activity> a10 = com.cupidapp.live.base.activity.a.f11763c.a();
                        Activity activity = a10 != null ? a10.get() : null;
                        if (activity == null) {
                            com.cupidapp.live.base.view.h.f12779a.t(resultException != null ? resultException.getErrorMessage() : null);
                            return;
                        } else {
                            this.c(activity, resultException);
                            return;
                        }
                    }
                    this.c(context2, resultException);
                }
            };
            this.f11898a = function1;
            ResultErrorController$ErrorMessageHandler$jumpHandler$1 resultErrorController$ErrorMessageHandler$jumpHandler$1 = new Function1<ResultException, p>() { // from class: com.cupidapp.live.base.network.ResultErrorController$ErrorMessageHandler$jumpHandler$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(ResultException resultException) {
                    invoke2(resultException);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable ResultException resultException) {
                    EventBus.c().o(new JumpToWebEvent(resultException != null ? resultException.getJumpUrl() : null, false, 2, null));
                }
            };
            this.f11899b = resultErrorController$ErrorMessageHandler$jumpHandler$1;
            ResultErrorController$ErrorMessageHandler$toastHandler$1 resultErrorController$ErrorMessageHandler$toastHandler$1 = new Function1<ResultException, p>() { // from class: com.cupidapp.live.base.network.ResultErrorController$ErrorMessageHandler$toastHandler$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(ResultException resultException) {
                    invoke2(resultException);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable ResultException resultException) {
                    com.cupidapp.live.base.view.h.f12779a.t(resultException != null ? resultException.getErrorMessage() : null);
                }
            };
            this.f11900c = resultErrorController$ErrorMessageHandler$toastHandler$1;
            this.f11901d = i0.h(kotlin.f.a(ResultShowErrorStyle.ALERT.getValue(), function1), kotlin.f.a(ResultShowErrorStyle.JUMP.getValue(), resultErrorController$ErrorMessageHandler$jumpHandler$1), kotlin.f.a(ResultShowErrorStyle.TOAST.getValue(), resultErrorController$ErrorMessageHandler$toastHandler$1));
        }

        @NotNull
        public final Map<String, Function1<ResultException, p>> b() {
            return this.f11901d;
        }

        public final void c(final Context context, final ResultException resultException) {
            if (context == null || resultException == null) {
                return;
            }
            String jumpUrl = resultException.getJumpUrl();
            if (jumpUrl == null || jumpUrl.length() == 0) {
                FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).n(resultException.getErrorMessage()), R$string.all_right, null, null, 6, null), null, 1, null);
                return;
            }
            String buttonName = resultException.getButtonName();
            String string = buttonName == null || buttonName.length() == 0 ? context.getString(2131886528) : resultException.getButtonName();
            s.h(string, "if (t.buttonName.isNullO…onfirm) else t.buttonName");
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.y(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).n(resultException.getErrorMessage()), string, null, new Function0<p>() { // from class: com.cupidapp.live.base.network.ResultErrorController$ErrorMessageHandler$showErrorDialog$1
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
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, context, resultException.getJumpUrl(), null, 4, null);
                }
            }, 2, null), 0, null, 3, null), null, 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResultErrorController(@Nullable Context context, @Nullable Map<Integer, ? extends Function1<? super String, p>> map, @Nullable Function0<p> function0) {
        this.f11894a = context;
        this.f11895b = map;
        this.f11896c = function0;
        this.f11897d = new ErrorMessageHandler(context);
    }

    public final boolean a(ResultException resultException) {
        Function1<String, p> function1;
        Map<Integer, Function1<String, p>> map = this.f11895b;
        if (map == null || (function1 = map.get(resultException.getErrorCode())) == null) {
            return false;
        }
        function1.invoke(resultException.getErrorMessage());
        return true;
    }

    public final void b(@Nullable Throwable th) {
        com.cupidapp.live.base.utils.j.f12332a.d(j.class.getSimpleName(), "error", th);
        if (th instanceof ResultException) {
            e((ResultException) th);
        } else {
            d(th);
        }
    }

    public final boolean c(ResultException resultException) {
        Integer errorCode = resultException.getErrorCode();
        int value = RequestErrorCode.AuthFail.getValue();
        if (errorCode != null && errorCode.intValue() == value) {
            String t2 = a.f11902a.t();
            p1.g gVar = p1.g.f52734a;
            User X = gVar.X();
            String userId = X != null ? X.userId() : null;
            j1.f.f50231a.a(TrackAppErrorType.TICKET_INVALID, "userId=" + t2 + "  LocalUserId=" + userId + "  ticket=" + gVar.G1() + "  errorMessage=" + resultException.getErrorMessage());
            EventBus.c().l(new InvalidEvent());
            if (resultException.getErrorMessage() != null) {
                com.cupidapp.live.base.view.h.f12779a.t(resultException.getErrorMessage());
            }
            return true;
        }
        Integer errorCode2 = resultException.getErrorCode();
        int value2 = RequestErrorCode.JumpToNoCloseWeb.getValue();
        if (errorCode2 == null || errorCode2.intValue() != value2) {
            return false;
        }
        FKBaseWebActivity.a aVar = FKBaseWebActivity.f13036s;
        if (aVar.a()) {
            EventBus.c().o(new JumpToWebEvent(resultException.getJumpUrl(), false));
            aVar.b(false);
        }
        return true;
    }

    public final void d(Throwable th) {
        Function0<p> function0 = this.f11896c;
        if (function0 != null) {
            function0.invoke();
        }
        if (th instanceof HttpException ? true : th instanceof ConnectException ? true : th instanceof TimeoutException ? true : th instanceof NoRouteToHostException ? true : th instanceof SocketTimeoutException) {
            if (this.f11896c == null) {
                com.cupidapp.live.base.view.h.f12779a.q(R$string.network_error);
            }
        } else if (th instanceof UnknownHostException) {
            com.cupidapp.live.base.view.h.f12779a.q(R$string.no_network_tip);
            NetworkClient.f11868a.R();
        } else if (this.f11896c == null) {
            com.cupidapp.live.base.view.h.f12779a.q(R$string.network_error);
        }
        com.cupidapp.live.base.utils.j.f12332a.f("network error ==", (th != null ? th.getMessage() : null));
    }

    public final void e(ResultException resultException) {
        Function1<ResultException, p> function1;
        if (c(resultException) || a(resultException) || (function1 = this.f11897d.b().get(resultException.getStyle())) == null) {
            return;
        }
        function1.invoke(resultException);
    }
}
