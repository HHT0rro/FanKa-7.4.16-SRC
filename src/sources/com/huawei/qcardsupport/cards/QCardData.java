package com.huawei.qcardsupport.cards;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.json.codec.JsonPacked;
import com.huawei.flexiblelayout.parser.utils.UriUtils;
import com.huawei.qcardsupport.bridge.JsBridges;
import com.huawei.qcardsupport.bridge.JsObjectBridge;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QCardData extends FLCardData {

    /* renamed from: a, reason: collision with root package name */
    @JsonPacked("quickCard")
    private String f33114a;

    /* renamed from: b, reason: collision with root package name */
    private String f33115b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f33116c;

    /* renamed from: d, reason: collision with root package name */
    private String f33117d;

    /* renamed from: e, reason: collision with root package name */
    private JsObjectBridge f33118e;

    /* renamed from: f, reason: collision with root package name */
    private a f33119f;

    public QCardData(String str) {
        super(str);
        this.f33116c = false;
    }

    public void a(boolean z10) {
        this.f33116c = z10;
    }

    @NonNull
    public JsObjectBridge b() {
        if (this.f33118e == null) {
            this.f33118e = JsBridges.toJsObjectBridge(getData());
        }
        return this.f33118e;
    }

    public boolean c() {
        return this.f33116c;
    }

    public String getQCardName() {
        if (TextUtils.isEmpty(this.f33115b)) {
            this.f33115b = UriUtils.getHost(getQCardUri());
        }
        return this.f33115b;
    }

    public String getQCardUri() {
        JsObjectBridge jsObjectBridge;
        if (TextUtils.isEmpty(this.f33114a) && (jsObjectBridge = this.f33118e) != null) {
            this.f33114a = jsObjectBridge.optString("uri");
        }
        return this.f33114a;
    }

    @Override // com.huawei.flexiblelayout.data.FLCardData
    public String getReuseIdentifier() {
        String str = this.f33117d;
        if (str != null) {
            return str;
        }
        String str2 = super.getType() + "-" + getQCardUri();
        this.f33117d = str2;
        return str2;
    }

    @NonNull
    public a a() {
        if (this.f33119f == null) {
            this.f33119f = new a(null);
        }
        return this.f33119f;
    }
}
