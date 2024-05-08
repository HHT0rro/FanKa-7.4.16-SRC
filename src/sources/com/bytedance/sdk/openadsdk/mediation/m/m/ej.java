package com.bytedance.sdk.openadsdk.mediation.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej extends com.bytedance.sdk.openadsdk.hc.m.m.m.ej {

    /* renamed from: m, reason: collision with root package name */
    private TTAdNative.FeedAdListener f11377m;

    public ej(TTAdNative.FeedAdListener feedAdListener) {
        super(feedAdListener);
        this.f11377m = feedAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.hc.m.m.m.ej, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 == 164102) {
            Iterable iterable = (List) valueSet.objectValue(0, List.class);
            if (iterable == null) {
                iterable = new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList();
            Iterator iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(new ve((Bridge) iterator2.next()));
            }
            TTAdNative.FeedAdListener feedAdListener = this.f11377m;
            if (feedAdListener == null) {
                return null;
            }
            feedAdListener.onFeedAdLoad(arrayList);
            return null;
        }
        return (T) super.call(i10, valueSet, cls);
    }
}
