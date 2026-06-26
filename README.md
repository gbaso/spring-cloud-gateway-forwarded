# Forwarded Gateway

This repository reproduces an issue where a downstream gateway drops forwarded headers when
configured to not add forwarded headers itself.

This repository contains 3 applications:
 - A simple backend
 - An edge gateway, with forwarded headers enabled
 - An internal gateway, downstream from edge, with forwarded headers disabled

Start the three applications:

```bash
./mvnw spring-boot:run -f backend/pom.xml
```

```bash
./mvnw spring-boot:run -f internal/pom.xml
```

```bash
./mvnw spring-boot:run -f edge/pom.xml
```

Call the route through the edge gateway:

```bash
http localhost:8080/redirect
```

Expected redirect location: `localhost:8080/redirected` (because forwarded headers from `edge` should preserve the original external host/port).

Actual redirect location: `localhost:8082/redirected` when those forwarded headers are not included by `internal`.
