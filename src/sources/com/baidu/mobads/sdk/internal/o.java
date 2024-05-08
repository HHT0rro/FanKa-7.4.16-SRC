package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOAdEvent f10278a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f10279b;

    public o(n nVar, IOAdEvent iOAdEvent) {
        this.f10279b = nVar;
        this.f10278a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener2;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener3;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener4;
        IOAdEvent iOAdEvent = this.f10278a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f10278a.getType();
        if (x.ap.equals(type)) {
            List<CpuChannelResponse> a10 = l.a((JSONArray) this.f10278a.getData().get("cpuChannelList"));
            cpuChannelListListener3 = this.f10279b.f10277a.f10274q;
            if (cpuChannelListListener3 != null) {
                cpuChannelListListener4 = this.f10279b.f10277a.f10274q;
                cpuChannelListListener4.onChannelListLoaded(a10);
                return;
            }
            return;
        }
        if (x.aq.equals(type)) {
            Map<String, Object> data = this.f10278a.getData();
            int i10 = 0;
            if (data != null) {
                str = (String) data.get("error_message");
                Object obj = data.get("error_code");
                if (obj == null) {
                    obj = 0;
                }
                i10 = ((Integer) obj).intValue();
            } else {
                str = "";
            }
            cpuChannelListListener = this.f10279b.f10277a.f10274q;
            if (cpuChannelListListener != null) {
                cpuChannelListListener2 = this.f10279b.f10277a.f10274q;
                cpuChannelListListener2.onChannelListError(str, i10);
            }
        }
    }
}
