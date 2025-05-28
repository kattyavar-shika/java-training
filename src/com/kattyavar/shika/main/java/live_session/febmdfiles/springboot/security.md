# Spring Boot Security 

Enabling Spring Boot Security in a Spring Boot 3.x application involves adding the necessary dependencies, configuring security settings, and optionally defining user roles and authentication methods.

## Add Dependencies

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

```

When you add the spring-boot-starter-security dependency to your Spring Boot application, Spring Security automatically configures some basic security settings for you, including user authentication. Here's a breakdown of what happens:


## Default Security Configuration
Basic Authentication:

Spring Security sets up basic authentication by default. This means that when you try to access any secured endpoint, you will be prompted for a username and password.


Generated Username and Password:

- By default, Spring Boot creates a user with a username of user.
- It generates a random password for this user, which is printed to the console when you start the application.

## How to See the Default Password

When you run your Spring Boot application, look in the console output for a line similar to this:
```textmate
Using generated security password: abcdefgh-ijkl-mnop-qrst-uvwxyz123456

```

The actual password will be a random string each time you start the application, and you can use this password along with the username user to log in.

## Customizing the Username and Password

If you want to customize the default username and password, you can do so by adding properties to your application.properties or application.yml file:

```yaml
spring.security.user.name=myuser
spring.security.user.password=mypassword

or
spring:
  security:
    user:
      name: myuser
      password: mypassword

```


# What is CSRF?

CSRF, or Cross-Site Request Forgery, is an important security concept that you should understand, especially when working with web applications.

## Definition

CSRF is an attack that tricks the user’s browser into making unwanted requests to a different site on which the user is authenticated. This can lead to actions being performed on behalf of the user without their consent.

## How CSRF Works

1. **User Authentication**: A user logs into a website (e.g., a banking site) and receives a session cookie.
2. **Malicious Request**: The user then visits a malicious site that sends a request to the banking site, including the session cookie.
3. **Unwanted Action**: Because the user is authenticated, the banking site processes the request, potentially allowing the attacker to perform actions like transferring funds.


## how you will see CSRF token. 

```java

  @GetMapping
  public CsrfToken  getCsrfToken(HttpServletRequest request) {
    return (CsrfToken) request.getAttribute("_csrf");
  }
```

you will see something like this. 

```json
{
  "parameterName": "_csrf",
  "token": "u-MlJfzpFset8Jvy5jyzbndaSF4H8pp8Io9NlXhLccpoBlZj2YVGFcqPIfOAxKnA0RGHVxQ8ZWZll6pRQ74p808tE_paZ2AF",
  "headerName": "X-CSRF-TOKEN"
}
```

If you pass this values as POST, DELETE, PUT, PATCH then session base api will work with this token. 

## Protecting Against CSRF

Spring Security provides built-in protection against CSRF attacks. Here’s how it works:

- **CSRF Tokens**: When a user submits a form, a unique CSRF token is generated and included in the request. The server checks this token to ensure that the request is legitimate.
- **Session Validation**: The server validates the session and checks if the CSRF token matches the one stored in the session.

## Configuring CSRF in Spring Security

By default, CSRF protection is enabled in Spring Security. You can configure it or disable it if your application does not require it.

### 1. Enabling/Configuring CSRF (Default Behavior)

You generally don’t need to change anything, as CSRF protection is enabled by default. However, if you want to customize it, you can do so in your `SecurityFilterChain`:

```java
http
    .csrf()
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // Example of using a cookie-based CSRF token
        .and()
    .authorizeRequests()
        // Your authorization configuration
```

###  Disabling CSRF Protection

In some scenarios (e.g., when building stateless REST APIs), you may choose to disable CSRF protection:

```java
http
    .csrf().disable(); // Disable CSRF protection

```

### When to Disable CSRF

Disabling CSRF protection is generally safe for stateless APIs (e.g., those using token-based authentication) because they don’t rely on cookies for authentication. However, if your application uses session-based authentication and handles sensitive actions, you should keep CSRF protection enabled.


## how to disable login form

```java

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    return http
      .formLogin(formLogin -> formLogin.disable())
      .httpBasic(Customizer.withDefaults())
      .build();

  }
}
```

## Secure some API and allow few are open.

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    return http
      .authorizeHttpRequests(authorize -> authorize
        .requestMatchers("/api/v1/open/**").permitAll()
        .anyRequest().authenticated()
      )
      .formLogin(formeLoing -> formeLoing.disable())
      .httpBasic(Customizer.withDefaults())
      .build();

  }
} 
```

## To make state less 

Description: This policy means that the application will not create or use HTTP sessions to store authentication information. Each request must contain all the necessary information to authenticate the user (like a JWT or other token).

Use Case: Ideal for RESTful APIs or microservices where you want to maintain a stateless architecture. Each request is treated independently, which is useful for scaling and security.


```java 
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    return http
      .sessionManagement(session ->
        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(authorize -> authorize
        .requestMatchers("/api/v1/open/**").permitAll()
        .anyRequest().authenticated()
      )
      .formLogin(formeLoing -> formeLoing.disable())
      .httpBasic(Customizer.withDefaults())
      .build();

  }
}
```

Ref : https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html

https://docs.spring.io/spring-security/reference/servlet/architecture.html



# What is a JWT Token?

A JWT typically has three parts, separated by dots `(.)`:

```text
<Header>.<Payload>.<Signature>

```

Where : 

- Header:  
   Specifies the type of token and the algorithm used to sign it (e.g., HS256).

- Payload:  
   Contains the claims (data), such as user ID, roles, or expiration time.

- Signature:  
   Used to verify the token's authenticity and integrity. Created using a secret key or private key.


## Why Should We Use JWT?

**Stateless Authentication:**  
No need to store session data on the server. The token itself contains the user data.

**Compact and Fast:**   
It's URL-safe and can be passed easily in headers, cookies, or URLs.

**Cross-Domain / Microservices Support:**   
JWT works well across domains and services, making it ideal for distributed systems.

**Security:**  
JWTs are signed (and optionally encrypted), so you can verify they haven't been tampered with.

**Scalability:**  
Since JWT is stateless, it scales well across multiple servers or services without session syncing.



#  What is Cryptography

Cryptography is the science of protecting information by transforming it into a secure format so that only authorized parties can understand it.


# Encryption and Decryption

## Encryption: Turning readable data (plaintext) into unreadable data (ciphertext).
## Decryption: Turning it back into readable form using a key.


# Two Types of Encryption

## Symmetric Encryption

- Definition: The same key is used to sign and verify the token.
- Algorithm Example: HS256 (HMAC with SHA-256)

## Asymmetric   Encryption
> Uses a pair of keys:

- A public key (shared with everyone)
- A private key (kept secret by the owner)

One key encrypts, the other decrypts.

###  Two Ways It’s Used:

-  For Confidential Messages (Encrypt with public, decrypt with private)
  - You encrypt a message using the recipient's public key
  - Only the recipient can decrypt it using their private key

- For Signatures (Encrypt/sign with private, verify with public)
  - You sign a message using your private key
  - Anyone can verify the message is from you using your public key


```text
Bob's Key Pair:
Public Key: BOB_PUBLIC
Private Key: BOB_PRIVATE

Alice encrypts message with BOB_PUBLIC → Bob decrypts with BOB_PRIVATE

```



Person A wants to send a message to Person B

 > Goals:
 >  Keep the message private
 >  Prevent Person C from modifying it
 >  Let Person B confirm the message came from Person A
 

# Option 1: Symmetric Encryption Only
- A and B agree on a shared secret key.
- A encrypts the message using that key.
- B decrypts the message with the same key.

## Problems:
- If person C intercepts the message and modifies it, B won’t know.
- Anyone with the shared key can impersonate A.
- No proof of sender identity.
- Not ideal for untrusted environments

# Option 2: Asymmetric Encryption + Digital Signature

- Each person has a public/private key pair.
  - A keeps their private key and shares their public key.
  - B keeps their private key and shares their public key.
- From Person A side:
  - Writes message: “Transfer $100 to Bob”
  - Signs it with A’s private key
  - Encrypts it with B’s public key
  - Sends it to B
- From person B side:
  - Decrypts it using B’s private key
  - Verifies the signature using A’s public key

### Result 
- Only B can read the message (encryption)
- B is sure the message came from A (signature)
- If C modifies the message, signature fails




# JWT - Reframing the Use Case with JWT

Goal  
Person A wants to send a message to Person B

- B should:
  - Confirm the message was not tampered
  - Verify the message is from A
  - Optionally, keep the message readable (or encrypted separately)


## JWT Structure

A JWT is a string with three parts, separated by dots:

```text
<base64-encoded header>.<base64-encoded payload>.<digital signature>

```

Example

```text
eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.
eyJ1c2VyIjoiQWxpY2UiLCJhY3Rpb24iOiJUcmFuc2ZlciAkMTAwIn0.
aGVsbG9zaWduYXR1cmUyMw==
```


### Person A (Sender: signs the message)

Create the Header

```json
{
  "alg": "RS256",
  "typ": "JWT"
}

```
Create the Payload

```json
{
  "user": "Alice",
  "action": "Transfer $100",
  "exp": 1717000000
}

```

Base64URL-encode both header and payload.

Concatenate them:

```text
signing_input = base64url(header) + "." + base64url(payload)

```

Sign the signing_input using A's private key (RS256 algorithm).

Base64URL-encode the signature.

Send JWT (header.payload.signature) to Person B.


### Person B  Receiver: verifies the signature

Split the JWT into three parts:

```text
header, payload, signature = JWT.split(".")

```
Rebuild the signing input:

```text
signing_input = header + "." + payload
```

- Verify the signature using A’s public key:
  - Compute the expected signature using A's public key and signing_input.
  - Compare it to the received signature.

- If the signature matches:
  - Message is authentic (from A).
  - Payload is untampered.

- ❌ If signature doesn’t match:
  - Message may have been altered or not from A → reject it.
