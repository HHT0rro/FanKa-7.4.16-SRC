package com.cupidapp.live.base.grpc;

import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.Status;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.Nullable;

/* compiled from: GrpcIMBase.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GrpcIMBase$callListener$1 extends ClientCall.Listener<CuConnectorOuterClass.ConnectorMessage> {
    public final /* synthetic */ GrpcIMBase this$0;

    public GrpcIMBase$callListener$1(GrpcIMBase grpcIMBase) {
        this.this$0 = grpcIMBase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClose$lambda$1(GrpcIMBase this$0, Status status, Metadata metadata) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (this$0.getGrpcIsConnecting()) {
            EventBus.c().l(new GrpcConnectEvent(false));
        }
        this$0.setGrpcIsConnecting(false);
        this$0.connectorClosed(status, metadata);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessage$lambda$2(GrpcIMBase this$0, CuConnectorOuterClass.ConnectorMessage connectorMessage) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (!this$0.getGrpcIsConnecting()) {
            EventBus.c().l(new GrpcConnectEvent(true));
        }
        this$0.setGrpcIsConnecting(true);
        this$0.connectorReceived(connectorMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReady$lambda$0(GrpcIMBase this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.connectorReady();
    }

    @Override // io.grpc.ClientCall.Listener
    public void onClose(@Nullable final Status status, @Nullable final Metadata metadata) {
        final GrpcIMBase grpcIMBase = this.this$0;
        GrpcIMBase.runInWorkThread$default(grpcIMBase, new Runnable() { // from class: com.cupidapp.live.base.grpc.t
            @Override // java.lang.Runnable
            public final void run() {
                GrpcIMBase$callListener$1.onClose$lambda$1(GrpcIMBase.this, status, metadata);
            }
        }, 0L, 2, null);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onReady() {
        final GrpcIMBase grpcIMBase = this.this$0;
        GrpcIMBase.runInWorkThread$default(grpcIMBase, new Runnable() { // from class: com.cupidapp.live.base.grpc.r
            @Override // java.lang.Runnable
            public final void run() {
                GrpcIMBase$callListener$1.onReady$lambda$0(GrpcIMBase.this);
            }
        }, 0L, 2, null);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onMessage(@Nullable final CuConnectorOuterClass.ConnectorMessage connectorMessage) {
        final GrpcIMBase grpcIMBase = this.this$0;
        GrpcIMBase.runInWorkThread$default(grpcIMBase, new Runnable() { // from class: com.cupidapp.live.base.grpc.s
            @Override // java.lang.Runnable
            public final void run() {
                GrpcIMBase$callListener$1.onMessage$lambda$2(GrpcIMBase.this, connectorMessage);
            }
        }, 0L, 2, null);
    }
}
