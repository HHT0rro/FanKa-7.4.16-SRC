package com.danlan.android.cognition.collector;

import android.content.Context;
import android.location.Location;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.LocationUtil;
import com.danlan.android.cognition.collector.util.PermissionUtil;
import com.danlan.android.cognition.collector.util.SafeJSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class LocationCollector extends SubCollector {
    private Context mcontext;
    private final PermissionUtil permissionUtils;

    public LocationCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
        this.permissionUtils = new PermissionUtil(context);
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        put(StringFog.decrypt("TUxHQlVKS08="), getLocationInfo(this.mcontext));
        collectDone();
    }

    public SafeJSONObject getLocationInfo(Context context) {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        Location location = LocationUtil.getLocation(context);
        if (location != null) {
            safeJSONObject.put(StringFog.decrypt("TUJQSlVWQEQ="), location.getLatitude());
            safeJSONObject.put(StringFog.decrypt("TUxKREhXUUVE"), location.getLongitude());
        }
        return safeJSONObject;
    }
}
