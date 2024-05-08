package com.alimm.tanx.core.ad.bean;

import com.alimm.tanx.core.ad.listener.bean.IClickBean;
import java.util.Arrays;

/* compiled from: ClickBean.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_do implements IClickBean {
    public String tanxc_do;
    public int tanxc_for;
    public String tanxc_if;
    public Integer[] tanxc_int;

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public String getClickThroughUrl() {
        return this.tanxc_do;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public String getDeepLinkUrl() {
        return this.tanxc_if;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public Integer[] getInteractType() {
        return this.tanxc_int;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public int getInteractType2Int() {
        Integer[] numArr = this.tanxc_int;
        if (numArr == null || numArr.length <= 0) {
            return -1;
        }
        return numArr[0].intValue();
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public int getOpenType() {
        return this.tanxc_for;
    }

    public void tanxc_do(String str) {
        this.tanxc_do = str;
    }

    public void tanxc_if(String str) {
        this.tanxc_if = str;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public boolean getInteractType(int i10) {
        return getInteractType() != null && getInteractType().length > 0 && Arrays.binarySearch(getInteractType(), Integer.valueOf(i10)) >= 0;
    }

    public void tanxc_do(int i10) {
        this.tanxc_for = i10;
    }

    public void tanxc_do(Integer[] numArr) {
        this.tanxc_int = numArr;
    }
}
