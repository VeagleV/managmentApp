package org.project.managmentappweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ManagmentAppWebApplication {


	//СНАЧАЛА БЭК НА ЗАПУСК, ПОТОМ ФРОНТ(npm run serve)
	//Убедиться что фронт работает на :8081

	/*
	ПОЛЕЗНЫЕ КОМАНДЫ:
	npm run lint -- --fix - автоматический фикс проблем на фронте(Vue)
	netstat -aon | findstr :8081 - поиск процесса который занимает порт 8081
	taskkill /F /PID 1544 - убить нахуй процесс на порте (число взять из предыдущей команды)
	 */

	/*
		НЕЛЬЗЯ ИСПОЛЬЗОВАТЬ ДАННЫЕ КОМАНДЫ
		docker system prune -a
		docker-compose down -v 
		ОНИ УНИЧТОЖАЮТ БАЗУ ДАННЫХ НАХУЙ. ВСЕ ЛОГИНЫ И ПАРОЛИ УДАЛЯЮТСЯ
	*/

	//TODO: ДОБАВИТЬ .ENV ФАЙЛ ДЛЯ ВАЖНЫХ ВЕЩЕЙ(ПАРОЛИ И Т.Д.)
	//TODO: ПОМЕНЯТЬ В ЛЕНДИНГ ПЕЙДЖ НАЗВАНИЕ
	//TODO: как то подключиться к серверному докеру на своём пк.(portainer?) 
	//TODO: как то подключиться к серверному постгре			(SSH в pgadmin4?)  

	public static void main(String[] args) {
		SpringApplication.run(ManagmentAppWebApplication.class, args);
	}

}
