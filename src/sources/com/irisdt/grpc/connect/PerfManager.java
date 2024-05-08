package com.irisdt.grpc.connect;

import android.os.SystemClock;
import com.irisdt.Irisdt;
import com.irisdt.StatConfig;
import com.irisdt.grpc.ConnectManager;
import com.irisdt.perf.PerfProtos;
import com.irisdt.perf.ReportServiceGrpc;
import com.irisdt.util.NamedRunnable;
import com.irisdt.util.ThreadManager;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class PerfManager extends BaseManager<PerfProtos.Request> {
    private volatile boolean enable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final PerfManager INSTANCE = new PerfManager();

        private InstanceHolder() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class PrefRunnable extends NamedRunnable {
        private PerfProtos.Requests requests;

        public PrefRunnable(PerfProtos.Requests requests) {
            super(StatConfig.getThreadName("pref"));
            this.requests = requests;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.irisdt.util.NamedRunnable
        public void execute() {
            if (StatConfig.isLogEnable()) {
                StatConfig.log().i("PREF start-request \n", this.requests);
            }
            ReportServiceGrpc.ReportServiceBlockingStub reportServiceBlockingStub = (ReportServiceGrpc.ReportServiceBlockingStub) ((ReportServiceGrpc.ReportServiceBlockingStub) ((ReportServiceGrpc.ReportServiceBlockingStub) ConnectManager.attachHeaders(ReportServiceGrpc.newBlockingStub(ConnectManager.getChannel()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
            PerfProtos.Response response = null;
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                response = reportServiceBlockingStub.batchReport(this.requests);
            } catch (Throwable th) {
                if (StatConfig.isLogEnable()) {
                    th.printStackTrace();
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            if (StatConfig.isLogEnable()) {
                StatConfig.log().i("PREF ", Long.valueOf(uptimeMillis2), ", ", response);
            }
        }
    }

    public static PerfManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void addPref(PerfProtos.Type type, long j10, int i10, Exception exc) {
        if (this.enable) {
            PerfProtos.Request.Builder clientTime = PerfProtos.Request.newBuilder().setType(type).setTakes((int) j10).setCode(i10).setClientTime(System.currentTimeMillis());
            if (exc != null) {
                clientTime.setDescription(exc.getMessage());
            }
            record(clientTime.build());
        }
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public long getMinUploadIntervals() {
        return 5000L;
    }

    public void setEnable(boolean z10) {
        this.enable = z10;
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public void upload(Object[] objArr) {
        PerfProtos.Requests.Builder newBuilder = PerfProtos.Requests.newBuilder();
        newBuilder.setCommon(Irisdt.getCommon().getProtoData());
        for (Object obj : objArr) {
            newBuilder.addRequest((PerfProtos.Request) obj);
        }
        ThreadManager.startThread(new PrefRunnable(newBuilder.build()));
    }

    private PerfManager() {
        this.enable = false;
    }

    public void addPref(PerfProtos.Type type, long j10, int i10, Throwable th) {
        if (this.enable) {
            PerfProtos.Request.Builder clientTime = PerfProtos.Request.newBuilder().setType(type).setTakes((int) j10).setCode(i10).setClientTime(System.currentTimeMillis());
            if (th != null) {
                clientTime.setDescription(th.getMessage());
            }
            record(clientTime.build());
        }
    }
}
