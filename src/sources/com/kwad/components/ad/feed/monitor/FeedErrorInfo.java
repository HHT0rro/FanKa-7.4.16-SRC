package com.kwad.components.ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FeedErrorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = 5562303989639679849L;
    public long feedType;
    public long materialType;
    public long width;

    public FeedErrorInfo setFeedType(int i10) {
        this.feedType = i10;
        return this;
    }

    public FeedErrorInfo setMaterialType(long j10) {
        this.materialType = j10;
        return this;
    }

    public FeedErrorInfo setWidth(long j10) {
        this.width = j10;
        return this;
    }
}
