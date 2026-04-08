# Backend Workspace

`backend/` now contains the single backend app plus the shared contracts it reuses.

## Modules

- `petshop-backend`
- `petshop-shared`

The older microservice folders are still present in the repo for reference, but the recommended deployment uses `petshop-backend`.

## Production Notes

- `petshop-backend` is the public backend API.
- `petshop-web` is the public frontend.
- Both can point at the same Neon PostgreSQL database.
- Use normal HTTP image URLs in the existing image fields instead of changing the service logic.

## Environment Example

See [`backend/petshop-backend/.env.example`](/c:/Users/yetes/OneDrive/Desktop/Pet%20Shop/backend/petshop-backend/.env.example).
