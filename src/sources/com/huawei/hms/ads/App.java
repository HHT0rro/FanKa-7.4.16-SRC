package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class App implements Serializable {
    private static final long serialVersionUID = 30421300;
    private Integer brand;
    private String name__;
    private String pkgname__;
    private String version__;

    @AllApi
    public App() {
    }

    @AllApi
    public App(String str, String str2, String str3) {
        this.name__ = str2;
        this.pkgname__ = str;
        this.version__ = str3;
    }

    @AllApi
    public App(String str, String str2, String str3, Integer num) {
        this.version__ = str;
        this.name__ = str2;
        this.pkgname__ = str3;
        this.brand = num;
    }

    @AllApi
    public Integer getBrand() {
        return this.brand;
    }

    @AllApi
    public String getName__() {
        return this.name__;
    }

    @AllApi
    public String getPkgname__() {
        return this.pkgname__;
    }

    @AllApi
    public String getVersion__() {
        return this.version__;
    }

    @AllApi
    public void setBrand(Integer num) {
        this.brand = num;
    }

    @AllApi
    public void setName__(String str) {
        this.name__ = str;
    }

    @AllApi
    public void setPkgname__(String str) {
        this.pkgname__ = str;
    }

    @AllApi
    public void setVersion__(String str) {
        this.version__ = str;
    }
}
