package com.huawei.flexiblelayout;

import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.card.dnode.FLDNodeListener;
import com.huawei.flexiblelayout.card.dnode.FLDNodeService;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FLDNodeServiceImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements FLDNodeService {

    /* renamed from: a, reason: collision with root package name */
    private final List<FLDNodeListener> f27710a = new ArrayList();

    /* compiled from: FLDNodeServiceImpl.java */
    /* renamed from: com.huawei.flexiblelayout.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface InterfaceC0263a {
        void a(FLDNodeListener fLDNodeListener);
    }

    public void a(InterfaceC0263a interfaceC0263a) {
        for (int size = this.f27710a.size() - 1; size >= 0; size--) {
            interfaceC0263a.a(this.f27710a.get(size));
        }
    }

    @Override // com.huawei.flexiblelayout.card.dnode.FLDNodeService
    public void addListener(@Nullable FLDNodeListener fLDNodeListener) {
        this.f27710a.add(fLDNodeListener);
    }

    @Override // com.huawei.flexiblelayout.card.dnode.FLDNodeService
    public void removeListener(@Nullable FLDNodeListener fLDNodeListener) {
        this.f27710a.remove(fLDNodeListener);
    }
}
