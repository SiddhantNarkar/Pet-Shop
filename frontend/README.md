# Frontend Workspace

`frontend/` contains the customer-facing Thymeleaf web application.

## Module

- `petshop-web`

## Production Notes

- The web app is the public frontend in the recommended production setup.
- It talks to the single backend service over REST.
- Keep media assets as normal HTTP URLs and store them in the current `imageUrl` fields.

## Environment Example

See [`frontend/.env.example`](/c:/Users/yetes/OneDrive/Desktop/Pet%20Shop/frontend/.env.example).
