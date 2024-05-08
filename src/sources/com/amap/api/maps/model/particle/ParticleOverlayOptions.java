package com.amap.api.maps.model.particle;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ParticleOverlayOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final Parcelable.Creator<ParticleOverlayOptions> CREATOR = new Parcelable.Creator<ParticleOverlayOptions>() { // from class: com.amap.api.maps.model.particle.ParticleOverlayOptions.1
        private static ParticleOverlayOptions a(Parcel parcel) {
            return new ParticleOverlayOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ParticleOverlayOptions createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ParticleOverlayOptions[] newArray(int i10) {
            return a(i10);
        }

        private static ParticleOverlayOptions[] a(int i10) {
            return new ParticleOverlayOptions[i10];
        }
    };
    private BitmapDescriptor bitmapDescriptor;
    private long duration;
    private boolean isParticleEmissionModuleUpdate;
    private boolean isParticleOverLifeModuleUpdate;
    private boolean isParticleShapeModuleUpdate;
    private boolean isStartColorUpdate;
    private boolean isStartSpeedUpdate;
    private boolean loop;
    private int maxParticles;
    private ParticleEmissionModule particleEmissionModule;
    private long particleLifeTime;
    private ParticleOverLifeModule particleOverLifeModule;
    private ParticleShapeModule particleShapeModule;
    private Object particleShapeModuleObject;
    private ColorGenerate startColor;
    private Object startColorObject;
    private int startParticleH;
    private int startParticleW;
    private VelocityGenerate startSpeed;
    private Object startSpeedObject;
    private boolean visibile;
    private float zIndex;

    public ParticleOverlayOptions() {
        this.zIndex = 1.0f;
        this.maxParticles = 100;
        this.loop = true;
        this.duration = 5000L;
        this.particleLifeTime = 5000L;
        this.startSpeed = null;
        this.startParticleW = 32;
        this.startParticleH = 32;
        this.visibile = true;
        this.isParticleEmissionModuleUpdate = false;
        this.isParticleShapeModuleUpdate = false;
        this.isStartSpeedUpdate = false;
        this.isStartColorUpdate = false;
        this.isParticleOverLifeModuleUpdate = false;
        this.type = "ParticleOptions";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDuration() {
        return this.duration;
    }

    public BitmapDescriptor getIcon() {
        return this.bitmapDescriptor;
    }

    public int getMaxParticles() {
        return this.maxParticles;
    }

    public ParticleEmissionModule getParticleEmissionModule() {
        return this.particleEmissionModule;
    }

    public long getParticleLifeTime() {
        return this.particleLifeTime;
    }

    public ParticleOverLifeModule getParticleOverLifeModule() {
        return this.particleOverLifeModule;
    }

    public ParticleShapeModule getParticleShapeModule() {
        return this.particleShapeModule;
    }

    public ColorGenerate getParticleStartColor() {
        return this.startColor;
    }

    public VelocityGenerate getParticleStartSpeed() {
        return this.startSpeed;
    }

    public int getStartParticleW() {
        return this.startParticleW;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public int getstartParticleH() {
        return this.startParticleH;
    }

    public ParticleOverlayOptions icon(BitmapDescriptor bitmapDescriptor) {
        try {
            this.bitmapDescriptor = bitmapDescriptor;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public boolean isLoop() {
        return this.loop;
    }

    public boolean isVisibile() {
        return this.visibile;
    }

    public ParticleOverlayOptions setDuration(long j10) {
        this.duration = j10;
        return this;
    }

    public ParticleOverlayOptions setLoop(boolean z10) {
        this.loop = z10;
        return this;
    }

    public ParticleOverlayOptions setMaxParticles(int i10) {
        this.maxParticles = i10;
        return this;
    }

    public ParticleOverlayOptions setParticleEmissionModule(ParticleEmissionModule particleEmissionModule) {
        this.particleEmissionModule = particleEmissionModule;
        this.isParticleEmissionModuleUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleLifeTime(long j10) {
        this.particleLifeTime = j10;
        return this;
    }

    public ParticleOverlayOptions setParticleOverLifeModule(ParticleOverLifeModule particleOverLifeModule) {
        this.particleOverLifeModule = particleOverLifeModule;
        this.isParticleOverLifeModuleUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleShapeModule(ParticleShapeModule particleShapeModule) {
        this.particleShapeModule = particleShapeModule;
        this.particleShapeModuleObject = particleShapeModule;
        this.isParticleShapeModuleUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleStartColor(ColorGenerate colorGenerate) {
        this.startColor = colorGenerate;
        this.startColorObject = colorGenerate;
        this.isStartColorUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleStartSpeed(VelocityGenerate velocityGenerate) {
        this.startSpeed = velocityGenerate;
        this.startSpeedObject = velocityGenerate;
        this.isStartSpeedUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setStartParticleSize(int i10, int i11) {
        this.startParticleW = i10;
        this.startParticleH = i11;
        return this;
    }

    public ParticleOverlayOptions setVisible(boolean z10) {
        this.visibile = z10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.bitmapDescriptor, i10);
        parcel.writeFloat(this.zIndex);
        parcel.writeInt(this.maxParticles);
        parcel.writeByte(this.loop ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.duration);
        parcel.writeLong(this.particleLifeTime);
        parcel.writeInt(this.startParticleW);
        parcel.writeInt(this.startParticleH);
        parcel.writeByte(this.visibile ? (byte) 1 : (byte) 0);
    }

    public ParticleOverlayOptions zIndex(float f10) {
        this.zIndex = f10;
        return this;
    }

    @JBindingExclude
    public ParticleOverlayOptions(Parcel parcel) {
        this.zIndex = 1.0f;
        this.maxParticles = 100;
        this.loop = true;
        this.duration = 5000L;
        this.particleLifeTime = 5000L;
        this.startSpeed = null;
        this.startParticleW = 32;
        this.startParticleH = 32;
        this.visibile = true;
        this.isParticleEmissionModuleUpdate = false;
        this.isParticleShapeModuleUpdate = false;
        this.isStartSpeedUpdate = false;
        this.isStartColorUpdate = false;
        this.isParticleOverLifeModuleUpdate = false;
        this.bitmapDescriptor = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        this.zIndex = parcel.readFloat();
        this.maxParticles = parcel.readInt();
        this.loop = parcel.readByte() != 0;
        this.duration = parcel.readLong();
        this.particleLifeTime = parcel.readLong();
        this.startParticleW = parcel.readInt();
        this.startParticleH = parcel.readInt();
        this.visibile = parcel.readByte() != 0;
    }
}
