package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TemplateConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -6943205584670122269L;
    public String h5Checksum;
    public String h5Url;
    public String h5Version;

    public boolean notEmpty() {
        return (TextUtils.isEmpty(this.h5Url) || TextUtils.isEmpty(this.h5Version) || TextUtils.isEmpty(this.h5Checksum)) ? false : true;
    }
}
