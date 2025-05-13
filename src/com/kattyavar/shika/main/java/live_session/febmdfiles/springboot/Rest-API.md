# REST API 

A REST API (Representational State Transfer Application Programming Interface) is a way for different software applications to communicate with each other over the internet using standard HTTP methods like:

- GET – Retrieve data (e.g., get a user's details)

- POST – Create new data (e.g., add a new user)

- PUT – Update existing data (e.g., edit user details)

- DELETE – Remove data (e.g., delete a user)

- PATCH
  - Used to partially update a resource.
  - Unlike PUT, which typically updates the entire resource, PATCH modifies only the specified fields.
  - Example: Update just the user's email address.

- HEAD
  - Same as GET, but it only retrieves the headers, not the body.
  - Useful to check if a resource exists or to get metadata.

- OPTIONS
  - Returns the allowed HTTP methods on a resource.
  - Helpful for CORS (Cross-Origin Resource Sharing) and API discovery.


# Summary of Common HTTP Methods in REST APIs

| **Method** | **Purpose**                 | **Typical Use Case**                            | **Request Body** | **Idempotent** | **Why is it Idempotent?** |
|------------|-----------------------------|--------------------------------------------------|------------------|----------------|----------------------------|
| **GET**    | Retrieve data                | Fetch a user's profile                          | ❌ No            | ✅ Yes         | It doesn’t change server state—calling it repeatedly returns the same result. |
| **POST**   | Create new resource          | Create a new user                               | ✅ Yes           | ❌ No          | Each call creates a new resource—repeated calls change server state. |
| **PUT**    | Update entire resource       | Replace a user's entire profile                 | ✅ Yes           | ✅ Yes         | Replaces the resource—calling with the same data has the same effect every time. |
| **PATCH**  | Update part of a resource    | Update just a user's email                      | ✅ Yes           | ✅ Yes*        | If the same partial update is applied multiple times, the state remains the same. |
| **DELETE** | Delete a resource            | Remove a user from the system                   | ❌ No            | ✅ Yes         | After deletion, the resource is gone—repeated calls don’t change anything further. |
| **HEAD**   | Fetch headers only           | Check if a resource exists or get metadata      | ❌ No            | ✅ Yes         | Like GET but without the body—it doesn’t modify the server state. |
| **OPTIONS**| Discover allowed methods     | Check which methods are supported for a resource| ❌ No            | ✅ Yes         | Returns supported methods—no change to the server state. |

> \*PATCH is technically idempotent if the patch operation is designed to be safely repeatable.

Note:  
idempotent :  idempotent means that making the same request multiple times will have the same effect as making it once.




# Key Concepts of REST API:

- **Stateless**: Each request from the client to the server must contain all the information needed to understand and process it. The server does not store any state about the client session.
- **Resources**: Data is treated as resources, identified by URLs. For example:
  - https://api.example.com/users might represent a list of users.
  - https://api.example.com/users/123 represents the user with ID 123.

- **JSON/XML Responses**: REST APIs usually return data in JSON format (most common) or sometimes XML.
- **Client-Server Architecture**: The client and server are independent. The client just needs to know how to make requests; it doesn’t care how the server processes them internally.
- **Uniform Interface**: All interactions with resources follow a standard set of rules, making the API predictable and easy to use.




# Guidelines for Defining Resources in a REST API

---

### 1. Think in Terms of Nouns, Not Actions

Resources should represent **things**, not **actions**.

**Good Examples:**
```http
GET /users
POST /orders
DELETE /products/123
```

Avoid 

```http
POST /createUser
GET /fetchAllOrders
DELETE /removeProduct?id=123
```

 
###  Use Plural Nouns for Resource Names

Keep naming consistent. Use plural for collections.

- Examples:
  - `/users — a collection of user resources`
  - `/products — a collection of products`


### Nest Resources for Hierarchical Relationships

Use nested routes when resources are logically related.

Example 

```http
GET /users/123/orders     → Orders that belong to user 123
POST /users/123/orders    → Create a new order for user 123
GET /products/45/reviews  → Reviews for product 45

```

### Use HTTP Methods to Define Actions

Let the HTTP method define what happens:

| **Method** | **Action**                   |
|------------|------------------------------|
| `GET`      | Read data                    |
| `POST`     | Create new resource          |
| `PUT`      | Replace entire resource      |
| `PATCH`    | Update part of resource      |
| `DELETE`   | Remove a resource            |


###  Use Standard Status Codes

- Use proper HTTP status codes to indicate results:
  - 200 OK – Successful GET, PUT, or PATCH
  - 201 Created – Successful POST
  - 204 No Content – Successful DELETE
  - 400 Bad Request – Validation failed
  - 404 Not Found – Resource doesn’t exist
  - 500 Internal Server Error – Something went wrong on the server

###  Use Query Parameters for Filtering, Sorting, or Searching

Example 

```http
GET /products?category=books
GET /users?sort=created_at
GET /orders?status=shipped
```

### Use Consistent Naming and Conventions

- Use lowercase and hyphens (-) for readability: /user-roles
- Avoid file extensions like .json or .xml in URLs
