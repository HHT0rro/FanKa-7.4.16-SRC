package com.qq.e.comm.pi;

import com.qq.e.comm.constants.LoadAdParams;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface NUADI extends ADI {
    String getAdNetWorkName();

    void loadData(int i10);

    void loadData(int i10, LoadAdParams loadAdParams);

    void setCategories(List<String> list);

    void setMaxVideoDuration(int i10);

    void setMinVideoDuration(int i10);

    void setVastClassName(String str);
}
