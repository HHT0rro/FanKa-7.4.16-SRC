package com.tencent.liteav.videobase.a;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class j extends b {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Integer> f43261a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Integer> f43262b;

    public j(String str, String str2) {
        super(str, str2);
        this.f43261a = new HashMap();
        this.f43262b = new HashMap();
    }

    public final void a(String str, int i10) {
        this.f43261a.put(str, Integer.valueOf(i10));
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void afterDrawArrays() {
        super.afterDrawArrays();
        Iterator<Map.Entry<String, Integer>> iterator2 = this.f43261a.entrySet().iterator2();
        int i10 = 33985;
        while (iterator2.hasNext()) {
            iterator2.next();
            GLES20.glActiveTexture(i10);
            OpenGlUtils.bindTexture(getTarget(), 0);
            i10++;
        }
        this.f43261a.clear();
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void beforeDrawArrays(int i10) {
        super.beforeDrawArrays(i10);
        int i11 = 33985;
        for (Map.Entry<String, Integer> entry : this.f43261a.entrySet()) {
            Integer num = this.f43262b.get(entry.getKey());
            if (num == null) {
                num = Integer.valueOf(GLES20.glGetUniformLocation(getProgramId(), entry.getKey()));
                this.f43262b.put(entry.getKey(), num);
            }
            GLES20.glActiveTexture(i11);
            OpenGlUtils.bindTexture(getTarget(), entry.getValue().intValue());
            GLES20.glUniform1i(num.intValue(), i11 - 33984);
            i11++;
        }
    }
}
