package com.cupidapp.live.base.grpc;

import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import java.util.ArrayList;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GrpcMessageRouter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GrpcMessageRouter {

    @NotNull
    public static final GrpcMessageRouter INSTANCE = new GrpcMessageRouter();

    @NotNull
    private static final ArrayList<IGrpcMessageListener> mIGrpcMessageListenerList = new ArrayList<>();

    private GrpcMessageRouter() {
    }

    public static /* synthetic */ void notifyGrpc$default(GrpcMessageRouter grpcMessageRouter, boolean z10, String str, Boolean bool, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            bool = null;
        }
        grpcMessageRouter.notifyGrpc(z10, str, bool);
    }

    public final void addIGrpcMessageListener(@NotNull IGrpcMessageListener listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        ArrayList<IGrpcMessageListener> arrayList = mIGrpcMessageListenerList;
        if (arrayList.contains(listener)) {
            return;
        }
        arrayList.add(listener);
    }

    public final void notifyGrpc(boolean z10, @Nullable String str, @Nullable Boolean bool) {
        EventBus.c().l(new InLiveShowHeartBeatEvent(z10, null, bool, str, 2, null));
    }

    public final void onDispatchGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        kotlin.jvm.internal.s.i(type, "type");
        kotlin.jvm.internal.s.i(model, "model");
        Iterator<IGrpcMessageListener> iterator2 = mIGrpcMessageListenerList.iterator2();
        kotlin.jvm.internal.s.h(iterator2, "mIGrpcMessageListenerList.iterator()");
        while (iterator2.hasNext()) {
            iterator2.next().onReceiveGrpcMessage(type, model);
        }
    }

    public final void removeIGrpcMessageListener(@NotNull IGrpcMessageListener listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        mIGrpcMessageListenerList.remove(listener);
    }
}
