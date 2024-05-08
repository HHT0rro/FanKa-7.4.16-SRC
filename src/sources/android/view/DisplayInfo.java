package android.view;

import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.display.DeviceProductInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.ArraySet;
import android.util.DisplayMetrics;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.SurfaceControl;
import com.alipay.sdk.util.i;
import com.android.internal.display.BrightnessSynchronizer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class DisplayInfo implements Parcelable {
    public static final Parcelable.Creator<DisplayInfo> CREATOR = new Parcelable.Creator<DisplayInfo>() { // from class: android.view.DisplayInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisplayInfo createFromParcel(Parcel source) {
            return new DisplayInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisplayInfo[] newArray(int size) {
            return new DisplayInfo[size];
        }
    };
    public DisplayAddress address;
    public int appHeight;
    public long appVsyncOffsetNanos;
    public int appWidth;
    public float brightnessDefault;
    public float brightnessMaximum;
    public float brightnessMinimum;
    public int colorMode;
    public int committedState;
    public int defaultModeId;
    public DeviceProductInfo deviceProductInfo;
    public DisplayCutout displayCutout;
    public int displayGroupId;
    public int displayId;
    public DisplayShape displayShape;
    public int flags;
    public Display.HdrCapabilities hdrCapabilities;
    public float hdrSdrRatio;
    public int installOrientation;
    public int largestNominalAppHeight;
    public int largestNominalAppWidth;
    public int layerStack;
    public SurfaceControl.RefreshRateRange layoutLimitedRefreshRate;
    public int logicalDensityDpi;
    public int logicalHeight;
    public int logicalWidth;
    IDisplayInfoExt mDisplayInfoExt;
    public boolean minimalPostProcessingSupported;
    public int modeId;
    public String name;
    public String ownerPackageName;
    public int ownerUid;
    public float physicalXDpi;
    public float physicalYDpi;
    public long presentationDeadlineNanos;
    public float refreshRateOverride;
    public int removeMode;
    public float renderFrameRate;
    public int rotation;
    public RoundedCorners roundedCorners;
    public int smallestNominalAppHeight;
    public int smallestNominalAppWidth;
    public int state;
    public int[] supportedColorModes;
    public Display.Mode[] supportedModes;
    public String thermalBrightnessThrottlingDataId;
    public SparseArray<SurfaceControl.RefreshRateRange> thermalRefreshRateThrottling;
    public int type;
    public String uniqueId;
    public int[] userDisabledHdrTypes;

    public DisplayInfo() {
        this.supportedModes = Display.Mode.EMPTY_ARRAY;
        this.supportedColorModes = new int[]{0};
        this.userDisabledHdrTypes = new int[0];
        this.removeMode = 0;
        this.hdrSdrRatio = Float.NaN;
        this.thermalRefreshRateThrottling = new SparseArray<>();
        this.mDisplayInfoExt = (IDisplayInfoExt) ExtLoader.type(IDisplayInfoExt.class).base(this).create();
    }

    public DisplayInfo(DisplayInfo other) {
        this.supportedModes = Display.Mode.EMPTY_ARRAY;
        this.supportedColorModes = new int[]{0};
        this.userDisabledHdrTypes = new int[0];
        this.removeMode = 0;
        this.hdrSdrRatio = Float.NaN;
        this.thermalRefreshRateThrottling = new SparseArray<>();
        this.mDisplayInfoExt = (IDisplayInfoExt) ExtLoader.type(IDisplayInfoExt.class).base(this).create();
        copyFrom(other);
    }

    private DisplayInfo(Parcel source) {
        this.supportedModes = Display.Mode.EMPTY_ARRAY;
        this.supportedColorModes = new int[]{0};
        this.userDisabledHdrTypes = new int[0];
        this.removeMode = 0;
        this.hdrSdrRatio = Float.NaN;
        this.thermalRefreshRateThrottling = new SparseArray<>();
        this.mDisplayInfoExt = (IDisplayInfoExt) ExtLoader.type(IDisplayInfoExt.class).base(this).create();
        readFromParcel(source);
    }

    public boolean equals(Object o10) {
        return (o10 instanceof DisplayInfo) && equals((DisplayInfo) o10);
    }

    public boolean equals(DisplayInfo other) {
        return other != null && this.layerStack == other.layerStack && this.flags == other.flags && this.type == other.type && this.displayId == other.displayId && this.displayGroupId == other.displayGroupId && Objects.equals(this.address, other.address) && Objects.equals(this.deviceProductInfo, other.deviceProductInfo) && Objects.equals(this.uniqueId, other.uniqueId) && this.appWidth == other.appWidth && this.appHeight == other.appHeight && this.smallestNominalAppWidth == other.smallestNominalAppWidth && this.smallestNominalAppHeight == other.smallestNominalAppHeight && this.largestNominalAppWidth == other.largestNominalAppWidth && this.largestNominalAppHeight == other.largestNominalAppHeight && this.logicalWidth == other.logicalWidth && this.logicalHeight == other.logicalHeight && Objects.equals(this.displayCutout, other.displayCutout) && this.rotation == other.rotation && this.modeId == other.modeId && this.renderFrameRate == other.renderFrameRate && this.defaultModeId == other.defaultModeId && Arrays.equals(this.supportedModes, other.supportedModes) && this.colorMode == other.colorMode && Arrays.equals(this.supportedColorModes, other.supportedColorModes) && Objects.equals(this.hdrCapabilities, other.hdrCapabilities) && Arrays.equals(this.userDisabledHdrTypes, other.userDisabledHdrTypes) && this.minimalPostProcessingSupported == other.minimalPostProcessingSupported && this.logicalDensityDpi == other.logicalDensityDpi && this.physicalXDpi == other.physicalXDpi && this.physicalYDpi == other.physicalYDpi && this.appVsyncOffsetNanos == other.appVsyncOffsetNanos && this.presentationDeadlineNanos == other.presentationDeadlineNanos && this.state == other.state && this.committedState == other.committedState && this.ownerUid == other.ownerUid && Objects.equals(this.ownerPackageName, other.ownerPackageName) && this.removeMode == other.removeMode && getRefreshRate() == other.getRefreshRate() && this.brightnessMinimum == other.brightnessMinimum && this.brightnessMaximum == other.brightnessMaximum && this.brightnessDefault == other.brightnessDefault && Objects.equals(this.roundedCorners, other.roundedCorners) && this.installOrientation == other.installOrientation && Objects.equals(this.displayShape, other.displayShape) && Objects.equals(this.layoutLimitedRefreshRate, other.layoutLimitedRefreshRate) && BrightnessSynchronizer.floatEquals(this.hdrSdrRatio, other.hdrSdrRatio) && this.thermalRefreshRateThrottling.contentEquals(other.thermalRefreshRateThrottling) && Objects.equals(this.thermalBrightnessThrottlingDataId, other.thermalBrightnessThrottlingDataId);
    }

    public int hashCode() {
        return 0;
    }

    public void copyFrom(DisplayInfo other) {
        this.layerStack = other.layerStack;
        this.flags = other.flags;
        this.type = other.type;
        this.displayId = other.displayId;
        this.displayGroupId = other.displayGroupId;
        this.address = other.address;
        this.deviceProductInfo = other.deviceProductInfo;
        this.name = other.name;
        this.uniqueId = other.uniqueId;
        this.appWidth = other.appWidth;
        this.appHeight = other.appHeight;
        this.smallestNominalAppWidth = other.smallestNominalAppWidth;
        this.smallestNominalAppHeight = other.smallestNominalAppHeight;
        this.largestNominalAppWidth = other.largestNominalAppWidth;
        this.largestNominalAppHeight = other.largestNominalAppHeight;
        this.logicalWidth = other.logicalWidth;
        this.logicalHeight = other.logicalHeight;
        this.displayCutout = other.displayCutout;
        this.rotation = other.rotation;
        this.modeId = other.modeId;
        this.renderFrameRate = other.renderFrameRate;
        this.defaultModeId = other.defaultModeId;
        Display.Mode[] modeArr = other.supportedModes;
        this.supportedModes = (Display.Mode[]) Arrays.copyOf(modeArr, modeArr.length);
        this.colorMode = other.colorMode;
        int[] iArr = other.supportedColorModes;
        this.supportedColorModes = Arrays.copyOf(iArr, iArr.length);
        this.hdrCapabilities = other.hdrCapabilities;
        this.userDisabledHdrTypes = other.userDisabledHdrTypes;
        this.minimalPostProcessingSupported = other.minimalPostProcessingSupported;
        this.logicalDensityDpi = other.logicalDensityDpi;
        this.physicalXDpi = other.physicalXDpi;
        this.physicalYDpi = other.physicalYDpi;
        this.appVsyncOffsetNanos = other.appVsyncOffsetNanos;
        this.presentationDeadlineNanos = other.presentationDeadlineNanos;
        this.state = other.state;
        this.committedState = other.committedState;
        this.ownerUid = other.ownerUid;
        this.ownerPackageName = other.ownerPackageName;
        this.removeMode = other.removeMode;
        this.refreshRateOverride = other.refreshRateOverride;
        this.brightnessMinimum = other.brightnessMinimum;
        this.brightnessMaximum = other.brightnessMaximum;
        this.brightnessDefault = other.brightnessDefault;
        this.roundedCorners = other.roundedCorners;
        this.installOrientation = other.installOrientation;
        this.displayShape = other.displayShape;
        this.layoutLimitedRefreshRate = other.layoutLimitedRefreshRate;
        this.hdrSdrRatio = other.hdrSdrRatio;
        this.thermalRefreshRateThrottling = other.thermalRefreshRateThrottling;
        this.thermalBrightnessThrottlingDataId = other.thermalBrightnessThrottlingDataId;
    }

    public void readFromParcel(Parcel source) {
        this.layerStack = source.readInt();
        this.flags = source.readInt();
        this.type = source.readInt();
        this.displayId = source.readInt();
        this.displayGroupId = source.readInt();
        this.address = (DisplayAddress) source.readParcelable(null, DisplayAddress.class);
        this.deviceProductInfo = (DeviceProductInfo) source.readParcelable(null, DeviceProductInfo.class);
        this.name = source.readString8();
        this.appWidth = source.readInt();
        this.appHeight = source.readInt();
        this.smallestNominalAppWidth = source.readInt();
        this.smallestNominalAppHeight = source.readInt();
        this.largestNominalAppWidth = source.readInt();
        this.largestNominalAppHeight = source.readInt();
        this.logicalWidth = source.readInt();
        this.logicalHeight = source.readInt();
        this.displayCutout = DisplayCutout.ParcelableWrapper.readCutoutFromParcel(source);
        this.rotation = source.readInt();
        this.modeId = source.readInt();
        this.renderFrameRate = source.readFloat();
        this.defaultModeId = source.readInt();
        int nModes = source.readInt();
        this.supportedModes = new Display.Mode[nModes];
        for (int i10 = 0; i10 < nModes; i10++) {
            this.supportedModes[i10] = Display.Mode.CREATOR.createFromParcel(source);
        }
        int i11 = source.readInt();
        this.colorMode = i11;
        int nColorModes = source.readInt();
        this.supportedColorModes = new int[nColorModes];
        for (int i12 = 0; i12 < nColorModes; i12++) {
            this.supportedColorModes[i12] = source.readInt();
        }
        this.hdrCapabilities = (Display.HdrCapabilities) source.readParcelable(null, Display.HdrCapabilities.class);
        this.minimalPostProcessingSupported = source.readBoolean();
        this.logicalDensityDpi = source.readInt();
        this.physicalXDpi = source.readFloat();
        this.physicalYDpi = source.readFloat();
        this.appVsyncOffsetNanos = source.readLong();
        this.presentationDeadlineNanos = source.readLong();
        this.state = source.readInt();
        this.committedState = source.readInt();
        this.ownerUid = source.readInt();
        this.ownerPackageName = source.readString8();
        this.uniqueId = source.readString8();
        this.removeMode = source.readInt();
        this.refreshRateOverride = source.readFloat();
        this.brightnessMinimum = source.readFloat();
        this.brightnessMaximum = source.readFloat();
        this.brightnessDefault = source.readFloat();
        this.roundedCorners = (RoundedCorners) source.readTypedObject(RoundedCorners.CREATOR);
        int numUserDisabledFormats = source.readInt();
        this.userDisabledHdrTypes = new int[numUserDisabledFormats];
        for (int i13 = 0; i13 < numUserDisabledFormats; i13++) {
            this.userDisabledHdrTypes[i13] = source.readInt();
        }
        int i14 = source.readInt();
        this.installOrientation = i14;
        this.displayShape = (DisplayShape) source.readTypedObject(DisplayShape.CREATOR);
        this.layoutLimitedRefreshRate = (SurfaceControl.RefreshRateRange) source.readTypedObject(SurfaceControl.RefreshRateRange.CREATOR);
        this.hdrSdrRatio = source.readFloat();
        this.thermalRefreshRateThrottling = source.readSparseArray(null, SurfaceControl.RefreshRateRange.class);
        this.thermalBrightnessThrottlingDataId = source.readString8();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.layerStack);
        dest.writeInt(this.flags);
        dest.writeInt(this.type);
        dest.writeInt(this.displayId);
        dest.writeInt(this.displayGroupId);
        dest.writeParcelable(this.address, flags);
        dest.writeParcelable(this.deviceProductInfo, flags);
        dest.writeString8(this.name);
        dest.writeInt(this.appWidth);
        dest.writeInt(this.appHeight);
        dest.writeInt(this.smallestNominalAppWidth);
        dest.writeInt(this.smallestNominalAppHeight);
        dest.writeInt(this.largestNominalAppWidth);
        dest.writeInt(this.largestNominalAppHeight);
        dest.writeInt(this.logicalWidth);
        dest.writeInt(this.logicalHeight);
        DisplayCutout.ParcelableWrapper.writeCutoutToParcel(this.displayCutout, dest, flags);
        dest.writeInt(this.rotation);
        dest.writeInt(this.modeId);
        dest.writeFloat(this.renderFrameRate);
        dest.writeInt(this.defaultModeId);
        dest.writeInt(this.supportedModes.length);
        int i10 = 0;
        while (true) {
            Display.Mode[] modeArr = this.supportedModes;
            if (i10 >= modeArr.length) {
                break;
            }
            modeArr[i10].writeToParcel(dest, flags);
            i10++;
        }
        int i11 = this.colorMode;
        dest.writeInt(i11);
        dest.writeInt(this.supportedColorModes.length);
        int i12 = 0;
        while (true) {
            int[] iArr = this.supportedColorModes;
            if (i12 >= iArr.length) {
                break;
            }
            dest.writeInt(iArr[i12]);
            i12++;
        }
        dest.writeParcelable(this.hdrCapabilities, flags);
        dest.writeBoolean(this.minimalPostProcessingSupported);
        dest.writeInt(this.logicalDensityDpi);
        dest.writeFloat(this.physicalXDpi);
        dest.writeFloat(this.physicalYDpi);
        dest.writeLong(this.appVsyncOffsetNanos);
        dest.writeLong(this.presentationDeadlineNanos);
        dest.writeInt(this.state);
        dest.writeInt(this.committedState);
        dest.writeInt(this.ownerUid);
        dest.writeString8(this.ownerPackageName);
        dest.writeString8(this.uniqueId);
        dest.writeInt(this.removeMode);
        dest.writeFloat(this.refreshRateOverride);
        dest.writeFloat(this.brightnessMinimum);
        dest.writeFloat(this.brightnessMaximum);
        dest.writeFloat(this.brightnessDefault);
        dest.writeTypedObject(this.roundedCorners, flags);
        dest.writeInt(this.userDisabledHdrTypes.length);
        int i13 = 0;
        while (true) {
            int[] iArr2 = this.userDisabledHdrTypes;
            if (i13 < iArr2.length) {
                dest.writeInt(iArr2[i13]);
                i13++;
            } else {
                int i14 = this.installOrientation;
                dest.writeInt(i14);
                dest.writeTypedObject(this.displayShape, flags);
                dest.writeTypedObject(this.layoutLimitedRefreshRate, flags);
                dest.writeFloat(this.hdrSdrRatio);
                dest.writeSparseArray(this.thermalRefreshRateThrottling);
                dest.writeString8(this.thermalBrightnessThrottlingDataId);
                return;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getRefreshRate() {
        float f10 = this.refreshRateOverride;
        if (f10 > 0.0f) {
            return f10;
        }
        if (this.supportedModes.length == 0) {
            return 0.0f;
        }
        return getMode().getRefreshRate();
    }

    public Display.Mode getMode() {
        return findMode(this.modeId);
    }

    public Display.Mode getDefaultMode() {
        return findMode(this.defaultModeId);
    }

    private Display.Mode findMode(int id2) {
        int i10 = 0;
        while (true) {
            Display.Mode[] modeArr = this.supportedModes;
            if (i10 < modeArr.length) {
                if (modeArr[i10].getModeId() != id2) {
                    i10++;
                } else {
                    return this.supportedModes[i10];
                }
            } else {
                Slog.d("DisplayInfo", "findMode id = " + id2 + "; " + toString());
                throw new IllegalStateException("Unable to locate mode id=" + id2 + ",supportedModes=" + Arrays.toString(this.supportedModes));
            }
        }
    }

    public Display.Mode findDefaultModeByRefreshRate(float refreshRate) {
        Display.Mode[] modes = this.supportedModes;
        Display.Mode defaultMode = getDefaultMode();
        for (int i10 = 0; i10 < modes.length; i10++) {
            if (modes[i10].matches(defaultMode.getPhysicalWidth(), defaultMode.getPhysicalHeight(), refreshRate)) {
                return modes[i10];
            }
        }
        return null;
    }

    public float[] getDefaultRefreshRates() {
        Display.Mode[] modes = this.supportedModes;
        ArraySet<Float> rates = new ArraySet<>();
        Display.Mode defaultMode = getDefaultMode();
        for (Display.Mode mode : modes) {
            if (mode.getPhysicalWidth() == defaultMode.getPhysicalWidth() && mode.getPhysicalHeight() == defaultMode.getPhysicalHeight()) {
                rates.add(Float.valueOf(mode.getRefreshRate()));
            }
        }
        int i10 = rates.size();
        float[] result = new float[i10];
        int i11 = 0;
        Iterator<Float> it = rates.iterator();
        while (it.hasNext()) {
            Float rate = it.next();
            result[i11] = rate.floatValue();
            i11++;
        }
        return result;
    }

    public void getAppMetrics(DisplayMetrics outMetrics) {
        getAppMetrics(outMetrics, CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO, null);
    }

    public void getAppMetrics(DisplayMetrics outMetrics, DisplayAdjustments displayAdjustments) {
        getMetricsWithSize(outMetrics, displayAdjustments.getCompatibilityInfo(), displayAdjustments.getConfiguration(), this.appWidth, this.appHeight);
    }

    public void getAppMetrics(DisplayMetrics outMetrics, CompatibilityInfo ci, Configuration configuration) {
        getMetricsWithSize(outMetrics, ci, configuration, this.appWidth, this.appHeight);
    }

    public void getLogicalMetrics(DisplayMetrics outMetrics, CompatibilityInfo compatInfo, Configuration configuration) {
        getMetricsWithSize(outMetrics, compatInfo, configuration, this.logicalWidth, this.logicalHeight);
    }

    public void getMaxBoundsMetrics(DisplayMetrics outMetrics, CompatibilityInfo compatInfo, Configuration configuration) {
        Rect bounds = configuration.windowConfiguration.getMaxBounds();
        getMetricsWithSize(outMetrics, compatInfo, null, bounds.width(), bounds.height());
    }

    public int getNaturalWidth() {
        int i10 = this.rotation;
        return (i10 == 0 || i10 == 2) ? this.logicalWidth : this.logicalHeight;
    }

    public int getNaturalHeight() {
        int i10 = this.rotation;
        return (i10 == 0 || i10 == 2) ? this.logicalHeight : this.logicalWidth;
    }

    public boolean isHdr() {
        Display.HdrCapabilities hdrCapabilities = this.hdrCapabilities;
        int[] types = hdrCapabilities != null ? hdrCapabilities.getSupportedHdrTypes() : null;
        return types != null && types.length > 0;
    }

    public boolean isWideColorGamut() {
        for (int colorMode : this.supportedColorModes) {
            if (colorMode == 6 || colorMode > 7) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAccess(int uid) {
        return Display.hasAccess(uid, this.flags, this.ownerUid, this.displayId);
    }

    private void getMetricsWithSize(DisplayMetrics outMetrics, CompatibilityInfo compatInfo, Configuration configuration, int width, int height) {
        int i10 = this.logicalDensityDpi;
        outMetrics.noncompatDensityDpi = i10;
        outMetrics.densityDpi = i10;
        float f10 = this.logicalDensityDpi * 0.00625f;
        outMetrics.noncompatDensity = f10;
        outMetrics.density = f10;
        float f11 = outMetrics.density;
        outMetrics.noncompatScaledDensity = f11;
        outMetrics.scaledDensity = f11;
        float f12 = this.physicalXDpi;
        outMetrics.noncompatXdpi = f12;
        outMetrics.xdpi = f12;
        float f13 = this.physicalYDpi;
        outMetrics.noncompatYdpi = f13;
        outMetrics.ydpi = f13;
        Rect appBounds = configuration != null ? configuration.windowConfiguration.getAppBounds() : null;
        int width2 = appBounds != null ? appBounds.width() : width;
        int height2 = appBounds != null ? appBounds.height() : height;
        outMetrics.widthPixels = width2;
        outMetrics.noncompatWidthPixels = width2;
        outMetrics.heightPixels = height2;
        outMetrics.noncompatHeightPixels = height2;
        boolean applyToSize = configuration != null && appBounds == null;
        compatInfo.applyDisplayMetricsIfNeeded(outMetrics, applyToSize);
        this.mDisplayInfoExt.overrideDisplayMetricsIfNeed(outMetrics, configuration, this.logicalDensityDpi, this.physicalXDpi, this.physicalYDpi);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DisplayInfo{\"");
        sb2.append(this.name);
        sb2.append("\", displayId ");
        sb2.append(this.displayId);
        sb2.append(", displayGroupId ");
        sb2.append(this.displayGroupId);
        sb2.append(flagsToString(this.flags));
        sb2.append(", real ");
        sb2.append(this.logicalWidth);
        sb2.append(" x ");
        sb2.append(this.logicalHeight);
        sb2.append(", largest app ");
        sb2.append(this.largestNominalAppWidth);
        sb2.append(" x ");
        sb2.append(this.largestNominalAppHeight);
        sb2.append(", smallest app ");
        sb2.append(this.smallestNominalAppWidth);
        sb2.append(" x ");
        sb2.append(this.smallestNominalAppHeight);
        sb2.append(", appVsyncOff ");
        sb2.append(this.appVsyncOffsetNanos);
        sb2.append(", presDeadline ");
        sb2.append(this.presentationDeadlineNanos);
        sb2.append(", mode ");
        sb2.append(this.modeId);
        sb2.append(this.renderFrameRate);
        sb2.append(", defaultMode ");
        sb2.append(this.defaultModeId);
        sb2.append(", modes ");
        sb2.append(Arrays.toString(this.supportedModes));
        sb2.append(", hdrCapabilities ");
        sb2.append((Object) this.hdrCapabilities);
        sb2.append(", userDisabledHdrTypes ");
        sb2.append(Arrays.toString(this.userDisabledHdrTypes));
        sb2.append(", minimalPostProcessingSupported ");
        sb2.append(this.minimalPostProcessingSupported);
        sb2.append(", rotation ");
        sb2.append(this.rotation);
        sb2.append(", state ");
        sb2.append(Display.stateToString(this.state));
        sb2.append(", committedState ");
        sb2.append(Display.stateToString(this.committedState));
        if (Process.myUid() != 1000) {
            sb2.append(i.f4738d);
            return sb2.toString();
        }
        sb2.append(", type ");
        sb2.append(Display.typeToString(this.type));
        sb2.append(", uniqueId \"");
        sb2.append(this.uniqueId);
        sb2.append("\", app ");
        sb2.append(this.appWidth);
        sb2.append(" x ");
        sb2.append(this.appHeight);
        sb2.append(", density ");
        sb2.append(this.logicalDensityDpi);
        sb2.append(" (");
        sb2.append(this.physicalXDpi);
        sb2.append(" x ");
        sb2.append(this.physicalYDpi);
        sb2.append(") dpi, layerStack ");
        sb2.append(this.layerStack);
        sb2.append(", colorMode ");
        sb2.append(this.colorMode);
        sb2.append(", supportedColorModes ");
        sb2.append(Arrays.toString(this.supportedColorModes));
        if (this.address != null) {
            sb2.append(", address ").append((Object) this.address);
        }
        sb2.append(", deviceProductInfo ");
        sb2.append((Object) this.deviceProductInfo);
        if (this.ownerUid != 0 || this.ownerPackageName != null) {
            sb2.append(", owner ").append(this.ownerPackageName);
            sb2.append(" (uid ").append(this.ownerUid).append(")");
        }
        sb2.append(", removeMode ");
        sb2.append(this.removeMode);
        sb2.append(", refreshRateOverride ");
        sb2.append(this.refreshRateOverride);
        sb2.append(", brightnessMinimum ");
        sb2.append(this.brightnessMinimum);
        sb2.append(", brightnessMaximum ");
        sb2.append(this.brightnessMaximum);
        sb2.append(", brightnessDefault ");
        sb2.append(this.brightnessDefault);
        sb2.append(", installOrientation ");
        sb2.append(Surface.rotationToString(this.installOrientation));
        sb2.append(", layoutLimitedRefreshRate ");
        sb2.append((Object) this.layoutLimitedRefreshRate);
        sb2.append(", hdrSdrRatio ");
        if (Float.isNaN(this.hdrSdrRatio)) {
            sb2.append("not_available");
        } else {
            sb2.append(this.hdrSdrRatio);
        }
        sb2.append(", thermalRefreshRateThrottling ");
        sb2.append((Object) this.thermalRefreshRateThrottling);
        sb2.append(", thermalBrightnessThrottlingDataId ");
        sb2.append(this.thermalBrightnessThrottlingDataId);
        sb2.append(i.f4738d);
        return sb2.toString();
    }

    public void dumpDebug(ProtoOutputStream protoOutputStream, long fieldId) {
        long token = protoOutputStream.start(fieldId);
        protoOutputStream.write(1120986464257L, this.logicalWidth);
        protoOutputStream.write(1120986464258L, this.logicalHeight);
        protoOutputStream.write(1120986464259L, this.appWidth);
        protoOutputStream.write(1120986464260L, this.appHeight);
        protoOutputStream.write(1138166333445L, this.name);
        protoOutputStream.write(1120986464262L, this.flags);
        DisplayCutout displayCutout = this.displayCutout;
        if (displayCutout != null) {
            displayCutout.dumpDebug(protoOutputStream, 1146756268039L);
        }
        protoOutputStream.end(token);
    }

    private static String flagsToString(int flags) {
        StringBuilder result = new StringBuilder();
        if ((flags & 2) != 0) {
            result.append(", FLAG_SECURE");
        }
        if ((flags & 1) != 0) {
            result.append(", FLAG_SUPPORTS_PROTECTED_BUFFERS");
        }
        if ((flags & 4) != 0) {
            result.append(", FLAG_PRIVATE");
        }
        if ((flags & 8) != 0) {
            result.append(", FLAG_PRESENTATION");
        }
        if ((1073741824 & flags) != 0) {
            result.append(", FLAG_SCALING_DISABLED");
        }
        if ((flags & 16) != 0) {
            result.append(", FLAG_ROUND");
        }
        if ((flags & 32) != 0) {
            result.append(", FLAG_CAN_SHOW_WITH_INSECURE_KEYGUARD");
        }
        if ((flags & 64) != 0) {
            result.append(", FLAG_SHOULD_SHOW_SYSTEM_DECORATIONS");
        }
        if ((flags & 128) != 0) {
            result.append(", FLAG_TRUSTED");
        }
        if ((flags & 256) != 0) {
            result.append(", FLAG_OWN_DISPLAY_GROUP");
        }
        if ((flags & 512) != 0) {
            result.append(", FLAG_ALWAYS_UNLOCKED");
        }
        if ((flags & 1024) != 0) {
            result.append(", FLAG_TOUCH_FEEDBACK_DISABLED");
        }
        if ((flags & 8192) != 0) {
            result.append(", FLAG_REAR_DISPLAY");
        }
        return result.toString();
    }
}
