package com.google.api;

import com.google.protobuf.Api;
import com.google.protobuf.ApiOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.Enum;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Type;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt32ValueOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ServiceOrBuilder extends MessageOrBuilder {
    Api getApis(int i10);

    int getApisCount();

    List<Api> getApisList();

    ApiOrBuilder getApisOrBuilder(int i10);

    List<? extends ApiOrBuilder> getApisOrBuilderList();

    Authentication getAuthentication();

    AuthenticationOrBuilder getAuthenticationOrBuilder();

    Backend getBackend();

    BackendOrBuilder getBackendOrBuilder();

    Billing getBilling();

    BillingOrBuilder getBillingOrBuilder();

    @Deprecated
    UInt32Value getConfigVersion();

    @Deprecated
    UInt32ValueOrBuilder getConfigVersionOrBuilder();

    Context getContext();

    ContextOrBuilder getContextOrBuilder();

    Control getControl();

    ControlOrBuilder getControlOrBuilder();

    Documentation getDocumentation();

    DocumentationOrBuilder getDocumentationOrBuilder();

    Endpoint getEndpoints(int i10);

    int getEndpointsCount();

    List<Endpoint> getEndpointsList();

    EndpointOrBuilder getEndpointsOrBuilder(int i10);

    List<? extends EndpointOrBuilder> getEndpointsOrBuilderList();

    Enum getEnums(int i10);

    int getEnumsCount();

    List<Enum> getEnumsList();

    EnumOrBuilder getEnumsOrBuilder(int i10);

    List<? extends EnumOrBuilder> getEnumsOrBuilderList();

    Http getHttp();

    HttpOrBuilder getHttpOrBuilder();

    String getId();

    ByteString getIdBytes();

    Logging getLogging();

    LoggingOrBuilder getLoggingOrBuilder();

    LogDescriptor getLogs(int i10);

    int getLogsCount();

    List<LogDescriptor> getLogsList();

    LogDescriptorOrBuilder getLogsOrBuilder(int i10);

    List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList();

    MetricDescriptor getMetrics(int i10);

    int getMetricsCount();

    List<MetricDescriptor> getMetricsList();

    MetricDescriptorOrBuilder getMetricsOrBuilder(int i10);

    List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList();

    MonitoredResourceDescriptor getMonitoredResources(int i10);

    int getMonitoredResourcesCount();

    List<MonitoredResourceDescriptor> getMonitoredResourcesList();

    MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int i10);

    List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList();

    Monitoring getMonitoring();

    MonitoringOrBuilder getMonitoringOrBuilder();

    String getName();

    ByteString getNameBytes();

    String getProducerProjectId();

    ByteString getProducerProjectIdBytes();

    Quota getQuota();

    QuotaOrBuilder getQuotaOrBuilder();

    SourceInfo getSourceInfo();

    SourceInfoOrBuilder getSourceInfoOrBuilder();

    SystemParameters getSystemParameters();

    SystemParametersOrBuilder getSystemParametersOrBuilder();

    String getTitle();

    ByteString getTitleBytes();

    Type getTypes(int i10);

    int getTypesCount();

    List<Type> getTypesList();

    TypeOrBuilder getTypesOrBuilder(int i10);

    List<? extends TypeOrBuilder> getTypesOrBuilderList();

    Usage getUsage();

    UsageOrBuilder getUsageOrBuilder();

    boolean hasAuthentication();

    boolean hasBackend();

    boolean hasBilling();

    @Deprecated
    boolean hasConfigVersion();

    boolean hasContext();

    boolean hasControl();

    boolean hasDocumentation();

    boolean hasHttp();

    boolean hasLogging();

    boolean hasMonitoring();

    boolean hasQuota();

    boolean hasSourceInfo();

    boolean hasSystemParameters();

    boolean hasUsage();
}
