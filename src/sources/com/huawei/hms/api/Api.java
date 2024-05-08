package com.huawei.hms.api;

import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Api<O extends ApiOptions> {
    private final String mApiName;
    public List<ConnectionPostProcessor> mConnetctPostList;
    private final Options<O> mOption;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface ApiOptions {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public interface HasOptions extends ApiOptions {
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class NoOptions implements NotRequiredOptions {
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class Options<O> {
        public List<PermissionInfo> getPermissionInfoList(O o10) {
            return Collections.emptyList();
        }

        public List<Scope> getScopeList(O o10) {
            return Collections.emptyList();
        }
    }

    public Api(String str) {
        this.mApiName = str;
        this.mOption = null;
    }

    public String getApiName() {
        return this.mApiName;
    }

    public Options<O> getOptions() {
        return this.mOption;
    }

    public List<ConnectionPostProcessor> getmConnetctPostList() {
        return this.mConnetctPostList;
    }

    public void setmConnetctPostList(List<ConnectionPostProcessor> list) {
        this.mConnetctPostList = list;
    }

    public Api(String str, Options<O> options) {
        this.mApiName = str;
        this.mOption = options;
    }
}
