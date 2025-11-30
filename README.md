# Quiz Application - Spring Boot

Aplikasi kuis dinamis untuk siswa kelas 2 SD dengan manajemen mata pelajaran dan soal.

## Fitur

- **Quiz Interface**: Interface kuis interaktif dengan multiple choice
- **Admin Panel**: Manajemen mata pelajaran dan soal
- **Database**: Penyimpanan data dinamis dengan PostgreSQL
- **Responsive**: Tampilan responsif dengan Tailwind CSS

## Setup

1. **Database Setup**
   ```sql
   CREATE DATABASE soal_db;
   ```

2. **Configuration**
   Update `application.yaml` dengan kredensial database Anda:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/soal_db
       username: your_username
       password: your_password
   ```

3. **Run Application**
   ```bash
   ./mvnw spring-boot:run
   ```

## Endpoints

- `/` - Quiz interface untuk siswa
- `/admin` - Admin panel untuk manajemen soal
- `/api/subjects` - API endpoint untuk data mata pelajaran

## Struktur Database

### Subjects
- id (Primary Key)
- code (Unique)
- name
- description

### Questions
- id (Primary Key)
- question (Text)
- optionA, optionB, optionC, optionD
- correctAnswer (0-3)
- subject_id (Foreign Key)

## Tech Stack

- Spring Boot 3.2.1
- Spring Data JPA
- Thymeleaf
- PostgreSQL
- Tailwind CSS
- Lombok