package dionis.utils;

/**
 * Константы для работы с данными "Дионис"
 * 
 * @author Ярных А.О.
 * 
 */
public interface Constants {

	/** Скорости порта **/
	String[] PORT_SPEED = { "50", "75", "110", "134.5", "150", "300", "600",
			"1200", "1800", "2000", "2400", "3600", "4800", "7200", "9600",
			"19200", "14400", "38400", "57600", "115200" };
	/** Управление порта **/
	String[] PORT_CONTROL = { "XON/XOFF", "RTS/CTS" };
	/** Тип направления передачи порта **/
	String[] PORT_TYPE = { "входной", "выходной", "динамический" };
	/** Количество бит **/
	String[] BIT_COUNT = { "7", "8" };
	/** Проверка фрейма - чётность, нечётность **/
	String[] PORT_FRAME_CHECK = { "NONE", "ODD", "EVEN", "MARK", "SPACE" };
	/** Стоп-бит **/
	String[] PORT_FRAME_STOP = { "1", "1.5", "2" };

	/** Базовые константы - Кластер - Режим работы **/
	String[] CLUSTER_MODE = { "Нет", "Master", "Slave" };

	/** Параметры удалённого управления **/
	String[] REMOTE_MODE = { "просмотр", "управление", "захват" };

	/** Уведомление администратора **/
	String[] NOTIFY_ADMIN = { "нет", "через 3", "через 9", "через 21" };
	/** Блокирование клиента **/
	String[] FREEZE_CLIENT = { "нет", "через 3", "через 9", "через 21" };

	/** Служба времени **/

	String[][] TIME_ZONES = { { "-12:00", "Эневеток, Кваджалейн", },
			{ "-11:00", "о.Мидуэй, Самоа", }, { "-10:00", "Гавайи", },
			{ "-09:00", "Аляска", },
			{ "-08:00", "Тихоокеанское время (США и Канада)", },
			{ "-07:00", "Горное время (США и Канада), Аризона", },
			{ "-06:00", "Мехико, Тегусигальпа", }, { "-06:00", "Саскачеван", },
			{ "-06:00", "Центральное время (США и Канада)", },
			{ "-05:00", "Богота, Лима, Киото", },
			{ "-05:00", "Восточное время (США и Канада)", },
			{ "-05:00", "Индиана (восток)", },
			{ "-04:00", "Атлантическое время (Канада)", },
			{ "-04:00", "Каракас, Ла Пас", }, { "-04:00", "Сантьяго", },
			{ "-03:30", "Ньюфаундленд", }, { "-03:00", "Бразилия", },
			{ "-03:00", "Буэнос-Айрес, Джорджтаун", },
			{ "-02:00", "Среднеатлантическое время", },
			{ "-01:00", "Азорские о-ва, о.Кабо-Верде", },
			{ "+00:00", "Время по Гринвичу: Дублин, Лондон", },
			{ "+00:00", "Лиссабон, Эдинбург, Касабланка", },
			{ "+01:00", "Прага, Вильнюс, София", },
			{ "+02:00", "Калининград", },
			{ "+03:00", "Москва, Санкт-Петербург, Волгоград", },
			{ "+04:00", "Самара, Ижевск", }, { "+04:30", "Кабул", },
			{ "+05:00", "Екатеринбург, Салехард, Оренбург, Уфа", },
			{ "+05:30", "Бомбей, Калькутта, Мадрас, Нью-Дели", },
			{ "+06:00", "Омск, Томск, Новосибирск, Алтай", },
			{ "+07:00", "Дудинка, Тура, Красноярск, Хакасия", },
			{ "+08:00", "Иркутск, Усть-Ордынский, Улан-Удэ", },
			{ "+09:00", "Якутск, Чита, Агинское, Благовещенск", },
			{ "+09:30", "Аделаида, Дарвин", },
			{ "+10:00", "Владивосток, Сахалин, Биробиджан", },
			{ "+10:00", "Канберра, Мельбурн, Сидней", },
			{ "+11:00", "Магадан", },
			{ "+12:00", "Камчатка, Фиджи, Маршалловы о-ва" } };

	// String[] TUNNEL_FILTER_STATUS = { "Разрешить", "Запретить", "Перезапуск"
	// };
	/** Флаг DF **/
	String[] DF_FLAG = { "Копировать", "Установить", "Сбросить" };

	String[] FLT_SYS_NAMES = { "main_in", "main_out", "trace", "prt_0",
			"prt_1", "prt_2", "prt_3", "prt_4", "prt_5", "prt_6", "prt_7",
			"dnslocal", "dnszone", "dns_int" };

	String[] FLT_SYS_DESCRIPTIONS = { "входной фильтр служб узла",
			"выходной фильтр служб узла", "ограничитель трассировки",
			"установщик приоритета 0", "установщик приоритета 1",
			"установщик приоритета 2", "установщик приоритета 3",
			"установщик приоритета 4", "установщик приоритета 5",
			"установщик приоритета 6", "установщик приоритета 7",
			"описатель внутренних DNS-запросов",
			"ограничитель пересылки DNS-зон",
			"ограничитель внутренних DNS-запросов" };

	/** Режим фильтра **/
	String[] FILTER_MODE = { "Разрешить", "Запретить", "Сбросить", "Сессия" };
	/** Направление фильтрации **/
	String[] FILTER_DIRECTION = { "Все", "Отправителя", "Получателя" };
	/** Логические операции **/
	String[] FILTER_LOGIC = { "Нет", "==", "!=", ">", ">=", "<", "<=" };
	/** Тип интерфейса по виду подключения **/
	String[] CONNECTION_TYPE = { "Оптика", "Витая пара" };
	/** Тип интерфейса по режиму передачи данных **/

	String[] CONNECTION_MODE = { "Автоопределение", "100Full", "100Half",
			"10Full", "10Half" };
	/** Тип режима активизации интерфейса **/
	String[] INTERFACE_MODE_TYPE = { "Статический", "Входящий", "Исходящий",
			"Двусторонний" };
	/** Тип NAT интерфейса **/
	String[] INTERFACE_NAT_TYPE = { " ", "Внутренний", "Внешний" };
	/** Стандартный фильтр **/
	int DLG_STANDARD = 0;
	/** Расширенный фильтр **/
	int DLG_EXTENDED = 1;
}
