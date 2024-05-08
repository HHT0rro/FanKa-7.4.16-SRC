package com.huawei.hianalytics.framework.datahandler;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.framework.data.ConfigManager;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ReportTask implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public String f28788a;

    /* renamed from: b, reason: collision with root package name */
    public String f28789b;

    /* renamed from: c, reason: collision with root package name */
    public ICallback f28790c;

    /* renamed from: d, reason: collision with root package name */
    public String f28791d;

    /* renamed from: e, reason: collision with root package name */
    public IMandatoryParameters f28792e = ConfigManager.getInstance().getParameters();

    /* renamed from: f, reason: collision with root package name */
    public boolean f28793f;

    public ReportTask(String str, String str2, ICallback iCallback, String str3) {
        this.f28788a = str;
        this.f28789b = str2;
        this.f28790c = iCallback;
        this.f28791d = str3;
    }

    private void getReportEventList(String str, String str2) {
        List<Event> readEvents;
        IStorageHandler c4 = com.huawei.hianalytics.framework.b.c(str);
        if (c4 != null) {
            if (this.f28793f) {
                readEvents = c4.readOldEvents(str, str2, this.f28792e.getProcessName());
            } else if ("allType".equals(str2)) {
                readEvents = c4.readEvents(str, this.f28792e.getProcessName());
            } else {
                readEvents = c4.readEvents(str, str2, this.f28792e.getProcessName());
            }
            List<Event> list = readEvents;
            if (list != null && list.size() != 0) {
                new e(str, str2, list, this.f28790c, this.f28791d).a();
                return;
            } else {
                HiLog.sw("ReportTask", "events size is empty");
                return;
            }
        }
        HiLog.e("ReportTask", "storageHandler is null! Data cannot be queried.");
    }

    private void handTagData(String str) {
        getReportEventList(str, FrameworkConstant.DataType.STRING_OPER);
        getReportEventList(str, FrameworkConstant.DataType.STRING_MAINT);
        getReportEventList(str, FrameworkConstant.DataType.STRING_DIFFPRIVACY);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f28788a) && TextUtils.isEmpty(this.f28789b)) {
            this.f28793f = true;
            Iterator<String> iterator2 = this.f28792e.getAllTags().iterator2();
            while (iterator2.hasNext()) {
                handTagData(iterator2.next());
            }
            return;
        }
        if ("_default_config_tag".equals(this.f28788a) && "allType".equals(this.f28789b)) {
            handTagData(this.f28788a);
        } else {
            getReportEventList(this.f28788a, this.f28789b);
        }
    }
}
