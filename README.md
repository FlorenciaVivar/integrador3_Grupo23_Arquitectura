# Grupo 23 - TP3: Servicios REST y SpringBoot
## Endpoints

---

### (A) Dar de alta un estudiante

**Descripción:**
La API `/api/estudiante` permite crear un nuevo estudiante con los datos especificados en el cuerpo de la solicitud.

**Método HTTP:** `POST`

**Parámetros del cuerpo:**
- `nombre`
- `apellido`
- `edad`
- `genero`
- `DNI`
- `numLegajo`
- `ciudad` --> opcional
- `antiguedadEnCarrera` --> opcional

---

### (B) Matricular un estudiante en una carrera

**Descripción:**
La API `/api/estudianteCarrera` permite matricular un estudiante en una carrera mediante los datos especificados en el cuerpo de la solicitud.

**Método HTTP:** `POST`

**Parámetros del cuerpo:**
- `idEstudiante`
- `idCarrera`

---

### (C) Obtener todos los estudiantes

**Descripción:**
La API `/api/estudianteCarrera` permite obtener todos los estudiantes que estudian una carrera, con posibilidad de ordenar los resultados por un criterio especificado en los query params.

**Método HTTP:** `GET`

**Parámetros de consulta:**
- `sort`

### Uso del switch:
  
 "1": Ordenar por el nombre del estudiante (estudiante.nombre).
 
 "2": Ordenar por el apellido del estudiante (estudiante.apellido).
 
 "3": Ordenar por la fecha de comienzo de la carrera (fechaComienzo).
 
 Valor por defecto: Si no se proporciona ningún valor o el valor no es válido, los resultados se ordenan por el ID de la carrera (idEstudianteCarrera).

### Ejemplo de uso: GET /api/estudianteCarrera?sort=2
---

### (D) Obtener un estudiante, en base a su número de libreta universitaria

**Descripción:**
La API `/api/estudiante/LU/{LU}` permite obtener el estudiante con el `LU` especificado.

**Método HTTP:** `GET`

**Parámetros de ruta::**
- `LU`

---

### (E) Obtener los estudiantes en base a su género

**Descripción:**
La API `/api/estudiante/genero/{genero}` permite obtener los estudiantes con el `genero` especificado.

**Método HTTP:** `GET`

**Parámetros de ruta::**
- `genero`

---

### (F) Obtener las carreras con estudiantes inscriptos, ordenadas por cantidad de inscriptos

**Descripción:**
La API `/api/carrera/orderBy/cantidad` permite obtener las carreras que posean estudiantes inscriptos, ordenadas por cantidad de inscriptos.

**Método HTTP:** `GET`

---

### (G) Obtener los estudiantes de una determinada carrera, filtrado por ciudad de residencia.

**Descripción:**
La API `/api/estudiante/search/{idCarrera}/{ciudad}` permite obtener los estudiantes de la carrera con {idCarrera} y {ciudad} especificada.

**Método HTTP:** `GET`

**Parámetros de ruta::**
- `idCarrera`
- `ciudad`

---

### (H) Generar un reporte de las carreras

**Descripción:**
La API `/api/carrera/reporte` permite obtener un reporte de las carreras ordenado alfabéticamente (presentando los años de manera cronológica), donde cada carrera incluye información de los inscriptos y egresados por año.

**Método HTTP:** `GET`

