package com.alibaba.security.realidentity.business.start;

import com.alibaba.security.realidentity.http.model.HttpResponse;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StartHttpResponse extends HttpResponse {
    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isRepeatedSubmitted() {
        DataBean dataBean;
        return this.code == 200 && (dataBean = this.data) != null && dataBean.getExtras() != null && "1".equals(this.data.getExtras().getStatus());
    }

    @Override // com.alibaba.security.realidentity.http.model.HttpResponse
    public boolean isSuccessful() {
        return !isRepeatedSubmitted() && this.code == 200;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
