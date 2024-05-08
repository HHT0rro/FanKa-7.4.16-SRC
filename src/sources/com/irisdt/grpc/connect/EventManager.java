package com.irisdt.grpc.connect;

import com.irisdt.Irisdt;
import com.irisdt.StatConfig;
import com.irisdt.event.CustomEventProtos;
import com.irisdt.util.NamedRunnable;
import com.irisdt.util.ThreadManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class EventManager extends BaseManager<CustomEventProtos.Request> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class EventRunnable extends NamedRunnable {
        private CustomEventProtos.Requests requests;

        public EventRunnable(CustomEventProtos.Requests requests) {
            super(StatConfig.getThreadName("event"));
            this.requests = requests;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        @Override // com.irisdt.util.NamedRunnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void execute() {
            /*
                r13 = this;
                boolean r0 = com.irisdt.StatConfig.isEventLogEnable()
                r1 = 1
                r2 = 2
                r3 = 0
                if (r0 == 0) goto L1a
                com.irisdt.util.Logger r0 = com.irisdt.StatConfig.log()
                java.lang.Object[] r4 = new java.lang.Object[r2]
                java.lang.String r5 = "EVENT start-request \n"
                r4[r3] = r5
                com.irisdt.event.CustomEventProtos$Requests r5 = r13.requests
                r4[r1] = r5
                r0.i(r4)
            L1a:
                io.grpc.Channel r0 = com.irisdt.grpc.ConnectManager.getChannel()
                com.irisdt.event.ReportServiceGrpc$ReportServiceBlockingStub r0 = com.irisdt.event.ReportServiceGrpc.newBlockingStub(r0)
                io.grpc.stub.AbstractStub r0 = com.irisdt.grpc.ConnectManager.attachHeaders(r0)
                com.irisdt.event.ReportServiceGrpc$ReportServiceBlockingStub r0 = (com.irisdt.event.ReportServiceGrpc.ReportServiceBlockingStub) r0
                java.lang.String r4 = "gzip"
                io.grpc.stub.AbstractStub r0 = r0.withCompression(r4)
                com.irisdt.event.ReportServiceGrpc$ReportServiceBlockingStub r0 = (com.irisdt.event.ReportServiceGrpc.ReportServiceBlockingStub) r0
                r4 = 30
                java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS
                io.grpc.stub.AbstractStub r0 = r0.withDeadlineAfter(r4, r6)
                com.irisdt.event.ReportServiceGrpc$ReportServiceBlockingStub r0 = (com.irisdt.event.ReportServiceGrpc.ReportServiceBlockingStub) r0
                long r4 = android.os.SystemClock.uptimeMillis()
                r6 = 0
                com.irisdt.event.CustomEventProtos$Requests r7 = r13.requests     // Catch: java.lang.Throwable -> L52
                com.irisdt.event.CustomEventProtos$Response r0 = r0.batchReport(r7)     // Catch: java.lang.Throwable -> L52
                if (r0 == 0) goto L4e
                int r7 = r0.getCode()     // Catch: java.lang.Throwable -> L4c
                goto L4f
            L4c:
                r6 = move-exception
                goto L56
            L4e:
                r7 = 0
            L4f:
                r11 = r6
                r10 = r7
                goto L61
            L52:
                r0 = move-exception
                r12 = r6
                r6 = r0
                r0 = r12
            L56:
                boolean r7 = com.irisdt.StatConfig.isEventLogEnable()
                if (r7 == 0) goto L5f
                r6.printStackTrace()
            L5f:
                r11 = r6
                r10 = 0
            L61:
                long r6 = android.os.SystemClock.uptimeMillis()
                long r4 = r6 - r4
                com.irisdt.grpc.connect.PerfManager r6 = com.irisdt.grpc.connect.PerfManager.getInstance()
                com.irisdt.perf.PerfProtos$Type r7 = com.irisdt.perf.PerfProtos.Type.CUSTOM_EVENT
                r8 = r4
                r6.addPref(r7, r8, r10, r11)
                boolean r6 = com.irisdt.StatConfig.isEventLogEnable()
                if (r6 == 0) goto L92
                com.irisdt.util.Logger r6 = com.irisdt.StatConfig.log()
                r7 = 4
                java.lang.Object[] r7 = new java.lang.Object[r7]
                java.lang.String r8 = "EVENT "
                r7[r3] = r8
                java.lang.Long r3 = java.lang.Long.valueOf(r4)
                r7[r1] = r3
                java.lang.String r1 = ", "
                r7[r2] = r1
                r1 = 3
                r7[r1] = r0
                r6.i(r7)
            L92:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.irisdt.grpc.connect.EventManager.EventRunnable.execute():void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final EventManager INSTANCE = new EventManager();

        private InstanceHolder() {
        }
    }

    public static EventManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public long getMinUploadIntervals() {
        return 5000L;
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public boolean isEnable() {
        return StatConfig.isEventEnable();
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public void upload(Object[] objArr) {
        CustomEventProtos.Requests.Builder newBuilder = CustomEventProtos.Requests.newBuilder();
        newBuilder.setCommon(Irisdt.getCommon().getProtoData());
        for (Object obj : objArr) {
            newBuilder.addRequest((CustomEventProtos.Request) obj);
        }
        ThreadManager.startThread(new EventRunnable(newBuilder.build()));
    }

    private EventManager() {
    }
}
