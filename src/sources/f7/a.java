package f7;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f49219a;

    /* renamed from: b, reason: collision with root package name */
    public final String f49220b;

    /* renamed from: c, reason: collision with root package name */
    public final T f49221c;

    @Deprecated
    /* renamed from: f7.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class C0736a extends a<Boolean> {
        public C0736a(int i10, String str, Boolean bool) {
            super(i10, str, bool);
        }
    }

    public a(int i10, String str, T t2) {
        this.f49219a = i10;
        this.f49220b = str;
        this.f49221c = t2;
        c.a().a(this);
    }

    @Deprecated
    public static C0736a a(int i10, String str, Boolean bool) {
        return new C0736a(i10, str, bool);
    }
}
