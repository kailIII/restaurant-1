
                                 restaurant 

It's simple restaurant website build on jsf 2.2, Spring, Spring mvc, Hibernate, PrimeFaces, PrettyFaces and log4j2.

To work with project i recommend to import db from root dir.
Project is already configured to work with mariadb from xampp.
You can find db configuration inside hibernate.cfg.xml and SecurityConfig class.
Tested with windows 10, jdk 1.8.0_102, mariadb 10.1.16-MariaDB and Tomcat 8.0.38.


features:
===========
- beautiful banner and old style template,
- dynamically managed food menu with ajax,
- booking tables for 2 or 6 people,
- admin panel and login page,
- chart and table with reservation data,
- excel and pdf import option for reservation data,
- editable content,
- form to set basic website informations (e.g. e-mail, phone),
- page to check reservation, available for clients,
- accounts creator,
- 3 kinds of accounts (admin, anonymous and moderator)
- restrictions for moderators
- absolute dir for user to store files
- mapped absolute patch for uploaded files (conf inside /restaurant/src/main/webapp/WEB-INF/spring/spring-context.xml)


To-Do list:
===========
- fix charts with reservation data,


URL:
===========
- project url: your-host-ip:port/restaurant
- admin panel url: your-host-ip:port/restaurant/login


admin account:
===========
- login: root
- password: 123


Sources:
===========
- archetype: weld-jsf-jee-minimal

- libraries inside pom file

- https://pixabay.com/en/food-salmon-teriyaki-cooking-712665/

- https://pixabay.com/en/food-salmon-seeded-mustard-dinner-712666/

- https://pixabay.com/en/salmon-dish-food-meal-fish-518032/

- https://pixabay.com/en/dinner-table-fancy-dinner-table-1433494/

- https://pixabay.com/en/floor-wood-hardwood-floors-1256804/

- https://pixabay.com/en/wood-planks-wooden-background-wall-336589/

- https://pixabay.com/en/wood-boards-nature-tree-texture-919668/

- https://www.pexels.com/photo/food-dinner-pasta-broccoli-8817/

- https://www.pexels.com/photo/chef-cook-cooking-dish-162400/

- https://www.pexels.com/photo/sea-sunset-beach-couple-2145/

- https://www.pexels.com/photo/restaurant-person-people-hand-4224/

- http://www.clipartkid.com/free-decorative-line-divider-clip-art-7YlFKU-clipart/