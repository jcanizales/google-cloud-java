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

/**
 * A client to Google Cloud Trace API.
 *
 * The interfaces provided are listed below, along with a usage sample
 *
 * ===============
 * TraceServiceApi
 * ===============
 *
 * Service Description: This file describes an API for collecting and viewing traces and spans
 * within a trace.  A Trace is a collection of spans corresponding to a single
 * operation or set of operations for an application. A span is an individual
 * timed event which forms a node of the trace tree. Spans for a single trace
 * may span multiple services.
 *
 * Sample for TraceServiceApi:
 * <pre>
 * <code>
 * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
 *   String projectId = "";
 *   Traces traces = Traces.newBuilder().build();
 *   traceServiceApi.patchTraces(projectId, traces);
 * }
 * </code>
 * </pre>
 *
 */
package com.google.cloud.trace.spi.v1;
