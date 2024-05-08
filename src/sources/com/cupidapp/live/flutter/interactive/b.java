package com.cupidapp.live.flutter.interactive;

import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.flutter.model.BaseTransModel;
import com.cupidapp.live.flutter.model.PageChannel;
import com.cupidapp.live.flutter.model.RoamingTransModel;
import io.flutter.plugin.common.BinaryMessenger;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FlutterPageCallNativeUtil.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f14666a = new b();

    public final void a(@Nullable BinaryMessenger binaryMessenger, @Nullable String str, @Nullable BaseTransModel baseTransModel, @Nullable FKBaseActivity fKBaseActivity) {
        FlutterBasicCallNative.f14659b.a(binaryMessenger, PageChannel.ALL_NEED_CHANNEL_NAME.getValue());
        if (str == null) {
            return;
        }
        if (s.d(str, PageChannel.Roaming.getValue())) {
            c.f14667c.a(binaryMessenger, str, (RoamingTransModel) baseTransModel);
        } else if (s.d(str, PageChannel.MediaChannel.getValue())) {
            FlutterMediaCallNative.f14660f.a(binaryMessenger, str, fKBaseActivity);
        }
    }
}
