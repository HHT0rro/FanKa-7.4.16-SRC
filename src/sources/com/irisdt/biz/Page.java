package com.irisdt.biz;

import com.irisdt.StatConfig;
import com.irisdt.grpc.connect.PageManager;
import com.irisdt.page.PageDurationProtos;
import com.irisdt.util.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Page {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final Page INSTANCE = new Page();

        private InstanceHolder() {
        }
    }

    public static Page getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void upload(PageDurationProtos.Request.Builder builder) {
        builder.setClientTime(System.currentTimeMillis());
        PageManager.getInstance().record(builder.build());
    }

    public void pageVisitLog(String str, String str2, long j10) {
        upload(PageDurationProtos.Request.newBuilder().setType(PageDurationProtos.Type.DURATION).setName(Utils.getStringValue(str)).setPageCode(Utils.getStringValue(str2)).setTakes((int) j10));
    }

    public void pageVisitPath(String str, String str2, String str3) {
        upload(PageDurationProtos.Request.newBuilder().setType(PageDurationProtos.Type.PATH).setName(Utils.getStringValue(str)).setPageCode(Utils.getStringValue(str2)).setPath(Utils.getStringValue(str3)));
    }

    public void setEnable(boolean z10) {
        StatConfig.setPageEnable(z10);
    }

    public void setLogEnable(boolean z10) {
        StatConfig.setPageLogEnable(z10);
    }

    private Page() {
    }
}
