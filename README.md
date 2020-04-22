## Проект Callboard(Доска объявлений) 

***
#### Что умеет приложение:

1. Возможность авторизоваться предполагается, что вы выполнили sql скрипт, который прилагается в директории resources/dump.sql.
1. Возможность создать объявление.
1. Возможность просмотреть детально объявление.
1. Возможность редактировать/удалить объявление если оно принадлежит вам.

Ниже приведены скриншоты работы приложения

Страница с формой авторизации:

---
![alt text](https://raw.githubusercontent.com/Web-Programmer-B-P/callboard/master/src/main/webapp/img_readme/login.png)

Список объявлений со строкой поиска и ссылкой на детальный просмотр:

---
![alt text](https://raw.githubusercontent.com/Web-Programmer-B-P/callboard/master/src/main/webapp/img_readme/list.png)

Страница добавления объявления:

---
![alt text](https://raw.githubusercontent.com/Web-Programmer-B-P/callboard/master/src/main/webapp/img_readme/add.png)

Страница редактирования:

---
![alt text](https://raw.githubusercontent.com/Web-Programmer-B-P/callboard/master/src/main/webapp/img_readme/edit.png)

Страница детального просмотра объявления:

---
![alt text](https://raw.githubusercontent.com/Web-Programmer-B-P/callboard/master/src/main/webapp/img_readme/details.png)

***

#### Технологии использованные при разработке

**фронтенд:**

    1. jsp/jstl
    1. bootstrap3 (модальные окна)
    
**бэкенд:**

    1. java 12
    2. spring-mvc 5.0.4
    2. spring-seurity 5.1.5
    3. База данных: postgres 9.6

**Сервер/контейнер**

    1. Apache Tomcat 9.0.30
    
**Логирование**

    1.log4j 2.12.1