package android.view.animation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class BaseInterpolator implements Interpolator {
    private int mChangingConfiguration;

    public int getChangingConfiguration() {
        return this.mChangingConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setChangingConfiguration(int changingConfiguration) {
        this.mChangingConfiguration = changingConfiguration;
    }
}
