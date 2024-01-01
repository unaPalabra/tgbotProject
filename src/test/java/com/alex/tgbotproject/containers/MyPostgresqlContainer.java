package com.alex.tgbotproject.containers;

import org.testcontainers.containers.PostgreSQLContainer;

// создаём класс контейнера, наследуем его от контейнера PostreSQL
public class MyPostgresqlContainer extends PostgreSQLContainer<MyPostgresqlContainer> {

    // указываем, какая версия СУБД нас интересует
    private static final String IMAGE_VERSION = "postgres:11.1";
    private static MyPostgresqlContainer container;

    // конструктор, создающий образ нужной версии
    private MyPostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    // метод получения/создания контейнера, следит за тем, чтобы контейнер был в единственном экземпляре
    public static MyPostgresqlContainer getInstance() {
        // если контейнера ещё нет, создаём его приватным конструктором
        if (container == null) {
            container = new MyPostgresqlContainer();
        }
        // возвращаем контейнер
        return container;
    }

    // описание действий при старте контейнера
    @Override
    public void start() {
        super.start();
        // складываем в системные свойства параметры подключения к СУБД
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        // ничего не нужно, контейнер остановится при остановке JVM
    }
}
