package com.dailystatusapi.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "dailystatus-api")
@ConfigurationProperties("dailystatus-api")
public class DailystatusApiProperty {
	
	private String originPermitida = "http://localhost:4200";

	private final Seguranca seguranca = new Seguranca();
	
	public static class Seguranca {
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
		
	}
	
	public Seguranca getSeguranca() {
		return seguranca;
	}

	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

}
