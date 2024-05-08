package h2;

import android.view.View;

/* compiled from: OnClickListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0742a f49494b;

    /* renamed from: c, reason: collision with root package name */
    public final int f49495c;

    /* compiled from: OnClickListener.java */
    /* renamed from: h2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface InterfaceC0742a {
        void a(int i10, View view);
    }

    public a(InterfaceC0742a interfaceC0742a, int i10) {
        this.f49494b = interfaceC0742a;
        this.f49495c = i10;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f49494b.a(this.f49495c, view);
    }
}
