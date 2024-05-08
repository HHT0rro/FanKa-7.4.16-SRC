package com.alibaba.security.realidentity.business.upload;

import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UploadResultResponse extends HttpResponse {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class DataBean implements Serializable {
        private String category;
        private int code;
        private IdCardInfoBean idCardInfo;
        private String material;
        private String msg;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static class IdCardInfoBean implements Serializable {
            private String address;
            private String birth;
            private String name;
            private String number;
            private String sex;

            public String getAddress() {
                return this.address;
            }

            public String getBirth() {
                return this.birth;
            }

            public String getName() {
                return this.name;
            }

            public String getNumber() {
                return this.number;
            }

            public String getSex() {
                return this.sex;
            }

            public void setAddress(String str) {
                this.address = str;
            }

            public void setBirth(String str) {
                this.birth = str;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setNumber(String str) {
                this.number = str;
            }

            public void setSex(String str) {
                this.sex = str;
            }
        }

        public String getCategory() {
            return this.category;
        }

        public int getCode() {
            return this.code;
        }

        public IdCardInfoBean getIdCardInfo() {
            return this.idCardInfo;
        }

        public String getMaterial() {
            return this.material;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setCategory(String str) {
            this.category = str;
        }

        public void setCode(int i10) {
            this.code = i10;
        }

        public void setIdCardInfo(IdCardInfoBean idCardInfoBean) {
            this.idCardInfo = idCardInfoBean;
        }

        public void setMaterial(String str) {
            this.material = str;
        }

        public void setMsg(String str) {
            this.msg = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override // com.alibaba.security.realidentity.http.model.HttpResponse
    public boolean isSuccessful() {
        int i10 = this.code;
        return i10 >= 200 && i10 < 300;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
