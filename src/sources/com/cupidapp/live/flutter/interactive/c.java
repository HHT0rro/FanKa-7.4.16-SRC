package com.cupidapp.live.flutter.interactive;

import com.cupidapp.live.flutter.model.RoamingTransModel;
import com.cupidapp.live.match.event.ChooseAreaResultEvent;
import com.cupidapp.live.match.model.RegionModel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FlutterRoamingCallNative.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c implements MethodChannel.MethodCallHandler {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14667c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final RoamingTransModel f14668b;

    /* compiled from: FlutterRoamingCallNative.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable BinaryMessenger binaryMessenger, @NotNull String channelName, @Nullable RoamingTransModel roamingTransModel) {
            s.i(channelName, "channelName");
            s.f(binaryMessenger);
            new MethodChannel(binaryMessenger, channelName).setMethodCallHandler(new c(roamingTransModel, null));
        }
    }

    public c(RoamingTransModel roamingTransModel) {
        this.f14668b = roamingTransModel;
    }

    public /* synthetic */ c(RoamingTransModel roamingTransModel, DefaultConstructorMarker defaultConstructorMarker) {
        this(roamingTransModel);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NotNull MethodCall call, @NotNull MethodChannel.Result result) {
        s.i(call, "call");
        s.i(result, "result");
        String str = call.method;
        if (s.d(str, "currentSelectCityName")) {
            RoamingTransModel roamingTransModel = this.f14668b;
            result.success(roamingTransModel != null ? roamingTransModel.getCityName() : null);
        } else {
            if (s.d(str, "selectCity")) {
                String str2 = (String) call.argument("code");
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = (String) call.argument("name");
                EventBus.c().o(new ChooseAreaResultEvent(new RegionModel(str2, str3 != null ? str3 : "", null)));
                return;
            }
            result.notImplemented();
        }
    }
}
