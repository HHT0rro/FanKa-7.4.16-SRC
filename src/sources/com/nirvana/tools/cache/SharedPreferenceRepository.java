package com.nirvana.tools.cache;

import android.content.Context;
import com.nirvana.tools.core.UTSharedPreferencesHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SharedPreferenceRepository extends CacheRepository<SharedPreferenceTemplate> {
    private Context mContext;

    public SharedPreferenceRepository(SharedPreferenceTemplate sharedPreferenceTemplate, Context context) {
        super(sharedPreferenceTemplate);
        this.mContext = context;
    }

    @Override // com.nirvana.tools.cache.CacheRepository
    public void clear() {
        UTSharedPreferencesHelper.clearInfo(this.mContext, getTemplate().getFileName(), getTemplate().getKeyName());
    }

    @Override // com.nirvana.tools.cache.CacheRepository
    public String read() {
        return (String) UTSharedPreferencesHelper.get(this.mContext, getTemplate().getFileName(), getTemplate().getKeyName(), "");
    }

    @Override // com.nirvana.tools.cache.CacheRepository
    public void write(String str) {
        UTSharedPreferencesHelper.put(this.mContext, getTemplate().getFileName(), getTemplate().getKeyName(), str);
    }
}
