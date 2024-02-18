package br.com.jessica.screenmatch;

import br.com.jessica.screenmatch.model.DadosSerie;
import br.com.jessica.screenmatch.service.ConsumoAPI;
import br.com.jessica.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args)
	{
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI =  new ConsumoAPI();
		String endereco = "https://omdbapi.com/?t=gilmore+girls&apikey=1514f43c";
		var json = consumoAPI.obterDados(endereco);
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
