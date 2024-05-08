package com.alimm.tanx.core.net.bean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DownLoadRequestBean extends RequestBean {
    public String fileName;
    public String path;
    public boolean resume;

    public String getFileName() {
        return this.fileName;
    }

    public String getPath() {
        return this.path;
    }

    public boolean isResume() {
        return this.resume;
    }

    public DownLoadRequestBean setFileName(String str) {
        this.fileName = str;
        return this;
    }

    public DownLoadRequestBean setPath(String str) {
        this.path = str;
        return this;
    }

    public DownLoadRequestBean setResume(boolean z10) {
        this.resume = z10;
        return this;
    }

    @Override // com.alimm.tanx.core.net.bean.RequestBean
    public DownLoadRequestBean build() {
        super.build();
        return this;
    }

    @Override // com.alimm.tanx.core.net.bean.RequestBean
    public DownLoadRequestBean setUrl(String str) {
        super.setUrl(str);
        return this;
    }
}
