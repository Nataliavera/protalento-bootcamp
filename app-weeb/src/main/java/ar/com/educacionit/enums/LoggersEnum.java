package ar.com.educacionit.enums;

public enum LoggersEnum {

	FS("FS"),
	CONSOLE("Console");
	
	private String desc;
//	private Integer valor;
	private LoggersEnum(String desc) {
//		this.valor = valor;
		this.desc = desc; 
	}
	
	public String getValor() {
		return this.desc;
	}
	
	public static LoggersEnum getEnumFromStr(String strEnum) {
		LoggersEnum aux = null;
		if(strEnum != null) {
			LoggersEnum[] enums = LoggersEnum.values();
			for(LoggersEnum _enum : enums) {
				if(strEnum.equalsIgnoreCase(_enum.getValor())) {
					aux = _enum;
					break; 
				}
			}
		}
		return aux; 
	}
}
