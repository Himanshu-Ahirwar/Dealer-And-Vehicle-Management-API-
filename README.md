
# Dealer & Vehicle Management API

This is a back-end RESTful API for managing car dealers and their vehicle inventory. It includes secure authentication, full CRUD functionality, and a simulation of an asynchronous payment process.

***

## Getting Started

To get a local copy up and running, follow these steps.

### Prerequisites

* Java JDK 17 or later
* Apache Maven
* PostgreSQL
* An API client like [Postman](https://www.postman.com/downloads/)

### Installation

1.  **Clone the repository:**
    ```bash
    git clone <your-repository-url>
    cd <repository-folder>
    ```

2.  **Configure the Database:**
    * Ensure your PostgreSQL server is running.
    * Open `src/main/resources/application.properties` and update the datasource URL, username, and password to match your local database.

3.  **Build and Run:**
    ```bash
    # Build the project
    mvn clean install

    # Run the application
    mvn spring-boot:run
    ```
    The server will start on `http://localhost:8080`.

***

## API Endpoints Guide

The API is secured with JWT. You must first get a token from the `/api/auth/login` endpoint and include it in the `Authorization: Bearer <token>` header for all protected requests.

### **Authentication**

| Method | Endpoint          | Description                        | Auth   |
| :----- | :---------------- | :--------------------------------- | :----- |
| `POST` | `/api/auth/login` | Authenticate and receive a JWT.    | Public |

<details>
<summary>Example Request Body</summary>

```json
{
    "username": "user",
    "password": "password"
}
````

\</details\>

-----

### **Task 1: Dealer & Vehicle Management**

All endpoints in this section require a valid JWT `Bearer Token`.

#### Dealers

| Method   | Endpoint           | Description                      | Auth |
| :------- | :----------------- | :------------------------------- | :--- |
| `POST`   | `/api/dealers`     | Create a new dealer.             | JWT  |
| `GET`    | `/api/dealers`     | Get a list of all dealers.       | JWT  |
| `GET`    | `/api/dealers/{id}`| Get a specific dealer by ID.     | JWT  |
| `PUT`    | `/api/dealers/{id}`| Update an existing dealer.       | JWT  |
| `DELETE` | `/api/dealers/{id}`| Delete a dealer.                 | JWT  |

\<details\>
\<summary\>Example `POST /api/dealers` Body\</summary\>

```json
{
    "name": "Prestige Motors",
    "email": "contact@prestigemotors.com",
    "subscriptionType": "PREMIUM"
}
```

\</details\>

#### Vehicles

| Method   | Endpoint                        | Description                               | Auth |
| :------- | :------------------------------ | :---------------------------------------- | :--- |
| `POST`   | `/api/vehicles`                 | Create a new vehicle for a dealer.        | JWT  |
| `GET`    | `/api/vehicles`                 | Get a list of all vehicles.               | JWT  |
| `GET`    | `/api/vehicles/{id}`            | Get a specific vehicle by ID.             | JWT  |
| `PUT`    | `/api/vehicles/{id}`            | Update an existing vehicle.               | JWT  |
| `DELETE` | `/api/vehicles/{id}`            | Delete a vehicle.                         | JWT  |
| `GET`    | `/api/vehicles/premium-dealers` | Get all vehicles from `PREMIUM` dealers.  | JWT  |

\<details\>
\<summary\>Example `POST /api/vehicles` Body\</summary\>

```json
{
    "model": "Ford Mustang",
    "price": 55000.00,
    "status": "AVAILABLE",
    "dealerId": 1
}
```

\</details\>

-----

### **Task 2: Payment Gateway Simulation**

This endpoint also requires a valid JWT `Bearer Token`.

| Method | Endpoint                  | Description                                                  | Auth |
| :----- | :------------------------ | :----------------------------------------------------------- | :--- |
| `POST` | `/api/payment/initiate`   | Initiates a payment. Responds immediately with `PENDING`, then updates to `SUCCESS` after 5 seconds in the background. | JWT  |

\<details\>
\<summary\>Example `POST /api/payment/initiate` Body\</summary\>

```json
{
    "dealerId": 1,
    "amount": 1000.00,
    "method": "Card"
}
```

\</details\>

```
```
