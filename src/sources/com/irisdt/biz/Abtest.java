package com.irisdt.biz;

import com.irisdt.StatConfig;
import com.irisdt.grpc.connect.AbtestManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Abtest {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final Abtest INSTANCE = new Abtest();

        private InstanceHolder() {
        }
    }

    public static Abtest getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public String getAbConfig(String str, String str2) {
        return AbtestManager.getInstance().getExpResult(str, str2);
    }

    public void initConfig(String str, String str2) {
        AbtestManager.getInstance().init(str, str2);
    }

    public void setDecisionId(String str) {
        AbtestManager.getInstance().setDecisionId(str);
    }

    public void setEnable(boolean z10) {
        StatConfig.setAbtestEnable(z10);
    }

    public void setLogEnable(boolean z10) {
        StatConfig.setAbtestLogEnable(z10);
    }

    private Abtest() {
    }

    public boolean getAbConfig(String str, boolean z10) {
        return AbtestManager.getInstance().getExpResult(str, z10);
    }

    public int getAbConfig(String str, int i10) {
        return AbtestManager.getInstance().getExpResult(str, i10);
    }
}
