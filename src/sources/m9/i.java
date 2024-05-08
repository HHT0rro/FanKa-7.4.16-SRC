package m9;

import android.text.TextUtils;
import com.huawei.appgallery.agd.core.impl.store.configlist.ConfigInfo;
import com.huawei.appgallery.agd.core.impl.store.configlist.ConfigListResponse;
import com.huawei.appgallery.agd.core.internalapi.CoreApi;
import com.huawei.appgallery.agd.core.internalapi.IQueryConfigList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    public static i f51966b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f51967c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public ConfigInfo f51968a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements IQueryConfigList.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IQueryConfigList.Callback f51969a;

        public a(IQueryConfigList.Callback callback) {
            this.f51969a = callback;
        }

        @Override // com.huawei.appgallery.agd.core.internalapi.IQueryConfigList.Callback
        public void onFail(int i10, String str) {
            this.f51969a.onFail(i10, str);
        }

        @Override // com.huawei.appgallery.agd.core.internalapi.IQueryConfigList.Callback
        public void onSuccess(ConfigListResponse configListResponse) {
            i.this.b(configListResponse);
            this.f51969a.onSuccess(configListResponse);
        }
    }

    public static i e() {
        i iVar;
        synchronized (f51967c) {
            if (f51966b == null) {
                f51966b = new i();
            }
            iVar = f51966b;
        }
        return iVar;
    }

    public List<String> a() {
        ConfigInfo configInfo = this.f51968a;
        if (configInfo != null && !TextUtils.isEmpty(configInfo.getConfigValue())) {
            return Arrays.asList(this.f51968a.getConfigValue().split(","));
        }
        return new ArrayList();
    }

    public final void b(ConfigListResponse configListResponse) {
        if (configListResponse == null || configListResponse.getConfigList() == null || configListResponse.getConfigList().isEmpty()) {
            return;
        }
        for (ConfigInfo configInfo : configListResponse.getConfigList()) {
            if ("AGD.CONFIG.WHITELIST".equals(configInfo.getConfigKey())) {
                this.f51968a = configInfo;
                return;
            }
        }
    }

    public void c(IQueryConfigList.Callback callback) {
        CoreApi.queryConfigList(new String[]{"AGD.CONFIG.WHITELIST"}, new a(callback));
    }
}
