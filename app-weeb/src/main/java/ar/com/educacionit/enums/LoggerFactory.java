package ar.com.educacionit.enums;

public final class LoggerFactory {
// ES UNA CLASE FINAL PORQUE NADIE VA A HEREDAR DE LA CLASE 
	
	public static ILogger getLoggerFromEnum(LoggersEnum loggerEnum) throws RuntimeException {

//		EVITAR QUE SALGA POR DEFECTO CONSOLE CUANDO SEA 
		if (loggerEnum == null) {
			throw new RuntimeException("Debe de indicar un LoggerEnum válido");
		}

		if (loggerEnum == LoggersEnum.FS) {
			return new FsLoger();
		} else {
			return new ConsoleLogger();
		}

	}
}
