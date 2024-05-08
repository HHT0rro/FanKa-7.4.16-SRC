package android.view;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SurfaceSocExtImpl implements ISurfaceSocExt {
    private Surface mSurface;

    public SurfaceSocExtImpl(Object obj) {
        this.mSurface = null;
        this.mSurface = (Surface) obj;
    }

    @Override // android.view.ISurfaceSocExt
    public boolean hookLockCanvas() {
        return false;
    }
}
