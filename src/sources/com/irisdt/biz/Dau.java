package com.irisdt.biz;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.irisdt.StatConfig;
import com.irisdt.dau.DayActiveUserProtos;
import com.irisdt.grpc.connect.DauManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Dau {
    private int heartbeatSeconds;
    private boolean localCacheEnable;
    private ProcessLifecycleObserver processLifecycleObserver;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final Dau INSTANCE = new Dau();

        private InstanceHolder() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnDauListener {
        void onDau(DayActiveUserProtos.NAME name);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class ProcessLifecycleObserver implements LifecycleObserver {
        private ProcessLifecycleObserver() {
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onAppBackground() {
            Dau.this.upload(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.SWITCH_TO_BACK), null, null);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onAppForeground() {
            Dau.this.uploadAndDelay(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.SWITCH_TO_FRONT));
        }
    }

    public static Dau getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upload(DayActiveUserProtos.Request.Builder builder, Long l10, String str) {
        builder.setClientTime(System.currentTimeMillis());
        DauManager.getInstance().record(builder, l10, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadAndDelay(DayActiveUserProtos.Request.Builder builder) {
        builder.setClientTime(System.currentTimeMillis());
        DauManager.getInstance().recordAndDelay(builder);
    }

    public int getHeartbeatSeconds() {
        return this.heartbeatSeconds;
    }

    public boolean isLocalCacheEnable() {
        return this.localCacheEnable;
    }

    @MainThread
    public void login() {
        uploadAndDelay(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.LOGIN));
        if (this.processLifecycleObserver == null) {
            this.processLifecycleObserver = new ProcessLifecycleObserver();
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this.processLifecycleObserver);
        }
    }

    @MainThread
    @Deprecated
    public void logout() {
        upload(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.LOGOUT), null, null);
        if (this.processLifecycleObserver != null) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(this.processLifecycleObserver);
            this.processLifecycleObserver = null;
        }
    }

    public void setEnable(boolean z10) {
        StatConfig.setDauEnable(z10);
    }

    public void setHeartbeatSeconds(int i10) {
        if (i10 > 0) {
            this.heartbeatSeconds = i10 * 1000;
        }
    }

    public void setLocalCacheEnable(boolean z10) {
        this.localCacheEnable = z10;
    }

    public void setLogEnable(boolean z10) {
        StatConfig.setDauLogEnable(z10);
    }

    public void setOnDauListener(OnDauListener onDauListener) {
        DauManager.getInstance().setOnDauListener(onDauListener);
    }

    private Dau() {
        this.heartbeatSeconds = StatConfig.STAT_DAU_PERIOD;
        this.localCacheEnable = true;
    }

    @MainThread
    public void logout(long j10) {
        upload(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.LOGOUT), Long.valueOf(j10), null);
        if (this.processLifecycleObserver != null) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(this.processLifecycleObserver);
            this.processLifecycleObserver = null;
        }
    }

    @MainThread
    public void logout(String str) {
        upload(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.LOGOUT), null, str);
        if (this.processLifecycleObserver != null) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(this.processLifecycleObserver);
            this.processLifecycleObserver = null;
        }
    }
}
