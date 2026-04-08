# Pet Shop Platform

Pet Shop is split into two top-level folders now:

- `frontend/` for the customer-facing Thymeleaf app
- `backend/` for the backend applications

The business logic stays the same. This wrap just makes the repository easier to deploy, easier to reason about, and easier to hand off to Render and Neon.

## What Runs Where

- `backend/petshop-backend`: single backend for catalog, pets, products, services, blog, FAQ, promotions, cart, checkout, orders, bookings, inquiries, wishlist, and adoption requests
- `backend/petshop-shared`: DTOs and enums shared inside the backend
- `frontend/petshop-web`: storefront, auth, account, and admin UI

## Runtime Model

- Frontend is the public UI URL.
- Frontend talks to the backend via REST.
- Backend and frontend use the same Neon PostgreSQL database.
- Asset URLs can be stored directly as normal HTTP URLs in the existing `imageUrl` fields.

## Local Environment Variables

Use these values in `.env`, shell, VS Code launch settings, or Render variables:

```bash
SPRING_DATASOURCE_URL=jdbc:postgresql://<host>:5432/<db>?sslmode=require
SPRING_DATASOURCE_USERNAME=<user>
SPRING_DATASOURCE_PASSWORD=<password>
PETSHOP_BACKEND_BASE_URL=http://localhost:8081
```

## Local Run Order

1. Start `petshop-backend`
2. Start `petshop-web`

Frontend URL locally:

- `http://localhost:8080`

## Production Path

The recommended production setup is:

1. Neon for PostgreSQL
2. Render for hosting the services
3. `petshop-web` as the public frontend
4. `petshop-backend` as the public backend API

Full step-by-step notes are in:

- [`docs/production-deployment.md`](docs/production-deployment.md)
- [`backend/README.md`](backend/README.md)
- [`frontend/README.md`](frontend/README.md)

Render blueprints in the repo:

- [`render-monolith.yaml`](render-monolith.yaml) for the frontend + backend setup

## Verification Checklist

- Home page loads with the new modern hero and section cards
- Shop, pets, services, blog, FAQ, and contact pages render through the frontend
- Registration and login work
- Cart, checkout, bookings, inquiries, and adoptions work end to end
- Admin dashboard, catalog, operations, and users pages work
- Public HTTP image URLs render correctly

## Note

I could not run Maven in this environment because `mvn` is not installed here. The project is wired for Java 21 and should be built locally or on Render with a Java 21 image.
