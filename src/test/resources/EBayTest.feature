#language: ru
Функционал: Регистрация

  Сценарий: Регистрация и авторизация на eBay
    Когда выполненно нажатие на "Зарегистрируйтесь"
    И заполняются поля:
      | Эл. почта               | aplanacucumber@mail.ru |
      | Подтверждение эл. почты | aplanacucumber@mail.ru |
      | Пароль                  | 123N123_nb           |
      | Имя                     | Иван                 |
      | Фамилия                 | Иванов               |
    Тогда выполнено нажатие на "Зарегестрироваться"
    Когда выполнен переход на почтовый ящик
      | Логин  | aplanacucumber@mail.ru |
      | Пароль | qwert12345           |
    Тогда выполнена проверка актуальности письма
    И выполнен переход из письма на eBay
    Когда выполнен вход в личный кабинет
      | Эл. почта | aplanacucumber@mail.ru |
      | Пароль    | 123N123_nb            |
    Также выполнен поиск по товарам blackberry
    Тогда выполнена проверка отображения товаров на странице
    Когда выполнен выход из под своей учетной записи
    Тогда выполнена проверка выход из под своей учетной записи


