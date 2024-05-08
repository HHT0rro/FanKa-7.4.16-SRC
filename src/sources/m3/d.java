package m3;

import android.content.Context;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.push.FKPushTunnel;
import com.cupidapp.live.push.model.FKPushTokenModel;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.listener.IPushQueryActionListener;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: VivoPushHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f51803a = new d();

    /* compiled from: VivoPushHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements IPushQueryActionListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<String, p> f51804a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super String, p> function1) {
            this.f51804a = function1;
        }

        @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onFail(@Nullable Integer num) {
            j.f12332a.a("PushMessage", "vivo getRegId onFail errorCode:" + ((Object) num));
        }

        @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            j.f12332a.a("PushMessage", "vivo getRegId onSuccess RegId:" + str);
            this.f51804a.invoke(str);
        }
    }

    public static final void h(Context context, Function1 successCallback, int i10) {
        s.i(context, "$context");
        s.i(successCallback, "$successCallback");
        j.f12332a.a("PushMessage", "vivo  开关状态处理，0代表成功  state:" + i10);
        if (i10 == 0) {
            f51803a.d(context, successCallback);
        }
    }

    public static final void j(int i10) {
        j.f12332a.a("PushMessage", "vivo turnOffPush 开关状态处理，0代表成功  state:" + i10);
    }

    public static final void k(int i10) {
        j.f12332a.a("PushMessage", "vivo turnOnPush 开关状态处理，0代表成功  state:" + i10);
    }

    public final void d(Context context, Function1<? super String, p> function1) {
        PushClient.getInstance(context).getRegId(new a(function1));
    }

    public final void e(@NotNull Context context) {
        s.i(context, "context");
        PushClient.getInstance(context).initialize(new PushConfig.Builder().agreePrivacyStatement(true).build());
    }

    public final boolean f(@NotNull Context context) {
        s.i(context, "context");
        return PushClient.getInstance(context).isSupport();
    }

    public final void g(@NotNull final Context context, @NotNull final Function1<? super String, p> successCallback) {
        s.i(context, "context");
        s.i(successCallback, "successCallback");
        PushClient.getInstance(context).turnOnPush(new IPushActionListener() { // from class: m3.a
            @Override // com.vivo.push.IPushActionListener
            public final void onStateChanged(int i10) {
                d.h(context, successCallback, i10);
            }
        });
    }

    public final void i(@NotNull Context context, boolean z10) {
        s.i(context, "context");
        FKPushTokenModel L0 = g.f52734a.L0();
        if (s.d(L0 != null ? L0.getType() : null, FKPushTunnel.Vivo.getType())) {
            if (z10) {
                PushClient.getInstance(context).turnOffPush(new IPushActionListener() { // from class: m3.b
                    @Override // com.vivo.push.IPushActionListener
                    public final void onStateChanged(int i10) {
                        d.j(i10);
                    }
                });
            } else {
                PushClient.getInstance(context).turnOnPush(new IPushActionListener() { // from class: m3.c
                    @Override // com.vivo.push.IPushActionListener
                    public final void onStateChanged(int i10) {
                        d.k(i10);
                    }
                });
            }
        }
    }
}
