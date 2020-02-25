# jv-spring-boot-docker

#### Технології: 
Spring Boot, Spring Security (inMemoryAuthentication), JpaRepository, H2, REST, Pagination, Swagger, Docker

#### Опис проекту: 
Проект відображає роботу основних методів: GET, POST, PUT, DELETE на прикладі моделі Книги. 

Прис старті відпрацьовує `PostConstruct` і база заповнюється тестовими даними. 

Використовується `inMemoryAuthentication`, тому доступними є два користувача:

| login   | password | 
| ------- | -------- | 
| user    | 123      | 
| admin   | 123      | 

Для адміна доступні всі функції. 

Щоб протестувати роботу рекомендую використовувати `Postman`.
Для авторизації: Authorization -> Type (Basic Auth) -> вводимо логін та пароль.

__GET__: `localhost:8081/book` - поверне 20 книг, відсортованих по `id` за зростанням (default).

`localhost:8081/book?limit=<books_per_page>&page=<page_number>&sortBy=<id/title/description/price/year>&sortOrder=<asc/desc>` (custom)

__DELETE__: `localhost:8081/book/<id>` - видалить книгу за id.

__POST__: `localhost:8081/book` - створить нову книгу.

Body -> raw -> Text (JSON):
```json
{
    "title": "Test title",
    "description": "Test description",
    "price": 500.00,
    "year": 2020
}
```

__PUT__: `localhost:8081/book/<id>` - оновить існуючу книгу за id.
```json
{
    "title": "Changed title",
    "description": "Changed description",
    "price": 500.00,
    "year": 2020
}
```

#### Як працювати з Docker:
Для початку потрібно встановити [Docker Desktop](https://docs.docker.com/install/) та зареєструватись 
на [DockerHub](https://hub.docker.com/signup).

Команди для роботи з Docker:

_1. Create a jar_

    mvn clean package

_2. Build the image_

    docker build -t <YOUR_DOCKER_HUB_ID/YOUR_IMAGE_NAME> .

_3. Run it locally and check the result on [localhost](http://localhost:8081/)_

    docker run -p 8081:8081 <YOUR_DOCKER_HUB_ID/YOUR_IMAGE_NAME>
    
_5. Stop it locally_

    Control + C

_4. Push the image to the [docker hub](https://hub.docker.com/)_

    docker push <YOUR_DOCKER_HUB_ID/YOUR_IMAGE_NAME>
    
#### Чим цей проект може бути корисним:

Якщо ваше тестове завдання потребує використання вище перераховани технологій, або частини з них, можете сміливо брати за основу цей проект.

Рекомендую для початку ознайомитись з функціоналом, а потім перейти до написання коду.

Для того щоб розпочати роботу вам потрібно скопіювати проект з репозиторію (не робити git fork / git clone).

Далі можна видалити не потрібний код, і поступово додавати новий функціонал. 

Успіхів у виконанні тестового завдання:)
