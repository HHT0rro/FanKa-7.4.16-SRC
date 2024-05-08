package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.widget.ImageView;
import com.huawei.hms.ads.lj;
import com.huawei.openalliance.ad.inter.data.b;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ke<V extends lj> {
    boolean B();

    void Code(Context context, ImageView imageView, Drawable drawable);

    void Code(Location location);

    void Code(RequestOptions requestOptions);

    void Code(com.huawei.openalliance.ad.inter.data.n nVar);

    void Code(com.huawei.openalliance.ad.inter.data.t tVar);

    void Code(Integer num);

    void Code(String str, int i10, List<String> list, int i11);

    void Code(String str, com.huawei.openalliance.ad.inter.data.g gVar, long j10);

    boolean Code(b bVar, float f10);

    void I(Integer num);

    void V(Integer num);

    void V(String str);
}
