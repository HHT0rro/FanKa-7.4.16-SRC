package com.cupidapp.live.flutter.interactive;

import android.app.Activity;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.flutter.api.FlutterNetWork;
import com.huawei.quickcard.base.Attributes;
import com.tencent.bugly.crashreport.CrashReport;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FlutterBasicCallNative.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FlutterBasicCallNative implements MethodChannel.MethodCallHandler {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f14659b = new a(null);

    /* compiled from: FlutterBasicCallNative.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable BinaryMessenger binaryMessenger, @NotNull String channelName) {
            s.i(channelName, "channelName");
            s.f(binaryMessenger);
            new MethodChannel(binaryMessenger, channelName).setMethodCallHandler(new FlutterBasicCallNative(null));
        }
    }

    public FlutterBasicCallNative() {
    }

    public /* synthetic */ FlutterBasicCallNative(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void a(String str, String str2) {
        CrashReport.postCatchedException(new UnknownError("flutter:" + str + "\n" + str2));
    }

    public final void b(Activity activity, String str, String str2) {
        if (s.d(str2, "Success")) {
            h.f12779a.d(activity, str);
        } else if (s.d(str2, "Warning")) {
            h.f12779a.s(activity, str);
        } else {
            h.f12779a.m(activity, str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x003d. Please report as an issue. */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NotNull MethodCall call, @NotNull final MethodChannel.Result result) {
        s.i(call, "call");
        s.i(result, "result");
        j.f12332a.a("flutter", "被调用了 " + call.method);
        WeakReference<Activity> a10 = com.cupidapp.live.base.activity.a.f11763c.a();
        Activity activity = a10 != null ? a10.get() : null;
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1913642710:
                    if (str.equals("showToast")) {
                        b(activity, (String) call.argument("text"), (String) call.argument("style"));
                        return;
                    }
                    break;
                case -270619340:
                    if (str.equals("reportError")) {
                        a((String) call.argument("exception"), (String) call.argument(Attributes.Component.STACK));
                        return;
                    }
                    break;
                case 193789659:
                    if (str.equals("urlHandler")) {
                        j.a.b(com.cupidapp.live.base.router.j.f12156c, activity, (String) call.argument("url"), null, 4, null);
                        return;
                    }
                    break;
                case 961246157:
                    if (str.equals("startRequest")) {
                        FlutterNetWork.f14654a.h(call, activity, new Function1<String, p>() { // from class: com.cupidapp.live.flutter.interactive.FlutterBasicCallNative$onMethodCall$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ p invoke(String str2) {
                                invoke2(str2);
                                return p.f51048a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull String data) {
                                s.i(data, "data");
                                MethodChannel.Result.this.success(data);
                            }
                        });
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }
}
