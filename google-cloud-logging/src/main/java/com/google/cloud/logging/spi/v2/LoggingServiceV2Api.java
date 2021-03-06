/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.logging.spi.v2;

import com.google.api.MonitoredResource;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.PageAccessor;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for ingesting and querying logs.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
 *   String formattedLogName = LoggingServiceV2Api.formatLogName("[PROJECT]", "[LOG]");
 *   loggingServiceV2Api.deleteLog(formattedLogName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the loggingServiceV2Api object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * ApiCallable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of LoggingServiceV2Settings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * LoggingServiceV2Settings loggingServiceV2Settings = LoggingServiceV2Settings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create(loggingServiceV2Settings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class LoggingServiceV2Api implements AutoCloseable {
  private final LoggingServiceV2Settings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<DeleteLogRequest, Empty> deleteLogCallable;
  private final ApiCallable<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesCallable;
  private final ApiCallable<ListLogEntriesRequest, ListLogEntriesResponse> listLogEntriesCallable;
  private final ApiCallable<ListLogEntriesRequest, PageAccessor<LogEntry>>
      listLogEntriesPagedCallable;
  private final ApiCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable;
  private final ApiCallable<
          ListMonitoredResourceDescriptorsRequest, PageAccessor<MonitoredResourceDescriptor>>
      listMonitoredResourceDescriptorsPagedCallable;

  public final LoggingServiceV2Settings getSettings() {
    return settings;
  }

  private static final PathTemplate PARENT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  private static final PathTemplate LOG_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/logs/{log}");

  /**
   * Formats a string containing the fully-qualified path to represent
   * a parent resource.
   */
  public static final String formatParentName(String project) {
    return PARENT_PATH_TEMPLATE.instantiate("project", project);
  }

  /**
   * Formats a string containing the fully-qualified path to represent
   * a log resource.
   */
  public static final String formatLogName(String project, String log) {
    return LOG_PATH_TEMPLATE.instantiate(
        "project", project,
        "log", log);
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a parent resource.
   */
  public static final String parseProjectFromParentName(String parentName) {
    return PARENT_PATH_TEMPLATE.parse(parentName).get("project");
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a log resource.
   */
  public static final String parseProjectFromLogName(String logName) {
    return LOG_PATH_TEMPLATE.parse(logName).get("project");
  }

  /**
   * Parses the log from the given fully-qualified path which
   * represents a log resource.
   */
  public static final String parseLogFromLogName(String logName) {
    return LOG_PATH_TEMPLATE.parse(logName).get("log");
  }

  /**
   * Constructs an instance of LoggingServiceV2Api with default settings.
   */
  public static final LoggingServiceV2Api create() throws IOException {
    return create(LoggingServiceV2Settings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of LoggingServiceV2Api, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final LoggingServiceV2Api create(LoggingServiceV2Settings settings)
      throws IOException {
    return new LoggingServiceV2Api(settings);
  }

  /**
   * Constructs an instance of LoggingServiceV2Api, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected LoggingServiceV2Api(LoggingServiceV2Settings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.deleteLogCallable =
        ApiCallable.create(settings.deleteLogSettings(), this.channel, this.executor);
    this.writeLogEntriesCallable =
        ApiCallable.create(settings.writeLogEntriesSettings(), this.channel, this.executor);
    this.listLogEntriesCallable =
        ApiCallable.create(settings.listLogEntriesSettings(), this.channel, this.executor);
    this.listLogEntriesPagedCallable =
        ApiCallable.createPagedVariant(
            settings.listLogEntriesSettings(), this.channel, this.executor);
    this.listMonitoredResourceDescriptorsCallable =
        ApiCallable.create(
            settings.listMonitoredResourceDescriptorsSettings(), this.channel, this.executor);
    this.listMonitoredResourceDescriptorsPagedCallable =
        ApiCallable.createPagedVariant(
            settings.listMonitoredResourceDescriptorsSettings(), this.channel, this.executor);

    if (settings.getChannelProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              channel.shutdown();
            }
          });
    }
    if (settings.getExecutorProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              executor.shutdown();
            }
          });
    }
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a log and all its log entries.
   * The log will reappear if it receives new entries.
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   String formattedLogName = LoggingServiceV2Api.formatLogName("[PROJECT]", "[LOG]");
   *   loggingServiceV2Api.deleteLog(formattedLogName);
   * }
   * </code></pre>
   *
   * @param logName Required. The resource name of the log to delete.  Example:
   * `"projects/my-project/logs/syslog"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteLog(String logName) {
    LOG_PATH_TEMPLATE.validate(logName, "deleteLog");
    DeleteLogRequest request = DeleteLogRequest.newBuilder().setLogName(logName).build();
    deleteLog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a log and all its log entries.
   * The log will reappear if it receives new entries.
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   String formattedLogName = LoggingServiceV2Api.formatLogName("[PROJECT]", "[LOG]");
   *   DeleteLogRequest request = DeleteLogRequest.newBuilder()
   *     .setLogName(formattedLogName)
   *     .build();
   *   loggingServiceV2Api.deleteLog(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final void deleteLog(DeleteLogRequest request) {
    deleteLogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a log and all its log entries.
   * The log will reappear if it receives new entries.
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   String formattedLogName = LoggingServiceV2Api.formatLogName("[PROJECT]", "[LOG]");
   *   DeleteLogRequest request = DeleteLogRequest.newBuilder()
   *     .setLogName(formattedLogName)
   *     .build();
   *   ListenableFuture&lt;Void&gt; future = loggingServiceV2Api.deleteLogCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<DeleteLogRequest, Empty> deleteLogCallable() {
    return deleteLogCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes log entries to Stackdriver Logging.  All log entries are
   * written by this method.
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   String logName = "";
   *   MonitoredResource resource = MonitoredResource.newBuilder().build();
   *   Map&lt;String, String&gt; labels = new HashMap&lt;&gt;();
   *   List&lt;LogEntry&gt; entries = new ArrayList&lt;&gt;();
   *   WriteLogEntriesResponse response = loggingServiceV2Api.writeLogEntries(logName, resource, labels, entries);
   * }
   * </code></pre>
   *
   * @param logName Optional. A default log resource name for those log entries in `entries`
   * that do not specify their own `logName`.  Example:
   * `"projects/my-project/logs/syslog"`.  See
   * [LogEntry][google.logging.v2.LogEntry].
   * @param resource Optional. A default monitored resource for those log entries in `entries`
   * that do not specify their own `resource`.
   * @param labels Optional. User-defined `key:value` items that are added to
   * the `labels` field of each log entry in `entries`, except when a log
   * entry specifies its own `key:value` item with the same key.
   * Example: `{ "size": "large", "color":"red" }`
   * @param entries Required. The log entries to write. The log entries must have values for
   * all required fields.
   *
   * To improve throughput and to avoid exceeding the quota limit for calls
   * to `entries.write`, use this field to write multiple log entries at once
   * rather than  // calling this method for each log entry.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final WriteLogEntriesResponse writeLogEntries(
      String logName,
      MonitoredResource resource,
      Map<String, String> labels,
      List<LogEntry> entries) {
    LOG_PATH_TEMPLATE.validate(logName, "writeLogEntries");
    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .setLogName(logName)
            .setResource(resource)
            .putAllLabels(labels)
            .addAllEntries(entries)
            .build();
    return writeLogEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes log entries to Stackdriver Logging.  All log entries are
   * written by this method.
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   List&lt;LogEntry&gt; entries = new ArrayList&lt;&gt;();
   *   WriteLogEntriesRequest request = WriteLogEntriesRequest.newBuilder()
   *     .addAllEntries(entries)
   *     .build();
   *   WriteLogEntriesResponse response = loggingServiceV2Api.writeLogEntries(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final WriteLogEntriesResponse writeLogEntries(WriteLogEntriesRequest request) {
    return writeLogEntriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes log entries to Stackdriver Logging.  All log entries are
   * written by this method.
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   List&lt;LogEntry&gt; entries = new ArrayList&lt;&gt;();
   *   WriteLogEntriesRequest request = WriteLogEntriesRequest.newBuilder()
   *     .addAllEntries(entries)
   *     .build();
   *   ListenableFuture&lt;WriteLogEntriesResponse&gt; future = loggingServiceV2Api.writeLogEntriesCallable().futureCall(request);
   *   // Do something
   *   WriteLogEntriesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesCallable() {
    return writeLogEntriesCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists log entries.  Use this method to retrieve log entries from Cloud
   * Logging.  For ways to export log entries, see
   * [Exporting Logs](/logging/docs/export).
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   List&lt;String&gt; projectIds = new ArrayList&lt;&gt;();
   *   String filter = "";
   *   String orderBy = "";
   *   for (LogEntry element : loggingServiceV2Api.listLogEntries(projectIds, filter, orderBy)) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param projectIds Required. One or more project IDs or project numbers from which to retrieve
   * log entries.  Examples of a project ID: `"my-project-1A"`, `"1234567890"`.
   * @param filter Optional. An [advanced logs filter](/logging/docs/view/advanced_filters).
   * The filter is compared against all log entries in the projects specified by
   * `projectIds`.  Only entries that match the filter are retrieved.  An empty
   * filter matches all log entries.
   * @param orderBy Optional. How the results should be sorted.  Presently, the only permitted
   * values are `"timestamp asc"` (default) and `"timestamp desc"`. The first
   * option returns entries in order of increasing values of
   * `LogEntry.timestamp` (oldest first), and the second option returns entries
   * in order of decreasing timestamps (newest first).  Entries with equal
   * timestamps are returned in order of `LogEntry.insertId`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<LogEntry> listLogEntries(
      List<String> projectIds, String filter, String orderBy) {
    ListLogEntriesRequest request =
        ListLogEntriesRequest.newBuilder()
            .addAllProjectIds(projectIds)
            .setFilter(filter)
            .setOrderBy(orderBy)
            .build();
    return listLogEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists log entries.  Use this method to retrieve log entries from Cloud
   * Logging.  For ways to export log entries, see
   * [Exporting Logs](/logging/docs/export).
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   List&lt;String&gt; projectIds = new ArrayList&lt;&gt;();
   *   ListLogEntriesRequest request = ListLogEntriesRequest.newBuilder()
   *     .addAllProjectIds(projectIds)
   *     .build();
   *   for (LogEntry element : loggingServiceV2Api.listLogEntries(request)) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<LogEntry> listLogEntries(ListLogEntriesRequest request) {
    return listLogEntriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists log entries.  Use this method to retrieve log entries from Cloud
   * Logging.  For ways to export log entries, see
   * [Exporting Logs](/logging/docs/export).
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   List&lt;String&gt; projectIds = new ArrayList&lt;&gt;();
   *   ListLogEntriesRequest request = ListLogEntriesRequest.newBuilder()
   *     .addAllProjectIds(projectIds)
   *     .build();
   *   ListenableFuture&lt;PageAccessor&lt;LogEntry&gt;&gt; future = loggingServiceV2Api.listLogEntriesPagedCallable().futureCall(request);
   *   // Do something
   *   for (LogEntry element : future.get()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<ListLogEntriesRequest, PageAccessor<LogEntry>>
      listLogEntriesPagedCallable() {
    return listLogEntriesPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists log entries.  Use this method to retrieve log entries from Cloud
   * Logging.  For ways to export log entries, see
   * [Exporting Logs](/logging/docs/export).
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   List&lt;String&gt; projectIds = new ArrayList&lt;&gt;();
   *   ListLogEntriesRequest request = ListLogEntriesRequest.newBuilder()
   *     .addAllProjectIds(projectIds)
   *     .build();
   *   while (true) {
   *     ListLogEntriesResponse response = loggingServiceV2Api.listLogEntriesCallable().call(request);
   *     for (LogEntry element : response.getEntriesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<ListLogEntriesRequest, ListLogEntriesResponse> listLogEntriesCallable() {
    return listLogEntriesCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resource descriptors used by Stackdriver Logging.
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   ListMonitoredResourceDescriptorsRequest request = ListMonitoredResourceDescriptorsRequest.newBuilder()
   *     .build();
   *   for (MonitoredResourceDescriptor element : loggingServiceV2Api.listMonitoredResourceDescriptors(request)) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<MonitoredResourceDescriptor> listMonitoredResourceDescriptors(
      ListMonitoredResourceDescriptorsRequest request) {
    return listMonitoredResourceDescriptorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resource descriptors used by Stackdriver Logging.
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   ListMonitoredResourceDescriptorsRequest request = ListMonitoredResourceDescriptorsRequest.newBuilder()
   *     .build();
   *   ListenableFuture&lt;PageAccessor&lt;MonitoredResourceDescriptor&gt;&gt; future = loggingServiceV2Api.listMonitoredResourceDescriptorsPagedCallable().futureCall(request);
   *   // Do something
   *   for (MonitoredResourceDescriptor element : future.get()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<
          ListMonitoredResourceDescriptorsRequest, PageAccessor<MonitoredResourceDescriptor>>
      listMonitoredResourceDescriptorsPagedCallable() {
    return listMonitoredResourceDescriptorsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the monitored resource descriptors used by Stackdriver Logging.
   *
   * Sample code:
   * <pre><code>
   * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
   *   ListMonitoredResourceDescriptorsRequest request = ListMonitoredResourceDescriptorsRequest.newBuilder()
   *     .build();
   *   while (true) {
   *     ListMonitoredResourceDescriptorsResponse response = loggingServiceV2Api.listMonitoredResourceDescriptorsCallable().call(request);
   *     for (MonitoredResourceDescriptor element : response.getResourceDescriptorsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable() {
    return listMonitoredResourceDescriptorsCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }
}
