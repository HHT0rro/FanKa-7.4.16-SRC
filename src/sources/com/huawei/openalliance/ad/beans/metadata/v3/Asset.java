package com.huawei.openalliance.ad.beans.metadata.v3;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Data;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Image;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Title;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Video;
import java.io.Serializable;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Asset implements Serializable {
    private static final long serialVersionUID = 5132069519973155133L;
    private String alias;
    private String context;
    private Data data;
    private String filePath;

    /* renamed from: id, reason: collision with root package name */
    private int f32147id;
    private Image img;
    private Title title;
    private Video video;

    public Video B() {
        return this.video;
    }

    public Title C() {
        return this.title;
    }

    public int Code() {
        return this.f32147id;
    }

    public void Code(int i10) {
        this.f32147id = i10;
    }

    public void Code(Data data) {
        this.data = data;
    }

    public void Code(Image image) {
        this.img = image;
    }

    public void Code(Title title) {
        this.title = title;
    }

    public void Code(Video video) {
        this.video = video;
    }

    public void Code(String str) {
        this.alias = str;
    }

    public String F() {
        return this.context;
    }

    public Data I() {
        return this.data;
    }

    public void I(String str) {
        this.context = str;
    }

    public String S() {
        return this.filePath;
    }

    public String V() {
        return this.alias;
    }

    public void V(String str) {
        this.filePath = str;
    }

    public Image Z() {
        return this.img;
    }
}
