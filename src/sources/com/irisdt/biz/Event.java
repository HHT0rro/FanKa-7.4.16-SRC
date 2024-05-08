package com.irisdt.biz;

import com.irisdt.StatConfig;
import com.irisdt.event.CustomEventProtos;
import com.irisdt.grpc.connect.EventManager;
import com.irisdt.util.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Event {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final Event INSTANCE = new Event();

        private InstanceHolder() {
        }
    }

    public static Event getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void upload(CustomEventProtos.Request.Builder builder) {
        builder.setClientTime(System.currentTimeMillis());
        EventManager.getInstance().record(builder.build());
    }

    public void eventFailed(String str, long j10, int i10, String str2) {
        eventNormal(str, j10, i10, str2);
    }

    public void eventNormal(String str, long j10, int i10, String str2) {
        upload(CustomEventProtos.Request.newBuilder().setTakes((int) j10).setName(Utils.getStringValue(str)).setCode(i10).setDescription(Utils.getStringValue(str2)));
    }

    public void eventSuccess(String str, long j10) {
        upload(CustomEventProtos.Request.newBuilder().setTakes((int) j10).setName(Utils.getStringValue(str)));
    }

    public void setEnable(boolean z10) {
        StatConfig.setEventEnable(z10);
    }

    public void setLogEnable(boolean z10) {
        StatConfig.setEventLogEnable(z10);
    }

    private Event() {
    }
}
