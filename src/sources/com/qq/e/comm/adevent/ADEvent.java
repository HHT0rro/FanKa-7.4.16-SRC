package com.qq.e.comm.adevent;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ADEvent {

    /* renamed from: a, reason: collision with root package name */
    private final int f38249a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f38250b;

    public ADEvent(int i10, Object... objArr) {
        this.f38249a = i10;
        this.f38250b = objArr;
        if (i10 < 100) {
            a("EventId 错误" + i10);
        }
    }

    private void a(String str) {
        GDTLogger.e(str);
    }

    public <T> T getParam(int i10, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.f38250b) == null || objArr.length <= i10) {
            return null;
        }
        T t2 = (T) objArr[i10];
        if (t2 == null) {
            GDTLogger.e("ADEvent 参数为空,type:" + this.f38249a);
            return null;
        }
        if (cls.isInstance(objArr[i10])) {
            return t2;
        }
        GDTLogger.e("ADEvent" + this.f38249a + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t2.getClass().getName());
        return null;
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.f38249a;
    }
}
