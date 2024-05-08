package com.alimm.tanx.core.ut.core;

import com.alimm.tanx.core.ut.bean.UtBean;
import com.alimm.tanx.core.ut.bean.UtItemBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UserReportManager implements IUserReport {
    public static volatile UserReportManager instance;

    public static UserReportManager getInstance() {
        if (instance == null) {
            synchronized (UserReportManager.class) {
                if (instance == null) {
                    instance = new UserReportManager();
                }
            }
        }
        return instance;
    }

    public void destroy() {
        QueueManager.getInstance().destroy();
        UtRequest.getInstance().destroy();
    }

    public void init() {
        QueueManager.getInstance().run();
    }

    @Override // com.alimm.tanx.core.ut.core.IUserReport
    public void send(UtItemBean utItemBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(utItemBean);
        send(arrayList);
    }

    @Override // com.alimm.tanx.core.ut.core.IUserReport
    public void send(List<UtItemBean> list) {
        QueueManager.getInstance().addRealTimeQueue(new UtBean(list));
    }
}
