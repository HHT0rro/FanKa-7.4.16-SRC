package android.view;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ViewSocExtImpl implements IViewSocExt {
    private View mView;

    public ViewSocExtImpl(Object obj) {
        this.mView = null;
        this.mView = (View) obj;
    }

    @Override // android.view.IViewSocExt
    public void hookCheckAudioMsgView() {
    }

    @Override // android.view.IViewSocExt
    public void hookPerfHint(int visibility) {
    }
}
