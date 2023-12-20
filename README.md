# User reactive service

## Table of Contents
1. [Hexagonal Architecture](#hexagonal-architecture)
2. [User Model](#user-model)
3. [Design Patterns](#design-patterns)
4. [Endpoints](#endpoints)
5. [Reactive Programming](#reactive-programming)

## Hexagonal Architecture
This project uses a Hexagonal Architecture (also known as Ports and Adapters) which consists of three layers:

- **Domain Layer**: This is the innermost layer and contains business logic and entities (in this case, the User entity). It is isolated from the outside world and doesn't know anything about databases or UI. In our project, this is implemented in the `user-domain` module.

- **Application Layer**: This layer serves as a bridge between the Domain and Infrastructure layers. It contains use cases which orchestrate the flow of data to and from the Domain layer. In our project, this is implemented in the `user-application` module.

- **Infrastructure Layer**: This layer interacts with the outside world (databases, web services, etc.). It implements the interfaces defined by the Application layer. In our project, this is implemented in the `user-infrastructure` module.

- **Presentation Layer**: This layer is responsible for handling all user interface operations. In our project, this is implemented in the `user-presentation` module.

## User Model
The User model is a simple Java class with fields that correspond to the columns in the User table in the database. The fields include `id`, `username`, `email`, `password`, etc.

## Design Patterns
This project uses several design patterns:

- **Repository Pattern**: This is used to abstract the data access logic. The repositories are interfaces defined in the Application layer and implemented in the Infrastructure layer.

- **Build Pattern**: This is used to create instances of the User model.

- **Value Object Pattern**: This is used for data validation in the User model.

## Endpoints
The project exposes several RESTful endpoints for managing users:

- `GET /user/username/{username}`: Get a single user by username.
- `GET /user/email/{email}`: Get a single user by email.
- `POST /user`: Create a new user.

## Reactive Programming
The project uses Spring WebFlux for reactive programming. This allows it to handle a large number of concurrent requests efficiently, without blocking I/O operations. The endpoints return `Mono` or `Flux` instances, which represent asynchronous sequences of zero or more items.
