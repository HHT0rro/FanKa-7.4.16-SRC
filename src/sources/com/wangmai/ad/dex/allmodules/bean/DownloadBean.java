package com.wangmai.ad.dex.allmodules.bean;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class DownloadBean {
    private DataBean data;
    private int ret;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class DataBean {
        private String clickid;
        private String dstlink;

        public String getClickid() {
            return this.clickid;
        }

        public String getDstlink() {
            return this.dstlink;
        }

        public void setClickid(String str) {
            this.clickid = str;
        }

        public void setDstlink(String str) {
            this.dstlink = str;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public int getRet() {
        return this.ret;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setRet(int i10) {
        this.ret = i10;
    }
}
