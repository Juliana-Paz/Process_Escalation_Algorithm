package model;

public class Processo {

	private String pid;
	private Double arrivelTime;
	private Integer burstTime;

	public Processo() {
	}

	public Processo(String pid, Double arrivelTime, Integer burstTime) {
		super();
		this.pid = pid;
		this.arrivelTime = arrivelTime;
		this.burstTime = burstTime;
	}

	@Override
	public String toString() {
		return "Nome: " + pid + "  AT: " + arrivelTime + "  BT: " + burstTime;
	}
	
	/**
	 * Retorna o ID do processo 
	 */
	public static String returnsPidTime(int idProcesso) {		
		return "P" + idProcesso;
	}

	/**
	 * Retorna o tempo de chegada com 6 casas decimais
	 * Caso seja o primeiro processo, o retorno é 0
	 */
	public static Double returnsArrivalTime(int fistProcesso) {
		if (fistProcesso == 0) {			
			return 0.0;
		}		
		Double random = Math.random();
		random = Math.round(random*1000000.0)/1000000.0;
		return random;
	}

	/**
	 * Retorna o tempo estimado de execução de cada processo
	 */
	public static int returnsBurstTime() {
		int min = 1, max = 35;
		int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return random;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Double getArrivalTime() {
		return arrivelTime;
	}

	public void setArrivalTime(Double arrivelTime) {
		this.arrivelTime = arrivelTime;
	}

	public Integer getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(Integer burstTime) {
		this.burstTime = burstTime;
	}

}
