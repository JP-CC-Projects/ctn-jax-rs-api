/*
 * CTN Telescope Operations API - OpenAPI 3.0
 * This is a sample server for Telescope Operations based on the OpenAPI 3.0 specification. This API provides functionality to control telescope mount operations and retrieve astronomical data. For more detailed information and updates, refer to the API documentation.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: api@telescopeoperations.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.openapitools.client.model.InlineResponse200;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelescopeApi {
    private ApiClient localVarApiClient;

    public TelescopeApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TelescopeApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for executeMountOperation
     * @param operation The operation to be executed on the telescope mount (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation executed successfully </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid operation requested </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call executeMountOperationCall(String operation, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/ctn/mount/{operation}"
            .replaceAll("\\{" + "operation" + "\\}", localVarApiClient.escapeString(operation.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "apiKeyAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call executeMountOperationValidateBeforeCall(String operation, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'operation' is set
        if (operation == null) {
            throw new ApiException("Missing the required parameter 'operation' when calling executeMountOperation(Async)");
        }
        

        okhttp3.Call localVarCall = executeMountOperationCall(operation, _callback);
        return localVarCall;

    }

    /**
     * Execute a telescope mount operation
     * This endpoint allows for the execution of various mount operations on the telescope, such as &#39;track&#39;, &#39;slew&#39;, and &#39;halt&#39;. The specific operation to be performed should be specified in the path parameter.
     * @param operation The operation to be executed on the telescope mount (required)
     * @return InlineResponse200
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation executed successfully </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid operation requested </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse200 executeMountOperation(String operation) throws ApiException {
        ApiResponse<InlineResponse200> localVarResp = executeMountOperationWithHttpInfo(operation);
        return localVarResp.getData();
    }

    /**
     * Execute a telescope mount operation
     * This endpoint allows for the execution of various mount operations on the telescope, such as &#39;track&#39;, &#39;slew&#39;, and &#39;halt&#39;. The specific operation to be performed should be specified in the path parameter.
     * @param operation The operation to be executed on the telescope mount (required)
     * @return ApiResponse&lt;InlineResponse200&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation executed successfully </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid operation requested </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse200> executeMountOperationWithHttpInfo(String operation) throws ApiException {
        okhttp3.Call localVarCall = executeMountOperationValidateBeforeCall(operation, null);
        Type localVarReturnType = new TypeToken<InlineResponse200>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Execute a telescope mount operation (asynchronously)
     * This endpoint allows for the execution of various mount operations on the telescope, such as &#39;track&#39;, &#39;slew&#39;, and &#39;halt&#39;. The specific operation to be performed should be specified in the path parameter.
     * @param operation The operation to be executed on the telescope mount (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation executed successfully </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid operation requested </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call executeMountOperationAsync(String operation, final ApiCallback<InlineResponse200> _callback) throws ApiException {

        okhttp3.Call localVarCall = executeMountOperationValidateBeforeCall(operation, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse200>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
