/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.websites;

import com.microsoft.windowsazure.core.OperationResponse;
import com.microsoft.windowsazure.core.ServiceClient;
import com.microsoft.windowsazure.credentials.SubscriptionCloudCredentials;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.configuration.ManagementConfiguration;
import com.microsoft.windowsazure.management.websites.models.WebSiteOperationStatus;
import com.microsoft.windowsazure.management.websites.models.WebSiteOperationStatusResponse;
import com.microsoft.windowsazure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
* The Windows Azure Web Sites management API provides a RESTful set of web
* services that interact with Windows Azure Web Sites service to manage your
* web sites. The API has entities that capture the relationship between an end
* user and the Windows Azure Web Sites service.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/dn166981.aspx for more
* information)
*/
public class WebSiteManagementClientImpl extends ServiceClient<WebSiteManagementClient> implements WebSiteManagementClient {
    private URI baseUri;
    
    /**
    * The URI used as the base for all Service Management requests.
    * @return The BaseUri value.
    */
    public URI getBaseUri() {
        return this.baseUri;
    }
    
    private SubscriptionCloudCredentials credentials;
    
    /**
    * When you create a Windows Azure subscription, it is uniquely identified
    * by a subscription ID. The subscription ID forms part of the URI for
    * every call that you make to the Service Management API.  The Windows
    * Azure Service ManagementAPI use mutual authentication of management
    * certificates over SSL to ensure that a request made to the service is
    * secure.  No anonymous requests are allowed.
    * @return The Credentials value.
    */
    public SubscriptionCloudCredentials getCredentials() {
        return this.credentials;
    }
    
    private ServerFarmOperations serverFarms;
    
    /**
    * Operations for managing the server farm in a web space.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn194277.aspx for
    * more information)
    * @return The ServerFarmsOperations value.
    */
    public ServerFarmOperations getServerFarmsOperations() {
        return this.serverFarms;
    }
    
    private WebSiteOperations webSites;
    
    /**
    * Operations for managing the web sites in a web space.
    * @return The WebSitesOperations value.
    */
    public WebSiteOperations getWebSitesOperations() {
        return this.webSites;
    }
    
    private WebSpaceOperations webSpaces;
    
    /**
    * Operations for managing web spaces beneath your subscription.
    * @return The WebSpacesOperations value.
    */
    public WebSpaceOperations getWebSpacesOperations() {
        return this.webSpaces;
    }
    
    /**
    * Initializes a new instance of the WebSiteManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    */
    private WebSiteManagementClientImpl(HttpClientBuilder httpBuilder, ExecutorService executorService) {
        super(httpBuilder, executorService);
        this.serverFarms = new ServerFarmOperationsImpl(this);
        this.webSites = new WebSiteOperationsImpl(this);
        this.webSpaces = new WebSpaceOperationsImpl(this);
    }
    
    /**
    * Initializes a new instance of the WebSiteManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    * @param credentials When you create a Windows Azure subscription, it is
    * uniquely identified by a subscription ID. The subscription ID forms part
    * of the URI for every call that you make to the Service Management API.
    * The Windows Azure Service ManagementAPI use mutual authentication of
    * management certificates over SSL to ensure that a request made to the
    * service is secure.  No anonymous requests are allowed.
    * @param baseUri The URI used as the base for all Service Management
    * requests.
    */
    public WebSiteManagementClientImpl(HttpClientBuilder httpBuilder, ExecutorService executorService, SubscriptionCloudCredentials credentials, URI baseUri) {
        this(httpBuilder, executorService);
        if (credentials == null) {
            throw new NullPointerException("credentials");
        }
        if (baseUri == null) {
            throw new NullPointerException("baseUri");
        }
        this.credentials = credentials;
        this.baseUri = baseUri;
    }
    
    /**
    * Initializes a new instance of the WebSiteManagementClientImpl class.
    * Initializes a new instance of the WebSiteManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    * @param credentials When you create a Windows Azure subscription, it is
    * uniquely identified by a subscription ID. The subscription ID forms part
    * of the URI for every call that you make to the Service Management API.
    * The Windows Azure Service ManagementAPI use mutual authentication of
    * management certificates over SSL to ensure that a request made to the
    * service is secure.  No anonymous requests are allowed.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    */
    @Inject
    public WebSiteManagementClientImpl(HttpClientBuilder httpBuilder, ExecutorService executorService, @Named(ManagementConfiguration.SUBSCRIPTION_CLOUD_CREDENTIALS) SubscriptionCloudCredentials credentials) throws java.net.URISyntaxException {
        this(httpBuilder, executorService);
        if (credentials == null) {
            throw new NullPointerException("credentials");
        }
        this.credentials = credentials;
        this.baseUri = new URI("https://management.core.windows.net");
    }
    
    /**
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    */
    protected WebSiteManagementClientImpl newInstance(HttpClientBuilder httpBuilder, ExecutorService executorService) {
        return new WebSiteManagementClientImpl(httpBuilder, executorService, this.getCredentials(), this.getBaseUri());
    }
    
    /**
    * The Get Operation Status operation returns the status of thespecified
    * operation. After calling a long-running operation, you can call Get
    * Operation Status to determine whether the operation has succeeded,
    * failed, timed out, or is still in progress.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460783.aspx for
    * more information)
    *
    * @param webSpaceName The name of the webspace for the website where the
    * operation was targeted.
    * @param siteName The name of the site where the operation was targeted.
    * @param operationId The operation ID for the operation you wish to track.
    * The operation ID is returned in the Id field in the body of the response
    * for long-running operations.
    * @return The response body contains the status of the specified
    * long-running operation, indicating whether it has succeeded, is
    * inprogress, has time dout, or has failed. Note that this status is
    * distinct from the HTTP status code returned for the Get Operation Status
    * operation itself.  If the long-running operation failed, the response
    * body includes error information regarding the failure.
    */
    @Override
    public Future<WebSiteOperationStatusResponse> getOperationStatusAsync(final String webSpaceName, final String siteName, final String operationId) {
        return this.getExecutorService().submit(new Callable<WebSiteOperationStatusResponse>() { 
            @Override
            public WebSiteOperationStatusResponse call() throws Exception {
                return getOperationStatus(webSpaceName, siteName, operationId);
            }
         });
    }
    
    /**
    * The Get Operation Status operation returns the status of thespecified
    * operation. After calling a long-running operation, you can call Get
    * Operation Status to determine whether the operation has succeeded,
    * failed, timed out, or is still in progress.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460783.aspx for
    * more information)
    *
    * @param webSpaceName The name of the webspace for the website where the
    * operation was targeted.
    * @param siteName The name of the site where the operation was targeted.
    * @param operationId The operation ID for the operation you wish to track.
    * The operation ID is returned in the Id field in the body of the response
    * for long-running operations.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The response body contains the status of the specified
    * long-running operation, indicating whether it has succeeded, is
    * inprogress, has time dout, or has failed. Note that this status is
    * distinct from the HTTP status code returned for the Get Operation Status
    * operation itself.  If the long-running operation failed, the response
    * body includes error information regarding the failure.
    */
    @Override
    public WebSiteOperationStatusResponse getOperationStatus(String webSpaceName, String siteName, String operationId) throws IOException, ServiceException, ParserConfigurationException, SAXException {
        // Validate
        if (webSpaceName == null) {
            throw new NullPointerException("webSpaceName");
        }
        if (siteName == null) {
            throw new NullPointerException("siteName");
        }
        if (operationId == null) {
            throw new NullPointerException("operationId");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("webSpaceName", webSpaceName);
            tracingParameters.put("siteName", siteName);
            tracingParameters.put("operationId", operationId);
            CloudTracing.enter(invocationId, this, "getOperationStatusAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getBaseUri() + "/" + this.getCredentials().getSubscriptionId() + "/services/WebSpaces/" + webSpaceName + "/sites/" + siteName + "/operations/" + operationId;
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2013-08-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            WebSiteOperationStatusResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpResponse.getEntity().getContent();
            result = new WebSiteOperationStatusResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(responseContent);
            
            NodeList elements = responseDoc.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Operation");
            Element operationElement = elements.getLength() > 0 ? ((Element) elements.item(0)) : null;
            if (operationElement != null) {
                NodeList elements2 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "CreatedTime");
                Element createdTimeElement = elements2.getLength() > 0 ? ((Element) elements2.item(0)) : null;
                if (createdTimeElement != null) {
                    Calendar createdTimeInstance;
                    createdTimeInstance = DatatypeConverter.parseDateTime(createdTimeElement.getTextContent());
                    result.setCreatedTime(createdTimeInstance);
                }
                
                NodeList elements3 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Errors");
                Element errorsSequenceElement = elements3.getLength() > 0 ? ((Element) elements3.item(0)) : null;
                if (errorsSequenceElement != null) {
                    boolean isNil = false;
                    Attr nilAttribute = errorsSequenceElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (nilAttribute != null) {
                        isNil = "true".equals(nilAttribute.getValue());
                    }
                    if (isNil == false) {
                        for (int i1 = 0; i1 < errorsSequenceElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Error").getLength(); i1 = i1 + 1) {
                            org.w3c.dom.Element errorsElement = ((org.w3c.dom.Element) errorsSequenceElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Error").item(i1));
                            WebSiteOperationStatusResponse.Error errorInstance = new WebSiteOperationStatusResponse.Error();
                            result.getErrors().add(errorInstance);
                            
                            NodeList elements4 = errorsElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Code");
                            Element codeElement = elements4.getLength() > 0 ? ((Element) elements4.item(0)) : null;
                            if (codeElement != null) {
                                boolean isNil2 = false;
                                Attr nilAttribute2 = codeElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (nilAttribute2 != null) {
                                    isNil2 = "true".equals(nilAttribute2.getValue());
                                }
                                if (isNil2 == false) {
                                    String codeInstance;
                                    codeInstance = codeElement.getTextContent();
                                    errorInstance.setCode(codeInstance);
                                }
                            }
                            
                            NodeList elements5 = errorsElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Message");
                            Element messageElement = elements5.getLength() > 0 ? ((Element) elements5.item(0)) : null;
                            if (messageElement != null) {
                                boolean isNil3 = false;
                                Attr nilAttribute3 = messageElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (nilAttribute3 != null) {
                                    isNil3 = "true".equals(nilAttribute3.getValue());
                                }
                                if (isNil3 == false) {
                                    String messageInstance;
                                    messageInstance = messageElement.getTextContent();
                                    errorInstance.setMessage(messageInstance);
                                }
                            }
                            
                            NodeList elements6 = errorsElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "ExtendedCode");
                            Element extendedCodeElement = elements6.getLength() > 0 ? ((Element) elements6.item(0)) : null;
                            if (extendedCodeElement != null) {
                                boolean isNil4 = false;
                                Attr nilAttribute4 = extendedCodeElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (nilAttribute4 != null) {
                                    isNil4 = "true".equals(nilAttribute4.getValue());
                                }
                                if (isNil4 == false) {
                                    String extendedCodeInstance;
                                    extendedCodeInstance = extendedCodeElement.getTextContent();
                                    errorInstance.setExtendedCode(extendedCodeInstance);
                                }
                            }
                            
                            NodeList elements7 = errorsElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "MessageTemplate");
                            Element messageTemplateElement = elements7.getLength() > 0 ? ((Element) elements7.item(0)) : null;
                            if (messageTemplateElement != null) {
                                boolean isNil5 = false;
                                Attr nilAttribute5 = messageTemplateElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (nilAttribute5 != null) {
                                    isNil5 = "true".equals(nilAttribute5.getValue());
                                }
                                if (isNil5 == false) {
                                    String messageTemplateInstance;
                                    messageTemplateInstance = messageTemplateElement.getTextContent();
                                    errorInstance.setMessageTemplate(messageTemplateInstance);
                                }
                            }
                            
                            NodeList elements8 = errorsElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Parameters");
                            Element parametersSequenceElement = elements8.getLength() > 0 ? ((Element) elements8.item(0)) : null;
                            if (parametersSequenceElement != null) {
                                boolean isNil6 = false;
                                Attr nilAttribute6 = parametersSequenceElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (nilAttribute6 != null) {
                                    isNil6 = "true".equals(nilAttribute6.getValue());
                                }
                                if (isNil6 == false) {
                                    for (int i2 = 0; i2 < parametersSequenceElement.getElementsByTagNameNS("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string").getLength(); i2 = i2 + 1) {
                                        org.w3c.dom.Element parametersElement = ((org.w3c.dom.Element) parametersSequenceElement.getElementsByTagNameNS("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string").item(i2));
                                        errorInstance.getParameters().add(parametersElement.getTextContent());
                                    }
                                }
                            }
                            
                            NodeList elements9 = errorsElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "InnerErrors");
                            Element innerErrorsElement = elements9.getLength() > 0 ? ((Element) elements9.item(0)) : null;
                            if (innerErrorsElement != null) {
                                boolean isNil7 = false;
                                Attr nilAttribute7 = innerErrorsElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (nilAttribute7 != null) {
                                    isNil7 = "true".equals(nilAttribute7.getValue());
                                }
                                if (isNil7 == false) {
                                    String innerErrorsInstance;
                                    innerErrorsInstance = innerErrorsElement.getTextContent();
                                    errorInstance.setInnerErrors(innerErrorsInstance);
                                }
                            }
                        }
                    }
                }
                
                NodeList elements10 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "ExpirationTime");
                Element expirationTimeElement = elements10.getLength() > 0 ? ((Element) elements10.item(0)) : null;
                if (expirationTimeElement != null) {
                    Calendar expirationTimeInstance;
                    expirationTimeInstance = DatatypeConverter.parseDateTime(expirationTimeElement.getTextContent());
                    result.setExpirationTime(expirationTimeInstance);
                }
                
                NodeList elements11 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "GeoMasterOperationId");
                Element geoMasterOperationIdElement = elements11.getLength() > 0 ? ((Element) elements11.item(0)) : null;
                if (geoMasterOperationIdElement != null) {
                    boolean isNil8 = false;
                    Attr nilAttribute8 = geoMasterOperationIdElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (nilAttribute8 != null) {
                        isNil8 = "true".equals(nilAttribute8.getValue());
                    }
                    if (isNil8 == false) {
                        String geoMasterOperationIdInstance;
                        geoMasterOperationIdInstance = geoMasterOperationIdElement.getTextContent();
                        result.setGeoMasterOperationId(geoMasterOperationIdInstance);
                    }
                }
                
                NodeList elements12 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Id");
                Element idElement = elements12.getLength() > 0 ? ((Element) elements12.item(0)) : null;
                if (idElement != null) {
                    boolean isNil9 = false;
                    Attr nilAttribute9 = idElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (nilAttribute9 != null) {
                        isNil9 = "true".equals(nilAttribute9.getValue());
                    }
                    if (isNil9 == false) {
                        String idInstance;
                        idInstance = idElement.getTextContent();
                        result.setOperationId(idInstance);
                    }
                }
                
                NodeList elements13 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "ModifiedTime");
                Element modifiedTimeElement = elements13.getLength() > 0 ? ((Element) elements13.item(0)) : null;
                if (modifiedTimeElement != null) {
                    Calendar modifiedTimeInstance;
                    modifiedTimeInstance = DatatypeConverter.parseDateTime(modifiedTimeElement.getTextContent());
                    result.setModifiedTime(modifiedTimeInstance);
                }
                
                NodeList elements14 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Name");
                Element nameElement = elements14.getLength() > 0 ? ((Element) elements14.item(0)) : null;
                if (nameElement != null) {
                    boolean isNil10 = false;
                    Attr nilAttribute10 = nameElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (nilAttribute10 != null) {
                        isNil10 = "true".equals(nilAttribute10.getValue());
                    }
                    if (isNil10 == false) {
                        String nameInstance;
                        nameInstance = nameElement.getTextContent();
                        result.setName(nameInstance);
                    }
                }
                
                NodeList elements15 = operationElement.getElementsByTagNameNS("http://schemas.microsoft.com/windowsazure", "Status");
                Element statusElement = elements15.getLength() > 0 ? ((Element) elements15.item(0)) : null;
                if (statusElement != null) {
                    WebSiteOperationStatus statusInstance;
                    statusInstance = WebSiteOperationStatus.valueOf(statusElement.getTextContent());
                    result.setStatus(statusInstance);
                }
            }
            
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
    
    /**
    * Register your subscription to use Windows Azure Web Sites.
    *
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<OperationResponse> registerSubscriptionAsync() {
        return this.getExecutorService().submit(new Callable<OperationResponse>() { 
            @Override
            public OperationResponse call() throws Exception {
                return registerSubscription();
            }
         });
    }
    
    /**
    * Register your subscription to use Windows Azure Web Sites.
    *
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public OperationResponse registerSubscription() throws IOException, ServiceException {
        // Validate
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            CloudTracing.enter(invocationId, this, "registerSubscriptionAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getBaseUri() + "/" + this.getCredentials().getSubscriptionId() + "/services" + "?" + "&" + "action=register";
        url = url + "service=website";
        
        // Create HTTP transport objects
        HttpPut httpRequest = new HttpPut(url);
        
        // Set Headers
        httpRequest.setHeader("Content-Type", "application/xml");
        httpRequest.setHeader("x-ms-version", "2013-08-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_ACCEPTED) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            OperationResponse result = null;
            result = new OperationResponse();
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
    
    /**
    * Unregister your subscription to use Windows Azure Web Sites.
    *
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<OperationResponse> unregisterSubscriptionAsync() {
        return this.getExecutorService().submit(new Callable<OperationResponse>() { 
            @Override
            public OperationResponse call() throws Exception {
                return unregisterSubscription();
            }
         });
    }
    
    /**
    * Unregister your subscription to use Windows Azure Web Sites.
    *
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public OperationResponse unregisterSubscription() throws IOException, ServiceException {
        // Validate
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            CloudTracing.enter(invocationId, this, "unregisterSubscriptionAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getBaseUri() + "/" + this.getCredentials().getSubscriptionId() + "/services" + "?" + "&" + "action=unregister";
        url = url + "service=website";
        
        // Create HTTP transport objects
        HttpPut httpRequest = new HttpPut(url);
        
        // Set Headers
        httpRequest.setHeader("Content-Type", "application/xml");
        httpRequest.setHeader("x-ms-version", "2013-08-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_ACCEPTED) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            OperationResponse result = null;
            result = new OperationResponse();
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
}
