## Factory

### Окружение проекта
- PostgreSQL (v.12)
- Java (v.17)
- Docker (v.3)

### Скачайте проект
```
cd ~
git clone https://github.com/Yandex-China-Group/BillYandexShawarma.git
```

### Запустите проект
```
cd ./BillYandexShawarma/
docker-compose up
```

### Тестируйте после запуска
#### Backend
```
http://localhost:8080/swagger-ui/index.html#/
```
#### Grafana
```
localhost:3000    	(Admin:Admin)
```

## Дополнительная информация
- 
- 
- 

Single Backend - Окружение
> При запуске бэкенда отдельно от всего проекта необходимо настроить окружение с помощью переменных окружения

### В окружение входят
- Система управления базами данных PostgreSQL
- POSTGRES_HOST - Host, где развернута СУБД PostgreSQL
- DB_NAME - База данных под управлением СУБД PostgreSQL (на момент запуска должна быть создана)
- DB_USER - Имя пользователя для подключения к базе
- DB_PASSWORD - Пароль для подключения к базе
