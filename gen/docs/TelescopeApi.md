# TelescopeApi

All URIs are relative to *https://open-development.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**executeMountOperation**](TelescopeApi.md#executeMountOperation) | **GET** /ctn/mount/{operation} | Execute a telescope mount operation


<a name="executeMountOperation"></a>
# **executeMountOperation**
> InlineResponse200 executeMountOperation(operation)

Execute a telescope mount operation

This endpoint allows for the execution of various mount operations on the telescope, such as &#39;track&#39;, &#39;slew&#39;, and &#39;halt&#39;. The specific operation to be performed should be specified in the path parameter.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TelescopeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://open-development.com/api/v1");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    TelescopeApi apiInstance = new TelescopeApi(defaultClient);
    String operation = "operation_example"; // String | The operation to be executed on the telescope mount
    try {
      InlineResponse200 result = apiInstance.executeMountOperation(operation);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TelescopeApi#executeMountOperation");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **operation** | **String**| The operation to be executed on the telescope mount | [enum: park, unpark, moveNorth, moveSouth, moveEast, moveWest, track, untrack, trackRate, maxRate, slew, setCoord]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Operation executed successfully |  -  |
**400** | Invalid operation requested |  -  |
**500** | Internal server error |  -  |

