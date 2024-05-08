package com.alibaba.security.realidentity.business.submit;

import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SubmitHttpResponse extends HttpResponse {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class DataBean implements Serializable {
        private int status;

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int i10) {
            this.status = i10;
        }
    }

    public int getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getStatus() {
        DataBean dataBean = this.data;
        if (dataBean == null) {
            return this.code;
        }
        return dataBean.status;
    }

    @Override // com.alibaba.security.realidentity.http.model.HttpResponse
    public boolean isSuccessful() {
        return getStatus() == 1;
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
