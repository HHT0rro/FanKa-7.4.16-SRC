package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FeedbackInfo implements Serializable {
    private static final long serialVersionUID = 30456300;

    /* renamed from: id, reason: collision with root package name */
    private long f32445id;
    private String label;
    private int type;

    @com.huawei.openalliance.ad.annotations.b
    public String Code() {
        return this.label;
    }

    public void Code(int i10) {
        this.type = i10;
    }

    public void Code(long j10) {
        this.f32445id = j10;
    }

    public void Code(String str) {
        this.label = str;
    }

    public long I() {
        return this.f32445id;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int V() {
        return this.type;
    }

    public boolean Z() {
        int i10;
        return !TextUtils.isEmpty(this.label) && ((i10 = this.type) == 1 || i10 == 2 || i10 == 3);
    }
}
