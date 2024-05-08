package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.api.Authentication;
import com.google.api.Backend;
import com.google.api.Billing;
import com.google.api.Context;
import com.google.api.Control;
import com.google.api.Documentation;
import com.google.api.Endpoint;
import com.google.api.Http;
import com.google.api.LogDescriptor;
import com.google.api.Logging;
import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.Monitoring;
import com.google.api.Quota;
import com.google.api.SourceInfo;
import com.google.api.SystemParameters;
import com.google.api.Usage;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Api;
import com.google.protobuf.ApiOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Enum;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Type;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt32ValueOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import u7.a0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Service extends GeneratedMessageV3 implements ServiceOrBuilder {
    public static final int APIS_FIELD_NUMBER = 3;
    public static final int AUTHENTICATION_FIELD_NUMBER = 11;
    public static final int BACKEND_FIELD_NUMBER = 8;
    public static final int BILLING_FIELD_NUMBER = 26;
    public static final int CONFIG_VERSION_FIELD_NUMBER = 20;
    public static final int CONTEXT_FIELD_NUMBER = 12;
    public static final int CONTROL_FIELD_NUMBER = 21;
    public static final int DOCUMENTATION_FIELD_NUMBER = 6;
    public static final int ENDPOINTS_FIELD_NUMBER = 18;
    public static final int ENUMS_FIELD_NUMBER = 5;
    public static final int HTTP_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 33;
    public static final int LOGGING_FIELD_NUMBER = 27;
    public static final int LOGS_FIELD_NUMBER = 23;
    public static final int METRICS_FIELD_NUMBER = 24;
    public static final int MONITORED_RESOURCES_FIELD_NUMBER = 25;
    public static final int MONITORING_FIELD_NUMBER = 28;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int PRODUCER_PROJECT_ID_FIELD_NUMBER = 22;
    public static final int QUOTA_FIELD_NUMBER = 10;
    public static final int SOURCE_INFO_FIELD_NUMBER = 37;
    public static final int SYSTEM_PARAMETERS_FIELD_NUMBER = 29;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TYPES_FIELD_NUMBER = 4;
    public static final int USAGE_FIELD_NUMBER = 15;
    private static final long serialVersionUID = 0;
    private List<Api> apis_;
    private Authentication authentication_;
    private Backend backend_;
    private Billing billing_;
    private UInt32Value configVersion_;
    private Context context_;
    private Control control_;
    private Documentation documentation_;
    private List<Endpoint> endpoints_;
    private List<Enum> enums_;
    private Http http_;
    private volatile Object id_;
    private Logging logging_;
    private List<LogDescriptor> logs_;
    private byte memoizedIsInitialized;
    private List<MetricDescriptor> metrics_;
    private List<MonitoredResourceDescriptor> monitoredResources_;
    private Monitoring monitoring_;
    private volatile Object name_;
    private volatile Object producerProjectId_;
    private Quota quota_;
    private SourceInfo sourceInfo_;
    private SystemParameters systemParameters_;
    private volatile Object title_;
    private List<Type> types_;
    private Usage usage_;
    private static final Service DEFAULT_INSTANCE = new Service();
    private static final Parser<Service> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ServiceOrBuilder {
        private RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> apisBuilder_;
        private List<Api> apis_;
        private SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> authenticationBuilder_;
        private Authentication authentication_;
        private SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> backendBuilder_;
        private Backend backend_;
        private SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> billingBuilder_;
        private Billing billing_;
        private int bitField0_;
        private SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> configVersionBuilder_;
        private UInt32Value configVersion_;
        private SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> contextBuilder_;
        private Context context_;
        private SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> controlBuilder_;
        private Control control_;
        private SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> documentationBuilder_;
        private Documentation documentation_;
        private RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> endpointsBuilder_;
        private List<Endpoint> endpoints_;
        private RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> enumsBuilder_;
        private List<Enum> enums_;
        private SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> httpBuilder_;
        private Http http_;
        private Object id_;
        private SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> loggingBuilder_;
        private Logging logging_;
        private RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> logsBuilder_;
        private List<LogDescriptor> logs_;
        private RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> metricsBuilder_;
        private List<MetricDescriptor> metrics_;
        private RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> monitoredResourcesBuilder_;
        private List<MonitoredResourceDescriptor> monitoredResources_;
        private SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> monitoringBuilder_;
        private Monitoring monitoring_;
        private Object name_;
        private Object producerProjectId_;
        private SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> quotaBuilder_;
        private Quota quota_;
        private SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> sourceInfoBuilder_;
        private SourceInfo sourceInfo_;
        private SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> systemParametersBuilder_;
        private SystemParameters systemParameters_;
        private Object title_;
        private RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> typesBuilder_;
        private List<Type> types_;
        private SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> usageBuilder_;
        private Usage usage_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureApisIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.apis_ = new ArrayList(this.apis_);
                this.bitField0_ |= 1;
            }
        }

        private void ensureEndpointsIsMutable() {
            if ((this.bitField0_ & 8) == 0) {
                this.endpoints_ = new ArrayList(this.endpoints_);
                this.bitField0_ |= 8;
            }
        }

        private void ensureEnumsIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.enums_ = new ArrayList(this.enums_);
                this.bitField0_ |= 4;
            }
        }

        private void ensureLogsIsMutable() {
            if ((this.bitField0_ & 16) == 0) {
                this.logs_ = new ArrayList(this.logs_);
                this.bitField0_ |= 16;
            }
        }

        private void ensureMetricsIsMutable() {
            if ((this.bitField0_ & 32) == 0) {
                this.metrics_ = new ArrayList(this.metrics_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureMonitoredResourcesIsMutable() {
            if ((this.bitField0_ & 64) == 0) {
                this.monitoredResources_ = new ArrayList(this.monitoredResources_);
                this.bitField0_ |= 64;
            }
        }

        private void ensureTypesIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.types_ = new ArrayList(this.types_);
                this.bitField0_ |= 2;
            }
        }

        private RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> getApisFieldBuilder() {
            if (this.apisBuilder_ == null) {
                this.apisBuilder_ = new RepeatedFieldBuilderV3<>(this.apis_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.apis_ = null;
            }
            return this.apisBuilder_;
        }

        private SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> getAuthenticationFieldBuilder() {
            if (this.authenticationBuilder_ == null) {
                this.authenticationBuilder_ = new SingleFieldBuilderV3<>(getAuthentication(), getParentForChildren(), isClean());
                this.authentication_ = null;
            }
            return this.authenticationBuilder_;
        }

        private SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> getBackendFieldBuilder() {
            if (this.backendBuilder_ == null) {
                this.backendBuilder_ = new SingleFieldBuilderV3<>(getBackend(), getParentForChildren(), isClean());
                this.backend_ = null;
            }
            return this.backendBuilder_;
        }

        private SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> getBillingFieldBuilder() {
            if (this.billingBuilder_ == null) {
                this.billingBuilder_ = new SingleFieldBuilderV3<>(getBilling(), getParentForChildren(), isClean());
                this.billing_ = null;
            }
            return this.billingBuilder_;
        }

        private SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> getConfigVersionFieldBuilder() {
            if (this.configVersionBuilder_ == null) {
                this.configVersionBuilder_ = new SingleFieldBuilderV3<>(getConfigVersion(), getParentForChildren(), isClean());
                this.configVersion_ = null;
            }
            return this.configVersionBuilder_;
        }

        private SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> getContextFieldBuilder() {
            if (this.contextBuilder_ == null) {
                this.contextBuilder_ = new SingleFieldBuilderV3<>(getContext(), getParentForChildren(), isClean());
                this.context_ = null;
            }
            return this.contextBuilder_;
        }

        private SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> getControlFieldBuilder() {
            if (this.controlBuilder_ == null) {
                this.controlBuilder_ = new SingleFieldBuilderV3<>(getControl(), getParentForChildren(), isClean());
                this.control_ = null;
            }
            return this.controlBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return a0.f53831a;
        }

        private SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> getDocumentationFieldBuilder() {
            if (this.documentationBuilder_ == null) {
                this.documentationBuilder_ = new SingleFieldBuilderV3<>(getDocumentation(), getParentForChildren(), isClean());
                this.documentation_ = null;
            }
            return this.documentationBuilder_;
        }

        private RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> getEndpointsFieldBuilder() {
            if (this.endpointsBuilder_ == null) {
                this.endpointsBuilder_ = new RepeatedFieldBuilderV3<>(this.endpoints_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                this.endpoints_ = null;
            }
            return this.endpointsBuilder_;
        }

        private RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> getEnumsFieldBuilder() {
            if (this.enumsBuilder_ == null) {
                this.enumsBuilder_ = new RepeatedFieldBuilderV3<>(this.enums_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                this.enums_ = null;
            }
            return this.enumsBuilder_;
        }

        private SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> getHttpFieldBuilder() {
            if (this.httpBuilder_ == null) {
                this.httpBuilder_ = new SingleFieldBuilderV3<>(getHttp(), getParentForChildren(), isClean());
                this.http_ = null;
            }
            return this.httpBuilder_;
        }

        private SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> getLoggingFieldBuilder() {
            if (this.loggingBuilder_ == null) {
                this.loggingBuilder_ = new SingleFieldBuilderV3<>(getLogging(), getParentForChildren(), isClean());
                this.logging_ = null;
            }
            return this.loggingBuilder_;
        }

        private RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> getLogsFieldBuilder() {
            if (this.logsBuilder_ == null) {
                this.logsBuilder_ = new RepeatedFieldBuilderV3<>(this.logs_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                this.logs_ = null;
            }
            return this.logsBuilder_;
        }

        private RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> getMetricsFieldBuilder() {
            if (this.metricsBuilder_ == null) {
                this.metricsBuilder_ = new RepeatedFieldBuilderV3<>(this.metrics_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                this.metrics_ = null;
            }
            return this.metricsBuilder_;
        }

        private RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesFieldBuilder() {
            if (this.monitoredResourcesBuilder_ == null) {
                this.monitoredResourcesBuilder_ = new RepeatedFieldBuilderV3<>(this.monitoredResources_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                this.monitoredResources_ = null;
            }
            return this.monitoredResourcesBuilder_;
        }

        private SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> getMonitoringFieldBuilder() {
            if (this.monitoringBuilder_ == null) {
                this.monitoringBuilder_ = new SingleFieldBuilderV3<>(getMonitoring(), getParentForChildren(), isClean());
                this.monitoring_ = null;
            }
            return this.monitoringBuilder_;
        }

        private SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> getQuotaFieldBuilder() {
            if (this.quotaBuilder_ == null) {
                this.quotaBuilder_ = new SingleFieldBuilderV3<>(getQuota(), getParentForChildren(), isClean());
                this.quota_ = null;
            }
            return this.quotaBuilder_;
        }

        private SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> getSourceInfoFieldBuilder() {
            if (this.sourceInfoBuilder_ == null) {
                this.sourceInfoBuilder_ = new SingleFieldBuilderV3<>(getSourceInfo(), getParentForChildren(), isClean());
                this.sourceInfo_ = null;
            }
            return this.sourceInfoBuilder_;
        }

        private SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> getSystemParametersFieldBuilder() {
            if (this.systemParametersBuilder_ == null) {
                this.systemParametersBuilder_ = new SingleFieldBuilderV3<>(getSystemParameters(), getParentForChildren(), isClean());
                this.systemParameters_ = null;
            }
            return this.systemParametersBuilder_;
        }

        private RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> getTypesFieldBuilder() {
            if (this.typesBuilder_ == null) {
                this.typesBuilder_ = new RepeatedFieldBuilderV3<>(this.types_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.types_ = null;
            }
            return this.typesBuilder_;
        }

        private SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> getUsageFieldBuilder() {
            if (this.usageBuilder_ == null) {
                this.usageBuilder_ = new SingleFieldBuilderV3<>(getUsage(), getParentForChildren(), isClean());
                this.usage_ = null;
            }
            return this.usageBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getApisFieldBuilder();
                getTypesFieldBuilder();
                getEnumsFieldBuilder();
                getEndpointsFieldBuilder();
                getLogsFieldBuilder();
                getMetricsFieldBuilder();
                getMonitoredResourcesFieldBuilder();
            }
        }

        public Builder addAllApis(Iterable<? extends Api> iterable) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureApisIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.apis_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAllEndpoints(Iterable<? extends Endpoint> iterable) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEndpointsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.endpoints_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAllEnums(Iterable<? extends Enum> iterable) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEnumsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.enums_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAllLogs(Iterable<? extends LogDescriptor> iterable) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureLogsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.logs_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAllMetrics(Iterable<? extends MetricDescriptor> iterable) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMetricsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.metrics_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> iterable) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMonitoredResourcesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.monitoredResources_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAllTypes(Iterable<? extends Type> iterable) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureTypesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.types_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addApis(Api api) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(api);
                ensureApisIsMutable();
                this.apis_.add(api);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(api);
            }
            return this;
        }

        public Api.Builder addApisBuilder() {
            return getApisFieldBuilder().addBuilder(Api.getDefaultInstance());
        }

        public Builder addEndpoints(Endpoint endpoint) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(endpoint);
                ensureEndpointsIsMutable();
                this.endpoints_.add(endpoint);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(endpoint);
            }
            return this;
        }

        public Endpoint.Builder addEndpointsBuilder() {
            return getEndpointsFieldBuilder().addBuilder(Endpoint.getDefaultInstance());
        }

        public Builder addEnums(Enum r22) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(r22);
                ensureEnumsIsMutable();
                this.enums_.add(r22);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(r22);
            }
            return this;
        }

        public Enum.Builder addEnumsBuilder() {
            return getEnumsFieldBuilder().addBuilder(Enum.getDefaultInstance());
        }

        public Builder addLogs(LogDescriptor logDescriptor) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(logDescriptor);
                ensureLogsIsMutable();
                this.logs_.add(logDescriptor);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(logDescriptor);
            }
            return this;
        }

        public LogDescriptor.Builder addLogsBuilder() {
            return getLogsFieldBuilder().addBuilder(LogDescriptor.getDefaultInstance());
        }

        public Builder addMetrics(MetricDescriptor metricDescriptor) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(metricDescriptor);
                ensureMetricsIsMutable();
                this.metrics_.add(metricDescriptor);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(metricDescriptor);
            }
            return this;
        }

        public MetricDescriptor.Builder addMetricsBuilder() {
            return getMetricsFieldBuilder().addBuilder(MetricDescriptor.getDefaultInstance());
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor monitoredResourceDescriptor) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(monitoredResourceDescriptor);
                ensureMonitoredResourcesIsMutable();
                this.monitoredResources_.add(monitoredResourceDescriptor);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(monitoredResourceDescriptor);
            }
            return this;
        }

        public MonitoredResourceDescriptor.Builder addMonitoredResourcesBuilder() {
            return getMonitoredResourcesFieldBuilder().addBuilder(MonitoredResourceDescriptor.getDefaultInstance());
        }

        public Builder addTypes(Type type) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(type);
                ensureTypesIsMutable();
                this.types_.add(type);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(type);
            }
            return this;
        }

        public Type.Builder addTypesBuilder() {
            return getTypesFieldBuilder().addBuilder(Type.getDefaultInstance());
        }

        public Builder clearApis() {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.apis_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearAuthentication() {
            if (this.authenticationBuilder_ == null) {
                this.authentication_ = null;
                onChanged();
            } else {
                this.authentication_ = null;
                this.authenticationBuilder_ = null;
            }
            return this;
        }

        public Builder clearBackend() {
            if (this.backendBuilder_ == null) {
                this.backend_ = null;
                onChanged();
            } else {
                this.backend_ = null;
                this.backendBuilder_ = null;
            }
            return this;
        }

        public Builder clearBilling() {
            if (this.billingBuilder_ == null) {
                this.billing_ = null;
                onChanged();
            } else {
                this.billing_ = null;
                this.billingBuilder_ = null;
            }
            return this;
        }

        @Deprecated
        public Builder clearConfigVersion() {
            if (this.configVersionBuilder_ == null) {
                this.configVersion_ = null;
                onChanged();
            } else {
                this.configVersion_ = null;
                this.configVersionBuilder_ = null;
            }
            return this;
        }

        public Builder clearContext() {
            if (this.contextBuilder_ == null) {
                this.context_ = null;
                onChanged();
            } else {
                this.context_ = null;
                this.contextBuilder_ = null;
            }
            return this;
        }

        public Builder clearControl() {
            if (this.controlBuilder_ == null) {
                this.control_ = null;
                onChanged();
            } else {
                this.control_ = null;
                this.controlBuilder_ = null;
            }
            return this;
        }

        public Builder clearDocumentation() {
            if (this.documentationBuilder_ == null) {
                this.documentation_ = null;
                onChanged();
            } else {
                this.documentation_ = null;
                this.documentationBuilder_ = null;
            }
            return this;
        }

        public Builder clearEndpoints() {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.endpoints_ = Collections.emptyList();
                this.bitField0_ &= -9;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearEnums() {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.enums_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearHttp() {
            if (this.httpBuilder_ == null) {
                this.http_ = null;
                onChanged();
            } else {
                this.http_ = null;
                this.httpBuilder_ = null;
            }
            return this;
        }

        public Builder clearId() {
            this.id_ = Service.getDefaultInstance().getId();
            onChanged();
            return this;
        }

        public Builder clearLogging() {
            if (this.loggingBuilder_ == null) {
                this.logging_ = null;
                onChanged();
            } else {
                this.logging_ = null;
                this.loggingBuilder_ = null;
            }
            return this;
        }

        public Builder clearLogs() {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.logs_ = Collections.emptyList();
                this.bitField0_ &= -17;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearMetrics() {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.metrics_ = Collections.emptyList();
                this.bitField0_ &= -33;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearMonitoredResources() {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.monitoredResources_ = Collections.emptyList();
                this.bitField0_ &= -65;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearMonitoring() {
            if (this.monitoringBuilder_ == null) {
                this.monitoring_ = null;
                onChanged();
            } else {
                this.monitoring_ = null;
                this.monitoringBuilder_ = null;
            }
            return this;
        }

        public Builder clearName() {
            this.name_ = Service.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder clearProducerProjectId() {
            this.producerProjectId_ = Service.getDefaultInstance().getProducerProjectId();
            onChanged();
            return this;
        }

        public Builder clearQuota() {
            if (this.quotaBuilder_ == null) {
                this.quota_ = null;
                onChanged();
            } else {
                this.quota_ = null;
                this.quotaBuilder_ = null;
            }
            return this;
        }

        public Builder clearSourceInfo() {
            if (this.sourceInfoBuilder_ == null) {
                this.sourceInfo_ = null;
                onChanged();
            } else {
                this.sourceInfo_ = null;
                this.sourceInfoBuilder_ = null;
            }
            return this;
        }

        public Builder clearSystemParameters() {
            if (this.systemParametersBuilder_ == null) {
                this.systemParameters_ = null;
                onChanged();
            } else {
                this.systemParameters_ = null;
                this.systemParametersBuilder_ = null;
            }
            return this;
        }

        public Builder clearTitle() {
            this.title_ = Service.getDefaultInstance().getTitle();
            onChanged();
            return this;
        }

        public Builder clearTypes() {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.types_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearUsage() {
            if (this.usageBuilder_ == null) {
                this.usage_ = null;
                onChanged();
            } else {
                this.usage_ = null;
                this.usageBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Api getApis(int i10) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.apis_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public Api.Builder getApisBuilder(int i10) {
            return getApisFieldBuilder().getBuilder(i10);
        }

        public List<Api.Builder> getApisBuilderList() {
            return getApisFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getApisCount() {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.apis_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Api> getApisList() {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.apis_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ApiOrBuilder getApisOrBuilder(int i10) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.apis_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends ApiOrBuilder> getApisOrBuilderList() {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.apis_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public Authentication getAuthentication() {
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Authentication authentication = this.authentication_;
                return authentication == null ? Authentication.getDefaultInstance() : authentication;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Authentication.Builder getAuthenticationBuilder() {
            onChanged();
            return getAuthenticationFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public AuthenticationOrBuilder getAuthenticationOrBuilder() {
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Authentication authentication = this.authentication_;
            return authentication == null ? Authentication.getDefaultInstance() : authentication;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Backend getBackend() {
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
            if (singleFieldBuilderV3 == null) {
                Backend backend = this.backend_;
                return backend == null ? Backend.getDefaultInstance() : backend;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Backend.Builder getBackendBuilder() {
            onChanged();
            return getBackendFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public BackendOrBuilder getBackendOrBuilder() {
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Backend backend = this.backend_;
            return backend == null ? Backend.getDefaultInstance() : backend;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Billing getBilling() {
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
            if (singleFieldBuilderV3 == null) {
                Billing billing = this.billing_;
                return billing == null ? Billing.getDefaultInstance() : billing;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Billing.Builder getBillingBuilder() {
            onChanged();
            return getBillingFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public BillingOrBuilder getBillingOrBuilder() {
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Billing billing = this.billing_;
            return billing == null ? Billing.getDefaultInstance() : billing;
        }

        @Override // com.google.api.ServiceOrBuilder
        @Deprecated
        public UInt32Value getConfigVersion() {
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
            if (singleFieldBuilderV3 == null) {
                UInt32Value uInt32Value = this.configVersion_;
                return uInt32Value == null ? UInt32Value.getDefaultInstance() : uInt32Value;
            }
            return singleFieldBuilderV3.getMessage();
        }

        @Deprecated
        public UInt32Value.Builder getConfigVersionBuilder() {
            onChanged();
            return getConfigVersionFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        @Deprecated
        public UInt32ValueOrBuilder getConfigVersionOrBuilder() {
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            UInt32Value uInt32Value = this.configVersion_;
            return uInt32Value == null ? UInt32Value.getDefaultInstance() : uInt32Value;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Context getContext() {
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
            if (singleFieldBuilderV3 == null) {
                Context context = this.context_;
                return context == null ? Context.getDefaultInstance() : context;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Context.Builder getContextBuilder() {
            onChanged();
            return getContextFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ContextOrBuilder getContextOrBuilder() {
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Context context = this.context_;
            return context == null ? Context.getDefaultInstance() : context;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Control getControl() {
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
            if (singleFieldBuilderV3 == null) {
                Control control = this.control_;
                return control == null ? Control.getDefaultInstance() : control;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Control.Builder getControlBuilder() {
            onChanged();
            return getControlFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ControlOrBuilder getControlOrBuilder() {
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Control control = this.control_;
            return control == null ? Control.getDefaultInstance() : control;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return a0.f53831a;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Documentation getDocumentation() {
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Documentation documentation = this.documentation_;
                return documentation == null ? Documentation.getDefaultInstance() : documentation;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Documentation.Builder getDocumentationBuilder() {
            onChanged();
            return getDocumentationFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public DocumentationOrBuilder getDocumentationOrBuilder() {
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Documentation documentation = this.documentation_;
            return documentation == null ? Documentation.getDefaultInstance() : documentation;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Endpoint getEndpoints(int i10) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.endpoints_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public Endpoint.Builder getEndpointsBuilder(int i10) {
            return getEndpointsFieldBuilder().getBuilder(i10);
        }

        public List<Endpoint.Builder> getEndpointsBuilderList() {
            return getEndpointsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getEndpointsCount() {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.endpoints_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Endpoint> getEndpointsList() {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.endpoints_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public EndpointOrBuilder getEndpointsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.endpoints_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.endpoints_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public Enum getEnums(int i10) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.enums_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public Enum.Builder getEnumsBuilder(int i10) {
            return getEnumsFieldBuilder().getBuilder(i10);
        }

        public List<Enum.Builder> getEnumsBuilderList() {
            return getEnumsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getEnumsCount() {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.enums_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Enum> getEnumsList() {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.enums_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public EnumOrBuilder getEnumsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.enums_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.enums_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public Http getHttp() {
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
            if (singleFieldBuilderV3 == null) {
                Http http = this.http_;
                return http == null ? Http.getDefaultInstance() : http;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Http.Builder getHttpBuilder() {
            onChanged();
            return getHttpFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public HttpOrBuilder getHttpOrBuilder() {
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Http http = this.http_;
            return http == null ? Http.getDefaultInstance() : http;
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.id_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Logging getLogging() {
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
            if (singleFieldBuilderV3 == null) {
                Logging logging = this.logging_;
                return logging == null ? Logging.getDefaultInstance() : logging;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Logging.Builder getLoggingBuilder() {
            onChanged();
            return getLoggingFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public LoggingOrBuilder getLoggingOrBuilder() {
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Logging logging = this.logging_;
            return logging == null ? Logging.getDefaultInstance() : logging;
        }

        @Override // com.google.api.ServiceOrBuilder
        public LogDescriptor getLogs(int i10) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.logs_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public LogDescriptor.Builder getLogsBuilder(int i10) {
            return getLogsFieldBuilder().getBuilder(i10);
        }

        public List<LogDescriptor.Builder> getLogsBuilderList() {
            return getLogsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getLogsCount() {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.logs_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<LogDescriptor> getLogsList() {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.logs_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public LogDescriptorOrBuilder getLogsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.logs_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.logs_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public MetricDescriptor getMetrics(int i10) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.metrics_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public MetricDescriptor.Builder getMetricsBuilder(int i10) {
            return getMetricsFieldBuilder().getBuilder(i10);
        }

        public List<MetricDescriptor.Builder> getMetricsBuilderList() {
            return getMetricsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getMetricsCount() {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.metrics_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<MetricDescriptor> getMetricsList() {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.metrics_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public MetricDescriptorOrBuilder getMetricsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.metrics_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.metrics_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public MonitoredResourceDescriptor getMonitoredResources(int i10) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.monitoredResources_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public MonitoredResourceDescriptor.Builder getMonitoredResourcesBuilder(int i10) {
            return getMonitoredResourcesFieldBuilder().getBuilder(i10);
        }

        public List<MonitoredResourceDescriptor.Builder> getMonitoredResourcesBuilderList() {
            return getMonitoredResourcesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getMonitoredResourcesCount() {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.monitoredResources_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.monitoredResources_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int i10) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.monitoredResources_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.monitoredResources_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public Monitoring getMonitoring() {
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
            if (singleFieldBuilderV3 == null) {
                Monitoring monitoring = this.monitoring_;
                return monitoring == null ? Monitoring.getDefaultInstance() : monitoring;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Monitoring.Builder getMonitoringBuilder() {
            onChanged();
            return getMonitoringFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public MonitoringOrBuilder getMonitoringOrBuilder() {
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Monitoring monitoring = this.monitoring_;
            return monitoring == null ? Monitoring.getDefaultInstance() : monitoring;
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getProducerProjectId() {
            Object obj = this.producerProjectId_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.producerProjectId_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getProducerProjectIdBytes() {
            Object obj = this.producerProjectId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.producerProjectId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Quota getQuota() {
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
            if (singleFieldBuilderV3 == null) {
                Quota quota = this.quota_;
                return quota == null ? Quota.getDefaultInstance() : quota;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Quota.Builder getQuotaBuilder() {
            onChanged();
            return getQuotaFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public QuotaOrBuilder getQuotaOrBuilder() {
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Quota quota = this.quota_;
            return quota == null ? Quota.getDefaultInstance() : quota;
        }

        @Override // com.google.api.ServiceOrBuilder
        public SourceInfo getSourceInfo() {
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                SourceInfo sourceInfo = this.sourceInfo_;
                return sourceInfo == null ? SourceInfo.getDefaultInstance() : sourceInfo;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public SourceInfo.Builder getSourceInfoBuilder() {
            onChanged();
            return getSourceInfoFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public SourceInfoOrBuilder getSourceInfoOrBuilder() {
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            SourceInfo sourceInfo = this.sourceInfo_;
            return sourceInfo == null ? SourceInfo.getDefaultInstance() : sourceInfo;
        }

        @Override // com.google.api.ServiceOrBuilder
        public SystemParameters getSystemParameters() {
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
            if (singleFieldBuilderV3 == null) {
                SystemParameters systemParameters = this.systemParameters_;
                return systemParameters == null ? SystemParameters.getDefaultInstance() : systemParameters;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public SystemParameters.Builder getSystemParametersBuilder() {
            onChanged();
            return getSystemParametersFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public SystemParametersOrBuilder getSystemParametersOrBuilder() {
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            SystemParameters systemParameters = this.systemParameters_;
            return systemParameters == null ? SystemParameters.getDefaultInstance() : systemParameters;
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.title_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Type getTypes(int i10) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.types_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public Type.Builder getTypesBuilder(int i10) {
            return getTypesFieldBuilder().getBuilder(i10);
        }

        public List<Type.Builder> getTypesBuilderList() {
            return getTypesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getTypesCount() {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.types_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Type> getTypesList() {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.types_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public TypeOrBuilder getTypesOrBuilder(int i10) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.types_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends TypeOrBuilder> getTypesOrBuilderList() {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.types_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public Usage getUsage() {
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
            if (singleFieldBuilderV3 == null) {
                Usage usage = this.usage_;
                return usage == null ? Usage.getDefaultInstance() : usage;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Usage.Builder getUsageBuilder() {
            onChanged();
            return getUsageFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public UsageOrBuilder getUsageOrBuilder() {
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Usage usage = this.usage_;
            return usage == null ? Usage.getDefaultInstance() : usage;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasAuthentication() {
            return (this.authenticationBuilder_ == null && this.authentication_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasBackend() {
            return (this.backendBuilder_ == null && this.backend_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasBilling() {
            return (this.billingBuilder_ == null && this.billing_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        @Deprecated
        public boolean hasConfigVersion() {
            return (this.configVersionBuilder_ == null && this.configVersion_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasContext() {
            return (this.contextBuilder_ == null && this.context_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasControl() {
            return (this.controlBuilder_ == null && this.control_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasDocumentation() {
            return (this.documentationBuilder_ == null && this.documentation_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasHttp() {
            return (this.httpBuilder_ == null && this.http_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasLogging() {
            return (this.loggingBuilder_ == null && this.logging_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasMonitoring() {
            return (this.monitoringBuilder_ == null && this.monitoring_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasQuota() {
            return (this.quotaBuilder_ == null && this.quota_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasSourceInfo() {
            return (this.sourceInfoBuilder_ == null && this.sourceInfo_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasSystemParameters() {
            return (this.systemParametersBuilder_ == null && this.systemParameters_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasUsage() {
            return (this.usageBuilder_ == null && this.usage_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return a0.f53832b.ensureFieldAccessorsInitialized(Service.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeAuthentication(Authentication authentication) {
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Authentication authentication2 = this.authentication_;
                if (authentication2 != null) {
                    this.authentication_ = Authentication.newBuilder(authentication2).mergeFrom(authentication).buildPartial();
                } else {
                    this.authentication_ = authentication;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(authentication);
            }
            return this;
        }

        public Builder mergeBackend(Backend backend) {
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
            if (singleFieldBuilderV3 == null) {
                Backend backend2 = this.backend_;
                if (backend2 != null) {
                    this.backend_ = Backend.newBuilder(backend2).mergeFrom(backend).buildPartial();
                } else {
                    this.backend_ = backend;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(backend);
            }
            return this;
        }

        public Builder mergeBilling(Billing billing) {
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
            if (singleFieldBuilderV3 == null) {
                Billing billing2 = this.billing_;
                if (billing2 != null) {
                    this.billing_ = Billing.newBuilder(billing2).mergeFrom(billing).buildPartial();
                } else {
                    this.billing_ = billing;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(billing);
            }
            return this;
        }

        @Deprecated
        public Builder mergeConfigVersion(UInt32Value uInt32Value) {
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
            if (singleFieldBuilderV3 == null) {
                UInt32Value uInt32Value2 = this.configVersion_;
                if (uInt32Value2 != null) {
                    this.configVersion_ = UInt32Value.newBuilder(uInt32Value2).mergeFrom(uInt32Value).buildPartial();
                } else {
                    this.configVersion_ = uInt32Value;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(uInt32Value);
            }
            return this;
        }

        public Builder mergeContext(Context context) {
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
            if (singleFieldBuilderV3 == null) {
                Context context2 = this.context_;
                if (context2 != null) {
                    this.context_ = Context.newBuilder(context2).mergeFrom(context).buildPartial();
                } else {
                    this.context_ = context;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(context);
            }
            return this;
        }

        public Builder mergeControl(Control control) {
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
            if (singleFieldBuilderV3 == null) {
                Control control2 = this.control_;
                if (control2 != null) {
                    this.control_ = Control.newBuilder(control2).mergeFrom(control).buildPartial();
                } else {
                    this.control_ = control;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(control);
            }
            return this;
        }

        public Builder mergeDocumentation(Documentation documentation) {
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Documentation documentation2 = this.documentation_;
                if (documentation2 != null) {
                    this.documentation_ = Documentation.newBuilder(documentation2).mergeFrom(documentation).buildPartial();
                } else {
                    this.documentation_ = documentation;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(documentation);
            }
            return this;
        }

        public Builder mergeHttp(Http http) {
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
            if (singleFieldBuilderV3 == null) {
                Http http2 = this.http_;
                if (http2 != null) {
                    this.http_ = Http.newBuilder(http2).mergeFrom(http).buildPartial();
                } else {
                    this.http_ = http;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(http);
            }
            return this;
        }

        public Builder mergeLogging(Logging logging) {
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
            if (singleFieldBuilderV3 == null) {
                Logging logging2 = this.logging_;
                if (logging2 != null) {
                    this.logging_ = Logging.newBuilder(logging2).mergeFrom(logging).buildPartial();
                } else {
                    this.logging_ = logging;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(logging);
            }
            return this;
        }

        public Builder mergeMonitoring(Monitoring monitoring) {
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
            if (singleFieldBuilderV3 == null) {
                Monitoring monitoring2 = this.monitoring_;
                if (monitoring2 != null) {
                    this.monitoring_ = Monitoring.newBuilder(monitoring2).mergeFrom(monitoring).buildPartial();
                } else {
                    this.monitoring_ = monitoring;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(monitoring);
            }
            return this;
        }

        public Builder mergeQuota(Quota quota) {
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
            if (singleFieldBuilderV3 == null) {
                Quota quota2 = this.quota_;
                if (quota2 != null) {
                    this.quota_ = Quota.newBuilder(quota2).mergeFrom(quota).buildPartial();
                } else {
                    this.quota_ = quota;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(quota);
            }
            return this;
        }

        public Builder mergeSourceInfo(SourceInfo sourceInfo) {
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                SourceInfo sourceInfo2 = this.sourceInfo_;
                if (sourceInfo2 != null) {
                    this.sourceInfo_ = SourceInfo.newBuilder(sourceInfo2).mergeFrom(sourceInfo).buildPartial();
                } else {
                    this.sourceInfo_ = sourceInfo;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(sourceInfo);
            }
            return this;
        }

        public Builder mergeSystemParameters(SystemParameters systemParameters) {
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
            if (singleFieldBuilderV3 == null) {
                SystemParameters systemParameters2 = this.systemParameters_;
                if (systemParameters2 != null) {
                    this.systemParameters_ = SystemParameters.newBuilder(systemParameters2).mergeFrom(systemParameters).buildPartial();
                } else {
                    this.systemParameters_ = systemParameters;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(systemParameters);
            }
            return this;
        }

        public Builder mergeUsage(Usage usage) {
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
            if (singleFieldBuilderV3 == null) {
                Usage usage2 = this.usage_;
                if (usage2 != null) {
                    this.usage_ = Usage.newBuilder(usage2).mergeFrom(usage).buildPartial();
                } else {
                    this.usage_ = usage;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(usage);
            }
            return this;
        }

        public Builder removeApis(int i10) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureApisIsMutable();
                this.apis_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder removeEndpoints(int i10) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEndpointsIsMutable();
                this.endpoints_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder removeEnums(int i10) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEnumsIsMutable();
                this.enums_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder removeLogs(int i10) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureLogsIsMutable();
                this.logs_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder removeMetrics(int i10) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMetricsIsMutable();
                this.metrics_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder removeMonitoredResources(int i10) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMonitoredResourcesIsMutable();
                this.monitoredResources_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder removeTypes(int i10) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureTypesIsMutable();
                this.types_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setApis(int i10, Api api) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(api);
                ensureApisIsMutable();
                this.apis_.set(i10, api);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, api);
            }
            return this;
        }

        public Builder setAuthentication(Authentication authentication) {
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(authentication);
                this.authentication_ = authentication;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(authentication);
            }
            return this;
        }

        public Builder setBackend(Backend backend) {
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(backend);
                this.backend_ = backend;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(backend);
            }
            return this;
        }

        public Builder setBilling(Billing billing) {
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(billing);
                this.billing_ = billing;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(billing);
            }
            return this;
        }

        @Deprecated
        public Builder setConfigVersion(UInt32Value uInt32Value) {
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(uInt32Value);
                this.configVersion_ = uInt32Value;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(uInt32Value);
            }
            return this;
        }

        public Builder setContext(Context context) {
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(context);
                this.context_ = context;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(context);
            }
            return this;
        }

        public Builder setControl(Control control) {
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(control);
                this.control_ = control;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(control);
            }
            return this;
        }

        public Builder setDocumentation(Documentation documentation) {
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(documentation);
                this.documentation_ = documentation;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(documentation);
            }
            return this;
        }

        public Builder setEndpoints(int i10, Endpoint endpoint) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(endpoint);
                ensureEndpointsIsMutable();
                this.endpoints_.set(i10, endpoint);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, endpoint);
            }
            return this;
        }

        public Builder setEnums(int i10, Enum r32) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(r32);
                ensureEnumsIsMutable();
                this.enums_.set(i10, r32);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, r32);
            }
            return this;
        }

        public Builder setHttp(Http http) {
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(http);
                this.http_ = http;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(http);
            }
            return this;
        }

        public Builder setId(String str) {
            Objects.requireNonNull(str);
            this.id_ = str;
            onChanged();
            return this;
        }

        public Builder setIdBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.id_ = byteString;
            onChanged();
            return this;
        }

        public Builder setLogging(Logging logging) {
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(logging);
                this.logging_ = logging;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(logging);
            }
            return this;
        }

        public Builder setLogs(int i10, LogDescriptor logDescriptor) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(logDescriptor);
                ensureLogsIsMutable();
                this.logs_.set(i10, logDescriptor);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, logDescriptor);
            }
            return this;
        }

        public Builder setMetrics(int i10, MetricDescriptor metricDescriptor) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(metricDescriptor);
                ensureMetricsIsMutable();
                this.metrics_.set(i10, metricDescriptor);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, metricDescriptor);
            }
            return this;
        }

        public Builder setMonitoredResources(int i10, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(monitoredResourceDescriptor);
                ensureMonitoredResourcesIsMutable();
                this.monitoredResources_.set(i10, monitoredResourceDescriptor);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, monitoredResourceDescriptor);
            }
            return this;
        }

        public Builder setMonitoring(Monitoring monitoring) {
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(monitoring);
                this.monitoring_ = monitoring;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(monitoring);
            }
            return this;
        }

        public Builder setName(String str) {
            Objects.requireNonNull(str);
            this.name_ = str;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            onChanged();
            return this;
        }

        public Builder setProducerProjectId(String str) {
            Objects.requireNonNull(str);
            this.producerProjectId_ = str;
            onChanged();
            return this;
        }

        public Builder setProducerProjectIdBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.producerProjectId_ = byteString;
            onChanged();
            return this;
        }

        public Builder setQuota(Quota quota) {
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(quota);
                this.quota_ = quota;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(quota);
            }
            return this;
        }

        public Builder setSourceInfo(SourceInfo sourceInfo) {
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(sourceInfo);
                this.sourceInfo_ = sourceInfo;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(sourceInfo);
            }
            return this;
        }

        public Builder setSystemParameters(SystemParameters systemParameters) {
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(systemParameters);
                this.systemParameters_ = systemParameters;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(systemParameters);
            }
            return this;
        }

        public Builder setTitle(String str) {
            Objects.requireNonNull(str);
            this.title_ = str;
            onChanged();
            return this;
        }

        public Builder setTitleBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.title_ = byteString;
            onChanged();
            return this;
        }

        public Builder setTypes(int i10, Type type) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(type);
                ensureTypesIsMutable();
                this.types_.set(i10, type);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, type);
            }
            return this;
        }

        public Builder setUsage(Usage usage) {
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(usage);
                this.usage_ = usage;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(usage);
            }
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        public Api.Builder addApisBuilder(int i10) {
            return getApisFieldBuilder().addBuilder(i10, Api.getDefaultInstance());
        }

        public Endpoint.Builder addEndpointsBuilder(int i10) {
            return getEndpointsFieldBuilder().addBuilder(i10, Endpoint.getDefaultInstance());
        }

        public Enum.Builder addEnumsBuilder(int i10) {
            return getEnumsFieldBuilder().addBuilder(i10, Enum.getDefaultInstance());
        }

        public LogDescriptor.Builder addLogsBuilder(int i10) {
            return getLogsFieldBuilder().addBuilder(i10, LogDescriptor.getDefaultInstance());
        }

        public Type.Builder addTypesBuilder(int i10) {
            return getTypesFieldBuilder().addBuilder(i10, Type.getDefaultInstance());
        }

        private Builder() {
            this.name_ = "";
            this.title_ = "";
            this.producerProjectId_ = "";
            this.id_ = "";
            this.apis_ = Collections.emptyList();
            this.types_ = Collections.emptyList();
            this.enums_ = Collections.emptyList();
            this.endpoints_ = Collections.emptyList();
            this.logs_ = Collections.emptyList();
            this.metrics_ = Collections.emptyList();
            this.monitoredResources_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public MetricDescriptor.Builder addMetricsBuilder(int i10) {
            return getMetricsFieldBuilder().addBuilder(i10, MetricDescriptor.getDefaultInstance());
        }

        public MonitoredResourceDescriptor.Builder addMonitoredResourcesBuilder(int i10) {
            return getMonitoredResourcesFieldBuilder().addBuilder(i10, MonitoredResourceDescriptor.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Service build() {
            Service buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Service buildPartial() {
            Service service = new Service(this, (a) null);
            service.name_ = this.name_;
            service.title_ = this.title_;
            service.producerProjectId_ = this.producerProjectId_;
            service.id_ = this.id_;
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.apis_ = Collections.unmodifiableList(this.apis_);
                    this.bitField0_ &= -2;
                }
                service.apis_ = this.apis_;
            } else {
                service.apis_ = repeatedFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV32 = this.typesBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.types_ = Collections.unmodifiableList(this.types_);
                    this.bitField0_ &= -3;
                }
                service.types_ = this.types_;
            } else {
                service.types_ = repeatedFieldBuilderV32.build();
            }
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV33 = this.enumsBuilder_;
            if (repeatedFieldBuilderV33 == null) {
                if ((this.bitField0_ & 4) != 0) {
                    this.enums_ = Collections.unmodifiableList(this.enums_);
                    this.bitField0_ &= -5;
                }
                service.enums_ = this.enums_;
            } else {
                service.enums_ = repeatedFieldBuilderV33.build();
            }
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
            if (singleFieldBuilderV3 == null) {
                service.documentation_ = this.documentation_;
            } else {
                service.documentation_ = singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV32 = this.backendBuilder_;
            if (singleFieldBuilderV32 == null) {
                service.backend_ = this.backend_;
            } else {
                service.backend_ = singleFieldBuilderV32.build();
            }
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV33 = this.httpBuilder_;
            if (singleFieldBuilderV33 == null) {
                service.http_ = this.http_;
            } else {
                service.http_ = singleFieldBuilderV33.build();
            }
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV34 = this.quotaBuilder_;
            if (singleFieldBuilderV34 == null) {
                service.quota_ = this.quota_;
            } else {
                service.quota_ = singleFieldBuilderV34.build();
            }
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV35 = this.authenticationBuilder_;
            if (singleFieldBuilderV35 == null) {
                service.authentication_ = this.authentication_;
            } else {
                service.authentication_ = singleFieldBuilderV35.build();
            }
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV36 = this.contextBuilder_;
            if (singleFieldBuilderV36 == null) {
                service.context_ = this.context_;
            } else {
                service.context_ = singleFieldBuilderV36.build();
            }
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV37 = this.usageBuilder_;
            if (singleFieldBuilderV37 == null) {
                service.usage_ = this.usage_;
            } else {
                service.usage_ = singleFieldBuilderV37.build();
            }
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV34 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV34 == null) {
                if ((this.bitField0_ & 8) != 0) {
                    this.endpoints_ = Collections.unmodifiableList(this.endpoints_);
                    this.bitField0_ &= -9;
                }
                service.endpoints_ = this.endpoints_;
            } else {
                service.endpoints_ = repeatedFieldBuilderV34.build();
            }
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV38 = this.controlBuilder_;
            if (singleFieldBuilderV38 == null) {
                service.control_ = this.control_;
            } else {
                service.control_ = singleFieldBuilderV38.build();
            }
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV35 = this.logsBuilder_;
            if (repeatedFieldBuilderV35 == null) {
                if ((this.bitField0_ & 16) != 0) {
                    this.logs_ = Collections.unmodifiableList(this.logs_);
                    this.bitField0_ &= -17;
                }
                service.logs_ = this.logs_;
            } else {
                service.logs_ = repeatedFieldBuilderV35.build();
            }
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV36 = this.metricsBuilder_;
            if (repeatedFieldBuilderV36 == null) {
                if ((this.bitField0_ & 32) != 0) {
                    this.metrics_ = Collections.unmodifiableList(this.metrics_);
                    this.bitField0_ &= -33;
                }
                service.metrics_ = this.metrics_;
            } else {
                service.metrics_ = repeatedFieldBuilderV36.build();
            }
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV37 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV37 == null) {
                if ((this.bitField0_ & 64) != 0) {
                    this.monitoredResources_ = Collections.unmodifiableList(this.monitoredResources_);
                    this.bitField0_ &= -65;
                }
                service.monitoredResources_ = this.monitoredResources_;
            } else {
                service.monitoredResources_ = repeatedFieldBuilderV37.build();
            }
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV39 = this.billingBuilder_;
            if (singleFieldBuilderV39 == null) {
                service.billing_ = this.billing_;
            } else {
                service.billing_ = singleFieldBuilderV39.build();
            }
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV310 = this.loggingBuilder_;
            if (singleFieldBuilderV310 == null) {
                service.logging_ = this.logging_;
            } else {
                service.logging_ = singleFieldBuilderV310.build();
            }
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV311 = this.monitoringBuilder_;
            if (singleFieldBuilderV311 == null) {
                service.monitoring_ = this.monitoring_;
            } else {
                service.monitoring_ = singleFieldBuilderV311.build();
            }
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV312 = this.systemParametersBuilder_;
            if (singleFieldBuilderV312 == null) {
                service.systemParameters_ = this.systemParameters_;
            } else {
                service.systemParameters_ = singleFieldBuilderV312.build();
            }
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV313 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV313 == null) {
                service.sourceInfo_ = this.sourceInfo_;
            } else {
                service.sourceInfo_ = singleFieldBuilderV313.build();
            }
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV314 = this.configVersionBuilder_;
            if (singleFieldBuilderV314 == null) {
                service.configVersion_ = this.configVersion_;
            } else {
                service.configVersion_ = singleFieldBuilderV314.build();
            }
            onBuilt();
            return service;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Service getDefaultInstanceForType() {
            return Service.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.name_ = "";
            this.title_ = "";
            this.producerProjectId_ = "";
            this.id_ = "";
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.apis_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV32 = this.typesBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                this.types_ = Collections.emptyList();
                this.bitField0_ &= -3;
            } else {
                repeatedFieldBuilderV32.clear();
            }
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV33 = this.enumsBuilder_;
            if (repeatedFieldBuilderV33 == null) {
                this.enums_ = Collections.emptyList();
                this.bitField0_ &= -5;
            } else {
                repeatedFieldBuilderV33.clear();
            }
            if (this.documentationBuilder_ == null) {
                this.documentation_ = null;
            } else {
                this.documentation_ = null;
                this.documentationBuilder_ = null;
            }
            if (this.backendBuilder_ == null) {
                this.backend_ = null;
            } else {
                this.backend_ = null;
                this.backendBuilder_ = null;
            }
            if (this.httpBuilder_ == null) {
                this.http_ = null;
            } else {
                this.http_ = null;
                this.httpBuilder_ = null;
            }
            if (this.quotaBuilder_ == null) {
                this.quota_ = null;
            } else {
                this.quota_ = null;
                this.quotaBuilder_ = null;
            }
            if (this.authenticationBuilder_ == null) {
                this.authentication_ = null;
            } else {
                this.authentication_ = null;
                this.authenticationBuilder_ = null;
            }
            if (this.contextBuilder_ == null) {
                this.context_ = null;
            } else {
                this.context_ = null;
                this.contextBuilder_ = null;
            }
            if (this.usageBuilder_ == null) {
                this.usage_ = null;
            } else {
                this.usage_ = null;
                this.usageBuilder_ = null;
            }
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV34 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV34 == null) {
                this.endpoints_ = Collections.emptyList();
                this.bitField0_ &= -9;
            } else {
                repeatedFieldBuilderV34.clear();
            }
            if (this.controlBuilder_ == null) {
                this.control_ = null;
            } else {
                this.control_ = null;
                this.controlBuilder_ = null;
            }
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV35 = this.logsBuilder_;
            if (repeatedFieldBuilderV35 == null) {
                this.logs_ = Collections.emptyList();
                this.bitField0_ &= -17;
            } else {
                repeatedFieldBuilderV35.clear();
            }
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV36 = this.metricsBuilder_;
            if (repeatedFieldBuilderV36 == null) {
                this.metrics_ = Collections.emptyList();
                this.bitField0_ &= -33;
            } else {
                repeatedFieldBuilderV36.clear();
            }
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV37 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV37 == null) {
                this.monitoredResources_ = Collections.emptyList();
                this.bitField0_ &= -65;
            } else {
                repeatedFieldBuilderV37.clear();
            }
            if (this.billingBuilder_ == null) {
                this.billing_ = null;
            } else {
                this.billing_ = null;
                this.billingBuilder_ = null;
            }
            if (this.loggingBuilder_ == null) {
                this.logging_ = null;
            } else {
                this.logging_ = null;
                this.loggingBuilder_ = null;
            }
            if (this.monitoringBuilder_ == null) {
                this.monitoring_ = null;
            } else {
                this.monitoring_ = null;
                this.monitoringBuilder_ = null;
            }
            if (this.systemParametersBuilder_ == null) {
                this.systemParameters_ = null;
            } else {
                this.systemParameters_ = null;
                this.systemParametersBuilder_ = null;
            }
            if (this.sourceInfoBuilder_ == null) {
                this.sourceInfo_ = null;
            } else {
                this.sourceInfo_ = null;
                this.sourceInfoBuilder_ = null;
            }
            if (this.configVersionBuilder_ == null) {
                this.configVersion_ = null;
            } else {
                this.configVersion_ = null;
                this.configVersionBuilder_ = null;
            }
            return this;
        }

        public Builder setAuthentication(Authentication.Builder builder) {
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.authentication_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setBackend(Backend.Builder builder) {
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.backend_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setBilling(Billing.Builder builder) {
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.billing_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        @Deprecated
        public Builder setConfigVersion(UInt32Value.Builder builder) {
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.configVersion_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setContext(Context.Builder builder) {
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.context_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setControl(Control.Builder builder) {
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.control_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setDocumentation(Documentation.Builder builder) {
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.documentation_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setHttp(Http.Builder builder) {
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.http_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setLogging(Logging.Builder builder) {
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.logging_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setMonitoring(Monitoring.Builder builder) {
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.monitoring_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setQuota(Quota.Builder builder) {
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.quota_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setSourceInfo(SourceInfo.Builder builder) {
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.sourceInfo_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setSystemParameters(SystemParameters.Builder builder) {
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.systemParameters_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setUsage(Usage.Builder builder) {
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.usage_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder addApis(int i10, Api api) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(api);
                ensureApisIsMutable();
                this.apis_.add(i10, api);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, api);
            }
            return this;
        }

        public Builder addEndpoints(int i10, Endpoint endpoint) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(endpoint);
                ensureEndpointsIsMutable();
                this.endpoints_.add(i10, endpoint);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, endpoint);
            }
            return this;
        }

        public Builder addEnums(int i10, Enum r32) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(r32);
                ensureEnumsIsMutable();
                this.enums_.add(i10, r32);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, r32);
            }
            return this;
        }

        public Builder addLogs(int i10, LogDescriptor logDescriptor) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(logDescriptor);
                ensureLogsIsMutable();
                this.logs_.add(i10, logDescriptor);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, logDescriptor);
            }
            return this;
        }

        public Builder addMetrics(int i10, MetricDescriptor metricDescriptor) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(metricDescriptor);
                ensureMetricsIsMutable();
                this.metrics_.add(i10, metricDescriptor);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, metricDescriptor);
            }
            return this;
        }

        public Builder addMonitoredResources(int i10, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(monitoredResourceDescriptor);
                ensureMonitoredResourcesIsMutable();
                this.monitoredResources_.add(i10, monitoredResourceDescriptor);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, monitoredResourceDescriptor);
            }
            return this;
        }

        public Builder addTypes(int i10, Type type) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(type);
                ensureTypesIsMutable();
                this.types_.add(i10, type);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, type);
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Service) {
                return mergeFrom((Service) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setApis(int i10, Api.Builder builder) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureApisIsMutable();
                this.apis_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder setEndpoints(int i10, Endpoint.Builder builder) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEndpointsIsMutable();
                this.endpoints_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder setEnums(int i10, Enum.Builder builder) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEnumsIsMutable();
                this.enums_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder setLogs(int i10, LogDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureLogsIsMutable();
                this.logs_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder setMetrics(int i10, MetricDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMetricsIsMutable();
                this.metrics_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder setMonitoredResources(int i10, MonitoredResourceDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMonitoredResourcesIsMutable();
                this.monitoredResources_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder setTypes(int i10, Type.Builder builder) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureTypesIsMutable();
                this.types_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder mergeFrom(Service service) {
            if (service == Service.getDefaultInstance()) {
                return this;
            }
            if (!service.getName().isEmpty()) {
                this.name_ = service.name_;
                onChanged();
            }
            if (!service.getTitle().isEmpty()) {
                this.title_ = service.title_;
                onChanged();
            }
            if (!service.getProducerProjectId().isEmpty()) {
                this.producerProjectId_ = service.producerProjectId_;
                onChanged();
            }
            if (!service.getId().isEmpty()) {
                this.id_ = service.id_;
                onChanged();
            }
            if (this.apisBuilder_ == null) {
                if (!service.apis_.isEmpty()) {
                    if (this.apis_.isEmpty()) {
                        this.apis_ = service.apis_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureApisIsMutable();
                        this.apis_.addAll(service.apis_);
                    }
                    onChanged();
                }
            } else if (!service.apis_.isEmpty()) {
                if (this.apisBuilder_.isEmpty()) {
                    this.apisBuilder_.dispose();
                    this.apisBuilder_ = null;
                    this.apis_ = service.apis_;
                    this.bitField0_ &= -2;
                    this.apisBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getApisFieldBuilder() : null;
                } else {
                    this.apisBuilder_.addAllMessages(service.apis_);
                }
            }
            if (this.typesBuilder_ == null) {
                if (!service.types_.isEmpty()) {
                    if (this.types_.isEmpty()) {
                        this.types_ = service.types_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureTypesIsMutable();
                        this.types_.addAll(service.types_);
                    }
                    onChanged();
                }
            } else if (!service.types_.isEmpty()) {
                if (this.typesBuilder_.isEmpty()) {
                    this.typesBuilder_.dispose();
                    this.typesBuilder_ = null;
                    this.types_ = service.types_;
                    this.bitField0_ &= -3;
                    this.typesBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getTypesFieldBuilder() : null;
                } else {
                    this.typesBuilder_.addAllMessages(service.types_);
                }
            }
            if (this.enumsBuilder_ == null) {
                if (!service.enums_.isEmpty()) {
                    if (this.enums_.isEmpty()) {
                        this.enums_ = service.enums_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureEnumsIsMutable();
                        this.enums_.addAll(service.enums_);
                    }
                    onChanged();
                }
            } else if (!service.enums_.isEmpty()) {
                if (this.enumsBuilder_.isEmpty()) {
                    this.enumsBuilder_.dispose();
                    this.enumsBuilder_ = null;
                    this.enums_ = service.enums_;
                    this.bitField0_ &= -5;
                    this.enumsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getEnumsFieldBuilder() : null;
                } else {
                    this.enumsBuilder_.addAllMessages(service.enums_);
                }
            }
            if (service.hasDocumentation()) {
                mergeDocumentation(service.getDocumentation());
            }
            if (service.hasBackend()) {
                mergeBackend(service.getBackend());
            }
            if (service.hasHttp()) {
                mergeHttp(service.getHttp());
            }
            if (service.hasQuota()) {
                mergeQuota(service.getQuota());
            }
            if (service.hasAuthentication()) {
                mergeAuthentication(service.getAuthentication());
            }
            if (service.hasContext()) {
                mergeContext(service.getContext());
            }
            if (service.hasUsage()) {
                mergeUsage(service.getUsage());
            }
            if (this.endpointsBuilder_ == null) {
                if (!service.endpoints_.isEmpty()) {
                    if (this.endpoints_.isEmpty()) {
                        this.endpoints_ = service.endpoints_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureEndpointsIsMutable();
                        this.endpoints_.addAll(service.endpoints_);
                    }
                    onChanged();
                }
            } else if (!service.endpoints_.isEmpty()) {
                if (this.endpointsBuilder_.isEmpty()) {
                    this.endpointsBuilder_.dispose();
                    this.endpointsBuilder_ = null;
                    this.endpoints_ = service.endpoints_;
                    this.bitField0_ &= -9;
                    this.endpointsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getEndpointsFieldBuilder() : null;
                } else {
                    this.endpointsBuilder_.addAllMessages(service.endpoints_);
                }
            }
            if (service.hasControl()) {
                mergeControl(service.getControl());
            }
            if (this.logsBuilder_ == null) {
                if (!service.logs_.isEmpty()) {
                    if (this.logs_.isEmpty()) {
                        this.logs_ = service.logs_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureLogsIsMutable();
                        this.logs_.addAll(service.logs_);
                    }
                    onChanged();
                }
            } else if (!service.logs_.isEmpty()) {
                if (this.logsBuilder_.isEmpty()) {
                    this.logsBuilder_.dispose();
                    this.logsBuilder_ = null;
                    this.logs_ = service.logs_;
                    this.bitField0_ &= -17;
                    this.logsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getLogsFieldBuilder() : null;
                } else {
                    this.logsBuilder_.addAllMessages(service.logs_);
                }
            }
            if (this.metricsBuilder_ == null) {
                if (!service.metrics_.isEmpty()) {
                    if (this.metrics_.isEmpty()) {
                        this.metrics_ = service.metrics_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureMetricsIsMutable();
                        this.metrics_.addAll(service.metrics_);
                    }
                    onChanged();
                }
            } else if (!service.metrics_.isEmpty()) {
                if (this.metricsBuilder_.isEmpty()) {
                    this.metricsBuilder_.dispose();
                    this.metricsBuilder_ = null;
                    this.metrics_ = service.metrics_;
                    this.bitField0_ &= -33;
                    this.metricsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getMetricsFieldBuilder() : null;
                } else {
                    this.metricsBuilder_.addAllMessages(service.metrics_);
                }
            }
            if (this.monitoredResourcesBuilder_ == null) {
                if (!service.monitoredResources_.isEmpty()) {
                    if (this.monitoredResources_.isEmpty()) {
                        this.monitoredResources_ = service.monitoredResources_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureMonitoredResourcesIsMutable();
                        this.monitoredResources_.addAll(service.monitoredResources_);
                    }
                    onChanged();
                }
            } else if (!service.monitoredResources_.isEmpty()) {
                if (this.monitoredResourcesBuilder_.isEmpty()) {
                    this.monitoredResourcesBuilder_.dispose();
                    this.monitoredResourcesBuilder_ = null;
                    this.monitoredResources_ = service.monitoredResources_;
                    this.bitField0_ &= -65;
                    this.monitoredResourcesBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getMonitoredResourcesFieldBuilder() : null;
                } else {
                    this.monitoredResourcesBuilder_.addAllMessages(service.monitoredResources_);
                }
            }
            if (service.hasBilling()) {
                mergeBilling(service.getBilling());
            }
            if (service.hasLogging()) {
                mergeLogging(service.getLogging());
            }
            if (service.hasMonitoring()) {
                mergeMonitoring(service.getMonitoring());
            }
            if (service.hasSystemParameters()) {
                mergeSystemParameters(service.getSystemParameters());
            }
            if (service.hasSourceInfo()) {
                mergeSourceInfo(service.getSourceInfo());
            }
            if (service.hasConfigVersion()) {
                mergeConfigVersion(service.getConfigVersion());
            }
            mergeUnknownFields(service.unknownFields);
            onChanged();
            return this;
        }

        public Builder addApis(Api.Builder builder) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureApisIsMutable();
                this.apis_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addEndpoints(Endpoint.Builder builder) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEndpointsIsMutable();
                this.endpoints_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addEnums(Enum.Builder builder) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEnumsIsMutable();
                this.enums_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addLogs(LogDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureLogsIsMutable();
                this.logs_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addMetrics(MetricDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMetricsIsMutable();
                this.metrics_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMonitoredResourcesIsMutable();
                this.monitoredResources_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addTypes(Type.Builder builder) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureTypesIsMutable();
                this.types_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.title_ = "";
            this.producerProjectId_ = "";
            this.id_ = "";
            this.apis_ = Collections.emptyList();
            this.types_ = Collections.emptyList();
            this.enums_ = Collections.emptyList();
            this.endpoints_ = Collections.emptyList();
            this.logs_ = Collections.emptyList();
            this.metrics_ = Collections.emptyList();
            this.monitoredResources_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder addApis(int i10, Api.Builder builder) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureApisIsMutable();
                this.apis_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        public Builder addEndpoints(int i10, Endpoint.Builder builder) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEndpointsIsMutable();
                this.endpoints_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        public Builder addEnums(int i10, Enum.Builder builder) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEnumsIsMutable();
                this.enums_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        public Builder addLogs(int i10, LogDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureLogsIsMutable();
                this.logs_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        public Builder addMetrics(int i10, MetricDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMetricsIsMutable();
                this.metrics_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        public Builder addMonitoredResources(int i10, MonitoredResourceDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMonitoredResourcesIsMutable();
                this.monitoredResources_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        public Builder addTypes(int i10, Type.Builder builder) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureTypesIsMutable();
                this.types_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.Service.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.Service.access$3700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.Service r3 = (com.google.api.Service) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                if (r3 == 0) goto L10
                r2.mergeFrom(r3)
            L10:
                return r2
            L11:
                r3 = move-exception
                goto L21
            L13:
                r3 = move-exception
                com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                com.google.api.Service r4 = (com.google.api.Service) r4     // Catch: java.lang.Throwable -> L11
                java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                throw r3     // Catch: java.lang.Throwable -> L1f
            L1f:
                r3 = move-exception
                r0 = r4
            L21:
                if (r0 == 0) goto L26
                r2.mergeFrom(r0)
            L26:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Service.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Service$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<Service> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Service parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Service(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ Service(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static Service getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return a0.f53831a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Service parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Service) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Service parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Service> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Service)) {
            return super.equals(obj);
        }
        Service service = (Service) obj;
        if (!getName().equals(service.getName()) || !getTitle().equals(service.getTitle()) || !getProducerProjectId().equals(service.getProducerProjectId()) || !getId().equals(service.getId()) || !getApisList().equals(service.getApisList()) || !getTypesList().equals(service.getTypesList()) || !getEnumsList().equals(service.getEnumsList()) || hasDocumentation() != service.hasDocumentation()) {
            return false;
        }
        if ((hasDocumentation() && !getDocumentation().equals(service.getDocumentation())) || hasBackend() != service.hasBackend()) {
            return false;
        }
        if ((hasBackend() && !getBackend().equals(service.getBackend())) || hasHttp() != service.hasHttp()) {
            return false;
        }
        if ((hasHttp() && !getHttp().equals(service.getHttp())) || hasQuota() != service.hasQuota()) {
            return false;
        }
        if ((hasQuota() && !getQuota().equals(service.getQuota())) || hasAuthentication() != service.hasAuthentication()) {
            return false;
        }
        if ((hasAuthentication() && !getAuthentication().equals(service.getAuthentication())) || hasContext() != service.hasContext()) {
            return false;
        }
        if ((hasContext() && !getContext().equals(service.getContext())) || hasUsage() != service.hasUsage()) {
            return false;
        }
        if ((hasUsage() && !getUsage().equals(service.getUsage())) || !getEndpointsList().equals(service.getEndpointsList()) || hasControl() != service.hasControl()) {
            return false;
        }
        if ((hasControl() && !getControl().equals(service.getControl())) || !getLogsList().equals(service.getLogsList()) || !getMetricsList().equals(service.getMetricsList()) || !getMonitoredResourcesList().equals(service.getMonitoredResourcesList()) || hasBilling() != service.hasBilling()) {
            return false;
        }
        if ((hasBilling() && !getBilling().equals(service.getBilling())) || hasLogging() != service.hasLogging()) {
            return false;
        }
        if ((hasLogging() && !getLogging().equals(service.getLogging())) || hasMonitoring() != service.hasMonitoring()) {
            return false;
        }
        if ((hasMonitoring() && !getMonitoring().equals(service.getMonitoring())) || hasSystemParameters() != service.hasSystemParameters()) {
            return false;
        }
        if ((hasSystemParameters() && !getSystemParameters().equals(service.getSystemParameters())) || hasSourceInfo() != service.hasSourceInfo()) {
            return false;
        }
        if ((!hasSourceInfo() || getSourceInfo().equals(service.getSourceInfo())) && hasConfigVersion() == service.hasConfigVersion()) {
            return (!hasConfigVersion() || getConfigVersion().equals(service.getConfigVersion())) && this.unknownFields.equals(service.unknownFields);
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Api getApis(int i10) {
        return this.apis_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getApisCount() {
        return this.apis_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Api> getApisList() {
        return this.apis_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ApiOrBuilder getApisOrBuilder(int i10) {
        return this.apis_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends ApiOrBuilder> getApisOrBuilderList() {
        return this.apis_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Authentication getAuthentication() {
        Authentication authentication = this.authentication_;
        return authentication == null ? Authentication.getDefaultInstance() : authentication;
    }

    @Override // com.google.api.ServiceOrBuilder
    public AuthenticationOrBuilder getAuthenticationOrBuilder() {
        return getAuthentication();
    }

    @Override // com.google.api.ServiceOrBuilder
    public Backend getBackend() {
        Backend backend = this.backend_;
        return backend == null ? Backend.getDefaultInstance() : backend;
    }

    @Override // com.google.api.ServiceOrBuilder
    public BackendOrBuilder getBackendOrBuilder() {
        return getBackend();
    }

    @Override // com.google.api.ServiceOrBuilder
    public Billing getBilling() {
        Billing billing = this.billing_;
        return billing == null ? Billing.getDefaultInstance() : billing;
    }

    @Override // com.google.api.ServiceOrBuilder
    public BillingOrBuilder getBillingOrBuilder() {
        return getBilling();
    }

    @Override // com.google.api.ServiceOrBuilder
    @Deprecated
    public UInt32Value getConfigVersion() {
        UInt32Value uInt32Value = this.configVersion_;
        return uInt32Value == null ? UInt32Value.getDefaultInstance() : uInt32Value;
    }

    @Override // com.google.api.ServiceOrBuilder
    @Deprecated
    public UInt32ValueOrBuilder getConfigVersionOrBuilder() {
        return getConfigVersion();
    }

    @Override // com.google.api.ServiceOrBuilder
    public Context getContext() {
        Context context = this.context_;
        return context == null ? Context.getDefaultInstance() : context;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ContextOrBuilder getContextOrBuilder() {
        return getContext();
    }

    @Override // com.google.api.ServiceOrBuilder
    public Control getControl() {
        Control control = this.control_;
        return control == null ? Control.getDefaultInstance() : control;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ControlOrBuilder getControlOrBuilder() {
        return getControl();
    }

    @Override // com.google.api.ServiceOrBuilder
    public Documentation getDocumentation() {
        Documentation documentation = this.documentation_;
        return documentation == null ? Documentation.getDefaultInstance() : documentation;
    }

    @Override // com.google.api.ServiceOrBuilder
    public DocumentationOrBuilder getDocumentationOrBuilder() {
        return getDocumentation();
    }

    @Override // com.google.api.ServiceOrBuilder
    public Endpoint getEndpoints(int i10) {
        return this.endpoints_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getEndpointsCount() {
        return this.endpoints_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Endpoint> getEndpointsList() {
        return this.endpoints_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public EndpointOrBuilder getEndpointsOrBuilder(int i10) {
        return this.endpoints_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
        return this.endpoints_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Enum getEnums(int i10) {
        return this.enums_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getEnumsCount() {
        return this.enums_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Enum> getEnumsList() {
        return this.enums_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public EnumOrBuilder getEnumsOrBuilder(int i10) {
        return this.enums_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
        return this.enums_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Http getHttp() {
        Http http = this.http_;
        return http == null ? Http.getDefaultInstance() : http;
    }

    @Override // com.google.api.ServiceOrBuilder
    public HttpOrBuilder getHttpOrBuilder() {
        return getHttp();
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getId() {
        Object obj = this.id_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.id_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getIdBytes() {
        Object obj = this.id_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.id_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Logging getLogging() {
        Logging logging = this.logging_;
        return logging == null ? Logging.getDefaultInstance() : logging;
    }

    @Override // com.google.api.ServiceOrBuilder
    public LoggingOrBuilder getLoggingOrBuilder() {
        return getLogging();
    }

    @Override // com.google.api.ServiceOrBuilder
    public LogDescriptor getLogs(int i10) {
        return this.logs_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getLogsCount() {
        return this.logs_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<LogDescriptor> getLogsList() {
        return this.logs_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public LogDescriptorOrBuilder getLogsOrBuilder(int i10) {
        return this.logs_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
        return this.logs_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MetricDescriptor getMetrics(int i10) {
        return this.metrics_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getMetricsCount() {
        return this.metrics_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<MetricDescriptor> getMetricsList() {
        return this.metrics_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MetricDescriptorOrBuilder getMetricsOrBuilder(int i10) {
        return this.metrics_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
        return this.metrics_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MonitoredResourceDescriptor getMonitoredResources(int i10) {
        return this.monitoredResources_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getMonitoredResourcesCount() {
        return this.monitoredResources_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
        return this.monitoredResources_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int i10) {
        return this.monitoredResources_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
        return this.monitoredResources_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Monitoring getMonitoring() {
        Monitoring monitoring = this.monitoring_;
        return monitoring == null ? Monitoring.getDefaultInstance() : monitoring;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MonitoringOrBuilder getMonitoringOrBuilder() {
        return getMonitoring();
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Service> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getProducerProjectId() {
        Object obj = this.producerProjectId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.producerProjectId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getProducerProjectIdBytes() {
        Object obj = this.producerProjectId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.producerProjectId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Quota getQuota() {
        Quota quota = this.quota_;
        return quota == null ? Quota.getDefaultInstance() : quota;
    }

    @Override // com.google.api.ServiceOrBuilder
    public QuotaOrBuilder getQuotaOrBuilder() {
        return getQuota();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = !GeneratedMessageV3.isStringEmpty(this.name_) ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.title_);
        }
        for (int i11 = 0; i11 < this.apis_.size(); i11++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, this.apis_.get(i11));
        }
        for (int i12 = 0; i12 < this.types_.size(); i12++) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, this.types_.get(i12));
        }
        for (int i13 = 0; i13 < this.enums_.size(); i13++) {
            computeStringSize += CodedOutputStream.computeMessageSize(5, this.enums_.get(i13));
        }
        if (this.documentation_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(6, getDocumentation());
        }
        if (this.backend_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(8, getBackend());
        }
        if (this.http_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(9, getHttp());
        }
        if (this.quota_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(10, getQuota());
        }
        if (this.authentication_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(11, getAuthentication());
        }
        if (this.context_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(12, getContext());
        }
        if (this.usage_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(15, getUsage());
        }
        for (int i14 = 0; i14 < this.endpoints_.size(); i14++) {
            computeStringSize += CodedOutputStream.computeMessageSize(18, this.endpoints_.get(i14));
        }
        if (this.configVersion_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(20, getConfigVersion());
        }
        if (this.control_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(21, getControl());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.producerProjectId_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(22, this.producerProjectId_);
        }
        for (int i15 = 0; i15 < this.logs_.size(); i15++) {
            computeStringSize += CodedOutputStream.computeMessageSize(23, this.logs_.get(i15));
        }
        for (int i16 = 0; i16 < this.metrics_.size(); i16++) {
            computeStringSize += CodedOutputStream.computeMessageSize(24, this.metrics_.get(i16));
        }
        for (int i17 = 0; i17 < this.monitoredResources_.size(); i17++) {
            computeStringSize += CodedOutputStream.computeMessageSize(25, this.monitoredResources_.get(i17));
        }
        if (this.billing_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(26, getBilling());
        }
        if (this.logging_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(27, getLogging());
        }
        if (this.monitoring_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(28, getMonitoring());
        }
        if (this.systemParameters_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(29, getSystemParameters());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.id_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(33, this.id_);
        }
        if (this.sourceInfo_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(37, getSourceInfo());
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.api.ServiceOrBuilder
    public SourceInfo getSourceInfo() {
        SourceInfo sourceInfo = this.sourceInfo_;
        return sourceInfo == null ? SourceInfo.getDefaultInstance() : sourceInfo;
    }

    @Override // com.google.api.ServiceOrBuilder
    public SourceInfoOrBuilder getSourceInfoOrBuilder() {
        return getSourceInfo();
    }

    @Override // com.google.api.ServiceOrBuilder
    public SystemParameters getSystemParameters() {
        SystemParameters systemParameters = this.systemParameters_;
        return systemParameters == null ? SystemParameters.getDefaultInstance() : systemParameters;
    }

    @Override // com.google.api.ServiceOrBuilder
    public SystemParametersOrBuilder getSystemParametersOrBuilder() {
        return getSystemParameters();
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getTitle() {
        Object obj = this.title_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.title_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getTitleBytes() {
        Object obj = this.title_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.title_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Type getTypes(int i10) {
        return this.types_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getTypesCount() {
        return this.types_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Type> getTypesList() {
        return this.types_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public TypeOrBuilder getTypesOrBuilder(int i10) {
        return this.types_.get(i10);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends TypeOrBuilder> getTypesOrBuilderList() {
        return this.types_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Usage getUsage() {
        Usage usage = this.usage_;
        return usage == null ? Usage.getDefaultInstance() : usage;
    }

    @Override // com.google.api.ServiceOrBuilder
    public UsageOrBuilder getUsageOrBuilder() {
        return getUsage();
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasAuthentication() {
        return this.authentication_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasBackend() {
        return this.backend_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasBilling() {
        return this.billing_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    @Deprecated
    public boolean hasConfigVersion() {
        return this.configVersion_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasContext() {
        return this.context_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasControl() {
        return this.control_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasDocumentation() {
        return this.documentation_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasHttp() {
        return this.http_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasLogging() {
        return this.logging_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasMonitoring() {
        return this.monitoring_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasQuota() {
        return this.quota_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasSourceInfo() {
        return this.sourceInfo_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasSystemParameters() {
        return this.systemParameters_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasUsage() {
        return this.usage_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getTitle().hashCode()) * 37) + 22) * 53) + getProducerProjectId().hashCode()) * 37) + 33) * 53) + getId().hashCode();
        if (getApisCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getApisList().hashCode();
        }
        if (getTypesCount() > 0) {
            hashCode = (((hashCode * 37) + 4) * 53) + getTypesList().hashCode();
        }
        if (getEnumsCount() > 0) {
            hashCode = (((hashCode * 37) + 5) * 53) + getEnumsList().hashCode();
        }
        if (hasDocumentation()) {
            hashCode = (((hashCode * 37) + 6) * 53) + getDocumentation().hashCode();
        }
        if (hasBackend()) {
            hashCode = (((hashCode * 37) + 8) * 53) + getBackend().hashCode();
        }
        if (hasHttp()) {
            hashCode = (((hashCode * 37) + 9) * 53) + getHttp().hashCode();
        }
        if (hasQuota()) {
            hashCode = (((hashCode * 37) + 10) * 53) + getQuota().hashCode();
        }
        if (hasAuthentication()) {
            hashCode = (((hashCode * 37) + 11) * 53) + getAuthentication().hashCode();
        }
        if (hasContext()) {
            hashCode = (((hashCode * 37) + 12) * 53) + getContext().hashCode();
        }
        if (hasUsage()) {
            hashCode = (((hashCode * 37) + 15) * 53) + getUsage().hashCode();
        }
        if (getEndpointsCount() > 0) {
            hashCode = (((hashCode * 37) + 18) * 53) + getEndpointsList().hashCode();
        }
        if (hasControl()) {
            hashCode = (((hashCode * 37) + 21) * 53) + getControl().hashCode();
        }
        if (getLogsCount() > 0) {
            hashCode = (((hashCode * 37) + 23) * 53) + getLogsList().hashCode();
        }
        if (getMetricsCount() > 0) {
            hashCode = (((hashCode * 37) + 24) * 53) + getMetricsList().hashCode();
        }
        if (getMonitoredResourcesCount() > 0) {
            hashCode = (((hashCode * 37) + 25) * 53) + getMonitoredResourcesList().hashCode();
        }
        if (hasBilling()) {
            hashCode = (((hashCode * 37) + 26) * 53) + getBilling().hashCode();
        }
        if (hasLogging()) {
            hashCode = (((hashCode * 37) + 27) * 53) + getLogging().hashCode();
        }
        if (hasMonitoring()) {
            hashCode = (((hashCode * 37) + 28) * 53) + getMonitoring().hashCode();
        }
        if (hasSystemParameters()) {
            hashCode = (((hashCode * 37) + 29) * 53) + getSystemParameters().hashCode();
        }
        if (hasSourceInfo()) {
            hashCode = (((hashCode * 37) + 37) * 53) + getSourceInfo().hashCode();
        }
        if (hasConfigVersion()) {
            hashCode = (((hashCode * 37) + 20) * 53) + getConfigVersion().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return a0.f53832b.ensureFieldAccessorsInitialized(Service.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b4 = this.memoizedIsInitialized;
        if (b4 == 1) {
            return true;
        }
        if (b4 == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Service();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.title_);
        }
        for (int i10 = 0; i10 < this.apis_.size(); i10++) {
            codedOutputStream.writeMessage(3, this.apis_.get(i10));
        }
        for (int i11 = 0; i11 < this.types_.size(); i11++) {
            codedOutputStream.writeMessage(4, this.types_.get(i11));
        }
        for (int i12 = 0; i12 < this.enums_.size(); i12++) {
            codedOutputStream.writeMessage(5, this.enums_.get(i12));
        }
        if (this.documentation_ != null) {
            codedOutputStream.writeMessage(6, getDocumentation());
        }
        if (this.backend_ != null) {
            codedOutputStream.writeMessage(8, getBackend());
        }
        if (this.http_ != null) {
            codedOutputStream.writeMessage(9, getHttp());
        }
        if (this.quota_ != null) {
            codedOutputStream.writeMessage(10, getQuota());
        }
        if (this.authentication_ != null) {
            codedOutputStream.writeMessage(11, getAuthentication());
        }
        if (this.context_ != null) {
            codedOutputStream.writeMessage(12, getContext());
        }
        if (this.usage_ != null) {
            codedOutputStream.writeMessage(15, getUsage());
        }
        for (int i13 = 0; i13 < this.endpoints_.size(); i13++) {
            codedOutputStream.writeMessage(18, this.endpoints_.get(i13));
        }
        if (this.configVersion_ != null) {
            codedOutputStream.writeMessage(20, getConfigVersion());
        }
        if (this.control_ != null) {
            codedOutputStream.writeMessage(21, getControl());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.producerProjectId_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 22, this.producerProjectId_);
        }
        for (int i14 = 0; i14 < this.logs_.size(); i14++) {
            codedOutputStream.writeMessage(23, this.logs_.get(i14));
        }
        for (int i15 = 0; i15 < this.metrics_.size(); i15++) {
            codedOutputStream.writeMessage(24, this.metrics_.get(i15));
        }
        for (int i16 = 0; i16 < this.monitoredResources_.size(); i16++) {
            codedOutputStream.writeMessage(25, this.monitoredResources_.get(i16));
        }
        if (this.billing_ != null) {
            codedOutputStream.writeMessage(26, getBilling());
        }
        if (this.logging_ != null) {
            codedOutputStream.writeMessage(27, getLogging());
        }
        if (this.monitoring_ != null) {
            codedOutputStream.writeMessage(28, getMonitoring());
        }
        if (this.systemParameters_ != null) {
            codedOutputStream.writeMessage(29, getSystemParameters());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.id_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 33, this.id_);
        }
        if (this.sourceInfo_ != null) {
            codedOutputStream.writeMessage(37, getSourceInfo());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ Service(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(Service service) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(service);
    }

    public static Service parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private Service(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Service parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Service getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static Service parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Service() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.title_ = "";
        this.producerProjectId_ = "";
        this.id_ = "";
        this.apis_ = Collections.emptyList();
        this.types_ = Collections.emptyList();
        this.enums_ = Collections.emptyList();
        this.endpoints_ = Collections.emptyList();
        this.logs_ = Collections.emptyList();
        this.metrics_ = Collections.emptyList();
        this.monitoredResources_ = Collections.emptyList();
    }

    public static Service parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static Service parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Service parseFrom(InputStream inputStream) throws IOException {
        return (Service) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Service parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Service) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Service parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0014. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private Service(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z10 = true;
                            case 10:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            case 18:
                                this.title_ = codedInputStream.readStringRequireUtf8();
                            case 26:
                                if ((i10 & 1) == 0) {
                                    this.apis_ = new ArrayList();
                                    i10 |= 1;
                                }
                                this.apis_.add(codedInputStream.readMessage(Api.parser(), extensionRegistryLite));
                            case 34:
                                if ((i10 & 2) == 0) {
                                    this.types_ = new ArrayList();
                                    i10 |= 2;
                                }
                                this.types_.add(codedInputStream.readMessage(Type.parser(), extensionRegistryLite));
                            case 42:
                                if ((i10 & 4) == 0) {
                                    this.enums_ = new ArrayList();
                                    i10 |= 4;
                                }
                                this.enums_.add(codedInputStream.readMessage(Enum.parser(), extensionRegistryLite));
                            case 50:
                                Documentation documentation = this.documentation_;
                                Documentation.Builder builder = documentation != null ? documentation.toBuilder() : null;
                                Documentation documentation2 = (Documentation) codedInputStream.readMessage(Documentation.parser(), extensionRegistryLite);
                                this.documentation_ = documentation2;
                                if (builder != null) {
                                    builder.mergeFrom(documentation2);
                                    this.documentation_ = builder.buildPartial();
                                }
                            case 66:
                                Backend backend = this.backend_;
                                Backend.Builder builder2 = backend != null ? backend.toBuilder() : null;
                                Backend backend2 = (Backend) codedInputStream.readMessage(Backend.parser(), extensionRegistryLite);
                                this.backend_ = backend2;
                                if (builder2 != null) {
                                    builder2.mergeFrom(backend2);
                                    this.backend_ = builder2.buildPartial();
                                }
                            case 74:
                                Http http = this.http_;
                                Http.Builder builder3 = http != null ? http.toBuilder() : null;
                                Http http2 = (Http) codedInputStream.readMessage(Http.parser(), extensionRegistryLite);
                                this.http_ = http2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(http2);
                                    this.http_ = builder3.buildPartial();
                                }
                            case 82:
                                Quota quota = this.quota_;
                                Quota.Builder builder4 = quota != null ? quota.toBuilder() : null;
                                Quota quota2 = (Quota) codedInputStream.readMessage(Quota.parser(), extensionRegistryLite);
                                this.quota_ = quota2;
                                if (builder4 != null) {
                                    builder4.mergeFrom(quota2);
                                    this.quota_ = builder4.buildPartial();
                                }
                            case 90:
                                Authentication authentication = this.authentication_;
                                Authentication.Builder builder5 = authentication != null ? authentication.toBuilder() : null;
                                Authentication authentication2 = (Authentication) codedInputStream.readMessage(Authentication.parser(), extensionRegistryLite);
                                this.authentication_ = authentication2;
                                if (builder5 != null) {
                                    builder5.mergeFrom(authentication2);
                                    this.authentication_ = builder5.buildPartial();
                                }
                            case 98:
                                Context context = this.context_;
                                Context.Builder builder6 = context != null ? context.toBuilder() : null;
                                Context context2 = (Context) codedInputStream.readMessage(Context.parser(), extensionRegistryLite);
                                this.context_ = context2;
                                if (builder6 != null) {
                                    builder6.mergeFrom(context2);
                                    this.context_ = builder6.buildPartial();
                                }
                            case 122:
                                Usage usage = this.usage_;
                                Usage.Builder builder7 = usage != null ? usage.toBuilder() : null;
                                Usage usage2 = (Usage) codedInputStream.readMessage(Usage.parser(), extensionRegistryLite);
                                this.usage_ = usage2;
                                if (builder7 != null) {
                                    builder7.mergeFrom(usage2);
                                    this.usage_ = builder7.buildPartial();
                                }
                            case 146:
                                if ((i10 & 8) == 0) {
                                    this.endpoints_ = new ArrayList();
                                    i10 |= 8;
                                }
                                this.endpoints_.add(codedInputStream.readMessage(Endpoint.parser(), extensionRegistryLite));
                            case 162:
                                UInt32Value uInt32Value = this.configVersion_;
                                UInt32Value.Builder builder8 = uInt32Value != null ? uInt32Value.toBuilder() : null;
                                UInt32Value uInt32Value2 = (UInt32Value) codedInputStream.readMessage(UInt32Value.parser(), extensionRegistryLite);
                                this.configVersion_ = uInt32Value2;
                                if (builder8 != null) {
                                    builder8.mergeFrom(uInt32Value2);
                                    this.configVersion_ = builder8.buildPartial();
                                }
                            case 170:
                                Control control = this.control_;
                                Control.Builder builder9 = control != null ? control.toBuilder() : null;
                                Control control2 = (Control) codedInputStream.readMessage(Control.parser(), extensionRegistryLite);
                                this.control_ = control2;
                                if (builder9 != null) {
                                    builder9.mergeFrom(control2);
                                    this.control_ = builder9.buildPartial();
                                }
                            case 178:
                                this.producerProjectId_ = codedInputStream.readStringRequireUtf8();
                            case 186:
                                if ((i10 & 16) == 0) {
                                    this.logs_ = new ArrayList();
                                    i10 |= 16;
                                }
                                this.logs_.add(codedInputStream.readMessage(LogDescriptor.parser(), extensionRegistryLite));
                            case 194:
                                if ((i10 & 32) == 0) {
                                    this.metrics_ = new ArrayList();
                                    i10 |= 32;
                                }
                                this.metrics_.add(codedInputStream.readMessage(MetricDescriptor.parser(), extensionRegistryLite));
                            case 202:
                                if ((i10 & 64) == 0) {
                                    this.monitoredResources_ = new ArrayList();
                                    i10 |= 64;
                                }
                                this.monitoredResources_.add(codedInputStream.readMessage(MonitoredResourceDescriptor.parser(), extensionRegistryLite));
                            case 210:
                                Billing billing = this.billing_;
                                Billing.Builder builder10 = billing != null ? billing.toBuilder() : null;
                                Billing billing2 = (Billing) codedInputStream.readMessage(Billing.parser(), extensionRegistryLite);
                                this.billing_ = billing2;
                                if (builder10 != null) {
                                    builder10.mergeFrom(billing2);
                                    this.billing_ = builder10.buildPartial();
                                }
                            case 218:
                                Logging logging = this.logging_;
                                Logging.Builder builder11 = logging != null ? logging.toBuilder() : null;
                                Logging logging2 = (Logging) codedInputStream.readMessage(Logging.parser(), extensionRegistryLite);
                                this.logging_ = logging2;
                                if (builder11 != null) {
                                    builder11.mergeFrom(logging2);
                                    this.logging_ = builder11.buildPartial();
                                }
                            case 226:
                                Monitoring monitoring = this.monitoring_;
                                Monitoring.Builder builder12 = monitoring != null ? monitoring.toBuilder() : null;
                                Monitoring monitoring2 = (Monitoring) codedInputStream.readMessage(Monitoring.parser(), extensionRegistryLite);
                                this.monitoring_ = monitoring2;
                                if (builder12 != null) {
                                    builder12.mergeFrom(monitoring2);
                                    this.monitoring_ = builder12.buildPartial();
                                }
                            case 234:
                                SystemParameters systemParameters = this.systemParameters_;
                                SystemParameters.Builder builder13 = systemParameters != null ? systemParameters.toBuilder() : null;
                                SystemParameters systemParameters2 = (SystemParameters) codedInputStream.readMessage(SystemParameters.parser(), extensionRegistryLite);
                                this.systemParameters_ = systemParameters2;
                                if (builder13 != null) {
                                    builder13.mergeFrom(systemParameters2);
                                    this.systemParameters_ = builder13.buildPartial();
                                }
                            case 266:
                                this.id_ = codedInputStream.readStringRequireUtf8();
                            case 298:
                                SourceInfo sourceInfo = this.sourceInfo_;
                                SourceInfo.Builder builder14 = sourceInfo != null ? sourceInfo.toBuilder() : null;
                                SourceInfo sourceInfo2 = (SourceInfo) codedInputStream.readMessage(SourceInfo.parser(), extensionRegistryLite);
                                this.sourceInfo_ = sourceInfo2;
                                if (builder14 != null) {
                                    builder14.mergeFrom(sourceInfo2);
                                    this.sourceInfo_ = builder14.buildPartial();
                                }
                            default:
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    z10 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (UninitializedMessageException e10) {
                        throw e10.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                    }
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                }
            } finally {
                if ((i10 & 1) != 0) {
                    this.apis_ = Collections.unmodifiableList(this.apis_);
                }
                if ((i10 & 2) != 0) {
                    this.types_ = Collections.unmodifiableList(this.types_);
                }
                if ((i10 & 4) != 0) {
                    this.enums_ = Collections.unmodifiableList(this.enums_);
                }
                if ((i10 & 8) != 0) {
                    this.endpoints_ = Collections.unmodifiableList(this.endpoints_);
                }
                if ((i10 & 16) != 0) {
                    this.logs_ = Collections.unmodifiableList(this.logs_);
                }
                if ((i10 & 32) != 0) {
                    this.metrics_ = Collections.unmodifiableList(this.metrics_);
                }
                if ((i10 & 64) != 0) {
                    this.monitoredResources_ = Collections.unmodifiableList(this.monitoredResources_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }
}
