package com.alimm.tanx.core.net.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.ad.bean.BaseBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BaseResponseBean<T> extends BaseBean {

    @JSONField(name = "seat")
    public T data;

    /* renamed from: id, reason: collision with root package name */
    @JSONField(name = "id")
    public int f4182id;
    public int status;

    public T getData() {
        return this.data;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(T t2) {
        this.data = t2;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
