# Production Deployment Guide

This guide follows the fast monolith setup: one backend, one frontend, and one PostgreSQL database.

## 1. Final Layout

```text
Pet Shop/
|-- backend/
|   |-- petshop-shared/
|   |-- petshop-backend/
|-- frontend/
|   |-- petshop-web/
|-- docs/
|-- pom.xml
|-- render-monolith.yaml
```

## 2. Neon Setup

### Database

1. Create a Neon project.
2. Open the connection details in Neon.
3. Use the PostgreSQL connection details for the app.
4. Put the JDBC URL in `SPRING_DATASOURCE_URL`.
5. Put the username in `SPRING_DATASOURCE_USERNAME`.
6. Put the password in `SPRING_DATASOURCE_PASSWORD`.
7. Keep `?sslmode=require` in the JDBC URL.

Recommended JDBC pattern:

```text
jdbc:postgresql://YOUR-NEON-HOST/neondb?sslmode=require
```

Recommended username pattern:

```text
YOUR_NEON_USER
```

### Images

1. Store image URLs directly in the existing `imageUrl` or `featuredImageUrl` columns.
2. You can use any public HTTP image URL.
3. No object storage service is required for this setup.

Example public URL:

```text
https://example.com/images/products/carrier.svg
```

## 3. Render Setup

Recommended services:

- `petshop-backend` as the public backend API
- `petshop-web` as the public frontend

## 4. Render Deployment Steps

1. Push the repo to GitHub.
2. In Render, create a Blueprint from the repo.
3. Use [`render-monolith.yaml`](../render-monolith.yaml).
4. Set the Neon database env vars for both services.
5. Set `PETSHOP_BACKEND_BASE_URL` on the frontend service to the backend public URL.
6. Let Render build both services.
7. Open the frontend public URL.

## 5. Manual Values You Must Configure

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `PETSHOP_BACKEND_BASE_URL` for the frontend app

Optional:

- `JAVA_OPTS=-Xms256m -Xmx512m`
- `THYMELEAF_CACHE=true` in production

## 6. How Images Fit Without Logic Changes

The app already stores raw image URLs. That means:

1. You host the image anywhere public.
2. You copy its HTTP URL.
3. You paste the URL into the admin form or seed data.
4. The existing UI renders the image with no code change.

## 7. Local Smoke Test

Run locally with Docker:

```bash
docker compose up --build
```

Then verify:

1. Home page
2. Shop page
3. Pets page
4. Services page
5. Blog page
6. FAQ page
7. Contact page
8. Register and login
9. Cart and checkout
10. Booking and inquiry forms
11. Admin dashboard

## 8. Production Smoke Test

After Render deploys:

1. Open the frontend URL.
2. Check `/actuator/health` on the backend URL.
3. Browse the public storefront pages.
4. Register a user.
5. Add to cart and checkout.
6. Submit a booking and inquiry.
7. Log in as admin.
8. Confirm admin pages load.
9. Verify one public image URL renders in production.
