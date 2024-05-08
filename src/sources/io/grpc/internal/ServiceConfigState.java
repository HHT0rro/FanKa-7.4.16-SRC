package io.grpc.internal;

import com.google.common.base.o;
import io.grpc.NameResolver;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ServiceConfigState {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private NameResolver.ConfigOrError currentServiceConfigOrError;
    private final NameResolver.ConfigOrError defaultServiceConfig;
    private final boolean lookUpServiceConfig;
    private boolean updated;

    public ServiceConfigState(ManagedChannelServiceConfig managedChannelServiceConfig, boolean z10) {
        if (managedChannelServiceConfig == null) {
            this.defaultServiceConfig = null;
        } else {
            this.defaultServiceConfig = NameResolver.ConfigOrError.fromConfig(managedChannelServiceConfig);
        }
        this.lookUpServiceConfig = z10;
        if (z10) {
            return;
        }
        this.currentServiceConfigOrError = this.defaultServiceConfig;
    }

    public boolean expectUpdates() {
        return this.lookUpServiceConfig;
    }

    public NameResolver.ConfigOrError getCurrent() {
        o.y(!shouldWaitOnServiceConfig(), "still waiting on service config");
        return this.currentServiceConfigOrError;
    }

    public boolean shouldWaitOnServiceConfig() {
        return !this.updated && expectUpdates();
    }

    public void update(NameResolver.ConfigOrError configOrError) {
        o.y(expectUpdates(), "unexpected service config update");
        boolean z10 = !this.updated;
        this.updated = true;
        if (z10) {
            if (configOrError == null) {
                this.currentServiceConfigOrError = this.defaultServiceConfig;
                return;
            }
            if (configOrError.getError() != null) {
                NameResolver.ConfigOrError configOrError2 = this.defaultServiceConfig;
                if (configOrError2 != null) {
                    this.currentServiceConfigOrError = configOrError2;
                    return;
                } else {
                    this.currentServiceConfigOrError = configOrError;
                    return;
                }
            }
            this.currentServiceConfigOrError = configOrError;
            return;
        }
        if (configOrError == null) {
            NameResolver.ConfigOrError configOrError3 = this.defaultServiceConfig;
            if (configOrError3 != null) {
                this.currentServiceConfigOrError = configOrError3;
                return;
            } else {
                this.currentServiceConfigOrError = null;
                return;
            }
        }
        if (configOrError.getError() != null) {
            NameResolver.ConfigOrError configOrError4 = this.currentServiceConfigOrError;
            if (configOrError4 == null || configOrError4.getError() == null) {
                return;
            }
            this.currentServiceConfigOrError = configOrError;
            return;
        }
        this.currentServiceConfigOrError = configOrError;
    }
}
