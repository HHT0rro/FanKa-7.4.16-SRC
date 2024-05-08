package android.window;

import android.app.ActivityManager;
import android.app.WindowConfiguration;
import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.WindowManager;
import android.window.TransitionInfo;
import com.alipay.sdk.util.i;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TransitionFilter implements Parcelable {
    public static final int CONTAINER_ORDER_ANY = 0;
    public static final int CONTAINER_ORDER_TOP = 1;
    public static final Parcelable.Creator<TransitionFilter> CREATOR = new Parcelable.Creator<TransitionFilter>() { // from class: android.window.TransitionFilter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TransitionFilter createFromParcel(Parcel in) {
            return new TransitionFilter(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TransitionFilter[] newArray(int size) {
            return new TransitionFilter[size];
        }
    };
    public int mFlags;
    public int mNotFlags;
    public Requirement[] mRequirements;
    public int[] mTypeSet;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface ContainerOrder {
    }

    public TransitionFilter() {
        this.mTypeSet = null;
        this.mFlags = 0;
        this.mNotFlags = 0;
        this.mRequirements = null;
    }

    private TransitionFilter(Parcel in) {
        this.mTypeSet = null;
        this.mFlags = 0;
        this.mNotFlags = 0;
        this.mRequirements = null;
        this.mTypeSet = in.createIntArray();
        this.mFlags = in.readInt();
        this.mNotFlags = in.readInt();
        this.mRequirements = (Requirement[]) in.createTypedArray(Requirement.CREATOR);
    }

    public boolean matches(TransitionInfo info) {
        if (this.mTypeSet != null) {
            boolean typePass = false;
            int i10 = 0;
            while (true) {
                if (i10 >= this.mTypeSet.length) {
                    break;
                }
                if (info.getType() != this.mTypeSet[i10]) {
                    i10++;
                } else {
                    typePass = true;
                    break;
                }
            }
            if (!typePass) {
                return false;
            }
        }
        int flags = info.getFlags();
        int i11 = this.mFlags;
        if ((flags & i11) != i11 || (info.getFlags() & this.mNotFlags) != 0) {
            return false;
        }
        if (this.mRequirements != null) {
            int i12 = 0;
            while (true) {
                Requirement[] requirementArr = this.mRequirements;
                if (i12 < requirementArr.length) {
                    boolean matches = requirementArr[i12].matches(info);
                    if (matches == this.mRequirements[i12].mNot) {
                        return false;
                    }
                    i12++;
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(this.mTypeSet);
        dest.writeInt(this.mFlags);
        dest.writeInt(this.mNotFlags);
        dest.writeTypedArray(this.mRequirements, flags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{types=[");
        if (this.mTypeSet != null) {
            int i10 = 0;
            while (i10 < this.mTypeSet.length) {
                sb2.append((i10 == 0 ? "" : ",") + WindowManager.transitTypeToString(this.mTypeSet[i10]));
                i10++;
            }
        }
        sb2.append("] flags=0x" + Integer.toHexString(this.mFlags));
        sb2.append("] notFlags=0x" + Integer.toHexString(this.mNotFlags));
        sb2.append(" checks=[");
        if (this.mRequirements != null) {
            int i11 = 0;
            while (i11 < this.mRequirements.length) {
                sb2.append((i11 == 0 ? "" : ",") + ((Object) this.mRequirements[i11]));
                i11++;
            }
        }
        return sb2.append("]}").toString();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Requirement implements Parcelable {
        public static final Parcelable.Creator<Requirement> CREATOR = new Parcelable.Creator<Requirement>() { // from class: android.window.TransitionFilter.Requirement.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Requirement createFromParcel(Parcel in) {
                return new Requirement(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Requirement[] newArray(int size) {
                return new Requirement[size];
            }
        };
        public int mActivityType;
        public int mFlags;
        public int[] mModes;
        public boolean mMustBeIndependent;
        public boolean mMustBeTask;
        public boolean mNot;
        public int mOrder;
        public ComponentName mTopActivity;

        public Requirement() {
            this.mActivityType = 0;
            this.mMustBeIndependent = true;
            this.mNot = false;
            this.mModes = null;
            this.mFlags = 0;
            this.mMustBeTask = false;
            this.mOrder = 0;
        }

        private Requirement(Parcel in) {
            this.mActivityType = 0;
            this.mMustBeIndependent = true;
            this.mNot = false;
            this.mModes = null;
            this.mFlags = 0;
            this.mMustBeTask = false;
            this.mOrder = 0;
            this.mActivityType = in.readInt();
            this.mMustBeIndependent = in.readBoolean();
            this.mNot = in.readBoolean();
            this.mModes = in.createIntArray();
            this.mFlags = in.readInt();
            this.mMustBeTask = in.readBoolean();
            this.mOrder = in.readInt();
            this.mTopActivity = (ComponentName) in.readTypedObject(ComponentName.CREATOR);
        }

        boolean matches(TransitionInfo info) {
            for (int i10 = info.getChanges().size() - 1; i10 >= 0; i10--) {
                TransitionInfo.Change change = info.getChanges().get(i10);
                if ((!this.mMustBeIndependent || TransitionInfo.isIndependent(change, info)) && ((this.mOrder != 1 || i10 <= 0) && ((this.mActivityType == 0 || (change.getTaskInfo() != null && change.getTaskInfo().getActivityType() == this.mActivityType)) && matchesTopActivity(change.getTaskInfo())))) {
                    if (this.mModes != null) {
                        boolean pass = false;
                        int m10 = 0;
                        while (true) {
                            int[] iArr = this.mModes;
                            if (m10 >= iArr.length) {
                                break;
                            }
                            if (iArr[m10] != change.getMode()) {
                                m10++;
                            } else {
                                pass = true;
                                break;
                            }
                        }
                        if (!pass) {
                            continue;
                        }
                    }
                    int flags = change.getFlags();
                    int i11 = this.mFlags;
                    if ((flags & i11) == i11 && (!this.mMustBeTask || change.getTaskInfo() != null)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean matchesTopActivity(ActivityManager.RunningTaskInfo info) {
            if (this.mTopActivity == null) {
                return true;
            }
            if (info == null) {
                return false;
            }
            ComponentName component = info.topActivity;
            return this.mTopActivity.equals(component);
        }

        boolean matches(TransitionRequestInfo request) {
            if (this.mActivityType == 0) {
                return true;
            }
            return request.getTriggerTask() != null && request.getTriggerTask().getActivityType() == this.mActivityType && matchesTopActivity(request.getTriggerTask());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mActivityType);
            dest.writeBoolean(this.mMustBeIndependent);
            dest.writeBoolean(this.mNot);
            dest.writeIntArray(this.mModes);
            dest.writeInt(this.mFlags);
            dest.writeBoolean(this.mMustBeTask);
            dest.writeInt(this.mOrder);
            dest.writeTypedObject(this.mTopActivity, flags);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder out = new StringBuilder();
            out.append('{');
            if (this.mNot) {
                out.append("NOT ");
            }
            out.append("atype=" + WindowConfiguration.activityTypeToString(this.mActivityType));
            out.append(" independent=" + this.mMustBeIndependent);
            out.append(" modes=[");
            if (this.mModes != null) {
                int i10 = 0;
                while (i10 < this.mModes.length) {
                    out.append((i10 == 0 ? "" : ",") + TransitionInfo.modeToString(this.mModes[i10]));
                    i10++;
                }
            }
            out.append("]");
            out.append(" flags=" + TransitionInfo.flagsToString(this.mFlags));
            out.append(" mustBeTask=" + this.mMustBeTask);
            out.append(" order=" + TransitionFilter.containerOrderToString(this.mOrder));
            out.append(" topActivity=").append((Object) this.mTopActivity);
            out.append(i.f4738d);
            return out.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String containerOrderToString(int order) {
        switch (order) {
            case 0:
                return "ANY";
            case 1:
                return "TOP";
            default:
                return "UNKNOWN(" + order + ")";
        }
    }
}